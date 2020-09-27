package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "EnclosingMethod")
public class EnclosingMethod extends attribute_info {
  public short class_index;
  public short method_index;
}
