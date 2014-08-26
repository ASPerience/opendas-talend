package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.AbstractExternalNode;
import org.talend.designer.xmlmap.XmlMapComponent;
import org.talend.designer.xmlmap.model.emf.xmlmap.XmlMapData;
import org.eclipse.emf.common.util.EList;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarTable;
import org.talend.designer.xmlmap.model.emf.xmlmap.InputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.TreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputTreeNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

/**
 * add by wliu
 */
public class TXMLMapMainJava {

  protected static String nl;
  public static synchronized TXMLMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLMapMainJava result = new TXMLMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t  boolean ";
  protected final String TEXT_3 = " = false;" + NL + "\t  boolean ";
  protected final String TEXT_4 = " = false;" + NL + "\t  boolean ";
  protected final String TEXT_5 = " = false;" + NL + "\t  ";
  protected final String TEXT_6 = NL + "\t\t    GenerateDocument_";
  protected final String TEXT_7 = " gen_Doc_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = " = new GenerateDocument_";
  protected final String TEXT_10 = "();" + NL + "\t\t\t";
  protected final String TEXT_11 = "_tmp.";
  protected final String TEXT_12 = " = null;";
  protected final String TEXT_13 = NL + "\t\t\t\t\tthrow new Exception(\"Please define the loop node for the main input Table!\");";
  protected final String TEXT_14 = NL + "\t\t\t\t\tString xPathLoop_";
  protected final String TEXT_15 = " = \"";
  protected final String TEXT_16 = "\";";
  protected final String TEXT_17 = NL + "\torg.dom4j.Document doc_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".getDocument(); " + NL + "\tnsTool_";
  protected final String TEXT_21 = ".countNSMap(doc_";
  protected final String TEXT_22 = ".getRootElement());" + NL + "\tjava.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_23 = " = nsTool_";
  protected final String TEXT_24 = ".xmlNameSpaceMap;" + NL + "\torg.dom4j.XPath x_";
  protected final String TEXT_25 = " = doc_";
  protected final String TEXT_26 = ".createXPath(nsTool_";
  protected final String TEXT_27 = ".addDefaultNSPrefix(xPathLoop_";
  protected final String TEXT_28 = ",xPathLoop_";
  protected final String TEXT_29 = "));  " + NL + "\tx_";
  protected final String TEXT_30 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_31 = ");" + NL + "\t" + NL + "    java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_32 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_33 = ".selectNodes(doc_";
  protected final String TEXT_34 = ");\t" + NL + "    String str_";
  protected final String TEXT_35 = " = null;" + NL + "    org.dom4j.Node node_";
  protected final String TEXT_36 = " = null;" + NL + "\t" + NL + "\tfor (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_37 = ": nodeList_";
  protected final String TEXT_38 = ") {" + NL + "    \tnb_line_";
  protected final String TEXT_39 = "++;" + NL + "    \t";
  protected final String TEXT_40 = " = false;" + NL + "\t\t";
  protected final String TEXT_41 = "=false;" + NL + "\t\t" + NL + "    \ttreeNodeAPI_";
  protected final String TEXT_42 = ".clear();";
  protected final String TEXT_43 = NL + "\t\t\torg.dom4j.XPath xTmp";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = " = temp_";
  protected final String TEXT_46 = ".createXPath(nsTool_";
  protected final String TEXT_47 = ".addDefaultNSPrefix(\"";
  protected final String TEXT_48 = "\",xPathLoop_";
  protected final String TEXT_49 = "));" + NL + "\t\t    xTmp";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_52 = ");" + NL + "\t\t    Object obj";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = " = xTmp";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ".evaluate(temp_";
  protected final String TEXT_57 = ");" + NL + "\t\t    if(obj";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = " instanceof String || obj";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = " instanceof Number){" + NL + "\t\t    \tstr_";
  protected final String TEXT_62 = " = String.valueOf(obj";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ");" + NL + "\t\t    }else{" + NL + "\t\t    \tnode_";
  protected final String TEXT_65 = " = xTmp";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ".selectSingleNode(temp_";
  protected final String TEXT_68 = ");" + NL + "\t\t    \tstr_";
  protected final String TEXT_69 = " = xTmp";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ".valueOf(temp_";
  protected final String TEXT_72 = ");" + NL + "\t\t    }" + NL + "\t\t    treeNodeAPI_";
  protected final String TEXT_73 = ".put(\"";
  protected final String TEXT_74 = "\", str_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + NL + "\t\t";
  protected final String TEXT_78 = "\t";
  protected final String TEXT_79 = NL + "\t\t///////////////////////////////////////////////" + NL + "\t\t//Starting Lookup Table \"";
  protected final String TEXT_80 = "\" " + NL + "\t\t///////////////////////////////////////////////" + NL + "\t\t//tHash_Lookup_";
  protected final String TEXT_81 = ".initGet();";
  protected final String TEXT_82 = NL + "\t\t";
  protected final String TEXT_83 = NL + "\t\t\tboolean forceLoop";
  protected final String TEXT_84 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_85 = " ";
  protected final String TEXT_86 = "ObjectFromLookup = null;" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t\tif(!";
  protected final String TEXT_88 = "){" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t" + NL + "\t\t\t\tif(!";
  protected final String TEXT_91 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_92 = "  " + NL + "\t\t\t\t   ";
  protected final String TEXT_93 = "HashKey.";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = ";" + NL + "\t\t\t\t   ";
  protected final String TEXT_96 = "HashKey.hashCodeDirty = true;" + NL + "\t\t\t\t   tHash_Lookup_";
  protected final String TEXT_97 = ".lookup( ";
  protected final String TEXT_98 = "HashKey );" + NL + "\t\t\t\t   if(!tHash_Lookup_";
  protected final String TEXT_99 = ".hasNext()){" + NL + "\t\t\t\t\t   ";
  protected final String TEXT_100 = "\t   " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_101 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_103 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t   ";
  protected final String TEXT_105 = NL + "\t\t\t\t   }" + NL + "\t\t\t\t   ";
  protected final String TEXT_106 = " " + NL + "\t\t\t\t  // ";
  protected final String TEXT_107 = " = false;";
  protected final String TEXT_108 = NL + "\t\t";
  protected final String TEXT_109 = " = false;";
  protected final String TEXT_110 = NL + "\t\t} // End of RejectInnerJoin/RejectedDocInnerJoin";
  protected final String TEXT_111 = NL + "\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\tif(!";
  protected final String TEXT_113 = "){" + NL + "\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_114 = ".lookup( ";
  protected final String TEXT_115 = "HashKey );" + NL + "\t\t\t\t\t\tif(tHash_Lookup_";
  protected final String TEXT_116 = ".hasNext()){" + NL + "\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_117 = " = true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else {" + NL + "\t\t\t\t\t\tforceLoop";
  protected final String TEXT_118 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t   " + NL + "\t\t\t\t\twhile (tHash_Lookup_";
  protected final String TEXT_119 = ".hasNext() || forceLoop";
  protected final String TEXT_120 = ") { " + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_121 = "Struct fromLookup_";
  protected final String TEXT_122 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = "Default;" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\tif (!forceLoop";
  protected final String TEXT_125 = ") { " + NL + "\t\t\t\t\t\t\tfromLookup_";
  protected final String TEXT_126 = " = tHash_Lookup_";
  protected final String TEXT_127 = ".next();" + NL + "\t\t\t\t\t\t\tif (fromLookup_";
  protected final String TEXT_128 = " != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_129 = " = fromLookup_";
  protected final String TEXT_130 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tforceLoop";
  protected final String TEXT_131 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_132 = NL + "\t";
  protected final String TEXT_133 = NL + "\t\t\t\tif(!";
  protected final String TEXT_134 = "){" + NL + "\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_135 = ".lookup( ";
  protected final String TEXT_136 = "HashKey );" + NL + "\t\t\t\t\tif(tHash_Lookup_";
  protected final String TEXT_137 = ".hasNext()){" + NL + "\t\t\t\t\t\tforceLoop";
  protected final String TEXT_138 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else {" + NL + "\t\t\t\t\tforceLoop";
  protected final String TEXT_139 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\twhile (tHash_Lookup_";
  protected final String TEXT_140 = ".hasNext() || forceLoop";
  protected final String TEXT_141 = ") { " + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = "Struct fromLookup_";
  protected final String TEXT_143 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = "Default;" + NL + "\t\t\t" + NL + "\t\t\t\t\tif (!forceLoop";
  protected final String TEXT_146 = ") { " + NL + "\t\t\t\t\t\tfromLookup_";
  protected final String TEXT_147 = " = tHash_Lookup_";
  protected final String TEXT_148 = ".next();" + NL + "\t\t\t\t\t\tif (fromLookup_";
  protected final String TEXT_149 = " != null) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_150 = " = fromLookup_";
  protected final String TEXT_151 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tforceLoop";
  protected final String TEXT_152 = " = false;";
  protected final String TEXT_153 = NL + NL;
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = NL + "\t\t////////////////////////////////////////////////////////";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + "\t{";
  protected final String TEXT_158 = "\t\t\t" + NL + "\t\t";
  protected final String TEXT_159 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ";";
  protected final String TEXT_163 = NL + NL + "//###############################" + NL + "//# Outputs initialization";
  protected final String TEXT_164 = NL + "\tboolean rejected_";
  protected final String TEXT_165 = " = true;" + NL + "\tboolean alreadyMapped_";
  protected final String TEXT_166 = " = false;";
  protected final String TEXT_167 = NL + "\t";
  protected final String TEXT_168 = " = null;" + NL + "\t//output table :'";
  protected final String TEXT_169 = "'";
  protected final String TEXT_170 = NL + "\t\t\t\tif(!";
  protected final String TEXT_171 = "){";
  protected final String TEXT_172 = NL + "\t\t\t\tif(";
  protected final String TEXT_173 = " && !alreadyMapped_";
  protected final String TEXT_174 = "){" + NL + "\t\t\t\t\trejected_";
  protected final String TEXT_175 = " = false;";
  protected final String TEXT_176 = NL + "\t\t\t\tif(!";
  protected final String TEXT_177 = " && rejected_";
  protected final String TEXT_178 = " && !alreadyMapped_";
  protected final String TEXT_179 = "){";
  protected final String TEXT_180 = NL + "\t\t\t\tif((";
  protected final String TEXT_181 = " || rejected_";
  protected final String TEXT_182 = ") && !alreadyMapped_";
  protected final String TEXT_183 = "){";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = NL + "\t\t\t\tif(!";
  protected final String TEXT_186 = "){";
  protected final String TEXT_187 = NL + "\t\t\t\tif(";
  protected final String TEXT_188 = " && !alreadyMapped_";
  protected final String TEXT_189 = "){" + NL + "\t\t\t\t\trejected_";
  protected final String TEXT_190 = " = false;";
  protected final String TEXT_191 = NL + "\t\t\t\tif(!";
  protected final String TEXT_192 = " && rejected_";
  protected final String TEXT_193 = " && !alreadyMapped_";
  protected final String TEXT_194 = "){";
  protected final String TEXT_195 = NL + "\t\t\t\tif((";
  protected final String TEXT_196 = " || rejected_";
  protected final String TEXT_197 = ") && !alreadyMapped_";
  protected final String TEXT_198 = "){";
  protected final String TEXT_199 = NL + "\tif( ";
  protected final String TEXT_200 = " ){" + NL + "\t\trejected_";
  protected final String TEXT_201 = " = false;" + NL + "\t\talreadyMapped_";
  protected final String TEXT_202 = " = true;";
  protected final String TEXT_203 = NL + "\t\t\tgen_Doc_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ".generateElements(treeNodeAPI_";
  protected final String TEXT_206 = ",";
  protected final String TEXT_207 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_208 = ", ";
  protected final String TEXT_209 = NL + "\t\t";
  protected final String TEXT_210 = ", ";
  protected final String TEXT_211 = ");" + NL + "" + NL + "\t\t\tif(";
  protected final String TEXT_212 = "_tmp.";
  protected final String TEXT_213 = " == null){" + NL + "\t\t\t\t";
  protected final String TEXT_214 = "_tmp.";
  protected final String TEXT_215 = " = new ";
  protected final String TEXT_216 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_217 = "_tmp.";
  protected final String TEXT_218 = ".setDocument(gen_Doc_";
  protected final String TEXT_219 = "_";
  protected final String TEXT_220 = ".getDocument());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_221 = "_save = ";
  protected final String TEXT_222 = "_tmp;";
  protected final String TEXT_223 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_224 = "_tmp.";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ";";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = NL + "\t\tif(nb_line_";
  protected final String TEXT_229 = ">=nodeList_";
  protected final String TEXT_230 = ".size())";
  protected final String TEXT_231 = NL;
  protected final String TEXT_232 = " = ";
  protected final String TEXT_233 = "_tmp;";
  protected final String TEXT_234 = NL + "} else {" + NL + "\trejected_";
  protected final String TEXT_235 = " = true;" + NL + "}// close for filter";
  protected final String TEXT_236 = NL;
  protected final String TEXT_237 = NL + "} // end for rejection";
  protected final String TEXT_238 = NL + "} // end for doc rejection";
  protected final String TEXT_239 = NL + "\t} // end for while loop";
  protected final String TEXT_240 = NL + "}// end var";
  protected final String TEXT_241 = NL + "\t";
  protected final String TEXT_242 = " = false;";
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = NL;
  protected final String TEXT_245 = NL + "\t\tif(nb_line_";
  protected final String TEXT_246 = " == nodeList_";
  protected final String TEXT_247 = ".size()) {";
  protected final String TEXT_248 = NL + "\t\t\t\t\t";
  protected final String TEXT_249 = " = ";
  protected final String TEXT_250 = "_save;";
  protected final String TEXT_251 = NL + "\t\t}";
  protected final String TEXT_252 = NL;

	class MatchXmlTreeExpr {
		String cid = null;
		java.util.Map<String, String> pathTypeMap = new java.util.HashMap<String, String>(); // Map<input table xpath, typeToGenerate>
		java.util.Map<String, String> pathPatternMap = new java.util.HashMap<String, String>(); // Map<input table xpath, Pattern>
		java.util.Map<String, String> pathTypeToGenMap = new java.util.HashMap<String, String>(); // Map<"/root/name","String">
		
		public MatchXmlTreeExpr(TreeNode node, String cid) {
			this.cid = cid;
			init(node);
		}
		
		private void init(TreeNode node) {
			if(node.getOutgoingConnections().size()>0 || node.getLookupOutgoingConnections().size()>0){
				String talendType = node.getType();
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, node.isNullable());
				String patternValue = node.getPattern() == null || node.getPattern().trim().length() == 0 ? null : node.getPattern();
				
				pathTypeMap.put(node.getXpath(), talendType);
				pathPatternMap.put(node.getXpath(), patternValue);
				pathTypeToGenMap.put(node.getXpath(), typeToGenerate);
			} else {
	    		for(TreeNode tmpNode : node.getChildren()) {
	    			init(tmpNode);
	    		}
			}
		}
		
		String generateExprCode(String expression){
			StringBuilder strBuilder = new StringBuilder();
			if(expression==null || ("").equals(expression)) {
				return "";
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
							strBuilder.append("treeNodeAPI_"+cid+".get_String(\""+ tmpXpath + "\")");
						} else if("id_Date".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI_"+cid+".get_Date(\""+ tmpXpath + "\" , \"" + pathPatternMap.get(tmpXpath) + "\")");
						} else if("id_byte[]".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI_"+cid+".get_Bytes(\""+ tmpXpath + "\")");
						} else {
							strBuilder.append("treeNodeAPI_"+cid+".get_" + pathTypeToGenMap.get(tmpXpath) + "(\""+ tmpXpath + "\")");
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
			return strBuilder.toString();
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
		
		void findXpathArray(TreeNode node, String loopPath, List<String> resultList, java.util.Map<String, String> map) {
			if(node.getOutgoingConnections().size()>0 || node.getLookupOutgoingConnections().size()>0){
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
				map.put(result, node.getXpath());
			} else {
    			for(TreeNode tmpNode : node.getChildren()) {
    				findXpathArray(tmpNode, loopPath, resultList, map);
    			}
			}
		}
	}

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	XmlMapComponent node = (XmlMapComponent) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	XmlMapData xmlMapData=(XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
	
	EList<InputXmlTree> inputTables = xmlMapData.getInputTrees();
	EList<OutputXmlTree> outputTables = xmlMapData.getOutputTrees();
	EList<VarTable> varTables = xmlMapData.getVarTables();

	String rejectedInnerJoin = "rejectedInnerJoin_" + cid;
	String rejectedDocInnerJoin = "rejectedDocInnerJoin_" + cid;
	String rejected = "rejected_" + cid;
	String mainRowRejected = "mainRowRejected_" + cid;
	boolean isLookup = false;
	boolean isXpathFromLookup = true;
	boolean isExpressionEmpty = true;
	boolean hasOutgoingConnection = false;
	boolean containDocType = false;
	boolean isPlainNode = false;
	boolean isPlainNodeInLookup = false;
	int lookupTableCount = 0;
	boolean hasDocumentGlobal = false;
	
	List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
	Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
    for (IConnection connection : outputConnections) {
	  		nameToOutputConnection.put(connection.getName(), connection);
	}
    
	List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();
	HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
	for(IConnection connection : inputConnections){
		 hNameToConnection.put(connection.getName(), connection);
	}
	
	
	HashMap<String, TreeNode> hInputTableNodes = new HashMap<String, TreeNode>();
	int sizeInputTables = inputTables.size();
	InputXmlTree mainInputTable = null;  // the main input table
	
	String mainInputTableName = null;
	IConnection realMainConnection = null;
	java.util.Map<String, String> xpathTypeMap = null;
	String str  = "";
	TreeNode currentMainNode = null;
	boolean findNext = false;

	 String nextLookupName = null;
	 List<IMetadataColumn> nextLookupColumnsKeys = new ArrayList<IMetadataColumn>();
 
	 boolean hasPersistentLookup = false;
	 int indexLastPersistentSortedTable = -1;
	 
	 ArrayList<InputXmlTree> inputTablesWithInnerJoin = new ArrayList<InputXmlTree>();
	if(inputConnections==null || inputConnections.size() < 1) {
		return "";
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( mainRowRejected );
    stringBuffer.append(TEXT_5);
    
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
	if(mainInputTable != null) {
		MatchXmlTreeExpr matchXmlTreeExpr = null;
		for(OutputXmlTree outputTable : outputTables) {
			String outputTableName = outputTable.getName();
			for(OutputTreeNode outputNode: outputTable.getNodes()) {
				if(("id_Document").equals(outputNode.getType())){
				

    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outputNode.getName());
    stringBuffer.append(TEXT_12);
    
					break;
				} // if(docuemnt)
			}// for(outputNode)
		} // for (outputXMLTree)

    
	String mainInputName = mainInputTable.getName();
	for(TreeNode tmpNode : mainInputTable.getNodes()){
			boolean isInnerJoin = true;
			currentMainNode = tmpNode;

			if(!tmpNode.getType().equals("id_Document")){
				isPlainNode = true;
			}
			
			matchXmlTreeExpr = new MatchXmlTreeExpr(tmpNode, cid);
			if(("id_Document").equals(tmpNode.getType())) { // find the type:document node.
				containDocType = true;
				//find the loop path
				FindNodeUtil findUtil = new FindNodeUtil();
				TreeNode loopNode = findUtil.findLoopPathNode(tmpNode);
				if(loopNode==null){

    stringBuffer.append(TEXT_13);
    
				} else {
					String loopPath = loopNode.getXpath();
					loopPath = loopPath.substring(loopPath.indexOf(":") + 1);

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(loopPath );
    stringBuffer.append(TEXT_16);
    
				}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(mainInputName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tmpNode.getName() );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
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
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(mainRowRejected);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
		// find all these leaf nodes with output connectors in order to get the xpath array
		List<String> resultList = new java.util.ArrayList<String>();
		xpathTypeMap = new java.util.HashMap<String, String>();
		findUtil.findXpathArray(tmpNode, loopNode.getXpath(), resultList, xpathTypeMap);
		for(int i = 0; i< resultList.size(); i++) {
		
			str = resultList.get(i);
		

    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(str );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(xpathTypeMap.get(str) );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
		}
		
	   }// if(document)
	}// for()

    stringBuffer.append(TEXT_76);
    
	//	System.out.println("size of vartable begin:" + varTables.size());
	for (int iInputTable = 0; iInputTable < sizeInputTables; iInputTable++) { 
		InputXmlTree nextInputTable = inputTables.get(iInputTable);

    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_78);
    
	EConnectionType connectionType = null;
	if (nextInputTable != null && nextInputTable.isLookup()) { 
			
		IConnection connection =  hNameToConnection.get(nextInputTable.getName());
		if(connection == null){
			continue;
		}else{
			connectionType = connection.getLineStyle();

			if(connectionType == EConnectionType.FLOW_REF) {
				IMetadataTable metadataTable = connection.getMetadataTable();
				 String tableName = nextInputTable.getName();
				
				 String lookupMode = nextInputTable.getLookupMode();
				 if (nextInputTable.isInnerJoin()) {
			         inputTablesWithInnerJoin.add(nextInputTable);
			     }
			   //  nextJoinedTableNames =tableName+  "__" + tableName; 
			    // System.out.println("nextJoinedTableNames : " + nextJoinedTableNames);
		     

    stringBuffer.append(TEXT_79);
    stringBuffer.append( nextInputTable );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_81);
    
			String expressionKey = "";
			List<IMetadataColumn> listColumns = metadataTable.getListColumns();
			ArrayList<String> keysNames = new ArrayList<String>();
			ArrayList<String> keysValues = new ArrayList<String>();
			ArrayList<String> keysTypes = new ArrayList<String>();
			EList<TreeNode> externalTreeNodes = nextInputTable.getNodes();
			for(int j = 0; j < listColumns.size(); j++){
				IMetadataColumn column = listColumns.get(j);
			    String columnName = column.getLabel();
			    TreeNode  externalInputTableEntry = externalTreeNodes.get(j);
			    if (externalInputTableEntry != null) {
			    	  	if(externalInputTableEntry.getOutgoingConnections().size() > 0){
					    	hasOutgoingConnection = true;
					    }
			    	  	expressionKey = externalInputTableEntry.getExpression();
						if (expressionKey != null && !"".equals(expressionKey.trim())) {
							
						    keysNames.add(columnName);

						    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

						    String resultExpression = null;
						    if(matchXmlTreeExpr != null){
								
						    	resultExpression = matchXmlTreeExpr.generateExprCode(expressionKey);
						    }
						    if(resultExpression != null && !("").equals(resultExpression)){
						    
						    	keysValues.add(resultExpression);
						    	if(resultExpression.indexOf("/") == -1)
						    	isXpathFromLookup = false;
						    }
						    else {
						    	keysValues.add(expressionKey);
						    }
						    keysTypes.add(typeToGenerate);
						    boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);
			//			    if(javaPrimitiveKeyColumn) {
			//			         	hasPrimitiveKey = true;
						}

			    }
			}
			String[] aKeysNames = keysNames.toArray(new String[0]);
			String[] aKeysValues = keysValues.toArray(new String[0]);
			
			String className = tableName + "Struct";
			String matchingMode = nextInputTable.getMatchingMode();
			if(matchingMode == null) {
				if(aKeysValues.length > 0) {
					matchingMode = "UNIQUE_MATCH";
				} else {
					matchingMode = "ALL_ROWS";
				}
			}

    stringBuffer.append(TEXT_82);
     if(hasOutgoingConnection){ 
    stringBuffer.append(TEXT_83);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_86);
    } 
    
		//if( null != expressionKey && !("").equals(expressionKey.trim())){
			
		if( null != aKeysValues && aKeysValues.length != 0 ){
			isExpressionEmpty = false;
			if(!isXpathFromLookup){

    stringBuffer.append(TEXT_87);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_88);
     } 
     
			if(aKeysValues.length > 0) { 
				for (int iKeyName = 0; iKeyName < aKeysNames.length; iKeyName++) {
				   String typeToGenerate = keysTypes.get(iKeyName);
				   boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);

    stringBuffer.append(TEXT_89);
    
				if (aKeysValues[iKeyName].indexOf("/") != -1){ 
				
    stringBuffer.append(TEXT_90);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_91);
     } 
    stringBuffer.append(TEXT_92);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_99);
    if(!isXpathFromLookup && aKeysValues[iKeyName].indexOf("/") == -1){
    stringBuffer.append(TEXT_100);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_101);
    } else if(isXpathFromLookup || aKeysValues[iKeyName].indexOf("/") != -1){
    stringBuffer.append(TEXT_102);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
     if (aKeysValues[iKeyName].indexOf("/") != -1){ 
    stringBuffer.append(TEXT_105);
     } 
				   
    stringBuffer.append(TEXT_106);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_107);
    
				}// end for aKeysNames

     if(iInputTable != sizeInputTables-1 && isXpathFromLookup){
    stringBuffer.append(TEXT_108);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_109);
    }
    

		} 

     if(!isXpathFromLookup){ 
    stringBuffer.append(TEXT_110);
     } 
    stringBuffer.append(TEXT_111);
    
		if(hasOutgoingConnection){
	
    stringBuffer.append(TEXT_112);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_131);
    				
	}
	
    stringBuffer.append(TEXT_132);
    
			} // end of expression key checking
		else {
	
			isExpressionEmpty = true;
			if(hasOutgoingConnection){
	
    stringBuffer.append(TEXT_133);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_152);
    					}
				}
			}
		}
	}

    
	
	if(hasOutgoingConnection)
			lookupTableCount++;
	
	} // end for lookup tables

    stringBuffer.append(TEXT_153);
    	
 for (OutputXmlTree table : outputTables) {
        EList<OutputTreeNode> tableEntries = table.getNodes();
        if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
            continue;
        }
        String tableName1 = table.getName();
        
        String instanceVarName = tableName1 + "__" + node.getUniqueName();
        String className = tableName1 + "Struct";

    stringBuffer.append(TEXT_154);
    
for(OutputTreeNode tableEntry : tableEntries) {

    
	if(("id_Document").equals(tableEntry.getType())){
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(tableEntry.getType(), tableEntry.isNullable());

    stringBuffer.append(TEXT_155);
    
	}
}
 }

    stringBuffer.append(TEXT_156);
    
	if(varTables.size() > 0 ){

    stringBuffer.append(TEXT_157);
    
	for(VarTable var : varTables) {
		String varsTableName = var.getName();
		String instanceVarName = varsTableName + "__" + cid;
		String className = instanceVarName + "__Struct";

    stringBuffer.append(TEXT_158);
    stringBuffer.append(className + " " + varsTableName + " = " + instanceVarName + ";" );
    
		for(VarNode varNode : var.getNodes()){
			String javaType = varNode.getType();
			String expression = varNode.getExpression();
			String resultExpression = "";
			if(matchXmlTreeExpr != null)
				resultExpression = matchXmlTreeExpr.generateExprCode(expression);
			if(resultExpression!=null && !("").equals(resultExpression)){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(varsTableName );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(varNode.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(resultExpression );
    stringBuffer.append(TEXT_162);
    
			}
		}
	}

    
	}

    stringBuffer.append(TEXT_163);
    
		boolean isInnerJoinReject = false;
		boolean isOutputReject = false;

//      EList<OutputXmlTree> outputTablesList = new ArrayList<OutputXmlTree>(outputTables);
    // constants

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    

	ArrayList<OutputXmlTree> outputTablesSortedByReject = new ArrayList<OutputXmlTree>(outputTables);
	// sorting outputs : rejects tables after not rejects table
	Collections.sort(outputTablesSortedByReject, new Comparator<OutputXmlTree>() {

		public int compare(OutputXmlTree o1, OutputXmlTree o2) {
			if (o1.isReject() != o2.isReject()) {
				if (o1.isReject()) {
					return 1;
				} else {
					return -1;
				}
			}
			if (o1.isRejectInnerJoin() != o2.isRejectInnerJoin()) {
				if (o1.isRejectInnerJoin()) {
					return 1;
				} else {
					return -1;
				}
			}
			return 0;
		}

	});

    for (OutputXmlTree table : outputTablesSortedByReject) {
        EList<OutputTreeNode> tableEntries = table.getNodes();

        if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
            continue;
        }
        String tableName1 = table.getName();
        isInnerJoinReject = table.isRejectInnerJoin();
		isOutputReject = table.isReject();
        String instanceVarName = tableName1 + "__" + node.getUniqueName();
        String className = tableName1 + "Struct";

    stringBuffer.append(TEXT_167);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(tableName1);
    stringBuffer.append(TEXT_169);
    	if(!isXpathFromLookup){
    
		if(!isInnerJoinReject && !isOutputReject) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(rejectedInnerJoin );
    stringBuffer.append(TEXT_171);
    
		} else if(isInnerJoinReject && !isOutputReject) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(rejectedInnerJoin );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
		} else if(!isInnerJoinReject && isOutputReject) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(rejectedInnerJoin);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
		} else if(isInnerJoinReject && isOutputReject) {

    stringBuffer.append(TEXT_180);
    stringBuffer.append(rejectedInnerJoin );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
		}

