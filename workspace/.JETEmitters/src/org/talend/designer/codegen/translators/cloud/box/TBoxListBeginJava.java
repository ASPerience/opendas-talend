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

public class TBoxListBeginJava
{
  protected static String nl;
  public static synchronized TBoxListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxListBeginJava result = new TBoxListBeginJava();
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
  protected final String TEXT_66 = "  ";
  protected final String TEXT_67 = NL + "    ";
  protected final String TEXT_68 = "_client.authenticate(new com.box.boxjavalibv2.dao.BoxOAuthToken(";
  protected final String TEXT_69 = "_map));" + NL + "}";
  protected final String TEXT_70 = NL + "\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_71 = "_client = (com.box.boxjavalibv2.BoxClient)globalMap.get(";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\tString ";
  protected final String TEXT_74 = "_path = normalizePath(";
  protected final String TEXT_75 = ");" + NL + "\tboolean ";
  protected final String TEXT_76 = "_hasError = false;" + NL + "\tString ";
  protected final String TEXT_77 = "_name = getFolderFromPath(";
  protected final String TEXT_78 = "_path);" + NL + "\tcom.box.boxjavalibv2.dao.BoxFile ";
  protected final String TEXT_79 = "_boxFile = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_80 = "_boxFolder = null;" + NL + "\tif ((";
  protected final String TEXT_81 = "_name.equals(\"All Files\") && (";
  protected final String TEXT_82 = "_path.isEmpty() || ";
  protected final String TEXT_83 = "_path == null)))" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_84 = "_boxFolder = ";
  protected final String TEXT_85 = "_client.getFoldersManager().getFolder(\"0\",null);\t" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tcom.box.restclientv2.requestsbase.BoxDefaultRequestObject ";
  protected final String TEXT_86 = "_requestObject = new com.box.restclientv2.requestsbase.BoxDefaultRequestObject();" + NL + "\t\t\tif (";
  protected final String TEXT_87 = "_name.equals(\"All Files\") || ";
  protected final String TEXT_88 = "_path.equals(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_89 = "_boxFolder = ";
  protected final String TEXT_90 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxCollection ";
  protected final String TEXT_91 = "_searchResults = ";
  protected final String TEXT_92 = "_client.getSearchManager().search(";
  protected final String TEXT_93 = "_name, ";
  protected final String TEXT_94 = "_requestObject);" + NL + "\t\t\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_95 = "_entry : ";
  protected final String TEXT_96 = "_searchResults.getEntries())" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_97 = "_entry instanceof com.box.boxjavalibv2.dao.BoxFile && ((com.box.boxjavalibv2.dao.BoxFile) ";
  protected final String TEXT_98 = "_entry).getName().equals(";
  protected final String TEXT_99 = "_name))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_100 = "_path == null || ";
  protected final String TEXT_101 = "_path.isEmpty())" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_102 = "_boxFile = ((com.box.boxjavalibv2.dao.BoxFile) ";
  protected final String TEXT_103 = "_entry);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tjava.lang.StringBuilder ";
  protected final String TEXT_104 = "_sBuilder = new java.lang.StringBuilder();" + NL + "\t\t\t\t\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_105 = "_obj : ((com.box.boxjavalibv2.dao.BoxFile) ";
  protected final String TEXT_106 = "_entry).getPathCollection().getEntries())" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_107 = "_sBuilder.append(";
  protected final String TEXT_108 = "_obj.getValue(\"name\") + \"/\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = "_sBuilder.append(((com.box.boxjavalibv2.dao.BoxFile) ";
  protected final String TEXT_110 = "_entry).getName());" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_111 = "_sBuilder.toString().equals(";
  protected final String TEXT_112 = "_path))" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_113 = "_boxFile = (com.box.boxjavalibv2.dao.BoxFile) ";
  protected final String TEXT_114 = "_entry;" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse if (";
  protected final String TEXT_115 = "_entry instanceof com.box.boxjavalibv2.dao.BoxFolder && ((com.box.boxjavalibv2.dao.BoxFolder) ";
  protected final String TEXT_116 = "_entry).getName().equals(";
  protected final String TEXT_117 = "_name))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tjava.lang.StringBuilder ";
  protected final String TEXT_118 = "_sBuilder = new java.lang.StringBuilder();" + NL + "\t\t\t\t\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_119 = "_obj : ((com.box.boxjavalibv2.dao.BoxFolder) ";
  protected final String TEXT_120 = "_entry).getPathCollection().getEntries())" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_121 = "_sBuilder.append(";
  protected final String TEXT_122 = "_obj.getValue(\"name\") + \"/\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = "_sBuilder.append(((com.box.boxjavalibv2.dao.BoxFolder) ";
  protected final String TEXT_124 = "_entry).getName());" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_125 = "_sBuilder.toString().equals(";
  protected final String TEXT_126 = "_path))" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_127 = "_boxFolder = (com.box.boxjavalibv2.dao.BoxFolder) ";
  protected final String TEXT_128 = "_entry;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_129 = "_boxFolder = ";
  protected final String TEXT_130 = "_client.getFoldersManager().getFolder(";
  protected final String TEXT_131 = "_boxFolder.getId(), null);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t}" + NL + "" + NL + "\tif (";
  protected final String TEXT_132 = "_boxFile == null && ";
  protected final String TEXT_133 = "_boxFolder == null)" + NL + "\t{" + NL + "\t\tthrow new Exception(\"";
  protected final String TEXT_134 = " - \" + \"No file or directory found in \" + ";
  protected final String TEXT_135 = ");" + NL + "\t}" + NL + "\telse if (";
  protected final String TEXT_136 = "_boxFolder != null)" + NL + "\t{" + NL + "\t\tjava.util.List<com.box.boxjavalibv2.dao.BoxItem>  ";
  protected final String TEXT_137 = "_children = new java.util.ArrayList<com.box.boxjavalibv2.dao.BoxItem>();";
  protected final String TEXT_138 = NL + "\t";
  protected final String TEXT_139 = NL + "\t\t";
  protected final String TEXT_140 = "_children = getChildrenRecursively(";
  protected final String TEXT_141 = "_client, ";
  protected final String TEXT_142 = "_boxFolder, ";
  protected final String TEXT_143 = "_children, true, false);" + NL + "\t";
  protected final String TEXT_144 = "\t\t" + NL + "\t\t";
  protected final String TEXT_145 = "_children = getChildrenRecursively(";
  protected final String TEXT_146 = "_client, ";
  protected final String TEXT_147 = "_boxFolder, ";
  protected final String TEXT_148 = "_children, false, true);" + NL + "\t";
  protected final String TEXT_149 = NL + "\t\t";
  protected final String TEXT_150 = "_children = getChildrenRecursively(";
  protected final String TEXT_151 = "_client, ";
  protected final String TEXT_152 = "_boxFolder, ";
  protected final String TEXT_153 = "_children, true, true);" + NL + "\t";
  protected final String TEXT_154 = NL + "\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_155 = "_boxFolder.getItemCollection().getEntries())" + NL + "\t\t{" + NL + "\t";
  protected final String TEXT_156 = NL + "\t\t\tif(obj.getType().equals(\"folder\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFolder folder = ";
  protected final String TEXT_157 = "_client.getFoldersManager().getFolder(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_158 = "_children.add(folder);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_159 = NL + "\t\t\tif (obj.getType().equals(\"file\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFile file = ";
  protected final String TEXT_160 = "_client.getFilesManager().getFile(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_161 = "_children.add(file);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_162 = NL + "\t\t\tif(obj.getType().equals(\"folder\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFolder folder = ";
  protected final String TEXT_163 = "_client.getFoldersManager().getFolder(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_164 = "_children.add(folder);" + NL + "\t\t\t}" + NL + "\t\t\telse if (obj.getType().equals(\"file\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFile file = ";
  protected final String TEXT_165 = "_client.getFilesManager().getFile(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_166 = "_children.add(file);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_167 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t}";
  protected final String TEXT_168 = NL + "\t\t" + NL + "\t\tfor (com.box.boxjavalibv2.dao.BoxItem ";
  protected final String TEXT_169 = "_item : ";
  protected final String TEXT_170 = "_children)" + NL + "\t\t{" + NL + "\t\t\tString ";
  protected final String TEXT_171 = "_itemPath = getBoxItemPath(";
  protected final String TEXT_172 = "_item);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_173 = "_NAME\", ";
  protected final String TEXT_174 = "_item.getName());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_175 = "_ID\", ";
  protected final String TEXT_176 = "_item.getId());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_177 = "_FILE_PATH\", ";
  protected final String TEXT_178 = "_itemPath);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_179 = "_FILE_DIRECTORY\", ";
  protected final String TEXT_180 = "_itemPath + ";
  protected final String TEXT_181 = "_item.getName());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_182 = "_TYPE\",";
  protected final String TEXT_183 = "_item.getType());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_184 = "_LAST_MODIFIED\", ";
  protected final String TEXT_185 = "_item.getModifiedAt());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_186 = "_SIZE\", ";
  protected final String TEXT_187 = "_item.getSize());" + NL + "\t" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t";

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
		
		String path = ElementParameterParser.getValue(node, "__PATH__");
		String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
		boolean includeSubDirectories = "true".equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				log4jFileUtil.componentStartInfo(node);
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
	    }
		
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end
		

    
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
    stringBuffer.append(path);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    if(includeSubDirectories){
    stringBuffer.append(TEXT_138);
    if(filelistType.equalsIgnoreCase("Directories")){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    } else if (filelistType.equalsIgnoreCase("Files")){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    } else {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    }
    }
    else{
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    if(filelistType.equalsIgnoreCase("Directories")){
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    } else if (filelistType.equalsIgnoreCase("Files")){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    } else {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    return stringBuffer.toString();
  }
}
