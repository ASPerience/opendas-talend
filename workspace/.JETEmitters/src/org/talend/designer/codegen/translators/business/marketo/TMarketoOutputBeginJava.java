package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMarketoOutputBeginJava
{
  protected static String nl;
  public static synchronized TMarketoOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputBeginJava result = new TMarketoOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tint nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "\torg.talend.marketo.Client client_";
  protected final String TEXT_11 = " = new org.talend.marketo.Client(";
  protected final String TEXT_12 = ",decryptedPassword_";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ");" + NL + "\tclient_";
  protected final String TEXT_15 = ".setTimeout(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tjava.util.List<com.marketo.www.mktows.LeadRecord> leadRecordList_";
  protected final String TEXT_18 = " = new java.util.ArrayList<com.marketo.www.mktows.LeadRecord>(";
  protected final String TEXT_19 = " * 2);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

    String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
    String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
    String passwordFieldName = "__SECRET_KEY__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_16);
    
	if(operation.equals("syncMultipleLeads")){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_19);
    		
	}

    return stringBuffer.toString();
  }
}
