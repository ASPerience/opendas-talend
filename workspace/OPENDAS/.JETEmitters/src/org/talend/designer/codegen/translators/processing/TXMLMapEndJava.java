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
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

/**
 * add by wliu
 */
public class TXMLMapEndJava {

  protected static String nl;
  public static synchronized TXMLMapEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLMapEndJava result = new TXMLMapEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "} // for input xml loop ";
  protected final String TEXT_3 = NL + NL;
  protected final String TEXT_4 = NL;

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
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	XmlMapComponent node = (XmlMapComponent) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	XmlMapData xmlMapData=(XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
	boolean isXpath = false;	
	boolean isPlainNode = true;
	EList<OutputXmlTree> outputTables = xmlMapData.getOutputTrees();
	EList<VarTable> varTables = xmlMapData.getVarTables();
	EList<InputXmlTree> inputTables = xmlMapData.getInputTrees();
	InputXmlTree mainInputTable = inputTables.get(0);
	for(TreeNode tmpNode : mainInputTable.getNodes()){
		if(tmpNode.getType().equals("id_Document"))
			isPlainNode = false;
	}

for (OutputXmlTree table : outputTables) {
	
    
    EList<OutputTreeNode> tableEntries = table.getNodes();
    if (tableEntries == null ) {
        continue;
    }
    for(OutputTreeNode tableEntry : tableEntries) {
        	if(!("id_Document").equals(tableEntry.getType())){

        		String resultExpression = tableEntry.getExpression();
        		if(null !=resultExpression && resultExpression.indexOf("/") != -1)
        		   isXpath = true;        	
			}
	}
}

    stringBuffer.append(TEXT_1);
     if(!isPlainNode){
    stringBuffer.append(TEXT_2);
    }
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
