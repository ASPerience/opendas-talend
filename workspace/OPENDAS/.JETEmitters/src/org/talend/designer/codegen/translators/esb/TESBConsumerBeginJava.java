package org.talend.designer.codegen.translators.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TESBConsumerBeginJava
{
  protected static String nl;
  public static synchronized TESBConsumerBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerBeginJava result = new TESBConsumerBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "javax.xml.namespace.QName serviceName_";
  protected final String TEXT_2 = " = null;" + NL + "javax.xml.namespace.QName portName_";
  protected final String TEXT_3 = " = null;" + NL + "org.talend.ws.helper.ServiceInvokerHelper serviceInvokerHelper_";
  protected final String TEXT_4 = " = null ;" + NL + "" + NL + "ESBConsumer consumer_";
  protected final String TEXT_5 = " = null;" + NL + "if (registry != null) {" + NL + "\tconsumer_";
  protected final String TEXT_6 = " = registry.createConsumer(" + NL + "\t\tnew ESBEndpointInfo() {" + NL + "\t\t\t@SuppressWarnings(\"serial\")" + NL + "\t\t\tprivate java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "\t\t\t\tput(\"wsdlURL\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\tput(\"dataFormat\", \"PAYLOAD\");" + NL + "\t\t\t\tput(\"portName\", \"{";
  protected final String TEXT_8 = "}";
  protected final String TEXT_9 = "\");" + NL + "\t\t\t\tput(\"serviceName\", \"{";
  protected final String TEXT_10 = "}";
  protected final String TEXT_11 = "\");" + NL + "\t\t\t\tput(\"defaultOperationName\", \"";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t\tput(\"defaultOperationNameSpace\", \"\");" + NL + "\t\t\t}};" + NL + "" + NL + "\t\t\tpublic String getEndpointUri() {" + NL + "\t\t\t\t// projectName + \"_\" + processName + \"_\" + componentName" + NL + "\t\t\t\treturn \"";
  protected final String TEXT_13 = "_";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = "\";" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.util.Map<String, Object> getEndpointProperties() {" + NL + "\t\t\t\treturn props;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic String getEndpointKey() {" + NL + "\t\t\t\treturn \"cxf\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t);" + NL + "} else {";
  protected final String TEXT_16 = NL + "System.out.println(\"";
  protected final String TEXT_17 = "\");" + NL + "System.out.println(\"";
  protected final String TEXT_18 = "\");" + NL + "System.out.println(\"";
  protected final String TEXT_19 = "|";
  protected final String TEXT_20 = "\");" + NL + "" + NL + "class Util_";
  protected final String TEXT_21 = " {" + NL + "" + NL + "\tpublic final String LIST_SIZE_SYMBOL = \".size\";" + NL + "" + NL + "\t\tpublic final String LEFT_SQUARE_BRACKET = \"[\";" + NL + "" + NL + "\t\tpublic final String RIGHT_SQUARE_BRACKET = \"]\";" + NL + "" + NL + "\t\tpublic final String ALL_LIST_SYMBOL = \"[*]\";" + NL + "" + NL + "\t\tpublic Object getValue(java.util.Map<String, Object> map, String path) {" + NL + "\t\t\tif (path == null || \"\".equals(path)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tif (map == null||map.isEmpty()) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tjava.util.List<String> paths = new java.util.ArrayList<String>();" + NL + "\t\t\tresolvePath(map, path, paths);" + NL + "\t\t\tif (paths.size() > 0) {" + NL + "\t\t\t\tif (path.indexOf(ALL_LIST_SYMBOL) == -1) {" + NL + "\t\t\t\t\treturn map.get(paths.get(0));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tint size = paths.size();" + NL + "\t\t\t\t\tjava.util.List<Object> out = new java.util.ArrayList<Object>(size);" + NL + "\t\t\t\t\tfor (int i = 0; i < size; i++) {" + NL + "\t\t\t\t\t\tout.add(map.get(paths.get(i)));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn out;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void resolveInputPath(java.util.Map<String, Object> inputMap) {" + NL + "\t\t\tjava.util.Map<String, Object> tempStoreMap = new java.util.HashMap<String, Object>();" + NL + "\t\t\tjava.util.List<String> tempRemovePath = new java.util.ArrayList<String>();" + NL + "\t\t\tfor (String key : inputMap.keySet()) {" + NL + "\t\t\t\tif (key.indexOf(ALL_LIST_SYMBOL) != -1) {" + NL + "\t\t\t\t\tString listHeadPath = key.substring(0, key.indexOf(ALL_LIST_SYMBOL));" + NL + "\t\t\t\t\tString listFootPath = key.substring(key.indexOf(ALL_LIST_SYMBOL) + ALL_LIST_SYMBOL.length());" + NL + "\t\t\t\t\tjava.util.List listElement = (java.util.List) inputMap.get(key);" + NL + "\t\t\t\t\tfor (int i = 0; i < listElement.size(); i++) {" + NL + "\t\t\t\t\t\ttempStoreMap.put(listHeadPath + LEFT_SQUARE_BRACKET + i + RIGHT_SQUARE_BRACKET + listFootPath, listElement.get(i));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\ttempRemovePath.add(key);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tinputMap.putAll(tempStoreMap);" + NL + "\t\t\tfor (String removePath : tempRemovePath) {" + NL + "\t\t\t\tinputMap.remove(removePath);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void resolvePath(java.util.Map<String, Object> map, String path, java.util.List<String> paths) {" + NL + "\t\t\tString listHeadPath = \"\";" + NL + "\t\t\tString listFootPath = \"\";" + NL + "\t\t\tint size = 0;" + NL + "\t\t\tString tempPath = \"\";" + NL + "\t\t\tif (path.indexOf(ALL_LIST_SYMBOL) != -1) {" + NL + "\t\t\t\tlistHeadPath = path.substring(0, path.indexOf(ALL_LIST_SYMBOL));" + NL + "\t\t\t\tlistFootPath = path.substring(path.indexOf(ALL_LIST_SYMBOL) + ALL_LIST_SYMBOL.length());" + NL + "\t\t\t\tif (map.get(listHeadPath) == null && map.get(listHeadPath + LIST_SIZE_SYMBOL) != null) {" + NL + "\t\t\t\t\tsize = Integer.parseInt(map.get(listHeadPath + LIST_SIZE_SYMBOL).toString());" + NL + "\t\t\t\t\tfor (int i = 0; i < size; i++) {" + NL + "\t\t\t\t\t\ttempPath = listHeadPath + LEFT_SQUARE_BRACKET + i + RIGHT_SQUARE_BRACKET + listFootPath;" + NL + "\t\t\t\t\t\tif (tempPath.indexOf(ALL_LIST_SYMBOL) != -1) {" + NL + "\t\t\t\t\t\t\tresolvePath(map, tempPath, paths);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tpaths.add(tempPath);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\t\tpaths.add(path);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic java.util.List<Object> normalize(String inputValue, String delimiter) {" + NL + "\t\t\tif (inputValue == null || \"\".equals(inputValue)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tObject[] inputValues = inputValue.split(delimiter);" + NL + "\t\t\treturn java.util.Arrays.asList(inputValues);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic String denormalize(java.util.List inputValues, String delimiter) {" + NL + "\t\t\tif (inputValues == null||inputValues.isEmpty()) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tStringBuffer sb = new StringBuffer();" + NL + "\t\t\tfor (Object o : inputValues) {" + NL + "\t\t\t\tsb.append(String.valueOf(o));" + NL + "\t\t\t\tsb.append(delimiter);" + NL + "\t\t\t}" + NL + "\t\t\tif (sb.length() > 0) {" + NL + "\t\t\t\tsb.delete(sb.length() - delimiter.length(),sb.length());" + NL + "\t\t\t}" + NL + "\t\t\treturn sb.toString();" + NL + "\t\t}" + NL + "}" + NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t//shade the log level for DynamicClientFactory.class" + NL + "\tjava.util.logging.Logger LOG_";
  protected final String TEXT_22 = " = org.apache.cxf.common.logging.LogUtils.getL7dLogger(org.apache.cxf.endpoint.dynamic.DynamicClientFactory.class);" + NL + "\tLOG_";
  protected final String TEXT_23 = ".setLevel(java.util.logging.Level.WARNING);" + NL + "" + NL + "\tUtil_";
  protected final String TEXT_24 = " util_";
  protected final String TEXT_25 = " = new Util_";
  protected final String TEXT_26 = "();" + NL + "" + NL + "\torg.talend.ws.helper.conf.ServiceHelperConfiguration config_";
  protected final String TEXT_27 = " = new org.talend.ws.helper.conf.ServiceHelperConfiguration();" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_28 = ".setConnectionTimeout(Long.valueOf(";
  protected final String TEXT_29 = "));" + NL + "\tconfig_";
  protected final String TEXT_30 = ".setReceiveTimeout(Long.valueOf(";
  protected final String TEXT_31 = "));" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_32 = ".setKeyStoreFile(System.getProperty(\"javax.net.ssl.keyStore\"));" + NL + "\tconfig_";
  protected final String TEXT_33 = ".setKeyStoreType(System.getProperty(\"javax.net.ssl.keyStoreType\"));" + NL + "\tconfig_";
  protected final String TEXT_34 = ".setKeyStorePwd(System.getProperty(\"javax.net.ssl.keyStorePassword\"));";
  protected final String TEXT_35 = NL + "\tSystem.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "" + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_36 = ");" + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\tconfig_";
  protected final String TEXT_39 = ".setUsername(";
  protected final String TEXT_40 = ");" + NL + "\tconfig_";
  protected final String TEXT_41 = ".setPassword(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\tjcifs.Config.setProperty(\"jcifs.smb.client.username\", ";
  protected final String TEXT_44 = ");" + NL + "\tjcifs.Config.setProperty(\"jcifs.smb.client.password\", ";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\tconfig_";
  protected final String TEXT_47 = ".setProxyServer(";
  protected final String TEXT_48 = ");" + NL + "\tconfig_";
  protected final String TEXT_49 = ".setProxyPort(";
  protected final String TEXT_50 = ");" + NL + "\tconfig_";
  protected final String TEXT_51 = ".setProxyUsername(";
  protected final String TEXT_52 = ");" + NL + "\tconfig_";
  protected final String TEXT_53 = ".setProxyPassword( ";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\tjcifs.Config.setProperty(\"jcifs.smb.client.domain\", ";
  protected final String TEXT_56 = ");" + NL + "\tjcifs.Config.setProperty(\"jcifs.netbios.wins\", ";
  protected final String TEXT_57 = ");" + NL + "\tjcifs.Config.registerSmbURLHandler();";
  protected final String TEXT_58 = NL + "\torg.talend.ws.helper.ServiceDiscoveryHelper serviceDiscoveryHelper_";
  protected final String TEXT_59 = " = null ;" + NL;
  protected final String TEXT_60 = NL + "\tjava.net.URI uri_";
  protected final String TEXT_61 = " = new java.net.URI(";
  protected final String TEXT_62 = ");" + NL + "\tif (\"http\".equals(uri_";
  protected final String TEXT_63 = ".getScheme()) || \"https\".equals(uri_";
  protected final String TEXT_64 = ".getScheme())) {" + NL + "\t\tserviceInvokerHelper_";
  protected final String TEXT_65 = " = new org.talend.ws.helper.ServiceInvokerHelper(";
  protected final String TEXT_66 = ",config_";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ");" + NL + "\t} else {";
  protected final String TEXT_69 = NL + "\t\tserviceDiscoveryHelper_";
  protected final String TEXT_70 = " = new org.talend.ws.helper.ServiceDiscoveryHelper(";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = ");" + NL + "\t\tserviceInvokerHelper_";
  protected final String TEXT_73 = " = new org.talend.ws.helper.ServiceInvokerHelper(serviceDiscoveryHelper_";
  protected final String TEXT_74 = ",config_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t}";
  protected final String TEXT_77 = NL + NL + "\tserviceName_";
  protected final String TEXT_78 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_79 = "\", \"";
  protected final String TEXT_80 = "\");" + NL + "\tportName_";
  protected final String TEXT_81 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_82 = "\", \"";
  protected final String TEXT_83 = "\");" + NL + "" + NL + "\tjava.util.Map<String,Object> inMap_";
  protected final String TEXT_84 = " = null;" + NL + "" + NL + "}";
  protected final String TEXT_85 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String projectName = codeGenArgument.getCurrentProjectName();
String processName = node.getProcess().getName();

String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");

String serviceNS = ElementParameterParser.getValue(node,"__SERVICE_NS__");
String serviceName = ElementParameterParser.getValue(node,"__SERVICE_NAME__");
String portNS = ElementParameterParser.getValue(node,"__PORT_NS__");
String portName = ElementParameterParser.getValue(node,"__PORT_NAME__");

String methodTemp = ElementParameterParser.getValue(node,"__METHOD__");
String method = methodTemp.indexOf("(")!=-1?methodTemp.substring(0,methodTemp.indexOf("(")):methodTemp;

String soapAction = ElementParameterParser.getValue(node,"__SOAPACTION__");
String methodNS = ElementParameterParser.getValue(node,"__METHOD_NS__");

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
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
String host = ElementParameterParser.getValue(node,"__NTLM_HOST__");

boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
String trustStorePassword = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");

String connTimeoutStr = ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__");
String connTimeoutSec = (connTimeoutStr!=null&&!("").equals(connTimeoutStr))?connTimeoutStr:"20";
long connTimeout = (long)(Double.valueOf(connTimeoutSec) * 1000);

String receiveTimeoutStr = ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__");
String receiveTimeoutSec = (receiveTimeoutStr!=null&&!("").equals(receiveTimeoutStr))?receiveTimeoutStr:"20";
long receiveTimeout = (long)(Double.valueOf(receiveTimeoutSec) * 1000);

String tempPath = ElementParameterParser.getValue(node,"__TMPPATH__");
if("".equals(tempPath))tempPath="\"\"";


    stringBuffer.append(TEXT_16);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(soapAction);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(trustStorePassword );
    stringBuffer.append(TEXT_37);
    
}
if (needAuth&&!useNTLM) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_42);
    
} else if(needAuth&&useNTLM) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_45);
    
}
if(useProxy) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_54);
    
}
if(useNTLM) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_57);
    
}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
     if (!useNTLM) { 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_68);
     } 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
     if (!useNTLM) { 
    stringBuffer.append(TEXT_76);
     } 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    return stringBuffer.toString();
  }
}
