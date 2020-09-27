package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = (byte)252, to = (byte)254))
public class append_frame extends stack_map_frame {
  public short offset_delta;
  @ArrayLength(fieldName = "frame_type" , subtruct = (byte)251) // frame_type - 251
  public verification_type_info[] locals;
}
