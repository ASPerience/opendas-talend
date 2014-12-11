package org.talend.designer.codegen.translators.cloud.box;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TBoxPutBeginJava
{
  protected static String nl;
  public static synchronized TBoxPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxPutBeginJava result = new TBoxPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\tcom.box.boxjavalibv2.BoxRESTClient ";
  protected final String TEXT_31 = "_httpClient = new com.box.boxjavalibv2.BoxRESTClient();";
  protected final String TEXT_32 = "   " + NL + "\t\t";
  protected final String TEXT_33 = "_httpClient.setConnectionTimeOut(3000);" + NL + "\t\torg.apache.http.HttpHost ";
  protected final String TEXT_34 = "_proxy = new org.apache.http.HttpHost(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", \"http\");" + NL + "\t\torg.apache.http.client.HttpClient ";
  protected final String TEXT_37 = "_cl = ";
  protected final String TEXT_38 = "_httpClient.getRawHttpClient();" + NL + "\t\t";
  protected final String TEXT_39 = "_cl.getParams().setParameter(org.apache.http.conn.params.ConnRoutePNames.DEFAULT_PROXY, ";
  protected final String TEXT_40 = "_proxy);";
  protected final String TEXT_41 = NL + "\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_42 = "_client = new com.box.boxjavalibv2.BoxClient(";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", null, null, ";
  protected final String TEXT_45 = "_httpClient, new com.box.boxjavalibv2.BoxConfigBuilder().build());" + NL + "if((";
  protected final String TEXT_46 = " == null || \"\".equals(";
  protected final String TEXT_47 = ".trim())) && (";
  protected final String TEXT_48 = " == null || \"\".equals(";
  protected final String TEXT_49 = ".trim()))) {" + NL + "\tthrow new Exception(\"One of Access token or Refresh token should be provided\");" + NL + "} else {" + NL + "\tjava.util.Map<String, Object> ";
  protected final String TEXT_50 = "_map = new java.util.HashMap<String, Object>();";
  protected final String TEXT_51 = NL + "\t";
  protected final String TEXT_52 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_53 = ");" + NL + "\t";
  protected final String TEXT_54 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "    ";
  protected final String TEXT_57 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);";
  protected final String TEXT_58 = NL + "    ";
  protected final String TEXT_59 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "    ";
  protected final String TEXT_62 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "    ";
  protected final String TEXT_65 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);";
  protected final String TEXT_66 = "   ";
  protected final String TEXT_67 = NL + "    ";
  protected final String TEXT_68 = "_client.authenticate(new com.box.boxjavalibv2.dao.BoxOAuthToken(";
  protected final String TEXT_69 = "_map));" + NL + "}";
  protected final String TEXT_70 = NL + "\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_71 = "_client = (com.box.boxjavalibv2.BoxClient)globalMap.get(";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\tString ";
  protected final String TEXT_74 = "_filePath = normalizePath(";
  protected final String TEXT_75 = ");" + NL + "\tString ";
  protected final String TEXT_76 = "_remotePath = normalizePath(";
  protected final String TEXT_77 = ");" + NL + "\t" + NL + "\tif(";
  protected final String TEXT_78 = "_remotePath == null || \"\".equals(";
  protected final String TEXT_79 = "_remotePath.trim()))" + NL + "\t{" + NL + "\t\tthrow new Exception(\"The Box remote path can't be null\");" + NL + "\t}" + NL + "\tboolean ";
  protected final String TEXT_80 = "_hasError = false;" + NL + "\tString ";
  protected final String TEXT_81 = "_remoteName = getFolderFromPath(";
  protected final String TEXT_82 = "_remotePath);" + NL + "\t" + NL + "\tcom.box.boxjavalibv2.dao.BoxFile ";
  protected final String TEXT_83 = "_boxFile = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_84 = "_boxFolder = null;";
  protected final String TEXT_85 = NL + "\tjava.io.ByteArrayOutputStream ";
  protected final String TEXT_86 = "_uploader_output = new java.io.ByteArrayOutputStream();" + NL + "\tjava.io.ByteArrayInputStream ";
  protected final String TEXT_87 = "_uploader_input = null;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_88 = "_OUTPUTSTREAM\", ";
  protected final String TEXT_89 = "_uploader_output);" + NL + "\ttry" + NL + "\t{";
  protected final String TEXT_90 = NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		String accessToken = ElementParameterParser.getValue(node, "__ACCESS_TOKEN__");
		String refreshToken = ElementParameterParser.getValue(node, "__REFRESH_TOKEN__");
		
		String clientId = ElementParameterParser.getValue(node, "__CLIENT_ID__");
		String clientSecret = ElementParameterParser.getValue(node, "__CLIENT_SECRET__");
		
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    String connectionKey = "\"conn_" + connection+"\"";
		
		String boxPath = ElementParameterParser.getValue(node, "__PATH__");
		String filePath = ElementParameterParser.getValue(node, "__FILE_PATH__");
		
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				log4jFileUtil.componentStartInfo(node);

    
if(!"true".equals(useExistingConn)){
	String useProxy = ElementParameterParser.getValue(node,"__USE_PROXY__");
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
	if("true".equals(useProxy)){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	}else{

    
	}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(clientSecret);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    if (accessToken != null && !accessToken.isEmpty()  && !accessToken.trim().matches("\"?\"?") && refreshToken != null && !refreshToken.isEmpty() && !refreshToken.trim().matches("\"?\"?")) { 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
     } else if (accessToken != null && !accessToken.isEmpty() && !accessToken.trim().matches("\"?\"?")) { 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_60);
     } else if (refreshToken != null && !"".equals(refreshToken.trim()) && !refreshToken.trim().matches("\"?\"?")) { 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
     } 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_72);
    
}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(boxPath);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    if("true".equals(exposeOutput)){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    return stringBuffer.toString();
  }
}
