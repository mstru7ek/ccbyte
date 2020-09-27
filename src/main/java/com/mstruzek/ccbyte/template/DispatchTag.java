package com.mstruzek.ccbyte.template;

import com.hubspot.jinjava.doc.annotations.JinjavaDoc;
import com.hubspot.jinjava.doc.annotations.JinjavaParam;
import com.hubspot.jinjava.doc.annotations.JinjavaSnippet;
import com.hubspot.jinjava.interpret.InterpretException;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.tag.Tag;
import com.hubspot.jinjava.tree.TagNode;

@JinjavaDoc(
    value = "Dispatch object dynamically and load corresponding template",
    params = {@JinjavaParam(
        value = "object",
        desc = "Object for which template will be resolved and context loaded from this object.")
    },
    snippets = {
        @JinjavaSnippet(code = "{% dispatch object %} ")
    }
)
public class DispatchTag implements Tag {

  public static final String TAG_NAME = "dispatch";

  @Override
  public String interpret(TagNode tagNode, JinjavaInterpreter interpreter) {
    var object = interpreter.resolveELExpression(tagNode.getHelpers(), tagNode.getLineNumber());
    if (object == null) {
      return "";
    }
    var sb = new StringBuilder();
    try (JinjavaInterpreter.InterpreterScopeClosable scope = interpreter.enterScope()) {
      interpreter.getContext().putAll(ObjectAsMap.wrap(object));
      var templateCode = TemplateUtils.loadTemplate(object.getClass());
      sb.append(interpreter.render(templateCode));
    } catch (Exception e) {
      throw new InterpretException(e.getMessage(), e, tagNode.getLineNumber(), tagNode.getStartPosition());
    }
    return sb.toString();
  }

  @Override
  public String getName() {
    return TAG_NAME;
  }

  @Override
  public String getEndTagName() {
    return null;
  }
}
