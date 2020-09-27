package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 8)
public class CONSTANT_String extends CONSTANT_Tag {
  public short string_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(string_index);
  }
}
