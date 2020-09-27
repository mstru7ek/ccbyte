package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface references {
  @Discriminator(byteValue = (byte)0xb2) class getstatic extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb3) class putstatic extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb4) class getfield extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb5) class putfield extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb6) class invokevirtual extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb7) class invokespecial extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb8) class invokestatic extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xb9) class invokeinterface extends op_code {public short index; public byte count; public byte zero;}
  @Discriminator(byteValue = (byte)0xba) class invokedynamic extends op_code { public short index; public short zero; }
  @Discriminator(byteValue = (byte)0xbb) class new_ extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xbc) class newarray extends op_code { public byte atype; }
  @Discriminator(byteValue = (byte)0xbd) class anewarray extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xbe) class arraylength extends op_code { }
  @Discriminator(byteValue = (byte)0xbf) class athrow extends op_code {}
  @Discriminator(byteValue = (byte)0xc0) class checkcast extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xc1) class instanceof_ extends op_code { public short index; }
  @Discriminator(byteValue = (byte)0xc2) class monitorenter extends op_code {}
  @Discriminator(byteValue = (byte)0xc3) class monitorexit extends op_code {}
}

