package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminated;

import static com.mstruzek.ccbyte.annotation.DiscriminationType.BYTE_VALUE;

public class verification_type_info {
  @Discriminated(type = BYTE_VALUE)
  public byte tag;
}
