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

  public static final String nieboraki = "nie bo raki";

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

//  public static final @Who Map<@Who String, List<@Who Integer>> lst = new HashMap<>();


  static Integer w;

  public static void main(String[] args) {

    System.out.println(nieboraki);

    int z = 10;

    if (z < 12) {
      w = z;
    } else if (z < 20) {
      w = z + 1;
    } else {
      w = -1;
    }
  }

  public int mx(int i, int w, int z, int q, int r, int y, int u, int k, int l) {
    return i + w + z + q + r + y + u + k + l;
  }

  @TestDenat(value = "asdf", part = Part.NIGHT, child = @TestChild(index = 1, name = "ulalal"), wwwrr = {"AA","ZZ"})
  public void sprawdzenie_adnotacji() {
    return;
  }

//  @TestDenat
//  public static class Winner {
//  }
//
//
  @Target(value = {ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE, ElementType.PARAMETER})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Who {
  }
//
//
//  public class DD implements Function<Integer, Integer> {
//
//    @Override
//    public Integer apply(Integer integer) {
//      return null;
//    }
//  }
//
//  public void mm(int k) throws IOException, IllegalAccessError {
//    int[] kk = new int[]{1, 2, 10};
//    w = ++k + kk[1];
//
//    Function<Integer, Integer> zzz = x -> x + 1;
//    Function<Integer, Integer> zzz2 = x -> x + 2;
//
//    zzz.apply(10);
//    zzz2.apply(12);
//
//    String[][][] strings = new String[3][4][4];
//    strings[1][1][1] = "asdf";
//
//  }
//
//  public long lookup_swwitch(int k) {
//    String[][][] strings = new String[3][4][4];
//    strings[1][1][1] = "asdf";
//
//
//    // lookupswitch
//    switch (k) {
//      case 120:
//        break;
//      case 230:
//        break;
//      case 1500:
//        break;
//    }
//
//    return 10l;
//  }
//
//  public Object table_switch(int k) {
//    switch (k) {
//      case 12:
//        break;
//      case 14:
//        break;
//      case 15:
//        break;
//    }
//    return new Object();
//  }
//
  public void parameter_annotations(
      @TestDenat(value = "asdf", part = Part.NIGHT, wwwrr = {}) @Who String request,
      @TestDenat(value = "asdf", part = Part.NIGHT, child = @TestChild(index = 1, name = "ulalal"), wwwrr = {"TT", "ZZ"}) String response
  ) {

    return;
  }
}
