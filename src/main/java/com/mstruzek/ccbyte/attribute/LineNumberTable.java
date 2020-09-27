package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.attribute.info.line_info;

@Discriminator(attributeName = "LineNumberTable")
public class LineNumberTable extends attribute_info {
  public short line_number_table_length;
  @ArrayLength(fieldName = "line_number_table_length")
  public line_info[] line_number_table;
}
