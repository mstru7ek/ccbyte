package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

import java.nio.charset.StandardCharsets;

class Utf8Filter implements Filter {

  @Override
  public String getName() {
    return "UTF8";
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) {
      return null;
    }
    if (varr instanceof byte[]) {
      return TemplateUtils.escapeHTML(new String((byte[]) varr, StandardCharsets.UTF_8));
    }
    return null;
  }
}
