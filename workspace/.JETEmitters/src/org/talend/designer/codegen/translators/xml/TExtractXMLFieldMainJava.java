package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractXMLFieldMainJava
{
  protected static String nl;
  public static synchronized TExtractXMLFieldMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractXMLFieldMainJava result = new TExtractXMLFieldMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString xmlStr_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "\tString xmlStr_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "_xml;";
  protected final String TEXT_8 = NL + "\tString xmlStr_";
  protected final String TEXT_9 = " = null;" + NL + "\tif(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "!=null){" + NL + "\t\txmlStr_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ";" + NL + "\t}";
  protected final String TEXT_15 = NL + "\tif(xmlStr_";
  protected final String TEXT_16 = "!=null){// C_01";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = " = null;";
  protected final String TEXT_19 = NL + "\tNameSpaceTool_";
  protected final String TEXT_20 = " nsTool_";
  protected final String TEXT_21 = " = new NameSpaceTool_";
  protected final String TEXT_22 = "();" + NL + "    org.dom4j.io.SAXReader reader_";
  protected final String TEXT_23 = " = new org.dom4j.io.SAXReader();" + NL + "    org.dom4j.Document doc_";
  protected final String TEXT_24 = " = null;" + NL + "    java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_25 = " = null;" + NL + "    org.dom4j.XPath x_";
  protected final String TEXT_26 = " = null;" + NL + "    java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_27 = " = null;";
  protected final String TEXT_28 = NL + "\tString loopQuery_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "+";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "    \tString loopQuery_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tString loopQuery_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = "; " + NL + "\t";
  protected final String TEXT_38 = NL + "    boolean isStructError_";
  protected final String TEXT_39 = "= true;" + NL + "        " + NL + "    try{" + NL + "\t    doc_";
  protected final String TEXT_40 = "= reader_";
  protected final String TEXT_41 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_42 = "));" + NL + "\t    nsTool_";
  protected final String TEXT_43 = ".countNSMap(doc_";
  protected final String TEXT_44 = ".getRootElement());" + NL + "\t    xmlNameSpaceMap_";
  protected final String TEXT_45 = " = nsTool_";
  protected final String TEXT_46 = ".xmlNameSpaceMap;" + NL + "" + NL + "    \tx_";
  protected final String TEXT_47 = " = doc_";
  protected final String TEXT_48 = ".createXPath(nsTool_";
  protected final String TEXT_49 = ".addDefaultNSPrefix(loopQuery_";
  protected final String TEXT_50 = ",loopQuery_";
  protected final String TEXT_51 = "));" + NL + "      " + NL + "    \tx_";
  protected final String TEXT_52 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_53 = "); " + NL + "    " + NL + "    \tnodeList_";
  protected final String TEXT_54 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_55 = ".selectNodes(doc_";
  protected final String TEXT_56 = ");" + NL + "    \t" + NL + "    \tisStructError_";
  protected final String TEXT_57 = " = false;" + NL + "    \t" + NL + "    }catch(java.lang.Exception ex_";
  protected final String TEXT_58 = "){";
  protected final String TEXT_59 = NL + "\tthrow(ex_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t";
  protected final String TEXT_62 = " = new ";
  protected final String TEXT_63 = "Struct();";
  protected final String TEXT_64 = NL + "\t\t\txml_api_";
  protected final String TEXT_65 = ".putRejectValueBeforeExtract_";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "    ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = NL + "\t";
  protected final String TEXT_75 = ".errorXMLField = xmlStr_";
  protected final String TEXT_76 = ";" + NL + "\t";
  protected final String TEXT_77 = ".errorMessage = ex_";
  protected final String TEXT_78 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "    System.err.println(ex_";
  protected final String TEXT_81 = ".getMessage());";
  protected final String TEXT_82 = NL + "    }" + NL + "    " + NL + "    org.dom4j.Node node_";
  protected final String TEXT_83 = " = null;" + NL + "    String str_";
  protected final String TEXT_84 = " = \"\";" + NL + "    boolean resultIsNode_";
  protected final String TEXT_85 = " = true;" + NL + "    for(int i_";
  protected final String TEXT_86 = "=0; isStructError_";
  protected final String TEXT_87 = " || (nodeList_";
  protected final String TEXT_88 = "!=null && i_";
  protected final String TEXT_89 = " < nodeList_";
  protected final String TEXT_90 = ".size());i_";
  protected final String TEXT_91 = "++){" + NL + "    \t" + NL + "    \tif(!isStructError_";
  protected final String TEXT_92 = "){";
  protected final String TEXT_93 = NL + "\t\t\t";
  protected final String TEXT_94 = " = null;";
  protected final String TEXT_95 = NL + "    \t\t";
  protected final String TEXT_96 = " = new ";
  protected final String TEXT_97 = "Struct();" + NL + "    \t" + NL + "    \t\torg.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_98 = " = nodeList_";
  protected final String TEXT_99 = ".get(i_";
  protected final String TEXT_100 = ");" + NL + "\t" + NL + "\t    \tnb_line_";
  protected final String TEXT_101 = "++;\t";
  protected final String TEXT_102 = NL + "\t    \tif (nb_line_";
  protected final String TEXT_103 = ">";
  protected final String TEXT_104 = ") {" + NL + "\t    \t\tbreak;" + NL + "\t    \t}";
  protected final String TEXT_105 = NL + "\t\t\ttry{";
  protected final String TEXT_106 = NL + "\t\t\txml_api_";
  protected final String TEXT_107 = ".putUnExtractValue_";
  protected final String TEXT_108 = "(";
  protected final String TEXT_109 = ",";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t\t";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = ";";
  protected final String TEXT_116 = NL + "\t\t\txml_api_";
  protected final String TEXT_117 = ".putExtractValue_";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ",";
  protected final String TEXT_121 = "xmlStr_";
  protected final String TEXT_122 = ",temp_";
  protected final String TEXT_123 = ",nsTool_";
  protected final String TEXT_124 = ",loopQuery_";
  protected final String TEXT_125 = ",xmlNameSpaceMap_";
  protected final String TEXT_126 = ",node_";
  protected final String TEXT_127 = ",str_";
  protected final String TEXT_128 = ",xml_api_";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t\t\torg.dom4j.XPath xTmp";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = " = temp_";
  protected final String TEXT_133 = ".createXPath(nsTool_";
  protected final String TEXT_134 = ".addDefaultNSPrefix(";
  protected final String TEXT_135 = ",loopQuery_";
  protected final String TEXT_136 = "));" + NL + "\t\t\t    xTmp";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_139 = ");" + NL + "\t\t\t    Object obj";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = " = xTmp";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = ".evaluate(temp_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t    if(obj";
  protected final String TEXT_145 = "_";
  protected final String TEXT_146 = " instanceof String || obj";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = " instanceof Number){" + NL + "\t\t\t    \tresultIsNode_";
  protected final String TEXT_149 = " = false;" + NL + "    \t\t\t\tstr_";
  protected final String TEXT_150 = " = String.valueOf(obj";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = ");" + NL + "   \t\t\t\t}else{" + NL + "   \t\t\t\t\tresultIsNode_";
  protected final String TEXT_153 = " = true;" + NL + "\t\t\t\t    node_";
  protected final String TEXT_154 = " = xTmp";
  protected final String TEXT_155 = "_";
  protected final String TEXT_156 = ".selectSingleNode(temp_";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t\t\t\t\tstr_";
  protected final String TEXT_159 = " = node_";
  protected final String TEXT_160 = "==null?null:node_";
  protected final String TEXT_161 = ".asXML();";
  protected final String TEXT_162 = NL + "\t\t\t\t    str_";
  protected final String TEXT_163 = " = xTmp";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ".valueOf(temp_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\t\t\t}";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = str_";
  protected final String TEXT_171 = ";";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_177 = " && xml_api_";
  protected final String TEXT_178 = ".isDefNull(node_";
  protected final String TEXT_179 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_182 = " && xml_api_";
  protected final String TEXT_183 = ".isEmpty(node_";
  protected final String TEXT_184 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_187 = " && xml_api_";
  protected final String TEXT_188 = ".isMissing(node_";
  protected final String TEXT_189 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = " =";
  protected final String TEXT_192 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_194 = " && xml_api_";
  protected final String TEXT_195 = ".isEmpty(node_";
  protected final String TEXT_196 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_199 = " && xml_api_";
  protected final String TEXT_200 = ".isMissing(node_";
  protected final String TEXT_201 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " =";
  protected final String TEXT_204 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_205 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_206 = " && xml_api_";
  protected final String TEXT_207 = ".isDefNull(node_";
  protected final String TEXT_208 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_211 = " && (xml_api_";
  protected final String TEXT_212 = ".isEmpty(node_";
  protected final String TEXT_213 = ") || xml_api_";
  protected final String TEXT_214 = ".isMissing(node_";
  protected final String TEXT_215 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = "=";
  protected final String TEXT_218 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_220 = " && (xml_api_";
  protected final String TEXT_221 = ".isMissing(node_";
  protected final String TEXT_222 = ") || xml_api_";
  protected final String TEXT_223 = ".isEmpty(node_";
  protected final String TEXT_224 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = " =";
  protected final String TEXT_227 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_228 = NL + "\t\t\t\t";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = str_";
  protected final String TEXT_231 = ";";
  protected final String TEXT_232 = NL + "\t\t\t\t";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_235 = ", ";
  protected final String TEXT_236 = ");";
  protected final String TEXT_237 = NL + "\t\t\t\t";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = ParserUtils.parseTo_";
  protected final String TEXT_240 = "(str_";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_243 = NL + "\t";
  protected final String TEXT_244 = " = null;";
  protected final String TEXT_245 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_246 = "){";
  protected final String TEXT_247 = NL + "\tthrow(ex_";
  protected final String TEXT_248 = ");";
  protected final String TEXT_249 = NL + "\t";
  protected final String TEXT_250 = " = new ";
  protected final String TEXT_251 = "Struct();";
  protected final String TEXT_252 = NL + "\t\t\txml_api_";
  protected final String TEXT_253 = ".putRejectValueAfterExtract_";
  protected final String TEXT_254 = "(";
  protected final String TEXT_255 = ",";
  protected final String TEXT_256 = ");";
  protected final String TEXT_257 = NL + "     ";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = " = ";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = ";";
  protected final String TEXT_262 = NL + "\t";
  protected final String TEXT_263 = ".errorXMLField = xmlStr_";
  protected final String TEXT_264 = ";" + NL + "\t";
  protected final String TEXT_265 = ".errorMessage = ex_";
  protected final String TEXT_266 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_267 = ";" + NL + "\t";
  protected final String TEXT_268 = " = null;";
  protected final String TEXT_269 = NL + "    System.err.println(ex_";
  protected final String TEXT_270 = ".getMessage());";
  protected final String TEXT_271 = NL + "    ";
  protected final String TEXT_272 = " = null;";
  protected final String TEXT_273 = NL + "\t";
  protected final String TEXT_274 = ".errorXMLField = xmlStr_";
  protected final String TEXT_275 = ";" + NL + "\t";
  protected final String TEXT_276 = ".errorMessage = ex_";
  protected final String TEXT_277 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_278 = ";";
  protected final String TEXT_279 = NL + "    \t}" + NL + "    }" + NL + "    " + NL + "    isStructError_";
  protected final String TEXT_280 = " = false;" + NL;
  protected final String TEXT_281 = NL + NL + "   globalMap.put(\"";
  protected final String TEXT_282 = "_NB_LINE\", nb_line_";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String strXMLField = ElementParameterParser.getValue(node, "__USE_XML_FIELD__");
boolean useXMLField = (strXMLField!=null&&!("").equals(strXMLField))?("true").equals(strXMLField):false;
String strXMLText = ElementParameterParser.getValue(node, "__XML_TEXT__");
String strXMLPrefix = ElementParameterParser.getValue(node, "__XML_PREFIX__");
if(("TRIGGER_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"/exchange/item\"";
}else if(("PROCESS_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"/item\"";
}else if(("NONE_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"\"";
}

List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 
String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

//get XML field content
IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
List<IMetadataColumn> inColumns = null;
if (inConns!=null) {
	for (IConnection incomingConn : inConns) {
		if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inConn = incomingConn;
			inColumns = inConn.getMetadataTable().getListColumns();
			break;
		}
	}
}
if(useXMLField){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(strXMLText );
    stringBuffer.append(TEXT_4);
    
}else if (inConns!=null) {
	if (inConn!=null) {
		if(("tMDMReadConf").equals(inConn.getSource().getComponent().getName())){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_7);
    
		}else{
			for (IMetadataColumn inputCol : inColumns) {
				if(inputCol.getLabel().equals(xmlField))
				{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(xmlField);
    stringBuffer.append("id_Document".equals(inputCol.getTalendType())?".toString()":"");
    stringBuffer.append(TEXT_14);
    
					break;
				}
			}
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
		blockCodes.add(new BlockCode("C_01"));
		((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	}
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName(); 
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    
    	}
    }
}

if (outConn!=null) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
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
    if(useXMLField){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(strXMLPrefix );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_31);
    }else{
	//useItems & loopQueryBase are only for tMDMInput
	String strUseItems = ElementParameterParser.getValue(node, "__USE_ITEMS__");
	boolean useItems = (strUseItems!=null&&!("").equals(strUseItems))?("true").equals(strUseItems):false;
	if(useItems){
		String loopQueryBase = ElementParameterParser.getValue(node, "__LOOP_QUERY_BASE__"); 
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append("\"\"".equals(loopQueryBase)?"":loopQueryBase+"+");
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_34);
    
	}else{
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_37);
    
	}
}
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
	if(dieOnError){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
	}else{
		if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_63);
    
			if(inConn!=null){
				int columnNo=0;
		 		for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
	    	  		if(!xmlField.equals(column.getLabel())){
	    	  			for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
	    	  				if(inColumn.getLabel().equals(column.getLabel())){
	    	  					if(schemaOptNum < mapping.size()){
	    	  						if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_68);
    
		 							}
		 							columnNo++;
	    	  					}else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    
								}
								break;
	    					}
	    				}
	    			}
	    	    }
	    	}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_79);
    
		} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    
		}
	}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_94);
    
    	}
    }
}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(Integer.parseInt(limit));
    stringBuffer.append(TEXT_104);
    
		}

    stringBuffer.append(TEXT_105);
    
		if(inConn!=null){
			int unExtractColNo=0;
			for (int i=0;i<mapping.size();i++) {
				if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
					String query = mapping.get(i).get("QUERY");
					if(query==null || query.trim().length() < 1 ){
						for(IMetadataColumn inColumn:inColumns) {
							if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
								if(schemaOptNum < mapping.size()){
									if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_110);
    
									}
									unExtractColNo++;
								}else{

    stringBuffer.append(TEXT_111);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_115);
    
								}
								break;
							}
						}
					}
				}
			}
		}
		//get the mapping column 
		int extractColNo=0;
		for (int i=0;i<mapping.size();i++) {  //for S_0
			String query = mapping.get(i).get("QUERY");
			String nodeCheck = mapping.get(i).get("NODECHECK");
			if(schemaOptNum < mapping.size()){
				if(query!=null && query.trim().length()>0){  // if S_0_0
					if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_119);
    if(inConn!=null){
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
					}
					extractColNo++;
				}
			}else{
			  if(query!=null && query.trim().length()>0){  // if S_0_0

    stringBuffer.append(TEXT_130);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
					if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    
					}else{

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    
					}

    stringBuffer.append(TEXT_167);
    
				for(IMetadataColumn column:outConn.getMetadataTable().getListColumns()) { // for S_0_0_0
					if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // if S_0_0_0_0
						if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { //if S_0_0_0_0_0
	        				
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
							boolean isNotSetDefault = false;
							String defaultValue=column.getDefault();
							if(defaultValue!=null){
								isNotSetDefault = defaultValue.length()==0;
							}else{
								isNotSetDefault=true;
							}
							
							if(("true").equals(nodeCheck)){
								if(!("id_Document".equals(column.getTalendType()))) { 

    stringBuffer.append(TEXT_168);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    
								} else {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    
								}
	            				continue;
	            			}
							if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_192);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_204);
    
								}
							}else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_218);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_227);
    
								}
							}
									
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_236);
    
								} else {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_240);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_241);
    
								}
							}

    stringBuffer.append(TEXT_242);
    
							break;
	        			} // if S_0_0_0_0_1
					} // if S_0_0_0_1
				} // for S_0_0_1
			  }// if S_0_1
			}
		} // for S_1
		if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_243);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_244);
    
		}

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    
	if(dieOnError){

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_251);
    
			int columnNo=0;
    	 	for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
    	 		if(schemaOptNum < mapping.size()){
	    	  		if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_256);
    
		 			}
		 			columnNo++;
	    	  	}else{

    stringBuffer.append(TEXT_257);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_261);
    
				}
    	    }

    stringBuffer.append(TEXT_262);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_268);
    
		} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_272);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_273);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_278);
    
		}
	}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    
}

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    return stringBuffer.toString();
  }
}
