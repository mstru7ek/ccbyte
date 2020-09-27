package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface reserved {
  @Discriminator(byteValue = (byte) 0xca) class breakpoint extends op_code { }
  @Discriminator(byteValue = (byte) 0xfe) class impdep1 extends op_code { }
  @Discriminator(byteValue = (byte) 0xff) class impdep2 extends op_code { }
}
