package org.talend.designer.codegen.translators.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TESBProviderFaultMainJava
{
  protected static String nl;
  public static synchronized TESBProviderFaultMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBProviderFaultMainJava result = new TESBProviderFaultMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tString esbProviderFaultTitle_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = " + \" [";
  protected final String TEXT_4 = "]\";" + NL + "\tDocument esbProviderFaultDoc_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "\tesbProviderFaultDoc_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "\tESBProviderCallback esbProviderCallback_";
  protected final String TEXT_11 = " = (ESBProviderCallback) globalMap.get(\"esbHandler\");" + NL + "\tif (null != esbProviderCallback_";
  protected final String TEXT_12 = ") {" + NL + "\t\tesbProviderCallback_";
  protected final String TEXT_13 = ".sendResponse(" + NL + "\t\t\t\tnew ProviderFault(" + NL + "\t\t\t\t\t\tesbProviderFaultTitle_";
  protected final String TEXT_14 = "," + NL + "\t\t\t\t\t\t(null == esbProviderFaultDoc_";
  protected final String TEXT_15 = ")" + NL + "\t\t\t\t\t\t\t? null : esbProviderFaultDoc_";
  protected final String TEXT_16 = ".getDocument())" + NL + "\t\t\t);" + NL + "\t}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if (null != metadatas && 0 < metadatas.size()) {
	IMetadataTable metadata = metadatas.get(0);
	if (null != metadata) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if(null != conns && 0 < conns.size()) {
			IConnection conn = conns.get(0);
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ESB_FAULT_TITLE__"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				List<IMetadataColumn> columns = metadata.getListColumns();
				int sizeColumns = columns.size();
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if ("payload".equals(column.getLabel())) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_9);
    
						break;
					}
				}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
