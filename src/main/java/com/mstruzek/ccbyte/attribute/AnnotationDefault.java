package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.ant.element_value;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "AnnotationDefault")
public class AnnotationDefault extends attribute_info {
  public element_value default_value;
}


