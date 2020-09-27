package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "MethodParameters")
public class MethodParameters extends attribute_info {
  public byte parameters_count;
  @ArrayLength(fieldName = "parameters_count")
  public parameter_info[] parameters;

}
