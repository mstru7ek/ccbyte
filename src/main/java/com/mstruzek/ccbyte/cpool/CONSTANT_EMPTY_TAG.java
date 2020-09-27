package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 0)
public class CONSTANT_EMPTY_TAG extends CONSTANT_Tag {

  @Override
  public String resolveAsString(ConstPool constPool) {
    return "null";
  }
}
