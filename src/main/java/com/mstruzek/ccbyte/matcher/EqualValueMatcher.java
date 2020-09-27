package com.mstruzek.ccbyte.matcher;

import com.mstruzek.ccbyte.core.ValueMatcher;

public class EqualValueMatcher implements ValueMatcher {

  private final Object expected;

  public EqualValueMatcher(Object expected) {
    this.expected = expected;
  }

  @Override
  public boolean contains(Object value) {
    return expected.equals(value);
  }
}
