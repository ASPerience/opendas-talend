package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessFinallyJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessFinallyJava result = new TBonitaInstantiateProcessFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "if(resourceMap.get(\"finish_";
  protected final String TEXT_3 = "\") == null){";
  protected final String TEXT_4 = NL + "\tif (resourceMap.get(\"httpConn_";
  protected final String TEXT_5 = "\") != null) {" + NL + "\t\t((java.net.HttpURLConnection)resourceMap.get(\"httpConn_";
  protected final String TEXT_6 = "\")).disconnect();" + NL + "\t}";
  protected final String TEXT_7 = NL + "\tif (resourceMap.get(\"loginContext_";
  protected final String TEXT_8 = "\") != null) {" + NL + "\t\t((javax.security.auth.login.LoginContext)resourceMap.get(\"loginContext_";
  protected final String TEXT_9 = "\")).logout();" + NL + "\t}";
  protected final String TEXT_10 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if ("HTTP_CLIENT".equals(clientMode)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}

    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
