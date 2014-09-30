package org.talend.designer.codegen.translators.databases.as400;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAS400RowBeginJava
{
  protected static String nl;
  public static synchronized TAS400RowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAS400RowBeginJava result = new TAS400RowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        java.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "        String dbProperties_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "        String url_";
  protected final String TEXT_8 = " = null;" + NL + "        if(dbProperties_";
  protected final String TEXT_9 = " == null || dbProperties_";
  protected final String TEXT_10 = ".trim().length() == 0) {" + NL + "            url_";
  protected final String TEXT_11 = " = \"jdbc:as400://\" + ";
  protected final String TEXT_12 = " + \"/\" + ";
  protected final String TEXT_13 = ";" + NL + "        } else {" + NL + "            url_";
  protected final String TEXT_14 = " = \"jdbc:as400://\" + ";
  protected final String TEXT_15 = " + \"/\" + ";
  protected final String TEXT_16 = "+ \";\" + ";
  protected final String TEXT_17 = ";" + NL + "        }" + NL + "        String dbUser_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "; ";
  protected final String TEXT_27 = NL + NL + "        String dbPwd_";
  protected final String TEXT_28 = " = decryptedPassword_";
  protected final String TEXT_29 = ";" + NL + "" + NL + "        java.lang.Class.forName(\"com.ibm.as400.access.AS400JDBCDriver\");    " + NL + "        java.sql.Connection conn_";
  protected final String TEXT_30 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_31 = ",dbUser_";
  protected final String TEXT_32 = ",dbPwd_";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "            conn_";
  protected final String TEXT_36 = ".setAutoCommit(false);            " + NL + "            int commitEvery_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";" + NL + "            int commitCounter_";
  protected final String TEXT_39 = " = 0;";
  protected final String TEXT_40 = NL + "\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_41 = " = conn_";
  protected final String TEXT_42 = ".prepareStatement(";
  protected final String TEXT_43 = ");\t";
  protected final String TEXT_44 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_45 = " = conn_";
  protected final String TEXT_46 = ".createStatement();";
  protected final String TEXT_47 = NL + "\tString query_";
  protected final String TEXT_48 = " = \"\";" + NL + "    boolean whetherReject_";
  protected final String TEXT_49 = " = false;    ";
  protected final String TEXT_50 = NL;

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
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbserver = ElementParameterParser.getValue(node, "__DBSERVER__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
    if(("true").equals(useExistingConn)) {
        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
        String conn = "conn_" + connection;
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    
    } else {
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbproperties);
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
        if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
            
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
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_43);
    
	} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
