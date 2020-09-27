package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface loads {
  @Discriminator(byteValue = 0x15) class iload extends op_code{ public byte index;}
  @Discriminator(byteValue = 0x16) class lload extends op_code{ public byte index;}
  @Discriminator(byteValue = 0x17) class fload extends op_code{ public byte index;}
  @Discriminator(byteValue = 0x18) class dload extends op_code{ public byte index;}
  @Discriminator(byteValue = 0x19) class aload extends op_code{ public byte index;}
  @Discriminator(byteValue = 0x1a) class iload_0 extends op_code {}
  @Discriminator(byteValue = 0x1b) class iload_1 extends op_code {}
  @Discriminator(byteValue = 0x1c) class iload_2 extends op_code {}
  @Discriminator(byteValue = 0x1d) class iload_3 extends op_code {}
  @Discriminator(byteValue = 0x1e) class lload_0 extends op_code {}
  @Discriminator(byteValue = 0x1f) class lload_1 extends op_code {}
  @Discriminator(byteValue = 0x20) class lload_2 extends op_code {}
  @Discriminator(byteValue = 0x21) class lload_3 extends op_code {}
  @Discriminator(byteValue = 0x22) class fload_0 extends op_code {}
  @Discriminator(byteValue = 0x23) class fload_1 extends op_code {}
  @Discriminator(byteValue = 0x24) class fload_2 extends op_code {}
  @Discriminator(byteValue = 0x25) class fload_3 extends op_code {}
  @Discriminator(byteValue = 0x26) class dload_0 extends op_code {}
  @Discriminator(byteValue = 0x27) class dload_1 extends op_code {}
  @Discriminator(byteValue = 0x28) class dload_2 extends op_code {}
  @Discriminator(byteValue = 0x29) class dload_3 extends op_code {}
  @Discriminator(byteValue = 0x2a) class aload_0 extends op_code {}
  @Discriminator(byteValue = 0x2b) class aload_1 extends op_code {}
  @Discriminator(byteValue = 0x2c) class aload_2 extends op_code {}
  @Discriminator(byteValue = 0x2d) class aload_3 extends op_code {}
  @Discriminator(byteValue = 0x2e) class iaload extends op_code {}
  @Discriminator(byteValue = 0x2f) class laload extends op_code {}
  @Discriminator(byteValue = 0x30) class faload extends op_code {}
  @Discriminator(byteValue = 0x31) class daload extends op_code {}
  @Discriminator(byteValue = 0x32) class aaload extends op_code {}
  @Discriminator(byteValue = 0x33) class baload extends op_code {}
  @Discriminator(byteValue = 0x34) class caload extends op_code {}
  @Discriminator(byteValue = 0x35) class saload extends op_code {}
}
