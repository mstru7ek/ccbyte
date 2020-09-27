package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "Exceptions")
public class Exceptions extends attribute_info {
  public short number_of_exceptions;
  @ArrayLength(fieldName = "number_of_exceptions")
  public short[] exception_index_table;
}
