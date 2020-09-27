package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface comparisons {
  @Discriminator(byteValue = (byte)0x94) class lcmp extends op_code {}
  @Discriminator(byteValue = (byte)0x95) class fcmpl extends op_code {}
  @Discriminator(byteValue = (byte)0x96) class fcmpg extends op_code {}
  @Discriminator(byteValue = (byte)0x97) class dcmpl extends op_code {}
  @Discriminator(byteValue = (byte)0x98) class dcmpg extends op_code {}
  @Discriminator(byteValue = (byte)0x99) class ifeq extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9a) class ifne extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9b) class iflt extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9c) class ifge extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9d) class ifgt extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9e) class ifle extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0x9f) class if_icmpeq extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa0) class if_icmpne extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa1) class if_icmplt extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa2) class if_icmpge extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa3) class if_icmpgt extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa4) class if_icmple extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa5) class if_acmpeq extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa6) class if_acmpne extends op_code { public short branch; }
}
