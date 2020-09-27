package com.mstruzek.ccbyte.matcher;

import com.mstruzek.ccbyte.core.ValueMatcher;

public class RangeByteValueMatcher implements ValueMatcher {

  private final byte from;
  private final byte to;

  public RangeByteValueMatcher(byte from, byte to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean contains(Object value) {
    return from <= (byte) value && (byte) value <= to;
  }
}
