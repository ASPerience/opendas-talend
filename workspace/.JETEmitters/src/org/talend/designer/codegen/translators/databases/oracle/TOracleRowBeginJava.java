package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOracleRowBeginJava
{
  protected static String nl;
  public static synchronized TOracleRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleRowBeginJava result = new TOracleRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\tconn_";
  protected final String TEXT_5 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = " " + NL + "\t\tif (null == conn_";
  protected final String TEXT_8 = ") {" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_9 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\t\tconn_";
  protected final String TEXT_10 = " = dataSources_";
  protected final String TEXT_11 = ".get(";
  protected final String TEXT_12 = ").getConnection();" + NL + "\t\t\tif (conn_";
  protected final String TEXT_13 = " != null) { " + NL + "\t\t\t\tconn_";
  protected final String TEXT_14 = ".setAutoCommit(";
  protected final String TEXT_15 = ");" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_16 = NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_17 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != dataSources_";
  protected final String TEXT_18 = ") {" + NL + "\t\t\tconn_";
  protected final String TEXT_19 = " = dataSources_";
  protected final String TEXT_20 = ".get(";
  protected final String TEXT_21 = ").getConnection();" + NL + "\t\t} else {";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\t\tjava.lang.Class.forName(\"oracle.jdbc.OracleDriver\");\t" + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t\t\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");\t" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t\tString url_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";        ";
  protected final String TEXT_28 = NL + "\t\t\tString url_";
  protected final String TEXT_29 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_30 = " + \":\" + ";
  protected final String TEXT_31 = " + \":\" + ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\t\tString url_";
  protected final String TEXT_34 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_35 = " + \")(port=\" + ";
  protected final String TEXT_36 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_37 = " + \")))\";";
  protected final String TEXT_38 = NL + "\t\t\tString url_";
  protected final String TEXT_39 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_40 = ";";
  protected final String TEXT_41 = NL + NL + "\t\tString dbUser_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ";" + NL + "\t\t";
  protected final String TEXT_44 = NL + NL + "\t\t";
  protected final String TEXT_45 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_46 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "; ";
  protected final String TEXT_51 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_52 = " = decryptedPassword_";
  protected final String TEXT_53 = ";" + NL;
  protected final String TEXT_54 = NL + "\t\tconn_";
  protected final String TEXT_55 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_56 = ",dbUser_";
  protected final String TEXT_57 = ",dbPwd_";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\tString atnParams_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "\t\tatnParams_";
  protected final String TEXT_62 = " = atnParams_";
  protected final String TEXT_63 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_64 = " = new java.util.Properties();" + NL + "\t\tatnParamsPrope_";
  protected final String TEXT_65 = ".put(\"user\",dbUser_";
  protected final String TEXT_66 = ");" + NL + "\t\tatnParamsPrope_";
  protected final String TEXT_67 = ".put(\"password\",dbPwd_";
  protected final String TEXT_68 = ");" + NL + "\t\tatnParamsPrope_";
  protected final String TEXT_69 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_70 = ".getBytes()));" + NL + "\t\tconn_";
  protected final String TEXT_71 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_72 = ", atnParamsPrope_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t}";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = NL + "        if(conn_";
  protected final String TEXT_77 = ".getAutoCommit()) {" + NL + "            conn_";
  protected final String TEXT_78 = ".setAutoCommit(false);" + NL + "        }        " + NL + "        int commitEvery_";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = ";    " + NL + "        int commitCounter_";
  protected final String TEXT_81 = " = 0;    ";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_84 = " = conn_";
  protected final String TEXT_85 = ".prepareStatement(";
  protected final String TEXT_86 = ");\t";
  protected final String TEXT_87 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_88 = " = conn_";
  protected final String TEXT_89 = ".createStatement();";
  protected final String TEXT_90 = NL + "String query_";
  protected final String TEXT_91 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_92 = " = false;" + NL;
  protected final String TEXT_93 = NL + "\t\tint nb_line_inserted_";
  protected final String TEXT_94 = " = 0;";
  protected final String TEXT_95 = NL + "\t\tint nb_line_update_";
  protected final String TEXT_96 = " = 0;";
  protected final String TEXT_97 = NL + "\t\tint nb_line_deleted_";
  protected final String TEXT_98 = " = 0;";
  protected final String TEXT_99 = NL + NL;
  protected final String TEXT_100 = NL;

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
	String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	
	String use_NB_Line = ElementParameterParser.getValue(node, "__USE_NB_LINE__");
	String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_6);
    	
	INode connectionNode = null; 
	for (INode processNode : node.getProcess().getGeneratingNodes()) { 
		if(connection.equals(processNode.getUniqueName())) { 
			connectionNode = processNode; 
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");
		String autoCommit = "true".equals(ElementParameterParser.getValue(connectionNode, "__AUTO_COMMIT__"))?"true":"false"; 

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_15);
    
	}
} else {
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_21);
    
	}

    stringBuffer.append(TEXT_22);
    if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) ){
    stringBuffer.append(TEXT_23);
    }else {
    stringBuffer.append(TEXT_24);
    }
    
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");
		if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_27);
    
		} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_32);
    
		} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_37);
    
		} else if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_40);
    
		}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_43);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_44);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
		if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
		} else {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
		}
	if(specify_alias){

    stringBuffer.append(TEXT_74);
    
	}
}

    stringBuffer.append(TEXT_75);
    
if(!("true").equals(useExistingConn)) {
    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
    }
}

    stringBuffer.append(TEXT_82);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_86);
    
	} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
	}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    	//feature 0010425
	if ("NB_LINE_INSERTED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
	} else if ("NB_LINE_UPDATED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
	} else if ("NB_LINE_DELETED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
	}//end feature 0010425

    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_100);
    return stringBuffer.toString();
  }
}
