package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;
import com.mstruzek.ccbyte.cpool.ConstPool;

class RFilter implements Filter {
  private final ConstPool constPool;

  public RFilter(ConstPool constPool) {
    this.constPool = constPool;
  }

  @Override
  public String getName() {
    return "R";
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) {
      return null;
    }
    if (varr instanceof Byte) {
      var value = constPool.resolve((byte) varr);
      return TemplateUtils.escapeHTML(value);
    } else  if (varr instanceof Short) {
      var value = constPool.resolve((short) varr);
      return TemplateUtils.escapeHTML(value);
    }
    return null;
  }

}
