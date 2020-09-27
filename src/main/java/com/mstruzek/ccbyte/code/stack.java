package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface stack {
  @Discriminator(byteValue = 0x57) class pop extends op_code {}
  @Discriminator(byteValue = 0x58) class pop2 extends op_code {}
  @Discriminator(byteValue = 0x59) class dup extends op_code {}
  @Discriminator(byteValue = 0x5a) class dup_x1 extends op_code {}
  @Discriminator(byteValue = 0x5b) class dup_x2 extends op_code {}
  @Discriminator(byteValue = 0x5c) class dup2 extends op_code {}
  @Discriminator(byteValue = 0x5d) class dup2_x1 extends op_code {}
  @Discriminator(byteValue = 0x5e) class dup2_x2 extends op_code {}
  @Discriminator(byteValue = 0x5f) class swap extends op_code {}
}
