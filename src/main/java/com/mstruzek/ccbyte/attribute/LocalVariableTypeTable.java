package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.attribute.info.local_variable_type_info;

@Discriminator(attributeName = "LocalVariableTypeTable")
public class LocalVariableTypeTable extends attribute_info {
  public short local_variable_type_table_length;
  @ArrayLength(fieldName = "local_variable_type_table_length")
  public local_variable_type_info[] local_variable_type_table;
}

