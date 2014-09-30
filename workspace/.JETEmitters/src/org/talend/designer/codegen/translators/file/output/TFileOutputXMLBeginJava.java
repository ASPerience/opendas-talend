package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.utils.TalendQuoteUtils;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLBeginJava result = new TFileOutputXMLBeginJava();
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
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "\t\tString log4jFileOutputXMLParameters_";
  protected final String TEXT_46 = " = \"\";" + NL + "\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_47 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_48 = " + \"FILENAME = \" + ";
  protected final String TEXT_49 = " + \" | \";" + NL + "\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_50 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_51 = " + \"INPUT_IS_DOCUMENT = \" + ";
  protected final String TEXT_52 = " + \" | \";" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_54 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_55 = " + \"DOCUMENT_COL = \" + \"";
  protected final String TEXT_56 = "\" + \" | \";" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_58 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_59 = " + \"ROW_TAG = \" + ";
  protected final String TEXT_60 = " + \" | \";" + NL + "\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_61 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_62 = " + \"SPLIT = \" + ";
  protected final String TEXT_63 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_65 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_66 = " + \"SPLIT_EVERY = \" + ";
  protected final String TEXT_67 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_69 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_70 = " + \"FLUSHONROW = \" + ";
  protected final String TEXT_71 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_73 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_74 = " + \"FLUSHONROW_NUM = \" + ";
  protected final String TEXT_75 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_78 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_79 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_80 = " + \" | \";" + NL + "\t\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_81 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_82 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_83 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_85 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_86 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_87 = "\" + \" | \";" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_89 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_90 = " + \"CREATE = \" + ";
  protected final String TEXT_91 = " + \" | \";" + NL + "\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_92 = " = log4jFileOutputXMLParameters_";
  protected final String TEXT_93 = " + \"DELETE_EMPTYFILE = \" + ";
  protected final String TEXT_94 = " + \" | \";" + NL + "\t\t" + NL + "\t\tlog4jFileOutputXMLParameters_";
  protected final String TEXT_95 = " = \"";
  protected final String TEXT_96 = " - Parameters:\" + log4jFileOutputXMLParameters_";
  protected final String TEXT_97 = ";" + NL + "\t\tlog.debug(log4jFileOutputXMLParameters_";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tString originalFileName_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ";" + NL + "\tjava.io.File originalFile_";
  protected final String TEXT_102 = " = new java.io.File(originalFileName_";
  protected final String TEXT_103 = "); " + NL + "" + NL + "\tString fileName_";
  protected final String TEXT_104 = " = originalFileName_";
  protected final String TEXT_105 = ";" + NL + "\tjava.io.File file_";
  protected final String TEXT_106 = " = new java.io.File(fileName_";
  protected final String TEXT_107 = "); " + NL + "\tif(!file_";
  protected final String TEXT_108 = ".isAbsolute()) {" + NL + "\t\tfile_";
  protected final String TEXT_109 = " = file_";
  protected final String TEXT_110 = ".getCanonicalFile();" + NL + "\t}" + NL;
  protected final String TEXT_111 = NL + "\t//create directory only if not exists" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tlog.info(\"";
  protected final String TEXT_113 = " - Creating directory '\" + file_";
  protected final String TEXT_114 = ".getParentFile() + \"'.\");" + NL + "\t";
  protected final String TEXT_115 = NL + "\tfile_";
  protected final String TEXT_116 = ".getParentFile().mkdirs();" + NL + "\t";
  protected final String TEXT_117 = NL + "\t\tlog.info(\"";
  protected final String TEXT_118 = " - Directory '\" + file_";
  protected final String TEXT_119 = ".getParentFile() + \"' created successfully.\");" + NL + "\t";
  protected final String TEXT_120 = NL + "\tString[] headers_";
  protected final String TEXT_121 = " = new String[";
  protected final String TEXT_122 = "];" + NL + "\t\t" + NL + "\theaders_";
  protected final String TEXT_123 = "[0] = \"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_124 = "+\"\\\"?>\";  " + NL;
  protected final String TEXT_125 = NL + "\tString[] footers_";
  protected final String TEXT_126 = " = new String[";
  protected final String TEXT_127 = "];" + NL;
  protected final String TEXT_128 = NL + "\theaders_";
  protected final String TEXT_129 = "[";
  protected final String TEXT_130 = "] = \"<\"+";
  protected final String TEXT_131 = "+\">\";" + NL + "" + NL + "\tfooters_";
  protected final String TEXT_132 = "[";
  protected final String TEXT_133 = "] = \"</\"+";
  protected final String TEXT_134 = "+\">\";" + NL;
  protected final String TEXT_135 = NL + "\tString[][] groupby_";
  protected final String TEXT_136 = " = new String[";
  protected final String TEXT_137 = "][2];" + NL + "" + NL + "\tint groupby_new_";
  protected final String TEXT_138 = " = 0;" + NL + "" + NL + "\tboolean start_";
  protected final String TEXT_139 = " = false;" + NL;
  protected final String TEXT_140 = NL + "\tgroupby_";
  protected final String TEXT_141 = "[";
  protected final String TEXT_142 = "][0] = \"\";" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_143 = "[";
  protected final String TEXT_144 = "][1] = \"</\"+";
  protected final String TEXT_145 = "+\">\";" + NL;
  protected final String TEXT_146 = NL + NL + "\tint nb_line_";
  protected final String TEXT_147 = " = 0;" + NL;
  protected final String TEXT_148 = NL + "\tint currentRowCount_";
  protected final String TEXT_149 = " = 0;" + NL + "\tint currentFileCount_";
  protected final String TEXT_150 = " = 0;" + NL + "" + NL + "\tString canonicalPath_";
  protected final String TEXT_151 = " = originalFile_";
  protected final String TEXT_152 = ".getCanonicalPath();" + NL + "\tStringBuffer sb_";
  protected final String TEXT_153 = " = new StringBuffer(canonicalPath_";
  protected final String TEXT_154 = ");" + NL + "\tint lastIndexOf_";
  protected final String TEXT_155 = " = canonicalPath_";
  protected final String TEXT_156 = ".lastIndexOf('.');" + NL + "\tint position_";
  protected final String TEXT_157 = " = lastIndexOf_";
  protected final String TEXT_158 = " > -1 ? lastIndexOf_";
  protected final String TEXT_159 = " : canonicalPath_";
  protected final String TEXT_160 = ".length();" + NL + "\tsb_";
  protected final String TEXT_161 = ".insert(position_";
  protected final String TEXT_162 = ", currentFileCount_";
  protected final String TEXT_163 = ");" + NL + "" + NL + "\tfileName_";
  protected final String TEXT_164 = " = sb_";
  protected final String TEXT_165 = ".toString();" + NL + "\tfile_";
  protected final String TEXT_166 = " = new java.io.File(fileName_";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + NL + "\tjava.io.BufferedWriter out_";
  protected final String TEXT_169 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_170 = "), ";
  protected final String TEXT_171 = "));" + NL;
  protected final String TEXT_172 = NL + "\tout_";
  protected final String TEXT_173 = ".write(headers_";
  protected final String TEXT_174 = "[";
  protected final String TEXT_175 = "]);" + NL + "\tout_";
  protected final String TEXT_176 = ".newLine();\t";
  protected final String TEXT_177 = NL + "\tint nb_line_";
  protected final String TEXT_178 = " = 0;" + NL + "\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_179 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "\tformat_";
  protected final String TEXT_180 = ".setEncoding(";
  protected final String TEXT_181 = ");" + NL + "\tformat_";
  protected final String TEXT_182 = ".setNewLineAfterDeclaration(false);" + NL + "\tformat_";
  protected final String TEXT_183 = ".setTrimText(";
  protected final String TEXT_184 = ");" + NL + "\torg.dom4j.io.XMLWriter writer_";
  protected final String TEXT_185 = " = new org.dom4j.io.XMLWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_186 = "), ";
  protected final String TEXT_187 = "), format_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL;

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
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	/* Build the Log4J message for the different parameters */

	if(isLog4jEnabled) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));
    stringBuffer.append(TEXT_52);
     if("true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"))) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DOCUMENT_COL__"));
    stringBuffer.append(TEXT_56);
     } else { 
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT__"));
    stringBuffer.append(TEXT_63);
     if("true".equals(ElementParameterParser.getValue(node, "__SPLIT__"))) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT_EVERY__"));
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    stringBuffer.append(TEXT_71);
     if("true".equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"))) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__"));
    stringBuffer.append(TEXT_75);
     } 
    stringBuffer.append(TEXT_76);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_83);
     } 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_87);
     } 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CREATE__"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
	}
			
	/* -------------------------- */
	
	log4jFileUtil.componentStartInfo(node);
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
			List<Map<String, String>> rootTags = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
			if (rootTags.size()==0) {
				Map<String, String> defaultRootNode = new HashMap<String, String>();
				defaultRootNode.put("TAG","\"root\"");
				rootTags.add(defaultRootNode);
			}
			int headers = rootTags.size() + 1;
			boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
			String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
			boolean trim = "true".equals(ElementParameterParser.getValue(node, "__TRIM__"));
			
			//**
			List<Map<String, String>> columnMapping = 
					(List<Map<String,String>>)ElementParameterParser.getObjectValue(
						node,
						"__MAPPING__"
					);
			String useDynamicGrouping = ElementParameterParser.getValue(
					node,
					"__USE_DYNAMIC_GROUPING__"
				);
			List<Map<String, String>> groupBys =
					(List<Map<String,String>>)ElementParameterParser.getObjectValue(
						node,
						"__GROUP_BY__"
					);
			if (("false").equals(useDynamicGrouping)) {
				groupBys.clear();
			}
			if (encoding!=null) {
				if (("").equals(encoding)) {
						encoding = "ISO-8859-15";
				}
			}
			String groupby[][] = new String[groupBys.size()][3];
			for(int i = 0; i < groupBys.size(); i++){
				groupby[i][0] = groupBys.get(i).get("COLUMN");
				groupby[i][1] = groupBys.get(i).get("LABEL");
			}
			int atts = 0;
			int tags = 0;
			outter1:
			for(int i = 0; i < columnMapping.size(); i++){
				Map<String, String> map = columnMapping.get(i);
				String col = metadata.getListColumns().get(i).getLabel();
				for(int j = 0; j < groupby.length; j++){
					if(groupby[j][0].equals(col)){
						if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
							groupby[j][2] = col;
							groupby[j][2] = TalendQuoteUtils.addQuotes(groupby[j][2]);
						}else{
							groupby[j][2] = map.get("LABEL");
						}
						continue outter1;
					}
				}
				if(("true").equals(map.get("AS_ATTRIBUTE"))){
					atts ++;
				}else{
					tags ++;
				}
			}
			String[][] attribute = new String[atts][2];
			String[][] tag = new String[tags][2];
			int ia=0;
			int it=0;
			outter2:
			for(int i = 0; i < columnMapping.size(); i++){
				Map<String, String> map = columnMapping.get(i);
				String col = metadata.getListColumns().get(i).getLabel();
				for(int j = 0; j < groupby.length; j++){
					if(groupby[j][0].equals(col)){
						continue outter2;
					}
				}
				if(("true").equals(map.get("AS_ATTRIBUTE"))){
					if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
						attribute[ia][1] = col;
					}else{
						attribute[ia][1] = map.get("LABEL");
					}
					attribute[ia++][0] = col;
				}else{
					if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
						tag[it][1] = col;
					}else{
						tag[it][1] = map.get("LABEL");
					}
					tag[it++][0] = col;
				}
			}
			//**

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
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
    
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    }
    
			}
			if(!inputIsDocument) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(headers );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_124);
    
				if(rootTags.size() > 0){

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(rootTags.size());
    stringBuffer.append(TEXT_127);
    
					for (int i=0; i<rootTags.size(); i++){
						Map<String, String> rootTag = rootTags.get(i);

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_134);
    
					}
				}

				if(groupby.length>0){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(groupby.length );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
					for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_145);
    
					}
				}

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
				if(split) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
				}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_171);
    	
				for(int i = 0; i < headers;i++){

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
				}
			} else {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
			}
		}
	}

    stringBuffer.append(TEXT_189);
    return stringBuffer.toString();
  }
}
