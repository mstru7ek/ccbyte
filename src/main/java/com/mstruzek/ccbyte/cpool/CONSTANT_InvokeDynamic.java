package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 18)
public class CONSTANT_InvokeDynamic extends CONSTANT_Tag {
  public short bootstrap_method_attr_index;
  public short name_and_type_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return constPool.resolve(bootstrap_method_attr_index) + "#" + constPool.resolve(name_and_type_index);
  }
}
