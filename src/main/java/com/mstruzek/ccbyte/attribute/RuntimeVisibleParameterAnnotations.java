package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.ant.parameter_annotation;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "RuntimeVisibleParameterAnnotations")
public class RuntimeVisibleParameterAnnotations extends attribute_info {
  public short num_parameters;
  @ArrayLength(fieldName = "num_parameters")
  public parameter_annotation[] parameter_annotations;
}
