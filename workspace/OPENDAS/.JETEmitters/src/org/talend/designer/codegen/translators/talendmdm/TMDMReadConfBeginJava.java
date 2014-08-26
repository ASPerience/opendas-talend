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

public class TMDMReadConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMReadConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMReadConfBeginJava result = new TMDMReadConfBeginJava();
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
  protected final String TEXT_21 = ");" + NL;
  protected final String TEXT_22 = NL + "String[] ids_";
  protected final String TEXT_23 = " = {";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "};" + NL + "org.talend.mdm.webservice.WSGetItem wsitem_";
  protected final String TEXT_26 = " = " + NL + "new org.talend.mdm.webservice.WSGetItem(new org.talend.mdm.webservice.WSItemPK(dataCluster_";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = ",ids_";
  protected final String TEXT_29 = "));" + NL + "org.talend.mdm.webservice.WSItem item_";
  protected final String TEXT_30 = "=xtentisWS_";
  protected final String TEXT_31 = ".getItem(wsitem_";
  protected final String TEXT_32 = ");" + NL + "" + NL + "String ";
  protected final String TEXT_33 = "_xml = item_";
  protected final String TEXT_34 = ".getContent();" + NL + "nb_line_";
  protected final String TEXT_35 = " ++;" + NL;
  protected final String TEXT_36 = NL + "org.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_37 = " = null;" + NL + "java.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_38 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();";
  protected final String TEXT_39 = NL + "wc_";
  protected final String TEXT_40 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_41 = ",org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ", org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_44 = ",false);" + NL + "org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = "=new org.talend.mdm.webservice.WSWhereItem(wc_";
  protected final String TEXT_47 = ",null,null);" + NL + "conditions_";
  protected final String TEXT_48 = ".add(wsItem_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_52 = " = null;" + NL + "if(conditions_";
  protected final String TEXT_53 = ".size() > 0){" + NL + "\twsItem_";
  protected final String TEXT_54 = " =new org.talend.mdm.webservice.WSWhereItem(null,conditions_";
  protected final String TEXT_55 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_56 = ".size()]),null);" + NL + "}" + NL + "org.talend.mdm.webservice.WSString wsCount_";
  protected final String TEXT_57 = " = xtentisWS_";
  protected final String TEXT_58 = ".count(" + NL + "\t\tnew org.talend.mdm.webservice.WSCount(dataCluster_";
  protected final String TEXT_59 = ",\"/\"+";
  protected final String TEXT_60 = ",wsItem_";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = "));" + NL + "int wsNum_";
  protected final String TEXT_63 = " = Integer.parseInt(wsCount_";
  protected final String TEXT_64 = ".getValue());" + NL + "int limit_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = ";" + NL + "if(limit_";
  protected final String TEXT_67 = " > 0 && wsNum_";
  protected final String TEXT_68 = " > limit_";
  protected final String TEXT_69 = "){" + NL + "\twsNum_";
  protected final String TEXT_70 = " = limit_";
  protected final String TEXT_71 = ";" + NL + "}" + NL + "" + NL + "org.talend.mdm.webservice.WSGetItems getitems_";
  protected final String TEXT_72 = "=null;" + NL + "int loop_";
  protected final String TEXT_73 = " = (int)(wsNum_";
  protected final String TEXT_74 = "+";
  protected final String TEXT_75 = "-1)/";
  protected final String TEXT_76 = ";" + NL + "" + NL + "for(int i_";
  protected final String TEXT_77 = "=0;i_";
  protected final String TEXT_78 = " <loop_";
  protected final String TEXT_79 = "; i_";
  protected final String TEXT_80 = "++){" + NL + "\t" + NL + "\tif(i_";
  protected final String TEXT_81 = " !=loop_";
  protected final String TEXT_82 = "-1){" + NL + "\t\tgetitems_";
  protected final String TEXT_83 = "=new org.talend.mdm.webservice.WSGetItems(dataCluster_";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ", wsItem_";
  protected final String TEXT_86 = "," + NL + "\t\t\t\t    \t";
  protected final String TEXT_87 = ",  //spell Threshold" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_88 = " + i_";
  protected final String TEXT_89 = " * ";
  protected final String TEXT_90 = ",\t\t//start" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = ");" + NL + "\t}else{" + NL + "\t\tgetitems_";
  protected final String TEXT_92 = "=new org.talend.mdm.webservice.WSGetItems(dataCluster_";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ", wsItem_";
  protected final String TEXT_95 = "," + NL + "\t\t\t\t    \t";
  protected final String TEXT_96 = ",  //spell Threshold" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_97 = " + i_";
  protected final String TEXT_98 = " * ";
  protected final String TEXT_99 = ",\t\t//start" + NL + "\t\t\t\t\t\twsNum_";
  protected final String TEXT_100 = " - i_";
  protected final String TEXT_101 = " * ";
  protected final String TEXT_102 = ");" + NL + "\t}" + NL + "\tString[] items_";
  protected final String TEXT_103 = " = xtentisWS_";
  protected final String TEXT_104 = ".getItems(getitems_";
  protected final String TEXT_105 = ");" + NL + "\tfor(String item_";
  protected final String TEXT_106 = " : items_";
  protected final String TEXT_107 = "){" + NL + "\t\tnb_line_";
  protected final String TEXT_108 = " ++;" + NL + "\t\tString ";
  protected final String TEXT_109 = "_xml = item_";
  protected final String TEXT_110 = ";\t";
  protected final String TEXT_111 = NL + NL;

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
	String concept = ElementParameterParser.getValue(node, "__CONCEPT__");
	
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	
	boolean useWhere = ("true").equals(ElementParameterParser.getValue(node, "__USE_ITEMS__"));
	List<Map<String, String>> ids = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__IDS__");
	List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
	
	String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
	String skip = ElementParameterParser.getValue(node, "__SKIP__");
	String bufferSize = ElementParameterParser.getValue(node, "__FETCHSIZE__");
	String limit = ElementParameterParser.getValue(node, "__MAXVALUE__");
	if(spellThrehold==null || ("").equals(spellThrehold)){
		spellThrehold = "0";
	}
	if(skip==null || ("").equals(skip)){
		skip = "0";
	}
	if(limit==null || ("").equals(limit)){
		limit = "0";
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
    if(!useWhere){//item
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
	for(int i=0; i<ids.size(); i++){
		Map<String, String> map = ids.get(i);
		String idValue = map.get("IDVALUE");

    stringBuffer.append(TEXT_24);
    stringBuffer.append((i==0? "":","));
    stringBuffer.append(idValue );
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
}else{//items

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
	for(int i=0; i < operations.size(); i++){
		Map<String, String> map= operations.get(i);
		String xpath=map.get("XPATH");
		String operator=map.get("FUNCTION");
		String value = map.get("VALUE");
		String predicate = map.get("PREDICATE");

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
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
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(spellThrehold );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(bufferSize);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(bufferSize);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(spellThrehold );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(skip);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(spellThrehold );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(skip);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
}

    stringBuffer.append(TEXT_111);
    
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
