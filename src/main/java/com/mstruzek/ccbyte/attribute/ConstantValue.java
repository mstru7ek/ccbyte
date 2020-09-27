package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "ConstantValue")
public class ConstantValue extends attribute_info {
  public short constantvalue_index;
}
