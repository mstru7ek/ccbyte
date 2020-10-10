package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.lib.fn.ELFunctionDefinition;
import com.mstruzek.ccbyte.core.ClassFileLoader;
import com.mstruzek.ccbyte.base.Flags;
import com.mstruzek.ccbyte.template.filter.*;

import static com.mstruzek.ccbyte.template.TemplateUtils.loadTemplate;

public class Template {

  private static final Jinjava jinjava = new Jinjava();

  public String process(ClassFileLoader classFileLoader) {
    jinjava.registerTag(new DispatchTag());
    jinjava.registerTag(new RDispatchTag());
    jinjava.registerFilter(new Utf8Filter());
    jinjava.registerFilter(new RFilter(classFileLoader.constantPool()));
    jinjava.registerFilter(new TFilter(classFileLoader.constantPool()));
    jinjava.registerFilter(new PTFilter());
    jinjava.registerFilter(new RefKindFilter());

    jinjava.registerFilter(FlagsFilter.from(Flags.Class.class, "C"));
    jinjava.registerFilter(FlagsFilter.from(Flags.NestedClass.class, "N"));
    jinjava.registerFilter(FlagsFilter.from(Flags.Field.class, "F"));
    jinjava.registerFilter(FlagsFilter.from(Flags.Method.class, "M"));
    jinjava.registerFilter(FlagsFilter.from(Flags.Module.class, "D"));
    jinjava.registerFilter(FlagsFilter.from(Flags.ModuleDependent.class, "MD"));
    jinjava.registerFilter(FlagsFilter.from(Flags.Parameter.class, "P"));

    try {
      jinjava.registerFunction(new ELFunctionDefinition("", "box", TemplateUtils.class.getDeclaredMethod("box", Object.class)));

      jinjava.registerFunction(new ELFunctionDefinition("", "uint", TemplateUtils.class.getDeclaredMethod("uint", byte.class)));

      jinjava.registerFunction(new ELFunctionDefinition("", "map", TemplateUtils.class.getDeclaredMethod("map", Object.class)));

      jinjava.registerFunction(new ELFunctionDefinition("", "toByte", TemplateUtils.class.getDeclaredMethod("toByte", Object.class)));

      jinjava.registerFunction(new ELFunctionDefinition("", "toChar", TemplateUtils.class.getDeclaredMethod("toChar", Object.class)));

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    var output = jinjava.render(loadTemplate(ClassFileLoader.class, false), ObjectAsMap.wrap(classFileLoader));

    return output;
  }

}
