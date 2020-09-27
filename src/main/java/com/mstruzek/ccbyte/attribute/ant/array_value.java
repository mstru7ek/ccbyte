package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class array_value {
  public short num_values;
  @ArrayLength(fieldName = "num_values")
  public element_value[] values;
}
