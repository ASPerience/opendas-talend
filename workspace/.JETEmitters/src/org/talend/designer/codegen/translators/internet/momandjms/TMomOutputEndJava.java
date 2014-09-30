package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tsession_";
  protected final String TEXT_3 = ".commit();" + NL + "\t\t";
  protected final String TEXT_4 = " // if no commmit or rollback component exists - close session" + NL + " \t\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\t\tproducer_";
  protected final String TEXT_5 = ".close();" + NL + "            session_";
  protected final String TEXT_6 = ".close();" + NL + "            connection_";
  protected final String TEXT_7 = ".close();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_9 = "\", true); " + NL + "\t";
  protected final String TEXT_10 = NL + "\t\tglobalMap.put(\"remoteQ_";
  protected final String TEXT_11 = "\",remoteQ_";
  protected final String TEXT_12 = ");" + NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_13 = "\",qMgr_";
  protected final String TEXT_14 = ");" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\tremoteQ_";
  protected final String TEXT_16 = ".close();" + NL + "\t\tqMgr_";
  protected final String TEXT_17 = ".disconnect();" + NL + "" + NL + "\t";
  protected final String TEXT_18 = NL + NL + "    globalMap.put(\"";
  protected final String TEXT_19 = "_NB_LINE\",nb_line_";
  protected final String TEXT_20 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
 

if (isUseSharedConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType) || isUseSharedConnection){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	if( ("JBoss").equals(serverType) || ( ("ActiveMQ").equals(serverType) && !isCommitRollback) ){
		// if no commmit or rollback component exists and set transacted - commit session
		if(transacted){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
        if (!isUseSharedConnection) {
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    	
		}
	}
	if((("ActiveMQ").equals(serverType) || isUseSharedConnection) && !isCommitRollback && transacted){
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}
}else{//server judgement   /***WebSphere MQ*****/
	if (transacted) {
	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
	} else {
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
	}
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
