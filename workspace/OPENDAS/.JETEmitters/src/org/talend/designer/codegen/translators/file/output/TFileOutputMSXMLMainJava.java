package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

/**
 * add by xzhang
 */
public class TFileOutputMSXMLMainJava {

  protected static String nl;
  public static synchronized TFileOutputMSXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputMSXMLMainJava result = new TFileOutputMSXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tvalueMap_";
  protected final String TEXT_3 = ".get(\"";
  protected final String TEXT_4 = "\")";
  protected final String TEXT_5 = NL + "\t(";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null?";
  protected final String TEXT_9 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_10 = "), ";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ")\t\t\t\t\t";
  protected final String TEXT_13 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "), ";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ")\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "            String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = NL + "            ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".toString()";
  protected final String TEXT_32 = ":";
  protected final String TEXT_33 = "null";
  protected final String TEXT_34 = NL + "\t\t)";
  protected final String TEXT_35 = NL + "\t\t\t";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ".setName(\"";
  protected final String TEXT_38 = "\");";
  protected final String TEXT_39 = NL + "\t\t\tif (";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_46 = NL + "                ";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = ".remove(";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ");" + NL + "            }\t\t\t";
  protected final String TEXT_51 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ";" + NL + "\t\tif (";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_56 = "\") == null) {";
  protected final String TEXT_57 = NL + "            ";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ".addElement(\"";
  protected final String TEXT_62 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = ".addElement(\"";
  protected final String TEXT_67 = "\");" + NL + "        }";
  protected final String TEXT_68 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = ".addElement(\"";
  protected final String TEXT_73 = "\");";
  protected final String TEXT_74 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + "\t\tif(";
  protected final String TEXT_79 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_80 = " .parseAndAdd(";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ",";
  protected final String TEXT_83 = ");" + NL + "\t\t}";
  protected final String TEXT_84 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_85 = " .parseAndAdd(";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_90 = NL + "\t\tif(";
  protected final String TEXT_91 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_92 = " .setText(";
  protected final String TEXT_93 = "_";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ");" + NL + "\t\t}";
  protected final String TEXT_96 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_101 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_102 = ".parseAndAdd(";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ",\"";
  protected final String TEXT_105 = "\");" + NL;
  protected final String TEXT_106 = NL + "\t\tif(";
  protected final String TEXT_107 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = ".addAttribute(\"";
  protected final String TEXT_110 = "\",";
  protected final String TEXT_111 = ");" + NL + "\t\t}";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = ".addAttribute(\"";
  protected final String TEXT_115 = "\", \"";
  protected final String TEXT_116 = "\");";
  protected final String TEXT_117 = NL + "\t\tif(";
  protected final String TEXT_118 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ".addNamespace(\"";
  protected final String TEXT_121 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_122 = "));";
  protected final String TEXT_123 = NL + "        \t";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_126 = "_";
  protected final String TEXT_127 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_128 = "))));";
  protected final String TEXT_129 = NL + "\t\t}";
  protected final String TEXT_130 = NL + "\t\t\t";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = ".addNamespace(\"";
  protected final String TEXT_133 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_134 = "\"));";
  protected final String TEXT_135 = NL + "        \t";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_140 = "\"))));";
  protected final String TEXT_141 = "true";
  protected final String TEXT_142 = " && (";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = "==null && ";
  protected final String TEXT_145 = " == null) || (true &&";
  protected final String TEXT_146 = "!=null" + NL + " && ";
  protected final String TEXT_147 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_148 = ".getText().equals(";
  protected final String TEXT_149 = ")";
  protected final String TEXT_150 = ")";
  protected final String TEXT_151 = NL + ")";
  protected final String TEXT_152 = " && (";
  protected final String TEXT_153 = "!=null" + NL + " && ";
  protected final String TEXT_154 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_155 = ".getText().equals(\"";
  protected final String TEXT_156 = "\")" + NL + " )";
  protected final String TEXT_157 = " && (";
  protected final String TEXT_158 = "(";
  protected final String TEXT_159 = "==null && ";
  protected final String TEXT_160 = ".attribute(\"";
  protected final String TEXT_161 = "\") == null) || (true && ";
  protected final String TEXT_162 = ".attribute(\"";
  protected final String TEXT_163 = "\")!=null" + NL + "&& ";
  protected final String TEXT_164 = ".attribute(\"";
  protected final String TEXT_165 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_166 = ".attribute(\"";
  protected final String TEXT_167 = "\").getText().equals(";
  protected final String TEXT_168 = ")";
  protected final String TEXT_169 = ")";
  protected final String TEXT_170 = ")";
  protected final String TEXT_171 = " && (";
  protected final String TEXT_172 = ".attribute(\"";
  protected final String TEXT_173 = "\")!=null" + NL + "&& ";
  protected final String TEXT_174 = ".attribute(\"";
  protected final String TEXT_175 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_176 = ".attribute(\"";
  protected final String TEXT_177 = "\").getText().equals(\"";
  protected final String TEXT_178 = "\")" + NL + " )";
  protected final String TEXT_179 = NL;
  protected final String TEXT_180 = ".element(\"";
  protected final String TEXT_181 = "\")";
  protected final String TEXT_182 = NL + "\tnb_line_";
  protected final String TEXT_183 = "++;" + NL + "\tvalueMap_";
  protected final String TEXT_184 = ".clear();";
  protected final String TEXT_185 = NL + "\tvalueMap_";
  protected final String TEXT_186 = ".put(\"";
  protected final String TEXT_187 = "\", ";
  protected final String TEXT_188 = ");" + NL + "\tif(isXML10Char_";
  protected final String TEXT_189 = ") {" + NL + "\t\tisXML10Char_";
  protected final String TEXT_190 = " = org.talend.util.xml.XMLText.isValid(";
  protected final String TEXT_191 = ");" + NL + "\t}";
  protected final String TEXT_192 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_193 = " = null;" + NL + "\t";
  protected final String TEXT_194 = NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_195 = "_";
  protected final String TEXT_196 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_197 = "_";
  protected final String TEXT_198 = " = false;";
  protected final String TEXT_199 = NL + "\t\troot_";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = " = subTreeRootParent_";
  protected final String TEXT_202 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_203 = "= root_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ";" + NL + "" + NL + "\t}";
  protected final String TEXT_206 = NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_207 = "_";
  protected final String TEXT_208 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = " = false;" + NL + "\t\troot_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = " = " + NL + "\t\t\t(org.dom4j.Element)doc_";
  protected final String TEXT_213 = ".selectSingleNode(\"";
  protected final String TEXT_214 = "\");" + NL + "\t\tif(root_";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = "==null) {" + NL + "\t\t\tSystem.err.println(\"warn:::the pre input source content is empty!\");" + NL + "\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\troot_";
  protected final String TEXT_218 = "_";
  protected final String TEXT_219 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_220 = ".selectSingleNode(\"";
  protected final String TEXT_221 = "\");" + NL + "\t\t}" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_222 = "= root_";
  protected final String TEXT_223 = "_";
  protected final String TEXT_224 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_225 = "= root_";
  protected final String TEXT_226 = "_";
  protected final String TEXT_227 = ";" + NL + "\t}";
  protected final String TEXT_228 = NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_229 = "_";
  protected final String TEXT_230 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_231 = "_";
  protected final String TEXT_232 = " = false;" + NL + "\t\troot_";
  protected final String TEXT_233 = "_";
  protected final String TEXT_234 = " = " + NL + "\t\t\t(org.dom4j.Element)doc_";
  protected final String TEXT_235 = ".selectSingleNode(\"";
  protected final String TEXT_236 = "\");" + NL + "\t";
  protected final String TEXT_237 = NL + "\t\troot_";
  protected final String TEXT_238 = "_";
  protected final String TEXT_239 = " = subTreeRootParent_";
  protected final String TEXT_240 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_241 = "= root_";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = ";" + NL + "\t}";
  protected final String TEXT_244 = NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_245 = "\t\t" + NL + "\t\tboolean bl_";
  protected final String TEXT_246 = "= false;//true:find the insert node;false:not";
  protected final String TEXT_247 = NL + "\t\tif(bl_";
  protected final String TEXT_248 = "==false){" + NL + "\t\t\tjava.util.List<org.dom4j.Element> listNodes= subTreeRootParent_";
  protected final String TEXT_249 = ".elements();" + NL + "\t\t\tif(listNodes!=null && listNodes.size()>0){" + NL + "\t\t\t\tint j=0;" + NL + "\t\t\t\tfor(j=0;j<listNodes.size();j++){" + NL + "\t\t\t\t\torg.dom4j.Element tempElem =listNodes.get(j);" + NL + "//\t\t\t\t\tString tmpPath=tempElem.getName();" + NL + "//\t\t\t\t\tif(tempElem.getNamespacePrefix() !=null && !tempElem.getNamespacePrefix().equals(\"\")){" + NL + "//\t\t\t\t\t\ttmpPath = tempElem.getNamespacePrefix() + \":\" + tmpPath;" + NL + "//\t\t\t\t\t}" + NL + "\t\t\t\t\tif((\"";
  protected final String TEXT_250 = "\").equals(tempElem.getPath())){" + NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_251 = "){" + NL + "\t\t\t\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_252 = " =  tempElem;" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(j>=listNodes.size()){" + NL + "\t\t\t\t\tbl_";
  protected final String TEXT_253 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tbl_";
  protected final String TEXT_254 = "=true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(bl_";
  protected final String TEXT_255 = "==true){";
  protected final String TEXT_256 = NL + "\t\t}";
  protected final String TEXT_257 = NL + "\t// build loop xml tree";
  protected final String TEXT_258 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;
        
        public String sourceName=null;

        public String column = null;
        
        public String defaultValue = null;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();
        
        public List<XMLNode> branches = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value) {
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            
            if (column.indexOf(":") >= 0) {
                this.column = column.substring(column.indexOf(":") + 1);
                this.sourceName = column.substring(0, column.indexOf(":"));
            }else{
            	this.sourceName = column;
            } 
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    }

    public XMLNode getInsertNode(XMLNode root, List<XMLNode> mainNode, List<String> listPreConns) {
        XMLNode returnNode = null;

        String[] existConns = root.sourceName.split("=");
        List<String> listExistConns = java.util.Arrays.asList(existConns);
        boolean isContains = false;
        if (listExistConns.contains(mainNode.get(0).sourceName)) {
            for (int i = 0; i < listPreConns.size(); i++) {
                if (listExistConns.contains(listPreConns.get(i))) {
                    isContains = true;
                    break;
                }
            }
        }

        if (isContains) {
            for (XMLNode node : root.elements) {
                returnNode = getInsertNode(node, mainNode, listPreConns);
                if (returnNode != null) {
                    break;
                }
            }
        }

        if (isContains && returnNode == null) {
            returnNode = root;
        }

        return returnNode;
    }

    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public XMLNode getRootTree(List<Map<String, String>> rootTable) {

        XMLNode root = null;
        XMLNode tmpParent = null;

        List<Map<String, String>> tmpTable = new ArrayList<Map<String, String>>();

        Map<String, String> currMainMap = null; // used to save the current Main Map in tmpTable
        Map<String, String> currMainRootMap = null; // used to save the current main map in rootTable
        String sourceName;
        for (int i = 0; i < rootTable.size(); i++) {
            if (rootTable.get(i).get("COLUMN").indexOf(":") >= 0) {
                sourceName = rootTable.get(i).get("COLUMN").substring(0, rootTable.get(i).get("COLUMN").indexOf(":"));
            } else {
                sourceName = rootTable.get(i).get("COLUMN");
            }
            if (rootTable.get(i).get("ATTRIBUTE").equals("main") == true
                    || rootTable.get(i).get("ATTRIBUTE").equals("branch") == true) {
                currMainRootMap = rootTable.get(i);
            }
            if (i == 0) {
                Map<String, String> tmpMap = new HashMap<String, String>();
                tmpMap.put("PATH", rootTable.get(i).get("PATH"));
                tmpMap.put("COLUMN", rootTable.get(i).get("COLUMN"));
                tmpMap.put("VALUE", rootTable.get(i).get("VALUE"));
                tmpMap.put("ATTRIBUTE", rootTable.get(i).get("ATTRIBUTE"));
                tmpMap.put("ORDER", rootTable.get(i).get("ORDER"));
                tmpMap.put("SOURCE", sourceName);
                tmpTable.add(tmpMap);
            } else {
                int j = 0;
                for (j = 0; j < tmpTable.size(); j++) {
                    if (tmpTable.get(j).get("ATTRIBUTE").equals("main") == true
                            || tmpTable.get(j).get("ATTRIBUTE").equals("branch") == true) {
                        currMainMap = tmpTable.get(j); // save the current main node
                    }
                    if (currMainMap.get("PATH").equals(currMainRootMap.get("PATH"))) {
                        if (tmpTable.get(j).get("PATH").equals(rootTable.get(i).get("PATH"))) {
                            // use the character = to separate the source connection
                            tmpTable.get(j).put("SOURCE", tmpTable.get(j).get("SOURCE") + "=" + sourceName);
                        } else {
                            // add the attributes or namespaces of the node
                            Map<String, String> tmpMap = new HashMap<String, String>();
                            tmpMap.put("PATH", rootTable.get(i).get("PATH"));
                            tmpMap.put("COLUMN", rootTable.get(i).get("COLUMN"));
                            tmpMap.put("VALUE", rootTable.get(i).get("VALUE"));
                            tmpMap.put("ATTRIBUTE", rootTable.get(i).get("ATTRIBUTE"));
                            tmpMap.put("ORDER", rootTable.get(i).get("ORDER"));
                            tmpMap.put("SOURCE", sourceName);
                            tmpTable.add(tmpMap);
                        }
                        break;
                    } else {
                        // nothing to do
                    }
                }

                if (j >= tmpTable.size()) {// doesn't find the node in the tmpTable, then it is a new node
                    Map<String, String> tmpMap = new HashMap<String, String>();
                    tmpMap.put("PATH", rootTable.get(i).get("PATH"));
                    tmpMap.put("COLUMN", rootTable.get(i).get("COLUMN"));
                    tmpMap.put("VALUE", rootTable.get(i).get("VALUE"));
                    tmpMap.put("ATTRIBUTE", rootTable.get(i).get("ATTRIBUTE"));
                    tmpMap.put("ORDER", rootTable.get(i).get("ORDER"));
                    tmpMap.put("SOURCE", sourceName);
                    tmpTable.add(tmpMap);
                }

            }
        }

        if (tmpTable != null && tmpTable.size() > 0) {
            for (Map<String, String> tmpMap : tmpTable) {
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                    tmpNew.sourceName = tmpMap.get("SOURCE");
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                    tmpNew.sourceName = tmpMap.get("SOURCE");
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                        tmpNew.sourceName = tmpMap.get("SOURCE");
                        tmpNew.special |= 1;
                        root = tmpNew;
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));

                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }

                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                        tmpNew.sourceName = tmpMap.get("SOURCE");

                        tmpParent.elements.add(tmpNew);
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
            }
            return root;
        }
        return null;
    }
    
  /**
     * 
     * distinguish the xml tags from different source node
     * 
     * @param rootTable
     * @param groupTable
     * @param loopTable
     * @param sourceNode
     * @return
     * @author wliu
     */
    public List<List<Map<String, String>>> getTables(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, String sourceNode) {

        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();

        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        List<Map<String, String>> resultRoot = new ArrayList<Map<String, String>>();
        List<Map<String, String>> resultGroup = new ArrayList<Map<String, String>>();
        List<Map<String, String>> resultLoop = new ArrayList<Map<String, String>>();

        List<List<Map<String, String>>> result = new ArrayList<List<Map<String, String>>>();
        result.add(resultRoot);
        result.add(resultGroup);
        result.add(resultLoop);

        for (int i = 0; i < tables.size(); i++) {

            if (rootTable != null && tables.get(i).size() > 0) {
                // find and save the root tag from the source node to the resultRoot List
                for (Map<String, String> map : tables.get(i)) {

                    boolean b_exit = map.get("COLUMN").equals(sourceNode) || (map.get("COLUMN").indexOf(":")>0 && map.get("COLUMN").substring(0, map.get("COLUMN").indexOf(":")).equals(sourceNode));
                    if (b_exit ) {
                        result.get(i).add(map);
                    }
                }
            }
        }

        return result;
        
    }
    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"));
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }
    
    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if ((attri.column != null && attri.column.length() != 0) || 
            	(attri.defaultValue != null && !"".equals(attri.defaultValue)) ) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null || (group.defaultValue != null && !"".equals(group.defaultValue)) ) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_4);
    
	}

	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_5);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_12);
    
    		} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_17);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_24);
    
            }else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_28);
    
        }else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_32);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_33);
    
			}
		}

    stringBuffer.append(TEXT_34);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_38);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
				}
			}
		}
	}	
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_67);
    
		}else{

    stringBuffer.append(TEXT_68);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_73);
    
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_78);
    tool.getValue(node); 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    tool.getValue(node);
    stringBuffer.append(TEXT_83);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
				}
			}else{

    stringBuffer.append(TEXT_90);
    tool.getValue(node);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    tool.getValue(node);
    stringBuffer.append(TEXT_95);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_105);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_106);
    tool.getValue(node);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_110);
    tool.getValue(node);
    stringBuffer.append(TEXT_111);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_116);
    
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_117);
    tool.getValue(node);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_121);
    tool.getValue(node);
    stringBuffer.append(TEXT_122);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_123);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    tool.getValue(node);
    stringBuffer.append(TEXT_128);
    
			}

    stringBuffer.append(TEXT_129);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_130);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_134);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_140);
    
			}
		}
	}
}

