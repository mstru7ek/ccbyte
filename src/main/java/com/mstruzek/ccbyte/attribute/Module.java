package com.mstruzek.ccbyte.attribute;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.attribute.module.export_element;
import com.mstruzek.ccbyte.attribute.module.open_element;
import com.mstruzek.ccbyte.attribute.module.provide_element;
import com.mstruzek.ccbyte.attribute.module.require_element;
import com.mstruzek.ccbyte.base.attribute_info;

@Discriminator(attributeName = "Module")
public class Module extends attribute_info {

  public short module_name_index;
  public short module_flags;
  public short module_version_index;

  public short requires_count;
  @ArrayLength(fieldName = "requires_count")
  public require_element[] requires;

  public short exports_count;
  @ArrayLength(fieldName = "exports_count")
  public export_element[] exports;

  public short opens_count;
  @ArrayLength(fieldName = "opens_count")
  public open_element[] opens;

  public short uses_count;
  @ArrayLength(fieldName = "uses_count")
  public short[] uses_index;

  public short provides_count;
  @ArrayLength(fieldName = "provides_count")
  public provide_element[] provides;
}
