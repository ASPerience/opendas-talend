package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessEndJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessEndJava result = new TBonitaInstantiateProcessEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tif (httpConn_";
  protected final String TEXT_3 = " != null) {" + NL + "\t\thttpConn_";
  protected final String TEXT_4 = ".disconnect();" + NL + "\t}";
  protected final String TEXT_5 = NL + "\tif (loginContext_";
  protected final String TEXT_6 = " != null) {" + NL + "\t\tloginContext_";
  protected final String TEXT_7 = ".logout();" + NL + "\t}";
  protected final String TEXT_8 = NL + "resourceMap.put(\"finish_";
  protected final String TEXT_9 = "\", true); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");

    
	if ("HTTP_CLIENT".equals(clientMode)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
