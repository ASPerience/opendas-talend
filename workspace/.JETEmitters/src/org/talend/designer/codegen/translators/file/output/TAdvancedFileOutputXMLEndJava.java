package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLEndJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLEndJava result = new TAdvancedFileOutputXMLEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = "_";
  protected final String TEXT_4 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_5 = "_c_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".addElement(\"xsd:complexType\");";
  protected final String TEXT_8 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_9 = "_s_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".addElement(\"xsd:sequence\");";
  protected final String TEXT_12 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_13 = "_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ".addElement(\"xsd:element\");";
  protected final String TEXT_16 = NL + "\t\tnameToElement_";
  protected final String TEXT_17 = ".get(\"";
  protected final String TEXT_18 = "\")";
  protected final String TEXT_19 = NL + "\t\t((org.dom4j.Element)(nameToElement_";
  protected final String TEXT_20 = ".get(\"";
  protected final String TEXT_21 = "\")))";
  protected final String TEXT_22 = NL + "\t\tnameToElement_";
  protected final String TEXT_23 = ".put(\"";
  protected final String TEXT_24 = "_c\",";
  protected final String TEXT_25 = ".addElement(\"xsd:complexType\"));";
  protected final String TEXT_26 = NL + "\t\tnameToElement_";
  protected final String TEXT_27 = ".put(\"";
  protected final String TEXT_28 = "_s\",";
  protected final String TEXT_29 = ".addElement(\"xsd:sequence\"));";
  protected final String TEXT_30 = NL + "\t\tnameToElement_";
  protected final String TEXT_31 = ".put(\"";
  protected final String TEXT_32 = "\",";
  protected final String TEXT_33 = ".addElement(\"xsd:element\"));";
  protected final String TEXT_34 = NL + "\t\tnameToElement_";
  protected final String TEXT_35 = ".put(\"root_xsd\",root_xsd_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "\t\t\tclass TalendXMLGenerateTool_";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = " {";
  protected final String TEXT_41 = NL + "\t\t\t}";
  protected final String TEXT_42 = NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_43 = "() throws java.lang.Exception{";
  protected final String TEXT_44 = NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_45 = "() throws java.lang.Exception{";
  protected final String TEXT_46 = NL + "\t\t\tTalendXMLGenerateTool_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = " talendXMLGenerateTool_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = " = new TalendXMLGenerateTool_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL + "\t\t\t\t\ttalendXMLGenerateTool_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = ".generateDocument_";
  protected final String TEXT_56 = "();";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = ".addAttribute(\"name\",\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t";
  protected final String TEXT_61 = ".addAttribute(\"nillable\",\"true\");";
  protected final String TEXT_62 = NL + "\t\t";
  protected final String TEXT_63 = ".addAttribute(\"minOccurs\",\"0\");" + NL + "\t\t";
  protected final String TEXT_64 = ".addAttribute(\"maxOccurs\",\"unbounded\");";
  protected final String TEXT_65 = NL + "\t\t";
  protected final String TEXT_66 = ".addElement(\"xsd:attribute\").addAttribute(\"name\",\"";
  protected final String TEXT_67 = "\");";
  protected final String TEXT_68 = NL + "\t\tout_xsd_";
  protected final String TEXT_69 = ".write(\"";
  protected final String TEXT_70 = "  <xsd:complexType>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_71 = ".newLine();" + NL + "\t\tout_xsd_";
  protected final String TEXT_72 = ".write(\"";
  protected final String TEXT_73 = "    <xsd:sequence>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_74 = ".newLine();";
  protected final String TEXT_75 = NL + "\t\tout_xsd_";
  protected final String TEXT_76 = ".write(\"";
  protected final String TEXT_77 = "    </xsd:sequence>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_78 = ".newLine();";
  protected final String TEXT_79 = NL + "\t\tout_xsd_";
  protected final String TEXT_80 = ".write(\"";
  protected final String TEXT_81 = "  </xsd:complexType>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_82 = ".newLine();";
  protected final String TEXT_83 = NL + "\t\tout_xsd_";
  protected final String TEXT_84 = ".write(\"";
  protected final String TEXT_85 = "</xsd:element>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_86 = ".newLine();";
  protected final String TEXT_87 = NL + "\t\tout_xsd_";
  protected final String TEXT_88 = ".write(\"";
  protected final String TEXT_89 = "<xsd:element name=\\\"";
  protected final String TEXT_90 = "\\\" nillable=\\\"true\\\" \"+";
  protected final String TEXT_91 = NL + "\t\t\"minOccurs=\\\"0\\\" maxOccurs=\\\"unbounded\\\"\"+";
  protected final String TEXT_92 = NL + "\t\t\">\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_93 = ".newLine();";
  protected final String TEXT_94 = NL + "\t\tout_xsd_";
  protected final String TEXT_95 = ".write(\"";
  protected final String TEXT_96 = "<xsd:attribute name= \\\"";
  protected final String TEXT_97 = "\\\"/>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_98 = ".newLine();";
  protected final String TEXT_99 = NL + "\t\tnameToElement_";
  protected final String TEXT_100 = ".clear();";
  protected final String TEXT_101 = NL + "if(currentRowCount_";
  protected final String TEXT_102 = " > 0){";
  protected final String TEXT_103 = NL + "\tjava.io.OutputStream stream_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_107 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_108 = " + currentFileCount_";
  protected final String TEXT_109 = " + suffix_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_112 = " = new java.io.FileOutputStream(fileName_";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = "    " + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_115 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_116 = ", format_";
  protected final String TEXT_117 = ");" + NL + "\tif(doc_";
  protected final String TEXT_118 = ".getRootElement()!=null){";
  protected final String TEXT_119 = NL + "\t\tdoc_";
  protected final String TEXT_120 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", file_";
  protected final String TEXT_121 = ".substring(file_";
  protected final String TEXT_122 = ".lastIndexOf(\"/\")+1)+\".xsd\");" + NL + "    \tdoc_";
  protected final String TEXT_123 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_124 = "  " + NL + "    \tnestXMLTool_";
  protected final String TEXT_125 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_126 = ".getRootElement());";
  protected final String TEXT_127 = NL + "    \tnestXMLTool_";
  protected final String TEXT_128 = ".removeEmptyElement(doc_";
  protected final String TEXT_129 = ".getRootElement());";
  protected final String TEXT_130 = NL + "    \toutput_";
  protected final String TEXT_131 = ".write(doc_";
  protected final String TEXT_132 = ");" + NL + "    }";
  protected final String TEXT_133 = NL + "    output_";
  protected final String TEXT_134 = ".close();";
  protected final String TEXT_135 = NL + "\toutput_";
  protected final String TEXT_136 = ".flush();" + NL + "\toutput_";
  protected final String TEXT_137 = " = null;";
  protected final String TEXT_138 = NL + "\tif (preUnNullMaxIndex_";
  protected final String TEXT_139 = " >= 0) {" + NL + "        // output all buffer" + NL + "        for (int j_";
  protected final String TEXT_140 = " = 0; j_";
  protected final String TEXT_141 = " <= preUnNullMaxIndex_";
  protected final String TEXT_142 = "; j_";
  protected final String TEXT_143 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_144 = "[j_";
  protected final String TEXT_145 = "] != null)" + NL + "                out_";
  protected final String TEXT_146 = ".write(startTabs_";
  protected final String TEXT_147 = "[j_";
  protected final String TEXT_148 = "]);" + NL + "        }" + NL + "" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_149 = " < preNewTabIndex_";
  protected final String TEXT_150 = " ) {" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_151 = " = preNewTabIndex_";
  protected final String TEXT_152 = " - 1; i_";
  protected final String TEXT_153 = " >= 0; i_";
  protected final String TEXT_154 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_155 = "[i_";
  protected final String TEXT_156 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_157 = ".write(endTabs_";
  protected final String TEXT_158 = "[i_";
  protected final String TEXT_159 = "]);" + NL + "            \t}" + NL + "            \t";
  protected final String TEXT_160 = "out_";
  protected final String TEXT_161 = ".newLine(); ";
  protected final String TEXT_162 = NL + "                out_";
  protected final String TEXT_163 = ".write(endTabStrs_";
  protected final String TEXT_164 = ".get(i_";
  protected final String TEXT_165 = "));" + NL + "            }" + NL + "        } else {" + NL + "            for (int i_";
  protected final String TEXT_166 = " = preUnNullMaxIndex_";
  protected final String TEXT_167 = "; i_";
  protected final String TEXT_168 = " >= 0; i_";
  protected final String TEXT_169 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_170 = "[i_";
  protected final String TEXT_171 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_172 = ".write(endTabs_";
  protected final String TEXT_173 = "[i_";
  protected final String TEXT_174 = "]);" + NL + "            \t}" + NL + "            \t";
  protected final String TEXT_175 = "out_";
  protected final String TEXT_176 = ".newLine(); ";
  protected final String TEXT_177 = NL + "                out_";
  protected final String TEXT_178 = ".write(endTabStrs_";
  protected final String TEXT_179 = ".get(i_";
  protected final String TEXT_180 = "));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_181 = NL + "\tif(nb_line_";
  protected final String TEXT_182 = " > 0){" + NL + "\t\tfor (int i_";
  protected final String TEXT_183 = " = endTabStrs_";
  protected final String TEXT_184 = ".size() - 1; i_";
  protected final String TEXT_185 = " >= 0; i_";
  protected final String TEXT_186 = "--) {" + NL + "        \tif(endTabs_";
  protected final String TEXT_187 = "[i_";
  protected final String TEXT_188 = "]!=null){" + NL + "        \t\tout_";
  protected final String TEXT_189 = ".write(endTabs_";
  protected final String TEXT_190 = "[i_";
  protected final String TEXT_191 = "]);" + NL + "        \t}" + NL + "        \t";
  protected final String TEXT_192 = "out_";
  protected final String TEXT_193 = ".newLine(); ";
  protected final String TEXT_194 = NL + "\t        out_";
  protected final String TEXT_195 = ".write(endTabStrs_";
  protected final String TEXT_196 = ".get(i_";
  protected final String TEXT_197 = "));" + NL + "\t    }" + NL + "    }";
  protected final String TEXT_198 = NL + "\tout_";
  protected final String TEXT_199 = ".close();";
  protected final String TEXT_200 = NL + "\tout_";
  protected final String TEXT_201 = ".flush();" + NL + "\toutWriter_";
  protected final String TEXT_202 = ".flush();" + NL + "\tout_";
  protected final String TEXT_203 = " = null;";
  protected final String TEXT_204 = NL + "}";
  protected final String TEXT_205 = NL + "globalMap.put(\"";
  protected final String TEXT_206 = "_NB_LINE\",nb_line_";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "\torg.dom4j.Document doc_xsd_";
  protected final String TEXT_209 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "\t" + NL + "\torg.dom4j.Element root_xsd_";
  protected final String TEXT_210 = " = doc_xsd_";
  protected final String TEXT_211 = ".addElement(\"xsd:schema\");" + NL + "    root_xsd_";
  protected final String TEXT_212 = ".addNamespace(\"xsd\", \"http://www.w3.org/2001/XMLSchema\");";
  protected final String TEXT_213 = NL + "\tjava.io.FileOutputStream stream_xsd_";
  protected final String TEXT_214 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_215 = "+\".xsd\");" + NL + "    org.dom4j.io.XMLWriter output_xsd_";
  protected final String TEXT_216 = " = new org.dom4j.io.XMLWriter(stream_xsd_";
  protected final String TEXT_217 = ", format_";
  protected final String TEXT_218 = ");" + NL + "    output_xsd_";
  protected final String TEXT_219 = ".write(doc_xsd_";
  protected final String TEXT_220 = " );" + NL + "    output_xsd_";
  protected final String TEXT_221 = ".close();" + NL + "    nameToElement_";
  protected final String TEXT_222 = ".clear();";
  protected final String TEXT_223 = NL + "\tjava.io.BufferedWriter out_xsd_";
  protected final String TEXT_224 = " = new java.io.BufferedWriter(" + NL + "\t\tnew java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_225 = "+\".xsd\"), ";
  protected final String TEXT_226 = "));" + NL + "\tout_xsd_";
  protected final String TEXT_227 = ".write(\"<xsd:schema xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\">\");" + NL + "\tout_xsd_";
  protected final String TEXT_228 = ".newLine();";
  protected final String TEXT_229 = NL + "\tout_xsd_";
  protected final String TEXT_230 = ".write(\"</xsd:schema>\");" + NL + "\tout_xsd_";
  protected final String TEXT_231 = ".close();";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = NL + " \tif((nb_line_";
  protected final String TEXT_234 = " == 0) && !alreadyExistsFile_";
  protected final String TEXT_235 = "){" + NL + "   \t\tcreateFile";
  protected final String TEXT_236 = ".delete();" + NL + " \t}";
  protected final String TEXT_237 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
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

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
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
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public List<XMLNode> getNextSiblings(){
            List<XMLNode> result = new ArrayList<XMLNode>();
            if(parent!=null && parent.elements!=null){
                for(XMLNode tmpNode: parent.elements){
                    if(order < tmpNode.order){
                        result.add(tmpNode);
                    }
                }
            }
            return result;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
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
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
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
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
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
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();

abstract class TouchXMLNode {
	protected String cid = null;
	
	abstract void getXMLNode(String currEleName);
	
	abstract void getXMLElement(String currEleName);
	
	abstract void putCurrentComplexTypeElement(String currEleName);
	
	abstract void putCurrentSequenceElement(String currEleName);
	
	abstract void putCurrentElement(String currEleName,String parent);
	
	abstract void putRootElement();
}

//get mean reference
//put mean declare,assign action
class ReferenceTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    
	}
	
	void getXMLElement(String currEleName) {
		getXMLNode(currEleName);
	}
	
	void putCurrentComplexTypeElement(String currEleName) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_7);
    
	}
	
	void putCurrentSequenceElement(String currEleName) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    getXMLNode(currEleName + "_c");
    stringBuffer.append(TEXT_11);
    
	}
	
	void putCurrentElement(String currEleName,String parent) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    getXMLNode(parent);
    stringBuffer.append(TEXT_15);
    
	}
	
	void putRootElement() {
		//do nothing
	}
}

class MappingTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_18);
    
	}
	
	void getXMLElement(String currEleName) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_21);
    
	}
	
	void putCurrentComplexTypeElement(String currEleName) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_24);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_25);
    
	}
	
	void putCurrentSequenceElement(String currEleName) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_28);
    getXMLNode(currEleName + "_c");
    stringBuffer.append(TEXT_29);
    
	}
	
	void putCurrentElement(String currEleName,String parent) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_32);
    getXMLNode(parent);
    stringBuffer.append(TEXT_33);
    
	}
	
	void putRootElement() {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}
}

    stringBuffer.append(TEXT_37);
    
