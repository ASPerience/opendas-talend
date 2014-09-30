package org.talend.designer.codegen.translators.databases.exist;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TEXistConnectionBeginJava
{
  protected static String nl;
  public static synchronized TEXistConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXistConnectionBeginJava result = new TEXistConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tClass cl_";
  protected final String TEXT_3 = " = Class.forName(";
  protected final String TEXT_4 = ");" + NL + "    org.xmldb.api.base.Database database_";
  protected final String TEXT_5 = " = (org.xmldb.api.base.Database) cl_";
  protected final String TEXT_6 = ".newInstance();" + NL + "    database_";
  protected final String TEXT_7 = ".setProperty(\"create-database\", \"true\");" + NL + "    org.xmldb.api.DatabaseManager.registerDatabase(database_";
  protected final String TEXT_8 = ");" + NL + "\t";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "    org.xmldb.api.base.Collection col_";
  protected final String TEXT_17 = " = org.xmldb.api.DatabaseManager.getCollection(";
  protected final String TEXT_18 = " + ";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ",decryptedPassword_";
  protected final String TEXT_21 = ");" + NL + "    globalMap.put(\"col_";
  protected final String TEXT_22 = "\",col_";
  protected final String TEXT_23 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String uri = ElementParameterParser.getValue(node, "__URI__");
	String driver = ElementParameterParser.getValue(node, "__DRIVER__");
	String collection = ElementParameterParser.getValue(node, "__COLLECTION__");
	String user = ElementParameterParser.getValue(node, "__USERNAME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(driver);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	String passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_9);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
