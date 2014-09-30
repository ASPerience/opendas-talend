package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TJDBCColumnListEndJava
{
  protected static String nl;
  public static synchronized TJDBCColumnListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCColumnListEndJava result = new TJDBCColumnListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}" + NL + "}catch(Exception e_";
  protected final String TEXT_3 = "){";
  protected final String TEXT_4 = NL + "        throw(e_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "        System.err.println(e_";
  protected final String TEXT_7 = ".getMessage());";
  protected final String TEXT_8 = NL + "}finally{" + NL + "    try{" + NL + "        if(stmt2_";
  protected final String TEXT_9 = "!=null){" + NL + "            stmt2_";
  protected final String TEXT_10 = ".close();" + NL + "        }" + NL + "    }catch(Exception e2_";
  protected final String TEXT_11 = "){";
  protected final String TEXT_12 = NL + "            throw(e2_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "            System.err.println(e2_";
  protected final String TEXT_15 = ".getMessage());";
  protected final String TEXT_16 = NL + "    }" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_COLUMN\", nb_column_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(dieOnError){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(dieOnError){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
