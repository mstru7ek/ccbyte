package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.attribute.info.line_number_info;

@Discriminator(attributeName = "LocalVariableTable")
public class LocalVariableTable extends attribute_info {
  public short local_variable_table_length;
  @ArrayLength(fieldName = "local_variable_table_length")
  public line_number_info[] local_variable_table;
}


