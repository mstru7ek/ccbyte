package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface conversions {
  @Discriminator(byteValue = (byte)0x85) class i2l extends op_code {}
  @Discriminator(byteValue = (byte)0x86) class i2f extends op_code {}
  @Discriminator(byteValue = (byte)0x87) class i2d extends op_code {}
  @Discriminator(byteValue = (byte)0x88) class l2i extends op_code {}
  @Discriminator(byteValue = (byte)0x89) class l2f extends op_code {}
  @Discriminator(byteValue = (byte)0x8a) class l2d extends op_code {}
  @Discriminator(byteValue = (byte)0x8b) class f2i extends op_code {}
  @Discriminator(byteValue = (byte)0x8c) class f2l extends op_code {}
  @Discriminator(byteValue = (byte)0x8d) class f2d extends op_code {}
  @Discriminator(byteValue = (byte)0x8e) class d2i extends op_code {}
  @Discriminator(byteValue = (byte)0x8f) class d2l extends op_code {}
  @Discriminator(byteValue = (byte)0x90) class d2f extends op_code {}
  @Discriminator(byteValue = (byte)0x91) class i2b extends op_code {}
  @Discriminator(byteValue = (byte)0x92) class i2c extends op_code {}
  @Discriminator(byteValue = (byte)0x93) class i2s extends op_code {}
}

