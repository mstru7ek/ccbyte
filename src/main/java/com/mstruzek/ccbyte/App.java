package com.mstruzek.ccbyte;

import com.mstruzek.ccbyte.core.ClassFileLoader;
import com.mstruzek.ccbyte.template.Template;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class App {


  public static void main(String[] args) throws IOException, URISyntaxException, NoSuchFieldException {

    var resourcePath = Paths.get(ClassLoader.getSystemClassLoader().getResource("com/mstruzek/ccbyte/test/Test.class").toURI());
//    var resourcePath = Paths.get(ClassLoader.getSystemClassLoader().getResource("com/mstruzek/ccbyte/test/T1.class").toURI());
    ClassFileLoader classFileLoader = new ClassFileLoader(resourcePath);
    classFileLoader.read();

    Template template = new Template();
    String classFileHtml = template.process(classFileLoader);
    System.out.println(classFileHtml);

    var f = new RandomAccessFile("index2.html", "rw");
    f.write(classFileHtml.getBytes());
    f.close();

  }
}
