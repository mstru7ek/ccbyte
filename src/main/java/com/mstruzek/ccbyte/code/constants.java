package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface constants {
  @Discriminator(byteValue = 0x00) class nop extends op_code {}
  @Discriminator(byteValue = 0x01) class aconst_null extends op_code {}
  @Discriminator(byteValue = 0x02) class iconst_m1 extends op_code {}
  @Discriminator(byteValue = 0x03) class iconst_0 extends op_code {}
  @Discriminator(byteValue = 0x04) class iconst_1 extends op_code {}
  @Discriminator(byteValue = 0x05) class iconst_2 extends op_code {}
  @Discriminator(byteValue = 0x06) class iconst_3 extends op_code {}
  @Discriminator(byteValue = 0x07) class iconst_4 extends op_code {}
  @Discriminator(byteValue = 0x08) class iconst_5 extends op_code {}
  @Discriminator(byteValue = 0x09) class lconst_0 extends op_code {}
  @Discriminator(byteValue = 0x0a) class lconst_1 extends op_code {}
  @Discriminator(byteValue = 0x0b) class fconst_0 extends op_code {}
  @Discriminator(byteValue = 0x0c) class fconst_1 extends op_code {}
  @Discriminator(byteValue = 0x0d) class fconst_2 extends op_code {}
  @Discriminator(byteValue = 0x0e) class dconst_0 extends op_code {}
  @Discriminator(byteValue = 0x0f) class dconst_1 extends op_code {}
  @Discriminator(byteValue = 0x10) class bipush extends op_code { public byte byte_; }
  @Discriminator(byteValue = 0x11) class sipush extends op_code {}
  @Discriminator(byteValue = 0x12) class ldc extends op_code { public byte index;}
  @Discriminator(byteValue = 0x13) class ldc_w extends op_code { public short index;}
  @Discriminator(byteValue = 0x14) class ldc2_w extends op_code { public short index;}
}
