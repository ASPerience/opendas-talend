package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPGetBeginJava
{
  protected static String nl;
  public static synchronized TFTPGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetBeginJava result = new TFTPGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");" + NL + "\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();" + NL + "\t";
  protected final String TEXT_5 = NL + "int nb_file_";
  protected final String TEXT_6 = " = 0;";
  protected final String TEXT_7 = NL + "  java.util.Properties props_";
  protected final String TEXT_8 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_10 = ");" + NL + "  props_";
  protected final String TEXT_11 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_12 = ");" + NL + "  props_";
  protected final String TEXT_13 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_16 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "; ";
  protected final String TEXT_21 = NL + "  props_";
  protected final String TEXT_22 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_23 = ");        ";
  protected final String TEXT_24 = "  " + NL + "  final java.util.List<String> msg_";
  protected final String TEXT_25 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_26 = NL + "    class MyUserInfo_";
  protected final String TEXT_27 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {";
  protected final String TEXT_28 = " " + NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_29 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "  \t\tString decryptedPassphrase_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = "; ";
  protected final String TEXT_34 = NL + "\t  String passphrase_";
  protected final String TEXT_35 = " = decryptedPassphrase_";
  protected final String TEXT_36 = ";" + NL + "" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_37 = "; }" + NL + "" + NL + "      public String getPassword() { return null; } " + NL + "" + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "      boolean[] echo) {" + NL + "\t\t";
  protected final String TEXT_38 = " " + NL + "    \t";
  protected final String TEXT_39 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; ";
  protected final String TEXT_45 = NL + "\t\tString[] password_";
  protected final String TEXT_46 = " = {decryptedPassword_";
  protected final String TEXT_47 = "};" + NL + "        return password_";
  protected final String TEXT_48 = ";" + NL + "      }" + NL + "    }; " + NL + "" + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_49 = " = new MyUserInfo_";
  protected final String TEXT_50 = "();";
  protected final String TEXT_51 = NL + NL + "  class MyProgressMonitor_";
  protected final String TEXT_52 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "" + NL + "    private long percent = -1;" + NL + "" + NL + "    public void init(int op, String src, String dest, long max) {}" + NL + "" + NL + "    public boolean count(long count) {return true;}" + NL + "" + NL + "    public void end() {}" + NL + "  } " + NL + "" + NL + "  class SFTPGetter_";
  protected final String TEXT_53 = " {" + NL + "" + NL + "    private com.jcraft.jsch.ChannelSftp cnlSFTP = null;" + NL + "" + NL + "    private com.jcraft.jsch.SftpProgressMonitor monitor = null;" + NL + "" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "      cnlSFTP.cd(remoteDirectory);" + NL + "      java.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "      for (Object sftpFile : sftpFiles) {" + NL + "        com.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "        com.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "        if ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "          continue;" + NL + "        }" + NL + "" + NL + "        if (attrs.isDir()) {" + NL + "          java.io.File localFile = new java.io.File(localDirectory + \"/\" + lsEntry.getFilename());" + NL + "" + NL + "          if (!localFile.exists()) {" + NL + "            localFile.mkdir();" + NL + "          }" + NL + "          getAllFiles(remoteDirectory + \"/\" + lsEntry.getFilename(), localDirectory + \"/\" + lsEntry.getFilename());" + NL + "          cnlSFTP.cd(remoteDirectory);" + NL + "        } else if (!attrs.isLink()) {" + NL + "          downloadFile(localDirectory, lsEntry.getFilename());" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "      cnlSFTP.cd(remoteDirectory);" + NL + "      java.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "      for (Object sftpFile : sftpFiles) {" + NL + "        com.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "        com.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "        if ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "          continue;" + NL + "        }" + NL + "" + NL + "        if (!attrs.isDir() && !attrs.isLink()) {" + NL + "" + NL + "          if (lsEntry.getFilename().matches(maskStr)) {" + NL + "            downloadFile(localDirectory, lsEntry.getFilename());" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) throws com.jcraft.jsch.SftpException{" + NL + "      cnlSFTP.cd(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() throws com.jcraft.jsch.SftpException{" + NL + "      return cnlSFTP.pwd();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) throws com.jcraft.jsch.SftpException {" + NL + "" + NL + "      try {" + NL + "        cnlSFTP.get(remoteFileName, localFileName, monitor,";
  protected final String TEXT_54 = "          " + NL + "            com.jcraft.jsch.ChannelSftp.OVERWRITE";
  protected final String TEXT_55 = NL + "            com.jcraft.jsch.ChannelSftp.APPEND";
  protected final String TEXT_56 = NL + "            com.jcraft.jsch.ChannelSftp.RESUME";
  protected final String TEXT_57 = NL + "        );" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_59 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_60 = ".delete(0,log4jSb_";
  protected final String TEXT_61 = ".length());" + NL + "\t\t";
  protected final String TEXT_62 = NL + "        msg_";
  protected final String TEXT_63 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_64 = NL + "          System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_65 = NL + "        globalMap.put(\"";
  protected final String TEXT_66 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "      } catch (com.jcraft.jsch.SftpException e){" + NL + "" + NL + "        if (e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_FAILURE || e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_BAD_MESSAGE) {" + NL + "          msg_";
  protected final String TEXT_67 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "          globalMap.put(\"";
  protected final String TEXT_68 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "        }" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_70 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_71 = NL + "        throw e;" + NL + "      }" + NL + "      count++;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_72 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_73 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_74 = "\");" + NL + "\t";
  protected final String TEXT_75 = NL + "\t\tif(c_";
  protected final String TEXT_76 = "!=null && c_";
  protected final String TEXT_77 = ".getSession()!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_78 = " - Uses an existing connection as \" + c_";
  protected final String TEXT_79 = ".getSession().getUserName() + \". Connection hostname: \" + c_";
  protected final String TEXT_80 = ".getSession().getHost() + \". Connection port: \" + c_";
  protected final String TEXT_81 = ".getSession().getPort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_82 = NL + "    if(c_";
  protected final String TEXT_83 = ".getHome()!=null && !c_";
  protected final String TEXT_84 = ".getHome().equals(c_";
  protected final String TEXT_85 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_86 = ".cd(c_";
  protected final String TEXT_87 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_88 = "    " + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_89 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_90 = NL + "\t  ";
  protected final String TEXT_91 = NL + "\t\tlog.info(\"";
  protected final String TEXT_92 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_93 = " + \"'.\");" + NL + "\t  ";
  protected final String TEXT_94 = NL + "      jsch_";
  protected final String TEXT_95 = ".addIdentity(";
  protected final String TEXT_96 = ", defaultUserInfo_";
  protected final String TEXT_97 = ".getPassphrase());";
  protected final String TEXT_98 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_99 = "=jsch_";
  protected final String TEXT_100 = ".getSession(";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ");" + NL;
  protected final String TEXT_104 = NL + "\t  ";
  protected final String TEXT_105 = NL + "\t\tlog.info(\"";
  protected final String TEXT_106 = " - SFTP authentication using a password.\");" + NL + "\t  ";
  protected final String TEXT_107 = NL + "\t  ";
  protected final String TEXT_108 = " " + NL + "\t  ";
  protected final String TEXT_109 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_110 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = "; ";
  protected final String TEXT_115 = NL + "      session_";
  protected final String TEXT_116 = ".setPassword(decryptedPassword_";
  protected final String TEXT_117 = "); ";
  protected final String TEXT_118 = NL + NL + "    session_";
  protected final String TEXT_119 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_120 = "); " + NL + "\t";
  protected final String TEXT_121 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_122 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_123 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_124 = ".setProxy(proxy_";
  protected final String TEXT_125 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_126 = NL + "\t";
  protected final String TEXT_127 = NL + "\t\tlog.info(\"";
  protected final String TEXT_128 = " - Connection attempt to '\" + ";
  protected final String TEXT_129 = " + \"' as '\" + ";
  protected final String TEXT_130 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_131 = NL + "    session_";
  protected final String TEXT_132 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_133 = "=session_";
  protected final String TEXT_134 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_135 = ".connect();" + NL + "\t";
  protected final String TEXT_136 = NL + "\t\tlog.info(\"";
  protected final String TEXT_137 = " - Connection to '\" + ";
  protected final String TEXT_138 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_139 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_140 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_141 = ";" + NL + "    c_";
  protected final String TEXT_142 = ".setFilenameEncoding(";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "  com.jcraft.jsch.SftpProgressMonitor monitor_";
  protected final String TEXT_145 = " = new MyProgressMonitor_";
  protected final String TEXT_146 = "();" + NL + "  SFTPGetter_";
  protected final String TEXT_147 = " getter_";
  protected final String TEXT_148 = " = new SFTPGetter_";
  protected final String TEXT_149 = "();" + NL + "  getter_";
  protected final String TEXT_150 = ".cnlSFTP = c_";
  protected final String TEXT_151 = ";" + NL + "  getter_";
  protected final String TEXT_152 = ".monitor = monitor_";
  protected final String TEXT_153 = ";" + NL + "  String remotedir_";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = ";" + NL + "  c_";
  protected final String TEXT_156 = ".cd(remotedir_";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = "  " + NL + "  final com.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_159 = " = new com.enterprisedt.net.ftp.TransferCompleteStrings();" + NL + "" + NL + "  class FTPGetter_";
  protected final String TEXT_160 = " {" + NL + "    private com.enterprisedt.net.ftp.FTPClient ftpClient = null;" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory) throws java.io.IOException, " + NL + "      com.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "" + NL + "      ftpClient.chdir(remoteDirectory);" + NL + "      String path = ftpClient.pwd();" + NL + "      String[] ftpFileNames = null;" + NL + "      com.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "      try{" + NL + "        //use dir() for Bug9562 with FTP server in AS400" + NL + "        ftpFileNames = ftpClient.dir(null, false);" + NL + "        //Bug 13272, the same as getFiles()." + NL + "      } catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_162 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_163 = NL + "        ftpFileNames = null;" + NL + "        ftpFiles = ftpClient.dirDetails(\".\");" + NL + "      }" + NL + "" + NL + "      //if dirDetails(...) doesn't work, then use dir(...), distinguish file type by FTPException" + NL + "" + NL + "      if ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "        //if the file is folder, catch the FTPException and recur" + NL + "        for (String ftpFileName : ftpFileNames){" + NL + "          try {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "          } catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_165 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_166 = NL + "            java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFileName);" + NL + "            " + NL + "            if (!localFile.exists()) {" + NL + "              localFile.mkdir();" + NL + "            }" + NL + "            getAllFiles(path + \"/\" + ftpFileName, localDirectory + \"/\" + ftpFileName);" + NL + "            ftpClient.chdir(path);" + NL + "          }" + NL + "        }" + NL + "      } else {" + NL + "        for (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "          if (ftpFile.isDir()) {" + NL + "            if ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "              java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "              if (!localFile.exists()) {" + NL + "                localFile.mkdir();" + NL + "              }" + NL + "              getAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "              ftpClient.chdir(path);" + NL + "            }" + NL + "          } else if (!ftpFile.isLink()) {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws java.io.IOException," + NL + "      com.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "      ftpClient.chdir(remoteDirectory);" + NL + "      String[] ftpFileNames = null;" + NL + "      com.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "      try {" + NL + "        //use dir() for Bug9562 with FTP server in AS400 (the same way as getAllFiles())" + NL + "        ftpFileNames = ftpClient.dir(null, false);" + NL + "        //Bug 13272, if dir() throw exception, use dirDetails()." + NL + "      } catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t";
  protected final String TEXT_167 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_168 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_169 = NL + "        ftpFileNames = null;" + NL + "        ftpFiles = ftpClient.dirDetails(\".\");" + NL + "      }" + NL + "      //if dirDetails(...) doesn't work, then use dir(...), but can not distinguish file type" + NL + "" + NL + "      if ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "        for (String ftpFileName : ftpFileNames) {" + NL + "          if (ftpFileName.matches(maskStr)) {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "          }" + NL + "        }" + NL + "      } else{" + NL + "" + NL + "        for (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "          if (!ftpFile.isDir() && !ftpFile.isLink()) {" + NL + "            String fileName = ftpFile.getName();" + NL + "" + NL + "            if (fileName.matches(maskStr)) {" + NL + "              downloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "            }" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "      ftpClient.chdir(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "      return ftpClient.pwd();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) throws java.io.IOException, com.enterprisedt.net.ftp.FTPException {" + NL + "      java.io.File localFile = new java.io.File(localFileName);" + NL + "" + NL + "      try {";
  protected final String TEXT_170 = NL + "          java.io.FileOutputStream fout = new java.io.FileOutputStream(localFile, true);" + NL + "          ftpClient.get(fout, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_172 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_173 = ".delete(0,log4jSb_";
  protected final String TEXT_174 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_175 = NL + "          msg_";
  protected final String TEXT_176 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_177 = NL + "            System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_178 = NL + "          globalMap.put(\"";
  protected final String TEXT_179 = "_CURRENT_STATUS\", \"File transfer OK.\");";
  protected final String TEXT_180 = NL + "          if (!localFile.exists()) {" + NL + "            ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_182 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_183 = ".delete(0,log4jSb_";
  protected final String TEXT_184 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "            msg_";
  protected final String TEXT_186 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_187 = NL + "              System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_188 = NL + "            globalMap.put(\"";
  protected final String TEXT_189 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "          } else { " + NL + "            msg_";
  protected final String TEXT_190 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "            globalMap.put(\"";
  protected final String TEXT_191 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "          }";
  protected final String TEXT_192 = NL + "          ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_194 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_195 = ".delete(0,log4jSb_";
  protected final String TEXT_196 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_197 = NL + "          msg_";
  protected final String TEXT_198 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_199 = NL + "            System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_200 = NL + "          if (localFile.exists()) {" + NL + "            long ftpSize = ftpClient.size(remoteFileName);" + NL + "            long localSize = localFile.length();" + NL + "" + NL + "            if (ftpSize != localSize) {" + NL + "              ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_202 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_203 = ".delete(0,log4jSb_";
  protected final String TEXT_204 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_205 = NL + "              msg_";
  protected final String TEXT_206 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_207 = NL + "              \tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_208 = NL + "              globalMap.put(\"";
  protected final String TEXT_209 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "            } else {" + NL + "              msg_";
  protected final String TEXT_210 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "              globalMap.put(\"";
  protected final String TEXT_211 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "            }" + NL + "          } else {" + NL + "            ftpClient.get(localFileName, remoteFileName);" + NL + "            msg_";
  protected final String TEXT_212 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_213 = NL + "              System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_214 = NL + "            globalMap.put(\"";
  protected final String TEXT_215 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "          }";
  protected final String TEXT_216 = NL + "      } catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "        msg_";
  protected final String TEXT_217 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_218 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "\t\t";
  protected final String TEXT_219 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_220 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_221 = NL + "        throw e;" + NL + "      }" + NL + "      count++;" + NL + "    }" + NL + "  }" + NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_222 = " = null;" + NL;
  protected final String TEXT_223 = NL + "    ftp_";
  protected final String TEXT_224 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_225 = "\");" + NL + "  \t";
  protected final String TEXT_226 = NL + "  \t\tString rootDir_";
  protected final String TEXT_227 = " = ftp_";
  protected final String TEXT_228 = ".pwd();" + NL + "  \t";
  protected final String TEXT_229 = NL + "\t";
  protected final String TEXT_230 = NL + "\t\tif(ftp_";
  protected final String TEXT_231 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_232 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_233 = ".getRemoteHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_234 = ".getRemotePort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_235 = "    " + NL + "    ftp_";
  protected final String TEXT_236 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_237 = ".setRemoteHost(";
  protected final String TEXT_238 = ");" + NL + "    ftp_";
  protected final String TEXT_239 = ".setRemotePort(";
  protected final String TEXT_240 = ");" + NL;
  protected final String TEXT_241 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_242 = " - \" + ";
  protected final String TEXT_243 = ");" + NL + "\t";
  protected final String TEXT_244 = NL + "      ftp_";
  protected final String TEXT_245 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_246 = NL + "      ftp_";
  protected final String TEXT_247 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_248 = NL + "    ftp_";
  protected final String TEXT_249 = ".setControlEncoding(";
  protected final String TEXT_250 = ");" + NL + "\t";
  protected final String TEXT_251 = NL + "\t\tlog.info(\"";
  protected final String TEXT_252 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_253 = " - Connection attempt to '\" + ";
  protected final String TEXT_254 = " + \"' as '\" +";
  protected final String TEXT_255 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_256 = NL + "    ftp_";
  protected final String TEXT_257 = ".connect();" + NL + "\t";
  protected final String TEXT_258 = " " + NL + "\t";
  protected final String TEXT_259 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_260 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_263 = " = ";
  protected final String TEXT_264 = "; ";
  protected final String TEXT_265 = NL + "\tftp_";
  protected final String TEXT_266 = ".login(";
  protected final String TEXT_267 = ", decryptedPassword_";
  protected final String TEXT_268 = ");  " + NL + "\t";
  protected final String TEXT_269 = NL + "\t\tlog.info(\"";
  protected final String TEXT_270 = " - Connection to '\" + ";
  protected final String TEXT_271 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_272 = "  ";
  protected final String TEXT_273 = NL + "  msg_";
  protected final String TEXT_274 = ".clearAll();" + NL + "  FTPGetter_";
  protected final String TEXT_275 = " getter_";
  protected final String TEXT_276 = " = new FTPGetter_";
  protected final String TEXT_277 = "();" + NL + "  getter_";
  protected final String TEXT_278 = ".ftpClient = ftp_";
  protected final String TEXT_279 = ";" + NL + "  String remotedir_";
  protected final String TEXT_280 = " = ";
  protected final String TEXT_281 = ";" + NL + "  ftp_";
  protected final String TEXT_282 = ".chdir(remotedir_";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "  class FTPSGetter_";
  protected final String TEXT_285 = " {" + NL + "    private it.sauronsoftware.ftp4j.FTPClient ftpClient = null;" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory)" + NL + "      throws IllegalStateException, IOException, java.io.FileNotFoundException," + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException, " + NL + "      it.sauronsoftware.ftp4j.FTPListParseException {" + NL + "" + NL + "      ftpClient.changeDirectory(remoteDirectory);" + NL + "      String path = ftpClient.currentDirectory();" + NL + "      it.sauronsoftware.ftp4j.FTPFile[] ftpFiles = null;" + NL + "      ftpFiles = ftpClient.list();" + NL + "" + NL + "      for (it.sauronsoftware.ftp4j.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "        if (ftpFile.getType() == it.sauronsoftware.ftp4j.FTPFile.TYPE_DIRECTORY) {" + NL + "" + NL + "          if ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "            java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "            if (!localFile.exists()) {" + NL + "              localFile.mkdir();" + NL + "            }" + NL + "            getAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "            ftpClient.changeDirectory(path);" + NL + "          }" + NL + "        } else if (ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_LINK) {" + NL + "          downloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) " + NL + "      throws IllegalStateException, IOException, java.io.FileNotFoundException," + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException, " + NL + "      it.sauronsoftware.ftp4j.FTPListParseException {" + NL + "" + NL + "      ftpClient.changeDirectory(remoteDirectory);" + NL + "      it.sauronsoftware.ftp4j.FTPFile[] ftpFiles = null;" + NL + "      ftpFiles = ftpClient.list(\".\");" + NL + "" + NL + "      for(it.sauronsoftware.ftp4j.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "        if ((ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_DIRECTORY) && (ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_LINK)) {" + NL + "          String fileName = ftpFile.getName();" + NL + "" + NL + "          if (fileName.matches(maskStr)) {" + NL + "            downloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) " + NL + "      throws IllegalStateException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException {" + NL + "      ftpClient.changeDirectory(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() " + NL + "      throws IllegalStateException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException {" + NL + "      return ftpClient.currentDirectory();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) " + NL + "      throws IllegalStateException, java.io.FileNotFoundException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException {" + NL + "      " + NL + "      java.io.File localFile = new java.io.File(localFileName);" + NL + "      ftpClient.download(remoteFileName, localFile);" + NL + "\t\t";
  protected final String TEXT_286 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_287 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_288 = ".delete(0,log4jSb_";
  protected final String TEXT_289 = ".length());" + NL + "\t\t";
  protected final String TEXT_290 = NL + "      count++;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_291 = NL + NL + "    class MyTrust_";
  protected final String TEXT_292 = "{" + NL + "      private javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "        throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "        java.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "        java.io.FileNotFoundException, java.io.IOException {" + NL + "" + NL + "        java.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL + "\t\t";
  protected final String TEXT_293 = " " + NL + "      \tString decryptedKeyStorePassword_";
  protected final String TEXT_294 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "      \tString decryptedKeyStorePassword_";
  protected final String TEXT_297 = " = ";
  protected final String TEXT_298 = "; ";
  protected final String TEXT_299 = NL + "\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_300 = "), decryptedKeyStorePassword_";
  protected final String TEXT_301 = ".toCharArray());" + NL + "        javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        tmf.init(ks);" + NL + "        return tmf.getTrustManagers();" + NL + "      }" + NL + "    }" + NL + "    MyTrust_";
  protected final String TEXT_302 = " myTrust_";
  protected final String TEXT_303 = "= null;";
  protected final String TEXT_304 = NL + "  javax.net.ssl.SSLContext sslContext = null;" + NL + "  javax.net.ssl.TrustManager[] trustManager = null;" + NL + "  javax.net.ssl.SSLSocketFactory sslSocketFactory = null;" + NL + "  it.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_305 = " =null;" + NL + "  FTPSGetter_";
  protected final String TEXT_306 = " getter_";
  protected final String TEXT_307 = " = null;" + NL + "  String remotedir_";
  protected final String TEXT_308 = " = null;" + NL + "" + NL + "  try {";
  protected final String TEXT_309 = NL + "      sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "      myTrust_";
  protected final String TEXT_310 = " = new MyTrust_";
  protected final String TEXT_311 = "();" + NL + "      trustManager = myTrust_";
  protected final String TEXT_312 = ".getTrustManagers();" + NL + "      sslContext.init(null, trustManager, new java.security.SecureRandom());" + NL + "      sslSocketFactory = sslContext.getSocketFactory();" + NL + "      ftp_";
  protected final String TEXT_313 = " = new it.sauronsoftware.ftp4j.FTPClient();" + NL + "      ftp_";
  protected final String TEXT_314 = ".setSSLSocketFactory(sslSocketFactory);";
  protected final String TEXT_315 = NL + "\t\tftp_";
  protected final String TEXT_316 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS);";
  protected final String TEXT_317 = NL + "    \tftp_";
  protected final String TEXT_318 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES);";
  protected final String TEXT_319 = NL + "\t  ";
  protected final String TEXT_320 = NL + "\t\tlog.info(\"";
  protected final String TEXT_321 = " - FTPS authentication (";
  protected final String TEXT_322 = ").\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_323 = " - Connection attempt to '\" + ";
  protected final String TEXT_324 = " + \"' as '\" + ";
  protected final String TEXT_325 = "+ \"'.\");" + NL + "\t  ";
  protected final String TEXT_326 = NL + "      ftp_";
  protected final String TEXT_327 = ".connect(";
  protected final String TEXT_328 = ",";
  protected final String TEXT_329 = ");" + NL + "\t\t";
  protected final String TEXT_330 = " " + NL + "    \t";
  protected final String TEXT_331 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_332 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_333 = ");";
  protected final String TEXT_334 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_335 = " = ";
  protected final String TEXT_336 = "; ";
  protected final String TEXT_337 = NL + "\t\tftp_";
  protected final String TEXT_338 = ".login(";
  protected final String TEXT_339 = ", decryptedPassword_";
  protected final String TEXT_340 = ");" + NL + "\t  \t";
  protected final String TEXT_341 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_342 = " - Connection to '\" + ";
  protected final String TEXT_343 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_344 = NL + "      ftp_";
  protected final String TEXT_345 = " = (it.sauronsoftware.ftp4j.FTPClient)globalMap.get(\"";
  protected final String TEXT_346 = "\");" + NL + "\t  ";
  protected final String TEXT_347 = NL + "\t\tif(ftp_";
  protected final String TEXT_348 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_349 = " - Uses an existing connection as \" + ftp_";
  protected final String TEXT_350 = ".getUsername() + \". Connection hostname: \" + ftp_";
  protected final String TEXT_351 = ".getHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_352 = ".getPort() + \".\"); " + NL + "\t\t}" + NL + "\t  ";
  protected final String TEXT_353 = NL + "    getter_";
  protected final String TEXT_354 = " = new FTPSGetter_";
  protected final String TEXT_355 = "();" + NL + "    getter_";
  protected final String TEXT_356 = ".ftpClient = ftp_";
  protected final String TEXT_357 = ";" + NL + "    remotedir_";
  protected final String TEXT_358 = " = ";
  protected final String TEXT_359 = ";" + NL + "    ftp_";
  protected final String TEXT_360 = ".changeDirectory(remotedir_";
  protected final String TEXT_361 = ");" + NL + "  } catch (java.lang.IllegalStateException e) {" + NL + "\t";
  protected final String TEXT_362 = NL + "\t\tlog.error(\"";
  protected final String TEXT_363 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_364 = NL + "    e.printStackTrace();" + NL + "  } catch (java.io.IOException e) {" + NL + "\t";
  protected final String TEXT_365 = NL + "\t\tlog.error(\"";
  protected final String TEXT_366 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_367 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) {" + NL + "\t";
  protected final String TEXT_368 = NL + "\t\tlog.error(\"";
  protected final String TEXT_369 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_370 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPException e) {" + NL + "\t";
  protected final String TEXT_371 = NL + "\t\tlog.error(\"";
  protected final String TEXT_372 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_373 = NL + "    e.printStackTrace();" + NL + "  }";
  protected final String TEXT_374 = NL + "java.util.List<String> maskList_";
  protected final String TEXT_375 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_376 = "    " + NL + "  maskList_";
  protected final String TEXT_377 = ".add(";
  protected final String TEXT_378 = ");       ";
  protected final String TEXT_379 = "  " + NL + "    ftp_";
  protected final String TEXT_380 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_381 = "  " + NL + "    ftp_";
  protected final String TEXT_382 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_383 = NL + "String localdir_";
  protected final String TEXT_384 = "  = ";
  protected final String TEXT_385 = ";  " + NL + "//create folder if local direcotry (assigned by property) not exists" + NL + "java.io.File dirHandle_";
  protected final String TEXT_386 = " = new java.io.File(localdir_";
  protected final String TEXT_387 = ");" + NL + "" + NL + "if (!dirHandle_";
  protected final String TEXT_388 = ".exists()) {" + NL + "  dirHandle_";
  protected final String TEXT_389 = ".mkdirs();" + NL + "}" + NL + "String root_";
  protected final String TEXT_390 = " = getter_";
  protected final String TEXT_391 = ".pwd();" + NL;
  protected final String TEXT_392 = NL + "\tlog.info(\"";
  protected final String TEXT_393 = " - Downloading files from the server.\");";
  protected final String TEXT_394 = NL + "for (String maskStr_";
  protected final String TEXT_395 = " : maskList_";
  protected final String TEXT_396 = ") { ";
  protected final String TEXT_397 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

String overwrite = ElementParameterParser.getValue(node, "__OVERWRITE__");
String sftpoverwrite =ElementParameterParser.getValue(node, "__SFTPOVERWRITE__");
String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

String keystoreFile = ElementParameterParser.getValue(node,"__KEYSTORE_FILE__");

boolean append = "true".equals(ElementParameterParser.getValue(node, "__APPEND__"));
String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean bPrintMsg = "true".equals(ElementParameterParser.getValue(node, "__PRINT_MESSAGE__"));
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";
if ("true".equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for(INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.

if (useProxy){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_14);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
} 

if (sftp) { // *** sftp *** //

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
  if ("false".equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
      passwordFieldName = "__PASSPHRASE__";
      if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
      
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
    	passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_38);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
  }
  
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
          if (("overwrite").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_54);
    
          } else if (("append").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_55);
    
          } else if (("resume").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_56);
    
          }
          
    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    
  if ("true".equals(useExistingConn)){
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_74);
    if(isLog4jEnabled){
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
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
  } else{
  
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    if ("PUBLICKEY".equals(authMethod)){
    stringBuffer.append(TEXT_90);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_103);
    if("PASSWORD".equals(authMethod)){
    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    
	  passwordFieldName = "__PASSWORD__";
      
    stringBuffer.append(TEXT_108);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_111);
    } else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    if (!useProxy) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_143);
    
  }
  
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
} else if (!ftps) { // *** ftp *** //

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    if (append) {
    stringBuffer.append(TEXT_170);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    
        } else if ("never".equals(overwrite)){
        
    stringBuffer.append(TEXT_180);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_187);
    }
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
        } else if ("always".equals(overwrite)){
        
    stringBuffer.append(TEXT_192);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_199);
    }
    
        } else if ("size_differ".equals(overwrite)) {
        
    stringBuffer.append(TEXT_200);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    
        }
        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
      
  if ("true".equals(useExistingConn)){
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_225);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    }
    } else {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_240);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_243);
    }
    if (("ACTIVE").equals(connectMode)){
    
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
    }else{
    
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
    }
    
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_250);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_255);
    }
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    
	passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_258);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_261);
    } else {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    } 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    
} else { // *** ftps *** //

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
      
  if ("false".equals(useExistingConn)){
  
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
        passwordFieldName = "__KEYSTORE_PASS__";
        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_295);
    } else {
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_298);
    }
    stringBuffer.append(TEXT_299);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
  }
  
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
      
    if ("false".equals(useExistingConn)){
    
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
	if("IMPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    
	}else if("EXPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    
    }

    stringBuffer.append(TEXT_319);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_325);
    }
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_329);
    
    	passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_330);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_333);
    } else {
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_336);
    }
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_343);
    }
      
    } else {
      String conn= "conn_" + connection;
      
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_346);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    }
      
    }
    
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    }
    stringBuffer.append(TEXT_364);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    }
    stringBuffer.append(TEXT_367);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    }
    stringBuffer.append(TEXT_373);
    
}
// *** share code *** //

    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    
for (int i = 0; i < files.size(); i++) {
  Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_378);
    
}

if (!sftp && !ftps) { // *** ftp *** //
  if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
  
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    
  }else {  
  
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    
  }
}

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(TEXT_397);
    return stringBuffer.toString();
  }
}
