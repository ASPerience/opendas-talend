package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");";
  protected final String TEXT_4 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_7 = " = SharedDBConnection.getDBConnection(\"";
  protected final String TEXT_8 = "\",url_";
  protected final String TEXT_9 = ",userName_";
  protected final String TEXT_10 = " , password_";
  protected final String TEXT_11 = " , sharedConnectionName_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tconn_";
  protected final String TEXT_14 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_15 = ",userName_";
  protected final String TEXT_16 = ",password_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\tconn_";
  protected final String TEXT_19 = ".setAutoCommit(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = NL + "\t\t\t\tconn_";
  protected final String TEXT_23 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\t\t\tSystem.setProperty(";
  protected final String TEXT_27 = " ,";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_32 = ");" + NL + "\t        " + NL + "        \t\t";
  protected final String TEXT_33 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_34 = " " + NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_35 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_36 = ");" + NL + "       \t\t \t";
  protected final String TEXT_37 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = "; " + NL + "    \t\t\t";
  protected final String TEXT_40 = NL + "        \t   \t" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_42 = ");\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_49 = "\", ";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_52 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_53 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_54 = " + \":\" + ";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_56 = " = \"jdbc:";
  protected final String TEXT_57 = "://\";";
  protected final String TEXT_58 = NL + "\t\t\t\t\tString dbUser_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\tif(dbUser_";
  protected final String TEXT_61 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_62 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"dbUser_";
  protected final String TEXT_65 = "\",dbUser_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_67 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_68 = " = \"jdbc:";
  protected final String TEXT_69 = "://\" + ";
  protected final String TEXT_70 = " + \":\" + ";
  protected final String TEXT_71 = " + \"/\" + ";
  protected final String TEXT_72 = " + \";principal=\" + ";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_75 = " = \"jdbc:";
  protected final String TEXT_76 = "://\" + ";
  protected final String TEXT_77 = " + \":\" + ";
  protected final String TEXT_78 = " + \"/\" + ";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "\t\t\tconn_";
  protected final String TEXT_81 = ".setAutoCommit(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + NL + "\t";
  protected final String TEXT_84 = NL + NL + "\tString userName_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "\t";
  protected final String TEXT_88 = NL + "\t\tString password_";
  protected final String TEXT_89 = " = \"null\";" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_92 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = "; ";
  protected final String TEXT_97 = NL + "\t\tString password_";
  protected final String TEXT_98 = " = decryptedPassword_";
  protected final String TEXT_99 = ";" + NL + "\t";
  protected final String TEXT_100 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_101 = " = null;" + NL;
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_104 = ")) {";
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_108 = "\", conn_";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t}";
  protected final String TEXT_111 = NL + "\tif (null != conn_";
  protected final String TEXT_112 = ") {" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t}";
  protected final String TEXT_114 = NL;
  protected final String TEXT_115 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_116 = ");" + NL + "\t" + NL + "\tjava.sql.Statement init_";
  protected final String TEXT_117 = " = conn_";
  protected final String TEXT_118 = ".createStatement();";
  protected final String TEXT_119 = NL + "        init_";
  protected final String TEXT_120 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_121 = ");" + NL + "\t    init_";
  protected final String TEXT_122 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\tinit_";
  protected final String TEXT_125 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\t\t\tinit_";
  protected final String TEXT_128 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t\tinit_";
  protected final String TEXT_131 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "    \t\tinit_";
  protected final String TEXT_134 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "    \t\tinit_";
  protected final String TEXT_135 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t\t\tinit_";
  protected final String TEXT_138 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "\t\t\tinit_";
  protected final String TEXT_141 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\t\t\tinit_";
  protected final String TEXT_144 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");" + NL + "\t\t\tinit_";
  protected final String TEXT_145 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_146 = NL + "    \t\t//set default yarn classpath with environment variable" + NL + "    \t\tinit_";
  protected final String TEXT_147 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_148 = NL + "    \t\tinit_";
  protected final String TEXT_149 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_150 = NL + "\t\t\tinit_";
  protected final String TEXT_151 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_152 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_153 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_154 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_155 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "\t\t\tinit_";
  protected final String TEXT_158 = ".execute(\"SET \"+";
  protected final String TEXT_159 = "+\"=\"+";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "\tinit_";
  protected final String TEXT_162 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_163 = NL + "\t\tjava.sql.Statement statement_";
  protected final String TEXT_164 = " = conn_";
  protected final String TEXT_165 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\t\tstatement_";
  protected final String TEXT_167 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_168 = ");" + NL + "\t\t";
  protected final String TEXT_169 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_170 = NL + "\t\t\tstatement_";
  protected final String TEXT_171 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_172 = ");" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tstatement_";
  protected final String TEXT_175 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_176 = ");" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_179 = ".execute(\"add jar \"+";
  protected final String TEXT_180 = ");" + NL + "\t\t";
  protected final String TEXT_181 = NL + "\t\tstatement_";
  protected final String TEXT_182 = ".close();" + NL + "\t";
  protected final String TEXT_183 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_184 = "\",conn_";
  protected final String TEXT_185 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_186 = "\",";
  protected final String TEXT_187 = ");" + NL + "\t" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_188 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_189 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_190 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString currentClientUsername_";
  protected final String TEXT_191 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\tif(currentClientUsername_";
  protected final String TEXT_192 = "!=null) {" + NL + "\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_193 = ");" + NL + "\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_194 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_195 = "\");" + NL + "\tif(originalHadoopUsername_";
  protected final String TEXT_196 = "!=null) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_197 = ");" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_198 = "\", null);" + NL + "\t} else {" + NL + "\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_20);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    stringBuffer.append(TEXT_21);
    

	class ConnectionUtil extends DefaultConnectionUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		
		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			} else {
				super.createConnection(node);
			}
		}
	
		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			
			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
			
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || cdhCanBeSecured ||pivotalCanBeSecured));
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

    stringBuffer.append(TEXT_25);
    
			}
			
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_28);
    
				} 
			}
			
			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_29);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_32);
    
        		String passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_33);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_36);
    } else {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_42);
    
				if(useKeytab) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_45);
    
				}
			}
			
			if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"PIVOTAL_HD_2_0".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"HDP_2_1".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion) && !"Cloudera_CDH5".equals(hiveVersion))) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_46);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_47);
    
			}
			
			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_48);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_50);
    
			}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_57);
    
				if(isCustom || (!isCustom && ("HDP_1_0,HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0".contains(hiveVersion)))) {
					String dbuser = ElementParameterParser.getValue(node, "__USER__");

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
				}
			} else {
				if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_73);
    
				} else {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_79);
    
				}
			}
		}
		
		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_82);
    
			}
		}
		
		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_83);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	
	connUtil.createURL(node);

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_86);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_87);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_90);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_93);
    } else {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_102);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_103);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_104);
    
		}

    stringBuffer.append(TEXT_105);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_106);
    connUtil.createConnection(node);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
		if(specify_alias){

    stringBuffer.append(TEXT_110);
    
		}
	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_113);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_114);
    
	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");	
	
	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");
	
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
	boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));	
			
	boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
	boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_0".equals(hiveVersion) || "HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion));
	

    stringBuffer.append(TEXT_115);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_123);
    
	}
	
	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_126);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_129);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_132);
    
		}

	}
	
	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
		if(setResourceManager) {
			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_136);
    
		}
		
		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_139);
    
		}
		
		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_142);
    
		}
		
		if("EMBEDDED".equals(connectionMode)) {
			if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
			} else {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
			}
			
			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
			}
		}
		
		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_156);
    
		}
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_160);
    
		}
	}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
			for(Map<String, String> jar : registerJarForHBase){
				String path = jar.get("JAR_PATH");
				if(path == null || "".equals(path) || "\"\"".equals(path)) {
					continue;
				}
		
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_180);
    
			}
		}
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    }
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbname);
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
    return stringBuffer.toString();
  }
}
