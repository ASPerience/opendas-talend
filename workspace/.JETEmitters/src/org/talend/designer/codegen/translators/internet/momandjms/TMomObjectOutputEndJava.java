package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomObjectOutputEndJava
{
  protected static String nl;
  public static synchronized TMomObjectOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomObjectOutputEndJava result = new TMomObjectOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tsession_";
  protected final String TEXT_3 = ".close();" + NL + "    connection_";
  protected final String TEXT_4 = ".close();";
  protected final String TEXT_5 = NL + NL + " System.out.println(\"Closing connection\");" + NL + "        producer_";
  protected final String TEXT_6 = ".close();" + NL + "        session_";
  protected final String TEXT_7 = ".close();" + NL + "        connection_";
  protected final String TEXT_8 = ".close();" + NL;
  protected final String TEXT_9 = NL + "\tremoteQ_";
  protected final String TEXT_10 = ".close();" + NL + "    qMgr_";
  protected final String TEXT_11 = ".disconnect();";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
if(("JBoss").equals(serverType)){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}else if(("ActiveMQ").equals(serverType)){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    }else{//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
