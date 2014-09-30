package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import org.talend.core.model.process.IProcess;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
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
  protected final String TEXT_44 = " ";
  protected final String TEXT_45 = NL + "String fileName_";
  protected final String TEXT_46 = " = \"\";";
  protected final String TEXT_47 = NL + "        int dynamic_column_count_";
  protected final String TEXT_48 = " = 1;" + NL + "\t";
  protected final String TEXT_49 = NL + "\t\t\t\tclass FileOutputDelimitedUtil_";
  protected final String TEXT_50 = "{" + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_52 = "(java.io.Writer out";
  protected final String TEXT_53 = ",final String OUT_DELIM_";
  protected final String TEXT_54 = ",final ";
  protected final String TEXT_55 = "Struct ";
  protected final String TEXT_56 = ")throws java.lang.Exception{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_58 = ".write(\"";
  protected final String TEXT_59 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = ", out";
  protected final String TEXT_63 = ", OUT_DELIM_";
  protected final String TEXT_64 = "); " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_66 = ".write(OUT_DELIM_";
  protected final String TEXT_67 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\tpublic void putValue_";
  protected final String TEXT_71 = "(final ";
  protected final String TEXT_72 = "Struct ";
  protected final String TEXT_73 = ",StringBuilder sb_";
  protected final String TEXT_74 = ",final String OUT_DELIM_";
  protected final String TEXT_75 = ")throws java.lang.Exception {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " != null) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t    \t\t\t\t    \troutines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ", sb_";
  protected final String TEXT_82 = ", OUT_DELIM_";
  protected final String TEXT_83 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_85 = ".append(" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t    \t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ")" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_91 = ".toPlainString(), ";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ")\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t        \t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ")).toPlainString(), ";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ")\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_100 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t    \t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_102 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ")).toString()" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_108 = NL + "\t    \t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t    \t\t\t\t\t    } " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_110 = "\t\t\t\t\t" + NL + "\t    \t\t\t            sb_";
  protected final String TEXT_111 = ".append(OUT_DELIM_";
  protected final String TEXT_112 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_116 = "(String[] headColu";
  protected final String TEXT_117 = ",final ";
  protected final String TEXT_118 = "Struct ";
  protected final String TEXT_119 = ",int dynamic_column_count_";
  protected final String TEXT_120 = " ";
  protected final String TEXT_121 = ")throws java.lang.Exception{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_123 = "[";
  protected final String TEXT_124 = "+dynamic_column_count_";
  protected final String TEXT_125 = "]=\"";
  protected final String TEXT_126 = "\";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_128 = "[";
  protected final String TEXT_129 = "]=\"";
  protected final String TEXT_130 = "\";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t                                dynamic_column_count_";
  protected final String TEXT_132 = " = ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\tfor(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_135 = ";mi++){" + NL + "\t    \t    \t\t     \t\t\theadColu";
  protected final String TEXT_136 = "[";
  protected final String TEXT_137 = "+mi]=";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ".getColumnMetadata(mi).getName();" + NL + "\t    \t    \t\t     \t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\tpublic void putValue_";
  protected final String TEXT_143 = "(final ";
  protected final String TEXT_144 = "Struct ";
  protected final String TEXT_145 = ",String[] row";
  protected final String TEXT_146 = ",int dynamic_column_count_";
  protected final String TEXT_147 = " ";
  protected final String TEXT_148 = "){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t\t\tif (";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = " != null) {" + NL + "\t\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = ".getColumnCount();" + NL + "\t                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = ", row";
  protected final String TEXT_157 = ", ";
  protected final String TEXT_158 = ");" + NL + "\t                            }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_159 = " " + NL + "\t                \t\t    \trow";
  protected final String TEXT_160 = "[";
  protected final String TEXT_161 = "+dynamic_column_count_";
  protected final String TEXT_162 = "]=";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t                \t\t\t\trow";
  protected final String TEXT_165 = "[";
  protected final String TEXT_166 = "]=";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = ", ";
  protected final String TEXT_174 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = ")).toString();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_179 = ".toPlainString(), ";
  protected final String TEXT_180 = ", ";
  protected final String TEXT_181 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = ")).toPlainString(), ";
  protected final String TEXT_185 = ", ";
  protected final String TEXT_186 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_188 = ".toPlainString();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t}" + NL + "\t\t\t\tFileOutputDelimitedUtil_";
  protected final String TEXT_195 = " fileOutputDelimitedUtil_";
  protected final String TEXT_196 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_197 = "();" + NL + "\t\t\t";
  protected final String TEXT_198 = NL + "\tfileName_";
  protected final String TEXT_199 = " = (new java.io.File(";
  protected final String TEXT_200 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "\tString fullName_";
  protected final String TEXT_201 = " = null;" + NL + "\tString extension_";
  protected final String TEXT_202 = " = null;" + NL + "\tString directory_";
  protected final String TEXT_203 = " = null;" + NL + "\tif((fileName_";
  protected final String TEXT_204 = ".indexOf(\"/\") != -1)) {" + NL + "\t    if(fileName_";
  protected final String TEXT_205 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_206 = ".lastIndexOf(\"/\")) {" + NL + "\t        fullName_";
  protected final String TEXT_207 = " = fileName_";
  protected final String TEXT_208 = ";" + NL + "\t        extension_";
  protected final String TEXT_209 = " = \"\";" + NL + "\t    } else {" + NL + "\t        fullName_";
  protected final String TEXT_210 = " = fileName_";
  protected final String TEXT_211 = ".substring(0, fileName_";
  protected final String TEXT_212 = ".lastIndexOf(\".\"));" + NL + "\t        extension_";
  protected final String TEXT_213 = " = fileName_";
  protected final String TEXT_214 = ".substring(fileName_";
  protected final String TEXT_215 = ".lastIndexOf(\".\"));" + NL + "\t    }           " + NL + "\t    directory_";
  protected final String TEXT_216 = " = fileName_";
  protected final String TEXT_217 = ".substring(0, fileName_";
  protected final String TEXT_218 = ".lastIndexOf(\"/\"));            " + NL + "\t} else {" + NL + "\t    if(fileName_";
  protected final String TEXT_219 = ".lastIndexOf(\".\") != -1) {" + NL + "\t        fullName_";
  protected final String TEXT_220 = " = fileName_";
  protected final String TEXT_221 = ".substring(0, fileName_";
  protected final String TEXT_222 = ".lastIndexOf(\".\"));" + NL + "\t        extension_";
  protected final String TEXT_223 = " = fileName_";
  protected final String TEXT_224 = ".substring(fileName_";
  protected final String TEXT_225 = ".lastIndexOf(\".\"));" + NL + "\t    } else {" + NL + "\t        fullName_";
  protected final String TEXT_226 = " = fileName_";
  protected final String TEXT_227 = ";" + NL + "\t        extension_";
  protected final String TEXT_228 = " = \"\";" + NL + "\t    }" + NL + "\t    directory_";
  protected final String TEXT_229 = " = \"\";" + NL + "\t}" + NL + "\tboolean isFileGenerated_";
  protected final String TEXT_230 = " = true;" + NL + "\tjava.io.File file";
  protected final String TEXT_231 = " = new java.io.File(fileName_";
  protected final String TEXT_232 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_233 = "_FILE_NAME\",fileName_";
  protected final String TEXT_234 = ");" + NL + "\t";
  protected final String TEXT_235 = NL + "\t\tif(file";
  protected final String TEXT_236 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_237 = " = false;" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_238 = NL + "            \tboolean isFirstCheckDyn_";
  protected final String TEXT_239 = "= true;";
  protected final String TEXT_240 = NL + "    \t\tint nb_line_";
  protected final String TEXT_241 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_242 = " = ";
  protected final String TEXT_243 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_244 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_245 = " = 0;\t\t" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_";
  protected final String TEXT_246 = " = ";
  protected final String TEXT_247 = ";" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_250 = "         " + NL + "\t                //create directory only if not exists" + NL + "\t                if(directory_";
  protected final String TEXT_251 = " != null && directory_";
  protected final String TEXT_252 = ".trim().length() != 0) {" + NL + "\t                    java.io.File dir_";
  protected final String TEXT_253 = " = new java.io.File(directory_";
  protected final String TEXT_254 = ");" + NL + "\t                    if(!dir_";
  protected final String TEXT_255 = ".exists()) {" + NL + "\t                    \t";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_257 = " - Creating directory '\" + dir_";
  protected final String TEXT_258 = ".getCanonicalPath() +\"'.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t                        dir_";
  protected final String TEXT_260 = ".mkdirs();" + NL + "\t                    \t";
  protected final String TEXT_261 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_262 = " - The directoy '\"+ dir_";
  protected final String TEXT_263 = ".getCanonicalPath() + \"' has been created successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t                    }" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_265 = NL + "    " + NL + "\t\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\tfile";
  protected final String TEXT_267 = " = new java.io.File(fileName_";
  protected final String TEXT_268 = ");" + NL + "\t\t\t\t\t\tString zipName_";
  protected final String TEXT_269 = " = fullName_";
  protected final String TEXT_270 = " + \".zip\";" + NL + "\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_271 = " = new java.io.File(zipName_";
  protected final String TEXT_272 = ");" + NL + "\t\t    \t\t    //routines.system.Row" + NL + "\t\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_273 = "= null;    \t\t    " + NL + "\t\t    \t\t    java.io.Writer out";
  protected final String TEXT_274 = " = null;" + NL + "\t\t    \t\t    " + NL + "\t\t    \t\t    if(file_";
  protected final String TEXT_275 = ".exists()) {" + NL + "\t\t    \t\t    \tfile_";
  protected final String TEXT_276 = ".delete();" + NL + "\t\t    \t\t    }" + NL + "\t    \t\t    \tzipOut_";
  protected final String TEXT_277 = "= new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_278 = ")));" + NL + "\t    \t\t    \tzipOut_";
  protected final String TEXT_279 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_280 = ".getName()));" + NL + "\t    \t\t    \tout";
  protected final String TEXT_281 = " = new ";
  protected final String TEXT_282 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_283 = ",";
  protected final String TEXT_284 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_285 = "\t\t" + NL + "\t\t    \t\t    //routines.system.Row" + NL + "\t\t    \t\t    java.io.Writer out";
  protected final String TEXT_286 = " = null;" + NL + "\t\t    \t\t    " + NL + "\t\t    \t\t    ";
  protected final String TEXT_287 = NL + "\t\t    \t\t    java.io.File fileToDelete_";
  protected final String TEXT_288 = " = new java.io.File(fileName_";
  protected final String TEXT_289 = ");" + NL + "\t\t    \t\t    if(fileToDelete_";
  protected final String TEXT_290 = ".exists()) {" + NL + "\t\t    \t\t    \tfileToDelete_";
  protected final String TEXT_291 = ".delete();" + NL + "\t\t    \t\t    }" + NL + "\t\t    \t\t    ";
  protected final String TEXT_292 = NL + "\t            \t\tout";
  protected final String TEXT_293 = " = new ";
  protected final String TEXT_294 = "(new java.io.OutputStreamWriter(" + NL + "\t            \t\tnew java.io.FileOutputStream(fileName_";
  protected final String TEXT_295 = ", ";
  protected final String TEXT_296 = "),";
  protected final String TEXT_297 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_298 = NL + "\t                java.io.Writer out";
  protected final String TEXT_299 = " = null;" + NL + "\t                file";
  protected final String TEXT_300 = " = new java.io.File(fullName_";
  protected final String TEXT_301 = " + splitedFileNo_";
  protected final String TEXT_302 = " + extension_";
  protected final String TEXT_303 = ");" + NL + "\t                " + NL + "\t    \t\t    ";
  protected final String TEXT_304 = NL + "\t    \t\t    if(file";
  protected final String TEXT_305 = ".exists()) {" + NL + "\t\t    \t\t\tfile";
  protected final String TEXT_306 = ".delete();" + NL + "\t    \t\t    }" + NL + "\t    \t\t    ";
  protected final String TEXT_307 = NL + "                \tout";
  protected final String TEXT_308 = " = new ";
  protected final String TEXT_309 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_310 = " + splitedFileNo_";
  protected final String TEXT_311 = " + extension_";
  protected final String TEXT_312 = ", ";
  protected final String TEXT_313 = "),";
  protected final String TEXT_314 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t\t       \t \t";
  protected final String TEXT_318 = NL + "\t\t\t\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\t\t    \t\t    if(file_";
  protected final String TEXT_320 = ".length()==0){" + NL + "\t\t\t    \t\t    \t";
  protected final String TEXT_321 = NL + "\t\t\t    \t\t    \t\tif(file";
  protected final String TEXT_322 = ".length()==0){" + NL + "\t\t\t    \t\t        ";
  protected final String TEXT_323 = NL + "\t\t\t                            \tfileOutputDelimitedUtil_";
  protected final String TEXT_324 = ".putHeaderValue_";
  protected final String TEXT_325 = "(out";
  protected final String TEXT_326 = ",OUT_DELIM_";
  protected final String TEXT_327 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t    \t\t            out";
  protected final String TEXT_329 = ".write(\"";
  protected final String TEXT_330 = "\");" + NL + "\t\t\t\t    \t\t            ";
  protected final String TEXT_331 = NL + "\t\t\t\t    \t\t                out";
  protected final String TEXT_332 = ".write(OUT_DELIM_";
  protected final String TEXT_333 = ");" + NL + "\t\t\t\t    \t\t                ";
  protected final String TEXT_334 = NL + "\t\t\t\t\t    \t\t        out";
  protected final String TEXT_335 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_336 = ");" + NL + "\t\t\t\t\t    \t\t        out";
  protected final String TEXT_337 = ".flush();" + NL + "\t\t\t\t\t    \t\t    }" + NL + "\t\t\t\t        \t";
  protected final String TEXT_338 = NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t       \t\t";
  protected final String TEXT_339 = NL + "\t\t\t\t\t\t\t} " + NL + "\t\t\t\t        ";
  protected final String TEXT_340 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_341 = NL + "\t    \t\t    //routines.system.Row" + NL + "\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_342 = "= null;    \t\t    " + NL + "\t    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_343 = " = null;" + NL + "\t    \t\t    java.io.Writer out";
  protected final String TEXT_344 = " = null;" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_345 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_346 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_347 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \twriter_";
  protected final String TEXT_348 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_349 = ",";
  protected final String TEXT_350 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_351 = " = new ";
  protected final String TEXT_352 = "(writer_";
  protected final String TEXT_353 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_354 = "\t\t" + NL + "\t    \t\t    //routines.system.Row" + NL + "\t    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_355 = " = null;" + NL + "\t    \t\t    java.io.Writer out";
  protected final String TEXT_356 = " = null;" + NL + "    \t\t    \twriter_";
  protected final String TEXT_357 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_358 = ",";
  protected final String TEXT_359 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_360 = " = new ";
  protected final String TEXT_361 = "(writer_";
  protected final String TEXT_362 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_363 = NL + "                            \tfileOutputDelimitedUtil_";
  protected final String TEXT_364 = ".putHeaderValue_";
  protected final String TEXT_365 = "(out";
  protected final String TEXT_366 = ",OUT_DELIM_";
  protected final String TEXT_367 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_368 = NL + "    \t\t            \tout";
  protected final String TEXT_369 = ".write(\"";
  protected final String TEXT_370 = "\");" + NL + "\t    \t\t            ";
  protected final String TEXT_371 = NL + "\t    \t\t                out";
  protected final String TEXT_372 = ".write(OUT_DELIM_";
  protected final String TEXT_373 = ");" + NL + "\t    \t\t            ";
  protected final String TEXT_374 = NL + "    \t\t        out";
  protected final String TEXT_375 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_376 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_377 = NL;
  protected final String TEXT_378 = NL + "\t            boolean isFirstCheckDyn_";
  protected final String TEXT_379 = "= true;" + NL + "\t            String[] headColu";
  protected final String TEXT_380 = " = null;";
  protected final String TEXT_381 = NL + "            \tString[] headColu";
  protected final String TEXT_382 = "=new String[";
  protected final String TEXT_383 = "];";
  protected final String TEXT_384 = "   \t    \t\t" + NL + "            class CSVBasicSet_";
  protected final String TEXT_385 = "{          \t" + NL + "            \tprivate char field_Delim;            \t" + NL + "            \tprivate char row_Delim;            \t" + NL + "            \tprivate char escape;            \t" + NL + "            \tprivate char textEnclosure;" + NL + "            \tprivate boolean useCRLFRecordDelimiter;" + NL + "            \t" + NL + "            \tpublic boolean isUseCRLFRecordDelimiter() {" + NL + "            \t\treturn useCRLFRecordDelimiter;" + NL + "            \t}" + NL + "            \t          \t" + NL + "            \tpublic void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_386 = "[] = null;" + NL + "                    " + NL + "            \t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "            \t\tif (fieldSep.length() > 0 ){" + NL + "            \t\t\tfield_Delim_";
  protected final String TEXT_387 = " = fieldSep.toCharArray();" + NL + "            \t\t}else { " + NL + "\t\t            \t";
  protected final String TEXT_388 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_389 = " - The field separator must be a character.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_390 = NL + "            \t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.field_Delim = field_Delim_";
  protected final String TEXT_391 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getFieldDelim(){" + NL + "            \t\tif(this.field_Delim==0){" + NL + "            \t\t\tsetFieldSeparator(";
  protected final String TEXT_392 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.field_Delim;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic void setRowSeparator(String rowSep){" + NL + "            \t\tif(\"\\r\\n\".equals(rowSep)) {" + NL + "            \t\t\tuseCRLFRecordDelimiter = true;" + NL + "            \t\t\treturn;" + NL + "            \t\t}" + NL + "            \t\tchar row_Delim";
  protected final String TEXT_393 = "[] = null;" + NL + "                 " + NL + "            \t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'.  " + NL + "            \t\tif (rowSep.length() > 0 ){ " + NL + "            \t\t\trow_Delim";
  protected final String TEXT_394 = " = rowSep.toCharArray();" + NL + "            \t\t}else {" + NL + "\t\t            \t";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_396 = " - The row separator must be a character.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_397 = NL + "            \t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.row_Delim = row_Delim";
  protected final String TEXT_398 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getRowDelim(){" + NL + "            \t\tif(this.row_Delim==0){" + NL + "            \t\t\tsetRowSeparator(";
  protected final String TEXT_399 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.row_Delim;" + NL + "            \t}" + NL + "            \t       \t        " + NL + "        \t    public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "        \t        if(strEscape.length() <= 0 ){ " + NL + "\t\t            \t";
  protected final String TEXT_400 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_401 = " - The escape character must be a character.\"); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_402 = NL + "        \t            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        \t        }" + NL + "        \t        " + NL + "                \tif (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "        \t\t\tchar textEnclosure_";
  protected final String TEXT_403 = "[] = null;" + NL + "        \t        " + NL + "        \t        if(strTextEnclosure.length() > 0 ){ " + NL + "              \t\t\ttextEnclosure_";
  protected final String TEXT_404 = " = strTextEnclosure.toCharArray(); " + NL + "        \t\t\t}else { " + NL + "\t\t            \t";
  protected final String TEXT_405 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_406 = " - The text enclosure must be a character.\"); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_407 = NL + "        \t            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        \t        }" + NL + "" + NL + "\t\t\t\t\tthis.textEnclosure = textEnclosure_";
  protected final String TEXT_408 = "[0];" + NL + "" + NL + "        \t\t\tif((\"\\\\\").equals(strEscape)){" + NL + "        \t\t\t\tthis.escape = '\\\\';" + NL + "        \t\t\t}else if(strEscape.equals(strTextEnclosure)){" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\t//the default escape mode is double escape" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t}" + NL + "        \t\t\t" + NL + "        \t\t\t" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getEscapeChar(){" + NL + "            \t\treturn (char)this.escape;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getTextEnclosure(){" + NL + "            \t\treturn this.textEnclosure;" + NL + "            \t}" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_409 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_410 = " = ";
  protected final String TEXT_411 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_412 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_413 = " = 0;" + NL + "            " + NL + "            " + NL + "            CSVBasicSet_";
  protected final String TEXT_414 = " csvSettings_";
  protected final String TEXT_415 = " = new CSVBasicSet_";
  protected final String TEXT_416 = "();" + NL + "            csvSettings_";
  protected final String TEXT_417 = ".setFieldSeparator(";
  protected final String TEXT_418 = ");" + NL + "            csvSettings_";
  protected final String TEXT_419 = ".setRowSeparator(";
  protected final String TEXT_420 = ");" + NL + "\t\t\tcsvSettings_";
  protected final String TEXT_421 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_422 = ",";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = "         " + NL + "\t                //create directory only if not exists" + NL + "\t                if(directory_";
  protected final String TEXT_425 = " != null && directory_";
  protected final String TEXT_426 = ".trim().length() != 0) {" + NL + "\t                    java.io.File dir_";
  protected final String TEXT_427 = " = new java.io.File(directory_";
  protected final String TEXT_428 = ");" + NL + "\t                    if(!dir_";
  protected final String TEXT_429 = ".exists()) {" + NL + "\t                        ";
  protected final String TEXT_430 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_431 = " - Creating directory '\" +dir_";
  protected final String TEXT_432 = ".getCanonicalPath() +\"'.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_433 = NL + "\t                        dir_";
  protected final String TEXT_434 = ".mkdirs();" + NL + "\t                    \t";
  protected final String TEXT_435 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_436 = " - The directory '\" + dir_";
  protected final String TEXT_437 = ".getCanonicalPath() + \"' has been created successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_438 = NL + "\t                    }" + NL + "\t                }";
  protected final String TEXT_439 = NL + "\t\t\t\t\t\t\tfile";
  protected final String TEXT_440 = " = new java.io.File(fileName_";
  protected final String TEXT_441 = ");" + NL + "\t\t\t\t\t\t\tString zipName_";
  protected final String TEXT_442 = " = fullName_";
  protected final String TEXT_443 = " + \".zip\";" + NL + "\t\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_444 = " = new java.io.File(zipName_";
  protected final String TEXT_445 = ");\t\t\t\t" + NL + "\t\t\t    \t\t    //routines.system.Row" + NL + "\t\t\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_446 = " = null;" + NL + "\t\t\t                java.io.Writer out";
  protected final String TEXT_447 = " = null;" + NL + "\t\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_448 = " = null; " + NL + "\t\t\t                " + NL + "    \t\t    \t\t    if(file_";
  protected final String TEXT_449 = ".exists()) {" + NL + "\t\t    \t\t    \t\tfile_";
  protected final String TEXT_450 = ".delete();" + NL + "\t    \t\t   \t\t \t}" + NL + "\t\t                \tzipOut_";
  protected final String TEXT_451 = "=new java.util.zip.ZipOutputStream(" + NL + "\t\t    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_452 = ")));" + NL + "\t\t\t    \t\t    zipOut_";
  protected final String TEXT_453 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_454 = ".getName()));" + NL + "\t\t\t    \t\t    out";
  protected final String TEXT_455 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_456 = ", ";
  protected final String TEXT_457 = "));" + NL + "\t\t\t    \t\t    java.io.StringWriter strWriter";
  protected final String TEXT_458 = " = new java.io.StringWriter();" + NL + "\t\t\t    \t\t    CsvWriter";
  protected final String TEXT_459 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_460 = ");" + NL + "\t\t\t    \t\t    CsvWriter";
  protected final String TEXT_461 = ".setSeparator(csvSettings_";
  protected final String TEXT_462 = ".getFieldDelim());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_463 = "\t\t" + NL + "\t\t\t                java.io.Writer out";
  protected final String TEXT_464 = " = null;" + NL + "\t\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_465 = " = null;" + NL + "\t\t\t                " + NL + "    \t\t    \t\t    ";
  protected final String TEXT_466 = NL + "    \t\t    \t\t    java.io.File fileToDelete_";
  protected final String TEXT_467 = " = new java.io.File(fileName_";
  protected final String TEXT_468 = ");" + NL + "    \t\t    \t\t    if(fileToDelete_";
  protected final String TEXT_469 = ".exists()) {" + NL + "    \t\t    \t\t    \tfileToDelete_";
  protected final String TEXT_470 = ".delete();" + NL + "    \t\t    \t\t    }" + NL + "    \t\t    \t\t    ";
  protected final String TEXT_471 = NL + "\t\t                \tout";
  protected final String TEXT_472 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t\t                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_473 = ", ";
  protected final String TEXT_474 = "), ";
  protected final String TEXT_475 = "));" + NL + "\t\t\t\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_476 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_477 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_478 = ");" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_479 = ".setSeparator(csvSettings_";
  protected final String TEXT_480 = ".getFieldDelim());" + NL + "                \t\t";
  protected final String TEXT_481 = NL + "\t\t\t\t\t\t\tfile";
  protected final String TEXT_482 = " = new java.io.File(fileName_";
  protected final String TEXT_483 = ");" + NL + "\t\t\t\t\t\t\tString zipName_";
  protected final String TEXT_484 = " = fullName_";
  protected final String TEXT_485 = " + \".zip\";" + NL + "\t\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_486 = " = new java.io.File(zipName_";
  protected final String TEXT_487 = ");" + NL + "\t\t\t    \t\t    //routines.system.Row" + NL + "\t\t\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_488 = " = null;" + NL + "\t\t\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_489 = " = null;" + NL + "\t\t\t\t\t\t\t" + NL + "    \t\t    \t\t    if(file_";
  protected final String TEXT_490 = ".exists()) {" + NL + "\t\t    \t\t    \t\tfile_";
  protected final String TEXT_491 = ".delete();" + NL + "\t    \t\t   \t\t \t}" + NL + "\t\t                \tzipOut_";
  protected final String TEXT_492 = "=new java.util.zip.ZipOutputStream(" + NL + "\t\t    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_493 = ")));" + NL + "\t\t    \t\t    \tzipOut_";
  protected final String TEXT_494 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_495 = ".getName()));" + NL + "\t\t    \t\t    \tCsvWriter";
  protected final String TEXT_496 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t                    zipOut_";
  protected final String TEXT_497 = ", ";
  protected final String TEXT_498 = ")));" + NL + "\t\t                    CsvWriter";
  protected final String TEXT_499 = ".setSeparator(csvSettings_";
  protected final String TEXT_500 = ".getFieldDelim());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_501 = NL + "\t\t\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_502 = " = null;" + NL + "\t\t\t\t\t\t\t" + NL + "\t    \t\t   \t\t \t";
  protected final String TEXT_503 = NL + "    \t\t    \t\t    java.io.File fileToDelete_";
  protected final String TEXT_504 = " = new java.io.File(fileName_";
  protected final String TEXT_505 = ");" + NL + "    \t\t    \t\t    if(fileToDelete_";
  protected final String TEXT_506 = ".exists()) {" + NL + "    \t\t    \t\t    \tfileToDelete_";
  protected final String TEXT_507 = ".delete();" + NL + "    \t\t    \t\t    }" + NL + "    \t\t    \t\t    ";
  protected final String TEXT_508 = NL + "\t\t                \tCsvWriter";
  protected final String TEXT_509 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_510 = ", ";
  protected final String TEXT_511 = "), ";
  protected final String TEXT_512 = ")));" + NL + "\t\t                    CsvWriter";
  protected final String TEXT_513 = ".setSeparator(csvSettings_";
  protected final String TEXT_514 = ".getFieldDelim());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_515 = NL + "\t\t                file";
  protected final String TEXT_516 = " = new java.io.File(fullName_";
  protected final String TEXT_517 = " + splitedFileNo_";
  protected final String TEXT_518 = " + extension_";
  protected final String TEXT_519 = ");" + NL + "\t\t                java.io.Writer out";
  protected final String TEXT_520 = " = null;" + NL + "\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_521 = " = null;" + NL + "\t\t                " + NL + "    \t    \t\t    ";
  protected final String TEXT_522 = NL + "    \t    \t\t    if(file";
  protected final String TEXT_523 = ".exists()) {" + NL + "    \t\t    \t\t\tfile";
  protected final String TEXT_524 = ".delete();" + NL + "    \t    \t\t    }" + NL + "    \t    \t\t    ";
  protected final String TEXT_525 = NL + "\t                \tout";
  protected final String TEXT_526 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_527 = " + splitedFileNo_";
  protected final String TEXT_528 = " + extension_";
  protected final String TEXT_529 = ", ";
  protected final String TEXT_530 = "),";
  protected final String TEXT_531 = "));" + NL + "\t                \tjava.io.StringWriter strWriter";
  protected final String TEXT_532 = " = new java.io.StringWriter();" + NL + "\t                \tCsvWriter";
  protected final String TEXT_533 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_534 = ");" + NL + "\t                \tCsvWriter";
  protected final String TEXT_535 = ".setSeparator(csvSettings_";
  protected final String TEXT_536 = ".getFieldDelim());" + NL + "\t                \t" + NL + "                \t";
  protected final String TEXT_537 = NL + "\t\t                file";
  protected final String TEXT_538 = " = new java.io.File(fullName_";
  protected final String TEXT_539 = " + splitedFileNo_";
  protected final String TEXT_540 = " + extension_";
  protected final String TEXT_541 = ");" + NL + "\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_542 = " = null; " + NL + "\t\t                " + NL + "    \t    \t\t    ";
  protected final String TEXT_543 = NL + "    \t    \t\t    if(file";
  protected final String TEXT_544 = ".exists()) {" + NL + "    \t\t    \t\t\tfile";
  protected final String TEXT_545 = ".delete();" + NL + "    \t    \t\t    }" + NL + "    \t    \t\t    ";
  protected final String TEXT_546 = NL + "\t                \tCsvWriter";
  protected final String TEXT_547 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_548 = " + splitedFileNo_";
  protected final String TEXT_549 = " + extension_";
  protected final String TEXT_550 = ", ";
  protected final String TEXT_551 = "),";
  protected final String TEXT_552 = ")));" + NL + "\t                    CsvWriter";
  protected final String TEXT_553 = ".setSeparator(csvSettings_";
  protected final String TEXT_554 = ".getFieldDelim());" + NL + "                \t";
  protected final String TEXT_555 = NL + "\t    \t    \tif(csvSettings_";
  protected final String TEXT_556 = ".isUseCRLFRecordDelimiter()) {" + NL + "\t    \t    \t\tCsvWriter";
  protected final String TEXT_557 = ".setLineEnd(\"\\r\\n\");" + NL + "\t    \t    \t} else {" + NL + "\t    \t    \t\tCsvWriter";
  protected final String TEXT_558 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_559 = ".getRowDelim());" + NL + "\t    \t    \t}" + NL + "\t    \t\t";
  protected final String TEXT_560 = NL + "\t\t    \t\tif(!csvSettings_";
  protected final String TEXT_561 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_562 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_563 = ".getRowDelim()!='\\n') {" + NL + "\t\t    \t\t\tCsvWriter";
  protected final String TEXT_564 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_565 = ".getRowDelim());" + NL + "\t\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_566 = "\t\t   " + NL + "\t\t\t\t\t";
  protected final String TEXT_567 = NL + "\t\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_568 = NL + "\t\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t\t        ";
  protected final String TEXT_569 = NL + "\t\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_570 = NL + "\t\t\t        \tif(file_";
  protected final String TEXT_571 = ".length()==0){" + NL + "\t\t        \t";
  protected final String TEXT_572 = NL + "\t\t    \t        if(file";
  protected final String TEXT_573 = ".length()==0){" + NL + "\t    \t        ";
  protected final String TEXT_574 = "\t\t\t" + NL + "\t\t         \t\t\t";
  protected final String TEXT_575 = NL + "\t\t                        \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_576 = ".putHeaderValue_";
  protected final String TEXT_577 = "(headColu";
  protected final String TEXT_578 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_579 = "\t      \t" + NL + "\t\t        \t\t\t\t\theadColu";
  protected final String TEXT_580 = "[";
  protected final String TEXT_581 = "]=\"";
  protected final String TEXT_582 = "\";" + NL + "\t\t        \t\t\t\t";
  protected final String TEXT_583 = "\t " + NL + "\t\t    \t            CsvWriter";
  protected final String TEXT_584 = ".writeNext(headColu";
  protected final String TEXT_585 = ");" + NL + "\t\t    \t            CsvWriter";
  protected final String TEXT_586 = ".flush();" + NL + "\t\t    \t            ";
  protected final String TEXT_587 = NL + "\t\t\t    \t            out";
  protected final String TEXT_588 = ".write(strWriter";
  protected final String TEXT_589 = ".getBuffer().toString());" + NL + "\t\t\t    \t            out";
  protected final String TEXT_590 = ".flush();" + NL + "\t\t\t                \tstrWriter";
  protected final String TEXT_591 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_592 = ".getBuffer().length()); \t" + NL + "\t\t                \t";
  protected final String TEXT_593 = NL + "                \t\t}" + NL + "\t        \t\t";
  protected final String TEXT_594 = NL + "\t\t\t\t\t\t} " + NL + "\t        \t\t";
  protected final String TEXT_595 = NL + "\t\t\t\t\t\t} " + NL + "\t        \t\t";
  protected final String TEXT_596 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_597 = NL + "\t\t\t\t";
  protected final String TEXT_598 = NL + "\t\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_599 = " = null;" + NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_600 = " = null;" + NL + "\t\t                java.io.Writer out";
  protected final String TEXT_601 = " = null;\t\t\t\t" + NL + "\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_602 = " = null;" + NL + "\t                \tzipOut_";
  protected final String TEXT_603 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_604 = "));" + NL + "\t    \t\t    \tzipOut_";
  protected final String TEXT_605 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "\t    \t\t    \toutWriter_";
  protected final String TEXT_606 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_607 = ", ";
  protected final String TEXT_608 = ");" + NL + "\t    \t\t    \tout";
  protected final String TEXT_609 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_610 = ");" + NL + "\t    \t\t    \tjava.io.StringWriter strWriter";
  protected final String TEXT_611 = " = new java.io.StringWriter();" + NL + "\t    \t\t    \tCsvWriter";
  protected final String TEXT_612 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_613 = ");" + NL + "\t    \t\t    \tCsvWriter";
  protected final String TEXT_614 = ".setSeparator(csvSettings_";
  protected final String TEXT_615 = ".getFieldDelim());" + NL + "\t\t\t\t\t";
  protected final String TEXT_616 = NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_617 = " = null;" + NL + "\t\t                java.io.Writer out";
  protected final String TEXT_618 = " = null;\t\t\t\t" + NL + "\t\t                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_619 = " = null;  " + NL + "\t                \toutWriter_";
  protected final String TEXT_620 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_621 = ", ";
  protected final String TEXT_622 = ");" + NL + "\t                \tout";
  protected final String TEXT_623 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_624 = ");" + NL + "\t                \tjava.io.StringWriter strWriter";
  protected final String TEXT_625 = " = new java.io.StringWriter();" + NL + "\t                \tCsvWriter";
  protected final String TEXT_626 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_627 = ");" + NL + "\t                \tCsvWriter";
  protected final String TEXT_628 = ".setSeparator(csvSettings_";
  protected final String TEXT_629 = ".getFieldDelim());" + NL + "\t\t\t\t\t";
  protected final String TEXT_630 = NL + "\t\t    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_631 = " = null;" + NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_632 = " = null;" + NL + "\t\t\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_633 = " = null;" + NL + "\t\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_634 = " = null;" + NL + "\t\t\t\t\t\tzipOut_";
  protected final String TEXT_635 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_636 = "));" + NL + "\t    \t\t   \t\tzipOut_";
  protected final String TEXT_637 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "\t    \t\t   \t\toutWriter_";
  protected final String TEXT_638 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_639 = ", ";
  protected final String TEXT_640 = ");" + NL + "\t    \t\t   \t\tbufferWriter_";
  protected final String TEXT_641 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_642 = ");" + NL + "\t    \t\t   \t\tCsvWriter";
  protected final String TEXT_643 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_644 = ");" + NL + "\t    \t\t   \t\tCsvWriter";
  protected final String TEXT_645 = ".setSeparator(csvSettings_";
  protected final String TEXT_646 = ".getFieldDelim());" + NL + "\t\t\t\t\t";
  protected final String TEXT_647 = NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_648 = " = null;" + NL + "\t\t\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_649 = " = null;" + NL + "\t\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_650 = " = null;" + NL + "\t\t\t\t\t\toutWriter_";
  protected final String TEXT_651 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_652 = ", ";
  protected final String TEXT_653 = ");" + NL + "\t\t\t\t\t\tbufferWriter_";
  protected final String TEXT_654 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_655 = ");" + NL + "\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_656 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_657 = ");" + NL + "\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_658 = ".setSeparator(csvSettings_";
  protected final String TEXT_659 = ".getFieldDelim());" + NL + "\t\t\t\t\t";
  protected final String TEXT_660 = NL + "\t       \t    \tif(csvSettings_";
  protected final String TEXT_661 = ".isUseCRLFRecordDelimiter()) {" + NL + "\t    \t    \t\tCsvWriter";
  protected final String TEXT_662 = ".setLineEnd(\"\\r\\n\");" + NL + "\t    \t    \t} else {" + NL + "\t    \t    \t\tCsvWriter";
  protected final String TEXT_663 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_664 = ".getRowDelim());   \t    \t" + NL + "\t    \t    \t}" + NL + "    \t    \t";
  protected final String TEXT_665 = NL + "\t    \t    \tif(!csvSettings_";
  protected final String TEXT_666 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_667 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_668 = ".getRowDelim()!='\\n') {" + NL + "\t\t    \t\t\tCsvWriter";
  protected final String TEXT_669 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_670 = ".getRowDelim());" + NL + "\t\t    \t\t}" + NL + "    \t    \t";
  protected final String TEXT_671 = NL + "                     \t\t\tfileOutputDelimitedUtil_";
  protected final String TEXT_672 = ".putHeaderValue_";
  protected final String TEXT_673 = "(headColu";
  protected final String TEXT_674 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_675 = NL + "       \t\t\t\t\t\theadColu";
  protected final String TEXT_676 = "[";
  protected final String TEXT_677 = "]=\"";
  protected final String TEXT_678 = "\";" + NL + "       \t\t\t\t\t";
  protected final String TEXT_679 = NL + "        \t\t\tCsvWriter";
  protected final String TEXT_680 = ".writeNext(headColu";
  protected final String TEXT_681 = ");\t" + NL + "        \t\t\t";
  protected final String TEXT_682 = NL + "\t\t        \t\tout";
  protected final String TEXT_683 = ".write(strWriter";
  protected final String TEXT_684 = ".getBuffer().toString());" + NL + "\t\t                strWriter";
  protected final String TEXT_685 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_686 = ".getBuffer().length());" + NL + "        \t\t\t";
  protected final String TEXT_687 = NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_688 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_689 = ".getEscapeChar());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_690 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_691 = ".getTextEnclosure());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_692 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "\t\t\t";
  protected final String TEXT_693 = NL + NL;
  protected final String TEXT_694 = NL;
  protected final String TEXT_695 = NL + "\t\tresourceMap.put(\"out_";
  protected final String TEXT_696 = "\", out";
  protected final String TEXT_697 = ");\t" + NL + "\t";
  protected final String TEXT_698 = NL + "\t\tresourceMap.put(\"out_";
  protected final String TEXT_699 = "\", out";
  protected final String TEXT_700 = ");\t" + NL + "\t\tresourceMap.put(\"writer_";
  protected final String TEXT_701 = "\", writer_";
  protected final String TEXT_702 = ");" + NL + "\t";
  protected final String TEXT_703 = NL + "\tresourceMap.put(\"CsvWriter_";
  protected final String TEXT_704 = "\", CsvWriter";
  protected final String TEXT_705 = ");\t " + NL + "\t";
  protected final String TEXT_706 = NL + "\t\t\tresourceMap.put(\"out_";
  protected final String TEXT_707 = "\", out";
  protected final String TEXT_708 = ");" + NL + "\t\t";
  protected final String TEXT_709 = NL + "\t\t\tresourceMap.put(\"out_";
  protected final String TEXT_710 = "\", out";
  protected final String TEXT_711 = ");" + NL + "\t\t\tresourceMap.put(\"outWriter_";
  protected final String TEXT_712 = "\", outWriter_";
  protected final String TEXT_713 = ");" + NL + "\t\t";
  protected final String TEXT_714 = NL + "\t\t\tresourceMap.put(\"bufferWriter_";
  protected final String TEXT_715 = "\", bufferWriter_";
  protected final String TEXT_716 = ");" + NL + "\t\t\tresourceMap.put(\"outWriter_";
  protected final String TEXT_717 = "\", outWriter_";
  protected final String TEXT_718 = ");" + NL + "\t\t";
  protected final String TEXT_719 = NL + "resourceMap.put(\"nb_line_";
  protected final String TEXT_720 = "\", nb_line_";
  protected final String TEXT_721 = ");";
  protected final String TEXT_722 = NL + "\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_723 = "\", isFileGenerated_";
  protected final String TEXT_724 = ");" + NL + "\t";
  protected final String TEXT_725 = NL + "\t\tresourceMap.put(\"file_";
  protected final String TEXT_726 = "\", file_";
  protected final String TEXT_727 = ");" + NL + "\t";
  protected final String TEXT_728 = NL + "\t\tresourceMap.put(\"file";
  protected final String TEXT_729 = "\", file";
  protected final String TEXT_730 = ");" + NL + "\t";

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

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));

boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
IProcess process = node.getProcess();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
log4jFileUtil.logParameters(node); 
log4jFileUtil.componentStartInfo(node); 

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
	IMetadataTable metadata = metadatas.get(0);
	boolean hasDynamic = metadata.isDynamicSchema();
	if(hasDynamic && ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))){
	
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	}
	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
	for (IConnection conn : conns) {//B1
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
	    	List<IMetadataColumn> columns = metadata.getListColumns();
	       	int sizeColumns = columns.size();
			if(sizeColumns> schemaOptNum){//D1
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
					if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
						if(isIncludeHeader){//F1
							for (int i = 0; i < sizeColumns; i++) {//H1
		                        IMetadataColumn column = columns.get(i);
		                       	if(i%schemaOptNum==0){
								
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_56);
    
								}
								if(!("id_Dynamic".equals(column.getTalendType()))) {
								
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_59);
    
								}else{
								
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
								}
								if(i != sizeColumns - 1) {
								
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
								}
								if((i+1)%schemaOptNum==0){
								
    stringBuffer.append(TEXT_68);
    
								}
							}//H1
							if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
							
    stringBuffer.append(TEXT_69);
    
							}
						}//F1
	        			for (int i = 0; i < sizeColumns; i++) {//F2
	        				IMetadataColumn column = columns.get(i);
	    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
		                    if(i%schemaOptNum==0){
							
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
							}
	    					if(!isPrimitive) {
							
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    
	    				    } 
	    				    if(column.getTalendType().equals("id_Dynamic")){
							
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
	    				    }else{
							
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
									
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_89);
    	
		    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
										if(javaType == JavaTypesManager.BIGDECIMAL) {
										
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_93);
     
		        						} else { 
										
    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_98);
     
		        						}
									} else if(javaType == JavaTypesManager.BIGDECIMAL){
									
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_100);
    
									} else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_101);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    
		    			        	} else {
									
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    				
		    			        	}
									
    stringBuffer.append(TEXT_108);
    
	    					}
	    					if(!isPrimitive) {
							
    stringBuffer.append(TEXT_109);
    
	    			        } 
	    			        if(i != sizeColumns - 1) {
							
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
	    			        }
	    			        if((i+1)%schemaOptNum==0){
							
    stringBuffer.append(TEXT_113);
    
							}
	    		        }//F2
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
						
    stringBuffer.append(TEXT_114);
    
						}
					}else{
						//E2 use CSV Option
						if(isIncludeHeader){//F3
							for (int i = 0; i < sizeColumns; i++) {//H3
		                        IMetadataColumn column = columns.get(i);
		                       	if(i%schemaOptNum==0){
								
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    
								}
								if(!("id_Dynamic".equals(column.getTalendType()))) {
								    if(hasDynamic){
									
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_126);
    
								    }else{
									
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_130);
    
								    }
								}else{
								
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    
								}
								if((i+1)%schemaOptNum==0){
								
    stringBuffer.append(TEXT_140);
    
								}
							}//H3
							if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
							
    stringBuffer.append(TEXT_141);
    
							}
						}//F3
	        			for (int i = 0; i < sizeColumns; i++) {//F4
	        				IMetadataColumn column = columns.get(i);
	    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
	    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
		                    if(i%schemaOptNum==0){
							
    stringBuffer.append(TEXT_142);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    
							}
	    					if(("id_Dynamic").equals(column.getTalendType())) {
							
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_158);
    
	                		}else{
	                		    if(hasDynamic){
								
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    stringBuffer.append(TEXT_163);
    
	                		    }else{
								
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    stringBuffer.append(TEXT_167);
    					
	                		    }
	                			if(javaType == JavaTypesManager.STRING ){
								
    stringBuffer.append(TEXT_168);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_170);
    
	                			}else if(javaType == JavaTypesManager.DATE && pattern != null){
								
    stringBuffer.append(TEXT_171);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_174);
    
	                			}else if(javaType == JavaTypesManager.BYTE_ARRAY){
								
    stringBuffer.append(TEXT_175);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    
	                			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
	        						if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_181);
      	
									} else { 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_186);
    		
									}
	        					} else if (javaType == JavaTypesManager.BIGDECIMAL) {
								
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_188);
    
	                			} else{
								
    stringBuffer.append(TEXT_189);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_191);
    
	                			}
	                		}
	    			        if((i+1)%schemaOptNum==0){
							
    stringBuffer.append(TEXT_192);
    
							}
	    		        }//F4
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
						
    stringBuffer.append(TEXT_193);
    
						}
					}
					
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
			}//D1
		}//C1
	}//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
	if(isAppend){
	
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
	}
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
           
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
    		
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean hasDynamic = metadata.isDynamicSchema();
			if(hasDynamic){
            
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
            }
            
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_249);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
			
    			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
				
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    
    			}
				
    stringBuffer.append(TEXT_265);
     	
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(!split){
    				if(compress && !isAppend){// compress the dest file
					
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
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
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_284);
    
    				}else{
					
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    if(!isAppend) {
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_297);
     
					}
    			} else {
				
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    if(!isAppend) {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_314);
    
    			}
    			
    			if(isIncludeHeader && !hasDynamic){
    		    
    stringBuffer.append(TEXT_315);
    
					if(codeGenArgument.getIsRunInMultiThread()){
					
    stringBuffer.append(TEXT_316);
    
					}
						if (codeGenArgument.subTreeContainsParallelIterate()) {
						
    stringBuffer.append(TEXT_317);
     
			        	}
				        	if (isParallelize) {
							
    stringBuffer.append(TEXT_318);
     
							}
								if(!split && compress && !isAppend){
					       	 	
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
			    		    	}else{
			    		    	
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    
			    		        }		
			    		        List<IMetadataColumn> columns = metadata.getListColumns();
			    		        int sizeColumns = columns.size();
			    		        for (int i = 0; i < sizeColumns; i++) {
			    		            IMetadataColumn column = columns.get(i);
			                        if(sizeColumns > schemaOptNum){
			                        	if(i%schemaOptNum==0){
										
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
			                        	}
			                        }else{//AA
			    		            
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_330);
    
				    		            if(i != sizeColumns - 1) {
				    		                
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
				    		            }
			    		            }//AA
			    		        }
			    		        
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
     
				        	if (isParallelize) {
							
    stringBuffer.append(TEXT_338);
    
				        	}
						if (codeGenArgument.subTreeContainsParallelIterate()) {
						
    stringBuffer.append(TEXT_339);
    
			        	}
		        	if(codeGenArgument.getIsRunInMultiThread()){
					
    stringBuffer.append(TEXT_340);
    
					}
    			}

    		}else{
    		//***********************the following is the part of output Stream**************************************
    		
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(compress){// compress the dest output stream
 				
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
    			}else{
				
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
				}
				
    			if(isIncludeHeader && !hasDynamic){
    		        List<IMetadataColumn> columns = metadata.getListColumns();
    		        int sizeColumns = columns.size();
    		        for (int i = 0; i < sizeColumns; i++) {
    		            IMetadataColumn column = columns.get(i);
  						if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){
							
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
                            }
                        }else{//BB
    		            
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_370);
    
	    		            if(i != sizeColumns - 1) {
	    		            
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
	    		            }
    		            }//BB
    		        }
    		        
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
    		    }
    		}// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_377);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                       
        	List<IMetadataColumn> columns = metadata.getListColumns();
	    	int sizeColumns = columns.size(); 
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    		String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
    		boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));
    		
        	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        	
 			if(escapeChar1.equals("\"\"\"")){
 				escapeChar1 = "\"\\\"\"";
 			}
        	
        	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
 			if(textEnclosure1.equals("\"\"\"")){
 				textEnclosure1 = "\"\\\"\"";
 			}
 			
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean hasDynamic = metadata.isDynamicSchema();
			if(hasDynamic){
            
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
            }else{
            
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_383);
    
            }
    	    
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    }
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    }
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_399);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    }
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    }
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_423);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
            	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    }
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    }
    stringBuffer.append(TEXT_438);
    
            	}
    	
	            if(!split){
	            	if(isInRowMode){
    					if(compress && !isAppend){// compress the dest file
						
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    
    					}else{
						
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    if(!isAppend) {
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    }
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    
                		}
                	
                	}else{
                		if(compress && !isAppend){// compress the dest file
						
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    
						}else{
						
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    if(!isAppend) {
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    }
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
						}
                	}
	            }else{
	            	if(isInRowMode){
               		
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    if(!isAppend) {
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    }
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    
                	}else{
                	
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    if(!isAppend) {
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    }
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    
                	}
	            }
	            
	            if(!useOSLineSeparator) {
	    		
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
	    		} else {
	    		
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    
	    		}
	    		
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
    	        
    stringBuffer.append(TEXT_566);
    
					if(codeGenArgument.getIsRunInMultiThread()){
					
    stringBuffer.append(TEXT_567);
    
					}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
					
    stringBuffer.append(TEXT_568);
     
		        	}
		        	if (isParallelize) {
					
    stringBuffer.append(TEXT_569);
     
					}
					if(!split && compress && !isAppend){
		        	
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    
		        	}else{
		        	
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    
    	        	}
    	        	
    stringBuffer.append(TEXT_574);
    
		         			for(int i = 0 ; i < sizeColumns ; i++){
		        				IMetadataColumn column = columns.get(i);
								if(sizeColumns> schemaOptNum){
		                        	if(i%schemaOptNum==0){
									
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    
		                            }
		                        }else{//CC
		        				
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_582);
    
		        				}//CC
		         			}
		    	            
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    if(isInRowMode){
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    }
    stringBuffer.append(TEXT_593);
     
	        		if (isParallelize) {
					
    stringBuffer.append(TEXT_594);
    
	        		}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
					
    stringBuffer.append(TEXT_595);
    
	        		}
	        		if(codeGenArgument.getIsRunInMultiThread()){
					
    stringBuffer.append(TEXT_596);
    
					}
	       			
    stringBuffer.append(TEXT_597);
    		  
	    	    }
	    	}else{
    		//***********************the following is the part of output Stream**************************************
	            if(isInRowMode){
	            	if(compress){// compress the dest output stream
					
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    
	            	}else{
					
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
					}

                }else{
                	if(compress){// compress the dest output stream
					
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    
                	}else{
					
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    
					}
                }

                if(!useOSLineSeparator) {
				
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    
    	    	} else {
    	    	
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    
    	    	}
    	    	
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
	    	        for(int i = 0; i < sizeColumns; i++)
	        		{
	        			IMetadataColumn column = columns.get(i);
						if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){
							
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    
                            }
                       	}else{//DD
    					
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_678);
    
       					}//DD
	        		}
    	        	
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    if(isInRowMode){
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    }
	    	    }
	    	}//*****************************csv mode under output stream end********************************************************
	    	
	    	if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""
			
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    
			}
	    }
    }
    
    stringBuffer.append(TEXT_693);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_694);
     
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
	if(!useStream){
	
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    
	}else{
	
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    
	}
}else{//the following is the tFileOutputCSV component

    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    
	if(!useStream){
		if(isInRowMode){
		
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    
		}
	}else{
		if(isInRowMode){
		
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    
		}else{
		
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    
		}
	}
}	

    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    if(!useStream && ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"))){
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    }else{
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    }
    }
    return stringBuffer.toString();
  }
}
