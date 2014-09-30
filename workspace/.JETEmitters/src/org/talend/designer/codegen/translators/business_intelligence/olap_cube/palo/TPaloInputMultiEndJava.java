package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloInputMultiEndJava
{
  protected static String nl;
  public static synchronized TPaloInputMultiEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloInputMultiEndJava result = new TPaloInputMultiEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "}";
  protected final String TEXT_2 = NL + "\t\tif(pConn_";
  protected final String TEXT_3 = " != null){" + NL + "\t\t\tpConn_";
  protected final String TEXT_4 = ".logout();" + NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String strOutputConnectionName="";
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
 	if(conns!=null){
		if (conns.size()>0){
            IConnection conn =conns.get(0);
            if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	strOutputConnectionName=conn.getName();
		    }
		}
	}
	if(strOutputConnectionName != null && strOutputConnectionName.length()>0){

    stringBuffer.append(TEXT_1);
    
	}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	}

    return stringBuffer.toString();
  }
}
