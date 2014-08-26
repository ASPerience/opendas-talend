package org.talend.designer.codegen.translators.opendas;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.*;

public class TXMLRPCGenericMainJava
{
  protected static String nl;
  public static synchronized TXMLRPCGenericMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLRPCGenericMainJava result = new TXMLRPCGenericMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "//DEBUG AFFICHAGE" + NL + "java.io.PrintStream consoleOut_";
  protected final String TEXT_2 = " = null;" + NL + "if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "{" + NL + "   \tconsoleOut_";
  protected final String TEXT_3 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "}" + NL + "else" + NL + "{" + NL + "\tconsoleOut_";
  protected final String TEXT_4 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "\tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_5 = ");" + NL + "}" + NL;
  protected final String TEXT_6 = NL + "\tSystem.out.println(\"";
  protected final String TEXT_7 = "\" + \" paramètres reçus : \" + ";
  protected final String TEXT_8 = ".toString());//DEBUG" + NL + "//\tconsoleOut_";
  protected final String TEXT_9 = ".flush();//DEBUG" + NL + "" + NL + "\t//Récupération des paramètres en entrée (ces paramètres viennent de tMomObjectInput)" + NL + "\tString title_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".title;" + NL + "\tString sendUrl_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".sendUrl;" + NL + "\tString fromUrl_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ".fromUrl;\t" + NL + "\tDate sendedDate_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ".sendedDate;" + NL + "\tString station_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ".station;" + NL + "\tjava.util.Map pointageMap = (java.util.Map) ";
  protected final String TEXT_20 = ".attachement;" + NL + "\t" + NL + "\tObject[] tab = pointageMap.keySet().toArray();" + NL + "\tredstone.xmlrpc.XmlRpcStruct vals = new redstone.xmlrpc.XmlRpcStruct();" + NL + "\tfor(int i = 0; i < tab.length; i++)" + NL + "\t\tvals.put(tab[i],pointageMap.get(tab[i]));" + NL + "\t" + NL + "\t//Initialisation des paramètres en sortie" + NL + "\tString title_out_";
  protected final String TEXT_21 = " = null;" + NL + "\tString sendUrl_out_";
  protected final String TEXT_22 = " = null;" + NL + "\tString fromUrl_out_";
  protected final String TEXT_23 = " = null;" + NL + "\tDate sendedDate_out_";
  protected final String TEXT_24 = " = null;" + NL + "\tString station_out_";
  protected final String TEXT_25 = " = null;" + NL + "\tObject attachement_out_";
  protected final String TEXT_26 = " = null;" + NL + "\tjava.util.List<org.opendas.modele.DASGeneric> result = new java.util.ArrayList<org.opendas.modele.DASGeneric>();" + NL + "" + NL + "\tASPerpgi_xmlrpc.ASPerpgi_connect connexion";
  protected final String TEXT_27 = " = new ASPerpgi_xmlrpc.ASPerpgi_connect(";
  protected final String TEXT_28 = ",";
  protected final String TEXT_29 = ",";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = ");" + NL + "\t" + NL + "\tjava.util.List<Object[]> context_search_tmp = new java.util.ArrayList<Object[]>();" + NL + "\tjava.util.List<String> context_read_tmp = new java.util.ArrayList<String>();";
  protected final String TEXT_33 = NL + "\t\tif(pointageMap.get(";
  protected final String TEXT_34 = ") != null && ";
  protected final String TEXT_35 = " != null)" + NL + "\t\t{" + NL + "\t\t\tcontext_search_tmp.add(new Object[]{";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ",pointageMap.get(";
  protected final String TEXT_38 = ")});" + NL + "\t\t}";
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = NL + "\t\tcontext_search_tmp.add(new Object[]{";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ",";
  protected final String TEXT_43 = "});";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "\t\tcontext_read_tmp.add(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + NL + "\tObject[] context_search = new Object[context_search_tmp.size()];" + NL + "\tfor(int i=0; i < context_search_tmp.size(); ++i)" + NL + "\t{" + NL + "\t\tcontext_search[i] = context_search_tmp.get(i);" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\tif (context_read_tmp.size() == 0) {" + NL + "\t\tcontext_read_tmp.add(\"id\");" + NL + "\t\tcontext_read_tmp.add(\"name\");" + NL + "\t}" + NL + "\tObject[] context_read = new Object[context_read_tmp.size()];" + NL + "\tfor(int i=0; i < context_read_tmp.size(); ++i)" + NL + "\t{" + NL + "\t\tcontext_read[i] = (Object)context_read_tmp.get(i);" + NL + "\t}" + NL + "\t" + NL + "\tSystem.out.println(\"context_read : \"+context_read_tmp);" + NL + "\t" + NL + "\tredstone.xmlrpc.XmlRpcArray res_array = null;" + NL + "\tSystem.out.println(";
  protected final String TEXT_48 = ");" + NL + "\tres_array = connexion";
  protected final String TEXT_49 = ".search(";
  protected final String TEXT_50 = ", context_search);" + NL + "\tSystem.out.println(\"Search : \"+res_array);" + NL + "\tres_array = connexion";
  protected final String TEXT_51 = ".special_read(";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ", (Object[])res_array.toArray(), context_read );" + NL + "\tSystem.out.println(\"Read : \"+res_array);" + NL + "\tObject retour = null;" + NL + "\tfor(int i=0; i < res_array.size(); ++i)" + NL + "\t{" + NL + "\t\torg.opendas.modele.DASGeneric tmp_generic = new org.opendas.modele.DASGeneric();" + NL + "\t\tredstone.xmlrpc.XmlRpcStruct tmp_dict = null;" + NL + "\t\ttmp_dict = (redstone.xmlrpc.XmlRpcStruct) res_array.get(i);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\t\t" + NL + "\t\t\tif(\"";
  protected final String TEXT_55 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\tif(\"";
  protected final String TEXT_56 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\t\tretour = (Object)new Integer(tmp_dict.getInteger(";
  protected final String TEXT_57 = "));" + NL + "\t\t\t\t} else if(\"";
  protected final String TEXT_58 = "\".equals(\"String\")) {" + NL + "\t\t\t\t\tretour = (Object)new Integer(tmp_dict.getInteger(";
  protected final String TEXT_59 = "));" + NL + "\t\t\t\t\tretour = (Object) ((Integer)retour).toString();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\telse if(\"";
  protected final String TEXT_60 = "\".equals(\"String\")) {" + NL + "\t\t\t\tif(\"";
  protected final String TEXT_61 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\t\tretour = (Object)new Integer(-1);" + NL + "\t\t\t\t} else if(\"";
  protected final String TEXT_62 = "\".equals(\"String\")) {" + NL + "\t\t\t\t\tretour = (Object)new String(tmp_dict.getString(";
  protected final String TEXT_63 = "));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (retour != null && (retour instanceof Integer || retour instanceof String) ) {" + NL + "\t\t\t\ttmp_generic.";
  protected final String TEXT_64 = "((";
  protected final String TEXT_65 = ")retour);" + NL + "\t\t\t\ttmp_generic.setPage(0);" + NL + "\t\t\t\ttmp_generic.setPosition(0);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\tresult.add(tmp_generic);" + NL + "\t}" + NL + "" + NL + "\t//transmission des paramètres au composant tMomObjectOutput (pas de sortie ici)" + NL + "\tObject[] results_";
  protected final String TEXT_67 = " = {title_";
  protected final String TEXT_68 = ", sendUrl_";
  protected final String TEXT_69 = ", fromUrl_";
  protected final String TEXT_70 = ", sendedDate_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ".attachement, station_";
  protected final String TEXT_73 = "," + NL + "\t\t   \t title_out_";
  protected final String TEXT_74 = ",sendUrl_out_";
  protected final String TEXT_75 = ", fromUrl_out_";
  protected final String TEXT_76 = ", sendedDate_out_";
  protected final String TEXT_77 = ", result , station_out_";
  protected final String TEXT_78 = "};" + NL + "" + NL + "      for (int i_";
  protected final String TEXT_79 = " = 0; i_";
  protected final String TEXT_80 = " < results_";
  protected final String TEXT_81 = ".length ; i_";
  protected final String TEXT_82 = "++) {" + NL + "" + NL + "" + NL + "// for output";
  protected final String TEXT_83 = NL + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t" + NL + "\t\t\t//on place les résultats dans les connexions de sortie" + NL + "\t\t\tif(";
  protected final String TEXT_85 = " < results_";
  protected final String TEXT_86 = ".length && results_";
  protected final String TEXT_87 = "[";
  protected final String TEXT_88 = "]!=null){\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = (String) results_";
  protected final String TEXT_92 = "[";
  protected final String TEXT_93 = "];";
  protected final String TEXT_94 = NL + "\t\t\t\t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = (Object) results_";
  protected final String TEXT_97 = "[";
  protected final String TEXT_98 = "];";
  protected final String TEXT_99 = NL + "\t\t\t\t\t";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = (Date) results_";
  protected final String TEXT_102 = "[";
  protected final String TEXT_103 = "];";
  protected final String TEXT_104 = NL + "\t\t\t\t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = results_";
  protected final String TEXT_107 = "[";
  protected final String TEXT_108 = "].getBytes();";
  protected final String TEXT_109 = NL + "\t\t\t\t\t";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = (Integer) results_";
  protected final String TEXT_112 = "[";
  protected final String TEXT_113 = "];\t";
  protected final String TEXT_114 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " = ParserUtils.parseTo_";
  protected final String TEXT_117 = " ((String) results_";
  protected final String TEXT_118 = "[";
  protected final String TEXT_119 = "]);";
  protected final String TEXT_120 = NL + "\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "      \t\t\t";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = "  " + NL + "}" + NL + NL;
  protected final String TEXT_131 = NL;

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
		String host = ElementParameterParser.getValue(node,"__SERVER-HOST__");
		String port = ElementParameterParser.getValue(node,"__SERVER-PORT__");
		String dbname = ElementParameterParser.getValue(node,"__AUTH_DBNAME__");
		String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
		String uid = ElementParameterParser.getValue(node,"__AUTH_UID__");
		String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");
        String  model = ElementParameterParser.getValue(node,"__MODEL__");
        String  method = ElementParameterParser.getValue(node,"__METHOD__");
        List<Map<String, String>> filter = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
        List<Map<String, String>> filter_const = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER_CONST__");
        List<Map<String, String>> out_mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__OUT_MAPPING__");
        

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
        List< ? extends IConnection> inConns = node.getIncomingConnections();
		String inputRowName = new String("input_row");
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            inputRowName = inConn.getName();

    
		List<IMetadataColumn> columns=metadata.getListColumns();
		int columnSize = columns.size();


    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_32);
    		
	for (Map<String, String> filterline : filter){
		String key = (String)filterline.get("NAME");
		String val = (String)filterline.get("FIELD");
		String ope = (String)filterline.get("OPERATOR");

    stringBuffer.append(TEXT_33);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    		
	for (Map<String, String> filterline : filter_const){
		String value = (String)filterline.get("VALUE");
		String val = (String)filterline.get("FIELD");
		String ope = (String)filterline.get("OPERATOR");

    stringBuffer.append(TEXT_40);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_43);
    
	}

    stringBuffer.append(TEXT_44);
    		
	for (Map<String, String> out_mappingline : out_mapping){
		String val = (String)out_mappingline.get("FIELD");
		String dasmethod = (String)out_mappingline.get("METHOD");

    stringBuffer.append(TEXT_45);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_46);
    
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(model);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(model);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(model);
    stringBuffer.append(TEXT_53);
    		
		for (Map<String, String> out_mappingline : out_mapping){
			String dasval = (String)out_mappingline.get("FIELD");
			String dasmethod = (String)out_mappingline.get("METHOD");
			String asptype = (String)out_mappingline.get("TYPE_ASP");
			String dastype = (String)out_mappingline.get("TYPE_DAS");

    stringBuffer.append(TEXT_54);
    stringBuffer.append(asptype);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(dastype);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dasval);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dastype);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dasval);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(asptype);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dastype);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(dastype);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(dasval);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dasmethod);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(dastype);
    stringBuffer.append(TEXT_65);
    
		}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

	
	String firstConnName = "";
	//si l'on a des connexions
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3


				
    stringBuffer.append(TEXT_83);
    			//pour chaque valeur attendue dans la connexion de sortie
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_88);
    
					if(javaType == JavaTypesManager.STRING ) { //String or Object

    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_93);
    
					} else if(javaType == JavaTypesManager.OBJECT) { //Date

    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_98);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_103);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_108);
    
					} else if(javaType == JavaTypesManager.INTEGER) { //int

    stringBuffer.append(TEXT_109);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_113);
    
					} else  { //other

    stringBuffer.append(TEXT_114);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_119);
    
					}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_123);
    			
			} //4
		}//3
		
		//pour chacune des connexions après la première, on recopie les champs de sortie
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1 (fin connexion sortante)

}//1 bis (fin connexion entrante)

    stringBuffer.append(TEXT_129);
    }
 }

 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(TEXT_131);
    return stringBuffer.toString();
  }
}
