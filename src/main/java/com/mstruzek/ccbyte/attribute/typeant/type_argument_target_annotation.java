package com.mstruzek.ccbyte.attribute.typeant;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Range;
import com.mstruzek.ccbyte.attribute.ant.element_value_pair;
import com.mstruzek.ccbyte.attribute.typeant.target.type_argument_target;

@Discriminator(range = @Range(from = 0x47, to = 0x4B))
public class type_argument_target_annotation extends type_annotation {
  public type_argument_target target_info;
  public type_path target_path;
  public short type_index;
  public short num_element_value_pairs;
  @ArrayLength(fieldName = "num_element_value_pairs")
  public element_value_pair[] element_value_pairs;
}
