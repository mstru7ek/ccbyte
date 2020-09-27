package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = (byte)247, to = (byte)247))
public class same_locals_1_stack_item_frame_extended extends stack_map_frame {
  public short offset_delta;
  public verification_type_info stack;
}
