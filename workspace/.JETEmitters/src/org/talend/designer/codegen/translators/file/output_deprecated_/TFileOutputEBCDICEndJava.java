package org.talend.designer.codegen.translators.file.output_deprecated_;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputEBCDICEndJava
{
  protected static String nl;
  public static synchronized TFileOutputEBCDICEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputEBCDICEndJava result = new TFileOutputEBCDICEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tfOut_";
  protected final String TEXT_2 = ".flush();" + NL + "\tfOut_";
  protected final String TEXT_3 = ".close();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\", nb_line_";
  protected final String TEXT_5 = ");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tlog.info(\"";
  protected final String TEXT_7 = " - Written records count: \" + nb_line_";
  protected final String TEXT_8 = " + \" .\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    }
	
    return stringBuffer.toString();
  }
}
