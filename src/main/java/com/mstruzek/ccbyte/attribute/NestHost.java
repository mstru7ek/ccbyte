package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "NestHost")
public class NestHost extends attribute_info {
  public short host_class_index;
}
