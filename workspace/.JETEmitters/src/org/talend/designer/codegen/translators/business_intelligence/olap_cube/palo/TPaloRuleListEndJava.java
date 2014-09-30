package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloRuleListEndJava
{
  protected static String nl;
  public static synchronized TPaloRuleListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloRuleListEndJava result = new TPaloRuleListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t" + NL + "}" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tif(pConn_";
  protected final String TEXT_5 = " != null){" + NL + "\t\t\tpConn_";
  protected final String TEXT_6 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_7 = NL + "//globalMap.put(\"";
  protected final String TEXT_8 = "_NB_RULES\", NB_RULES";
  protected final String TEXT_9 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));


    
String outputConnName = null;
boolean bIterate=false;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns!=null) {
	if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				outputConnName = connTemp.getName();
				break;
			}
		}
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if(connTemp.getLineStyle().toString().equals("ITERATE")) {
				bIterate=true;
				//break;
			}
		}

	}
}

    stringBuffer.append(TEXT_2);
    
if (outputConnName != null || bIterate){

    stringBuffer.append(TEXT_3);
    
}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
