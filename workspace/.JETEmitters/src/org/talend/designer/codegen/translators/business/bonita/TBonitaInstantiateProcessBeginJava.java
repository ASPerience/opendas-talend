package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessBeginJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessBeginJava result = new TBonitaInstantiateProcessBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tString processInstanceUUID_";
  protected final String TEXT_3 = " = null;" + NL + "\t\tStringBuilder parameters_";
  protected final String TEXT_4 = " = new StringBuilder(\"options=user:\");" + NL + "\t\tparameters_";
  protected final String TEXT_5 = ".append(";
  protected final String TEXT_6 = ");" + NL + "\t\tString url_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = " + \"API/runtimeAPI/instantiateProcessWithVariables/\" + ";
  protected final String TEXT_9 = " +\"--\" +";
  protected final String TEXT_10 = ";" + NL + "\t\tjava.net.HttpURLConnection httpConn_";
  protected final String TEXT_11 = " = null;" + NL + "\t" + NL + "\t\thttpConn_";
  protected final String TEXT_12 = " = (java.net.HttpURLConnection) new java.net.URL(url_";
  protected final String TEXT_13 = ").openConnection();" + NL + "\t\tresourceMap.put(\"httpConn_";
  protected final String TEXT_14 = "\", httpConn_";
  protected final String TEXT_15 = "); " + NL + "\t\thttpConn_";
  protected final String TEXT_16 = ".setUseCaches (false);" + NL + "\t    httpConn_";
  protected final String TEXT_17 = ".setDoInput(true);" + NL + "\t    httpConn_";
  protected final String TEXT_18 = ".setDoOutput(true);" + NL + "\t    httpConn_";
  protected final String TEXT_19 = ".setInstanceFollowRedirects(false);" + NL + "\t    httpConn_";
  protected final String TEXT_20 = ".setRequestMethod(\"POST\");" + NL + "\t    httpConn_";
  protected final String TEXT_21 = ".setRequestProperty(\"Content-Type\", \"application/x-www-form-urlencoded\");" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = "; ";
  protected final String TEXT_29 = NL + "\t    httpConn_";
  protected final String TEXT_30 = ".setRequestProperty(\"Authorization\", \"Basic \" + new String(org.apache.commons.codec.binary.Base64.encodeBase64((";
  protected final String TEXT_31 = "+ \":\"+ decryptedPassword_";
  protected final String TEXT_32 = ").getBytes(utf8Charset)),utf8Charset));" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\t\tSystem.setProperty(\"BONITA_HOME\", ";
  protected final String TEXT_34 = ");" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\tSystem.setProperty(\"org.ow2.bonita.environment\", ";
  protected final String TEXT_36 = " );" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tSystem.setProperty(\"java.security.auth.login.config\", ";
  protected final String TEXT_38 = " );" + NL + "\t\tSystem.setProperty(\"java.util.logging.config.file\", new java.io.File(";
  protected final String TEXT_39 = ").toURI().toURL().toString());" + NL + "\t\t" + NL + "\t\t" + NL + "\t\torg.ow2.bonita.facade.RuntimeAPI runtimeAPI_";
  protected final String TEXT_40 = " = org.ow2.bonita.util.AccessorUtil.getAPIAccessor().getRuntimeAPI();" + NL + "\t\tjavax.security.auth.login.LoginContext loginContext_";
  protected final String TEXT_41 = " = null;" + NL + "\t\torg.ow2.bonita.facade.uuid.ProcessDefinitionUUID processID_";
  protected final String TEXT_42 = " =null;" + NL + "\t\t" + NL + "\t\tString processInstanceUUID_";
  protected final String TEXT_43 = " = null;" + NL + "\t\tjava.util.Map<String, Object> parameters_";
  protected final String TEXT_44 = "=new java.util.HashMap<String, Object>();" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_46 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_47 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = "; ";
  protected final String TEXT_52 = NL + "\t\tloginContext_";
  protected final String TEXT_53 = " = new javax.security.auth.login.LoginContext(";
  protected final String TEXT_54 = ", new org.ow2.bonita.util.SimpleCallbackHandler(";
  protected final String TEXT_55 = ", decryptedPassword_";
  protected final String TEXT_56 = "));" + NL + "\t\tresourceMap.put(\"loginContext_";
  protected final String TEXT_57 = "\", loginContext_";
  protected final String TEXT_58 = "); " + NL + "\t\tloginContext_";
  protected final String TEXT_59 = ".login();" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tprocessID_";
  protected final String TEXT_61 = " = new org.ow2.bonita.facade.uuid.ProcessDefinitionUUID(";
  protected final String TEXT_62 = ");" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\t\tprocessID_";
  protected final String TEXT_64 = " = new org.ow2.bonita.facade.uuid.ProcessDefinitionUUID(";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ");" + NL + "\t\t";
  protected final String TEXT_67 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	if ("HTTP_CLIENT".equals(clientMode)) {
		String url = ElementParameterParser.getValue(node, "__BONITA_URL__");
		String authUserName = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
		String process_name = ElementParameterParser.getValue(node, "__PROCESS_NAME__");
		String process_version = ElementParameterParser.getValue(node, "__PROCESS_VERSION__");
		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
		String passwordFieldName = "__AUTH_PASSWD__";
		
    stringBuffer.append(TEXT_22);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    } else {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(authUserName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	} else { // JAVA CLIENT
	
		String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
	
		String use_process_id = ElementParameterParser.getValue(node, "__USE_PROCESS_ID__");
	
		String process_name = ElementParameterParser.getValue(node, "__PROCESS_NAME__");
		String process_version = ElementParameterParser.getValue(node, "__PROCESS_VERSION__");
		
		boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
		
		String bonitaEnvironmentFile = ElementParameterParser.getValue(node, "__BONITA_ENVIRONMENT_FILE__");
		String jassFile = ElementParameterParser.getValue(node, "__JASS_STANDARD_FILE__");
		String loggingFile = ElementParameterParser.getValue(node, "__LOGGING_FILE__");
		String loginModule = ElementParameterParser.getValue(node, "__LOGIN_MODULE__");
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
		String bonitaHome = ElementParameterParser.getValue(node, "__BONITA_HOME__");
	
		if("BONITA_561".equals(dbVersion) || "BONITA_5101".equals(dbVersion)){
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_34);
    
		}else if("BONITA_531".equals(dbVersion)||"BONITA_523".equals(dbVersion)){
		
    stringBuffer.append(TEXT_35);
    stringBuffer.append(bonitaEnvironmentFile);
    stringBuffer.append(TEXT_36);
    
		}
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(jassFile);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(loggingFile);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_45);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_48);
    } else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(loginModule);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		if("true".equals(use_process_id)) {
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(processID);
    stringBuffer.append(TEXT_62);
    
		} else {
		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_66);
    
		}
	}
	
    stringBuffer.append(TEXT_67);
    return stringBuffer.toString();
  }
}
