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
  protected final String TEXT_2 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_3 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\tRegexUtil_";
  protected final String TEXT_4 = " regexUtil_";
  protected final String TEXT_5 = " = new RegexUtil_";
  protected final String TEXT_6 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_7 = " = new jxl.WorkbookSettings();";
  protected final String TEXT_8 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_9 = ".setCellValidationDisabled(true);";
  protected final String TEXT_10 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_11 = ".setSuppressWarnings(true);";
  protected final String TEXT_12 = "\t\t" + NL + "        workbookSettings_";
  protected final String TEXT_13 = ".setEncoding(";
  protected final String TEXT_14 = ");" + NL + "        " + NL + "        Object source_";
  protected final String TEXT_15 = " =";
  protected final String TEXT_16 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_17 = ";" + NL + "        " + NL + "        if(source_";
  protected final String TEXT_18 = " instanceof java.io.InputStream){" + NL + "        \tworkbook_";
  protected final String TEXT_19 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream((java.io.InputStream)source_";
  protected final String TEXT_20 = "), workbookSettings_";
  protected final String TEXT_21 = ");" + NL + "        }else if(source_";
  protected final String TEXT_22 = " instanceof String){" + NL + "        \tworkbook_";
  protected final String TEXT_23 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(new java.io.FileInputStream(" + NL + "        \t\t\t\t\t\t\tsource_";
  protected final String TEXT_24 = ".toString())), workbookSettings_";
  protected final String TEXT_25 = ");" + NL + "        }else{" + NL + "        \tworkbook_";
  protected final String TEXT_26 = " = null;" + NL + "        \tthrow new Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "        }" + NL + "        try {";
  protected final String TEXT_27 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_28 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_29 = ".getSheets());";
  protected final String TEXT_30 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_31 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_32 = NL + "        sheetList_";
  protected final String TEXT_33 = ".addAll(regexUtil_";
  protected final String TEXT_34 = ".getSheets(workbook_";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = "));";
  protected final String TEXT_38 = NL + "        if(sheetList_";
  protected final String TEXT_39 = ".size() <= 0){" + NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "        " + NL + "        int nb_line_";
  protected final String TEXT_40 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "0";
  protected final String TEXT_43 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "0";
  protected final String TEXT_46 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_47 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_48 = ":sheetList_";
  protected final String TEXT_49 = "){" + NL + "        \tend_line_";
  protected final String TEXT_50 = "+=sheet_";
  protected final String TEXT_51 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_52 = " -= footer_input_";
  protected final String TEXT_53 = ";" + NL + "        int limit_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "-1";
  protected final String TEXT_56 = ";" + NL + "        int start_column_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "0";
  protected final String TEXT_59 = "-1";
  protected final String TEXT_60 = ";" + NL + "        int end_column_";
  protected final String TEXT_61 = " = sheetList_";
  protected final String TEXT_62 = ".get(0).getColumns();";
  protected final String TEXT_63 = NL + "        Integer lastColumn_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_66 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_67 = " = lastColumn_";
  protected final String TEXT_68 = ".intValue();" + NL + "        }";
  protected final String TEXT_69 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_70 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_71 = " = sheetList_";
  protected final String TEXT_72 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_73 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_74 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_75 = " = sheetList_";
  protected final String TEXT_76 = ".get(0).getRows();" + NL + "        " + NL + "        for(int i_";
  protected final String TEXT_77 = " = begin_line_";
  protected final String TEXT_78 = "; i_";
  protected final String TEXT_79 = " < end_line_";
  protected final String TEXT_80 = "; i_";
  protected final String TEXT_81 = "++){" + NL + "        " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_82 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_83 = " != -1 && nb_line_";
  protected final String TEXT_84 = " >= limit_";
  protected final String TEXT_85 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_86 = " >= rowCount_";
  protected final String TEXT_87 = " + currentRows_";
  protected final String TEXT_88 = ") {" + NL + "                rowCount_";
  protected final String TEXT_89 = " += currentRows_";
  protected final String TEXT_90 = ";" + NL + "                sheet_";
  protected final String TEXT_91 = " = sheetList_";
  protected final String TEXT_92 = ".get(++sheetIndex_";
  protected final String TEXT_93 = ");" + NL + "                currentRows_";
  protected final String TEXT_94 = " = sheet_";
  protected final String TEXT_95 = ".getRows();" + NL + "            }";
  protected final String TEXT_96 = NL + "            if (rowCount_";
  protected final String TEXT_97 = " <= i_";
  protected final String TEXT_98 = ") {" + NL + "                row_";
  protected final String TEXT_99 = " = sheet_";
  protected final String TEXT_100 = ".getRow(i_";
  protected final String TEXT_101 = " - rowCount_";
  protected final String TEXT_102 = ");" + NL + "            }";
  protected final String TEXT_103 = NL + "            if (rowCount_";
  protected final String TEXT_104 = " <= i_";
  protected final String TEXT_105 = " && i_";
  protected final String TEXT_106 = " - rowCount_";
  protected final String TEXT_107 = " >= begin_line_";
  protected final String TEXT_108 = " && currentRows_";
  protected final String TEXT_109 = " - footer_input_";
  protected final String TEXT_110 = " > i_";
  protected final String TEXT_111 = " - rowCount_";
  protected final String TEXT_112 = ") {" + NL + "                row_";
  protected final String TEXT_113 = " = sheet_";
  protected final String TEXT_114 = ".getRow(i_";
  protected final String TEXT_115 = " - rowCount_";
  protected final String TEXT_116 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_117 = "               " + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_118 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_119 = ".getName());";
  protected final String TEXT_120 = NL + "    \t\t";
  protected final String TEXT_121 = " = null;\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_123 = " = new String[";
  protected final String TEXT_124 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_125 = " = end_column_";
  protected final String TEXT_126 = " >\trow_";
  protected final String TEXT_127 = ".length ? row_";
  protected final String TEXT_128 = ".length : end_column_";
  protected final String TEXT_129 = ";" + NL + "\t\t\tjava.text.DecimalFormat df = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\t\tchar separatorChar = df.getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_130 = ";i++){" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_131 = " < actual_end_column_";
  protected final String TEXT_132 = "){" + NL + "\t\t\t\t" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_133 = " = row_";
  protected final String TEXT_134 = "[i + start_column_";
  protected final String TEXT_135 = "];" + NL + "\t\t\t\t  " + NL + "\t\t\t\t  if (";
  protected final String TEXT_136 = " && jxl.CellType.NUMBER == cell_";
  protected final String TEXT_137 = ".getType()){\t\t\t\t   " + NL + "\t\t\t\t  \ttemp_row_";
  protected final String TEXT_138 = "[i] = String.valueOf(((jxl.NumberCell)cell_";
  protected final String TEXT_139 = ").getValue());" + NL + "\t\t\t\t\tString content = cell_";
  protected final String TEXT_140 = ".getContents();" + NL + "\t\t\t\t\tif(content!=null && content.indexOf(separatorChar)==-1 && (temp_row_";
  protected final String TEXT_141 = "[i].indexOf(\"E\")==-1)) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_142 = "[i] = content;" + NL + "\t\t\t\t\t} else {" + NL + "    \t\t\t\t\tString literal = temp_row_";
  protected final String TEXT_143 = "[i];" + NL + "    \t\t\t\t\tif(literal!=null) {" + NL + "    \t\t\t\t\t\tliteral = df.format(((jxl.NumberCell)cell_";
  protected final String TEXT_144 = ").getValue());" + NL + "    \t\t\t\t\t}" + NL + "    \t\t\t\t\ttemp_row_";
  protected final String TEXT_145 = "[i] = literal;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t  } else{" + NL + "\t\t\t\t    temp_row_";
  protected final String TEXT_146 = "[i] = cell_";
  protected final String TEXT_147 = ".getContents();" + NL + "\t\t\t\t  }" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_148 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_149 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_150 = " = new ";
  protected final String TEXT_151 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_152 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_153 = " = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_154 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_155 = "[";
  protected final String TEXT_156 = "]";
  protected final String TEXT_157 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_158 = "=";
  protected final String TEXT_159 = " + start_column_";
  protected final String TEXT_160 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_161 = " = \"";
  protected final String TEXT_162 = "\";";
  protected final String TEXT_163 = NL + "\t\t\t";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " = temp_row_";
  protected final String TEXT_166 = "[";
  protected final String TEXT_167 = "]";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_170 = "<actual_end_column_";
  protected final String TEXT_171 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_172 = " = ((jxl.DateCell)row_";
  protected final String TEXT_173 = "[";
  protected final String TEXT_174 = " + start_column_";
  protected final String TEXT_175 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_178 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_179 = ".getTime()));" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in row \"+(nb_line_";
  protected final String TEXT_180 = "+1));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_181 = NL + "\t\t";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = " = ParserUtils.parseTo_";
  protected final String TEXT_184 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_185 = "[";
  protected final String TEXT_186 = "]";
  protected final String TEXT_187 = ", ";
  protected final String TEXT_188 = ", ";
  protected final String TEXT_189 = "));";
  protected final String TEXT_190 = "\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = temp_row_";
  protected final String TEXT_193 = "[";
  protected final String TEXT_194 = "]";
  protected final String TEXT_195 = ".getBytes(";
  protected final String TEXT_196 = ");" + NL + "\t";
  protected final String TEXT_197 = NL + "\t\t\t";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = ParserUtils.parseTo_";
  protected final String TEXT_200 = "(temp_row_";
  protected final String TEXT_201 = "[";
  protected final String TEXT_202 = "]";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_205 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_206 = "' in '";
  protected final String TEXT_207 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_208 = NL + "\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_212 = "++;";
  protected final String TEXT_213 = NL + "\t\t}";
  protected final String TEXT_214 = NL + "\t\t\t\t\t";
  protected final String TEXT_215 = " ";
  protected final String TEXT_216 = " = null; ";
  protected final String TEXT_217 = NL;
  protected final String TEXT_218 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_219 = " == ";
  protected final String TEXT_220 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_221 = "  " + NL + "\t\t\t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_222 = " = true;";
  protected final String TEXT_223 = NL + "            throw(e);";
  protected final String TEXT_224 = NL + "                    ";
  protected final String TEXT_225 = " = new ";
  protected final String TEXT_226 = "Struct();";
  protected final String TEXT_227 = NL + "                    ";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = ";";
  protected final String TEXT_232 = NL + "                ";
  protected final String TEXT_233 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_234 = "+ \" column: \" + curColName_";
  protected final String TEXT_235 = " + \" (No. \" + curColNum_";
  protected final String TEXT_236 = " + \")\";";
  protected final String TEXT_237 = NL + "                ";
  protected final String TEXT_238 = " = null;";
  protected final String TEXT_239 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_240 = NL + "                ";
  protected final String TEXT_241 = " = null;";
  protected final String TEXT_242 = NL + "            \t";
  protected final String TEXT_243 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_244 = "+ \" column: \" + curColName_";
  protected final String TEXT_245 = " + \" (No. \" + curColNum_";
  protected final String TEXT_246 = " + \")\";";
  protected final String TEXT_247 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_248 = NL + "\t\t";
  protected final String TEXT_249 = "if(!whetherReject_";
  protected final String TEXT_250 = ") { ";
  protected final String TEXT_251 = "      " + NL + "             if(";
  protected final String TEXT_252 = " == null){ " + NL + "            \t ";
  protected final String TEXT_253 = " = new ";
  protected final String TEXT_254 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_255 = NL + "\t    \t ";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = ";    \t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t";
  protected final String TEXT_261 = " } ";
  protected final String TEXT_262 = "\t";
  protected final String TEXT_263 = NL + "\t\t\torg.apache.log4j.Logger logger_";
  protected final String TEXT_264 = " = org.apache.log4j.Logger.getLogger(\"org.openxml4j.opc\");" + NL + "\t        logger_";
  protected final String TEXT_265 = ".setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_266 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_267 = " regexUtil_";
  protected final String TEXT_268 = " = new RegexUtil_";
  protected final String TEXT_269 = "();" + NL + "\t\t" + NL + "\t\tObject source_";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_272 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_273 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_274 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_275 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook(";
  protected final String TEXT_276 = ");" + NL + "\t\t}else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_277 = " = null;" + NL + "\t\t\tthrow new Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t";
  protected final String TEXT_278 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_279 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_280 = ":workbook_";
  protected final String TEXT_281 = "){" + NL + "    \t\tsheetList_";
  protected final String TEXT_282 = ".add(sheet_";
  protected final String TEXT_283 = ");" + NL + "    \t}";
  protected final String TEXT_284 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_285 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_286 = NL + "        sheetList_";
  protected final String TEXT_287 = ".addAll(regexUtil_";
  protected final String TEXT_288 = ".getSheets(workbook_";
  protected final String TEXT_289 = ", ";
  protected final String TEXT_290 = ", ";
  protected final String TEXT_291 = "));";
  protected final String TEXT_292 = NL + "    \tif(sheetList_";
  protected final String TEXT_293 = ".size() <= 0){" + NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_294 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_295 = " = ";
  protected final String TEXT_296 = "0";
  protected final String TEXT_297 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_298 = " = ";
  protected final String TEXT_299 = "0";
  protected final String TEXT_300 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_301 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_302 = ":sheetList_";
  protected final String TEXT_303 = "){" + NL + "        \tend_line_";
  protected final String TEXT_304 = "+=(sheet_";
  protected final String TEXT_305 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_306 = " -= footer_input_";
  protected final String TEXT_307 = ";" + NL + "        int limit_";
  protected final String TEXT_308 = " = ";
  protected final String TEXT_309 = "-1";
  protected final String TEXT_310 = ";" + NL + "        int start_column_";
  protected final String TEXT_311 = " = ";
  protected final String TEXT_312 = "0";
  protected final String TEXT_313 = "-1";
  protected final String TEXT_314 = ";" + NL + "        int end_column_";
  protected final String TEXT_315 = " = -1;";
  protected final String TEXT_316 = "       " + NL + "        Integer lastColumn_";
  protected final String TEXT_317 = " = ";
  protected final String TEXT_318 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_319 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_320 = " = lastColumn_";
  protected final String TEXT_321 = ".intValue();" + NL + "        }        ";
  protected final String TEXT_322 = ";" + NL + "        " + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_323 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_324 = " = sheetList_";
  protected final String TEXT_325 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_326 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_327 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_328 = " = (sheetList_";
  protected final String TEXT_329 = ".get(0).getLastRowNum()+1);" + NL + "        " + NL + "        for(int i_";
  protected final String TEXT_330 = " = begin_line_";
  protected final String TEXT_331 = "; i_";
  protected final String TEXT_332 = " < end_line_";
  protected final String TEXT_333 = "; i_";
  protected final String TEXT_334 = "++){" + NL + "       " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_335 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_336 = " != -1 && nb_line_";
  protected final String TEXT_337 = " >= limit_";
  protected final String TEXT_338 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_339 = " >= rowCount_";
  protected final String TEXT_340 = " + currentRows_";
  protected final String TEXT_341 = ") {" + NL + "                rowCount_";
  protected final String TEXT_342 = " += currentRows_";
  protected final String TEXT_343 = ";" + NL + "                sheet_";
  protected final String TEXT_344 = " = sheetList_";
  protected final String TEXT_345 = ".get(++sheetIndex_";
  protected final String TEXT_346 = ");" + NL + "                currentRows_";
  protected final String TEXT_347 = " = (sheet_";
  protected final String TEXT_348 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_349 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_350 = ".getSheetName());";
  protected final String TEXT_351 = NL + "            if (rowCount_";
  protected final String TEXT_352 = " <= i_";
  protected final String TEXT_353 = ") {" + NL + "                row_";
  protected final String TEXT_354 = " = sheet_";
  protected final String TEXT_355 = ".getRow(i_";
  protected final String TEXT_356 = " - rowCount_";
  protected final String TEXT_357 = ");" + NL + "            }";
  protected final String TEXT_358 = NL + "            if (rowCount_";
  protected final String TEXT_359 = " <= i_";
  protected final String TEXT_360 = " && i_";
  protected final String TEXT_361 = " - rowCount_";
  protected final String TEXT_362 = " >= begin_line_";
  protected final String TEXT_363 = " && currentRows_";
  protected final String TEXT_364 = " - footer_input_";
  protected final String TEXT_365 = " > i_";
  protected final String TEXT_366 = " - rowCount_";
  protected final String TEXT_367 = ") {" + NL + "                row_";
  protected final String TEXT_368 = " = sheet_";
  protected final String TEXT_369 = ".getRow(i_";
  protected final String TEXT_370 = " - rowCount_";
  protected final String TEXT_371 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_372 = "          ";
  protected final String TEXT_373 = NL + "\t\t    ";
  protected final String TEXT_374 = " = null;\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_376 = " = new String[";
  protected final String TEXT_377 = "];" + NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_378 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_379 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_380 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_381 = "=row_";
  protected final String TEXT_382 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_383 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_384 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_385 = " = excel_end_column_";
  protected final String TEXT_386 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_387 = " = end_column_";
  protected final String TEXT_388 = " >\texcel_end_column_";
  protected final String TEXT_389 = " ? excel_end_column_";
  protected final String TEXT_390 = " : end_column_";
  protected final String TEXT_391 = ";" + NL + "\t\t\t}" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_392 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_393 = " < actual_end_column_";
  protected final String TEXT_394 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_395 = " = row_";
  protected final String TEXT_396 = ".getCell(i + start_column_";
  protected final String TEXT_397 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_398 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_399 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_400 = "[i] = cell_";
  protected final String TEXT_401 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_402 = ")) {" + NL + "                                temp_row_";
  protected final String TEXT_403 = "[i] =cell_";
  protected final String TEXT_404 = ".getDateCellValue().toString();" + NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_405 = "[i] =new java.math.BigDecimal(cell_";
  protected final String TEXT_406 = ".getNumericCellValue()).toPlainString();" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_407 = "[i] =String.valueOf(cell_";
  protected final String TEXT_408 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_409 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_410 = "[i] = cell_";
  protected final String TEXT_411 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_412 = ")) {" + NL + "                                        temp_row_";
  protected final String TEXT_413 = "[i] =cell_";
  protected final String TEXT_414 = ".getDateCellValue().toString();" + NL + "                                    } else {" + NL + "                                        temp_row_";
  protected final String TEXT_415 = "[i] =new java.math.BigDecimal(cell_";
  protected final String TEXT_416 = ".getNumericCellValue()).toPlainString();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_417 = "[i] =String.valueOf(cell_";
  protected final String TEXT_418 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_419 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_420 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_421 = "[i]=\"\";" + NL + "                \t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_422 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_423 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_424 = " = new ";
  protected final String TEXT_425 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_426 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_427 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_428 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_429 = "[";
  protected final String TEXT_430 = "]";
  protected final String TEXT_431 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_432 = "=";
  protected final String TEXT_433 = " + start_column_";
  protected final String TEXT_434 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_435 = " = \"";
  protected final String TEXT_436 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_437 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_438 = ".";
  protected final String TEXT_439 = " = temp_row_";
  protected final String TEXT_440 = "[";
  protected final String TEXT_441 = "]";
  protected final String TEXT_442 = ";";
  protected final String TEXT_443 = "\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_444 = "<actual_end_column_";
  protected final String TEXT_445 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_446 = ".getCell(";
  protected final String TEXT_447 = "+ start_column_";
  protected final String TEXT_448 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_449 = ".getCell(";
  protected final String TEXT_450 = "+ start_column_";
  protected final String TEXT_451 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_452 = ".";
  protected final String TEXT_453 = " = row_";
  protected final String TEXT_454 = ".getCell(";
  protected final String TEXT_455 = "+ start_column_";
  protected final String TEXT_456 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_459 = "[";
  protected final String TEXT_460 = "]";
  protected final String TEXT_461 = ", ";
  protected final String TEXT_462 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in row \"+(nb_line_";
  protected final String TEXT_463 = "+1));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_464 = NL + "\t\t\t\t";
  protected final String TEXT_465 = ".";
  protected final String TEXT_466 = " = ParserUtils.parseTo_";
  protected final String TEXT_467 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_468 = "[";
  protected final String TEXT_469 = "]";
  protected final String TEXT_470 = ", ";
  protected final String TEXT_471 = ", ";
  protected final String TEXT_472 = "));";
  protected final String TEXT_473 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_474 = ".";
  protected final String TEXT_475 = " = temp_row_";
  protected final String TEXT_476 = "[";
  protected final String TEXT_477 = "]";
  protected final String TEXT_478 = ".getBytes(";
  protected final String TEXT_479 = ");";
  protected final String TEXT_480 = NL + "\t\t\t\t";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = " = ParserUtils.parseTo_";
  protected final String TEXT_483 = "(temp_row_";
  protected final String TEXT_484 = "[";
  protected final String TEXT_485 = "]";
  protected final String TEXT_486 = ");";
  protected final String TEXT_487 = NL + "\t\t\t}else{";
  protected final String TEXT_488 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_489 = "' in '";
  protected final String TEXT_490 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_491 = NL + "\t\t\t\t";
  protected final String TEXT_492 = ".";
  protected final String TEXT_493 = " = ";
  protected final String TEXT_494 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_495 = "++;";
  protected final String TEXT_496 = NL + "\t\t\t}";
  protected final String TEXT_497 = " ";
  protected final String TEXT_498 = " = null; ";
  protected final String TEXT_499 = NL;
  protected final String TEXT_500 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_501 = " == ";
  protected final String TEXT_502 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_503 = "  " + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_504 = " = true;";
  protected final String TEXT_505 = NL + "\t            throw(e);";
  protected final String TEXT_506 = NL + "\t\t\t\t\t";
  protected final String TEXT_507 = " = new ";
  protected final String TEXT_508 = "Struct();";
  protected final String TEXT_509 = NL + "\t\t\t\t\t";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = " = ";
  protected final String TEXT_512 = ".";
  protected final String TEXT_513 = ";";
  protected final String TEXT_514 = NL + "\t\t\t\t\t";
  protected final String TEXT_515 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_516 = "+ \" column: \" + curColName_";
  protected final String TEXT_517 = " + \" (No. \" + curColNum_";
  protected final String TEXT_518 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_519 = " = null;";
  protected final String TEXT_520 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_521 = " = null;";
  protected final String TEXT_522 = NL + "\t\t\t\t\t";
  protected final String TEXT_523 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_524 = "+ \" column: \" + curColName_";
  protected final String TEXT_525 = " + \" (No. \" + curColNum_";
  protected final String TEXT_526 = " + \")\";";
  protected final String TEXT_527 = NL + "\t\t\t}\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_528 = NL + "\t\t";
  protected final String TEXT_529 = "if(!whetherReject_";
  protected final String TEXT_530 = ") { ";
  protected final String TEXT_531 = "      " + NL + "             if(";
  protected final String TEXT_532 = " == null){ " + NL + "            \t ";
  protected final String TEXT_533 = " = new ";
  protected final String TEXT_534 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_535 = NL + "\t    \t ";
  protected final String TEXT_536 = ".";
  protected final String TEXT_537 = " = ";
  protected final String TEXT_538 = ".";
  protected final String TEXT_539 = ";    \t\t\t\t";
  protected final String TEXT_540 = NL + "\t\t";
  protected final String TEXT_541 = " } ";
  protected final String TEXT_542 = "\t";
  protected final String TEXT_543 = NL;
  protected final String TEXT_544 = NL;
  protected final String TEXT_545 = NL;

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
		
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_7);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    
		}

    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
          
		if(isAllSheets){

    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    
		}else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_37);
    
			}
		}

    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_42);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_44);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_45);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_55);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    
	if(!affect){

    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    
	}else{

    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    
    }

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
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

    stringBuffer.append(TEXT_120);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_121);
    
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
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(bReadRealValue);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_156);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_163);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_167);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_168);
    		
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_169);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_170);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    
//start			
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_186);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_189);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
	
    stringBuffer.append(TEXT_190);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_196);
    
			} else {
//
//end
    stringBuffer.append(TEXT_197);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_203);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_204);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_205);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_207);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_208);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_213);
    