    stringBuffer.append(TEXT_184);
    	} else if(isXpathFromLookup && containDocType ){ 
    
		if(!isInnerJoinReject && !isOutputReject) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(rejectedDocInnerJoin );
    stringBuffer.append(TEXT_186);
    
		} else if(isInnerJoinReject && !isOutputReject) {

    stringBuffer.append(TEXT_187);
    stringBuffer.append(rejectedDocInnerJoin );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
		} else if(!isInnerJoinReject && isOutputReject) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(rejectedDocInnerJoin );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
		} else if(isInnerJoinReject && isOutputReject) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(rejectedDocInnerJoin );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
		}

     } 
      if(table.isActivateExpressionFilter() && table.getExpressionFilter() != null && !("").equals(table.getExpressionFilter())){ 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(matchXmlTreeExpr!=null?matchXmlTreeExpr.generateExprCode(table.getExpressionFilter()):false);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
     } 
    
	boolean hasDocument = false;
	for(OutputTreeNode tableEntry : tableEntries) {

		if(("id_Document").equals(tableEntry.getType())){
			hasDocument = true;
			hasDocumentGlobal = true;
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(tableEntry.getType(), tableEntry.isNullable());

    stringBuffer.append(TEXT_203);
    stringBuffer.append(table.getName() );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( rejectedDocInnerJoin );
    stringBuffer.append(TEXT_207);
    
		for (InputXmlTree inputTable: inputTables) {
	
		
    stringBuffer.append(TEXT_208);
    stringBuffer.append(inputTable.getName() );
    stringBuffer.append(TEXT_209);
    
	
		}
		for (VarTable var : varTables) {
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(var.getName());
    
		}
		
    stringBuffer.append(TEXT_211);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(tableEntry.getName() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(tableEntry.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(tableEntry.getName() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(table.getName() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_222);
    
		} else {
			String resultExpression = "";
			//if(matchXmlTreeExpr != null)
				resultExpression = matchXmlTreeExpr.generateExprCode(tableEntry.getExpression());
		if(resultExpression!=null && !("").equals(resultExpression)){

    stringBuffer.append(TEXT_223);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(tableEntry.getName() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(resultExpression );
    stringBuffer.append(TEXT_226);
    	
		}
	}


    stringBuffer.append(TEXT_227);
    	
}//for (OutputXmlTree table : outputTablesSortedByReject) {

    
	if(hasDocument && !isPlainNode) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    	
	}

    stringBuffer.append(TEXT_231);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_233);
     if(table.isActivateExpressionFilter() && table.getExpressionFilter() != null && !("").equals(table.getExpressionFilter())){ 
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
     } 
    stringBuffer.append(TEXT_236);
    	if(!isXpathFromLookup){
    stringBuffer.append(TEXT_237);
     } else if(isXpathFromLookup && containDocType ){
    stringBuffer.append(TEXT_238);
     } 
    
//	System.out.println("size of vartable end:" + varTables.size());
	if(varTables.size() > 0 ){

    	}
}
    if(hasOutgoingConnection && isExpressionEmpty){
	int i = 0;
	while(i < lookupTableCount){

    stringBuffer.append(TEXT_239);
    	
	i++;
		} 
	}

    stringBuffer.append(TEXT_240);
    	if(!isXpathFromLookup){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(rejectedInnerJoin );
    stringBuffer.append(TEXT_242);
     } 
    
if((isXpathFromLookup || hasOutgoingConnection) && containDocType && !isPlainNode){
    stringBuffer.append(TEXT_243);
     } 
    stringBuffer.append(TEXT_244);
    
	
}// if(maininputtable)
	
//========================the input xml part end=============================

    
	if(hasDocumentGlobal && !isPlainNode) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
			boolean flat = true;
			for (OutputXmlTree table : outputTables) {        
				EList<OutputTreeNode> tableEntries = table.getNodes();
				if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
					continue;
				}
				for(OutputTreeNode tableEntry : tableEntries) {
					if(("id_Document").equals(tableEntry.getType())){
						flat = false;
						break;
					}
				}
				
				String tableName1 = table.getName();
            
				String instanceVarName = tableName1 + "__" + node.getUniqueName();
				String className = tableName1 + "Struct";
				if(!flat) {
            

    stringBuffer.append(TEXT_248);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_249);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_250);
    
				}
			}

    stringBuffer.append(TEXT_251);
    
	}

    stringBuffer.append(TEXT_252);
    return stringBuffer.toString();
  }
}
