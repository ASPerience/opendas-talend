package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.AbstractExternalNode;
import org.talend.designer.xmlmap.XmlMapComponent;
import org.talend.designer.xmlmap.model.emf.xmlmap.XmlMapData;
import org.eclipse.emf.common.util.EList;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarTable;
import org.talend.designer.xmlmap.model.emf.xmlmap.InputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.TreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.AbstractNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputTreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.NodeType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IHashableInputConnections;;

public class TXMLMapBeginJava
{
  protected static String nl;
  public static synchronized TXMLMapBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLMapBeginJava result = new TXMLMapBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\torg.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_2 = "LookupManager<";
  protected final String TEXT_3 = "Struct> tHash_Lookup_";
  protected final String TEXT_4 = " = " + NL + "\t\t(org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_5 = "LookupManager<";
  protected final String TEXT_6 = "Struct>) " + NL + "\t\t\t((org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_7 = "LookupManager<";
  protected final String TEXT_8 = "Struct>) " + NL + "\t\t\t\t globalMap.get( \"tHash_Lookup_";
  protected final String TEXT_9 = "\" ))" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t.clone()" + NL + "\t\t\t\t";
  protected final String TEXT_11 = ";" + NL + "\t";
  protected final String TEXT_12 = NL + "\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_13 = "Struct> tHash_Lookup_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "null;";
  protected final String TEXT_16 = "(org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_17 = "Struct>) " + NL + "\t\t\t((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_18 = "Struct>) " + NL + "\t\t\t\tglobalMap.get( \"tHash_Lookup_";
  protected final String TEXT_19 = "\" ))" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t.clone()" + NL + "\t\t\t\t";
  protected final String TEXT_21 = ";" + NL + "\t";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = NL + "\t" + NL + "\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_24 = "Struct> tHash_Lookup_Cache_";
  protected final String TEXT_25 = " =" + NL + "\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup." + NL + "\t\t<";
  protected final String TEXT_26 = "Struct>getLookup(org.talend.designer.components.lookup.commom.ICommonLookup.MATCHING_MODE.";
  protected final String TEXT_27 = ");" + NL + "\t" + NL + "\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_28 = "Struct tHash_Lookup_Real_";
  protected final String TEXT_29 = " = null;" + NL + "\t";
  protected final String TEXT_30 = NL + "\t\ttHash_Lookup_";
  protected final String TEXT_31 = ".initGet();" + NL + "\t";
  protected final String TEXT_32 = NL + "\t";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = "HashKey = new ";
  protected final String TEXT_35 = "();" + NL + "\t";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = "Default = new ";
  protected final String TEXT_38 = "();" + NL + "\t";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = " = new ";
  protected final String TEXT_41 = "();" + NL + "\t";
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = NL + "//===============================input xml init part===============================" + NL + "" + NL + "class NameSpaceTool_";
  protected final String TEXT_44 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "        \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_45 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}";
  protected final String TEXT_46 = NL + "class TreeNode_API_";
  protected final String TEXT_47 = " {" + NL + "\tjava.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();" + NL + "\t" + NL + "\tvoid clear(){" + NL + "\t\txpath_value_map.clear();" + NL + "\t}" + NL + "\t" + NL + "\tvoid put(String xpath, String value){" + NL + "\t\txpath_value_map.put(xpath, value);" + NL + "\t}" + NL + "\tString get_null(String xpath) {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_48 = NL + "}";
  protected final String TEXT_49 = NL + "\tString get_String(String xpath){" + NL + "\t\treturn xpath_value_map.get(xpath);" + NL + "\t}";
  protected final String TEXT_50 = NL + "\tjava.util.Date get_Date(String xpath, String pattern){" + NL + "\t\tif(xpath_value_map.get(xpath)==null) return null;" + NL + "\t\treturn ParserUtils.parseTo_Date(xpath_value_map.get(xpath), pattern);" + NL + "\t}";
  protected final String TEXT_51 = NL + "\tbyte[] get_Bytes(String xpath){" + NL + "\t\tif(xpath_value_map.get(xpath)==null) return null;" + NL + "\t\treturn xpath_value_map.get(xpath).getBytes();" + NL + "\t}";
  protected final String TEXT_52 = NL + "\t";
  protected final String TEXT_53 = " get_";
  protected final String TEXT_54 = "(String xpath){" + NL + "\t\treturn ParserUtils.parseTo_";
  protected final String TEXT_55 = "(xpath_value_map.get(xpath));" + NL + "\t}";
  protected final String TEXT_56 = NL + "\tclass ";
  protected final String TEXT_57 = " {";
  protected final String TEXT_58 = "\t";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "\t}" + NL + "\t";
  protected final String TEXT_62 = " ";
  protected final String TEXT_63 = " = new ";
  protected final String TEXT_64 = "();";
  protected final String TEXT_65 = NL + "// ###############################" + NL + "// # Outputs initialization";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = "_tmp = new ";
  protected final String TEXT_69 = "();";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = "_save = new ";
  protected final String TEXT_73 = "();";
  protected final String TEXT_74 = NL + "// ###############################";
  protected final String TEXT_75 = NL + NL + "\t\t\tTreeNode_API_";
  protected final String TEXT_76 = " treeNodeAPI_";
  protected final String TEXT_77 = " = new TreeNode_API_";
  protected final String TEXT_78 = "();" + NL + "\t\t\tint nb_line_";
  protected final String TEXT_79 = " = 0; " + NL + "\t\t\tNameSpaceTool_";
  protected final String TEXT_80 = " nsTool_";
  protected final String TEXT_81 = " = new NameSpaceTool_";
  protected final String TEXT_82 = "();";
  protected final String TEXT_83 = NL + "\t" + NL + "    XML_API_";
  protected final String TEXT_84 = " xml_api_";
  protected final String TEXT_85 = " = new XML_API_";
  protected final String TEXT_86 = "();" + NL;
  protected final String TEXT_87 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_88 = ";" + NL + "\t\tif (";
  protected final String TEXT_89 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_90 = "\") == null) {";
  protected final String TEXT_91 = NL + "            ";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ".addElement(\"";
  protected final String TEXT_94 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ".addElement(\"";
  protected final String TEXT_97 = "\");" + NL + "        }";
  protected final String TEXT_98 = NL + "\t\t\t\torg.dom4j.Element ";
  protected final String TEXT_99 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_100 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_101 = ".elements().add(order++,";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t\t\torg.dom4j.Element ";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ".addElement(\"";
  protected final String TEXT_106 = "\");" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\tsubTreeRootParent = ";
  protected final String TEXT_109 = ";";
  protected final String TEXT_110 = NL + "//\t\tif(";
  protected final String TEXT_111 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_112 = ".addAttribute(\"";
  protected final String TEXT_113 = "\",String.valueOf(";
  protected final String TEXT_114 = "));" + NL + "//\t\t}";
  protected final String TEXT_115 = NL + "\t\tnestXMLTool.setText(";
  protected final String TEXT_116 = ", String.valueOf(";
  protected final String TEXT_117 = "));";
  protected final String TEXT_118 = NL + "\t\t\tisNewElement = false;";
  protected final String TEXT_119 = NL + "\t\t\t\t\tif(isNewElement || groupbyList.size()<=";
  protected final String TEXT_120 = " || groupbyList.get(";
  protected final String TEXT_121 = ")==null";
  protected final String TEXT_122 = NL + "\t\t\t\t\t|| ( groupbyList.get(";
  protected final String TEXT_123 = ").get(";
  protected final String TEXT_124 = ")!=null ? !groupbyList.get(";
  protected final String TEXT_125 = ").get(";
  protected final String TEXT_126 = ").equals(";
  protected final String TEXT_127 = ") : ";
  protected final String TEXT_128 = "!=null )";
  protected final String TEXT_129 = NL + "\t\t\t\t\t){" + NL;
  protected final String TEXT_130 = "\t" + NL + "\t\t\t\t\tif(groupbyList.size()<=";
  protected final String TEXT_131 = "){" + NL + "\t\t\t\t\t\tgroupbyList.add(new java.util.ArrayList<String>());" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgroupbyList.get(";
  protected final String TEXT_132 = ").clear();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\tgroupbyList.get(";
  protected final String TEXT_134 = ").add(";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\t\t\t\t\tisNewElement=true;" + NL + "\t\t\t\t\tif(groupElementList.size()<=";
  protected final String TEXT_137 = "){" + NL + "\t\t\t\t\t\tgroupElementList.add(group";
  protected final String TEXT_138 = "_);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgroupElementList.set(";
  protected final String TEXT_139 = ",group";
  protected final String TEXT_140 = "_);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tsubTreeRootParent=groupElementList.get(";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "class NestXMLTool_";
  protected final String TEXT_143 = "{" + NL + "\tpublic void parseAndAdd(org.dom4j.Element nestRoot, String value){" + NL + "\t\ttry {" + NL + "            org.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText(\"<root>\"+ value + \"</root>\");" + NL + "    \t\tnestRoot.setContent(doc4Str.getRootElement().content());" + NL + "    \t} catch (Exception e) {" + NL + "    \t\te.printStackTrace();" + NL + "    \t\tnestRoot.setText(value);" + NL + "        }" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setText(org.dom4j.Element element, String value){" + NL + "\t\tif (value.startsWith(\"<![CDATA[\") && value.endsWith(\"]]>\")) {" + NL + "\t\t\tString text = value.substring(9, value.length()-3);" + NL + "\t\t\telement.addCDATA(text);" + NL + "\t\t}else{" + NL + "\t\t\telement.setText(value);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void replaceDefaultNameSpace(org.dom4j.Element nestRoot){" + NL + "\t\tif (nestRoot!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {" + NL + "        \t\tif ((\"\").equals(tmp.getQName().getNamespace().getURI()) && (\"\").equals(tmp.getQName().getNamespace().getPrefix())){" + NL + "        \t\t\ttmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));" + NL + "\t        \t}" + NL + "    \t    \treplaceDefaultNameSpace(tmp);" + NL + "       \t\t}" + NL + "       \t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void removeEmptyElement(org.dom4j.Element root){" + NL + "\t\tif (root!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {" + NL + "\t\t\t\tremoveEmptyElement(tmp);" + NL + "\t\t\t}" + NL + "\t\t\tif (root.content().size() == 0 " + NL + "    \t\t\t&& root.attributes().size() == 0 " + NL + "    \t\t\t&& root.declaredNamespaces().size() == 0) {" + NL + "    \t\t\tif(root.getParent()!=null){" + NL + "                \troot.getParent().remove(root);" + NL + "                }" + NL + "            }" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "//NestXMLTool_";
  protected final String TEXT_144 = " nestXMLTool_";
  protected final String TEXT_145 = " = new NestXMLTool_";
  protected final String TEXT_146 = "();" + NL;
  protected final String TEXT_147 = NL + "class GenerateDocument_";
  protected final String TEXT_148 = " {" + NL + "\t" + NL + "\tTreeNode_API_";
  protected final String TEXT_149 = " treeNodeAPI = null;" + NL + "\t" + NL + "\torg.dom4j.Document doc = null;" + NL + "\t" + NL + "\tNestXMLTool_";
  protected final String TEXT_150 = " nestXMLTool = null;" + NL + "\t" + NL + "\torg.dom4j.Element root4Group = null;" + NL + "\t" + NL + "\torg.dom4j.io.OutputFormat format = null;" + NL + "\t" + NL + "\tjava.util.List<java.util.List<String>> groupbyList = null;" + NL + "\tjava.util.List<org.dom4j.Element> groupElementList = null;" + NL + "\tint order = 0;" + NL + "\t" + NL + "\tboolean isFirst = true;" + NL + "\t" + NL + "\tboolean\tneedRoot = true;";
  protected final String TEXT_151 = NL + "\t" + NL + "    public GenerateDocument_";
  protected final String TEXT_152 = "(){" + NL + "//    \tthis.treeNodeAPI = treeNodeAPI;" + NL + "    \t" + NL + "    \tnestXMLTool = new NestXMLTool_";
  protected final String TEXT_153 = "();" + NL + "    \t" + NL + "    \tgroupbyList =  new java.util.ArrayList<java.util.List<String>>();" + NL + "\t\tgroupElementList = new java.util.ArrayList<org.dom4j.Element>();" + NL + "    \t" + NL + "    \tdoc = org.dom4j.DocumentHelper.createDocument();" + NL + "    \tformat = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "    \tformat.setTrimText(false);" + NL + "    }" + NL + "    " + NL + "    public org.dom4j.Document getDocument(){" + NL + "    \treturn this.doc;" + NL + "    }" + NL + "\t" + NL + "    void generateElements(TreeNode_API_";
  protected final String TEXT_154 = " treeNodeAPI,boolean isInnerJoin";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = "Struct ";
  protected final String TEXT_157 = NL + "\t";
  protected final String TEXT_158 = ", ";
  protected final String TEXT_159 = " ";
  protected final String TEXT_160 = NL + "\t";
  protected final String TEXT_161 = ") {" + NL + "\t" + NL + "\t" + NL + "\t/*if(this.treeNodeAPI==null) {" + NL + "\t\tthis.treeNodeAPI = treeNodeAPI;" + NL + "\t}*/" + NL + "\t" + NL + "\torg.dom4j.Element subTreeRootParent = null;" + NL + "// build root xml tree " + NL + "if (needRoot) {" + NL + "\tneedRoot=false;";
  protected final String TEXT_162 = NL + "\t\troot4Group = subTreeRootParent;" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent=root4Group;" + NL + "\t}" + NL + "\t/* build group xml tree */" + NL + "\tboolean isNewElement = false;";
  protected final String TEXT_163 = NL + "\t\tisNewElement = false;" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t}" + NL + "    }" + NL;
  protected final String TEXT_165 = NL;
  protected final String TEXT_166 = NL + "\t            class SortableRow_";
  protected final String TEXT_167 = " implements Comparable<SortableRow_";
  protected final String TEXT_168 = ">, routines.system.IPersistableRow<SortableRow_";
  protected final String TEXT_169 = "> { // G_TM_B_001 " + NL + "\t" + NL + "\t\t\t\t\tboolean is__rejectedInnerJoin;" + NL + "\t\t\t\t\t";
  protected final String TEXT_170 = " exprKey_";
  protected final String TEXT_171 = "__";
  protected final String TEXT_172 = ";" + NL + "\t\t\t                    \t";
  protected final String TEXT_173 = NL + "\t\t\t\t//";
  protected final String TEXT_174 = NL + "\t\t\t\t";
  protected final String TEXT_175 = " ";
  protected final String TEXT_176 = "__";
  protected final String TEXT_177 = ";" + NL + "\t\t\t                    ";
  protected final String TEXT_178 = NL + "\t\t\t        public void fillFrom(";
  protected final String TEXT_179 = " ";
  protected final String TEXT_180 = "Struct ";
  protected final String TEXT_181 = " ";
  protected final String TEXT_182 = " exprKey_";
  protected final String TEXT_183 = "__";
  protected final String TEXT_184 = ") {" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_185 = "this.";
  protected final String TEXT_186 = "__";
  protected final String TEXT_187 = " = ";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = ";" + NL + "\t\t\t            \t\t";
  protected final String TEXT_190 = NL + "\t\t\t            ";
  protected final String TEXT_191 = "this.exprKey_";
  protected final String TEXT_192 = "__";
  protected final String TEXT_193 = " = exprKey_";
  protected final String TEXT_194 = "__";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        public void copyDataTo(";
  protected final String TEXT_197 = "Struct ";
  protected final String TEXT_198 = ") {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = " = this.";
  protected final String TEXT_201 = "__";
  protected final String TEXT_202 = ";" + NL + "\t\t\t\t            \t";
  protected final String TEXT_203 = NL + "\t\t\t        }" + NL + "\t\t\t\t\tpublic String toString() {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\t\t\t\t\tsb.append(super.toString());" + NL + "\t\t\t\t\t\tsb.append(\"[\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_205 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_207 = "__";
  protected final String TEXT_208 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\tsb.append(\"=\");" + NL + "\t\t\t\t\t\t\t\t\t\tsb.append(String.valueOf(this.";
  protected final String TEXT_209 = "__";
  protected final String TEXT_210 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\tsb.append(\"]\");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn sb.toString();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t        public int compareTo(SortableRow_";
  protected final String TEXT_212 = " other) {" + NL + "\t\t\t            int returnValue = 0;" + NL + "\t\t\t            ";
  protected final String TEXT_213 = NL + "\t\t\t            \treturnValue = checkNullsAndCompare(this.exprKey_";
  protected final String TEXT_214 = "__";
  protected final String TEXT_215 = ", other.exprKey_";
  protected final String TEXT_216 = "__";
  protected final String TEXT_217 = ");" + NL + "\t\t\t            \tif (returnValue != 0) {" + NL + "\t\t\t                    return returnValue;" + NL + "\t\t\t            \t}" + NL + "\t\t\t            ";
  protected final String TEXT_218 = NL + "\t\t\t            return returnValue;" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "\t\t\t            int returnValue = 0;" + NL + "\t\t\t            if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "\t\t\t                returnValue = ((Comparable) object1).compareTo(object2);" + NL + "\t\t\t            } else if (object1 != null && object2 != null) {" + NL + "\t\t\t                returnValue = compareStrings(object1.toString(), object2" + NL + "\t\t\t                        .toString());" + NL + "\t\t\t            } else if (object1 == null && object2 != null) {" + NL + "\t\t\t                returnValue = 1;" + NL + "\t\t\t            } else if (object1 != null && object2 == null) {" + NL + "\t\t\t                returnValue = -1;" + NL + "\t\t\t            } else {" + NL + "\t\t\t                returnValue = 0;" + NL + "\t\t\t            }" + NL + "\t\t\t            return returnValue;" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        private int compareStrings(String string1, String string2) {" + NL + "\t\t\t            return string1.compareTo(string2);" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t\t\tpublic void readData(ObjectInputStream dis) {" + NL + "\t\t\t\t\t\tsynchronized(";
  protected final String TEXT_219 = "Struct.commonByteArrayLock) {" + NL + "\t\t\t\t\t\t    try {" + NL + "\t\t\t\t\t\t\t\tint length = 0;" + NL + "\t\t\t\t\t\t\t\tthis.is__rejectedInnerJoin = dis.readBoolean();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t            this.";
  protected final String TEXT_221 = "__";
  protected final String TEXT_222 = " = dis.read";
  protected final String TEXT_223 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_225 = "__";
  protected final String TEXT_226 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tif(length > ";
  protected final String TEXT_227 = "Struct.commonByteArray.length) {" + NL + "\t\t\t   \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_228 = "Struct.commonByteArray.length == 0) {" + NL + "\t\t\t           \t\t\t\t\t";
  protected final String TEXT_229 = "Struct.commonByteArray = new byte[1024];" + NL + "\t\t\t   \t\t\t\t\t\t} else {" + NL + "\t\t\t           \t\t\t\t\t";
  protected final String TEXT_230 = "Struct.commonByteArray = new byte[2 * length];" + NL + "\t\t\t           \t\t\t\t}" + NL + "\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t       \t\t\t\tdis.readFully(";
  protected final String TEXT_231 = "Struct.commonByteArray, 0, length);" + NL + "\t\t\t       \t\t\t\tthis.";
  protected final String TEXT_232 = "__";
  protected final String TEXT_233 = " = new String(";
  protected final String TEXT_234 = "Struct.commonByteArray, 0, length);" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_236 = "__";
  protected final String TEXT_237 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tthis.";
  protected final String TEXT_238 = "__";
  protected final String TEXT_239 = " = new Date(dis.readLong());" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_241 = "__";
  protected final String TEXT_242 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "\t\t\t       \t\t\t\tdis.readFully(byteArray);" + NL + "\t\t\t       \t\t\t\tthis.";
  protected final String TEXT_243 = "__";
  protected final String TEXT_244 = " = byteArray;" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t\tthis.";
  protected final String TEXT_246 = "__";
  protected final String TEXT_247 = " = (";
  protected final String TEXT_248 = ") dis.readObject();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_250 = "__";
  protected final String TEXT_251 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tthis.";
  protected final String TEXT_252 = "__";
  protected final String TEXT_253 = " = dis.read";
  protected final String TEXT_254 = "();" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t            ";
  protected final String TEXT_256 = NL + "\t\t\t\t            this.exprKey_";
  protected final String TEXT_257 = "__";
  protected final String TEXT_258 = " = dis.read";
  protected final String TEXT_259 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_261 = "__";
  protected final String TEXT_262 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tthis.exprKey_";
  protected final String TEXT_263 = "__";
  protected final String TEXT_264 = " = new Date(dis.readLong());" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_266 = "__";
  protected final String TEXT_267 = " = null;" + NL + "\t\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t\t   \t\t\t\t\tif(length > ";
  protected final String TEXT_268 = "Struct.commonByteArray.length) {" + NL + "\t\t\t\t   \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_269 = "Struct.commonByteArray.length == 0) {" + NL + "\t\t\t\t           \t\t\t\t\t";
  protected final String TEXT_270 = "Struct.commonByteArray = new byte[1024];" + NL + "\t\t\t\t   \t\t\t\t\t\t} else {" + NL + "\t\t\t\t           \t\t\t\t\t";
  protected final String TEXT_271 = "Struct.commonByteArray = new byte[2 * length];" + NL + "\t\t\t\t           \t\t\t\t}" + NL + "\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t       \t\t\t\tdis.readFully(";
  protected final String TEXT_272 = "Struct.commonByteArray, 0, length);" + NL + "\t\t\t\t       \t\t\t\tthis.exprKey_";
  protected final String TEXT_273 = "__";
  protected final String TEXT_274 = " = new String(";
  protected final String TEXT_275 = "Struct.commonByteArray, 0, length);" + NL + "\t\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_277 = "__";
  protected final String TEXT_278 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "\t\t\t       \t\t\t\tdis.readFully(byteArray);" + NL + "\t\t\t       \t\t\t\tthis.exprKey_";
  protected final String TEXT_279 = "__";
  protected final String TEXT_280 = " = byteArray;" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t   \t\t\t\tthis.exprKey_";
  protected final String TEXT_282 = "__";
  protected final String TEXT_283 = " = (";
  protected final String TEXT_284 = ") dis.readObject();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_286 = "__";
  protected final String TEXT_287 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tthis.exprKey_";
  protected final String TEXT_288 = "__";
  protected final String TEXT_289 = " = dis.read";
  protected final String TEXT_290 = "();" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_291 = NL + "\t\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t        throw new RuntimeException(e);" + NL + "\t\t\t\t";
  protected final String TEXT_292 = NL + "\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t\t\t} catch(ClassNotFoundException eCNFE) {" + NL + "\t\t\t\t\t\t\t throw new RuntimeException(eCNFE);" + NL + "\t\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t\t} " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\tpublic void writeData(ObjectOutputStream dos) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t   \tdos.writeBoolean(this.is__rejectedInnerJoin);" + NL + "\t\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t            \tdos.write";
  protected final String TEXT_296 = "(this.";
  protected final String TEXT_297 = "__";
  protected final String TEXT_298 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_299 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_300 = "__";
  protected final String TEXT_301 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t                byte[] byteArray = this.";
  protected final String TEXT_302 = "__";
  protected final String TEXT_303 = ".getBytes();" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "\t\t\t       \t\t\t\tdos.write(byteArray);" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_305 = "__";
  protected final String TEXT_306 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.writeLong(this.";
  protected final String TEXT_307 = "__";
  protected final String TEXT_308 = ".getTime());" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_310 = "__";
  protected final String TEXT_311 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(this.";
  protected final String TEXT_312 = "__";
  protected final String TEXT_313 = ".length);" + NL + "\t\t\t       \t\t\t\tdos.write(this.";
  protected final String TEXT_314 = "__";
  protected final String TEXT_315 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\t    \tdos.writeObject(this.";
  protected final String TEXT_317 = "__";
  protected final String TEXT_318 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_320 = "__";
  protected final String TEXT_321 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.write";
  protected final String TEXT_322 = "(this.";
  protected final String TEXT_323 = "__";
  protected final String TEXT_324 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t            ";
  protected final String TEXT_326 = NL + "\t\t\t\t            dos.write";
  protected final String TEXT_327 = "(this.exprKey_";
  protected final String TEXT_328 = "__";
  protected final String TEXT_329 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_330 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_331 = "__";
  protected final String TEXT_332 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t                byte[] byteArray = this.exprKey_";
  protected final String TEXT_333 = "__";
  protected final String TEXT_334 = ".getBytes();" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "\t\t\t       \t\t\t\tdos.write(byteArray);" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_335 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_336 = "__";
  protected final String TEXT_337 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.writeLong(this.exprKey_";
  protected final String TEXT_338 = "__";
  protected final String TEXT_339 = ".getTime());" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_340 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_341 = "__";
  protected final String TEXT_342 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(this.exprKey_";
  protected final String TEXT_343 = "__";
  protected final String TEXT_344 = ".length);" + NL + "\t\t\t       \t\t\t\tdos.write(this.exprKey_";
  protected final String TEXT_345 = "__";
  protected final String TEXT_346 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\t    \tdos.writeObject(this.exprKey_";
  protected final String TEXT_348 = "__";
  protected final String TEXT_349 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_350 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_351 = "__";
  protected final String TEXT_352 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.write";
  protected final String TEXT_353 = "(this.exprKey_";
  protected final String TEXT_354 = "__";
  protected final String TEXT_355 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\t        throw new RuntimeException(e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "\t     }" + NL + "\t   ";
  protected final String TEXT_358 = NL + "\t            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	XmlMapComponent node = (XmlMapComponent) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	XmlMapData xmlMapData=(XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
	
	EList<InputXmlTree> inputTables = xmlMapData.getInputTrees();
	EList<OutputXmlTree> outputTables = xmlMapData.getOutputTrees();
	EList<VarTable> varTables = xmlMapData.getVarTables();
	
	boolean hasConcurrencyContext = false;
	List<IConnection> inputConnections = (List<IConnection>)node.getIncomingConnections();
	HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
	for(IConnection connection : inputConnections){
		hNameToConnection.put(connection.getName(), connection);
	}
	
	List<InputXmlTree> inputTableTrees = new ArrayList<InputXmlTree>();
	for(int i=0; i<inputTables.size(); i++){
		InputXmlTree  currentTree = inputTables.get(i);
		if(hNameToConnection.get(currentTree.getName()) != null){
			inputTableTrees.add(currentTree);
		}
	}
	int lstSizeInputs = inputTableTrees.size();
	for(int i = 1; i<lstSizeInputs; i++){
		InputXmlTree inputTable = (InputXmlTree)inputTableTrees.get(i);
		String tableName = inputTable.getName();
		List<IMetadataTable> treeNodeEntries = node.getMetadataList();
		
		if(treeNodeEntries == null){
		      continue;
	    }
		
		boolean isAllRows = "ALL_ROWS".equals(inputTable.getMatchingMode());
		String className = tableName + "Struct";
		String lookupMode = inputTable.getLookupMode();
		boolean isReloadLookupMode = org.talend.designer.xmlmap.model.tree.LOOKUP_MODE.RELOAD.name().equals(lookupMode);
		boolean isCacheOrReloadLookupMode = org.talend.designer.xmlmap.model.tree.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(lookupMode);
		boolean isOneOfReloadLookupMode = isReloadLookupMode || isCacheOrReloadLookupMode;
		if(inputTable.isPersistent()){

    stringBuffer.append(TEXT_1);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_9);
    
				if(hasConcurrencyContext) {
				
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
		} else {
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_14);
    
	
	if(isOneOfReloadLookupMode) {
		 
    stringBuffer.append(TEXT_15);
    
	} else {
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_19);
    
				if(hasConcurrencyContext) {
				
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    
	}
	
    stringBuffer.append(TEXT_22);
    
	}
	String matchingModeStr = inputTable.getMatchingMode();
	if(isCacheOrReloadLookupMode) {
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(matchingModeStr);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_29);
    }
	if(isAllRows && !isOneOfReloadLookupMode) {
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_41);
    
	}
	
    stringBuffer.append(TEXT_42);
    
	class RepalceTableXpath {
		
		public void replaceTableXpath(TreeNode root){
			String xpath = root.getXpath();
			int index_p = xpath.indexOf(".");
			if(index_p<0){
    			xpath = xpath.replaceFirst("/", ".");
    			xpath = xpath.replaceFirst("/", ":/");
    			root.setXpath(xpath);
			}
    		for(TreeNode tmpNode : root.getChildren()) {
    			replaceTableXpath(tmpNode);
    		}
		}
	}
	RepalceTableXpath replaceXpath = new RepalceTableXpath();
	
	if(inputTables.size() > 0 && !inputTables.get(0).isLookup()) {
		InputXmlTree inputMainTable = inputTables.get(0);
		for(TreeNode tmpnode : inputMainTable.getNodes()) {
			if("id_Document".equals(tmpnode.getType())) {
				replaceXpath.replaceTableXpath(tmpnode);
				break;
			}
		}
	}
	for(OutputXmlTree outputMainTable : outputTables) {
		for(OutputTreeNode tmpnode : outputMainTable.getNodes()) {
			if("id_Document".equals(tmpnode.getType())) {
				replaceXpath.replaceTableXpath(tmpnode);
				break;
			}
		}
	}
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    

class GenerateMethodUtil {
	String cid = null;
	java.util.Map<String, String> typeMap = new java.util.HashMap<String, String>(); // Map<typeToGenerate, typeToGenerate>
	java.util.Map<String, String> pathTypeMap = new java.util.HashMap<String, String>(); // Map<input table xpath, typeToGenerate>
	java.util.Map<String, String> pathPatternMap = new java.util.HashMap<String, String>(); // Map<input table xpath, Pattern>
	java.util.Map<String, String> pathTypeToGenMap = new java.util.HashMap<String, String>(); // Map<"/root/name","String">
	
	void generateExprCode(String expression){
			StringBuilder strBuilder = new StringBuilder();
			if(expression==null || ("").equals(expression)) {
				return;
			}
	
			String currentExpression = expression;
			String tmpXpath = "";
			java.util.regex.Pattern expressionFromDoc = java.util.regex.Pattern.compile("\\[.*\\..*:.*\\]");
			java.util.regex.Matcher matcherFromDoc;
			
			boolean end = false;
			
			if(expression.indexOf("[")>-1) {
				strBuilder.append(expression.substring(0, expression.indexOf("[")));
				currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
				
				while(currentExpression.length()>0 && !end) {
					expression = currentExpression.substring(0, currentExpression.indexOf("]")+1);
					currentExpression = currentExpression.substring(expression.length(), currentExpression.length());
					matcherFromDoc = expressionFromDoc.matcher(expression);
					if(matcherFromDoc.matches()) {
						tmpXpath = expression.substring(1, expression.length()-1);
						if("id_String".equals(pathTypeMap.get(tmpXpath)) || "id_Object".equals(pathTypeMap.get(tmpXpath))){
							strBuilder.append("treeNodeAPI.get_String(\""+ tmpXpath + "\")");
						} else if("id_Date".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI.get_Date(\""+ tmpXpath + "\" , \"" + pathPatternMap.get(tmpXpath) + "\")");
						} else if("id_byte[]".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI.get_Bytes(\""+ tmpXpath + "\")");
						} else {
							strBuilder.append("treeNodeAPI.get_" + pathTypeToGenMap.get(tmpXpath) + "(\""+ tmpXpath + "\")");
						}				
					} else {
						strBuilder.append(expression);
					}
					if(currentExpression.indexOf("[")>-1) {
						strBuilder.append(currentExpression.substring(0, currentExpression.indexOf("[")));
						currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
					} else {
						strBuilder.append(currentExpression);
						end=true;
					}
				
				}
			} else {
				strBuilder.append(expression);
			}
			
    stringBuffer.append(strBuilder.toString());
    
		}
		
		public List<TreeNode> getGroupByNodeList(TreeNode group) {
			List<TreeNode> list = new ArrayList<TreeNode>();
			for (TreeNode attri : group.getChildren()) {
				if(NodeType.ATTRIBUT.equals(attri.getNodeType())) {
					list.add(attri);
				}
			}
			if (NodeType.ELEMENT.equals(group.getNodeType()) && group.getChildren().size()==0) {
				list.add(group);
			} else {
				if(NodeType.ELEMENT.equals(group.getNodeType()))
				for (TreeNode element : group.getChildren()) {
					if (!element.isMain() && !element.isLoop()) {
						list.addAll(getGroupByNodeList(element));
					}
				}
			}
			return list;
		}

	
	void generateCode(TreeNode node, String cid){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
		generateMethodCode(node, cid);

    stringBuffer.append(TEXT_48);
    
	}
	
	void generateMethodCode(TreeNode node, String cid) {

		if(node.getOutgoingConnections().size()>0){
			String talendType = node.getType();
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, node.isNullable());
			String patternValue = node.getPattern() == null || node.getPattern().trim().length() == 0 ? null : node.getPattern();
			
			pathTypeMap.put(node.getXpath(), talendType);
			pathPatternMap.put(node.getXpath(), patternValue);
			pathTypeToGenMap.put(node.getXpath(), typeToGenerate);
//			System.out.println("javaType:Id=" + javaType.getId() + "---talendType="+talendType +"---typeGen=" +typeToGenerate);
			if(typeMap.get(typeToGenerate)==null){
				typeMap.put(typeToGenerate,typeToGenerate);
				if ("id_String".equals(talendType) || "id_Object".equals(talendType)) {

    stringBuffer.append(TEXT_49);
    
				} else if ("id_Date".equals(talendType)) {

    stringBuffer.append(TEXT_50);
    
				} else if("id_byte[]".equals(talendType)){ 

    stringBuffer.append(TEXT_51);
    
				} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_55);
    
				}
			}
		} else {
    		for(TreeNode tmpNode : node.getChildren()) {
    			generateMethodCode(tmpNode,cid);
    		}
		}
	}
}

	// define the var row
	for (VarTable var : xmlMapData.getVarTables()) {
		String tableName = var.getName();
        String instanceVarName = tableName + "__" + node.getUniqueName();
        String className = instanceVarName + "__Struct";

    stringBuffer.append(TEXT_56);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_57);
    
            for(VarNode varNode : var.getNodes()){
                String javaType = varNode.getType();

    stringBuffer.append(TEXT_58);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(javaType, varNode.isNullable()) );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(varNode.getName() );
    stringBuffer.append(TEXT_60);
    
            }

    stringBuffer.append(TEXT_61);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( instanceVarName );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_64);
    
	}

    stringBuffer.append(TEXT_65);
    

		List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
		Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection connection : outputConnections) {
		  		nameToOutputConnection.put(connection.getName(), connection);
		}

//        EList<OutputXmlTree> outputTablesList = new ArrayList<OutputXmlTree>(outputTables);
        // constants
        for (OutputXmlTree table : outputTables) {
        
            EList<OutputTreeNode> tableEntries = table.getNodes();
            if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
                continue;
            }
            String tableName1 = table.getName();
            
            String instanceVarName = tableName1 + "__" + node.getUniqueName();
            String className = tableName1 + "Struct";
            

    stringBuffer.append(TEXT_66);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_73);
    
        }

    stringBuffer.append(TEXT_74);
    
	
//	List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();
	InputXmlTree mainInputTable = null;  // the main input table
	if(inputConnections==null || inputConnections.size() < 1) {
		return "";
	}

	if(inputTables==null || inputTables.size()==0) return "";
	for(IConnection conn : inputConnections) { // find the input main table
		InputXmlTree inputTable = inputTables.get(0);
		EConnectionType connectionType = conn.getLineStyle();
		if (connectionType == EConnectionType.FLOW_MAIN) {
			if(!inputTable.isLookup()) { // lookup is used to sign it is lookup table
    			mainInputTable = inputTable;
    			break;
			}
		}
	}
	
	class FindNodeUtil{
		
		TreeNode findLoopPathNode(TreeNode node){
			if(node == null){
				return null;
			}
			if(node.isLoop()) {
				return node;
			}
			for(TreeNode tmpNode : node.getChildren()) {
				TreeNode resultNode = findLoopPathNode(tmpNode);
				if(resultNode!=null){
					return resultNode;
				}
			}
			
			return null;
		}
		
		void findXpathArray(TreeNode node, String loopPath, List<String> resultList) {
			if(node.getOutgoingConnections().size()>0){
				String xpath = node.getXpath();
				String result = null;
				if(xpath==null || ("").equals(xpath)){
				} else if(xpath.equals(loopPath)){ // get the value in the loop elment
					result = ".";
				} else if(xpath.contains(loopPath)){ // find the loop path
					result = xpath.substring(loopPath.length() + 1);
				} else {
					StringBuilder resultBuff = new StringBuilder();
					String tmp = loopPath;
					
					while(!xpath.contains(tmp)){
						int index = tmp.lastIndexOf("/");
						if(index<0){ break; }
						tmp = tmp.substring(0,index-1);
						resultBuff.append("../");
					}
					if(tmp.lastIndexOf("/") < 0 ){
						System.out.println("Loop Path is not set or loop Path is invalid");
					}else{
						resultBuff.append(xpath.substring(tmp.length() + 1));
					}
					result = resultBuff.toString();
				}
				resultList.add(result);
			} else {
    			for(TreeNode tmpNode : node.getChildren()) {
    				findXpathArray(tmpNode, loopPath, resultList);
    			}
			}
		}
	}
	GenerateMethodUtil generateMethodUtil = new GenerateMethodUtil();
	generateMethodUtil.cid = cid;
	if(mainInputTable != null) {
		String mainInputName = mainInputTable.getName();
		for(TreeNode tmpNode : mainInputTable.getNodes()){
            generateMethodUtil.generateCode(tmpNode, cid); // begin part keep this part

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			break;
		}
    }


    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=====================================================output xml init part=======================================================================
class GenerateToolByDom4j{
	String cid = null;
	GenerateMethodUtil generateMethodUtil = null;
	java.util.List<java.util.List<TreeNode>> groupList = new java.util.ArrayList<java.util.List<TreeNode>>();
	java.util.List<java.util.List<java.util.List<TreeNode>>> groupbyNodeList = new java.util.ArrayList(new java.util.ArrayList<java.util.List<TreeNode>>());
	
	void setAllMainNodes(TreeNode root) {
		TreeNode loop = getLoopNode(root);
		if(loop==null) return;
		loop.setMain(true);
		TreeNode parent = (TreeNode)loop.eContainer();
		while((parent != null) && (!("id_Document").equals(parent.getType())) ) {
			parent.setMain(true);
			parent = (TreeNode)parent.eContainer();
		}
	}
	
	public TreeNode getLoopNode(TreeNode root) {
		if(root == null) {
			return null;
		}
		if(root.isLoop()){
			return root;
		}
		
		for(TreeNode node : root.getChildren()){
			TreeNode tmpNode = getLoopNode(node);
			if(tmpNode!=null) {
				return tmpNode;
			}
		}
		return null;
	}
	
	public void generateCode(OutputTreeNode node, String currEleName, String parentName){
		if(node.getNodeType()==NodeType.ELEMENT){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
		
    		// add namespace support here in the future
    		//
    		
    		addAttribute(currEleName, node);
//    		System.out.println("parent:" + ((OutputTreeNode)node).getName() + "===node:" + node.getName() );
    		if(!isRootEndMainNode(node)){
    			int index = 0;
				for(TreeNode child:node.getChildren()){
					if(!child.isLoop() && !child.isMain())
						generateCode((OutputTreeNode)child,currEleName+"_"+index++,currEleName);
    			}
			}
		}
	}
	
	private void createElement(String currEleName, OutputTreeNode node, String parentName){
		int index = 0;
		index = node.getName().indexOf(":");
		if(index>0 && hasParent(node)){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(node.getName().substring(0,index));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(node.getName().substring(index+1));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_97);
    
		}else{
			if(node.isMain() && node.isGroup()) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_102);
    
			} else {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_106);
    
			}
		}

    stringBuffer.append(TEXT_107);
    
		if(node.isGroup() || node.isMain()){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_109);
    
		}
	}
	
	private void addAttribute(String currEleName, OutputTreeNode node){
		for(TreeNode tmpNode : node.getChildren()) {
			if(tmpNode.getNodeType()==NodeType.ATTRIBUT) {

    stringBuffer.append(TEXT_110);
    //tool.getValue(node);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(tmpNode.getName() );
    stringBuffer.append(TEXT_113);
    generateMethodUtil.generateExprCode(tmpNode.getExpression()); 
    stringBuffer.append(TEXT_114);
    
			}
		}
	}
	
	private void setText(String currEleName, OutputTreeNode node){
		if(node.getExpression()!=null && !("").equals(node.getExpression()) ){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_116);
    generateMethodUtil.generateExprCode(node.getExpression()); 
    stringBuffer.append(TEXT_117);
    
		}
	}
	private boolean hasParent(OutputTreeNode node){
		if(node.eContainer()!=null){
			OutputTreeNode parent = (OutputTreeNode)node.eContainer();
			if(!("id_Document").equals(parent.getType()) && parent.isMain()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isRootEndMainNode(OutputTreeNode node){
//		System.out.println(node.getName() + ":main=" + node.isMain() + ":Loop=" + node.isLoop() + ":group=" + node.isGroup());
		if(!node.isMain() || node.isLoop() || node.isGroup()){
			return false;
		}
		for(TreeNode tmpNode: node.getChildren()){
			if(tmpNode.isMain() && (tmpNode.isLoop() || tmpNode.isGroup())){
				return true;
			}
		}
		return false;
	}
	// the root node which a group child or loop child
	private boolean isMediaMainNode(OutputTreeNode node) {
		if(node.isMain()) {
			for(TreeNode tmpNode : node.getChildren()) {
				if(tmpNode.isMain() && (tmpNode.isLoop() || tmpNode.isGroup())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void generateGroupCode(int index) {
		if(groupList.get(index).size()>0){

    stringBuffer.append(TEXT_118);
    
			for(int i=0;i<groupList.get(index).size();i++){
				TreeNode groupRootNode = groupList.get(index).get(i);

    stringBuffer.append(TEXT_119);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    
						for(int j=0;j<groupbyNodeList.get(index).get(i).size();j++){
							TreeNode attr = groupbyNodeList.get(index).get(i).get(j);

    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_126);
    generateMethodUtil.generateExprCode(attr.getExpression());
    stringBuffer.append(TEXT_127);
    generateMethodUtil.generateExprCode(attr.getExpression());
    stringBuffer.append(TEXT_128);
     
						}
			

    stringBuffer.append(TEXT_129);
    
					generateCode((OutputTreeNode)groupList.get(index).get(i),"group"+i+"_","subTreeRootParent");						

    stringBuffer.append(TEXT_130);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
     
					for(int j=0;j<groupbyNodeList.get(index).get(i).size();j++){
						TreeNode attr = groupbyNodeList.get(index).get(i).get(j);

    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    generateMethodUtil.generateExprCode(attr.getExpression());
    stringBuffer.append(TEXT_135);
     
					}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
     
		}
	}
}
	
	
	private void generateGroupCmpCode(OutputTreeNode node, int index) {
		for(TreeNode tmpNode : node.getChildren()) {
			if((tmpNode.isGroup()) && !tmpNode.isLoop()) {
				groupbyNodeList.get(index).add(generateMethodUtil.getGroupByNodeList(tmpNode));
				groupList.get(index).add(tmpNode);
				generateGroupCmpCode((OutputTreeNode)tmpNode, index);
			}
		}
	}
}

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
	generateToolByDom4j.cid = cid;
	generateToolByDom4j.generateMethodUtil = generateMethodUtil;
// define the generate the output document class
int index = -1;
for(OutputXmlTree outputTable : outputTables) {
	String tableName = outputTable.getName();
	for(OutputTreeNode outputNode: outputTable.getNodes()) {
		if(("id_Document").equals(outputNode.getType())){
			index+=1;

    stringBuffer.append(TEXT_147);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
//Integer groupSize = new Integer(0);
//getGroupSize(outputNode, groupSize);

    stringBuffer.append(TEXT_151);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    
	for (InputXmlTree inputTable: inputTables) {
	
	
    stringBuffer.append(TEXT_155);
    stringBuffer.append(inputTable.getName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(inputTable.getName() );
    stringBuffer.append(TEXT_157);
    
		
	}
	for (VarTable var : varTables) {
			String tableName1 = var.getName();
	        String instanceVarName = tableName1 + "__" + cid;
	        String className = instanceVarName + "__Struct";
	
    stringBuffer.append(TEXT_158);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(var.getName());
    stringBuffer.append(TEXT_160);
    
	}
	
    stringBuffer.append(TEXT_161);
    
	OutputTreeNode root = (OutputTreeNode)outputNode.getChildren().get(0); // get the root tree node
	generateToolByDom4j.setAllMainNodes(root);
	generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_162);
    
generateToolByDom4j.groupList.add(new java.util.ArrayList<TreeNode>());
generateToolByDom4j.groupbyNodeList.add(new java.util.ArrayList<java.util.List<TreeNode>>());
generateToolByDom4j.generateGroupCmpCode(root, index);
generateToolByDom4j.generateGroupCode(index);

    stringBuffer.append(TEXT_163);
    
			
			OutputTreeNode loop = (OutputTreeNode)generateToolByDom4j.getLoopNode(root);
			//if(loop==null){
			//	System.out.println("Loop is empty");
			//}else {
				
				generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
			//}
			
    stringBuffer.append(TEXT_164);
    
		} // if(docuemnt)
	}// for(outputNode)
} // for (outputXMLTree)

    stringBuffer.append(TEXT_165);
    

	HashMap<String, AbstractNode> hExternalInputTableEntries = new HashMap<String, AbstractNode>();
	
	String currentJoinedTableNames = "";
	
	int sizeInputTables = inputTables.size();
	        
	List<IConnection> cumulatedInputConnections = new ArrayList<IConnection>();
	
	String comma;
	for (int iInputTable = 0; iInputTable < sizeInputTables - 1; iInputTable++) { 
	        
			InputXmlTree currentInputTable = inputTables.get(iInputTable);
			InputXmlTree nextInputTable = null; 
			
			if(sizeInputTables > 1) {
				nextInputTable = inputTables.get(iInputTable + 1);
			}
			if(currentJoinedTableNames.length() > 0) {
				currentJoinedTableNames += "__";
			}
			currentJoinedTableNames += currentInputTable.getName();
		
			String currentTableName = currentInputTable.getName();
		    IConnection currentConection = hNameToConnection.get(currentTableName);
		    if (currentConection == null) {
		        continue;
		    }
		    cumulatedInputConnections.add(currentConection);
    
		if(nextInputTable != null && nextInputTable.isPersistent()) {
			
			List<IMetadataColumn> nextColumnsKeys = new ArrayList<IMetadataColumn>();
	
		        String nextTableName = nextInputTable.getName();
	            IConnection nextConection = hNameToConnection.get(nextTableName);
	            if (nextConection == null) {
	                continue;
	            }
	  
    stringBuffer.append(TEXT_166);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_169);
    
			        IMetadataTable nextMetadataTable = nextConection.getMetadataTable();
			        if (nextInputTable != null) {
			            hExternalInputTableEntries.clear();
			            List<TreeNode> trees = nextInputTable.getNodes();
			            if (trees == null) {
			                continue;
			            }

			            
			            List<IMetadataColumn> listColumns = nextMetadataTable.getListColumns();
			            //for (IMetadataColumn column : listColumns) {
			            for(int i=0; i<listColumns.size(); i++){
			            	IMetadataColumn column = listColumns.get(i);
			                TreeNode currentNode = (TreeNode)trees.get(i);
			            	if (currentNode != null) {
			            		String expressionKey = currentNode.getExpression();
			                    if (expressionKey != null && !"".equals(expressionKey.trim())) {
			                    
			                    	nextColumnsKeys.add(column);
			                    
			                    	
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_170);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_172);
    
				                           
			                    }
			                }
			            }
					}
				// properties declarations 
				
    stringBuffer.append(TEXT_173);
    stringBuffer.append( currentInputTable.getName() );
    stringBuffer.append(TEXT_174);
    
			        IMetadataTable currentMetadataTable = currentConection.getMetadataTable();
			        if (currentInputTable != null) {
			
						for(IConnection connection : cumulatedInputConnections) {
			            	IMetadataTable joinedTable = connection.getMetadataTable();
			                List<IMetadataColumn> listColumns = joinedTable.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
			                    String columnName = column.getLabel();
			                    
			                    
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    
							}
			            }
			            hExternalInputTableEntries.clear();

			            List<TreeNode> trees = currentInputTable.getNodes();
			            if (trees == null) {
			                continue;
			            }
					}
			        
    stringBuffer.append(TEXT_178);
    
				        comma = "";
			         	for(IConnection connection : cumulatedInputConnections) {
			         	
			         		IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
			         	
				        	
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_179);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( connection.getName() );
    
			         		comma = ", ";
			         	}
			            int sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
			         		
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel() );
    
			            
			            } 
			            
			         
    stringBuffer.append(TEXT_184);
    
			        	for(IConnection connection : cumulatedInputConnections) {
			        	
			        		IMetadataTable table = connection.getMetadataTable();
							List<IMetadataColumn> listColumns = table.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
								
    stringBuffer.append(TEXT_185);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_189);
    
			        		}
			        	}
			        	
    stringBuffer.append(TEXT_190);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
							
    stringBuffer.append(TEXT_191);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_195);
    
			            
			            } 
			            
    stringBuffer.append(TEXT_196);
    
			         
				         comma = "";
				         for(IConnection connection : cumulatedInputConnections) {
				
				            IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
				
					         
    stringBuffer.append(comma);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( connection.getName() );
    
				         	comma = ", ";
				         }
				         
    stringBuffer.append(TEXT_198);
    
				        	for(IConnection connection : cumulatedInputConnections) {
				        	
				        		IMetadataTable table = connection.getMetadataTable();
								List<IMetadataColumn> listColumns = table.getListColumns();
				            	for (IMetadataColumn column : listColumns) {
								
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_202);
    
				        		}
				        	}
				        	
    stringBuffer.append(TEXT_203);
    	
						comma = "";
							for(IConnection connection : cumulatedInputConnections) {
						        	
								IMetadataTable metadata = connection.getMetadataTable();
							if (metadata !=null) {
								for (IMetadataColumn column: metadata.getListColumns()) {
										if(comma.length() > 0) {
										
    stringBuffer.append(TEXT_204);
    stringBuffer.append( comma );
    stringBuffer.append(TEXT_205);
    
										}
										
    stringBuffer.append(TEXT_206);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_210);
    
									comma = ", ";
								}
							}
						}
						
    stringBuffer.append(TEXT_211);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_212);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			            
    stringBuffer.append(TEXT_213);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    
			            } 
			            
    stringBuffer.append(TEXT_218);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_219);
    	
						boolean hasAtLeastOneRead = false;
						boolean hasAtLeastOneObjectType = false;
						if (currentMetadataTable !=null) {
						        for(IConnection connection : cumulatedInputConnections) {
				        		IMetadataTable table = connection.getMetadataTable();
								List<IMetadataColumn> listColumns = table.getListColumns();
				            	for (IMetadataColumn column : listColumns) {
							  	hasAtLeastOneRead = true;
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							 	
						if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
							typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					    
    stringBuffer.append(TEXT_220);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_223);
    
						} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_224);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_234);
    
						} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_235);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_239);
    
						} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_240);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_241);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_244);
    
						} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
							hasAtLeastOneObjectType = true;
						
    stringBuffer.append(TEXT_245);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_248);
    
						} else {
							typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
							typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_249);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_254);
    
							}
			        	  }
			        	}
			        	
    stringBuffer.append(TEXT_255);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
						  	hasAtLeastOneRead = true;
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			
						 	if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
						 		typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_256);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_259);
    
						 	} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_260);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_261);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_264);
    
						 	} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_265);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_268);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_271);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_272);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_273);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_275);
    
						 	} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_276);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_280);
    
						 	} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
				 		hasAtLeastOneObjectType = true;
						
    stringBuffer.append(TEXT_281);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_282);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_284);
    
						 	} else {
						typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
						typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_285);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_286);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_288);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_289);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_290);
    
						 	}
			            } 
					}
					if(hasAtLeastOneRead) {
						
    stringBuffer.append(TEXT_291);
    
				}
				
    stringBuffer.append(TEXT_292);
    
					if(hasAtLeastOneObjectType) {
				
    stringBuffer.append(TEXT_293);
    
				}
				
    stringBuffer.append(TEXT_294);
    	
					boolean hasAtLeastOneWrite = false;
					if (currentMetadataTable !=null) {
			        	for(IConnection connection : cumulatedInputConnections) {
			        	
			        		IMetadataTable table = connection.getMetadataTable();
							List<IMetadataColumn> listColumns = table.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							hasAtLeastOneWrite = true;
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
								typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
							
    stringBuffer.append(TEXT_295);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_296);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_298);
    
							} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_299);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_300);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_302);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_303);
    
							} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_304);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_306);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_307);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_308);
    
							} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_309);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_310);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_311);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_312);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_315);
    
							} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_316);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_318);
    
							} else {
								typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
								typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_319);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_320);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_321);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_322);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_324);
    
								}
			        		}
			        	}
			        	
    stringBuffer.append(TEXT_325);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							hasAtLeastOneWrite = true;
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
								typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_326);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_327);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_328);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_329);
    
						} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_330);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_331);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_332);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_334);
    
						} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_335);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_336);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_337);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_339);
    
						} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_340);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_343);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_344);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_346);
    
						} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_347);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_349);
    
						} else {
								typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
								typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_350);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_351);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_352);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_353);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_355);
    
							}
			            } 
					}
					if(hasAtLeastOneWrite) {
					
    stringBuffer.append(TEXT_356);
    
					}
					
    stringBuffer.append(TEXT_357);
    }
	}
	
    stringBuffer.append(TEXT_358);
    return stringBuffer.toString();
  }
}
