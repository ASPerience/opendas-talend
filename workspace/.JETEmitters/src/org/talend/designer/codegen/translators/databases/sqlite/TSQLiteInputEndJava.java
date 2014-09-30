package org.talend.designer.codegen.translators.databases.sqlite;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSQLiteInputEndJava
{
  protected static String nl;
  public static synchronized TSQLiteInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQLiteInputEndJava result = new TSQLiteInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}" + NL + "}finally{" + NL + "\tstmt_";
  protected final String TEXT_3 = ".close();" + NL;
  protected final String TEXT_4 = NL + "\t\tif(conn_";
  protected final String TEXT_5 = " != null && !conn_";
  protected final String TEXT_6 = ".isClosed()) {";
  protected final String TEXT_7 = NL + "\t\tconn_";
  protected final String TEXT_8 = ".commit();";
  protected final String TEXT_9 = NL + "\t\t\tconn_";
  protected final String TEXT_10 = " .close();" + NL + "\t\t}";
  protected final String TEXT_11 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_12 = "_NB_LINE\",nb_line_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    	
	if(!useExistingConn){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		String useCursor = ElementParameterParser.getValue(node, "__USE_CURSOR__");
    	if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
		}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
