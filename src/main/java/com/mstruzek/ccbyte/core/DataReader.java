package com.mstruzek.ccbyte.core;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.DiscriminationType;
import com.mstruzek.ccbyte.annotation.Padding;
import com.mstruzek.ccbyte.annotation.SequencedPositioned;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class DataReader {

  private final HierarchyRegister hierarchyRegister;

  public DataReader(HierarchyRegister hierarchyRegister) {
    this.hierarchyRegister = hierarchyRegister;
  }

  /**
   * Inicjalizuje kolejne elementy sekwencji.
   * @param baseClass
   * @param array
   * @param byteCode
   */
  public void readSequence(Class<?> baseClass, Object[] array, ByteBuffer byteCode) {
    int j = 0;
    while (j < array.length) {
      array[j++] = createAndReadObject(baseClass, byteCode);
    }
  }

  public void readSequencePositioned(Class<?> baseClass, Object[] array, ByteBuffer byteCode) {
    while (byteCode.hasRemaining()) {
      array[byteCode.position()] = createAndReadObject(baseClass, byteCode);
    }
  }

  /**
   * Stworz nowa instacje obiektu i wczytaj calkowicie.
   *
   * @param baseClass
   * @param byteCode
   * @return
   */
  private Object createAndReadObject(Class<?> baseClass, ByteBuffer byteCode) {
    if (!byteCode.hasRemaining())
      throw new IllegalStateException("byteCode has no remaining bits");
    try {
      Class<?> initClass = getInitClassOrDiscriminated(baseClass, byteCode);
      Object object = initClass.getConstructor().newInstance();
      readObject(initClass, object, byteCode);
      return object;
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Get baseClass or sub-class if discriminated.
   * @param baseClass
   * @param byteCode
   * @return class
   */
  private Class<?> getInitClassOrDiscriminated(Class<?> baseClass, ByteBuffer byteCode) {
    if (hierarchyRegister.isBaseClass(baseClass) && byteCode.hasRemaining()) {
      byteCode.mark();
      Object tag;
      if (hierarchyRegister.discriminationType(baseClass) == DiscriminationType.CONST_POOL_RESOLVED) {
        tag = byteCode.getShort();
      } else {
        tag = byteCode.get();
      }
      byteCode.reset();
      return hierarchyRegister.findSubClass(baseClass, tag);
    } else {
      return baseClass;
    }
  }

  private void readObject(Class<?> aClass, Object object, ByteBuffer byteCode) {
    Field[] baseClassFields = aClass.getSuperclass().getDeclaredFields();
    Field[] attributeClassFields = aClass.getDeclaredFields();
    Field[] attributeFields = Arrays.copyOf(baseClassFields, baseClassFields.length + attributeClassFields.length);
    System.arraycopy(attributeClassFields, 0, attributeFields, baseClassFields.length, attributeClassFields.length);
    try {
      for (Field field : attributeFields) {
        if (field.getType().equals(byte.class)) field.set(object, byteCode.get());
        else if (field.getType().equals(short.class)) field.set(object, byteCode.getShort());
        else if (field.getType().equals(int.class)) field.set(object, byteCode.getInt());
        else if (field.getType().equals(float.class)) field.set(object, byteCode.getFloat());
        else if (field.getType().equals(long.class)) field.set(object, byteCode.getLong());
        else if (field.getType().equals(double.class)) field.set(object, byteCode.getDouble());
        else if (!field.getType().isArray() || hierarchyRegister.isBaseClass(field.getType())) {
          field.set(object, createAndReadObject(field.getType(), byteCode));
        } else  if (field.getAnnotation(SequencedPositioned.class)!= null){
          var byteBuffer = bufferFromField(object, field.getAnnotation(SequencedPositioned.class).sourceFrom());
          initArray(aClass, object, field, byteBuffer);
          readFully(field, field.get(object), byteBuffer);
        } else {
          initArray(aClass, object, field, byteCode);
          readFully(field, field.get(object), byteCode);
        }
      }
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  private void initArray(Class<?> aClass, Object object, Field field, ByteBuffer byteCode) throws IllegalAccessException, NoSuchFieldException {
    if (field.getType().componentType().equals(byte.class) && field.getAnnotation(Padding.class) != null) {
      byte alignment = field.getAnnotation(Padding.class).alignment();
      int rem = byteCode.position() % alignment;
      int length = rem != 0 ? alignment - rem : 0;
      byte[] array = new byte[length];
      field.set(object, array);
    } else if (field.getType().componentType().equals(byte.class) && field.getAnnotation(ArrayLength.class) != null) {
      int arrayLength = getArrayLength(aClass, object, field);
      byte[] array = new byte[arrayLength];
      field.set(object, array);
    } else if (field.getType().componentType().equals(short.class) && field.getAnnotation(ArrayLength.class) != null) {
      int arrayLength = getArrayLength(aClass, object, field);
      short[] array = new short[arrayLength];
      field.set(object, array);
    } else if (field.getType().componentType().equals(int.class) && field.getAnnotation(ArrayLength.class) != null) {
      int arrayLength = getArrayLength(aClass, object, field);
      int[] array = new int[arrayLength];
      field.set(object, array);
    } else if (field.getAnnotation(ArrayLength.class) != null) {
      int arrayLength = getArrayLength(aClass, object, field);
      Object[] array = (Object[]) Array.newInstance(field.getType().getComponentType(), arrayLength);
      field.set(object, array);
    }
  }

  private int getArrayLength(Class<?> aClass, Object aobject, Field field) throws IllegalAccessException, NoSuchFieldException {
    ArrayLength annotation = field.getAnnotation(ArrayLength.class);
    String fieldName = annotation.fieldName();
    int length = integerValue(getAnyDeclaredField(aClass, fieldName).get(aobject));
    String subField = annotation.subField();
    int subLength = subField.isEmpty() ? 0 : integerValue(getAnyDeclaredField(aClass, subField).get(aobject));
    int subtract = annotation.subtruct();
    return length - subLength - subtract;
  }

  private Field getAnyDeclaredField(Class<?> aClass, String fieldName) throws NoSuchFieldException {
    try {
      return aClass.getDeclaredField(fieldName);
    } catch (NoSuchFieldException e) {
      return aClass.getSuperclass().getDeclaredField(fieldName);
    }
  }


  private static int integerValue(Object obj) {
    if (obj instanceof Byte) {
      return ((Byte) obj).intValue();
    } else if (obj instanceof Short) {
      return ((Short) obj).intValue();
    } else if (obj instanceof Integer) {
      return (Integer) obj;
    } else {
      throw new RuntimeException("is not convertible to integer");
    }
  }

  /**
   * Read initialized object, array or simple object.
   * @param field
   * @param object
   * @param byteCode
   */
  public void readFully(Field field, Object object, ByteBuffer byteCode) {
    if (object.getClass().isArray() && object.getClass().getComponentType().equals(byte.class)) {
      readByteSequence((byte[]) object, byteCode);
    } else if (object.getClass().isArray() && object.getClass().getComponentType().equals(short.class)) {
      readShortSequence((short[]) object, byteCode);
    } else if (object.getClass().isArray() && object.getClass().getComponentType().equals(int.class)) {
      readIntSequence((int[]) object, byteCode);
    } else if (object.getClass().isArray() && field.getAnnotation(SequencedPositioned.class)  != null) {
      readSequencePositioned(object.getClass().getComponentType(), (Object[]) object, byteCode);
    } else if (object.getClass().isArray()) {
      readSequence(object.getClass().getComponentType(), (Object[]) object, byteCode);
    } else {
      readObject(object.getClass(), object, byteCode);
    }
  }

  private void readShortSequence(short[] object, ByteBuffer byteCode) {
    int j = 0;
    while (j < object.length) {
      object[j++] = byteCode.getShort();
    }
  }

  private void readIntSequence(int[] object, ByteBuffer byteCode) {
    int j = 0;
    while (j < object.length) {
      object[j++] = byteCode.getInt();
    }
  }

  private void readByteSequence(byte[] object, ByteBuffer byteCode) {
    byteCode.get(object, 0, object.length);
  }

  private ByteBuffer bufferFromField(Object object, String sourceFrom ) {
    try {
      return ByteBuffer.wrap((byte[]) object.getClass().getDeclaredField(sourceFrom).get(object));
    } catch (IllegalAccessException | NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }
}
