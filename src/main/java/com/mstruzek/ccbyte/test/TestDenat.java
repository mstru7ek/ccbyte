package com.mstruzek.ccbyte.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestDenat {


  String value() default "";

  Part part() default Part.DAY;

  TestChild child() default @TestChild();

  String[] wwwrr() ;

  public enum Part {
    DAY,
    NIGHT;
  }
}
