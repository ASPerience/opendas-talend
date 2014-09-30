package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFTPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TFTPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPConnectionBeginJava result = new TFTPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");" + NL + "\t";
  protected final String TEXT_3 = "  " + NL + "  java.util.Properties props_";
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
  protected final String TEXT_18 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_21 = " - \" + ";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_24 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "  ftp_";
  protected final String TEXT_25 = ".setRemoteHost(";
  protected final String TEXT_26 = ");" + NL + "  ftp_";
  protected final String TEXT_27 = ".setRemotePort(";
  protected final String TEXT_28 = ");" + NL;
  protected final String TEXT_29 = NL + "    ftp_";
  protected final String TEXT_30 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_31 = NL + "    ftp_";
  protected final String TEXT_32 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_33 = NL + "  ftp_";
  protected final String TEXT_34 = ".setControlEncoding(";
  protected final String TEXT_35 = ");" + NL + "\t";
  protected final String TEXT_36 = NL + "\t\tlog.info(\"";
  protected final String TEXT_37 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_38 = " - Connection attempt to '\" + ";
  protected final String TEXT_39 = " + \"' as '\" +";
  protected final String TEXT_40 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_41 = NL + "  ftp_";
  protected final String TEXT_42 = ".connect();" + NL + "    " + NL + "  \t";
  protected final String TEXT_43 = " " + NL + "  \t";
  protected final String TEXT_44 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = "; ";
  protected final String TEXT_50 = NL + "  ftp_";
  protected final String TEXT_51 = ".login(";
  protected final String TEXT_52 = ", decryptedPassword_";
  protected final String TEXT_53 = ");" + NL + "    " + NL + "  \t";
  protected final String TEXT_54 = NL + "\t\tlog.info(\"";
  protected final String TEXT_55 = " - Connection to '\" + ";
  protected final String TEXT_56 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_57 = NL + "  globalMap.put(\"conn_";
  protected final String TEXT_58 = "\",ftp_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "  class MyUserInfo implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {";
  protected final String TEXT_61 = " " + NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_62 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "; ";
  protected final String TEXT_67 = NL + NL + "\tString passphrase_";
  protected final String TEXT_68 = " = decryptedPassphrase_";
  protected final String TEXT_69 = ";" + NL + "" + NL + "    public String getPassphrase() { return passphrase_";
  protected final String TEXT_70 = "; }" + NL + "" + NL + "    public String getPassword() { return null; } " + NL + "" + NL + "    public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "    public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "    public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "    public void showMessage(String arg0) { } " + NL + "" + NL + "    public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "    boolean[] echo) {" + NL + "\t  ";
  protected final String TEXT_71 = " " + NL + "\t  ";
  protected final String TEXT_72 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_73 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = "; ";
  protected final String TEXT_78 = NL + "\t  String[] password_";
  protected final String TEXT_79 = " = {decryptedPassword_";
  protected final String TEXT_80 = "};" + NL + "      return password_";
  protected final String TEXT_81 = ";" + NL + "    }" + NL + "  };" + NL + "  final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_82 = " = new MyUserInfo();" + NL + "  com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_83 = " = new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_84 = NL + "\t";
  protected final String TEXT_85 = NL + "\t\tlog.info(\"";
  protected final String TEXT_86 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_87 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_88 = NL + "    jsch_";
  protected final String TEXT_89 = ".addIdentity(";
  protected final String TEXT_90 = ", defaultUserInfo_";
  protected final String TEXT_91 = ".getPassphrase());";
  protected final String TEXT_92 = NL + "  com.jcraft.jsch.Session session_";
  protected final String TEXT_93 = " = jsch_";
  protected final String TEXT_94 = ".getSession(";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ", ";
  protected final String TEXT_97 = ");" + NL;
  protected final String TEXT_98 = " " + NL + "\t";
  protected final String TEXT_99 = NL + "\t\tlog.info(\"";
  protected final String TEXT_100 = " - SFTP authentication using a password.\");" + NL + "\t";
  protected final String TEXT_101 = NL + "\t" + NL + "\t";
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_104 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = "; ";
  protected final String TEXT_109 = NL + "\tsession_";
  protected final String TEXT_110 = ".setPassword(decryptedPassword_";
  protected final String TEXT_111 = "); ";
  protected final String TEXT_112 = NL + NL + "  session_";
  protected final String TEXT_113 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_114 = "); " + NL + "\t";
  protected final String TEXT_115 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_116 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_117 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_118 = ".setProxy(proxy_";
  protected final String TEXT_119 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_120 = NL + "  \t";
  protected final String TEXT_121 = NL + "\t\tlog.info(\"";
  protected final String TEXT_122 = " - Connection attempt to '\" + ";
  protected final String TEXT_123 = " + \"' as '\" + ";
  protected final String TEXT_124 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_125 = NL + "  session_";
  protected final String TEXT_126 = ".connect();" + NL + "  com.jcraft.jsch. Channel channel_";
  protected final String TEXT_127 = " = session_";
  protected final String TEXT_128 = ".openChannel(\"sftp\"); " + NL + "  channel_";
  protected final String TEXT_129 = ".connect();" + NL + "  \t";
  protected final String TEXT_130 = NL + "\t\tlog.info(\"";
  protected final String TEXT_131 = " - Connection to '\" + ";
  protected final String TEXT_132 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_133 = NL + "  com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_134 = " = (com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_135 = ";" + NL + "  c_";
  protected final String TEXT_136 = ".setFilenameEncoding(";
  protected final String TEXT_137 = ");" + NL + "  globalMap.put(\"conn_";
  protected final String TEXT_138 = "\", c_";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "  class MyTrust_";
  protected final String TEXT_141 = "{" + NL + "" + NL + "    private javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "      throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "      java.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "      java.io.FileNotFoundException, java.io.IOException{" + NL + "      java.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL + "\t  ";
  protected final String TEXT_142 = " " + NL + "\t    String decryptedKeyStorePassword_";
  protected final String TEXT_143 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_144 = ");" + NL + "\t  ";
  protected final String TEXT_145 = NL + "\t    String decryptedKeyStorePassword_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = "; " + NL + "\t  ";
  protected final String TEXT_148 = NL + "\t  ks.load(new java.io.FileInputStream(";
  protected final String TEXT_149 = "), decryptedKeyStorePassword_";
  protected final String TEXT_150 = ".toCharArray());" + NL + "      javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "      tmf.init(ks);" + NL + "      return tmf.getTrustManagers();" + NL + "    }" + NL + "  }" + NL + "  javax.net.ssl.SSLContext sslContext = null;" + NL + "  javax.net.ssl.TrustManager[] trustManager = null;" + NL + "  javax.net.ssl.SSLSocketFactory sslSocketFactory = null;" + NL + "  it.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_151 = " =null;" + NL + "  MyTrust_";
  protected final String TEXT_152 = " myTrust_";
  protected final String TEXT_153 = " = null;" + NL + "" + NL + "  try {" + NL + "    sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "    myTrust_";
  protected final String TEXT_154 = " = new MyTrust_";
  protected final String TEXT_155 = "();" + NL + "    trustManager = myTrust_";
  protected final String TEXT_156 = ".getTrustManagers();" + NL + "    sslContext.init(null, trustManager, new java.security.SecureRandom());" + NL + "    sslSocketFactory = sslContext.getSocketFactory();" + NL + "    ftp_";
  protected final String TEXT_157 = " = new it.sauronsoftware.ftp4j.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_158 = ".setSSLSocketFactory(sslSocketFactory);";
  protected final String TEXT_159 = NL + "    \tftp_";
  protected final String TEXT_160 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS);";
  protected final String TEXT_161 = NL + "    \tftp_";
  protected final String TEXT_162 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES);";
  protected final String TEXT_163 = NL + "  \t";
  protected final String TEXT_164 = NL + "\t\tlog.info(\"";
  protected final String TEXT_165 = " - FTPS authentication (";
  protected final String TEXT_166 = ").\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_167 = " - Connection attempt to '\" + ";
  protected final String TEXT_168 = " + \"' as '\" + ";
  protected final String TEXT_169 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_170 = NL + "    ftp_";
  protected final String TEXT_171 = ".connect(";
  protected final String TEXT_172 = ",";
  protected final String TEXT_173 = ");" + NL + "  \t";
  protected final String TEXT_174 = NL + "\t\tlog.info(\"";
  protected final String TEXT_175 = " - Connection to '\" + ";
  protected final String TEXT_176 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_177 = NL + "\t" + NL + "\t";
  protected final String TEXT_178 = NL + "\t";
  protected final String TEXT_179 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_180 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_183 = " = ";
  protected final String TEXT_184 = "; ";
  protected final String TEXT_185 = NL + "\tftp_";
  protected final String TEXT_186 = ".login(";
  protected final String TEXT_187 = ", decryptedPassword_";
  protected final String TEXT_188 = ");" + NL + "  } catch (java.lang.IllegalStateException e) {" + NL + "\t";
  protected final String TEXT_189 = NL + "\t\tlog.error(\"";
  protected final String TEXT_190 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_191 = NL + "    e.printStackTrace();" + NL + "  } catch (java.io.IOException e) {" + NL + "\t";
  protected final String TEXT_192 = NL + "\t\tlog.error(\"";
  protected final String TEXT_193 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_194 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) {" + NL + "\t";
  protected final String TEXT_195 = NL + "\t\tlog.error(\"";
  protected final String TEXT_196 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_197 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPException e) {" + NL + "\t";
  protected final String TEXT_198 = NL + "\t\tlog.error(\"";
  protected final String TEXT_199 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_200 = NL + "    e.printStackTrace();" + NL + "  }" + NL + "  globalMap.put(\"conn_";
  protected final String TEXT_201 = "\", ftp_";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL + "\tlog.info(\"";
  protected final String TEXT_204 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USER__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
boolean sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
boolean ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
String sEncoding = ElementParameterParser.getValue(node, "__ENCODING__");
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(isLog4jEnabled){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    }
String passwordFieldName = "";
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

if (!sftp && !ftps) { // *** ftp *** //
  	if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_28);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
  	passwordFieldName = "__PASS__";
  	
    stringBuffer.append(TEXT_43);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
} else if (!ftps) { // *** sftp *** //

    stringBuffer.append(TEXT_60);
    
    passwordFieldName = "__PASSPHRASE__";
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
	  passwordFieldName = "__PASS__";
	  
    stringBuffer.append(TEXT_71);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_74);
    } else {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_77);
    }
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
    if (("PUBLICKEY").equals(authMethod)){
    stringBuffer.append(TEXT_84);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_97);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_98);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    
	passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_102);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    } else {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    if (!useProxy) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(user);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
} else {  // *** ftps *** //

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	  passwordFieldName = "__KEYSTORE_PASS__";
	  if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
	  
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_144);
    } else {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    
    if("IMPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    
    }else if("EXPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    
    }

    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    
	passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_178);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_181);
    } else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    
}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    return stringBuffer.toString();
  }
}
