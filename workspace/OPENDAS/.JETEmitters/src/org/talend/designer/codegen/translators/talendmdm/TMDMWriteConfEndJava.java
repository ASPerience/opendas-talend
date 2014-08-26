package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMWriteConfEndJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfEndJava result = new TMDMWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}//for" + NL + "}//if" + NL + "xmlFieldList_";
  protected final String TEXT_2 = ".clear();";
  protected final String TEXT_3 = " " + NL + "\tif(miList_";
  protected final String TEXT_4 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_5 = " = xtentisWS_";
  protected final String TEXT_6 = ".putItemWithReportArray(miList_";
  protected final String TEXT_7 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[miList_";
  protected final String TEXT_8 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_9 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_10 = " = null;" + NL + "\t\t";
  protected final String TEXT_11 = NL + "        \txtentisWS_";
  protected final String TEXT_12 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_13 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_14 = ",wspks_";
  protected final String TEXT_15 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_16 = ".clear();";
  protected final String TEXT_17 = NL + "\t}";
  protected final String TEXT_18 = NL + "\tif(miList_";
  protected final String TEXT_19 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_20 = " = xtentisWS_";
  protected final String TEXT_21 = ".putItemArray(miList_";
  protected final String TEXT_22 = ".toArray(new org.talend.mdm.webservice.WSPutItem[miList_";
  protected final String TEXT_23 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_24 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_25 = " = null;" + NL + "\t\t";
  protected final String TEXT_26 = NL + "        \txtentisWS_";
  protected final String TEXT_27 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_28 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_29 = ",wspks_";
  protected final String TEXT_30 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_31 = ".clear();";
  protected final String TEXT_32 = NL + "\t}";
  protected final String TEXT_33 = NL + " \t" + NL + " \tstub_";
  protected final String TEXT_34 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + " \t" + NL + " \tglobalMap.put(\"";
  protected final String TEXT_35 = "_NB_LINE\",nb_line_";
  protected final String TEXT_36 = ");             ";
  protected final String TEXT_37 = NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}
	
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	String taskID = ElementParameterParser.getValue(node,"__TASKID__");
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
if(!usePartialUpdate){
	if(isMassInsert){
		if(withReport){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(addTaskID){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
		}else{
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    if(addTaskID){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
		}
	}
}
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
