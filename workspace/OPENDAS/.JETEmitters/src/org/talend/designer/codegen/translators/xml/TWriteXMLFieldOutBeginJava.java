package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TWriteXMLFieldOutBeginJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutBeginJava result = new TWriteXMLFieldOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//tWriteXMLFieldOut_begin";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "boolean needRoot_";
  protected final String TEXT_4 = "  = true;" + NL + "" + NL + "String  strCompCache_";
  protected final String TEXT_5 = "= null;\t\t" + NL + "List<String> listGroupby_";
  protected final String TEXT_6 = "=new java.util.ArrayList<String>();" + NL + "" + NL + "java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_7 = " = new java.util.ArrayList<java.util.List<String>>();" + NL + "java.util.Map<String,String> valueMap_";
  protected final String TEXT_8 = " = new java.util.HashMap<String,String>();";
  protected final String TEXT_9 = NL + "java.util.List<java.util.Map<String,String>> flows_";
  protected final String TEXT_10 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "java.util.Map<String,String> flowValues_";
  protected final String TEXT_11 = " = null;";
  protected final String TEXT_12 = NL + NL + "class NestXMLTool_";
  protected final String TEXT_13 = "{" + NL + "\tpublic void parseAndAdd(org.dom4j.Element nestRoot, String value){" + NL + "\t\ttry {" + NL + "            org.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText(\"<root>\"+ value + \"</root>\");" + NL + "    \t\tnestRoot.setContent(doc4Str.getRootElement().content());" + NL + "    \t} catch (Exception e) {" + NL + "    \t\te.printStackTrace();" + NL + "    \t\tnestRoot.setText(value);" + NL + "        }" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setText(org.dom4j.Element element, String value){" + NL + "\t\tif (value.startsWith(\"<![CDATA[\") && value.endsWith(\"]]>\")) {" + NL + "\t\t\tString text = value.substring(9, value.length()-3);" + NL + "\t\t\telement.addCDATA(text);" + NL + "\t\t}else{" + NL + "\t\t\telement.setText(value);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void replaceDefaultNameSpace(org.dom4j.Element nestRoot){" + NL + "\t\tif (nestRoot!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {" + NL + "        \t\tif ((\"\").equals(tmp.getQName().getNamespace().getURI()) && (\"\").equals(tmp.getQName().getNamespace().getPrefix())){" + NL + "        \t\t\ttmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));" + NL + "\t        \t}" + NL + "    \t    \treplaceDefaultNameSpace(tmp);" + NL + "       \t\t}" + NL + "       \t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void removeEmptyElement(org.dom4j.Element root){" + NL + "\t\tif (root!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {" + NL + "\t\t\t\tremoveEmptyElement(tmp);" + NL + "\t\t\t}" + NL + "\t\t\tif (root.content().size() == 0 " + NL + "    \t\t\t&& root.attributes().size() == 0 " + NL + "    \t\t\t&& root.declaredNamespaces().size() == 0) {" + NL + "    \t\t\tif(root.getParent()!=null){" + NL + "                \troot.getParent().remove(root);" + NL + "                }" + NL + "            }" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "NestXMLTool_";
  protected final String TEXT_14 = " nestXMLTool_";
  protected final String TEXT_15 = " = new NestXMLTool_";
  protected final String TEXT_16 = "();" + NL + "" + NL + "// sort group root element for judgement of group" + NL + "java.util.List<org.dom4j.Element> groupElementList_";
  protected final String TEXT_17 = " = new java.util.ArrayList<org.dom4j.Element>();" + NL + "org.dom4j.Element root4Group_";
  protected final String TEXT_18 = " = null;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_19 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_20 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "format_";
  protected final String TEXT_21 = ".setTrimText(false);" + NL + "format_";
  protected final String TEXT_22 = ".setEncoding(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = "format_";
  protected final String TEXT_25 = ".setExpandEmptyElements(true);";
  protected final String TEXT_26 = NL + "int[] orders_";
  protected final String TEXT_27 = " = new int[";
  protected final String TEXT_28 = "];";
  protected final String TEXT_29 = NL + "java.util.List<String> endTabStrs_";
  protected final String TEXT_30 = " = new java.util.ArrayList<String>();" + NL + "java.util.List<String> startTabStrs_";
  protected final String TEXT_31 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_32 = NL + "endTabStrs_";
  protected final String TEXT_33 = ".add(\"";
  protected final String TEXT_34 = "</";
  protected final String TEXT_35 = ">\");" + NL + "startTabStrs_";
  protected final String TEXT_36 = ".add(\"\\n";
  protected final String TEXT_37 = "<";
  protected final String TEXT_38 = ">\");";
  protected final String TEXT_39 = NL + "int preUnNullMaxIndex_";
  protected final String TEXT_40 = " = -1;" + NL + "int preNewTabIndex_";
  protected final String TEXT_41 = " = -1;" + NL + "String[] startTabs_";
  protected final String TEXT_42 = " = new String[endTabStrs_";
  protected final String TEXT_43 = ".size()];" + NL + "String[] endTabs_";
  protected final String TEXT_44 = " = new String[endTabStrs_";
  protected final String TEXT_45 = ".size()];" + NL + "java.io.StringWriter strWriter_";
  protected final String TEXT_46 = " = new java.io.StringWriter();" + NL + "java.io.BufferedWriter out_";
  protected final String TEXT_47 = " = new java.io.BufferedWriter(strWriter_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "out_";
  protected final String TEXT_50 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_51 = "+\"\\\"?>\");" + NL + "out_";
  protected final String TEXT_52 = ".newLine();";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    			String removeHeader = ElementParameterParser.getValue(node, "__REMOVE_HEADER__"); // add for feature7788
        		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
				boolean isAllowEmpty = ("true").equals(ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__"));
                boolean expandEmptyElm = ("true").equals(ElementParameterParser.getValue(node, "__EXPAND_EMPTY_ELM__"));
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        		List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    if(storeFlow){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    
				// *** generation mode init ***
				if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_23);
    if(isAllowEmpty && expandEmptyElm){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    
					int groupSize = 0;
					if(groupTable!=null && groupTable.size()>0){
						for(java.util.Map<String, String> tmpMap : groupTable){
							if(tmpMap.get("ATTRIBUTE").equals("main")){
								groupSize++;
							}
						}
					}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(groupSize + 1);
    stringBuffer.append(TEXT_28);
    
				}else if(("Null").equals(mode)){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
            		if(loopTable.size()>0){
            			String emptyspace = "";
        				String endPath = loopTable.get(0).get("PATH");
        				String[] endTabs = endPath.split("/");
        				for(int len = 1; len<endTabs.length-1;len++){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_38);
    
	         				emptyspace += "  ";
            			}
        			}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					if(!("true").equals(removeHeader)){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
					}

    stringBuffer.append(TEXT_53);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
