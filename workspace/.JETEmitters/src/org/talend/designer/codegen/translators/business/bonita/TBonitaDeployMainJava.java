package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaDeployMainJava
{
  protected static String nl;
  public static synchronized TBonitaDeployMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaDeployMainJava result = new TBonitaDeployMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tSystem.setProperty(\"BONITA_HOME\", ";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tSystem.setProperty(\"org.ow2.bonita.environment\", ";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tSystem.setProperty(\"java.security.auth.login.config\", ";
  protected final String TEXT_7 = " );" + NL + "\tSystem.setProperty(\"java.util.logging.config.file\", new java.io.File(";
  protected final String TEXT_8 = ").toURI().toURL().toString());" + NL + "\t" + NL + "\t" + NL + "\torg.ow2.bonita.facade.ManagementAPI managementAPI_";
  protected final String TEXT_9 = " = org.ow2.bonita.util.AccessorUtil.getAPIAccessor().getManagementAPI();" + NL + "\tjavax.security.auth.login.LoginContext loginContext_";
  protected final String TEXT_10 = " = null;" + NL + "\torg.ow2.bonita.facade.def.majorElement.ProcessDefinition process_";
  protected final String TEXT_11 = " = null;" + NL + "\t" + NL + "\tString processDefinitionUUID_";
  protected final String TEXT_12 = " = null;" + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_14 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; ";
  protected final String TEXT_20 = NL + "\t\tloginContext_";
  protected final String TEXT_21 = " = new javax.security.auth.login.LoginContext(";
  protected final String TEXT_22 = ", new org.ow2.bonita.util.SimpleCallbackHandler(";
  protected final String TEXT_23 = ", decryptedPassword_";
  protected final String TEXT_24 = "));" + NL + "\t\tloginContext_";
  protected final String TEXT_25 = ".login();" + NL + "\t\tprocess_";
  protected final String TEXT_26 = " = managementAPI_";
  protected final String TEXT_27 = ".deploy(org.ow2.bonita.util.BusinessArchiveFactory.getBusinessArchive(new java.io.File(";
  protected final String TEXT_28 = ").toURI().toURL()));" + NL + "\t\tprocessDefinitionUUID_";
  protected final String TEXT_29 = " = process_";
  protected final String TEXT_30 = ".getUUID().getValue();" + NL + "\t\t" + NL + "\t\tSystem.out.println(\"**** Process \"+ processDefinitionUUID_";
  protected final String TEXT_31 = " + \" deploy successful ****\");" + NL + "" + NL + "\t} catch (javax.security.auth.login.LoginException le_";
  protected final String TEXT_32 = ") {//just login exception";
  protected final String TEXT_33 = NL + "\t\tthrow le_";
  protected final String TEXT_34 = ";\t\t";
  protected final String TEXT_35 = NL + "\t\tSystem.err.println(le_";
  protected final String TEXT_36 = ".getCause().getMessage());";
  protected final String TEXT_37 = "\t\t" + NL + "\t} catch (java.lang.Exception e_";
  protected final String TEXT_38 = ") {";
  protected final String TEXT_39 = NL + "\t\tthrow e_";
  protected final String TEXT_40 = ";\t\t";
  protected final String TEXT_41 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_42 = ".getMessage());";
  protected final String TEXT_43 = NL + "\t} finally {" + NL + "\t\tloginContext_";
  protected final String TEXT_44 = ".logout();" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_45 = "_ProcessDefinitionUUID\", processDefinitionUUID_";
  protected final String TEXT_46 = "); ";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String businessArchive = ElementParameterParser.getValue(node, "__BUSINESS_ARCHIVE__");
	String userName = ElementParameterParser.getValue(node, "__USERNAME__");
	
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	String bonitaEnvironmentFile = ElementParameterParser.getValue(node, "__BONITA_ENVIRONMENT_FILE__");
	String jassFile = ElementParameterParser.getValue(node, "__JASS_STANDARD_FILE__");
	String loggingFile = ElementParameterParser.getValue(node, "__LOGGING_FILE__");
	String loginModule = ElementParameterParser.getValue(node, "__LOGIN_MODULE__");
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	String bonitaHome = ElementParameterParser.getValue(node, "__BONITA_HOME__");
	if("BONITA_561".equals(dbVersion) || "BONITA_5101".equals(dbVersion)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_3);
    
	}else if("BONITA_531".equals(dbVersion)||"BONITA_523".equals(dbVersion)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(bonitaEnvironmentFile);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(jassFile);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(loggingFile);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(loginModule);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(businessArchive);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	if (dieOnError) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    	
	}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if (dieOnError) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    	
	}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
