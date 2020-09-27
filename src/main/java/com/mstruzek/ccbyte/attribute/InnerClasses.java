package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.attribute.info.inner_class_info;

@Discriminator(attributeName = "InnerClasses")
public class InnerClasses extends attribute_info {
  public short number_of_classes;
  @ArrayLength(fieldName = "number_of_classes")
  public inner_class_info[] classes;

}
