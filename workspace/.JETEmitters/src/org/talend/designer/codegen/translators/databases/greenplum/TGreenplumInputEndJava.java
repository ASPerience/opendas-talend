package org.talend.designer.codegen.translators.databases.greenplum;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TGreenplumInputEndJava
{
  protected static String nl;
  public static synchronized TGreenplumInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGreenplumInputEndJava result = new TGreenplumInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_5 = " + \" \" + log4jSb_";
  protected final String TEXT_6 = ");" + NL + "\t\tlog4jSb_";
  protected final String TEXT_7 = ".delete(0,log4jSb_";
  protected final String TEXT_8 = ".length());" + NL + "\t";
  protected final String TEXT_9 = NL + "\t}" + NL + "}finally{" + NL + "\tstmt_";
  protected final String TEXT_10 = ".close();" + NL;
  protected final String TEXT_11 = NL + "\tif(conn_";
  protected final String TEXT_12 = " != null && !conn_";
  protected final String TEXT_13 = ".isClosed()) {";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + "\t\tlog.info(\"";
  protected final String TEXT_16 = " - Starting to commit.\");" + NL + "\t";
  protected final String TEXT_17 = NL + "\t\tconn_";
  protected final String TEXT_18 = ".commit();" + NL + "\t";
  protected final String TEXT_19 = NL + "\t\tlog.info(\"";
  protected final String TEXT_20 = " - Commit has succeeded.\");";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = NL + "\t\tlog.info(\"";
  protected final String TEXT_24 = " - Closing the connection to the database.\");" + NL + "\t";
  protected final String TEXT_25 = NL + "\t\tconn_";
  protected final String TEXT_26 = " .close();" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\tlog.info(\"";
  protected final String TEXT_28 = " - Connection to the database closed.\");" + NL + "\t";
  protected final String TEXT_29 = NL + "\t}" + NL + "\t";
  protected final String TEXT_30 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_31 = "_NB_LINE\",nb_line_";
  protected final String TEXT_32 = ");" + NL;
  protected final String TEXT_33 = NL + "\tlog.info(\"";
  protected final String TEXT_34 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_35 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_36 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
if(!("true").equals(useExistingConn))
{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
	String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
	if(("true").equals(useCursor)) {
	
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
    return stringBuffer.toString();
  }
}
