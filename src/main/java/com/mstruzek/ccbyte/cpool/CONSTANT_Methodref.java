package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 10)
public class CONSTANT_Methodref extends CONSTANT_Tag {
  public short class_index;
  public short name_and_type_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(class_index) + "." + constPool.resolve(name_and_type_index);
  }
}
