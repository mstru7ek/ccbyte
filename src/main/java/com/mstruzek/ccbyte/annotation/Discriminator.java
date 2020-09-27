package com.mstruzek.ccbyte.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Discriminator {

  /**
   * By default id of one of discriminated sub class.
   */
  short value() default 0x00;


  /**
   * By default if of one of discriminated sub class.
   * @return
   */
  byte byteValue() default 0x00;

  /**
   * Search for discriminated sub-class by String
   * @return
   */
  String attributeName() default "";

  Range range() default @Range(from = 0, to =  0);

  char[] charArray() default {};

}
