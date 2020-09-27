package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 7)
public class CONSTANT_Class extends CONSTANT_Tag {
  public short name_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(name_index);
  }
}
