package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "SourceFile")
public class SourceFile extends attribute_info {
  public short sourcefile_index;
}
