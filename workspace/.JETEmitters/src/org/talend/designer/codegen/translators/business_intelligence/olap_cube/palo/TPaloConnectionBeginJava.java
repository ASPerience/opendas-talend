package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloConnectionBeginJava
{
  protected static String nl;
  public static synchronized TPaloConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloConnectionBeginJava result = new TPaloConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "// Initialize jpalo" + NL + "org.talend.jpalo.palo p_";
  protected final String TEXT_3 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_4 = ");" + NL + "" + NL + "// Open the connection";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "org.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_12 = " = p_";
  protected final String TEXT_13 = ".connect(";
  protected final String TEXT_14 = ", decryptedPassword_";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ");" + NL + "" + NL + "globalMap.put(\"p_";
  protected final String TEXT_18 = "\", p_";
  protected final String TEXT_19 = ");" + NL + "globalMap.put(\"pConn_";
  protected final String TEXT_20 = "\", pConn_";
  protected final String TEXT_21 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");

    
    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_4);
    
String passwordFieldName = "__PASS__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
