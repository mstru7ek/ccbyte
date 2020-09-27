package com.mstruzek.ccbyte.render;

import com.mstruzek.ccbyte.cpool.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.lang.String.format;

public class HtmlFileRender {

  public static final String BASE_PACKAGE_NAME = "com.mstruzek.";
  public static final String DST_RESOURCE_FOLDER_PATTERN = "D:\\workspace\\gradleboy\\src\\main\\resources\\%s.html";

  private static final List<Class<?>> constPools =  Arrays.asList(
      CONSTANT_Class.class,
      CONSTANT_Double.class,
      CONSTANT_Dynamic.class,
      CONSTANT_EMPTY_TAG.class,
      CONSTANT_Fieldref.class,
      CONSTANT_Float.class,
      CONSTANT_Integer.class,
      CONSTANT_InterfaceMethodref.class,
      CONSTANT_InvokeDynamic.class,
      CONSTANT_Long.class,
      CONSTANT_MethodHandle.class,
      CONSTANT_Methodref.class,
      CONSTANT_MethodType.class,
      CONSTANT_Module.class,
      CONSTANT_NameAndType.class,
      CONSTANT_Package.class,
      CONSTANT_String.class,
      CONSTANT_Tag.class,
      CONSTANT_Utf8.class
  );

  public static void main(String[] args) {

//    List<Class<?>> classes = Arrays.asList(
//        catch_target_annotation.class,
//        empty_target_annotation.class,
//        formal_parameter_target_annotation.class,
//        localvar_target_annotation.class,
//        offset_target_annotation.class,
//        path_element.class,
//        supertype_target_annotation.class,
//        throws_target_annotation.class,
//        type_argument_target_annotation.class,
//        type_parameter_bound_target_annotation.class,
//        type_parameter_target_annotation.class,
//        type_path.class,
//        catch_target.class,
//        empty_target.class,
//        formal_parameter_target.class,
//        localvar_target.class,
//        offset_target.class,
//        supertype_target.class,
//        table_entry.class,
//        throws_target.class,
//        type_argument_target.class,
//        type_parameter_bound_target.class,
//        type_parameter_target.class,
//        RuntimeInvisibleAnnotations.class,
//        RuntimeInvisibleParameterAnnotations.class,
//        RuntimeInvisibleTypeAnnotations.class,
//        RuntimeVisibleAnnotations.class,
//        RuntimeVisibleParameterAnnotations.class,
//        RuntimeVisibleTypeAnnotations.class,
//        parameter_annotation.class,
//        Deprecated.class,
//        EnclosingMethod.class,
//        Exceptions.class,
//        LineNumberTable.class,
//        line_info.class,
//        LocalVariableTable.class,
//        line_number_info.class,
//        LocalVariableTypeTable.class,
//        local_variable_type_info.class,
//        MethodParameters.class,
//        parameter_info.class,
//        Module.class,
//        require_element.class,
//        export_element.class,
//        open_element.class,
//        provide_element.class

//        ModuleMainClass.class,
//        ModulePackages.class,
//        NestHost.class,
//        SourceDebugExtension.class,
//        StackMapTable.class,
//        append_frame.class,
//        chop_frame.class,
//        full_frame.class,
//        same_frame.class,
//        same_frame_extended.class,
//        same_locals_1_stack_item_frame.class,
//        same_locals_1_stack_item_frame_extended.class,
//        verification_type_info.class,
//        Double_variable_info.class,
//        Float_variable_info.class,
//        Integer_variable_info.class,
//        Long_variable_info.class,
//        Null_variable_info.class,
//        Object_variable_info.class,
//        Top_variable_info.class,
//        Uninitialized_variable_info.class,
//        UninitializedThis_variable_info.class,
//        Synthetic.class

//    );


/*
    constPools
        .forEach(srcClass -> buildHtmlScaffolding(srcClass, HtmlFileRender::buildPoolConstant));
*/

/*
    List<Class<?>> classes = Arrays.asList(Code.class);
    classes
        .forEach(srcClass -> buildHtmlScaffolding(srcClass, HtmlFileRender::buildHtmlBody));
*/


  }

  private static void buildHtmlScaffolding(Class<?> srcClass, Function<Class<?>, String> transform) {
    var fileName = srcClass.getCanonicalName().substring(BASE_PACKAGE_NAME.length()).replace(".", "\\");
    var outputFile = format(DST_RESOURCE_FOLDER_PATTERN, fileName);

    System.out.println("outputFile = " + outputFile);

    var body = transform.apply(srcClass);

    System.out.println(body);

    createDirIfNotExists(new File(outputFile).toPath().getParent());

    try (var w = new RandomAccessFile(new File(outputFile), "rw")) {
      w.write(body.getBytes());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void createDirIfNotExists(Path parentDir) {
    if (!Files.isDirectory(parentDir, new LinkOption[]{})) {
      try {
        Files.createDirectories(parentDir, new FileAttribute[]{});
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static String buildPoolConstant(Class<?> aClass) {
    var sb = new StringBuilder();
    sb.append("<tr>\n");
    sb.append("\t<td>#{{ loop.getIndex0() }}</td>\n");
    sb.append(format("\t<td>%s</td>\n", aClass.getSimpleName().substring("CONSTANT_".length())));

    if (aClass.getDeclaredFields().length==1 ) {
      var df = aClass.getDeclaredFields()[0];
      sb.append(format("\t<td>#{{ %s }}</td>\n\t<td>{{ %s |R }}</td>\n", df.getName(), df.getName()));
    }  else if (aClass.getDeclaredFields().length==2){
      var df_1 = aClass.getDeclaredFields()[0];
      var df_2 = aClass.getDeclaredFields()[1];
      sb.append(format("\t<td>#{{ %s }}:#{{ %s }}:</td>\n\t<td>{{ %s |R }}:{{ %s |R }}</td>\n", df_1.getName(), df_2.getName(), df_1.getName(), df_2.getName()));
    }
    sb.append("</tr>\n");
    return sb.toString();
  }

  private static String buildHtmlBody(Class<?> srcClass) {
    var sb = new StringBuilder();
    var simpleName = srcClass.getSimpleName();
    var declaredFields = srcClass.getDeclaredFields();
    sb.append(format("<div class=\"%s\">\n",simpleName));
    sb.append(format("\t<h4>%s</h4>\n",simpleName));
    for (Field declaredField : declaredFields) {
      var fieldName = declaredField.getName();
      if (declaredField.getType().isArray()) {
        var componentSimpleName = declaredField.getType().componentType().getSimpleName();
        sb.append(format("\t<div class=\"%s\">\n",fieldName));
        sb.append(format("\t{%% for %s in %s %%}\n",componentSimpleName, fieldName));
        sb.append(format("\t\t{%% dispatch %s %%}\n",componentSimpleName));
        sb.append("\t{% endfor %}\n");
        sb.append("\t</div>\n");
      } else if (declaredField.getType().isPrimitive()) {
        sb.append(format("\t<div class=\"%s\"><span>#{{ %s }}: </span><span>{{ %s |R }}</span></div>\n",fieldName, fieldName, fieldName));
      } else {
        sb.append(format("\t<div class=\"%s\">{%% dispatch %s %%}</div>\n",fieldName, fieldName));
      }
    }
    sb.append("</div>\n");
    return sb.toString();
  }
}
