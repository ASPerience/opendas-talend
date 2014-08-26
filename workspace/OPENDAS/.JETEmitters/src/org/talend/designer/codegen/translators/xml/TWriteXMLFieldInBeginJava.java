package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TWriteXMLFieldInBeginJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldInBeginJava result = new TWriteXMLFieldInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\tList<String> xmlFieldList_";
  protected final String TEXT_4 = " = (List<String>)globalMap.get(\"XMLFIELD\");" + NL + "" + NL + "\tif(xmlFieldList_";
  protected final String TEXT_5 = "!=null){" + NL + "\t\tfor(String strXmlField_";
  protected final String TEXT_6 = " :xmlFieldList_";
  protected final String TEXT_7 = "){" + NL + "//\t\t\t";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " = strField_";
  protected final String TEXT_10 = ";   //move to the main code";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getOutgoingConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		}
	}
}

    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
