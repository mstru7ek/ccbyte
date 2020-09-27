package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 15)
public class CONSTANT_MethodHandle extends CONSTANT_Tag {
  public byte reference_kind;
  public short reference_index;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return String.format("%s %s", Consts.RefKinds.get(reference_kind), constPool.resolve(reference_index));
  }
}
