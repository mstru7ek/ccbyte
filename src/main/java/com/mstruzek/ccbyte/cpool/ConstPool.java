package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.core.Descriptor;
import com.mstruzek.ccbyte.core.ValueMatcher;
import com.mstruzek.ccbyte.matcher.ByteEqualValueMatcher;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

public class ConstPool {

  private final short constant_pool_count;
  private final CONSTANT_Tag[] constant_pool;

  private final List<Descriptor<ValueMatcher, Class<?>>> tagRegister = new ArrayList<>();
  private final ByteBuffer byteCode;

  public ConstPool(ByteBuffer byteCode) {
    this.byteCode = byteCode;
    constant_pool_count = byteCode.getShort();
    constant_pool = new CONSTANT_Tag[constant_pool_count + 1];
    constant_pool[0] = new CONSTANT_EMPTY_TAG();
    init();
  }

  private void register(Class<? extends CONSTANT_Tag> tagClass) {
    Discriminator discriminator = tagClass.getAnnotation(Discriminator.class);
    ByteEqualValueMatcher descriptor = new ByteEqualValueMatcher(discriminator.byteValue());
    tagRegister.add(new Descriptor<>(descriptor, tagClass));
  }

  private void init() {
    register(CONSTANT_EMPTY_TAG.class);
    register(CONSTANT_Utf8.class);
    register(CONSTANT_Integer.class);
    register(CONSTANT_Float.class);
    register(CONSTANT_Long.class);
    register(CONSTANT_Double.class);
    register(CONSTANT_Class.class);
    register(CONSTANT_String.class);
    register(CONSTANT_Fieldref.class);
    register(CONSTANT_Methodref.class);
    register(CONSTANT_InterfaceMethodref.class);
    register(CONSTANT_NameAndType.class);
    register(CONSTANT_MethodHandle.class);
    register(CONSTANT_MethodType.class);
    register(CONSTANT_Dynamic.class);
    register(CONSTANT_InvokeDynamic.class);
    register(CONSTANT_Module.class);
    register(CONSTANT_Package.class);
  }

  public void read() {
    for (int i = 1; i < constant_pool_count; i++) {
      byteCode.mark();
      var constTagClass = findClass(byteCode.get());
      byteCode.reset();
      constant_pool[i] = read_CONSTANT_Tag_Class(constTagClass, byteCode);
      if (constant_pool[i].getClass().equals(CONSTANT_Double.class) ||
          constant_pool[i].getClass().equals(CONSTANT_Long.class)) {
        i = i + 1;
      }
    }
  }

  private Class<?> findClass(Byte tag) {
    for (Descriptor<ValueMatcher, Class<?>> descriptor : tagRegister) {
      if (descriptor.matcher.contains(tag)) {
        return descriptor.aClass;
      }
    }
    throw new RuntimeException("invalid constant pool tag_id");
  }

  private CONSTANT_Tag read_CONSTANT_Tag_Class(Class<?> constTagClass, ByteBuffer byteCode) {
    try {
      var constructor = constTagClass.getDeclaredConstructor();
      var object = constructor.newInstance();
      var baseDeclaredFields = constTagClass.getSuperclass().getDeclaredFields();
      var classDeclaredFields = constTagClass.getDeclaredFields();
      var declaredFields = Arrays.copyOf(baseDeclaredFields, baseDeclaredFields.length + classDeclaredFields.length);
      System.arraycopy(classDeclaredFields, 0, declaredFields, baseDeclaredFields.length, classDeclaredFields.length);
      for (Field declaredField : declaredFields) {
        if (declaredField.getType().equals(byte.class)) declaredField.set(object, byteCode.get());
        else if (declaredField.getType().equals(short.class)) declaredField.set(object, byteCode.getShort());
        else if (declaredField.getType().equals(int.class)) declaredField.set(object, byteCode.getInt());
        else if (declaredField.getType().equals(long.class)) declaredField.set(object, byteCode.getLong());
        else if (declaredField.getType().equals(float.class)) declaredField.set(object, byteCode.getFloat());
        else if (declaredField.getType().equals(double.class)) declaredField.set(object, byteCode.getDouble());
        else if (declaredField.getType().isArray() && declaredField.getType().getComponentType().equals(byte.class)) {
          var referenceFieldSize = declaredField.getAnnotation(ArrayLength.class).fieldName();
          var length = constTagClass.getDeclaredField(referenceFieldSize).get(object);
          var arrayLength = integerValue(length);
          var array = new byte[arrayLength];
          byteCode.get(array, 0, arrayLength);
          declaredField.set(object, array);
        } else {
          throw new RuntimeException("not recognized field type");
        }
      }
      return (CONSTANT_Tag) object;

    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
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

  public String resolve(short index) {
    Objects.requireNonNull(constant_pool[index], "invalid const pool index" + index);
    return constant_pool[index].resolveAsString(this);
  }

  public void print() {
    for (short i = 0; i < constant_pool.length - 1; i++) {
      if (constant_pool[i] != null)
        out.printf("%d  |  %s%n", i, constant_pool[i].resolveAsString(this));
    }
  }

  public CONSTANT_Tag[] getTags() {
    return constant_pool;
  }
}
