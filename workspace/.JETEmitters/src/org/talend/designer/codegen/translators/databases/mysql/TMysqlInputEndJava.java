package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMysqlInputEndJava
{
  protected static String nl;
  public static synchronized TMysqlInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlInputEndJava result = new TMysqlInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}" + NL + "}finally{" + NL + "\tif(rs_";
  protected final String TEXT_3 = " != null){" + NL + "\t\trs_";
  protected final String TEXT_4 = ".close();" + NL + "\t}" + NL + "\tstmt_";
  protected final String TEXT_5 = ".close();";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\tif(conn_";
  protected final String TEXT_10 = " != null && !conn_";
  protected final String TEXT_11 = ".isClosed()) {" + NL + "\t\t\tconn_";
  protected final String TEXT_12 = ".close();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE\",nb_line_";
  protected final String TEXT_18 = ");" + NL;
  protected final String TEXT_19 = NL + "\tlog.info(\"";
  protected final String TEXT_20 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_21 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_22 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
	if(!("true").equals(useExistingConn))
	{
		
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    return stringBuffer.toString();
  }
}
