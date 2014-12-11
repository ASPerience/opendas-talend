package org.talend.designer.codegen.translators.file.input_deprecated_;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputEBCDICBeginJava
{
  protected static String nl;
  public static synchronized TFileInputEBCDICBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputEBCDICBeginJava result = new TFileInputEBCDICBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "   int nb_line_";
  protected final String TEXT_30 = " = 0;";
  protected final String TEXT_31 = NL + "\t// open file" + NL + "\tjavax.xml.bind.JAXBContext jaxbContext_";
  protected final String TEXT_32 = " = javax.xml.bind.JAXBContext.newInstance(\"net.sf.cobol2j\");" + NL + "\tjavax.xml.bind.Unmarshaller unmarshaller_";
  protected final String TEXT_33 = " = jaxbContext_";
  protected final String TEXT_34 = ".createUnmarshaller();" + NL + "\tObject o_";
  protected final String TEXT_35 = " = unmarshaller_";
  protected final String TEXT_36 = ".unmarshal(new java.io.FileInputStream(";
  protected final String TEXT_37 = "));" + NL + "\tnet.sf.cobol2j.FileFormat fF_";
  protected final String TEXT_38 = " = (net.sf.cobol2j.FileFormat) o_";
  protected final String TEXT_39 = ";" + NL + "\tnet.sf.cobol2j.RecordSet rset_";
  protected final String TEXT_40 = " = new net.sf.cobol2j.RecordSet(new java.io.FileInputStream(";
  protected final String TEXT_41 = "), fF_";
  protected final String TEXT_42 = ");" + NL + "\tjava.util.Map recdefs_";
  protected final String TEXT_43 = " = new net.sf.cobol2j.RecordsMap(fF_";
  protected final String TEXT_44 = ");" + NL + "\t" + NL + "\t// read every record, for each record split into column definition" + NL + "\tList inrecord_";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = NL + "\tclass EBCDICUtil_";
  protected final String TEXT_47 = "{";
  protected final String TEXT_48 = NL + "\t\t\t\tpublic void getValue_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = "(final ";
  protected final String TEXT_51 = "Struct ";
  protected final String TEXT_52 = ",List inrecord_";
  protected final String TEXT_53 = "){";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = (String)inrecord_";
  protected final String TEXT_57 = ".get(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = (";
  protected final String TEXT_62 = ")inrecord_";
  protected final String TEXT_63 = ".get(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\t\t\t}";
  protected final String TEXT_66 = NL + "\t\t\t\t}";
  protected final String TEXT_67 = NL + "\t}" + NL + "\tEBCDICUtil_";
  protected final String TEXT_68 = " ebcdicUtil_";
  protected final String TEXT_69 = "=new EBCDICUtil_";
  protected final String TEXT_70 = "();";
  protected final String TEXT_71 = NL + "    \tlog.info(\"";
  protected final String TEXT_72 = " - Retrieving records from file.\");";
  protected final String TEXT_73 = NL + "\twhile (rset_";
  protected final String TEXT_74 = ".hasNext()){" + NL + "\t\tinrecord_";
  protected final String TEXT_75 = " = rset_";
  protected final String TEXT_76 = ".next();" + NL + "\t\tnb_line_";
  protected final String TEXT_77 = " ++;" + NL + "" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_79 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_80 = " + \".\");" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t\t" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t";
  protected final String TEXT_83 = " = null;\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\tif(inrecord_";
  protected final String TEXT_85 = ".get(0).equals(\"";
  protected final String TEXT_86 = "\") || recdefs_";
  protected final String TEXT_87 = ".size() == 1 ){" + NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_88 = " = new ";
  protected final String TEXT_89 = "Struct();";
  protected final String TEXT_90 = "\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = (String)inrecord_";
  protected final String TEXT_93 = ".get(";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = (";
  protected final String TEXT_98 = ")inrecord_";
  protected final String TEXT_99 = ".get(";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\tebcdicUtil_";
  protected final String TEXT_102 = ".getValue_";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = "(";
  protected final String TEXT_105 = ",inrecord_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = "\t" + NL + "\t\t\t}\t";
  protected final String TEXT_108 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_109 = " should be bigger than 0" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_110 = NL + "\t\t\tjava.io.FileInputStream fs_";
  protected final String TEXT_111 = " = new java.io.FileInputStream(";
  protected final String TEXT_112 = ");" + NL + "\t\t\tbyte[] bb_row_";
  protected final String TEXT_113 = " = new byte[";
  protected final String TEXT_114 = "];" + NL + "\t\t\tjava.nio.ByteBuffer bbRecord_";
  protected final String TEXT_115 = " = null;" + NL + "\t\t\tint iReadOffset_";
  protected final String TEXT_116 = " = 0;";
  protected final String TEXT_117 = NL + "\t\t\t\t\tclass EBCDICUtil_";
  protected final String TEXT_118 = "{";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\tpublic void getValue_";
  protected final String TEXT_120 = "(final ";
  protected final String TEXT_121 = "Struct ";
  protected final String TEXT_122 = ",java.nio.ByteBuffer bbRecord_";
  protected final String TEXT_123 = ") throws java.lang.Exception{";
  protected final String TEXT_124 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_125 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = " = new byte[";
  protected final String TEXT_129 = "];" + NL + "\t\t\t\t\t\t\tbbRecord_";
  protected final String TEXT_130 = ".get(bb_";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = new String(bb_";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = ",";
  protected final String TEXT_138 = ")";
  protected final String TEXT_139 = ";";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ",";
  protected final String TEXT_155 = ",";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_160 = "_";
  protected final String TEXT_161 = ",";
  protected final String TEXT_162 = ",";
  protected final String TEXT_163 = ",";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_168 = "_";
  protected final String TEXT_169 = "),0);";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = " = bb_";
  protected final String TEXT_173 = "_";
  protected final String TEXT_174 = ";";
  protected final String TEXT_175 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_176 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tEBCDICUtil_";
  protected final String TEXT_180 = " ebcdicUtil_";
  protected final String TEXT_181 = "=new EBCDICUtil_";
  protected final String TEXT_182 = "();";
  protected final String TEXT_183 = NL + "\t\t    ";
  protected final String TEXT_184 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_185 = " - Retrieving records from file.\");" + NL + "\t\t    ";
  protected final String TEXT_186 = NL + "\t\t\twhile((iReadOffset_";
  protected final String TEXT_187 = " = fs_";
  protected final String TEXT_188 = ".read(bb_row_";
  protected final String TEXT_189 = "))!= -1){" + NL + "\t\t\t\tbbRecord_";
  protected final String TEXT_190 = " = java.nio.ByteBuffer.wrap(bb_row_";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_193 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_195 = "_";
  protected final String TEXT_196 = " = new byte[";
  protected final String TEXT_197 = "];" + NL + "\t\t\t\t\t\t\tbbRecord_";
  protected final String TEXT_198 = ".get(bb_";
  protected final String TEXT_199 = "_";
  protected final String TEXT_200 = ");";
  protected final String TEXT_201 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = new String(bb_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ",";
  protected final String TEXT_206 = ")";
  protected final String TEXT_207 = ";";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = ",";
  protected final String TEXT_223 = ",";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_228 = "_";
  protected final String TEXT_229 = ",";
  protected final String TEXT_230 = ",";
  protected final String TEXT_231 = ",";
  protected final String TEXT_232 = ");";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = "),0);";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " = bb_";
  protected final String TEXT_241 = "_";
  protected final String TEXT_242 = ";";
  protected final String TEXT_243 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_244 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t\tebcdicUtil_";
  protected final String TEXT_246 = ".getValue_";
  protected final String TEXT_247 = "(";
  protected final String TEXT_248 = ",bbRecord_";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "\t\t\t\tbbRecord_";
  protected final String TEXT_251 = ".clear();";
  protected final String TEXT_252 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String cid = node.getUniqueName();
    
	String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	String copybook = ElementParameterParser.getValue(node,"__COPYBOOK__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
	List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
	String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
	boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
	boolean isOptimizeCode=false;

    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    
if(!customSetOriginalLength){//------11111

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
    stringBuffer.append( copybook );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( filename );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
		for(Map<String, String> schemaMap : schemas) {
			String schemaName = schemaMap.get("SCHEMA");
			if(conns != null && conns.size() > 0){
				for(IConnection conn : conns){
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
						if(schemaName.equals(conn.getMetadataTable().getLabel())){
							IMetadataTable justMetadata = conn.getMetadataTable();
							List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
							if(schemaOptNum<justColumnList.size()){
								isOptimizeCode=true;
							}
							break;
						}
					}
				}
			}
			if(isOptimizeCode){
				break;
			}
		}
	if(isOptimizeCode){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	
	for(Map<String, String> schemaMap : schemas) {//------AAA0
		String schemaName = schemaMap.get("SCHEMA");
		IConnection justConn = null; //------->get the right output connection--->to get the columns info
		if(conns != null && conns.size() > 0){
			for(IConnection conn : conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
					if(schemaName.equals(conn.getMetadataTable().getLabel())){
						justConn = conn;
						break;
					}
				}
			}
		}

		if(justConn != null){//------BBB0
			IMetadataTable justMetadata = justConn.getMetadataTable();
			List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
			int sizeListColumns = justColumnList.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = justColumnList.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
					}
					if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_58);
    
					}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(javaType.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_64);
    
					}
				    if((valueN+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_65);
    
					}
				}
				if(sizeListColumns>0&&(sizeListColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_66);
    
				}
		}
	}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    

    		if (conns!=null && conns.size()>0) {
				for (int i=0;i<conns.size();i++) {
					IConnection connTemp = conns.get(i);
					if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_83);
    
					}
				}
    		}
    		
	for(Map<String, String> schemaMap : schemas) {//------AAA0
		String schemaName = schemaMap.get("SCHEMA");
		String code = schemaMap.get("CODE");
	
		IConnection justConn = null; //------->get the right output connection--->to get the columns info
		if(conns != null && conns.size() > 0){
			for(IConnection conn : conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
					if(schemaName.equals(conn.getMetadataTable().getLabel())){
						justConn = conn;
						break;
					}
				}
			}
		}

		if(justConn != null){//------BBB0
		IMetadataTable justMetadata = justConn.getMetadataTable();
		List<IMetadataColumn> justColumnList = justMetadata.getListColumns();

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_89);
    
				int sizeListColumns = justColumnList.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = justColumnList.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(!isOptimizeCode){
						if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_94);
    
						}else {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(javaType.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_100);
    
						}
					}else{
						if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
						}
					}
				}

    stringBuffer.append(TEXT_107);
    
		}//------BBB0
	}//------AAA0
}else{//------11111
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns!=null && conns.size()>0){//------conns
		IConnection conn = conns.get(0);
			int totalRealSize = 0;
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//--------AAA00
				IMetadataTable justMetadata = conn.getMetadataTable();
				List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
				int sizeListColumns = justColumnList.size();
				if(schemaOptNum < sizeListColumns){
					isOptimizeCode=true;
				}
				for (int valueN=0; valueN<sizeListColumns; valueN++) {//------BBB00
					IMetadataColumn column = justColumnList.get(valueN);
					Integer orgainLength  = column.getOriginalLength();
					if(orgainLength==null || orgainLength.intValue()==0) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    
						break;
					}
					totalRealSize = totalRealSize + orgainLength.intValue();
				}//------BBB00
			}//--------AAA00

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(totalRealSize );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
			if(isOptimizeCode){//------B01
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//------B02
					IMetadataTable justMetadata = conn.getMetadataTable();
					List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
					int sizeListColumns = justColumnList.size();
					if(sizeListColumns>0){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
						for (int valueN=0; valueN<sizeListColumns; valueN++) {//------B02
							IMetadataColumn column = justColumnList.get(valueN);
							Integer orgainLength = column.getOriginalLength();
							String orgainType = column.getType();
							Integer precision = column.getPrecision();
							if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
							}
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    
								continue;
							}

    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_138);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_139);
    
							}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
							}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_156);
    
								}else{

    stringBuffer.append(TEXT_157);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_164);
    
								}
							}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
							}else {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_176);
    
							}
				    		if((valueN+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_177);
    
							}
						}//------B02
						if(sizeListColumns>0&&(sizeListColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_178);
    
						}

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
					}
				}//------B02
			}//------B01

    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//------BBB1
					IMetadataTable justMetadata = conn.getMetadataTable();
					List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
					int sizeListColumns = justColumnList.size();
					for (int valueN=0; valueN<sizeListColumns; valueN++) {//------BBB12
						IMetadataColumn column = justColumnList.get(valueN);
						Integer orgainLength = column.getOriginalLength();
						String orgainType = column.getType();
						Integer precision = column.getPrecision();
						if(!isOptimizeCode){
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_193);
    
								continue;
							}

    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_201);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_206);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_207);
    
							}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
							}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_213);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_218);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_224);
    
								}else{

    stringBuffer.append(TEXT_225);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_232);
    
								}
							}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
							}else {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    
							}
						}else{
							if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    
							}
						}
					}//------BBB12
			}//------BBB1

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
	}//------conns
}//------11111

    stringBuffer.append(TEXT_252);
    return stringBuffer.toString();
  }
}
