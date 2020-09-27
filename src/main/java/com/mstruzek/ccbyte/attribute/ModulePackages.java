package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "ModulePackages")
public class ModulePackages extends attribute_info {
  public short package_count;
  @ArrayLength(fieldName = "package_count")
  public short[] package_index;
}
