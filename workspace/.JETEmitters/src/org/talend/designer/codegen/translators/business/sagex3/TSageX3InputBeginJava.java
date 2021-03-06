package org.talend.designer.codegen.translators.business.sagex3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSageX3InputBeginJava
{
  protected static String nl;
  public static synchronized TSageX3InputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSageX3InputBeginJava result = new TSageX3InputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            org.talend.sage.Client client_";
  protected final String TEXT_2 = " = new org.talend.sage.Client();" + NL + "            client_";
  protected final String TEXT_3 = ".ConnectService(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "            client_";
  protected final String TEXT_12 = ".setContext(";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ",decryptedPassword_";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ");" + NL + "" + NL + "            java.util.Map<String,String> keyValues_";
  protected final String TEXT_18 = " = new java.util.HashMap<String,String>();\t\t          ";
  protected final String TEXT_19 = NL + "    " + NL + "                \tkeyValues_";
  protected final String TEXT_20 = ".put(";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = ");" + NL + "    ";
  protected final String TEXT_23 = NL + "\t\t\t\t\tjava.util.List<org.talend.sage.Result> results_";
  protected final String TEXT_24 = " = client_";
  protected final String TEXT_25 = ".query(";
  protected final String TEXT_26 = ",client_";
  protected final String TEXT_27 = ".createCAdxKeyValues(keyValues_";
  protected final String TEXT_28 = "),";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t\tfor(org.talend.sage.Result result_";
  protected final String TEXT_30 = ":results_";
  protected final String TEXT_31 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tjava.util.List<org.talend.sage.Summary> results_";
  protected final String TEXT_33 = " = client_";
  protected final String TEXT_34 = ".querySummary(";
  protected final String TEXT_35 = ",client_";
  protected final String TEXT_36 = ".createCAdxKeyValues(keyValues_";
  protected final String TEXT_37 = "),";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t\tfor(org.talend.sage.Summary result_";
  protected final String TEXT_39 = ":results_";
  protected final String TEXT_40 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\torg.talend.sage.Result result_";
  protected final String TEXT_42 = " = client_";
  protected final String TEXT_43 = ".read(";
  protected final String TEXT_44 = ",client_";
  protected final String TEXT_45 = ".createCAdxKeyValues(keyValues_";
  protected final String TEXT_46 = "));" + NL + "\t\t\t\t\tif(result_";
  protected final String TEXT_47 = " != null){" + NL + "\t\t\t\t";
  protected final String TEXT_48 = "           " + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tif(result_";
  protected final String TEXT_50 = ".getValue(";
  protected final String TEXT_51 = ")!=null){" + NL + "    \t\t\t";
  protected final String TEXT_52 = "    \t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = " = result_";
  protected final String TEXT_55 = ".getListValue(";
  protected final String TEXT_56 = ");" + NL + "    \t\t\t";
  protected final String TEXT_57 = "\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " = result_";
  protected final String TEXT_60 = ".getStringValue(";
  protected final String TEXT_61 = ");" + NL + "    \t\t\t";
  protected final String TEXT_62 = NL + "    \t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = ParserUtils.parseTo_Date(result_";
  protected final String TEXT_65 = ".getStringValue(";
  protected final String TEXT_66 = "), ";
  protected final String TEXT_67 = ");" + NL + "    \t\t\t";
  protected final String TEXT_68 = NL + "    \t\t\t\t\t";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = result_";
  protected final String TEXT_71 = ".getValue(";
  protected final String TEXT_72 = ");" + NL + "    \t\t\t";
  protected final String TEXT_73 = "\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = ParserUtils.parseTo_";
  protected final String TEXT_76 = "(result_";
  protected final String TEXT_77 = ".getStringValue(";
  protected final String TEXT_78 = "));\t" + NL + "    \t\t\t";
  protected final String TEXT_79 = NL + "    \t\t\t}else{" + NL + "    \t\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "    \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + NL + NL + NL + "        ";
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) { //1
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) { //2
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){ //3

            String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
            String user = ElementParameterParser.getValue(node, "__USER__");

            String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
            String poolAlias = ElementParameterParser.getValue(node, "__POOL_ALIAS__");
            String requestConfig = ElementParameterParser.getValue(node, "__REQUEST_CONFIG__");
            String limit = ElementParameterParser.getValue(node, "__LIMIT_SIZE__");
            boolean useKeys = ("true").equals(ElementParameterParser.getValue(node,"__USE_KEYS__"));
            String publicName = ElementParameterParser.getValue(node,"__PUBLICATION_NAME__");
            String action = ElementParameterParser.getValue(node,"__ACTION__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_4);
    
            String passwordFieldName = "__PASSWORD__";
            
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(poolAlias);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(requestConfig);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			if(useKeys || "Read".equals(action)){	
                List<Map<String, String>> keys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEYS__");            
                for(Map<String,String> keyValue:keys){
                	String key = keyValue.get("KEY");
                	String value = keyValue.get("VALUE");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
    			}
			}
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) || outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.USE_ITERATE)) { 
				if("QueryAndRead".equals(action)){
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(publicName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
				}else if("Query".equals(action)){
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(publicName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
				}else if("Read".equals(action)){
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(publicName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
				}

    stringBuffer.append(TEXT_48);
    
		  if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			List<Map<String, String>> mappingList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
			Map<String,Map<String,String>> resultMapping = new HashMap<String,Map<String,String>>();
			Map<String,String> fldMapping;
			for(Map<String,String> inputMapping:mappingList){	
				fldMapping = new HashMap<String,String>();
				fldMapping.put("gID",inputMapping.get("GROUP_TABLE_ID"));
				fldMapping.put("fID",inputMapping.get("PARAMETER_NAME"));
				resultMapping.put(inputMapping.get("SCHEMA_COLUMN"),fldMapping);
			}
			for( int i = 0; i < columnList.size(); i++) {
			
				IMetadataColumn column = columnList.get(i);
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
				Map<String,String> fieldMapping = resultMapping.get(column.getLabel());
				String keyOfValueStr = !"Query".equals(action)?fieldMapping.get("gID")+",":"";
				keyOfValueStr += fieldMapping.get("fID");

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_51);
    	
    				if (javaType == JavaTypesManager.LIST) {	
				
    stringBuffer.append(TEXT_52);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_56);
    				
    				}else if (javaType == JavaTypesManager.STRING) {
    			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_61);
    
    				} else if(javaType == JavaTypesManager.DATE) { // Date
    			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_67);
    
    				}  else if(javaType == JavaTypesManager.OBJECT) { // OBJECT
    			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_72);
    
    				} else  { // other
    			
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(keyOfValueStr);
    stringBuffer.append(TEXT_78);
    
    				}
    			
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_82);
    
			}
			}
		  }
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