//65535 limit
class BigMethodHelper {
	protected String cid = null;
	protected boolean isOptimizeCodeForXMLNode = false;
	protected int xmlNodeOptNum = 100;
	protected int index = -1;
	
	protected String generateId = "";
	
	public BigMethodHelper() {
		initIsOptimizeCodeForXMLNode();
	}
	
	public void setGenerateId(String generateId) {
		this.generateId = generateId; 
	}
	
	public void resetIndex() {
		index = -1;
	}
	
	public TouchXMLNode getTouchXMLNode() {
		if(isOptimizeCodeForXMLNode) {
			return new MappingTouchXMLNode();
		}
		return new ReferenceTouchXMLNode();
	}
	
	public void initIsOptimizeCodeForXMLNode(){
		String xmlNodeOptNumStr = ElementParameterParser.getValue(node, "__XMLNODE_OPT_NUM__");
		if(xmlNodeOptNumStr!=null && !"".equals(xmlNodeOptNumStr) && !"\"\"".equals(xmlNodeOptNumStr)){
			xmlNodeOptNum  = Integer.parseInt(xmlNodeOptNumStr);
		}
		
        List<Map<String, String>> rootTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
        
        int elementNumber = getElementNumber(rootTable) + getElementNumber(groupTable) + getElementNumber(loopTable);
        if(elementNumber > xmlNodeOptNum) {
			isOptimizeCodeForXMLNode = true;
        }
	}
	
