package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.Discriminated;

import static com.mstruzek.ccbyte.annotation.DiscriminationType.*;

public class CONSTANT_Tag implements ConstPoolResolver {
  @Discriminated(type = BYTE_VALUE)
  public byte tag_id;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return null;
  }
}
