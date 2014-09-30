package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TWebServiceBeginJava
{
  protected static String nl;
  public static synchronized TWebServiceBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceBeginJava result = new TWebServiceBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tSystem.setProperty(\"javax.xml.transform.TransformerFactory\", \"org.apache.xalan.processor.TransformerFactoryImpl\");" + NL + "    System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t//shade the log level for DynamicClientFactory.class" + NL + "\tjava.util.logging.Logger LOG_";
  protected final String TEXT_2 = " = org.apache.cxf.common.logging.LogUtils.getL7dLogger(org.apache.cxf.endpoint.dynamic.DynamicClientFactory.class);\t\t\t\t\t" + NL + "\tLOG_";
  protected final String TEXT_3 = ".setLevel(java.util.logging.Level.WARNING);" + NL + "\t" + NL + "\torg.talend.webservice.helper.Utils util_";
  protected final String TEXT_4 = " = new org.talend.webservice.helper.Utils();" + NL + "    " + NL + "    org.talend.webservice.helper.conf.ServiceHelperConfiguration config_";
  protected final String TEXT_5 = " = new org.talend.webservice.helper.conf.ServiceHelperConfiguration();" + NL + "\t" + NL + "\tconfig_";
  protected final String TEXT_6 = ".setConnectionTimeout(Long.valueOf(";
  protected final String TEXT_7 = "));" + NL + "\tconfig_";
  protected final String TEXT_8 = ".setReceiveTimeout(Long.valueOf(";
  protected final String TEXT_9 = "));" + NL + "\t" + NL + "\tconfig_";
  protected final String TEXT_10 = ".setKeyStoreFile(System.getProperty(\"javax.net.ssl.keyStore\"));" + NL + "\tconfig_";
  protected final String TEXT_11 = ".setKeyStoreType(System.getProperty(\"javax.net.ssl.keyStoreType\"));" + NL + "\tconfig_";
  protected final String TEXT_12 = ".setKeyStorePwd(System.getProperty(\"javax.net.ssl.keyStorePassword\"));" + NL + "\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_20 = "   " + NL + "    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "" + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = " " + NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_23 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; ";
  protected final String TEXT_28 = "\t" + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPwd_";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = "\t" + NL + "\tconfig_";
  protected final String TEXT_31 = ".setUsername(";
  protected final String TEXT_32 = ");" + NL + "\tconfig_";
  protected final String TEXT_33 = ".setPassword(decryptedPassword_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\tconfig_";
  protected final String TEXT_36 = ".setProxyServer(";
  protected final String TEXT_37 = ");" + NL + "\tconfig_";
  protected final String TEXT_38 = ".setProxyPort(";
  protected final String TEXT_39 = ");" + NL + "    config_";
  protected final String TEXT_40 = ".setProxyUsername(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = " " + NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_43 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "; ";
  protected final String TEXT_48 = NL + "    config_";
  protected final String TEXT_49 = ".setProxyPassword(decryptedProxyPwd_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t";
  protected final String TEXT_52 = NL + "\tSystem.setProperty(\"http.auth.ntlm.domain\", ";
  protected final String TEXT_53 = ");" + NL + "\t";
  protected final String TEXT_54 = NL + "\tjava.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "        public java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "            return new java.net.PasswordAuthentication(";
  protected final String TEXT_55 = ", decryptedPassword_";
  protected final String TEXT_56 = ".toCharArray());" + NL + "        }" + NL + "    });" + NL + "\t" + NL + "\tconfig_";
  protected final String TEXT_57 = ".setAllowChunking(false);";
  protected final String TEXT_58 = " " + NL + "\torg.talend.webservice.helper.ServiceDiscoveryHelper serviceDiscoveryHelper_";
  protected final String TEXT_59 = " = null ;" + NL + "\torg.talend.webservice.helper.ServiceInvokerHelper serviceInvokerHelper_";
  protected final String TEXT_60 = " = null ;" + NL;
  protected final String TEXT_61 = NL + "\tjava.net.URI uri_";
  protected final String TEXT_62 = " = new java.net.URI(";
  protected final String TEXT_63 = ");" + NL + "    if (\"http\".equals(uri_";
  protected final String TEXT_64 = ".getScheme()) || \"https\".equals(uri_";
  protected final String TEXT_65 = ".getScheme())) {" + NL + "  " + NL + "\t\tserviceInvokerHelper_";
  protected final String TEXT_66 = " = new org.talend.webservice.helper.ServiceInvokerHelper(";
  protected final String TEXT_67 = ",config_";
  protected final String TEXT_68 = ",";
  protected final String TEXT_69 = ");" + NL + "" + NL + "\t} else {";
  protected final String TEXT_70 = NL + "        serviceDiscoveryHelper_";
  protected final String TEXT_71 = " = new org.talend.webservice.helper.ServiceDiscoveryHelper(";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ");" + NL + "    \tserviceInvokerHelper_";
  protected final String TEXT_74 = " = new org.talend.webservice.helper.ServiceInvokerHelper(serviceDiscoveryHelper_";
  protected final String TEXT_75 = ",config_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL + "\t" + NL + "\tjavax.xml.namespace.QName serviceName_";
  protected final String TEXT_79 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_80 = "\", \"";
  protected final String TEXT_81 = "\");" + NL + "\tjavax.xml.namespace.QName portName_";
  protected final String TEXT_82 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_83 = "\", \"";
  protected final String TEXT_84 = "\");" + NL + "\t" + NL + "\tjava.util.Map<String,Object> inMap_";
  protected final String TEXT_85 = " = null;";
  protected final String TEXT_86 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");

String serviceNS = ElementParameterParser.getValue(node,"__SERVICE_NS__");
String serviceName = ElementParameterParser.getValue(node,"__SERVICE_NAME__");
String portNS = ElementParameterParser.getValue(node,"__PORT_NS__");
String portName = ElementParameterParser.getValue(node,"__PORT_NAME__");

String soapAction = ElementParameterParser.getValue(node,"__SOAPACTION__");
String methodNS = ElementParameterParser.getValue(node,"__METHOD_NS__");

boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
String host = ElementParameterParser.getValue(node,"__NTLM_HOST__");

boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
        
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
        
String connTimeoutStr = ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__");
String connTimeoutSec = (connTimeoutStr!=null&&!("").equals(connTimeoutStr))?connTimeoutStr:"20";
long connTimeout = (long)(Double.valueOf(connTimeoutSec) * 1000);

String receiveTimeoutStr = ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__");
String receiveTimeoutSec = (receiveTimeoutStr!=null&&!("").equals(receiveTimeoutStr))?receiveTimeoutStr:"20";
long receiveTimeout = (long)(Double.valueOf(receiveTimeoutSec) * 1000);

String tempPath = ElementParameterParser.getValue(node,"__TMPPATH__");
String passwordFieldName = "";
if("".equals(tempPath))tempPath="\"\"";


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
passwordFieldName = "__AUTH_PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_21);
    
    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
     
}if(needAuth&&!useNTLM){	

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
}if(useProxy){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_41);
    
    passwordFieldName = "__PROXY_PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    } else {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
}if(useNTLM){

    stringBuffer.append(TEXT_51);
    if(!"\"\"".equals(domain)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
     
} 	

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(!useNTLM){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    if(!useNTLM){
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    return stringBuffer.toString();
  }
}