	private int getElementNumber(List<Map<String, String>> nodeTable) {
		if(nodeTable == null) {
			return 0;
		}
		
		int result = 0;
		for(Map<String,String> node : nodeTable) {
			if(node == null) {
				continue;
			}
			
			if("attri".equals(node.get("ATTRIBUTE")) || "ns".equals(node.get("ATTRIBUTE"))) {
				continue;
			}
			
			result++;
		}
		
		return result;
	}
	
	public void generateClassNameWithRBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
		}
	}
	
	public void generateLeftBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_41);
    
		}
	}
	
	public void generateMethod() {
		if(isOptimizeCodeForXMLNode) {
			if(index == -1) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_43);
    
			} else if((index+1)%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_44);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_45);
    
			}
			index++;
		}
	}
	
	public void generateMethodCall() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
			int count = index + 1;
			for(int i = 0; i < count; i++) {
				if(i%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i/xmlNodeOptNum);
    stringBuffer.append(TEXT_56);
    
				}
			}
		}
	}
	
}

    stringBuffer.append(TEXT_57);
    
// ------------------- *** Dom4j generation mode start *** ------------------- //
class XSDToolByDom4j{
    String cid = null;
    
	//opt for big xml config tree
	BigMethodHelper bigMethodHelper = null;
	TouchXMLNode touchXMLNode = null;
	
