package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "NestMembers")
public class NestMembers extends attribute_info {
  public short number_of_classes;
  @ArrayLength(fieldName = "number_of_classes")
  public short[] classes;
}
