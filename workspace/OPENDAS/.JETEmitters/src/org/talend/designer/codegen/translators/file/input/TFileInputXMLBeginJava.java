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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_5 = " implements com.sun.org.apache.xml.internal.utils.PrefixResolver {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "    public String getBaseIdentifier() {" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return com.sun.org.apache.xml.internal.utils.Constants.S_XMLNAMESPACEURI;" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix, org.w3c.dom.Node context) {" + NL + "        return getNamespaceForPrefix(prefix);" + NL + "    }" + NL + "" + NL + "    public boolean handlesNullPrefixes() {" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "    public int[] getDefaulNSIndex(String path, String loopPath){" + NL + "\t\tString fullPath = loopPath;" + NL + "    \tif(!path.equals(fullPath)){" + NL + "        \tfor (String tmp : path.split(\"/\")) {" + NL + "        \t\tif ((\"..\").equals(tmp)) {" + NL + "                    fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                } else {" + NL + "                    fullPath += \"/\" + tmp;" + NL + "                }" + NL + "        \t}" + NL + "        }" + NL + "    \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "        java.util.Arrays.fill(indexs, -1);" + NL + "        int length = 0;" + NL + "        for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                length = defualtNSPath.get(i).length();" + NL + "            }" + NL + "        }" + NL + "    \treturn indexs;" + NL + "    }" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_6 = "{" + NL + "" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\tTalendPrefixResolver_";
  protected final String TEXT_7 = " pr = null;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "\tpublic void initXPath(org.w3c.dom.Node root){" + NL + "\t\tpr= new TalendPrefixResolver_";
  protected final String TEXT_8 = "();" + NL + "    \thasDefaultNS = pr.countNSMap(root);" + NL + "\t}" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\tcom.sun.org.apache.xpath.internal.objects.XObject obj = null;" + NL + "\t" + NL + "\tpublic int getNodeType(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tobj = com.sun.org.apache.xpath.internal.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\treturn obj.getType();" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tif(obj==null){" + NL + "\t\t\tobj = com.sun.org.apache.xpath.internal.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\t}" + NL + "\t\treturn obj.str();" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "    \tif(obj==null){" + NL + "        \tobj = com.sun.org.apache.xpath.internal.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        }" + NL + "        return obj.nodelist().item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "        com.sun.org.apache.xpath.internal.objects.XObject obj = com.sun.org.apache.xpath.internal.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        return obj.nodelist();" + NL + "    }" + NL + "    " + NL + "    private String addDefaultNSPrefix(String path) {" + NL + "        if (hasDefaultNS) {" + NL + "            StringBuffer newPath = new StringBuffer();" + NL + "            int[] indexs= pr.getDefaulNSIndex(path,loopPath);" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL;
  protected final String TEXT_9 = NL + "class ContentTool_";
  protected final String TEXT_10 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_11 = " contentTool_";
  protected final String TEXT_12 = " = new ContentTool_";
  protected final String TEXT_13 = "();" + NL + "contentTool_";
  protected final String TEXT_14 = ".field_separator=";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + NL + "XML_API_";
  protected final String TEXT_17 = " xml_api_";
  protected final String TEXT_18 = " = new XML_API_";
  protected final String TEXT_19 = "();" + NL + "xml_api_";
  protected final String TEXT_20 = ".loopPath=";
  protected final String TEXT_21 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_22 = " = new org.apache.xerces.parsers.DOMParser();" + NL + "parser_";
  protected final String TEXT_23 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_24 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_25 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_26 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_27 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_28 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "boolean isValidFile_";
  protected final String TEXT_31 = " = true;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_32 = " != null && filename_";
  protected final String TEXT_33 = " instanceof String && filename_";
  protected final String TEXT_34 = ".toString().startsWith(\"//\")){" + NL + "    \tfilename_";
  protected final String TEXT_35 = " = filename_";
  protected final String TEXT_36 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_37 = " instanceof java.io.InputStream){" + NL + "    \tparser_";
  protected final String TEXT_38 = ".parse(new org.xml.sax.InputSource((java.io.InputStream)filename_";
  protected final String TEXT_39 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_40 = "= new java.io.FileInputStream(filename_";
  protected final String TEXT_41 = ".toString());" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_42 = " = new org.xml.sax.InputSource(in_";
  protected final String TEXT_43 = ");" + NL + "    \txmlInputSource_";
  protected final String TEXT_44 = ".setEncoding(";
  protected final String TEXT_45 = ");" + NL + "    \tparser_";
  protected final String TEXT_46 = ".parse(xmlInputSource_";
  protected final String TEXT_47 = ");" + NL + "    }" + NL + "}catch(Exception e){";
  protected final String TEXT_48 = NL + "\tthrow(e);";
  protected final String TEXT_49 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_50 = " = false;";
  protected final String TEXT_51 = NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_52 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_53 = " = parser_";
  protected final String TEXT_54 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_55 = ".initXPath(doc_";
  protected final String TEXT_56 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_57 = " = xml_api_";
  protected final String TEXT_58 = ".getNodeList(doc_";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_61 = "  = null;" + NL + "String str_";
  protected final String TEXT_62 = " = null;" + NL + "for (int i_";
  protected final String TEXT_63 = " = 0; i_";
  protected final String TEXT_64 = " < nodelist_";
  protected final String TEXT_65 = ".getLength(); i_";
  protected final String TEXT_66 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_67 = " = nodelist_";
  protected final String TEXT_68 = ".item(i_";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "class NameSpaceTool_";
  protected final String TEXT_71 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "        \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_72 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_73 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_74 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_75 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_76 = " = new org.dom4j.io.SAXReader();" + NL + "Object filename_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL + "if(filename_";
  protected final String TEXT_79 = " != null && filename_";
  protected final String TEXT_80 = " instanceof String && filename_";
  protected final String TEXT_81 = ".toString().startsWith(\"//\")){" + NL + "\tfilename_";
  protected final String TEXT_82 = " = filename_";
  protected final String TEXT_83 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "}" + NL;
  protected final String TEXT_84 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_85 = " = null;" + NL + "if(filename_";
  protected final String TEXT_86 = " instanceof java.io.InputStream){" + NL + "\tdoc_reader_";
  protected final String TEXT_87 = " = reader_";
  protected final String TEXT_88 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_89 = ");" + NL + "}else{" + NL + "\tdoc_reader_";
  protected final String TEXT_90 = " = reader_";
  protected final String TEXT_91 = ".read(new java.io.File(filename_";
  protected final String TEXT_92 = ".toString()).toURI().toString());" + NL + "}" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_93 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_94 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "format_";
  protected final String TEXT_95 = ".setTrimText(false);" + NL + "format_";
  protected final String TEXT_96 = ".setEncoding(";
  protected final String TEXT_97 = ");" + NL + "" + NL + "new XML_NS_RMV_";
  protected final String TEXT_98 = "().removeNamespace(doc_reader_";
  protected final String TEXT_99 = ",doc_tmp_";
  protected final String TEXT_100 = ");" + NL + "" + NL + "doc_reader_";
  protected final String TEXT_101 = ".clearContent();" + NL + "doc_reader_";
  protected final String TEXT_102 = " = null;" + NL + "" + NL + "java.io.FileOutputStream stream_";
  protected final String TEXT_103 = " = new java.io.FileOutputStream(";
  protected final String TEXT_104 = ");" + NL + "org.dom4j.io.XMLWriter output_";
  protected final String TEXT_105 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_106 = ", format_";
  protected final String TEXT_107 = ");" + NL + "output_";
  protected final String TEXT_108 = ".write(doc_tmp_";
  protected final String TEXT_109 = ");" + NL + "output_";
  protected final String TEXT_110 = ".close();" + NL + "" + NL + "filename_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ";";
  protected final String TEXT_113 = NL + "boolean isValidFile_";
  protected final String TEXT_114 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_115 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_116 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_";
  protected final String TEXT_117 = " = reader_";
  protected final String TEXT_118 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_119 = ");" + NL + "\t}else{" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_120 = "= new org.xml.sax.InputSource(new java.io.FileInputStream(filename_";
  protected final String TEXT_121 = ".toString()));" + NL + "\t\tin_";
  protected final String TEXT_122 = ".setEncoding(";
  protected final String TEXT_123 = ");\t\t" + NL + "\t\tdoc_";
  protected final String TEXT_124 = " = reader_";
  protected final String TEXT_125 = ".read(in_";
  protected final String TEXT_126 = ");" + NL + "\t}" + NL + "}catch(Exception e){";
  protected final String TEXT_127 = NL + "\tthrow(e);";
  protected final String TEXT_128 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_129 = " = false;";
  protected final String TEXT_130 = NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_131 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_132 = " nsTool_";
  protected final String TEXT_133 = " = new NameSpaceTool_";
  protected final String TEXT_134 = "();" + NL + "nsTool_";
  protected final String TEXT_135 = ".countNSMap(doc_";
  protected final String TEXT_136 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_137 = " = nsTool_";
  protected final String TEXT_138 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_139 = " = doc_";
  protected final String TEXT_140 = ".createXPath(nsTool_";
  protected final String TEXT_141 = ".addDefaultNSPrefix(";
  protected final String TEXT_142 = ",";
  protected final String TEXT_143 = "));  " + NL + "x_";
  protected final String TEXT_144 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_145 = "); " + NL + "" + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_146 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_147 = ".selectNodes(doc_";
  protected final String TEXT_148 = ");\t" + NL + "XML_API_";
  protected final String TEXT_149 = " xml_api_";
  protected final String TEXT_150 = " = new XML_API_";
  protected final String TEXT_151 = "();" + NL + "String str_";
  protected final String TEXT_152 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_153 = " = null;" + NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_154 = ": nodeList_";
  protected final String TEXT_155 = ") {";
  protected final String TEXT_156 = NL + "class XML_API_";
  protected final String TEXT_157 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_158 = " xml_api_";
  protected final String TEXT_159 = " = new XML_API_";
  protected final String TEXT_160 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_161 = " = new String[]{";
  protected final String TEXT_162 = "\t" + NL + "\t";
  protected final String TEXT_163 = "\t\t" + NL + "\t,";
  protected final String TEXT_164 = "+\"/@xsi:nil\"";
  protected final String TEXT_165 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_166 = " = new boolean[]{";
  protected final String TEXT_167 = "\t" + NL + "\t";
  protected final String TEXT_168 = "\t\t" + NL + "\t,false";
  protected final String TEXT_169 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_170 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_171 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_172 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_173 = ",queryPaths_";
  protected final String TEXT_174 = ",asXMLs_";
  protected final String TEXT_175 = ");" + NL + "looper_";
  protected final String TEXT_176 = ".setEncoding(";
  protected final String TEXT_177 = ");" + NL + "Object filename_";
  protected final String TEXT_178 = " = ";
  protected final String TEXT_179 = ";" + NL + "if(filename_";
  protected final String TEXT_180 = " != null && filename_";
  protected final String TEXT_181 = " instanceof String && filename_";
  protected final String TEXT_182 = ".toString().startsWith(\"//\")){" + NL + "\tfilename_";
  protected final String TEXT_183 = " = filename_";
  protected final String TEXT_184 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_185 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_186 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_187 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_188 = ".parse(filename_";
  protected final String TEXT_189 = ".toString());" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_190 = "  = looper_";
  protected final String TEXT_191 = ".iterator();" + NL + "while (it_";
  protected final String TEXT_192 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_193 = " = it_";
  protected final String TEXT_194 = ".next();";
  protected final String TEXT_195 = NL + "\tnb_line_";
  protected final String TEXT_196 = "++;";
  protected final String TEXT_197 = NL + "\t";
  protected final String TEXT_198 = " = null;\t\t\t";
  protected final String TEXT_199 = NL + "\tboolean whetherReject_";
  protected final String TEXT_200 = " = false;" + NL + "\t";
  protected final String TEXT_201 = " = new ";
  protected final String TEXT_202 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_203 = NL + "\tif(xml_api_";
  protected final String TEXT_204 = ".getNodeType(tmp_";
  protected final String TEXT_205 = ",";
  protected final String TEXT_206 = ")==com.sun.org.apache.xpath.internal.objects.XObject.CLASS_NODESET){" + NL + "\t\tnode_";
  protected final String TEXT_207 = " = xml_api_";
  protected final String TEXT_208 = ".getSingleNode(tmp_";
  protected final String TEXT_209 = ",";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL + "    \tif(node_";
  protected final String TEXT_212 = "!=null && node_";
  protected final String TEXT_213 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_214 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_215 = " = contentTool_";
  protected final String TEXT_216 = ".getNodeContent(node_";
  protected final String TEXT_217 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_218 = " = node_";
  protected final String TEXT_219 = "!=null?node_";
  protected final String TEXT_220 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_221 = NL + "\t\tstr_";
  protected final String TEXT_222 = " = node_";
  protected final String TEXT_223 = "!=null?node_";
  protected final String TEXT_224 = ".getTextContent():\"\";";
  protected final String TEXT_225 = NL + "\t}else{" + NL + "\t\tnode_";
  protected final String TEXT_226 = " = tmp_";
  protected final String TEXT_227 = ";" + NL + "\t\tstr_";
  protected final String TEXT_228 = " = xml_api_";
  protected final String TEXT_229 = ".getNodeString(tmp_";
  protected final String TEXT_230 = ",";
  protected final String TEXT_231 = ");" + NL + "\t}";
  protected final String TEXT_232 = NL + "\torg.dom4j.XPath xTmp";
  protected final String TEXT_233 = "_";
  protected final String TEXT_234 = " = temp_";
  protected final String TEXT_235 = ".createXPath(nsTool_";
  protected final String TEXT_236 = ".addDefaultNSPrefix(";
  protected final String TEXT_237 = ",";
  protected final String TEXT_238 = "));" + NL + "    xTmp";
  protected final String TEXT_239 = "_";
  protected final String TEXT_240 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_241 = ");" + NL + "    Object obj";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = " = xTmp";
  protected final String TEXT_244 = "_";
  protected final String TEXT_245 = ".evaluate(temp_";
  protected final String TEXT_246 = ");" + NL + "    if(obj";
  protected final String TEXT_247 = "_";
  protected final String TEXT_248 = " instanceof String || obj";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_251 = " = temp_";
  protected final String TEXT_252 = ";" + NL + "    \tstr_";
  protected final String TEXT_253 = " = String.valueOf(obj";
  protected final String TEXT_254 = "_";
  protected final String TEXT_255 = ");" + NL + "    }else{" + NL + "    \tnode_";
  protected final String TEXT_256 = " = xTmp";
  protected final String TEXT_257 = "_";
  protected final String TEXT_258 = ".selectSingleNode(temp_";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "\t\tstr_";
  protected final String TEXT_261 = " = node_";
  protected final String TEXT_262 = "==null?null:node_";
  protected final String TEXT_263 = ".asXML();";
  protected final String TEXT_264 = NL + "    \tstr_";
  protected final String TEXT_265 = " = xTmp";
  protected final String TEXT_266 = "_";
  protected final String TEXT_267 = ".valueOf(temp_";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "\t}";
  protected final String TEXT_270 = NL + "\tstr_";
  protected final String TEXT_271 = " = row_";
  protected final String TEXT_272 = ".get(";
  protected final String TEXT_273 = ");";
  protected final String TEXT_274 = NL + "\tnode_";
  protected final String TEXT_275 = " = new String[]{str_";
  protected final String TEXT_276 = ",row_";
  protected final String TEXT_277 = ".get(";
  protected final String TEXT_278 = "+\"/@xsi:nil\")};";
  protected final String TEXT_279 = NL + "\tnode_";
  protected final String TEXT_280 = " = new String[]{str_";
  protected final String TEXT_281 = ",null};";
  protected final String TEXT_282 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_285 = ");";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = " = str_";
  protected final String TEXT_289 = ";";
  protected final String TEXT_290 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_291 = ".isDefNull(node_";
  protected final String TEXT_292 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_295 = ".isEmpty(node_";
  protected final String TEXT_296 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_297 = ".";
  protected final String TEXT_298 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_299 = ".isMissing(node_";
  protected final String TEXT_300 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_301 = ".";
  protected final String TEXT_302 = " =";
  protected final String TEXT_303 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_305 = ".isEmpty(node_";
  protected final String TEXT_306 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_309 = ".isMissing(node_";
  protected final String TEXT_310 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_311 = ".";
  protected final String TEXT_312 = " =";
  protected final String TEXT_313 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_314 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_315 = ".isDefNull(node_";
  protected final String TEXT_316 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_319 = ".isEmpty(node_";
  protected final String TEXT_320 = ") || xml_api_";
  protected final String TEXT_321 = ".isMissing(node_";
  protected final String TEXT_322 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = "=";
  protected final String TEXT_325 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_326 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_327 = ".isMissing(node_";
  protected final String TEXT_328 = ") || xml_api_";
  protected final String TEXT_329 = ".isEmpty(node_";
  protected final String TEXT_330 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " =";
  protected final String TEXT_333 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_334 = NL + "\t\t";
  protected final String TEXT_335 = ".";
  protected final String TEXT_336 = " = str_";
  protected final String TEXT_337 = ";";
  protected final String TEXT_338 = NL + "\t\t";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_341 = ", ";
  protected final String TEXT_342 = ",false);";
  protected final String TEXT_343 = NL + "\t\t";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_346 = ", ";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_349 = ".";
  protected final String TEXT_350 = " = str_";
  protected final String TEXT_351 = ".getBytes(";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "\t\t";
  protected final String TEXT_354 = ".";
  protected final String TEXT_355 = " = ParserUtils.parseTo_";
  protected final String TEXT_356 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_357 = ", ";
  protected final String TEXT_358 = ", ";
  protected final String TEXT_359 = "));";
  protected final String TEXT_360 = NL + "\t\t";
  protected final String TEXT_361 = ".";
  protected final String TEXT_362 = " = ParserUtils.parseTo_";
  protected final String TEXT_363 = "(str_";
  protected final String TEXT_364 = ");";
  protected final String TEXT_365 = NL + "\t}";
  protected final String TEXT_366 = " ";
  protected final String TEXT_367 = " = null; ";
  protected final String TEXT_368 = NL + "\t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_369 = " = true;";
  protected final String TEXT_370 = NL + "            throw(e);";
  protected final String TEXT_371 = NL + "                    ";
  protected final String TEXT_372 = " = new ";
  protected final String TEXT_373 = "Struct();";
  protected final String TEXT_374 = NL + "                    ";
  protected final String TEXT_375 = ".";
  protected final String TEXT_376 = " = ";
  protected final String TEXT_377 = ".";
  protected final String TEXT_378 = ";";
  protected final String TEXT_379 = NL + "                ";
  protected final String TEXT_380 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_381 = ";";
  protected final String TEXT_382 = NL + "                ";
  protected final String TEXT_383 = " = null;";
  protected final String TEXT_384 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_385 = NL + "                ";
  protected final String TEXT_386 = " = null;";
  protected final String TEXT_387 = NL + "            \t";
  protected final String TEXT_388 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_389 = ";";
  protected final String TEXT_390 = NL + "    }";
  protected final String TEXT_391 = NL + "\t\t";
  protected final String TEXT_392 = "if(!whetherReject_";
  protected final String TEXT_393 = ") { ";
  protected final String TEXT_394 = "      " + NL + "             if(";
  protected final String TEXT_395 = " == null){ " + NL + "            \t ";
  protected final String TEXT_396 = " = new ";
  protected final String TEXT_397 = "Struct();" + NL + "             }";
  protected final String TEXT_398 = NL + "\t    \t ";
  protected final String TEXT_399 = ".";
  protected final String TEXT_400 = " = ";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = ";    \t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t";
  protected final String TEXT_404 = " } ";
  protected final String TEXT_405 = "\t";
  protected final String TEXT_406 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_407 = ">";
  protected final String TEXT_408 = ") {" + NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_409 = NL + "\t\t\t";
  protected final String TEXT_410 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    if("true".equals(useSeparator)){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(loopQuery);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(filename );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if (dieOnError) {
    stringBuffer.append(TEXT_48);
    }else{
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
	}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(filename );
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
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_112);
    
	}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    if (dieOnError) {
    stringBuffer.append(TEXT_127);
    }else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_163);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_164);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_167);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_168);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
}

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
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

    stringBuffer.append(TEXT_197);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_198);
    
				}
    		}
