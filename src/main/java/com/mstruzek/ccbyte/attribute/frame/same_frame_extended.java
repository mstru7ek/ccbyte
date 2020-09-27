package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = (byte) 251, to = (byte) 251))
public class same_frame_extended extends stack_map_frame {
  public short offset_delta;
}
