package org.talend.designer.codegen.translators.databases.interbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TInterbaseRowBeginJava
{
  protected static String nl;
  public static synchronized TInterbaseRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInterbaseRowBeginJava result = new TInterbaseRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        java.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "        java.lang.Class.forName(\"";
  protected final String TEXT_6 = "\");        " + NL + "        String url_";
  protected final String TEXT_7 = " = \"jdbc:interbase://\" + ";
  protected final String TEXT_8 = " + \"/\" + ";
  protected final String TEXT_9 = ";        " + NL + "        String userName_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";        " + NL + "        ";
  protected final String TEXT_12 = NL + "        ";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "          " + NL + "        " + NL + "        String password_";
  protected final String TEXT_20 = " = decryptedPassword_";
  protected final String TEXT_21 = ";        " + NL + "        java.sql.Connection conn_";
  protected final String TEXT_22 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_23 = ",userName_";
  protected final String TEXT_24 = ",password_";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "            conn_";
  protected final String TEXT_28 = ".setAutoCommit(false);            " + NL + "            int commitEvery_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";            " + NL + "            int commitCounter_";
  protected final String TEXT_31 = " = 0;    ";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_34 = " = conn_";
  protected final String TEXT_35 = ".prepareStatement(";
  protected final String TEXT_36 = ");\t";
  protected final String TEXT_37 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_38 = " = conn_";
  protected final String TEXT_39 = ".createStatement();";
  protected final String TEXT_40 = NL + "String query_";
  protected final String TEXT_41 = " = \"\";" + NL + "    boolean whetherReject_";
  protected final String TEXT_42 = " = false;   ";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String host =  ElementParameterParser.getValue(node, "__HOST__");
	
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	
	String username = ElementParameterParser.getValue(node, "__USER__");
	
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
    String javaDbDriver   = "interbase.interclient.Driver";  
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    
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
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_11);
    
        String passwordFieldName = "__PASS__";
        
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
    
    }
    
    stringBuffer.append(TEXT_26);
    
    if(!("true").equals(useExistingConn)) {
        if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
        }
    }
    
    stringBuffer.append(TEXT_32);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_36);
    
	} else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
	}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
