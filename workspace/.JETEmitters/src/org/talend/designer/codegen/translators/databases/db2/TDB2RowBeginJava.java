package org.talend.designer.codegen.translators.databases.db2;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDB2RowBeginJava
{
  protected static String nl;
  public static synchronized TDB2RowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDB2RowBeginJava result = new TDB2RowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_4 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t    String url_";
  protected final String TEXT_7 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_8 = " + \":\" + ";
  protected final String TEXT_9 = " + \"/\" + ";
  protected final String TEXT_10 = ";    ";
  protected final String TEXT_11 = NL + "\t\tString url_";
  protected final String TEXT_12 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_13 = " + \":\" + ";
  protected final String TEXT_14 = " + \"/\" + ";
  protected final String TEXT_15 = " + \":\" + ";
  protected final String TEXT_16 = ";";
  protected final String TEXT_17 = NL + "    java.lang.Class.forName(\"com.ibm.db2.jcc.DB2Driver\");    " + NL + "    String dbUser_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";    ";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "; ";
  protected final String TEXT_27 = NL + NL + "    String dbPwd_";
  protected final String TEXT_28 = " = decryptedPassword_";
  protected final String TEXT_29 = ";" + NL + "    " + NL + "    java.sql.Connection conn_";
  protected final String TEXT_30 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_31 = ",dbUser_";
  protected final String TEXT_32 = ",dbPwd_";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "        conn_";
  protected final String TEXT_36 = ".setAutoCommit(false);        " + NL + "        int commitEvery_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";" + NL + "        int commitCounter_";
  protected final String TEXT_39 = " = 0;";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_42 = " = conn_";
  protected final String TEXT_43 = ".prepareStatement(";
  protected final String TEXT_44 = ");\t";
  protected final String TEXT_45 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_46 = " = conn_";
  protected final String TEXT_47 = ".createStatement();";
  protected final String TEXT_48 = NL + "String query_";
  protected final String TEXT_49 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_50 = " = false;";
  protected final String TEXT_51 = NL;

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
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    stringBuffer.append(TEXT_2);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
} else {
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    
	} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_16);
    
	}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_19);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_20);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_23);
    } else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
}

    stringBuffer.append(TEXT_34);
    
if(!("true").equals(useExistingConn)) {
    if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){
        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
    }
}

    stringBuffer.append(TEXT_40);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_44);
    
	} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
	}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
