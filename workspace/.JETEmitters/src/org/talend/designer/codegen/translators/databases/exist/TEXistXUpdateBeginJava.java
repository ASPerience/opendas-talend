package org.talend.designer.codegen.translators.databases.exist;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TEXistXUpdateBeginJava
{
  protected static String nl;
  public static synchronized TEXistXUpdateBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXistXUpdateBeginJava result = new TEXistXUpdateBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\torg.xmldb.api.base.Collection col_";
  protected final String TEXT_3 = " = (org.xmldb.api.base.Collection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "\t\tClass cl_";
  protected final String TEXT_6 = " = Class.forName(";
  protected final String TEXT_7 = ");" + NL + "\t    org.xmldb.api.base.Database database_";
  protected final String TEXT_8 = " = (org.xmldb.api.base.Database) cl_";
  protected final String TEXT_9 = ".newInstance();" + NL + "\t    database_";
  protected final String TEXT_10 = ".setProperty(\"create-database\", \"true\");" + NL + "\t    org.xmldb.api.DatabaseManager.registerDatabase(database_";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "\t    org.xmldb.api.base.Collection col_";
  protected final String TEXT_20 = " = org.xmldb.api.DatabaseManager.getCollection(";
  protected final String TEXT_21 = " + ";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ",decryptedPassword_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\torg.xmldb.api.modules.XUpdateQueryService service_";
  protected final String TEXT_26 = " = (org.xmldb.api.modules.XUpdateQueryService) col_";
  protected final String TEXT_27 = ".getService(\"XUpdateQueryService\", \"1.0\");" + NL + "\tjava.io.File file_";
  protected final String TEXT_28 = " = new java.io.File(";
  protected final String TEXT_29 = ");" + NL + "\tjava.io.BufferedReader br_";
  protected final String TEXT_30 = " = new java.io.BufferedReader(new java.io.FileReader(file_";
  protected final String TEXT_31 = "));" + NL + "\tchar[] characters_";
  protected final String TEXT_32 = " = new char[new Long(file_";
  protected final String TEXT_33 = ".length()).intValue()];" + NL + "\tbr_";
  protected final String TEXT_34 = ".read(characters_";
  protected final String TEXT_35 = ", 0, new Long(file_";
  protected final String TEXT_36 = ".length()).intValue());" + NL + "\tbr_";
  protected final String TEXT_37 = ".close();" + NL + "\tString xUpdateModifications_";
  protected final String TEXT_38 = " = new String(characters_";
  protected final String TEXT_39 = ");" + NL + "\tservice_";
  protected final String TEXT_40 = ".update(xUpdateModifications_";
  protected final String TEXT_41 = ");";

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
	String updateFile = ElementParameterParser.getValue(node, "__UPDATEFILE__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)){
		String col= "col_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(col);
    stringBuffer.append(TEXT_4);
    
	}else{

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driver);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(updateFile);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
