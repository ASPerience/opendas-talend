package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFilePropertiesBeginJava
{
  protected static String nl;
  public static synchronized TFTPFilePropertiesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFilePropertiesBeginJava result = new TFTPFilePropertiesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  java.util.Properties props_";
  protected final String TEXT_2 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_3 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_4 = ");" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_10 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = "; ";
  protected final String TEXT_15 = NL + "  props_";
  protected final String TEXT_16 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_17 = ");    ";
  protected final String TEXT_18 = NL + "    class MyUserInfo_";
  protected final String TEXT_19 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {";
  protected final String TEXT_20 = " " + NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL + "\t  String passphrase_";
  protected final String TEXT_27 = " = decryptedPassphrase_";
  protected final String TEXT_28 = ";" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_29 = "; }" + NL + "      public String getPassword() { return null; } " + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "    \t";
  protected final String TEXT_30 = " " + NL + "\t\t";
  protected final String TEXT_31 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_32 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "; ";
  protected final String TEXT_37 = NL + "    \tString[] password_";
  protected final String TEXT_38 = " = {decryptedPassword_";
  protected final String TEXT_39 = "};" + NL + "        return password_";
  protected final String TEXT_40 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_41 = " = new MyUserInfo_";
  protected final String TEXT_42 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_43 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_44 = NL + "      jsch_";
  protected final String TEXT_45 = ".addIdentity(";
  protected final String TEXT_46 = ", defaultUserInfo_";
  protected final String TEXT_47 = ".getPassphrase());";
  protected final String TEXT_48 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_49 = "=jsch_";
  protected final String TEXT_50 = ".getSession(";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");" + NL;
  protected final String TEXT_54 = " " + NL + "\t\t";
  protected final String TEXT_55 = " " + NL + "\t\t";
  protected final String TEXT_56 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_57 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = "; ";
  protected final String TEXT_62 = NL + "\tsession_";
  protected final String TEXT_63 = ".setPassword(decryptedPassword_";
  protected final String TEXT_64 = "); ";
  protected final String TEXT_65 = NL + "    session_";
  protected final String TEXT_66 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_67 = "); " + NL + "\t";
  protected final String TEXT_68 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_69 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_70 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_71 = ".setProxy(proxy_";
  protected final String TEXT_72 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_73 = NL + "    session_";
  protected final String TEXT_74 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_75 = "=session_";
  protected final String TEXT_76 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_77 = ".connect();" + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_78 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_79 = ";" + NL + "    c_";
  protected final String TEXT_80 = ".setFilenameEncoding(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_83 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_84 = "\");" + NL + "    if(c_";
  protected final String TEXT_85 = ".getHome()!=null && !c_";
  protected final String TEXT_86 = ".getHome().equals(c_";
  protected final String TEXT_87 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_88 = ".cd(c_";
  protected final String TEXT_89 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_90 = " " + NL + "  String remoteDir_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_93 = NL + "  ";
  protected final String TEXT_94 = " = new ";
  protected final String TEXT_95 = "Struct();" + NL + "  String remoteFile_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = " + \"/\" + ";
  protected final String TEXT_98 = ";" + NL + "  com.jcraft.jsch.SftpATTRS lstat_";
  protected final String TEXT_99 = " = c_";
  protected final String TEXT_100 = ".lstat(remoteFile_";
  protected final String TEXT_101 = ");" + NL + "" + NL + "  if (lstat_";
  protected final String TEXT_102 = " != null) {";
  protected final String TEXT_103 = NL + "    ";
  protected final String TEXT_104 = ".abs_path = (remoteFile_";
  protected final String TEXT_105 = ").replaceAll(\"//\", \"/\");";
  protected final String TEXT_106 = NL + "    ";
  protected final String TEXT_107 = ".dirname = ";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "    ";
  protected final String TEXT_110 = ".basename = ";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL + "    ";
  protected final String TEXT_113 = ".size = lstat_";
  protected final String TEXT_114 = ".getSize();";
  protected final String TEXT_115 = NL + "    ";
  protected final String TEXT_116 = ".mtime = (long)lstat_";
  protected final String TEXT_117 = ".getMTime();";
  protected final String TEXT_118 = NL + "    ";
  protected final String TEXT_119 = ".mtime_string = lstat_";
  protected final String TEXT_120 = ".getMtimeString();" + NL;
  protected final String TEXT_121 = NL + "      // Calculation of the Message Digest MD5" + NL + "      java.io.InputStream is_";
  protected final String TEXT_122 = " = c_";
  protected final String TEXT_123 = ".get(remoteFile_";
  protected final String TEXT_124 = ");" + NL + "      byte[] buffer_";
  protected final String TEXT_125 = " = new byte[8192];" + NL + "      int read_";
  protected final String TEXT_126 = " = 0;" + NL + "      java.security.MessageDigest dgs_";
  protected final String TEXT_127 = " = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "" + NL + "      while ( (read_";
  protected final String TEXT_128 = " = is_";
  protected final String TEXT_129 = ".read(buffer_";
  protected final String TEXT_130 = ")) > 0) {" + NL + "        dgs_";
  protected final String TEXT_131 = ".update(buffer_";
  protected final String TEXT_132 = ", 0, read_";
  protected final String TEXT_133 = ");" + NL + "      }";
  protected final String TEXT_134 = NL + "      ";
  protected final String TEXT_135 = ".md5 =String.format(\"%032x\", new java.math.BigInteger(1, dgs_";
  protected final String TEXT_136 = ".digest()));" + NL + "      is_";
  protected final String TEXT_137 = ".close();";
  protected final String TEXT_138 = NL + "  }  ";
  protected final String TEXT_139 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_140 = " =null;" + NL;
  protected final String TEXT_141 = NL + "    ftp_";
  protected final String TEXT_142 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_143 = "\");";
  protected final String TEXT_144 = NL + "    ftp_";
  protected final String TEXT_145 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_146 = ".setRemoteHost(";
  protected final String TEXT_147 = ");" + NL + "    ftp_";
  protected final String TEXT_148 = ".setRemotePort(";
  protected final String TEXT_149 = ");" + NL;
  protected final String TEXT_150 = NL + "      ftp_";
  protected final String TEXT_151 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_152 = NL + "      ftp_";
  protected final String TEXT_153 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_154 = NL + "    ftp_";
  protected final String TEXT_155 = ".setControlEncoding(";
  protected final String TEXT_156 = ");" + NL + "    ftp_";
  protected final String TEXT_157 = ".connect();" + NL + "\t";
  protected final String TEXT_158 = " " + NL + "\t";
  protected final String TEXT_159 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_160 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = "; ";
  protected final String TEXT_165 = NL + "    ftp_";
  protected final String TEXT_166 = ".login(";
  protected final String TEXT_167 = ", decryptedPassword_";
  protected final String TEXT_168 = ");";
  protected final String TEXT_169 = NL + "  \tftp_";
  protected final String TEXT_170 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_171 = NL + "  String remoteDir_";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_174 = NL + "  ";
  protected final String TEXT_175 = " = new ";
  protected final String TEXT_176 = "Struct();" + NL + "  String remoteFile_";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = " + \"/\" + ";
  protected final String TEXT_179 = ";" + NL + "" + NL + "  if (ftp_";
  protected final String TEXT_180 = ".exists(remoteFile_";
  protected final String TEXT_181 = ")) {";
  protected final String TEXT_182 = NL + "    ";
  protected final String TEXT_183 = ".abs_path = (remoteFile_";
  protected final String TEXT_184 = ").replaceAll(\"//\", \"/\");";
  protected final String TEXT_185 = NL + "    ";
  protected final String TEXT_186 = ".dirname = ";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "    ";
  protected final String TEXT_189 = ".basename = ";
  protected final String TEXT_190 = ";";
  protected final String TEXT_191 = NL + "    ";
  protected final String TEXT_192 = ".size = ftp_";
  protected final String TEXT_193 = ".size(remoteFile_";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "    ";
  protected final String TEXT_196 = ".mtime = ftp_";
  protected final String TEXT_197 = ".modtime(remoteFile_";
  protected final String TEXT_198 = ").getTime();";
  protected final String TEXT_199 = NL + "    ";
  protected final String TEXT_200 = ".mtime_string =ftp_";
  protected final String TEXT_201 = ".modtime(remoteFile_";
  protected final String TEXT_202 = ").toString();" + NL;
  protected final String TEXT_203 = NL + "      // Calculation of the Message Digest MD5" + NL + "      java.security.MessageDigest dgs_";
  protected final String TEXT_204 = " = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "      dgs_";
  protected final String TEXT_205 = ".update(ftp_";
  protected final String TEXT_206 = ".get(remoteFile_";
  protected final String TEXT_207 = "));";
  protected final String TEXT_208 = NL + "      ";
  protected final String TEXT_209 = ".md5 =String.format(\"%032x\", new java.math.BigInteger(1, dgs_";
  protected final String TEXT_210 = ".digest()));";
  protected final String TEXT_211 = NL + "  }";
  protected final String TEXT_212 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
String mode = ElementParameterParser.getValue(node, "__MODE__");
boolean MD5 = new Boolean(ElementParameterParser.getValue(node, "__MD5__"));
boolean sftp = false;

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

String passwordFieldName = "";
if (useProxy) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_8);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    } else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
}
String outputConnName = null;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

if (conns != null) {
  if (conns.size() > 0) {
    for (int i = 0; i < conns.size(); i++) {
      IConnection connTemp = conns.get(i);
      if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        outputConnName = connTemp.getName();
        break;
      }
    }
  }
}

if (outputConnName == null) {
  return "";
}

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (sftp) {

  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
      passwordFieldName = "__PASSPHRASE__";
      if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
      
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_30);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_53);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_54);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_55);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    } else {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    if (!useProxy) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    }
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_81);
    } else {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn );
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
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    if (MD5) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    
} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_143);
    } else {
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_149);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    } else {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
	passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_158);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_161);
    } else {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    
  //add feature 19709,add the "Transfer mode" option,
  //the default transfer mode is ASCII,we don't change the mode when ascii is choosed.
  if("binary".equalsIgnoreCase(mode)){
  
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    
  }
  
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    if (MD5) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    
}

    stringBuffer.append(TEXT_212);
    return stringBuffer.toString();
  }
}
