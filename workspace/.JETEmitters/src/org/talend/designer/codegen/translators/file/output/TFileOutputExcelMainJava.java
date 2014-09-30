package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
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
  protected final String TEXT_44 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_45 = ".putValue_";
  protected final String TEXT_46 = "(";
  protected final String TEXT_47 = ",writableSheet_";
  protected final String TEXT_48 = "," + NL + "\t\t\t\t\tstartRowNum_";
  protected final String TEXT_49 = ",nb_line_";
  protected final String TEXT_50 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = "format_";
  protected final String TEXT_52 = "null";
  protected final String TEXT_53 = ",fitWidth_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\t\t";
  protected final String TEXT_56 = "\t\t\t\t";
  protected final String TEXT_57 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = " = writableSheet_";
  protected final String TEXT_66 = ".getWritableCell(";
  protected final String TEXT_67 = " + ";
  protected final String TEXT_68 = ", startRowNum_";
  protected final String TEXT_69 = " + nb_line_";
  protected final String TEXT_70 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = " = new jxl.write.";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = " + ";
  protected final String TEXT_76 = ", startRowNum_";
  protected final String TEXT_77 = " + nb_line_";
  protected final String TEXT_78 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = " = new jxl.write.";
  protected final String TEXT_82 = "(";
  protected final String TEXT_83 = ", startRowNum_";
  protected final String TEXT_84 = " + nb_line_";
  protected final String TEXT_85 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = NL + "//modif end";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ", cell_format_";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = ")";
  protected final String TEXT_94 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ".toString()";
  protected final String TEXT_97 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = ")).toString()";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_102 = "), ";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = "), ";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_110 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_111 = ").doubleValue()";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ".setCellFormat( existingCell_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_124 = ".addCell(cell_";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = "=currentWith_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = ">10?10:currentWith_";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = ";";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = " = cell_";
  protected final String TEXT_141 = "_";
  protected final String TEXT_142 = ".getContents().trim().length();";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_144 = "[";
  protected final String TEXT_145 = "]=fitWidth_";
  protected final String TEXT_146 = "[";
  protected final String TEXT_147 = "]>currentWith_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = "?fitWidth_";
  protected final String TEXT_150 = "[";
  protected final String TEXT_151 = "]:currentWith_";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = "+2;";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_155 = "_";
  protected final String TEXT_156 = "=";
  protected final String TEXT_157 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_158 = "[";
  protected final String TEXT_159 = "]=fitWidth_";
  protected final String TEXT_160 = "[";
  protected final String TEXT_161 = "]>currentWith_";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = "?fitWidth_";
  protected final String TEXT_164 = "[";
  protected final String TEXT_165 = "]:currentWith_";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = "+2;";
  protected final String TEXT_168 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t                log4jSb_";
  protected final String TEXT_171 = ".append(";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = ");" + NL + "\t                ";
  protected final String TEXT_174 = NL + "\t                \tlog4jSb_";
  protected final String TEXT_175 = ".append(\"|\");" + NL + "\t                ";
  protected final String TEXT_176 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_177 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_179 = ".addRow();";
  protected final String TEXT_180 = NL + "   \t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_181 = ".putValue_";
  protected final String TEXT_182 = "(";
  protected final String TEXT_183 = ",xlsxTool_";
  protected final String TEXT_184 = ");";
  protected final String TEXT_185 = NL + "\t\t\t\t";
  protected final String TEXT_186 = "\t\t\t\t\t";
  protected final String TEXT_187 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_191 = ".addCellValue(";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = ", ";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_196 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = ")).toString());";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_201 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_202 = "), ";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_206 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = "), ";
  protected final String TEXT_209 = ", ";
  protected final String TEXT_210 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_211 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_212 = ".addCellValue((";
  protected final String TEXT_213 = ").doubleValue());";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_215 = ".addCellValue(";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_219 = ".addCellValue(";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_223 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ")));";
  protected final String TEXT_226 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_227 = ".addCellValue(String.valueOf(";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = "));";
  protected final String TEXT_230 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_231 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\t";
  protected final String TEXT_233 = NL + "\t                log4jSb_";
  protected final String TEXT_234 = ".append(";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = ");" + NL + "\t                ";
  protected final String TEXT_237 = NL + "\t                \tlog4jSb_";
  protected final String TEXT_238 = ".append(\"|\");" + NL + "\t                ";
  protected final String TEXT_239 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_240 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\tbufferCount_";
  protected final String TEXT_242 = "++;" + NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_243 = " >= flushRowNum_";
  protected final String TEXT_244 = "){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_245 = ".flushRowInMemory();" + NL + "    \t\t\t\t\tbufferCount_";
  protected final String TEXT_246 = "=0;" + NL + "    \t\t\t\t}";

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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
String font = ElementParameterParser.getValue(node, "__FONT__"); 
//modif start
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
//modif end
boolean keepCellFormating =  ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__").equals("true");
boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		if(!version07){//version judgement
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
    					}
    					continue;
    				}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_59);
    
    				} 
    				
    stringBuffer.append(TEXT_60);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
   				
    stringBuffer.append(TEXT_61);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_62);
    if(keepCellFormating){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_93);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_100);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_104);
     } else { 
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_109);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_111);
    
					}else {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_115);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
							}
							
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
					if(isNumber){

    stringBuffer.append(TEXT_127);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
					}else{

    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
					}else{

    stringBuffer.append(TEXT_154);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_168);
    
    				} 
    			
    stringBuffer.append(TEXT_169);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    if(i < sizeColumns-1){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
				}
    
				}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    log4jFileUtil.debugWriteData(node);
    
    		}
    	}
    	}else{ //version judgement /***excel 2007 xlsx*****/

		List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
    					}
    					continue;
	        		}

    stringBuffer.append(TEXT_185);
    stringBuffer.append(TEXT_186);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_187);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_189);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_194);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_199);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_203);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_204);
     } else { 
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_210);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_213);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_217);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_221);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_225);
    
					}else{	

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_229);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
    				} 
    				
    stringBuffer.append(TEXT_232);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    if(i < sizeColumns-1){
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    }
				}
    
    			}
    			
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    log4jFileUtil.debugWriteData(node);
    
				if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
				}
    		}
    	}

    	}
    }
}

    return stringBuffer.toString();
  }
}