//***************************end********************
			if (conns.size()>0) { // S_if_a_0_0		
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_202);
    
				
				for (int i=0;i<mapping.size();i++) { // S_for_a_1_0
					String query = mapping.get(i).get("QUERY");
					String nodeCheck = mapping.get(i).get("NODECHECK");
					if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_210);
    
						if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
						}else{

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
						}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_231);
    
					}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_232);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    
							
						}else{

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
						}

    stringBuffer.append(TEXT_269);
    
					}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_273);
    
						if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_278);
    
						}else{

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    
						}
					}
					for(IMetadataColumn column:columns) {  // S_for_0_1
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

    stringBuffer.append(TEXT_282);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    
									} else {

    stringBuffer.append(TEXT_286);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    
									}
									continue;
								}
								if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_303);
    
									}else{ // column.isNullable()

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_313);
    
									}
								}else{ // other type
									if(column.isNullable()){

    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_325);
    
								  	}else{ // column.isNullable()

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_333);
    
									}
								}
								
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_334);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    
								} else if (javaType == JavaTypesManager.DATE) {
									if(checkDate) {

    stringBuffer.append(TEXT_338);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_342);
      
									} else {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_347);
    										
									}
								} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_348);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_352);
    
								} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_353);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_355);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_359);
    
								} else {

    stringBuffer.append(TEXT_360);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    
								}

    stringBuffer.append(TEXT_365);
    
							} //S_if_1_2
						} // S_if_1_1
					} // S_for_1_0
				} // S_for_a_0_1

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_366);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_370);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_371);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_373);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_374);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_376);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_378);
    
                }
                
    stringBuffer.append(TEXT_379);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_383);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_384);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_386);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_389);
    }
		}
        
    stringBuffer.append(TEXT_390);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_391);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_394);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_397);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_398);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_402);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_403);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_404);
     } 
    stringBuffer.append(TEXT_405);
    
			}
//***********************************

		} // if(conn!=null)
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_408);
     
		}
	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_409);
    stringBuffer.append(TEXT_410);
    return stringBuffer.toString();
  }
}
