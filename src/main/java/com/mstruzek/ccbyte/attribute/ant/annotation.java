package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class annotation {
  public short type_index;
  public short num_element_value_pairs;
  @ArrayLength(fieldName = "num_element_value_pairs")
  public element_value_pair[] element_value_pairs;
}
