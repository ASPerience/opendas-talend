package org.talend.designer.codegen.translators.system;

import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TRunJobMainJava
{
  protected static String nl;
  public static synchronized TRunJobMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMainJava result = new TRunJobMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.List<String> paraList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\tif(childJob_commandLine_Mapper_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ")==null){" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_12 = " - The child job named \" + ";
  protected final String TEXT_13 = " + \" is not in the job list.\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\tthrow new RuntimeException(\"The child job named \"+";
  protected final String TEXT_15 = "+\" is not in the job list.\");" + NL + "\t\t}" + NL + "\t\tparaList_";
  protected final String TEXT_16 = ".addAll(childJob_commandLine_Mapper_";
  protected final String TEXT_17 = ".get(";
  protected final String TEXT_18 = "));" + NL + "\t";
  protected final String TEXT_19 = NL + "\t        \t\t\tparaList_";
  protected final String TEXT_20 = ".add(";
  protected final String TEXT_21 = ");" + NL + "\t      \t\t\t";
  protected final String TEXT_22 = NL + "\t        \t\t\tparaList_";
  protected final String TEXT_23 = ".add(\"";
  protected final String TEXT_24 = "\");" + NL + "\t      \t\t\t";
  protected final String TEXT_25 = NL + "\t\t\tString osName_";
  protected final String TEXT_26 = " = System.getProperty(\"os.name\");" + NL + "\t\t\tif (osName_";
  protected final String TEXT_27 = " != null && osName_";
  protected final String TEXT_28 = ".toLowerCase().startsWith(\"win\")){" + NL + "\t      \t\t";
  protected final String TEXT_29 = NL + "\t\t      \t\t\tparaList_";
  protected final String TEXT_30 = ".add(\"";
  protected final String TEXT_31 = "\");" + NL + "\t\t      \t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_33 = ".add(dealChildJobLibrary_";
  protected final String TEXT_34 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_35 = "));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t      \t\t\t\t\tparaList_";
  protected final String TEXT_37 = ".add(";
  protected final String TEXT_38 = ");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t        \t\t\t\tparaList_";
  protected final String TEXT_40 = ".add(dealChildJobLibrary_";
  protected final String TEXT_41 = ".replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_42 = "\"));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t      \t\t\t\t\tparaList_";
  protected final String TEXT_44 = ".add(\"";
  protected final String TEXT_45 = "\");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t} else {" + NL + "\t      \t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\tparaList_";
  protected final String TEXT_48 = ".add(\"";
  protected final String TEXT_49 = "\");" + NL + "\t\t      \t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_51 = ".add(dealChildJobLibrary_";
  protected final String TEXT_52 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_53 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t        \t\t\t\tparaList_";
  protected final String TEXT_55 = ".add(";
  protected final String TEXT_56 = ".replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t     \t \t\t\t";
  protected final String TEXT_57 = NL + "\t\t      \t\t\t\t\tparaList_";
  protected final String TEXT_58 = ".add(dealChildJobLibrary_";
  protected final String TEXT_59 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_60 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_62 = ".add(";
  protected final String TEXT_63 = ");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t}    " + NL + "\t  \t";
  protected final String TEXT_65 = NL + "\t\t\tif(!\"\".equals(log4jLevel)){" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_66 = ".add(\"--log4jLevel=\"+log4jLevel);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t//for feature:10589" + NL + "\t";
  protected final String TEXT_68 = NL + "\t\tparaList_";
  protected final String TEXT_69 = ".add(\"--stat_port=\" + null);" + NL + "\t";
  protected final String TEXT_70 = NL + "\t\tparaList_";
  protected final String TEXT_71 = ".add(\"--stat_port=\" + portStats);" + NL + "\t";
  protected final String TEXT_72 = NL + NL + "\tif(resuming_logs_dir_path != null){" + NL + "\t\tparaList_";
  protected final String TEXT_73 = ".add(\"--resuming_logs_dir_path=\" + resuming_logs_dir_path);" + NL + "\t}" + NL + "\tString childResumePath_";
  protected final String TEXT_74 = " = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);" + NL + "\tString tRunJobName_";
  protected final String TEXT_75 = " = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);" + NL + "\tif(\"";
  protected final String TEXT_76 = "\".equals(tRunJobName_";
  protected final String TEXT_77 = ") && childResumePath_";
  protected final String TEXT_78 = " != null){" + NL + "\t\tparaList_";
  protected final String TEXT_79 = ".add(\"--resuming_checkpoint_path=\" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));" + NL + "\t}" + NL + "\tparaList_";
  protected final String TEXT_80 = ".add(\"--parent_part_launcher=JOB:\" + jobName + \"/NODE:";
  protected final String TEXT_81 = "\");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> parentContextMap_";
  protected final String TEXT_82 = " = new java.util.HashMap<String, Object>();" + NL + "" + NL + "\t";
  protected final String TEXT_83 = NL + "\t\t";
  protected final String TEXT_84 = " " + NL + "\t\t";
  protected final String TEXT_85 = ".synchronizeContext();" + NL + "\t\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ".propertyNames();" + NL + "\t\twhile (propertyNames_";
  protected final String TEXT_88 = ".hasMoreElements()) {" + NL + "\t\t\tString key_";
  protected final String TEXT_89 = " = (String) propertyNames_";
  protected final String TEXT_90 = ".nextElement();" + NL + "\t\t\tObject value_";
  protected final String TEXT_91 = " = (Object) ";
  protected final String TEXT_92 = ".get(key_";
  protected final String TEXT_93 = ");       " + NL + "\t\t\tparaList_";
  protected final String TEXT_94 = ".add(\"--context_param \" + key_";
  protected final String TEXT_95 = " + \"=\" + value_";
  protected final String TEXT_96 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_97 = "  " + NL + "\t\t\tparentContextMap_";
  protected final String TEXT_98 = ".put(\"";
  protected final String TEXT_99 = "\", ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ");" + NL + "\t\t";
  protected final String TEXT_102 = NL + NL + "\tObject obj_";
  protected final String TEXT_103 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\tobj_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL + "\t\tparaList_";
  protected final String TEXT_107 = ".add(\"--context_param ";
  protected final String TEXT_108 = "=\" + RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_109 = "));" + NL + "\t\tparentContextMap_";
  protected final String TEXT_110 = ".put(\"";
  protected final String TEXT_111 = "\", obj_";
  protected final String TEXT_112 = ");" + NL + "\t";
  protected final String TEXT_113 = NL + "\t";
  protected final String TEXT_114 = NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_115 = " in ";
  protected final String TEXT_116 = " call ";
  protected final String TEXT_117 = "\"+";
  protected final String TEXT_118 = "+\"";
  protected final String TEXT_119 = " with:\\n\\n\" + paraList_";
  protected final String TEXT_120 = " + \"\\n\");" + NL + "\t";
  protected final String TEXT_121 = NL + "\t\t";
  protected final String TEXT_122 = " childJob_";
  protected final String TEXT_123 = " = new ";
  protected final String TEXT_124 = "();" + NL + "\t    // pass DataSources" + NL + "\t    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_";
  protected final String TEXT_125 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap" + NL + "\t            .get(KEY_DB_DATASOURCES);" + NL + "\t    if (null != talendDataSources_";
  protected final String TEXT_126 = ") {" + NL + "\t        java.util.Map<String, javax.sql.DataSource> dataSources_";
  protected final String TEXT_127 = " = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "\t        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_";
  protected final String TEXT_128 = " : talendDataSources_";
  protected final String TEXT_129 = NL + "\t\t\t        .entrySet()) {" + NL + "\t            dataSources_";
  protected final String TEXT_130 = ".put(talendDataSourceEntry_";
  protected final String TEXT_131 = ".getKey()," + NL + "\t                    talendDataSourceEntry_";
  protected final String TEXT_132 = ".getValue().getRawDataSource());" + NL + "\t        }" + NL + "\t        childJob_";
  protected final String TEXT_133 = ".setDataSources(dataSources_";
  protected final String TEXT_134 = ");" + NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_135 = "  " + NL + "\t\t\tchildJob_";
  protected final String TEXT_136 = ".parentContextMap = parentContextMap_";
  protected final String TEXT_137 = ";" + NL + "\t\t";
  protected final String TEXT_138 = "  " + NL + "\t\t";
  protected final String TEXT_139 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_140 = " - The child job '";
  protected final String TEXT_141 = "\"+";
  protected final String TEXT_142 = "+\"";
  protected final String TEXT_143 = "' starts on the version '";
  protected final String TEXT_144 = "' with the context '";
  protected final String TEXT_145 = "'.\");" + NL + "\t\t";
  protected final String TEXT_146 = NL + "\t\tString[][] childReturn_";
  protected final String TEXT_147 = " = childJob_";
  protected final String TEXT_148 = ".runJob((String[]) paraList_";
  protected final String TEXT_149 = ".toArray(new String[paraList_";
  protected final String TEXT_150 = ".size()]));" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_152 = " - The child job '";
  protected final String TEXT_153 = "\"+";
  protected final String TEXT_154 = "+\"";
  protected final String TEXT_155 = "' is done.\");" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t  \t";
  protected final String TEXT_157 = NL + "\t\t\t\t((java.util.Map)threadLocal.get()).put(\"errorCode\", childJob_";
  protected final String TEXT_158 = ".getErrorCode());" + NL + "\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\terrorCode = childJob_";
  protected final String TEXT_160 = ".getErrorCode();" + NL + "\t\t    ";
  protected final String TEXT_161 = NL + "\t            " + NL + "\t    \tif(childJob_";
  protected final String TEXT_162 = ".getErrorCode() == null){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_163 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_164 = ".getStatus() != null && (\"failure\").equals(childJob_";
  protected final String TEXT_165 = ".getStatus()) ? 1 : 0);" + NL + "\t    \t}else{" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_166 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_167 = ".getErrorCode());" + NL + "\t\t    }" + NL + "\t\t    if (childJob_";
  protected final String TEXT_168 = ".getExceptionStackTrace() != null) { " + NL + "\t\t    \tglobalMap.put(\"";
  protected final String TEXT_169 = "_CHILD_EXCEPTION_STACKTRACE\", childJob_";
  protected final String TEXT_170 = ".getExceptionStackTrace());" + NL + "\t\t    }" + NL + "\t  " + NL + "\t\t\t";
  protected final String TEXT_171 = " " + NL + "\t\t\t\tif (childJob_";
  protected final String TEXT_172 = ".getErrorCode() != null || (\"failure\").equals(childJob_";
  protected final String TEXT_173 = ".getStatus())) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_175 = " - The child job '";
  protected final String TEXT_176 = "\"+";
  protected final String TEXT_177 = "+\"";
  protected final String TEXT_178 = "' has failed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t        \t\tthrow new RuntimeException(\"Child job running failed\");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_180 = NL + "\t  \t";
  protected final String TEXT_181 = NL + "\t\t\tfor (String[] item_";
  protected final String TEXT_182 = " : childReturn_";
  protected final String TEXT_183 = ") { " + NL + "\t\t\t\tif(childJob_";
  protected final String TEXT_184 = ".hastBufferOutputComponent() || ";
  protected final String TEXT_185 = "){" + NL + "\t\t\t    \t";
  protected final String TEXT_186 = "\t\t" + NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_187 = " < item_";
  protected final String TEXT_188 = ".length){\t\t\t\t" + NL + "\t\t\t           \t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t           \t\t";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = " = item_";
  protected final String TEXT_192 = "[";
  protected final String TEXT_193 = "];" + NL + "\t\t\t           \t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t           \t\t";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " = ParserUtils.parseTo_Date(item_";
  protected final String TEXT_197 = "[";
  protected final String TEXT_198 = "], ";
  protected final String TEXT_199 = ");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_200 = "\t\t\t\t\t\t\t" + NL + "\t\t\t           \t\t\t";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " = item_";
  protected final String TEXT_203 = "[";
  protected final String TEXT_204 = "].getBytes();" + NL + "\t\t\t           \t\t";
  protected final String TEXT_205 = NL + "\t\t\t           \t\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = ParserUtils.parseTo_";
  protected final String TEXT_208 = "(item_";
  protected final String TEXT_209 = "[";
  protected final String TEXT_210 = "], \",\");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_211 = NL + "\t\t\t           \t\t\t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ParserUtils.parseTo_";
  protected final String TEXT_214 = "(item_";
  protected final String TEXT_215 = "[";
  protected final String TEXT_216 = "]);" + NL + "\t\t\t           \t\t";
  protected final String TEXT_217 = NL + "\t\t           \t\t}else{" + NL + "\t\t\t           \t\t";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = " = ";
  protected final String TEXT_220 = ";" + NL + "\t\t           \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " = ";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_228 = NL + "\t\tRuntime runtime_";
  protected final String TEXT_229 = " = Runtime.getRuntime();" + NL + "\t\tfinal Process ps_";
  protected final String TEXT_230 = ";" + NL + "\t\tps_";
  protected final String TEXT_231 = " = runtime_";
  protected final String TEXT_232 = ".exec((String[])paraList_";
  protected final String TEXT_233 = ".toArray(new String[paraList_";
  protected final String TEXT_234 = ".size()]));" + NL + "" + NL + "\t\tThread normal_";
  protected final String TEXT_235 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_236 = ".getInputStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\tSystem.out.println(line);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_238 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_239 = NL + "\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t    \t}" + NL + "  \t\t};" + NL + "\t\t";
  protected final String TEXT_240 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_241 = " - The child job '";
  protected final String TEXT_242 = "\"+";
  protected final String TEXT_243 = "+\"";
  protected final String TEXT_244 = "' starts on the version '";
  protected final String TEXT_245 = "' with the context '";
  protected final String TEXT_246 = "'.\");" + NL + "\t\t";
  protected final String TEXT_247 = NL + "\t\tnormal_";
  protected final String TEXT_248 = ".start();" + NL + "\t\t";
  protected final String TEXT_249 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_250 = " - The child job '";
  protected final String TEXT_251 = "\"+";
  protected final String TEXT_252 = "+\"";
  protected final String TEXT_253 = "' is done.\");" + NL + "\t\t";
  protected final String TEXT_254 = NL + NL + "\t\tfinal StringBuffer errorMsg_";
  protected final String TEXT_255 = " = new StringBuffer();" + NL + "\t\tThread error_";
  protected final String TEXT_256 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_257 = ".getErrorStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "        \t\t\ttry {" + NL + "          \t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "            \t\t\t\terrorMsg_";
  protected final String TEXT_258 = ".append(line).append(\"\\n\");" + NL + "          \t\t\t\t}" + NL + "        \t\t\t} finally {" + NL + "          \t\t\t\treader.close();" + NL + "        \t\t\t}" + NL + "      \t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_260 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_261 = NL + "\t\t\t        ioe.printStackTrace();" + NL + "      \t\t\t}" + NL + "    \t\t}" + NL + "\t\t};" + NL + "\t\terror_";
  protected final String TEXT_262 = ".start();" + NL + "" + NL + "\t\t//0 indicates normal termination\t" + NL + "\t\tint result_";
  protected final String TEXT_263 = " = ps_";
  protected final String TEXT_264 = ".waitFor();" + NL + "\t\tnormal_";
  protected final String TEXT_265 = ".join(10000);" + NL + "\t\terror_";
  protected final String TEXT_266 = ".join(10000);" + NL + "  " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_267 = "_CHILD_RETURN_CODE\",result_";
  protected final String TEXT_268 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_269 = " != 0){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_270 = "_CHILD_EXCEPTION_STACKTRACE\",errorMsg_";
  protected final String TEXT_271 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_272 = "  " + NL + "\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_274 = " - Child job returns \" + result_";
  protected final String TEXT_275 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_276 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_277 = NL + "\t    \t\tthrow new RuntimeException(\"Child job returns \" + result_";
  protected final String TEXT_278 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_279 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_282 = " - Child job returns \" + result_";
  protected final String TEXT_283 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_284 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\tSystem.err.println(\"Child job returns \" + result_";
  protected final String TEXT_286 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_287 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_288 = NL + "  \t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_291 = " - Child job returns \" + result_";
  protected final String TEXT_292 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_293 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_294 = NL + "  \t\t\t\tSystem.err.println(\"when tRunJob runs in an independent process, it can't extract datas from tBufferOutput of child job.\"); " + NL + "\t\t\t";
  protected final String TEXT_295 = NL + "\t";
  protected final String TEXT_296 = NL + "\t\tlog.info(\"";
  protected final String TEXT_297 = " - Done.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        columns = metadata.getListColumns();
    }
}
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
//if tRunJob is the first node, it can get the return values of the child job.
//if tRunJob is middle node of the FLOW link, it will be data_auto_propagate=true 
List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_CHILD_ERROR__"));  
boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();  
boolean transmitWholeContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_WHOLE_CONTEXT__"));  
boolean printParameter = ("true").equals(ElementParameterParser.getValue(node, "__PRINT_PARAMETER__")); 

