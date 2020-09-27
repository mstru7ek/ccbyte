package com.mstruzek.ccbyte.core;

public final class Descriptor<T, V> {
  public final T matcher;
  public final V aClass;

  public Descriptor(T matcher, V aClass) {
    this.matcher = matcher;
    this.aClass = aClass;
  }
}
