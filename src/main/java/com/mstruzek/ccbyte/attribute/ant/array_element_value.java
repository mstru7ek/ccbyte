package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(charArray = {'['})
public class array_element_value extends element_value {
  public array_value value;
}
