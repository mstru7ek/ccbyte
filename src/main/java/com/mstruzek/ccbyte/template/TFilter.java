package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;
import com.mstruzek.ccbyte.cpool.ConstPool;

class TFilter implements Filter {
  private final ConstPool constPool;

  public TFilter(ConstPool constPool) {
    this.constPool = constPool;
  }

  @Override
  public String getName() {
    return "T";
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) {
      return null;
    }
    if (varr instanceof Short) {
      var tag = constPool.getTags()[(short) varr];
      return TemplateUtils.escapeHTML(tag.getClass().getSimpleName().substring("CONSTANT_".length()));
    }
    return null;
  }

}
