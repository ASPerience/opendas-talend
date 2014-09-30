package org.talend.designer.codegen.translators.databases.javadb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TJavaDBOutputFinallyJava
{
  protected static String nl;
  public static synchronized TJavaDBOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJavaDBOutputFinallyJava result = new TJavaDBOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tif(resourceMap.get(\"finish_";
  protected final String TEXT_2 = "\")==null){" + NL + "\t\tif(resourceMap.get(\"conn_";
  protected final String TEXT_3 = "\")!=null){" + NL + "\t\t\ttry" + NL + "\t    \t{" + NL + "\t\t\t\t((java.sql.Connection)resourceMap.get(\"conn_";
  protected final String TEXT_4 = "\")).close();" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t    \t\tjava.sql.DriverManager.getConnection(\"jdbc:derby:;shutdown=true\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t    \t}" + NL + "\t    \tcatch(java.sql.SQLException se)" + NL + "\t    \t{" + NL + "\t            //ignore" + NL + "\t    \t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String frameworkType = ElementParameterParser.getValue(node,"__FRAMEWORK_TYPE__");
	
	String connectionFlag = ElementParameterParser.getValue(node, "__CONNECTION_FLAG__");	
	
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			if(("EMBEDED").equals(frameworkType)){
			
    stringBuffer.append(TEXT_5);
    
			}
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
