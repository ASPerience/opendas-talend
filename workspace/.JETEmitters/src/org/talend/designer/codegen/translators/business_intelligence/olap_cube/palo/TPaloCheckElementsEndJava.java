package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloCheckElementsEndJava
{
  protected static String nl;
  public static synchronized TPaloCheckElementsEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloCheckElementsEndJava result = new TPaloCheckElementsEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif(pConn_";
  protected final String TEXT_3 = " != null) {" + NL + "\t\t\tpConn_";
  protected final String TEXT_4 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	if(!useExistingConnection)	{

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	}

    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
