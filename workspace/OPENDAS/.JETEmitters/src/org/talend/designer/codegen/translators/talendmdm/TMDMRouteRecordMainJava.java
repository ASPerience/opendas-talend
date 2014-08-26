package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMDMRouteRecordMainJava
{
  protected static String nl;
  public static synchronized TMDMRouteRecordMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMRouteRecordMainJava result = new TMDMRouteRecordMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + "org.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_3 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "xtentisService_";
  protected final String TEXT_4 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_5 = ");" + NL + "org.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_6 = " = xtentisService_";
  protected final String TEXT_7 = ".getXtentisPort();    " + NL + "org.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_8 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_9 = ";" + NL + "" + NL + "// Authentification";
  protected final String TEXT_10 = NL + "stub_";
  protected final String TEXT_11 = ".setUsername(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "stub_";
  protected final String TEXT_14 = ".setUsername(";
  protected final String TEXT_15 = " + \"/\" + ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "stub_";
  protected final String TEXT_18 = ".setPassword(";
  protected final String TEXT_19 = ");" + NL + "" + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_20 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_21 = ");" + NL + "" + NL + "org.talend.mdm.webservice.WSRouteItemV2 wsRouteItem_";
  protected final String TEXT_22 = " = new org.talend.mdm.webservice.WSRouteItemV2();" + NL + "org.talend.mdm.webservice.WSItemPK wsItemPK_";
  protected final String TEXT_23 = " = new org.talend.mdm.webservice.WSItemPK();" + NL + "wsItemPK_";
  protected final String TEXT_24 = ".setConceptName(";
  protected final String TEXT_25 = ");" + NL + "wsItemPK_";
  protected final String TEXT_26 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_27 = ");" + NL + "wsItemPK_";
  protected final String TEXT_28 = ".setIds(new String[]{";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "});" + NL + "wsRouteItem_";
  protected final String TEXT_31 = ".setWsItemPK(wsItemPK_";
  protected final String TEXT_32 = ");" + NL + "org.talend.mdm.webservice.WSRoutingRulePK[] wsRoutingRulePKArray_";
  protected final String TEXT_33 = " = xtentisWS_";
  protected final String TEXT_34 = ".routeItemV2(wsRouteItem_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
	String entity = ElementParameterParser.getValue(node, "__ENTITY__");
	String keyField = ElementParameterParser.getValue(node, "__KEYFIELD__");
	
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	
	List<Map<String, String>> ids = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__IDS__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_12);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(entity );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
boolean isfirst = true;
for(Map<String, String> map:ids){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(isfirst?"":",");
    stringBuffer.append(map.get("ID"));
    
	isfirst =false;
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
