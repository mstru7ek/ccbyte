package com.mstruzek.ccbyte.code;


import com.mstruzek.ccbyte.annotation.*;

public class op_code {
    @Discriminated(type = DiscriminationType.BYTE_VALUE)
    public byte op_code;
}
