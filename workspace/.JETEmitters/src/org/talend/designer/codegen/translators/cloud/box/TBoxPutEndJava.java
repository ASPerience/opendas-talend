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

public class TBoxPutEndJava
{
  protected static String nl;
  public static synchronized TBoxPutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxPutEndJava result = new TBoxPutEndJava();
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
  protected final String TEXT_30 = NL + "\tif(";
  protected final String TEXT_31 = "_remoteName == null || ";
  protected final String TEXT_32 = "_remoteName.isEmpty())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"File name can not be empty\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_33 = "_uploader_input = new java.io.ByteArrayInputStream(";
  protected final String TEXT_34 = "_uploader_output.toByteArray());" + NL + "\tif(";
  protected final String TEXT_35 = "_remotePath.equals(\"All Files\"))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_36 = "_boxFolder = ";
  protected final String TEXT_37 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_38 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_39 = "_boxFolder = ";
  protected final String TEXT_40 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_41 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_42 = "_client, ";
  protected final String TEXT_43 = "_boxFolder, ";
  protected final String TEXT_44 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_45 = "_remotePath.length() - ";
  protected final String TEXT_46 = "_remoteName.length()));" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (";
  protected final String TEXT_47 = "_boxFolder == null)" + NL + "\t\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_48 = "_remotePath);" + NL + "\t\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_49 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_50 = "_boxFolder.getId(), ";
  protected final String TEXT_51 = "_remoteName, ";
  protected final String TEXT_52 = "_uploader_input);" + NL + "\t\tboolean ";
  protected final String TEXT_53 = "_exists = false;" + NL + "\t\tString ";
  protected final String TEXT_54 = "_fileId = null;" + NL + "\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_55 = "_boxFolder.getItemCollection().getEntries())" + NL + "        {" + NL + "        \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_56 = "_remoteName))" + NL + "        \t{" + NL + "        \t\t";
  protected final String TEXT_57 = "_exists = true;" + NL + "        \t\t";
  protected final String TEXT_58 = "_fileId = obj.getId();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        }" + NL + "        if (";
  protected final String TEXT_59 = "_exists)" + NL + "        {" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t";
  protected final String TEXT_61 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_62 = "_fileId, null);" + NL + "\t\t\t\t";
  protected final String TEXT_63 = "_boxFile = ";
  protected final String TEXT_64 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_65 = "_fileUploadObj);" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_68 = "_boxFile = ";
  protected final String TEXT_69 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_70 = "_fileUploadObj);" + NL + "\t\t}" + NL + "\t} finally {" + NL + "\t\tif (";
  protected final String TEXT_71 = "_uploader_input != null)" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_72 = "_uploader_input.close();" + NL + "\t\t\t} catch (IOException e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t\tif (";
  protected final String TEXT_73 = "_uploader_output != null)" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_74 = "_uploader_output.close();" + NL + "\t\t\t} catch (IOException e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t}";

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
		
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
		String overwrite = ElementParameterParser.getValue(node, "__REPLACE_IF_EXIST__");
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				log4jFileUtil.componentStartInfo(node);

    if("true".equals(exposeOutput)){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
     if ("true".equals(overwrite))
			{ 
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
    } else {
    stringBuffer.append(TEXT_66);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    return stringBuffer.toString();
  }
}
