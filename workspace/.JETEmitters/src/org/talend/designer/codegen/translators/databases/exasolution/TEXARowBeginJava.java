package org.talend.designer.codegen.translators.databases.exasolution;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TEXARowBeginJava
{
  protected static String nl;
  public static synchronized TEXARowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXARowBeginJava result = new TEXARowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        String dbProperties_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "        String url_";
  protected final String TEXT_5 = " = null;" + NL + "        if(dbProperties_";
  protected final String TEXT_6 = " == null || dbProperties_";
  protected final String TEXT_7 = ".trim().length() == 0) {" + NL + "            url_";
  protected final String TEXT_8 = " = \"jdbc:exa:\" + ";
  protected final String TEXT_9 = " + \":\" + ";
  protected final String TEXT_10 = "+ \";schema=\" + ";
  protected final String TEXT_11 = "; " + NL + "        } else {" + NL + "            url_";
  protected final String TEXT_12 = " = \"jdbc:exa:\" + ";
  protected final String TEXT_13 = " + \":\" + ";
  protected final String TEXT_14 = " + \";schema=\" + ";
  protected final String TEXT_15 = " + \";\" + ";
  protected final String TEXT_16 = ";" + NL + "        }" + NL + "        String dbUser_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL + NL + "        String dbPwd_";
  protected final String TEXT_27 = " = decryptedPassword_";
  protected final String TEXT_28 = ";" + NL + "" + NL + "        java.lang.Class.forName(\"com.exasol.jdbc.EXADriver\");" + NL + "        java.sql.Connection conn_";
  protected final String TEXT_29 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_30 = ",dbUser_";
  protected final String TEXT_31 = ",dbPwd_";
  protected final String TEXT_32 = ");" + NL;
  protected final String TEXT_33 = NL + "            conn_";
  protected final String TEXT_34 = ".setAutoCommit(false);            " + NL + "            int commitEvery_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "            int commitCounter_";
  protected final String TEXT_37 = " = 0;";
  protected final String TEXT_38 = NL + "    java.sql.Statement stmt_";
  protected final String TEXT_39 = " = conn_";
  protected final String TEXT_40 = ".createStatement();    " + NL + "    String query_";
  protected final String TEXT_41 = " = \"\";" + NL + "    boolean whetherReject_";
  protected final String TEXT_42 = " = false;    ";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbschema= ElementParameterParser.getValue(node, "__DB_SCHEMA__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_18);
    
        String passwordFieldName = "__PASS__";
        
    stringBuffer.append(TEXT_19);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
        if(!commitEvery.equals("") && !commitEvery.equals("0")) {
            
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
        }
    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
