package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminated;

import static com.mstruzek.ccbyte.annotation.DiscriminationType.*;

public class stack_map_frame {
  @Discriminated(type = RANGE_VALUE)
  public byte frame_type;
}
