package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = 0, to = 63))
public class same_frame extends stack_map_frame {
}
