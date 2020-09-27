package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;
import com.mstruzek.ccbyte.base.Flags;

import java.lang.reflect.Field;

public class FlagsFilter<T> implements Filter {

  private final String tagName;
  private final Class<T> enumClass;

  private FlagsFilter(Class<T> source, String suffix) {
    this.enumClass = source;
    this.tagName = "Flag" + suffix;
  }

  public static <T> FlagsFilter<T> from(Class<T> enumClass, String suffix) {
    return new FlagsFilter<T>(enumClass, suffix);
  }

  @Override
  public String getName() {
    return tagName;
  }

  @Override
  public Object filter(Object varr, JinjavaInterpreter interpreter, String... args) {
    if (varr == null) {
      return null;
    }
    if (varr instanceof Short) {
      try {
        String value = accessFlagsString((Short) varr);
        return TemplateUtils.escapeHTML(value);
      } catch (IllegalAccessException e) {
        throw new IllegalStateException(e);
      }
    }
    return null;
  }

  public String accessFlagsString(short accessFlags) throws IllegalAccessException {
    var sb = new StringBuilder();
    var declaredFields = enumClass.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      if (declaredField.isEnumConstant() && (((Flags) declaredField.get(null)).value() & accessFlags) != 0) {
        sb.append(declaredField.getName()).append(", ");
      }
    }
    return sb.toString();
  }
}
