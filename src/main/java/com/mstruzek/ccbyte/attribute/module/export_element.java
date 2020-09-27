package com.mstruzek.ccbyte.attribute.module;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class export_element {
  public short exports_index;
  public short exports_flags;
  public short exports_to_count;
  @ArrayLength(fieldName = "exports_to_count")
  public short[] exports_to_index;
}
