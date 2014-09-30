package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSCopyMainJava
{
  protected static String nl;
  public static synchronized TGSCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSCopyMainJava result = new TGSCopyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_3 = " = null;" + NL + "\ttry {";
  protected final String TEXT_4 = NL + "\t\tservice_";
  protected final String TEXT_5 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t   ";
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_15 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_16 = ",decryptedPassword_";
  protected final String TEXT_17 = ");" + NL + "\t\tservice_";
  protected final String TEXT_18 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_19 = ");" + NL + "\t\tservice_";
  protected final String TEXT_20 = ".getAccountOwner();";
  protected final String TEXT_21 = NL + "\t\tString targetFolder_";
  protected final String TEXT_22 = "=";
  protected final String TEXT_23 = ";" + NL + "\t\tif(targetFolder_";
  protected final String TEXT_24 = ".length()>0 && !targetFolder_";
  protected final String TEXT_25 = ".endsWith(\"/\")){" + NL + "\t\t\ttargetFolder_";
  protected final String TEXT_26 = "=targetFolder_";
  protected final String TEXT_27 = "+\"/\";" + NL + "\t\t}";
  protected final String TEXT_28 = NL + "\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_29 = " = service_";
  protected final String TEXT_30 = ".listObjects(";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = ",null);" + NL + "\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_33 = " : objects_";
  protected final String TEXT_34 = ") {" + NL + "\t\t\tString srcObjectKey_";
  protected final String TEXT_35 = "=objectSummary_";
  protected final String TEXT_36 = ".getKey();" + NL + "\t\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_37 = "=service_";
  protected final String TEXT_38 = ".getObject(";
  protected final String TEXT_39 = ", objectSummary_";
  protected final String TEXT_40 = ".getKey());" + NL + "\t\t\ttarObj_";
  protected final String TEXT_41 = ".setKey(targetFolder_";
  protected final String TEXT_42 = "+objectSummary_";
  protected final String TEXT_43 = ".getKey());";
  protected final String TEXT_44 = NL + "\t\t\tservice_";
  protected final String TEXT_45 = ".copyObject(";
  protected final String TEXT_46 = ", srcObjectKey_";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = ",tarObj_";
  protected final String TEXT_49 = " , false);";
  protected final String TEXT_50 = "\t\t" + NL + "\t\t\tservice_";
  protected final String TEXT_51 = ".moveObject(";
  protected final String TEXT_52 = ", srcObjectKey_";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", tarObj_";
  protected final String TEXT_55 = ", false);";
  protected final String TEXT_56 = NL + "\t\t\ttarObj_";
  protected final String TEXT_57 = ".closeDataInputStream();" + NL + "\t\t}";
  protected final String TEXT_58 = NL + "\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_59 = " = service_";
  protected final String TEXT_60 = ".getObject(";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\ttarObj_";
  protected final String TEXT_64 = ".setKey(targetFolder_";
  protected final String TEXT_65 = "+";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\ttarObj_";
  protected final String TEXT_68 = ".setKey(targetFolder_";
  protected final String TEXT_69 = "+tarObj_";
  protected final String TEXT_70 = ".getKey());";
  protected final String TEXT_71 = NL + "\t\tservice_";
  protected final String TEXT_72 = ".copyObject(";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ",tarObj_";
  protected final String TEXT_76 = " , false);";
  protected final String TEXT_77 = NL + "\t\tservice_";
  protected final String TEXT_78 = ".moveObject(";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", tarObj_";
  protected final String TEXT_82 = ", false);";
  protected final String TEXT_83 = NL + "\t\ttarObj_";
  protected final String TEXT_84 = ".closeDataInputStream();";
  protected final String TEXT_85 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_86 = "_SOURCE_BUCKET\",";
  protected final String TEXT_87 = "); " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_88 = "_SOURCE_OBJECTKEY\",";
  protected final String TEXT_89 = "); " + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_90 = "_DESTINATION_BUCKETNAME\", ";
  protected final String TEXT_91 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_92 = "_DESTINATION_FOLDER\", ";
  protected final String TEXT_93 = ");" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_94 = ") {";
  protected final String TEXT_95 = NL + "\t\tthrow(e_";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\t\tif(e_";
  protected final String TEXT_98 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_99 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_100 = ";" + NL + "\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_101 = ":\");" + NL + "\t\t\tSystem.err.println(servError_";
  protected final String TEXT_102 = ".getMessage());" + NL + "\t\t\tif(servError_";
  protected final String TEXT_103 = ".getErrorCode()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_104 = ".getErrorCode());" + NL + "\t\t\t}" + NL + "\t\t\tif(servError_";
  protected final String TEXT_105 = ".getErrorMessage()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_106 = ".getErrorMessage());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t}else{" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_107 = ".getMessage());" + NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_109 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_110 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSourceFolder=("true").equals(ElementParameterParser.getValue(node,"__IS_SOUCE_FOLDER__"));
	String srcBucketName=ElementParameterParser.getValue(node,"__SOURCE_BUCKET__");
	String sourceObjectKey = ElementParameterParser.getValue(node,"__SOURCE_OBJECTKEY__");
	String targetBucket=ElementParameterParser.getValue(node,"__TARGET_BUCKET__");
	String targetFolder=ElementParameterParser.getValue(node,"__TARGET_FOLDER__");
	String newObjectKey = ElementParameterParser.getValue(node,"__NEW_OBJECTKEY__");
	String actionType = ElementParameterParser.getValue(node,"__ACTION_TYPE__");
	boolean isRename = ("true").equals(ElementParameterParser.getValue(node,"__RENAME__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    
	}else{

    
       String passwordFieldName = "__SECRET_KEY__";
       
    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(accessKey);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	if(isSourceFolder){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sourceObjectKey);
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
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		if("COPY".equals(actionType) ){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
		}else{

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
	}else{

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_62);
    
		if(isRename){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(newObjectKey);
    stringBuffer.append(TEXT_66);
    
		}else{

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
		}
		if("COPY".equals(actionType) ){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		}else{

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
	}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
		} else {

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
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
		}

    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
