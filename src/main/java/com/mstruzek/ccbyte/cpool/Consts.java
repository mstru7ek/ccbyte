package com.mstruzek.ccbyte.cpool;

import com.google.common.collect.ImmutableMap;

public class Consts {

  public static final ImmutableMap<Byte, String> RefKinds = ImmutableMap.<Byte, String>builder()
      .put((byte) 1, "REF_getField")
      .put((byte) 2, "REF_getStatic")
      .put((byte) 3, "REF_putField")
      .put((byte) 4, "REF_putStatic")
      .put((byte) 5, "REF_invokeVirtual")
      .put((byte) 6, "REF_invokeStatic")
      .put((byte) 7, "REF_invokeSpecial")
      .put((byte) 8, "REF_newInvokeSpecial")
      .put((byte) 9, "REF_invokeInterface")
      .build();
}
