package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TMDMViewSearchBeginJava
{
  protected static String nl;
  public static synchronized TMDMViewSearchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMViewSearchBeginJava result = new TMDMViewSearchBeginJava();
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
  protected final String TEXT_21 = ");" + NL + "" + NL + "org.talend.mdm.webservice.WSViewSearch wsViewSearch_";
  protected final String TEXT_22 = " = new org.talend.mdm.webservice.WSViewSearch();" + NL + "wsViewSearch_";
  protected final String TEXT_23 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_24 = ");" + NL + "wsViewSearch_";
  protected final String TEXT_25 = ".setWsViewPK(new org.talend.mdm.webservice.WSViewPK(";
  protected final String TEXT_26 = "));" + NL + "" + NL + "wsViewSearch_";
  protected final String TEXT_27 = ".setSpellTreshold(";
  protected final String TEXT_28 = ");" + NL + "wsViewSearch_";
  protected final String TEXT_29 = ".setSkip(";
  protected final String TEXT_30 = ");" + NL + "wsViewSearch_";
  protected final String TEXT_31 = ".setMaxItems(";
  protected final String TEXT_32 = ");" + NL;
  protected final String TEXT_33 = NL + "wsViewSearch_";
  protected final String TEXT_34 = ".setOrderBy(";
  protected final String TEXT_35 = "); // OPTIONAL" + NL + "wsViewSearch_";
  protected final String TEXT_36 = ".setDirection(\"";
  protected final String TEXT_37 = "\"); // OPTIONAL";
  protected final String TEXT_38 = NL + NL + "org.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_39 = " = null;" + NL + "java.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_40 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();";
  protected final String TEXT_41 = NL + "wc_";
  protected final String TEXT_42 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_43 = ",org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ", org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_46 = ",false);" + NL + "org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_47 = "=new org.talend.mdm.webservice.WSWhereItem(wc_";
  protected final String TEXT_48 = ",null,null);" + NL + "conditions_";
  protected final String TEXT_49 = ".add(wsItem_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_52 = " = null;" + NL + "if(conditions_";
  protected final String TEXT_53 = ".size() > 0){" + NL + "\twsItem_";
  protected final String TEXT_54 = " =new org.talend.mdm.webservice.WSWhereItem(null,conditions_";
  protected final String TEXT_55 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_56 = ".size()]),null);" + NL + "}" + NL + "wsViewSearch_";
  protected final String TEXT_57 = ".setWhereItem(wsItem_";
  protected final String TEXT_58 = "); // OPTIONAL" + NL + "" + NL + "String[] items_";
  protected final String TEXT_59 = " = xtentisWS_";
  protected final String TEXT_60 = ".viewSearch(wsViewSearch_";
  protected final String TEXT_61 = ");" + NL + "for(int i_";
  protected final String TEXT_62 = "=1;i_";
  protected final String TEXT_63 = " < items_";
  protected final String TEXT_64 = ".length; i_";
  protected final String TEXT_65 = "++){" + NL + "\tnb_line_";
  protected final String TEXT_66 = " ++;" + NL + "\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = items_";
  protected final String TEXT_69 = "[i_";
  protected final String TEXT_70 = "];\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (outgoingConns != null && outgoingConns.size() > 0){
		
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
	
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
//	String concept = ElementParameterParser.getValue(node, "__CONCEPT__");
	String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");
	
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	String viewName = ElementParameterParser.getValue(node, "__VIEWNAME__");
	
	List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
	List<Map<String, String>> orders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ORDER_TABLE__");
	
	String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
	String skip = ElementParameterParser.getValue(node, "__SKIP__");
	String maxValue = ElementParameterParser.getValue(node, "__MAXVALUE__");
	if(spellThrehold==null || ("").equals(spellThrehold)){
		spellThrehold = "-1";
	}
	if(skip==null || ("").equals(skip)){
		skip = "0";
	}
	
	if(maxValue==null || ("").equals(maxValue)){
		maxValue = "-1";
	}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(spellThrehold);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(skip );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(maxValue);
    stringBuffer.append(TEXT_32);
    
	for(int i=0; i< orders.size(); i++){ // only the first one will be effective.
		Map<String, String> map= orders.get(i);

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(map.get("XPATH"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(map.get("ORDER"));
    stringBuffer.append(TEXT_37);
    
		break;
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
	for(int i=0; i < operations.size(); i++){
		Map<String, String> map= operations.get(i);
		String xpath=map.get("XPATH");
		String operator=map.get("FUNCTION");
		String value = map.get("VALUE");
		String predicate = map.get("PREDICATE");

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_50);
    
	}//for

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
