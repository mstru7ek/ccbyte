package com.mstruzek.ccbyte.attribute.frame;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;

@Discriminator(range = @Range(from = (byte)255, to = (byte)255))
public class full_frame extends stack_map_frame {
  public short offset_delta;
  public short number_of_locals;
  @ArrayLength(fieldName = "number_of_locals")
  verification_type_info[] locals;
  public short number_of_stack_items;
  @ArrayLength(fieldName = "number_of_stack_items")
  verification_type_info[] stack;
}
