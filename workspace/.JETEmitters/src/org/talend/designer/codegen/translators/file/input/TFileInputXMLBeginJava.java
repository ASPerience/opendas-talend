package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Done.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_13 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tStringBuilder log4jParamters_";
  protected final String TEXT_15 = " = new StringBuilder();" + NL + "\t\t\t   \tlog4jParamters_";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" - Parameters:\");" + NL + "\t\t\t   \t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_22 = ".append(\" | \");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t   \t\tlog.debug(log4jParamters_";
  protected final String TEXT_24 = ");" + NL + "\t   \t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_27 = ") + \".\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_28 = " - Content of the record \" + (nb_line_";
  protected final String TEXT_29 = ") + \": \" + log4jSb_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_31 = ".delete(0,log4jSb_";
  protected final String TEXT_32 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - Writing the record \" + nb_line_";
  protected final String TEXT_35 = " + \" to the file.\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_36 = " - Content of the record \" + nb_line_";
  protected final String TEXT_37 = " + \": \" + log4jSb_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_39 = ".delete(0,log4jSb_";
  protected final String TEXT_40 = ".length());";
  protected final String TEXT_41 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - Written records count: \" + nb_line_";
  protected final String TEXT_43 = " + \" .\");";
  protected final String TEXT_44 = NL + "\t";
  protected final String TEXT_45 = NL + "\t\t\trowHelper_";
  protected final String TEXT_46 = ".valueToConn(";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = ");" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t\trowHelper_";
  protected final String TEXT_51 = ".valueToConnWithD(";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = ");" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\t\trowHelper_";
  protected final String TEXT_57 = ".connToConn(";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = ");" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_61 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_63 = "(";
  protected final String TEXT_64 = " ";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = "Struct ";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_71 = "(";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = ",";
  protected final String TEXT_74 = "Struct ";
  protected final String TEXT_75 = ", routines.system.Dynamic ";
  protected final String TEXT_76 = " ";
  protected final String TEXT_77 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = "Struct ";
  protected final String TEXT_82 = ",";
  protected final String TEXT_83 = "Struct ";
  protected final String TEXT_84 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_87 = " ";
  protected final String TEXT_88 = ",";
  protected final String TEXT_89 = "Struct ";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = "Struct ";
  protected final String TEXT_96 = ", routines.system.Dynamic ";
  protected final String TEXT_97 = " ";
  protected final String TEXT_98 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = ",";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_105 = "(";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = ",";
  protected final String TEXT_108 = " ";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_112 = "Struct ";
  protected final String TEXT_113 = ",";
  protected final String TEXT_114 = "Struct ";
  protected final String TEXT_115 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = ",";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_122 = " rowHelper_";
  protected final String TEXT_123 = "  = new RowHelper_";
  protected final String TEXT_124 = "();" + NL + "\t\t\t";
  protected final String TEXT_125 = NL;
  protected final String TEXT_126 = NL + "\tString log4jFileInputXMLParameters_";
  protected final String TEXT_127 = " = \"\";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_128 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_129 = " + \"FILENAME = \" + ";
  protected final String TEXT_130 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_131 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_132 = " + \"LOOP_QUERY = \" + ";
  protected final String TEXT_133 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_134 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_135 = " + \"LIMIT = \" + ";
  protected final String TEXT_136 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_137 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_138 = " + \"IGNORE_DTD = \" + ";
  protected final String TEXT_139 = " + \" | \";" + NL + "\t";
  protected final String TEXT_140 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_141 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_142 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_143 = " + \" | \";" + NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_144 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_145 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_146 = " + \" | \";" + NL + "\t";
  protected final String TEXT_147 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_148 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_149 = " + \"GENERATION_MODE = \" + \"";
  protected final String TEXT_150 = "\" + \" | \";" + NL + "\t";
  protected final String TEXT_151 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_152 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_153 = " + \"IGNORE_NS = \" + ";
  protected final String TEXT_154 = " + \" | \";" + NL + "\t\t";
  protected final String TEXT_155 = NL + "\t\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_156 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_157 = " + \"TMP_FILENAME = \" + ";
  protected final String TEXT_158 = " + \" | \";" + NL + "\t\t";
  protected final String TEXT_159 = NL + "\t";
  protected final String TEXT_160 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_161 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_162 = " + \"USE_SEPARATOR_FOR_XERCES = \" + ";
  protected final String TEXT_163 = " + \" | \";" + NL + "\t";
  protected final String TEXT_164 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_165 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_166 = " + \"FIELD_SEPARATOR = \" + ";
  protected final String TEXT_167 = " + \" | \";" + NL + "\t";
  protected final String TEXT_168 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_169 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_170 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_171 = "\" + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_172 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_173 = " + \"CHECK_DATE = \" + ";
  protected final String TEXT_174 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_175 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_176 = " + \"DIE_ON_ERROR = \" + ";
  protected final String TEXT_177 = " + \" | \";" + NL + "" + NL + "\t" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_178 = " = \"";
  protected final String TEXT_179 = " - Parameters:\" + log4jFileInputXMLParameters_";
  protected final String TEXT_180 = ";" + NL + "\tlog.debug(log4jFileInputXMLParameters_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "int nb_line_";
  protected final String TEXT_183 = " = 0;" + NL;
  protected final String TEXT_184 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_185 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_186 = NL + "\tString os_";
  protected final String TEXT_187 = " = System.getProperty(\"os.name\").toLowerCase();" + NL + "\tboolean isWindows_";
  protected final String TEXT_188 = "=false;" + NL + "\tif(os_";
  protected final String TEXT_189 = ".indexOf(\"windows\") > -1 || os_";
  protected final String TEXT_190 = ".indexOf(\"nt\") > -1){" + NL + "\t\tisWindows_";
  protected final String TEXT_191 = "=true;" + NL + "\t}";
  protected final String TEXT_192 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_193 = " implements org.apache.xml.utils.PrefixResolver {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "    public String getBaseIdentifier() {" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return org.apache.xml.utils.Constants.S_XMLNAMESPACEURI;" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix, org.w3c.dom.Node context) {" + NL + "        return getNamespaceForPrefix(prefix);" + NL + "    }" + NL + "" + NL + "    public boolean handlesNullPrefixes() {" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "    public int[] getDefaulNSIndex(String path, String loopPath){" + NL + "\t\tString fullPath = loopPath;" + NL + "    \tif(!path.equals(fullPath)){" + NL + "        \tfor (String tmp : path.split(\"/\")) {" + NL + "        \t\tif ((\"..\").equals(tmp)) {" + NL + "                    fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                } else {" + NL + "                    fullPath += \"/\" + tmp;" + NL + "                }" + NL + "        \t}" + NL + "        }" + NL + "    \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "        java.util.Arrays.fill(indexs, -1);" + NL + "        int length = 0;" + NL + "        for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                length = defualtNSPath.get(i).length();" + NL + "            }" + NL + "        }" + NL + "    \treturn indexs;" + NL + "    }" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_194 = "{" + NL + "" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\tTalendPrefixResolver_";
  protected final String TEXT_195 = " pr = null;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "\tpublic void initXPath(org.w3c.dom.Node root){" + NL + "\t\tpr= new TalendPrefixResolver_";
  protected final String TEXT_196 = "();" + NL + "    \thasDefaultNS = pr.countNSMap(root);" + NL + "\t}" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\torg.apache.xpath.objects.XObject obj = null;" + NL + "\t" + NL + "\tpublic int getNodeType(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\treturn obj.getType();" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tif(obj==null){" + NL + "\t\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\t}" + NL + "\t\treturn obj.str();" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "    \tif(obj==null){" + NL + "        \tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        }" + NL + "        return obj.nodelist().item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "        org.apache.xpath.objects.XObject obj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        return obj.nodelist();" + NL + "    }" + NL + "    " + NL + "    private String addDefaultNSPrefix(String path) {" + NL + "        if (hasDefaultNS) {" + NL + "            StringBuffer newPath = new StringBuffer();" + NL + "            int[] indexs= pr.getDefaulNSIndex(path,loopPath);" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL;
  protected final String TEXT_197 = NL + "class ContentTool_";
  protected final String TEXT_198 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_199 = " contentTool_";
  protected final String TEXT_200 = " = new ContentTool_";
  protected final String TEXT_201 = "();" + NL + "contentTool_";
  protected final String TEXT_202 = ".field_separator=";
  protected final String TEXT_203 = ";";
  protected final String TEXT_204 = NL + NL + "XML_API_";
  protected final String TEXT_205 = " xml_api_";
  protected final String TEXT_206 = " = new XML_API_";
  protected final String TEXT_207 = "();" + NL + "xml_api_";
  protected final String TEXT_208 = ".loopPath=";
  protected final String TEXT_209 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_210 = " = new org.apache.xerces.parsers.DOMParser();";
  protected final String TEXT_211 = NL + "parser_";
  protected final String TEXT_212 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_213 = "());";
  protected final String TEXT_214 = NL + "parser_";
  protected final String TEXT_215 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_216 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_217 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_218 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_219 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_220 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_221 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_222 = " = ";
  protected final String TEXT_223 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_224 = NL + "\t";
  protected final String TEXT_225 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_226 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_227 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_228 = NL + "\t";
  protected final String TEXT_229 = NL + "\t\tlog.error(\"";
  protected final String TEXT_230 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_231 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_232 = NL + "}" + NL + "" + NL + "boolean isValidFile_";
  protected final String TEXT_233 = " = true;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_234 = " = null;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_235 = " != null && filename_";
  protected final String TEXT_236 = " instanceof String && filename_";
  protected final String TEXT_237 = ".toString().startsWith(\"//\")){" + NL + "\t\tif (!isWindows_";
  protected final String TEXT_238 = "){" + NL + "\t\t\tfilename_";
  protected final String TEXT_239 = " = filename_";
  protected final String TEXT_240 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t\t}" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_241 = " instanceof java.io.InputStream){" + NL + "    \tjava.io.InputStream inputStream_";
  protected final String TEXT_242 = " = (java.io.InputStream)filename_";
  protected final String TEXT_243 = ";" + NL + "    \ttoClose_";
  protected final String TEXT_244 = " = inputStream_";
  protected final String TEXT_245 = ";" + NL + "    \tparser_";
  protected final String TEXT_246 = ".parse(new org.xml.sax.InputSource(inputStream_";
  protected final String TEXT_247 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_248 = "= new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_249 = "));" + NL + "    \tjava.io.Reader unicodeReader_";
  protected final String TEXT_250 = " = new UnicodeReader(in_";
  protected final String TEXT_251 = ",";
  protected final String TEXT_252 = ");" + NL + "    \ttoClose_";
  protected final String TEXT_253 = " = unicodeReader_";
  protected final String TEXT_254 = ";" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_255 = " = new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_256 = ");" + NL + "    \tparser_";
  protected final String TEXT_257 = ".parse(xmlInputSource_";
  protected final String TEXT_258 = ");" + NL + "    }" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_259 = NL + "\t";
  protected final String TEXT_260 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_261 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_262 = NL + "\tthrow(e);";
  protected final String TEXT_263 = NL + "\t";
  protected final String TEXT_264 = NL + "\t\tlog.error(\"";
  protected final String TEXT_265 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_266 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_267 = " = false;";
  protected final String TEXT_268 = NL + "}finally {" + NL + "\tif(toClose_";
  protected final String TEXT_269 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_270 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_271 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_272 = " = parser_";
  protected final String TEXT_273 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_274 = ".initXPath(doc_";
  protected final String TEXT_275 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_276 = " = xml_api_";
  protected final String TEXT_277 = ".getNodeList(doc_";
  protected final String TEXT_278 = ",";
  protected final String TEXT_279 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_280 = "  = null;" + NL + "String str_";
  protected final String TEXT_281 = " = null;";
  protected final String TEXT_282 = NL + "for (int i_";
  protected final String TEXT_283 = " = 0; i_";
  protected final String TEXT_284 = " < nodelist_";
  protected final String TEXT_285 = ".getLength(); i_";
  protected final String TEXT_286 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_287 = " = nodelist_";
  protected final String TEXT_288 = ".item(i_";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "class NameSpaceTool_";
  protected final String TEXT_291 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "            int size = fullPath.split(\"/\").length - 1;" + NL + "            if(size<0) {" + NL + "            \treturn fullPath;" + NL + "            }" + NL + "        \tint[] indexs = new int[size];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_292 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_293 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_294 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_295 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_296 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_297 = NL + "reader_";
  protected final String TEXT_298 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_299 = "());";
  protected final String TEXT_300 = NL + "Object filename_";
  protected final String TEXT_301 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_302 = " = ";
  protected final String TEXT_303 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_304 = NL + "\t";
  protected final String TEXT_305 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_306 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_307 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_308 = NL + "\t";
  protected final String TEXT_309 = NL + "\t\tlog.error(\"";
  protected final String TEXT_310 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_311 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_312 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_313 = " != null && filename_";
  protected final String TEXT_314 = " instanceof String && filename_";
  protected final String TEXT_315 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_316 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_317 = " = filename_";
  protected final String TEXT_318 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_319 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_320 = " = null;" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_321 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_322 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_323 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_reader_";
  protected final String TEXT_324 = " = reader_";
  protected final String TEXT_325 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_326 = ");" + NL + "\t}else{" + NL + "\t\tdoc_reader_";
  protected final String TEXT_327 = " = reader_";
  protected final String TEXT_328 = ".read(new java.io.File(String.valueOf(filename_";
  protected final String TEXT_329 = ")).toURI().toString());" + NL + "\t}" + NL + "\tformat_";
  protected final String TEXT_330 = ".setTrimText(false);" + NL + "\tformat_";
  protected final String TEXT_331 = ".setEncoding(";
  protected final String TEXT_332 = ");" + NL + "\tnew XML_NS_RMV_";
  protected final String TEXT_333 = "().removeNamespace(doc_reader_";
  protected final String TEXT_334 = ",doc_tmp_";
  protected final String TEXT_335 = ");" + NL + "\tdoc_reader_";
  protected final String TEXT_336 = ".clearContent();" + NL + "\tdoc_reader_";
  protected final String TEXT_337 = " = null;" + NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_338 = " = new java.io.FileOutputStream(";
  protected final String TEXT_339 = ");" + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_340 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_341 = ", format_";
  protected final String TEXT_342 = ");" + NL + "\toutput_";
  protected final String TEXT_343 = ".write(doc_tmp_";
  protected final String TEXT_344 = ");" + NL + "\toutput_";
  protected final String TEXT_345 = ".close();" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_346 = NL + "\t";
  protected final String TEXT_347 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_348 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_349 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_350 = NL + "\t";
  protected final String TEXT_351 = NL + "\t\tlog.error(\"";
  protected final String TEXT_352 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_353 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_354 = NL + "} finally {" + NL + "\tif(filename_";
  protected final String TEXT_355 = " instanceof java.io.InputStream && filename_";
  protected final String TEXT_356 = "!=null){" + NL + "\t\t((java.io.InputStream)filename_";
  protected final String TEXT_357 = ").close();" + NL + "\t}" + NL + "}" + NL + "filename_";
  protected final String TEXT_358 = " = ";
  protected final String TEXT_359 = ";";
  protected final String TEXT_360 = NL + "boolean isValidFile_";
  protected final String TEXT_361 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_362 = " = null;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_363 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_364 = " instanceof java.io.InputStream){" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_365 = " = (java.io.InputStream)filename_";
  protected final String TEXT_366 = ";" + NL + "\t\ttoClose_";
  protected final String TEXT_367 = " = inputStream_";
  protected final String TEXT_368 = ";" + NL + "\t\tdoc_";
  protected final String TEXT_369 = " = reader_";
  protected final String TEXT_370 = ".read(inputStream_";
  protected final String TEXT_371 = ");" + NL + "\t}else{" + NL + "\t\tjava.io.Reader unicodeReader_";
  protected final String TEXT_372 = " = new UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_373 = ")),";
  protected final String TEXT_374 = ");" + NL + "\t\ttoClose_";
  protected final String TEXT_375 = " = unicodeReader_";
  protected final String TEXT_376 = ";" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_377 = "= new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_378 = ");" + NL + "\t\tdoc_";
  protected final String TEXT_379 = " = reader_";
  protected final String TEXT_380 = ".read(in_";
  protected final String TEXT_381 = ");" + NL + "\t}" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_382 = NL + "\t";
  protected final String TEXT_383 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_384 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_385 = NL + "\tthrow(e);";
  protected final String TEXT_386 = NL + "\t";
  protected final String TEXT_387 = NL + "\t\tlog.error(\"";
  protected final String TEXT_388 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_389 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_390 = " = false;";
  protected final String TEXT_391 = NL + "} finally {" + NL + "\tif(toClose_";
  protected final String TEXT_392 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_393 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_394 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_395 = " nsTool_";
  protected final String TEXT_396 = " = new NameSpaceTool_";
  protected final String TEXT_397 = "();" + NL + "nsTool_";
  protected final String TEXT_398 = ".countNSMap(doc_";
  protected final String TEXT_399 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_400 = " = nsTool_";
  protected final String TEXT_401 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_402 = " = doc_";
  protected final String TEXT_403 = ".createXPath(nsTool_";
  protected final String TEXT_404 = ".addDefaultNSPrefix(";
  protected final String TEXT_405 = ",";
  protected final String TEXT_406 = "));  " + NL + "x_";
  protected final String TEXT_407 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_408 = "); ";
  protected final String TEXT_409 = NL + "org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_410 = " = new org.jaxen.NamespaceContext() {" + NL + "" + NL + "\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t}" + NL + "\t" + NL + "};" + NL + "x_";
  protected final String TEXT_411 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_412 = ");";
  protected final String TEXT_413 = NL + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_414 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_415 = ".selectNodes(doc_";
  protected final String TEXT_416 = ");\t" + NL + "XML_API_";
  protected final String TEXT_417 = " xml_api_";
  protected final String TEXT_418 = " = new XML_API_";
  protected final String TEXT_419 = "();" + NL + "String str_";
  protected final String TEXT_420 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_421 = " = null;" + NL + "" + NL + "//init all mapping xpaths";
  protected final String TEXT_422 = NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_423 = ": nodeList_";
  protected final String TEXT_424 = ") {";
  protected final String TEXT_425 = NL + "class XML_API_";
  protected final String TEXT_426 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_427 = " xml_api_";
  protected final String TEXT_428 = " = new XML_API_";
  protected final String TEXT_429 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_430 = " = new String[]{";
  protected final String TEXT_431 = "\t" + NL + "\t";
  protected final String TEXT_432 = "\t\t" + NL + "\t,";
  protected final String TEXT_433 = "+\"/@xsi:nil\"";
  protected final String TEXT_434 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_435 = " = new boolean[]{";
  protected final String TEXT_436 = "\t" + NL + "\t";
  protected final String TEXT_437 = "\t\t" + NL + "\t,false";
  protected final String TEXT_438 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_439 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_440 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_441 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_442 = ",queryPaths_";
  protected final String TEXT_443 = ",asXMLs_";
  protected final String TEXT_444 = ");";
  protected final String TEXT_445 = NL + "looper_";
  protected final String TEXT_446 = ".setIgnoreDTD(true);";
  protected final String TEXT_447 = NL + "looper_";
  protected final String TEXT_448 = ".setEncoding(";
  protected final String TEXT_449 = ");" + NL + "Object filename_";
  protected final String TEXT_450 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_451 = " = ";
  protected final String TEXT_452 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_453 = NL + "\t";
  protected final String TEXT_454 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_455 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_456 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_457 = NL + "\t\tlog.error(\"";
  protected final String TEXT_458 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_459 = NL + "\t";
  protected final String TEXT_460 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_461 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_462 = " != null && filename_";
  protected final String TEXT_463 = " instanceof String && filename_";
  protected final String TEXT_464 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_465 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_466 = " = filename_";
  protected final String TEXT_467 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_468 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_469 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_470 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_471 = ".parse(String.valueOf(filename_";
  protected final String TEXT_472 = "));" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_473 = "  = looper_";
  protected final String TEXT_474 = ".iterator();";
  protected final String TEXT_475 = NL + "while (it_";
  protected final String TEXT_476 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_477 = " = it_";
  protected final String TEXT_478 = ".next();";
  protected final String TEXT_479 = NL + "\tnb_line_";
  protected final String TEXT_480 = "++;";
  protected final String TEXT_481 = NL + "\t";
  protected final String TEXT_482 = " = null;\t\t\t";
  protected final String TEXT_483 = NL + "\tif(xml_api_";
  protected final String TEXT_484 = ".getNodeType(tmp_";
  protected final String TEXT_485 = ",";
  protected final String TEXT_486 = ")==org.apache.xpath.objects.XObject.CLASS_NODESET){" + NL + "\t\tnode_";
  protected final String TEXT_487 = " = xml_api_";
  protected final String TEXT_488 = ".getSingleNode(tmp_";
  protected final String TEXT_489 = ",";
  protected final String TEXT_490 = ");";
  protected final String TEXT_491 = NL + "    \tif(node_";
  protected final String TEXT_492 = "!=null && node_";
  protected final String TEXT_493 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_494 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_495 = " = contentTool_";
  protected final String TEXT_496 = ".getNodeContent(node_";
  protected final String TEXT_497 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_498 = " = node_";
  protected final String TEXT_499 = "!=null?node_";
  protected final String TEXT_500 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_501 = NL + "\t\tstr_";
  protected final String TEXT_502 = " = node_";
  protected final String TEXT_503 = "!=null?node_";
  protected final String TEXT_504 = ".getTextContent():\"\";";
  protected final String TEXT_505 = NL + "\t}else{" + NL + "\t\tnode_";
  protected final String TEXT_506 = " = tmp_";
  protected final String TEXT_507 = ";" + NL + "\t\tstr_";
  protected final String TEXT_508 = " = xml_api_";
  protected final String TEXT_509 = ".getNodeString(tmp_";
  protected final String TEXT_510 = ",";
  protected final String TEXT_511 = ");" + NL + "\t}";
  protected final String TEXT_512 = NL + "\torg.dom4j.XPath xTmp";
  protected final String TEXT_513 = "_";
  protected final String TEXT_514 = " = org.dom4j.DocumentHelper.createXPath(nsTool_";
  protected final String TEXT_515 = ".addDefaultNSPrefix(";
  protected final String TEXT_516 = ",";
  protected final String TEXT_517 = "));" + NL + "\txTmp";
  protected final String TEXT_518 = "_";
  protected final String TEXT_519 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_520 = ");";
  protected final String TEXT_521 = NL + "\txTmp";
  protected final String TEXT_522 = "_";
  protected final String TEXT_523 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_524 = ");";
  protected final String TEXT_525 = NL + "\tif(true) {" + NL + "\t\t";
  protected final String TEXT_526 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_527 = " - Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t\t";
  protected final String TEXT_528 = NL + "\t\tthrow new RuntimeException(\"Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t}";
  protected final String TEXT_529 = NL + "    Object obj";
  protected final String TEXT_530 = "_";
  protected final String TEXT_531 = " = xTmp";
  protected final String TEXT_532 = "_";
  protected final String TEXT_533 = ".evaluate(temp_";
  protected final String TEXT_534 = ");" + NL + "    if(obj";
  protected final String TEXT_535 = "_";
  protected final String TEXT_536 = " == null) {" + NL + "    \tnode_";
  protected final String TEXT_537 = " = null;";
  protected final String TEXT_538 = NL + "\t\tstr_";
  protected final String TEXT_539 = " = null;";
  protected final String TEXT_540 = NL + "    \tstr_";
  protected final String TEXT_541 = " = \"\";";
  protected final String TEXT_542 = NL + "    \t" + NL + "    } else if(obj";
  protected final String TEXT_543 = "_";
  protected final String TEXT_544 = " instanceof org.dom4j.Node) {" + NL + "    \tnode_";
  protected final String TEXT_545 = " = (org.dom4j.Node)obj";
  protected final String TEXT_546 = "_";
  protected final String TEXT_547 = ";";
  protected final String TEXT_548 = NL + "\t\tstr_";
  protected final String TEXT_549 = " = node_";
  protected final String TEXT_550 = ".asXML();";
  protected final String TEXT_551 = NL + "    \tstr_";
  protected final String TEXT_552 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_553 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_554 = NL + "    } else if(obj";
  protected final String TEXT_555 = "_";
  protected final String TEXT_556 = " instanceof String || obj";
  protected final String TEXT_557 = "_";
  protected final String TEXT_558 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_559 = " = temp_";
  protected final String TEXT_560 = ";" + NL + "    \tstr_";
  protected final String TEXT_561 = " = String.valueOf(obj";
  protected final String TEXT_562 = "_";
  protected final String TEXT_563 = ");" + NL + "    } else if(obj";
  protected final String TEXT_564 = "_";
  protected final String TEXT_565 = " instanceof java.util.List){" + NL + "    \tjava.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_566 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_567 = "_";
  protected final String TEXT_568 = ";" + NL + "    \tnode_";
  protected final String TEXT_569 = " = nodes_";
  protected final String TEXT_570 = ".size()>0 ? nodes_";
  protected final String TEXT_571 = ".get(0) : null;";
  protected final String TEXT_572 = NL + "\t\tstr_";
  protected final String TEXT_573 = " = node_";
  protected final String TEXT_574 = "==null?null:node_";
  protected final String TEXT_575 = ".asXML();";
  protected final String TEXT_576 = NL + "    \tstr_";
  protected final String TEXT_577 = " = node_";
  protected final String TEXT_578 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_579 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_580 = NL + "\t}";
  protected final String TEXT_581 = NL + "\tstr_";
  protected final String TEXT_582 = " = row_";
  protected final String TEXT_583 = ".get(";
  protected final String TEXT_584 = ");";
  protected final String TEXT_585 = NL + "\tnode_";
  protected final String TEXT_586 = " = new String[]{str_";
  protected final String TEXT_587 = ",row_";
  protected final String TEXT_588 = ".get(";
  protected final String TEXT_589 = "+\"/@xsi:nil\")};";
  protected final String TEXT_590 = NL + "\tnode_";
  protected final String TEXT_591 = " = new String[]{str_";
  protected final String TEXT_592 = ",null};";
  protected final String TEXT_593 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_594 = ".";
  protected final String TEXT_595 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_596 = ",";
  protected final String TEXT_597 = ",";
  protected final String TEXT_598 = ");";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_600 = ".";
  protected final String TEXT_601 = " = str_";
  protected final String TEXT_602 = ";";
  protected final String TEXT_603 = NL + "\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_604 = ".append(";
  protected final String TEXT_605 = ".";
  protected final String TEXT_606 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_607 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_608 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_609 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_610 = ".isDefNull(node_";
  protected final String TEXT_611 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_612 = ".";
  protected final String TEXT_613 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_614 = ".isEmpty(node_";
  protected final String TEXT_615 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_616 = ".";
  protected final String TEXT_617 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_618 = ".isMissing(node_";
  protected final String TEXT_619 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_620 = ".";
  protected final String TEXT_621 = " =";
  protected final String TEXT_622 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_623 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_624 = ".isEmpty(node_";
  protected final String TEXT_625 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_626 = ".";
  protected final String TEXT_627 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_628 = ".isMissing(node_";
  protected final String TEXT_629 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_630 = ".";
  protected final String TEXT_631 = " =";
  protected final String TEXT_632 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_633 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_634 = ".isDefNull(node_";
  protected final String TEXT_635 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_636 = ".";
  protected final String TEXT_637 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_638 = ".isEmpty(node_";
  protected final String TEXT_639 = ") || xml_api_";
  protected final String TEXT_640 = ".isMissing(node_";
  protected final String TEXT_641 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = "=";
  protected final String TEXT_644 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_645 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_646 = ".isMissing(node_";
  protected final String TEXT_647 = ") || xml_api_";
  protected final String TEXT_648 = ".isEmpty(node_";
  protected final String TEXT_649 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_650 = ".";
  protected final String TEXT_651 = " =";
  protected final String TEXT_652 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_653 = NL + "\t\t";
  protected final String TEXT_654 = ".";
  protected final String TEXT_655 = " = str_";
  protected final String TEXT_656 = ";";
  protected final String TEXT_657 = NL + "\t\t";
  protected final String TEXT_658 = ".";
  protected final String TEXT_659 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_660 = ", ";
  protected final String TEXT_661 = ",false);";
  protected final String TEXT_662 = NL + "\t\t";
  protected final String TEXT_663 = ".";
  protected final String TEXT_664 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_665 = ", ";
  protected final String TEXT_666 = ");";
  protected final String TEXT_667 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_668 = ".";
  protected final String TEXT_669 = " = str_";
  protected final String TEXT_670 = ".getBytes(";
  protected final String TEXT_671 = ");";
  protected final String TEXT_672 = NL + "\t\t";
  protected final String TEXT_673 = ".";
  protected final String TEXT_674 = " = ParserUtils.parseTo_";
  protected final String TEXT_675 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_676 = ", ";
  protected final String TEXT_677 = ", ";
  protected final String TEXT_678 = "));";
  protected final String TEXT_679 = NL + "\t\t";
  protected final String TEXT_680 = ".";
  protected final String TEXT_681 = " = ParserUtils.parseTo_";
  protected final String TEXT_682 = "(str_";
  protected final String TEXT_683 = ");";
  protected final String TEXT_684 = NL + "\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_685 = ".append(";
  protected final String TEXT_686 = ".";
  protected final String TEXT_687 = ");";
  protected final String TEXT_688 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_689 = ".append(\"|\");";
  protected final String TEXT_690 = NL + "\t}";
  protected final String TEXT_691 = NL + "    \t\t\t\t";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = " = ";
  protected final String TEXT_694 = ".";
  protected final String TEXT_695 = ";";
  protected final String TEXT_696 = NL + "\tboolean whetherReject_";
  protected final String TEXT_697 = " = false;" + NL + "\t";
  protected final String TEXT_698 = " = new ";
  protected final String TEXT_699 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_700 = " ";
  protected final String TEXT_701 = " ";
  protected final String TEXT_702 = " = null; ";
  protected final String TEXT_703 = NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_704 = " = true;";
  protected final String TEXT_705 = NL + "\t\t\t";
  protected final String TEXT_706 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_707 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_708 = NL + "            throw(e);";
  protected final String TEXT_709 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_710 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_711 = NL + "                    ";
  protected final String TEXT_712 = " = new ";
  protected final String TEXT_713 = "Struct();";
  protected final String TEXT_714 = NL + "                ";
  protected final String TEXT_715 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_716 = ";";
  protected final String TEXT_717 = NL + "                ";
  protected final String TEXT_718 = " = null;";
  protected final String TEXT_719 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_720 = NL + "                ";
  protected final String TEXT_721 = " = null;";
  protected final String TEXT_722 = NL + "            \t";
  protected final String TEXT_723 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_724 = ";";
  protected final String TEXT_725 = NL + "    }";
  protected final String TEXT_726 = NL + "\t\t";
  protected final String TEXT_727 = "if(!whetherReject_";
  protected final String TEXT_728 = ") { ";
  protected final String TEXT_729 = "      " + NL + "             if(";
  protected final String TEXT_730 = " == null){ " + NL + "            \t ";
  protected final String TEXT_731 = " = new ";
  protected final String TEXT_732 = "Struct();" + NL + "             }";
  protected final String TEXT_733 = NL + "\t    \t ";
  protected final String TEXT_734 = ".";
  protected final String TEXT_735 = " = ";
  protected final String TEXT_736 = ".";
  protected final String TEXT_737 = ";    \t\t\t\t";
  protected final String TEXT_738 = NL + "\t\t";
  protected final String TEXT_739 = " } ";
  protected final String TEXT_740 = "\t";
  protected final String TEXT_741 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_742 = ">";
  protected final String TEXT_743 = ") {" + NL + "\t";
  protected final String TEXT_744 = NL + "\t\t\tlooper_";
  protected final String TEXT_745 = ".stopRead();" + NL + "\t";
  protected final String TEXT_746 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_747 = NL + "\t\t\t";
  protected final String TEXT_748 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
		}
		
		public void logParameters(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			   	java.util.List<org.talend.core.model.process.EParameterFieldType> ignoreT = java.util.Arrays.asList(
			   		org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
			   		org.talend.core.model.process.EParameterFieldType.LABEL);
		   		for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
		   			if(ignoreT.contains(ep.getFieldType())){
		   				continue;
		   			}
		   			String name = ep.getName();
		   			String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
		   			if(value == null || "".equals(value.trim())) {
		   				value = "\"\"";
		   			} else if("\"\\n\"".equals(value) || "\"\\r\"".equals(value) || "\"\\r\\n\"".equals(value)) {
		   				value = value.replaceAll("\\\\","\\\\\\\\");
		   			} else if("\"\"\"".equals(value)){
		   				value = "\"" + "\\" +  "\"" + "\"";
		   			} else if("\"\"\\r\\n\"\"".equals(value)){
		   				value = "\"\\\\r\\\\n\"";
		   			} else if("\"\"\\r\"\"".equals(value)){
		   				value = "\"\\\\r\"";
		   			} else if("\"\"\\n\"\"".equals(value)){
		   				value = "\"\\\\n\"";
		   			}
		   			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		   		}
		   		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	   		}
		}

		//for all tFileinput* components
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    		
			}
		}
		
		//for all tFileOutput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    		
			}
		}
		
		//for all tFileOutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_44);
    
	class DefaultRowUtil {
		String cid = "";
		INode node;
		int schemaOptNum;
		int columnListSize;
		boolean isOptimizeCode;
		boolean isBehindDynamic;
	
		boolean useV2C = false;
		IMetadataTable V2CMetadata;
		String V2CTargetConnName;
		String V2CSourceValueClass;
		String V2CSourceValueName;
		StringBuffer parmsStr;
		StringBuffer varsStr;
		public void prepareOptimizeParam(IMetadataTable metadata,int schemaOptNum){
			this.schemaOptNum=schemaOptNum;
			this.columnListSize = metadata.getListColumns().size();
			this.isOptimizeCode = schemaOptNum < this.columnListSize;
		}
		
		public void prepareValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int schemaOptNum){
			this.node = node;
			this.V2CMetadata = metadata;
			this.V2CTargetConnName = targetConnName;
			this.V2CSourceValueClass = sourceValueClass;
			this.V2CSourceValueName = sourceValueName;
			this.useV2C = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		public void genVarsParmsStr(Map<String,String> varsMap){
			parmsStr=new StringBuffer();
			varsStr=new StringBuffer();
			if(varsMap!=null && varsMap.size()>0){
				java.util.Set<String> vars=varsMap.keySet();
				for(String varName:vars){
					parmsStr.append(","+varsMap.get(varName)+" "+varName);
					varsStr.append(","+varName);
				}
			}
		}
		public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
		}
		
		public void callValueToConn(String sourceValueName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_49);
    
			}else{
				codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, 0, columnListSize);
			}
		}
		
		boolean useV2CWithD = false;
		IMetadataTable V2CWithDMetadata;
		String V2CWithDTargetConnName;
		String V2CWithDSourceValueClass;
		String V2CWithDSourceValueName;
		String V2CWithDDynamicName;
		public void prepareValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int schemaOptNum){
			this.node = node;
			this.V2CWithDMetadata = metadata;
			this.V2CWithDTargetConnName = targetConnName;
			this.V2CWithDSourceValueClass = sourceValueClass;
			this.V2CWithDSourceValueName = sourceValueName;
			this.V2CWithDDynamicName = dynamicName;
			this.useV2CWithD = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		
		public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName ,int start , int end){
			return false;
		}
		
		public void callValueToConnWithD(String sourceValueName, String targetConnName, String dynamicName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_55);
    
			}else{
				codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, 0, columnListSize);
			}
		}
		
		IMetadataTable C2CMetadata;
		String C2CTargetConnName;
		String C2CSourceConnName;
		boolean useC2C = false;
		public void prepareConnToConn(IMetadataTable metadata, String sourceConnName, String targetConnName){
			this.C2CMetadata = metadata;
			this.C2CTargetConnName = targetConnName;
			this.C2CSourceConnName = sourceConnName;
			this.useC2C = true;
		}
		
		public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start ,int end){
		}
		
		public void callConnToConn(String sourceConnName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_59);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
				int start=0;
				int end=0;
				for(int i=0;i<methodNum;i++){
					start=i*schemaOptNum;
					if(i==(methodNum-1)){
						end=columnListSize;
					}else{
						end=(i+1)*schemaOptNum;
					}
					if(useV2C){
					
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_68);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_69);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_77);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_78);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_84);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_85);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_86);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_91);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_92);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_98);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_103);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_104);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_109);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_110);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_111);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_115);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_119);
    
						}
					}
					
    stringBuffer.append(TEXT_120);
    
				}
				
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_125);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");

