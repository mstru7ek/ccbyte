package com.mstruzek.ccbyte.attribute.module;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class open_element {
  public short opens_index;
  public short opens_flags;
  public short opens_to_count;
  @ArrayLength(fieldName = "opens_to_count")
  public short[] opens_to_index;
}
