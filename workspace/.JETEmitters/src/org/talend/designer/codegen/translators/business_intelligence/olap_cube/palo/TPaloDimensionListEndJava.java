package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloDimensionListEndJava
{
  protected static String nl;
  public static synchronized TPaloDimensionListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDimensionListEndJava result = new TPaloDimensionListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t}" + NL + "   }" + NL + "\tbreak;" + NL + "  }" + NL + "\t";
  protected final String TEXT_4 = NL + "\telse {" + NL + "\t\t    throw new RuntimeException (\"Cube '\" + ";
  protected final String TEXT_5 = " + " + NL + "\t\t                              \"' not found in database '\" + ";
  protected final String TEXT_6 = " + \"'. exiting...\" );" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tif(pConn_";
  protected final String TEXT_8 = " != null){" + NL + "\t\t\tpConn_";
  protected final String TEXT_9 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_10 = NL + "//globalMap.put(\"";
  protected final String TEXT_11 = "_NB_RULES\", NB_RULES";
  protected final String TEXT_12 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    String sCubeName = ElementParameterParser.getValue(node,"__CUBE__");
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean useRetriveFromCube = "true".equals(ElementParameterParser.getValue(node,"__RETRIEVE_DIMENSIONS_FROM_CUBE__"));


    
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
    
	if(useRetriveFromCube){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_6);
    }
    
}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