String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
String tmp_filename = ElementParameterParser.getValue(node, "__TMP_FILENAME__");

String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");

String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;


boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
/* Build the Log4J message for the different parameters */

if(isLog4jEnabled) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(ElementParameterParser.getValue(node, "__LOOP_QUERY__"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LIMIT__"))?"\"\"":ElementParameterParser.getValue(node, "__LIMIT__"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));
    stringBuffer.append(TEXT_139);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_146);
     } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GENERATION_MODE__"));
    stringBuffer.append(TEXT_150);
     if("DOM4J".equalsIgnoreCase(ElementParameterParser.getValue(node, "__GENERATION_MODE__"))) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IGNORE_NS__"));
    stringBuffer.append(TEXT_154);
     if("true".equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"))) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TMP_FILENAME__"));
    stringBuffer.append(TEXT_158);
     } 
    stringBuffer.append(TEXT_159);
     } 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USE_SEPARATOR__"));
    stringBuffer.append(TEXT_163);
     if("true".equals(ElementParameterParser.getValue(node, "__USE_SEPARATOR__"))) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__"));
    stringBuffer.append(TEXT_167);
     } 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CHECK_DATE__"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
}
		
/* -------------------------- */

log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
	}

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    if("true".equals(useSeparator)){
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
      }

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_223);
    if (dieOnError) {
    stringBuffer.append(TEXT_224);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    }else{
    stringBuffer.append(TEXT_228);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    if (dieOnError) {
    stringBuffer.append(TEXT_259);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    }else{
    stringBuffer.append(TEXT_263);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    }
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    
	}

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
      }

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_303);
    if (dieOnError) {
    stringBuffer.append(TEXT_304);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    }else{
    stringBuffer.append(TEXT_308);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    }
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    if (dieOnError) {
    stringBuffer.append(TEXT_346);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    }else{
    stringBuffer.append(TEXT_350);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    }
    stringBuffer.append(TEXT_353);
    }
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_359);
    
	}

    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    if (dieOnError) {
    stringBuffer.append(TEXT_382);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    }else{
    stringBuffer.append(TEXT_386);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    }
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    }
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    if(("true").equals(ignore_NS_Str)){
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    }
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_431);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_432);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_433);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_436);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_437);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    if(ignoreDTD){
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    }
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_452);
    if (dieOnError) {
    stringBuffer.append(TEXT_453);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    }
    stringBuffer.append(TEXT_456);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    }
    stringBuffer.append(TEXT_459);
    }else{
    stringBuffer.append(TEXT_460);
    }
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    
}

    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		if (conns!=null) {
//************ add for reject start*****************
		    String rejectConnName = "";
		    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
		    if(rejectConns != null && rejectConns.size() > 0) {
		        IConnection rejectConn = rejectConns.get(0);
		        rejectConnName = rejectConn.getName();
		    }
		    List<IMetadataColumn> rejectColumnList = null;
		    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
		    if(metadataTable != null) {
		        rejectColumnList = metadataTable.getListColumns();      
		    }
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_482);
    
				}
    		}
