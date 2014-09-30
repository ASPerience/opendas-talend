package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

public class TWriteXMLFieldInEndJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldInEndJava result = new TWriteXMLFieldInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_4 = ".join();" + NL + "\t\t\t\t\tif(txf_";
  protected final String TEXT_5 = ".getLastException()!=null) {" + NL + "\t\t\t\t\t\tcurrentComponent = txf_";
  protected final String TEXT_6 = ".getCurrentComponent();" + NL + "\t\t\t\t\t\tthrow txf_";
  protected final String TEXT_7 = ".getLastException();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tglobalMap.remove(\"queue_";
  protected final String TEXT_8 = "\");" + NL + "    \t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tString readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "_FINISH_WITH_EXCEPTION\"+(queue_";
  protected final String TEXT_12 = "==null?\"\":queue_";
  protected final String TEXT_13 = ".hashCode());" + NL + "\t\t\t\t\tif(globalMap.containsKey(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_14 = ")){" + NL + "\t\t\t\t\t\tglobalMap.put(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_15 = ", null);// syn" + NL + "\t\t\t\t\t\tglobalMap.remove(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tglobalMap.remove(\"queue_";
  protected final String TEXT_17 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tglobalMap.put(readFinishMarkWithPipeId_";
  protected final String TEXT_19 = ",null);//syn" + NL + "\t\t\t\tglobalMap.remove(readFinishMarkWithPipeId_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "globalMap.put(\"";
  protected final String TEXT_22 = "_NB_LINE\",nb_line_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
    stringBuffer.append(TEXT_2);
    
				INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
				String virtualSourceCid = sourceNode.getUniqueName();
				INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
				String startNodeCid = null; 
				if(startNode != null){
					startNodeCid = startNode.getUniqueName();
				} 
				IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
	   			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_8);
    
    			}else{
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
				}
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
			}
		}
	}
}

String strJobCid="";
if(destination !=null && !("").equals(destination.trim()))
	strJobCid=destination;
else{
	strJobCid= cid.substring(0,cid.length()-3);
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
