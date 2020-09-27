package com.mstruzek.ccbyte.code;

import com.mstruzek.ccbyte.annotation.Discriminator;

public interface math {
  @Discriminator(byteValue = 0x60) class iadd extends op_code {}
  @Discriminator(byteValue = 0x61) class ladd extends op_code {}
  @Discriminator(byteValue = 0x62) class fadd extends op_code {}
  @Discriminator(byteValue = 0x63) class dadd extends op_code {}
  @Discriminator(byteValue = 0x64) class isub extends op_code {}
  @Discriminator(byteValue = 0x65) class lsub extends op_code {}
  @Discriminator(byteValue = 0x66) class fsub extends op_code {}
  @Discriminator(byteValue = 0x67) class dsub extends op_code {}
  @Discriminator(byteValue = 0x68) class imul extends op_code {}
  @Discriminator(byteValue = 0x69) class lmul extends op_code {}
  @Discriminator(byteValue = 0x6a) class fmul extends op_code {}
  @Discriminator(byteValue = 0x6b) class dmul extends op_code {}
  @Discriminator(byteValue = 0x6c) class idiv extends op_code {}
  @Discriminator(byteValue = 0x6d) class ldiv extends op_code {}
  @Discriminator(byteValue = 0x6e) class fdiv extends op_code {}
  @Discriminator(byteValue = 0x6f) class ddiv extends op_code {}
  @Discriminator(byteValue = 0x70) class irem extends op_code {}
  @Discriminator(byteValue = 0x71) class lrem extends op_code {}
  @Discriminator(byteValue = 0x72) class frem extends op_code {}
  @Discriminator(byteValue = 0x73) class drem extends op_code {}
  @Discriminator(byteValue = 0x74) class ineg extends op_code {}
  @Discriminator(byteValue = 0x75) class lneg extends op_code {}
  @Discriminator(byteValue = 0x76) class fneg extends op_code {}
  @Discriminator(byteValue = 0x77) class dneg extends op_code {}
  @Discriminator(byteValue = 0x78) class ishl extends op_code {}
  @Discriminator(byteValue = 0x79) class lshl extends op_code {}
  @Discriminator(byteValue = 0x7a) class ishr extends op_code {}
  @Discriminator(byteValue = 0x7b) class lshr extends op_code {}
  @Discriminator(byteValue = 0x7c) class iushr extends op_code {}
  @Discriminator(byteValue = 0x7d) class lushr extends op_code {}
  @Discriminator(byteValue = 0x7e) class iand extends op_code {}
  @Discriminator(byteValue = 0x7f) class land extends op_code {}
  @Discriminator(byteValue = (byte)0x80) class ior extends op_code {}
  @Discriminator(byteValue = (byte)0x81) class lor extends op_code {}
  @Discriminator(byteValue = (byte)0x82) class ixor extends op_code {}
  @Discriminator(byteValue = (byte)0x83) class lxor extends op_code {}
  @Discriminator(byteValue = (byte)0x84) class iinc extends op_code { public byte index; public byte cvalue; }
}
