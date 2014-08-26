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

public class TXMLRPCOpenDASMainJava
{
  protected static String nl;
  public static synchronized TXMLRPCOpenDASMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLRPCOpenDASMainJava result = new TXMLRPCOpenDASMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "//DEBUG DISPLAY" + NL + "java.io.PrintStream consoleOut_";
  protected final String TEXT_2 = " = null;" + NL + "if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "{" + NL + "   \tconsoleOut_";
  protected final String TEXT_3 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "}" + NL + "else" + NL + "{" + NL + "\tconsoleOut_";
  protected final String TEXT_4 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "\tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_5 = ");" + NL + "}" + NL;
  protected final String TEXT_6 = NL + "    consoleOut_";
  protected final String TEXT_7 = ".println(\"";
  protected final String TEXT_8 = "\" + \" received parameters : \" + ";
  protected final String TEXT_9 = ".toString());consoleOut_";
  protected final String TEXT_10 = ".flush();" + NL + "" + NL + "\t//Retrieving input parameters (These parameters come from tMomObjectInput)" + NL + "\tString title_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".title;" + NL + "\tString sendUrl_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".sendUrl;" + NL + "\tString fromUrl_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ".fromUrl;\t" + NL + "\tDate sendedDate_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ".sendedDate;" + NL + "\tString station_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ".station;" + NL + "\tjava.util.Map checkingMap = (java.util.Map) ";
  protected final String TEXT_21 = ".attachement;" + NL + "\t" + NL + "\tObject[] tab = checkingMap.keySet().toArray();" + NL + "\tredstone.xmlrpc.XmlRpcStruct vals = new redstone.xmlrpc.XmlRpcStruct();" + NL + "\tfor(int i = 0; i < tab.length; i++) {";
  protected final String TEXT_22 = NL + "\t\t\tif(";
  protected final String TEXT_23 = ".equals(tab[i]))" + NL + "\t\t\t{" + NL + "\t\t\t\tvals.put(";
  protected final String TEXT_24 = ",checkingMap.get(tab[i]));" + NL + "\t\t\t}";
  protected final String TEXT_25 = NL + "\t}" + NL + "\t//Initialization output parameters" + NL + "\tString title_out_";
  protected final String TEXT_26 = " = null;" + NL + "\tString sendUrl_out_";
  protected final String TEXT_27 = " = null;" + NL + "\tString fromUrl_out_";
  protected final String TEXT_28 = " = null;" + NL + "\tDate sendedDate_out_";
  protected final String TEXT_29 = " = null;" + NL + "\tString station_out_";
  protected final String TEXT_30 = " = null;" + NL + "\tObject attachement_out_";
  protected final String TEXT_31 = " = null;" + NL + "\torg.opendas.modele.DASError result = new org.opendas.modele.DASError();" + NL + "\t" + NL + "\ttry" + NL + "\t{";
  protected final String TEXT_32 = NL + "\t\t\tconsoleOut_";
  protected final String TEXT_33 = ".println(\"";
  protected final String TEXT_34 = "\" + \" Connexion Magento \");consoleOut_";
  protected final String TEXT_35 = ".flush();" + NL + "\t\t\tOpenDAS_xmlrpc.Magento_connect connexion";
  protected final String TEXT_36 = " = new OpenDAS_xmlrpc.Magento_connect(";
  protected final String TEXT_37 = ",";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\tconsoleOut_";
  protected final String TEXT_42 = ".println(\"";
  protected final String TEXT_43 = "\" + \" Connexion ASPerpgi \");consoleOut_";
  protected final String TEXT_44 = ".flush();" + NL + "\t\t\tOpenDAS_xmlrpc.OpenERP_V5_connect connexion";
  protected final String TEXT_45 = " = new OpenDAS_xmlrpc.OpenERP_V5_connect(";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ",";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + NL + "\t\tjava.util.List<Object[]> context_search_tmp = new java.util.ArrayList<Object[]>();";
  protected final String TEXT_53 = NL + "\t\t\tif(checkingMap.get(";
  protected final String TEXT_54 = ") != null && ";
  protected final String TEXT_55 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\tcontext_search_tmp.add(new Object[]{";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ",checkingMap.get(";
  protected final String TEXT_58 = ")});" + NL + "\t\t\t}";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = NL + "\t\t\tcontext_search_tmp.add(new Object[]{";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = "});";
  protected final String TEXT_64 = NL + NL + "\t\tObject[] context_search = new Object[context_search_tmp.size()];" + NL + "\t\tfor(int i=0; i < context_search_tmp.size(); ++i)" + NL + "\t\t{" + NL + "\t\t\tcontext_search[i] = context_search_tmp.get(i);" + NL + "\t\t}" + NL + "" + NL + "" + NL + "" + NL + "\t\tconsoleOut_";
  protected final String TEXT_65 = ".println(\"";
  protected final String TEXT_66 = "\" + \" XMLRpc : \"+";
  protected final String TEXT_67 = "+\" \"+";
  protected final String TEXT_68 = ");consoleOut_";
  protected final String TEXT_69 = ".flush();" + NL + "\t\tredstone.xmlrpc.XmlRpcStruct response";
  protected final String TEXT_70 = " = (redstone.xmlrpc.XmlRpcStruct)connexion";
  protected final String TEXT_71 = ".exec(";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ", vals, context_search);" + NL + "\t\tif(response";
  protected final String TEXT_74 = " != null)" + NL + "\t\t{" + NL + "\t\t\tSystem.out.println(\"response";
  protected final String TEXT_75 = " : \"+response";
  protected final String TEXT_76 = ");" + NL + "\t\t\tresult.setCode(response";
  protected final String TEXT_77 = ".getInteger(\"code\"));" + NL + "\t\t\tresult.setString(response";
  protected final String TEXT_78 = ".getString(\"string\"));" + NL + "\t\t\tjava.util.List<org.opendas.modele.DASGeneric> listgen = new java.util.ArrayList<org.opendas.modele.DASGeneric>();" + NL + "\t\t\t" + NL + "\t\t\tredstone.xmlrpc.XmlRpcArray res_array = null;" + NL + "\t\t\tres_array = (redstone.xmlrpc.XmlRpcArray)response";
  protected final String TEXT_79 = ".get(\"object\");" + NL + "\t\t\t" + NL + "\t\t\tObject retour = null;" + NL + "\t\t\tfor(int i=0; i < res_array.size(); ++i)" + NL + "\t\t\t{" + NL + "\t\t\t\torg.opendas.modele.DASGeneric tmp_generic = new org.opendas.modele.DASGeneric();" + NL + "\t\t\t\tredstone.xmlrpc.XmlRpcStruct tmp_dict = null;" + NL + "\t\t\t\ttmp_dict = (redstone.xmlrpc.XmlRpcStruct) res_array.get(i);" + NL + "\t\t\t\ttmp_generic.setInfos(connexion";
  protected final String TEXT_80 = ".convert(tmp_dict));";
  protected final String TEXT_81 = NL + "\t\t\t\t\tif(\"";
  protected final String TEXT_82 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\t\t\tif(\"";
  protected final String TEXT_83 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\t\t\t\tretour = (Object)new Integer(tmp_dict.getInteger(";
  protected final String TEXT_84 = "));" + NL + "\t\t\t\t\t\t} else if(\"";
  protected final String TEXT_85 = "\".equals(\"String\")) {" + NL + "\t\t\t\t\t\t\tretour = (Object)new Integer(tmp_dict.getInteger(";
  protected final String TEXT_86 = "));" + NL + "\t\t\t\t\t\t\tretour = (Object) ((Integer)retour).toString();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse if(\"";
  protected final String TEXT_87 = "\".equals(\"String\")) {" + NL + "\t\t\t\t\t\tif(\"";
  protected final String TEXT_88 = "\".equals(\"Integer\")) {" + NL + "\t\t\t\t\t\t\tretour = (Object)new Integer(-1);" + NL + "\t\t\t\t\t\t} else if(\"";
  protected final String TEXT_89 = "\".equals(\"String\")) {" + NL + "\t\t\t\t\t\t\tretour = (Object)new String(tmp_dict.getString(";
  protected final String TEXT_90 = "));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (retour != null && (retour instanceof Integer || retour instanceof String) ) {" + NL + "\t\t\t\t\t\ttmp_generic.";
  protected final String TEXT_91 = "((";
  protected final String TEXT_92 = ")retour);" + NL + "\t\t\t\t\t\ttmp_generic.setPage(0);" + NL + "\t\t\t\t\t\ttmp_generic.setPosition(0);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_93 = NL + "\t\t\t\tlistgen.add(tmp_generic);" + NL + "\t\t\t}" + NL + "\t\t\tresult.setObject(listgen);" + NL + "\t\t}" + NL + "\t\telse\t\t\t\t\t\t\t" + NL + "\t\t{" + NL + "            System.out.println(\"ERROR : On ext response\");" + NL + "" + NL + "\t\t\tresult.setCode(1);" + NL + "" + NL + "\t\t\tresult.setString(\"ERROR : On ext response\");" + NL + "" + NL + "\t\t}" + NL + "\t" + NL + "\t}" + NL + "\tcatch(redstone.xmlrpc.XmlRpcException e)" + NL + "\t{" + NL + "\t\tSystem.out.println(\"ERROR XMLRPC : \"+e.toString());" + NL + "\t\tresult.setCode(2);" + NL + "\t\tresult.setString(\"ERROR XMLRPC : \"+e.toString());" + NL + "\t}" + NL + "\tcatch(Exception e)" + NL + "\t{" + NL + "\t\tSystem.out.println(\"ERROR : \"+e.toString());" + NL + "\t\tresult.setCode(3);" + NL + "\t\tresult.setString(\"ERROR : \"+e.toString());" + NL + "\t}" + NL + "\tSystem.out.println(\"result :\"+result);" + NL + "\t" + NL + "\t//Transmission of parameters to tMomObjectOutput component ( none output here)" + NL + "\tObject[] results_";
  protected final String TEXT_94 = " = {title_";
  protected final String TEXT_95 = ", sendUrl_";
  protected final String TEXT_96 = ", fromUrl_";
  protected final String TEXT_97 = ", sendedDate_";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ".attachement, station_";
  protected final String TEXT_100 = "," + NL + "\t\t   \t title_out_";
  protected final String TEXT_101 = ", sendUrl_out_";
  protected final String TEXT_102 = ", fromUrl_out_";
  protected final String TEXT_103 = ", sendedDate_out_";
  protected final String TEXT_104 = ", result , station_out_";
  protected final String TEXT_105 = "};" + NL + "" + NL + "      for (int i_";
  protected final String TEXT_106 = " = 0; i_";
  protected final String TEXT_107 = " < results_";
  protected final String TEXT_108 = ".length ; i_";
  protected final String TEXT_109 = "++) {" + NL + "" + NL + "" + NL + "// for output";
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = NL + "\t\t\t//We set the results in the output connections" + NL + "\t\t\tif(";
  protected final String TEXT_112 = " < results_";
  protected final String TEXT_113 = ".length && results_";
  protected final String TEXT_114 = "[";
  protected final String TEXT_115 = "]!=null){\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = (String) results_";
  protected final String TEXT_119 = "[";
  protected final String TEXT_120 = "];";
  protected final String TEXT_121 = NL + "\t\t\t\t\t";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = (Object) results_";
  protected final String TEXT_124 = "[";
  protected final String TEXT_125 = "];";
  protected final String TEXT_126 = NL + "\t\t\t\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = (Date) results_";
  protected final String TEXT_129 = "[";
  protected final String TEXT_130 = "];";
  protected final String TEXT_131 = NL + "\t\t\t\t\t";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = results_";
  protected final String TEXT_134 = "[";
  protected final String TEXT_135 = "].getBytes();";
  protected final String TEXT_136 = NL + "\t\t\t\t\t";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " = (Integer) results_";
  protected final String TEXT_139 = "[";
  protected final String TEXT_140 = "];\t";
  protected final String TEXT_141 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " = ParserUtils.parseTo_";
  protected final String TEXT_144 = " ((String) results_";
  protected final String TEXT_145 = "[";
  protected final String TEXT_146 = "]);";
  protected final String TEXT_147 = NL + "\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "      \t\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = "  " + NL + "}" + NL + NL;
  protected final String TEXT_158 = NL;

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
        String  method = ElementParameterParser.getValue(node,"__METHOD__");
        String  model = ElementParameterParser.getValue(node,"__MODEL__");
        String  type = ElementParameterParser.getValue(node,"__TYPE__");
        List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
        List<Map<String, String>> out_mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__OUT_MAPPING__");
        List<Map<String, String>> filter = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
        List<Map<String, String>> filter_const = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER_CONST__");

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_21);
    
		for (Map<String, String> mappingline : mapping){
			String field_name = (String)mappingline.get("NAME");
			String field = (String)mappingline.get("FIELD");

    stringBuffer.append(TEXT_22);
    stringBuffer.append(field_name);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_24);
    
		}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		if(type.equals("magento"))
		{

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_40);
    
		}
		else
		{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_50);
    
		}

    stringBuffer.append(TEXT_51);
    
		int nb_filter = filter.size();

    stringBuffer.append(TEXT_52);
    		
		for (Map<String, String> filterline : filter){
			String key = (String)filterline.get("NAME");
			String val = (String)filterline.get("FIELD");
			String ope = (String)filterline.get("OPERATOR");

    stringBuffer.append(TEXT_53);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_58);
    
		}

    stringBuffer.append(TEXT_59);
    		
		for (Map<String, String> filterline : filter_const){
			String value = (String)filterline.get("VALUE");
			String val = (String)filterline.get("FIELD");
			String ope = (String)filterline.get("OPERATOR");

    stringBuffer.append(TEXT_60);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ope);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_63);
    
		}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(model);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(model);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(method);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    				
				for (Map<String, String> out_mappingline : out_mapping){
					String field_ext = (String)out_mappingline.get("FIELD");
					String method_das = (String)out_mappingline.get("METHOD");
					String type_ext = (String)out_mappingline.get("TYPE_EXT");
					String type_das = (String)out_mappingline.get("TYPE_DAS");

    stringBuffer.append(TEXT_81);
    stringBuffer.append(type_ext);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(type_das);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(field_ext);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(type_das);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(field_ext);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(type_ext);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(type_das);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(type_das);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(field_ext);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(method_das);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(type_das);
    stringBuffer.append(TEXT_92);
    
				}

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

	
	String firstConnName = "";
	//si l'on a des connexions
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3


				
    stringBuffer.append(TEXT_110);
    			//for each expected value in the output connection
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_115);
    
					if(javaType == JavaTypesManager.STRING ) { //String or Object

    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_120);
    
					} else if(javaType == JavaTypesManager.OBJECT) { //Date

    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_125);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_130);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_135);
    
					} else if(javaType == JavaTypesManager.INTEGER) { //int

    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_140);
    
					} else  { //other

    stringBuffer.append(TEXT_141);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_146);
    
					}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_150);
    			
			} //4
		}//3
		
		//for each connections after the first,we copy the output fields
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1 (end outgoing connection)

}//1 bis (end outgoing connection)

    stringBuffer.append(TEXT_156);
    }
 }

 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(TEXT_158);
    return stringBuffer.toString();
  }
}
