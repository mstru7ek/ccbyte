package com.mstruzek.ccbyte.attribute.typeant;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class type_path {
  public byte path_length;
  @ArrayLength(fieldName = "path_length")
  public path_element[] path;
}