//***************************end********************
			Map<String,String> varsMap=new java.util.HashMap<String,String>();
			varsMap.put("xml_api_"+cid,"XML_API_"+cid);
			if("true".equals(useSeparator)){
				varsMap.put("contentTool_"+cid,"ContentTool_"+cid);
			}
			if(("Xerces").equals(mode)){
				varsMap.put("tmp_"+cid,"org.w3c.dom.Node");
				varsMap.put("node_"+cid,"org.w3c.dom.Node");
			}
			if(("Dom4j").equals(mode)){
				varsMap.put("node_"+cid,"org.dom4j.Node");
				varsMap.put("nsTool_"+cid,"NameSpaceTool_"+cid);
				varsMap.put("xmlNameSpaceMap_"+cid,"java.util.HashMap<String,String>");
				varsMap.put("temp_"+cid,"org.dom4j.tree.AbstractNode");
				if(("true").equals(ignore_NS_Str)){
					varsMap.put("namespaceContext_"+cid,"org.jaxen.NamespaceContext");
				}
			}
			if(("SAX").equals(mode)){
				varsMap.put("row_"+cid,"java.util.Map<String, String>");
				varsMap.put("node_"+cid,"String[]");
			}
			if(isLog4jEnabled){
				varsMap.put("log4jSb_"+cid,"StringBuffer");
			}
			class RowUtil extends DefaultRowUtil{
				public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
					cid = node.getUniqueName();
					boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
					List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
					List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
					IConnection conn = conns.get(0);
					String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
					boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
					String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
					String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
					
					String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
					boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
					boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));
					String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
					
					String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
					
					String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
					String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 
					String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
					
					for (int i=start;i<end;i++) { // S_for_a_1_0
						String query = mapping.get(i).get("QUERY");
						String nodeCheck = mapping.get(i).get("NODECHECK");
						if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_490);
    
							if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    
							}else{

    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    
							}

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_511);
    
						}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_512);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
							if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_521);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
							}
							//TDI-18498
							boolean isWrongConfig = false;
							
							for(IMetadataColumn column:metadata.getListColumns()) {
								if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
									if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
										if("id_Document".equals(column.getTalendType()) && "false".equals(nodeCheck)) {
											isWrongConfig = true;
											break;
										}
									}
								}
							}
							
							if(isWrongConfig) {

    stringBuffer.append(TEXT_525);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    }
    stringBuffer.append(TEXT_528);
    
							}

    stringBuffer.append(TEXT_529);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    
							
							}else{

    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    
						}

    stringBuffer.append(TEXT_542);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    
							
							}else{

    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    
							}

    stringBuffer.append(TEXT_554);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    
							
							}else{

    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    
							}

    stringBuffer.append(TEXT_580);
    
						}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_584);
    
							if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_589);
    
							}else{

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    
							}
						}
						for(IMetadataColumn column:metadata.getListColumns()) {  // S_for_0_1
							if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
								if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
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
									if(("Dom4j").equals(mode) && ("true").equals(nodeCheck)){
										if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_593);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(ignoreDTD);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_598);
    
										} else {

    stringBuffer.append(TEXT_599);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    
										}
										if(isLog4jEnabled){
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_606);
    if(i < mapping.size()-1){
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    }
									}
										continue;
									}
									if(javaType == JavaTypesManager.STRING){
										if(column.isNullable()){

    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_622);
    
										}else{ // column.isNullable()

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_632);
    
										}
									}else{ // other type
										if(column.isNullable()){

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_644);
    
								  		}else{ // column.isNullable()

    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_652);
    
										}
									}
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_653);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    
									} else if (javaType == JavaTypesManager.DATE) {
										if(checkDate) {

    stringBuffer.append(TEXT_657);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_661);
      
										} else {

    stringBuffer.append(TEXT_662);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_663);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_666);
    
										}
									} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_667);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_671);
    
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_672);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_674);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_677);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_678);
    
									} else {

    stringBuffer.append(TEXT_679);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_681);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    
									}
									if(isLog4jEnabled){

    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_687);
    
										if(i < mapping.size()-1){

    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    
										}
									}

    stringBuffer.append(TEXT_690);
    
								} //S_if_1_2
							} // S_if_1_1
						} // S_for_1_0
					} // S_for_a_1_0
				}
				
				public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
	    			for(int colNum=start;colNum<end;colNum++) {
	    				IMetadataColumn column=metadata.getListColumns().get(colNum);

    stringBuffer.append(TEXT_691);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_693);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_695);
    
					}
				}
			}//class defined end
			RowUtil rowUtil = new RowUtil(); 
			if (conns.size()>0) { // S_if_a_0_0	
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
			    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
			    	rowUtil.genVarsParmsStr(varsMap);
					rowUtil.prepareValueToConn(node, metadata, "String", "str_"+cid, firstConnName, schemaOptNum);
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
					}
					rowUtil.generateClass();
				}
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_699);
    
	rowUtil.callValueToConn("str_"+cid, firstConnName);

     log4jFileUtil.debugRetriveData(node); 
    stringBuffer.append(TEXT_700);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_701);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_702);
    }
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_705);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    }
    stringBuffer.append(TEXT_708);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_711);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_713);
    
                rowUtil.callConnToConn(firstConnName, rejectConnName);
                
    stringBuffer.append(TEXT_714);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_718);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_719);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_721);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_722);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_724);
    }
		}
        
    stringBuffer.append(TEXT_725);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_726);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_729);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_730);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_731);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_732);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_733);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_736);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_737);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_738);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_739);
     } 
    stringBuffer.append(TEXT_740);
    
			}
//***********************************

		} // if(conn!=null)
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_743);
    if(("SAX").equals(mode)) {
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    }
    stringBuffer.append(TEXT_746);
     
		}
	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_747);
    stringBuffer.append(TEXT_748);
    return stringBuffer.toString();
  }
}
