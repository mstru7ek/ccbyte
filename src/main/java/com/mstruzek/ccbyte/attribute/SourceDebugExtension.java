package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "SourceDebugExtension")
public class SourceDebugExtension extends attribute_info {
  @ArrayLength(fieldName = "attribute_length")
  public byte[] debug_extension;
}

