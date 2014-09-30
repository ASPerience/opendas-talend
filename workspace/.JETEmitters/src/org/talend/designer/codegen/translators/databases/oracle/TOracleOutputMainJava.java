package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.process.IProcess;

public class TOracleOutputMainJava {
  protected static String nl;
  public static synchronized TOracleOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputMainJava result = new TOracleOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        ";
  protected final String TEXT_3 = NL + "            ";
  protected final String TEXT_4 = " = null;            ";
  protected final String TEXT_5 = NL + "\t\tString dataOperationPrefix_";
  protected final String TEXT_6 = " = \"\";" + NL + "\t\tString dataOperationSuffix_";
  protected final String TEXT_7 = " = \"\";" + NL + "\t";
  protected final String TEXT_8 = NL + "\t\tif(nb_line_";
  protected final String TEXT_9 = "==0) {" + NL + "\t";
  protected final String TEXT_10 = NL + NL + "\t\tif(dbschema_";
  protected final String TEXT_11 = " == null || dbschema_";
  protected final String TEXT_12 = ".trim().length() == 0) {" + NL + "\t\t\ttableName_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t} else {" + NL + "\t\t\ttableName_";
  protected final String TEXT_15 = " = dbschema_";
  protected final String TEXT_16 = " + \".\" + ";
  protected final String TEXT_17 = ";    " + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "  \ttableName_";
  protected final String TEXT_19 = " += \" \" +";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_24 = " = conn_";
  protected final String TEXT_25 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Droping table '\" + tableName_";
  protected final String TEXT_28 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "            stmtDrop_";
  protected final String TEXT_30 = ".execute(\"";
  protected final String TEXT_31 = "\");" + NL + "        \t";
  protected final String TEXT_32 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Drop table '\" + tableName_";
  protected final String TEXT_34 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "            stmtDrop_";
  protected final String TEXT_36 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_37 = " = conn_";
  protected final String TEXT_38 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_39 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Creating table '\" + tableName_";
  protected final String TEXT_41 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_43 = ".execute(((\"";
  protected final String TEXT_44 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ", \"";
  protected final String TEXT_47 = "\"))+\")";
  protected final String TEXT_48 = "\")";
  protected final String TEXT_49 = ".toUpperCase()";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_52 = ".execute(\"";
  protected final String TEXT_53 = ")\");";
  protected final String TEXT_54 = NL + "        \t";
  protected final String TEXT_55 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Create table '\" + tableName_";
  protected final String TEXT_57 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_59 = ".close();";
  protected final String TEXT_60 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_61 = " = conn_";
  protected final String TEXT_62 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_63 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_64 = " - Creating table '\" + tableName_";
  protected final String TEXT_65 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_67 = ".execute(((\"";
  protected final String TEXT_68 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ", \"";
  protected final String TEXT_71 = "\"))+\")";
  protected final String TEXT_72 = "\")";
  protected final String TEXT_73 = ".toUpperCase()";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_76 = ".execute(\"";
  protected final String TEXT_77 = ")\");";
  protected final String TEXT_78 = NL + "        \t";
  protected final String TEXT_79 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_80 = " - Create table '\" + tableName_";
  protected final String TEXT_81 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "            stmtCreate_";
  protected final String TEXT_83 = ".close();";
  protected final String TEXT_84 = "\t         " + NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_85 = NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_86 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_87 = "+\"][\"+";
  protected final String TEXT_88 = "+\"][\"+";
  protected final String TEXT_89 = "+\"][\"+";
  protected final String TEXT_90 = "+\"][\"+";
  protected final String TEXT_91 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_92 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_93 = NL + "\t\t    // [%connection%][checktable][tableName]" + NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_94 = " = conn_";
  protected final String TEXT_95 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_96 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_97 = NL + "\t\t    " + NL + "\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_98 = ")== null){" + NL + "\t\t\t" + NL + "\t\t\t\tsynchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_99 = ")) {" + NL + "\t\t\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_100 = ")== null){";
  protected final String TEXT_101 = "              ";
  protected final String TEXT_102 = NL + "\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_103 = " = conn_";
  protected final String TEXT_104 = ".createStatement();" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_105 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tisExistStmt_";
  protected final String TEXT_106 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_107 = " + \"]\" );" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_108 = " = true;" + NL + "\t\t\t\t} catch (java.lang.Exception e){" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_109 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tisExistStmt_";
  protected final String TEXT_110 = ".close();";
  protected final String TEXT_111 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_113 = " = conn_";
  protected final String TEXT_114 = ".getMetaData();" + NL + "\t            if(tableNameForSearch_";
  protected final String TEXT_115 = ".indexOf(\"\\\"\")==-1){" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_116 = " = tableNameForSearch_";
  protected final String TEXT_117 = ".toUpperCase();" + NL + "            \t}else{" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_118 = " = tableNameForSearch_";
  protected final String TEXT_119 = ".replaceAll(\"\\\"\",\"\");" + NL + "            \t}" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_120 = " = dbMetaData_";
  protected final String TEXT_121 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_122 = ", tableNameForSearch_";
  protected final String TEXT_123 = ", new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_124 = " = false;" + NL + "\t            if(rsTable_";
  protected final String TEXT_125 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_126 = " = true;" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_127 = ".close();" + NL + "\t            ";
  protected final String TEXT_128 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_129 = " = conn_";
  protected final String TEXT_130 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_131 = " = dbMetaData_";
  protected final String TEXT_132 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_133 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_134 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_135 = " = rsTable_";
  protected final String TEXT_136 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_137 = " = rsTable_";
  protected final String TEXT_138 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_139 = ".equals";
  protected final String TEXT_140 = "IgnoreCase";
  protected final String TEXT_141 = "(";
  protected final String TEXT_142 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_143 = ".equals";
  protected final String TEXT_144 = "IgnoreCase";
  protected final String TEXT_145 = "(dbschema_";
  protected final String TEXT_146 = ") || dbschema_";
  protected final String TEXT_147 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_148 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_149 = ".close();";
  protected final String TEXT_150 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_151 = " = conn_";
  protected final String TEXT_152 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_153 = " = dbMetaData_";
  protected final String TEXT_154 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_155 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_156 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_157 = " = rsTable_";
  protected final String TEXT_158 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_159 = " = rsTable_";
  protected final String TEXT_160 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_161 = ".equals";
  protected final String TEXT_162 = "IgnoreCase";
  protected final String TEXT_163 = "((";
  protected final String TEXT_164 = ")";
  protected final String TEXT_165 = ".toUpperCase()";
  protected final String TEXT_166 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_167 = ".equals";
  protected final String TEXT_168 = "IgnoreCase";
  protected final String TEXT_169 = "(dbschema_";
  protected final String TEXT_170 = ") || (dbschema_";
  protected final String TEXT_171 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_172 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_173 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_174 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_175 = ".close();";
  protected final String TEXT_176 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_177 = " = conn_";
  protected final String TEXT_178 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_179 = " = dbMetaData_";
  protected final String TEXT_180 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_181 = " = false;" + NL + "\t            String defaultSchema_";
  protected final String TEXT_182 = " = \"public\";" + NL + "\t            if(dbschema_";
  protected final String TEXT_183 = " == null || dbschema_";
  protected final String TEXT_184 = ".trim().length() == 0) {" + NL + "\t            \tjava.sql.Statement stmtSchema_";
  protected final String TEXT_185 = " = conn_";
  protected final String TEXT_186 = ".createStatement();" + NL + "\t            \tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_187 = " = stmtSchema_";
  protected final String TEXT_188 = ".executeQuery(\"select current_schema() \");" + NL + "\t            \twhile(rsSchema_";
  protected final String TEXT_189 = ".next()){" + NL + "\t            \t\tdefaultSchema_";
  protected final String TEXT_190 = " = rsSchema_";
  protected final String TEXT_191 = ".getString(\"current_schema\");" + NL + "\t            \t}" + NL + "\t            \trsSchema_";
  protected final String TEXT_192 = ".close();" + NL + "\t            \tstmtSchema_";
  protected final String TEXT_193 = ".close();" + NL + "\t            }" + NL + "\t            while(rsTable_";
  protected final String TEXT_194 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_195 = " = rsTable_";
  protected final String TEXT_196 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_197 = " = rsTable_";
  protected final String TEXT_198 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_199 = ".equals";
  protected final String TEXT_200 = "IgnoreCase";
  protected final String TEXT_201 = "(";
  protected final String TEXT_202 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_203 = ".equals";
  protected final String TEXT_204 = "IgnoreCase";
  protected final String TEXT_205 = "(dbschema_";
  protected final String TEXT_206 = ") || ((dbschema_";
  protected final String TEXT_207 = " ==null || dbschema_";
  protected final String TEXT_208 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_209 = ".equals";
  protected final String TEXT_210 = "IgnoreCase";
  protected final String TEXT_211 = "(schema_";
  protected final String TEXT_212 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_213 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_214 = ".close();";
  protected final String TEXT_215 = "      " + NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_216 = " = conn_";
  protected final String TEXT_217 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_218 = " = dbMetaData_";
  protected final String TEXT_219 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_220 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_221 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_222 = " = rsTable_";
  protected final String TEXT_223 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_224 = ".equalsIgnoreCase(";
  protected final String TEXT_225 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_226 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_227 = ".close();";
  protected final String TEXT_228 = NL + "                if(!whetherExist_";
  protected final String TEXT_229 = ") {" + NL + "                    java.sql.Statement stmtCreate_";
  protected final String TEXT_230 = " = conn_";
  protected final String TEXT_231 = ".createStatement();" + NL + "        \t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_233 = " - Creating table '\" + tableName_";
  protected final String TEXT_234 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_236 = ".execute(((\"";
  protected final String TEXT_237 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = ", \"";
  protected final String TEXT_240 = "\"))+\")";
  protected final String TEXT_241 = "\")";
  protected final String TEXT_242 = ".toUpperCase()";
  protected final String TEXT_243 = ");";
  protected final String TEXT_244 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_245 = ".execute(\"";
  protected final String TEXT_246 = ")\");";
  protected final String TEXT_247 = NL + "    \t\t   \t";
  protected final String TEXT_248 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_249 = " - Create table '\" + tableName_";
  protected final String TEXT_250 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_251 = NL + "                    stmtCreate_";
  protected final String TEXT_252 = ".close();            " + NL + "                }                ";
  protected final String TEXT_253 = NL + "                if(whetherExist_";
  protected final String TEXT_254 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_255 = " = conn_";
  protected final String TEXT_256 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_257 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_258 = " - Droping table '\" + tableName_";
  protected final String TEXT_259 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_260 = NL + "                    stmtDrop_";
  protected final String TEXT_261 = ".execute(\"";
  protected final String TEXT_262 = "\");" + NL + "\t    \t    \t";
  protected final String TEXT_263 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_264 = " - Drop table '\" + tableName_";
  protected final String TEXT_265 = "+ \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_266 = NL + "                    stmtDrop_";
  protected final String TEXT_267 = ".close();" + NL + "                }" + NL + "                java.sql.Statement stmtCreate_";
  protected final String TEXT_268 = " = conn_";
  protected final String TEXT_269 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_271 = " - Creating table '\" + tableName_";
  protected final String TEXT_272 = " + \"'.\" );" + NL + "\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_274 = ".execute(((\"";
  protected final String TEXT_275 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = ", \"";
  protected final String TEXT_278 = "\"))+\")";
  protected final String TEXT_279 = "\")";
  protected final String TEXT_280 = ".toUpperCase()";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_283 = ".execute(\"";
  protected final String TEXT_284 = ")\");";
  protected final String TEXT_285 = NL + "\t    \t    \t";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_287 = " - Create table '\" + tableName_";
  protected final String TEXT_288 = " + \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_289 = NL + "                stmtCreate_";
  protected final String TEXT_290 = ".close();";
  protected final String TEXT_291 = NL + "\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_292 = ", true);" + NL + "" + NL + "\t\t\t\t\t} // end of if" + NL + "\t\t\t\t} // end synchronized" + NL + "\t\t\t}";
  protected final String TEXT_293 = "            ";
  protected final String TEXT_294 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_295 = " = conn_";
  protected final String TEXT_296 = ".createStatement();" + NL + "    \t   ";
  protected final String TEXT_297 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_298 = " - Clearing table '\" + tableName_";
  protected final String TEXT_299 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_300 = NL + "            stmtClear_";
  protected final String TEXT_301 = ".executeUpdate(\"";
  protected final String TEXT_302 = "\");" + NL + "   \t    \t";
  protected final String TEXT_303 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_304 = "- Clear table '\" + tableName_";
  protected final String TEXT_305 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_306 = NL + "            stmtClear_";
  protected final String TEXT_307 = ".close();";
  protected final String TEXT_308 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_309 = " = conn_";
  protected final String TEXT_310 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_311 = " = stmtTruncCount_";
  protected final String TEXT_312 = ".executeQuery(\"";
  protected final String TEXT_313 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_314 = " = conn_";
  protected final String TEXT_315 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_316 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_317 = " - Trancating table '\" + tableName_";
  protected final String TEXT_318 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_319 = NL + "\t\t\t";
  protected final String TEXT_320 = NL + "\t\t\tconn_";
  protected final String TEXT_321 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_322 = NL + "            stmtTrunc_";
  protected final String TEXT_323 = ".executeUpdate(\"";
  protected final String TEXT_324 = "\");" + NL + "   \t    \t";
  protected final String TEXT_325 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_326 = " - Truncate table '\" + tableName_";
  protected final String TEXT_327 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_328 = NL + "            while(rsTruncCount_";
  protected final String TEXT_329 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_330 = " += rsTruncCount_";
  protected final String TEXT_331 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_332 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_333 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_334 = ".close();            ";
  protected final String TEXT_335 = NL + "\t\t \tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_336 = " = conn_";
  protected final String TEXT_337 = ".createStatement();" + NL + "\t\t \tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_338 = " = stmtTruncCount_";
  protected final String TEXT_339 = ".executeQuery(\"";
  protected final String TEXT_340 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_341 = " = conn_";
  protected final String TEXT_342 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_343 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_344 = " - Truncating reuse stroage table '\" + tableName_";
  protected final String TEXT_345 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_346 = NL + "\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\tconn_";
  protected final String TEXT_348 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_349 = NL + "            stmtTrunc_";
  protected final String TEXT_350 = ".executeUpdate(\"";
  protected final String TEXT_351 = "\");" + NL + "   \t    \t";
  protected final String TEXT_352 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_353 = " - Truncate reuse stroage table '\" + tableName_";
  protected final String TEXT_354 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_355 = NL + "             while(rsTruncCount_";
  protected final String TEXT_356 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_357 = " += rsTruncCount_";
  protected final String TEXT_358 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_359 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_360 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_361 = ".close();";
  protected final String TEXT_362 = NL + "\t\t\t";
  protected final String TEXT_363 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_364 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_365 = " + \" (";
  protected final String TEXT_366 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_367 = ".";
  protected final String TEXT_368 = ",\"";
  protected final String TEXT_369 = "\")+\") VALUES (";
  protected final String TEXT_370 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = ")+\")\";";
  protected final String TEXT_373 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_374 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_375 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_376 = ".";
  protected final String TEXT_377 = ", \"";
  protected final String TEXT_378 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = ")+\")\";";
  protected final String TEXT_381 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_382 = " = insert_";
  protected final String TEXT_383 = ".toUpperCase();" + NL + "\t\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\t";
  protected final String TEXT_385 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_386 = " = new StringBuffer(insert_";
  protected final String TEXT_387 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_388 = ".insert(insert_";
  protected final String TEXT_389 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_390 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_391 = " =insertStringBuffer_";
  protected final String TEXT_392 = ".toString(); ";
  protected final String TEXT_393 = "    \t    " + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_394 = NL + "\t\t\t\t\t\t\t\tpstmt_";
  protected final String TEXT_395 = " = conn_";
  protected final String TEXT_396 = ".prepareStatement(insert_";
  protected final String TEXT_397 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\t\t\t\t\tpstmt_";
  protected final String TEXT_400 = " = null;         " + NL + "\t\t\t\t\t\t\t\t// [%connection%][psmt][tableName]" + NL + "\t\t\t\t\t\t\t\tString keyPsmt_";
  protected final String TEXT_401 = " = conn_";
  protected final String TEXT_402 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_403 = " + \"]\";" + NL + "\t\t\t\t\t\t\t\tif(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_404 = ")== null){" + NL + "\t\t\t\t\t\t\t\t\tpstmt_";
  protected final String TEXT_405 = " = conn_";
  protected final String TEXT_406 = ".prepareStatement(insert_";
  protected final String TEXT_407 = ");\t\t" + NL + "\t\t\t\t\t\t\t\t\tGlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_408 = ", pstmt_";
  protected final String TEXT_409 = ");" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tpstmt_";
  protected final String TEXT_410 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_411 = ");\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_412 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_413 = NL + "\t\t\t\t\t\tString update_";
  protected final String TEXT_414 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_415 = " + \" SET ";
  protected final String TEXT_416 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_417 = ".";
  protected final String TEXT_418 = ", \"";
  protected final String TEXT_419 = "\")+\" WHERE ";
  protected final String TEXT_420 = "\";";
  protected final String TEXT_421 = NL + "\t\t\t\t\t\tString update_";
  protected final String TEXT_422 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_423 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_424 = ".";
  protected final String TEXT_425 = ", \"";
  protected final String TEXT_426 = "\")+\" WHERE ";
  protected final String TEXT_427 = "\";";
  protected final String TEXT_428 = NL + "\t\t\t\t\t\tupdate_";
  protected final String TEXT_429 = " = update_";
  protected final String TEXT_430 = ".toUpperCase();" + NL + "\t\t\t\t\t";
  protected final String TEXT_431 = NL + "\t\t\t\t";
  protected final String TEXT_432 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_433 = " = new StringBuffer(update_";
  protected final String TEXT_434 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_435 = ".insert(update_";
  protected final String TEXT_436 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_437 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_438 = " =updateStringBuffer_";
  protected final String TEXT_439 = ".toString(); ";
  protected final String TEXT_440 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_441 = " = conn_";
  protected final String TEXT_442 = ".prepareStatement(update_";
  protected final String TEXT_443 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_444 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_445 = " = conn_";
  protected final String TEXT_446 = ".prepareStatement((\"SELECT COUNT(1) FROM \" + tableName_";
  protected final String TEXT_447 = " + \" WHERE ";
  protected final String TEXT_448 = "\")";
  protected final String TEXT_449 = ".toUpperCase()";
  protected final String TEXT_450 = ");";
  protected final String TEXT_451 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_452 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_453 = " + \" (";
  protected final String TEXT_454 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = ", \"";
  protected final String TEXT_457 = "\")+\") VALUES (";
  protected final String TEXT_458 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = ")+\")\";";
  protected final String TEXT_461 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_462 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_463 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_464 = ".";
  protected final String TEXT_465 = ", \"";
  protected final String TEXT_466 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_467 = ".";
  protected final String TEXT_468 = ")+\")\";";
  protected final String TEXT_469 = NL + "\t\t\t\t\t\tString update_";
  protected final String TEXT_470 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_471 = " + \" SET ";
  protected final String TEXT_472 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_473 = ".";
  protected final String TEXT_474 = ", \"";
  protected final String TEXT_475 = "\")+\" WHERE ";
  protected final String TEXT_476 = "\";";
  protected final String TEXT_477 = NL + "\t\t\t\t\t\tString update_";
  protected final String TEXT_478 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_479 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_480 = ".";
  protected final String TEXT_481 = ", \"";
  protected final String TEXT_482 = "\")+\" WHERE ";
  protected final String TEXT_483 = "\";";
  protected final String TEXT_484 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_485 = " = insert_";
  protected final String TEXT_486 = ".toUpperCase();" + NL + "\t\t\t\t\t\tupdate_";
  protected final String TEXT_487 = " = update_";
  protected final String TEXT_488 = ".toUpperCase();" + NL + "\t\t\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\t";
  protected final String TEXT_490 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_491 = " = new StringBuffer(insert_";
  protected final String TEXT_492 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_493 = ".insert(insert_";
  protected final String TEXT_494 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_495 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_496 = " =insertStringBuffer_";
  protected final String TEXT_497 = ".toString(); ";
  protected final String TEXT_498 = "    " + NL + "\t\t\t\tpstmtInsert_";
  protected final String TEXT_499 = " = conn_";
  protected final String TEXT_500 = ".prepareStatement(insert_";
  protected final String TEXT_501 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_502 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_503 = " = new StringBuffer(update_";
  protected final String TEXT_504 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_505 = ".insert(update_";
  protected final String TEXT_506 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_507 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_508 = " =updateStringBuffer_";
  protected final String TEXT_509 = ".toString(); ";
  protected final String TEXT_510 = NL + "\t\t\t\tpstmtUpdate_";
  protected final String TEXT_511 = " = conn_";
  protected final String TEXT_512 = ".prepareStatement(update_";
  protected final String TEXT_513 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\t\t\t\tString insert_";
  protected final String TEXT_515 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_516 = " + \" (";
  protected final String TEXT_517 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_518 = ".";
  protected final String TEXT_519 = ", \"";
  protected final String TEXT_520 = "\")+\") VALUES (";
  protected final String TEXT_521 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_522 = ".";
  protected final String TEXT_523 = ")+\")\";";
  protected final String TEXT_524 = NL + "\t\t\t\t\t\t\tString insert_";
  protected final String TEXT_525 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_526 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = ", \"";
  protected final String TEXT_529 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_530 = ".";
  protected final String TEXT_531 = ")+\")\";";
  protected final String TEXT_532 = NL + "\t\t\t\t\t\t\tString update_";
  protected final String TEXT_533 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_534 = " + \" SET ";
  protected final String TEXT_535 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_536 = ".";
  protected final String TEXT_537 = ", \"";
  protected final String TEXT_538 = "\")+\" WHERE ";
  protected final String TEXT_539 = "\";";
  protected final String TEXT_540 = NL + "\t\t\t\t\t\t\tString update_";
  protected final String TEXT_541 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_542 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = ", \"";
  protected final String TEXT_545 = "\")+\" WHERE ";
  protected final String TEXT_546 = "\";";
  protected final String TEXT_547 = NL + "\t\t\t\t\t\t\tinsert_";
  protected final String TEXT_548 = " = insert_";
  protected final String TEXT_549 = ".toUpperCase();" + NL + "\t\t\t\t\t\t\tupdate_";
  protected final String TEXT_550 = " = update_";
  protected final String TEXT_551 = ".toUpperCase();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_552 = NL + "\t\t\t\t";
  protected final String TEXT_553 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_554 = " = new StringBuffer(update_";
  protected final String TEXT_555 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_556 = ".insert(update_";
  protected final String TEXT_557 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_558 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_559 = " =updateStringBuffer_";
  protected final String TEXT_560 = ".toString(); ";
  protected final String TEXT_561 = NL + "\t\t\t\tpstmtUpdate_";
  protected final String TEXT_562 = " = conn_";
  protected final String TEXT_563 = ".prepareStatement(update_";
  protected final String TEXT_564 = ");\t    " + NL + "\t\t\t\t";
  protected final String TEXT_565 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_566 = " = new StringBuffer(insert_";
  protected final String TEXT_567 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_568 = ".insert(insert_";
  protected final String TEXT_569 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_570 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_571 = " =insertStringBuffer_";
  protected final String TEXT_572 = ".toString(); ";
  protected final String TEXT_573 = "    " + NL + "\t\t\t\tpstmtInsert_";
  protected final String TEXT_574 = " = conn_";
  protected final String TEXT_575 = ".prepareStatement(insert_";
  protected final String TEXT_576 = ");\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_577 = NL + "\t\t\t\tString delete_";
  protected final String TEXT_578 = " = \"DELETE FROM \" + tableName_";
  protected final String TEXT_579 = " + \" WHERE ";
  protected final String TEXT_580 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_581 = NL + "\t\t\t\t\tdelete_";
  protected final String TEXT_582 = " = delete_";
  protected final String TEXT_583 = ".toUpperCase();" + NL + "\t\t\t\t";
  protected final String TEXT_584 = NL + "\t\t\t\t";
  protected final String TEXT_585 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_586 = " = new StringBuffer(delete_";
  protected final String TEXT_587 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_588 = ".insert(delete_";
  protected final String TEXT_589 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_590 = "  + \" \" );" + NL + "    delete_";
  protected final String TEXT_591 = " =deleteStringBuffer_";
  protected final String TEXT_592 = ".toString();  ";
  protected final String TEXT_593 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_594 = " = conn_";
  protected final String TEXT_595 = ".prepareStatement(delete_";
  protected final String TEXT_596 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_597 = NL + "\t\t\t   ";
  protected final String TEXT_598 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_599 = " = insert_";
  protected final String TEXT_600 = ".split(\"\\\\?\");";
  protected final String TEXT_601 = NL + "\t\t\tupdate_";
  protected final String TEXT_602 = " += \" \";" + NL + "\t    \tupdateSQLSplits_";
  protected final String TEXT_603 = " = update_";
  protected final String TEXT_604 = ".split(\"\\\\?\");";
  protected final String TEXT_605 = NL + "\t\t\tupdate_";
  protected final String TEXT_606 = " += \" \";" + NL + "\t\t\tupdateSQLSplits_";
  protected final String TEXT_607 = " = update_";
  protected final String TEXT_608 = ".split(\"\\\\?\");" + NL + "\t\t\tinsertSQLSplits_";
  protected final String TEXT_609 = " = insert_";
  protected final String TEXT_610 = ".split(\"\\\\?\");";
  protected final String TEXT_611 = NL + "\t\t\tdelete_";
  protected final String TEXT_612 = " += \" \";" + NL + "\t\t   \tdeleteSQLSplits_";
  protected final String TEXT_613 = " = delete_";
  protected final String TEXT_614 = ".split(\"\\\\?\");";
  protected final String TEXT_615 = NL + "\t\t\treplace_";
  protected final String TEXT_616 = " += \" \";" + NL + "\t\t\treplaceSQLSplits_";
  protected final String TEXT_617 = " = replace_";
  protected final String TEXT_618 = ".split(\"\\\\?\");";
  protected final String TEXT_619 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_620 = " += \" \";" + NL + "\t\t\tinsertIgnoreSQLSplits_";
  protected final String TEXT_621 = " = insertIgnore_";
  protected final String TEXT_622 = ".split(\"\\\\?\");";
  protected final String TEXT_623 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_624 = " = insert_";
  protected final String TEXT_625 = ".split(\"\\\\?\");";
  protected final String TEXT_626 = NL + "\t\t\t   ";
  protected final String TEXT_627 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_628 = NL + "\t\tquery_";
  protected final String TEXT_629 = " = new StringBuffer(\"\");";
  protected final String TEXT_630 = NL + "\t\t\t\tcommitEvery_";
  protected final String TEXT_631 = " = buffersSize_";
  protected final String TEXT_632 = ";";
  protected final String TEXT_633 = NL + "\t\t\t\tbatchSize_";
  protected final String TEXT_634 = " = buffersSize_";
  protected final String TEXT_635 = ";";
  protected final String TEXT_636 = NL + NL + "\t\t";
  protected final String TEXT_637 = NL + "        whetherReject_";
  protected final String TEXT_638 = " = false;";
  protected final String TEXT_639 = NL + "\t\t\t\t\t     \t// TODO unable to parse integer: ";
  protected final String TEXT_640 = NL + "\t\t\t\t\t     \t// TODO error: ";
  protected final String TEXT_641 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_642 = NL + "                    \torg.talend.sdi.geometry.Geometry tGeometry_";
  protected final String TEXT_643 = " = (org.talend.sdi.geometry.Geometry)";
  protected final String TEXT_644 = ".";
  protected final String TEXT_645 = ";" + NL + "\t                    com.vividsolutions.jts.geom.Geometry geometry_";
  protected final String TEXT_646 = " = tGeometry_";
  protected final String TEXT_647 = "._getInternalGeometry();" + NL + "                    \t" + NL + "                    \tcom.vividsolutions.jts.geom.Envelope extends_";
  protected final String TEXT_648 = " = geometryColumnToExtends.get(\"";
  protected final String TEXT_649 = "\");" + NL + "                    \tif (extends_";
  protected final String TEXT_650 = " == null) {" + NL + "                    \t    geometryColumnToExtends.put(\"";
  protected final String TEXT_651 = "\", geometry_";
  protected final String TEXT_652 = ".getEnvelopeInternal());" + NL + "                    \t}" + NL + "                    \telse {" + NL + "                    \t    extends_";
  protected final String TEXT_653 = ".expandToInclude(geometry_";
  protected final String TEXT_654 = ".getEnvelopeInternal()); " + NL + "                    \t}" + NL + "                    \t" + NL + "\t\t\t\t\t\tString wkt_";
  protected final String TEXT_655 = " = geometry_";
  protected final String TEXT_656 = ".toText();" + NL + "\t\t\t\t\t\toracle.spatial.util.WKT oracle_wkt_";
  protected final String TEXT_657 = " = new oracle.spatial.util.WKT();" + NL + "\t\t\t\t\t\toracle.spatial.geometry.JGeometry jgeometry_";
  protected final String TEXT_658 = " = oracle_wkt_";
  protected final String TEXT_659 = ".toJGeometry(wkt_";
  protected final String TEXT_660 = ".getBytes());" + NL;
  protected final String TEXT_661 = NL + "\t\t\t\t\t\t\tjgeometry_";
  protected final String TEXT_662 = ".setSRID(";
  protected final String TEXT_663 = ");";
  protected final String TEXT_664 = NL + "               \t\tpstmt_";
  protected final String TEXT_665 = ".setObject(";
  protected final String TEXT_666 = ", oracle.spatial.geometry.JGeometry.store(jgeometry_";
  protected final String TEXT_667 = ", conn_";
  protected final String TEXT_668 = "));" + NL + "                \t";
  protected final String TEXT_669 = NL + "                    ";
  protected final String TEXT_670 = NL + "                        query_";
  protected final String TEXT_671 = " = ";
  protected final String TEXT_672 = ";";
  protected final String TEXT_673 = NL + "\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_674 = ",";
  protected final String TEXT_675 = ".";
  protected final String TEXT_676 = ", ";
  protected final String TEXT_677 = ",insertSQLSplits_";
  protected final String TEXT_678 = ");";
  protected final String TEXT_679 = NL + "\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_680 = ".";
  protected final String TEXT_681 = ", pstmt_";
  protected final String TEXT_682 = ", ";
  protected final String TEXT_683 = ", \"";
  protected final String TEXT_684 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_685 = NL + "                globalMap.put(\"";
  protected final String TEXT_686 = "_QUERY\", query_";
  protected final String TEXT_687 = ".toString().trim());";
  protected final String TEXT_688 = NL + "    \t\t";
  protected final String TEXT_689 = NL + "\t\t\t";
  protected final String TEXT_690 = NL + "\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_691 = " = \"Inserting\";" + NL + "\t\t\t";
  protected final String TEXT_692 = NL + "    \t\tpstmt_";
  protected final String TEXT_693 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_694 = "++;    \t\t " + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_695 = NL + "\t\t\t\t";
  protected final String TEXT_696 = NL + "\t\t\t\t\tdataOperationSuffix_";
  protected final String TEXT_697 = " = \" to the ";
  protected final String TEXT_698 = " batch\";" + NL + "\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_699 = " = \"Adding\";" + NL + "\t\t\t\t";
  protected final String TEXT_700 = NL + "\t\t\t\tbatchSizeCounter_";
  protected final String TEXT_701 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_702 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_703 = NL + "            try {" + NL + "                nb_line_";
  protected final String TEXT_704 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_705 = NL + "\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_706 = " = \"Inserting\";" + NL + "\t\t\t\t";
  protected final String TEXT_707 = NL + "                insertedCount_";
  protected final String TEXT_708 = " = insertedCount_";
  protected final String TEXT_709 = " + pstmt_";
  protected final String TEXT_710 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e_";
  protected final String TEXT_711 = ") {" + NL + "                whetherReject_";
  protected final String TEXT_712 = " = true;";
  protected final String TEXT_713 = NL + "                \t";
  protected final String TEXT_714 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_715 = " - \" + e_";
  protected final String TEXT_716 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_717 = NL + "                    throw(e_";
  protected final String TEXT_718 = ");";
  protected final String TEXT_719 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_720 = " - \" + e_";
  protected final String TEXT_721 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_722 = NL + "                        ";
  protected final String TEXT_723 = " = new ";
  protected final String TEXT_724 = "Struct();";
  protected final String TEXT_725 = NL + "                            ";
  protected final String TEXT_726 = ".";
  protected final String TEXT_727 = " = ";
  protected final String TEXT_728 = ".";
  protected final String TEXT_729 = ";";
  protected final String TEXT_730 = NL + "                        rejectedCount_";
  protected final String TEXT_731 = " = rejectedCount_";
  protected final String TEXT_732 = " + 1;";
  protected final String TEXT_733 = NL + "                        ";
  protected final String TEXT_734 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_735 = ").getSQLState();";
  protected final String TEXT_736 = NL + "                        ";
  protected final String TEXT_737 = ".errorMessage = e_";
  protected final String TEXT_738 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_739 = ";";
  protected final String TEXT_740 = NL + "                        System.err.print(e_";
  protected final String TEXT_741 = ".getMessage());";
  protected final String TEXT_742 = NL + "            }    \t\t" + NL + "    \t\t";
  protected final String TEXT_743 = NL + "                    ";
  protected final String TEXT_744 = NL + "                        query_";
  protected final String TEXT_745 = " = ";
  protected final String TEXT_746 = ";";
  protected final String TEXT_747 = NL + "                    routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_748 = ",";
  protected final String TEXT_749 = ".";
  protected final String TEXT_750 = ", ";
  protected final String TEXT_751 = ",updateSQLSplits_";
  protected final String TEXT_752 = ");";
  protected final String TEXT_753 = NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_754 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_755 = ".";
  protected final String TEXT_756 = ", pstmt_";
  protected final String TEXT_757 = ", ";
  protected final String TEXT_758 = ", \"";
  protected final String TEXT_759 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_760 = NL + "                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_761 = NL + "\t\t\t\t\t   ";
  protected final String TEXT_762 = NL + "\t\t\t\t\t";
  protected final String TEXT_763 = NL + "\t\t\t\t\t   ";
  protected final String TEXT_764 = NL + "\t\t\t\t\t";
  protected final String TEXT_765 = NL + "\t\t\t\t\t\t\tquery_";
  protected final String TEXT_766 = " = ";
  protected final String TEXT_767 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_768 = NL + "\t\t\t\t\t\t\tquery_";
  protected final String TEXT_769 = " = ";
  protected final String TEXT_770 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_771 = "  " + NL + "                    ";
  protected final String TEXT_772 = NL + "                    ";
  protected final String TEXT_773 = NL + "\t\t\t\t\t   query_";
  protected final String TEXT_774 = " = ";
  protected final String TEXT_775 = ";" + NL + "\t\t\t\t    ";
  protected final String TEXT_776 = NL + "\t\t\t\t\t   query_";
  protected final String TEXT_777 = " = ";
  protected final String TEXT_778 = ";" + NL + "\t\t\t\t    ";
  protected final String TEXT_779 = NL + "                globalMap.put(\"";
  protected final String TEXT_780 = "_QUERY\", query_";
  protected final String TEXT_781 = ".toString().trim());";
  protected final String TEXT_782 = NL + "    \t\t";
  protected final String TEXT_783 = NL + "\t\t\t";
  protected final String TEXT_784 = NL + "\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_785 = " = \"Updating\";" + NL + "\t\t\t";
  protected final String TEXT_786 = NL + "    \t\tpstmt_";
  protected final String TEXT_787 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_788 = "++;" + NL + "    \t\t";
  protected final String TEXT_789 = NL + "\t\t\t";
  protected final String TEXT_790 = NL + "\t\t\t\tdataOperationSuffix_";
  protected final String TEXT_791 = " = \" to the ";
  protected final String TEXT_792 = " batch\";" + NL + "\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_793 = " = \"Adding\";" + NL + "\t\t\t";
  protected final String TEXT_794 = NL + "    \t\tbatchSizeCounter_";
  protected final String TEXT_795 = "++;" + NL + "    \t\t";
  protected final String TEXT_796 = "    \t\t    \t\t" + NL + "    \t\t";
  protected final String TEXT_797 = NL + "             try {" + NL + "                nb_line_";
  protected final String TEXT_798 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_799 = NL + "\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_800 = " = \"Updating\";" + NL + "\t\t\t\t";
  protected final String TEXT_801 = NL + "                updatedCount_";
  protected final String TEXT_802 = " = updatedCount_";
  protected final String TEXT_803 = " + pstmt_";
  protected final String TEXT_804 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e_";
  protected final String TEXT_805 = ") {" + NL + "                whetherReject_";
  protected final String TEXT_806 = " = true;";
  protected final String TEXT_807 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_808 = " - \" + e_";
  protected final String TEXT_809 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_810 = NL + "                    throw(e_";
  protected final String TEXT_811 = ");";
  protected final String TEXT_812 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_813 = " - \" + e_";
  protected final String TEXT_814 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_815 = NL + "                        ";
  protected final String TEXT_816 = " = new ";
  protected final String TEXT_817 = "Struct();";
  protected final String TEXT_818 = NL + "                            ";
  protected final String TEXT_819 = ".";
  protected final String TEXT_820 = " = ";
  protected final String TEXT_821 = ".";
  protected final String TEXT_822 = ";";
  protected final String TEXT_823 = NL + "                        rejectedCount_";
  protected final String TEXT_824 = " = rejectedCount_";
  protected final String TEXT_825 = " + 1;";
  protected final String TEXT_826 = NL + "                        ";
  protected final String TEXT_827 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_828 = ").getSQLState();";
  protected final String TEXT_829 = NL + "                        ";
  protected final String TEXT_830 = ".errorMessage = e_";
  protected final String TEXT_831 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_832 = ";";
  protected final String TEXT_833 = NL + "                        System.err.print(e_";
  protected final String TEXT_834 = ".getMessage());";
  protected final String TEXT_835 = NL + "            }   \t\t    \t\t" + NL + "    \t\t";
  protected final String TEXT_836 = NL;
  protected final String TEXT_837 = NL + "    " + NL + "    \t    ";
  protected final String TEXT_838 = NL + "\t\t\t\t\t";
  protected final String TEXT_839 = NL + "                    \t";
  protected final String TEXT_840 = NL + "                    ";
  protected final String TEXT_841 = NL + "    " + NL + "    \t\tjava.sql.ResultSet rs_";
  protected final String TEXT_842 = " = pstmt_";
  protected final String TEXT_843 = ".executeQuery();" + NL + "    \t\tint checkCount_";
  protected final String TEXT_844 = " = -1;" + NL + "    \t\twhile(rs_";
  protected final String TEXT_845 = ".next()) {" + NL + "    \t\t\tcheckCount_";
  protected final String TEXT_846 = " = rs_";
  protected final String TEXT_847 = ".getInt(1);" + NL + "    \t\t}" + NL + "    \t\tif(checkCount_";
  protected final String TEXT_848 = " > 0) {";
  protected final String TEXT_849 = NL + "                        ";
  protected final String TEXT_850 = NL + "                            query_";
  protected final String TEXT_851 = " = ";
  protected final String TEXT_852 = ";";
  protected final String TEXT_853 = NL + "\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_854 = ",";
  protected final String TEXT_855 = ".";
  protected final String TEXT_856 = ", ";
  protected final String TEXT_857 = ",updateSQLSplits_";
  protected final String TEXT_858 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_859 = NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_860 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_861 = ".";
  protected final String TEXT_862 = ", pstmtUpdate_";
  protected final String TEXT_863 = ", ";
  protected final String TEXT_864 = ", \"";
  protected final String TEXT_865 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_866 = NL + "\t\t\t\t\t";
  protected final String TEXT_867 = NL + "\t\t\t\t";
  protected final String TEXT_868 = NL + "\t\t\t\t\t";
  protected final String TEXT_869 = NL + "\t\t\t\t";
  protected final String TEXT_870 = NL + "\t\t\t\t\t\t\t\tquery_";
  protected final String TEXT_871 = " = ";
  protected final String TEXT_872 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_873 = NL + "\t\t\t\t\t\t\t\tquery_";
  protected final String TEXT_874 = " = ";
  protected final String TEXT_875 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_876 = NL + "                        ";
  protected final String TEXT_877 = NL + "\t\t\t\t\tquery_";
  protected final String TEXT_878 = " = ";
  protected final String TEXT_879 = ";" + NL + "\t\t\t    \t";
  protected final String TEXT_880 = NL + "\t\t\t\t\tquery_";
  protected final String TEXT_881 = " = ";
  protected final String TEXT_882 = ";" + NL + "\t\t\t    \t";
  protected final String TEXT_883 = NL + "                    globalMap.put(\"";
  protected final String TEXT_884 = "_QUERY\", query_";
  protected final String TEXT_885 = ".toString().trim());";
  protected final String TEXT_886 = NL + "                try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_887 = NL + "\t\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_888 = " = \"Updating\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_889 = NL + "        \t\t\tupdatedCount_";
  protected final String TEXT_890 = " = updatedCount_";
  protected final String TEXT_891 = " + pstmtUpdate_";
  protected final String TEXT_892 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e_";
  protected final String TEXT_893 = ") {" + NL + "                    whetherReject_";
  protected final String TEXT_894 = " = true;";
  protected final String TEXT_895 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_896 = " - \" + e_";
  protected final String TEXT_897 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_898 = NL + "                        throw(e_";
  protected final String TEXT_899 = ");";
  protected final String TEXT_900 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_901 = " - \" + e_";
  protected final String TEXT_902 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_903 = NL + "                            ";
  protected final String TEXT_904 = " = new ";
  protected final String TEXT_905 = "Struct();";
  protected final String TEXT_906 = NL + "                                ";
  protected final String TEXT_907 = ".";
  protected final String TEXT_908 = " = ";
  protected final String TEXT_909 = ".";
  protected final String TEXT_910 = ";";
  protected final String TEXT_911 = NL + "                            rejectedCount_";
  protected final String TEXT_912 = " = rejectedCount_";
  protected final String TEXT_913 = " + 1;";
  protected final String TEXT_914 = NL + "                            ";
  protected final String TEXT_915 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_916 = ").getSQLState();";
  protected final String TEXT_917 = NL + "                            ";
  protected final String TEXT_918 = ".errorMessage = e_";
  protected final String TEXT_919 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_920 = ";";
  protected final String TEXT_921 = NL + "                            System.err.print(e_";
  protected final String TEXT_922 = ".getMessage());";
  protected final String TEXT_923 = NL + "                }" + NL + "    \t\t} else {";
  protected final String TEXT_924 = NL + "                        ";
  protected final String TEXT_925 = NL + "                            query_";
  protected final String TEXT_926 = " = ";
  protected final String TEXT_927 = ";";
  protected final String TEXT_928 = NL + "\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_929 = ",";
  protected final String TEXT_930 = ".";
  protected final String TEXT_931 = ", ";
  protected final String TEXT_932 = ",insertSQLSplits_";
  protected final String TEXT_933 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_934 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_935 = ".";
  protected final String TEXT_936 = ", pstmtInsert_";
  protected final String TEXT_937 = ", ";
  protected final String TEXT_938 = ", \"";
  protected final String TEXT_939 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_940 = NL + "                    globalMap.put(\"";
  protected final String TEXT_941 = "_QUERY\", query_";
  protected final String TEXT_942 = ".toString().trim());";
  protected final String TEXT_943 = NL + "                try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_944 = NL + "\t\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_945 = " = \"Inserting\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_946 = NL + "                    insertedCount_";
  protected final String TEXT_947 = " = insertedCount_";
  protected final String TEXT_948 = " + pstmtInsert_";
  protected final String TEXT_949 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e_";
  protected final String TEXT_950 = ") {" + NL + "                    whetherReject_";
  protected final String TEXT_951 = " = true;";
  protected final String TEXT_952 = NL + "\t                    ";
  protected final String TEXT_953 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_954 = " - \" + e_";
  protected final String TEXT_955 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_956 = NL + "                        throw(e_";
  protected final String TEXT_957 = ");";
  protected final String TEXT_958 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_959 = " - \" + e_";
  protected final String TEXT_960 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_961 = NL + "                            ";
  protected final String TEXT_962 = " = new ";
  protected final String TEXT_963 = "Struct();";
  protected final String TEXT_964 = NL + "                                ";
  protected final String TEXT_965 = ".";
  protected final String TEXT_966 = " = ";
  protected final String TEXT_967 = ".";
  protected final String TEXT_968 = ";";
  protected final String TEXT_969 = NL + "                            rejectedCount_";
  protected final String TEXT_970 = " = rejectedCount_";
  protected final String TEXT_971 = " + 1;";
  protected final String TEXT_972 = NL + "                            ";
  protected final String TEXT_973 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_974 = ").getSQLState();";
  protected final String TEXT_975 = NL + "                            ";
  protected final String TEXT_976 = ".errorMessage = e_";
  protected final String TEXT_977 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_978 = ";";
  protected final String TEXT_979 = NL + "                            System.err.print(e_";
  protected final String TEXT_980 = ".getMessage());";
  protected final String TEXT_981 = NL + "                }" + NL + "    \t\t}" + NL + "    \t\tnb_line_";
  protected final String TEXT_982 = "++;" + NL + "    \t\t";
  protected final String TEXT_983 = NL + "    \t    int updateFlag_";
  protected final String TEXT_984 = " = 0;" + NL + "    \t    ";
  protected final String TEXT_985 = NL + "                    ";
  protected final String TEXT_986 = NL + "                        query_";
  protected final String TEXT_987 = " = ";
  protected final String TEXT_988 = ";";
  protected final String TEXT_989 = NL + "\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_990 = ",";
  protected final String TEXT_991 = ".";
  protected final String TEXT_992 = ", ";
  protected final String TEXT_993 = ",updateSQLSplits_";
  protected final String TEXT_994 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_995 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_996 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_997 = ".";
  protected final String TEXT_998 = ", pstmtUpdate_";
  protected final String TEXT_999 = ", ";
  protected final String TEXT_1000 = ", \"";
  protected final String TEXT_1001 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_1002 = NL + "    \t\t\t\t\t";
  protected final String TEXT_1003 = NL + "\t\t\t\t\t";
  protected final String TEXT_1004 = NL + "    \t\t\t\t\t";
  protected final String TEXT_1005 = NL + "\t\t\t\t\t";
  protected final String TEXT_1006 = NL + "\t\t\t\t\t\tquery_";
  protected final String TEXT_1007 = " = ";
  protected final String TEXT_1008 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1009 = NL + "\t\t\t\t\t\tquery_";
  protected final String TEXT_1010 = " = ";
  protected final String TEXT_1011 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1012 = NL + "                    ";
  protected final String TEXT_1013 = NL + "                    ";
  protected final String TEXT_1014 = NL + "\t\t\t\t\t\tquery_";
  protected final String TEXT_1015 = " = ";
  protected final String TEXT_1016 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1017 = NL + "\t\t\t\t\t\tquery_";
  protected final String TEXT_1018 = " = ";
  protected final String TEXT_1019 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1020 = NL + "                globalMap.put(\"";
  protected final String TEXT_1021 = "_QUERY\", query_";
  protected final String TEXT_1022 = ".toString().trim());";
  protected final String TEXT_1023 = NL + "    " + NL + "            try {" + NL + "\t\t\t\t";
  protected final String TEXT_1024 = NL + "\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_1025 = " = \"Updating\";" + NL + "\t\t\t\t";
  protected final String TEXT_1026 = NL + "                updateFlag_";
  protected final String TEXT_1027 = " = pstmtUpdate_";
  protected final String TEXT_1028 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_1029 = " = updatedCount_";
  protected final String TEXT_1030 = "+updateFlag_";
  protected final String TEXT_1031 = ";" + NL + "            if(updateFlag_";
  protected final String TEXT_1032 = " == 0) {" + NL + "            " + NL + "\t\t\t\t";
  protected final String TEXT_1033 = NL + "\t\t\t\tquery_";
  protected final String TEXT_1034 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_1035 = NL + "                        ";
  protected final String TEXT_1036 = NL + "                            query_";
  protected final String TEXT_1037 = " = ";
  protected final String TEXT_1038 = ";";
  protected final String TEXT_1039 = NL + "\t\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_1040 = ",";
  protected final String TEXT_1041 = ".";
  protected final String TEXT_1042 = ", ";
  protected final String TEXT_1043 = ",insertSQLSplits_";
  protected final String TEXT_1044 = ");" + NL + "\t                \t\t\t";
  protected final String TEXT_1045 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1046 = ".";
  protected final String TEXT_1047 = ", pstmtInsert_";
  protected final String TEXT_1048 = ", ";
  protected final String TEXT_1049 = ", \"";
  protected final String TEXT_1050 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1051 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1052 = "_QUERY\", query_";
  protected final String TEXT_1053 = ".toString().trim());";
  protected final String TEXT_1054 = NL + "\t\t\t\t\t";
  protected final String TEXT_1055 = NL + "\t\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_1056 = " = \"Inserting\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1057 = NL + "                    insertedCount_";
  protected final String TEXT_1058 = " = insertedCount_";
  protected final String TEXT_1059 = " + pstmtInsert_";
  protected final String TEXT_1060 = ".executeUpdate();" + NL + "             }" + NL + "                } catch(java.lang.Exception e_";
  protected final String TEXT_1061 = ") {" + NL + "                    whetherReject_";
  protected final String TEXT_1062 = " = true;";
  protected final String TEXT_1063 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1064 = " - \" + e_";
  protected final String TEXT_1065 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1066 = NL + "                        throw(e_";
  protected final String TEXT_1067 = ");";
  protected final String TEXT_1068 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1069 = " - \" + e_";
  protected final String TEXT_1070 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1071 = NL + "                            ";
  protected final String TEXT_1072 = " = new ";
  protected final String TEXT_1073 = "Struct();";
  protected final String TEXT_1074 = NL + "                                ";
  protected final String TEXT_1075 = ".";
  protected final String TEXT_1076 = " = ";
  protected final String TEXT_1077 = ".";
  protected final String TEXT_1078 = ";";
  protected final String TEXT_1079 = NL + "                            rejectedCount_";
  protected final String TEXT_1080 = " = rejectedCount_";
  protected final String TEXT_1081 = " + 1;";
  protected final String TEXT_1082 = NL + "                            ";
  protected final String TEXT_1083 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_1084 = ").getSQLState();";
  protected final String TEXT_1085 = NL + "                            ";
  protected final String TEXT_1086 = ".errorMessage = e_";
  protected final String TEXT_1087 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1088 = ";";
  protected final String TEXT_1089 = NL + "                            System.err.print(e_";
  protected final String TEXT_1090 = ".getMessage());";
  protected final String TEXT_1091 = NL + "                }" + NL + "            nb_line_";
  protected final String TEXT_1092 = "++;";
  protected final String TEXT_1093 = NL + "\t\t\t\t\t";
  protected final String TEXT_1094 = NL + "                    \t";
  protected final String TEXT_1095 = NL + "\t                        query_";
  protected final String TEXT_1096 = " = ";
  protected final String TEXT_1097 = ";" + NL + "\t                        ";
  protected final String TEXT_1098 = NL + "                    ";
  protected final String TEXT_1099 = NL + "                         query_";
  protected final String TEXT_1100 = " = ";
  protected final String TEXT_1101 = ";";
  protected final String TEXT_1102 = NL + "                globalMap.put(\"";
  protected final String TEXT_1103 = "_QUERY\", query_";
  protected final String TEXT_1104 = ".toString().trim());";
  protected final String TEXT_1105 = NL + "    \t\t";
  protected final String TEXT_1106 = NL + "\t\t\t";
  protected final String TEXT_1107 = NL + "\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_1108 = " = \"Deleting\";" + NL + "\t\t\t";
  protected final String TEXT_1109 = NL + "    \t\tpstmt_";
  protected final String TEXT_1110 = ".addBatch();" + NL + "    \t\t  ";
  protected final String TEXT_1111 = NL + "\t\t\t  ";
  protected final String TEXT_1112 = NL + "\t\t\t\tdataOperationSuffix_";
  protected final String TEXT_1113 = " = \" to the ";
  protected final String TEXT_1114 = " batch\";" + NL + "\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_1115 = " = \"Adding\";" + NL + "\t\t\t  ";
  protected final String TEXT_1116 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1117 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1118 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1119 = NL + "            try {" + NL + "\t\t\t\t";
  protected final String TEXT_1120 = NL + "\t\t\t\t\tdataOperationPrefix_";
  protected final String TEXT_1121 = " = \"Deleting\";" + NL + "\t\t\t\t";
  protected final String TEXT_1122 = NL + "                deletedCount_";
  protected final String TEXT_1123 = " = deletedCount_";
  protected final String TEXT_1124 = " + pstmt_";
  protected final String TEXT_1125 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e_";
  protected final String TEXT_1126 = ") {" + NL + "                whetherReject_";
  protected final String TEXT_1127 = " = true;";
  protected final String TEXT_1128 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1129 = " - \" + e_";
  protected final String TEXT_1130 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1131 = NL + "                    throw(e_";
  protected final String TEXT_1132 = ");";
  protected final String TEXT_1133 = NL + "\t\t    \t\t\tlog.error(\"";
  protected final String TEXT_1134 = " - \" + e_";
  protected final String TEXT_1135 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1136 = NL + "                        ";
  protected final String TEXT_1137 = " = new ";
  protected final String TEXT_1138 = "Struct();";
  protected final String TEXT_1139 = NL + "                            ";
  protected final String TEXT_1140 = ".";
  protected final String TEXT_1141 = " = ";
  protected final String TEXT_1142 = ".";
  protected final String TEXT_1143 = ";";
  protected final String TEXT_1144 = NL + "                        rejectedCount_";
  protected final String TEXT_1145 = " = rejectedCount_";
  protected final String TEXT_1146 = " + 1;";
  protected final String TEXT_1147 = NL + "                        ";
  protected final String TEXT_1148 = ".errorCode = ((java.sql.SQLException)e_";
  protected final String TEXT_1149 = ").getSQLState();";
  protected final String TEXT_1150 = NL + "                        ";
  protected final String TEXT_1151 = ".errorMessage = e_";
  protected final String TEXT_1152 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1153 = ";";
  protected final String TEXT_1154 = NL + "                        System.err.print(e_";
  protected final String TEXT_1155 = ".getMessage());";
  protected final String TEXT_1156 = NL + "            }    \t\t    \t\t" + NL + "    \t\t";
  protected final String TEXT_1157 = NL + "            nb_line_";
  protected final String TEXT_1158 = "++;" + NL + "    \t";
  protected final String TEXT_1159 = NL + "                log4jSb_";
  protected final String TEXT_1160 = ".append(";
  protected final String TEXT_1161 = ".";
  protected final String TEXT_1162 = ");";
  protected final String TEXT_1163 = NL + "                \tlog4jSb_";
  protected final String TEXT_1164 = ".append(\"|\");";
  protected final String TEXT_1165 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_1166 = " - \" + dataOperationPrefix_";
  protected final String TEXT_1167 = " + \" the record \" + nb_line_";
  protected final String TEXT_1168 = " + dataOperationSuffix_";
  protected final String TEXT_1169 = " + \".\");" + NL + "\t\t\tlog.trace(\"";
  protected final String TEXT_1170 = " - Content of the record \" + nb_line_";
  protected final String TEXT_1171 = " + \": \" + log4jSb_";
  protected final String TEXT_1172 = ");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_1173 = ".delete(0,log4jSb_";
  protected final String TEXT_1174 = ".length());" + NL + "\t\t";
  protected final String TEXT_1175 = NL + "            if(!whetherReject_";
  protected final String TEXT_1176 = ") {";
  protected final String TEXT_1177 = NL + "                            ";
  protected final String TEXT_1178 = " = new ";
  protected final String TEXT_1179 = "Struct();";
  protected final String TEXT_1180 = NL + "                                ";
  protected final String TEXT_1181 = ".";
  protected final String TEXT_1182 = " = ";
  protected final String TEXT_1183 = ".";
  protected final String TEXT_1184 = ";";
  protected final String TEXT_1185 = NL + "            }";
  protected final String TEXT_1186 = "                                                " + NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1187 = " <= batchSizeCounter_";
  protected final String TEXT_1188 = ") {                " + NL + "                \ttry {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1189 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1190 = " - Executing the ";
  protected final String TEXT_1191 = " batch.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1192 = NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_1193 = ".executeBatch();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1194 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1195 = " - The ";
  protected final String TEXT_1196 = " batch execution has succeeded.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1197 = NL + "                \t}catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_1198 = "){" + NL + "                \t";
  protected final String TEXT_1199 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1200 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1201 = " - \" + e_";
  protected final String TEXT_1202 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1203 = NL + "                \t\tthrow(e_";
  protected final String TEXT_1204 = ");" + NL + "                \t";
  protected final String TEXT_1205 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1206 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1207 = " - \" + e_";
  protected final String TEXT_1208 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1209 = NL + "                \t\tSystem.err.println(e_";
  protected final String TEXT_1210 = ".getMessage());" + NL + "                \t";
  protected final String TEXT_1211 = NL + "                \t}" + NL + "\t\t\t\t\ttmp_batchUpdateCount_";
  protected final String TEXT_1212 = " = pstmt_";
  protected final String TEXT_1213 = ".getUpdateCount();                \t" + NL + "        \t    \t";
  protected final String TEXT_1214 = NL + "        \t    \t\tinsertedCount_";
  protected final String TEXT_1215 = NL + "        \t    \t";
  protected final String TEXT_1216 = NL + "        \t    \t\tupdatedCount_";
  protected final String TEXT_1217 = NL + "        \t    \t";
  protected final String TEXT_1218 = NL + "        \t    \t    deletedCount_";
  protected final String TEXT_1219 = NL + "        \t    \t";
  protected final String TEXT_1220 = "      " + NL + "        \t    \t+= (tmp_batchUpdateCount_";
  protected final String TEXT_1221 = "!=-1?tmp_batchUpdateCount_";
  protected final String TEXT_1222 = ":0);                   \t    \t" + NL + "        \t    \tbatchSizeCounter_";
  protected final String TEXT_1223 = " = 0;             \t                \t                \t" + NL + "    \t\t\t}" + NL + "\t    \t\t";
  protected final String TEXT_1224 = NL + "    \t\t    commitCounter_";
  protected final String TEXT_1225 = "++;            " + NL + "                if(commitEvery_";
  protected final String TEXT_1226 = " <= commitCounter_";
  protected final String TEXT_1227 = ") {" + NL + "                " + NL + "\t                ";
  protected final String TEXT_1228 = NL + "\t\t                try {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1229 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1230 = " - Executing the ";
  protected final String TEXT_1231 = " batch.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1232 = NL + "\t\t                \t\tpstmt_";
  protected final String TEXT_1233 = ".executeBatch();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1234 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1235 = " - The ";
  protected final String TEXT_1236 = " batch execution has succeeded.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1237 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t                }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_1238 = "){" + NL + "\t\t                \t";
  protected final String TEXT_1239 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1240 = NL + "\t\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1241 = " - \" + e_";
  protected final String TEXT_1242 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1243 = NL + "\t\t\t\t\t\t\t\tthrow(e_";
  protected final String TEXT_1244 = ");" + NL + "\t\t                \t";
  protected final String TEXT_1245 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1246 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1247 = " - \" + e_";
  protected final String TEXT_1248 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_1249 = NL + "\t\t                        System.out.println(e_";
  protected final String TEXT_1250 = ".getMessage());" + NL + "\t\t                \t";
  protected final String TEXT_1251 = NL + "\t\t                " + NL + "\t\t                }            \t                              " + NL + "\t\t        \t\ttmp_batchUpdateCount_";
  protected final String TEXT_1252 = " = pstmt_";
  protected final String TEXT_1253 = ".getUpdateCount();" + NL + "\t\t    \t    \t";
  protected final String TEXT_1254 = NL + "\t\t    \t    \t\tinsertedCount_";
  protected final String TEXT_1255 = NL + "\t\t    \t    \t";
  protected final String TEXT_1256 = "            \t    \t\t" + NL + "\t\t    \t    \t\tupdatedCount_";
  protected final String TEXT_1257 = NL + "\t\t    \t    \t";
  protected final String TEXT_1258 = NL + "\t\t    \t    \t    deletedCount_";
  protected final String TEXT_1259 = NL + "\t\t    \t    \t";
  protected final String TEXT_1260 = "     " + NL + "\t\t    \t    \t+= (tmp_batchUpdateCount_";
  protected final String TEXT_1261 = "!=-1?tmp_batchUpdateCount_";
  protected final String TEXT_1262 = ":0);" + NL + "\t                ";
  protected final String TEXT_1263 = NL + "\t\t\t\t\t";
  protected final String TEXT_1264 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1265 = " - Starting to commit \" + commitCounter_";
  protected final String TEXT_1266 = "+ \" records.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1267 = NL + "\t\t        \tconn_";
  protected final String TEXT_1268 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_1269 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1270 = " - Commit has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1271 = "                " + NL + "                \tcommitCounter_";
  protected final String TEXT_1272 = "=0;" + NL + "                }\t";
  protected final String TEXT_1273 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
	public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
			if(this.getColumn()!=null) {
				if (this.getColumn().getTalendType().equals("id_Geometry")) {
				    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
	    			    return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
					return this.sqlStmt;
				}
			} else {
				return this.sqlStmt;
			}
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient

        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
    	  return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
    	  return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                        	// move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                    		if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                    			String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                        		int index = pkList.indexOf(columnStr);
                        		if(index !=-1){
                    				for (int i=index;i>0;i--) {
                    					pkList.set(i, pkList.get(i-1));
                    				}
                    				pkList.set(0, columnStr);
                        		}
                    		}
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
        	if("sybase_id".equalsIgnoreCase(getDBMSId())){
        		return " IDENTITY NOT NULL";
        	} else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
        		return " AUTO_INCREMENT";
        	} else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
        		return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
        	} else {
        		return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
        	}
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.getColumnName().equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
				Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
				skeletonColumn.setOperator("=");
				skeletonColumn.setDataType(column.getType());
				stmtStructure.add(skeletonColumn);
				
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
            	actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
            	actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
	            for(Column column : stmtStructure) {
	            	if(column.isReplaced()) {
	                    List<Column> replacedColumns = column.getReplacement();
	                    for(Column replacedColumn : replacedColumns) {
	                        actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
	                    }
	                } else {
	                    actionSQLMap = processSQLClause(column, actionSQLMap);        
	                }
	            }
            }
            return actionSQLMap;
        }
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            if(column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
		
		public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
			} else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
        		} else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
		
		public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + dynamicIndex + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(null, column, index, incomingConnName, cid, actionType);
        }     
        
		public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
				String fieldDelimiter, 
				String newLineChar,
				String nullIndicator) {
		return null;
			
		}
		
		public String generateCode4TabelExist() {
		    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
		    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		    StringBuilder code = new StringBuilder();  
		    code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
		    if (hasSchema()) {
    		    code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
    		    code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("} else {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("}\r\n");
		    }
		    return code.toString();
		}
		
		protected String getTableName4Search(boolean useExistingConnection, String connection) {
		    return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
		}
		
	    protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
	    }

	    /*
	     * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
	     * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
	     * 
	     * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
	    */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }	
        
        protected boolean hasSchema() {
            return false;
        }
	    
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
            	if (typeToGenerate.equals("Long")) {
            		setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
            	} else {
            		setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            	}
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            	createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
    	String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
	
	public class HiveManager extends Manager {
    	String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
    	boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
        	this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
    	public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
				String recordDelimiter, String nullIndicator) {		
    		StringBuilder copyBulkSQL = new StringBuilder();
			copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
			copyBulkSQL.append(" (\"+");	            
			int counter = 0;
			for(IMetadataColumn column : columnList) {
				counter++;
				// add each table field and separator
				copyBulkSQL.append( 
				"\n\"\\n" +
				  column.getOriginalDbColumnName() 
				+ "="
				+ (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
			
				// add these only if not last entry
				if (counter < columnList.size()){
					copyBulkSQL.append(
					//convertDelim(fieldDelimiter)
					"\"+field_delimiter_"+cid +"+\""
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					+ " ,"
					+ "\""
					+ "+"
					);
				} else {
					copyBulkSQL.append(
					recordDelimiter
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					);
					copyBulkSQL.append(")");
				}     	
			} 
			return copyBulkSQL.toString();
		} 

    	public String getTruncateTableSQL() {
    		StringBuilder truncateTableSQL = new StringBuilder();
    		truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
    		+ cid + " + \"\\\" TO TRUNCATED");
    		return truncateTableSQL.toString();
		}				        
    }
    
    public class VectorWiseManager extends IngresManager {
		public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
	}	
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
        	return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                	MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
					dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){
                	String pattern = column.getColumn().getPattern();
                	setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                	if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                	   setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                	}
                	setStmt.append("}else{\r\n");
					setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
					if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
					setStmt.append(");\r\n");
                	setStmt.append("}\r\n");
                }else{
                	setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                	if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
                	setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
    	  private String[] oracleKeyWords= {
    		    	"ACCESS" ,"AUDIT","COMPRESS","DESC" , 
    		    	"ADD","CONNECT","DISTINCT" ,
    		    	"ALL","BY","CREATE","DROP",
    		    	"ALTER","CHAR","CURRENT","ELSE",
    		    	"AND","CHECK","DATE","EXCLUSIVE",
    		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
    		    	"AS","COLUMN","DEFAULT","FILE",
    		    	"ASC","COMMENT","DELETE","FLOAT",
    		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
    		    	"FROM","MAXEXTENTS","PRIOR","SYNONYM",
    		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
    		    	"GROUP","MODE","PUBLIC","TABLE",
    		    	"HAVING","MODIFY","RAW","THEN",
    		    	"IDENTIFIED","NETWORK","RENAME","TO",
    				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
    				"IN","NOCOMPRESS","REVOKE","UID",
    				"INCREMENT","NOT","ROW","UNION",
    				"INDEX","NOWAIT","ROWID","UNIQUE",
    				"INITIAL","NULL","ROWNUM","UPDATE",
    				"INSERT","NUMBER","ROWS","USER",
    				"INTEGER","OF","SELECT","VALIDATE",
    				"INTERSECT","OFFLINE","SESSION","VALUES",
    				"INTO","ON","SET","VARCHAR",
    				"IS","ONLINE","SHARE","VARCHAR2",
    				"LEVEL","OPTION","SIZE","VIEW",
    				"LIKE","OR","SMALLINT","WHENEVER",
    				"LOCK","ORDER","START","WHERE","WITH"
    		    	};
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
		public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			boolean isObject = false;
			String prefix = null;
			if(actionType == NORMAL_TYPE) {
				prefix = "pstmt_";
			} else if(actionType == INSERT_TYPE) {
				prefix = "pstmtInsert_";
			} else if(actionType == UPDATE_TYPE) {
				prefix = "pstmtUpdate_";
			}
			StringBuilder setStmt = new StringBuilder();
			if(typeToGenerate.equals("Character")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
			} else if(typeToGenerate.equals("Date")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
			} else if(typeToGenerate.equals("byte[]")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
					setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
				} else {
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
				}
			} else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
			} else if(typeToGenerate.equals("String")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				if(dbType != null && dbType.equals("CLOB")) {
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
				} else {
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
				}
			} else if(typeToGenerate.equals("Object")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				if(dbType != null && dbType.equals("BLOB")) {
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
				} else if("CLOB".equals(dbType)){
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
				} else {
					setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
				}
			} else if(typeToGenerate.equals("Boolean")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
			} else if(typeToGenerate.equals("Double")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
			} else if(typeToGenerate.equals("Float")) {
				isObject = true;
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
			}
			if(isObject) {
				setStmt.append("} else {");
			}
			typeToGenerate = getGenerateType(typeToGenerate);
			if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
				if(isObject) {
					setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
				} else {
					setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
				}
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
				setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
				setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
				setStmt.append("} else {\r\n");
				setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
				setStmt.append("}");
			}
			else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
				if(isObject) {
					setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
				} else {
					setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
				}
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
				setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
				setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
				setStmt.append("} else {\r\n");
				setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
				setStmt.append("}");
			} else if(typeToGenerate.equals("Date")) {
				setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
				boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
				if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
					setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
					setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
					setStmt.append("}else{");
					setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
					setStmt.append("}");
				}else if ("Date".equalsIgnoreCase(dbType)) {
					if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
						setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
					} else {
						setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
					}
				} else {
					setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
				}
				setStmt.append("} else {\r\n");
				setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
				setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
				setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
			} else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
				setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
			} else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
				setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
			}else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("XMLTYPE"))) {
				setStmt.append("if (" + incomingConnName + "." + column.getName() + " instanceof String) {\r\n");
				setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  xmlTypeUtil_" + cid + ".getCLOB((String)" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
				setStmt.append("} else {\r\n");
				setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
				setStmt.append("}\r\n");
			}
			else {
				setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
			}
			if(isObject) {
				setStmt.append("}\r\n");
			}
			return setStmt.toString();
		}
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
			boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
			if(convertToUppercase){
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
			}else{
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
			}
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
			String columnName = column.getColumnName();
			String dataType = column.getDataType();
			if(dataType!=null)
			{
			boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
			if(trimChar && "char".equals(dataType.toLowerCase()))
			{
				columnName = "trim("+columnName+")";
			}
			}
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class GreenplumManager extends PostgrePlusManager {
    	 public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
    	 private String[] sybaseKeyWords= {
    			 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
 		    	"ADD","CONNECT","COUNT","DISTINCT" ,
 		    	"ALL","BY","CREATE","DROP",
 		    	"ALTER","CHAR","CURRENT","ELSE",
 		    	"AND","CHECK","DATE","EXCLUSIVE",
 		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
 		    	"AS","COLUMN","DEFAULT","FILE",
 		    	"ASC","COMMENT","DELETE","FLOAT",
 		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
 		    	"FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
 		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
 		    	"GROUP","MODE","PUBLIC","TABLE",
 		    	"HAVING","MODIFY","RAW","THEN",
 		    	"IDENTIFIED","NETWORK","RENAME","TO",
 				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
 				"IN","NOCOMPRESS","REVOKE","UID",
 				"INCREMENT","NOT","ROW","UNION",
 				"INDEX","NOWAIT","ROWID","UNIQUE",
 				"INITIAL","NULL","ROWNUM","UPDATE",
 				"INSERT","NUMBER","ROWS","USER",
 				"INTEGER","OF","SELECT","VALIDATE",
 				"INTERSECT","OFFLINE","SESSION","VALUES",
 				"INTO","ON","SET","VARCHAR",
 				"IS","ONLINE","SHARE",
 				"LEVEL","OPTION","SIZE","VIEW",
 				"LIKE","OR","SMALLINT","WHENEVER",
 				"LOCK","ORDER","START","WHERE","WITH"
    			 
    	 };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal") && column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
   	 	public ExasolManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }  
   }
    public class UnDefinedManager extends Manager{
    	
    	private String dbmsId = "";
    	
    	public UnDefinedManager(String cid) {
            super(cid);
        }
    	public void setDBMSId(String dbmsId){
    		this.dbmsId = dbmsId;
    	}
    	protected String getDBMSId() {
            return this.dbmsId;
        }
    	protected String getLProtectedChar() {
    		return "";
    	}
    	protected String getRProtectedChar() {
    		return "";
    	}
    }
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String tableSchema = ElementParameterParser.getValue(node,"__TABLESCHEMA__");
    String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
    
    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");	
	
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
    String batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
    String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");    
    boolean isUseBatchByDBVersion = !"ORACLE_8".equalsIgnoreCase(dbVersion);
    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    if(useExistingConnection) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
	    for(INode targetNode : nodes){
	    	if (targetNode.getUniqueName().equals(connection)) {
		      dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
		    }
	    }
	}
    
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
    
    boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));
    boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));
    boolean createGeometryColumns = ("true").equals(ElementParameterParser.getValue(node,"__GEOMETRY_COLUMNS__"));
	
	//feature:2880
    ((OracleManager)getManager(dbmsId, cid, node)).setDbVersion(dbVersion);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
    IProcess process = node.getProcess();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = getColumnList(node);
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size() > 0) {
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
		
    String rejectConnName = null;
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
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
              
        }
    }
	
	Manager manager = null;
	boolean isDynamic = false;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		isDynamic = metadata.isDynamicSchema(); 
	}
	
	List<Column> stmtStructure =  getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
	isDynamic = isDynamic && !getManager(dbmsId, cid).isDynamicColumnReplaced();
