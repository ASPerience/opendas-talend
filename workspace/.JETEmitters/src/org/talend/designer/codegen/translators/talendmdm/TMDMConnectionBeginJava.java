package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMDMConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMConnectionBeginJava result = new TMDMConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "org.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_3 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "xtentisService_";
  protected final String TEXT_4 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_5 = ");" + NL + "org.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_6 = " = xtentisService_";
  protected final String TEXT_7 = ".getXtentisPort();    " + NL + "org.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_8 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_9 = ";" + NL + "" + NL + "// Authentification";
  protected final String TEXT_10 = NL + "stub_";
  protected final String TEXT_11 = ".setUsername(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "stub_";
  protected final String TEXT_14 = ".setUsername(";
  protected final String TEXT_15 = " + \"/\" + ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = "; ";
  protected final String TEXT_23 = NL + "stub_";
  protected final String TEXT_24 = ".setPassword(decryptedPassword_";
  protected final String TEXT_25 = ");" + NL;
  protected final String TEXT_26 = NL + "String turl_";
  protected final String TEXT_27 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(";
  protected final String TEXT_28 = ");" + NL + "com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_29 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_30 = ",stub_";
  protected final String TEXT_31 = ".getUsername(),stub_";
  protected final String TEXT_32 = ".getPassword());" + NL + "stub_";
  protected final String TEXT_33 = ".setHeader(new org.apache.axis.message.SOAPHeaderElement(\"http://www.talend.com/mdm\", \"transaction-id\", mdmTransaction_";
  protected final String TEXT_34 = ".getId()));" + NL + "globalMap.put(\"mdmTransaction_";
  protected final String TEXT_35 = "\", mdmTransaction_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + NL + "stub_";
  protected final String TEXT_38 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_39 = NL + NL + "globalMap.put(\"xtentisWS_";
  protected final String TEXT_40 = "\", xtentisWS_";
  protected final String TEXT_41 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
String username = ElementParameterParser.getValue(node, "__USER__");

String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
boolean useTransaction = "false".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_12);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_16);
    }
    
String passwordFieldName = "__PASS__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    if(useTransaction) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    //For TDI-26109
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
