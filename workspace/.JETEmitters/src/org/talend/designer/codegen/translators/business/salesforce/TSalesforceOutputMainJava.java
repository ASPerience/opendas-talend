package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TSalesforceOutputMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputMainJava result = new TSalesforceOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t    \tString decryptedPwd_";
  protected final String TEXT_3 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_4 = ");" + NL + "\t    ";
  protected final String TEXT_5 = NL + "\t    \tString decryptedPwd_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "    \t";
  protected final String TEXT_8 = NL + "    java.util.Properties props_";
  protected final String TEXT_9 = " = System.getProperties();" + NL + "    props_";
  protected final String TEXT_10 = ".put(\"socksProxyHost\",";
  protected final String TEXT_11 = ");  " + NL + "    props_";
  protected final String TEXT_12 = ".put(\"socksProxyPort\",";
  protected final String TEXT_13 = ");" + NL + "    props_";
  protected final String TEXT_14 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_15 = ");" + NL + "    props_";
  protected final String TEXT_16 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_17 = ");  " + NL + "    ";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + NL + "\t";
  protected final String TEXT_20 = " = null;\t\t\t";
  protected final String TEXT_21 = NL + "///////////////////////\t\t" + NL + "" + NL + "" + NL + "Object[] resultMessageObj_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tjava.util.List<org.apache.axiom.om.OMElement> list_";
  protected final String TEXT_25 = " = new java.util.ArrayList<org.apache.axiom.om.OMElement>();" + NL + "\t\t\t\t//the null value will be updated or inserted,so we can't treat it as key for updating(only Id can be the key) or upserting(Id,external id or indexed id)" + NL + "\t\t\t\tjava.util.List<String> nullList_";
  protected final String TEXT_26 = " = new java.util.ArrayList<String>();\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\torg.apache.axiom.om.OMElement reference_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = " = fac_";
  protected final String TEXT_31 = ".createOMElement(";
  protected final String TEXT_32 = ", null);" + NL + "\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = ".addChild(sforceManagement_";
  protected final String TEXT_36 = ".newOMElement(\"type\",";
  protected final String TEXT_37 = "));";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ".addChild(sforceManagement_";
  protected final String TEXT_44 = ".newOMElement(";
  protected final String TEXT_45 = ",FormatterUtils.format_Date(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = ") ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ".addChild(sforceManagement_";
  protected final String TEXT_55 = ".newOMElement(";
  protected final String TEXT_56 = ",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ")).toString() ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_59 = "   \t\t\t\t" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t    \t\t\tif(";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ".addChild(sforceManagement_";
  protected final String TEXT_72 = ".newOMElement(";
  protected final String TEXT_73 = ",String.valueOf(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ") ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_77 = ".add(reference_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_84 = ".add(sforceManagement_";
  protected final String TEXT_85 = ".newOMElement(\"";
  protected final String TEXT_86 = "\",FormatterUtils.format_Date(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_93 = ".add(sforceManagement_";
  protected final String TEXT_94 = ".newOMElement(\"";
  protected final String TEXT_95 = "\",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ")).toString() ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_98 = "   \t\t\t\t" + NL + "\t\t    \t\t\t";
  protected final String TEXT_99 = NL + "\t\t    \t\t\tif(";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_104 = NL + "\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_108 = ".add(sforceManagement_";
  protected final String TEXT_109 = ".newOMElement(\"";
  protected final String TEXT_110 = "\",String.valueOf(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t    else{" + NL + "\t\t\t\t\t\t\tnullList_";
  protected final String TEXT_115 = ".add(\"";
  protected final String TEXT_116 = "\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t" + NL + " \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_118 = " " + NL + "\t\t\t";
  protected final String TEXT_119 = NL + NL + "resultMessageObj_";
  protected final String TEXT_120 = " = sforceManagement_";
  protected final String TEXT_121 = ".insert(";
  protected final String TEXT_122 = ", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_123 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_124 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_125 = NL + NL + "resultMessageObj_";
  protected final String TEXT_126 = " = sforceManagement_";
  protected final String TEXT_127 = ".update(";
  protected final String TEXT_128 = ", ";
  protected final String TEXT_129 = ".Id, (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_130 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_131 = ".size()]),(String[])nullList_";
  protected final String TEXT_132 = ".toArray(new String[nullList_";
  protected final String TEXT_133 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_134 = " " + NL + "" + NL + "resultMessageObj_";
  protected final String TEXT_135 = " = sforceManagement_";
  protected final String TEXT_136 = ".upsert(";
  protected final String TEXT_137 = ", \"";
  protected final String TEXT_138 = "\", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_139 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_140 = ".size()]),(String[])nullList_";
  protected final String TEXT_141 = ".toArray(new String[nullList_";
  protected final String TEXT_142 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_143 = NL + "    \t\t\t";
  protected final String TEXT_144 = NL + NL + "resultMessageObj_";
  protected final String TEXT_145 = " = sforceManagement_";
  protected final String TEXT_146 = ".delete(";
  protected final String TEXT_147 = ".Id);    \t\t\t" + NL;
  protected final String TEXT_148 = "     \t\t\t" + NL + "    \t\t\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_149 = "++; " + NL;
  protected final String TEXT_150 = NL + "\t\t\t\tjava.util.Map<String,String> resultMessage_";
  protected final String TEXT_151 = " = sforceManagement_";
  protected final String TEXT_152 = ".readResult(resultMessageObj_";
  protected final String TEXT_153 = ");" + NL + "\t\t\t\tif(resultMessage_";
  protected final String TEXT_154 = "!=null){" + NL + "\t\t\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_155 = ".get(\"success\"))){";
  protected final String TEXT_156 = NL + "\t\t\tnb_success_";
  protected final String TEXT_157 = "++;" + NL + "\t\t\t";
  protected final String TEXT_158 = " = new ";
  protected final String TEXT_159 = "Struct();";
  protected final String TEXT_160 = NL + "\t\t\t";
  protected final String TEXT_161 = ".salesforce_id = resultMessage_";
  protected final String TEXT_162 = ".get(\"id\");";
  protected final String TEXT_163 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ";\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t}else{";
  protected final String TEXT_169 = NL + "\t\t\tnb_reject_";
  protected final String TEXT_170 = "++;" + NL + "\t\t\t";
  protected final String TEXT_171 = " = new ";
  protected final String TEXT_172 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_173 = ".errorCode = resultMessage_";
  protected final String TEXT_174 = ".get(\"StatusCode\");" + NL + "\t\t\t";
  protected final String TEXT_175 = ".errorFields = resultMessage_";
  protected final String TEXT_176 = ".get(\"Fields\");" + NL + "\t\t\t";
  protected final String TEXT_177 = ".errorMessage = resultMessage_";
  protected final String TEXT_178 = ".get(\"Message\");";
  protected final String TEXT_179 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ";\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_185 = "\t";
  protected final String TEXT_186 = NL + "\t\t\tnb_success_";
  protected final String TEXT_187 = "++;" + NL + "\t\t\t";
  protected final String TEXT_188 = " = new ";
  protected final String TEXT_189 = "Struct();";
  protected final String TEXT_190 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = ";\t\t\t";
  protected final String TEXT_195 = "\t\t \t";
  protected final String TEXT_196 = "\t\t\t    \t\t\t" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_197 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();    	

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

String action = ElementParameterParser.getValue(node, "__ACTION__");
String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");

boolean retreiveInsertID = ("true").equals(ElementParameterParser.getValue(node, "__RETREIVE_INSERT_ID__"));
boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));

boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));

//var for upsert(contain upsert by relationship)
String upsertkey = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
List<Map<String, String>> relationshipMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__UPSERT_RELATION__");

    stringBuffer.append(TEXT_1);
    
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	if(!useOAuth && useProxy){
	    String passwordFieldName = "__PROXY_PASSWORD__";
	    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
	    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_4);
    
	    } else {
	    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    
    	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    
if ("CustomModule".equals(modulename)) {
	//modulename = customModulename; 
	modulename = customModulename;
}else{
	modulename = "\""+modulename+"\"";
}

boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if(outgoingConns!=null){
	for (int i=0;i<outgoingConns.size();i++) {
    IConnection outgoingConn = outgoingConns.get(i);
    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_20);
    
    	}
    }
}
    	
List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
 if ("insert".equals(action) || "update".equals(action) || "upsert".equals(action)) {//************

    stringBuffer.append(TEXT_23);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5  			

  			        
    				IMetadataColumn column = columns.get(i);
    				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				
    				boolean generateFinished = false;
    				if("upsert".equals(action) && (relationshipMappings.size() > 0)) {//TD512
    					int j = 0;
						for(Map<String,String> row : relationshipMappings) {
							String columnName = row.get("COLUMN_NAME");
							if(columnName.equals(column.getLabel())) {
								j++;
								String loookupFieldName = row.get("LOOKUP_FIELD_NAME");
								String externalIdFromLookupField = row.get("LOOKUP_FIELD_EXTERNAL_ID_NAME");
								String moduleNameOfLookupField = row.get("LOOKUP_FIELD_MODULE_NAME");
								generateFinished = true;

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(loookupFieldName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(moduleNameOfLookupField);
    stringBuffer.append(TEXT_37);
    
								if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_48);
    
								} else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_58);
    
								} else {//TD1024

    stringBuffer.append(TEXT_59);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_64);
    }else{
    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_75);
    
								}////TD1024

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_80);
    
							}
						}
    				}//TD512
    				
    				//make sure to filter the schema "Id", when updating (but not when upserting)
  			        if(("Id".equals(column.getLabel()) && (!("upsert".equals(action)) || ("upsert".equals(action) && !"Id".equals(upsertkey)))) || generateFinished) continue;
    				
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_89);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    				
					} else {//others
						

    stringBuffer.append(TEXT_98);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    }else{
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    				
					}

    stringBuffer.append(TEXT_113);
    if(!ignoreNullValue && !(("Id".equals(column.getLabel()) || upsertkey.equals(column.getLabel())) && ("upsert".equals(action)))){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    
				}//5	

    stringBuffer.append(TEXT_118);
    
 if ("insert".equals(action)) {//#######

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
	} else if ("update".equals(action)) {//#######

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
    } else if ("upsert".equals(action)) {//#######

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(upsertkey);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
    }//#######

    stringBuffer.append(TEXT_143);
    
	} else if ("delete".equals(action)) {//*************	

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    
  }//************

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
	if(!extendedInsert){ 

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
			if (connsSuccess != null && connsSuccess.size() == 1) {
				IConnection connSuccess = connsSuccess.get(0);
				if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_159);
    
					if(retreiveInsertID&&"insert".equals(action)){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
					}

    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_168);
    
			if (connsReject != null && connsReject.size() == 1) {
				IConnection connReject = connsReject.get(0);
				if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_184);
    
	}else{//batch start

    stringBuffer.append(TEXT_185);
    
			if (connsSuccess != null && connsSuccess.size() == 1) {
				IConnection connSuccess = connsSuccess.get(0);
				if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_189);
    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_194);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_195);
    
	}  //batch end

    stringBuffer.append(TEXT_196);
    
    		}//4
    	}//3
    }//2
}//1


    stringBuffer.append(TEXT_197);
    return stringBuffer.toString();
  }
}
