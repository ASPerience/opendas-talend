package org.talend.designer.codegen.translators.databases.ingres;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TIngresOutputBulkEndJava
{
  protected static String nl;
  public static synchronized TIngresOutputBulkEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIngresOutputBulkEndJava result = new TIngresOutputBulkEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tout";
  protected final String TEXT_2 = ".close();" + NL + "\tresourceMap.put(\"finish_";
  protected final String TEXT_3 = "\", true); " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\",nb_line_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	/***********************************************************************/
	/** Talend standard code                                              **/
	/***********************************************************************/

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
