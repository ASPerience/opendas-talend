package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketListBeginJava
{
  protected static String nl;
  public static synchronized TGSBucketListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketListBeginJava result = new TGSBucketListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_bucket_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_4 = " = new org.jets3t.service.model.GSBucket[] {};" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "\tservice_";
  protected final String TEXT_7 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + "\ttry {";
  protected final String TEXT_10 = NL + "\t   ";
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_18 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_19 = ",decryptedPassword_";
  protected final String TEXT_20 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_21 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_22 = ");" + NL + "\t\tservice_";
  protected final String TEXT_23 = ".getAccountOwner();";
  protected final String TEXT_24 = NL + "\t\tbuckets_";
  protected final String TEXT_25 = "=service_";
  protected final String TEXT_26 = ".listAllBuckets(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\tbuckets_";
  protected final String TEXT_29 = "=service_";
  protected final String TEXT_30 = ".listAllBuckets();";
  protected final String TEXT_31 = NL + "\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_32 = " : buckets_";
  protected final String TEXT_33 = ") {" + NL + "\t\tnb_bucket_";
  protected final String TEXT_34 = "++;" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_35 = " = bucket_";
  protected final String TEXT_36 = ".getName();" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_37 = "_CURRENT_BUCKET_NAME\", currentBucketName_";
  protected final String TEXT_38 = ");";

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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
	}else{

    stringBuffer.append(TEXT_9);
    
       String passwordFieldName = "__SECRET_KEY__";
       
    stringBuffer.append(TEXT_10);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    		
	}
		if(isSpecifyprojectID){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_27);
    
		}else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
