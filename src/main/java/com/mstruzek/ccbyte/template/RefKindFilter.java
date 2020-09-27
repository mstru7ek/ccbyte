package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;
import com.mstruzek.ccbyte.cpool.Consts;

public class RefKindFilter implements Filter {
  @Override
  public String getName() {
    return "RefKind";
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) return null;
    return Consts.RefKinds.get(varr);
  }
}