//----------** dom4j to genenrate comparison expression **-------//
class GenerateExprCmpByDom4j{
//	String cid = null;
	XMLTool tool = null;
	XMLNode groupNode = null;
	boolean needEmptyNode = true;
	public void generateCode(XMLNode node, String parentName){
		String tmpPath = node.path.replaceFirst(groupNode.path,"");
		String[] arrNames = tmpPath.split("/");
		if(node==groupNode){

    stringBuffer.append(TEXT_141);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_142);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_143);
    tool.getValue(node); 
    stringBuffer.append(TEXT_144);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_145);
    			}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_146);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_147);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_148);
    tool.getValue(node); 
    stringBuffer.append(TEXT_149);
    if(!needEmptyNode){
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    
		}else if(node.defaultValue!=null && !"".equals(node.defaultValue)){

    stringBuffer.append(TEXT_152);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_153);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_154);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_155);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_156);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_157);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_158);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_159);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_161);
    					}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_163);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_165);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_167);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_168);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_169);
    }

    stringBuffer.append(TEXT_170);
    
				}else if(attri.defaultValue!=null && !"".equals(attri.defaultValue)){

    stringBuffer.append(TEXT_171);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_173);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_175);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(attri.defaultValue );
    stringBuffer.append(TEXT_178);
    
				}
			}
		}	
		
		if(node.elements!=null){
			for(XMLNode child:node.elements){
				if(!child.isMainNode()){
					generateCode(child,parentName);
				}
			}
		}		
	}
	
	private void generateCmnExpr(String[] arrNames, String parentName){

    stringBuffer.append(TEXT_179);
    stringBuffer.append(parentName );
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){

    stringBuffer.append(TEXT_180);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_181);
    
		}
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tFileOutputXMLMultiSchema","tOXMLMS");

