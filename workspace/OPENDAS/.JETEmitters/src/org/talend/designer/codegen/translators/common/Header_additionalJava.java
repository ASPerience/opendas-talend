package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.Vector;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Header_additionalJava
{
  protected static String nl;
  public static synchronized Header_additionalJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_additionalJava result = new Header_additionalJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\tprivate ESBEndpointRegistry registry = null;" + NL + "\tprivate ESBProviderCallback callback = null;" + NL + "" + NL + "\tpublic void setEndpointRegistry(ESBEndpointRegistry registry) {";
  protected final String TEXT_2 = "\t\tthis.registry = registry;";
  protected final String TEXT_3 = NL + "\t}" + NL + "" + NL + "\tpublic void setProviderCallback(ESBProviderCallback callback) {";
  protected final String TEXT_4 = "\t\tthis.callback = callback;";
  protected final String TEXT_5 = NL + "\t}" + NL + "" + NL + "\tpublic ESBEndpointInfo getEndpoint() {";
  protected final String TEXT_6 = NL + "\t\treturn new ESBEndpointInfo() {" + NL + "\t\t\tprivate String uri = ";
  protected final String TEXT_7 = ";" + NL + "\t\t\t@SuppressWarnings(\"serial\")" + NL + "\t\t\tprivate java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "\t\t\t\t// \"request-response\" or \"one-way\"" + NL + "\t\t\t\tput(\"COMMUNICATION_STYLE\", \"";
  protected final String TEXT_8 = "\");" + NL + "\t\t\t\t//" + NL + "\t\t\t\tput(\"dataFormat\", \"PAYLOAD\");" + NL + "\t\t\t\t// static" + NL + "\t\t\t\tput(\"portName\", \"{http://talend.org/esb/service/job}TalendJobAsWebService\");" + NL + "\t\t\t\t// local part is: projectName + \"_\" + processName" + NL + "\t\t\t\tput(\"serviceName\", \"{http://talend.org/esb/service/job}";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = "\");" + NL + "\t\t\t\t// static" + NL + "\t\t\t\tput(\"defaultOperationName\", \"invoke\");" + NL + "\t\t\t\t// static" + NL + "\t\t\t\tput(\"defaultOperationNameSpace\", \"\");" + NL + "\t\t\t\t// endpoint URI configured in tESBProviderInput" + NL + "\t\t\t\tput(\"publishedEndpointUrl\", uri);" + NL + "\t\t\t}};" + NL + "" + NL + "\t\t\tpublic String getEndpointKey() {" + NL + "\t\t\t\treturn \"cxf\";" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic String getEndpointUri() {" + NL + "\t\t\t\t// projectName + \"_\" + processName" + NL + "\t\t\t\treturn \"";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = "\";" + NL + "\t\t\t\t// return uri;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.util.Map<String, Object> getEndpointProperties() {" + NL + "\t\t\t\treturn props;" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_13 = NL + "\t\treturn null;";
  protected final String TEXT_14 = NL + "\t}";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "\tpublic class ProviderFault {" + NL + "" + NL + "\t\tfinal String message;" + NL + "\t\tfinal Object detail;" + NL + "" + NL + "\t\tpublic ProviderFault(String message) {" + NL + "\t\t\tthis(message, null);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic ProviderFault(String message, Object detail) {" + NL + "\t\t\tthis.message = message;" + NL + "\t\t\tthis.detail = detail;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic String getMessage() {" + NL + "\t\t\treturn message;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic Object getDetail() {" + NL + "\t\t\treturn detail;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess)v.get(0);

boolean actAsProvider = !process.getNodesOfType("tESBProviderRequest").isEmpty();
boolean actAsConsumer = !process.getNodesOfType("tESBConsumer").isEmpty();

if (actAsProvider || actAsConsumer) { 
    stringBuffer.append(TEXT_1);
     if (actAsConsumer) { 
    stringBuffer.append(TEXT_2);
     } 
    stringBuffer.append(TEXT_3);
     if (actAsProvider) { 
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
     if (actAsProvider) {
	String projectName = codeGenArgument.getCurrentProjectName();
	String processName = process.getName();

	boolean isOneWay = (process.getNodesOfType("tESBProviderFault").isEmpty()
		&& process.getNodesOfType("tESBProviderResponse").isEmpty());
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(
										process.getNodesOfType("tESBProviderRequest").get(0),
										"__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append((isOneWay)?"one-way":"request-response");
    stringBuffer.append(TEXT_8);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_12);
     } else { 
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     if (actAsProvider) { 
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
