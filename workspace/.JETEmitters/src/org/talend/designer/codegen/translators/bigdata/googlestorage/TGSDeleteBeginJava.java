package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSDeleteBeginJava
{
  protected static String nl;
  public static synchronized TGSDeleteBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSDeleteBeginJava result = new TGSDeleteBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_17 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_18 = ",decryptedPassword_";
  protected final String TEXT_19 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_20 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_21 = ");" + NL + "\t\tservice_";
  protected final String TEXT_22 = ".getAccountOwner();";
  protected final String TEXT_23 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_24 = "=service_";
  protected final String TEXT_25 = ".listAllBuckets(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_28 = "=service_";
  protected final String TEXT_29 = ".listAllBuckets();";
  protected final String TEXT_30 = NL + "\t\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_31 = " : buckets_";
  protected final String TEXT_32 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_33 = " = bucket_";
  protected final String TEXT_34 = ".getName();" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_35 = " = service_";
  protected final String TEXT_36 = ".listObjects(currentBucketName_";
  protected final String TEXT_37 = "," + NL + "\t\t\t";
  protected final String TEXT_38 = " null ";
  protected final String TEXT_39 = "," + NL + "\t\t\t";
  protected final String TEXT_40 = " null ";
  protected final String TEXT_41 = NL + "\t\t\t);";
  protected final String TEXT_42 = NL + "\t\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_43 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_44 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t\tmap_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ".put(\"OBJECT_PREFIX\",";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t\t\tmap_";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ".put(\"OBJECT_DELIMITER\",";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t\tlist_";
  protected final String TEXT_59 = ".add(map_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_63 = ": list_";
  protected final String TEXT_64 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_65 = "=map_";
  protected final String TEXT_66 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_67 = " =new org.jets3t.service.model.GSObject[0];" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_68 = " = service_";
  protected final String TEXT_69 = ".listObjects(currentBucketName_";
  protected final String TEXT_70 = ",map_";
  protected final String TEXT_71 = ".get(\"OBJECT_PREFIX\"),map_";
  protected final String TEXT_72 = ".get(\"OBJECT_DELIMITER\"));" + NL + "\t\t\t\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_73 = "){";
  protected final String TEXT_74 = NL + "\t\t\t\t\tthrow(e_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_77 = ":\");" + NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_78 = ".getMessage());" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_79 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_80 = ".getErrorCode());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_81 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_82 = ".getErrorMessage());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_83 = NL + "\t\t\t\t}";
  protected final String TEXT_84 = NL + "\t\t\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_85 = " : objects_";
  protected final String TEXT_86 = ") {" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_87 = "++;" + NL + "\t\t\t\t\tservice_";
  protected final String TEXT_88 = ".deleteObject(currentBucketName_";
  protected final String TEXT_89 = ",objectSummary_";
  protected final String TEXT_90 = ".getKey());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSpecifyprojectID=("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_PROJECT__"));
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String delimiter=ElementParameterParser.getValue(node,"__DELIMITER__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
	}else{

    stringBuffer.append(TEXT_8);
    
        String passwordFieldName = "__SECRET_KEY__";

    stringBuffer.append(TEXT_9);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    		
	}
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	boolean queryDelObjInListBuckets = "true".equals(ElementParameterParser.getValue(node,"__DEL_IN_LIST_BUCKETS__"));
	if(!queryDelObjInListBuckets){
		String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
		if(isSpecifyprojectID){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_26);
    
		}else{

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
		}

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
    if(objects_prefix!=null && objects_prefix.trim().length()>0){
    stringBuffer.append(objects_prefix);
     }else{
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(delimiter!=null && delimiter.trim().length()>0){
    stringBuffer.append(delimiter);
     }else{
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    
	} else if(buckets.size()>0){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		for(int i=0;i<buckets.size();i++){
			Map<String, String> map=buckets.get(i);
			String bucket_name =map.get("BUCKET_NAME");
			String object_prefix =map.get("OBJECT_PREFIX");
			String object_delimiter =map.get("OBJECT_DELIMITER");

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_49);
    
			if(object_prefix!=null && object_prefix.trim().length()>0){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_53);
    
			}
			if(object_delimiter!=null && object_delimiter.trim().length()>0){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(object_delimiter);
    stringBuffer.append(TEXT_57);
    
			}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_61);
    
		}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		} else {

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
    
		}

    stringBuffer.append(TEXT_83);
    
	}
	if(!queryDelObjInListBuckets || buckets.size()>0){

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
    
	}

    return stringBuffer.toString();
  }
}
