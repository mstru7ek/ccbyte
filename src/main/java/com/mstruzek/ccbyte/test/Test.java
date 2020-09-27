package com.mstruzek.ccbyte.test;

import com.mstruzek.ccbyte.test.TestDenat.Part;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Test {

  public class Dzieciaki {
    public static final String nieboraki = "nie bo raki";

    public String ss;
    public Integer is;
    public Long ws;
    public Long zsLongggggggggggggggggggggggggggggggggg;
    public Long zsasdfasdlfkja;

    public Function<String, Long> maps;

    public Dzieciaki(String ss, Integer is, Long ws, Long zsLongggggggggggggggggggggggggggggggggg, Long zsasdfasdlfkja, Function<String, Long> maps) {
      this.ss = ss;
      this.is = is;
      this.ws = ws;
      this.zsLongggggggggggggggggggggggggggggggggg = zsLongggggggggggggggggggggggggggggggggg;
      this.zsasdfasdlfkja = zsasdfasdlfkja;
      this.maps = maps;
    }
  }

  public static class Kolosemu {

    public void koloseum() {



    }
  }

  static final Short si = 10;
  static final int ii = 10;
  static final float fi = 100.f;
  static final long li = 10L;
  static final double di = 10.0d;

  private static final Function<Object, Object> ffi = Objects::isNull;

  public static final @Who Map<@Who String, List<@Who Integer>> lst = new HashMap<>();


  static Integer w;
  public static void main(String[] args) {

    int z = 10;

    if (z < 12) {
      w = z;
    } else if (z < 20){
      w = z + 1;
    } else {
      w = -1;
    }
  }

  @TestDenat(value = "asdf", part = Part.NIGHT)
  public void sprawdzenie_adnotacji(){
    return;
  }


  public static class Winner {}


  @Target(value = {ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Who {}


  public void mm(int k) throws IOException, IllegalAccessError {

    class Enclosing {
    }

    // lookupswitch
    switch (k) {
      case 120:
        break;
      case 230:
        break;
      case 1500:
        break;
      default:
          return;
    }
  }
}
