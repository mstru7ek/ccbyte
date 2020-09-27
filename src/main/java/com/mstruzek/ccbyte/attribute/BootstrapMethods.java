package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.info.bootstrap_method_info;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "BootstrapMethods")
public class BootstrapMethods extends attribute_info {
  public short num_bootstrap_methods;
  @ArrayLength(fieldName = "num_bootstrap_methods")
  public bootstrap_method_info[] bootstrap_methods;
}
