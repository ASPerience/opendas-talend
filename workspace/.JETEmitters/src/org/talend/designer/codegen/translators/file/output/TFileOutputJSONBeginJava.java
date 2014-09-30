package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputJSONBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputJSONBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputJSONBeginJava result = new TFileOutputJSONBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "java.io.File file_";
  protected final String TEXT_4 = " = new java.io.File(";
  protected final String TEXT_5 = ");" + NL + "java.io.File dir_";
  protected final String TEXT_6 = " = file_";
  protected final String TEXT_7 = ".getParentFile();";
  protected final String TEXT_8 = NL + "\tif(dir_";
  protected final String TEXT_9 = "!=null && !dir_";
  protected final String TEXT_10 = ".exists()){" + NL + "\t\tdir_";
  protected final String TEXT_11 = ".mkdirs();" + NL + "\t}";
  protected final String TEXT_12 = NL + "java.io.PrintWriter out";
  protected final String TEXT_13 = " = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(";
  protected final String TEXT_14 = ")));" + NL + "out";
  protected final String TEXT_15 = ".append(\"{\\\"\" + ";
  protected final String TEXT_16 = " + \"\\\":[\");" + NL + "boolean isFirst_";
  protected final String TEXT_17 = " = true;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
String datablockname = ElementParameterParser.getValue(node, "__DATABLOCKNAME__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean create = "true".equals(ElementParameterParser.getValue(node, "__CREATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
if(create){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(datablockname);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
