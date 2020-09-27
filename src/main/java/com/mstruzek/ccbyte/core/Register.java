package com.mstruzek.ccbyte.core;

import com.mstruzek.ccbyte.matcher.*;
import com.mstruzek.ccbyte.annotation.Discriminated;
import com.mstruzek.ccbyte.annotation.DiscriminationType;
import com.mstruzek.ccbyte.annotation.Discriminator;

import java.util.*;

public class Register<T> {

  private final Class<T> baseClass;
  private final List<Descriptor<ValueMatcher, Class<?>>> register = new ArrayList<>();

  private final DiscriminationType discriminationType;

  public Register(Class<T> baseClass) {
    this.baseClass = baseClass;
    this.discriminationType = findDiscriminationType(baseClass);
  }

  public void register(Class<?> subClass) {
    Discriminator annotation = subClass.getAnnotation(Discriminator.class);
    switch (discriminationType) {
      case BYTE_VALUE ->
          register.add(new Descriptor<>(new ByteEqualValueMatcher(annotation.byteValue()), subClass));
      case RANGE_VALUE ->
          register.add(new Descriptor<>(new RangeByteValueMatcher(annotation.range().from(), annotation.range().to()), subClass));
      case CONST_POOL_RESOLVED ->
          register.add(new Descriptor<>(new EqualValueMatcher(annotation.attributeName()), subClass));
      case CHAR_TABLE ->
          register.add(new Descriptor<>(new CharSequenceValueMatcher(annotation.charArray()), subClass));
    };
  }

  public Class<?> findSubclass(Object discriminator)  {
    for (Descriptor<ValueMatcher, Class<?>> descriptor : register) {
      if (descriptor.matcher.contains(discriminator)) {
        return descriptor.aClass;
      }
    }
    throw new IllegalStateException("no matching class in hierarchy");
  }

  private DiscriminationType findDiscriminationType(Class<?> baseClass) {
    Optional<Discriminated> discriminated = Arrays.stream(baseClass.getDeclaredFields())
        .map(field -> field.getAnnotation(Discriminated.class))
        .filter(Objects::nonNull)
        .findFirst();
    Optional<DiscriminationType> discriminationType = discriminated.map(Discriminated::type);
    return discriminationType.orElseThrow(() -> new RuntimeException("class without any Discriminated.class field"));
  }

  public DiscriminationType getDiscriminationType() {
    return discriminationType;
  }
}
