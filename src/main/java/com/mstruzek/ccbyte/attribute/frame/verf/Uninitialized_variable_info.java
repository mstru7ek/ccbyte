package com.mstruzek.ccbyte.attribute.frame.verf;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.frame.verification_type_info;

@Discriminator(byteValue = 8)
public class Uninitialized_variable_info extends verification_type_info {
  public short cpool_index;
}
