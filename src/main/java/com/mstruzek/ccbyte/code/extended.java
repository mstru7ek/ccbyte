package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface extended {
  @Discriminator(byteValue = (byte) 0xc4) class wide extends op_code {}
  @Discriminator(byteValue = (byte) 0xc5) class multianewarray extends op_code { public short index; public byte dimensions; }
  @Discriminator(byteValue = (byte) 0xc6) class ifnull extends op_code { public short branch; }
  @Discriminator(byteValue = (byte) 0xc7) class ifnonnull extends op_code { public short branch; }
  @Discriminator(byteValue = (byte) 0xc8) class goto_w extends op_code { public int branch; }
  @Discriminator(byteValue = (byte) 0xc9) class jsr_w extends op_code { public int branch; }
}
