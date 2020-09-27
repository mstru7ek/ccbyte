package com.mstruzek.ccbyte.attribute.module;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class provide_element {
  public short provides_index;
  public short provides_with_count;
  @ArrayLength(fieldName = "provides_with_count")
  public short[] provides_with_index;
}
