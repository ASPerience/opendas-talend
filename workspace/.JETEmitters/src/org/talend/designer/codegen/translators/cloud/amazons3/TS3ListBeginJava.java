package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3ListBeginJava
{
  protected static String nl;
  public static synchronized TS3ListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListBeginJava result = new TS3ListBeginJava();
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
  protected final String TEXT_45 = NL + NL + "\tint nb_bucket_";
  protected final String TEXT_46 = " = 0;" + NL + "\tint nb_bucket_object_";
  protected final String TEXT_47 = " = 0;" + NL + "\ttry{";
  protected final String TEXT_48 = NL + "\tjava.util.List<com.amazonaws.services.s3.model.Bucket> buckets_";
  protected final String TEXT_49 = " = conn_";
  protected final String TEXT_50 = ".listBuckets();" + NL + "\tfor (com.amazonaws.services.s3.model.Bucket bucket_";
  protected final String TEXT_51 = " : buckets_";
  protected final String TEXT_52 = ") {" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_53 = " = bucket_";
  protected final String TEXT_54 = ".getName();" + NL + "\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_55 = " = conn_";
  protected final String TEXT_56 = ".listObjects(currentBucketName_";
  protected final String TEXT_57 = ",";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\tjava.util.List<java.util.Map<String,String>> buckets_map_list_";
  protected final String TEXT_60 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\tjava.util.Map<String,String> bucket_prefix_map_";
  protected final String TEXT_61 = " = null;" + NL + "\tString object_prefix_";
  protected final String TEXT_62 = " = \"\";";
  protected final String TEXT_63 = NL + "\t\t\tobject_prefix_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";";
  protected final String TEXT_66 = NL + "\t\tbucket_prefix_map_";
  protected final String TEXT_67 = " = new java.util.HashMap<String,String>();" + NL + "\t\tbucket_prefix_map_";
  protected final String TEXT_68 = ".put(";
  protected final String TEXT_69 = ",object_prefix_";
  protected final String TEXT_70 = ");" + NL + "\t\tbuckets_map_list_";
  protected final String TEXT_71 = ".add(bucket_prefix_map_";
  protected final String TEXT_72 = ");" + NL + "\t\tobject_prefix_";
  protected final String TEXT_73 = " = \"\";";
  protected final String TEXT_74 = NL + "\tfor (java.util.Map<String,String> bucketMap_";
  protected final String TEXT_75 = ": buckets_map_list_";
  protected final String TEXT_76 = ") {" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_77 = " = \"\";" + NL + "\t\tString currentPrefix_";
  protected final String TEXT_78 = " = \"\";" + NL + "\t\tfor(java.util.Map.Entry<String,String> entry_";
  protected final String TEXT_79 = ":bucketMap_";
  protected final String TEXT_80 = ".entrySet()){" + NL + "\t\t\tcurrentBucketName_";
  protected final String TEXT_81 = " = entry_";
  protected final String TEXT_82 = ".getKey();" + NL + "\t\t\tcurrentPrefix_";
  protected final String TEXT_83 = " = entry_";
  protected final String TEXT_84 = ".getValue();" + NL + "\t\t}" + NL + "\t\ttry{" + NL + "\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_85 = " = conn_";
  protected final String TEXT_86 = ".listObjects(currentBucketName_";
  protected final String TEXT_87 = ",currentPrefix_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\tdo {" + NL + "\t\tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> list_objects_";
  protected final String TEXT_90 = " = objects_";
  protected final String TEXT_91 = ".getObjectSummaries();" + NL + "\t\tif(list_objects_";
  protected final String TEXT_92 = ".size()>0){" + NL + "\t\t\tnb_bucket_";
  protected final String TEXT_93 = "++;" + NL + "\t\t}" + NL + "\t\tfor (com.amazonaws.services.s3.model.S3ObjectSummary objectSummary_";
  protected final String TEXT_94 = " : list_objects_";
  protected final String TEXT_95 = ") {" + NL + "\t\t\tnb_bucket_object_";
  protected final String TEXT_96 = "++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_97 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_98 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_99 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_100 = ".getKey());";

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
    
List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
if(listAll){
	String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");

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
    stringBuffer.append(objects_prefix!=null && objects_prefix.trim().length()>0 ?objects_prefix:null);
    stringBuffer.append(TEXT_58);
    
} else if(buckets.size()>0){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
	for(Map<String, String> map: buckets){
		String bucket_name =map.get("BUCKET_NAME");
		String object_prefix =map.get("OBJECT_PREFIX");
		if(object_prefix!=null && object_prefix.trim().length()>0){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_65);
    
		}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
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
    
}
if(listAll || buckets.size()>0){

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
    
}

    return stringBuffer.toString();
  }
}
