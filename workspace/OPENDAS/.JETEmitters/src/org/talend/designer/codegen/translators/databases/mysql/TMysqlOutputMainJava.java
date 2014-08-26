package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IProcess;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TMysqlOutputMainJava {
  protected static String nl;
  public static synchronized TMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputMainJava result = new TMysqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        ";
  protected final String TEXT_3 = NL + "            ";
  protected final String TEXT_4 = " = null;            ";
  protected final String TEXT_5 = NL + "\t\tif(nb_line_";
  protected final String TEXT_6 = "==0) {" + NL + "\t";
  protected final String TEXT_7 = NL + "    \t";
  protected final String TEXT_8 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_9 = " = conn_";
  protected final String TEXT_10 = ".createStatement();" + NL + "            stmtDrop_";
  protected final String TEXT_11 = ".execute(\"";
  protected final String TEXT_12 = "\");" + NL + "            stmtDrop_";
  protected final String TEXT_13 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_14 = " = conn_";
  protected final String TEXT_15 = ".createStatement();";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_17 = ".execute(\"";
  protected final String TEXT_18 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ", \"";
  protected final String TEXT_21 = "\")+\")";
  protected final String TEXT_22 = "\");";
  protected final String TEXT_23 = "\t\t\t\t" + NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_24 = ".execute(\"";
  protected final String TEXT_25 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ", \"";
  protected final String TEXT_28 = "\")+\")";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_31 = ".execute(\"";
  protected final String TEXT_32 = ")\");";
  protected final String TEXT_33 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_34 = ".close();";
  protected final String TEXT_35 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_36 = " = conn_";
  protected final String TEXT_37 = ".createStatement();";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_39 = ".execute(\"";
  protected final String TEXT_40 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ", \"";
  protected final String TEXT_43 = "\")+\")";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_46 = ".execute(\"";
  protected final String TEXT_47 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ", \"";
  protected final String TEXT_50 = "\")+\")";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_53 = ".execute(\"";
  protected final String TEXT_54 = ")\");";
  protected final String TEXT_55 = NL + "            stmtCreate_";
  protected final String TEXT_56 = ".close();";
  protected final String TEXT_57 = "\t         " + NL + "\t\t    // [%connection%][checktable][tableName]" + NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_58 = " = conn_";
  protected final String TEXT_59 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_60 = " + \"]\";" + NL + "\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_61 = ")== null){";
  protected final String TEXT_62 = "              ";
  protected final String TEXT_63 = NL + "\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_64 = " = conn_";
  protected final String TEXT_65 = ".createStatement();" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_66 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tisExistStmt_";
  protected final String TEXT_67 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_68 = " + \"]\" );" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_69 = " = true;" + NL + "\t\t\t\t} catch (Exception e){" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_70 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tisExistStmt_";
  protected final String TEXT_71 = ".close();";
  protected final String TEXT_72 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_74 = " = conn_";
  protected final String TEXT_75 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_76 = " = dbMetaData_";
  protected final String TEXT_77 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_78 = ", tableNameForSearch_";
  protected final String TEXT_79 = ", new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_80 = " = false;" + NL + "\t            if(rsTable_";
  protected final String TEXT_81 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_82 = " = true;" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_83 = ".close();" + NL + "\t            ";
  protected final String TEXT_84 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_85 = " = conn_";
  protected final String TEXT_86 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_87 = " = dbMetaData_";
  protected final String TEXT_88 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_89 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_90 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_91 = " = rsTable_";
  protected final String TEXT_92 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_93 = " = rsTable_";
  protected final String TEXT_94 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_95 = ".equalsIgnoreCase(";
  protected final String TEXT_96 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_97 = ".equalsIgnoreCase(dbschema_";
  protected final String TEXT_98 = ") || dbschema_";
  protected final String TEXT_99 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_100 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_101 = ".close();";
  protected final String TEXT_102 = "      " + NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_103 = " = conn_";
  protected final String TEXT_104 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_105 = " = dbMetaData_";
  protected final String TEXT_106 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_107 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_108 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_109 = " = rsTable_";
  protected final String TEXT_110 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_111 = ".equalsIgnoreCase(";
  protected final String TEXT_112 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_113 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_114 = ".close();";
  protected final String TEXT_115 = NL + "                if(!whetherExist_";
  protected final String TEXT_116 = ") {" + NL + "                    java.sql.Statement stmtCreate_";
  protected final String TEXT_117 = " = conn_";
  protected final String TEXT_118 = ".createStatement();";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_120 = ".execute(\"";
  protected final String TEXT_121 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ", \"";
  protected final String TEXT_124 = "\")+\")";
  protected final String TEXT_125 = "\");";
  protected final String TEXT_126 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_127 = ".execute(\"";
  protected final String TEXT_128 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = ", \"";
  protected final String TEXT_131 = "\")+\")";
  protected final String TEXT_132 = "\");";
  protected final String TEXT_133 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_134 = ".execute(\"";
  protected final String TEXT_135 = ")\");";
  protected final String TEXT_136 = NL + "                    stmtCreate_";
  protected final String TEXT_137 = ".close();            " + NL + "                }                ";
  protected final String TEXT_138 = NL + "                if(whetherExist_";
  protected final String TEXT_139 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_140 = " = conn_";
  protected final String TEXT_141 = ".createStatement();" + NL + "                    stmtDrop_";
  protected final String TEXT_142 = ".execute(\"";
  protected final String TEXT_143 = "\");" + NL + "                    stmtDrop_";
  protected final String TEXT_144 = ".close();" + NL + "                }" + NL + "                java.sql.Statement stmtCreate_";
  protected final String TEXT_145 = " = conn_";
  protected final String TEXT_146 = ".createStatement();";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_148 = ".execute(\"";
  protected final String TEXT_149 = "\"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ", \"";
  protected final String TEXT_152 = "\")+\")";
  protected final String TEXT_153 = "\");";
  protected final String TEXT_154 = "\t\t\t\t" + NL + "\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_155 = ".execute(\"";
  protected final String TEXT_156 = ", \"+DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = ", \"";
  protected final String TEXT_159 = "\")+\")";
  protected final String TEXT_160 = "\");";
  protected final String TEXT_161 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_162 = ".execute(\"";
  protected final String TEXT_163 = ")\");";
  protected final String TEXT_164 = NL + "                stmtCreate_";
  protected final String TEXT_165 = ".close();";
  protected final String TEXT_166 = NL + "\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_167 = ", true);" + NL + "\t\t\t}";
  protected final String TEXT_168 = "            ";
  protected final String TEXT_169 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_170 = " = conn_";
  protected final String TEXT_171 = ".createStatement();" + NL + "            stmtClear_";
  protected final String TEXT_172 = ".executeUpdate(\"";
  protected final String TEXT_173 = "\");" + NL + "            stmtClear_";
  protected final String TEXT_174 = ".close();";
  protected final String TEXT_175 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_176 = " = conn_";
  protected final String TEXT_177 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_178 = " = stmtTruncCount_";
  protected final String TEXT_179 = ".executeQuery(\"";
  protected final String TEXT_180 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_181 = " = conn_";
  protected final String TEXT_182 = ".createStatement();" + NL + "            stmtTrunc_";
  protected final String TEXT_183 = ".executeUpdate(\"";
  protected final String TEXT_184 = "\");" + NL + "            while(rsTruncCount_";
  protected final String TEXT_185 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_186 = " += rsTruncCount_";
  protected final String TEXT_187 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_188 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_189 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_190 = ".close();            ";
  protected final String TEXT_191 = NL + "\t\t\tStringBuffer duplidateClause_";
  protected final String TEXT_192 = " = new StringBuffer(\" ON DUPLICATE KEY UPDATE \");\t" + NL + "\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_194 = ".append(\",\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_195 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_196 = ".append (\"`\" +  ";
  protected final String TEXT_197 = " + \"`\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_198 = ".append (\"=\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_199 = ".append (";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t       ";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_203 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_204 = " + \"` (";
  protected final String TEXT_205 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = ", \"";
  protected final String TEXT_208 = "\")+\") VALUES (";
  protected final String TEXT_209 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ")+\")\";";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_213 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_214 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = ", \"";
  protected final String TEXT_217 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = ")+\")\";";
  protected final String TEXT_220 = "            " + NL + "\t\t\t\tinsert_";
  protected final String TEXT_221 = " += \tduplidateClause_";
  protected final String TEXT_222 = ".toString();";
  protected final String TEXT_223 = NL + "\t\t\t\t";
  protected final String TEXT_224 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_225 = " = new StringBuffer(insert_";
  protected final String TEXT_226 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_227 = ".insert(insert_";
  protected final String TEXT_228 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_229 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_230 = " =insertStringBuffer_";
  protected final String TEXT_231 = ".toString(); ";
  protected final String TEXT_232 = "    " + NL;
  protected final String TEXT_233 = NL + "                        pstmt_";
  protected final String TEXT_234 = " = conn_";
  protected final String TEXT_235 = ".prepareStatement(insert_";
  protected final String TEXT_236 = ");";
  protected final String TEXT_237 = NL + "                        ";
  protected final String TEXT_238 = NL + "                \t\tpstmt_";
  protected final String TEXT_239 = " = null;         " + NL + "                        // [%connection%][psmt][tableName]" + NL + "                        String keyPsmt_";
  protected final String TEXT_240 = " = conn_";
  protected final String TEXT_241 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_242 = " + \"]\";" + NL + "                \t\tif(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_243 = ")== null){" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_244 = " = conn_";
  protected final String TEXT_245 = ".prepareStatement(insert_";
  protected final String TEXT_246 = ");\t\t" + NL + "                \t\t\tGlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_247 = ", pstmt_";
  protected final String TEXT_248 = ");" + NL + "                \t\t}else{" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_249 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_250 = ");\t\t\t\t" + NL + "                \t\t}";
  protected final String TEXT_251 = NL + "\t        \t        ";
  protected final String TEXT_252 = "\t            " + NL + "\t            ////////////////////////////////////////////////////////////////////////////////////////////" + NL + "\t            " + NL + "\t            " + NL + "\t            StringBuilder extendInsertValueStmt_";
  protected final String TEXT_253 = " = new StringBuilder();" + NL + "                for(int i=0;i < ";
  protected final String TEXT_254 = ";i++){";
  protected final String TEXT_255 = NL + "                    extendInsertValueStmt_";
  protected final String TEXT_256 = ".append(\"(";
  protected final String TEXT_257 = ",\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = ")+\")\");";
  protected final String TEXT_260 = NL + "\t\t\t\t    extendInsertValueStmt_";
  protected final String TEXT_261 = ".append(\"(";
  protected final String TEXT_262 = ")\");";
  protected final String TEXT_263 = NL + "                if (i!=";
  protected final String TEXT_264 = "-1) extendInsertValueStmt_";
  protected final String TEXT_265 = ".append(\",\");" + NL + "                }";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_267 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_268 = " + \"` (";
  protected final String TEXT_269 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = ", \"";
  protected final String TEXT_272 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_273 = ".toString();";
  protected final String TEXT_274 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_275 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_276 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = ", \"";
  protected final String TEXT_279 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_280 = ".toString();";
  protected final String TEXT_281 = "            " + NL + "\t\t\t\t    insert_";
  protected final String TEXT_282 = " += \tduplidateClause_";
  protected final String TEXT_283 = ".toString();";
  protected final String TEXT_284 = NL + "\t\t\t\t\t";
  protected final String TEXT_285 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_286 = " = new StringBuffer(insert_";
  protected final String TEXT_287 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_288 = ".insert(insert_";
  protected final String TEXT_289 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_290 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_291 = " =insertStringBuffer_";
  protected final String TEXT_292 = ".toString(); ";
  protected final String TEXT_293 = "    " + NL + "\t\t\t\t    pstmt_";
  protected final String TEXT_294 = " =  conn_";
  protected final String TEXT_295 = ".prepareStatement(insert_";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "\t\t    " + NL + "\t\t\t\t    insertColName";
  protected final String TEXT_298 = " = \"";
  protected final String TEXT_299 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = ", \"";
  protected final String TEXT_302 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_303 = " =  \"";
  protected final String TEXT_304 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_305 = ".";
  protected final String TEXT_306 = "); ";
  protected final String TEXT_307 = NL + "\t      \t\t\tinsertColName";
  protected final String TEXT_308 = " = DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_309 = ".";
  protected final String TEXT_310 = ", \"";
  protected final String TEXT_311 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_312 = " =  DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = "); ";
  protected final String TEXT_315 = NL + "\t\t\t    rowCount";
  protected final String TEXT_316 = " = 0;";
  protected final String TEXT_317 = NL + "\t            int rowCount";
  protected final String TEXT_318 = " = 0;\t ";
  protected final String TEXT_319 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_320 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_321 = " + \"` (";
  protected final String TEXT_322 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = ", \"";
  protected final String TEXT_325 = "\")+\") VALUES (";
  protected final String TEXT_326 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = ")+\")\";";
  protected final String TEXT_329 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_330 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_331 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_332 = ".";
  protected final String TEXT_333 = ", \"";
  protected final String TEXT_334 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_335 = ".";
  protected final String TEXT_336 = ")+\")\";";
  protected final String TEXT_337 = "            " + NL + "\t\t\t\t\t    insert_";
  protected final String TEXT_338 = " += \tduplidateClause_";
  protected final String TEXT_339 = ".toString();";
  protected final String TEXT_340 = NL + "\t\t\t\t\t    batchSize_";
  protected final String TEXT_341 = " = ";
  protected final String TEXT_342 = ";" + NL + "\t\t   \t\t\t    batchSizeCounter_";
  protected final String TEXT_343 = "=0;";
  protected final String TEXT_344 = NL + "\t\t\t\t\t    int batchSize_";
  protected final String TEXT_345 = " = ";
  protected final String TEXT_346 = ";" + NL + "\t\t   \t\t\t    int batchSizeCounter_";
  protected final String TEXT_347 = "=0;";
  protected final String TEXT_348 = NL + "\t\t        ";
  protected final String TEXT_349 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_350 = " = new StringBuffer(insert_";
  protected final String TEXT_351 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_352 = ".insert(insert_";
  protected final String TEXT_353 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_354 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_355 = " =insertStringBuffer_";
  protected final String TEXT_356 = ".toString(); ";
  protected final String TEXT_357 = "    " + NL + "\t\t        pstmt_";
  protected final String TEXT_358 = " = conn_";
  protected final String TEXT_359 = ".prepareStatement(insert_";
  protected final String TEXT_360 = ");" + NL + "\t\t        " + NL + "\t\t\t\t";
  protected final String TEXT_361 = NL + "\t\t\t\tString update_";
  protected final String TEXT_362 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_363 = " + \"` SET ";
  protected final String TEXT_364 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_365 = ".";
  protected final String TEXT_366 = ", \"";
  protected final String TEXT_367 = "\")+\" WHERE ";
  protected final String TEXT_368 = "\";";
  protected final String TEXT_369 = NL + "\t\t\t\tString update_";
  protected final String TEXT_370 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_371 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_372 = ".";
  protected final String TEXT_373 = ", \"";
  protected final String TEXT_374 = "\")+\" WHERE ";
  protected final String TEXT_375 = "\";";
  protected final String TEXT_376 = NL + "\t    ";
  protected final String TEXT_377 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_378 = " = new StringBuffer(update_";
  protected final String TEXT_379 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_380 = ".insert(update_";
  protected final String TEXT_381 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_382 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_383 = " =updateStringBuffer_";
  protected final String TEXT_384 = ".toString(); ";
  protected final String TEXT_385 = NL + "\t    pstmt_";
  protected final String TEXT_386 = " = conn_";
  protected final String TEXT_387 = ".prepareStatement(update_";
  protected final String TEXT_388 = ");" + NL + "\t    ";
  protected final String TEXT_389 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_390 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_391 = " + \"` (";
  protected final String TEXT_392 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_393 = ".";
  protected final String TEXT_394 = ", \"";
  protected final String TEXT_395 = "\")+\") VALUES (";
  protected final String TEXT_396 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_397 = ".";
  protected final String TEXT_398 = ")+\")\";";
  protected final String TEXT_399 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_400 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_401 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_402 = ".";
  protected final String TEXT_403 = ", \"";
  protected final String TEXT_404 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_405 = ".";
  protected final String TEXT_406 = ")+\")\";";
  protected final String TEXT_407 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_408 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_409 = " + \"` SET ";
  protected final String TEXT_410 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_411 = ".";
  protected final String TEXT_412 = ", \"";
  protected final String TEXT_413 = "\")+\" WHERE ";
  protected final String TEXT_414 = "\";";
  protected final String TEXT_415 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_416 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_417 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_418 = ".";
  protected final String TEXT_419 = ", \"";
  protected final String TEXT_420 = "\")+\" WHERE ";
  protected final String TEXT_421 = "\";";
  protected final String TEXT_422 = NL + "\t    pstmt_";
  protected final String TEXT_423 = " = conn_";
  protected final String TEXT_424 = ".prepareStatement(\"SELECT COUNT(1) FROM `\" + ";
  protected final String TEXT_425 = " + \"` WHERE ";
  protected final String TEXT_426 = "\");//String insert_";
  protected final String TEXT_427 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_428 = " + \"` (";
  protected final String TEXT_429 = ") VALUES (";
  protected final String TEXT_430 = ")\";" + NL + "\t    ";
  protected final String TEXT_431 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_432 = " = new StringBuffer(insert_";
  protected final String TEXT_433 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_434 = ".insert(insert_";
  protected final String TEXT_435 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_436 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_437 = " =insertStringBuffer_";
  protected final String TEXT_438 = ".toString(); ";
  protected final String TEXT_439 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_440 = " = conn_";
  protected final String TEXT_441 = ".prepareStatement(insert_";
  protected final String TEXT_442 = ");" + NL + "\t    ";
  protected final String TEXT_443 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_444 = " = new StringBuffer(update_";
  protected final String TEXT_445 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_446 = ".insert(update_";
  protected final String TEXT_447 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_448 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_449 = " =updateStringBuffer_";
  protected final String TEXT_450 = ".toString(); ";
  protected final String TEXT_451 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_452 = " = conn_";
  protected final String TEXT_453 = ".prepareStatement(update_";
  protected final String TEXT_454 = ");\t\t" + NL + "\t    ";
  protected final String TEXT_455 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_456 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_457 = " + \"` (";
  protected final String TEXT_458 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = ", \"";
  protected final String TEXT_461 = "\")+\") VALUES (";
  protected final String TEXT_462 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_463 = ".";
  protected final String TEXT_464 = ")+\")\";";
  protected final String TEXT_465 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_466 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_467 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_468 = ".";
  protected final String TEXT_469 = ", \"";
  protected final String TEXT_470 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = ")+\")\";";
  protected final String TEXT_473 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_474 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_475 = " + \"` SET ";
  protected final String TEXT_476 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_477 = ".";
  protected final String TEXT_478 = ", \"";
  protected final String TEXT_479 = "\")+\" WHERE ";
  protected final String TEXT_480 = "\";";
  protected final String TEXT_481 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_482 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_483 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_484 = ".";
  protected final String TEXT_485 = ", \"";
  protected final String TEXT_486 = "\")+\" WHERE ";
  protected final String TEXT_487 = "\";";
  protected final String TEXT_488 = NL + "\t    ";
  protected final String TEXT_489 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_490 = " = new StringBuffer(update_";
  protected final String TEXT_491 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_492 = ".insert(update_";
  protected final String TEXT_493 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_494 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_495 = " =updateStringBuffer_";
  protected final String TEXT_496 = ".toString(); ";
  protected final String TEXT_497 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_498 = " = conn_";
  protected final String TEXT_499 = ".prepareStatement(update_";
  protected final String TEXT_500 = ");" + NL + "\t    ";
  protected final String TEXT_501 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_502 = " = new StringBuffer(insert_";
  protected final String TEXT_503 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_504 = ".insert(insert_";
  protected final String TEXT_505 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_506 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_507 = " =insertStringBuffer_";
  protected final String TEXT_508 = ".toString(); ";
  protected final String TEXT_509 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_510 = " = conn_";
  protected final String TEXT_511 = ".prepareStatement(insert_";
  protected final String TEXT_512 = ");\t\t\t\t" + NL + "\t    ";
  protected final String TEXT_513 = NL + "\t    String delete_";
  protected final String TEXT_514 = " = \"DELETE  FROM `\" + ";
  protected final String TEXT_515 = " + \"` WHERE ";
  protected final String TEXT_516 = "\";" + NL + "\t    ";
  protected final String TEXT_517 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_518 = " = new StringBuffer(delete_";
  protected final String TEXT_519 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_520 = ".insert(delete_";
  protected final String TEXT_521 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_522 = "  + \" \" );" + NL + "    delete_";
  protected final String TEXT_523 = " =deleteStringBuffer_";
  protected final String TEXT_524 = ".toString();  ";
  protected final String TEXT_525 = NL + "\t    pstmt_";
  protected final String TEXT_526 = " = conn_";
  protected final String TEXT_527 = ".prepareStatement(delete_";
  protected final String TEXT_528 = ");" + NL + "\t    ";
  protected final String TEXT_529 = NL + "\t    String replace_";
  protected final String TEXT_530 = " = \"REPLACE INTO `\" + ";
  protected final String TEXT_531 = " + \"` (";
  protected final String TEXT_532 = ") VALUES (";
  protected final String TEXT_533 = ")\";" + NL + "\t    pstmt_";
  protected final String TEXT_534 = " = conn_";
  protected final String TEXT_535 = ".prepareStatement(replace_";
  protected final String TEXT_536 = ");" + NL + "\t    ";
  protected final String TEXT_537 = NL + "\t    String insertIgnore_";
  protected final String TEXT_538 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_539 = " + \"` (";
  protected final String TEXT_540 = ") VALUES (";
  protected final String TEXT_541 = ") ON DUPLICATE KEY UPDATE ";
  protected final String TEXT_542 = "\";" + NL + "\t    pstmt_";
  protected final String TEXT_543 = " = conn_";
  protected final String TEXT_544 = ".prepareStatement(insertIgnore_";
  protected final String TEXT_545 = ");" + NL + "\t    ";
  protected final String TEXT_546 = NL + "\t    String insert_";
  protected final String TEXT_547 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_548 = " + \"` (";
  protected final String TEXT_549 = ") VALUES (";
  protected final String TEXT_550 = ")\";" + NL + "\t    ";
  protected final String TEXT_551 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_552 = " = new StringBuffer(insert_";
  protected final String TEXT_553 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_554 = ".insert(insert_";
  protected final String TEXT_555 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_556 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_557 = " =insertStringBuffer_";
  protected final String TEXT_558 = ".toString(); ";
  protected final String TEXT_559 = "    " + NL + "\t    pstmt_";
  protected final String TEXT_560 = " = conn_";
  protected final String TEXT_561 = ".prepareStatement(insert_";
  protected final String TEXT_562 = ");" + NL + "\t    ";
  protected final String TEXT_563 = NL + "        StringBuffer query_";
  protected final String TEXT_564 = " = null;" + NL + "       \t";
  protected final String TEXT_565 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_566 = " = insert_";
  protected final String TEXT_567 = ".split(\"\\\\?\");";
  protected final String TEXT_568 = NL + "\t\t\tupdate_";
  protected final String TEXT_569 = " += \" \";" + NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_570 = " = update_";
  protected final String TEXT_571 = ".split(\"\\\\?\");";
  protected final String TEXT_572 = NL + "\t\t\tupdate_";
  protected final String TEXT_573 = " += \" \";" + NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_574 = " = update_";
  protected final String TEXT_575 = ".split(\"\\\\?\");" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_576 = " = insert_";
  protected final String TEXT_577 = ".split(\"\\\\?\");";
  protected final String TEXT_578 = NL + "\t\t\tdelete_";
  protected final String TEXT_579 = " += \" \";" + NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_580 = " = delete_";
  protected final String TEXT_581 = ".split(\"\\\\?\");";
  protected final String TEXT_582 = NL + "\t\t\treplace_";
  protected final String TEXT_583 = " += \" \";" + NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_584 = " = replace_";
  protected final String TEXT_585 = ".split(\"\\\\?\");";
  protected final String TEXT_586 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_587 = " += \" \";" + NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_588 = " = insertIgnore_";
  protected final String TEXT_589 = ".split(\"\\\\?\");";
  protected final String TEXT_590 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_591 = " = insert_";
  protected final String TEXT_592 = ".split(\"\\\\?\");";
  protected final String TEXT_593 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_594 = NL + "    ";
  protected final String TEXT_595 = NL + "                if(";
  protected final String TEXT_596 = ".";
  protected final String TEXT_597 = "==null){";
  protected final String TEXT_598 = NL + "                    ";
  protected final String TEXT_599 = ".setNull(counter";
  protected final String TEXT_600 = ",java.sql.Types.CHAR);";
  protected final String TEXT_601 = NL + "                if(";
  protected final String TEXT_602 = ".";
  protected final String TEXT_603 = "==null){";
  protected final String TEXT_604 = NL + "                    ";
  protected final String TEXT_605 = ".setNull(counter";
  protected final String TEXT_606 = ",java.sql.Types.DATE);";
  protected final String TEXT_607 = NL + "                if(";
  protected final String TEXT_608 = ".";
  protected final String TEXT_609 = "==null){";
  protected final String TEXT_610 = NL + "                    ";
  protected final String TEXT_611 = ".setNull(counter";
  protected final String TEXT_612 = ",java.sql.Types.ARRAY);         ";
  protected final String TEXT_613 = NL + "                if(";
  protected final String TEXT_614 = ".";
  protected final String TEXT_615 = "==null){";
  protected final String TEXT_616 = NL + "                    ";
  protected final String TEXT_617 = ".setNull(counter";
  protected final String TEXT_618 = ",java.sql.Types.INTEGER);";
  protected final String TEXT_619 = NL + "                if(";
  protected final String TEXT_620 = ".";
  protected final String TEXT_621 = "==null){";
  protected final String TEXT_622 = NL + "                    ";
  protected final String TEXT_623 = ".setNull(counter";
  protected final String TEXT_624 = ",java.sql.Types.VARCHAR);";
  protected final String TEXT_625 = NL + "                if(";
  protected final String TEXT_626 = ".";
  protected final String TEXT_627 = "==null){";
  protected final String TEXT_628 = NL + "                    ";
  protected final String TEXT_629 = ".setNull(counter";
  protected final String TEXT_630 = ",java.sql.Types.OTHER);";
  protected final String TEXT_631 = NL + "                if(";
  protected final String TEXT_632 = ".";
  protected final String TEXT_633 = "==null){";
  protected final String TEXT_634 = NL + "                    ";
  protected final String TEXT_635 = ".setNull(counter";
  protected final String TEXT_636 = ",java.sql.Types.BOOLEAN);   ";
  protected final String TEXT_637 = NL + "                if(";
  protected final String TEXT_638 = ".";
  protected final String TEXT_639 = "==null){";
  protected final String TEXT_640 = NL + "                    ";
  protected final String TEXT_641 = ".setNull(counter";
  protected final String TEXT_642 = ",java.sql.Types.DOUBLE);    ";
  protected final String TEXT_643 = NL + "                if(";
  protected final String TEXT_644 = ".";
  protected final String TEXT_645 = "==null){";
  protected final String TEXT_646 = NL + "                    ";
  protected final String TEXT_647 = ".setNull(counter";
  protected final String TEXT_648 = ",java.sql.Types.FLOAT); ";
  protected final String TEXT_649 = NL + "                }else{";
  protected final String TEXT_650 = NL + "                    if(";
  protected final String TEXT_651 = ".";
  protected final String TEXT_652 = "==null){";
  protected final String TEXT_653 = NL + "                    if((\"null\").equals(String.valueOf(";
  protected final String TEXT_654 = ".";
  protected final String TEXT_655 = ").toLowerCase())){";
  protected final String TEXT_656 = NL + "                ";
  protected final String TEXT_657 = ".setNull(counter";
  protected final String TEXT_658 = ",java.sql.Types.CHAR);" + NL + "            " + NL + "                }else if(";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = " == '\\0'){" + NL + "        ";
  protected final String TEXT_661 = NL + "                    ";
  protected final String TEXT_662 = ".setString(counter";
  protected final String TEXT_663 = ",\"\");" + NL + "            " + NL + "                }else{" + NL + "            ";
  protected final String TEXT_664 = NL + "                    ";
  protected final String TEXT_665 = ".setString(counter";
  protected final String TEXT_666 = ",String.valueOf(";
  protected final String TEXT_667 = ".";
  protected final String TEXT_668 = "));" + NL + "                }";
  protected final String TEXT_669 = NL + "                if(";
  protected final String TEXT_670 = ".";
  protected final String TEXT_671 = "!=null){" + NL + "                    // timestamp < min java date value (year 1) || timestamp > max mysql value (year 10000) => set 0000-00-00 as date in MySQL" + NL + "                    date_";
  protected final String TEXT_672 = " = ";
  protected final String TEXT_673 = ".";
  protected final String TEXT_674 = ".getTime();" + NL + "                    if (date_";
  protected final String TEXT_675 = " < year1_";
  protected final String TEXT_676 = " || date_";
  protected final String TEXT_677 = " >= year10000_";
  protected final String TEXT_678 = ") {";
  protected final String TEXT_679 = NL + "                        ";
  protected final String TEXT_680 = ".setString(counter";
  protected final String TEXT_681 = ", \"0000-00-00 00:00:00\");" + NL + "                    } else {";
  protected final String TEXT_682 = NL + "                        ";
  protected final String TEXT_683 = ".setTimestamp(counter";
  protected final String TEXT_684 = ", new java.sql.Timestamp(date_";
  protected final String TEXT_685 = "));" + NL + "                    }" + NL + "                }else{" + NL + "        ";
  protected final String TEXT_686 = NL + "                    ";
  protected final String TEXT_687 = ".setNull(counter";
  protected final String TEXT_688 = ",java.sql.Types.DATE);" + NL + "            " + NL + "                }";
  protected final String TEXT_689 = NL + "                ";
  protected final String TEXT_690 = ".set";
  protected final String TEXT_691 = "(counter";
  protected final String TEXT_692 = ",";
  protected final String TEXT_693 = ".";
  protected final String TEXT_694 = ");";
  protected final String TEXT_695 = NL + "            " + NL + "                }" + NL + "        ";
  protected final String TEXT_696 = NL + "\t\tquery_";
  protected final String TEXT_697 = " = new StringBuffer(\"\");";
  protected final String TEXT_698 = NL + "\t\t\t\tcommitEvery_";
  protected final String TEXT_699 = " = buffersSize_";
  protected final String TEXT_700 = ";";
  protected final String TEXT_701 = NL + "\t\t\t\t\tbatchSize_";
  protected final String TEXT_702 = " = buffersSize_";
  protected final String TEXT_703 = ";";
  protected final String TEXT_704 = NL + "\t\t";
  protected final String TEXT_705 = NL + "        whetherReject_";
  protected final String TEXT_706 = " = false;";
  protected final String TEXT_707 = "                " + NL + "\t                \tint counter";
  protected final String TEXT_708 = " = rowCount";
  protected final String TEXT_709 = " * ";
  protected final String TEXT_710 = " + 1;" + NL + "\t                ";
  protected final String TEXT_711 = NL + "\t                        counter";
  protected final String TEXT_712 = "++;" + NL + "\t                        ";
  protected final String TEXT_713 = NL + "\t\t\t\t\t\t\tint count_dyn_";
  protected final String TEXT_714 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_715 = ".";
  protected final String TEXT_716 = ", pstmt_";
  protected final String TEXT_717 = ", counter";
  protected final String TEXT_718 = "-1);" + NL + "\t\t\t\t\t\t\tcounter";
  protected final String TEXT_719 = "+=count_dyn_";
  protected final String TEXT_720 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_721 = NL + "\t             " + NL + "\t                exInsertColValue";
  protected final String TEXT_722 = " = new BufferLine_";
  protected final String TEXT_723 = "(" + NL + "\t                ";
  protected final String TEXT_724 = NL + "\t                            ," + NL + "\t                            ";
  protected final String TEXT_725 = NL + "\t                        ";
  protected final String TEXT_726 = ".";
  protected final String TEXT_727 = "              " + NL + "\t                        ";
  protected final String TEXT_728 = NL + "\t\t\t\t\t, ";
  protected final String TEXT_729 = ".";
  protected final String TEXT_730 = NL + "\t\t\t\t";
  protected final String TEXT_731 = "  " + NL + "\t                ); " + NL + "\t               " + NL + "\t                exInsertColValueList";
  protected final String TEXT_732 = ".add(exInsertColValue";
  protected final String TEXT_733 = ");" + NL + "\t    " + NL + "\t                rowCount";
  protected final String TEXT_734 = "++;";
  protected final String TEXT_735 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_736 = "++;";
  protected final String TEXT_737 = "\t         " + NL + "\t                if(rowCount";
  protected final String TEXT_738 = " == ";
  protected final String TEXT_739 = "){ " + NL + "\t                    insertedCount_";
  protected final String TEXT_740 = " = insertedCount_";
  protected final String TEXT_741 = " + pstmt_";
  protected final String TEXT_742 = ".executeUpdate();" + NL + "\t                    exInsertColValueList";
  protected final String TEXT_743 = ".clear();" + NL + "\t                    rowCount";
  protected final String TEXT_744 = " = 0;" + NL + "\t\t\t    counter";
  protected final String TEXT_745 = "=1;" + NL + "\t                }    ";
  protected final String TEXT_746 = NL + "\t                        ";
  protected final String TEXT_747 = NL + "\t                        ";
  protected final String TEXT_748 = NL + "\t                            query_";
  protected final String TEXT_749 = " = ";
  protected final String TEXT_750 = ";" + NL + "\t                            ";
  protected final String TEXT_751 = NL + "\t\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_752 = ".";
  protected final String TEXT_753 = ", pstmt_";
  protected final String TEXT_754 = ", ";
  protected final String TEXT_755 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_756 = NL + "\t                    globalMap.put(\"";
  protected final String TEXT_757 = "_QUERY\", query_";
  protected final String TEXT_758 = ".toString().trim());" + NL + "\t                    ";
  protected final String TEXT_759 = NL + "\t\t\t\t\t";
  protected final String TEXT_760 = NL + "\t\t    \t\tpstmt_";
  protected final String TEXT_761 = ".addBatch();" + NL + "\t\t    \t\tnb_line_";
  protected final String TEXT_762 = "++;    \t\t " + NL + "\t\t\t\t\t" + NL + "\t\t    \t\t  ";
  protected final String TEXT_763 = NL + "\t\t    \t\t  batchSizeCounter_";
  protected final String TEXT_764 = "++;" + NL + "\t\t    \t\t  ";
  protected final String TEXT_765 = "    \t\t" + NL + "\t\t    \t\t";
  protected final String TEXT_766 = NL + "\t                try {" + NL + "\t                    insertedCount_";
  protected final String TEXT_767 = " = insertedCount_";
  protected final String TEXT_768 = " + pstmt_";
  protected final String TEXT_769 = ".executeUpdate();" + NL + "\t                    nb_line_";
  protected final String TEXT_770 = "++;" + NL + "\t                } catch(Exception e) {" + NL + "\t                    whetherReject_";
  protected final String TEXT_771 = " = true;" + NL + "\t                    ";
  protected final String TEXT_772 = NL + "\t                        throw(e);" + NL + "\t                        ";
  protected final String TEXT_773 = NL + "\t                            ";
  protected final String TEXT_774 = " = new ";
  protected final String TEXT_775 = "Struct();" + NL + "\t                            ";
  protected final String TEXT_776 = NL + "\t                                ";
  protected final String TEXT_777 = ".";
  protected final String TEXT_778 = " = ";
  protected final String TEXT_779 = ".";
  protected final String TEXT_780 = ";" + NL + "\t                            ";
  protected final String TEXT_781 = NL + "\t                            ";
  protected final String TEXT_782 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_783 = ";" + NL + "\t                            ";
  protected final String TEXT_784 = NL + "\t                            System.err.print(e.getMessage());" + NL + "\t                            ";
  protected final String TEXT_785 = NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_786 = NL + "                        ";
  protected final String TEXT_787 = NL + "                            query_";
  protected final String TEXT_788 = " = ";
  protected final String TEXT_789 = ";";
  protected final String TEXT_790 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = ", pstmt_";
  protected final String TEXT_793 = ", ";
  protected final String TEXT_794 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_795 = NL + "                    globalMap.put(\"";
  protected final String TEXT_796 = "_QUERY\", query_";
  protected final String TEXT_797 = ".toString().trim());";
  protected final String TEXT_798 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_799 = " = insertedCount_";
  protected final String TEXT_800 = " + pstmt_";
  protected final String TEXT_801 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_802 = "++;" + NL + "                } catch(Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_803 = " = true;";
  protected final String TEXT_804 = NL + "                        throw(e);";
  protected final String TEXT_805 = NL + "                            ";
  protected final String TEXT_806 = " = new ";
  protected final String TEXT_807 = "Struct();";
  protected final String TEXT_808 = NL + "                                ";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = " = ";
  protected final String TEXT_811 = ".";
  protected final String TEXT_812 = ";";
  protected final String TEXT_813 = NL + "                            ";
  protected final String TEXT_814 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_815 = ";";
  protected final String TEXT_816 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_817 = NL + "                }";
  protected final String TEXT_818 = NL + "    \t\t\t    ";
  protected final String TEXT_819 = NL + "    \t\t\t    ";
  protected final String TEXT_820 = NL + "                        query_";
  protected final String TEXT_821 = " = ";
  protected final String TEXT_822 = ";";
  protected final String TEXT_823 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_824 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = ", pstmt_";
  protected final String TEXT_827 = ", ";
  protected final String TEXT_828 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_829 = NL + "                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_830 = NL + "                    \t";
  protected final String TEXT_831 = NL + "                        query_";
  protected final String TEXT_832 = " = ";
  protected final String TEXT_833 = ";";
  protected final String TEXT_834 = "  " + NL + "    \t\t\t    ";
  protected final String TEXT_835 = NL + "    \t\t\t    ";
  protected final String TEXT_836 = NL + "                       query_";
  protected final String TEXT_837 = " = ";
  protected final String TEXT_838 = ";";
  protected final String TEXT_839 = NL + "                globalMap.put(\"";
  protected final String TEXT_840 = "_QUERY\", query_";
  protected final String TEXT_841 = ".toString().trim());";
  protected final String TEXT_842 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_843 = NL + "    \t\tpstmt_";
  protected final String TEXT_844 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_845 = "++;    \t\t " + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_846 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_847 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_848 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_849 = NL + "            try {" + NL + "                updatedCount_";
  protected final String TEXT_850 = " = updatedCount_";
  protected final String TEXT_851 = " + pstmt_";
  protected final String TEXT_852 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_853 = "++;" + NL + "            } catch(Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_854 = " = true;";
  protected final String TEXT_855 = NL + "                    throw(e);";
  protected final String TEXT_856 = NL + "                        ";
  protected final String TEXT_857 = " = new ";
  protected final String TEXT_858 = "Struct();";
  protected final String TEXT_859 = NL + "                            ";
  protected final String TEXT_860 = ".";
  protected final String TEXT_861 = " = ";
  protected final String TEXT_862 = ".";
  protected final String TEXT_863 = ";";
  protected final String TEXT_864 = NL + "                        ";
  protected final String TEXT_865 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_866 = ";";
  protected final String TEXT_867 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_868 = NL + "            }";
  protected final String TEXT_869 = NL + "\t\t\t\t\t";
  protected final String TEXT_870 = NL + "                    \t";
  protected final String TEXT_871 = NL + "    \t\t\t    ";
  protected final String TEXT_872 = NL + "    \t\t\t    ";
  protected final String TEXT_873 = NL + "    " + NL + "    \t\tjava.sql.ResultSet rs_";
  protected final String TEXT_874 = " = pstmt_";
  protected final String TEXT_875 = ".executeQuery();" + NL + "    \t\tint checkCount_";
  protected final String TEXT_876 = " = -1;" + NL + "    \t\twhile(rs_";
  protected final String TEXT_877 = ".next()) {" + NL + "    \t\t\tcheckCount_";
  protected final String TEXT_878 = " = rs_";
  protected final String TEXT_879 = ".getInt(1);" + NL + "    \t\t}" + NL + "    \t\tif(checkCount_";
  protected final String TEXT_880 = " > 0) {" + NL + "    \t\t\t";
  protected final String TEXT_881 = NL + "    \t\t\t\t    ";
  protected final String TEXT_882 = NL + "    \t\t\t\t    ";
  protected final String TEXT_883 = NL + "                            query_";
  protected final String TEXT_884 = " = ";
  protected final String TEXT_885 = ";";
  protected final String TEXT_886 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_887 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_888 = ".";
  protected final String TEXT_889 = ", pstmtUpdate_";
  protected final String TEXT_890 = ", ";
  protected final String TEXT_891 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_892 = NL + "\t                    \t";
  protected final String TEXT_893 = NL + "\t                    ";
  protected final String TEXT_894 = NL + "\t                        query_";
  protected final String TEXT_895 = " = ";
  protected final String TEXT_896 = ";" + NL + "\t                        ";
  protected final String TEXT_897 = NL + "    \t\t\t\t    ";
  protected final String TEXT_898 = NL + "    \t\t\t\t    ";
  protected final String TEXT_899 = NL + "                            query_";
  protected final String TEXT_900 = " = ";
  protected final String TEXT_901 = ";";
  protected final String TEXT_902 = NL + "                    globalMap.put(\"";
  protected final String TEXT_903 = "_QUERY\", query_";
  protected final String TEXT_904 = ".toString().trim());";
  protected final String TEXT_905 = NL + "                try {" + NL + "                    updatedCount_";
  protected final String TEXT_906 = " = updatedCount_";
  protected final String TEXT_907 = " + pstmtUpdate_";
  protected final String TEXT_908 = ".executeUpdate();" + NL + "                } catch(Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_909 = " = true;";
  protected final String TEXT_910 = NL + "                        throw(e);";
  protected final String TEXT_911 = NL + "                        ";
  protected final String TEXT_912 = " = new ";
  protected final String TEXT_913 = "Struct();";
  protected final String TEXT_914 = NL + "                                ";
  protected final String TEXT_915 = ".";
  protected final String TEXT_916 = " = ";
  protected final String TEXT_917 = ".";
  protected final String TEXT_918 = ";";
  protected final String TEXT_919 = NL + "                            ";
  protected final String TEXT_920 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_921 = ";";
  protected final String TEXT_922 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_923 = NL + "                }" + NL + "    \t\t} else {" + NL + "    \t\t\t";
  protected final String TEXT_924 = NL + "    \t\t\t\t    ";
  protected final String TEXT_925 = NL + "    \t\t\t\t    ";
  protected final String TEXT_926 = NL + "                            query_";
  protected final String TEXT_927 = " = ";
  protected final String TEXT_928 = ";";
  protected final String TEXT_929 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_930 = ".";
  protected final String TEXT_931 = ", pstmtInsert_";
  protected final String TEXT_932 = ", ";
  protected final String TEXT_933 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_934 = NL + "                    globalMap.put(\"";
  protected final String TEXT_935 = "_QUERY\", query_";
  protected final String TEXT_936 = ".toString().trim());";
  protected final String TEXT_937 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_938 = " = insertedCount_";
  protected final String TEXT_939 = " + pstmtInsert_";
  protected final String TEXT_940 = ".executeUpdate();" + NL + "                } catch(Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_941 = " = true;";
  protected final String TEXT_942 = NL + "                        throw(e);";
  protected final String TEXT_943 = NL + "                        ";
  protected final String TEXT_944 = " = new ";
  protected final String TEXT_945 = "Struct();";
  protected final String TEXT_946 = NL + "                                ";
  protected final String TEXT_947 = ".";
  protected final String TEXT_948 = " = ";
  protected final String TEXT_949 = ".";
  protected final String TEXT_950 = ";";
  protected final String TEXT_951 = NL + "                            ";
  protected final String TEXT_952 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_953 = ";";
  protected final String TEXT_954 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_955 = NL + "                }" + NL + "    \t\t}" + NL + "    \t\tnb_line_";
  protected final String TEXT_956 = "++;" + NL + "    \t\t";
  protected final String TEXT_957 = NL + "    \t    int updateFlag_";
  protected final String TEXT_958 = "=0;" + NL + "    \t    ";
  protected final String TEXT_959 = NL + "    \t\t\t    ";
  protected final String TEXT_960 = NL + "    \t\t\t    ";
  protected final String TEXT_961 = NL + "                        query_";
  protected final String TEXT_962 = " = ";
  protected final String TEXT_963 = ";";
  protected final String TEXT_964 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_965 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_966 = ".";
  protected final String TEXT_967 = ", pstmtUpdate_";
  protected final String TEXT_968 = ", ";
  protected final String TEXT_969 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_970 = NL + "\t\t\t\t\t";
  protected final String TEXT_971 = NL + "                    \t";
  protected final String TEXT_972 = NL + "\t                        query_";
  protected final String TEXT_973 = " = ";
  protected final String TEXT_974 = ";" + NL + "\t                        ";
  protected final String TEXT_975 = NL + "                    " + NL + "    \t\t\t    ";
  protected final String TEXT_976 = NL + "    \t\t\t    ";
  protected final String TEXT_977 = NL + "                        query_";
  protected final String TEXT_978 = " = ";
  protected final String TEXT_979 = ";";
  protected final String TEXT_980 = NL + "                globalMap.put(\"";
  protected final String TEXT_981 = "_QUERY\", query_";
  protected final String TEXT_982 = ".toString().trim());";
  protected final String TEXT_983 = NL + "    \t" + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_984 = "=pstmtUpdate_";
  protected final String TEXT_985 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_986 = " = updatedCount_";
  protected final String TEXT_987 = "+updateFlag_";
  protected final String TEXT_988 = ";" + NL + "                " + NL + "            } catch(Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_989 = " = true;";
  protected final String TEXT_990 = NL + "                    throw(e);";
  protected final String TEXT_991 = NL + "                        ";
  protected final String TEXT_992 = " = new ";
  protected final String TEXT_993 = "Struct();";
  protected final String TEXT_994 = NL + "                            ";
  protected final String TEXT_995 = ".";
  protected final String TEXT_996 = " = ";
  protected final String TEXT_997 = ".";
  protected final String TEXT_998 = ";";
  protected final String TEXT_999 = NL + "                        ";
  protected final String TEXT_1000 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1001 = ";";
  protected final String TEXT_1002 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1003 = NL + "            }" + NL + "            if(updateFlag_";
  protected final String TEXT_1004 = " == 0) {" + NL + "            " + NL + "            \t";
  protected final String TEXT_1005 = NL + "\t\t\t\tquery_";
  protected final String TEXT_1006 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_1007 = NL + "        \t\t\t    ";
  protected final String TEXT_1008 = NL + "        \t\t\t    ";
  protected final String TEXT_1009 = NL + "                            query_";
  protected final String TEXT_1010 = " = ";
  protected final String TEXT_1011 = ";";
  protected final String TEXT_1012 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1013 = ".";
  protected final String TEXT_1014 = ", pstmtInsert_";
  protected final String TEXT_1015 = ", ";
  protected final String TEXT_1016 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1017 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1018 = "_QUERY\", query_";
  protected final String TEXT_1019 = ".toString().trim());";
  protected final String TEXT_1020 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1021 = " = insertedCount_";
  protected final String TEXT_1022 = " + pstmtInsert_";
  protected final String TEXT_1023 = ".executeUpdate();" + NL + "                } catch(Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1024 = " = true;";
  protected final String TEXT_1025 = NL + "                        throw(e);";
  protected final String TEXT_1026 = NL + "                        ";
  protected final String TEXT_1027 = " = new ";
  protected final String TEXT_1028 = "Struct();";
  protected final String TEXT_1029 = NL + "                                ";
  protected final String TEXT_1030 = ".";
  protected final String TEXT_1031 = " = ";
  protected final String TEXT_1032 = ".";
  protected final String TEXT_1033 = ";";
  protected final String TEXT_1034 = NL + "                            ";
  protected final String TEXT_1035 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1036 = ";";
  protected final String TEXT_1037 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1038 = NL + "                }" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_1039 = "++;";
  protected final String TEXT_1040 = NL + "\t\t\t\t\t";
  protected final String TEXT_1041 = NL + "                    \t";
  protected final String TEXT_1042 = NL + "\t                        query_";
  protected final String TEXT_1043 = " = ";
  protected final String TEXT_1044 = ";" + NL + "\t                        ";
  protected final String TEXT_1045 = NL + "    \t\t\t    ";
  protected final String TEXT_1046 = NL + "    \t\t\t    ";
  protected final String TEXT_1047 = NL + "                        query_";
  protected final String TEXT_1048 = " = ";
  protected final String TEXT_1049 = ";";
  protected final String TEXT_1050 = NL + "                globalMap.put(\"";
  protected final String TEXT_1051 = "_QUERY\", query_";
  protected final String TEXT_1052 = ".toString().trim());";
  protected final String TEXT_1053 = NL + "        \t";
  protected final String TEXT_1054 = NL + "    \t\tpstmt_";
  protected final String TEXT_1055 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_1056 = "++;    \t\t " + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_1057 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1058 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1059 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1060 = NL + "            try {" + NL + "        \t    deletedCount_";
  protected final String TEXT_1061 = " = deletedCount_";
  protected final String TEXT_1062 = " + pstmt_";
  protected final String TEXT_1063 = ".executeUpdate();" + NL + "            } catch(Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1064 = " = true;";
  protected final String TEXT_1065 = NL + "                    throw(e);";
  protected final String TEXT_1066 = NL + "                        ";
  protected final String TEXT_1067 = " = new ";
  protected final String TEXT_1068 = "Struct();";
  protected final String TEXT_1069 = NL + "                            ";
  protected final String TEXT_1070 = ".";
  protected final String TEXT_1071 = " = ";
  protected final String TEXT_1072 = ".";
  protected final String TEXT_1073 = ";" + NL + "                            ";
  protected final String TEXT_1074 = NL + "                        rejectedCount_";
  protected final String TEXT_1075 = " =  rejectedCount_";
  protected final String TEXT_1076 = "+ 1;";
  protected final String TEXT_1077 = NL + "                        ";
  protected final String TEXT_1078 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1079 = ";" + NL + "                       ";
  protected final String TEXT_1080 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1081 = NL + "            }";
  protected final String TEXT_1082 = NL + "            nb_line_";
  protected final String TEXT_1083 = "++;" + NL + "        \t";
  protected final String TEXT_1084 = NL + "                    ";
  protected final String TEXT_1085 = NL + "                        query_";
  protected final String TEXT_1086 = " = ";
  protected final String TEXT_1087 = ";";
  protected final String TEXT_1088 = NL + "                globalMap.put(\"";
  protected final String TEXT_1089 = "_QUERY\", query_";
  protected final String TEXT_1090 = ".toString().trim());";
  protected final String TEXT_1091 = NL + "            int replaceCount_";
  protected final String TEXT_1092 = " = 0;" + NL + "            try {" + NL + "                replaceCount_";
  protected final String TEXT_1093 = " = pstmt_";
  protected final String TEXT_1094 = ".executeUpdate();" + NL + "            } catch(Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1095 = " = true;";
  protected final String TEXT_1096 = NL + "                    throw(e);";
  protected final String TEXT_1097 = NL + "                        ";
  protected final String TEXT_1098 = " = new ";
  protected final String TEXT_1099 = "Struct();";
  protected final String TEXT_1100 = NL + "                            ";
  protected final String TEXT_1101 = ".";
  protected final String TEXT_1102 = " = ";
  protected final String TEXT_1103 = ".";
  protected final String TEXT_1104 = ";";
  protected final String TEXT_1105 = NL + "                        rejectedCount_";
  protected final String TEXT_1106 = " =  rejectedCount_";
  protected final String TEXT_1107 = "+ 1;";
  protected final String TEXT_1108 = NL + "                        ";
  protected final String TEXT_1109 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1110 = ";";
  protected final String TEXT_1111 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1112 = "                " + NL + "            }" + NL + "            if(replaceCount_";
  protected final String TEXT_1113 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1114 = " += replaceCount_";
  protected final String TEXT_1115 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1116 = " += 1;" + NL + "                deletedCount_";
  protected final String TEXT_1117 = " += replaceCount_";
  protected final String TEXT_1118 = " - 1;" + NL + "            }";
  protected final String TEXT_1119 = NL + "                    ";
  protected final String TEXT_1120 = NL + "                        query_";
  protected final String TEXT_1121 = " = ";
  protected final String TEXT_1122 = ";";
  protected final String TEXT_1123 = NL + "                    ";
  protected final String TEXT_1124 = NL + "                        query_";
  protected final String TEXT_1125 = " = ";
  protected final String TEXT_1126 = ";";
  protected final String TEXT_1127 = NL + "                globalMap.put(\"";
  protected final String TEXT_1128 = "_QUERY\", query_";
  protected final String TEXT_1129 = ".toString().trim());";
  protected final String TEXT_1130 = NL + "            int count_on_duplicate_key_";
  protected final String TEXT_1131 = " = 0;" + NL + "            try {" + NL + "                count_on_duplicate_key_";
  protected final String TEXT_1132 = " = pstmt_";
  protected final String TEXT_1133 = ".executeUpdate();" + NL + "            } catch(Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1134 = " = true;";
  protected final String TEXT_1135 = NL + "                    throw(e);";
  protected final String TEXT_1136 = NL + "                        ";
  protected final String TEXT_1137 = " = new ";
  protected final String TEXT_1138 = "Struct();";
  protected final String TEXT_1139 = NL + "                            ";
  protected final String TEXT_1140 = ".";
  protected final String TEXT_1141 = " = ";
  protected final String TEXT_1142 = ".";
  protected final String TEXT_1143 = ";";
  protected final String TEXT_1144 = NL + "                        rejectedCount_";
  protected final String TEXT_1145 = " =  rejectedCount_";
  protected final String TEXT_1146 = "+ 1;";
  protected final String TEXT_1147 = NL + "                        ";
  protected final String TEXT_1148 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1149 = ";";
  protected final String TEXT_1150 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1151 = "                " + NL + "            }" + NL + "            if(count_on_duplicate_key_";
  protected final String TEXT_1152 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1153 = " += count_on_duplicate_key_";
  protected final String TEXT_1154 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1155 = " += 1;" + NL + "                updatedCount_";
  protected final String TEXT_1156 = " += count_on_duplicate_key_";
  protected final String TEXT_1157 = " - 1;" + NL + "            }";
  protected final String TEXT_1158 = NL + "                        ";
  protected final String TEXT_1159 = NL + "                            query_";
  protected final String TEXT_1160 = " = ";
  protected final String TEXT_1161 = ";";
  protected final String TEXT_1162 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1163 = "_QUERY\", query_";
  protected final String TEXT_1164 = ".toString().trim());";
  protected final String TEXT_1165 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1166 = " = insertedCount_";
  protected final String TEXT_1167 = " + pstmt_";
  protected final String TEXT_1168 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_1169 = "++;" + NL + "                } catch(Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1170 = " = true;";
  protected final String TEXT_1171 = NL + "                        throw(e);";
  protected final String TEXT_1172 = NL + "                            ";
  protected final String TEXT_1173 = " = new ";
  protected final String TEXT_1174 = "Struct();";
  protected final String TEXT_1175 = NL + "                                ";
  protected final String TEXT_1176 = ".";
  protected final String TEXT_1177 = " = ";
  protected final String TEXT_1178 = ".";
  protected final String TEXT_1179 = ";";
  protected final String TEXT_1180 = NL + "                            rejectedCount_";
  protected final String TEXT_1181 = " =  rejectedCount_";
  protected final String TEXT_1182 = "+ 1;";
  protected final String TEXT_1183 = NL + "                            ";
  protected final String TEXT_1184 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1185 = ";";
  protected final String TEXT_1186 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1187 = NL + "                }";
  protected final String TEXT_1188 = NL + "            if(!whetherReject_";
  protected final String TEXT_1189 = ") {";
  protected final String TEXT_1190 = NL + "                            ";
  protected final String TEXT_1191 = " = new ";
  protected final String TEXT_1192 = "Struct();";
  protected final String TEXT_1193 = NL + "                                ";
  protected final String TEXT_1194 = ".";
  protected final String TEXT_1195 = " = ";
  protected final String TEXT_1196 = ".";
  protected final String TEXT_1197 = ";";
  protected final String TEXT_1198 = NL + "            }";
  protected final String TEXT_1199 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1200 = " <= batchSizeCounter_";
  protected final String TEXT_1201 = ") {                ";
  protected final String TEXT_1202 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_1203 = ".executeBatch();                \t" + NL + "            \t    \t";
  protected final String TEXT_1204 = NL + "            \t    \t\tinsertedCount_";
  protected final String TEXT_1205 = " += batchSizeCounter_";
  protected final String TEXT_1206 = ";" + NL + "            \t    \t";
  protected final String TEXT_1207 = "                         \t    \t" + NL + "                }catch (java.sql.SQLException e){" + NL + "                \t";
  protected final String TEXT_1208 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1209 = NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1210 = NL + "                }";
  protected final String TEXT_1211 = "    " + NL + "                \t\t\t" + NL + "    \t\t\tbatchSizeCounter_";
  protected final String TEXT_1212 = " = 0;" + NL + "    \t\t}" + NL + "    \t\t";
  protected final String TEXT_1213 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1214 = " <= batchSizeCounter_";
  protected final String TEXT_1215 = ") {                ";
  protected final String TEXT_1216 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_1217 = ".executeBatch();                \t" + NL + "            \t    \t";
  protected final String TEXT_1218 = NL + "            \t    \t\tupdatedCount_";
  protected final String TEXT_1219 = " += pstmt_";
  protected final String TEXT_1220 = ". getUpdateCount();" + NL + "            \t    \t";
  protected final String TEXT_1221 = NL + "            \t    \t    deletedCount_";
  protected final String TEXT_1222 = " += pstmt_";
  protected final String TEXT_1223 = ". getUpdateCount();" + NL + "            \t    \t";
  protected final String TEXT_1224 = "                         \t    \t" + NL + "            \t    \tbatchSizeCounter_";
  protected final String TEXT_1225 = " = 0;             \t                \t                \t" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1226 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1227 = NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1228 = NL + "                }";
  protected final String TEXT_1229 = "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_1230 = NL + "        \t    commitCounter_";
  protected final String TEXT_1231 = "++;" + NL + "       " + NL + "                if(commitEvery_";
  protected final String TEXT_1232 = " <= commitCounter_";
  protected final String TEXT_1233 = ") {" + NL + "                ";
  protected final String TEXT_1234 = NL + "                try {" + NL + "                \t\tpstmt_";
  protected final String TEXT_1235 = ".executeBatch();" + NL + "            \t    \t";
  protected final String TEXT_1236 = NL + "            \t    \tif(pstmt_";
  protected final String TEXT_1237 = ".getUpdateCount() != -1)" + NL + "            \t    \t\tinsertedCount_";
  protected final String TEXT_1238 = " += pstmt_";
  protected final String TEXT_1239 = ".getUpdateCount();" + NL + "            \t    \t";
  protected final String TEXT_1240 = "            \t    \t\t" + NL + "            \t    \t\tupdatedCount_";
  protected final String TEXT_1241 = " += pstmt_";
  protected final String TEXT_1242 = ".getUpdateCount();" + NL + "            \t    \t";
  protected final String TEXT_1243 = NL + "            \t    \t    deletedCount_";
  protected final String TEXT_1244 = " += pstmt_";
  protected final String TEXT_1245 = ".getUpdateCount();" + NL + "            \t    \t";
  protected final String TEXT_1246 = "            \t    " + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1247 = NL + "\t\t\t\t\t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1248 = NL + "                        System.out.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1249 = NL + "                " + NL + "                }            \t                              ";
  protected final String TEXT_1250 = NL + "                \tconn_";
  protected final String TEXT_1251 = ".commit();" + NL + "                \t" + NL + "                \tcommitCounter_";
  protected final String TEXT_1252 = "=0;" + NL + "                " + NL + "                }\t" + NL + "    ";
  protected final String TEXT_1253 = NL;

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
	IProcess process = node.getProcess();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");
	
    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
    
    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
    
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    
    boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
        
        //to fixed: bug8422
        if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
        	extendedInsert = false;
        }    
    
    String numPerInsert = ElementParameterParser.getValue(node, "__NB_ROWS_PER_INSERT__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
	
	//feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
	
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	
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
	
	if(isDynamic) {
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
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
		hintValue = option.get("HINT");	
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
		}
	}
} 
//// hint options end ////

