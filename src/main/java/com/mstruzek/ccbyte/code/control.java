package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.ArrayLength;
import com.mstruzek.ccbyte.annotation.Discriminator;
import com.mstruzek.ccbyte.annotation.Padding;

public interface control {
  @Discriminator(byteValue = (byte)0xa7) class goto_ extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa8) class jsr  extends op_code { public short branch; }
  @Discriminator(byteValue = (byte)0xa9) class ret  extends op_code { public byte index; }
  @Discriminator(byteValue = (byte)0xaa) class tableswitch  extends op_code {
    @Padding
    public byte[] pad;
    public int default_;
    public int low;
    public int high;
    @ArrayLength(fieldName = "high", subField = "low", subtruct = -1)
    public int[] offsets;
  }
  @Discriminator(byteValue = (byte)0xab) class lookupswitch  extends op_code {
    @Padding
    public byte[] pad;
    public int default_;
    public int npairs;
    @ArrayLength(fieldName = "npairs")
    public match_offset_pair[] pairs;


    public static class match_offset_pair {
      public int match;
      public int offset;
    }

  }
  @Discriminator(byteValue = (byte)0xac) class ireturn  extends op_code {}
  @Discriminator(byteValue = (byte)0xad) class lreturn  extends op_code {}
  @Discriminator(byteValue = (byte)0xae) class freturn  extends op_code {}
  @Discriminator(byteValue = (byte)0xaf) class dreturn  extends op_code {}
  @Discriminator(byteValue = (byte)0xb0) class areturn  extends op_code {}
  @Discriminator(byteValue = (byte)0xb1) class return_  extends op_code {}
}
