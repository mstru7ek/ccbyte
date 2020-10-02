package com.mstruzek.ccbyte.core;

import com.mstruzek.ccbyte.attribute.*;
import com.mstruzek.ccbyte.attribute.Deprecated;
import com.mstruzek.ccbyte.attribute.Module;
import com.mstruzek.ccbyte.attribute.ant.*;
import com.mstruzek.ccbyte.attribute.frame.*;
import com.mstruzek.ccbyte.attribute.frame.verf.*;
import com.mstruzek.ccbyte.annotation.DiscriminationType;
import com.mstruzek.ccbyte.attribute.typeant.*;
import com.mstruzek.ccbyte.base.attribute_info;
import com.mstruzek.ccbyte.cpool.ConstPool;
import com.mstruzek.ccbyte.code.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HierarchyRegister {

  // For each base class store separate register
  private final Map<Class<?>, Register<?>> registers = new HashMap<>();

  // Convert redden value from byte code into value for matcher
  private final Map<Class<?>, Function<Object,Object>> valueConverter = new HashMap<>();

  private final ConstPool constPool;

  public HierarchyRegister(ConstPool constPool) {
    this.constPool = constPool;
    initHierarchyRegister();
    initOpCodeRegister();
  }

  public boolean isBaseClass(Class<?> baseClass) {
    return registers.containsKey(baseClass);
  }

  public DiscriminationType discriminationType(Class<?> baseClass) {
    return registers.get(baseClass).getDiscriminationType();
  }

  public Class<?> findSubClass(Class<?> baseClass, Object tag) {
    Object discriminator = valueConverter.get(baseClass).apply(tag);
    return registers.get(baseClass).findSubclass(discriminator);
  }

  private void registerBase(Class<?> baseClass) {
    registers.put(baseClass, new Register<>(baseClass));
  }

  private void registerSubClass(Class<?> subClass) {
    registers.get(subClass.getSuperclass()).register(subClass);
  }

  private void registerConverter(Class<?> baseClass, Function<Object, Object> converter) {
    valueConverter.put(baseClass, converter);
  }

  private void initHierarchyRegister() {

    // ---- Attributes ----

    registerBase(attribute_info.class);
    registerConverter(attribute_info.class, (tag) -> constPool.resolve((short) tag));

    registerSubClass(AnnotationDefault.class);
    registerSubClass(BootstrapMethods.class);
    registerSubClass(Code.class);
    registerSubClass(ConstantValue.class);
    registerSubClass(Deprecated.class);
    registerSubClass(EnclosingMethod.class);
    registerSubClass(Exceptions.class);
    registerSubClass(InnerClasses.class);
    registerSubClass(LineNumberTable.class);
    registerSubClass(LocalVariableTable.class);
    registerSubClass(LocalVariableTypeTable.class);
    registerSubClass(MethodParameters.class);
    registerSubClass(Module.class);
    registerSubClass(ModuleMainClass.class);
    registerSubClass(ModulePackages.class);
    registerSubClass(NestHost.class);
    registerSubClass(NestMembers.class);
    registerSubClass(RuntimeInvisibleAnnotations.class);
    registerSubClass(RuntimeInvisibleParameterAnnotations.class);
    registerSubClass(RuntimeInvisibleTypeAnnotations.class);
    registerSubClass(RuntimeInvisibleTypeAnnotations.class);
    registerSubClass(RuntimeVisibleAnnotations.class);
    registerSubClass(RuntimeVisibleParameterAnnotations.class);
    registerSubClass(RuntimeVisibleTypeAnnotations.class);
    registerSubClass(Signature.class);
    registerSubClass(SourceDebugExtension.class);
    registerSubClass(SourceFile.class);
    registerSubClass(StackMapTable.class);
    registerSubClass(Synthetic.class);

    // ---- end Attributes ----

    // ---- Stack-Map-Frame -----

    registerBase(stack_map_frame.class);
    registerConverter(stack_map_frame.class, Function.identity());

    registerSubClass(same_frame.class);
    registerSubClass(same_locals_1_stack_item_frame.class);
    registerSubClass(same_locals_1_stack_item_frame_extended.class);
    registerSubClass(chop_frame.class);
    registerSubClass(same_frame_extended.class);
    registerSubClass(append_frame.class);
    registerSubClass(full_frame.class);

    // ---- end  Stack-Map-Frame -----

    // ---- Verification Type Info -----

    registerBase(verification_type_info.class);
    registerConverter(verification_type_info.class, Function.identity());

    registerSubClass(Top_variable_info.class);
    registerSubClass(Integer_variable_info.class);
    registerSubClass(Float_variable_info.class);
    registerSubClass(Long_variable_info.class);
    registerSubClass(Double_variable_info.class);
    registerSubClass(Null_variable_info.class);
    registerSubClass(UninitializedThis_variable_info.class);
    registerSubClass(Object_variable_info.class);
    registerSubClass(Uninitialized_variable_info.class);

    // ---- end Verification Type Info -----


    // ---- Element Value ----

    registerBase(element_value.class);
    registerConverter(element_value.class, o -> (char) ((Byte)o).intValue());

    registerSubClass(const_value_element_value.class);
    registerSubClass(enum_const_element_value.class);
    registerSubClass(class_info_element_value.class);
    registerSubClass(annotation_element_value.class);
    registerSubClass(array_element_value.class);

    // ---- end  Element Value ----

    // ---- Type Annotation ----

    registerBase(type_annotation.class);
    registerConverter(type_annotation.class, Function.identity());

    registerSubClass(catch_target_annotation.class);
    registerSubClass(empty_target_annotation.class);
    registerSubClass(formal_parameter_target_annotation.class);
    registerSubClass(localvar_target_annotation.class);
    registerSubClass(offset_target_annotation.class);
    registerSubClass(supertype_target_annotation.class);
    registerSubClass(throws_target_annotation.class);
    registerSubClass(type_argument_target_annotation.class);
    registerSubClass(type_parameter_bound_target_annotation.class);
    registerSubClass(type_parameter_target_annotation.class);

    // ---- end Type Annotation ----
  }

  private void initOpCodeRegister() {

    registerBase(op_code.class);
    registerConverter(op_code.class, Function.identity());

    Class<?>[] op_categories = new Class[]{
        constants.class,
        loads.class,
        stores.class,
        stack.class,
        math.class,
        conversions.class,
        comparisons.class,
        control.class,
        references.class,
        extended.class,
        reserved.class
    };

    for (Class<?> category : op_categories) {
      for (Class<?> declaredClass : category.getDeclaredClasses()) {
        registerSubClass(declaredClass);
      }
    }
  }
}
