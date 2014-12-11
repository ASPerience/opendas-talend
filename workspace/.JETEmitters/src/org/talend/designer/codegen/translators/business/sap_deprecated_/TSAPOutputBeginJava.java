package org.talend.designer.codegen.translators.business.sap_deprecated_;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

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
  protected final String TEXT_17 = NL + "\t\tjava.util.Properties properties_";
  protected final String TEXT_18 = " = new java.util.Properties();" + NL + "\t\t";
  protected final String TEXT_19 = NL + "    \t\t//Create a client connection to a dedicated R/3 system" + NL + "    \t\tproperties_";
  protected final String TEXT_20 = ".put(\"jco.client.type\", \"3\");" + NL + "    \t\tif (";
  protected final String TEXT_21 = " != null) properties_";
  protected final String TEXT_22 = ".put(\"jco.client.client\", ";
  protected final String TEXT_23 = ");" + NL + "    \t\tif (";
  protected final String TEXT_24 = " != null) properties_";
  protected final String TEXT_25 = ".put(\"jco.client.user\", ";
  protected final String TEXT_26 = ");" + NL + "    \t\tif (decryptedPassword_";
  protected final String TEXT_27 = " != null) properties_";
  protected final String TEXT_28 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_29 = ");" + NL + "    \t\tif (";
  protected final String TEXT_30 = " != null) properties_";
  protected final String TEXT_31 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_32 = ");" + NL + "    \t\tif (";
  protected final String TEXT_33 = " != null) properties_";
  protected final String TEXT_34 = ".put(\"jco.client.ashost\", ";
  protected final String TEXT_35 = ");" + NL + "    \t\tif (";
  protected final String TEXT_36 = " != null) properties_";
  protected final String TEXT_37 = ".put(\"jco.client.sysnr\", ";
  protected final String TEXT_38 = ");\t" + NL + "    \t";
  protected final String TEXT_39 = NL + "    \t\t//Create a client connection to Message Server " + NL + "    \t\tproperties_";
  protected final String TEXT_40 = ".put(\"jco.client.type\", \"3\");" + NL + "            if (";
  protected final String TEXT_41 = " != null) properties_";
  protected final String TEXT_42 = ".put(\"jco.client.client\", ";
  protected final String TEXT_43 = ");" + NL + "    \t\tif (";
  protected final String TEXT_44 = " != null) properties_";
  protected final String TEXT_45 = ".put(\"jco.client.user\", ";
  protected final String TEXT_46 = ");" + NL + "    \t\tif (decryptedPassword_";
  protected final String TEXT_47 = " != null) properties_";
  protected final String TEXT_48 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_49 = ");" + NL + "    \t\tif (";
  protected final String TEXT_50 = " != null) properties_";
  protected final String TEXT_51 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_52 = ");" + NL + "    \t\tif (";
  protected final String TEXT_53 = " != null) properties_";
  protected final String TEXT_54 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_55 = ");" + NL + "    \t\tif (";
  protected final String TEXT_56 = " != null) properties_";
  protected final String TEXT_57 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_58 = ");" + NL + "    \t\tif (";
  protected final String TEXT_59 = " != null) properties_";
  protected final String TEXT_60 = ".put(\"jco.client.group\", ";
  protected final String TEXT_61 = ");" + NL + "    \t";
  protected final String TEXT_62 = NL + "    \t";
  protected final String TEXT_63 = NL + "    \t\tproperties_";
  protected final String TEXT_64 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "    \t\tproperties_";
  protected final String TEXT_65 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_66 = ");" + NL + "    \t\tproperties_";
  protected final String TEXT_67 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_68 = "));" + NL + "    \t\t";
  protected final String TEXT_69 = NL + "        \t\tif(";
  protected final String TEXT_70 = " != null){" + NL + "        \t\t\tproperties_";
  protected final String TEXT_71 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_72 = ");" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_73 = NL + "    \t\t";
  protected final String TEXT_74 = NL + "        \t\tif(";
  protected final String TEXT_75 = " != null){" + NL + "        \t\t\tproperties_";
  protected final String TEXT_76 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_77 = ");" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_78 = NL + "    \t";
  protected final String TEXT_79 = NL + "    \t";
  protected final String TEXT_80 = "\t" + NL + "    \t\tproperties_";
  protected final String TEXT_81 = ".put(";
  protected final String TEXT_82 = " ,";
  protected final String TEXT_83 = ");" + NL + "    \t\t";
  protected final String TEXT_84 = NL + "    \tclient_";
  protected final String TEXT_85 = " = com.sap.mw.jco.JCO.createClient(properties_";
  protected final String TEXT_86 = "); " + NL + "\t\t// Open the connection" + NL + "\t\tclient_";
  protected final String TEXT_87 = ".connect();" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\tclient_";
  protected final String TEXT_89 = ".setSapGui(2);" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t";
  protected final String TEXT_91 = " \t" + NL + "\tresourceMap.put(\"conn_";
  protected final String TEXT_92 = "\", client_";
  protected final String TEXT_93 = ");" + NL + "      " + NL + "    com.sap.mw.jco.IRepository repository_";
  protected final String TEXT_94 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_95 = ");" + NL + "" + NL + "    com.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_96 = " = repository_";
  protected final String TEXT_97 = ".getFunctionTemplate(";
  protected final String TEXT_98 = ");" + NL + "" + NL + "\tif(functionTemplate_";
  protected final String TEXT_99 = " == null){" + NL + "\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_100 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_101 = " + \".\");" + NL + "\t}      " + NL + "\t" + NL + "    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_102 = " = functionTemplate_";
  protected final String TEXT_103 = ".getFunction();" + NL + "" + NL + "    com.sap.mw.jco.JCO.ParameterList importParameterList_";
  protected final String TEXT_104 = " = function_";
  protected final String TEXT_105 = ".getImportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList exportParameterList_";
  protected final String TEXT_106 = " = function_";
  protected final String TEXT_107 = ".getExportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList tableParameterList_";
  protected final String TEXT_108 = " = function_";
  protected final String TEXT_109 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.mw.jco.JCO.Structure input_structure_";
  protected final String TEXT_110 = "=null;" + NL + "    com.sap.mw.jco.JCO.Table input_table_";
  protected final String TEXT_111 = "=null; " + NL + "    com.sap.mw.jco.JCO.Table table_input_";
  protected final String TEXT_112 = "=null; ";
  protected final String TEXT_113 = NL + "\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_114 = " = null;" + NL + "\t";
  protected final String TEXT_115 = "\t" + NL + "\t\tdest_";
  protected final String TEXT_116 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"conn_";
  protected final String TEXT_117 = "\");";
  protected final String TEXT_118 = NL + "\t\t\t\t\tif(dest_";
  protected final String TEXT_119 = " == null){" + NL + "\t\t\t\t\t\tdest_";
  protected final String TEXT_120 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_121 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_122 = NL + "\t";
  protected final String TEXT_123 = NL + "\t\t\t\tdest_";
  protected final String TEXT_124 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\tif(dest_";
  protected final String TEXT_127 = " == null){";
  protected final String TEXT_128 = NL + "\t\t\t\torg.talend.sap.TSAPDestinationData destinationData_";
  protected final String TEXT_129 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_130 = " = new java.util.Properties();" + NL + "    \t\t\t";
  protected final String TEXT_131 = NL + "            \t\tproperties_";
  protected final String TEXT_132 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "            \t\tproperties_";
  protected final String TEXT_133 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_134 = ");" + NL + "            \t\tproperties_";
  protected final String TEXT_135 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_136 = "));" + NL + "            \t\t";
  protected final String TEXT_137 = NL + "                \t\tif(";
  protected final String TEXT_138 = " != null){" + NL + "                \t\t\tproperties_";
  protected final String TEXT_139 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_140 = ");" + NL + "                \t\t}" + NL + "            \t\t";
  protected final String TEXT_141 = NL + "            \t\t";
  protected final String TEXT_142 = NL + "                \t\tif(";
  protected final String TEXT_143 = " != null){" + NL + "                \t\t\tproperties_";
  protected final String TEXT_144 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_145 = ");" + NL + "                \t\t}" + NL + "            \t\t";
  protected final String TEXT_146 = NL + "            \t";
  protected final String TEXT_147 = NL + "\t\t\t\t";
  protected final String TEXT_148 = "\t" + NL + "            \t\tproperties_";
  protected final String TEXT_149 = ".put(";
  protected final String TEXT_150 = " ,";
  protected final String TEXT_151 = ");" + NL + "            \t\t";
  protected final String TEXT_152 = NL + "    \t\t\t";
  protected final String TEXT_153 = NL + "    \t\t\t\tdestinationData_";
  protected final String TEXT_154 = " = new org.talend.sap.TSAPApplicationServerDestData.Builder(";
  protected final String TEXT_155 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_157 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_158 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = ")" + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_163 = ")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "    \t\t\t";
  protected final String TEXT_164 = "\t\t\t" + NL + "    \t\t\t\tdestinationData_";
  protected final String TEXT_165 = " = new org.talend.sap.TSAPMessageServerDestData.Builder(";
  protected final String TEXT_166 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_167 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_168 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_170 = "," + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = "," + NL + "    \t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = ")" + NL + "    \t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_175 = ")" + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "    \t\t\t";
  protected final String TEXT_176 = NL + "    \t\t    ";
  protected final String TEXT_177 = NL + "    \t\t\t\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "    \t\t\t";
  protected final String TEXT_178 = NL + "    \t\t\tdest_";
  protected final String TEXT_179 = " = org.talend.sap.TSAPDestinationFactory.getInstance().getDestination(destinationData_";
  protected final String TEXT_180 = ");" + NL + "\t\t\t    // Begins the stateful call sequence for calls to the specified destination." + NL + "\t\t\t\tcom.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\t\t\t}";
  protected final String TEXT_183 = NL + "\t";
  protected final String TEXT_184 = " " + NL + "\tresourceMap.put(\"conn_";
  protected final String TEXT_185 = "\", dest_";
  protected final String TEXT_186 = ");" + NL + "\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_187 = " = dest_";
  protected final String TEXT_188 = ".getRepository();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_189 = " = repository_";
  protected final String TEXT_190 = ".getFunctionTemplate(";
  protected final String TEXT_191 = ");" + NL + "\tif(functionTemplate_";
  protected final String TEXT_192 = " == null){" + NL + "\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_193 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_194 = " + \".\");" + NL + "\t}  " + NL + "\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_195 = " = functionTemplate_";
  protected final String TEXT_196 = ".getFunction();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoParameterList importParameterList_";
  protected final String TEXT_197 = " = function_";
  protected final String TEXT_198 = ".getImportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList exportParameterList_";
  protected final String TEXT_199 = " = function_";
  protected final String TEXT_200 = ".getExportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList tableParameterList_";
  protected final String TEXT_201 = " = function_";
  protected final String TEXT_202 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.conn.jco.JCoStructure input_structure_";
  protected final String TEXT_203 = "=null;" + NL + "    com.sap.conn.jco.JCoTable input_table_";
  protected final String TEXT_204 = "=null; " + NL + "    com.sap.conn.jco.JCoTable table_input_";
  protected final String TEXT_205 = "=null; ";
  protected final String TEXT_206 = NL;

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
String password = ElementParameterParser.getValue(node, "__PASSWORD__");
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

