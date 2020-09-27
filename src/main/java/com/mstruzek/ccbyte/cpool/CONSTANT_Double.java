package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 6)
public class CONSTANT_Double extends CONSTANT_Tag {
  public double bytes;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return Double.toString(bytes);
  }
}
