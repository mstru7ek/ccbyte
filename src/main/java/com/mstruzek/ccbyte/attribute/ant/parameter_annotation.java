package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class parameter_annotation {
  public short num_annotations;
  @ArrayLength(fieldName = "num_annotations")
  public annotation[] annotations;
}
