package org.talend.designer.codegen.translators.business.sap;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.talend.core.model.utils.TalendTextUtils;

public class TSAPInputBeginJava
{
  protected static String nl;
  public static synchronized TSAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPInputBeginJava result = new TSAPInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t//" + NL + "\t\t\t\t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_5 = ".getString(";
  protected final String TEXT_6 = "),";
  protected final String TEXT_7 = ");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".getString(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = ParserUtils.parseTo_";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ".getString(";
  protected final String TEXT_18 = "));" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + NL + "\t";
  protected final String TEXT_21 = NL + NL + "\t";
  protected final String TEXT_22 = NL + NL + "\t";
  protected final String TEXT_23 = NL + "    " + NL + "\t";
  protected final String TEXT_24 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "; ";
  protected final String TEXT_30 = NL + "\t" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t";
  protected final String TEXT_33 = "\t    " + NL + "\t\t\tclient_";
  protected final String TEXT_34 = " = (com.sap.mw.jco.JCO.Client)globalMap.get(\"conn_";
  protected final String TEXT_35 = "\");\t" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\ttry{" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\t\t\tclient_";
  protected final String TEXT_39 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_40 = ",      // SAP client" + NL + "\t\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_41 = ",   \t// userid" + NL + "\t\t\t\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_42 = ",    // password" + NL + "\t\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_43 = ",    // language" + NL + "\t\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_44 = ",    // host name" + NL + "\t\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_45 = " );      // system number" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t//Create a client connection to Message Server " + NL + "\t\t\t\tclient_";
  protected final String TEXT_47 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_48 = ",      // SAP client" + NL + "\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_49 = ",   \t// userid" + NL + "\t\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_50 = ",    // password" + NL + "\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_51 = ",    // language" + NL + "\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_52 = ",    // host name" + NL + "\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_53 = ",    // system ID,defined in sapmsg.ini" + NL + "\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_54 = " );  // group name    " + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t// Open the connection" + NL + "\t\t\tclient_";
  protected final String TEXT_56 = ".connect();" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\t\tclient_";
  protected final String TEXT_58 = ".setSapGui(2);" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = "      " + NL + "\t    com.sap.mw.jco.IRepository repository_";
  protected final String TEXT_61 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_62 = ");" + NL + "\t" + NL + "\t    com.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_63 = " = repository_";
  protected final String TEXT_64 = ".getFunctionTemplate(";
  protected final String TEXT_65 = ");" + NL + "\t    " + NL + "\t\tif(functionTemplate_";
  protected final String TEXT_66 = " == null){" + NL + "\t\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_67 = ");" + NL + "\t\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_68 = " + \".\");" + NL + "\t\t}        " + NL + "\t" + NL + "\t    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_69 = " = functionTemplate_";
  protected final String TEXT_70 = ".getFunction();" + NL + "\t" + NL + "\t    com.sap.mw.jco.JCO.ParameterList importParameterList_";
  protected final String TEXT_71 = " = function_";
  protected final String TEXT_72 = ".getImportParameterList();" + NL + "\t    com.sap.mw.jco.JCO.ParameterList exportParameterList_";
  protected final String TEXT_73 = " = function_";
  protected final String TEXT_74 = ".getExportParameterList();" + NL + "\t    com.sap.mw.jco.JCO.ParameterList tableParameterList_";
  protected final String TEXT_75 = " = function_";
  protected final String TEXT_76 = ".getTableParameterList();" + NL + "\t    " + NL + "\t    com.sap.mw.jco.JCO.Structure input_structure_";
  protected final String TEXT_77 = "=null;" + NL + "\t    com.sap.mw.jco.JCO.Table input_table_";
  protected final String TEXT_78 = "=null; " + NL + "\t    com.sap.mw.jco.JCO.Table  table_input_";
  protected final String TEXT_79 = "=null; " + NL + "\t";
  protected final String TEXT_80 = NL + "\t\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_81 = " = null;" + NL + "\t\t";
  protected final String TEXT_82 = "\t" + NL + "\t\t\tdest_";
  protected final String TEXT_83 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"conn_";
  protected final String TEXT_84 = "\");";
  protected final String TEXT_85 = " " + NL + "                                        if(dest_";
  protected final String TEXT_86 = " == null){ " + NL + "                                                dest_";
  protected final String TEXT_87 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_88 = "); " + NL + "                                        } ";
  protected final String TEXT_89 = " " + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\ttry{";
  protected final String TEXT_92 = " " + NL + "                                        dest_";
  protected final String TEXT_93 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_94 = "); ";
  protected final String TEXT_95 = " " + NL + "                    if (null == dest_";
  protected final String TEXT_96 = ") { ";
  protected final String TEXT_97 = " " + NL + "                                        org.talend.sap.TalendDestinationData destinationData_";
  protected final String TEXT_98 = " = null; ";
  protected final String TEXT_99 = " " + NL + "                                                destinationData_";
  protected final String TEXT_100 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_103 = ", " + NL + "                                                                                                                                                                                        decryptedPassword_";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_110 = "); ";
  protected final String TEXT_111 = "                       " + NL + "                                                destinationData_";
  protected final String TEXT_112 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_115 = ", " + NL + "                                                                                                                                                                                        decryptedPassword_";
  protected final String TEXT_116 = ",";
  protected final String TEXT_117 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_118 = ", ";
  protected final String TEXT_119 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = NL + "                                                                                                                                                                                        ";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_124 = " ); ";
  protected final String TEXT_125 = " " + NL + "                                    org.talend.sap.TalendDestinationDataProvider destinationDataProvider_";
  protected final String TEXT_126 = " = org.talend.sap.TalendDestinationDataProvider.getInstance(); " + NL + "                                    destinationDataProvider_";
  protected final String TEXT_127 = ".addDestination(\"SAP_SERVER_";
  protected final String TEXT_128 = "\", destinationData_";
  protected final String TEXT_129 = "); ";
  protected final String TEXT_130 = " " + NL + "                                    destinationDataProvider_";
  protected final String TEXT_131 = ".getDestinationProperties(\"SAP_SERVER_";
  protected final String TEXT_132 = "\").setProperty(com.sap.conn.jco.ext.DestinationDataProvider.JCO_USE_SAPGUI, \"2\"); " + NL + "                                        com.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\"); ";
  protected final String TEXT_133 = " " + NL + "                                    try { " + NL + "                                        com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(destinationDataProvider_";
  protected final String TEXT_134 = "); " + NL + "                                        } catch (java.lang.IllegalStateException ex) { " + NL + "                                                //ignore if the provider already registered. " + NL + "                                    } " + NL + "                                    dest_";
  protected final String TEXT_135 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(\"SAP_SERVER_";
  protected final String TEXT_136 = "\"); " + NL + "                                    // Begins the stateful call sequence for calls to the specified destination. " + NL + "                                com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_137 = "); ";
  protected final String TEXT_138 = " " + NL + "                                } ";
  protected final String TEXT_139 = " " + NL + "\t\t";
  protected final String TEXT_140 = " " + NL + "\t\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_141 = " = dest_";
  protected final String TEXT_142 = ".getRepository();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_143 = " = repository_";
  protected final String TEXT_144 = ".getFunctionTemplate(";
  protected final String TEXT_145 = ");" + NL + "\t\tif(functionTemplate_";
  protected final String TEXT_146 = " == null){" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_147 = ");" + NL + "\t\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_148 = " + \".\");" + NL + "\t\t}  " + NL + "\t\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_149 = " = functionTemplate_";
  protected final String TEXT_150 = ".getFunction();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoParameterList importParameterList_";
  protected final String TEXT_151 = " = function_";
  protected final String TEXT_152 = ".getImportParameterList();" + NL + "\t    com.sap.conn.jco.JCoParameterList exportParameterList_";
  protected final String TEXT_153 = " = function_";
  protected final String TEXT_154 = ".getExportParameterList();" + NL + "\t    com.sap.conn.jco.JCoParameterList tableParameterList_";
  protected final String TEXT_155 = " = function_";
  protected final String TEXT_156 = ".getTableParameterList();" + NL + "\t    " + NL + "\t    com.sap.conn.jco.JCoStructure input_structure_";
  protected final String TEXT_157 = "=null;" + NL + "\t    com.sap.conn.jco.JCoTable input_table_";
  protected final String TEXT_158 = "=null; " + NL + "\t    com.sap.conn.jco.JCoTable table_input_";
  protected final String TEXT_159 = "=null; " + NL + "\t";
  protected final String TEXT_160 = NL + "\t" + NL + "    Object isListObject_";
  protected final String TEXT_161 = "=null;" + NL + "        " + NL + "\t";
  protected final String TEXT_162 = NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\timportParameterList_";
  protected final String TEXT_164 = ".setValue(";
  protected final String TEXT_165 = ",";
  protected final String TEXT_166 = "); // \"input_single\"" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\timportParameterList_";
  protected final String TEXT_168 = ".setValue(";
  protected final String TEXT_169 = ",";
  protected final String TEXT_170 = "); // \"input_single\"" + NL + "\t\t\t";
  protected final String TEXT_171 = "\t\t" + NL + "\t\t";
  protected final String TEXT_172 = NL + "\t\t\tinput_structure_";
  protected final String TEXT_173 = " = importParameterList_";
  protected final String TEXT_174 = ".getStructure(";
  protected final String TEXT_175 = ");\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\tinput_structure_";
  protected final String TEXT_178 = ".setValue(";
  protected final String TEXT_179 = ",";
  protected final String TEXT_180 = ");\t// \"input_structure\"" + NL + "\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\tinput_structure_";
  protected final String TEXT_182 = ".setValue(";
  protected final String TEXT_183 = ",";
  protected final String TEXT_184 = ");\t// \"input_structure\"" + NL + "\t\t\t\t";
  protected final String TEXT_185 = "\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\tjava.util.List list_";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = "_";
  protected final String TEXT_189 = " = new java.util.ArrayList();\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_191 = "_";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = ".add(";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\tisListObject_";
  protected final String TEXT_196 = " = ";
  protected final String TEXT_197 = ";" + NL + "\t\t\t\t\tif(isListObject_";
  protected final String TEXT_198 = " instanceof java.util.List){" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_199 = "_";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = ".addAll((java.util.List)isListObject_";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_203 = "_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ".add(";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\tint rowSize_";
  protected final String TEXT_208 = "_";
  protected final String TEXT_209 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\trowSize_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = " = list_";
  protected final String TEXT_213 = "_";
  protected final String TEXT_214 = "_";
  protected final String TEXT_215 = ".size();\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\tif(rowSize_";
  protected final String TEXT_217 = "_";
  protected final String TEXT_218 = "!=list_";
  protected final String TEXT_219 = "_";
  protected final String TEXT_220 = "_";
  protected final String TEXT_221 = ".size()){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The row count of column: ";
  protected final String TEXT_222 = " in table: ";
  protected final String TEXT_223 = " not equals others, please make sure the row count of every columns equal.\");" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\tinput_table_";
  protected final String TEXT_225 = " = importParameterList_";
  protected final String TEXT_226 = ".getTable(";
  protected final String TEXT_227 = ");" + NL + "\t\t\tinput_table_";
  protected final String TEXT_228 = ".appendRows(rowSize_";
  protected final String TEXT_229 = "_";
  protected final String TEXT_230 = ");" + NL + "\t\t\tinput_table_";
  protected final String TEXT_231 = ".firstRow();" + NL + "\t\t\tfor(int rowNum_";
  protected final String TEXT_232 = "=0; rowNum_";
  protected final String TEXT_233 = " < rowSize_";
  protected final String TEXT_234 = "_";
  protected final String TEXT_235 = "; rowNum_";
  protected final String TEXT_236 = "++){\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\tinput_table_";
  protected final String TEXT_239 = ".setValue(list_";
  protected final String TEXT_240 = "_";
  protected final String TEXT_241 = "_";
  protected final String TEXT_242 = ".get(rowNum_";
  protected final String TEXT_243 = "),";
  protected final String TEXT_244 = ");// \"table_input\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\tinput_table_";
  protected final String TEXT_246 = ".setValue(";
  protected final String TEXT_247 = ",list_";
  protected final String TEXT_248 = "_";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = ".get(rowNum_";
  protected final String TEXT_251 = "));// \"table_input\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\tinput_table_";
  protected final String TEXT_254 = ".nextRow();" + NL + "\t\t\t}\t" + NL + "\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\tjava.util.List list_";
  protected final String TEXT_256 = "_";
  protected final String TEXT_257 = "_";
  protected final String TEXT_258 = " = new java.util.ArrayList();\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_260 = "_";
  protected final String TEXT_261 = "_";
  protected final String TEXT_262 = ".add(";
  protected final String TEXT_263 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\tisListObject_";
  protected final String TEXT_265 = " = ";
  protected final String TEXT_266 = ";" + NL + "\t\t\t\t\tif(isListObject_";
  protected final String TEXT_267 = " instanceof java.util.List){" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = "_";
  protected final String TEXT_270 = ".addAll((java.util.List)isListObject_";
  protected final String TEXT_271 = ");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = "_";
  protected final String TEXT_274 = ".add(";
  protected final String TEXT_275 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\tint rowSize_";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_279 = NL + "\t\t\t\t\trowSize_";
  protected final String TEXT_280 = "_";
  protected final String TEXT_281 = " = list_";
  protected final String TEXT_282 = "_";
  protected final String TEXT_283 = "_";
  protected final String TEXT_284 = ".size();\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t\tif(rowSize_";
  protected final String TEXT_286 = "_";
  protected final String TEXT_287 = "!=list_";
  protected final String TEXT_288 = "_";
  protected final String TEXT_289 = "_";
  protected final String TEXT_290 = ".size()){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The row count of column: ";
  protected final String TEXT_291 = " in table: ";
  protected final String TEXT_292 = " not equals others, please make sure the row count of every columns equal.\");" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\ttable_input_";
  protected final String TEXT_294 = " = tableParameterList_";
  protected final String TEXT_295 = ".getTable(";
  protected final String TEXT_296 = ");" + NL + "\t\t\ttable_input_";
  protected final String TEXT_297 = ".appendRows(rowSize_";
  protected final String TEXT_298 = "_";
  protected final String TEXT_299 = ");" + NL + "\t\t\ttable_input_";
  protected final String TEXT_300 = ".firstRow();" + NL + "\t\t\tfor(int rowNum_";
  protected final String TEXT_301 = "=0;rowNum_";
  protected final String TEXT_302 = "<rowSize_";
  protected final String TEXT_303 = "_";
  protected final String TEXT_304 = ";rowNum_";
  protected final String TEXT_305 = "++){\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\ttable_input_";
  protected final String TEXT_308 = ".setValue(list_";
  protected final String TEXT_309 = "_";
  protected final String TEXT_310 = "_";
  protected final String TEXT_311 = ".get(rowNum_";
  protected final String TEXT_312 = "),";
  protected final String TEXT_313 = ");// \"input_table\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\t\t\ttable_input_";
  protected final String TEXT_315 = ".setValue(";
  protected final String TEXT_316 = ",list_";
  protected final String TEXT_317 = "_";
  protected final String TEXT_318 = "_";
  protected final String TEXT_319 = ".get(rowNum_";
  protected final String TEXT_320 = "));// \"input_table\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\ttable_input_";
  protected final String TEXT_323 = ".nextRow();" + NL + "\t\t\t}\t" + NL + "\t\t";
  protected final String TEXT_324 = "        " + NL + "\t";
  protected final String TEXT_325 = NL + "\t\ttry{" + NL + "    \t\tclient_";
  protected final String TEXT_326 = ".execute(function_";
  protected final String TEXT_327 = ");" + NL + "\t    }catch (java.lang.Exception e_";
  protected final String TEXT_328 = ") {" + NL + "\t\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_329 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_330 = ".getMessage());" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_331 = NL + "\t\ttry{" + NL + "\t\t\tfunction_";
  protected final String TEXT_332 = ".execute(dest_";
  protected final String TEXT_333 = ");" + NL + "\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_334 = ") {" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_335 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_336 = ".getMessage());" + NL + "\t\t}";
  protected final String TEXT_337 = NL + "\t";
  protected final String TEXT_338 = NL + "\t\tboolean go_";
  protected final String TEXT_339 = " = true;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_340 = NL + "\t\t\t";
  protected final String TEXT_341 = NL + "\t\t\t\tcom.sap.mw.jco.JCO.Table table_";
  protected final String TEXT_342 = "_";
  protected final String TEXT_343 = " = exportParameterList_";
  protected final String TEXT_344 = ".getTable(";
  protected final String TEXT_345 = ");" + NL + "\t\t\t";
  protected final String TEXT_346 = NL + "\t\t\t\tcom.sap.conn.jco.JCoTable table_";
  protected final String TEXT_347 = "_";
  protected final String TEXT_348 = " = exportParameterList_";
  protected final String TEXT_349 = ".getTable(";
  protected final String TEXT_350 = ");" + NL + "\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\tgo_";
  protected final String TEXT_352 = " = !table_";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = ".isEmpty();" + NL + "\t\t";
  protected final String TEXT_355 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_356 = NL + "\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\t\tcom.sap.mw.jco.JCO.Table table_";
  protected final String TEXT_358 = "_";
  protected final String TEXT_359 = " = tableParameterList_";
  protected final String TEXT_360 = ".getTable(";
  protected final String TEXT_361 = ");" + NL + "\t\t\t";
  protected final String TEXT_362 = NL + "\t\t\t\tcom.sap.conn.jco.JCoTable table_";
  protected final String TEXT_363 = "_";
  protected final String TEXT_364 = " = tableParameterList_";
  protected final String TEXT_365 = ".getTable(";
  protected final String TEXT_366 = ");" + NL + "\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\tgo_";
  protected final String TEXT_368 = " = !table_";
  protected final String TEXT_369 = "_";
  protected final String TEXT_370 = ".isEmpty();" + NL + "\t\t";
  protected final String TEXT_371 = "\t\t" + NL + "\t";
  protected final String TEXT_372 = NL + NL + "\twhile(" + NL + "\t";
  protected final String TEXT_373 = NL + "\t\t";
  protected final String TEXT_374 = "go_";
  protected final String TEXT_375 = NL + "\t\t";
  protected final String TEXT_376 = "){" + NL + "\t\t\t";
  protected final String TEXT_377 = NL + "\t\t\t\t";
  protected final String TEXT_378 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_379 = NL + NL + "\t\t\t";
  protected final String TEXT_380 = NL + NL + "\t\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\t    \tif (true) {" + NL + "\t\t\t    \t\tthrow new java.lang.Exception(\"The connection for schema ";
  protected final String TEXT_382 = " is with problem, they must be the same name.\");" + NL + "    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_383 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t    \tif (true) {" + NL + "\t\t\t    \t\tthrow new java.lang.Exception(\"Please make sure to configure the \\\"Outputs->Mapping->Schema XpathQuerys\\\" for schema ";
  protected final String TEXT_385 = "\");    " + NL + "\t\t\t    \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_386 = NL + "\t\t\t\tif(go_";
  protected final String TEXT_387 = "){" + NL + "\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t\t\t\tgo_";
  protected final String TEXT_389 = " = false;\t" + NL + "\t\t\t    \t\t";
  protected final String TEXT_390 = " = new ";
  protected final String TEXT_391 = "Struct();" + NL + "\t\t\t            ";
  protected final String TEXT_392 = NL + "\t\t\t            \t// \"output_single\"--";
  protected final String TEXT_393 = NL + "\t\t\t            \t";
  protected final String TEXT_394 = NL + "\t\t\t            \t";
  protected final String TEXT_395 = "           \t" + NL + "\t\t\t        ";
  protected final String TEXT_396 = NL + "\t\t\t        \tgo_";
  protected final String TEXT_397 = " = false;" + NL + "\t\t\t        \t";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\t\tcom.sap.mw.jco.JCO.Structure output_structure_";
  protected final String TEXT_399 = "_";
  protected final String TEXT_400 = " = exportParameterList_";
  protected final String TEXT_401 = ".getStructure(";
  protected final String TEXT_402 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\t\tcom.sap.conn.jco.JCoStructure output_structure_";
  protected final String TEXT_404 = "_";
  protected final String TEXT_405 = " = exportParameterList_";
  protected final String TEXT_406 = ".getStructure(";
  protected final String TEXT_407 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t    \t\t";
  protected final String TEXT_409 = " = new ";
  protected final String TEXT_410 = "Struct();" + NL + "\t\t\t            ";
  protected final String TEXT_411 = NL + "\t\t\t\t            // \"output_structure\"--";
  protected final String TEXT_412 = NL + "\t\t\t\t            ";
  protected final String TEXT_413 = NL + "\t\t\t            \t";
  protected final String TEXT_414 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\t    \t\tif(table_";
  protected final String TEXT_416 = "_";
  protected final String TEXT_417 = ".isLastRow()){ //check the flag first" + NL + "\t\t\t    \t\t\tgo_";
  protected final String TEXT_418 = " = false;" + NL + "\t\t\t    \t\t}        \t" + NL + "\t    \t\t\t\t";
  protected final String TEXT_419 = " = new ";
  protected final String TEXT_420 = "Struct();" + NL + "\t            \t\t";
  protected final String TEXT_421 = "\t" + NL + "\t\t\t\t            // \"table_output\" or \"output_table\"--";
  protected final String TEXT_422 = NL + "\t\t\t\t            ";
  protected final String TEXT_423 = NL + "\t            \t\t\t";
  protected final String TEXT_424 = " \t" + NL + "\t\t\t            if(go_";
  protected final String TEXT_425 = "){" + NL + "\t            \t\t\ttable_";
  protected final String TEXT_426 = "_";
  protected final String TEXT_427 = ".nextRow();" + NL + "\t            \t\t}     " + NL + "\t\t            ";
  protected final String TEXT_428 = NL + "\t\t\t\t}" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class AssignUtil{
    	public void gen(IConnection justConn,IMetadataColumn justColumn,String value,String paramName){
    		
    		String typeToGenerate = JavaTypesManager.getTypeToGenerate(justColumn.getTalendType(), justColumn.isNullable());
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(justColumn.getTalendType());
			String patternValue = justColumn.getPattern() == null || justColumn.getPattern().trim().length() == 0 ? null : justColumn.getPattern();
			
			if(javaType == JavaTypesManager.DATE) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_7);
    
			} else if(javaType == JavaTypesManager.OBJECT) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_12);
    
			} else{
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_18);
    
			}
    	}
    }
	
