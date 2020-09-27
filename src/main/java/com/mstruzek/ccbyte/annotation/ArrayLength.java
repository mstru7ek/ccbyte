package com.mstruzek.ccbyte.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArrayLength {

  /**
   * Reference field name witch contains initilization value for annotated type buffer.
   */
  String fieldName() default "";

  byte subtruct() default 0;

  String subField() default "";
}
