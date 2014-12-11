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

public class TBoxPutMainJava
{
  protected static String nl;
  public static synchronized TBoxPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxPutMainJava result = new TBoxPutMainJava();
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
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + NL + "\t";
  protected final String TEXT_32 = NL + "\t\tObject ";
  protected final String TEXT_33 = "_content = ";
  protected final String TEXT_34 = ".content;" + NL + "\t\tjava.io.InputStream ";
  protected final String TEXT_35 = "_InputStream = null;" + NL + "\t\ttry" + NL + "\t\t{" + NL + "\t\t\tif(";
  protected final String TEXT_36 = "_content == null){" + NL + "\t\t\t\tthrow new Exception(\"The Uploaded Box file Content can't be null\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_37 = "_content instanceof byte[]){" + NL + "\t\t\t\t";
  protected final String TEXT_38 = "_InputStream = new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_39 = "_content);" + NL + "\t\t\t}else if(";
  protected final String TEXT_40 = "_content instanceof java.io.InputStream){" + NL + "\t\t\t\t";
  protected final String TEXT_41 = "_InputStream = (java.io.InputStream)";
  protected final String TEXT_42 = "_content;" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_43 = "_InputStream = new java.io.ByteArrayInputStream(";
  protected final String TEXT_44 = "_content.toString().getBytes());" + NL + "\t\t\t}" + NL + "\t\t\tcom.box.restclientv2.requestsbase.BoxDefaultRequestObject ";
  protected final String TEXT_45 = "_requestObject = new com.box.restclientv2.requestsbase.BoxDefaultRequestObject();" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_46 = "_remotePath.equals(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_47 = "_boxFolder = ";
  protected final String TEXT_48 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tif (";
  protected final String TEXT_49 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = "_boxFolder = ";
  protected final String TEXT_51 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_52 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_53 = "_client, ";
  protected final String TEXT_54 = "_boxFolder, ";
  protected final String TEXT_55 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_56 = "_remotePath.length() - ";
  protected final String TEXT_57 = "_remoteName.length()));" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif (";
  protected final String TEXT_58 = "_boxFolder == null)" + NL + "\t\t\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_59 = "_remotePath);" + NL + "\t\t\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_60 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_61 = "_boxFolder.getId(), ";
  protected final String TEXT_62 = "_remoteName, ";
  protected final String TEXT_63 = "_InputStream);" + NL + "\t\t\tboolean ";
  protected final String TEXT_64 = "_exists = false;" + NL + "\t\t\tString ";
  protected final String TEXT_65 = "_fileId = null;" + NL + "\t        for (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_66 = "_boxFolder.getItemCollection().getEntries())" + NL + "\t        {" + NL + "\t        \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_67 = "_remoteName))" + NL + "\t        \t{" + NL + "\t        \t\t";
  protected final String TEXT_68 = "_exists = true;" + NL + "\t        \t\t";
  protected final String TEXT_69 = "_fileId = obj.getId();" + NL + "\t        \t\tbreak;" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t        if (";
  protected final String TEXT_70 = "_exists)" + NL + "\t        {" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t";
  protected final String TEXT_72 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_73 = "_fileId, null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = "_boxFile = ";
  protected final String TEXT_75 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_76 = "_fileUploadObj);" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_79 = "_boxFile = ";
  protected final String TEXT_80 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_81 = "_fileUploadObj);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t";
  protected final String TEXT_83 = ".content = ";
  protected final String TEXT_84 = "_content;" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t}" + NL + "\t\tfinally {" + NL + "\t\t\tif (";
  protected final String TEXT_86 = "_InputStream != null)" + NL + "\t\t\t\t";
  protected final String TEXT_87 = "_InputStream.close();" + NL + "\t\t}";
  protected final String TEXT_88 = "\t" + NL + "\tjava.io.InputStream ";
  protected final String TEXT_89 = "_InputStream = null;" + NL + "\t" + NL + "\t\tjava.io.File ";
  protected final String TEXT_90 = "_fileToUpload = new java.io.File(";
  protected final String TEXT_91 = "_filePath);" + NL + "\t\tif(!";
  protected final String TEXT_92 = "_fileToUpload.exists())" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"The Uploaded Box file doesn't exist\");" + NL + "\t\t}" + NL + "\t\tif(";
  protected final String TEXT_93 = "_fileToUpload.isDirectory())" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"The specified path is a directory (file expected)\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_94 = "_InputStream = new java.io.FileInputStream(";
  protected final String TEXT_95 = "_fileToUpload);" + NL + "\t\tif(";
  protected final String TEXT_96 = "_remotePath.equals(\"All Files\"))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_97 = "_boxFolder = ";
  protected final String TEXT_98 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_99 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_100 = "_boxFolder = ";
  protected final String TEXT_101 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_102 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_103 = "_client, ";
  protected final String TEXT_104 = "_boxFolder, ";
  protected final String TEXT_105 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_106 = "_remotePath.length() - ";
  protected final String TEXT_107 = "_remoteName.length()));" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_108 = "_boxFolder == null)" + NL + "\t\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_109 = "_remotePath);" + NL + "\t\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_110 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_111 = "_boxFolder.getId(), ";
  protected final String TEXT_112 = "_remoteName, ";
  protected final String TEXT_113 = "_InputStream);" + NL + "\t\tboolean ";
  protected final String TEXT_114 = "_exists = false;" + NL + "\t\tString ";
  protected final String TEXT_115 = "_fileId = null;" + NL + "        for (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_116 = "_boxFolder.getItemCollection().getEntries())" + NL + "        {" + NL + "        \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_117 = "_remoteName))" + NL + "        \t{" + NL + "        \t\t";
  protected final String TEXT_118 = "_exists = true;" + NL + "        \t\t";
  protected final String TEXT_119 = "_fileId = obj.getId();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        }" + NL + "        if (";
  protected final String TEXT_120 = "_exists)" + NL + "        {" + NL + "\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t";
  protected final String TEXT_122 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_123 = "_fileId, null);" + NL + "\t\t\t\t";
  protected final String TEXT_124 = "_boxFile = ";
  protected final String TEXT_125 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_126 = "_fileUploadObj);" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_129 = "_boxFile = ";
  protected final String TEXT_130 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_131 = "_fileUploadObj);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\t";
  protected final String TEXT_133 = ".content = ";
  protected final String TEXT_134 = "_InputStream;" + NL + "\t";

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
		String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		String uploadLocalFile = ElementParameterParser.getValue(node, "__UPLOAD_LOCAL_FILE__");
		String readContentFromInput = ElementParameterParser.getValue(node, "__READ_CONTENT_FROM_INPUT__");
		String overwrite = ElementParameterParser.getValue(node, "__REPLACE_IF_EXIST__");
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		log4jFileUtil.componentStartInfo(node);
		
		String dataInputConnection = null;
        String dataOutputConnection = null;
        
        List< ? extends IConnection> inputConnections = node.getIncomingConnections();
	    for(IConnection conn : inputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataInputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end
	    
	    
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_30);
    if("true".equals(readContentFromInput)){
    stringBuffer.append(TEXT_31);
    if(dataInputConnection != null)
	{
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dataInputConnection);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
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
     if ("true".equals(overwrite))
				{ 
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    } else {
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
	} 

    
} else if ("true".equals(uploadLocalFile)) {

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
     if ("true".equals(overwrite))
			{ 
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
    } else {
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    }
    
}

    return stringBuffer.toString();
  }
}
