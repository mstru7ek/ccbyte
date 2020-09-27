package com.mstruzek.ccbyte.core;

import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.cpool.ConstPool;
import com.mstruzek.ccbyte.base.field_info;
import com.mstruzek.ccbyte.base.method_info;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.out;

public class ClassFileLoader {

  private byte[] classBuffer;

  private short minor_version;

  private short major_version;

  private ConstPool constPool;

  private HierarchyRegister hierarchyRegister;

  private short accessFlags;

  private short this_class;

  private short super_class;

  private short[] interfaces;

  private field_info[] fields;

  private method_info[] methods;

  private attribute_info[] attributes;

  public ClassFileLoader(Path path) throws IOException {
    this.classBuffer = Files.readAllBytes(path);
  }

  public void read() throws NoSuchFieldException {
    ByteBuffer byteCode = ByteBuffer.wrap(classBuffer);

    byte[] magic = new byte[4];

    byteCode.get(magic, 0, 4);

    assert magic[0] == (byte) 0xCA;
    assert magic[1] == (byte) 0xFE;
    assert magic[2] == (byte) 0xBA;
    assert magic[3] == (byte) 0xBE;

    minor_version = byteCode.getShort();
    major_version = byteCode.getShort();

    constPool = new ConstPool(byteCode);
    constPool.read();

    hierarchyRegister = new HierarchyRegister(constPool);

    accessFlags = byteCode.getShort();

    this_class = byteCode.getShort();
    super_class = byteCode.getShort();

    short interface_count = byteCode.getShort();
    interfaces = new short[interface_count];

    for (int i = 0; i < interface_count; i++) {
      interfaces[i] = byteCode.getShort();
    }

    final DataReader dataReader = new DataReader(hierarchyRegister);

    short fields_count = byteCode.getShort();
    fields = new field_info[fields_count];

    for (int i = 0; i < fields_count; i++) {
      field_info fi = new field_info();
      fi.access_flags = byteCode.getShort();
      fi.name_index = byteCode.getShort();
      fi.descriptor_index = byteCode.getShort();
      fi.attributes_count = byteCode.getShort();
      fi.attributes = new attribute_info[fi.attributes_count];

      dataReader.readFully(field_info.class.getDeclaredField("attributes"), fi.attributes, byteCode);
      fields[i] = fi;
    }

    short methods_count = byteCode.getShort();
    methods = new method_info[methods_count];

    for (int i = 0; i < methods_count; i++) {
      method_info mth = new method_info();
      mth.access_flags = byteCode.getShort();
      mth.name_index = byteCode.getShort();
      mth.descriptor_index = byteCode.getShort();
      mth.attributes_count = byteCode.getShort();
      mth.attributes = new attribute_info[mth.attributes_count];

      dataReader.readFully(method_info.class.getDeclaredField("attributes"), mth.attributes, byteCode);
      methods[i] = mth;
    }

    short attributes_count = byteCode.getShort();
    attributes = new attribute_info[attributes_count];

    dataReader.readFully(ClassFileLoader.class.getDeclaredField("attributes"), attributes, byteCode);

//    printBasicDescription();
    // -------------------
  }

  private void printBasicDescription() {

    out.println("--------------------------------------");
    out.printf("Minor Version: %d \n", minor_version);
    out.printf("Major Version: %d \n", major_version);

    out.println("--------------------------------------");
    constPool.print();

    out.println("--------------------------------------");

    out.println("--------------------------------------");
    out.printf("Class Name: %s \n", constPool.resolve(this_class));
    out.printf("Super Class: %s \n", constPool.resolve(super_class));

    out.println("--------------------------------------");
    for (int i = 0; i < interfaces.length; i++) {
      out.printf("Interface: %s \n", constPool.resolve(interfaces[i]));
    }

    out.println("--------------------------------------");
    for (int i = 0; i < fields.length; i++) {
      out.printf("Field: %s:%s\n", constPool.resolve(fields[i].name_index), constPool.resolve(fields[i].descriptor_index));
      for (int j = 0; j < fields[i].attributes.length; j++) {
        out.printf("Field Attribute: %s\n", constPool.resolve(fields[i].attributes[j].attribute_name_index));
      }
    }

    out.println("--------------------------------------");
    for (int i = 0; i < methods.length; i++) {
      out.printf("Method: %s : %s\n", constPool.resolve(methods[i].name_index), constPool.resolve(methods[i].descriptor_index));
      for (int j = 0; j < methods[i].attributes.length; j++) {
        out.printf("Method Attribute: %s\n", constPool.resolve(methods[i].attributes[j].attribute_name_index));
      }
    }

    out.println("--------------------------------------");
    for (int i = 0; i < attributes.length; i++) {
      out.printf("Attribute: %s \n", constPool.resolve(attributes[i].attribute_name_index));

    }
  }

  public ConstPool constantPool() {
    return this.constPool;
  }

}


