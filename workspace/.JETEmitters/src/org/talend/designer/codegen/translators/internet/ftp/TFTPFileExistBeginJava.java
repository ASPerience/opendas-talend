package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileExistBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistBeginJava result = new TFTPFileExistBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.info(\"";
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
  protected final String TEXT_18 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_19 = ");        ";
  protected final String TEXT_20 = NL + "    class MyUserInfo_";
  protected final String TEXT_21 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL;
  protected final String TEXT_22 = " " + NL + "  \t    String decryptedPassphrase_";
  protected final String TEXT_23 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; ";
  protected final String TEXT_28 = NL + "\t  String passphrase_";
  protected final String TEXT_29 = " = decryptedPassphrase_";
  protected final String TEXT_30 = ";" + NL + "" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_31 = "; }" + NL + "" + NL + "      public String getPassword() { return null; } " + NL + "" + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "\t\t";
  protected final String TEXT_32 = " " + NL + "\t\t";
  protected final String TEXT_33 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_34 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "; ";
  protected final String TEXT_39 = NL + "\t\tString[] password_";
  protected final String TEXT_40 = " = {decryptedPassword_";
  protected final String TEXT_41 = "};" + NL + "        return password_";
  protected final String TEXT_42 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_43 = " = new MyUserInfo_";
  protected final String TEXT_44 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_45 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_46 = NL + "\t  ";
  protected final String TEXT_47 = NL + "\t\tlog.info(\"";
  protected final String TEXT_48 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_49 = " + \"'.\");" + NL + "\t  ";
  protected final String TEXT_50 = NL + "      jsch_";
  protected final String TEXT_51 = ".addIdentity(";
  protected final String TEXT_52 = ", defaultUserInfo_";
  protected final String TEXT_53 = ".getPassphrase());";
  protected final String TEXT_54 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_55 = "=jsch_";
  protected final String TEXT_56 = ".getSession(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ");" + NL;
  protected final String TEXT_60 = " " + NL + "\t  ";
  protected final String TEXT_61 = NL + "\t\tlog.info(\"";
  protected final String TEXT_62 = " - SFTP authentication using a password.\");" + NL + "\t  ";
  protected final String TEXT_63 = NL + "\t  ";
  protected final String TEXT_64 = " " + NL + "\t  ";
  protected final String TEXT_65 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_66 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "; ";
  protected final String TEXT_71 = NL + "    session_";
  protected final String TEXT_72 = ".setPassword(decryptedPassword_";
  protected final String TEXT_73 = "); ";
  protected final String TEXT_74 = NL + "    session_";
  protected final String TEXT_75 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_76 = "); " + NL + "\t";
  protected final String TEXT_77 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_78 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_79 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_80 = ".setProxy(proxy_";
  protected final String TEXT_81 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_82 = NL + "\t";
  protected final String TEXT_83 = NL + "\t\tlog.info(\"";
  protected final String TEXT_84 = " - Connection attempt to '\" + ";
  protected final String TEXT_85 = " + \"' as '\" + ";
  protected final String TEXT_86 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_87 = NL + "    session_";
  protected final String TEXT_88 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_89 = "=session_";
  protected final String TEXT_90 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_91 = ".connect();" + NL + "\t";
  protected final String TEXT_92 = NL + "\t\tlog.info(\"";
  protected final String TEXT_93 = " - Connection to '\" + ";
  protected final String TEXT_94 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_95 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_96 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_97 = ";" + NL + "    c_";
  protected final String TEXT_98 = ".setFilenameEncoding(";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_101 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_102 = "\");" + NL + "\t";
  protected final String TEXT_103 = NL + "\t\tif(c_";
  protected final String TEXT_104 = "!=null && c_";
  protected final String TEXT_105 = ".getSession()!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_106 = " - Uses an existing connection as \" + c_";
  protected final String TEXT_107 = ".getSession().getUserName() + \". Connection hostname: \" + c_";
  protected final String TEXT_108 = ".getSession().getHost() + \". Connection port: \" + c_";
  protected final String TEXT_109 = ".getSession().getPort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_110 = NL + "    if(c_";
  protected final String TEXT_111 = ".getHome()!=null && !c_";
  protected final String TEXT_112 = ".getHome().equals(c_";
  protected final String TEXT_113 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_114 = ".cd(c_";
  protected final String TEXT_115 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_116 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_117 = " = null;" + NL;
  protected final String TEXT_118 = NL + "    ftp_";
  protected final String TEXT_119 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_120 = "\");";
  protected final String TEXT_121 = NL + "\t\tif(ftp_";
  protected final String TEXT_122 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_123 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_124 = ".getRemoteHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_125 = ".getRemotePort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_126 = "    " + NL + "    ftp_";
  protected final String TEXT_127 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_128 = ".setRemoteHost(";
  protected final String TEXT_129 = ");" + NL + "    ftp_";
  protected final String TEXT_130 = ".setRemotePort(";
  protected final String TEXT_131 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_132 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_133 = " - \" + ";
  protected final String TEXT_134 = ");" + NL + "\t";
  protected final String TEXT_135 = NL;
  protected final String TEXT_136 = NL + "      ftp_";
  protected final String TEXT_137 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_138 = NL + "      ftp_";
  protected final String TEXT_139 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_140 = NL + "    ftp_";
  protected final String TEXT_141 = ".setControlEncoding(";
  protected final String TEXT_142 = ");" + NL + "\t";
  protected final String TEXT_143 = NL + "\t\tlog.info(\"";
  protected final String TEXT_144 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_145 = " - Connection attempt to '\" + ";
  protected final String TEXT_146 = " + \"' as '\" +";
  protected final String TEXT_147 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_148 = NL + "    ftp_";
  protected final String TEXT_149 = ".connect();  " + NL + "\t";
  protected final String TEXT_150 = " " + NL + "\t";
  protected final String TEXT_151 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_152 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = "; ";
  protected final String TEXT_157 = NL + "    ftp_";
  protected final String TEXT_158 = ".login(";
  protected final String TEXT_159 = ", decryptedPassword_";
  protected final String TEXT_160 = ");" + NL + "\t";
  protected final String TEXT_161 = NL + "\t\tlog.info(\"";
  protected final String TEXT_162 = " - Connection to '\" + ";
  protected final String TEXT_163 = "  + \"' has succeeded.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host=ElementParameterParser.getValue(node, "__HOST__");
String port=ElementParameterParser.getValue(node, "__PORT__");
String username=ElementParameterParser.getValue(node, "__USERNAME__");

String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
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

String passwordFieldName = "";

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

if (sftp) {
  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
      passwordFieldName = "__PASSPHRASE__";
      if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_32);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_46);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_59);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_60);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    
	  passwordFieldName = "__PASSWORD__";
	  
    stringBuffer.append(TEXT_64);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    } else {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    if (!useProxy) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_99);
    
  } else {
  
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_102);
    if(isLog4jEnabled){
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
    }
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
    
  }
} else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
     if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    }
    } else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_131);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    } else {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_142);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
	passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_150);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_153);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_163);
    }
      
  }
}
    return stringBuffer.toString();
  }
}