String incomingName = (String)codeGenArgument.getIncomingName();
List<IMetadataTable> metadatas = NodeUtil.getIncomingMetadataTable(node, IConnectionCategory.FLOW);

if ((metadatas!=null)&&(metadatas.size()>0)) {
    	List< ? extends IConnection> incomingConns = node.getIncomingConnections();
    	
  		//Notice here: only for the code viewer, because when click the tUnite component, it doesn't know which is the right input connection. 
    	if (incomingName == null && incomingConns.size() > 0) 
    	{ 
    	   incomingName = incomingConns.get(0).getName(); 
    	}    	 	
    	if(incomingConns!=null && incomingConns.size()>0){
    		//the first connection name
    		String firstConnName=incomingConns.get(0).getUniqueName();
    	
	    	IConnection incomingConn = null;
	    	INode preNode = null;
	    	List<IMetadataTable> preMetadatas = null;
	    	IMetadataTable preMetadata = null;
	    	String sourceName=null;
	    	for (IConnection conn : incomingConns) {
	    		if ( conn.getLineStyle().equals(EConnectionType.FLOW_MERGE) && conn.getName().equals(incomingName)) {
					
					incomingConn = conn;
					preNode = incomingConn.getSource();
					preMetadatas = preNode.getMetadataList();
					preMetadata = preMetadatas.get(0);
					sourceName = incomingConn.getUniqueName();
	    		    break;
	    		}
	    	}
	    	
    		if(preMetadata!=null){
    		
            	List<Map<String, String>> rootTable =
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable =
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable =
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = incomingConn.getName();
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
                List<List<Map<String, String>>> tables = getTables(rootTable, groupTable, loopTable, sourceName);
				Object[] treeObjs = getTree(tables.get(0), tables.get(1), tables.get(2), preMetadata.getListColumns());

				if(treeObjs == null || treeObjs.length == 0){
					return "";
				}

            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);                
            	XMLNode loop = (XMLNode)treeObjs[2];
            	
                if(!("true").equals(allowEmpty)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
					for(IMetadataColumn column :preMetadata.getListColumns()){

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_187);
    tool.getValue(column); 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    tool.getValue(column); 
    stringBuffer.append(TEXT_191);
    
					}
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
		//init the generate tool.
		GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
	
	    if(("true").equals(allowEmpty)){
	    	generateToolByDom4j.allowEmpty = true;
	    }
	    generateToolByDom4j.cid = cid;
	    generateToolByDom4j.tool = tool;
	    
	    //start generate code

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    		//the first input connection
		if(sourceName.equals(firstConnName)){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    	
		generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_199);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
		}else{
			List<String> listConnNames = new ArrayList<String>();
			// get the input connections before the current connection
			for(IConnection conn:incomingConns){
				// the last one is the current connection
				if(conn.getName().equals(sourceName)){
					break;
				}
				listConnNames.add(conn.getName());
			}
			
			XMLNode rootNode = getRootTree(rootTable);
			XMLNode branchNode = getInsertNode(rootNode, mainList, listConnNames);
			if(branchNode.path.equals(mainList.get(mainList.size()-1).path)==true){// the last main node

    stringBuffer.append(TEXT_206);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(branchNode.path );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    generateToolByDom4j.generateCode(root,"root","doc");
    stringBuffer.append(TEXT_217);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(branchNode.path );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    
			}else{
				//find the father main node in the branch
				XMLNode tempNode=null;
				for(XMLNode tmpNode: mainList){
					if(tmpNode.path.equals(branchNode.path)){
						tempNode = mainList.get(mainList.indexOf(tmpNode)+1);
						break;
					}
				}

    stringBuffer.append(TEXT_228);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(branchNode.path );
    stringBuffer.append(TEXT_236);
    generateToolByDom4j.generateCode(tempNode,"root", "root_"+sourceName); 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    
			}
		}

    stringBuffer.append(TEXT_244);
     
		if(tables.get(1).size()>0){					//init the generate tool.
		    String firstGroupPath = groupList.get(0).path;

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    
			for( int i=0; i<groupList.size();i++){
				XMLNode groupNode= groupList.get(i);
				GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
				generateExprCmpByDom4j.tool = tool;
				generateExprCmpByDom4j.groupNode = groupNode;
				generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(groupNode.path );
    stringBuffer.append(TEXT_250);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
     
				generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_256);
    
	 		}//for
		}

    stringBuffer.append(TEXT_257);
    
				if(tables.get(2)!=null && tables.get(2).size()>0){
					generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
				}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_258);
    return stringBuffer.toString();
  }
}
