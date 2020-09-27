package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = 64, to = 127))
public class same_locals_1_stack_item_frame extends stack_map_frame {
  public verification_type_info stack;
}
