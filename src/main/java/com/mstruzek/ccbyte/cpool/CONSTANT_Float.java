package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 4)
public class CONSTANT_Float extends CONSTANT_Tag {
  public float bytes;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return Float.toString(bytes);
  }
}
