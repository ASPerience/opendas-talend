package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work\");" + NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Done.\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tStringBuilder log4jParamters_";
  protected final String TEXT_16 = " = new StringBuilder();" + NL + "\t\t\t   \tlog4jParamters_";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" - Parameters:\");" + NL + "\t\t\t   \t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_23 = ".append(\" | \");" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t   \t\tlog.debug(log4jParamters_";
  protected final String TEXT_25 = ");" + NL + "\t   \t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_28 = ") + \".\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_29 = " - Content of the record \" + (nb_line_";
  protected final String TEXT_30 = ") + \": \" + log4jSb_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_32 = ".delete(0,log4jSb_";
  protected final String TEXT_33 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_35 = " - Writing the record \" + nb_line_";
  protected final String TEXT_36 = " + \" to the file.\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_37 = " - Content of the record \" + nb_line_";
  protected final String TEXT_38 = " + \": \" + log4jSb_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_40 = ".delete(0,log4jSb_";
  protected final String TEXT_41 = ".length());";
  protected final String TEXT_42 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_43 = " - Written records count: \" + nb_line_";
  protected final String TEXT_44 = " + \" .\");";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "\t\t\tString log4jFileInputExcelParamters_";
  protected final String TEXT_47 = " = \"\";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_48 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_49 = " + \"FILENAME = \" + ";
  protected final String TEXT_50 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_51 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_52 = " + \"VERSION_2007 = \" + ";
  protected final String TEXT_53 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_54 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_55 = " + \"ALL_SHEETS = \" + ";
  protected final String TEXT_56 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_57 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_58 = " + \"HEADER = \" + ";
  protected final String TEXT_59 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_60 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_61 = " + \"FOOTER = \" + ";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_63 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_64 = " + \"AFFECT_EACH_SHEET = \" + ";
  protected final String TEXT_65 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_66 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_67 = " + \"LIMIT = \" + ";
  protected final String TEXT_68 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_69 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_70 = " + \"FIRST_COLUMN = \" + ";
  protected final String TEXT_71 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_72 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_73 = " + \"LAST_COLUMN = \" + ";
  protected final String TEXT_74 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_76 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_77 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_78 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_79 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_80 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_81 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_83 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_84 = " + \"TRIMALL = \" + ";
  protected final String TEXT_85 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_87 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_88 = " + \"READ_REAL_VALUE = \" + ";
  protected final String TEXT_89 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_90 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_91 = " + \"NOVALIDATE_ON_CELL = \" + ";
  protected final String TEXT_92 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_93 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_94 = " + \"SUPPRESS_WARN = \" + ";
  protected final String TEXT_95 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_97 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_98 = " + \"GENERATION_MODE = \" + \"";
  protected final String TEXT_99 = "\" + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_101 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_102 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_103 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_104 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_105 = " + \"DIE_ON_ERROR = \" + ";
  protected final String TEXT_106 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_107 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_108 = " + \"STOPREAD_ON_EMPTYROW = \" + ";
  protected final String TEXT_109 = " + \" | \";" + NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_110 = " = \"";
  protected final String TEXT_111 = " - Parameters:\" + log4jFileInputExcelParamters_";
  protected final String TEXT_112 = ";" + NL + "\t\t\tlog.debug(log4jFileInputExcelParamters_";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_115 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\tRegexUtil_";
  protected final String TEXT_116 = " regexUtil_";
  protected final String TEXT_117 = " = new RegexUtil_";
  protected final String TEXT_118 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_119 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_120 = ".setDrawingsDisabled(true);";
  protected final String TEXT_121 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_122 = ".setCellValidationDisabled(true);";
  protected final String TEXT_123 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_124 = ".setSuppressWarnings(true);";
  protected final String TEXT_125 = "\t\t" + NL + "        workbookSettings_";
  protected final String TEXT_126 = ".setEncoding(";
  protected final String TEXT_127 = ");" + NL + "        " + NL + "        Object source_";
  protected final String TEXT_128 = " =";
  protected final String TEXT_129 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_130 = ";" + NL + "        " + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_131 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_132 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_133 = " = (java.io.InputStream)source_";
  protected final String TEXT_134 = ";" + NL + "        \t\tworkbook_";
  protected final String TEXT_135 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_136 = "), workbookSettings_";
  protected final String TEXT_137 = ");" + NL + "            }else if(source_";
  protected final String TEXT_138 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_139 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_140 = ".toString());" + NL + "        \t\tworkbook_";
  protected final String TEXT_141 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_142 = "), workbookSettings_";
  protected final String TEXT_143 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_144 = " = null;" + NL + "            \t";
  protected final String TEXT_145 = NL + "            \t\tlog.fatal(\"";
  protected final String TEXT_146 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "            \t";
  protected final String TEXT_147 = NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            } " + NL + "        } finally {" + NL + "\t\t\tif(toClose_";
  protected final String TEXT_148 = "!=null) {" + NL + "\t\t\t\ttoClose_";
  protected final String TEXT_149 = ".close();" + NL + "    \t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_150 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_151 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_152 = ".getSheets());";
  protected final String TEXT_153 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_154 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_155 = NL + "        sheetList_";
  protected final String TEXT_156 = ".addAll(regexUtil_";
  protected final String TEXT_157 = ".getSheets(workbook_";
  protected final String TEXT_158 = ", ";
  protected final String TEXT_159 = ", ";
  protected final String TEXT_160 = "));";
  protected final String TEXT_161 = NL + "        if(sheetList_";
  protected final String TEXT_162 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_164 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_165 = NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "        " + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_166 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_167 = " : sheetList_";
  protected final String TEXT_168 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_169 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_170 = ".add(sheet_FilterNull_";
  protected final String TEXT_171 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_172 = " = sheet_FilterNullList_";
  protected final String TEXT_173 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_174 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_175 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = "0";
  protected final String TEXT_178 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = "0";
  protected final String TEXT_181 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_182 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_183 = ":sheetList_";
  protected final String TEXT_184 = "){" + NL + "        \tend_line_";
  protected final String TEXT_185 = "+=sheet_";
  protected final String TEXT_186 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_187 = " -= footer_input_";
  protected final String TEXT_188 = ";" + NL + "        int limit_";
  protected final String TEXT_189 = " = ";
  protected final String TEXT_190 = "-1";
  protected final String TEXT_191 = ";" + NL + "        int start_column_";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = "0";
  protected final String TEXT_194 = "-1";
  protected final String TEXT_195 = ";" + NL + "        int end_column_";
  protected final String TEXT_196 = " = sheetList_";
  protected final String TEXT_197 = ".get(0).getColumns();";
  protected final String TEXT_198 = NL + "        Integer lastColumn_";
  protected final String TEXT_199 = " = ";
  protected final String TEXT_200 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_201 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_202 = " = lastColumn_";
  protected final String TEXT_203 = ".intValue();" + NL + "        }";
  protected final String TEXT_204 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_205 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_206 = " = sheetList_";
  protected final String TEXT_207 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_208 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_209 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_210 = " = sheetList_";
  protected final String TEXT_211 = ".get(0).getRows();" + NL + "        " + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_212 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_213 = " = df_";
  protected final String TEXT_214 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_215 = NL + "        for(int i_";
  protected final String TEXT_216 = " = begin_line_";
  protected final String TEXT_217 = "; i_";
  protected final String TEXT_218 = " < end_line_";
  protected final String TEXT_219 = "; i_";
  protected final String TEXT_220 = "++){" + NL + "        " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_221 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_222 = " != -1 && nb_line_";
  protected final String TEXT_223 = " >= limit_";
  protected final String TEXT_224 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_225 = " >= rowCount_";
  protected final String TEXT_226 = " + currentRows_";
  protected final String TEXT_227 = ") {" + NL + "                rowCount_";
  protected final String TEXT_228 = " += currentRows_";
  protected final String TEXT_229 = ";" + NL + "                sheet_";
  protected final String TEXT_230 = " = sheetList_";
  protected final String TEXT_231 = ".get(++sheetIndex_";
  protected final String TEXT_232 = ");" + NL + "                currentRows_";
  protected final String TEXT_233 = " = sheet_";
  protected final String TEXT_234 = ".getRows();" + NL + "            }";
  protected final String TEXT_235 = NL + "            if (rowCount_";
  protected final String TEXT_236 = " <= i_";
  protected final String TEXT_237 = ") {" + NL + "                row_";
  protected final String TEXT_238 = " = sheet_";
  protected final String TEXT_239 = ".getRow(i_";
  protected final String TEXT_240 = " - rowCount_";
  protected final String TEXT_241 = ");" + NL + "            }";
  protected final String TEXT_242 = NL + "            if (rowCount_";
  protected final String TEXT_243 = " <= i_";
  protected final String TEXT_244 = " && i_";
  protected final String TEXT_245 = " - rowCount_";
  protected final String TEXT_246 = " >= begin_line_";
  protected final String TEXT_247 = " && currentRows_";
  protected final String TEXT_248 = " - footer_input_";
  protected final String TEXT_249 = " > i_";
  protected final String TEXT_250 = " - rowCount_";
  protected final String TEXT_251 = ") {" + NL + "                row_";
  protected final String TEXT_252 = " = sheet_";
  protected final String TEXT_253 = ".getRow(i_";
  protected final String TEXT_254 = " - rowCount_";
  protected final String TEXT_255 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_256 = "               " + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_257 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_258 = ".getName());";
  protected final String TEXT_259 = NL + "    \t\t";
  protected final String TEXT_260 = " = null;\t\t\t";
  protected final String TEXT_261 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_262 = " = new String[";
  protected final String TEXT_263 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_264 = " = end_column_";
  protected final String TEXT_265 = " >\trow_";
  protected final String TEXT_266 = ".length ? row_";
  protected final String TEXT_267 = ".length : end_column_";
  protected final String TEXT_268 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_269 = ";i++){" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_270 = " < actual_end_column_";
  protected final String TEXT_271 = "){" + NL + "\t\t\t\t" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_272 = " = row_";
  protected final String TEXT_273 = "[i + start_column_";
  protected final String TEXT_274 = "];";
  protected final String TEXT_275 = " " + NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_276 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_277 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_278 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_279 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_280 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_281 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_282 = "[i] = df_";
  protected final String TEXT_283 = ".format(doubleCell_";
  protected final String TEXT_284 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_285 = "[i] = cell_";
  protected final String TEXT_286 = ".getContents();" + NL + "                        }";
  protected final String TEXT_287 = NL + "                        temp_row_";
  protected final String TEXT_288 = "[i] = cell_";
  protected final String TEXT_289 = ".getContents();";
  protected final String TEXT_290 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_291 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_292 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_293 = " = new ";
  protected final String TEXT_294 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_295 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_296 = " = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_297 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_298 = "[";
  protected final String TEXT_299 = "]";
  protected final String TEXT_300 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_301 = "=";
  protected final String TEXT_302 = " + start_column_";
  protected final String TEXT_303 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_304 = " = \"";
  protected final String TEXT_305 = "\";";
  protected final String TEXT_306 = NL + "\t\t\t";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " = temp_row_";
  protected final String TEXT_309 = "[";
  protected final String TEXT_310 = "]";
  protected final String TEXT_311 = ";";
  protected final String TEXT_312 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_313 = "<actual_end_column_";
  protected final String TEXT_314 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_315 = " = ((jxl.DateCell)row_";
  protected final String TEXT_316 = "[";
  protected final String TEXT_317 = " + start_column_";
  protected final String TEXT_318 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_319 = ".";
  protected final String TEXT_320 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_321 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_322 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t";
  protected final String TEXT_324 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_325 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_326 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_327 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_329 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_330 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_331 = NL + "\t\t";
  protected final String TEXT_332 = ".";
  protected final String TEXT_333 = " = ParserUtils.parseTo_";
  protected final String TEXT_334 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_335 = "[";
  protected final String TEXT_336 = "]";
  protected final String TEXT_337 = ", ";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = "));";
  protected final String TEXT_340 = "\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_341 = ".";
  protected final String TEXT_342 = " = temp_row_";
  protected final String TEXT_343 = "[";
  protected final String TEXT_344 = "]";
  protected final String TEXT_345 = ".getBytes(";
  protected final String TEXT_346 = ");" + NL + "\t";
  protected final String TEXT_347 = NL + "\t\t\t";
  protected final String TEXT_348 = ".";
  protected final String TEXT_349 = " = ParserUtils.parseTo_";
  protected final String TEXT_350 = "(temp_row_";
  protected final String TEXT_351 = "[";
  protected final String TEXT_352 = "]";
  protected final String TEXT_353 = ");";
  protected final String TEXT_354 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_355 = NL + "\t\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_357 = " - Value is empty for column : '";
  protected final String TEXT_358 = "' in '";
  protected final String TEXT_359 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_361 = "' in '";
  protected final String TEXT_362 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_363 = NL + "\t\t\t\t";
  protected final String TEXT_364 = ".";
  protected final String TEXT_365 = " = ";
  protected final String TEXT_366 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_367 = "++;";
  protected final String TEXT_368 = NL + "\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_369 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_370 = ".append(";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_373 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_374 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_376 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_377 = " ";
  protected final String TEXT_378 = " = null; ";
  protected final String TEXT_379 = NL;
  protected final String TEXT_380 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_381 = " == ";
  protected final String TEXT_382 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_383 = "  " + NL + "\t\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_384 = " = true;";
  protected final String TEXT_385 = NL + "\t        ";
  protected final String TEXT_386 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_387 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_388 = NL + "            throw(e);";
  protected final String TEXT_389 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_390 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_391 = NL + "                    ";
  protected final String TEXT_392 = " = new ";
  protected final String TEXT_393 = "Struct();";
  protected final String TEXT_394 = NL + "                    ";
  protected final String TEXT_395 = ".";
  protected final String TEXT_396 = " = ";
  protected final String TEXT_397 = ".";
  protected final String TEXT_398 = ";";
  protected final String TEXT_399 = NL + "                ";
  protected final String TEXT_400 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_401 = "+ \" column: \" + curColName_";
  protected final String TEXT_402 = " + \" (No. \" + curColNum_";
  protected final String TEXT_403 = " + \")\";";
  protected final String TEXT_404 = NL + "                ";
  protected final String TEXT_405 = " = null;";
  protected final String TEXT_406 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_407 = NL + "                ";
  protected final String TEXT_408 = " = null;";
  protected final String TEXT_409 = NL + "            \t";
  protected final String TEXT_410 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_411 = "+ \" column: \" + curColName_";
  protected final String TEXT_412 = " + \" (No. \" + curColNum_";
  protected final String TEXT_413 = " + \")\";";
  protected final String TEXT_414 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_415 = NL + "\t\t";
  protected final String TEXT_416 = "if(!whetherReject_";
  protected final String TEXT_417 = ") { ";
  protected final String TEXT_418 = "      " + NL + "             if(";
  protected final String TEXT_419 = " == null){ " + NL + "            \t ";
  protected final String TEXT_420 = " = new ";
  protected final String TEXT_421 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_422 = NL + "\t    \t ";
  protected final String TEXT_423 = ".";
  protected final String TEXT_424 = " = ";
  protected final String TEXT_425 = ".";
  protected final String TEXT_426 = ";    \t\t\t\t";
  protected final String TEXT_427 = NL + "\t\t";
  protected final String TEXT_428 = " } ";
  protected final String TEXT_429 = "\t";
  protected final String TEXT_430 = NL + "\t\t\torg.apache.log4j.Logger logger_";
  protected final String TEXT_431 = " = org.apache.log4j.Logger.getLogger(\"org.openxml4j.opc\");" + NL + "\t        logger_";
  protected final String TEXT_432 = ".setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_433 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_434 = " regexUtil_";
  protected final String TEXT_435 = " = new RegexUtil_";
  protected final String TEXT_436 = "();" + NL + "\t\t" + NL + "\t\tObject source_";
  protected final String TEXT_437 = " = ";
  protected final String TEXT_438 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_439 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_440 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_441 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_442 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_443 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_444 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_445 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_446 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_447 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_448 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_449 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t";
  protected final String TEXT_450 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_451 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_452 = ":workbook_";
  protected final String TEXT_453 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_454 = ".add(sheet_";
  protected final String TEXT_455 = ");" + NL + "    \t}";
  protected final String TEXT_456 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_457 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_458 = NL + "        sheetList_";
  protected final String TEXT_459 = ".addAll(regexUtil_";
  protected final String TEXT_460 = ".getSheets(workbook_";
  protected final String TEXT_461 = ", ";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = "));";
  protected final String TEXT_464 = NL + "    \tif(sheetList_";
  protected final String TEXT_465 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_467 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_468 = NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "\t\t" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_469 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_470 = " : sheetList_";
  protected final String TEXT_471 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_472 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_473 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_474 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_475 = ".add(sheet_FilterNull_";
  protected final String TEXT_476 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_477 = " = sheetList_FilterNull_";
  protected final String TEXT_478 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_479 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_480 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_481 = " = ";
  protected final String TEXT_482 = "0";
  protected final String TEXT_483 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_484 = " = ";
  protected final String TEXT_485 = "0";
  protected final String TEXT_486 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_487 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_488 = ":sheetList_";
  protected final String TEXT_489 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_490 = "+=(sheet_";
  protected final String TEXT_491 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_492 = " -= footer_input_";
  protected final String TEXT_493 = ";" + NL + "        int limit_";
  protected final String TEXT_494 = " = ";
  protected final String TEXT_495 = "-1";
  protected final String TEXT_496 = ";" + NL + "        int start_column_";
  protected final String TEXT_497 = " = ";
  protected final String TEXT_498 = "0";
  protected final String TEXT_499 = "-1";
  protected final String TEXT_500 = ";" + NL + "        int end_column_";
  protected final String TEXT_501 = " = -1;";
  protected final String TEXT_502 = "       " + NL + "        Integer lastColumn_";
  protected final String TEXT_503 = " = ";
  protected final String TEXT_504 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_505 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_506 = " = lastColumn_";
  protected final String TEXT_507 = ".intValue();" + NL + "        }        ";
  protected final String TEXT_508 = NL + "        " + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_509 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_510 = " = sheetList_";
  protected final String TEXT_511 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_512 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_513 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_514 = " = (sheetList_";
  protected final String TEXT_515 = ".get(0).getLastRowNum()+1);" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_516 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_517 = " = df_";
  protected final String TEXT_518 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_519 = NL + "        for(int i_";
  protected final String TEXT_520 = " = begin_line_";
  protected final String TEXT_521 = "; i_";
  protected final String TEXT_522 = " < end_line_";
  protected final String TEXT_523 = "; i_";
  protected final String TEXT_524 = "++){" + NL + "       " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_525 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_526 = " != -1 && nb_line_";
  protected final String TEXT_527 = " >= limit_";
  protected final String TEXT_528 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_529 = " >= rowCount_";
  protected final String TEXT_530 = " + currentRows_";
  protected final String TEXT_531 = ") {" + NL + "                rowCount_";
  protected final String TEXT_532 = " += currentRows_";
  protected final String TEXT_533 = ";" + NL + "                sheet_";
  protected final String TEXT_534 = " = sheetList_";
  protected final String TEXT_535 = ".get(++sheetIndex_";
  protected final String TEXT_536 = ");" + NL + "                currentRows_";
  protected final String TEXT_537 = " = (sheet_";
  protected final String TEXT_538 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_539 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_540 = ".getSheetName());";
  protected final String TEXT_541 = NL + "            if (rowCount_";
  protected final String TEXT_542 = " <= i_";
  protected final String TEXT_543 = ") {" + NL + "                row_";
  protected final String TEXT_544 = " = sheet_";
  protected final String TEXT_545 = ".getRow(i_";
  protected final String TEXT_546 = " - rowCount_";
  protected final String TEXT_547 = ");" + NL + "            }";
  protected final String TEXT_548 = NL + "            if (rowCount_";
  protected final String TEXT_549 = " <= i_";
  protected final String TEXT_550 = " && i_";
  protected final String TEXT_551 = " - rowCount_";
  protected final String TEXT_552 = " >= begin_line_";
  protected final String TEXT_553 = " && currentRows_";
  protected final String TEXT_554 = " - footer_input_";
  protected final String TEXT_555 = " > i_";
  protected final String TEXT_556 = " - rowCount_";
  protected final String TEXT_557 = ") {" + NL + "                row_";
  protected final String TEXT_558 = " = sheet_";
  protected final String TEXT_559 = ".getRow(i_";
  protected final String TEXT_560 = " - rowCount_";
  protected final String TEXT_561 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_562 = "          ";
  protected final String TEXT_563 = NL + "\t\t    ";
  protected final String TEXT_564 = " = null;\t\t\t";
  protected final String TEXT_565 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_566 = " = new String[";
  protected final String TEXT_567 = "];";
  protected final String TEXT_568 = "\t\t\t\t" + NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_569 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_570 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_571 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_572 = ".add(";
  protected final String TEXT_573 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_574 = ".add(";
  protected final String TEXT_575 = ");";
  protected final String TEXT_576 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_577 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_578 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_579 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_580 = "=row_";
  protected final String TEXT_581 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_582 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_583 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_584 = " = excel_end_column_";
  protected final String TEXT_585 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_586 = " = end_column_";
  protected final String TEXT_587 = " >\texcel_end_column_";
  protected final String TEXT_588 = " ? excel_end_column_";
  protected final String TEXT_589 = " : end_column_";
  protected final String TEXT_590 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_591 = " = null;" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_592 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_593 = " < actual_end_column_";
  protected final String TEXT_594 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_595 = " = row_";
  protected final String TEXT_596 = ".getCell(i + start_column_";
  protected final String TEXT_597 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_598 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_599 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_600 = "[i] = cell_";
  protected final String TEXT_601 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_602 = ")) {";
  protected final String TEXT_603 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_604 = ".get(i)){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_605 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_606 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_607 = ".get(i));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_608 = "[i] = cell_";
  protected final String TEXT_609 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_610 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_611 = "[i] =cell_";
  protected final String TEXT_612 = ".getDateCellValue().toString();";
  protected final String TEXT_613 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_614 = "[i] = df_";
  protected final String TEXT_615 = ".format(cell_";
  protected final String TEXT_616 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_617 = "[i] =String.valueOf(cell_";
  protected final String TEXT_618 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_619 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_620 = "[i] = cell_";
  protected final String TEXT_621 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_622 = ")) {";
  protected final String TEXT_623 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_624 = ".get(i)){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_625 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_626 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_627 = ".get(i));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_628 = "[i] =cell_";
  protected final String TEXT_629 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_630 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_631 = "[i] =cell_";
  protected final String TEXT_632 = ".getDateCellValue().toString();";
  protected final String TEXT_633 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_634 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_635 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_636 = "[i] = ne_";
  protected final String TEXT_637 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_638 = "[i] =String.valueOf(cell_";
  protected final String TEXT_639 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_640 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_641 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_642 = "[i]=\"\";" + NL + "                \t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_643 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_644 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_645 = " = new ";
  protected final String TEXT_646 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_647 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_648 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_649 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_650 = "[";
  protected final String TEXT_651 = "]";
  protected final String TEXT_652 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_653 = "=";
  protected final String TEXT_654 = " + start_column_";
  protected final String TEXT_655 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_656 = " = \"";
  protected final String TEXT_657 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_658 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = " = temp_row_";
  protected final String TEXT_661 = "[";
  protected final String TEXT_662 = "]";
  protected final String TEXT_663 = ";";
  protected final String TEXT_664 = "\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_665 = "<actual_end_column_";
  protected final String TEXT_666 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_667 = ".getCell(";
  protected final String TEXT_668 = "+ start_column_";
  protected final String TEXT_669 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_670 = ".getCell(";
  protected final String TEXT_671 = "+ start_column_";
  protected final String TEXT_672 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_673 = ".";
  protected final String TEXT_674 = " = row_";
  protected final String TEXT_675 = ".getCell(";
  protected final String TEXT_676 = "+ start_column_";
  protected final String TEXT_677 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_678 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_679 = "[";
  protected final String TEXT_680 = "]";
  protected final String TEXT_681 = ", ";
  protected final String TEXT_682 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_683 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_684 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_685 = NL + "\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_686 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_687 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_688 = " + \" )\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_689 = NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_690 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_691 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_692 = NL + "                                ";
  protected final String TEXT_693 = ".";
  protected final String TEXT_694 = " = tempDate_";
  protected final String TEXT_695 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_696 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_697 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_698 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_699 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_700 = " + \" )\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_701 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_702 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_703 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_704 = NL + "\t\t\t\t";
  protected final String TEXT_705 = ".";
  protected final String TEXT_706 = " = ParserUtils.parseTo_";
  protected final String TEXT_707 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_708 = "[";
  protected final String TEXT_709 = "]";
  protected final String TEXT_710 = ", ";
  protected final String TEXT_711 = ", ";
  protected final String TEXT_712 = "));";
  protected final String TEXT_713 = NL + "\t\t\t\t";
  protected final String TEXT_714 = ".";
  protected final String TEXT_715 = " = ParserUtils.parseTo_";
  protected final String TEXT_716 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_717 = "[";
  protected final String TEXT_718 = "]";
  protected final String TEXT_719 = ", null, '.'==decimalChar_";
  protected final String TEXT_720 = " ? null : decimalChar_";
  protected final String TEXT_721 = "));";
  protected final String TEXT_722 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_723 = ".";
  protected final String TEXT_724 = " = temp_row_";
  protected final String TEXT_725 = "[";
  protected final String TEXT_726 = "]";
  protected final String TEXT_727 = ".getBytes(";
  protected final String TEXT_728 = ");";
  protected final String TEXT_729 = NL + "\t\t\t\t";
  protected final String TEXT_730 = ".";
  protected final String TEXT_731 = " = ParserUtils.parseTo_";
  protected final String TEXT_732 = "(temp_row_";
  protected final String TEXT_733 = "[";
  protected final String TEXT_734 = "]";
  protected final String TEXT_735 = ");";
  protected final String TEXT_736 = NL + "\t\t\t}else{";
  protected final String TEXT_737 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_738 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_739 = " - Value is empty for column : '";
  protected final String TEXT_740 = "' in '";
  protected final String TEXT_741 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_742 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_743 = "' in '";
  protected final String TEXT_744 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_745 = NL + "\t\t\t\t";
  protected final String TEXT_746 = ".";
  protected final String TEXT_747 = " = ";
  protected final String TEXT_748 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_749 = "++;";
  protected final String TEXT_750 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_751 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_752 = ".append(";
  protected final String TEXT_753 = ".";
  protected final String TEXT_754 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_755 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_756 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_757 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_758 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_759 = "\t";
  protected final String TEXT_760 = " ";
  protected final String TEXT_761 = " = null; ";
  protected final String TEXT_762 = NL;
  protected final String TEXT_763 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_764 = " == ";
  protected final String TEXT_765 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_766 = "  " + NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_767 = " = true;";
  protected final String TEXT_768 = NL + "\t\t\t\t";
  protected final String TEXT_769 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_770 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_771 = NL + "\t            throw(e);";
  protected final String TEXT_772 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_773 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_774 = NL + "\t\t\t\t\t";
  protected final String TEXT_775 = " = new ";
  protected final String TEXT_776 = "Struct();";
  protected final String TEXT_777 = NL + "\t\t\t\t\t";
  protected final String TEXT_778 = ".";
  protected final String TEXT_779 = " = ";
  protected final String TEXT_780 = ".";
  protected final String TEXT_781 = ";";
  protected final String TEXT_782 = NL + "\t\t\t\t\t";
  protected final String TEXT_783 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_784 = "+ \" column: \" + curColName_";
  protected final String TEXT_785 = " + \" (No. \" + curColNum_";
  protected final String TEXT_786 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_787 = " = null;";
  protected final String TEXT_788 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_789 = " = null;";
  protected final String TEXT_790 = NL + "\t\t\t\t\t";
  protected final String TEXT_791 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_792 = "+ \" column: \" + curColName_";
  protected final String TEXT_793 = " + \" (No. \" + curColNum_";
  protected final String TEXT_794 = " + \")\";";
  protected final String TEXT_795 = NL + "\t\t\t}\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_796 = NL + "\t\t";
  protected final String TEXT_797 = "if(!whetherReject_";
  protected final String TEXT_798 = ") { ";
  protected final String TEXT_799 = "      " + NL + "             if(";
  protected final String TEXT_800 = " == null){ " + NL + "            \t ";
  protected final String TEXT_801 = " = new ";
  protected final String TEXT_802 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_803 = NL + "\t    \t ";
  protected final String TEXT_804 = ".";
  protected final String TEXT_805 = " = ";
  protected final String TEXT_806 = ".";
  protected final String TEXT_807 = ";    \t\t\t\t";
  protected final String TEXT_808 = NL + "\t\t";
  protected final String TEXT_809 = " } ";
  protected final String TEXT_810 = "\t";
  protected final String TEXT_811 = NL + "\t\tObject source_";
  protected final String TEXT_812 = " = ";
  protected final String TEXT_813 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_814 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_815 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_816 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_817 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_818 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_819 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_820 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {";
  protected final String TEXT_821 = NL + "\t\texcelReader_";
  protected final String TEXT_822 = ".addSheetName(\".*\",true);";
  protected final String TEXT_823 = NL + "\t\texcelReader_";
  protected final String TEXT_824 = ".addSheetName(";
  protected final String TEXT_825 = ", ";
  protected final String TEXT_826 = ");";
  protected final String TEXT_827 = NL + "\t\tint start_column_";
  protected final String TEXT_828 = " = ";
  protected final String TEXT_829 = "0";
  protected final String TEXT_830 = "-1";
  protected final String TEXT_831 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_832 = " = ";
  protected final String TEXT_833 = "-1";
  protected final String TEXT_834 = "-1";
  protected final String TEXT_835 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_836 = " >=0) {//follow start column" + NL + "\t\t\tend_column_";
  protected final String TEXT_837 = " = start_column_";
  protected final String TEXT_838 = " + ";
  protected final String TEXT_839 = " - 1;" + NL + "\t\t} else if(end_column_";
  protected final String TEXT_840 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_841 = " = end_column_";
  protected final String TEXT_842 = " - ";
  protected final String TEXT_843 = " + 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(end_column_";
  protected final String TEXT_844 = "<0 || start_column_";
  protected final String TEXT_845 = "<0) {" + NL + "\t\t\t";
  protected final String TEXT_846 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_847 = " - Error start column and end column.\");" + NL + "\t\t\t";
  protected final String TEXT_848 = NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tint header_";
  protected final String TEXT_849 = " = ";
  protected final String TEXT_850 = "0";
  protected final String TEXT_851 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_852 = " = ";
  protected final String TEXT_853 = "-1";
  protected final String TEXT_854 = ";" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_855 = " = 0;" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_856 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_857 = " = df_";
  protected final String TEXT_858 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_859 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_860 = ".parse((String)source_";
  protected final String TEXT_861 = ",";
  protected final String TEXT_862 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_863 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_864 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_865 = ",";
  protected final String TEXT_866 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\twhile((header_";
  protected final String TEXT_867 = "--)>0 && excelReader_";
  protected final String TEXT_868 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_869 = ".next();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_870 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_871 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_872 = " = 0;" + NL + "\t\t" + NL + "\t\t\tif (limit_";
  protected final String TEXT_873 = " != -1 && nb_line_";
  protected final String TEXT_874 = " >= limit_";
  protected final String TEXT_875 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_876 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_877 = " = excelReader_";
  protected final String TEXT_878 = ".next();";
  protected final String TEXT_879 = NL + "\t\t";
  protected final String TEXT_880 = " = null;\t\t\t";
  protected final String TEXT_881 = NL + "\t\tString[] temp_row_";
  protected final String TEXT_882 = " = new String[";
  protected final String TEXT_883 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_884 = "=0;i_";
  protected final String TEXT_885 = " < ";
  protected final String TEXT_886 = ";i_";
  protected final String TEXT_887 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_888 = " = i_";
  protected final String TEXT_889 = " + start_column_";
  protected final String TEXT_890 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_891 = " <= end_column_";
  protected final String TEXT_892 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_893 = " < row_";
  protected final String TEXT_894 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_895 = " = row_";
  protected final String TEXT_896 = ".get(current_";
  protected final String TEXT_897 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_898 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_899 = "[i_";
  protected final String TEXT_900 = "] = column_";
  protected final String TEXT_901 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_902 = "[i_";
  protected final String TEXT_903 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_904 = "[i_";
  protected final String TEXT_905 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_906 = "[i_";
  protected final String TEXT_907 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_908 = " = false;" + NL + "\t\t";
  protected final String TEXT_909 = " = new ";
  protected final String TEXT_910 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_911 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_912 = " = \"\";" + NL + "\t\t" + NL + "\t\ttry{";
  protected final String TEXT_913 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_914 = "[";
  protected final String TEXT_915 = "]";
  protected final String TEXT_916 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_917 = "=";
  protected final String TEXT_918 = " + start_column_";
  protected final String TEXT_919 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_920 = " = \"";
  protected final String TEXT_921 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_922 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_923 = ".";
  protected final String TEXT_924 = " = temp_row_";
  protected final String TEXT_925 = "[";
  protected final String TEXT_926 = "]";
  protected final String TEXT_927 = ";";
  protected final String TEXT_928 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_929 = ".";
  protected final String TEXT_930 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_931 = "[";
  protected final String TEXT_932 = "]";
  protected final String TEXT_933 = ", ";
  protected final String TEXT_934 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_935 = NL + "\t\t\t\t\t";
  protected final String TEXT_936 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_937 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_938 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_939 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_940 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_941 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_942 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_943 = NL + "\t\t\t\t";
  protected final String TEXT_944 = ".";
  protected final String TEXT_945 = " = ParserUtils.parseTo_";
  protected final String TEXT_946 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_947 = "[";
  protected final String TEXT_948 = "]";
  protected final String TEXT_949 = ", ";
  protected final String TEXT_950 = ", ";
  protected final String TEXT_951 = "));";
  protected final String TEXT_952 = NL + "\t\t\t\t";
  protected final String TEXT_953 = ".";
  protected final String TEXT_954 = " = ParserUtils.parseTo_";
  protected final String TEXT_955 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_956 = "[";
  protected final String TEXT_957 = "]";
  protected final String TEXT_958 = ", null, '.'==decimalChar_";
  protected final String TEXT_959 = " ? null : decimalChar_";
  protected final String TEXT_960 = "));";
  protected final String TEXT_961 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_962 = ".";
  protected final String TEXT_963 = " = temp_row_";
  protected final String TEXT_964 = "[";
  protected final String TEXT_965 = "]";
  protected final String TEXT_966 = ".getBytes(";
  protected final String TEXT_967 = ");";
  protected final String TEXT_968 = NL + "\t\t\t\t";
  protected final String TEXT_969 = ".";
  protected final String TEXT_970 = " = ParserUtils.parseTo_";
  protected final String TEXT_971 = "(temp_row_";
  protected final String TEXT_972 = "[";
  protected final String TEXT_973 = "]";
  protected final String TEXT_974 = ");";
  protected final String TEXT_975 = NL + "\t\t\t}else{";
  protected final String TEXT_976 = NL + "\t\t\t\t\t";
  protected final String TEXT_977 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_978 = " - Value is empty for column : '";
  protected final String TEXT_979 = "' in '";
  protected final String TEXT_980 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_981 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_982 = "' in '";
  protected final String TEXT_983 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_984 = NL + "\t\t\t\t";
  protected final String TEXT_985 = ".";
  protected final String TEXT_986 = " = ";
  protected final String TEXT_987 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_988 = "++;";
  protected final String TEXT_989 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_990 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_991 = ".append(";
  protected final String TEXT_992 = ".";
  protected final String TEXT_993 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_994 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_995 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_996 = NL;
  protected final String TEXT_997 = " ";
  protected final String TEXT_998 = " = null; ";
  protected final String TEXT_999 = NL;
  protected final String TEXT_1000 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_1001 = " == ";
  protected final String TEXT_1002 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_1003 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_1004 = " = true;";
  protected final String TEXT_1005 = NL + "\t\t\t\t";
  protected final String TEXT_1006 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1007 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_1008 = NL + "\t            throw(e);";
  protected final String TEXT_1009 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1010 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1011 = NL + "\t\t\t\t\t";
  protected final String TEXT_1012 = " = new ";
  protected final String TEXT_1013 = "Struct();";
  protected final String TEXT_1014 = NL + "\t\t\t\t\t";
  protected final String TEXT_1015 = ".";
  protected final String TEXT_1016 = " = ";
  protected final String TEXT_1017 = ".";
  protected final String TEXT_1018 = ";";
  protected final String TEXT_1019 = NL + "\t\t\t\t\t";
  protected final String TEXT_1020 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1021 = "+ \" column: \" + curColName_";
  protected final String TEXT_1022 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1023 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1024 = " = null;";
  protected final String TEXT_1025 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_1026 = " = null;";
  protected final String TEXT_1027 = NL + "\t\t\t\t\t";
  protected final String TEXT_1028 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1029 = "+ \" column: \" + curColName_";
  protected final String TEXT_1030 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1031 = " + \")\";";
  protected final String TEXT_1032 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_1033 = NL + "        \t\t";
  protected final String TEXT_1034 = "if(!whetherReject_";
  protected final String TEXT_1035 = ") { ";
  protected final String TEXT_1036 = "      " + NL + "                     if(";
  protected final String TEXT_1037 = " == null){ " + NL + "                    \t ";
  protected final String TEXT_1038 = " = new ";
  protected final String TEXT_1039 = "Struct();" + NL + "                     }\t\t\t\t";
  protected final String TEXT_1040 = NL + "        \t    \t ";
  protected final String TEXT_1041 = ".";
  protected final String TEXT_1042 = " = ";
  protected final String TEXT_1043 = ".";
  protected final String TEXT_1044 = ";    \t\t\t\t";
  protected final String TEXT_1045 = NL + "        \t\t";
  protected final String TEXT_1046 = " } ";
  protected final String TEXT_1047 = "\t";
  protected final String TEXT_1048 = NL;
  protected final String TEXT_1049 = NL;
  protected final String TEXT_1050 = NL;
  protected final String TEXT_1051 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logParameters(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
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
		   			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		   		}
		   		
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	   		}
		}

		//for all tFileinput* components
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    		
			}
		}
		
		//for all tFileOutput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    		
			}
		}
		
		//for all tFileOutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_45);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");
	
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));
		
		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		boolean eventMode = "EVENT_MODE".equals(mode);
		
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			
		/* Build the Log4J message for the different parameters */
	
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node, "__VERSION_2007__"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ALL_SHEETS__"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HEADER__"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FOOTER__"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getValue(node, "__AFFECT_EACH_SHEET__"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LIMIT__"))?"\"\"":ElementParameterParser.getValue(node, "__LIMIT__"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_COLUMN__"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LAST_COLUMN__"))?"\"\"":ElementParameterParser.getValue(node, "__LAST_COLUMN__"));
    stringBuffer.append(TEXT_74);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_81);
     } 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TRIMALL__"));
    stringBuffer.append(TEXT_85);
     if("false".equals(ElementParameterParser.getValue(node, "__VERSION_2007__"))) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__NOVALIDATE_ON_CELL__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SUPPRESS_WARN__"));
    stringBuffer.append(TEXT_95);
     } else { 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GENERATION_MODE__"));
    stringBuffer.append(TEXT_99);
     } 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STOPREAD_ON_EMPTYROW__"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		}
		
		/* -------------------------- */
		log4jFileUtil.componentStartInfo(node);
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    
		}

    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
          
		if(isAllSheets){

    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    
		}else{

    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_160);
    
			}
		}

    stringBuffer.append(TEXT_161);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_162);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_176);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_177);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_180);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_190);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_192);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_193);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_234);
    
	if(!affect){

    stringBuffer.append(TEXT_235);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_241);
    
	}else{

    stringBuffer.append(TEXT_242);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    
    }

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    
//begin
//
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

    stringBuffer.append(TEXT_259);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_260);
    
    				}
    			}
    		}
    	}
    	
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_261);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_263);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_269);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_274);
    
                    if(bReadRealValue){

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    
                    }else{

    stringBuffer.append(TEXT_287);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
                    }

    stringBuffer.append(TEXT_290);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_299);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_302);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_305);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_306);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_310);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_311);
    		
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_312);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_313);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_317);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_323);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    }
    stringBuffer.append(TEXT_328);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    
