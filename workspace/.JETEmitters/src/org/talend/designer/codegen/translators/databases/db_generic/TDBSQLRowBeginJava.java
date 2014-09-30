package org.talend.designer.codegen.translators.databases.db_generic;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDBSQLRowBeginJava
{
  protected static String nl;
  public static synchronized TDBSQLRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBSQLRowBeginJava result = new TDBSQLRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_3 = " = \"jdbc:odbc:\"+";
  protected final String TEXT_4 = ";" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + NL + "String dbPwd_";
  protected final String TEXT_15 = " = decryptedPassword_";
  protected final String TEXT_16 = ";" + NL + "" + NL + "" + NL + "String dbProperties_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "java.sql.Connection conn_";
  protected final String TEXT_19 = " = null;" + NL + "if(dbProperties_";
  protected final String TEXT_20 = " == null || dbProperties_";
  protected final String TEXT_21 = ".trim().length() == 0) {" + NL + "\tconn_";
  protected final String TEXT_22 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_23 = ",dbUser_";
  protected final String TEXT_24 = ",dbPwd_";
  protected final String TEXT_25 = ");" + NL + "}else{" + NL + "\tdbProperties_";
  protected final String TEXT_26 = " = dbProperties_";
  protected final String TEXT_27 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_28 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_29 = ".put(\"user\",dbUser_";
  protected final String TEXT_30 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_31 = ".put(\"password\",dbPwd_";
  protected final String TEXT_32 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_33 = ".load(new java.io.ByteArrayInputStream(dbProperties_";
  protected final String TEXT_34 = ".getBytes()));" + NL + "\tconn_";
  protected final String TEXT_35 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_36 = ", atnParamsPrope_";
  protected final String TEXT_37 = ");" + NL + "}" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_38 = " = false;" + NL;
  protected final String TEXT_39 = NL + NL + "int commitEvery_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_42 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_43 = ".setAutoCommit(false);";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_46 = " = conn_";
  protected final String TEXT_47 = ".prepareStatement(";
  protected final String TEXT_48 = ");\t";
  protected final String TEXT_49 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_50 = " = conn_";
  protected final String TEXT_51 = ".createStatement();";
  protected final String TEXT_52 = NL + "String query_";
  protected final String TEXT_53 = " = \"\";";
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_6);
    
String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
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
    
if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
}

    stringBuffer.append(TEXT_44);
    
	if(usePrepareStatement){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_48);
    
	}else{

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
	}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
