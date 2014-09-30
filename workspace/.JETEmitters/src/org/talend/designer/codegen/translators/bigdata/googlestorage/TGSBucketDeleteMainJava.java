package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketDeleteMainJava
{
  protected static String nl;
  public static synchronized TGSBucketDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketDeleteMainJava result = new TGSBucketDeleteMainJava();
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
  protected final String TEXT_17 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_18 = " =new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_19 = ");" + NL + "\t\tservice_";
  protected final String TEXT_20 = ".getAccountOwner();";
  protected final String TEXT_21 = NL + "\t\tservice_";
  protected final String TEXT_22 = ".deleteBucket(";
  protected final String TEXT_23 = ");" + NL + "" + NL + "\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_24 = ") {";
  protected final String TEXT_25 = NL + "\t\tthrow(e_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_28 = ":\");" + NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_29 = ".getMessage());" + NL + "\t\tif(e_";
  protected final String TEXT_30 = ".getErrorCode()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_31 = ".getErrorCode());" + NL + "\t\t}" + NL + "\t\tif(e_";
  protected final String TEXT_32 = ".getErrorMessage()!=null){" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_33 = ".getErrorMessage());" + NL + "\t\t}";
  protected final String TEXT_34 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_35 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_36 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t}" + NL + "\t";

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
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		}

    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
