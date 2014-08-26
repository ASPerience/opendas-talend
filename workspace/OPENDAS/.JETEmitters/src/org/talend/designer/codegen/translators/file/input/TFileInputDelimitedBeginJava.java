package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileInputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedBeginJava result = new TFileInputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if(isFirstCheckDyn_";
  protected final String TEXT_2 = "){// for the header line";
  protected final String TEXT_3 = NL + "int colsLen_";
  protected final String TEXT_4 = " = row";
  protected final String TEXT_5 = ".length;";
  protected final String TEXT_6 = NL + "int colsLen_";
  protected final String TEXT_7 = " = fid_";
  protected final String TEXT_8 = ".getColumnsCountOfCurrentRow();";
  protected final String TEXT_9 = NL + "    for (int i = ";
  protected final String TEXT_10 = "-1; i < colsLen_";
  protected final String TEXT_11 = "; i++) {" + NL + "    " + NL + "    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_12 = " = new routines.system.DynamicMetadata();" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_13 = ".setName(";
  protected final String TEXT_14 = "row";
  protected final String TEXT_15 = "[i]";
  protected final String TEXT_16 = "fid_";
  protected final String TEXT_17 = ".get(i)";
  protected final String TEXT_18 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_19 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_20 = ".getName());" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_21 = ".setType(\"id_String\");" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_22 = ".setDbType(\"VARCHAR\");" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_23 = ".setLength(100);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_24 = ".setPrecision(0);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_25 = ".setNullable(true);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_26 = ".setKey(false);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_27 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.demilitedFile);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_28 = ".setColumnPosition(i);" + NL + "    \tdynamic_";
  protected final String TEXT_29 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_30 = ");" + NL + "    }" + NL + "    isFirstCheckDyn_";
  protected final String TEXT_31 = " = false;" + NL + "    continue;" + NL + "}";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL + "boolean isFirstCheckDyn_";
  protected final String TEXT_34 = " = true;" + NL + "routines.system.Dynamic dynamic_";
  protected final String TEXT_35 = " = new routines.system.Dynamic();";
  protected final String TEXT_36 = NL + "int nb_line_";
  protected final String TEXT_37 = " = 0;" + NL + "org.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_38 = " = null;" + NL + "try{";
  protected final String TEXT_39 = NL + NL + "Object filename_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";\t" + NL + "java.util.zip.ZipInputStream zis_";
  protected final String TEXT_42 = " = null;" + NL + "if(filename_";
  protected final String TEXT_43 = " instanceof java.io.InputStream){" + NL + "\tzis_";
  protected final String TEXT_44 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_45 = "));" + NL + "}else{" + NL + "\tzis_";
  protected final String TEXT_46 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(filename_";
  protected final String TEXT_47 = ".toString())));" + NL + "}" + NL + "java.util.zip.ZipEntry entry_";
  protected final String TEXT_48 = " = null;" + NL + "" + NL + "while ((entry_";
  protected final String TEXT_49 = " = zis_";
  protected final String TEXT_50 = ".getNextEntry()) != null) {" + NL + "\tif(entry_";
  protected final String TEXT_51 = ".isDirectory()){ //directory" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tfid_";
  protected final String TEXT_52 = " = new org.talend.fileprocess.FileInputDelimited(zis_";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ",";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "fid_";
  protected final String TEXT_64 = " = " + NL + "\tnew org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ",";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ",";
  protected final String TEXT_69 = ",";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "while (fid_";
  protected final String TEXT_76 = ".nextRecord()) {";
  protected final String TEXT_77 = NL + "    \t\t";
  protected final String TEXT_78 = " = null;\t\t\t";
  protected final String TEXT_79 = "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_80 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_81 = " = new ";
  protected final String TEXT_82 = "Struct();" + NL + "\t\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_83 = "String temp_";
  protected final String TEXT_84 = " = \"\"; " + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "temp_";
  protected final String TEXT_86 = "  = fid_";
  protected final String TEXT_87 = ".get(";
  protected final String TEXT_88 = ")";
  protected final String TEXT_89 = ";" + NL + "if(temp_";
  protected final String TEXT_90 = ".length() > 0){" + NL + "\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = temp_";
  protected final String TEXT_93 = ";" + NL + "}else{" + NL + "\t";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ";" + NL + "}";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = fid_";
  protected final String TEXT_100 = ".get(";
  protected final String TEXT_101 = ")";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "dynamic_";
  protected final String TEXT_104 = ".clearColumnValues();" + NL + "int fieldCount = fid_";
  protected final String TEXT_105 = ".getColumnsCountOfCurrentRow();" + NL + "for (int i = 0; i < dynamic_";
  protected final String TEXT_106 = ".getColumnCount(); i++) {" + NL + "\tif ((";
  protected final String TEXT_107 = "-1+i) < fieldCount){" + NL + "\t\tdynamic_";
  protected final String TEXT_108 = ".addColumnValue(fid_";
  protected final String TEXT_109 = ".get(";
  protected final String TEXT_110 = "-1+i)";
  protected final String TEXT_111 = ");" + NL + "\t}" + NL + "\telse{" + NL + "\t\tdynamic_";
  protected final String TEXT_112 = ".addColumnValue(\"\");" + NL + "\t}" + NL + "}";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "=dynamic_";
  protected final String TEXT_116 = ";";
  protected final String TEXT_117 = "temp_";
  protected final String TEXT_118 = " = fid_";
  protected final String TEXT_119 = ".get(";
  protected final String TEXT_120 = ")";
  protected final String TEXT_121 = ";" + NL + "if(temp_";
  protected final String TEXT_122 = ".length() > 0) {";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = temp_";
  protected final String TEXT_125 = ".getBytes(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ", false);";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = ParserUtils.parseTo_";
  protected final String TEXT_137 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_138 = ", ";
  protected final String TEXT_139 = ", ";
  protected final String TEXT_140 = "));";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ParserUtils.parseTo_";
  protected final String TEXT_143 = "(temp_";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = "} else {\t\t\t\t\t\t";
  protected final String TEXT_146 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_147 = "' in '";
  protected final String TEXT_148 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = ";";
  protected final String TEXT_152 = "}";
  protected final String TEXT_153 = NL + "\t\t\t\t";
  protected final String TEXT_154 = NL + "\t int filedsum_";
  protected final String TEXT_155 = " = fid_";
  protected final String TEXT_156 = ".getColumnsCountOfCurrentRow();" + NL + "\t if(filedsum_";
  protected final String TEXT_157 = " < ";
  protected final String TEXT_158 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_159 = " > ";
  protected final String TEXT_160 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }     ";
  protected final String TEXT_161 = "\t\t\t\t" + NL;
  protected final String TEXT_162 = " ";
  protected final String TEXT_163 = " = null; ";
  protected final String TEXT_164 = NL + "\t\t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_165 = " = true;";
  protected final String TEXT_166 = NL + "            throw(e);";
  protected final String TEXT_167 = "                    ";
  protected final String TEXT_168 = NL + "                    ";
  protected final String TEXT_169 = " = new ";
  protected final String TEXT_170 = "Struct();";
  protected final String TEXT_171 = NL + "                    ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ";";
  protected final String TEXT_176 = NL + "                ";
  protected final String TEXT_177 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_178 = ";";
  protected final String TEXT_179 = NL + "                ";
  protected final String TEXT_180 = " = null;";
  protected final String TEXT_181 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_182 = NL + "                ";
  protected final String TEXT_183 = " = null;";
  protected final String TEXT_184 = NL + "            \t";
  protected final String TEXT_185 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_186 = ";";
  protected final String TEXT_187 = NL + "    }" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t";
  protected final String TEXT_189 = "if(!whetherReject_";
  protected final String TEXT_190 = ") { ";
  protected final String TEXT_191 = "      " + NL + "             if(";
  protected final String TEXT_192 = " == null){ " + NL + "            \t ";
  protected final String TEXT_193 = " = new ";
  protected final String TEXT_194 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_195 = NL + "\t    \t ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ";    \t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t";
  protected final String TEXT_201 = " } ";
  protected final String TEXT_202 = "\t";
  protected final String TEXT_203 = NL;
  protected final String TEXT_204 = NL;
  protected final String TEXT_205 = NL + "boolean isFirstCheckDyn_";
  protected final String TEXT_206 = " = true;" + NL + "routines.system.Dynamic dynamic_";
  protected final String TEXT_207 = " = new routines.system.Dynamic();";
  protected final String TEXT_208 = NL + "\t\tint nb_line_";
  protected final String TEXT_209 = " = 0;" + NL + "\t\tint footer_";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";" + NL + "\t\tint totalLine";
  protected final String TEXT_212 = " = 0;" + NL + "\t\tint limit";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = ";" + NL + "\t\tint lastLine";
  protected final String TEXT_215 = " = -1;\t" + NL + "\t\t" + NL + "\t\tchar fieldSeparator_";
  protected final String TEXT_216 = "[] = null;" + NL + "\t\t" + NL + "\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\tif ( ((String)";
  protected final String TEXT_217 = ").length() > 0 ){" + NL + "\t\t\tfieldSeparator_";
  protected final String TEXT_218 = " = ((String)";
  protected final String TEXT_219 = ").toCharArray();" + NL + "\t\t}else {\t\t\t" + NL + "\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tchar rowSeparator_";
  protected final String TEXT_220 = "[] = null;" + NL + "\t\t" + NL + "\t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'. " + NL + "\t\tif ( ((String)";
  protected final String TEXT_221 = ").length() > 0 ){" + NL + "\t\t\trowSeparator_";
  protected final String TEXT_222 = " = ((String)";
  protected final String TEXT_223 = ").toCharArray();" + NL + "\t\t}else {" + NL + "\t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\"); " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tObject filename_";
  protected final String TEXT_224 = " = ";
  protected final String TEXT_225 = ";\t\t" + NL + "\t\tcom.csvreader.CsvReader csvReader";
  protected final String TEXT_226 = " = null;" + NL + "" + NL + "\t\ttry{";
  protected final String TEXT_227 = NL + "        java.util.zip.ZipInputStream zis_";
  protected final String TEXT_228 = " = null;" + NL + "        if(filename_";
  protected final String TEXT_229 = " instanceof java.io.InputStream){" + NL + "        \tzis_";
  protected final String TEXT_230 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_231 = "));" + NL + "        }else{" + NL + "        \tzis_";
  protected final String TEXT_232 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(filename_";
  protected final String TEXT_233 = ".toString())));" + NL + "        }" + NL + "        java.util.zip.ZipEntry entry_";
  protected final String TEXT_234 = " = null;" + NL + "        " + NL + "        while ((entry_";
  protected final String TEXT_235 = " = zis_";
  protected final String TEXT_236 = ".getNextEntry()) != null) {" + NL + "        \tif(entry_";
  protected final String TEXT_237 = ".isDirectory()){ //directory" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tcsvReader";
  protected final String TEXT_238 = "=new com.csvreader.CsvReader(zis_";
  protected final String TEXT_239 = ", fieldSeparator_";
  protected final String TEXT_240 = "[0], java.nio.charset.Charset.forName(";
  protected final String TEXT_241 = "));";
  protected final String TEXT_242 = NL + "\t\tif(filename_";
  protected final String TEXT_243 = " instanceof java.io.InputStream){" + NL + "\t\t\tcsvReader";
  protected final String TEXT_244 = "=new com.csvreader.CsvReader((java.io.InputStream)filename_";
  protected final String TEXT_245 = ", fieldSeparator_";
  protected final String TEXT_246 = "[0], java.nio.charset.Charset.forName(";
  protected final String TEXT_247 = "));" + NL + "\t\t}else{" + NL + "\t\t\tcsvReader";
  protected final String TEXT_248 = "=new com.csvreader.CsvReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "                \tnew java.io.FileInputStream(filename_";
  protected final String TEXT_249 = ".toString()),";
  protected final String TEXT_250 = ")), fieldSeparator_";
  protected final String TEXT_251 = "[0]);" + NL + "        }";
  protected final String TEXT_252 = NL + "\t\tif ( (rowSeparator_";
  protected final String TEXT_253 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_254 = "[0] != '\\r') )" + NL + "        \tcsvReader";
  protected final String TEXT_255 = ".setRecordDelimiter(rowSeparator_";
  protected final String TEXT_256 = "[0]);" + NL + "        \t";
  protected final String TEXT_257 = NL + "        csvReader";
  protected final String TEXT_258 = ".setTextQualifier('";
  protected final String TEXT_259 = "');";
  protected final String TEXT_260 = NL + "\t\tString textEnclosure1_";
  protected final String TEXT_261 = " = ";
  protected final String TEXT_262 = "; " + NL + "\t\tchar textEnclosure_";
  protected final String TEXT_263 = "[] = null;" + NL + "        " + NL + "        if(((String)textEnclosure1_";
  protected final String TEXT_264 = ").length() > 0 ){ " + NL + "  \t\t\ttextEnclosure_";
  protected final String TEXT_265 = " = ((String)textEnclosure1_";
  protected final String TEXT_266 = ").toCharArray(); " + NL + "\t\t}else { " + NL + "            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        }" + NL + "\t\tcsvReader";
  protected final String TEXT_267 = ".setTextQualifier(textEnclosure_";
  protected final String TEXT_268 = "[0]); ";
  protected final String TEXT_269 = NL + "            csvReader";
  protected final String TEXT_270 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);";
  protected final String TEXT_271 = NL + "            csvReader";
  protected final String TEXT_272 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);";
  protected final String TEXT_273 = NL + "            //?????doesn't work for other escapeChar";
  protected final String TEXT_274 = " " + NL + "        String escapeChar1_";
  protected final String TEXT_275 = " = ";
  protected final String TEXT_276 = ";          " + NL + "        char escapeChar_";
  protected final String TEXT_277 = "[] = null;" + NL + "        " + NL + "        if(((String)escapeChar1_";
  protected final String TEXT_278 = ").length() > 0 ){ " + NL + "        \tescapeChar_";
  protected final String TEXT_279 = " = ((String)escapeChar1_";
  protected final String TEXT_280 = ").toCharArray(); " + NL + "  \t\t}else { " + NL + "            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        }" + NL + "       \tif(escapeChar_";
  protected final String TEXT_281 = "[0] == '\\\\'){" + NL + "       \t\tcsvReader";
  protected final String TEXT_282 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);" + NL + "       \t}else if(escapeChar_";
  protected final String TEXT_283 = "[0] ==";
  protected final String TEXT_284 = NL + "       \t'";
  protected final String TEXT_285 = "'";
  protected final String TEXT_286 = "textEnclosure_";
  protected final String TEXT_287 = "[0]";
  protected final String TEXT_288 = "){" + NL + "       \t\tcsvReader";
  protected final String TEXT_289 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);" + NL + "       \t}";
  protected final String TEXT_290 = "      " + NL + "\t" + NL + "\t\tString[] row";
  protected final String TEXT_291 = "=null;" + NL + "\t\t" + NL + "\t\tif(footer_";
  protected final String TEXT_292 = " > 0){" + NL + "\t\t\tfor(totalLine";
  protected final String TEXT_293 = "=0;totalLine";
  protected final String TEXT_294 = " < ";
  protected final String TEXT_295 = "; totalLine";
  protected final String TEXT_296 = "++){" + NL + "\t\t\t\tcsvReader";
  protected final String TEXT_297 = ".readRecord();" + NL + "\t\t\t}" + NL + "\t\t\tcsvReader";
  protected final String TEXT_298 = ".setSkipEmptyRecords(";
  protected final String TEXT_299 = ");" + NL + "            while (csvReader";
  protected final String TEXT_300 = ".readRecord()) {";
  protected final String TEXT_301 = NL + "\t\t\t\trow";
  protected final String TEXT_302 = "=csvReader";
  protected final String TEXT_303 = ".getValues();" + NL + "\t\t\t\tif(!(row";
  protected final String TEXT_304 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_305 = "[0]))){//empty line when row separator is '\\n'";
  protected final String TEXT_306 = NL + "                " + NL + "                \ttotalLine";
  protected final String TEXT_307 = "++;" + NL + "                ";
  protected final String TEXT_308 = NL + "\t\t\t\t}";
  protected final String TEXT_309 = NL + "                " + NL + "            }" + NL + "            int lastLineTemp";
  protected final String TEXT_310 = " = totalLine";
  protected final String TEXT_311 = " - footer_";
  protected final String TEXT_312 = "   < 0? 0 : totalLine";
  protected final String TEXT_313 = " - footer_";
  protected final String TEXT_314 = " ;" + NL + "            if(lastLine";
  protected final String TEXT_315 = " > 0){" + NL + "                lastLine";
  protected final String TEXT_316 = " = lastLine";
  protected final String TEXT_317 = " < lastLineTemp";
  protected final String TEXT_318 = " ? lastLine";
  protected final String TEXT_319 = " : lastLineTemp";
  protected final String TEXT_320 = "; " + NL + "            }else {" + NL + "                lastLine";
  protected final String TEXT_321 = " = lastLineTemp";
  protected final String TEXT_322 = ";" + NL + "            }" + NL + "         " + NL + "          \tcsvReader";
  protected final String TEXT_323 = ".close();" + NL + "          \t" + NL + "        if(filename_";
  protected final String TEXT_324 = " instanceof java.io.InputStream){" + NL + "\t\t \tcsvReader";
  protected final String TEXT_325 = "=new com.csvreader.CsvReader((java.io.InputStream)filename_";
  protected final String TEXT_326 = ", fieldSeparator_";
  protected final String TEXT_327 = "[0], java.nio.charset.Charset.forName(";
  protected final String TEXT_328 = "));" + NL + "        }else{" + NL + "\t\t \tcsvReader";
  protected final String TEXT_329 = "=new com.csvreader.CsvReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t          new java.io.FileInputStream(filename_";
  protected final String TEXT_330 = ".toString()),";
  protected final String TEXT_331 = ")), fieldSeparator_";
  protected final String TEXT_332 = "[0]);" + NL + "\t\t}" + NL + "\t          " + NL + "\t\tif ( (rowSeparator_";
  protected final String TEXT_333 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_334 = "[0] != '\\r') )\t" + NL + "        \tcsvReader";
  protected final String TEXT_335 = ".setRecordDelimiter(rowSeparator_";
  protected final String TEXT_336 = "[0]);";
  protected final String TEXT_337 = NL + "\t\tcsvReader";
  protected final String TEXT_338 = ".setTextQualifier('";
  protected final String TEXT_339 = "');";
  protected final String TEXT_340 = NL + "\t\tcsvReader";
  protected final String TEXT_341 = ".setTextQualifier(textEnclosure_";
  protected final String TEXT_342 = "[0]);";
  protected final String TEXT_343 = NL + "        csvReader";
  protected final String TEXT_344 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);";
  protected final String TEXT_345 = NL + "        csvReader";
  protected final String TEXT_346 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);";
  protected final String TEXT_347 = NL + "        //?????doesn't work for other escapeChar";
  protected final String TEXT_348 = " " + NL + "       \tif(escapeChar_";
  protected final String TEXT_349 = "[0] == '\\\\'){" + NL + "       \t\tcsvReader";
  protected final String TEXT_350 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);" + NL + "       \t}else if(escapeChar_";
  protected final String TEXT_351 = "[0] == ";
  protected final String TEXT_352 = NL + "       \t'";
  protected final String TEXT_353 = "'";
  protected final String TEXT_354 = "textEnclosure_";
  protected final String TEXT_355 = "[0]";
  protected final String TEXT_356 = "){" + NL + "       \t\tcsvReader";
  protected final String TEXT_357 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);" + NL + "       \t}";
  protected final String TEXT_358 = "  " + NL + "          " + NL + "        }" + NL + "        " + NL + "        " + NL + "        " + NL + "        int currentLine";
  protected final String TEXT_359 = " = 0;" + NL + "        int outputLine";
  protected final String TEXT_360 = " = 0;" + NL + "        " + NL + "        if(limit";
  protected final String TEXT_361 = " != 0){" + NL + "        \tfor(currentLine";
  protected final String TEXT_362 = "=0;currentLine";
  protected final String TEXT_363 = " < ";
  protected final String TEXT_364 = ";currentLine";
  protected final String TEXT_365 = "++){" + NL + "        \t\tcsvReader";
  protected final String TEXT_366 = ".readRecord();" + NL + "        \t}" + NL + "        }" + NL + "        csvReader";
  protected final String TEXT_367 = ".setSkipEmptyRecords(";
  protected final String TEXT_368 = ");" + NL + "        while ( limit";
  protected final String TEXT_369 = " != 0 && csvReader";
  protected final String TEXT_370 = ".readRecord() ) { " + NL + "        " + NL + "        \trow";
  protected final String TEXT_371 = "=csvReader";
  protected final String TEXT_372 = ".getValues();" + NL + "        \t";
  protected final String TEXT_373 = NL + "        \tif(row";
  protected final String TEXT_374 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_375 = "[0])){//empty line when row separator is '\\n'" + NL + "        \t\tcontinue;" + NL + "        \t}";
  protected final String TEXT_376 = NL + "        \t" + NL + "        \t" + NL + "        \tcurrentLine";
  protected final String TEXT_377 = "++;" + NL + "            " + NL + "            if(lastLine";
  protected final String TEXT_378 = " > -1 && currentLine";
  protected final String TEXT_379 = " > lastLine";
  protected final String TEXT_380 = ") {" + NL + "                break;" + NL + "            }" + NL + "            outputLine";
  protected final String TEXT_381 = "++;" + NL + "            if (limit";
  protected final String TEXT_382 = " > 0 && outputLine";
  protected final String TEXT_383 = " > limit";
  protected final String TEXT_384 = ") {" + NL + "                break;" + NL + "            }  " + NL + "                                                                      ";
  protected final String TEXT_385 = NL + "    \t\t";
  protected final String TEXT_386 = " = null;\t\t\t";
  protected final String TEXT_387 = NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_388 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_389 = " = new ";
  protected final String TEXT_390 = "Struct();" + NL + "\t\t\ttry {\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_391 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\tif(row";
  protected final String TEXT_392 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_393 = "[0])){//empty line when row separator is '\\n'" + NL + "\t\t\t\t";
  protected final String TEXT_394 = NL + NL + "\t\t\t\t";
  protected final String TEXT_395 = ".";
  protected final String TEXT_396 = " = ";
  protected final String TEXT_397 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t" + NL + "\t\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\tString temp_";
  protected final String TEXT_400 = " = \"\";";
  protected final String TEXT_401 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_402 = " < row";
  protected final String TEXT_403 = ".length){\t\t\t\t";
  protected final String TEXT_404 = NL + "\t\t\t\t\ttemp_";
  protected final String TEXT_405 = " = row";
  protected final String TEXT_406 = "[";
  protected final String TEXT_407 = "]";
  protected final String TEXT_408 = ";" + NL + "\t\t\t\t\tif(temp_";
  protected final String TEXT_409 = ".length() > 0){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_410 = ".";
  protected final String TEXT_411 = " = temp_";
  protected final String TEXT_412 = ";" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = " = ";
  protected final String TEXT_415 = ";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_416 = NL + "\t\t\t\t\t";
  protected final String TEXT_417 = ".";
  protected final String TEXT_418 = " = row";
  protected final String TEXT_419 = "[";
  protected final String TEXT_420 = "]";
  protected final String TEXT_421 = ";";
  protected final String TEXT_422 = NL + "\t\t\t\t\t\tif(row";
  protected final String TEXT_423 = "[";
  protected final String TEXT_424 = "].length() > 0) {" + NL + "\t";
  protected final String TEXT_425 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_426 = ".";
  protected final String TEXT_427 = " = ParserUtils.parseTo_Date(row";
  protected final String TEXT_428 = "[";
  protected final String TEXT_429 = "]";
  protected final String TEXT_430 = ", ";
  protected final String TEXT_431 = ", false);" + NL + "\t";
  protected final String TEXT_432 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_433 = ".";
  protected final String TEXT_434 = " = ParserUtils.parseTo_Date(row";
  protected final String TEXT_435 = "[";
  protected final String TEXT_436 = "]";
  protected final String TEXT_437 = ", ";
  protected final String TEXT_438 = ");" + NL + "\t";
  protected final String TEXT_439 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_440 = ".";
  protected final String TEXT_441 = " = ParserUtils.parseTo_";
  protected final String TEXT_442 = "(ParserUtils.parseTo_Number(row";
  protected final String TEXT_443 = "[";
  protected final String TEXT_444 = "]";
  protected final String TEXT_445 = ", ";
  protected final String TEXT_446 = ", ";
  protected final String TEXT_447 = "));" + NL + "\t";
  protected final String TEXT_448 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_449 = ".";
  protected final String TEXT_450 = " = row";
  protected final String TEXT_451 = "[";
  protected final String TEXT_452 = "]";
  protected final String TEXT_453 = ".getBytes(";
  protected final String TEXT_454 = ");" + NL + "\t";
  protected final String TEXT_455 = NL + "for (int i = 0; i < dynamic_";
  protected final String TEXT_456 = ".getColumnCount(); i++) {" + NL + "\tdynamic_";
  protected final String TEXT_457 = ".clearColumnValues();" + NL + "}" + NL + "int fieldCount = row";
  protected final String TEXT_458 = ".length;" + NL + "for (int i = 0; i < dynamic_";
  protected final String TEXT_459 = ".getColumnCount(); i++) {" + NL + "\tif ((";
  protected final String TEXT_460 = "-1+i) < fieldCount)" + NL + "\t\tdynamic_";
  protected final String TEXT_461 = ".addColumnValue(row";
  protected final String TEXT_462 = "[";
  protected final String TEXT_463 = "-1+i]";
  protected final String TEXT_464 = ");" + NL + "\telse" + NL + "\t\tdynamic_";
  protected final String TEXT_465 = ".addColumnValue(\"\");" + NL + "}";
  protected final String TEXT_466 = NL;
  protected final String TEXT_467 = ".";
  protected final String TEXT_468 = " = dynamic_";
  protected final String TEXT_469 = ";" + NL + "\t";
  protected final String TEXT_470 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = " = ParserUtils.parseTo_";
  protected final String TEXT_473 = "(row";
  protected final String TEXT_474 = "[";
  protected final String TEXT_475 = "]";
  protected final String TEXT_476 = ");" + NL + "\t";
  protected final String TEXT_477 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = " = ";
  protected final String TEXT_480 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_481 = "\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_482 = ".";
  protected final String TEXT_483 = " = ";
  protected final String TEXT_484 = ";" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_485 = NL + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_486 = NL + "\t int filedsum_";
  protected final String TEXT_487 = " = row";
  protected final String TEXT_488 = ".length;" + NL + "\t if(filedsum_";
  protected final String TEXT_489 = " < ";
  protected final String TEXT_490 = "){" + NL + "\t \tthrow new Exception(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_491 = " > ";
  protected final String TEXT_492 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }     ";
  protected final String TEXT_493 = "\t" + NL;
  protected final String TEXT_494 = " ";
  protected final String TEXT_495 = " = null; ";
  protected final String TEXT_496 = NL + "\t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_497 = " = true;";
  protected final String TEXT_498 = NL + "            throw(e);";
  protected final String TEXT_499 = NL + "                    ";
  protected final String TEXT_500 = " = new ";
  protected final String TEXT_501 = "Struct();";
  protected final String TEXT_502 = NL + "                    ";
  protected final String TEXT_503 = ".";
  protected final String TEXT_504 = " = ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = ";";
  protected final String TEXT_507 = NL + "                ";
  protected final String TEXT_508 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_509 = ";";
  protected final String TEXT_510 = NL + "                ";
  protected final String TEXT_511 = " = null;";
  protected final String TEXT_512 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_513 = NL + "                ";
  protected final String TEXT_514 = " = null;";
  protected final String TEXT_515 = NL + "            \t";
  protected final String TEXT_516 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_517 = ";";
  protected final String TEXT_518 = NL + "    }" + NL;
  protected final String TEXT_519 = NL + "\t\t";
  protected final String TEXT_520 = "if(!whetherReject_";
  protected final String TEXT_521 = ") { ";
  protected final String TEXT_522 = "      " + NL + "             if(";
  protected final String TEXT_523 = " == null){ " + NL + "            \t ";
  protected final String TEXT_524 = " = new ";
  protected final String TEXT_525 = "Struct();" + NL + "             }";
  protected final String TEXT_526 = NL + "\t    \t ";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = " = ";
  protected final String TEXT_529 = ".";
  protected final String TEXT_530 = ";    \t\t\t\t";
  protected final String TEXT_531 = NL + "\t\t";
  protected final String TEXT_532 = " } ";
  protected final String TEXT_533 = "\t";
  protected final String TEXT_534 = NL;
  protected final String TEXT_535 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();	
	
	String projectName = codeGenArgument.getCurrentProjectName();
	String jobName = codeGenArgument.getJobName();
	String jobVersion = codeGenArgument.getJobVersion();
	
	String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");
	
	String vcid = "";

	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		vcid = destination;
	}
	
		
	class GenerateCode{
		public int colLen = 0; // the length of the column in the input schema
		public void generateDynamicSchemaCode(boolean isCsv){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
		if(isCsv){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
		}else{

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    		}
    stringBuffer.append(TEXT_9);
    stringBuffer.append(colLen );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    if(isCsv){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    }else{
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		}
	}
	GenerateCode generateCode = new GenerateCode();

    
	if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_32);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		String filename = ElementParameterParser.getValue(node,"__FILENAME__");
		
		if(!("".equals(vcid))) {
			filename = "\"/"+filename.substring(1, filename.length()-1)+vcid+"_"+projectName+"_"+jobName+"_"+jobVersion+"\"";
			filename = tempDir+"+"+filename;
		}
		
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	if(("").equals(header)){
    		header="0";
    	}
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		if(("").equals(limit)){
			limit = "-1";
		}
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	if(("").equals(footer)){
    		footer="0";
    	}
    	String random = "-1";
    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
    	if(("true").equals(ran)){
    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
    		if(("").equals(random)){
    			random="0";
    		}
    	}
    	
		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
		String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
		boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
		
    	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
		
		String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
		boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		String splitRecordStr = ElementParameterParser.getValue(node, "__SPLITRECORD__");
		boolean splitRecord = (splitRecordStr!=null&&!("").equals(splitRecordStr))?("true").equals(splitRecordStr):false;
		
		boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
		
		boolean hasDynamic = metadata.isDynamicSchema();
		if(hasDynamic){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
		}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
		if(uncompress){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_58);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_62);
    
		}else{

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_70);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_74);
    
		}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_78);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    	
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				boolean hasStringDefault = false;
				for (int valueM=0; valueM<sizeListColumns; valueM++) {
					IMetadataColumn column = listColumns.get(valueM);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
							hasStringDefault = true;
							break;
						}
					}
				}
				if(hasDynamic){// generate the dynamic schema code
					generateCode.colLen = sizeListColumns;
					generateCode.generateDynamicSchemaCode(false); //false: delimited mode
				}
				if(noStringTypeExist || hasStringDefault){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    }
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
	String defaultValue = column.getDefault();
	if(defaultValue!=null && defaultValue.length()>0){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_88);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_96);
    	}else{
    stringBuffer.append(TEXT_97);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_101);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_102);
    
	}
}else if(column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(sizeListColumns);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(sizeListColumns);
    stringBuffer.append(TEXT_110);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
}else{

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_120);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_126);
    
					}else if(javaType == JavaTypesManager.DATE) { 
						if(checkNum || checkDate){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_130);
    
						}else{

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_134);
    
						}
					}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_140);
    
					} else { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
					}

    stringBuffer.append(TEXT_145);
    
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
					if(defaultValue == null) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_148);
    
					} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_151);
    
					}

    stringBuffer.append(TEXT_152);
    
}

    
				}
    stringBuffer.append(TEXT_153);
    if(checkNum) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_163);
    }
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_166);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_167);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_170);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_171);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_175);
    
                }
                
    stringBuffer.append(TEXT_176);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_180);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_181);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_183);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_186);
    }
        } 
        
    stringBuffer.append(TEXT_187);
    
			}
		}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_188);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_194);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_200);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_201);
     } 
    stringBuffer.append(TEXT_202);
    
		}
	  }
	}
}

    stringBuffer.append(TEXT_203);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileInputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_204);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	if(("").equals(limit)){
    		limit="-1";
    	}
    	String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");     	
    	String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	
    	
    	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
    	
    	if(("").equals(escapeChar1)){
    		escapeChar1 = "\"\"";
    	}
    	String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
    	if(("'").equals(escapeChar)){
    		escapeChar = "\\'";
    	}
    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    	if(("").equals(textEnclosure1)){
    		textEnclosure1 = "\"\"";
    	}
    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    	if ("".equals(textEnclosure)) textEnclosure = "\0";
    	if(("'").equals(textEnclosure)){
    		textEnclosure = "\\'";
    	}
    	
    	String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    	
    	List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		
		String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
		boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
		
		String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
		boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
		
		boolean hasDynamic = metadata.isDynamicSchema();
		if(hasDynamic){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    
		}

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( footer);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( limit );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    
		if(uncompress){

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_241);
    
		}else{

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
		}

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    
		if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_259);
    
		}else{ //context and global variables

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
		}
		
		if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
        	if(("\\\\").equals(escapeChar)){
        
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
        	}else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    
        	}else{
        
    stringBuffer.append(TEXT_273);
    
        	}
        }else{//context and global variables
 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_285);
    }else{
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    		}
	
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( header );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
                 	if(("true").equals(removeEmptyRow)){
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    				}
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
                	if(("true").equals(removeEmptyRow)){
    stringBuffer.append(TEXT_308);
    				}
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    
		if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_339);
    
		}else{

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    
		}
		if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
        	if(("\\\\").equals(escapeChar)){
        
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    
        	}else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    
        	}else{
        
    stringBuffer.append(TEXT_347);
    
        	}
        }else{//context and global variables

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_352);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_353);
    }else{
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    }
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    
        }
        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    
   		if(("true").equals(removeEmptyRow)){
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    		}
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_385);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_386);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_390);
    
				List<IMetadataColumn> columns=metadata.getListColumns();
				int columnSize = columns.size();
				
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    
		for (IMetadataColumn column1: metadata.getListColumns()) {
    stringBuffer.append(TEXT_394);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_397);
    		}
    stringBuffer.append(TEXT_398);
    
			boolean hasStringDefault = false;
			for (int valueM=0; valueM<columnSize; valueM++) {
				IMetadataColumn column = columns.get(valueM);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
						hasStringDefault = true;
						break;
					}
				}
			}
			if(hasDynamic){// generate the dynamic schema code
				generateCode.colLen = columnSize;
				generateCode.generateDynamicSchemaCode(true); //true: CSV mode
			}
			if(hasStringDefault==true){

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    
			}
			for (int i=0;i<columnSize;i++) {
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_401);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
						String defaultValue = column.getDefault();
						if(defaultValue!=null && defaultValue.length()>0){

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_407);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_415);
    
						}else{

    stringBuffer.append(TEXT_416);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_420);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_421);
    
						}
					} else {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_424);
    
							if(javaType == JavaTypesManager.DATE) {
								if(checkNum || checkDate){
	
    stringBuffer.append(TEXT_425);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_429);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_430);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_431);
    
								}else{
	
    stringBuffer.append(TEXT_432);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_436);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_437);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_438);
    
								}
							} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
	
    stringBuffer.append(TEXT_439);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_441);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_444);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_446);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_447);
    
							}else if(javaType == JavaTypesManager.BYTE_ARRAY){ 
	
    stringBuffer.append(TEXT_448);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_452);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_454);
    
							}else if(column.getTalendType().equals("id_Dynamic")){
	
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(columnSize);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(columnSize);
    stringBuffer.append(TEXT_463);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    
							}else {
	
    stringBuffer.append(TEXT_470);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_475);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_476);
    
							}
	
    stringBuffer.append(TEXT_477);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()));
    stringBuffer.append(TEXT_480);
    					
					}
    stringBuffer.append(TEXT_481);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()) );
    stringBuffer.append(TEXT_484);
    			}
    stringBuffer.append(TEXT_485);
    if(checkNum) {
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_492);
    }
    stringBuffer.append(TEXT_493);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_494);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_495);
    }
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_498);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_499);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_501);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_502);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_506);
    
                }
                
    stringBuffer.append(TEXT_507);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_511);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_512);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_514);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_515);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_517);
    }
        } 
        
    stringBuffer.append(TEXT_518);
    			
			}
		}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_519);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_522);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_525);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_526);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_530);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_531);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_532);
     } 
    stringBuffer.append(TEXT_533);
    
		}
	}
		}
	}

    stringBuffer.append(TEXT_534);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  }

    stringBuffer.append(TEXT_535);
    return stringBuffer.toString();
  }
}
