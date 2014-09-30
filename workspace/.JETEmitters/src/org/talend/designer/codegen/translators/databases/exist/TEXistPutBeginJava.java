package org.talend.designer.codegen.translators.databases.exist;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TEXistPutBeginJava
{
  protected static String nl;
  public static synchronized TEXistPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXistPutBeginJava result = new TEXistPutBeginJava();
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
  protected final String TEXT_25 = NL + "\tint nb_file_";
  protected final String TEXT_26 = " = 0;" + NL + "    java.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_27 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_28 = NL + "\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = ".put(";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ");\t\t" + NL + " \t\tlist_";
  protected final String TEXT_35 = ".add(map_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = "\t" + NL + "" + NL + "\t\tString localdir_";
  protected final String TEXT_39 = "  = ";
  protected final String TEXT_40 = ";\t" + NL + "\t\tfor(java.util.Map<String, String> map_";
  protected final String TEXT_41 = " : list_";
  protected final String TEXT_42 = "){";

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
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
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
    
    for(int i=0; i<files.size(); i++){
		Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(line.get("FILEMASK"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(line.get("NEWNAME"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
