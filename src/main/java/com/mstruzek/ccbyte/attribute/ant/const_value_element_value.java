package com.mstruzek.ccbyte.attribute.ant;

import com.mstruzek.ccbyte.annotation.Discriminator;

@Discriminator(charArray = {'B', 'C', 'D', 'F', 'I', 'J', 'S', 'Z', 's'})
public class const_value_element_value extends element_value {
  public short value;
}
