package org.talend.designer.codegen.translators.databases.informix;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TInformixRowBeginJava
{
  protected static String nl;
  public static synchronized TInformixRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInformixRowBeginJava result = new TInformixRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "\tjava.lang.Class.forName(\"com.informix.jdbc.IfxDriver\");" + NL;
  protected final String TEXT_6 = NL + "    String url_";
  protected final String TEXT_7 = " = \"jdbc:informix-sqli://\" + ";
  protected final String TEXT_8 = " + \":\" + ";
  protected final String TEXT_9 = " + \"/\" + ";
  protected final String TEXT_10 = " + \":informixserver=\" + ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "    String url_";
  protected final String TEXT_13 = " = \"jdbc:informix-sqli://\" + ";
  protected final String TEXT_14 = " + \":\" + ";
  protected final String TEXT_15 = " + \"/\" + ";
  protected final String TEXT_16 = " + \":informixserver=\" + ";
  protected final String TEXT_17 = " + \";\" + ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "\tString dbUser_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t";
  protected final String TEXT_22 = NL + NL + "\t";
  protected final String TEXT_23 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = "; ";
  protected final String TEXT_29 = NL + NL + "\tString dbPwd_";
  protected final String TEXT_30 = " = decryptedPassword_";
  protected final String TEXT_31 = ";" + NL + "" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_32 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_33 = ",dbUser_";
  protected final String TEXT_34 = ",dbPwd_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + NL + "boolean whetherReject_";
  protected final String TEXT_37 = " = false;";
  protected final String TEXT_38 = NL + NL + "int commitEvery_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_41 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_42 = ".setAutoCommit(false);";
  protected final String TEXT_43 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_44 = " = conn_";
  protected final String TEXT_45 = ".prepareStatement(";
  protected final String TEXT_46 = ");\t";
  protected final String TEXT_47 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_48 = " = conn_";
  protected final String TEXT_49 = ".createStatement();";
  protected final String TEXT_50 = NL + "String query_";
  protected final String TEXT_51 = " = \"\";";
  protected final String TEXT_52 = NL;

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
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    boolean useTransaction = ("true").equals(ElementParameterParser.getValue(node,"__USE_TRANSACTION__"));
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
    
    boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    
	if (useExistingConnection) {
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		String connectionName = "conn_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    
	} else {

    stringBuffer.append(TEXT_5);
    
		if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbserver);
    stringBuffer.append(TEXT_11);
    
		} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbserver);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_18);
    
		}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_21);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_22);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    } else {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
if(useTransaction && !("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
}

    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_46);
    
	} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
