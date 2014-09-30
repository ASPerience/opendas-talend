package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
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
  protected final String TEXT_45 = NL + "\t\t\tString log4jFileInputExcelParamters_";
  protected final String TEXT_46 = " = \"\";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_47 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_48 = " + \"FILENAME = \" + ";
  protected final String TEXT_49 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_50 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_51 = " + \"USESTREAM = \" + ";
  protected final String TEXT_52 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_53 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_54 = " + \"VERSION_2007 = \" + ";
  protected final String TEXT_55 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_56 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_57 = " + \"SHEETNAME = \" + ";
  protected final String TEXT_58 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_59 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_60 = " + \"INCLUDEHEADER = \" + ";
  protected final String TEXT_61 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_62 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_63 = " + \"APPEND_FILE = \" + ";
  protected final String TEXT_64 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_66 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_67 = " + \"APPEND_SHEET = \" + ";
  protected final String TEXT_68 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_70 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_71 = " + \"FIRST_CELL_Y_ABSOLUTE = \" + ";
  protected final String TEXT_72 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_74 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_75 = " + \"FIRST_CELL_X = \" + ";
  protected final String TEXT_76 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_77 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_78 = " + \"FIRST_CELL_Y = \" + ";
  protected final String TEXT_79 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_80 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_81 = " + \"KEEP_CELL_FORMATING = \" + ";
  protected final String TEXT_82 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_84 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_85 = " + \"FONT = \" + \"";
  protected final String TEXT_86 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_87 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_88 = " + \"IS_ALL_AUTO_SIZE = \" + ";
  protected final String TEXT_89 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_91 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_92 = " + \"FLUSHONROW = \" + ";
  protected final String TEXT_93 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_95 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_96 = " + \"FLUSHONROW_NUM = \" + ";
  protected final String TEXT_97 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_101 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_102 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_103 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_104 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_105 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_106 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_108 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_109 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_110 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_111 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_112 = " + \"DELETE_EMPTYFILE = \" + ";
  protected final String TEXT_113 = " + \" | \";" + NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_114 = " = \"";
  protected final String TEXT_115 = " - Parameters:\" + log4jFileInputExcelParamters_";
  protected final String TEXT_116 = ";" + NL + "\t\t\tlog.debug(log4jFileInputExcelParamters_";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\tint nb_line_";
  protected final String TEXT_119 = " = 0;" + NL;
  protected final String TEXT_120 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_121 = "=";
  protected final String TEXT_122 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_123 = " = new java.io.File(fileName_";
  protected final String TEXT_124 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_125 = " = true;";
  protected final String TEXT_126 = NL + "\t\tif(file_";
  protected final String TEXT_127 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_128 = " = false;" + NL + "\t\t}";
  protected final String TEXT_129 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_130 = " = file_";
  protected final String TEXT_131 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_132 = " != null && !parentFile_";
  protected final String TEXT_133 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_134 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_135 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_136 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "             parentFile_";
  protected final String TEXT_138 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_139 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_140 = " - Create directory '\"+parentFile_";
  protected final String TEXT_141 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "          }";
  protected final String TEXT_143 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_144 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_145 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_146 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_147 = ".setEncoding(";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_150 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_151 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = "  " + NL + "        if (file_";
  protected final String TEXT_154 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_155 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_156 = ",workbookSettings_";
  protected final String TEXT_157 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_158 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_159 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_160 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_161 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_162 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_163 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_164 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_165 = ");        " + NL + "        }     ";
  protected final String TEXT_166 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_167 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_168 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = "       " + NL + "" + NL + "        writableSheet_";
  protected final String TEXT_171 = " = writeableWorkbook_";
  protected final String TEXT_172 = ".getSheet(";
  protected final String TEXT_173 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_174 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_175 = " = writeableWorkbook_";
  protected final String TEXT_176 = ".createSheet(";
  protected final String TEXT_177 = ", writeableWorkbook_";
  protected final String TEXT_178 = ".getNumberOfSheets());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_179 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_180 = " = writeableWorkbook_";
  protected final String TEXT_181 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_182 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_183 = "[i].equals(";
  protected final String TEXT_184 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_185 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_186 = " = writeableWorkbook_";
  protected final String TEXT_187 = ".createSheet(";
  protected final String TEXT_188 = ", writeableWorkbook_";
  protected final String TEXT_189 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_190 = NL + NL + "        //modif start";
  protected final String TEXT_191 = NL + "\t\tint startRowNum_";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = ";";
  protected final String TEXT_194 = NL + "        int startRowNum_";
  protected final String TEXT_195 = " = writableSheet_";
  protected final String TEXT_196 = ".getRows();";
  protected final String TEXT_197 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_198 = " = new int[";
  protected final String TEXT_199 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_200 = "=0;i_";
  protected final String TEXT_201 = "<";
  protected final String TEXT_202 = ";i_";
  protected final String TEXT_203 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_204 = "=writableSheet_";
  protected final String TEXT_205 = ".getColumnView(i_";
  protected final String TEXT_206 = "+";
  protected final String TEXT_207 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_208 = "[i_";
  protected final String TEXT_209 = "]=fitCellViewSize_";
  protected final String TEXT_210 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_211 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_212 = "[i_";
  protected final String TEXT_213 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_214 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_215 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_216 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_217 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_218 = "); ";
  protected final String TEXT_219 = NL;
  protected final String TEXT_220 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_223 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_224 = "));";
  protected final String TEXT_225 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_226 = "_";
  protected final String TEXT_227 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_228 = "));";
  protected final String TEXT_229 = NL + "\t\tif(true){" + NL + "\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_231 = " - Date pattern must be set for column ";
  protected final String TEXT_232 = " in the schema of component ";
  protected final String TEXT_233 = "!\");" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_235 = " in the schema of component ";
  protected final String TEXT_236 = "!\");" + NL + "\t\t}";
  protected final String TEXT_237 = "\t\t" + NL;
  protected final String TEXT_238 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_239 = "{";
  protected final String TEXT_240 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_241 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_242 = ",final int rowNum_";
  protected final String TEXT_243 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_244 = ",final int[] fitWidth_";
  protected final String TEXT_245 = ") throws java.lang.Exception {";
  protected final String TEXT_246 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_247 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_248 = " + ";
  protected final String TEXT_249 = ", rowNum_";
  protected final String TEXT_250 = ", \"";
  protected final String TEXT_251 = "\"";
  protected final String TEXT_252 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_253 = NL + "\t\t\t));\t\t";
  protected final String TEXT_254 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_255 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_256 = ", rowNum_";
  protected final String TEXT_257 = ", \"";
  protected final String TEXT_258 = "\"";
  protected final String TEXT_259 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_260 = NL + "\t\t\t));";
  protected final String TEXT_261 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_262 = "[";
  protected final String TEXT_263 = "]=fitWidth_";
  protected final String TEXT_264 = "[";
  protected final String TEXT_265 = "]>";
  protected final String TEXT_266 = "?fitWidth_";
  protected final String TEXT_267 = "[";
  protected final String TEXT_268 = "]:";
  protected final String TEXT_269 = ";";
  protected final String TEXT_270 = NL + "\t\t\t}";
  protected final String TEXT_271 = NL + "\t\t\t}";
  protected final String TEXT_272 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_273 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_274 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_275 = ") throws java.lang.Exception {";
  protected final String TEXT_276 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_277 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_278 = ".setColumnView(";
  protected final String TEXT_279 = " + ";
  protected final String TEXT_280 = ", fitWidth_";
  protected final String TEXT_281 = "[";
  protected final String TEXT_282 = "]);" + NL + "        \t\t";
  protected final String TEXT_283 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_284 = ".setColumnView(";
  protected final String TEXT_285 = ", fitWidth_";
  protected final String TEXT_286 = "[";
  protected final String TEXT_287 = "]);" + NL + "        \t\t";
  protected final String TEXT_288 = NL + "    \t\t\t//modif end";
  protected final String TEXT_289 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_290 = ".setColumnView(";
  protected final String TEXT_291 = ", fitWidth_";
  protected final String TEXT_292 = "[";
  protected final String TEXT_293 = "]);";
  protected final String TEXT_294 = NL + "\t\t\t}";
  protected final String TEXT_295 = NL + "\t\t\t}";
  protected final String TEXT_296 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_297 = "(final ";
  protected final String TEXT_298 = "Struct ";
  protected final String TEXT_299 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_300 = ",final int startRowNum_";
  protected final String TEXT_301 = ",final int nb_line_";
  protected final String TEXT_302 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_303 = ",int[] fitWidth_";
  protected final String TEXT_304 = ") throws java.lang.Exception {";
  protected final String TEXT_305 = NL + "\t\t\t";
  protected final String TEXT_306 = "\t\t\t\t";
  protected final String TEXT_307 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_308 = ".";
  protected final String TEXT_309 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_310 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_311 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_314 = "_";
  protected final String TEXT_315 = " = writableSheet_";
  protected final String TEXT_316 = ".getWritableCell(";
  protected final String TEXT_317 = " + ";
  protected final String TEXT_318 = ", startRowNum_";
  protected final String TEXT_319 = " + nb_line_";
  protected final String TEXT_320 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_322 = "_";
  protected final String TEXT_323 = " = new jxl.write.";
  protected final String TEXT_324 = "(";
  protected final String TEXT_325 = " + ";
  protected final String TEXT_326 = ", startRowNum_";
  protected final String TEXT_327 = " + nb_line_";
  protected final String TEXT_328 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_329 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_330 = "_";
  protected final String TEXT_331 = " = new jxl.write.";
  protected final String TEXT_332 = "(";
  protected final String TEXT_333 = ", startRowNum_";
  protected final String TEXT_334 = " + nb_line_";
  protected final String TEXT_335 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_336 = NL + "//modif end";
  protected final String TEXT_337 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_338 = ".";
  protected final String TEXT_339 = ", cell_format_";
  protected final String TEXT_340 = "_";
  protected final String TEXT_341 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_342 = ".";
  protected final String TEXT_343 = ")";
  protected final String TEXT_344 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_345 = ".";
  protected final String TEXT_346 = ".toString()";
  protected final String TEXT_347 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_348 = ".";
  protected final String TEXT_349 = ")).toString()";
  protected final String TEXT_350 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_352 = "), ";
  protected final String TEXT_353 = ", ";
  protected final String TEXT_354 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_356 = ".";
  protected final String TEXT_357 = "), ";
  protected final String TEXT_358 = ", ";
  protected final String TEXT_359 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_360 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_361 = ").doubleValue()";
  protected final String TEXT_362 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_363 = ".";
  protected final String TEXT_364 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_365 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_367 = "_";
  protected final String TEXT_368 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_369 = "_";
  protected final String TEXT_370 = ".setCellFormat( existingCell_";
  protected final String TEXT_371 = "_";
  protected final String TEXT_372 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_373 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_374 = ".addCell(cell_";
  protected final String TEXT_375 = "_";
  protected final String TEXT_376 = ");";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_378 = "_";
  protected final String TEXT_379 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_380 = "_";
  protected final String TEXT_381 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_382 = "_";
  protected final String TEXT_383 = "=currentWith_";
  protected final String TEXT_384 = "_";
  protected final String TEXT_385 = ">10?10:currentWith_";
  protected final String TEXT_386 = "_";
  protected final String TEXT_387 = ";";
  protected final String TEXT_388 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_389 = "_";
  protected final String TEXT_390 = " = cell_";
  protected final String TEXT_391 = "_";
  protected final String TEXT_392 = ".getContents().trim().length();";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_394 = "[";
  protected final String TEXT_395 = "]=fitWidth_";
  protected final String TEXT_396 = "[";
  protected final String TEXT_397 = "]>currentWith_";
  protected final String TEXT_398 = "_";
  protected final String TEXT_399 = "?fitWidth_";
  protected final String TEXT_400 = "[";
  protected final String TEXT_401 = "]:currentWith_";
  protected final String TEXT_402 = "_";
  protected final String TEXT_403 = "+2;";
  protected final String TEXT_404 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_405 = "_";
  protected final String TEXT_406 = "=";
  protected final String TEXT_407 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_408 = "[";
  protected final String TEXT_409 = "]=fitWidth_";
  protected final String TEXT_410 = "[";
  protected final String TEXT_411 = "]>currentWith_";
  protected final String TEXT_412 = "_";
  protected final String TEXT_413 = "?fitWidth_";
  protected final String TEXT_414 = "[";
  protected final String TEXT_415 = "]:currentWith_";
  protected final String TEXT_416 = "_";
  protected final String TEXT_417 = "+2;";
  protected final String TEXT_418 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t}";
  protected final String TEXT_420 = NL + "\t\t\t}";
  protected final String TEXT_421 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_422 = " fileOutputExcelUtil_";
  protected final String TEXT_423 = "=new FileOutputExcelUtil_";
  protected final String TEXT_424 = "();";
  protected final String TEXT_425 = NL;
  protected final String TEXT_426 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_427 = " == ";
  protected final String TEXT_428 = "){";
  protected final String TEXT_429 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_430 = " == 0){";
  protected final String TEXT_431 = NL + "\t//modif end";
  protected final String TEXT_432 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_433 = ".putHeaderValue_";
  protected final String TEXT_434 = "(writableSheet_";
  protected final String TEXT_435 = ",startRowNum_";
  protected final String TEXT_436 = ",";
  protected final String TEXT_437 = "format_";
  protected final String TEXT_438 = "null";
  protected final String TEXT_439 = ",fitWidth_";
  protected final String TEXT_440 = ");";
  protected final String TEXT_441 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_442 = ".putHeaderValue_";
  protected final String TEXT_443 = "(writableSheet_";
  protected final String TEXT_444 = ",nb_line_";
  protected final String TEXT_445 = ",";
  protected final String TEXT_446 = "format_";
  protected final String TEXT_447 = "null";
  protected final String TEXT_448 = ",fitWidth_";
  protected final String TEXT_449 = ");";
  protected final String TEXT_450 = NL + "\t\t//modif start";
  protected final String TEXT_451 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_452 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_453 = " + ";
  protected final String TEXT_454 = ", startRowNum_";
  protected final String TEXT_455 = ", \"";
  protected final String TEXT_456 = "\"";
  protected final String TEXT_457 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_458 = NL + "\t\t\t));\t\t";
  protected final String TEXT_459 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_460 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_461 = ", nb_line_";
  protected final String TEXT_462 = ", \"";
  protected final String TEXT_463 = "\"";
  protected final String TEXT_464 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_465 = NL + "\t\t\t));";
  protected final String TEXT_466 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_467 = "[";
  protected final String TEXT_468 = "]=fitWidth_";
  protected final String TEXT_469 = "[";
  protected final String TEXT_470 = "]>";
  protected final String TEXT_471 = "?fitWidth_";
  protected final String TEXT_472 = "[";
  protected final String TEXT_473 = "]:";
  protected final String TEXT_474 = ";";
  protected final String TEXT_475 = NL + "\t\tnb_line_";
  protected final String TEXT_476 = "++;" + NL + "\t}";
  protected final String TEXT_477 = NL + "\t\t";
  protected final String TEXT_478 = NL + "\t\tString fileName_";
  protected final String TEXT_479 = "=";
  protected final String TEXT_480 = ";";
  protected final String TEXT_481 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_482 = " = new java.io.File(fileName_";
  protected final String TEXT_483 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_484 = " = true;";
  protected final String TEXT_485 = NL + "\t\tif(file_";
  protected final String TEXT_486 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_487 = " = false;" + NL + "\t\t}";
  protected final String TEXT_488 = NL + "\t\tint nb_line_";
  protected final String TEXT_489 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_490 = " = new org.talend.ExcelTool();";
  protected final String TEXT_491 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_492 = "=";
  protected final String TEXT_493 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_494 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_495 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_496 = NL + "\t\txlsxTool_";
  protected final String TEXT_497 = ".setSheet(";
  protected final String TEXT_498 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_499 = ".setAppend(";
  protected final String TEXT_500 = ",";
  protected final String TEXT_501 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_502 = ".setXY(";
  protected final String TEXT_503 = ",";
  protected final String TEXT_504 = ",";
  protected final String TEXT_505 = ",";
  protected final String TEXT_506 = ");" + NL + "\t\t";
  protected final String TEXT_507 = NL + "\t\txlsxTool_";
  protected final String TEXT_508 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_509 = ");" + NL + "\t\t";
  protected final String TEXT_510 = NL + "\t\txlsxTool_";
  protected final String TEXT_511 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_512 = NL + "\t\txlsxTool_";
  protected final String TEXT_513 = ".setFont(\"";
  protected final String TEXT_514 = "\");" + NL + "\t\t";
  protected final String TEXT_515 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_516 = "{";
  protected final String TEXT_517 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_518 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_519 = ") throws java.lang.Exception {";
  protected final String TEXT_520 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_521 = ".addCellValue(\"";
  protected final String TEXT_522 = "\");";
  protected final String TEXT_523 = NL + "\t\t\t\t}";
  protected final String TEXT_524 = NL + "\t\t\t\t}";
  protected final String TEXT_525 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_526 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_527 = ") throws java.lang.Exception {";
  protected final String TEXT_528 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_529 = ".setColAutoSize(";
  protected final String TEXT_530 = ");";
  protected final String TEXT_531 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_532 = ".setColAutoSize(";
  protected final String TEXT_533 = ");";
  protected final String TEXT_534 = NL + "\t\t\t\t}";
  protected final String TEXT_535 = NL + "\t\t\t\t}";
  protected final String TEXT_536 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_537 = "(final ";
  protected final String TEXT_538 = "Struct ";
  protected final String TEXT_539 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_540 = ") throws java.lang.Exception {";
  protected final String TEXT_541 = NL + "\t\t\t\t";
  protected final String TEXT_542 = "\t\t\t\t\t";
  protected final String TEXT_543 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_544 = ".";
  protected final String TEXT_545 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_546 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_547 = ".addCellValue(";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = ", ";
  protected final String TEXT_550 = ");";
  protected final String TEXT_551 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_552 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_553 = ".";
  protected final String TEXT_554 = ")).toString());";
  protected final String TEXT_555 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_556 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_557 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_558 = "), ";
  protected final String TEXT_559 = ", ";
  protected final String TEXT_560 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_561 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_562 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_563 = ".";
  protected final String TEXT_564 = "), ";
  protected final String TEXT_565 = ", ";
  protected final String TEXT_566 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_567 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_568 = ".addCellValue((";
  protected final String TEXT_569 = ").doubleValue());";
  protected final String TEXT_570 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_571 = ".addCellValue(";
  protected final String TEXT_572 = ".";
  protected final String TEXT_573 = ");";
  protected final String TEXT_574 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_575 = ".addCellValue(";
  protected final String TEXT_576 = ".";
  protected final String TEXT_577 = ");";
  protected final String TEXT_578 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_579 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_580 = ".";
  protected final String TEXT_581 = ")));";
  protected final String TEXT_582 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_583 = ".addCellValue(String.valueOf(";
  protected final String TEXT_584 = ".";
  protected final String TEXT_585 = "));";
  protected final String TEXT_586 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_587 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_588 = NL + "\t\t\t\t}";
  protected final String TEXT_589 = NL + "\t\t\t\t}";
  protected final String TEXT_590 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_591 = " fileOutputExcelUtil_";
  protected final String TEXT_592 = "=new FileOutputExcelUtil_";
  protected final String TEXT_593 = "();";
  protected final String TEXT_594 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_595 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_596 = NL + "\t\txlsxTool_";
  protected final String TEXT_597 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_598 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_599 = ".putHeaderValue_";
  protected final String TEXT_600 = "(xlsxTool_";
  protected final String TEXT_601 = ");";
  protected final String TEXT_602 = NL + "\t\txlsxTool_";
  protected final String TEXT_603 = ".addCellValue(\"";
  protected final String TEXT_604 = "\");" + NL + "\t\t";
  protected final String TEXT_605 = NL + "\t\tnb_line_";
  protected final String TEXT_606 = "++;" + NL + "\t\t";
  protected final String TEXT_607 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_608 = NL;

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
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
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
    stringBuffer.append(ElementParameterParser.getValue(node, "__USESTREAM__"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getValue(node, "__VERSION_2007__"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SHEETNAME__"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ElementParameterParser.getValue(node, "__APPEND_FILE__"));
    stringBuffer.append(TEXT_64);
     if("true".equals(ElementParameterParser.getValue(node, "__APPEND_FILE__"))) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ElementParameterParser.getValue(node, "__APPEND_SHEET__"));
    stringBuffer.append(TEXT_68);
     } 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
    stringBuffer.append(TEXT_72);
     if("true".equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"))) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_X__"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_Y__"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
    stringBuffer.append(TEXT_82);
     } 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FONT__"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__"));
    stringBuffer.append(TEXT_89);
     if("true".equals(ElementParameterParser.getValue(node, "__VERSION_2007__"))) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    stringBuffer.append(TEXT_93);
     if("true".equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"))) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__"));
    stringBuffer.append(TEXT_97);
     } 
    stringBuffer.append(TEXT_98);
     } 
    stringBuffer.append(TEXT_99);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_106);
     } 
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
		}
		
		/* -------------------------- */
		log4jFileUtil.componentStartInfo(node);
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    
			}
		}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_148);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    
			} else {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_169);
    
			}
		}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_193);
    }else{
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    if(font !=null && font.length()!=0){
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(font !=null && font.length()!=0){

    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_224);
    
					}else{

    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_228);
    	
					}
				}else{

    stringBuffer.append(TEXT_229);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_237);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_240);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_251);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_253);
    
			}else{

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_260);
    
			}

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_269);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_270);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_271);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
				}
			}
			
			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_276);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_282);
    }else{
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_293);
    
            		}
        		}
     		}
     		
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_294);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_295);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_296);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
			}

    stringBuffer.append(TEXT_305);
    stringBuffer.append(TEXT_306);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_307);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_309);
    
    				} 
    				
    stringBuffer.append(TEXT_310);
    
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
   				
    stringBuffer.append(TEXT_311);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_312);
    if(keepCellFormating){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    }else{
    stringBuffer.append(TEXT_329);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    }
    stringBuffer.append(TEXT_336);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_337);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_340);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_341);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_343);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_346);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_347);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_349);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_350);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_351);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_352);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_353);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_354);
     } else { 
    stringBuffer.append(TEXT_355);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_357);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_359);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_360);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_361);
    
					}else {

    stringBuffer.append(TEXT_362);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_365);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_366);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
							}
							
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
					if(isNumber){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    
					}else{

    stringBuffer.append(TEXT_388);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    
					}else{

    stringBuffer.append(TEXT_404);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_418);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_419);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_420);
    
     	}

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
	}//TD64

    stringBuffer.append(TEXT_425);
    
if(isIncludeHeader){
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_428);
    
	}else{

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    
	}

    stringBuffer.append(TEXT_431);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_438);
    }
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    
        		} else {

    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_447);
    }
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_450);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_456);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_458);
    
		}else{

    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_463);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_465);
    
		}

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_474);
    
	}

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    
}

    stringBuffer.append(TEXT_477);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_480);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    
					}
				}
			}

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    		
		} 

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_506);
    if(!useStream){
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    }else{
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    }
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_514);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_517);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    
    			}

    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_522);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_523);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_524);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_525);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
        			
					}
    			}
    			
    			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_530);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_533);
    
            		}
    			}
    			
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_534);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_535);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_536);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
        			
    			}

    stringBuffer.append(TEXT_541);
    stringBuffer.append(TEXT_542);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_543);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_545);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_550);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_554);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_555);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_558);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_559);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_560);
     } else { 
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_564);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_565);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_566);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_569);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_573);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_577);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_581);
    
					}else{	

    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_585);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_588);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_589);
        		
    		}

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    
		}//TD1
		
		if(isIncludeHeader){
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    
			}
		
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_604);
    
			}
		
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_607);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_608);
    return stringBuffer.toString();
  }
}
