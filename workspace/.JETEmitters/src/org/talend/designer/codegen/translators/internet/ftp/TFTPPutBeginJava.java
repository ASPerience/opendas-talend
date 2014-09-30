package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPPutBeginJava
{
  protected static String nl;
  public static synchronized TFTPPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPPutBeginJava result = new TFTPPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");";
  protected final String TEXT_3 = NL + "  java.util.Properties props_";
  protected final String TEXT_4 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_8 = ");" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "  props_";
  protected final String TEXT_18 = ".put(\"java.net.socks.password\",decryptedProxyPassword_";
  protected final String TEXT_19 = ");        ";
  protected final String TEXT_20 = NL + "int nb_file_";
  protected final String TEXT_21 = " = 0;" + NL;
  protected final String TEXT_22 = NL + NL + "  class MyProgressMonitor_";
  protected final String TEXT_23 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "    public void init(int op, String src, String dest, long max) {}" + NL + "    public boolean count(long count) { return true;}" + NL + "    public void end() {}" + NL + "  }" + NL;
  protected final String TEXT_24 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_25 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_26 = "\");" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\tif(c_";
  protected final String TEXT_28 = "!=null && c_";
  protected final String TEXT_29 = ".getSession()!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Uses an existing connection as \" + c_";
  protected final String TEXT_31 = ".getSession().getUserName() + \". Connection hostname: \" + c_";
  protected final String TEXT_32 = ".getSession().getHost() + \". Connection port: \" + c_";
  protected final String TEXT_33 = ".getSession().getPort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + "    if(c_";
  protected final String TEXT_35 = ".getHome()!=null && !c_";
  protected final String TEXT_36 = ".getHome().equals(c_";
  protected final String TEXT_37 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_38 = ".cd(c_";
  protected final String TEXT_39 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_40 = "    " + NL + "    class MyUserInfo_";
  protected final String TEXT_41 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {";
  protected final String TEXT_42 = " " + NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_43 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "; ";
  protected final String TEXT_48 = NL + "\t  String passphrase_";
  protected final String TEXT_49 = " = decryptedPassphrase_";
  protected final String TEXT_50 = ";" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_51 = "; }" + NL + "      public String getPassword() { return null; } " + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "      public void showMessage(String arg0) { } " + NL + "      " + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "    \t";
  protected final String TEXT_52 = " " + NL + "    \t";
  protected final String TEXT_53 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "; ";
  protected final String TEXT_59 = NL + "    \tString[] password_";
  protected final String TEXT_60 = " = {decryptedPassword_";
  protected final String TEXT_61 = "};" + NL + "        return password_";
  protected final String TEXT_62 = ";" + NL + "      }" + NL + "    };" + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_63 = " = new MyUserInfo_";
  protected final String TEXT_64 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_65 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_66 = NL + "\t  ";
  protected final String TEXT_67 = NL + "\t\tlog.info(\"";
  protected final String TEXT_68 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_69 = " + \"'.\");" + NL + "\t  ";
  protected final String TEXT_70 = NL + "      jsch_";
  protected final String TEXT_71 = ".addIdentity(";
  protected final String TEXT_72 = ", defaultUserInfo_";
  protected final String TEXT_73 = ".getPassphrase());";
  protected final String TEXT_74 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_75 = "=jsch_";
  protected final String TEXT_76 = ".getSession(";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ");" + NL;
  protected final String TEXT_80 = NL + "\t  ";
  protected final String TEXT_81 = NL + "\t\tlog.info(\"";
  protected final String TEXT_82 = " - SFTP authentication using a password.\");" + NL + "\t  ";
  protected final String TEXT_83 = NL + "\t  ";
  protected final String TEXT_84 = " " + NL + "\t  ";
  protected final String TEXT_85 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_86 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "; ";
  protected final String TEXT_91 = NL + "\t  session_";
  protected final String TEXT_92 = ".setPassword(decryptedPassword_";
  protected final String TEXT_93 = "); ";
  protected final String TEXT_94 = NL + "    session_";
  protected final String TEXT_95 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_96 = "); " + NL + "\t";
  protected final String TEXT_97 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_98 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_99 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_100 = ".setProxy(proxy_";
  protected final String TEXT_101 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = NL + "\t\tlog.info(\"";
  protected final String TEXT_104 = " - Connection attempt to '\" + ";
  protected final String TEXT_105 = " + \"' as '\" + ";
  protected final String TEXT_106 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_107 = NL + "    session_";
  protected final String TEXT_108 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_109 = "=session_";
  protected final String TEXT_110 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_111 = ".connect();" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tlog.info(\"";
  protected final String TEXT_113 = " - Connection to '\" + ";
  protected final String TEXT_114 = " + \" has succeeded.\" );" + NL + "\t";
  protected final String TEXT_115 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_116 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_117 = ";" + NL + "    c_";
  protected final String TEXT_118 = ".setFilenameEncoding(";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "  // becasue there is not the same method in JSch class as FTPClient class, define a list here" + NL + "  java.util.List<String> msg_";
  protected final String TEXT_121 = " = new java.util.ArrayList<String>();" + NL + "  com.jcraft.jsch.SftpProgressMonitor monitor";
  protected final String TEXT_122 = " = new MyProgressMonitor_";
  protected final String TEXT_123 = "();" + NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_124 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "  ";
  protected final String TEXT_125 = NL + "    java.util.Map<String,String> map";
  protected final String TEXT_126 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_127 = ".put(";
  protected final String TEXT_128 = ", ";
  protected final String TEXT_129 = ");    " + NL + "    list";
  protected final String TEXT_130 = ".add(map";
  protected final String TEXT_131 = ");       ";
  protected final String TEXT_132 = "  " + NL + "  String localdir";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ";" + NL + "\t";
  protected final String TEXT_135 = NL + "\t\tlog.info(\"";
  protected final String TEXT_136 = " - Putting file to the server.\");" + NL + "\t";
  protected final String TEXT_137 = NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_138 = " : list";
  protected final String TEXT_139 = ") {" + NL;
  protected final String TEXT_140 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_141 = " =null;" + NL;
  protected final String TEXT_142 = NL + "    ftp_";
  protected final String TEXT_143 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_144 = "\");" + NL + "\t  ";
  protected final String TEXT_145 = NL + "\t\t  String rootDir_";
  protected final String TEXT_146 = " = ftp_";
  protected final String TEXT_147 = ".pwd();" + NL + "\t  ";
  protected final String TEXT_148 = NL + "\t";
  protected final String TEXT_149 = NL + "\t\tif(ftp_";
  protected final String TEXT_150 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_151 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_152 = ".getRemoteHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_153 = ".getRemotePort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_154 = "    " + NL + "  \t";
  protected final String TEXT_155 = NL + "\t\tlog.info(\"";
  protected final String TEXT_156 = " - Connection attempt to '\" + ";
  protected final String TEXT_157 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_158 = NL + "    ftp_";
  protected final String TEXT_159 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_160 = ".setRemoteHost(";
  protected final String TEXT_161 = ");" + NL + "    ftp_";
  protected final String TEXT_162 = ".setRemotePort(";
  protected final String TEXT_163 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_164 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_165 = " - \" + ";
  protected final String TEXT_166 = ");" + NL + "\t";
  protected final String TEXT_167 = NL;
  protected final String TEXT_168 = NL + "      ftp_";
  protected final String TEXT_169 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_170 = NL + "      ftp_";
  protected final String TEXT_171 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_172 = NL + "    ftp_";
  protected final String TEXT_173 = ".setControlEncoding(";
  protected final String TEXT_174 = ");" + NL + "\t";
  protected final String TEXT_175 = NL + "\t\tlog.info(\"";
  protected final String TEXT_176 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_177 = " - Connection attempt to '\" + ";
  protected final String TEXT_178 = " + \"' as '\" +";
  protected final String TEXT_179 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_180 = NL + "    ftp_";
  protected final String TEXT_181 = ".connect();  " + NL + "\t";
  protected final String TEXT_182 = " " + NL + "\t";
  protected final String TEXT_183 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_184 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_187 = " = ";
  protected final String TEXT_188 = "; ";
  protected final String TEXT_189 = NL + "    ftp_";
  protected final String TEXT_190 = ".login(";
  protected final String TEXT_191 = ", decryptedPassword_";
  protected final String TEXT_192 = ");" + NL + "\t";
  protected final String TEXT_193 = NL + "\t\tlog.info(\"";
  protected final String TEXT_194 = " - Connection to '\" + ";
  protected final String TEXT_195 = " +  \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_196 = " ";
  protected final String TEXT_197 = "  " + NL + "" + NL + "  // msg_";
  protected final String TEXT_198 = " likes a String[] to save the message from transfer.  " + NL + "  com.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_199 = " = ftp_";
  protected final String TEXT_200 = ".getTransferCompleteMessages();" + NL + "  msg_";
  protected final String TEXT_201 = ".clearAll();" + NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_202 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_203 = "    " + NL + "    java.util.Map<String,String> map";
  protected final String TEXT_204 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_205 = ".put(";
  protected final String TEXT_206 = ",";
  protected final String TEXT_207 = ");  " + NL + "    list";
  protected final String TEXT_208 = ".add(map";
  protected final String TEXT_209 = ");       ";
  protected final String TEXT_210 = "  " + NL + "  String remotedir";
  protected final String TEXT_211 = " = ";
  protected final String TEXT_212 = ";" + NL + "  ftp_";
  protected final String TEXT_213 = ".chdir(remotedir";
  protected final String TEXT_214 = ");" + NL;
  protected final String TEXT_215 = "  " + NL + "    ftp_";
  protected final String TEXT_216 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_217 = "  " + NL + "    ftp_";
  protected final String TEXT_218 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_219 = NL + "  String localdir";
  protected final String TEXT_220 = "  = ";
  protected final String TEXT_221 = ";" + NL + "" + NL + "\t";
  protected final String TEXT_222 = NL + "\t\tlog.info(\"";
  protected final String TEXT_223 = " - Uploading files to the server.\");" + NL + "\t";
  protected final String TEXT_224 = NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_225 = " : list";
  protected final String TEXT_226 = ") {";
  protected final String TEXT_227 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";
if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
}  

if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
}
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_10);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if (sftp) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if (("true").equals(useExistingConn)) {
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
      passwordFieldName = "__PASSPHRASE__";
      if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
      
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    } else {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
    	passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_52);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    } else {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_66);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_79);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    
	  passwordFieldName = "__PASSWORD__";
	  
    stringBuffer.append(TEXT_84);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_87);
    } else {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    if (!useProxy) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_131);
    
  }
  
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_134);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    } else {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
  if (("true").equals(useExistingConn)) {
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_144);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    }
    } else {
    stringBuffer.append(TEXT_154);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    } else {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_174);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    
	passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_182);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_185);
    } else {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_209);
    
  }
  
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    } else { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_221);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    return stringBuffer.toString();
  }
}
