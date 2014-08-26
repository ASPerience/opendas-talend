package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputPropertiesEndJava
{
  protected static String nl;
  public static synchronized TFileOutputPropertiesEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPropertiesEndJava result = new TFileOutputPropertiesEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.io.OutputStream fos_";
  protected final String TEXT_2 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_3 = ");" + NL + "\tproperties_";
  protected final String TEXT_4 = ".store(fos_";
  protected final String TEXT_5 = ", \"\");";
  protected final String TEXT_6 = NL + "\tini_";
  protected final String TEXT_7 = ".store();";
  protected final String TEXT_8 = NL + "globalMap.put(\"";
  protected final String TEXT_9 = "_NB_LINE\", tos_count_";
  protected final String TEXT_10 = ");" + NL + NL;
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
String filename = ElementParameterParser.getValue(node,"__FILENAME__");	
if(("PROPERTIES_FORMAT").equals(fileFormat)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
}else if(("INI_FORMAT").equals(fileFormat)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
