package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TXMLRPCDASSsccEndJava
{
  protected static String nl;
  public static synchronized TXMLRPCDASSsccEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLRPCDASSsccEndJava result = new TXMLRPCDASSsccEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
