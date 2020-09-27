package com.mstruzek.ccbyte.test;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.out;

public class Templates {

  static class Pair {
    public int id;
    public String value;
    public Pair(int id, String value) {
      this.id = id;
      this.value = value;
    }
    public int getId() { return id; }
    public String getValue() { return value;}
  }

  public static void main(String[] args) throws IOException {

    var cpool = Maps.<String,String>newHashMap();
    cpool.put("A", "Andrzej");
    cpool.put("B", "Barbara");
    cpool.put("C", "Cecylia");

    var jinjava = new Jinjava();

    var ctx = Maps.<String, Object>newHashMap();
    ctx.put("name", "Jared");
    ctx.put("the_list", Arrays.asList(new Pair(1, "A"), new Pair(2, "B"), new Pair(3, "C")));

    var template = Resources.toString(Resources.getResource("my-template.html"), Charsets.UTF_8);

    jinjava.registerFilter(new Filter() {
      @Override
      public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
        if (var == null) {
          return null;
        }
        var value = cpool.get(var.toString());
        return value;
      }

      @Override
      public String getName() {
        return "R";
      }
    });

    var render = jinjava.render(template, ctx);

    out.println(render);

  }
}
