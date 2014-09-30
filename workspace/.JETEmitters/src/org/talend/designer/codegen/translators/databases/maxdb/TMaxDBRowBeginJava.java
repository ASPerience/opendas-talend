package org.talend.designer.codegen.translators.databases.maxdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMaxDBRowBeginJava
{
  protected static String nl;
  public static synchronized TMaxDBRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMaxDBRowBeginJava result = new TMaxDBRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"com.sap.dbtech.jdbc.DriverSapDB\");" + NL + "" + NL + "String url_";
  protected final String TEXT_3 = " = \"jdbc:sapdb://\"+";
  protected final String TEXT_4 = "+\":\"+";
  protected final String TEXT_5 = "+\"/\" + ";
  protected final String TEXT_6 = ";" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + NL + "String dbPwd_";
  protected final String TEXT_17 = " = decryptedPassword_";
  protected final String TEXT_18 = ";" + NL + "" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_19 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_20 = ",dbUser_";
  protected final String TEXT_21 = ",dbPwd_";
  protected final String TEXT_22 = ");" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_23 = " = false;" + NL;
  protected final String TEXT_24 = NL + NL + "int commitEvery_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_27 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_28 = ".setAutoCommit(false);";
  protected final String TEXT_29 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_30 = " = conn_";
  protected final String TEXT_31 = ".prepareStatement(";
  protected final String TEXT_32 = ");\t";
  protected final String TEXT_33 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_34 = " = conn_";
  protected final String TEXT_35 = ".createStatement();";
  protected final String TEXT_36 = NL + "String query_";
  protected final String TEXT_37 = " = \"\";";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbserver = ElementParameterParser.getValue(node, "__DBSERVER__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_8);
    
String passwordFieldName = "__PASS__";

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
}

    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_32);
    
	} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
