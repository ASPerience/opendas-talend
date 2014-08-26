package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFixedFlowInputBeginJava
{
  protected static String nl;
  public static synchronized TFixedFlowInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFixedFlowInputBeginJava result = new TFixedFlowInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t    globalMap.put(\"NB_LINE\", ";
  protected final String TEXT_3 = ");" + NL + "\t    for (int i_";
  protected final String TEXT_4 = " = 0 ; i_";
  protected final String TEXT_5 = " < ";
  protected final String TEXT_6 = " ; i_";
  protected final String TEXT_7 = "++) {" + NL + "\t        ";
  protected final String TEXT_8 = "        \t            \t" + NL + "        \t            \t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";        \t            \t" + NL + "        \t            \t";
  protected final String TEXT_12 = "        \t            \t" + NL + "        \t            \t\t";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "        \t            \t";
  protected final String TEXT_16 = NL + "\tint nb_line_";
  protected final String TEXT_17 = " = 0;";
  protected final String TEXT_18 = NL + "\tList<";
  protected final String TEXT_19 = "Struct> cacheList_";
  protected final String TEXT_20 = " = new java.util.ArrayList<";
  protected final String TEXT_21 = "Struct>();";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = " = new ";
  protected final String TEXT_24 = "Struct();";
  protected final String TEXT_25 = "        \t            \t";
  protected final String TEXT_26 = NL + "    ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";        \t            \t";
  protected final String TEXT_30 = "        \t            \t" + NL + "\t";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";";
  protected final String TEXT_34 = NL + "\tcacheList_";
  protected final String TEXT_35 = ".add(";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\tfor (int i_";
  protected final String TEXT_38 = " = 0 ; i_";
  protected final String TEXT_39 = " < ";
  protected final String TEXT_40 = " ; i_";
  protected final String TEXT_41 = "++) {" + NL + "\t\tfor(";
  protected final String TEXT_42 = "Struct tmpRow_";
  protected final String TEXT_43 = " : cacheList_";
  protected final String TEXT_44 = "){" + NL + "\t" + NL + "\t\t\tnb_line_";
  protected final String TEXT_45 = " ++;\t\t" + NL + "\t\t\t";
  protected final String TEXT_46 = " = tmpRow_";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + NL + "StringBuilder result_";
  protected final String TEXT_49 = " = new StringBuilder();";
  protected final String TEXT_50 = NL + "\tresult_";
  protected final String TEXT_51 = ".append(\"";
  protected final String TEXT_52 = "\");";
  protected final String TEXT_53 = NL + "String originalFileContent_";
  protected final String TEXT_54 = " = \"\";" + NL + "try {" + NL + "    originalFileContent_";
  protected final String TEXT_55 = " = new String((new sun.misc.BASE64Decoder()).decodeBuffer(result_";
  protected final String TEXT_56 = ".toString()), \"UTF8\");" + NL + "} catch (Exception e) {" + NL + "    e.printStackTrace();" + NL + "}" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_57 = " = 0;" + NL + "globalMap.put(\"NB_LINE\", ";
  protected final String TEXT_58 = ");" + NL + "" + NL + "for (int i_";
  protected final String TEXT_59 = " = 0 ; i_";
  protected final String TEXT_60 = " < ";
  protected final String TEXT_61 = " ; i_";
  protected final String TEXT_62 = "++) {\t" + NL + "" + NL + "java.io.InputStream ins_";
  protected final String TEXT_63 = " = new java.io.ByteArrayInputStream(originalFileContent_";
  protected final String TEXT_64 = ".getBytes());        " + NL + "org.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_65 = " = new org.talend.fileprocess.FileInputDelimited(ins_";
  protected final String TEXT_66 = ", \"UTF-8\",";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ",true, 0, 0, -1, -1, false);" + NL + "" + NL + "while (fid_";
  protected final String TEXT_69 = ".nextRecord()) {" + NL + "\tnb_line_";
  protected final String TEXT_70 = "++;";
  protected final String TEXT_71 = NL + "\t\t\t";
  protected final String TEXT_72 = " = new ";
  protected final String TEXT_73 = "Struct();";
  protected final String TEXT_74 = NL + NL + "\t\t\t\tif(";
  protected final String TEXT_75 = " < fid_";
  protected final String TEXT_76 = ".getColumnsCountOfCurrentRow()){" + NL + "\t\t\t\t\tString colContent = fid_";
  protected final String TEXT_77 = ".get(";
  protected final String TEXT_78 = ");\t\t\t\t";
  protected final String TEXT_79 = NL + "                    \t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = (colContent == null || colContent.length() == 0) ? ";
  protected final String TEXT_82 = ": colContent;";
  protected final String TEXT_83 = NL + "                    \t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = (colContent == null || colContent.length() == 0) ? ParserUtils.parseTo_Date((String)";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ") : ParserUtils.parseTo_Date(colContent, ";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "                    \t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = (colContent == null || colContent.length() == 0) ? ";
  protected final String TEXT_92 = " : colContent.getBytes();";
  protected final String TEXT_93 = NL + "                    \t\t";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = (colContent == null || colContent.trim().length() == 0) ? ";
  protected final String TEXT_96 = " : ParserUtils.parseTo_";
  protected final String TEXT_97 = "(colContent);";
  protected final String TEXT_98 = "\t\t\t" + NL + "\t\t\t\t} else { " + NL + "\t\t\t\t";
  protected final String TEXT_99 = "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = ParserUtils.parseTo_Date((String)";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String nbRows = ElementParameterParser.getValue(node, "__NB_ROWS__");

	List<Map<String, String>> tableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__VALUES__"
    );
    
    boolean use_singleMode = ("true").equals(ElementParameterParser.getValue(node, "__USE_SINGLEMODE__"));
    boolean use_inTable = ("true").equals(ElementParameterParser.getValue(node, "__USE_INTABLE__"));
    boolean use_inlineContent = ("true").equals(ElementParameterParser.getValue(node, "__USE_INLINECONTENT__"));
    
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    
	List<Map<String, String>> inTableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__INTABLE__"
    );
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);    
    }
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	
//************** the original part that get only one value for each column ********************
	if(use_singleMode){
		if(tableValues != null && tableValues.size() > 0 && conns != null && conns.size() > 0) {
	    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
    	    for(IConnection conn : conns) {
    	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    	        	
    	            for(Map<String, String> tableValue : tableValues) {
    	            	String lable = tableValue.get("SCHEMA_COLUMN");
        	            String value = tableValue.get("VALUE");
        	            if(value == null || value.length() == 0){ //use the default value
        	            	IMetadataColumn column = metadata.getColumn(lable);
    	            		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    	            		String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
    	            		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(lable );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_11);
    
        	            }else{
        	            	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(lable );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_15);
    
        	            }
    	            }
    	        }
    	    }
		}
