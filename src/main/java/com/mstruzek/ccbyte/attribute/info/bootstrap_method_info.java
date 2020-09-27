package com.mstruzek.ccbyte.attribute.info;

import com.mstruzek.ccbyte.annotation.ArrayLength;

public class bootstrap_method_info {
  public short bootstrap_method_ref;
  public short num_bootstrap_arguments;
  @ArrayLength(fieldName = "num_bootstrap_arguments")
  public short[] bootstrap_arguments;
}
