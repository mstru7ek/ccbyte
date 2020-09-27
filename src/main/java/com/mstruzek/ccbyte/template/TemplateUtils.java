package com.mstruzek.ccbyte.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class TemplateUtils {

  private static final Map<Class<?>, String> templates = new HashMap<>();

  private TemplateUtils() {
  }

  public static String loadTemplate(Class<?> templateClass) {
    if (templates.get(templateClass) == null) {
      var templateBody = doLoadTemplate(templateClass);
      templates.put(templateClass, templateBody);
    }
    return templates.get(templateClass);
  }

  private static String doLoadTemplate(Class<?> templateClass) {
    var file = templateClass.getName().substring("com.mstruzek.ccbyte".length() + 1).replace(".", "/").concat(".html");
    try {
      var resource = ClassLoader.getSystemClassLoader().getResource(file);
      Objects.requireNonNull(resource, String.format("resource not found: %s", file));
      var path = Paths.get(resource.toURI());
      return Files.readString(path);
    } catch (URISyntaxException | IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static Object[] box(Object object) {
    if (object.getClass().isArray() && object.getClass().getComponentType().isPrimitive()) {
      return boxedArray(object);
    } else if (object.getClass().isArray()) {
      return (Object[]) object;
    }
    throw new IllegalStateException("object is not an array");
  }

  public static Object[] boxedArray(Object array) {
    if (array.getClass().getComponentType().equals(short.class)) {
      short[] src = (short[]) array;
      Short[] dst = new Short[src.length];
      for (int i = 0; i < src.length; i++) {
        dst[i] = src[i];
      }
      return dst;
    } else {
      throw new IllegalStateException(String.format("type not supported = %s", array.getClass()));
    }
  }

  public static String escapeHTML(String s) {
    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
        out.append("&#");
        out.append((int) c);
        out.append(';');
      } else {
        out.append(c);
      }
    }
    return out.toString();
  }

  public static Integer uint(byte value) {
    return Byte.toUnsignedInt(value);
  }

}