//start
//
					}
    stringBuffer.append(TEXT_214);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_220);
    
	}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_223);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_224);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_226);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_227);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_231);
    
                }
                
    stringBuffer.append(TEXT_232);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_238);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_241);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_242);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    }
        } 
        
    stringBuffer.append(TEXT_247);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_248);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_254);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_255);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_259);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_260);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_261);
     } 
    stringBuffer.append(TEXT_262);
    
		}
		}

    	
		}//version judgement /***excel 2007 xlsx*****/
		else{

    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_278);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
		}else{

    stringBuffer.append(TEXT_284);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_285);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_286);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_291);
    
			}
		}

    stringBuffer.append(TEXT_292);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_295);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_296);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_297);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_298);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_299);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_300);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_308);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_309);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_310);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_311);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_312);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_315);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    
	if(!affect){

    stringBuffer.append(TEXT_351);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_357);
    
	}else{

    stringBuffer.append(TEXT_358);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_371);
    
    }

    stringBuffer.append(TEXT_372);
    
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

    stringBuffer.append(TEXT_373);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_374);
    
		    		}
		    	}
		    }
		}
		String firstConnName = "";
		if (conns!=null) {//3	 
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_375);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_392);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_430);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_433);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_436);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_437);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_441);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_442);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_443);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_450);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_455);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_460);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_461);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_462);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_463);
    		
						}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_464);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_466);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_469);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_470);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_471);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_472);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_473);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_477);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_479);
    
						} else {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_482);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_485);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_486);
    
						}

    stringBuffer.append(TEXT_487);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_488);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_490);
    
						} else {

    stringBuffer.append(TEXT_491);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_494);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_495);
    
						}

    stringBuffer.append(TEXT_496);
    
					}

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_497);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_498);
    }
    stringBuffer.append(TEXT_499);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_500);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_502);
    
	}

    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_505);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_506);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_508);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_509);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_513);
    
					    }//16

    stringBuffer.append(TEXT_514);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_519);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_520);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_521);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_522);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    
					}//15
				}

    stringBuffer.append(TEXT_527);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_528);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_531);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_534);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_535);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_539);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_540);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_541);
     } 
    stringBuffer.append(TEXT_542);
    
		}
		}

    
		}//end version judgement

    stringBuffer.append(TEXT_543);
    
	}
}
//
//end
    stringBuffer.append(TEXT_544);
    stringBuffer.append(TEXT_545);
    return stringBuffer.toString();
  }
}