	public XSDToolByDom4j() {
		bigMethodHelper = new BigMethodHelper();
		touchXMLNode = bigMethodHelper.getTouchXMLNode();
	}
	
	public void generateXSD(String parent, String currEleName, XMLNode root){
		if(!("ELEMENT").equals(root.type)){
			return;
		}
		
		bigMethodHelper.setGenerateId(currEleName);
		//start the class
		bigMethodHelper.generateClassNameWithRBlock();
		
		bigMethodHelper.resetIndex();
		
		generateMainCode(parent,currEleName,root);
		
		//end the last method
		bigMethodHelper.generateLeftBlock();
		
		//end the class
		bigMethodHelper.generateLeftBlock();
		
		bigMethodHelper.generateMethodCall();
	}
	
    public void generateMainCode(String parent, String currEleName, XMLNode root){
    	if(("ELEMENT").equals(root.type)){
    		bigMethodHelper.generateMethod();
    		
    		createElement(parent,currEleName,root);
			
			if(root.elements!=null && root.elements.size()>0
			  || root.attributes!=null && root.attributes.size()>0){
			  
				touchXMLNode.putCurrentComplexTypeElement(currEleName);
				touchXMLNode.putCurrentSequenceElement(currEleName);
				
        		int index = 0;
        		for(XMLNode child:root.elements){
        			generateMainCode(currEleName+"_s", currEleName+"_"+index++, child);
        		}
        		
        		for(XMLNode attri:root.attributes){
        			createAttribute(currEleName+"_c",attri);
        		}
			}
    	}
    }
    
