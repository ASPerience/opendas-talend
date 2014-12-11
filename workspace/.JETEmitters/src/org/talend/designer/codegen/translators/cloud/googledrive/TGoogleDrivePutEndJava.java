package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TGoogleDrivePutEndJava
{
  protected static String nl;
  public static synchronized TGoogleDrivePutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDrivePutEndJava result = new TGoogleDrivePutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_4 = "_file = new com.google.api.services.drive.model.File();" + NL + "\t\t\tcom.google.api.client.http.AbstractInputStreamContent ";
  protected final String TEXT_5 = "_fContent = null;" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_7 = "_listRequest =  ";
  protected final String TEXT_8 = "_client.files().list();" + NL + "\t\t\t";
  protected final String TEXT_9 = "_listRequest.setQ(\"title = '\" + ";
  protected final String TEXT_10 = " + \"' and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "\t\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_11 = "_files = ";
  protected final String TEXT_12 = "_listRequest.execute();" + NL + "\t\t\tif (";
  protected final String TEXT_13 = "_files.getItems().size() > 1)" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"More then one folder found with name \\\"\" + ";
  protected final String TEXT_14 = " + \"\\\" \");" + NL + "\t\t\t}" + NL + "\t\t\telse if (";
  protected final String TEXT_15 = "_files.getItems().isEmpty())" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"No folder found with name \\\"\" + ";
  protected final String TEXT_16 = " + \"\\\" \");" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tString ";
  protected final String TEXT_17 = "_folderId = ";
  protected final String TEXT_18 = "_files.getItems().get(0).getId();" + NL + "\t\t\t\t";
  protected final String TEXT_19 = "_file.setParents(java.util.Arrays.asList(new com.google.api.services.drive.model.ParentReference().setId(";
  protected final String TEXT_20 = "_folderId)));" + NL + "\t\t";
  protected final String TEXT_21 = "\t" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t";
  protected final String TEXT_23 = "_file.setTitle(";
  protected final String TEXT_24 = ");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_26 = "_fileRequest = ";
  protected final String TEXT_27 = "_client.files().list().setQ(\"title = '\" + ";
  protected final String TEXT_28 = " + \"' and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "\t\t\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_29 = "_existingFiles = ";
  protected final String TEXT_30 = "_fileRequest.execute();" + NL + "\t\t\t\tif (";
  protected final String TEXT_31 = "_existingFiles.getItems().size() > 1)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tthrow new Exception(\"Multiply files with same name already exist\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "\t\t\t\tif (";
  protected final String TEXT_33 = "_existingFiles.getItems().size() == 1)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_34 = "_existingFiles.getItems().get(0).getExplicitlyTrashed() != null)" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tthrow new Exception(\"File with the same name exist in Trash folder\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tthrow new Exception(\"File with the same name exist\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_36 = "_existingFiles.getItems().size() == 1)" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_37 = "_client.files().delete(";
  protected final String TEXT_38 = "_existingFiles.getItems().get(0).getId()).execute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = "_uploader_input  = new java.io.ByteArrayInputStream(";
  protected final String TEXT_41 = "_uploader_output.toByteArray());" + NL + "\t\t\t\tcom.google.api.client.http.InputStreamContent ";
  protected final String TEXT_42 = "_upload_content = new com.google.api.client.http.InputStreamContent(null, ";
  protected final String TEXT_43 = "_uploader_input);" + NL + "\t\t\t\t";
  protected final String TEXT_44 = "_file = ";
  protected final String TEXT_45 = "_client.files().insert(";
  protected final String TEXT_46 = "_file, ";
  protected final String TEXT_47 = "_upload_content).execute();" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t" + NL + "\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t}finally {" + NL + "\t\tif (";
  protected final String TEXT_50 = "_uploader_input != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_51 = "_uploader_input.close();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tif(";
  protected final String TEXT_54 = ".content != null){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t((java.io.InputStream)";
  protected final String TEXT_55 = ".content).close();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		NodeParamsHelper helper = new NodeParamsHelper(node);
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		
		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");
		boolean overwrite = helper.getBoolParam("__OVERWRITE__");
		String title = helper.getStringParam("__FILE_TITLE__");
		
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
	    boolean exposeOutput = helper.getBoolParam("__EXPOSE_OUTPUT_STREAM__");

    stringBuffer.append(TEXT_2);
    if(exposeOutput){
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				String destFolderName = helper.getStringParam("__DESTINATION_FOLDER_NAME__");
				if(!destFolderName.matches("\\s*\"?\"?\\s*") && !destFolderName.equals("\"root\"")){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				}
		
    stringBuffer.append(TEXT_21);
    
				if(!title.matches("\\s*\"?\"?\\s*")){
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if(!overwrite) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
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
    
				
				if(!destFolderName.matches("\\s*\"?\"?\\s*") && !destFolderName.equals("\"root\"")){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_55);
    }
    return stringBuffer.toString();
  }
}
