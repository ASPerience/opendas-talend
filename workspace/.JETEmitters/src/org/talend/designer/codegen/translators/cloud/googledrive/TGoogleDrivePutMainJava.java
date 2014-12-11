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

public class TGoogleDrivePutMainJava
{
  protected static String nl;
  public static synchronized TGoogleDrivePutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDrivePutMainJava result = new TGoogleDrivePutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_2 = "_file = new com.google.api.services.drive.model.File();" + NL + "\tcom.google.api.client.http.AbstractInputStreamContent ";
  protected final String TEXT_3 = "_fContent = null;";
  protected final String TEXT_4 = NL + "\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_5 = "_listRequest =  ";
  protected final String TEXT_6 = "_client.files().list();" + NL + "\t";
  protected final String TEXT_7 = "_listRequest.setQ(\"title = '\" + ";
  protected final String TEXT_8 = " + \"' and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_9 = "_files = ";
  protected final String TEXT_10 = "_listRequest.execute();" + NL + "\tif (";
  protected final String TEXT_11 = "_files.getItems().size() > 1)" + NL + "\t{" + NL + "\t\tthrow new Exception(\"More then one folder found with name \\\"\" + ";
  protected final String TEXT_12 = " + \"\\\" \");" + NL + "\t}" + NL + "\telse if (";
  protected final String TEXT_13 = "_files.getItems().isEmpty())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"No folder found with name \\\"\" + ";
  protected final String TEXT_14 = " + \"\\\" \");" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tString ";
  protected final String TEXT_15 = "_folderId = ";
  protected final String TEXT_16 = "_files.getItems().get(0).getId();" + NL + "\t\t";
  protected final String TEXT_17 = "_file.setParents(java.util.Arrays.asList(new com.google.api.services.drive.model.ParentReference().setId(";
  protected final String TEXT_18 = "_folderId)));" + NL + "\t";
  protected final String TEXT_19 = NL + "\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_20 = "_fileRequest = ";
  protected final String TEXT_21 = "_client.files().list().setQ(\"title = '\" + ";
  protected final String TEXT_22 = " + \"' and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_23 = "_existingFiles = ";
  protected final String TEXT_24 = "_fileRequest.execute();" + NL + "\t\tif (";
  protected final String TEXT_25 = "_existingFiles.getItems().size() > 1)" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Multiply files with same name already exist\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_26 = "\t" + NL + "\t\tif (";
  protected final String TEXT_27 = "_existingFiles.getItems().size() == 1)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_28 = "_existingFiles.getItems().get(0).getExplicitlyTrashed() != null)" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"File with the same name exist in Trash folder\");" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"File with the same name exist\");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = "_existingFiles.getItems().size() == 1)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_31 = "_client.files().delete(";
  protected final String TEXT_32 = "_existingFiles.getItems().get(0).getId()).execute();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t";
  protected final String TEXT_34 = NL + "\t";
  protected final String TEXT_35 = "_file.setTitle(";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\tObject ";
  protected final String TEXT_38 = "_content = ";
  protected final String TEXT_39 = ".content;" + NL + "\t" + NL + "\tif(";
  protected final String TEXT_40 = "_content == null){" + NL + "\t\tthrow new Exception(\"The Uploaded file Content can't be null\");" + NL + "\t}" + NL + "\tif(";
  protected final String TEXT_41 = "_content instanceof byte[]){" + NL + "\t\t";
  protected final String TEXT_42 = "_fContent = new com.google.api.client.http.ByteArrayContent(null, (byte[])";
  protected final String TEXT_43 = "_content);" + NL + "\t}else if(";
  protected final String TEXT_44 = "_content instanceof java.io.InputStream){" + NL + "\t\t";
  protected final String TEXT_45 = "_fContent = new com.google.api.client.http.InputStreamContent(null, (java.io.InputStream)";
  protected final String TEXT_46 = "_content);" + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_47 = "_fContent = new com.google.api.client.http.ByteArrayContent(null, ";
  protected final String TEXT_48 = "_content.toString().getBytes());" + NL + "\t}" + NL + "\t";
  protected final String TEXT_49 = "_file = ";
  protected final String TEXT_50 = "_client.files().insert(";
  protected final String TEXT_51 = "_file, ";
  protected final String TEXT_52 = "_fContent).execute();";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = ".content = ";
  protected final String TEXT_55 = "_content;";
  protected final String TEXT_56 = NL + "\t";
  protected final String TEXT_57 = "_fContent = new com.google.api.client.http.FileContent(null, new java.io.File(";
  protected final String TEXT_58 = "));" + NL + "\t";
  protected final String TEXT_59 = "_file = ";
  protected final String TEXT_60 = "_client.files().insert(";
  protected final String TEXT_61 = "_file, ";
  protected final String TEXT_62 = "_fContent).execute();";
  protected final String TEXT_63 = NL + "\t}";
  protected final String TEXT_64 = NL + "\t}finally{" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		NodeParamsHelper helper = new NodeParamsHelper(node);

		String connection = helper.getStringParam("__CONNECTION__");
		String connectionKey = "\"conn_" + connection+"\"";

		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");

		boolean readContentFromInput = helper.getBoolParam("__READ_CONTENT_FROM_INPUT__");
		boolean uploadLocalFile = helper.getBoolParam("__UPLOAD_LOCAL_FILE__");
		boolean exposeOutput = helper.getBoolParam("__EXPOSE_OUTPUT_STREAM__");
		boolean overwrite = helper.getBoolParam("__OVERWRITE__");
		String title = helper.getStringParam("__FILE_TITLE__");
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


    if(!exposeOutput){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		String destFolderName = helper.getStringParam("__DESTINATION_FOLDER_NAME__");
		if(!destFolderName.matches("\\s*\"?\"?\\s*") && !destFolderName.equals("\"root\"")){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(destFolderName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		}
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    if(!overwrite) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    
		if(!title.matches("\\s*\"?\"?\\s*")){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_36);
    
		}
		
		if(readContentFromInput){
			if(dataInputConnection != null){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dataInputConnection);
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
    
				if(dataOutputConnection != null){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
				}
			}
		}else if(uploadLocalFile){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(helper.getStringParam("__LOCAL_FILE_PATH__"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
		}

    
		if(!destFolderName.matches("\\s*\"?\"?\\s*") && !destFolderName.equals("\"root\"")){

    stringBuffer.append(TEXT_63);
    		}

    stringBuffer.append(TEXT_64);
    }
    return stringBuffer.toString();
  }
}
