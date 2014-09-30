package org.talend.designer.codegen.translators.business.sap;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPOutputBeginJava
{
  protected static String nl;
  public static synchronized TSAPOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPOutputBeginJava result = new TSAPOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_13 = " = null;" + NL + "\t";
  protected final String TEXT_14 = "\t    " + NL + "\t\t  client_";
  protected final String TEXT_15 = " = (com.sap.mw.jco.JCO.Client)globalMap.get(\"conn_";
  protected final String TEXT_16 = "\");\t" + NL + "\t";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = "    " + NL + "\t\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\t  \tclient_";
  protected final String TEXT_19 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_20 = ",      // SAP client" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_21 = ",   \t// userid" + NL + "\t\t\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_22 = ",    // password" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_23 = ",    // language" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_24 = ",    // host name" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_25 = " );      // system number" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\t//Create a client connection to Message Server " + NL + "\t\t\tclient_";
  protected final String TEXT_27 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_28 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_29 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_30 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_31 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_32 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_33 = ",    // system ID,defined in sapmsg.ini" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_34 = " );  // group name    " + NL + "\t\t";
  protected final String TEXT_35 = "\t        \t\t\t\t " + NL + "\t\t// Open the connection" + NL + "\t\tclient_";
  protected final String TEXT_36 = ".connect();" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\tclient_";
  protected final String TEXT_38 = ".setSapGui(2);" + NL + "\t\t";
  protected final String TEXT_39 = NL + "\t";
  protected final String TEXT_40 = " \t" + NL + "\tresourceMap.put(\"conn_";
  protected final String TEXT_41 = "\", client_";
  protected final String TEXT_42 = ");" + NL + "      " + NL + "    com.sap.mw.jco.IRepository repository_";
  protected final String TEXT_43 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_44 = ");" + NL + "" + NL + "    com.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_45 = " = repository_";
  protected final String TEXT_46 = ".getFunctionTemplate(";
  protected final String TEXT_47 = ");" + NL + "" + NL + "\tif(functionTemplate_";
  protected final String TEXT_48 = " == null){" + NL + "\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_49 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_50 = " + \".\");" + NL + "\t}      " + NL + "\t" + NL + "    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_51 = " = functionTemplate_";
  protected final String TEXT_52 = ".getFunction();" + NL + "" + NL + "    com.sap.mw.jco.JCO.ParameterList importParameterList_";
  protected final String TEXT_53 = " = function_";
  protected final String TEXT_54 = ".getImportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList exportParameterList_";
  protected final String TEXT_55 = " = function_";
  protected final String TEXT_56 = ".getExportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList tableParameterList_";
  protected final String TEXT_57 = " = function_";
  protected final String TEXT_58 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.mw.jco.JCO.Structure input_structure_";
  protected final String TEXT_59 = "=null;" + NL + "    com.sap.mw.jco.JCO.Table input_table_";
  protected final String TEXT_60 = "=null; " + NL + "    com.sap.mw.jco.JCO.Table table_input_";
  protected final String TEXT_61 = "=null; ";
  protected final String TEXT_62 = NL + "\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_63 = " = null;" + NL + "\t";
  protected final String TEXT_64 = "\t" + NL + "\t\tdest_";
  protected final String TEXT_65 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"conn_";
  protected final String TEXT_66 = "\");";
  protected final String TEXT_67 = " " + NL + "                                        if(dest_";
  protected final String TEXT_68 = " == null){ " + NL + "                                                dest_";
  protected final String TEXT_69 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_70 = "); " + NL + "                                        } ";
  protected final String TEXT_71 = " " + NL + "\t";
  protected final String TEXT_72 = " " + NL + "                                dest_";
  protected final String TEXT_73 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_74 = "); ";
  protected final String TEXT_75 = " " + NL + "                        if(dest_";
  protected final String TEXT_76 = " == null){ ";
  protected final String TEXT_77 = " " + NL + "                                org.talend.sap.TalendDestinationData destinationData_";
  protected final String TEXT_78 = " = null; ";
  protected final String TEXT_79 = " " + NL + "                                        destinationData_";
  protected final String TEXT_80 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_83 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_90 = "); ";
  protected final String TEXT_91 = "                       " + NL + "                                        destinationData_";
  protected final String TEXT_92 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_95 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = NL + "                                                                                                                                                                                ";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = NL + "                                                                                                                                                                ";
  protected final String TEXT_104 = " ); ";
  protected final String TEXT_105 = " " + NL + "                            org.talend.sap.TalendDestinationDataProvider destinationDataProvider_";
  protected final String TEXT_106 = " = org.talend.sap.TalendDestinationDataProvider.getInstance(); " + NL + "                            destinationDataProvider_";
  protected final String TEXT_107 = ".addDestination(\"SAP_SERVER_";
  protected final String TEXT_108 = "\", destinationData_";
  protected final String TEXT_109 = "); ";
  protected final String TEXT_110 = " " + NL + "                            destinationDataProvider_";
  protected final String TEXT_111 = ".getDestinationProperties(\"SAP_SERVER_";
  protected final String TEXT_112 = "\").setProperty(com.sap.conn.jco.ext.DestinationDataProvider.JCO_USE_SAPGUI, \"2\"); " + NL + "                                com.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\"); ";
  protected final String TEXT_113 = " " + NL + "                            try { " + NL + "                                com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(destinationDataProvider_";
  protected final String TEXT_114 = "); " + NL + "                                } catch (java.lang.IllegalStateException ex) { " + NL + "                                        //ignore if the provider already registered. " + NL + "                            } " + NL + "                            dest_";
  protected final String TEXT_115 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(\"SAP_SERVER_";
  protected final String TEXT_116 = "\"); " + NL + "                            // Begins the stateful call sequence for calls to the specified destination. " + NL + "                                com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_117 = "); ";
  protected final String TEXT_118 = " " + NL + "                        } ";
  protected final String TEXT_119 = " " + NL + "\t";
  protected final String TEXT_120 = " " + NL + "\tresourceMap.put(\"conn_";
  protected final String TEXT_121 = "\", dest_";
  protected final String TEXT_122 = ");" + NL + "\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_123 = " = dest_";
  protected final String TEXT_124 = ".getRepository();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_125 = " = repository_";
  protected final String TEXT_126 = ".getFunctionTemplate(";
  protected final String TEXT_127 = ");" + NL + "\tif(functionTemplate_";
  protected final String TEXT_128 = " == null){" + NL + "\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_129 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_130 = " + \".\");" + NL + "\t}  " + NL + "\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_131 = " = functionTemplate_";
  protected final String TEXT_132 = ".getFunction();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoParameterList importParameterList_";
  protected final String TEXT_133 = " = function_";
  protected final String TEXT_134 = ".getImportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList exportParameterList_";
  protected final String TEXT_135 = " = function_";
  protected final String TEXT_136 = ".getExportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList tableParameterList_";
  protected final String TEXT_137 = " = function_";
  protected final String TEXT_138 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.conn.jco.JCoStructure input_structure_";
  protected final String TEXT_139 = "=null;" + NL + "    com.sap.conn.jco.JCoTable input_table_";
  protected final String TEXT_140 = "=null; " + NL + "    com.sap.conn.jco.JCoTable table_input_";
  protected final String TEXT_141 = "=null; ";
  protected final String TEXT_142 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getIncomingConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ( metadatas != null && metadatas.size() > 0 ) {
		metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn == null || firstColumnList == null)
	{
		return "";
	}

    stringBuffer.append(TEXT_3);
    
boolean startIterate = false;
String firstDataConnName = firstDataConn.getName();

String client = ElementParameterParser.getValue(node, "__CLIENT__");
String userid = ElementParameterParser.getValue(node, "__USERID__");
String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");

String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");

String functionName = ElementParameterParser.getValue(node, "__SAP_FUNCTION__");

String iterate_out_type = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TYPE__");
String iterate_out_tablename = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TABLENAME__");
boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String version = "sapjco.jar";
if(useExistingConn){
    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
    	if (targetNode.getUniqueName().equals(connection)) {
	      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
	    }
    }
}else{
	version = ElementParameterParser.getValue(node, "__DB_VERSION__");
}

String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_4);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if(useExistingConn){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append(TEXT_17);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_25);
    }else{
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    if(useFtpHttp){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if(useExistingConn){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_66);
           
                        INode connectionNode = null;  
                        for (INode processNode : node.getProcess().getGeneratingNodes()) {  
                                if(connection.equals(processNode.getUniqueName())) {  
                                        connectionNode = processNode;  
                                        break;  
                                }  
                        }  
                        boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__")); 
                        if(specify_alias){ 
                                String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__"); 
                                if(null != alias && !("".equals(alias))){ 

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_70);
     
                                } 
                        } 

    stringBuffer.append(TEXT_71);
    }else{
     
                boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__")); 
                if(specify_alias){ 
                        String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__"); 
                        if(null != alias && !("".equals(alias))){ 

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_74);
     
                        } 

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
     
                } 

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_90);
    }else{
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    if(useFtpHttp){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
     
                if(specify_alias){ 

    stringBuffer.append(TEXT_118);
     
                } 

    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    return stringBuffer.toString();
  }
}
