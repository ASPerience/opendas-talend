package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputBeginJava result = new TMicrosoftCrmOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tint nb_line_";
  protected final String TEXT_2 = " = 0;\t" + NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_3 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_4 = ");" + NL + "\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_5 = " = service_";
  protected final String TEXT_6 = "._getServiceClient().getOptions();" + NL + "\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_7 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "\t\t\t" + NL + "\t\t\tList<String> authSchemes_";
  protected final String TEXT_8 = " = new java.util.ArrayList<String>();" + NL + "\t\t\tauthSchemes_";
  protected final String TEXT_9 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\tauth_";
  protected final String TEXT_10 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_11 = ");" + NL + "\t\t\t" + NL + "            auth_";
  protected final String TEXT_12 = " .setUsername(";
  protected final String TEXT_13 = ");" + NL + "            auth_";
  protected final String TEXT_14 = " .setPassword(";
  protected final String TEXT_15 = ");" + NL + "            auth_";
  protected final String TEXT_16 = " .setHost(";
  protected final String TEXT_17 = ");" + NL + "            auth_";
  protected final String TEXT_18 = " .setPort(";
  protected final String TEXT_19 = ");" + NL + "            auth_";
  protected final String TEXT_20 = " .setDomain(";
  protected final String TEXT_21 = ");" + NL + "            auth_";
  protected final String TEXT_22 = " .setPreemptiveAuthentication(false);" + NL + "            " + NL + "            options_";
  protected final String TEXT_23 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_24 = ");" + NL + "            options_";
  protected final String TEXT_25 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_26 = "\");" + NL + "            " + NL + "            options_";
  protected final String TEXT_27 = " .setUserName(";
  protected final String TEXT_28 = ");" + NL + "            options_";
  protected final String TEXT_29 = " .setPassword(";
  protected final String TEXT_30 = ");" + NL + "            options_";
  protected final String TEXT_31 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_32 = "));" + NL + "            " + NL + "            options_";
  protected final String TEXT_33 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_34 = "));" + NL + "            options_";
  protected final String TEXT_35 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_36 = "));" + NL + "            " + NL + "            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_37 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_38 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "            token_";
  protected final String TEXT_39 = ".setAuthenticationType(0);" + NL + "            token_";
  protected final String TEXT_40 = ".setOrganizationName(";
  protected final String TEXT_41 = ");" + NL + "            catd_";
  protected final String TEXT_42 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_43 = ");" + NL + "            " + NL + "     \t" + NL + "" + NL + "  \t\t" + NL + "        \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

		
			String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
			String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
			String host = ElementParameterParser.getValue(node, "__HOST__");
			String port = ElementParameterParser.getValue(node, "__PORT__");
			String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
			String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
			int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
			boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
