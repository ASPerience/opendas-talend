package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketCreateMainJava
{
  protected static String nl;
  public static synchronized TGSBucketCreateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketCreateMainJava result = new TGSBucketCreateMainJava();
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
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t    ";
  protected final String TEXT_9 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = "; ";
  protected final String TEXT_15 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_16 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_17 = ",decryptedPassword_";
  protected final String TEXT_18 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_19 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_20 = ");" + NL + "\t\tservice_";
  protected final String TEXT_21 = ".getAccountOwner();";
  protected final String TEXT_22 = NL + "\t\tservice_";
  protected final String TEXT_23 = ".createBucket(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\tservice_";
  protected final String TEXT_26 = ".createBucket(";
  protected final String TEXT_27 = ",org.jets3t.service.model.GSBucket.";
  protected final String TEXT_28 = "," + NL + "\t\t\t";
  protected final String TEXT_29 = "null";
  protected final String TEXT_30 = "org.jets3t.service.acl.AccessControlList.";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_34 = ") {";
  protected final String TEXT_35 = NL + "\t\tthrow(e_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_38 = ":\");" + NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_39 = ".getMessage());" + NL + "\t\tif(e_";
  protected final String TEXT_40 = ".getErrorCode()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_41 = ".getErrorCode());" + NL + "\t\t}" + NL + "\t\tif(e_";
  protected final String TEXT_42 = ".getErrorMessage()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_43 = ".getErrorMessage());" + NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_45 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_46 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSpecialConfig=("true").equals(ElementParameterParser.getValue(node,"__SPECIAL_CONFIGUER__"));
	String bucketName=ElementParameterParser.getValue(node,"__BUCKET__");
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String location = ElementParameterParser.getValue(node,"__LOCATION__");
	String acl = ElementParameterParser.getValue(node,"__ACL__");
	
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

    stringBuffer.append(TEXT_7);
    
        String passwordFieldName = "__SECRET_KEY__";

    stringBuffer.append(TEXT_8);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    } else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    		
	}
		if(!isSpecialConfig){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_24);
    
		}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_28);
    if("NONE".endsWith(acl)){
    stringBuffer.append(TEXT_29);
    }else{
    stringBuffer.append(TEXT_30);
    stringBuffer.append(acl);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_32);
    
		}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		} else {

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
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		}

    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