    stringBuffer.append(TEXT_19);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    stringBuffer.append(TEXT_20);
    	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ( metadatas != null && metadatas.size() > 0 ) {
		metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn == null || firstColumnList == null)
	{
		return "";
	}
	
    stringBuffer.append(TEXT_21);
             
	List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
	
	List<Map<String, String>> tempSchemaBufferBaseOnLink = new ArrayList<Map<String, String>>();
	//filter some values for schemas, because it should be base on Connection, because some Connection maybe deactivate.
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
	            for(Map<String, String> schemaMap : schemas) {
	            	String schemaName = schemaMap.get("SCHEMA");
	    			if(schemaName.equals(conn.getName())){
						tempSchemaBufferBaseOnLink.add(schemaMap);
	    			}
	    		}	
			}
		}
	}
	schemas =  tempSchemaBufferBaseOnLink;
	
    stringBuffer.append(TEXT_22);
    
	boolean startIterate = false;
	String firstDataConnName = firstDataConn.getName();
	
	String client = ElementParameterParser.getValue(node, "__CLIENT__");
	String userid = ElementParameterParser.getValue(node, "__USERID__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
	String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
	String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
	
	String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
	String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
	String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
	
	String functionName = ElementParameterParser.getValue(node, "__SAP_FUNCTION__");
	
	String iterate_out_type = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TYPE__");
	String iterate_out_tablename = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TABLENAME__");
	String [] iterate_out_multi = iterate_out_tablename.split(",");
	for(int k = 0; k < iterate_out_multi.length; k++){
		if(iterate_out_multi[k] != null){
			iterate_out_multi[k] = iterate_out_multi[k].trim();
		}
	}
	List<String> iterate_out_multi_list = Arrays.asList(iterate_out_multi);
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
	String version = "sapjco.jar";
    if(useExistingConn){
	    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
	    for(INode targetNode : nodes){
	    	if (targetNode.getUniqueName().equals(connection)) {
		      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
		    }
	    }
	}else{
		version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}
	
    String passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_23);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(useExistingConn){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    }else{
    stringBuffer.append(TEXT_36);
    //big try
    stringBuffer.append(TEXT_37);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_45);
    }else{
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    if(useFtpHttp){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(functionName );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    if(useExistingConn){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_84);
           
                        INode connectionNode = null;  
                        for (INode processNode : node.getProcess().getGeneratingNodes()) {  
                                if(connection.equals(processNode.getUniqueName())) {  
                                        connectionNode = processNode;  
                                        break;  
                                }  
                        }  
                        boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__")); 
                        if(specify_alias){ 
                                String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__"); 
                                if(null != alias && !("".equals(alias))){ 

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_88);
     
                                } 
                        } 

    stringBuffer.append(TEXT_89);
    }else{
    stringBuffer.append(TEXT_90);
    //big try
    stringBuffer.append(TEXT_91);
     
                        boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__")); 
                        if(specify_alias){ 
                                String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__"); 
                                if(null != alias && !("".equals(alias))){ 

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_94);
     
                                } 

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
     
                        } 

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_110);
    }else{
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    if(useFtpHttp){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
     
                        if(specify_alias){ 

    stringBuffer.append(TEXT_138);
     
                        } 

    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(functionName );
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
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	Map<String,String> input_single_map = new HashMap<String,String>();
	Map<String,Map<String,String>> input_structure_map = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> input_table_map = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> table_input_map = new HashMap<String,Map<String,String>>();
	Map<String,String> table_map = null;

	List<Map<String, String>> sapMapping_input = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");            
    
	for(Map<String, String> configRow : sapMapping_input){
	
		String parameterType = configRow.get("SAP_PARAMETER_TYPE");
		if("table_input".equals(parameterType)) { 
			if(table_input_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				table_input_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = table_input_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else if("input_table".equals(parameterType)){
			if(input_table_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				input_table_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = input_table_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else if("input_structure".equals(parameterType)){
			if(input_structure_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				input_structure_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = input_structure_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else{
			input_single_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));	
		}
		
		if(true){
		System.out.println(configRow.get("SCHEMA_COLUMN") + " " + configRow.get("SAP_PARAMETER_TYPE") + " " + configRow.get("SAP_TABLE_NAME") + " " + configRow.get("SAP_PARAMETER_NAME") + " " + configRow.get("SAP_PARAMETER_VALUE")+ " " + configRow.get("SAP_TABLE_ROWNUMBER"));
		}
	}
	//assign input value	
	if(!input_single_map.isEmpty()){
		for(Object pName:input_single_map.keySet()){
		
    stringBuffer.append(TEXT_162);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(input_single_map.get(pName));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(pName.toString());
    stringBuffer.append(TEXT_166);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(pName.toString());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(input_single_map.get(pName));
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    
		}
	}
	if(!input_structure_map.isEmpty()){
		for(Object tableName:input_structure_map.keySet()){
		
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(tableName.toString());
    stringBuffer.append(TEXT_175);
    
			table_map = (HashMap<String,String>)input_structure_map.get(tableName);
			for(Object ColName: table_map.keySet()){
			
    stringBuffer.append(TEXT_176);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(table_map.get(ColName));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(ColName.toString());
    stringBuffer.append(TEXT_180);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ColName.toString());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(table_map.get(ColName));
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    
			}
		}
	}
	if(!input_table_map.isEmpty()){
		String tName = "";
		String cName = "";
		for(Object tableName:input_table_map.keySet()){
			tName = TalendTextUtils.removeQuotes(tableName.toString());
			table_map = (HashMap<String,String>)input_table_map.get(tableName);
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				String multiValues = table_map.get(colName);
				
    stringBuffer.append(TEXT_186);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
				if(multiValues != null && multiValues.indexOf(",") != -1){
					String[] values = multiValues.split(",");
					for(int k = 0; k < values.length; k++){
					
    stringBuffer.append(TEXT_190);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(values[k]);
    stringBuffer.append(TEXT_194);
    
					}
				}else{
				
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_206);
    						
				}
			}
			
    stringBuffer.append(TEXT_207);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
     
			boolean isFirstRow = true;
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				if(isFirstRow){ 
				
    stringBuffer.append(TEXT_210);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
					isFirstRow = false;
				}else{
				
    stringBuffer.append(TEXT_216);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_223);
    
				}
			}
			
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_236);
    
				for(Object colName: table_map.keySet()){
					cName = TalendTextUtils.removeQuotes(colName.toString());
					
    stringBuffer.append(TEXT_237);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_244);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    
				}
				
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    
		}
	}
	if(!table_input_map.isEmpty()){
		String tName = "";
		String cName = "";
		for(Object tableName:table_input_map.keySet()){
			tName = TalendTextUtils.removeQuotes(tableName.toString());
			table_map = (HashMap<String,String>)table_input_map.get(tableName);
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				String multiValues = table_map.get(colName);
				
    stringBuffer.append(TEXT_255);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
				if(multiValues != null && multiValues.indexOf(",") != -1){
    				String[] values = multiValues.split(",");
    				for(int k = 0; k < values.length; k++){
					
    stringBuffer.append(TEXT_259);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(values[k]);
    stringBuffer.append(TEXT_263);
    
					}
				}else{
				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_275);
    						
				}
			}
			
    stringBuffer.append(TEXT_276);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
			boolean isFirstRow = true;
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				if(isFirstRow){
				
    stringBuffer.append(TEXT_279);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
					isFirstRow = false;
				}else{
				
    stringBuffer.append(TEXT_285);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_292);
    
				}
			}
			
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_305);
    
				for(Object colName: table_map.keySet()){
					cName = TalendTextUtils.removeQuotes(colName.toString());
					
    stringBuffer.append(TEXT_306);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_313);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    
				}
				
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    
		}
	}	
	
    stringBuffer.append(TEXT_324);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    }
    stringBuffer.append(TEXT_337);
    
	for(Map<String, String> schemaMap : schemas) {
		String schemaName = schemaMap.get("SCHEMA");
		String paramType = schemaMap.get("SAP_ITERATE_OUT_TYPE");	
		String tableName = schemaMap.get("SAP_TABLE_NAME");	
		
    stringBuffer.append(TEXT_338);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_339);
    if(paramType.equals("output_table")){
    stringBuffer.append(TEXT_340);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_341);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_345);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_346);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_350);
    }
    stringBuffer.append(TEXT_351);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    }
    stringBuffer.append(TEXT_355);
    if(paramType.equals("table_output")){
    stringBuffer.append(TEXT_356);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_357);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_361);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_366);
    }
    stringBuffer.append(TEXT_367);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    }
    stringBuffer.append(TEXT_371);
    	
	}
	
    stringBuffer.append(TEXT_372);
    boolean firstWhilePart = true;
	for(Map<String, String> schemaMap : schemas) {
		String schemaName = schemaMap.get("SCHEMA");
		
    stringBuffer.append(TEXT_373);
    stringBuffer.append(!firstWhilePart?"||":"" );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_375);
    	
		firstWhilePart = false;
	}
    stringBuffer.append(TEXT_376);
    
			for(Map<String, String> schemaMap : schemas) {
				String schemaName = schemaMap.get("SCHEMA");
			
    stringBuffer.append(TEXT_377);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_378);
    	
			}
			
    stringBuffer.append(TEXT_379);
    
			for(Map<String, String> schemaMap : schemas) {
				String schemaName = schemaMap.get("SCHEMA");
				String paramType = schemaMap.get("SAP_ITERATE_OUT_TYPE");
				String tableName = schemaMap.get("SAP_TABLE_NAME");	
				String mapping = schemaMap.get("MAPPING");	
				String[] paramNames = null;
				if(mapping != null){
					paramNames = mapping.split(",");
				}	
				IConnection justConn = null; //------->get the right output connection--->to get the columns info
				if(conns != null && conns.size() > 0){
					for(IConnection conn : conns){
						if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(schemaName.equals(conn.getName())){
								justConn = conn;
								break;
							}
						}
					}
				}
				
    stringBuffer.append(TEXT_380);
    
				//do check1, make sure the field "component setting viewer->View->Connection format" is "row"
				if(justConn == null){
				
    stringBuffer.append(TEXT_381);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_382);
    
					return stringBuffer.toString();
				}

				IMetadataTable justMetadata = justConn.getMetadataTable();
				List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
				
    stringBuffer.append(TEXT_383);
    
				//do check2, make sure the field "Schema XpathQuerys" are not empty 
				if(paramNames == null || paramNames.length != justColumnList.size()){
				
    stringBuffer.append(TEXT_384);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_385);
    
					return stringBuffer.toString();
				}
				
    stringBuffer.append(TEXT_386);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_387);
    if(paramType.equals("output_single")){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_391);
    
		                int i = 0;
		                for(IMetadataColumn justColumn : justColumnList){    
			            
    stringBuffer.append(TEXT_392);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_393);
    new AssignUtil().gen(justConn,justColumn,"exportParameterList_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_394);
    	
			            	i++;
			            }
			            
    stringBuffer.append(TEXT_395);
    }else if(paramType.equals("output_structure")){
    stringBuffer.append(TEXT_396);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_397);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_398);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_402);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_403);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_407);
    }
    stringBuffer.append(TEXT_408);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_410);
    
			            int i = 0;
			            for(IMetadataColumn justColumn : justColumnList){    
			            
    stringBuffer.append(TEXT_411);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_412);
    new AssignUtil().gen(justConn,justColumnList.get(i),"output_structure_"+justConn.getName()+"_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_413);
    	
			            	i++;
			            }
			            
    stringBuffer.append(TEXT_414);
    }else if(paramType.equals("output_table") || paramType.equals("table_output")){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_420);
    
		                int i = 0;
		                for(IMetadataColumn justColumn : justColumnList){  
	            		
    stringBuffer.append(TEXT_421);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_422);
    new AssignUtil().gen(justConn,justColumnList.get(i),"table_"+schemaName+"_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_423);
    	
	        				i++;
	            		}
	            		
    stringBuffer.append(TEXT_424);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    
		            }
		            
    stringBuffer.append(TEXT_428);
    	
			}
			
    return stringBuffer.toString();
  }
}
