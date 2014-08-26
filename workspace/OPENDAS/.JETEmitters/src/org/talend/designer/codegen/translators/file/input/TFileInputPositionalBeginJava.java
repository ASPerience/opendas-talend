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
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "int footer_";
  protected final String TEXT_4 = "  = ";
  protected final String TEXT_5 = ";" + NL + "int nb_limit_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL;
  protected final String TEXT_8 = NL + "class Arrays_";
  protected final String TEXT_9 = "{" + NL + "    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "        int newLength = to - from;" + NL + "        if (newLength < 0)" + NL + "            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "        byte[] copy = new byte[newLength];" + NL + "        System.arraycopy(original, from, copy, 0," + NL + "                         Math.min(original.length - from, newLength));" + NL + "        return copy;" + NL + "    }" + NL + "}" + NL + "Arrays_";
  protected final String TEXT_10 = " arrays_";
  protected final String TEXT_11 = " = new Arrays_";
  protected final String TEXT_12 = "();";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "int[] sizes_";
  protected final String TEXT_15 = " = new int[";
  protected final String TEXT_16 = "];" + NL + "int[] begins_";
  protected final String TEXT_17 = " = new int[";
  protected final String TEXT_18 = "];" + NL + "int[] ends_";
  protected final String TEXT_19 = " = new int[";
  protected final String TEXT_20 = "];";
  protected final String TEXT_21 = NL + "sizes_";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "] = ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "sizes_";
  protected final String TEXT_26 = "[";
  protected final String TEXT_27 = "] = ";
  protected final String TEXT_28 = ";\t\t\t\t";
  protected final String TEXT_29 = NL + "begins_";
  protected final String TEXT_30 = "[";
  protected final String TEXT_31 = "] = 0;" + NL + "ends_";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = "] = sizes_";
  protected final String TEXT_34 = "[";
  protected final String TEXT_35 = "];";
  protected final String TEXT_36 = NL + "begins_";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "] = begins_";
  protected final String TEXT_39 = "[";
  protected final String TEXT_40 = "] + sizes_";
  protected final String TEXT_41 = "[";
  protected final String TEXT_42 = "];" + NL + "ends_";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "] = -1;";
  protected final String TEXT_45 = NL + "begins_";
  protected final String TEXT_46 = "[";
  protected final String TEXT_47 = "] = begins_";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "] + sizes_";
  protected final String TEXT_50 = "[";
  protected final String TEXT_51 = "];" + NL + "ends_";
  protected final String TEXT_52 = "[";
  protected final String TEXT_53 = "] = ends_";
  protected final String TEXT_54 = "[";
  protected final String TEXT_55 = "] + sizes_";
  protected final String TEXT_56 = "[";
  protected final String TEXT_57 = "];";
  protected final String TEXT_58 = NL + "Object filename_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "java.io.BufferedReader in_";
  protected final String TEXT_61 = " = null;" + NL + "org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_62 = " = null;";
  protected final String TEXT_63 = NL + "java.util.zip.ZipInputStream zis_";
  protected final String TEXT_64 = " = null;" + NL + "if(filename_";
  protected final String TEXT_65 = " instanceof java.io.InputStream){" + NL + "\tzis_";
  protected final String TEXT_66 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_67 = "));" + NL + "}else{" + NL + "\tzis_";
  protected final String TEXT_68 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(filename_";
  protected final String TEXT_69 = ".toString())));" + NL + "}" + NL + "java.util.zip.ZipEntry entry_";
  protected final String TEXT_70 = " = null;" + NL + "while ((entry_";
  protected final String TEXT_71 = " = zis_";
  protected final String TEXT_72 = ".getNextEntry()) != null) {" + NL + "\tif(entry_";
  protected final String TEXT_73 = ".isDirectory()){ //directory" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tin_";
  protected final String TEXT_74 = " = new java.io.BufferedReader(new java.io.InputStreamReader(zis_";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = "));";
  protected final String TEXT_77 = NL + "if(filename_";
  protected final String TEXT_78 = " instanceof java.io.InputStream){" + NL + "\tin_";
  protected final String TEXT_79 = " = " + NL + "\t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = "));" + NL + "}else{" + NL + "\tin_";
  protected final String TEXT_82 = " = " + NL + "\t\tnew java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename_";
  protected final String TEXT_83 = ".toString()), ";
  protected final String TEXT_84 = "));" + NL + "}" + NL;
  protected final String TEXT_85 = NL + "int rowLength_";
  protected final String TEXT_86 = " = 0;";
  protected final String TEXT_87 = NL + "rowLength_";
  protected final String TEXT_88 = " += sizes_";
  protected final String TEXT_89 = "[";
  protected final String TEXT_90 = "];";
  protected final String TEXT_91 = NL + "rowLength_";
  protected final String TEXT_92 = " += ";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = NL + "reader_";
  protected final String TEXT_95 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_96 = ", rowLength_";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "reader_";
  protected final String TEXT_99 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "reader_";
  protected final String TEXT_104 = ".setSafetySwitch(";
  protected final String TEXT_105 = ");" + NL + "reader_";
  protected final String TEXT_106 = ".skipHeaders(";
  protected final String TEXT_107 = ");" + NL + "if(footer_";
  protected final String TEXT_108 = " > 0){" + NL + "\tint available_";
  protected final String TEXT_109 = " = (int)reader_";
  protected final String TEXT_110 = ".getAvailableRowCount(footer_";
  protected final String TEXT_111 = ");" + NL + "\treader_";
  protected final String TEXT_112 = ".close();" + NL + "\tif(filename_";
  protected final String TEXT_113 = " instanceof java.io.InputStream){" + NL + "\t\tin_";
  protected final String TEXT_114 = " = new java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = "));" + NL + "\t}else{" + NL + "\t\tin_";
  protected final String TEXT_117 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename_";
  protected final String TEXT_118 = ".toString()), ";
  protected final String TEXT_119 = "));" + NL + "\t}";
  protected final String TEXT_120 = NL + "\treader_";
  protected final String TEXT_121 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_122 = ", rowLength_";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\treader_";
  protected final String TEXT_125 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = "\t" + NL + "\treader_";
  protected final String TEXT_130 = ".skipHeaders(";
  protected final String TEXT_131 = ");" + NL + "\t" + NL + "\tif ( nb_limit_";
  protected final String TEXT_132 = " >= 0 ){" + NL + "\t\tnb_limit_";
  protected final String TEXT_133 = " = ( nb_limit_";
  protected final String TEXT_134 = " > available_";
  protected final String TEXT_135 = ") ? available_";
  protected final String TEXT_136 = " : nb_limit_";
  protected final String TEXT_137 = ";" + NL + "\t}else{" + NL + "\t\tnb_limit_";
  protected final String TEXT_138 = " = available_";
  protected final String TEXT_139 = ";" + NL + "\t}" + NL + "}" + NL + "String row_";
  protected final String TEXT_140 = " = null;   ";
  protected final String TEXT_141 = NL + "byte[] byteArray_";
  protected final String TEXT_142 = " = new byte[0];";
  protected final String TEXT_143 = NL + "String column_";
  protected final String TEXT_144 = " = null;";
  protected final String TEXT_145 = NL + "byte[][] byteArray_";
  protected final String TEXT_146 = " = new byte[";
  protected final String TEXT_147 = "][];";
  protected final String TEXT_148 = NL + "String[] columnValue";
  protected final String TEXT_149 = "=new String[";
  protected final String TEXT_150 = "];";
  protected final String TEXT_151 = NL + "int rowLen_";
  protected final String TEXT_152 = " = 0;" + NL + "while (nb_limit_";
  protected final String TEXT_153 = " != 0 && reader_";
  protected final String TEXT_154 = ".readRecord()) {" + NL + "\trow_";
  protected final String TEXT_155 = " = reader_";
  protected final String TEXT_156 = ".getRowRecord();";
  protected final String TEXT_157 = NL + "\trowLen_";
  protected final String TEXT_158 = " = row_";
  protected final String TEXT_159 = ".getBytes(";
  protected final String TEXT_160 = ").length;";
  protected final String TEXT_161 = NL + "\trowLen_";
  protected final String TEXT_162 = " = row_";
  protected final String TEXT_163 = ".length();";
  protected final String TEXT_164 = NL + "    \t\t";
  protected final String TEXT_165 = " = null;\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_167 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_168 = " = new ";
  protected final String TEXT_169 = "Struct();" + NL + "\t\t\ttry {" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "    if(begins_";
  protected final String TEXT_171 = "[";
  protected final String TEXT_172 = "] < rowLen_";
  protected final String TEXT_173 = "){";
  protected final String TEXT_174 = NL + "\t\tbyteArray_";
  protected final String TEXT_175 = "=arrays_";
  protected final String TEXT_176 = ".copyOfRange(row_";
  protected final String TEXT_177 = ".getBytes(";
  protected final String TEXT_178 = "),begins_";
  protected final String TEXT_179 = "[";
  protected final String TEXT_180 = "],rowLen_";
  protected final String TEXT_181 = ");" + NL + "    \tcolumn_";
  protected final String TEXT_182 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_183 = ",";
  protected final String TEXT_184 = "), ";
  protected final String TEXT_185 = ", ";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL + "\t\tcolumn_";
  protected final String TEXT_188 = " = TalendString.talendTrim(row_";
  protected final String TEXT_189 = ".substring(begins_";
  protected final String TEXT_190 = "[";
  protected final String TEXT_191 = "]), ";
  protected final String TEXT_192 = ", ";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_195 = " = \"\";" + NL + "    }";
  protected final String TEXT_196 = NL + "\tif(begins_";
  protected final String TEXT_197 = "[";
  protected final String TEXT_198 = "] < rowLen_";
  protected final String TEXT_199 = "){" + NL + "        if(ends_";
  protected final String TEXT_200 = "[";
  protected final String TEXT_201 = "] <= rowLen_";
  protected final String TEXT_202 = "){" + NL + "        \tbyteArray_";
  protected final String TEXT_203 = " = arrays_";
  protected final String TEXT_204 = ".copyOfRange(row_";
  protected final String TEXT_205 = ".getBytes(";
  protected final String TEXT_206 = "),begins_";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "],ends_";
  protected final String TEXT_209 = "[";
  protected final String TEXT_210 = "]);" + NL + "        }else{" + NL + "        \tbyteArray_";
  protected final String TEXT_211 = " = arrays_";
  protected final String TEXT_212 = ".copyOfRange(row_";
  protected final String TEXT_213 = ".getBytes(";
  protected final String TEXT_214 = "),begins_";
  protected final String TEXT_215 = "[";
  protected final String TEXT_216 = "],rowLen_";
  protected final String TEXT_217 = ");" + NL + "\t\t}" + NL + "\t\tcolumn_";
  protected final String TEXT_218 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_219 = ",";
  protected final String TEXT_220 = "), ";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = ");" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_223 = " = \"\";" + NL + "    }";
  protected final String TEXT_224 = NL + "\tif(begins_";
  protected final String TEXT_225 = "[";
  protected final String TEXT_226 = "] < rowLen_";
  protected final String TEXT_227 = "){" + NL + "        if(ends_";
  protected final String TEXT_228 = "[";
  protected final String TEXT_229 = "] <= rowLen_";
  protected final String TEXT_230 = "){" + NL + "        \tcolumn_";
  protected final String TEXT_231 = " = TalendString.talendTrim(row_";
  protected final String TEXT_232 = ".substring(begins_";
  protected final String TEXT_233 = "[";
  protected final String TEXT_234 = "], ends_";
  protected final String TEXT_235 = "[";
  protected final String TEXT_236 = "]), ";
  protected final String TEXT_237 = ", ";
  protected final String TEXT_238 = ");" + NL + "        }else{" + NL + "        \tcolumn_";
  protected final String TEXT_239 = " = TalendString.talendTrim(row_";
  protected final String TEXT_240 = ".substring(begins_";
  protected final String TEXT_241 = "[";
  protected final String TEXT_242 = "]), ";
  protected final String TEXT_243 = ", ";
  protected final String TEXT_244 = ");" + NL + "\t\t}" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_245 = " = \"\";" + NL + "    }";
  protected final String TEXT_246 = NL + "\tcolumn_";
  protected final String TEXT_247 = " = column_";
  protected final String TEXT_248 = ".trim();";
  protected final String TEXT_249 = NL + "\t";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = " = column_";
  protected final String TEXT_252 = ";";
  protected final String TEXT_253 = NL + "\tif(column_";
  protected final String TEXT_254 = ".length() > 0) {";
  protected final String TEXT_255 = NL + "\t\t";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_258 = ", ";
  protected final String TEXT_259 = ",false);";
  protected final String TEXT_260 = NL + "\t\t";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = ");";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = " = ParserUtils.parseTo_";
  protected final String TEXT_268 = "(ParserUtils.parseTo_Number(column_";
  protected final String TEXT_269 = ", ";
  protected final String TEXT_270 = ", ";
  protected final String TEXT_271 = "));";
  protected final String TEXT_272 = NL + "\t\t";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " = column_";
  protected final String TEXT_275 = ".getBytes(";
  protected final String TEXT_276 = ");";
  protected final String TEXT_277 = NL + "\t\t";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = " = ParserUtils.parseTo_";
  protected final String TEXT_280 = "(column_";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "    }else{" + NL + "    \t";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = ";
  protected final String TEXT_285 = ";" + NL + "    }";
  protected final String TEXT_286 = NL + "\tint substringBegin";
  protected final String TEXT_287 = "=0,substringEnd";
  protected final String TEXT_288 = "=0;" + NL + "\t";
  protected final String TEXT_289 = "\t" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_290 = "[";
  protected final String TEXT_291 = "]=\"\";";
  protected final String TEXT_292 = NL + "\t\t    if(substringBegin";
  protected final String TEXT_293 = " >= rowLen_";
  protected final String TEXT_294 = "){" + NL + "\t\t    \tcolumnValue";
  protected final String TEXT_295 = "[";
  protected final String TEXT_296 = "]= \"\";" + NL + "    \t\t}else{";
  protected final String TEXT_297 = NL + "        \t\t\t \tsubstringEnd";
  protected final String TEXT_298 = "=rowLen_";
  protected final String TEXT_299 = ";";
  protected final String TEXT_300 = NL + "        \t\t\t\tsubstringEnd";
  protected final String TEXT_301 = " = substringEnd";
  protected final String TEXT_302 = " + ";
  protected final String TEXT_303 = ";" + NL + "        " + NL + "\t\t\t\t        if(substringEnd";
  protected final String TEXT_304 = " > rowLen_";
  protected final String TEXT_305 = "){" + NL + "\t\t\t\t        \tsubstringEnd";
  protected final String TEXT_306 = " = rowLen_";
  protected final String TEXT_307 = ";" + NL + "\t\t\t\t    \t}";
  protected final String TEXT_308 = NL + "\t\t\t\t\tbyteArray_";
  protected final String TEXT_309 = "[";
  protected final String TEXT_310 = "] = arrays_";
  protected final String TEXT_311 = ".copyOfRange(row_";
  protected final String TEXT_312 = ".getBytes(";
  protected final String TEXT_313 = "),substringBegin";
  protected final String TEXT_314 = ", substringEnd";
  protected final String TEXT_315 = ");" + NL + "\t\t\t\t\tcolumnValue";
  protected final String TEXT_316 = "[";
  protected final String TEXT_317 = "] = new String(byteArray_";
  protected final String TEXT_318 = "[";
  protected final String TEXT_319 = "],";
  protected final String TEXT_320 = ");";
  protected final String TEXT_321 = NL + "        \t\t\tcolumnValue";
  protected final String TEXT_322 = "[";
  protected final String TEXT_323 = "] = row_";
  protected final String TEXT_324 = ".substring(substringBegin";
  protected final String TEXT_325 = ", substringEnd";
  protected final String TEXT_326 = ");";
  protected final String TEXT_327 = NL + "\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_328 = "[";
  protected final String TEXT_329 = "] = columnValue";
  protected final String TEXT_330 = "[";
  protected final String TEXT_331 = "].trim();";
  protected final String TEXT_332 = "    \t" + NL + "        \t\t\tsubstringBegin";
  protected final String TEXT_333 = " = substringEnd";
  protected final String TEXT_334 = ";" + NL + "\t\t\t}";
  protected final String TEXT_335 = NL + "\t\tString arrFieldSeparator";
  protected final String TEXT_336 = "[] = \"";
  protected final String TEXT_337 = "\".split(\",\");";
  protected final String TEXT_338 = "\t\t" + NL + "\t\tString arrFieldSeparator";
  protected final String TEXT_339 = "[] = ";
  protected final String TEXT_340 = ".split(\",\");";
  protected final String TEXT_341 = NL + "\t\tfor (int i_";
  protected final String TEXT_342 = " = 0; i_";
  protected final String TEXT_343 = " < ";
  protected final String TEXT_344 = "; i_";
  protected final String TEXT_345 = "++) {" + NL + "\t\t\tif (i_";
  protected final String TEXT_346 = " >= arrFieldSeparator";
  protected final String TEXT_347 = ".length ){" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_348 = "[i_";
  protected final String TEXT_349 = "]=\"\";" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t " + NL + "\t\t    if (substringBegin";
  protected final String TEXT_350 = " >= rowLen_";
  protected final String TEXT_351 = ") {" + NL + "\t\t    \tcolumnValue";
  protected final String TEXT_352 = "[i_";
  protected final String TEXT_353 = "] = \"\";" + NL + "\t\t    } else{" + NL + "\t\t    " + NL + "\t\t\t\tif ((\"*\").equals(arrFieldSeparator";
  protected final String TEXT_354 = "[i_";
  protected final String TEXT_355 = "])){" + NL + "\t\t\t\t\tsubstringEnd";
  protected final String TEXT_356 = " = rowLen_";
  protected final String TEXT_357 = ";" + NL + "\t\t\t\t} else{" + NL + "\t    \t\t\tsubstringEnd";
  protected final String TEXT_358 = " = substringEnd";
  protected final String TEXT_359 = " + Integer.parseInt(arrFieldSeparator";
  protected final String TEXT_360 = "[i_";
  protected final String TEXT_361 = "]);" + NL + "\t\t\t        if(substringEnd";
  protected final String TEXT_362 = " > rowLen_";
  protected final String TEXT_363 = ")" + NL + "\t\t\t        \tsubstringEnd";
  protected final String TEXT_364 = " = rowLen_";
  protected final String TEXT_365 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_366 = NL + "\t\t\t\tbyteArray_";
  protected final String TEXT_367 = "[i_";
  protected final String TEXT_368 = "] = arrays_";
  protected final String TEXT_369 = ".copyOfRange(row_";
  protected final String TEXT_370 = ".getBytes(";
  protected final String TEXT_371 = "),substringBegin";
  protected final String TEXT_372 = ", substringEnd";
  protected final String TEXT_373 = ");" + NL + "\t\t\t\tcolumnValue";
  protected final String TEXT_374 = "[i_";
  protected final String TEXT_375 = "] = new String(byteArray_";
  protected final String TEXT_376 = "[i_";
  protected final String TEXT_377 = "],";
  protected final String TEXT_378 = ");";
  protected final String TEXT_379 = NL + "\t        \tcolumnValue";
  protected final String TEXT_380 = "[i_";
  protected final String TEXT_381 = "] = row_";
  protected final String TEXT_382 = ".substring(substringBegin";
  protected final String TEXT_383 = ", substringEnd";
  protected final String TEXT_384 = ");\t";
  protected final String TEXT_385 = NL + "\t        \tif (";
  protected final String TEXT_386 = ")" + NL + "\t        \t\tcolumnValue";
  protected final String TEXT_387 = "[i_";
  protected final String TEXT_388 = "] = columnValue";
  protected final String TEXT_389 = "[i_";
  protected final String TEXT_390 = "].trim();" + NL + "\t        \t" + NL + "\t        \tsubstringBegin";
  protected final String TEXT_391 = " = substringEnd";
  protected final String TEXT_392 = ";" + NL + "\t        }" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_393 = NL + "\t";
  protected final String TEXT_394 = ".";
  protected final String TEXT_395 = " = columnValue";
  protected final String TEXT_396 = "[";
  protected final String TEXT_397 = "];";
  protected final String TEXT_398 = NL + "\tif(columnValue";
  protected final String TEXT_399 = "[";
  protected final String TEXT_400 = "].length() > 0) {";
  protected final String TEXT_401 = "\t" + NL + "\t\t";
  protected final String TEXT_402 = ".";
  protected final String TEXT_403 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_404 = "[";
  protected final String TEXT_405 = "], ";
  protected final String TEXT_406 = ",false);";
  protected final String TEXT_407 = NL + "\t\t";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_410 = "[";
  protected final String TEXT_411 = "], ";
  protected final String TEXT_412 = ");\t";
  protected final String TEXT_413 = NL + "\t\t";
  protected final String TEXT_414 = ".";
  protected final String TEXT_415 = " = ParserUtils.parseTo_";
  protected final String TEXT_416 = "(ParserUtils.parseTo_Number(columnValue";
  protected final String TEXT_417 = "[";
  protected final String TEXT_418 = "], ";
  protected final String TEXT_419 = ", ";
  protected final String TEXT_420 = "));";
  protected final String TEXT_421 = "\t" + NL + "\t\t";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = " = columnValue";
  protected final String TEXT_424 = "[";
  protected final String TEXT_425 = "].getBytes(";
  protected final String TEXT_426 = ");";
  protected final String TEXT_427 = "\t" + NL + "\t\t";
  protected final String TEXT_428 = ".";
  protected final String TEXT_429 = " = ParserUtils.parseTo_";
  protected final String TEXT_430 = "(columnValue";
  protected final String TEXT_431 = "[";
  protected final String TEXT_432 = "].trim());";
  protected final String TEXT_433 = NL + "        }else{" + NL + "        \t";
  protected final String TEXT_434 = ".";
  protected final String TEXT_435 = " = ";
  protected final String TEXT_436 = ";" + NL + "        }";
  protected final String TEXT_437 = NL + "        \t\t\t";
  protected final String TEXT_438 = " ";
  protected final String TEXT_439 = " = null; ";
  protected final String TEXT_440 = "        \t\t\t" + NL + "        \t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_441 = " = true;";
  protected final String TEXT_442 = NL + "            throw(e);";
  protected final String TEXT_443 = NL + "                    ";
  protected final String TEXT_444 = " = new ";
  protected final String TEXT_445 = "Struct();";
  protected final String TEXT_446 = NL + "                    ";
  protected final String TEXT_447 = ".";
  protected final String TEXT_448 = " = ";
  protected final String TEXT_449 = ".";
  protected final String TEXT_450 = ";";
  protected final String TEXT_451 = NL + "                ";
  protected final String TEXT_452 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_453 = ";";
  protected final String TEXT_454 = NL + "                ";
  protected final String TEXT_455 = " = null;";
  protected final String TEXT_456 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_457 = NL + "                ";
  protected final String TEXT_458 = " = null;";
  protected final String TEXT_459 = NL + "            \t";
  protected final String TEXT_460 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_461 = ";";
  protected final String TEXT_462 = NL + "    }" + NL + "        \t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_463 = NL + "\t\t";
  protected final String TEXT_464 = "if(!whetherReject_";
  protected final String TEXT_465 = ") { ";
  protected final String TEXT_466 = "      " + NL + "             if(";
  protected final String TEXT_467 = " == null){ " + NL + "            \t ";
  protected final String TEXT_468 = " = new ";
  protected final String TEXT_469 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_470 = NL + "\t    \t ";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = " = ";
  protected final String TEXT_473 = ".";
  protected final String TEXT_474 = ";    \t\t\t\t";
  protected final String TEXT_475 = NL + "\t\t";
  protected final String TEXT_476 = " } ";
  protected final String TEXT_477 = "\t";
  protected final String TEXT_478 = NL;

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
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern1 = ElementParameterParser.getValue(node, "__PATTERN__");
            
            boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
            boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && ("false").equals(trimAll)){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		if ("".equals(limit.trim())) limit = "-1";
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
        	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    		
    		//need to process rows longger than 100 000 characters, the property SafetySwitch(in talend_file_enhanced_20070724.jar) should be sent to false.(the default is true)
    		//that means if check the option(true), the logic value of bSafetySwitch should be changed to false (XOR with 'true')
    		boolean bSafetySwitch = (("true").equals(ElementParameterParser.getValue(node, "__PROCESS_LONG_ROW__")) ^ true);    		
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);    		  
			
			String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
			boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
			
			boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
			
    		if(("").equals(header)){
    			header = "0";
    		}
    			
    		if(("").equals(footer)){
    			footer = "0";
    		}
    		
    		boolean useStar = false;
    		
    		String pattern=TalendTextUtils.removeQuotes(pattern1);
    		String[] positions=(pattern.trim()).split(",");
    		for(int i=0;i<positions.length;i++){
            	if(("").equals(positions[i])){
               	 	positions[i]="0";
            	}
            	if(("*").equals(positions[i])){
            		useStar = true;
            	}
            }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_7);
    
		if(useByte){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
		}

    stringBuffer.append(TEXT_13);
    
		if(advanced){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_20);
    
			for(int i = 0; i < formats.size(); i++){ 
				if(i == formats.size() - 1 && !(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
					if(("*").equals(formats.get(i).get("SIZE"))){ 
						useStar = true;
					}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(useStar ? -1 :  formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_24);
    
				}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_28);
    
				}
			}
			for(int i = 0; i < formats.size(); i++){ 
				if(i == 0){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_35);
    
				}else if(i == formats.size() - 1 && useStar){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_44);
    
				}else{

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_57);
    
				}
			}
		}//end if(advanced)

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
		if(uncompress){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_76);
    
		}else{

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_84);
    
		}
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_90);
    
					}
				}else{
    				for(int i=0;i<positions.length;i++){

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(positions[i] );
    stringBuffer.append(TEXT_93);
    
        			}
				}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
			}else{

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_102);
    
			}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_119);
    
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
			}else{

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_128);
    
			}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
	if(advanced){
		if(useByte){

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
		}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
	}else{
		if(useByte){

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_147);
    
		}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_150);
    
	}

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
    
	if(useByte){

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_160);
    
	}else{

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
	}

    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<? extends IConnection> connsFlow = node.getOutgoingConnections("FLOW");

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

    stringBuffer.append(TEXT_164);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_165);
    
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
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_169);
    
    			if(advanced){
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int sizeListColumns = listColumns.size();
    				for (int valueN=0; valueN<sizeListColumns; valueN++) {
    					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
    					String align = formats.get(valueN).get("ALIGN");
    					if(("'L'").equals(align)){
    						align = "-1";
    					}else if(("'C'").equals(align)){
    						align = "0";
    					}else{
    						align = "1";
    					}
    					if(valueN == sizeListColumns - 1 && useStar){ //last column

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    
							if(useByte){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_186);
    
							}else{

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_193);
    
							}

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    
						}else{//other column
							if(useByte){

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    
							}else{

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
							}
						}
						if(isTrimAll || ("true").equals(trimSelects.get(valueN).get("TRIM"))){

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    
						}
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    
					} else {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    
						if(javaType == JavaTypesManager.DATE) {
							if(checkDate) {

    stringBuffer.append(TEXT_255);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_259);
    
							} else {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_264);
    
							}
						}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_265);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_271);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_276);
    
							} else {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    
							}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_285);
    					
					}
				}
			}else{// end if(advance)

    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    
	///////////////////
	//Branch: first item is a numberic, not '((String)globalMap.get("global_variable"))' or 'context.Separator'
	if ( java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches() ){
	///////////////////
	
		for(int i=0;i <	metadata.getListColumns().size();i++){
			if(i >=positions.length){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    
				continue;
			}

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_296);
    
					if(("*").equals(positions[i])){

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    
					} else{

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(positions[i]);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    
					}
					if(useByte){

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_320);
    
					}else{

    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
     
					}
       				if(isTrimAll || ("true").equals(trimSelects.get(i).get("TRIM"))){

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_331);
    
					}

    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    
	
		}//for(...)
				
	///////////////
	} else{
		if(pattern1.startsWith("\"")){

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(positions[0] );
    stringBuffer.append(TEXT_337);
    
		}else{
	
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(positions[0]);
    stringBuffer.append(TEXT_340);
    
		}

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    
		if(useByte){

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_378);
    
		}else{

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
    
		}

    stringBuffer.append(TEXT_385);
    stringBuffer.append(isTrimAll);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    
	}
	///////////////
	
				
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_393);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_397);
    
					} else {

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_400);
    
							if(javaType == JavaTypesManager.DATE) {
								if(checkDate) {

    stringBuffer.append(TEXT_401);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_405);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_406);
    
								} else {

    stringBuffer.append(TEXT_407);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_411);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_412);
    
								}
							}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_413);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_415);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_418);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_419);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_420);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_421);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_426);
    
							} else {

    stringBuffer.append(TEXT_427);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_429);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_432);
    
							}

    stringBuffer.append(TEXT_433);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_436);
    
        					}
        				}
        			}
    stringBuffer.append(TEXT_437);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_438);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_442);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_443);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_445);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_446);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_448);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_450);
    
                }
                
    stringBuffer.append(TEXT_451);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_455);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_456);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_458);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_459);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_461);
    }
        } 
        
    stringBuffer.append(TEXT_462);
            			
        		}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_463);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_466);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_469);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_470);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_474);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_475);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_476);
     } 
    stringBuffer.append(TEXT_477);
    
		}
        	}
		}
	}
}

    stringBuffer.append(TEXT_478);
    return stringBuffer.toString();
  }
}
