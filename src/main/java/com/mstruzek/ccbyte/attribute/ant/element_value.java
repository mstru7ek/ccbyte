package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.Discriminated;
import com.mstruzek.ccbyte.annotation.DiscriminationType;

public class element_value {
  @Discriminated(type = DiscriminationType.CHAR_TABLE)
  public byte tag;
}
