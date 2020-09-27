package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.ant.annotation;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "RuntimeVisibleAnnotations")
public class RuntimeVisibleAnnotations extends attribute_info {
  public short num_annotations;
  @ArrayLength(fieldName = "num_annotations")
  public annotation[] annotations;
}
