package org.talend.designer.codegen.translators.processing.fields_deprecated_;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TExtractEBCDICFieldsEndJava
{
  protected static String nl;
  public static synchronized TExtractEBCDICFieldsEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractEBCDICFieldsEndJava result = new TExtractEBCDICFieldsEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\",nb_line_";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tlog.info(\"";
  protected final String TEXT_5 = " - Extracted records count: \" + nb_line_";
  protected final String TEXT_6 = " + \" .\");";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
