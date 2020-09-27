package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 3)
public class CONSTANT_Integer extends CONSTANT_Tag {
  public int bytes;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return Integer.toString(bytes);
  }
}
