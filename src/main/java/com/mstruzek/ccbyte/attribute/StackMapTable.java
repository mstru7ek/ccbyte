package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.frame.stack_map_frame;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "StackMapTable")
public class StackMapTable extends attribute_info {
  public short number_of_entries;
  @ArrayLength(fieldName = "number_of_entries")
  public stack_map_frame[] entries;
}
