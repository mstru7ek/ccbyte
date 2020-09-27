package com.mstruzek.ccbyte.test;

import java.io.Serializable;
import java.util.function.Function;

public class Lancuch {

  public static class BB {

    private String a;
    private String b;
    private String c;

    public BB() {
    }

    private BB(Builder builder) {
      this.a = builder.a;
      this.b = builder.b;
      this.c = builder.c;
    }

    public void setA(String a) {
      this.a = a;
    }

    public void setB(String b) {
      this.b = b;
    }

    public void setC(String c) {
      this.c = c;
    }
  }

  public static class Builder {

    private String a;
    private String b;
    private String c;

    public Builder a(String a) {
      this.a = a;
      return this;
    }

    public Builder b(String b) {
      this.b = b;
      return this;
    }

    public Builder c(String c) {
      this.c = c;
      return this;
    }

    public BB build() {
      return new BB(this);
    }



  }

  public static void main(String[] args) {
    String name = new AZespol().bDruzyn().zawodnik().getName();
    System.out.println(name);

    BB bb = new Builder().a("a").b("b").c("c").build();


    BB bhg = new BB();

    bhg.setA("a");
    bhg.setB("b");
    bhg.setC("c");
  }


  private static class AZespol {
    public BDruzyn bDruzyn() {
      return new BDruzyn();
    }
  }

  private static class BDruzyn {

    public Zawodnik zawodnik() {
      return new Zawodnik();
    }

  }

  public interface Transform<T> {
    public T apply(T value);
  }

  public static final class Zawodnik implements  Comparable<Zawodnik>, Transform<Integer> {

    private final String name = "Moje imie";

    public String getName() {
      return name;
    }

    private int f;

    public void checkAndSetF(int f) {
      if (f < 0) {
        throw new IllegalArgumentException();
      } 
      this.f = f;
    }

    public void cos() {

      Function<String, String> makeThis = (v) -> v;

      Function<String,String> innerClass = new Function<String,String>() {

        @Override
        public String apply(String s) {
          return Zawodnik.this.name + s;
        }
      };
    }

    public String apply(String s) {
      return s;
    }

    @Override
    public int compareTo(Zawodnik o) {
      return name.compareTo(o.name);
    }

    @Override
    public Integer apply(Integer value) {
      return value;
    }
  }
}
