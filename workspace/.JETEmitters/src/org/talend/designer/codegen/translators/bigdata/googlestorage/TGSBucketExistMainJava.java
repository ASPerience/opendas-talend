package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketExistMainJava
{
  protected static String nl;
  public static synchronized TGSBucketExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketExistMainJava result = new TGSBucketExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tboolean bucketExist_";
  protected final String TEXT_3 = "=false;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t   ";
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
  protected final String TEXT_21 = ".getAccountOwner();\t";
  protected final String TEXT_22 = NL + "\t\tif(service_";
  protected final String TEXT_23 = ".getBucket(";
  protected final String TEXT_24 = ")!=null){" + NL + "\t\t\tbucketExist_";
  protected final String TEXT_25 = "=true;" + NL + "\t\t}" + NL + "\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_26 = ") {";
  protected final String TEXT_27 = NL + "\t\tthrow(e_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_30 = ":\");" + NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_31 = ".getMessage());" + NL + "\t\tif(e_";
  protected final String TEXT_32 = ".getErrorCode()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_33 = ".getErrorCode());" + NL + "\t\t}" + NL + "\t\tif(e_";
  protected final String TEXT_34 = ".getErrorMessage()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_35 = ".getErrorMessage());" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_37 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_38 = ".shutdown();" + NL + "\t\t}";
  protected final String TEXT_39 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_40 = "_BUCKET_NAME\", ";
  protected final String TEXT_41 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_42 = "_BUCKET_EXIST\", bucketExist_";
  protected final String TEXT_43 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String bucketName=ElementParameterParser.getValue(node,"__BUCKET__");
	
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

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		if (("true").equals(dieOnError)) {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
		}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
