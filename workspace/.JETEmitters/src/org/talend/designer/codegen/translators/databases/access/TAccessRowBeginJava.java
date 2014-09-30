package org.talend.designer.codegen.translators.databases.access;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAccessRowBeginJava
{
  protected static String nl;
  public static synchronized TAccessRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAccessRowBeginJava result = new TAccessRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "boolean whetherReject_";
  protected final String TEXT_3 = " = false;" + NL + "java.sql.Connection conn_";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "\tconn_";
  protected final String TEXT_6 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_7 = "\");" + NL + "\t";
  protected final String TEXT_8 = "\t" + NL + "java.lang.Class.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");" + NL;
  protected final String TEXT_9 = NL + "\tString url_";
  protected final String TEXT_10 = " = \"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=\" + ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "\tString url_";
  protected final String TEXT_13 = " = \"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=\" + ";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "\tString userName_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_18 = NL + "\t" + NL + "\t";
  protected final String TEXT_19 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "; ";
  protected final String TEXT_25 = NL + "  \t" + NL + "\t" + NL + "\tString password_";
  protected final String TEXT_26 = " = decryptedPassword_";
  protected final String TEXT_27 = ";" + NL;
  protected final String TEXT_28 = NL + "\tconn_";
  protected final String TEXT_29 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_30 = ", userName_";
  protected final String TEXT_31 = ", password_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\tString atnParams_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\tatnParams_";
  protected final String TEXT_36 = " = atnParams_";
  protected final String TEXT_37 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_38 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_39 = ".put(\"user\",userName_";
  protected final String TEXT_40 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_41 = ".put(\"password\",password_";
  protected final String TEXT_42 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_43 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_44 = ".getBytes()));" + NL + "  " + NL + "\tconn_";
  protected final String TEXT_45 = " =  java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_46 = ", atnParamsPrope_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t" + NL + "\tint commitEvery_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ";" + NL + "\t" + NL + "\tint commitCounter_";
  protected final String TEXT_52 = " = 0;" + NL + "\t" + NL + "\tconn_";
  protected final String TEXT_53 = ".setAutoCommit(false);" + NL + "\t";
  protected final String TEXT_54 = NL;
  protected final String TEXT_55 = NL + "\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_56 = " = conn_";
  protected final String TEXT_57 = ".prepareStatement(";
  protected final String TEXT_58 = ");\t";
  protected final String TEXT_59 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_60 = " = conn_";
  protected final String TEXT_61 = ".createStatement();";
  protected final String TEXT_62 = NL + "String query_";
  protected final String TEXT_63 = " = \"\";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	
	String username = ElementParameterParser.getValue(node, "__USER__");
	
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
if(useExistingConnection) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_7);
    
} else {   
    
    stringBuffer.append(TEXT_8);
    if ("Access_2003".equalsIgnoreCase(dbversion)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_11);
    
}else if ("Access_2007".equalsIgnoreCase(dbversion)) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_14);
    
}
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_17);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_18);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	}

    stringBuffer.append(TEXT_48);
    
	}

    
if(!useExistingConnection) {
	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
	}
}

    stringBuffer.append(TEXT_54);
    
	if(usePrepareStatement){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_58);
    
	}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
	}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
