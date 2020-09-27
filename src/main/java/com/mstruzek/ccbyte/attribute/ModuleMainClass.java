package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "ModuleMainClass")
public class ModuleMainClass extends attribute_info {
  public short main_class_index;
}