//start			
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_331);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_336);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_337);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_339);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
	
    stringBuffer.append(TEXT_340);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_344);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_346);
    
			} else {
//
//end
    stringBuffer.append(TEXT_347);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_352);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_353);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_354);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_355);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_359);
    }
    stringBuffer.append(TEXT_360);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_362);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_363);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_368);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_372);
    if(i < size-1){
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    }
						}
    
//start
//
					}
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_377);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_378);
    }
    stringBuffer.append(TEXT_379);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_380);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_382);
    
	}

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_385);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    }
    stringBuffer.append(TEXT_388);
    
        } else {
	        if(isLog4jEnabled){
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_391);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_393);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_394);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_398);
    
                }
                
    stringBuffer.append(TEXT_399);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_405);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_406);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_408);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_409);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    }
        } 
        
    stringBuffer.append(TEXT_414);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_415);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_421);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_426);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_427);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_428);
     } 
    stringBuffer.append(TEXT_429);
    
		}
		}

    	
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    }
    stringBuffer.append(TEXT_449);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_450);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    
		}else{

    stringBuffer.append(TEXT_456);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_457);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_458);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_462);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_463);
    
			}
		}

    stringBuffer.append(TEXT_464);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_465);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    }
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_481);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_482);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_483);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_484);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_485);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_486);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_494);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_495);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_496);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_497);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_498);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_499);
    }
    stringBuffer.append(TEXT_500);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_501);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    }
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_519);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    
	if(!affect){

    stringBuffer.append(TEXT_541);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_547);
    
	}else{

    stringBuffer.append(TEXT_548);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_561);
    
    }

    stringBuffer.append(TEXT_562);
    
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

    stringBuffer.append(TEXT_563);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_564);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3	 
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_565);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_567);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    	
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");				
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_575);
    
						}
					}
				}	
			}

    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_592);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    
								if(converDatetoString){

    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    
								}else{

    stringBuffer.append(TEXT_610);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    
								}

    stringBuffer.append(TEXT_613);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    
										if(converDatetoString){

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
										}else{

    stringBuffer.append(TEXT_630);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    
										}

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_651);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_654);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_657);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_658);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_662);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_663);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_664);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_665);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_668);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_671);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_674);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_676);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_680);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_681);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    }
    stringBuffer.append(TEXT_689);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_696);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    }
    stringBuffer.append(TEXT_701);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_704);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_706);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_709);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_710);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_711);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_712);
    
							} else {

    stringBuffer.append(TEXT_713);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_715);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_718);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_721);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_722);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_726);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_728);
    
						} else {

    stringBuffer.append(TEXT_729);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_730);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_731);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_734);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_735);
    
						}

    stringBuffer.append(TEXT_736);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_737);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_740);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_741);
    }
    stringBuffer.append(TEXT_742);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_743);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_744);
    
						} else {

    stringBuffer.append(TEXT_745);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_746);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_748);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_749);
    
						}

    stringBuffer.append(TEXT_750);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_754);
    if(i < size-1){
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    }
						}
    
					}

    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_759);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_760);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_761);
    }
    stringBuffer.append(TEXT_762);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_763);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_765);
    
	}

    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_767);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_768);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    }
    stringBuffer.append(TEXT_771);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_774);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_776);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_777);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_779);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_781);
    
					    }//16

    stringBuffer.append(TEXT_782);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_787);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_788);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_789);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_790);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    
					}//15
				}

    stringBuffer.append(TEXT_795);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_796);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_799);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_800);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_802);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_803);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_804);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_805);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_806);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_807);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_808);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_809);
     } 
    stringBuffer.append(TEXT_810);
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_812);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    }
    stringBuffer.append(TEXT_820);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_825);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_826);
    
				}
			}

    stringBuffer.append(TEXT_827);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_828);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_829);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_830);
    }
    stringBuffer.append(TEXT_831);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_832);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_833);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_834);
    }
    stringBuffer.append(TEXT_835);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_836);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_837);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_838);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_839);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_840);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_841);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_842);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_843);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_844);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_845);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    }
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_850);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_852);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_853);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_854);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_865);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_869);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_872);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_873);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_874);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    
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

    stringBuffer.append(TEXT_879);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_880);
    
    		    		}
    		    	}
    		    }
			}
			
			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256

    stringBuffer.append(TEXT_881);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_882);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_891);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_892);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_904);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_905);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_912);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_914);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_915);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_917);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_918);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_920);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_921);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_922);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_923);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_925);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_926);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_927);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_928);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_929);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_931);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_932);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_933);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_934);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_935);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_939);
    }
    stringBuffer.append(TEXT_940);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_942);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_943);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_944);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_945);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_947);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_948);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_949);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_950);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_951);
    
							} else {

    stringBuffer.append(TEXT_952);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_953);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_954);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_956);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_957);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_960);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_961);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_962);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_964);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_965);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_966);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_967);
    
						} else {

    stringBuffer.append(TEXT_968);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_969);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_970);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_971);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_972);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_973);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_974);
    
						}

    stringBuffer.append(TEXT_975);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_976);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_979);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_980);
    }
    stringBuffer.append(TEXT_981);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_982);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_983);
    
						} else {

    stringBuffer.append(TEXT_984);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_985);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_986);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_987);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_988);
    
						}

    stringBuffer.append(TEXT_989);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_990);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_992);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_993);
    if(i < size-1){
    stringBuffer.append(TEXT_994);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_995);
    }
						}
    
					}//TD128

    stringBuffer.append(TEXT_996);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_997);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_998);
    }
    stringBuffer.append(TEXT_999);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_1000);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_1002);
    
	}

    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1004);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_1005);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    }
    stringBuffer.append(TEXT_1008);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_1011);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1013);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_1014);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1018);
    
					    }//16

    stringBuffer.append(TEXT_1019);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1024);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_1025);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1026);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_1027);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1031);
    
					}//15
				}

    stringBuffer.append(TEXT_1032);
    
    				}//TD256
				}//TD528
				
        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_1033);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1035);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1039);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_1040);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1044);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_1045);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_1046);
     } 
    stringBuffer.append(TEXT_1047);
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_1048);
    
		}//end version judgement

    stringBuffer.append(TEXT_1049);
    
	}
}
//
//end
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(TEXT_1051);
    return stringBuffer.toString();
  }
}
