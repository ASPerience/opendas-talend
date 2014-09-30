package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveRowBeginJava
{
  protected static String nl;
  public static synchronized THiveRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowBeginJava result = new THiveRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");";
  protected final String TEXT_3 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_6 = " - Driver ClassName: ";
  protected final String TEXT_7 = ".\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_11 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_15 = " = log4jDebugParamters_";
  protected final String TEXT_16 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_17 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_22 = " = log4jDebugParamters_";
  protected final String TEXT_23 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_24 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_29 = " = log4jDebugParamters_";
  protected final String TEXT_30 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_31 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_36 = " = log4jDebugParamters_";
  protected final String TEXT_37 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_38 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_43 = " = log4jDebugParamters_";
  protected final String TEXT_44 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_45 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_48 = " = log4jDebugParamters_";
  protected final String TEXT_49 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_50 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_53 = " = log4jDebugParamters_";
  protected final String TEXT_54 = " + \"DBVERSION = ";
  protected final String TEXT_55 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_60 = " = log4jDebugParamters_";
  protected final String TEXT_61 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_65 = " = log4jDebugParamters_";
  protected final String TEXT_66 = " + \"USE_CURSOR = ";
  protected final String TEXT_67 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_70 = " = log4jDebugParamters_";
  protected final String TEXT_71 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_72 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_75 = " = log4jDebugParamters_";
  protected final String TEXT_76 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_77 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_82 = " = log4jDebugParamters_";
  protected final String TEXT_83 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_84 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_89 = " = log4jDebugParamters_";
  protected final String TEXT_90 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_91 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_93 = " = \"";
  protected final String TEXT_94 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_95 = ";";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_99 = " = null;";
  protected final String TEXT_100 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_101 = "); ";
  protected final String TEXT_102 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\tconn_";
  protected final String TEXT_105 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_106 = "\");" + NL + "\t\t" + NL + "\t\tString dbname_";
  protected final String TEXT_107 = " = (String)globalMap.get(\"";
  protected final String TEXT_108 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_109 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_110 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_111 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_112 = " = conn_";
  protected final String TEXT_113 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_114 = ".execute(\"use \" + dbname_";
  protected final String TEXT_115 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_116 = ".close();" + NL + "    \t}" + NL + "    \t" + NL + "    \tString dbUser_";
  protected final String TEXT_117 = " = (String)globalMap.get(\"";
  protected final String TEXT_118 = "\");" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_119 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_120 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_121 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_123 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "    \t\t    \tlog.fatal(\"";
  protected final String TEXT_126 = " - The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "    \t\t    ";
  protected final String TEXT_127 = NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_128 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_129 = " ,";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_132 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_133 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_134 = ");" + NL + "\t        " + NL + "    \t\t";
  protected final String TEXT_135 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_136 = " " + NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_137 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_138 = ");" + NL + "   \t\t \t";
  protected final String TEXT_139 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = "; " + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t   \t" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_143 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_144 = ");\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_151 = "\", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\tString dbUser_";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = ";" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t\t";
  protected final String TEXT_157 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_158 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = "; ";
  protected final String TEXT_163 = NL + "\t\tString dbPwd_";
  protected final String TEXT_164 = " = decryptedPassword_";
  protected final String TEXT_165 = ";" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_166 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_167 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_168 = " + \":\" + ";
  protected final String TEXT_169 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_170 = " = \"jdbc:";
  protected final String TEXT_171 = "://\";";
  protected final String TEXT_172 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_173 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_174 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_175 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_176 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_177 = NL + "\t\t\t\tString url_";
  protected final String TEXT_178 = " = \"jdbc:";
  protected final String TEXT_179 = "://\" + ";
  protected final String TEXT_180 = " + \":\" + ";
  protected final String TEXT_181 = " + \"/\" + ";
  protected final String TEXT_182 = " + \";principal=\" + ";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL + "\t\t\t\tString url_";
  protected final String TEXT_185 = " = \"jdbc:";
  protected final String TEXT_186 = "://\" + ";
  protected final String TEXT_187 = " + \":\" + ";
  protected final String TEXT_188 = " + \"/\" + ";
  protected final String TEXT_189 = ";";
  protected final String TEXT_190 = NL + "\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_191 = "\");" + NL + "\t\t";
  protected final String TEXT_192 = "\t" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_194 = " - Connection attempt to '\" + url_";
  protected final String TEXT_195 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_196 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_197 = NL + "\t\t\tconn_";
  protected final String TEXT_198 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t\t\tconn_";
  protected final String TEXT_201 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_202 = ", dbUser_";
  protected final String TEXT_203 = ", dbPwd_";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\t";
  protected final String TEXT_206 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_207 = " - Connection to '\" + url_";
  protected final String TEXT_208 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_209 = NL + "\t\t" + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_210 = " = conn_";
  protected final String TEXT_211 = ".createStatement();";
  protected final String TEXT_212 = NL + "        \tinit_";
  protected final String TEXT_213 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_214 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_215 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "\t\tinit_";
  protected final String TEXT_218 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL + "\t\t\tinit_";
  protected final String TEXT_221 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = NL + "\t\t\tinit_";
  protected final String TEXT_224 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_225 = ");";
  protected final String TEXT_226 = NL + "        \t\tinit_";
  protected final String TEXT_227 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_228 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "\t\t\t\tinit_";
  protected final String TEXT_231 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_232 = ");";
  protected final String TEXT_233 = NL + "\t\t\t\tinit_";
  protected final String TEXT_234 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_235 = ");";
  protected final String TEXT_236 = NL + "\t\t\t\tinit_";
  protected final String TEXT_237 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_238 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_239 = NL + "        \t\t//set default yarn classpath with environment variable" + NL + "        \t\tinit_";
  protected final String TEXT_240 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_241 = NL + "    \t\t\tinit_";
  protected final String TEXT_242 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_243 = NL + "    \t\t\tinit_";
  protected final String TEXT_244 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_245 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_246 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_247 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_248 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "\t\t\t\tinit_";
  protected final String TEXT_251 = ".execute(\"SET \"+";
  protected final String TEXT_252 = "+\"=\"+";
  protected final String TEXT_253 = ");";
  protected final String TEXT_254 = NL + "\t\tinit_";
  protected final String TEXT_255 = ".close();" + NL + "\t\t" + NL + "    \tString dbname_";
  protected final String TEXT_256 = " = ";
  protected final String TEXT_257 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_258 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_259 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_260 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_261 = " = conn_";
  protected final String TEXT_262 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_263 = ".execute(\"use \" + dbname_";
  protected final String TEXT_264 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_265 = ".close();" + NL + "    \t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_266 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_267 = " = conn_";
  protected final String TEXT_268 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_269 = NL + "    \t\t\tstatement_";
  protected final String TEXT_270 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_271 = ");" + NL + "    \t\t";
  protected final String TEXT_272 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_273 = NL + "        \t\tstatement_";
  protected final String TEXT_274 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_275 = ");" + NL + "        \t";
  protected final String TEXT_276 = NL + "        \t" + NL + "\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_278 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_279 = ");" + NL + "\t\t\t";
  protected final String TEXT_280 = "        \t" + NL + "    \t" + NL + "        \t";
  protected final String TEXT_281 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_282 = ".execute(\"add jar \"+";
  protected final String TEXT_283 = ");" + NL + "    \t\t";
  protected final String TEXT_284 = NL + "    \t\tstatement_";
  protected final String TEXT_285 = ".close();";
  protected final String TEXT_286 = NL;
  protected final String TEXT_287 = NL + "        if(conn_";
  protected final String TEXT_288 = ".getAutoCommit()) {" + NL + "            conn_";
  protected final String TEXT_289 = ".setAutoCommit(false);" + NL + "        }        " + NL + "        int commitEvery_";
  protected final String TEXT_290 = " = ";
  protected final String TEXT_291 = ";" + NL + "        int commitCounter_";
  protected final String TEXT_292 = " = 0;";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_295 = " = conn_";
  protected final String TEXT_296 = ".prepareStatement(";
  protected final String TEXT_297 = ");\t";
  protected final String TEXT_298 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_299 = " = conn_";
  protected final String TEXT_300 = ".createStatement();";
  protected final String TEXT_301 = NL + "String query_";
  protected final String TEXT_302 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_303 = " = false;";
  protected final String TEXT_304 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
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

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_96);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");

    String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");//hive jdbc not support setAutoCommit
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	log4jCodeGenerateUtil.infoComponentStart(node);

    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_100);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_101);
     
	}
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_102);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_103);
    
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
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
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
		
		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
    	
    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
    	
    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
		
		boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
		
		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "MAPR310".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion)))) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}
		
		if(!isCustom && (("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
		 || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
		  || ("HDP_2_1".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode))
		   || ("MapR_EMR".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_124);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    
		}
		
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_130);
    
			} 
		}
		
		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_131);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_134);
    
    		String passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_135);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_138);
    } else {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_144);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_147);
    
			}
		}
		
		if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"PIVOTAL_HD_2_0".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"HDP_2_1".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion) && !"Cloudera_CDH5".equals(hiveVersion))) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_148);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_149);
    
		}
		
		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_150);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_152);
    
		}		

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_155);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_156);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_159);
    } else {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_171);
    
			if(isCustom || (!isCustom && ("HDP_1_0,HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
			}
		} else {
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_183);
    
			} else {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_189);
    
			}
		}

    stringBuffer.append(TEXT_190);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_191);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node,javaDbDriver);	
		
    stringBuffer.append(TEXT_192);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    
		} else {

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
		}

    stringBuffer.append(TEXT_205);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_216);
    
	}
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion));
		
	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_219);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_222);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_225);
    
		}

	}
		
    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
		
    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_229);
    
			}
		
    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_232);
    
			}
			
    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_235);
    
			}
		
			if("EMBEDDED".equals(connectionMode)) {
				if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
				} else {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
				}
				
    			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
    			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
				}
			}
		
    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_249);
    
			}
		}
		
		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_253);
    
			}
		}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_283);
    
    			}
    		}

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
	  	}
	}

    stringBuffer.append(TEXT_286);
    
if(!("true").equals(useExistingConn)) {
    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
    }
}

    stringBuffer.append(TEXT_293);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_297);
    
	} else {

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    
	}

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(TEXT_304);
    return stringBuffer.toString();
  }
}
