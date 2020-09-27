package com.mstruzek.ccbyte.attribute.typeant.target;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class localvar_target extends target_info {
  public short table_length;
  @ArrayLength(fieldName = "table_length")
  public table_entry[] table;
}
