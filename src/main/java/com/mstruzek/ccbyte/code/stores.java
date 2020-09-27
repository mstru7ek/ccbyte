package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface stores {
  @Discriminator(byteValue = 0x36) class istore extends op_code { public byte index;}
  @Discriminator(byteValue = 0x37) class lstore extends op_code { public byte index;}
  @Discriminator(byteValue = 0x38) class fstore extends op_code { public byte index;}
  @Discriminator(byteValue = 0x39) class dstore extends op_code { public byte index;}
  @Discriminator(byteValue = 0x3a) class astore extends op_code { public byte index;}
  @Discriminator(byteValue = 0x3b) class istore_0 extends op_code { }
  @Discriminator(byteValue = 0x3c) class istore_1 extends op_code { }
  @Discriminator(byteValue = 0x3d) class istore_2 extends op_code { }
  @Discriminator(byteValue = 0x3e) class istore_3 extends op_code { }
  @Discriminator(byteValue = 0x3f) class lstore_0 extends op_code { }
  @Discriminator(byteValue = 0x40) class lstore_1 extends op_code { }
  @Discriminator(byteValue = 0x41) class lstore_2 extends op_code { }
  @Discriminator(byteValue = 0x42) class lstore_3 extends op_code { }
  @Discriminator(byteValue = 0x43) class fstore_0 extends op_code { }
  @Discriminator(byteValue = 0x44) class fstore_1 extends op_code { }
  @Discriminator(byteValue = 0x45) class fstore_2 extends op_code { }
  @Discriminator(byteValue = 0x46) class fstore_3 extends op_code { }
  @Discriminator(byteValue = 0x47) class dstore_0 extends op_code { }
  @Discriminator(byteValue = 0x48) class dstore_1 extends op_code { }
  @Discriminator(byteValue = 0x49) class dstore_2 extends op_code { }
  @Discriminator(byteValue = 0x4a) class dstore_3 extends op_code { }
  @Discriminator(byteValue = 0x4b) class astore_0 extends op_code { }
  @Discriminator(byteValue = 0x4c) class astore_1 extends op_code { }
  @Discriminator(byteValue = 0x4d) class astore_2 extends op_code { }
  @Discriminator(byteValue = 0x4e) class astore_3 extends op_code { }
  @Discriminator(byteValue = 0x4f) class iastore extends op_code { }
  @Discriminator(byteValue = 0x50) class lastore extends op_code { }
  @Discriminator(byteValue = 0x51) class fastore extends op_code { }
  @Discriminator(byteValue = 0x52) class dastore extends op_code { }
  @Discriminator(byteValue = 0x53) class aastore extends op_code { }
  @Discriminator(byteValue = 0x54) class bastore extends op_code { }
  @Discriminator(byteValue = 0x55) class castore extends op_code { }
  @Discriminator(byteValue = 0x56) class sastore extends op_code { }
}
