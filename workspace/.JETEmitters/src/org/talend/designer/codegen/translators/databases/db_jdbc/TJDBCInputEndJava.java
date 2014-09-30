package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TJDBCInputEndJava
{
  protected static String nl;
  public static synchronized TJDBCInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCInputEndJava result = new TJDBCInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}" + NL + "}finally{" + NL + "\tif(rs_";
  protected final String TEXT_3 = " != null){" + NL + "\t\trs_";
  protected final String TEXT_4 = ".close();" + NL + "\t}" + NL + "\tstmt_";
  protected final String TEXT_5 = ".close();" + NL;
  protected final String TEXT_6 = NL + "if(conn_";
  protected final String TEXT_7 = " != null && !conn_";
  protected final String TEXT_8 = ".isClosed()) {" + NL + "\tconn_";
  protected final String TEXT_9 = ".close();" + NL + "}";
  protected final String TEXT_10 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE\", nb_line_";
  protected final String TEXT_12 = ");" + NL + NL;
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("false").equals(useExistingConn)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
