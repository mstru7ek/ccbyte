package com.mstruzek.ccbyte.template.filter;

import com.google.common.collect.ImmutableMap;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

public class PTFilter implements Filter {

  public PTFilter() {
  }

  @Override
  public String getName() {
    return "PT";
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) {
      return null;
    }
    if (varr instanceof Byte) {
      return  PRIMITIVE_TYPE.get((Byte) varr);
    }
    return null;
  }

  private static final ImmutableMap<Byte, String> PRIMITIVE_TYPE =
      ImmutableMap.<Byte, String>builder()
          .put((byte) 4, "boolean")
          .put((byte) 5, "char")
          .put((byte) 6, "float")
          .put((byte) 7, "double")
          .put((byte) 8, "byte")
          .put((byte) 9, "short")
          .put((byte) 10, "int")
          .put((byte) 11, "long")
          .build();

}