if(columnList != null && columnList.size() > 0) {
    
    stringBuffer.append(TEXT_7);
      
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

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_22);
    
					} else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_29);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_32);
    
			}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    				

        } else if(("CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_44);
    
					} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_51);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_54);
    
			}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
			}

    stringBuffer.append(TEXT_62);
     
			/*
				case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
				so in mssql use "Select" checked the table whether exist.
			*/
			//TODO we will use like "select" sql intead of use system table to checked table?
			if(MSSQL.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
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
    
			} else if (ORACLE.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
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
    
			} else if ( SYBASE.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId)
						|| INFORMIX.equalsIgnoreCase(dbmsId) || DB2.equalsIgnoreCase(dbmsId) ) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
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
    stringBuffer.append(table);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    			
			} else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
			}

    
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_125);
    
					} else {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_132);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_135);
    
			}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
            } else {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);
					if(query.lastIndexOf("(")==query.length()-1) {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_153);
    
					} else {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_160);
    
					}
				}
			} else {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_163);
    
			}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
			}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
			}

    stringBuffer.append(TEXT_168);
    
        } else if(("CLEAR").equals(tableAction)) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
        }else if(("TRUNCATE").equals(tableAction)) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(manager.getTruncateTableSQL());
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
    
    boolean supportDuplicateUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ON_DUPLICATE_KEY_UPDATE__"));
    
	if(("INSERT").equals(dataAction)) {
	
		if (supportDuplicateUpdate) {
			List<Map<String, String>> duplicateKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue( node,"__DUPLICATED_KEYS__" );
			          			
			if (duplicateKeys.size() > 0) {
			
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
				for (int i=0; i< duplicateKeys.size() ; i++) {
					if (i >0) {
					
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
					}
					
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_KEY"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_VALUE"));
    stringBuffer.append(TEXT_200);
    
				}
			}
		}

    stringBuffer.append(TEXT_201);
    				       
		    if(!extendedInsert) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);

					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_211);
    					} else {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_219);
    
					}
				}
			
		        
    	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    	
				}

    stringBuffer.append(TEXT_223);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    
                //to fixed: bug8422
                if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    
                //to fixed: bug8422
                if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){ 
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    
	    } else {//extended-insert mode(begin)
	    	if ("mysql-connector-java-3.1.14-bin.jar".equals(dbVersion)) {

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_254);
    
			if(isDynamic) {
			     List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			     if(conns_dynamic!=null && conns_dynamic.size()>0){
			     	IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_259);
    
				}			
			} else {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_262);
    
			}

    stringBuffer.append(TEXT_263);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_269);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    					} else {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    
					}	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    	
				}

    stringBuffer.append(TEXT_284);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_305);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_306);
    
					} else {

    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_314);
    
					}
				}
		    if(isDynamic) {

    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    
		    } else {

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    
		    }
		} else if ("mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_323);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_328);
    					} else {

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_336);
    
					}
				}
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    	
				}
				if(isDynamic) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
				} else {

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
				}

    stringBuffer.append(TEXT_348);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    }
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
	       	} 
	    }//extended-insert mode(end)
	} else if (("UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);
			if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_368);
    			} else {

    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_372);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_375);
    
			}
		}		
	    
    stringBuffer.append(TEXT_376);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    		
	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_393);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_398);
    					} else {

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_406);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_410);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_414);
    				} else {

    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_421);
    
				}
			}
	    
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_430);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    }
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    }
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    
	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_459);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_462);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_463);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_464);
    					} else {

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_468);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_471);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_472);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_480);
    				} else {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_487);
    
				}
			}	
	    
    stringBuffer.append(TEXT_488);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    }
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    }
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    			
	} else if (("DELETE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_516);
    if(useHintOptions && hintsValues.get("DELETE") != null) {
  
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
  }
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    		
	} else if(("REPLACE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    
	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
	} else if(("INSERT_IGNORE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_550);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    }
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    
	}
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    
		}

    
    }
}
	
    stringBuffer.append(TEXT_593);
    
	}
	
	
    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure){
    	if(!colStmt.isReplaced() && !colStmt.isAddCol()){
    		colStruct.add(colStmt);
    	}
    }

	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	if(("true").equals(useExistingConn)) {
		List<? extends INode> nodes =  process.getNodesOfType("tMysqlConnection");
		for (INode ne:nodes) {
			if (connection.equals(ne.getUniqueName())) {
				dbVersion = ElementParameterParser.getValue(ne, "__DB_VERSION__");
			}
		}
	} else {
		dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}

    class ExtendInsertOperation{
        public String generateType(String typeToGenerate){
            if(("byte[]").equals(typeToGenerate)){
                typeToGenerate = "Bytes";
            }else if(("java.util.Date").equals(typeToGenerate)){
                typeToGenerate = "Date";
            }else if(("Integer").equals(typeToGenerate)){
                typeToGenerate = "Int";
            }else if(("List").equals(typeToGenerate)){  
                typeToGenerate = "Object";                 
            }else{
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public void generateSetStmt(String typeToGenerate, Column column, String incomingConnName, String cid){
            boolean isObject = false;                               
            String prefix = "pstmt_";                             
            
    stringBuffer.append(TEXT_594);
    
            if(("Character").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_595);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_597);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    
            }else if(("Date").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_601);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    
            }else if(("byte[]").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_607);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    
            }else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_613);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_615);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
            }else if(("String").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_619);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_621);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
            }else if(("Object").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_625);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    
            }else if(("Boolean").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_631);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    
            }else if(("Double").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_637);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_639);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    
            }else if(("Float").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_643);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_645);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_649);
    
            }
            typeToGenerate = generateType(typeToGenerate);
        
            if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
                
    
                if(isObject) {
                    
    stringBuffer.append(TEXT_650);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_652);
    
                } else {
                    
    stringBuffer.append(TEXT_653);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_655);
    
                }
                
    stringBuffer.append(TEXT_656);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_660);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_668);
    
            }else if(("Date").equals(typeToGenerate)){
                
    stringBuffer.append(TEXT_669);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    
            }else{
                
    stringBuffer.append(TEXT_689);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_694);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_695);
    
            }
        }
    }
    
	if(isEnableDebug) {

    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    
	}

	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	
	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!"true".equals(useExistingConn)) {
	    	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_700);
    
	    	}
	    }
	    if ("mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) {
	    	if (extendedInsert || useBatchSize) {
			    if((!("").equals(numPerInsert)&&!("0").equals(numPerInsert))
			    	||(!("").equals(batchSize)&&!("0").equals(batchSize))) {

    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_703);
    
			    }
	    	}
    	}

    stringBuffer.append(TEXT_704);
    
	}

    if(incomingConnName != null && columnList != null){
        
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    	
        if(("INSERT").equals(dataAction)) {
            if(extendedInsert) {//extended-insert mode(begin)
            	if ("mysql-connector-java-3.1.14-bin.jar".equals(dbVersion)) {
	                ExtendInsertOperation eiOperation = new ExtendInsertOperation(); 
	                int insertableCount = 0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        insertableCount++;
	                    }
	                }
			if(!isDynamic) {
	                
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(insertableCount);
    stringBuffer.append(TEXT_710);
    
			}   
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        eiOperation.generateSetStmt(typeToGenerate,column,incomingConnName,cid);
	                        
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    
	                    }
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    
						}
					}
	                
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
     
	                int count =0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        if(count != 0) {
	                            
    stringBuffer.append(TEXT_724);
    
	                        }                        
	                        
    stringBuffer.append(TEXT_725);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_727);
                            
	                        count++;                    
	                    }   
	                }
			if(isDynamic) {
			    	Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_728);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_730);
    
				}
			    }
	                
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    
			if(isDynamic) {

    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    
			}

    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
     
				} else if ("mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) {
	 				int counter = 1;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        
    stringBuffer.append(TEXT_746);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_747);
    
	                        if(isEnableDebug) {
	                            
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_750);
    
	                        }                        
	                        counter++;                        
	                    }		
	
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_751);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_755);
    
						}
					}
					
	                if(isEnableDebug) {
	                    
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    
	                }                
	                
    stringBuffer.append(TEXT_759);
    if (rejectConnName == null) { // modification one
		    		
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    if (!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
		    		  
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_764);
    
		    		  }
    stringBuffer.append(TEXT_765);
    
		    		}else {    		
		    		
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    
	                    if (("true").equals(dieOnError)) {
	                        
    stringBuffer.append(TEXT_772);
    
	                    } else {
	                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_773);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_775);
    
	                            for(IMetadataColumn column : columnList) {
	                             
    stringBuffer.append(TEXT_776);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_778);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_780);
    
	                            }
	                            
    stringBuffer.append(TEXT_781);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_783);
    
	                        } else {
	                            
    stringBuffer.append(TEXT_784);
    
	                        }
	                    } 
	                    
    stringBuffer.append(TEXT_785);
    
    			}
    			
    
				}
            } else {//extended-insert mode(end)
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_786);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_789);
    
                        }                        
                        counter++;                        
                    }		

                }
				
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_790);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_794);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    
                }                
                
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_804);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_805);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_806);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_807);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_808);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_810);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_812);
    
                            }
                            
    stringBuffer.append(TEXT_813);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_815);
    
                        } else {
                            
    stringBuffer.append(TEXT_816);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_817);
    
            }
    	} else if(("UPDATE").equals(dataAction)) {
    	    int counterCol = 1;    		
    		for(Column column : colStruct) {
    			if(column.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_818);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_819);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_822);
    
                    }    	
                    counterCol++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_828);
    
				}
			}
    
    		for(Column column:colStruct){
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_829);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_830);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
      
					if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_833);
    
                    }
                    	counterCol++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_834);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    stringBuffer.append(TEXT_835);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_838);
    
                    }    			    
    			    counterCol++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    
            }    
    		
    stringBuffer.append(TEXT_842);
    if (rejectConnName == null && useBatchSize && "mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_845);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    
    		  }
    stringBuffer.append(TEXT_848);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_854);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_855);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_856);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_857);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_858);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_859);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_861);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_863);
    
                        }
                        
    stringBuffer.append(TEXT_864);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_866);
    
                    } else {
                        
    stringBuffer.append(TEXT_867);
    
                    }
                } 
                
    stringBuffer.append(TEXT_868);
    
            } // end whether use batch
            
    
    	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
    		int columnIndex = 1;
    		for(Column column : colStruct) {
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_869);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_870);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
      
                    	columnIndex++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_871);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_872);
    
    			    columnIndex++;
    			}
    		}
    		
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    
    			int counterCol = 1;
    			for(Column column : colStruct) {
    				if(column.isUpdatable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_881);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_882);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_885);
    
                        }    				    
    				    counterCol++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_890);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_891);
    
					}
				}
    			for(Column column : colStruct) {
    				if(column.isUpdateKey()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    String dbType = column.getColumn().getType();
                        
     
	                    //#############for feature:2880
	                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_892);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_893);
      
		                     if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_896);
    
	                    	} 
	                    	counterCol++;
	                       }
	                     //#############                      
	                    
    stringBuffer.append(TEXT_897);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_898);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_901);
    
                        }    				    
    				    counterCol++;				    
    				}
    			}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    
                }    			
    			
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_910);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_911);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_912);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_913);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_914);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_916);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_918);
    
                            }
                            
    stringBuffer.append(TEXT_919);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_921);
    
                        } else {
                            
    stringBuffer.append(TEXT_922);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_923);
    
    			int counterInsert = 1;
    			for(Column columnInsert : colStruct)
    			{
    				if(columnInsert.isInsertable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_924);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_925);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_928);
    
                        }    				    
    				    counterInsert++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_929);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_933);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_936);
    
                }    			
    			
    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_941);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_942);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_943);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_944);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_945);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_946);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_948);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_950);
    
                            }
                            
    stringBuffer.append(TEXT_951);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_953);
    
                        } else {
                            
    stringBuffer.append(TEXT_954);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    
    	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_957);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_958);
    
    		int counterColUpdate = 1;
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_959);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_960);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_963);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_964);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_967);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_969);
    
				}
			}
    
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    String dbType = columnUpdate.getColumn().getType();
                    
    stringBuffer.append(TEXT_970);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && columnUpdate.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_971);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_974);
    
	                    	}
                    	counterColUpdate++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_975);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_976);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_979);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_980);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_981);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_982);
    
            }    		
    		
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_987);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_989);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_990);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_991);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_992);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_993);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_994);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_996);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_997);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_998);
    
                        }
                        
    stringBuffer.append(TEXT_999);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1001);
    
                    } else {
                        
    stringBuffer.append(TEXT_1002);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1004);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1006);
    
        		}
        		int counter = 1;
        		
        		for(Column column : colStruct) {
        			if(column.isInsertable()) {
        			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
        			    
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_1008);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1011);
    
                        }        			    
        			    counter++;
        			}
        		}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1016);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1019);
    
                }        		
        		
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1024);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1025);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1028);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1033);
    
                            }
                            
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1036);
    
                        } else {
                            
    stringBuffer.append(TEXT_1037);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1039);
    
    	
    	} else if (("DELETE").equals(dataAction)) {
    	    int keyCounter = 1;
    		for(Column column : colStruct) {
    			if(column.isDeleteKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1040);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1044);
    
	                    	}
                    	 keyCounter++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1046);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_1049);
    
                    }    			    
    			    keyCounter++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    
            }    		
        	
    stringBuffer.append(TEXT_1053);
    if (rejectConnName == null && useBatchSize && "mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1058);
    
    		  }
    stringBuffer.append(TEXT_1059);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1064);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1065);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1068);
    
                        for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1073);
    
                        }
                        
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1079);
    
                    } else {
                        
    stringBuffer.append(TEXT_1080);
    
                    }
                }
                
    stringBuffer.append(TEXT_1081);
    
            } // end whether use batch
            
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1083);
    
    	} else if(("REPLACE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "replaceSQLSplits_"));
    stringBuffer.append(TEXT_1087);
    
                    }                    
                    counter++;                        
                }       

            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1090);
    
            }            
            
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1095);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1096);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1099);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1104);
    
                        }
                        
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1110);
    
                    } else {
                        
    stringBuffer.append(TEXT_1111);
    
                    }
                }
                
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    
    	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1122);
    
                    }                    
                    counter++;                        
                }       

            }
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1126);
    
                    }                    
                    counter++;                   
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1129);
    
            }            
            
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1134);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1135);
    
                } else {
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
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1149);
    
                    } else {
                        
    stringBuffer.append(TEXT_1150);
    
                    }
                }
                
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1157);
    
    	}else if(("INSERT_IGNORE").equals(dataAction)) {
    	int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1161);
    
                        }                        
                        counter++;                        
                    }		

                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1164);
    
                }                
                
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1170);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_1171);
    
                    } else {
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1174);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1179);
    
                            }
                            
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1185);
    
                        } else {
                            
    stringBuffer.append(TEXT_1186);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1187);
    
    	}
    	
        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1189);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
                            
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1192);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1197);
                      
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1198);
    
        }	
        	//////////batch execute by batch size///////
    	if (extendedInsert && "mysql-connector-java-5.1.0-bin.jar".equals(dbVersion) && ("INSERT").equals(dataAction)) {
    		if(!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
    		
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1201);
    if ( (rejectConnName==null)) {
                
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1203);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1206);
    
            	    	}
            	    	
    stringBuffer.append(TEXT_1207);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1208);
    
                	}else {
                	
    stringBuffer.append(TEXT_1209);
    
                	}
    stringBuffer.append(TEXT_1210);
    
                }
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1212);
    	
    		}
    	
    	}
    	if (useBatchSize && "mysql-connector-java-5.1.0-bin.jar".equals(dbVersion) &&(rejectConnName==null)) {
    		if(!("").equals(batchSize) && !("0").equals(batchSize)) {
    		
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1215);
    if ( (rejectConnName==null) && (("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
                
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1217);
    
            	    	 if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1220);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1223);
    
            	    	}
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1225);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1226);
    
                	}else {
                	
    stringBuffer.append(TEXT_1227);
    
                	}
    stringBuffer.append(TEXT_1228);
    
                }
    stringBuffer.append(TEXT_1229);
    	
    		}
    	
    	}	
    	////////////commit every////////////
    	if(!("true").equals(useExistingConn)) {
    		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    		    
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1233);
    if ((rejectConnName==null && useBatchSize && "mysql-connector-java-5.1.0-bin.jar".equals(dbVersion)) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ) {
                
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1235);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1239);
    
            	    	}else if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1242);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1245);
    
            	    	}
    stringBuffer.append(TEXT_1246);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_1247);
    
                	}else {
                	
    stringBuffer.append(TEXT_1248);
    
                	}
    stringBuffer.append(TEXT_1249);
    
                }
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1252);
    
    		}
    	}
    }

    stringBuffer.append(TEXT_1253);
    return stringBuffer.toString();
  }
}
