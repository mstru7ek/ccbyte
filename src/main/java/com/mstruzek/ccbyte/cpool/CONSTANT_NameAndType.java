package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 12)
public class CONSTANT_NameAndType extends CONSTANT_Tag {
  public short name_index;
  public short descriptor_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(name_index) + ":" + constPool.resolve(descriptor_index);
  }
}