boolean originalContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_ORIGINAL_CONTEXT__")); 

IProcess currentProcess = node.getProcess();
List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
String version = ElementParameterParser.getValue(node,"__PROCESS_TYPE_VERSION__");
String[] codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
String[] commandLineWindows = new String[] {"<command>"};
String[] commandLineUnix = new String[] {"<command>"};
String[] commandLine = new String[] {"<command>"};
String childJob = ElementParameterParser.getValue(node,"__PROCESS__");

boolean isPropagateChildResult = ("true").equals(ElementParameterParser.getValue(node, "__PROPAGATE_CHILD_RESULT__"));

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
String dynamicJobName = ElementParameterParser.getValue(node,"__CONTEXT_JOB__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean propagateData = false;
Set<String> inputCols = new HashSet<String>();
String inputConnName = null;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
	//For TDI-28558

	List<IMetadataColumn> inputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	List<IMetadataColumn> outputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = incomingConn.getName();
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputMetadataColumn.add(inputCol);
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}
	if(node.getOutgoingConnections()!=null) {
		for (IConnection outputConn : node.getOutgoingConnections()) {
			if (outputConn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
				IMetadataTable outputMetadataTable = outputConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					outputMetadataColumn.add(outputCol);
				}
			}
		}
	}
	if(inputMetadataColumn!=null && outputMetadataColumn!=null){
		if(inputMetadataColumn.size() == outputMetadataColumn.size()){
			int size = inputMetadataColumn.size();
			for(int i = 0;i< size; i++){
				if(!inputMetadataColumn.get(i).getLabel().equals(outputMetadataColumn.get(i).getLabel()) ||
				   !inputMetadataColumn.get(i).getTalendType().equals(outputMetadataColumn.get(i).getTalendType())){
					propagateData = false;
					break;
				}else{
					propagateData = true;
				}
			}
		}
	}
	if(useDynamicJob || useIndependentProcess || !isPropagateChildResult){
		if (propagateData) {
			for (IConnection conn : node.getOutgoingConnections()) {
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
					IMetadataTable outputMetadataTable = conn.getMetadataTable();
					if (outputMetadataTable!=null) {
						for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
							if (inputCols.contains(outputCol.getLabel())) {
							
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_7);
    
							}
						}
					}
					break;
				}
			}
		}
	}
	
	if(useDynamicJob){
		useIndependentProcess = true;
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_18);
    
	}else{
		try {
			if(useIndependentProcess){
		    	commandLineWindows = ProcessorUtilities.getCommandLine("win32",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
		    	// remove the 2 fist lines
		    	if (commandLineWindows.length > 0 && ProcessorUtilities.isExportConfig()){
		    		int tmpSize = commandLineWindows.length - 2;
		    		String[] tmp = new String[tmpSize];
		    		System.arraycopy(commandLineWindows, 2, tmp, 0, tmpSize);
		    		commandLineWindows = tmp;
	    		}
		    	commandLineUnix = ProcessorUtilities.getCommandLine("linux",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
	    		// remove the 2 first lines
				if (commandLineUnix.length > 0 && ProcessorUtilities.isExportConfig()){
					int tmpSize = commandLineUnix.length - 2;
					String[] tmp = new String[tmpSize];
					System.arraycopy(commandLineUnix, 2, tmp, 0, tmpSize);
					commandLineUnix = tmp;
				}
			}else{
		    	commandLine = ProcessorUtilities.getMainCommand(process,version, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);  
			}
		} catch (ProcessorException e) {
		}


		if (!useIndependentProcess) {
			for (int i = 0; i < commandLine.length; i++) {
				if (i == 0){
					childJob = commandLine[0];
				} else if (i > 0){
					if (commandLine[i].indexOf("\"") >= 0){
	      			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_21);
    }else{
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_24);
    }
	    		}
	  		}
		} else {
	  	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
				for (int i = 0; i < commandLineWindows.length; i++) {
					if (i == 0){
		     	 	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(commandLineWindows[i]);
    stringBuffer.append(TEXT_31);
    
					} else if (i > 0){
		      			if (commandLineWindows[i].indexOf("\"") >= 0){
							if(commandLineWindows[i].indexOf(".jar")>=0){
		      				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_35);
    
							}else{
		      				
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_38);
    
		          			}
		      			}else{
		          			if(commandLineWindows[i].indexOf(".jar")>=0){
              				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_42);
    
		          			}else{
              				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_45);
    
		          			}
		      			}	
		    		}
		  		}
		  		
    stringBuffer.append(TEXT_46);
    
				for (int i = 0; i < commandLineUnix.length; i++) {
					if (i == 0){
		      		
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(commandLineUnix[i]);
    stringBuffer.append(TEXT_49);
    
		    		} else if (i > 0){
		      			String param;
						if (commandLineUnix[i].indexOf("\"") >= 0){
							param = commandLineUnix[i];
						} else {
							param = "\""+commandLineUnix[i]+"\"";
						}
						if (param.contains("$ROOT_PATH")) {
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_53);
    }else{
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_56);
    
		      				}
		      			}else{
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_60);
    }else{
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_63);
    			
		      				}
		      			}	
	    			}
		  		}
		  		
    stringBuffer.append(TEXT_64);
    
		}
		if(isLog4jEnabled){//For TDI-27659
		
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
		}
	}
	
    stringBuffer.append(TEXT_67);
    if(useIndependentProcess){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    }else{
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	List<? extends IConnection> iterateConns = node.getIncomingConnections(EConnectionType.ITERATE);
	if(iterateConns != null)  { 
		iterateConnSet.addAll(iterateConns);
	}
	boolean parallelIterate = false;
	for (IConnection iterateConn : iterateConnSet) {
		parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	}
	if(transmitWholeContext){//111111
	
    stringBuffer.append(TEXT_83);
     
		//bug21906
		String localContext = "context";
		if(parallelIterate) {
			localContext = "localContext";
		}
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
		for (IContextParameter ctxParam :params){
			String ctxParamName = ctxParam.getName();
 			
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_101);
    
		}
	}//111111
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
	for (int i=0; i<contextParams.size(); i++) {
		Map<String, String> contextParam = contextParams.get(i);
		String name = contextParam.get("PARAM_NAME_COLUMN");
		String value = contextParam.get("PARAM_VALUE_COLUMN");
		//bug22181
		if(parallelIterate && value!=null && value.contains("context.")) {
			value = value.replace("context.","localContext.");
		}
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
	}
	
    stringBuffer.append(TEXT_113);
    if(printParameter){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_116);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	if (!useIndependentProcess){//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if(originalContext){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_141);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_153);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    
		if (childJob != null) {
	    	if (isRunInMultiThread){
    		
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    }else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    if (dieOnError) { 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_176);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    }
		}
    stringBuffer.append(TEXT_180);
    

		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)){
	      			firstConnName = conn.getName(); //get the first available flow link
	      			break;
	      		}
	    	}
		}
		boolean inConnNull = false;
		if(inConns == null || inConns.size() == 0) {
			inConnNull = true; 
		}
		if(firstConnName != null && (isPropagateChildResult || inConnNull)) {//b
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	    	
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(inConnNull);
    stringBuffer.append(TEXT_185);
    
					int columnSize = columns.size();
					for (int i = 0; i < columnSize; i++) {//a
						IMetadataColumn column = columns.get(i);
						String label = column.getLabel();
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			        	
    stringBuffer.append(TEXT_186);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_193);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_199);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_200);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_204);
    }else if(javaType == JavaTypesManager.LIST) {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_210);
    } else {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_220);
    
					}//a
					if (inConnNull==false && propagateData) {//d
					
    stringBuffer.append(TEXT_221);
    
						for (IConnection conn : node.getOutgoingConnections()) {
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
								IMetadataTable outputMetadataTable = conn.getMetadataTable();
								if (outputMetadataTable!=null) {
									for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
										if (inputCols.contains(outputCol.getLabel())) {
										
    stringBuffer.append(TEXT_222);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_226);
    
										}
									}
								}
								break;
							}
						}
					}//d
					
    stringBuffer.append(TEXT_227);
    
		}//b  
	} else { //AAAAAAAAAAAA

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	// use independent process to run subjob
	
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_242);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_246);
    }
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_251);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_252);
    }
    stringBuffer.append(TEXT_253);
    }
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    if (dieOnError) { 
    stringBuffer.append(TEXT_272);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    }
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    }else{
    stringBuffer.append(TEXT_280);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    }
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    
		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
					firstConnName = conn.getName(); //get the first available flow link
					break;
				}
			}
		}
		if(firstConnName != null) {//b
	    	if(inConns == null || inConns.size() == 0){//c
			
    stringBuffer.append(TEXT_289);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    }
    stringBuffer.append(TEXT_294);
    
			}//c
		}//b  
	}//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_295);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    }
    return stringBuffer.toString();
  }
}
