package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSOAPBeginJava
{
  protected static String nl;
  public static synchronized TSOAPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSOAPBeginJava result = new TSOAPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = "final";
  protected final String TEXT_4 = " org.talend.soap.SOAPUtil soapUtil_";
  protected final String TEXT_5 = " = new org.talend.soap.SOAPUtil();";
  protected final String TEXT_6 = "   " + NL + "System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = " " + NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "System.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPwd_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = "; ";
  protected final String TEXT_22 = NL + "soapUtil_";
  protected final String TEXT_23 = ".setBasicAuth(";
  protected final String TEXT_24 = ",decryptedPassword_";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "soapUtil_";
  protected final String TEXT_27 = ".setNTLMAuth(";
  protected final String TEXT_28 = ",";
  protected final String TEXT_29 = ",decryptedPassword_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = " " + NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_32 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "; ";
  protected final String TEXT_37 = NL + "soapUtil_";
  protected final String TEXT_38 = ".setProxy(";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = ",decryptedProxyPwd_";
  protected final String TEXT_42 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
        
boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
        
boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");

boolean useKerberos = ("true").equals(ElementParameterParser.getValue(node,"__USE_KERBEROS__"));
String kerberosConfiguration = ElementParameterParser.getValue(node,"__KERBEROS_CONFIGURATION__");
String passwordFieldName = "";

    if(useKerberos){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    		
if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_7);
    
    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
    
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
     
}

    
passwordFieldName = "__AUTH_PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    } else {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    }
    
if(needAuth&&!useNTLM){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
}
if(needAuth&&useNTLM){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
}
if(useProxy){

    
    passwordFieldName = "__PROXY_PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(proxyUser);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
}

    return stringBuffer.toString();
  }
}
