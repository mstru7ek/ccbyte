package com.mstruzek.ccbyte.matcher;

import com.mstruzek.ccbyte.core.ValueMatcher;

public class ByteEqualValueMatcher implements ValueMatcher {

  private final byte tag;

  public ByteEqualValueMatcher(byte tag) {
    this.tag = tag;
  }

  @Override
  public boolean contains(Object value) {
    return tag == (byte) value;
  }
}
