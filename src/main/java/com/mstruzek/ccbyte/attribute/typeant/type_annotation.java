package com.mstruzek.ccbyte.attribute.typeant;

import com.mstruzek.ccbyte.annotation.Discriminated;
import com.mstruzek.ccbyte.annotation.DiscriminationType;

public class type_annotation {
  @Discriminated(type = DiscriminationType.RANGE_VALUE)
  public byte target_type;
}



