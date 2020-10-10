package com.mstruzek.ccbyte.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class  TemplateUtils {

  private static final Map<Class<?>, String> templates = new HashMap<>();
  private static final Map<Class<?>, String> templatesR = new HashMap<>();

  private TemplateUtils() {
  }

  public static String loadTemplate(Class<?> aClass, boolean templateR) {
    return templateR
        ? loadTemplate(templatesR, ".R", aClass)
        : loadTemplate(templates, "", aClass);
  }

  private static String loadTemplate(Map<Class<?>, String> templates, String postfix, Class<?> templateClass) {
    if (templates.get(templateClass) == null) {
      var templateBody = doLoadTemplate(templateClass, postfix);
      templates.put(templateClass, templateBody);
    }
    return templates.get(templateClass);
  }

  private static String doLoadTemplate(Class<?> templateClass, String postfix) {
    var file = getFileName(templateClass, postfix);
    try {
      URL resource = ClassLoader.getSystemClassLoader().getResource(file);
      if (resource == null) {
        resource = ClassLoader.getSystemClassLoader().getResource(getFileName(templateClass.getSuperclass(), postfix));
        if (resource == null) {
          throw new RuntimeException(String.format("resource not found: %s", file));
        }
      }
      var path = Paths.get(resource.toURI());
      return Files.readString(path);
    } catch (URISyntaxException | IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private static String getFileName(Class<?> templateClass, String postfix) {
    return templateClass.getName().substring("com.mstruzek.ccbyte".length() + 1).replace(".", "/").replace("$", "/").concat(postfix).concat(".html");
  }

  public static Object[] box(Object object) {
    if (object.getClass().isArray() && object.getClass().getComponentType().isPrimitive()) {
      return boxedArray(object);
    } else if (object.getClass().isArray()) {
      return (Object[]) object;
    }
    throw new IllegalStateException("object is not an array");
  }

  public static Byte toByte(Object object) {
    if (object instanceof String) {
      return (byte)((String) object).charAt(0);
    } else if (object instanceof Character) {
      return (byte) ((Character)object).charValue();
    }
    throw new IllegalStateException("object is not convertible to byte");
  }

  public static Character toChar(Object object) {
    if (object instanceof Byte) {
      return (char)((Byte) object).byteValue();
    }
    throw new IllegalStateException("object is not convertible to char");
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

  public static Object map(Object object) {
    return ObjectAsMap.wrap(object);
  }
}