    private void createElement(String parent, String currEleName, XMLNode node){
    	touchXMLNode.putCurrentElement(currEleName,parent);

    stringBuffer.append(TEXT_58);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_60);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_61);
    
		if(node.parent != null){

    stringBuffer.append(TEXT_62);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_63);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_64);
    
		}
    }
    
    private void createAttribute(String parent, XMLNode node){

    stringBuffer.append(TEXT_65);
    touchXMLNode.getXMLNode(parent);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_67);
    
    }
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class XSDToolByNull{
	String cid = null;
    public void generateXSD(String emptyspace, XMLNode root){
    	if(("ELEMENT").equals(root.type)){
    		createElement(emptyspace, root);
			
			if(root.elements!=null && root.elements.size()>0
			  || root.attributes!=null && root.attributes.size()>0){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
				XMLNode mainNode = null;
        		for(XMLNode child:root.elements){
        			if( 1==(child.special & 4)){
        				mainNode = child;
        			}else{
        				generateXSD(emptyspace+"      ", child);
        			}
        		}
        		if(mainNode!= null){
        			generateXSD(emptyspace+"      ", mainNode);
        		}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
        		for(XMLNode attri:root.attributes){
        			createAttribute(emptyspace+"    ",attri);
        		}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
    	}
    }
    
    private void createElement(String emptyspace, XMLNode node){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_90);
    
		if(node.parent != null){

    stringBuffer.append(TEXT_91);
    
		}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
    }
    
    private void createAttribute(String emptyspace, XMLNode node){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
    }
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
List<Map<String, String>> rootTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
List<Map<String, String>> groupTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
List<Map<String, String>> loopTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));

//*****************add for the feature:8873 to support output steam *****************
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
//*******************add for feature:8873 end ****************

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	if("Dom4j".equals(mode)){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
	}
	
	String split = ElementParameterParser.getValue(node, "__SPLIT__");
	if(!useStream && ("true").equals(split)){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
	}
	if(("Dom4j").equals(mode)){
		if(useStream){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_105);
    
		}else{
			if(("true").equals(split)){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
			}else{

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
			}
		}

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
		if(!useStream && ("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
		}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		}

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
		if(!useStream){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
		}else{

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
		}

    
	}else if(("Null").equals(mode)){
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(isCompact==false){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    if(isCompact==false){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    if(isCompact==false){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
			}
		}
		
		if(!useStream){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
		}else{

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    
		}
	}
	if(!useStream && ("true").equals(split)){

    stringBuffer.append(TEXT_204);
    
	}

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid_original );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    

// ------------------- *** xsd output code start *** ------------------- //
	if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file

        // change tables to a tree 
		Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadatas.get(0).getListColumns());
    	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
        XMLNode root = mainList.get(0);

        if(!("true").equals(allowEmpty)){
        	removeEmptyElement(root);
        }

		if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
	XSDToolByDom4j xsdTool = new XSDToolByDom4j();
	xsdTool.cid = cid;
	xsdTool.touchXMLNode.cid = cid;
	xsdTool.bigMethodHelper.cid = cid;
	xsdTool.touchXMLNode.putRootElement();
	xsdTool.generateXSD("root_xsd","ele_xsd",root);

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
		}else if(("Null").equals(mode)){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
	XSDToolByNull xsdTool = new XSDToolByNull();
	xsdTool.cid=cid;
	xsdTool.generateXSD("  ",root);

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    
		}
    }
}

    stringBuffer.append(TEXT_232);
    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    return stringBuffer.toString();
  }
}
