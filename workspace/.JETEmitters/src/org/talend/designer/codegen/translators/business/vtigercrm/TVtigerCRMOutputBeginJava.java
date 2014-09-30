package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TVtigerCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TVtigerCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMOutputBeginJava result = new TVtigerCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_2 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = "; ";
  protected final String TEXT_7 = NL + "    " + NL + "    org.talend.vtiger.IVtigerManager vtigerManager_";
  protected final String TEXT_8 = " = new org.talend.vtiger.VtigerManager(";
  protected final String TEXT_9 = ", decryptedPassword_";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Clndrdetail> clndrDetais_";
  protected final String TEXT_16 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Clndrdetail>(); ";
  protected final String TEXT_17 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Contactdetail> contactdetails_";
  protected final String TEXT_18 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Contactdetail>();";
  protected final String TEXT_19 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Taskdetail> taskdetails_";
  protected final String TEXT_20 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Taskdetail>();";
  protected final String TEXT_21 = NL + "    com.vtiger.vtwsclib.WSClient vtMgr_";
  protected final String TEXT_22 = " = new com.vtiger.vtwsclib.WSClient(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "; ";
  protected final String TEXT_30 = NL + "\t    " + NL + "\tboolean lr_";
  protected final String TEXT_31 = " = vtMgr_";
  protected final String TEXT_32 = ".doLogin(";
  protected final String TEXT_33 = ", decryptedPassword_";
  protected final String TEXT_34 = ");" + NL + "\tif(!lr_";
  protected final String TEXT_35 = "){" + NL + "\t \tthrow new RuntimeException(vtMgr_";
  protected final String TEXT_36 = ".lastError().toString());" + NL + "\t}";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String version_selection = ElementParameterParser.getValue(node, "__VERSION_SELECTION__");
if(version_selection.equals("VTIGER_50")){

    String serverAddr = ElementParameterParser.getValue(node, "__SERVERADDR__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String vtigerPath = ElementParameterParser.getValue(node, "__VTIGERPATH__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String version = ElementParameterParser.getValue(node, "__VERSION__");
    String method = ElementParameterParser.getValue(node, "__METHODNAME__");
    String passwordFieldName = "__PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_3);
    } else {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(serverAddr);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(vtigerPath);
    stringBuffer.append(TEXT_14);
    
    if(("addClndr").equals(method) || ("updateClndr").equals(method)) {
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
    } else if(("addContacts").equals(method) || ("updateContacts").equals(method)) {
        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
    } else if(("addTasks").equals(method) || ("updateTasks").equals(method)) {
        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
    }
//*****************************************************version 5.1 start**************************************
}else{
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String username = ElementParameterParser.getValue(node, "__USERNAME_510__");

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_23);
    
    String passwordFieldName = "__ACCESS_KEY__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
