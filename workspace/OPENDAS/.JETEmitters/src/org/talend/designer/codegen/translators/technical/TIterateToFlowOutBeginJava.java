package org.talend.designer.codegen.translators.technical;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TIterateToFlowOutBeginJava
{
  protected static String nl;
  public static synchronized TIterateToFlowOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIterateToFlowOutBeginJava result = new TIterateToFlowOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "OnSubjobOkStruct";
  protected final String TEXT_3 = " struct_";
  protected final String TEXT_4 = " = new OnSubjobOkStruct";
  protected final String TEXT_5 = "();";
  protected final String TEXT_6 = NL + "struct_";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "  = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "synchronized(obj){" + NL + "    if(";
  protected final String TEXT_12 = ".this.globalMap.containsKey(\"";
  protected final String TEXT_13 = "\")){" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_14 = "> list_";
  protected final String TEXT_15 = " = (java.util.List<OnSubjobOkStruct";
  protected final String TEXT_16 = ">)";
  protected final String TEXT_17 = ".this.globalMap.get(\"";
  protected final String TEXT_18 = "\"); " + NL + "    \tlist_";
  protected final String TEXT_19 = ".add(struct_";
  protected final String TEXT_20 = ");" + NL + "    }else{" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_21 = "> list_";
  protected final String TEXT_22 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<OnSubjobOkStruct";
  protected final String TEXT_23 = ">());" + NL + "    \tlist_";
  protected final String TEXT_24 = ".add(struct_";
  protected final String TEXT_25 = ");" + NL + "    \t";
  protected final String TEXT_26 = ".this.globalMap.put(\"";
  protected final String TEXT_27 = "\",list_";
  protected final String TEXT_28 = ");" + NL + "    }" + NL + "}";
  protected final String TEXT_29 = NL + "    if(globalMap.containsKey(\"";
  protected final String TEXT_30 = "\")){" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_31 = "> list_";
  protected final String TEXT_32 = " = (java.util.List<OnSubjobOkStruct";
  protected final String TEXT_33 = ">)globalMap.get(\"";
  protected final String TEXT_34 = "\"); " + NL + "    \tlist_";
  protected final String TEXT_35 = ".add(struct_";
  protected final String TEXT_36 = ");" + NL + "    }else{" + NL + "    \tjava.util.List<OnSubjobOkStruct";
  protected final String TEXT_37 = "> list_";
  protected final String TEXT_38 = " = new java.util.ArrayList<OnSubjobOkStruct";
  protected final String TEXT_39 = ">();" + NL + "    \tlist_";
  protected final String TEXT_40 = ".add(struct_";
  protected final String TEXT_41 = ");" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_42 = "\",list_";
  protected final String TEXT_43 = ");" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

IProcess currentProcess = node.getProcess();

boolean isInThread = false;

List< ? extends IConnection> connsInIterate = node.getIncomingConnections(EConnectionType.ITERATE);
if(connsInIterate != null && connsInIterate.size() > 0){
	IConnection conn = connsInIterate.get(0);
	isInThread = "true".equals(ElementParameterParser.getValue(conn, "__ENABLE_PARALLEL__")); 
}

String destination = ElementParameterParser.getValue(
    node,
    "__DESTINATION__"
);

List<Map<String, String>> mapping =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__MAPPING__"
    );

    stringBuffer.append(TEXT_2);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_5);
    
for (Map<String, String> mappingColumn : mapping) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mappingColumn.get("SCHEMA_COLUMN"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(mappingColumn.get("VALUE"));
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    if(isInThread){//tIterateToFlow is a little special, it link with OnSubJobOK in virtual level, so, in Multi-Thread, there should be synchronized.
    stringBuffer.append(TEXT_11);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }else{
    stringBuffer.append(TEXT_29);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    return stringBuffer.toString();
  }
}
