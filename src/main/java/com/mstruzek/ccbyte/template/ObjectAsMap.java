package com.mstruzek.ccbyte.template;

import java.lang.reflect.Field;
import java.util.*;

public class ObjectAsMap implements Map<String, Object> {

  private static final Map<Class, Field[]> classToFields = new HashMap<>();

  private final Object context;
  private final String className;

  private final Map<String, Object> baseContext;

  private ObjectAsMap(Object context) {
    this.context = context;
    this.className = context.getClass().getSimpleName();
    this.baseContext = registerBaseContext();
  }

  private Map<String, Object> registerBaseContext() {
    var base = new HashMap<String, Object>();
    base.put("$className", clearName(this.className));
    base.put("$superName", this.context.getClass().getSuperclass().getSimpleName());
    return base;
  }

  public static String clearName(String className) {
    if (className.endsWith("_"))
      return className.substring(0, className.length()-1);
    return className;
  }

  public static ObjectAsMap wrap(Object context) {
    return new ObjectAsMap(context);
  }

  @Override
  public int size() {
    return getClassFields(context.getClass()).length;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean containsKey(Object key) {
    return true;
  }

  @Override
  public boolean containsValue(Object value) {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public Object get(Object key) {
    String keyValue = (String) key;
    var baseObject = baseContext.get(keyValue);
    if (baseObject != null)
      return baseObject;
    try {
      Field declaredField = Arrays
          .stream(getClassFields(context.getClass()))
          .filter(field -> field.getName().equals(keyValue))
          .findFirst().get();
      declaredField.setAccessible(true);
      return declaredField.get(context);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Object put(String key, Object value) {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public Object remove(Object key) {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public void putAll(Map<? extends String, ?> m) {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public void clear() {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public Set<String> keySet() {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public Collection<Object> values() {
    throw new IllegalStateException("not implemented");
  }

  @Override
  public Set<Entry<String, Object>> entrySet() {
    var entries = new HashSet<Entry<String, Object>>();
    Field[] attributeFields = getClassFields(context.getClass());
    for (Field attributeField : attributeFields) {
      try {
        attributeField.setAccessible(true);
        entries.add(Map.entry(attributeField.getName(), attributeField.get(context)));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    entries.addAll(baseContext.entrySet());
    return entries;
  }
  public static Field[] getClassFields(Class klass) {
    if (classToFields.get(klass) == null) {
      Field[] baseClassFields = klass.getSuperclass().getDeclaredFields();
      Field[] attributeClassFields = klass.getDeclaredFields();
      Field[] attributeFields = Arrays.copyOf(baseClassFields, baseClassFields.length + attributeClassFields.length);
      System.arraycopy(attributeClassFields, 0, attributeFields, baseClassFields.length, attributeClassFields.length);
      classToFields.put(klass, attributeFields);
    }
    return classToFields.get(klass);
  }
}
