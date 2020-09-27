package com.mstruzek.ccbyte.base;

public interface Flags {
  int value();

  public enum Class implements Flags {
    ACC_PUBLIC(0x0001),
    ACC_FINAL(0x0010),
    ACC_SUPER(0x0020),
    ACC_INTERFACE(0x0200),
    ACC_ABSTRACT(0x0400),
    ACC_SYNTHETIC(0x1000),
    ACC_ANNOTATION(0x2000),
    ACC_ENUM(0x4000),
    ACC_MODULE(0x8000);

    final int value;

    private Class(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

  public enum NestedClass implements Flags {
    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_INTERFACE(0x0200),
    ACC_ABSTRACT(0x0400),
    ACC_SYNTHETIC(0x1000),
    ACC_ANNOTATION(0x2000),
    ACC_ENUM(0x4000);

    final int value;

    private NestedClass(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

  public enum Field implements Flags {
    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_VOLATILE(0x0040),
    ACC_TRANSIENT(0x0080),
    ACC_SYNTHETIC(0x1000),
    ACC_ENUM(0x4000);

    final int value;

    private Field(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

  public enum Method implements Flags {
    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_SYNCHRONIZED(0x0020),
    ACC_BRIDGE(0x0040),
    ACC_VARARGS(0x0080),
    ACC_NATIVE(0x0100),
    ACC_ABSTRACT(0x0400),
    ACC_STRICT(0x0800),
    ACC_SYNTHETIC(0x1000);

    final int value;

    private Method(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

  public enum Module implements Flags {
    ACC_OPEN(0x0020),
    ACC_SYNTHETIC(0x1000),
    ACC_MANDATED(0x8000);

    final int value;

    private Module(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

  public enum ModuleDependent implements Flags {
    ACC_TRANSITIVE(0x0020),
    ACC_STATIC_PHASE(0x0040),
    ACC_SYNTHETIC(0x1000),
    ACC_MANDATED(0x8000);

    final int value;

    private ModuleDependent(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }


  public enum Parameter implements Flags {
    ACC_FINAL(0x0010),
    ACC_SYNTHETIC(0x1000),
    ACC_MANDATED(0x8000);

    final int value;

    private Parameter(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }
  }

}
