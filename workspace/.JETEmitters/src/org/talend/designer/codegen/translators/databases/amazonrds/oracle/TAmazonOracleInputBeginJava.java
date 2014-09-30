package org.talend.designer.codegen.translators.databases.amazonrds.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TAmazonOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TAmazonOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonOracleInputBeginJava result = new TAmazonOracleInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");";
  protected final String TEXT_4 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_5 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_6 = ") {";
  protected final String TEXT_7 = NL + "                conn_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_11 = NL + "\t\t\t    java.lang.Class.forName(\"";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t   \tString dbUser_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "        \t\t";
  protected final String TEXT_15 = NL + "        \t\t";
  protected final String TEXT_16 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = "; ";
  protected final String TEXT_22 = NL + "\t\t        String dbPwd_";
  protected final String TEXT_23 = " = decryptedPassword_";
  protected final String TEXT_24 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Start to work\");";
  protected final String TEXT_28 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_29 = " = new StringBuffer();";
  protected final String TEXT_30 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_31 = " - Driver ClassName: ";
  protected final String TEXT_32 = ".\");";
  protected final String TEXT_33 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_36 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_40 = " = log4jDebugParamters_";
  protected final String TEXT_41 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_42 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_47 = " = log4jDebugParamters_";
  protected final String TEXT_48 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_49 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_54 = " = log4jDebugParamters_";
  protected final String TEXT_55 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_56 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_61 = " = log4jDebugParamters_";
  protected final String TEXT_62 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_63 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_68 = " = log4jDebugParamters_";
  protected final String TEXT_69 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_70 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_73 = " = log4jDebugParamters_";
  protected final String TEXT_74 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_75 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_78 = " = log4jDebugParamters_";
  protected final String TEXT_79 = " + \"DBVERSION = ";
  protected final String TEXT_80 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_85 = " = log4jDebugParamters_";
  protected final String TEXT_86 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_87 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t";
  protected final String TEXT_89 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_90 = " = log4jDebugParamters_";
  protected final String TEXT_91 = " + \"USE_CURSOR = ";
  protected final String TEXT_92 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_95 = " = log4jDebugParamters_";
  protected final String TEXT_96 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_97 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_100 = " = log4jDebugParamters_";
  protected final String TEXT_101 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_102 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_107 = " = log4jDebugParamters_";
  protected final String TEXT_108 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_109 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_114 = " = log4jDebugParamters_";
  protected final String TEXT_115 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_116 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_118 = " = \"";
  protected final String TEXT_119 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_120 = ";";
  protected final String TEXT_121 = NL + "\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_124 = " - Connection attempt to '\" + url_";
  protected final String TEXT_125 = " + \"' with the username '\"+ dbUser_";
  protected final String TEXT_126 = " +\"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tconn_";
  protected final String TEXT_128 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_129 = ",dbUser_";
  protected final String TEXT_130 = ",dbPwd_";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "\t\t\t\tconn_";
  protected final String TEXT_133 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_137 = " - Connection to '\" + url_";
  protected final String TEXT_138 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t        ";
  protected final String TEXT_140 = NL + "\t\t    }";
  protected final String TEXT_141 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_142 = " = conn_";
  protected final String TEXT_143 = ".createStatement();";
  protected final String TEXT_144 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_145 = " = conn_";
  protected final String TEXT_146 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_148 = " = rs_";
  protected final String TEXT_149 = ".getString(";
  protected final String TEXT_150 = "column_index_";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "                        if(tmpContent_";
  protected final String TEXT_153 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_154 = " = tmpContent_";
  protected final String TEXT_155 = ";" + NL + "                        }";
  protected final String TEXT_156 = NL + "                    if(tmpContent_";
  protected final String TEXT_157 = " != null && tmpContent_";
  protected final String TEXT_158 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_159 = NL + "                        ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = tmpContent_";
  protected final String TEXT_162 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_163 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_164 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_165 = NL + "                                ";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_168 = NL + "                                ";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_171 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_172 = ")) {\t\t\t  \t\t";
  protected final String TEXT_173 = NL + "                                ";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_177 = " - Value is empty for column : '";
  protected final String TEXT_178 = "' in '";
  protected final String TEXT_179 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_181 = "' in '";
  protected final String TEXT_182 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_183 = NL + "                    }";
  protected final String TEXT_184 = NL + "\t\t\tif(rs_";
  protected final String TEXT_185 = ".getTimestamp(";
  protected final String TEXT_186 = "column_index_";
  protected final String TEXT_187 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " = new java.util.Date(rs_";
  protected final String TEXT_190 = ".getTimestamp(";
  protected final String TEXT_191 = "column_index_";
  protected final String TEXT_192 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_195 = NL + "            tmpContent_";
  protected final String TEXT_196 = " = rs_";
  protected final String TEXT_197 = ".getString(";
  protected final String TEXT_198 = "column_index_";
  protected final String TEXT_199 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_200 = " != null) {";
  protected final String TEXT_201 = NL + "                ";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = tmpContent_";
  protected final String TEXT_204 = ";" + NL + "            } else {";
  protected final String TEXT_205 = NL + "                ";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = null;" + NL + "            }";
  protected final String TEXT_208 = NL + "            if(rs_";
  protected final String TEXT_209 = ".getObject(";
  protected final String TEXT_210 = "column_index_";
  protected final String TEXT_211 = ") != null) {";
  protected final String TEXT_212 = NL + "                ";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = " = rs_";
  protected final String TEXT_215 = ".get";
  protected final String TEXT_216 = "(";
  protected final String TEXT_217 = "column_index_";
  protected final String TEXT_218 = ");" + NL + "            } else {";
  protected final String TEXT_219 = NL + "                    ";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = null;";
  protected final String TEXT_222 = NL + "\t\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_224 = " - Null value in non-Nullable column\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_225 = "    " + NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_226 = NL + "            }";
  protected final String TEXT_227 = NL + "            \tString url_";
  protected final String TEXT_228 = " = null;";
  protected final String TEXT_229 = NL + "            \t\turl_";
  protected final String TEXT_230 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_231 = " + \":\" + ";
  protected final String TEXT_232 = " + \":\" + ";
  protected final String TEXT_233 = ";";
  protected final String TEXT_234 = NL + "            \t\turl_";
  protected final String TEXT_235 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_236 = " + \")(port=\" + ";
  protected final String TEXT_237 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_238 = " + \")))\";";
  protected final String TEXT_239 = NL + "            \t    url_";
  protected final String TEXT_240 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_241 = ";";
  protected final String TEXT_242 = NL + "\t    \t\t\turl_";
  protected final String TEXT_243 = " = ";
  protected final String TEXT_244 = ";";
  protected final String TEXT_245 = NL;
  protected final String TEXT_246 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_247 = "\");" + NL + "\t\t\t";
  protected final String TEXT_248 = NL + "\t        String dbUser_";
  protected final String TEXT_249 = " = ";
  protected final String TEXT_250 = ";" + NL + "    \t\t";
  protected final String TEXT_251 = NL + "    \t\t";
  protected final String TEXT_252 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_253 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_254 = ");";
  protected final String TEXT_255 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_256 = " = ";
  protected final String TEXT_257 = "; ";
  protected final String TEXT_258 = NL + "\t        String dbPwd_";
  protected final String TEXT_259 = " = decryptedPassword_";
  protected final String TEXT_260 = ";";
  protected final String TEXT_261 = NL + "\t\t\tconn_";
  protected final String TEXT_262 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "\t\t\tconn_";
  protected final String TEXT_265 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_266 = ",dbUser_";
  protected final String TEXT_267 = ",dbPwd_";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "\t\t\tString atnParams_";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";" + NL + "\t\t\tatnParams_";
  protected final String TEXT_272 = " = atnParams_";
  protected final String TEXT_273 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_274 = " = new java.util.Properties();" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_275 = ".put(\"user\",dbUser_";
  protected final String TEXT_276 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_277 = ".put(\"password\",dbPwd_";
  protected final String TEXT_278 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_279 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_280 = ".getBytes()));" + NL + "\t\t\tconn_";
  protected final String TEXT_281 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_282 = ", atnParamsPrope_";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "                stmt_";
  protected final String TEXT_285 = ".setFetchSize(";
  protected final String TEXT_286 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_288 = " = rs_";
  protected final String TEXT_289 = ".getCharacterStream(";
  protected final String TEXT_290 = "column_index_";
  protected final String TEXT_291 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_292 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_293 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_294 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_295 = ");                 \t                        " + NL + " \t                StringBuffer content_";
  protected final String TEXT_296 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_297 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_298 = " = br_";
  protected final String TEXT_299 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_300 = ".append((char)c_";
  protected final String TEXT_301 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_302 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = " = content_";
  protected final String TEXT_305 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = " = null;" + NL + "\t\t\t\t}                 \t                    ";
  protected final String TEXT_308 = NL + "\t\t\t \t    tmpContent_";
  protected final String TEXT_309 = " = rs_";
  protected final String TEXT_310 = ".getString(";
  protected final String TEXT_311 = "column_index_";
  protected final String TEXT_312 = ");" + NL + "\t\t\t        if(tmpContent_";
  protected final String TEXT_313 = " != null) {" + NL + "\t\t\t            ";
  protected final String TEXT_314 = ".";
  protected final String TEXT_315 = " = tmpContent_";
  protected final String TEXT_316 = ";" + NL + "\t\t\t        } else {" + NL + "\t\t\t            ";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = " = null;" + NL + "\t\t\t        }                 \t                    ";
  protected final String TEXT_319 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_320 = " = rs_";
  protected final String TEXT_321 = ".getBytes(";
  protected final String TEXT_322 = "column_index_";
  protected final String TEXT_323 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_324 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = " = tmpBytes_";
  protected final String TEXT_327 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_328 = ".";
  protected final String TEXT_329 = " = null;" + NL + "\t\t\t}\t\t";
  protected final String TEXT_330 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_331 = "_";
  protected final String TEXT_332 = " = rs_";
  protected final String TEXT_333 = ".getObject(";
  protected final String TEXT_334 = "column_index_";
  protected final String TEXT_335 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_336 = "_";
  protected final String TEXT_337 = " != null) {";
  protected final String TEXT_338 = NL + "\t\t\t\t\t";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_341 = "_";
  protected final String TEXT_342 = ").getStringVal();";
  protected final String TEXT_343 = NL + "\t\t\t\t\t";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = " = tmpObj_";
  protected final String TEXT_346 = "_";
  protected final String TEXT_347 = ";";
  protected final String TEXT_348 = NL + "\t\t\t\t} else {";
  protected final String TEXT_349 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_350 = ".";
  protected final String TEXT_351 = " = null;";
  protected final String TEXT_352 = "    " + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_353 = NL + "\t\t\t\t}";
  protected final String TEXT_354 = NL + "\t\t\t\tif(rs_";
  protected final String TEXT_355 = ".getObject(";
  protected final String TEXT_356 = "column_index_";
  protected final String TEXT_357 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_358 = ".";
  protected final String TEXT_359 = " = rs_";
  protected final String TEXT_360 = ".get";
  protected final String TEXT_361 = "(";
  protected final String TEXT_362 = "column_index_";
  protected final String TEXT_363 = ");" + NL + "\t\t\t\t} else {";
  protected final String TEXT_364 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_365 = ".";
  protected final String TEXT_366 = " = null;";
  protected final String TEXT_367 = "    " + NL + " \t                        throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_368 = NL + "\t\t\t\t}";
  protected final String TEXT_369 = NL + NL + "    " + NL + "\t";
  protected final String TEXT_370 = NL + "\t\t    int nb_line_";
  protected final String TEXT_371 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_372 = " = null;";
  protected final String TEXT_373 = NL + "\t\t        conn_";
  protected final String TEXT_374 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_375 = "\");";
  protected final String TEXT_376 = NL + "\t\t        \tif (null == conn_";
  protected final String TEXT_377 = ") {" + NL + "\t\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_378 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\t\tconn_";
  protected final String TEXT_379 = " = dataSources_";
  protected final String TEXT_380 = ".get(";
  protected final String TEXT_381 = ").getConnection();" + NL + "\t\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_382 = "\", conn_";
  protected final String TEXT_383 = ");" + NL + "\t\t        \t}" + NL + "\t\t        ";
  protected final String TEXT_384 = NL + "\t\t\t\t";
  protected final String TEXT_385 = NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_386 = " != null) {" + NL + "\t\t\t\t\t\tif(conn_";
  protected final String TEXT_387 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_388 = " - Uses an existing connection as \" + conn_";
  protected final String TEXT_389 = ".getMetaData().getUserName() + \". Connection URL: \" + conn_";
  protected final String TEXT_390 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_391 = NL + NL + "\t\t    ";
  protected final String TEXT_392 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_393 = " = ";
  protected final String TEXT_394 = ";";
  protected final String TEXT_395 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_396 = " - Executing the query: '\" + dbquery_";
  protected final String TEXT_397 = " + \"'.\");";
  protected final String TEXT_398 = NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_399 = "_QUERY\",dbquery_";
  protected final String TEXT_400 = ");" + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_401 = " = null;" + NL + "\t\ttry{" + NL + "\t\t    rs_";
  protected final String TEXT_402 = " = stmt_";
  protected final String TEXT_403 = ".executeQuery(dbquery_";
  protected final String TEXT_404 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_405 = " = rs_";
  protected final String TEXT_406 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_407 = " = rsmd_";
  protected final String TEXT_408 = ".getColumnCount();" + NL;
  protected final String TEXT_409 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_410 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_411 = ".setDbmsId(\"";
  protected final String TEXT_412 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_413 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_414 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_415 = ".add(\"";
  protected final String TEXT_416 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_417 = NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_418 = " = ";
  protected final String TEXT_419 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_420 = "; i <= rsmd_";
  protected final String TEXT_421 = ".getColumnCount()-";
  protected final String TEXT_422 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_423 = ".contains(rsmd_";
  protected final String TEXT_424 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_425 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_426 = ".setName(rsmd_";
  protected final String TEXT_427 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_428 = ".setDbName(rsmd_";
  protected final String TEXT_429 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_430 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_431 = "\", rsmd_";
  protected final String TEXT_432 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_433 = ".getPrecision(i), rsmd_";
  protected final String TEXT_434 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_435 = ".setDbType(rsmd_";
  protected final String TEXT_436 = ".getColumnTypeName(i));";
  protected final String TEXT_437 = NL + "                \tdcm_";
  protected final String TEXT_438 = ".setFormat(";
  protected final String TEXT_439 = ");";
  protected final String TEXT_440 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_441 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_442 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_443 = ".setLength(rsmd_";
  protected final String TEXT_444 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_445 = ".setLength(rsmd_";
  protected final String TEXT_446 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_447 = NL + "\t\t\tdcm_";
  protected final String TEXT_448 = ".setLength(rsmd_";
  protected final String TEXT_449 = ".getPrecision(i));";
  protected final String TEXT_450 = NL + "                \tdcm_";
  protected final String TEXT_451 = ".setPrecision(rsmd_";
  protected final String TEXT_452 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_453 = ".setNullable(rsmd_";
  protected final String TEXT_454 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_455 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_456 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_457 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_458 = ".metadatas.add(dcm_";
  protected final String TEXT_459 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_460 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_461 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_462 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_463 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_464 = NL + "\t\t    ";
  protected final String TEXT_465 = NL + "\t\t\t    StringBuffer log4jSb_";
  protected final String TEXT_466 = " = new StringBuffer();" + NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_467 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_468 = NL + "\t\t    while (rs_";
  protected final String TEXT_469 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_470 = "++;" + NL + "\t\t        ";
  protected final String TEXT_471 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_472 = " = ";
  protected final String TEXT_473 = " + dcg_";
  protected final String TEXT_474 = ".getColumnCount(); " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_475 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_476 = " = ";
  protected final String TEXT_477 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_478 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_479 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_480 = " < ";
  protected final String TEXT_481 = "column_index_";
  protected final String TEXT_482 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_483 = ".";
  protected final String TEXT_484 = " = ";
  protected final String TEXT_485 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_486 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_487 = "\t\t\t";
  protected final String TEXT_488 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_490 = NL + "\t\t                            ";
  protected final String TEXT_491 = ".";
  protected final String TEXT_492 = " = (List)rs_";
  protected final String TEXT_493 = ".getObject(";
  protected final String TEXT_494 = "column_index_";
  protected final String TEXT_495 = ");";
  protected final String TEXT_496 = NL + "\t\t                         ";
  protected final String TEXT_497 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_498 = ".getObject(";
  protected final String TEXT_499 = "column_index_";
  protected final String TEXT_500 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_501 = NL + "                                    ";
  protected final String TEXT_502 = ".";
  protected final String TEXT_503 = " = new Geometry(wktValue);";
  protected final String TEXT_504 = NL + "                                        ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = ".setEPSG(";
  protected final String TEXT_507 = ");";
  protected final String TEXT_508 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_509 = NL + "                                  ";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = "=dcg_";
  protected final String TEXT_512 = ";";
  protected final String TEXT_513 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_514 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_515 = " = ";
  protected final String TEXT_516 = "; i_";
  protected final String TEXT_517 = "  <= rsmd_";
  protected final String TEXT_518 = ".getColumnCount(); i_";
  protected final String TEXT_519 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_520 = ".getColumnTypeName(i_";
  protected final String TEXT_521 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_522 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_523 = ".getClob(i_";
  protected final String TEXT_524 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_525 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_526 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_527 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_528 = ".add(tNTextImpl_";
  protected final String TEXT_529 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_530 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_531 = ".";
  protected final String TEXT_532 = ", rs_";
  protected final String TEXT_533 = ", fixedColumnCount_";
  protected final String TEXT_534 = ",list_";
  protected final String TEXT_535 = ");";
  protected final String TEXT_536 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_537 = ".";
  protected final String TEXT_538 = ", rs_";
  protected final String TEXT_539 = ", fixedColumnCount_";
  protected final String TEXT_540 = ");";
  protected final String TEXT_541 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_542 = ".";
  protected final String TEXT_543 = ", rs_";
  protected final String TEXT_544 = ", fixedColumnCount_";
  protected final String TEXT_545 = ");";
  protected final String TEXT_546 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_547 = ".getObject(";
  protected final String TEXT_548 = "column_index_";
  protected final String TEXT_549 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = " = new Geometry(sb.toString());";
  protected final String TEXT_552 = NL + "\t\t                          ";
  protected final String TEXT_553 = NL + "\t\t                    }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_554 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_555 = ".append(";
  protected final String TEXT_556 = ".";
  protected final String TEXT_557 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_558 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_559 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_560 = NL + "\t\t\t\t\t";
  protected final String TEXT_561 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_562 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_563 = " + \".\");" + NL + "\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_564 = " - Content of the record \" + nb_line_";
  protected final String TEXT_565 = " + \": \" + log4jSb_";
  protected final String TEXT_566 = ");" + NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_567 = ".delete(0,log4jSb_";
  protected final String TEXT_568 = ".length());" + NL + "\t\t\t\t\t";
  protected final String TEXT_569 = NL + "\t\t                            ";
  protected final String TEXT_570 = ".";
  protected final String TEXT_571 = " = ";
  protected final String TEXT_572 = ".";
  protected final String TEXT_573 = ";" + NL + "\t\t                            ";
  protected final String TEXT_574 = NL + NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_575 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	    	if(isLog4jEnabled){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    			}
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    }
	    
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    
		}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_14);
    
        		String passwordFieldName = "__PASS__";
        		
    stringBuffer.append(TEXT_15);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    } else {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    this.setURL(node);
    stringBuffer.append(TEXT_25);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jCodeGenerateUtil {
	
		INode node = null;
	    String cid = null;
		String dbproperties = null;
		String dbhost = null;
    	String dbport = null;
    	String dbname = null;
    	String dbuser = null;
 		String dbpwd = null;
		String connectionType = null;
 		String dbVersion =  null; 
 		String dbSchema = null;
 		String useCursor = null;
 		String trimAllColumn = null;
 		String noNullValues = null;
 		String dbquery= null;
 		String table = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	 		dbSchema = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
	 		useCursor = ElementParameterParser.getValue(node,"__USE_CURSOR__");
	 		trimAllColumn = ElementParameterParser.getValue(node,"__TRIM_ALL_COLUMN__");
	 		noNullValues = ElementParameterParser.getValue(node,"__NO_NULL_VALUES__");
	 		dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			table= ElementParameterParser.getValue(node, "__TABLE__");
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void infoComponentStart(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_32);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
			}
		}
	
		public void dbConnectionParamsForELT(INode previousNode){
			cid = previousNode.getUniqueName();
			dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	    	dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
		}
		
		public void additionalParameter(INode node) {
			String needtoConvet2Upper= ElementParameterParser.getValue(node, "__Convert_to_UPPer__");
		}
		
		public void generateAdditionalParameters(INode node) {
			additionalParameter(node);
		}
		
		public void generateConnectionParams() {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_121);
    log4jCodeGenerateUtil.debugConnectionParams(node,this.getDirverClassName(node));
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    }
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
			} else {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
			}

    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_140);
    
			}
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    if(isDynamic){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_151);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_155);
    
                    }

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_170);
    
                        } else {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_175);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_182);
    
                        }

    stringBuffer.append(TEXT_183);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    if(isDynamic){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    if(isDynamic){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_192);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_194);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    if(isDynamic){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_207);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    if(isDynamic){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_216);
    if(isDynamic){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_218);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_219);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_221);
    
                } else {
                    
    stringBuffer.append(TEXT_222);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
        
                }
                
    stringBuffer.append(TEXT_226);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    

	class DBInputBeginUtil extends DefaultDBInputUtil{
	
		private INode node = null;
		
		public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	this.node = node;
	    }
	
		public void setURL(INode node) {
			
			String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
            	if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_233);
    
            	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_238);
    
            	} else if(("ORACLE_OCI").equals(connectionType)) {
            	    
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_241);
    
            	}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_244);
    
				}

    stringBuffer.append(TEXT_245);
    
		}
		
		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";	
			}else {
				return "oracle.jdbc.driver.OracleDriver";	
			}
		}
		
		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");

    stringBuffer.append(TEXT_246);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_247);
    this.setURL(node);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_250);
    
    		String passwordFieldName = "__PASS__";
    		
    stringBuffer.append(TEXT_251);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_254);
    } else {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    
			}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
			} else {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(dbproperties);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
			}
		}
		
		public void createStatement(INode node) {
			
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_286);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    if(isDynamic){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_307);
    
			} else {

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    if(isDynamic){
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_318);
    
			}
	    }
	    
	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    if(isDynamic){
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_329);
    
	    }

	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
	   		boolean isConvert = ("true").equals(ElementParameterParser.getValue(node, "__IS_CONVERT_XMLTYPE__"));    
			List<Map<String, String>> convertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONVERT_XMLTYPE__");  
	   		
			if(("Object").equals(typeToGenerate)){
			
				boolean needConvert = false;
	   			String convertToJavaType = "";
				if (isConvert && convertColumns.size() > 0) {
					for(java.util.Map<String, String> convertcolumn : convertColumns) {
						if (convertcolumn.get("REFCOL").equals(column.getLabel()) ) {
							needConvert = true;
							convertToJavaType = convertcolumn.get("CONVETTYPE");
						}
					}
				} 
				

    stringBuffer.append(TEXT_330);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    if(isDynamic){
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_335);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_338);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    
				} else {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    
				}

    stringBuffer.append(TEXT_348);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_351);
    
					} else {

    stringBuffer.append(TEXT_352);
        
					}

    stringBuffer.append(TEXT_353);
    
			} else {

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    if(isDynamic){
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_357);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_361);
    if(isDynamic){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_363);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_364);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_366);
    
					} else {

    stringBuffer.append(TEXT_367);
        
					}

    stringBuffer.append(TEXT_368);
    
			}
	    }	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_369);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	        
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_375);
    
                INode connectionNode = null;
                for (INode processNode : node.getProcess().getGeneratingNodes()) {
                    if(connection.equals(processNode.getUniqueName())) {
                        connectionNode = processNode;
                        break;
                    }
                }
		        boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
		        if(specify_alias){
	                String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    
		        }
		        
    stringBuffer.append(TEXT_384);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
     } 
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_391);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_394);
    
			if(isLog4jEnabled && ("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
			}

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
		    
		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_416);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_439);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

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
    
		} else {

    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    
		}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
		    }
		    
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    if(isDynamic){
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    }
    stringBuffer.append(TEXT_464);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    }
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();
		                 
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    }else{
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_477);
    }
    stringBuffer.append(TEXT_478);
    
							}
							
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    if(isDynamic){
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_482);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_485);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_486);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_487);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_488);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_489);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_490);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    if(isDynamic){
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_495);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_496);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    if(isDynamic){
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_500);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_503);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_504);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_507);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_508);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_509);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_535);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_536);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    
									}else{

    stringBuffer.append(TEXT_541);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    if(isDynamic){
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_549);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_551);
    
                 	            } else {

    stringBuffer.append(TEXT_552);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_553);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_557);
    if(columnList.size() > currentColNo){
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    }
							}
      
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_560);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_569);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_570);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_573);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_574);
    stringBuffer.append(TEXT_575);
    return stringBuffer.toString();
  }
}
