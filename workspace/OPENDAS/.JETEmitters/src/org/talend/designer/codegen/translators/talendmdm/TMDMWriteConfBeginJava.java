package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfBeginJava result = new TMDMWriteConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\tclass Util_";
  protected final String TEXT_5 = "{" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "\t\t\t\torg.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "\t\t        wsUpdateMetadataItem.setTaskId(taskID);" + NL + "\t\t        wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "\t\t        return wsUpdateMetadataItem;" + NL + "\t\t\t}" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "\t\t\t\tint i = 0;" + NL + "\t\t        for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "\t\t        \twsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "\t\t        \ti++;" + NL + "\t\t        }" + NL + "\t\t        return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tUtil_";
  protected final String TEXT_6 = " util_";
  protected final String TEXT_7 = " = new Util_";
  protected final String TEXT_8 = "();" + NL + "\t";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_11 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_13 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t\tjava.util.List<String> taskIDs_";
  protected final String TEXT_15 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_16 = NL + "org.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_17 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "xtentisService_";
  protected final String TEXT_18 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_19 = ");" + NL + "org.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_20 = " = xtentisService_";
  protected final String TEXT_21 = ".getXtentisPort();    " + NL + "org.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_22 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_23 = ";" + NL + "" + NL + "// Authentification";
  protected final String TEXT_24 = NL + "stub_";
  protected final String TEXT_25 = ".setUsername(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "stub_";
  protected final String TEXT_28 = ".setUsername(";
  protected final String TEXT_29 = " + \"/\" + ";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "stub_";
  protected final String TEXT_32 = ".setPassword(";
  protected final String TEXT_33 = ");" + NL + "" + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_34 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_35 = ");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_36 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_37 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_38 = ";" + NL + "" + NL + "org.talend.mdm.webservice.WSItemPK[] wspks_";
  protected final String TEXT_39 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_40 = ";" + NL + "" + NL + "List<String> xmlFieldList_";
  protected final String TEXT_41 = " = (List<String>)globalMap.get(\"XMLFIELD\");";
  protected final String TEXT_42 = NL + "\tjava.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_43 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"XMLFLOWS\");" + NL + "\tint flowNum_";
  protected final String TEXT_44 = " = 0;";
  protected final String TEXT_45 = NL + NL + "if(xmlFieldList_";
  protected final String TEXT_46 = "!=null){" + NL + "\tfor(String strXmlField_";
  protected final String TEXT_47 = " :xmlFieldList_";
  protected final String TEXT_48 = "){" + NL + "\t\tstrXmlField_";
  protected final String TEXT_49 = " = strXmlField_";
  protected final String TEXT_50 = ".trim();";
  protected final String TEXT_51 = NL;

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
	
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
	String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
	
	boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    if(!usePartialUpdate){
    stringBuffer.append(TEXT_3);
    if(addTaskID){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if(isMassInsert){
		if(withReport){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    	}else{
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		}
		if(addTaskID){
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    	
		}
	}
}
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_26);
    }else{
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if(storeFlow){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
