package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 5)
public class CONSTANT_Long extends CONSTANT_Tag {
  public long bytes;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return Long.toString(bytes);
  }
}
