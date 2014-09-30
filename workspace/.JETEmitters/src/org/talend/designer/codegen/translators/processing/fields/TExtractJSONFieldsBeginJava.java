package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractJSONFieldsBeginJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsBeginJava result = new TExtractJSONFieldsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "class ConvertJSONString_";
  protected final String TEXT_4 = "{" + NL + "    final static int Brace = 0 ; // {" + NL + "    final static int Bracket = 1; // [" + NL + "    private int barceType = -1 ;" + NL + "    private String originalJsonString = \"\" ;" + NL + "    private String originalLoopString = \"\" ;" + NL + "    private String jsonString4XML = null;" + NL + "    private String loopString4XML = null;" + NL + "    private String additionRoot = null;" + NL + "    " + NL + "    public void barceType(){" + NL + "" + NL + "        for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "            if (originalJsonString.charAt(c) == '{') {" + NL + "                barceType = Brace;" + NL + "                break;" + NL + "            } else if (originalJsonString.charAt(c) == '[') {" + NL + "                barceType = Bracket;" + NL + "                break;" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void setJsonString (String originalJsonString) {" + NL + "        this.originalJsonString = originalJsonString;" + NL + "    }" + NL + "    " + NL + "    public void setLoopString (String originalLoopString) {" + NL + "        this.originalLoopString = originalLoopString;" + NL + "    }" + NL + "    " + NL + "    public String getJsonString4XML(){" + NL + "        return jsonString4XML;" + NL + "    }" + NL + "    " + NL + "    public String getLoopString4XML(){" + NL + "        if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "        \tloopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "\t\t}" + NL + "        return loopString4XML;" + NL + "    }" + NL + "    " + NL + "    public void setAdditionRoot(String additionRoot) {" + NL + "        this.additionRoot = additionRoot;" + NL + "    }" + NL + "    " + NL + "    public String getAdditionRoot(){" + NL + "        return additionRoot;" + NL + "    }" + NL + "    " + NL + "    public void generate() {" + NL + "        barceType();" + NL + "        jsonString4XML = originalJsonString;" + NL + "        loopString4XML = originalLoopString;" + NL + "        if (Brace == barceType) {" + NL + "            if (isNeedAddRoot(originalJsonString)) {" + NL + "                jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                loopString4XML = \"root\" + originalLoopString;" + NL + "                setAdditionRoot(\"root\");" + NL + "            }" + NL + "        } else if (Bracket == barceType) {" + NL + "            jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                    + originalJsonString + \" } }\";" + NL + "            loopString4XML = \"root/object\" + originalLoopString;" + NL + "                setAdditionRoot(\"object\");" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public boolean isNeedAddRoot(String originalJsonString) {" + NL + "        boolean isNeedAddRoot = false;" + NL + "        net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                .fromObject(originalJsonString);" + NL + "        String jsonKey = \"\";" + NL + "        Object firstObject = null;" + NL + "        if (jso.names().size() == 1) {" + NL + "            jsonKey = jso.names().get(0).toString();" + NL + "            firstObject = jso.get(jsonKey);" + NL + "        }" + NL + "        if (jso.size() > 1" + NL + "                || (firstObject != null" + NL + "                        && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                        .size() > 1)) {" + NL + "            isNeedAddRoot = true;" + NL + "        }" + NL + "        return isNeedAddRoot;" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "ConvertJSONString_";
  protected final String TEXT_5 = " cjs_";
  protected final String TEXT_6 = " = new ConvertJSONString_";
  protected final String TEXT_7 = "();" + NL + "" + NL + "de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_8 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_9 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_10 = ");" + NL + "javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_11 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "boolean isGetWholeJson_";
  protected final String TEXT_12 = " = false;" + NL + "" + NL + "\tclass OriginalJSONString_";
  protected final String TEXT_13 = " {";
  protected final String TEXT_14 = NL + NL + "        \t\tString originalJSONString = null;" + NL + "        \t\tjava.io.ByteArrayInputStream bais = null;" + NL + "        \t\tjava.io.ByteArrayOutputStream baos = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "           \t\t" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "           \t\t\ttry {" + NL + "           \t\t\t\tif(isArray){" + NL + "           \t\t\t\t\txmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t\tbais = new ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "            \t\t\tbaos = new java.io.ByteArrayOutputStream();" + NL + "            \t\t\tconfig = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "            \t\t\tjxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "            \t\t\tjavax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais,encoding);" + NL + "            \t\t\tjavax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "\t\t\t\t\t\txmLEventWriter.add(xmlEventReader);" + NL + "\t\t\t\t\t\txmlEventReader.close();" + NL + "\t\t\t\t\t\txmLEventWriter.close();" + NL + "\t\t\t\t\t\tnet.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "\t\t\t\t\t\tif(isArray){" + NL + "\t\t\t\t\t\t\tjson = json.getJSONObject(\"list\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tnet.sf.json.JSONObject originalJsonObject = null;" + NL + "\t\t\t\t\t\tif (!json.isNullObject()) {" + NL + "\t\t\t\t\t\t\tif (additionRoot == null) {" + NL + "\t\t\t\t\t\t\t\toriginalJSONString = json.toString();" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\tif (isGetWholeJson) {" + NL + "                                    originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                    if (!originalJsonObject.isNullObject()) {" + NL + "                                        originalJSONString = originalJsonObject.toString();" + NL + "                                    } " + NL + "                                }else {" + NL + "                                        originalJSONString = json.toString();" + NL + "                                }" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t        baos.close();" + NL + "\t\t\t\t        if(bais!=null){" + NL + "\t\t\t\t            bais.close();" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\treturn originalJSONString;" + NL + "           \t\t}" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "    \t\t\t\t\treturn getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "\t\t\t\t}";
  protected final String TEXT_15 = NL + "}" + NL + "\t\t\t" + NL + "\t\t\tOriginalJSONString_";
  protected final String TEXT_16 = " originalJSONString_";
  protected final String TEXT_17 = " = new OriginalJSONString_";
  protected final String TEXT_18 = "();" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_19 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }";
  protected final String TEXT_20 = NL + "            public void putUnExtractValue_";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = "Struct ";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = "Struct ";
  protected final String TEXT_25 = "){";
  protected final String TEXT_26 = NL + "                ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "            }";
  protected final String TEXT_32 = NL + "            }";
  protected final String TEXT_33 = NL + "            public void putExtractValue_";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = "Struct ";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = "Struct ";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = NL + "                String xmlStr_";
  protected final String TEXT_40 = ",org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_41 = ",String loopQuery_";
  protected final String TEXT_42 = ",java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_43 = ",org.dom4j.Node node_";
  protected final String TEXT_44 = "," + NL + "                    String str_";
  protected final String TEXT_45 = ",XML_API_";
  protected final String TEXT_46 = " xml_api_";
  protected final String TEXT_47 = ",OriginalJSONString_";
  protected final String TEXT_48 = " originalJSONString_";
  protected final String TEXT_49 = ",ConvertJSONString_";
  protected final String TEXT_50 = " cjs_";
  protected final String TEXT_51 = ",boolean isGetWholeJson_";
  protected final String TEXT_52 = " ) throws java.lang.Exception {";
  protected final String TEXT_53 = NL + "                    \tisGetWholeJson_";
  protected final String TEXT_54 = "  = true;";
  protected final String TEXT_55 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = " = temp_";
  protected final String TEXT_58 = ".createXPath(";
  protected final String TEXT_59 = ");" + NL + "                xTmp";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t                Object obj";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = " = xTmp";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ".evaluate(temp_";
  protected final String TEXT_68 = ");" + NL + "\t                if(obj";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " instanceof String || obj";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = " instanceof Number){" + NL + "\t                    node_";
  protected final String TEXT_73 = " = temp_";
  protected final String TEXT_74 = ";" + NL + "\t                    str_";
  protected final String TEXT_75 = " = String.valueOf(obj";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = ");" + NL + "\t                }else{" + NL + "                    \tnode_";
  protected final String TEXT_78 = " = xTmp";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = ".selectSingleNode(temp_";
  protected final String TEXT_81 = ");" + NL + "                    \t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t\tif(node_";
  protected final String TEXT_83 = "==null){" + NL + "\t \t\t\t\t\t\t\tstr_";
  protected final String TEXT_84 = " = null;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tstr_";
  protected final String TEXT_85 = " = originalJSONString_";
  protected final String TEXT_86 = ".getOriginalJSONString(node_";
  protected final String TEXT_87 = ".asXML(),cjs_";
  protected final String TEXT_88 = ".getAdditionRoot(),";
  protected final String TEXT_89 = ",isGetWholeJson_";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_91 = " = false;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "                        \tstr_";
  protected final String TEXT_93 = " = xTmp";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ".valueOf(temp_";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_97 = NL + "                \t}";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\tString xmlStrTemp";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = " = \"\";" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_101 = " : xTmp";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = ".selectNodes(temp_";
  protected final String TEXT_104 = ")){" + NL + "\t\t\t\t\t\t\tnode_";
  protected final String TEXT_105 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_106 = ";" + NL + "\t\t\t\t\t\t\txmlStrTemp";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = " += node_";
  protected final String TEXT_109 = ".asXML();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(\"\".equals(xmlStrTemp";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ")){" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_112 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_113 = " = originalJSONString_";
  protected final String TEXT_114 = ".getOriginalJSONString(xmlStrTemp";
  protected final String TEXT_115 = "_";
  protected final String TEXT_116 = ",cjs_";
  protected final String TEXT_117 = ".getAdditionRoot(),";
  protected final String TEXT_118 = ",isGetWholeJson_";
  protected final String TEXT_119 = ", true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_120 = " = false;" + NL + "                \t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\tjava.util.List<String> xmlListTemp";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_124 = " : xTmp";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = ".selectNodes(temp_";
  protected final String TEXT_127 = ")){" + NL + "\t\t\t\t\t\t\txmlListTemp";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_130 = ").getStringValue());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = NL + "                                ";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = str_";
  protected final String TEXT_134 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t                                    if(xml_api_";
  protected final String TEXT_136 = ".isDefNull(node_";
  protected final String TEXT_137 = ")){" + NL + "\t                                        ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " =null;" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_140 = ".isEmpty(node_";
  protected final String TEXT_141 = ")){" + NL + "\t                                        ";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " =\"\";" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_144 = ".isMissing(node_";
  protected final String TEXT_145 = " )){ " + NL + "\t                                        ";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " =";
  protected final String TEXT_148 = ";" + NL + "\t                                    }else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_150 = ".isEmpty(node_";
  protected final String TEXT_151 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_154 = ".isMissing(node_";
  protected final String TEXT_155 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " =";
  protected final String TEXT_158 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = "\t" + NL + "\t                                \tif(xml_api_";
  protected final String TEXT_160 = ".isDefNull(node_";
  protected final String TEXT_161 = ")){" + NL + "\t                                    \t";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = null;" + NL + "\t                                \t}else if(xml_api_";
  protected final String TEXT_164 = ".isEmpty(node_";
  protected final String TEXT_165 = ") || xml_api_";
  protected final String TEXT_166 = ".isMissing(node_";
  protected final String TEXT_167 = ")){" + NL + "\t                                    \t";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = " = ";
  protected final String TEXT_170 = ";" + NL + "\t                                \t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_172 = ".isMissing(node_";
  protected final String TEXT_173 = ") || xml_api_";
  protected final String TEXT_174 = ".isEmpty(node_";
  protected final String TEXT_175 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " =";
  protected final String TEXT_178 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = str_";
  protected final String TEXT_182 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_186 = ", ";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = " = ParserUtils.parseTo_";
  protected final String TEXT_191 = "(str_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\t\tif(xmlListTemp";
  protected final String TEXT_195 = "_";
  protected final String TEXT_196 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = null;\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = xmlListTemp";
  protected final String TEXT_202 = "_";
  protected final String TEXT_203 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = xmlListTemp";
  protected final String TEXT_207 = "_";
  protected final String TEXT_208 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_210 = NL + "            }";
  protected final String TEXT_211 = NL + "            }";
  protected final String TEXT_212 = NL + "            public void putRejectValueBeforeExtract_";
  protected final String TEXT_213 = "(";
  protected final String TEXT_214 = "Struct ";
  protected final String TEXT_215 = ",";
  protected final String TEXT_216 = "Struct ";
  protected final String TEXT_217 = "){";
  protected final String TEXT_218 = NL + "                ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = ";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = ";";
  protected final String TEXT_223 = NL + "            }";
  protected final String TEXT_224 = NL + "            }";
  protected final String TEXT_225 = NL + "            public void putRejectValueAfterExtract_";
  protected final String TEXT_226 = "(";
  protected final String TEXT_227 = "Struct ";
  protected final String TEXT_228 = ",";
  protected final String TEXT_229 = "Struct ";
  protected final String TEXT_230 = "){";
  protected final String TEXT_231 = NL + "                ";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = ";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = ";";
  protected final String TEXT_236 = NL + "            }";
  protected final String TEXT_237 = NL + "            }";
  protected final String TEXT_238 = NL + "}" + NL + "" + NL + "    String jsonStr_";
  protected final String TEXT_239 = " = \"\";" + NL + "    String xmlStr_";
  protected final String TEXT_240 = " = \"\";" + NL + "" + NL + "XML_API_";
  protected final String TEXT_241 = " xml_api_";
  protected final String TEXT_242 = " = new XML_API_";
  protected final String TEXT_243 = "();";
  protected final String TEXT_244 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	int schemaOptNum=100;
    String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
    if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
        schemaOptNum  = Integer.parseInt(schemaOptNumStr);
    }
    String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");

    String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        String nodeChecked = null;
        boolean hasNodeCheck = false;
        for(int i = 0 ;i<mapping.size();i++){
            nodeChecked = mapping.get(i).get("NODECHECK");
            if("true".equals(nodeChecked)){
                hasNodeCheck = true;
                break;
            }
        }
        if(hasNodeCheck){//----start has nodeCheck

    stringBuffer.append(TEXT_14);
    
        }//----end has nodeCheck

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
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
if (outConn!=null) {
    if(schemaOptNum < mapping.size()){//whether to optimize
        if(inConn!=null){
            int unExtractColNo=0;
            for (int i=0;i<mapping.size();i++) { 
                if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                    String query = mapping.get(i).get("QUERY");
                    if(query==null || query.trim().length()<1){
                        for(IMetadataColumn inColumn:inColumns) {
                            if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
                                if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_25);
    
                                }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_30);
    
                                if((unExtractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_31);
    
                                }
                                unExtractColNo++;
                                break;
                            }
                        }
                    }
                }
            }
            if(unExtractColNo>0&&(unExtractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_32);
    
            }
        }
        int extractColNo=0;
        for (int i=0;i<mapping.size();i++) {  //for S_0
            String query = mapping.get(i).get("QUERY");
            String nodeCheck = mapping.get(i).get("NODECHECK");
            boolean isArrayCheck = "true".equals(mapping.get(i).get("ISARRAY"));
            if(query!=null && query.trim().length()>0){  // if S_0_0
                if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_36);
    if(inConn!=null){
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
                }
             	if("true".equals(nodeCheck)){
                	if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
                	}
            	}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                if(!isArrayCheck){
                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
  		                if(("true").equals(nodeCheck)){
						
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                    	}else{
						
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
                    	}
                    	
    stringBuffer.append(TEXT_97);
    
                }else{
                	if(("true").equals(nodeCheck)){
					
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
                	}else{
					
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
                	}
                }
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
							
    stringBuffer.append(TEXT_131);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
                                continue;
                            }
                            if(!isArrayCheck){
	                            if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_148);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_158);
    
									}
	                            }else{ // other type
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_170);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_178);
    
									}
								}
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								
    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    
								} else {
									if (javaType == JavaTypesManager.DATE) {
									
    stringBuffer.append(TEXT_183);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_187);
    
									} else {
									
    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_192);
    
									}
								}
								
    stringBuffer.append(TEXT_193);
    
							}else{
							
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_199);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
									}else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_204);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
									}
									
    stringBuffer.append(TEXT_209);
    
							}
                            break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
                if((extractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_210);
    
                }
                extractColNo++;
            }// if S_0_1
        } // for S_1
        if(extractColNo >0&&(extractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_211);
    
        }
        if(!dieOnError && !("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {//reject before extract
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_212);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_217);
    
                                }

    stringBuffer.append(TEXT_218);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_222);
    
                                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_223);
    
                                }
                                columnNo++;
                                break;
                            }
                        }
                    }
                }
                if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_224);
    
                }
            }
        }//reject before extract
        
        if(!dieOnError && !("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//reject extract
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_225);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_230);
    
                }

    stringBuffer.append(TEXT_231);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_235);
    
                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_236);
    
                }
                columnNo++;
            }
            if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_237);
    
            }
        }//reject extract
        
    }//whether to optimize
}

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    return stringBuffer.toString();
  }
}
