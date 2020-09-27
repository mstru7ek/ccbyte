package com.mstruzek.ccbyte.cpool;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(byteValue = 1)
public class CONSTANT_Utf8 extends CONSTANT_Tag {
  public short len;
  @ArrayLength(fieldName = "len")
  public byte[] bytes;

  @Override
  public String resolveAsString(ConstPool constPool) {
    return new String(bytes);
  }
}
