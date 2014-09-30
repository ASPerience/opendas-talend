package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileOutputPropertiesBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputPropertiesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPropertiesBeginJava result = new TFileOutputPropertiesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.io.File file_";
  protected final String TEXT_2 = " = new java.io.File(";
  protected final String TEXT_3 = ");" + NL + "java.io.File parent_";
  protected final String TEXT_4 = " = file_";
  protected final String TEXT_5 = ".getParentFile();" + NL + "if(!parent_";
  protected final String TEXT_6 = ".exists()){" + NL + "\tparent_";
  protected final String TEXT_7 = ".mkdirs();" + NL + "}";
  protected final String TEXT_8 = NL + "else{" + NL + "\tif(file_";
  protected final String TEXT_9 = ".exists()){" + NL + "\t\tfile_";
  protected final String TEXT_10 = ".delete();" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL + "file_";
  protected final String TEXT_12 = ".createNewFile();";
  protected final String TEXT_13 = NL + "\tjava.io.InputStream fis_";
  protected final String TEXT_14 = " = new java.io.FileInputStream(file_";
  protected final String TEXT_15 = ");" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_16 = " = new java.util.Properties();" + NL + "\tproperties_";
  protected final String TEXT_17 = ".load(fis_";
  protected final String TEXT_18 = ");" + NL + "\tfis_";
  protected final String TEXT_19 = ".close();";
  protected final String TEXT_20 = NL + "\torg.ini4j.Wini ini_";
  protected final String TEXT_21 = " = new org.ini4j.Wini(new java.io.File(";
  protected final String TEXT_22 = "));" + NL + "\tini_";
  protected final String TEXT_23 = ".getConfig().setFileEncoding(java.nio.charset.Charset.forName(";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
String filename = ElementParameterParser.getValue(node,"__FILENAME__");
String append = ElementParameterParser.getValue(node,"__APPEND__");
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
if(("false").equals(append)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
if(("PROPERTIES_FORMAT").equals(fileFormat)){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
}else if(("INI_FORMAT").equals(fileFormat)){
	

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
