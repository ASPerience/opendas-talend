package org.talend.designer.codegen.translators.file.input_deprecated_;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;

public class TFileInputEBCDICEndJava
{
  protected static String nl;
  public static synchronized TFileInputEBCDICEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputEBCDICEndJava result = new TFileInputEBCDICEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_2 = NL + "\t\t\t\t}" + NL + "\t\t\t\tfs_";
  protected final String TEXT_3 = ".close();";
  protected final String TEXT_4 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE\", tos_count_";
  protected final String TEXT_6 = ");" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tlog.info(\"";
  protected final String TEXT_8 = "- Retrieved records count: \"+ nb_line_";
  protected final String TEXT_9 = " + \".\");" + NL + "\t";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	String cid = node.getUniqueName();
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
	if(!customSetOriginalLength){

    stringBuffer.append(TEXT_1);
    
	}else{
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			if(conns!=null && conns.size()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
			}
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
