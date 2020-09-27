package com.mstruzek.ccbyte.matcher;

import com.mstruzek.ccbyte.core.ValueMatcher;

public class CharSequenceValueMatcher implements ValueMatcher {

  private final char[] allowed;

  public CharSequenceValueMatcher(char[] allowed) {
    this.allowed = allowed;
  }

  @Override
  public boolean contains(Object value) {
    for (char c : allowed) {
      if (c == (char) value) return true;
    }
    return false;
  }
}
