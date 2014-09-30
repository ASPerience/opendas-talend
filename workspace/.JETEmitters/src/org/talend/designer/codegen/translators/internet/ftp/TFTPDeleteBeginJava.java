package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPDeleteBeginJava
{
  protected static String nl;
  public static synchronized TFTPDeleteBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPDeleteBeginJava result = new TFTPDeleteBeginJava();
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
  protected final String TEXT_17 = ");        ";
  protected final String TEXT_18 = NL + "int nb_file_";
  protected final String TEXT_19 = " = 0;" + NL;
  protected final String TEXT_20 = NL + "    class MyUserInfo_";
  protected final String TEXT_21 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t  ";
  protected final String TEXT_22 = " " + NL + "\t    String decryptedPassphrase_";
  protected final String TEXT_23 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_24 = ");" + NL + "\t  ";
  protected final String TEXT_25 = NL + "\t    String decryptedPassphrase_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; " + NL + "\t  ";
  protected final String TEXT_28 = NL + "\t  String passphrase_";
  protected final String TEXT_29 = " = decryptedPassphrase_";
  protected final String TEXT_30 = ";" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_31 = "; }" + NL + "      public String getPassword() { return null; } " + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "\t\t";
  protected final String TEXT_32 = " " + NL + "\t\t";
  protected final String TEXT_33 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_34 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "; ";
  protected final String TEXT_39 = NL + "\t    String[] password_";
  protected final String TEXT_40 = " = {decryptedPassword_";
  protected final String TEXT_41 = "};" + NL + "        return password_";
  protected final String TEXT_42 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_43 = " = new MyUserInfo_";
  protected final String TEXT_44 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_45 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_46 = NL + "      jsch_";
  protected final String TEXT_47 = ".addIdentity(";
  protected final String TEXT_48 = ", defaultUserInfo_";
  protected final String TEXT_49 = ".getPassphrase());";
  protected final String TEXT_50 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_51 = "=jsch_";
  protected final String TEXT_52 = ".getSession(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ");" + NL;
  protected final String TEXT_56 = " " + NL + "\t\t";
  protected final String TEXT_57 = " " + NL + "\t\t";
  protected final String TEXT_58 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "; ";
  protected final String TEXT_64 = NL + "\tsession_";
  protected final String TEXT_65 = ".setPassword(decryptedPassword_";
  protected final String TEXT_66 = "); ";
  protected final String TEXT_67 = NL + "    session_";
  protected final String TEXT_68 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_69 = "); " + NL + "\t";
  protected final String TEXT_70 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_71 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_72 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_73 = ".setProxy(proxy_";
  protected final String TEXT_74 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_75 = NL + "    session_";
  protected final String TEXT_76 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_77 = "=session_";
  protected final String TEXT_78 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_79 = ".connect();" + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_80 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_81 = ";" + NL + "    c_";
  protected final String TEXT_82 = ".setFilenameEncoding(";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_85 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_86 = "\");" + NL + "    if(c_";
  protected final String TEXT_87 = ".getHome()!=null && !c_";
  protected final String TEXT_88 = ".getHome().equals(c_";
  protected final String TEXT_89 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_90 = ".cd(c_";
  protected final String TEXT_91 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_92 = NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_93 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_94 = "    " + NL + "    java.util.Map<String,String> map";
  protected final String TEXT_95 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_96 = ".put(";
  protected final String TEXT_97 = ",\"\");" + NL + "    list";
  protected final String TEXT_98 = ".add(map";
  protected final String TEXT_99 = ");       ";
  protected final String TEXT_100 = "  " + NL + "" + NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_101 = " : list";
  protected final String TEXT_102 = ") {" + NL;
  protected final String TEXT_103 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_104 = " =null;" + NL;
  protected final String TEXT_105 = NL + "    ftp_";
  protected final String TEXT_106 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_107 = "\");" + NL + "  \t";
  protected final String TEXT_108 = NL + "  \t\tString rootDir_";
  protected final String TEXT_109 = " = ftp_";
  protected final String TEXT_110 = ".pwd();" + NL + "  \t";
  protected final String TEXT_111 = "    " + NL + "    ftp_";
  protected final String TEXT_112 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_113 = ".setRemoteHost(";
  protected final String TEXT_114 = ");" + NL + "    ftp_";
  protected final String TEXT_115 = ".setRemotePort(";
  protected final String TEXT_116 = ");" + NL;
  protected final String TEXT_117 = NL + "      ftp_";
  protected final String TEXT_118 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_119 = NL + "      ftp_";
  protected final String TEXT_120 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_121 = NL + "    ftp_";
  protected final String TEXT_122 = ".setControlEncoding(";
  protected final String TEXT_123 = ");" + NL + "    ftp_";
  protected final String TEXT_124 = ".connect();  ";
  protected final String TEXT_125 = " " + NL + "\t";
  protected final String TEXT_126 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_127 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = "; ";
  protected final String TEXT_132 = NL + "    ftp_";
  protected final String TEXT_133 = ".login(";
  protected final String TEXT_134 = ", decryptedPassword_";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = "  " + NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_137 = " = new java.util.ArrayList<java.util.Map<String,String>>();  " + NL;
  protected final String TEXT_138 = NL + "    java.util.Map<String,String> map";
  protected final String TEXT_139 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_140 = ".put(";
  protected final String TEXT_141 = ",\"\");" + NL + "    list";
  protected final String TEXT_142 = ".add(map";
  protected final String TEXT_143 = ");       ";
  protected final String TEXT_144 = "  " + NL + "  String remotedir";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "  ftp_";
  protected final String TEXT_147 = ".chdir(remotedir";
  protected final String TEXT_148 = ");" + NL + "  String root";
  protected final String TEXT_149 = " = ftp_";
  protected final String TEXT_150 = ".pwd();" + NL + "" + NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_151 = " : list";
  protected final String TEXT_152 = ") {";
  protected final String TEXT_153 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");  
String fileOrDir = ElementParameterParser.getValue(node, "__FILE_OR_DIRECTORY__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
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
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if(useProxy){

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
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
      
if (sftp) {

  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_55);
    if (("PASSWORD").equals(authMethod)){ 
    stringBuffer.append(TEXT_56);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_57);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    if (!useProxy) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_83);
    } else {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(conn );
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
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    for (int i=0; i<files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_107);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    }
    } else {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_116);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    } else {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
	passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_125);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_128);
    } else {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    return stringBuffer.toString();
  }
}
