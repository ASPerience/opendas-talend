package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TOracleSPBeginJava
{
  protected static String nl;
  public static synchronized TOracleSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSPBeginJava result = new TOracleSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t";
  protected final String TEXT_5 = NL + "\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tString connectionString_";
  protected final String TEXT_7 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_8 = " + \":\" + ";
  protected final String TEXT_9 = " + \":\" + ";
  protected final String TEXT_10 = ";" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\tString connectionString_";
  protected final String TEXT_12 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_13 = " + \")(port=\" + ";
  protected final String TEXT_14 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_15 = " + \")))\";" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t    String connectionString_";
  protected final String TEXT_17 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_18 = ";" + NL + "\t    ";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_21 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\tString atnParams_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";" + NL + "\tatnParams_";
  protected final String TEXT_28 = " = atnParams_";
  protected final String TEXT_29 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_30 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_31 = ".put(\"user\",";
  protected final String TEXT_32 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_33 = ".put(\"password\",";
  protected final String TEXT_34 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_35 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_36 = ".getBytes()));" + NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_37 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_38 = ", atnParamsPrope_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t" + NL + "\t";
  protected final String TEXT_41 = NL + "\tjava.sql.Statement stmtNLS_";
  protected final String TEXT_42 = " = connection_";
  protected final String TEXT_43 = ".createStatement();";
  protected final String TEXT_44 = "\t" + NL + "\t\tstmtNLS_";
  protected final String TEXT_45 = ".execute(\"ALTER SESSION SET NLS_LANGUAGE=\" +\"";
  protected final String TEXT_46 = "\" );";
  protected final String TEXT_47 = "\t" + NL + "\t\tstmtNLS_";
  protected final String TEXT_48 = ".execute(\"ALTER SESSION SET NLS_TERRITORY=\" +\"";
  protected final String TEXT_49 = "\" );";
  protected final String TEXT_50 = NL + NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_51 = " = connection_";
  protected final String TEXT_52 = ".prepareCall(\"{";
  protected final String TEXT_53 = "call \" + ";
  protected final String TEXT_54 = " + \"(";
  protected final String TEXT_55 = "?";
  protected final String TEXT_56 = ",?";
  protected final String TEXT_57 = ")}\");" + NL + "" + NL + "java.sql.Timestamp tmpDate_";
  protected final String TEXT_58 = ";" + NL + "String tmpString_";
  protected final String TEXT_59 = ";";
  protected final String TEXT_60 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd  = ElementParameterParser.getValue(node, "__PASS__");
	String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
	boolean isFunction = ("true").equals(ElementParameterParser.getValue(node, "__IS_FUNCTION__"));
	List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");
	boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

	String nlsLanguage = ElementParameterParser.getValue(node, "__NLS_LANGUAGE__");
	String nlsTerritory = ElementParameterParser.getValue(node, "__NLS_TERRITORY__");

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
    
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	if (("ORACLE_SID").equals(connectionType)) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    
	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_15);
    
	} else if(("ORACLE_OCI").equals(connectionType)) {
	    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_24);
    
	} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbpwd);
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
    
	}

    stringBuffer.append(TEXT_40);
    
}


    	
	if (!("NONE").equals(nlsLanguage) || !("NONE").equals(nlsTerritory) ) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		if(!("NONE").equals(nlsLanguage)){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(nlsLanguage);
    stringBuffer.append(TEXT_46);
    
		}
		if(!("NONE").equals(nlsTerritory)){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(nlsTerritory);
    stringBuffer.append(TEXT_49);
    
		}
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_53);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_54);
    
boolean isFirstArg = true;
for (int i = 0; i < spArgs.size(); i++) {
	if(isFirstArg){
		
    stringBuffer.append(TEXT_55);
    
		isFirstArg=false;
	}else{
		
    stringBuffer.append(TEXT_56);
    
	}
}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}
