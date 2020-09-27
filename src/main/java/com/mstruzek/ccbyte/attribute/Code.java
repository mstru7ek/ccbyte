package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.SequencedPositioned;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.attribute.info.exception_info;
import com.mstruzek.ccbyte.code.op_code;

@Discriminator(attributeName = "Code")
public class Code extends attribute_info {
  public short max_stack;
  public short max_locals;
  public int code_length;
  @ArrayLength(fieldName = "code_length")
  public byte[] code;

  @ArrayLength(fieldName = "code_length")
  @SequencedPositioned(sourceFrom = "code")
  public op_code[] code_segment;

  public short exception_table_length;
  @ArrayLength(fieldName = "exception_table_length")
  public exception_info[] exception_table;
  public short attributes_count;
  @ArrayLength(fieldName = "attributes_count")
  public attribute_info[] attributes;
}
