package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;
import java.util.List;

public class TXMLRPCDASSsccMainJava
{
  protected static String nl;
  public static synchronized TXMLRPCDASSsccMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLRPCDASSsccMainJava result = new TXMLRPCDASSsccMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.apache.xmlrpc.client.XmlRpcClientConfigImpl config";
  protected final String TEXT_2 = "= new org.apache.xmlrpc.client.XmlRpcClientConfigImpl();" + NL + "config";
  protected final String TEXT_3 = ".setServerURL(new java.net.URL(";
  protected final String TEXT_4 = "));" + NL + "config";
  protected final String TEXT_5 = ".setEnabledForExtensions(true);  " + NL + "config";
  protected final String TEXT_6 = ".setConnectionTimeout(60 * 1000);" + NL + "config";
  protected final String TEXT_7 = ".setReplyTimeout(60 * 1000);" + NL + "" + NL + "" + NL + "" + NL + "//DEBUG AFFICHAGE" + NL + "java.io.PrintStream consoleOut_";
  protected final String TEXT_8 = " = null;" + NL + "if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "{" + NL + "   \tconsoleOut_";
  protected final String TEXT_9 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "}" + NL + "else" + NL + "{" + NL + "\tconsoleOut_";
  protected final String TEXT_10 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "\tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_11 = ");" + NL + "}" + NL + NL + NL;
  protected final String TEXT_12 = NL + NL + "\t" + NL + "    consoleOut_";
  protected final String TEXT_13 = ".println(\"";
  protected final String TEXT_14 = "\" + \" paramètres reçus : \" + ";
  protected final String TEXT_15 = ".toString());//DEBUG" + NL + "\tconsoleOut_";
  protected final String TEXT_16 = ".flush();//DEBUG" + NL + "" + NL + "" + NL + "" + NL + "org.apache.xmlrpc.client.XmlRpcClient client";
  protected final String TEXT_17 = " = new org.apache.xmlrpc.client.XmlRpcClient();" + NL + "// use Commons HttpClient as transport" + NL + " client";
  protected final String TEXT_18 = ".setTransportFactory(" + NL + "              new org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory(client";
  protected final String TEXT_19 = "));" + NL + "          // set configuration" + NL + "\tclient";
  protected final String TEXT_20 = ".setConfig(config";
  protected final String TEXT_21 = ");" + NL + "          // make the a regular call" + NL + "\t\t\t" + NL + "//Récupération des paramètres en entrée (ces paramètres ont été extraits dans le tMomObjectInput)" + NL + "" + NL + "String title_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".title;" + NL + "String sendUrl_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".sendUrl;" + NL + "String fromUrl_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ".fromUrl;" + NL + "Date sendedDate_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".sendedDate;" + NL + "org.opendas.modele.DASSscc lotPese_";
  protected final String TEXT_30 = " = (org.opendas.modele.DASSscc) ";
  protected final String TEXT_31 = ".attachement;" + NL + "String station_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ".station;" + NL + "" + NL + "" + NL + "\t//Paramétrage de la requête create stock.tracking" + NL + "\tjava.util.Hashtable<String, Object> varsDASSscc = new java.util.Hashtable<String, Object>();" + NL + "\tvarsDASSscc.put(\"production_date\", lotPese_";
  protected final String TEXT_34 = ".getProduction_date());" + NL + "\tvarsDASSscc.put(\"expiry_date\", lotPese_";
  protected final String TEXT_35 = ".getExpiry_date());" + NL + "\tvarsDASSscc.put(\"lot_date\", lotPese_";
  protected final String TEXT_36 = ".getLot_date());" + NL + "\tvarsDASSscc.put(\"quantity\", lotPese_";
  protected final String TEXT_37 = ".getQuantity());" + NL + "//\tvarsDASSscc.put(\"ean_code\", lotPese_";
  protected final String TEXT_38 = ".getEan_code()); pas renseigné pour l'instant" + NL + "\tObject[] paramsDASSscc_";
  protected final String TEXT_39 = " = new Object[]{";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ",\"stock.tracking\", \"create\", varsDASSscc};" + NL + "" + NL + "" + NL + "\t//Envoi de la requête create das.sscc" + NL + "\tObject DASSsccId_";
  protected final String TEXT_43 = " = client";
  protected final String TEXT_44 = ".execute(";
  protected final String TEXT_45 = ", paramsDASSscc_";
  protected final String TEXT_46 = ");" + NL + "\tint tracking_id_";
  protected final String TEXT_47 = " = Integer.parseInt(DASSsccId_";
  protected final String TEXT_48 = ".toString());" + NL + "\tconsoleOut_";
  protected final String TEXT_49 = ".println(\"";
  protected final String TEXT_50 = " stock.tracking - create, ids = \" + tracking_id_";
  protected final String TEXT_51 = ");//DEBUG" + NL + "\tconsoleOut_";
  protected final String TEXT_52 = ".flush();//DEBUG" + NL + "" + NL + "//On récupère le sscc du stock_tracking créé" + NL + "\t//Paramétrage de la requête read stock.tracking" + NL + "\tString[] search_detail = new String[] {\"name\"};\t" + NL + "\tObject[] paramsRead = new Object[]{\"openerp\", ";
  protected final String TEXT_53 = ", \"admin\",\"stock.tracking\", \"read\", tracking_id_";
  protected final String TEXT_54 = ", search_detail};" + NL + "" + NL + "\t//Envoi de la requête read stock.tracking" + NL + "\tObject namesearchRead = (client";
  protected final String TEXT_55 = ".execute(";
  protected final String TEXT_56 = ", paramsRead));" + NL + "\tjava.util.HashMap ReadSsccMap = (java.util.HashMap) namesearchRead;" + NL + "\tString readSscc = ReadSsccMap.get(\"name\").toString();" + NL + "\tconsoleOut_";
  protected final String TEXT_57 = ".println(\"";
  protected final String TEXT_58 = " stock.tracking - read, sscc = \" + readSscc);//DEBUG" + NL + "\tconsoleOut_";
  protected final String TEXT_59 = ".flush();//DEBUG" + NL + "" + NL + "" + NL + "//Transmission des paramètres au composant tMomObjectOutput" + NL + "\tObject[] results_";
  protected final String TEXT_60 = " = {title_";
  protected final String TEXT_61 = ", sendUrl_";
  protected final String TEXT_62 = ", fromUrl_";
  protected final String TEXT_63 = ", sendedDate_";
  protected final String TEXT_64 = ", readSscc, station_";
  protected final String TEXT_65 = "};" + NL + "" + NL + "" + NL + "\tfor (int i_";
  protected final String TEXT_66 = " = 0; i_";
  protected final String TEXT_67 = " < results_";
  protected final String TEXT_68 = ".length; i_";
  protected final String TEXT_69 = "++) {" + NL + "" + NL + "// for output";
  protected final String TEXT_70 = NL + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t" + NL + "\t\t\t" + NL + "\t\t\t//on place les résultats dans les connexions de sortie" + NL + "\t\t\tif(";
  protected final String TEXT_72 = " < results_";
  protected final String TEXT_73 = ".length && results_";
  protected final String TEXT_74 = "[";
  protected final String TEXT_75 = "]!=null){\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = (String) results_";
  protected final String TEXT_79 = "[";
  protected final String TEXT_80 = "];";
  protected final String TEXT_81 = NL + "\t\t\t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = (Date) results_";
  protected final String TEXT_84 = "[";
  protected final String TEXT_85 = "];";
  protected final String TEXT_86 = NL + "\t\t\t\t\t";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = results_";
  protected final String TEXT_89 = "[";
  protected final String TEXT_90 = "].getBytes();";
  protected final String TEXT_91 = NL + "\t\t\t\t\t";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = " = (Integer) results_";
  protected final String TEXT_94 = "[";
  protected final String TEXT_95 = "];\t";
  protected final String TEXT_96 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " = ParserUtils.parseTo_";
  protected final String TEXT_99 = " ((String) results_";
  protected final String TEXT_100 = "[";
  protected final String TEXT_101 = "]);";
  protected final String TEXT_102 = NL + "\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "      \t\t\t";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_111 = NL + "   ";
  protected final String TEXT_112 = "  " + NL + "}";
  protected final String TEXT_113 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        List<IMetadataColumn> listColumns = metadata.getListColumns(); 
        String needAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
        String authUsername = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
		String authPassword = ElementParameterParser.getValue(node, "__AUTH_PASSWORD__");
		String authUid = ElementParameterParser.getValue(node, "__AUTH_UID__");
        List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
        String  url=ElementParameterParser.getValue(node,"__SERVER-URL__");
        String  method=ElementParameterParser.getValue(node,"__METHOD__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// for input
        List< ? extends IConnection> inConns = node.getIncomingConnections();
		String inputRowName = new String("input_row");
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            inputRowName = inConn.getName();


    
List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();

			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(authUsername);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(authUid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(authPassword);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(authUid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3


				
    stringBuffer.append(TEXT_70);
    
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_75);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_80);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_85);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_90);
    
					} else if(javaType == JavaTypesManager.INTEGER) { //int

    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_95);
    
					} else  { //other

    stringBuffer.append(TEXT_96);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_101);
    
					}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_105);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_110);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1 (fin connexion sortante)

}//1 bis (fin connexion entrante)

    stringBuffer.append(TEXT_111);
    }
 }

 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}
