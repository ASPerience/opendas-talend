package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class THttpRequestMainJava
{
  protected static String nl;
  public static synchronized THttpRequestMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THttpRequestMainJava result = new THttpRequestMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.net.URL url_";
  protected final String TEXT_2 = " = new java.net.URL(";
  protected final String TEXT_3 = ");" + NL;
  protected final String TEXT_4 = NL + "  java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "\t  protected java.net.PasswordAuthentication getPasswordAuthentication() {";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "\t\t  " + NL + "\t  \treturn new java.net.PasswordAuthentication(";
  protected final String TEXT_12 = ", decryptedPassword_";
  protected final String TEXT_13 = ".toCharArray());" + NL + "  }});";
  protected final String TEXT_14 = NL + "java.net.HttpURLConnection urlConn_";
  protected final String TEXT_15 = " = (java.net.HttpURLConnection) url_";
  protected final String TEXT_16 = ".openConnection();" + NL + "urlConn_";
  protected final String TEXT_17 = ".setRequestMethod(\"";
  protected final String TEXT_18 = "\");" + NL + "urlConn_";
  protected final String TEXT_19 = ".setDoOutput(true);" + NL + "urlConn_";
  protected final String TEXT_20 = ".setDoInput(true);" + NL + "urlConn_";
  protected final String TEXT_21 = ".setUseCaches(false);" + NL;
  protected final String TEXT_22 = NL + "  urlConn_";
  protected final String TEXT_23 = ".setRequestProperty(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + NL + "urlConn_";
  protected final String TEXT_27 = ".connect();" + NL + "" + NL + "byte[] buffer_";
  protected final String TEXT_28 = " = new byte[1024];" + NL + "int bos_buffer_";
  protected final String TEXT_29 = " = 0;";
  protected final String TEXT_30 = "StringBuilder sb_";
  protected final String TEXT_31 = "=new StringBuilder(); ";
  protected final String TEXT_32 = NL + "    java.io.InputStream bisParam_";
  protected final String TEXT_33 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_34 = "));" + NL + "    java.io.OutputStream bosParam_";
  protected final String TEXT_35 = " = new java.io.BufferedOutputStream(urlConn_";
  protected final String TEXT_36 = ".getOutputStream());" + NL + "    " + NL + "    while ((bos_buffer_";
  protected final String TEXT_37 = " = bisParam_";
  protected final String TEXT_38 = ".read(buffer_";
  protected final String TEXT_39 = ")) != -1) {" + NL + "      bosParam_";
  protected final String TEXT_40 = ".write(buffer_";
  protected final String TEXT_41 = ",0,bos_buffer_";
  protected final String TEXT_42 = ");" + NL + "    }" + NL + "    bosParam_";
  protected final String TEXT_43 = ".flush();" + NL + "    bosParam_";
  protected final String TEXT_44 = ".close();" + NL + "    bisParam_";
  protected final String TEXT_45 = ".close();";
  protected final String TEXT_46 = NL + NL + "if (java.net.HttpURLConnection.HTTP_OK == (urlConn_";
  protected final String TEXT_47 = ".getResponseCode())) {" + NL + "\tjava.io.InputStream bis_";
  protected final String TEXT_48 = " = new java.io.BufferedInputStream(urlConn_";
  protected final String TEXT_49 = ".getInputStream());";
  protected final String TEXT_50 = NL + "\t\tjava.io.OutputStream bosContent_";
  protected final String TEXT_51 = " = new java.io.BufferedOutputStream(new java.io.FileOutputStream(";
  protected final String TEXT_52 = "));";
  protected final String TEXT_53 = NL + "\t\twhile ((bos_buffer_";
  protected final String TEXT_54 = " = bis_";
  protected final String TEXT_55 = ".read(buffer_";
  protected final String TEXT_56 = ")) != -1) {";
  protected final String TEXT_57 = "bosContent_";
  protected final String TEXT_58 = ".write(buffer_";
  protected final String TEXT_59 = ",0,bos_buffer_";
  protected final String TEXT_60 = "); ";
  protected final String TEXT_61 = "sb_";
  protected final String TEXT_62 = ".append(new String(buffer_";
  protected final String TEXT_63 = ",0,bos_buffer_";
  protected final String TEXT_64 = ")); ";
  protected final String TEXT_65 = NL + "\t\t}";
  protected final String TEXT_66 = "\t\t" + NL + "\t\tbosContent_";
  protected final String TEXT_67 = ".flush();" + NL + "\t\tbosContent_";
  protected final String TEXT_68 = ".close();";
  protected final String TEXT_69 = NL + "\t\tbis_";
  protected final String TEXT_70 = ".close();" + NL + "} else {" + NL + "  System.err.println(urlConn_";
  protected final String TEXT_71 = ".getResponseCode() + \" \" + urlConn_";
  protected final String TEXT_72 = ".getResponseMessage());" + NL + "}" + NL;
  protected final String TEXT_73 = NL + "        ";
  protected final String TEXT_74 = ".ResponseContent = sb_";
  protected final String TEXT_75 = ".toString();";
  protected final String TEXT_76 = NL + "        ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = NL + "urlConn_";
  protected final String TEXT_82 = ".disconnect();";
  protected final String TEXT_83 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
List<? extends IConnection> outConns = node.getOutgoingSortedConnections();
String inConnName = null, outConnName = null;

boolean hasOutputSchema = false;

if (outConns != null && outConns.size() > 0){
  	if (outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
	  	outConnName = outConns.get(0).getName();
	  	hasOutputSchema = true;
  	}
  	if (inConns != null && inConns.size() > 0){
    	inConnName = inConns.get(0).getName();
  	}
}

String sURI = ElementParameterParser.getValue(node, "__URI__");
String sMethod = ElementParameterParser.getValue(node, "__METHOD_CHOSED__");
String sParamFile = ElementParameterParser.getValue(node, "__POST_PARAMS_FROM_FILE__");
boolean bOutToFile = "true".equals(ElementParameterParser.getValue(node, "__OUT_TO_FILE__"));
String sOutFilePath = ElementParameterParser.getValue(node, "__OUT_FILE_NAME__");
List<Map<String, String>> headerParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HEADERS__");
boolean bNeedAuthentication = "true".equals(ElementParameterParser.getValue(node, "__NEED_AUTHENTICATION__"));
String sUser = ElementParameterParser.getValue(node, "__USR__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(sURI);
    stringBuffer.append(TEXT_3);
    if (bNeedAuthentication){
    stringBuffer.append(TEXT_4);
    
        String passwordFieldName = "__PWD__";
        
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
    stringBuffer.append(sUser);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(sMethod);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    for (Map<String, String> header : headerParams){ // set request properties
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(header.get("HEADER_NAME"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(header.get("HEADER_VALUE"));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    if(hasOutputSchema){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    
// add parameters from file
if ("POST".equals(sMethod)){
  if (sParamFile != null && !"".equals(sParamFile)){
  
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(sParamFile);
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
    
  }
}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
  // output response content to file
	if (bOutToFile && sOutFilePath != null){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(sOutFilePath);
    stringBuffer.append(TEXT_52);
    	}
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    	if (bOutToFile && sOutFilePath != null){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    }
    	if(hasOutputSchema){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    	if (bOutToFile && sOutFilePath != null){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    	}
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
// output data
if (outConnName != null){
  List<IMetadataTable> metaTables = node.getMetadataList();
  
  if (metaTables != null && metaTables.size() > 0){
    IMetadataTable metaTable = metaTables.get(0);
    List<IMetadataColumn> columns = metaTable.getListColumns();
    
    for (IMetadataColumn column : columns){
      String colName = column.getLabel();
      
      if ("ResponseContent".equals(colName)){
      
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
      } else {
      
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_80);
    
      }
    }
  }
}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
