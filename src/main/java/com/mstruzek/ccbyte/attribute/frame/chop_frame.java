package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = (byte)248, to = (byte)250))
public class chop_frame extends stack_map_frame {
  public short offset_delta;
}
