package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 16)
public class CONSTANT_MethodType extends CONSTANT_Tag {
  public short descriptor_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(descriptor_index);
  }
}
