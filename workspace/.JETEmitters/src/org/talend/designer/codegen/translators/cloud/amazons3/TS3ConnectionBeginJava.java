package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TS3ConnectionBeginJava
{
  protected static String nl;
  public static synchronized TS3ConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ConnectionBeginJava result = new TS3ConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_13 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_14 = ",decryptedPassword_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_17 = " = new com.amazonaws.ClientConfiguration();";
  protected final String TEXT_18 = NL + "\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_19 = " = 0;" + NL + "\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_20 = " = 0;";
  protected final String TEXT_21 = NL + "\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "\t\t\t\tcc_";
  protected final String TEXT_28 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t\t\tcc_";
  protected final String TEXT_31 = ".set";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t\tcc_";
  protected final String TEXT_35 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_36 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_39 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_40 = ",cc_";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_43 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\tglobalMap.put(\"conn_\" + \"";
  protected final String TEXT_46 = "\",conn_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
}else{

    
    String passwordFieldName = "__SECRET_KEY__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	if(configClient && clientConfiguration.size()>0){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		boolean setBuffer = false;
		for(Map<String,String> map :clientConfiguration){
			String client_parameter = map.get("CLIENT_PARAMETER");
			String value = map.get("VALUE");
			if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
				setBuffer=true;

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
			}
			if("SocketSendBufferSizeHints".equals(client_parameter)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
			}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_26);
    
			}else if("Protocol".equals(client_parameter)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_29);
    
			}else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_33);
    
			}
		}
		if(setBuffer){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
		}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
	}else{

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
	}
}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}