//***************************the original part end ***************************************
	}else if(use_inTable){
//******************the new part ---get several values for each column*********************
		if(inTableValues != null && inTableValues.size() > 0 && conns != null && conns.size() > 0) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
            String firstConnName = "";	
            for(IConnection conn : conns) {
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
             		firstConnName = conn.getName();
             		break;
                }
            }
    	    if(firstConnName!=null && !firstConnName.equals("")){//XXX

    stringBuffer.append(TEXT_18);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_21);
        	        	
    	            for(Map<String, String> tableValue : inTableValues) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_24);
    
    	            	for(IMetadataColumn column: metadata.getListColumns()){
    	            		String label = column.getLabel();
	    	            	String value = tableValue.get(label);
	        	            if(value == null || value.length() == 0){ //use the default value
	    	            		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	    	            		String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());

    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_29);
    
        	            	}else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_33);
    
        	            	}
        	            }

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_36);
    
    	            }

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
    	    }
		}
//********************the new part end*****************************************************
	}else if(use_inlineContent){
	
	String fileContent = ElementParameterParser.getValue(node,"__INLINECONTENT__");
	
	String lineSeparator = (String) java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));
	//lineSeparator.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n")
	
	String fileContentEnCodeStr = "";
	try {
		fileContentEnCodeStr = (new sun.misc.BASE64Encoder()).encode(fileContent.getBytes("UTF8"));
	} catch (java.io.UnsupportedEncodingException e) {
		e.printStackTrace();
	}	

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
String[] arrayStr = fileContentEnCodeStr.split(lineSeparator);
for(String item : arrayStr){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(item );
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(nbRows);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(nbRows);
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
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
    String firstConnName = "";	
    for(IConnection conn : conns) {
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
     		firstConnName = conn.getName();
     		break;
        }
    }
    
    if(!firstConnName.equals("")){//XXX

    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_73);
    
        	List<IMetadataColumn> columns = metadata.getListColumns();
        	int sizeListColumns = columns.size();

			for (int i=0;i<sizeListColumns;i++) {//AAA
					IMetadataColumn column=columns.get(i);
					String label = column.getLabel();
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();					
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());

    stringBuffer.append(TEXT_74);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_78);
    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_82);
    }else if(javaType == JavaTypesManager.DATE){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_88);
    }else if(javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_92);
    }else{
    stringBuffer.append(TEXT_93);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    if(javaType != JavaTypesManager.DATE){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_102);
    }else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    
				}//AAA
			
    
	}//XXX
//********************the use_inTable part end*****************************************************
	}

    return stringBuffer.toString();
  }
}
