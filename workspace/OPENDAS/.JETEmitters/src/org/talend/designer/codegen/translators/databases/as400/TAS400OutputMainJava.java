package org.talend.designer.codegen.translators.databases.as400;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TAS400OutputMainJava {
  protected static String nl;
  public static synchronized TAS400OutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAS400OutputMainJava result = new TAS400OutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        ";
  protected final String TEXT_3 = NL + "            ";
  protected final String TEXT_4 = " = null;            ";
  protected final String TEXT_5 = NL + "\t\tquery_";
  protected final String TEXT_6 = " = new StringBuffer(\"\");";
  protected final String TEXT_7 = NL + "\t\tif(nb_line_";
  protected final String TEXT_8 = "==0) {" + NL + "\t";
  protected final String TEXT_9 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_10 = " = conn_";
  protected final String TEXT_11 = ".createStatement();" + NL + "            stmtDrop_";
  protected final String TEXT_12 = ".execute(\"";
  protected final String TEXT_13 = "\");" + NL + "            stmtDrop_";
  protected final String TEXT_14 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_15 = " = conn_";
  protected final String TEXT_16 = ".createStatement();";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_18 = ".execute(\"";
  protected final String TEXT_19 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ", \"";
  protected final String TEXT_22 = "\")+\")";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = "\t\t\t\t" + NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_25 = ".execute(\"";
  protected final String TEXT_26 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ", \"";
  protected final String TEXT_29 = "\")+\")";
  protected final String TEXT_30 = "\");";
  protected final String TEXT_31 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_32 = ".execute(\"";
  protected final String TEXT_33 = ")\");";
  protected final String TEXT_34 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_35 = ".close();";
  protected final String TEXT_36 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_37 = " = conn_";
  protected final String TEXT_38 = ".createStatement();";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_40 = ".execute(\"";
  protected final String TEXT_41 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ", \"";
  protected final String TEXT_44 = "\")+\")";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_47 = ".execute(\"";
  protected final String TEXT_48 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ", \"";
  protected final String TEXT_51 = "\")+\")";
  protected final String TEXT_52 = "\");";
  protected final String TEXT_53 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_54 = ".execute(\"";
  protected final String TEXT_55 = ")\");";
  protected final String TEXT_56 = NL + "            stmtCreate_";
  protected final String TEXT_57 = ".close();";
  protected final String TEXT_58 = "\t         " + NL + "\t\t    // [%connection%][checktable][tableName]" + NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_59 = " = conn_";
  protected final String TEXT_60 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_61 = " + \"]\";" + NL + "\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_62 = ")== null){";
  protected final String TEXT_63 = "              ";
  protected final String TEXT_64 = NL + "\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_65 = " = conn_";
  protected final String TEXT_66 = ".createStatement();" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_67 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tisExistStmt_";
  protected final String TEXT_68 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_69 = " + \"]\" );" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_70 = " = true;" + NL + "\t\t\t\t} catch (Exception e){" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_71 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tisExistStmt_";
  protected final String TEXT_72 = ".close();";
  protected final String TEXT_73 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_75 = " = conn_";
  protected final String TEXT_76 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_77 = " = dbMetaData_";
  protected final String TEXT_78 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_79 = ", tableNameForSearch_";
  protected final String TEXT_80 = ", new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_81 = " = false;" + NL + "\t            if(rsTable_";
  protected final String TEXT_82 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_83 = " = true;" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_84 = ".close();" + NL + "\t            ";
  protected final String TEXT_85 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_86 = " = conn_";
  protected final String TEXT_87 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_88 = " = dbMetaData_";
  protected final String TEXT_89 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_90 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_91 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_92 = " = rsTable_";
  protected final String TEXT_93 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_94 = " = rsTable_";
  protected final String TEXT_95 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_96 = ".equalsIgnoreCase(";
  protected final String TEXT_97 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_98 = ".equalsIgnoreCase(dbschema_";
  protected final String TEXT_99 = ") || dbschema_";
  protected final String TEXT_100 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_101 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_102 = ".close();";
  protected final String TEXT_103 = "      " + NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_104 = " = conn_";
  protected final String TEXT_105 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_106 = " = dbMetaData_";
  protected final String TEXT_107 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_108 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_109 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_110 = " = rsTable_";
  protected final String TEXT_111 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_112 = ".equalsIgnoreCase(";
  protected final String TEXT_113 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_114 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_115 = ".close();";
  protected final String TEXT_116 = NL + "                if(!whetherExist_";
  protected final String TEXT_117 = ") {" + NL + "                    java.sql.Statement stmtCreate_";
  protected final String TEXT_118 = " = conn_";
  protected final String TEXT_119 = ".createStatement();";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_121 = ".execute(\"";
  protected final String TEXT_122 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ", \"";
  protected final String TEXT_125 = "\")+\")";
  protected final String TEXT_126 = "\");";
  protected final String TEXT_127 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_128 = ".execute(\"";
  protected final String TEXT_129 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ", \"";
  protected final String TEXT_132 = "\")+\")";
  protected final String TEXT_133 = "\");";
  protected final String TEXT_134 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_135 = ".execute(\"";
  protected final String TEXT_136 = ")\");";
  protected final String TEXT_137 = NL + "                    stmtCreate_";
  protected final String TEXT_138 = ".close();            " + NL + "                }                ";
  protected final String TEXT_139 = NL + "                if(whetherExist_";
  protected final String TEXT_140 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_141 = " = conn_";
  protected final String TEXT_142 = ".createStatement();" + NL + "                    stmtDrop_";
  protected final String TEXT_143 = ".execute(\"";
  protected final String TEXT_144 = "\");" + NL + "                    stmtDrop_";
  protected final String TEXT_145 = ".close();" + NL + "                }" + NL + "                java.sql.Statement stmtCreate_";
  protected final String TEXT_146 = " = conn_";
  protected final String TEXT_147 = ".createStatement();";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_149 = ".execute(\"";
  protected final String TEXT_150 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = ", \"";
  protected final String TEXT_153 = "\")+\")";
  protected final String TEXT_154 = "\");";
  protected final String TEXT_155 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_156 = ".execute(\"";
  protected final String TEXT_157 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ", \"";
  protected final String TEXT_160 = "\")+\")";
  protected final String TEXT_161 = "\");";
  protected final String TEXT_162 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_163 = ".execute(\"";
  protected final String TEXT_164 = ")\");";
  protected final String TEXT_165 = NL + "                stmtCreate_";
  protected final String TEXT_166 = ".close();";
  protected final String TEXT_167 = NL + "\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_168 = ", true);" + NL + "\t\t\t}";
  protected final String TEXT_169 = "            ";
  protected final String TEXT_170 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_171 = " = conn_";
  protected final String TEXT_172 = ".createStatement();" + NL + "            stmtClear_";
  protected final String TEXT_173 = ".executeUpdate(\"";
  protected final String TEXT_174 = "\");" + NL + "            stmtClear_";
  protected final String TEXT_175 = ".close();";
  protected final String TEXT_176 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_177 = " = conn_";
  protected final String TEXT_178 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_179 = " = stmtTruncCount_";
  protected final String TEXT_180 = ".executeQuery(\"";
  protected final String TEXT_181 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_182 = " = conn_";
  protected final String TEXT_183 = ".createStatement();" + NL + "            stmtTrunc_";
  protected final String TEXT_184 = ".executeUpdate(\"";
  protected final String TEXT_185 = "\");" + NL + "            while(rsTruncCount_";
  protected final String TEXT_186 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_187 = " += rsTruncCount_";
  protected final String TEXT_188 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_189 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_190 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_191 = ".close();            ";
  protected final String TEXT_192 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_193 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_194 = " + \" (";
  protected final String TEXT_195 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = ", \"";
  protected final String TEXT_198 = "\")+\") VALUES (";
  protected final String TEXT_199 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = ")+\")\";";
  protected final String TEXT_202 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_203 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_204 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = ", \"";
  protected final String TEXT_207 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = ")+\")\";";
  protected final String TEXT_210 = NL + "\t    pstmt_";
  protected final String TEXT_211 = " = conn_";
  protected final String TEXT_212 = ".prepareStatement(insert_";
  protected final String TEXT_213 = ", java.sql.Statement.RETURN_GENERATED_KEYS);" + NL + "\t    ";
  protected final String TEXT_214 = NL + "\t\t\t\tString update_";
  protected final String TEXT_215 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_216 = " + \" SET ";
  protected final String TEXT_217 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = ", \"";
  protected final String TEXT_220 = "\")+\" WHERE ";
  protected final String TEXT_221 = "\";";
  protected final String TEXT_222 = NL + "\t\t\t\tString update_";
  protected final String TEXT_223 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_224 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = ", \"";
  protected final String TEXT_227 = "\")+\" WHERE ";
  protected final String TEXT_228 = "\";";
  protected final String TEXT_229 = NL + "\t    pstmt_";
  protected final String TEXT_230 = " = conn_";
  protected final String TEXT_231 = ".prepareStatement(update_";
  protected final String TEXT_232 = ");" + NL + "\t    ";
  protected final String TEXT_233 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_234 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_235 = " + \" (";
  protected final String TEXT_236 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = ", \"";
  protected final String TEXT_239 = "\")+\") VALUES (";
  protected final String TEXT_240 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = ")+\")\";";
  protected final String TEXT_243 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_244 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_245 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = ", \"";
  protected final String TEXT_248 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = ")+\")\";";
  protected final String TEXT_251 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_252 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_253 = " + \" SET ";
  protected final String TEXT_254 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = ", \"";
  protected final String TEXT_257 = "\")+\" WHERE ";
  protected final String TEXT_258 = "\";";
  protected final String TEXT_259 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_260 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_261 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = ", \"";
  protected final String TEXT_264 = "\")+\" WHERE ";
  protected final String TEXT_265 = "\";";
  protected final String TEXT_266 = NL + "\t    pstmt_";
  protected final String TEXT_267 = " = conn_";
  protected final String TEXT_268 = ".prepareStatement(\"SELECT COUNT(1) FROM \" + ";
  protected final String TEXT_269 = " + \" WHERE ";
  protected final String TEXT_270 = "\");" + NL + "\t    pstmtInsert_";
  protected final String TEXT_271 = " = conn_";
  protected final String TEXT_272 = ".prepareStatement(insert_";
  protected final String TEXT_273 = ");" + NL + "\t    pstmtUpdate_";
  protected final String TEXT_274 = " = conn_";
  protected final String TEXT_275 = ".prepareStatement(update_";
  protected final String TEXT_276 = ");" + NL + "\t    ";
  protected final String TEXT_277 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_278 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_279 = " + \" (";
  protected final String TEXT_280 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_281 = ".";
  protected final String TEXT_282 = ", \"";
  protected final String TEXT_283 = "\")+\") VALUES (";
  protected final String TEXT_284 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_285 = ".";
  protected final String TEXT_286 = ")+\")\";";
  protected final String TEXT_287 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_288 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_289 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = ", \"";
  protected final String TEXT_292 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = ")+\")\";";
  protected final String TEXT_295 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_296 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_297 = " + \" SET ";
  protected final String TEXT_298 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_299 = ".";
  protected final String TEXT_300 = ", \"";
  protected final String TEXT_301 = "\")+\" WHERE ";
  protected final String TEXT_302 = "\";";
  protected final String TEXT_303 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_304 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_305 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = ", \"";
  protected final String TEXT_308 = "\")+\" WHERE ";
  protected final String TEXT_309 = "\";";
  protected final String TEXT_310 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_311 = " = conn_";
  protected final String TEXT_312 = ".prepareStatement(update_";
  protected final String TEXT_313 = ");" + NL + "\t    pstmtInsert_";
  protected final String TEXT_314 = " = conn_";
  protected final String TEXT_315 = ".prepareStatement(insert_";
  protected final String TEXT_316 = ");\t\t" + NL + "\t    ";
  protected final String TEXT_317 = NL + "\t    String delete_";
  protected final String TEXT_318 = " = \"DELETE FROM \" + ";
  protected final String TEXT_319 = " + \" WHERE ";
  protected final String TEXT_320 = "\";" + NL + "\t    pstmt_";
  protected final String TEXT_321 = " = conn_";
  protected final String TEXT_322 = ".prepareStatement(delete_";
  protected final String TEXT_323 = ");" + NL + "\t    ";
  protected final String TEXT_324 = NL + "        StringBuffer query_";
  protected final String TEXT_325 = " = null;" + NL + "       \t";
  protected final String TEXT_326 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_327 = " = insert_";
  protected final String TEXT_328 = ".split(\"\\\\?\");";
  protected final String TEXT_329 = NL + "\t\t\tupdate_";
  protected final String TEXT_330 = " += \" \";" + NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_331 = " = update_";
  protected final String TEXT_332 = ".split(\"\\\\?\");";
  protected final String TEXT_333 = NL + "\t\t\tupdate_";
  protected final String TEXT_334 = " += \" \";" + NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_335 = " = update_";
  protected final String TEXT_336 = ".split(\"\\\\?\");" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_337 = " = insert_";
  protected final String TEXT_338 = ".split(\"\\\\?\");";
  protected final String TEXT_339 = NL + "\t\t\tdelete_";
  protected final String TEXT_340 = " += \" \";" + NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_341 = " = delete_";
  protected final String TEXT_342 = ".split(\"\\\\?\");";
  protected final String TEXT_343 = NL + "\t\t\treplace_";
  protected final String TEXT_344 = " += \" \";" + NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_345 = " = replace_";
  protected final String TEXT_346 = ".split(\"\\\\?\");";
  protected final String TEXT_347 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_348 = " += \" \";" + NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_349 = " = insertIgnore_";
  protected final String TEXT_350 = ".split(\"\\\\?\");";
  protected final String TEXT_351 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_352 = " = insert_";
  protected final String TEXT_353 = ".split(\"\\\\?\");";
  protected final String TEXT_354 = NL + "\t}";
  protected final String TEXT_355 = NL + "\t\t\t\t\tcommitEvery_";
  protected final String TEXT_356 = " = buffersSize_";
  protected final String TEXT_357 = ";";
  protected final String TEXT_358 = NL + "        whetherReject_";
  protected final String TEXT_359 = " = false;";
  protected final String TEXT_360 = NL + "                    ";
  protected final String TEXT_361 = NL + "                        query_";
  protected final String TEXT_362 = " = ";
  protected final String TEXT_363 = ";";
  protected final String TEXT_364 = NL + "\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_365 = ".";
  protected final String TEXT_366 = ", pstmt_";
  protected final String TEXT_367 = ", ";
  protected final String TEXT_368 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_369 = NL + "                globalMap.put(\"";
  protected final String TEXT_370 = "_QUERY\", query_";
  protected final String TEXT_371 = ".toString().trim());";
  protected final String TEXT_372 = NL + "            try {" + NL + "                insertedCount_";
  protected final String TEXT_373 = " = insertedCount_";
  protected final String TEXT_374 = " + pstmt_";
  protected final String TEXT_375 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_376 = "++;" + NL + "            } catch(java.sql.SQLException e) {" + NL + "                whetherReject_";
  protected final String TEXT_377 = " = true;";
  protected final String TEXT_378 = NL + "                    throw(e);";
  protected final String TEXT_379 = NL + "                        ";
  protected final String TEXT_380 = " = new ";
  protected final String TEXT_381 = "Struct();";
  protected final String TEXT_382 = NL + "                            ";
  protected final String TEXT_383 = ".";
  protected final String TEXT_384 = " = ";
  protected final String TEXT_385 = ".";
  protected final String TEXT_386 = ";";
  protected final String TEXT_387 = NL + "                        ";
  protected final String TEXT_388 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_389 = ";";
  protected final String TEXT_390 = NL + "                         System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_391 = NL + "            }";
  protected final String TEXT_392 = NL + "                    ";
  protected final String TEXT_393 = NL + "                        query_";
  protected final String TEXT_394 = " = ";
  protected final String TEXT_395 = ";";
  protected final String TEXT_396 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_397 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_398 = ".";
  protected final String TEXT_399 = ", pstmt_";
  protected final String TEXT_400 = ", ";
  protected final String TEXT_401 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_402 = NL + "                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_403 = NL + "                    \t";
  protected final String TEXT_404 = NL + "                        query_";
  protected final String TEXT_405 = " = ";
  protected final String TEXT_406 = ";";
  protected final String TEXT_407 = "  " + NL + "                    ";
  protected final String TEXT_408 = NL + "                    ";
  protected final String TEXT_409 = NL + "                        query_";
  protected final String TEXT_410 = " = ";
  protected final String TEXT_411 = ";";
  protected final String TEXT_412 = NL + "                globalMap.put(\"";
  protected final String TEXT_413 = "_QUERY\", query_";
  protected final String TEXT_414 = ".toString().trim());";
  protected final String TEXT_415 = NL + "            try {" + NL + "                updatedCount_";
  protected final String TEXT_416 = " = updatedCount_";
  protected final String TEXT_417 = " + pstmt_";
  protected final String TEXT_418 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_419 = "++;" + NL + "            } catch(java.sql.SQLException e) {" + NL + "                whetherReject_";
  protected final String TEXT_420 = " = true;";
  protected final String TEXT_421 = NL + "                    throw(e);";
  protected final String TEXT_422 = NL + "                        ";
  protected final String TEXT_423 = " = new ";
  protected final String TEXT_424 = "Struct();";
  protected final String TEXT_425 = NL + "                            ";
  protected final String TEXT_426 = ".";
  protected final String TEXT_427 = " = ";
  protected final String TEXT_428 = ".";
  protected final String TEXT_429 = ";";
  protected final String TEXT_430 = NL + "                        ";
  protected final String TEXT_431 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_432 = ";";
  protected final String TEXT_433 = NL + "                         System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_434 = NL + "            }";
  protected final String TEXT_435 = NL + "\t\t\t\t\t";
  protected final String TEXT_436 = NL + "                    \t";
  protected final String TEXT_437 = NL + "                    ";
  protected final String TEXT_438 = NL + "    \t\tjava.sql.ResultSet rs_";
  protected final String TEXT_439 = " = pstmt_";
  protected final String TEXT_440 = ".executeQuery();" + NL + "    \t\tint checkCount_";
  protected final String TEXT_441 = " = -1;" + NL + "    \t\twhile(rs_";
  protected final String TEXT_442 = ".next()) {" + NL + "    \t\t\tcheckCount_";
  protected final String TEXT_443 = " = rs_";
  protected final String TEXT_444 = ".getInt(1);" + NL + "    \t\t}" + NL + "    \t\tif(checkCount_";
  protected final String TEXT_445 = " > 0) {" + NL + "    \t\t\t";
  protected final String TEXT_446 = NL + "                        ";
  protected final String TEXT_447 = NL + "                            query_";
  protected final String TEXT_448 = " = ";
  protected final String TEXT_449 = ";";
  protected final String TEXT_450 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_451 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_452 = ".";
  protected final String TEXT_453 = ", pstmtUpdate_";
  protected final String TEXT_454 = ", ";
  protected final String TEXT_455 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_456 = NL + "\t                    \t";
  protected final String TEXT_457 = NL + "\t                    ";
  protected final String TEXT_458 = NL + "\t                        query_";
  protected final String TEXT_459 = " = ";
  protected final String TEXT_460 = ";" + NL + "\t                        ";
  protected final String TEXT_461 = NL + "\t                    ";
  protected final String TEXT_462 = NL + "                        ";
  protected final String TEXT_463 = NL + "                            query_";
  protected final String TEXT_464 = " = ";
  protected final String TEXT_465 = ";";
  protected final String TEXT_466 = NL + "                    globalMap.put(\"";
  protected final String TEXT_467 = "_QUERY\", query_";
  protected final String TEXT_468 = ".toString().trim());";
  protected final String TEXT_469 = NL + "                try {" + NL + "        \t\t\tupdatedCount_";
  protected final String TEXT_470 = " = updatedCount_";
  protected final String TEXT_471 = " + pstmtUpdate_";
  protected final String TEXT_472 = ".executeUpdate();" + NL + "                } catch(java.sql.SQLException e) {" + NL + "                    whetherReject_";
  protected final String TEXT_473 = " = true;";
  protected final String TEXT_474 = NL + "                        throw(e);";
  protected final String TEXT_475 = NL + "                            ";
  protected final String TEXT_476 = " = new ";
  protected final String TEXT_477 = "Struct();";
  protected final String TEXT_478 = NL + "                                ";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = " = ";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = ";";
  protected final String TEXT_483 = NL + "                            ";
  protected final String TEXT_484 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "                             System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_487 = NL + "                }" + NL + "    \t\t} else {" + NL + "    \t\t\t";
  protected final String TEXT_488 = NL + "                        ";
  protected final String TEXT_489 = NL + "                            query_";
  protected final String TEXT_490 = " = ";
  protected final String TEXT_491 = ";";
  protected final String TEXT_492 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = ", pstmtInsert_";
  protected final String TEXT_495 = ", ";
  protected final String TEXT_496 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_497 = NL + "                    globalMap.put(\"";
  protected final String TEXT_498 = "_QUERY\", query_";
  protected final String TEXT_499 = ".toString().trim());";
  protected final String TEXT_500 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_501 = " = insertedCount_";
  protected final String TEXT_502 = " + pstmtInsert_";
  protected final String TEXT_503 = ".executeUpdate();" + NL + "                } catch(java.sql.SQLException e) {" + NL + "                    whetherReject_";
  protected final String TEXT_504 = " = true;";
  protected final String TEXT_505 = NL + "                        throw(e);";
  protected final String TEXT_506 = NL + "                            ";
  protected final String TEXT_507 = " = new ";
  protected final String TEXT_508 = "Struct();";
  protected final String TEXT_509 = NL + "                                ";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = " = ";
  protected final String TEXT_512 = ".";
  protected final String TEXT_513 = ";";
  protected final String TEXT_514 = NL + "                            ";
  protected final String TEXT_515 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_516 = ";";
  protected final String TEXT_517 = NL + "                             System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_518 = NL + "                }" + NL + "    \t\t}" + NL + "    \t\tnb_line_";
  protected final String TEXT_519 = "++;" + NL + "    " + NL + "    \t\t";
  protected final String TEXT_520 = NL + "    \t    int updateFlag_";
  protected final String TEXT_521 = "=0;" + NL + "    \t    ";
  protected final String TEXT_522 = NL + "                    ";
  protected final String TEXT_523 = NL + "                        query_";
  protected final String TEXT_524 = " = ";
  protected final String TEXT_525 = ";";
  protected final String TEXT_526 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_527 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_528 = ".";
  protected final String TEXT_529 = ", pstmtUpdate_";
  protected final String TEXT_530 = ", ";
  protected final String TEXT_531 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_532 = NL + "\t\t\t\t\t";
  protected final String TEXT_533 = NL + "                    \t";
  protected final String TEXT_534 = NL + "\t                        query_";
  protected final String TEXT_535 = " = ";
  protected final String TEXT_536 = ";" + NL + "\t                        ";
  protected final String TEXT_537 = NL + "                    ";
  protected final String TEXT_538 = NL + "                    ";
  protected final String TEXT_539 = NL + "                        query_";
  protected final String TEXT_540 = " = ";
  protected final String TEXT_541 = ";";
  protected final String TEXT_542 = NL + "                globalMap.put(\"";
  protected final String TEXT_543 = "_QUERY\", query_";
  protected final String TEXT_544 = ".toString().trim());";
  protected final String TEXT_545 = "\t" + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_546 = "=pstmtUpdate_";
  protected final String TEXT_547 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_548 = " = updatedCount_";
  protected final String TEXT_549 = "+updateFlag_";
  protected final String TEXT_550 = ";" + NL + "            } catch(java.sql.SQLException e) {" + NL + "                whetherReject_";
  protected final String TEXT_551 = " = true;";
  protected final String TEXT_552 = NL + "                    throw(e);";
  protected final String TEXT_553 = NL + "                        ";
  protected final String TEXT_554 = " = new ";
  protected final String TEXT_555 = "Struct();";
  protected final String TEXT_556 = NL + "                            ";
  protected final String TEXT_557 = ".";
  protected final String TEXT_558 = " = ";
  protected final String TEXT_559 = ".";
  protected final String TEXT_560 = ";";
  protected final String TEXT_561 = NL + "                        ";
  protected final String TEXT_562 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_563 = ";";
  protected final String TEXT_564 = NL + "                         System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_565 = NL + "            }" + NL + "            " + NL + "            if(updateFlag_";
  protected final String TEXT_566 = " == 0) {" + NL + "\t\t\t\t";
  protected final String TEXT_567 = NL + "\t\t\t\tquery_";
  protected final String TEXT_568 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_569 = NL + "                        ";
  protected final String TEXT_570 = NL + "                            query_";
  protected final String TEXT_571 = " = ";
  protected final String TEXT_572 = ";";
  protected final String TEXT_573 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_574 = ".";
  protected final String TEXT_575 = ", pstmtInsert_";
  protected final String TEXT_576 = ", ";
  protected final String TEXT_577 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_578 = NL + "                    globalMap.put(\"";
  protected final String TEXT_579 = "_QUERY\", query_";
  protected final String TEXT_580 = ".toString().trim());";
  protected final String TEXT_581 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_582 = " = insertedCount_";
  protected final String TEXT_583 = " + pstmtInsert_";
  protected final String TEXT_584 = ".executeUpdate();" + NL + "                } catch(java.sql.SQLException e) {" + NL + "                    whetherReject_";
  protected final String TEXT_585 = " = true;";
  protected final String TEXT_586 = NL + "                        throw(e);";
  protected final String TEXT_587 = NL + "                            ";
  protected final String TEXT_588 = " = new ";
  protected final String TEXT_589 = "Struct();";
  protected final String TEXT_590 = NL + "                                ";
  protected final String TEXT_591 = ".";
  protected final String TEXT_592 = " = ";
  protected final String TEXT_593 = ".";
  protected final String TEXT_594 = ";";
  protected final String TEXT_595 = NL + "                            ";
  protected final String TEXT_596 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_597 = ";";
  protected final String TEXT_598 = NL + "                             System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_599 = NL + "                }" + NL + "            } " + NL + "            nb_line_";
  protected final String TEXT_600 = "++;";
  protected final String TEXT_601 = NL + "\t\t\t\t\t";
  protected final String TEXT_602 = NL + "                    \t";
  protected final String TEXT_603 = NL + "\t                        query_";
  protected final String TEXT_604 = " = ";
  protected final String TEXT_605 = ";" + NL + "\t                        ";
  protected final String TEXT_606 = NL + "                    ";
  protected final String TEXT_607 = NL + "                    ";
  protected final String TEXT_608 = NL + "                        query_";
  protected final String TEXT_609 = " = ";
  protected final String TEXT_610 = ";";
  protected final String TEXT_611 = NL + "                globalMap.put(\"";
  protected final String TEXT_612 = "_QUERY\", query_";
  protected final String TEXT_613 = ".toString().trim());";
  protected final String TEXT_614 = NL + "            try {" + NL + "                deletedCount_";
  protected final String TEXT_615 = " = deletedCount_";
  protected final String TEXT_616 = " + pstmt_";
  protected final String TEXT_617 = ".executeUpdate();" + NL + "            } catch(java.sql.SQLException e) {" + NL + "                whetherReject_";
  protected final String TEXT_618 = " = true;";
  protected final String TEXT_619 = NL + "                    throw(e);";
  protected final String TEXT_620 = NL + "                        ";
  protected final String TEXT_621 = " = new ";
  protected final String TEXT_622 = "Struct();";
  protected final String TEXT_623 = NL + "                            ";
  protected final String TEXT_624 = ".";
  protected final String TEXT_625 = " = ";
  protected final String TEXT_626 = ".";
  protected final String TEXT_627 = ";";
  protected final String TEXT_628 = NL + "                        ";
  protected final String TEXT_629 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_630 = ";";
  protected final String TEXT_631 = NL + "                         System.err.println(e.getMessage() + \" SQLSTATE=[\" + e.getSQLState() + \"] \" + \"CODE[\" + e.getErrorCode() + \"]\");";
  protected final String TEXT_632 = NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_633 = "++;" + NL + "    \t";
  protected final String TEXT_634 = NL + "            if(!whetherReject_";
  protected final String TEXT_635 = ") {";
  protected final String TEXT_636 = NL + "                            ";
  protected final String TEXT_637 = " = new ";
  protected final String TEXT_638 = "Struct();";
  protected final String TEXT_639 = NL + "                                ";
  protected final String TEXT_640 = ".";
  protected final String TEXT_641 = " = ";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = ";";
  protected final String TEXT_644 = NL + "            }";
  protected final String TEXT_645 = NL + "                    commitCounter_";
  protected final String TEXT_646 = "++;                " + NL + "                    if(commitEvery_";
  protected final String TEXT_647 = " <= commitCounter_";
  protected final String TEXT_648 = ") {                " + NL + "                        conn_";
  protected final String TEXT_649 = ".commit();                \t" + NL + "                        commitCounter_";
  protected final String TEXT_650 = "=0;                " + NL + "                    }\t";
  protected final String TEXT_651 = NL;

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
    public static final String HSQLDB = "hsqldb_id";
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
    public static final String POSTGRESQL = "postgres_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
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
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
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
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
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
            //createSQL.append(")");
            
            // add VectorWise option
            //if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            //	createSQL.append("WITH STRUCTURE = VECTORWISE");
            //}
            
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
            return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
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

        public List<Column> createColumnList(List<IMetadataColumn> columnList, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();
            for(IMetadataColumn column : columnList) {
                Column skeletonColumn = getColumn(column);
                skeletonColumn.setOperator("=");
                stmtStructure.add(skeletonColumn);
            }
            for(IMetadataColumn column : columnList) {
                if(addCols != null && addCols.size() > 0) {
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
                                replacedCol.replace(replacementCol);
                            }
                        }                        
                    }
                }
            }
            return stmtStructure;
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
				if(!("id_Dynamic".equals(column.getTalendType()))) {
					Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
					skeletonColumn.setOperator("=");
					skeletonColumn.setDataType(column.getType());
					stmtStructure.add(skeletonColumn);
				}
            }
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
                            }                            
                        }
                    }
                }
            }
            return stmtStructure;
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
            if(column.isInsertable()) {
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
            if(column.isUpdatable()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey()) {
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
            if(column.isUpdateKey()) {
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
            		if (index == 1) {
            			return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		} else {
            			return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		}
            }else {
            	if (index == 1) {
            		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	} else {
            		return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	}
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
        	if (index == 1) {
        		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
        	} else {
        		return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+index+"])";
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

            System.out.println(column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable());
            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
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
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
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
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
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
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
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
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
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
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
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
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
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
         	//createSQL.append(")");
            
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
				+ "char(0)");
			
				// add these only if not last entry
				if (counter < columnList.size()){
					copyBulkSQL.append(
					//convertDelim(fieldDelimiter)
					fieldDelimiter
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
        
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + index + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
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
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
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
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
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
            //createSQL.append(")");
            
            // add VectorWise option
            //if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            //  createSQL.append("WITH STRUCTURE = VECTORWISE");
            //}
            
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
        protected boolean contaionsSpaces(String columnName) {
        	if (columnName != null) {
        	    //bug0016837 when use Additional column the coulmn name like: " + "columnNmae" + "
        	    if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
        	        return false;
        	    }
        	    
        		if (columnName.contains(" ")) {
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
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
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
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
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
                if(dbType != null && dbType.equals("BLOB")) {
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
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
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
                if ("Date".equalsIgnoreCase(dbType) && !ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__").equals("true")) {
                    setStmt.append(prefix + cid + ".setDate(" + index + ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("XMLTYPE"))) {
                setStmt.append("if (" + incomingConnName + "." + column.getName() + " instanceof String) {\r\n");
                setStmt.append(prefix + cid + ".setObject(" + index + ",  xmlTypeUtil_" + cid + ".getCLOB((String)" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                setStmt.append("}\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\""; 
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
			if("char".equals(dataType.toLowerCase()))
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
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
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
                        if (count == columnList.size() - 1 && pkList.size() == 0) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            if (pkList.size() > 0) {
                createSQL.append("primary key(");
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
            //createSQL.append(")");
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
            }
        }
        return columnList;
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
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
    
    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");	
	
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
    
	//feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = getColumnList(node);
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
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
	
	List<Column> stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
	
	Manager manager = null;
	boolean isDynamic = false;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		isDynamic = metadata.isDynamicSchema(); 
	}
	
    ////////////////////////////////////////////////////////////
    List<Column> colStruct = new ArrayList();
    for(Column colStmt : stmtStructure) {
    	if(!colStmt.isReplaced() && !colStmt.isAddCol()) {
    		colStruct.add(colStmt);
    	}
    }
	if(isEnableDebug) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
	}
	
	if(isDynamic) {
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	
	if(columnList != null && columnList.size() > 0) {    
   
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);
	String ending="";
	
	if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
		ending="WITH STRUCTURE = VECTORWISE";
	}

	if(!("NONE").equals(tableAction)) {

        if(("DROP_CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_23);
    
					} else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_30);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_33);
    
			}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    				

        } else if(("CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_45);
    
					} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_52);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_55);
    
			}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}

    stringBuffer.append(TEXT_63);
     
			/*
				case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
				so in mssql use "Select" checked the table whether exist.
			*/
			//TODO we will use like "select" sql intead of use system table to checked table?
			if(MSSQL.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
			} else if (ORACLE.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
			} else if ( SYBASE.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId)
						|| INFORMIX.equalsIgnoreCase(dbmsId) || DB2.equalsIgnoreCase(dbmsId) ) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    			
			} else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			}

    
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_126);
    
					} else {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_133);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_136);
    
			}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
            } else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_154);
    
					} else {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_161);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_164);
    
			}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
			}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    
			}

    stringBuffer.append(TEXT_169);
    
        } else if(("CLEAR").equals(tableAction)) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
        }else if(("TRUNCATE").equals(tableAction)) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(manager.getTruncateTableSQL());
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
    
		}         
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);   
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);    
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);    
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);

	if(("INSERT").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);
				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_201);
    				} else {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_209);
    
				}
			}
	    
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
	} else if (("UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);
			if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_221);
    			} else {

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_228);
    
			}
		}
	    
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    		
	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);
				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_242);
    				} else {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_250);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_258);
    				} else {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_265);
    
				}
			}
	    
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);
				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_286);
    				} else {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_294);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_302);
    				} else {

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_306);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_309);
    
				}
			}
			
	    
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    			
	} else if (("DELETE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    		
	}
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
		}

    
    }    
}

    stringBuffer.append(TEXT_354);
    
} //end isDynamic
	
	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	String useCommitControl = ElementParameterParser.getValue(node,"__USE_COMMIT_CONTROL__");
	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!useExistingConnection) {
			if(("true").equals(useCommitControl)) {// if use commit control
	    		if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_357);
    
	    		}
	    	}
    	}
    
	}
	
    if(incomingConnName != null && columnList != null) {
        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    	
        if(("INSERT").equals(dataAction)) {
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_360);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_363);
    
                    }                    
                    counter++;                        
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_364);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_368);
    
				}
			}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
            }            
    		
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_378);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_379);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_381);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_382);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_384);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_386);
    
                        }
                        
    stringBuffer.append(TEXT_387);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_389);
    
                    } else {
                        
    stringBuffer.append(TEXT_390);
    
                    }
                } 
                
    stringBuffer.append(TEXT_391);
    
    	} else if(("UPDATE").equals(dataAction)) {
    	    int counterCol = 1;
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_392);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_395);
    
                    }                    
                    counterCol++;                   
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_401);
    
				}
			}
    
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_402);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
      
					if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_406);
    
                    }
                    	counterCol++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_407);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_411);
    
                    }                    
                    counterCol++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    
            }            
    		
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_421);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_422);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_424);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_425);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_429);
    
                        }
                        
    stringBuffer.append(TEXT_430);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_432);
    
                    } else {
                        
    stringBuffer.append(TEXT_433);
    
                    }
                } 
                
    stringBuffer.append(TEXT_434);
    
    	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
    		int columnIndex = 1;
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_435);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_436);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
      
                    	columnIndex++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_437);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                    columnIndex++;
                }
            }
    		
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
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
    
    			int counterCol = 1;
                for(Column column : colStruct) {
                    if(column.isUpdatable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_446);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_449);
    
                        }                        
                        counterCol++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_455);
    
					}
				}
                for(Column column : colStruct) {
                    if(column.isUpdateKey()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
                        
     
	                    //#############for feature:2880
	                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_456);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_457);
      
		                     if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_460);
    
	                    	} 
	                    	counterCol++;
	                       }
	                     //#############                      
	                    
    stringBuffer.append(TEXT_461);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_465);
    
                        }                        
                        counterCol++;                   
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    
                }                
    			
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_474);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_475);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_477);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_478);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_482);
    
                            }
                            
    stringBuffer.append(TEXT_483);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_485);
    
                        } else {
                            
    stringBuffer.append(TEXT_486);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_487);
    
    			int counterInsert = 1;
                for(Column columnInsert : colStruct) {
                    if(columnInsert.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_488);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_491);
    
                        }                        
                        counterInsert++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_492);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_496);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    
                }                
    			
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_505);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_506);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_508);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_509);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_513);
    
                            }
                            
    stringBuffer.append(TEXT_514);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_516);
    
                        } else {
                            
    stringBuffer.append(TEXT_517);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    
    	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
    		int counterColUpdate = 1;
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_522);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_525);
    
                    }                    
                    counterColUpdate++;
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_531);
    
				}
			}
    
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    String dbType = columnUpdate.getColumn().getType();
                    
    stringBuffer.append(TEXT_532);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && columnUpdate.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_533);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_536);
    
	                    	}
                    	counterColUpdate++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_541);
    
                    }                    
                    counterColUpdate++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    
            }            
    		
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_552);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_553);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_555);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_556);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_560);
    
                        }
                        
    stringBuffer.append(TEXT_561);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_563);
    
                    } else {
                        
    stringBuffer.append(TEXT_564);
    
                    }
                } 
                
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
        		}
        		int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_569);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_572);
    
                        }                        
                        counter++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_573);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_577);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    
                }                
        		
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_586);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_587);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_589);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_590);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_594);
    
                            }
                            
    stringBuffer.append(TEXT_595);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_597);
    
                        } else {
                            
    stringBuffer.append(TEXT_598);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
        	
    	} else if (("DELETE").equals(dataAction)) {
    	    int keyCounter = 1;
            for(Column column : colStruct) {
                if(column.isDeleteKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_601);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_602);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_605);
    
	                    	}
                    	 keyCounter++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_606);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_610);
    
                    }                    
                    keyCounter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    
            }            
    		
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_619);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_620);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_622);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_623);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_625);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_627);
    
                        }
                        
    stringBuffer.append(TEXT_628);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_630);
    
                    } else {
                        
    stringBuffer.append(TEXT_631);
    
                    }
                } 
                
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    
    	}
   	
        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {                            
                            
    stringBuffer.append(TEXT_636);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_637);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_638);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_639);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_640);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_643);
                      
                            }
                        }
                    }
                }
                
    stringBuffer.append(TEXT_644);
    
        }	
        if(!useExistingConnection) {
            if(("true").equals(useCommitControl)) {
                if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
                    
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    
                }
            }
        }
    }
    
    stringBuffer.append(TEXT_651);
    return stringBuffer.toString();
  }
}
