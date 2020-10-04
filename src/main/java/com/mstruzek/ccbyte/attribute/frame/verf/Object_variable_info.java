package com.mstruzek.ccbyte.attribute.frame.verf;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.frame.verification_type_info;

@Discriminator(byteValue = 7)
public class Object_variable_info extends verification_type_info {
  public short cpool_index;
}