boolean activeSNC = ("true").equals(ElementParameterParser.getValue(node,"__SNC_ACTIVE__"));
String partnerSNCName = ElementParameterParser.getValue(node,"__SNC_PARTNER_NAME__");
String mySNCName = ElementParameterParser.getValue(node,"__SNC_MY_NAME__");
String sncLevel = ElementParameterParser.getValue(node,"__SNC_LEVEL__");
String sncLibPath = ElementParameterParser.getValue(node,"__SNC_LIB_PATH__");
boolean hasSNCLibPath = sncLibPath != null && !"".equals(sncLibPath);
boolean hasMySNCName = mySNCName != null && !"".equals(mySNCName);    

List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");    

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_38);
    }else{
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    
    	if(activeSNC){
    	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_68);
    if(hasMySNCName){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    
    	}
    	
    stringBuffer.append(TEXT_79);
    
        if(sapProps!=null) {
    		for(Map<String, String> item : sapProps){
    		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_83);
     
    		}
        }
    	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(useFtpHttp){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    if(useExistingConn){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_117);
    	
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

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_121);
    
				}
			}

    stringBuffer.append(TEXT_122);
    }else{
    
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
			if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_125);
    
			}

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
		}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
            	if(activeSNC){
            	
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_136);
    if(hasMySNCName){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    
            	}
            	
    stringBuffer.append(TEXT_147);
    
                if(sapProps!=null) {
            		for(Map<String, String> item : sapProps){
            		
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_151);
     
            		}
                }
            	
    stringBuffer.append(TEXT_152);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_160);
    if(useFtpHttp){
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    }else{
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_172);
    if(useFtpHttp){
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    if(useFtpHttp){
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
		if(specify_alias){

    stringBuffer.append(TEXT_182);
    
		}

    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    return stringBuffer.toString();
  }
}