IMetadataColumn talendDynCol = null;
	if(isLog4jEnabled) {
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}
	
	if(isDynamic) {
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			///// hint options/////
		boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
		Map<String, String> hintsValues = null; 
		if (useHintOptions) {
			List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
			hintsValues = new HashMap<String, String>();
			String hintValue = null;
			boolean firstInsert = true;
			boolean firstUpdate = true;
			boolean firstDelete = true;
			boolean firstTableName = true;
			for(java.util.Map<String, String> option : hintOptions) {
				//get
				if(option.get("HINT").matches("\"/\\*NORMALIZED_HINT\\*/\"")) {
					String id = cid.replace(node.getComponent().getName() + "_", "");
					hintValue = "\"/*\"+" + table + "+\".\" + "  + "\"" + option.get("SQL_STMT")+ ".\"" + "+" +  id   +  "+\"*/\" " ;
				}else if (option.get("HINT").matches("\"/\\*+.*\\*/\"")) {
					hintValue = option.get("HINT");	
				}
				//set
				if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
					if(firstInsert){
						hintsValues.put("INSERT", hintValue) ;
						firstInsert = false;
					}else {
						hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
					}									
				}else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
					if(firstUpdate){
						hintsValues.put("UPDATE", hintValue) ;
						firstUpdate = false;
					}else {
						hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
					}
				}else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
					if (firstDelete){
						hintsValues.put("DELETE", hintValue) ;
						firstDelete =false;
					}else {
						hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
					}		
				}else if ("TABLE_NAME".equalsIgnoreCase(option.get("SQL_STMT"))){
					if (firstTableName){
						hintsValues.put("TABLE_NAME", hintValue) ;
						firstTableName = false;
					}else {
						hintsValues.put("TABLE_NAME", hintsValues.get("TABLE_NAME") + "+" + hintValue) ;
					}
				}
			}
		} 
		//// hint options end ////
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(table);
    stringBuffer.append(convertToUppercase ? ".toUpperCase()" : "");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(table);
    stringBuffer.append(convertToUppercase ? ".toUpperCase()" : "");
    stringBuffer.append(TEXT_17);
    if(useHintOptions && hintsValues.get("TABLE_NAME") != null) {
  
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(hintsValues.get("TABLE_NAME"));
    stringBuffer.append(TEXT_20);
    
  }
    stringBuffer.append(TEXT_21);
    
		if(columnList != null && columnList.size()>0) {    
			
    stringBuffer.append(TEXT_22);
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean isLog4jEnabled_tableAction = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);
	String ending="";
	
	if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
		ending="WITH STRUCTURE = VECTORWISE";
	}

	if(!("NONE").equals(tableAction)) {

        if(("DROP_CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_48);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    
				}
			} else {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_53);
    
			}

    stringBuffer.append(TEXT_54);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    				

        } else if(("CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_72);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    
				}
			} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_77);
    
			}

    stringBuffer.append(TEXT_78);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
        	boolean tableNameCaseSensitive=false;
    		if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
    			tableNameCaseSensitive=true;
    		}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_84);
    //bug22719: informix use independent connection, should remove this code after use shared connection
		    if(INFORMIX.equalsIgnoreCase(dbmsId)){
			    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
	    		String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
			    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
				String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
				String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
		    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_92);
    }else{
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
			}

    stringBuffer.append(TEXT_101);
     
			/*
				case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
				so in mssql use "Select" checked the table whether exist.
			*/
			//TODO we will use like "select" sql intead of use system table to checked table?
			if(MSSQL.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
			} else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
			} else if ( SYBASE.equalsIgnoreCase(dbmsId)
						|| INFORMIX.equalsIgnoreCase(dbmsId) ) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    			
			} else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_164);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
			} else if ( GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    			
			} else {

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
    stringBuffer.append(table);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
			}

    
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_241);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    
				}
			} else {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_246);
    
			}

    stringBuffer.append(TEXT_247);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
            } else {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    }
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_262);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_279);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_281);
    
				}
			} else {

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_284);
    
			}

    stringBuffer.append(TEXT_285);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
			}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    
			}

    stringBuffer.append(TEXT_293);
    
        } else if(("CLEAR").equals(tableAction)) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    }
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_302);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
        }else if(("TRUNCATE").equals(tableAction)) {

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    }
    stringBuffer.append(TEXT_319);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_324);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    }
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    
		} else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_351);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    }
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    
		}         
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    stringBuffer.append(TEXT_362);
    
			Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
			StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);   
			StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);    
			StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);    
			StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
			StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);

			talendDynCol = getDynamicColumn();
			if(("INSERT").equals(dataAction)) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);

					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_367);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_368);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_370);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_371);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_372);
    					} else {

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_376);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_377);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_380);
    
					}
					if(convertToUppercase){
					
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    
					}
				}

    stringBuffer.append(TEXT_384);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    }
    stringBuffer.append(TEXT_393);
    
						//to fixed: bug8422
						if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    
						//to fixed: bug8422
						if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){ 
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    }
    stringBuffer.append(TEXT_412);
    
			} else if (("UPDATE").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_416);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_420);
    					} else {

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_424);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_427);
    
					}
					if(convertToUppercase){
					
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
					}
				}
				
    stringBuffer.append(TEXT_431);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    		
			} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
				
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_448);
    if(convertToUppercase){
    stringBuffer.append(TEXT_449);
    }
    stringBuffer.append(TEXT_450);
    				
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);

					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_455);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_459);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_460);
    					} else {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_464);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_465);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_467);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_468);
    
					}
					if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_474);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_476);
    					} else {

    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_481);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_483);
    
					}
					if(convertToUppercase){
					
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
					}
				}

    stringBuffer.append(TEXT_489);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    }
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    }
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
			} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
					if(conns_dynamic!=null && conns_dynamic.size()>0){
						IConnection conn = conns_dynamic.get(0);

						if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_517);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_523);
    						} else {

    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_528);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_530);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_531);
    
						}
						if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_539);
    						} else {

    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_546);
    
						}
						if(convertToUppercase){
						
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    
						}
					}
				
    stringBuffer.append(TEXT_552);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    }
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    }
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    			
			} else if (("DELETE").equals(dataAction)) {
				
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_580);
    
				if(convertToUppercase){
				
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    
				}
				
    stringBuffer.append(TEXT_584);
    if(useHintOptions && hintsValues.get("DELETE") != null) {
  
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    
  }
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    		
			}
			if(isEnableDebug) {
				
    stringBuffer.append(TEXT_597);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    
		}

    stringBuffer.append(TEXT_626);
    
			}
		}
		
    stringBuffer.append(TEXT_627);
    
	}
	
    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure) {
    	if(!colStmt.isReplaced() && !colStmt.isAddCol() && !colStmt.isDynamic()) {
    		colStruct.add(colStmt);
    	}
    }
	if(isEnableDebug) {

    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
	}
	
	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	
	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!useExistingConnection) {
	    	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_632);
    
	    	}
    	}
    	
    	if (("true").equals(useBatchSize)) {
		    if(!("").equals(batchSize)&&!("0").equals(batchSize)) {

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_635);
    
		    }
    	}

    stringBuffer.append(TEXT_636);
    
	}
	
    if(incomingConnName != null && columnList != null) {
        
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    	
        if(("INSERT").equals(dataAction)) {
		
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    String columnName = column.getName();
                    if( null == dbType) {
                    	dbType="";
                    }
                    if (typeToGenerate.equals("Geometry")) {
                    	int targetSRID = -1;
						try {
						  	targetSRID = Integer.parseInt(ElementParameterParser.getValue(node,"__SRID__"));
						}
					    catch (NumberFormatException e) {
						
    stringBuffer.append(TEXT_639);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SRID__"));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(e.getMessage());
    stringBuffer.append(TEXT_641);
    
						 	e.printStackTrace();
						}
					                    
                    
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(column.getName() );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    
						if (targetSRID > 0) {

    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(targetSRID);
    stringBuffer.append(TEXT_663);
    
						}

    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    
                	}
                    else {
                    
    stringBuffer.append(TEXT_669);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    }
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_672);
    
                    }
                    counter++;
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(talendDynCol);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
    			if(isEnableDebug) {
    			
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_676);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    
    			}
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_679);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_684);
    
				}
			}

            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    
            }            
    		
    stringBuffer.append(TEXT_688);
    if (rejectConnName == null && isUseBatchByDBVersion && !useExistingConnection) { // modification one
    		
    stringBuffer.append(TEXT_689);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
     } 
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    if (("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_695);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
     } 
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    
    		  }
    stringBuffer.append(TEXT_702);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
     } 
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_713);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    }
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    
                } else {
                	if(isLog4jEnabled){
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_722);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_724);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_725);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_727);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_729);
    
                        }
                        
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_739);
    
                    } else {
                        
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    
                    }
                } 
                
    stringBuffer.append(TEXT_742);
    
    		}
    
    	} else if(("UPDATE").equals(dataAction)) {
    	    int counterCol = 1;
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    
    stringBuffer.append(TEXT_743);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_746);
    
                    }                    
                    counterCol++;                   
                }
            }
			if(isDynamic) {
			Column dynamicColumn = getColumn(talendDynCol);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
                if(isEnableDebug) {
                
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_750);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    
                }
                
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_759);
    
					}
				}
    
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    
    stringBuffer.append(TEXT_760);
     
                    //#############for feature:2880 and 6980
				if(whereSupportNull && column.getColumn().isNullable()) { 
					if(isDynamic){
					
    stringBuffer.append(TEXT_761);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_762);
    
					}else{
					
    stringBuffer.append(TEXT_763);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_764);
    
					}
					if(isEnableDebug) {
						if(isDynamic){
						
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_767);
    
						}else{
						
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_770);
    
						}
					}
                    	counterCol++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_771);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    
                    if(isEnableDebug) {
				    if(isDynamic){
				    
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_775);
    
				    }else{
				    
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_778);
    
				    }
                    }                    
                    counterCol++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_781);
    
            }    
    		
    stringBuffer.append(TEXT_782);
    if(rejectConnName == null && isUseBatchByDBVersion && !useExistingConnection) {
    		
    stringBuffer.append(TEXT_783);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
     } 
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    if (("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		
    stringBuffer.append(TEXT_789);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
     } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    
    		}
    stringBuffer.append(TEXT_796);
    
    		}else {
    		
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
     } 
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_809);
    }
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    
                } else {
                	if(isLog4jEnabled){
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_815);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_817);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_818);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_820);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_822);
    
                        }
                        
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_832);
    
                    } else {
                        
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    
                    }
                } 
                
    stringBuffer.append(TEXT_835);
    
    		}
    stringBuffer.append(TEXT_836);
    
    	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_837);
    
    		int columnIndex = 1;
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    
    stringBuffer.append(TEXT_838);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_839);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
      
                    	columnIndex++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_840);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                    columnIndex++;
                }
            }
    		
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_848);
    
    			int counterCol = 1;
                for(Column column : colStruct) {
                    if(column.isUpdatable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
						if( null == dbType) {
							dbType="";
						}
                        
    stringBuffer.append(TEXT_849);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_852);
    
                        }                        
                        counterCol++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(getDynamicColumn());
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					if(isEnableDebug) {
					
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_856);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    
					}
					
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_865);
    
					}
				}
                for(Column column : colStruct) {
                    if(column.isUpdateKey()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
						if( null == dbType) {
							dbType="";
						}
                        
     
	                    //#############for feature:2880
					if(whereSupportNull && column.getColumn().isNullable()) { 
				if(isDynamic){
				
    stringBuffer.append(TEXT_866);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_867);
    
				}else{
				
    stringBuffer.append(TEXT_868);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_869);
    
				}
						if(isEnableDebug) {
							if(isDynamic){
							
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_872);
    
							}else{
							
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_875);
    
							}
						}
	                    	counterCol++;
	                       }
	                     //#############                      
	                    
    stringBuffer.append(TEXT_876);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                        if(isEnableDebug) {
                            	if(isDynamic){
				
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_879);
    
			    	}else{
			    	
    stringBuffer.append(TEXT_880);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_882);
    
			    	}
                        }                        
                        counterCol++;                   
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    
                }                
    			
    stringBuffer.append(TEXT_886);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
     } 
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_892);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_895);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    }
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_899);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_902);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_903);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_904);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_905);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_906);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_908);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_910);
    
                            }
                            
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_920);
    
                        } else {
                            
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_923);
    
    			int counterInsert = 1;
                for(Column columnInsert : colStruct)
                {
                    if(columnInsert.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                        String dbType = columnInsert.getColumn().getType();
						if( null == dbType) {
							dbType="";
						}
                        
    stringBuffer.append(TEXT_924);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_927);
    
                        }                        
                        counterInsert++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(getDynamicColumn());
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					if(isEnableDebug) {
					
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_931);
    stringBuffer.append(counterInsert);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_933);
    
					}
					
    stringBuffer.append(TEXT_934);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_938);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_939);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_942);
    
                }                
    			
    stringBuffer.append(TEXT_943);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
     } 
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_951);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_952);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    }
    stringBuffer.append(TEXT_956);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_957);
    
                    } else {
	                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_961);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_962);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_963);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_964);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_966);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_968);
    
                            }
                            
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(TEXT_972);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_978);
    
                        } else {
                            
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_981);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_982);
    
    	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    
    		int counterColUpdate = 1;
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    String dbType = columnUpdate.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    
    stringBuffer.append(TEXT_985);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_986);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_987);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_988);
    
                    }                    
                    counterColUpdate++;
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(getDynamicColumn());
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
					if(isEnableDebug) {
					
    stringBuffer.append(TEXT_989);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_990);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_992);
    stringBuffer.append(counterColUpdate);
    stringBuffer.append(TEXT_993);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_994);
    
					}
					
    stringBuffer.append(TEXT_995);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_996);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_997);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1001);
    
				}
			}
    
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    String dbType = columnUpdate.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    //#############for feature:2880 and 6980
				if(whereSupportNull && columnUpdate.getColumn().isNullable()) { 
					if(isDynamic){
					
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1003);
    
					}else{
					
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1005);
    
					}
					if(isEnableDebug) {
						if(isDynamic){
						
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1008);
    
						}else{
						
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1011);
    
						}
					}
                    	counterColUpdate++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                    if(isEnableDebug) {
					if(isDynamic){
					
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1016);
    
					}else{
					
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1019);
    
					}
                    }                    
                    counterColUpdate++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1022);
    
            }            
    		
    stringBuffer.append(TEXT_1023);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1025);
     } 
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1032);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1034);
    
        		}
        		int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
						if( null == dbType) {
							dbType="";
						}
                        
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, counter, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1038);
    
                        }                        
                        counter++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(talendDynCol);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
						if(isEnableDebug) {
						
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1044);
    
	    					}
						
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1050);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1053);
    
                }                
        		
    stringBuffer.append(TEXT_1054);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
     } 
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1065);
    }
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1067);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1070);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1073);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1078);
    
                            }
                            
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1088);
    
                        } else {
                            
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1090);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1092);
    
    	
    	} else if (("DELETE").equals(dataAction)) {
    	    int keyCounter = 1;
            for(Column column : colStruct) {
                if(column.isDeleteKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
					if( null == dbType) {
                    	dbType="";
                    }
                    
    stringBuffer.append(TEXT_1093);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1097);
    
	                    	}
                    	 keyCounter++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, dbType, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_1101);
    
                    }                    
                    keyCounter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
    
            }            
    		
    stringBuffer.append(TEXT_1105);
    if (rejectConnName == null && isUseBatchByDBVersion && !useExistingConnection) {
    		
    stringBuffer.append(TEXT_1106);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1108);
     } 
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1110);
    if (("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1111);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1115);
     } 
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1117);
    
    		  }
    stringBuffer.append(TEXT_1118);
    
    		}else {
    		
    stringBuffer.append(TEXT_1119);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
     } 
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1127);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1130);
    }
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1132);
    
                } else {
		    		if(isLog4jEnabled){
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1135);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1138);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1143);
    
                        }
                        
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1153);
    
                    } else {
                        
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1155);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1156);
    
    		}
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1158);
    
    	}
    	
		if(isLog4jEnabled){
			int count = 0;
			for(IMetadataColumn column : columnList) {
				count++;
		
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1162);
    if(count < columnList.size()){
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1164);
    }
            }
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1174);
    }
        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1176);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
                            
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1179);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1184);
                      
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1185);
    
        }	
    	//////////batch execute by batch size///////
    	if ("true".equals(useBatchSize)) {
    		if(!("").equals(batchSize) && !("0").equals(batchSize)) {
                if ( (rejectConnName==null && isUseBatchByDBVersion && !useExistingConnection) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
                
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1188);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1191);
     } 
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1193);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1196);
     } 
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1198);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1199);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1202);
    }
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1204);
    
                	}else {
                	
    stringBuffer.append(TEXT_1205);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1208);
    }
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1210);
    
                	}
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1213);
    if (("INSERT").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1215);
    
        	    	}else if (("UPDATE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1217);
    
        	    	}else if (("DELETE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1219);
    
        	    	}
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1223);
    	
    			}
    		}
    	}
    	
    	
    	////////////commit every////////////
    	if(!useExistingConnection) {
    		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    		    
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1227);
    if ((rejectConnName==null && isUseBatchByDBVersion && !useExistingConnection) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ) {
	                
    stringBuffer.append(TEXT_1228);
    if (isLog4jEnabled && ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1231);
    }
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1233);
    if (isLog4jEnabled && ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1236);
    }
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1238);
    if(("true").equals(dieOnError)) {
		                	
    stringBuffer.append(TEXT_1239);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1242);
    }
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1244);
    
		                	}else {
		                	
    stringBuffer.append(TEXT_1245);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1248);
    }
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1250);
    
		                	}
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1253);
    if (("INSERT").equals(dataAction)) {
		    	    	
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1255);
    
		    	    	}else if (("UPDATE").equals(dataAction)) {
		    	    	
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1257);
    
		    	    	}else if (("DELETE").equals(dataAction)) {
		    	    	
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1259);
    
		    	    	}
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1262);
    
	                }
    stringBuffer.append(TEXT_1263);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1266);
    }
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1268);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1270);
    }
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1272);
    
    		}
    	}
    }
    
    stringBuffer.append(TEXT_1273);
    return stringBuffer.toString();
  }
}
