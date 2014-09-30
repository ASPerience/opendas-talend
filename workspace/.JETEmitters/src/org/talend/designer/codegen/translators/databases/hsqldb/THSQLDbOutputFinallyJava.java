package org.talend.designer.codegen.translators.databases.hsqldb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IProcess;

public class THSQLDbOutputFinallyJava
{
  protected static String nl;
  public static synchronized THSQLDbOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THSQLDbOutputFinallyJava result = new THSQLDbOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_4 = "\")==null){" + NL + "\t\t\tif(resourceMap.get(\"conn_";
  protected final String TEXT_5 = "\")!=null){" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\t((java.sql.Connection)resourceMap.get(\"conn_";
  protected final String TEXT_6 = "\")).close();" + NL + "\t\t\t\t} catch (java.sql.SQLException sqlEx_";
  protected final String TEXT_7 = ") {" + NL + "\t\t\t\t\tSystem.out.println(\"failed to close the connection in ";
  protected final String TEXT_8 = " :\" + sqlEx_";
  protected final String TEXT_9 = ".getMessage());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	IProcess process = node.getProcess();
	String cid = node.getUniqueName();
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    
	if(!useExistingConnection)
	{
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	}
    
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
