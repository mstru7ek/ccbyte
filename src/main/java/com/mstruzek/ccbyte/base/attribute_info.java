package com.mstruzek.ccbyte.base;

import com.mstruzek.ccbyte.annotation.Discriminated;

import static com.mstruzek.ccbyte.annotation.DiscriminationType.CONST_POOL_RESOLVED;

public class attribute_info {
  @Discriminated(type = CONST_POOL_RESOLVED)
  public short attribute_name_index;
  public int attribute_length;
}

