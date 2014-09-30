package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPOPBeginJava
{
  protected static String nl;
  public static synchronized TPOPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPOPBeginJava result = new TPOPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  " + NL + "String server_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";" + NL + "String mbox_";
  protected final String TEXT_4 = " = \"INBOX\";" + NL + "String user_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "String password_";
  protected final String TEXT_14 = " = decryptedPassword_";
  protected final String TEXT_15 = ";" + NL + "int port_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "int nb_email_";
  protected final String TEXT_18 = " = 0;" + NL + "javax.mail.Folder folder_";
  protected final String TEXT_19 = ";" + NL + "javax.mail.Session session_";
  protected final String TEXT_20 = ";" + NL + "javax.mail.Store store_";
  protected final String TEXT_21 = ";" + NL + "javax.mail.URLName url_";
  protected final String TEXT_22 = ";" + NL + "java.util.Properties props_";
  protected final String TEXT_23 = ";" + NL + "" + NL + "try {" + NL + "  props_";
  protected final String TEXT_24 = " = System.getProperties();" + NL + "} catch (SecurityException sex) {" + NL + "  props_";
  protected final String TEXT_25 = " = new java.util.Properties();" + NL + "}";
  protected final String TEXT_26 = NL + "    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());" + NL + "    props_";
  protected final String TEXT_27 = ".setProperty(\"mail.pop3.socketFactory.class\", \"javax.net.ssl.SSLSocketFactory\");      " + NL + "    props_";
  protected final String TEXT_28 = ".setProperty(\"mail.pop3.socketFactory.fallback\", \"false\");" + NL + "    props_";
  protected final String TEXT_29 = ".setProperty(\"mail.pop3.socketFactory.port\", port_";
  protected final String TEXT_30 = " + \"\");";
  protected final String TEXT_31 = NL + "    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());" + NL + "    props_";
  protected final String TEXT_32 = ".setProperty(\"mail.imap.socketFactory.class\", \"javax.net.ssl.SSLSocketFactory\");" + NL + "    props_";
  protected final String TEXT_33 = ".setProperty(\"mail.imap.socketFactory.fallback\", \"false\");" + NL + "    props_";
  protected final String TEXT_34 = ".setProperty(\"mail.imap.socketFactory.port\", port_";
  protected final String TEXT_35 = " + \"\");    ";
  protected final String TEXT_36 = NL + "  session_";
  protected final String TEXT_37 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_38 = ", null);" + NL + "  store_";
  protected final String TEXT_39 = " = session_";
  protected final String TEXT_40 = ".getStore(\"";
  protected final String TEXT_41 = "\");" + NL + "  store_";
  protected final String TEXT_42 = ".connect(server_";
  protected final String TEXT_43 = ", port_";
  protected final String TEXT_44 = ", user_";
  protected final String TEXT_45 = ", password_";
  protected final String TEXT_46 = ");" + NL + "  folder_";
  protected final String TEXT_47 = " = store_";
  protected final String TEXT_48 = ".getDefaultFolder();" + NL + "" + NL + "  if (folder_";
  protected final String TEXT_49 = " == null) {" + NL + "    throw new RuntimeException(\"No default folder\");" + NL + "  }" + NL + "  // its INBOX" + NL + "  folder_";
  protected final String TEXT_50 = " = folder_";
  protected final String TEXT_51 = ".getFolder(mbox_";
  protected final String TEXT_52 = ");" + NL + "" + NL + "  if (folder_";
  protected final String TEXT_53 = " == null){" + NL + "    throw new RuntimeException(\"No POP3 INBOX\");" + NL + "  }";
  protected final String TEXT_54 = NL + "    mbox_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "  url_";
  protected final String TEXT_58 = " = new javax.mail.URLName(\"";
  protected final String TEXT_59 = "\", server_";
  protected final String TEXT_60 = ", -1, mbox_";
  protected final String TEXT_61 = ", user_";
  protected final String TEXT_62 = ", password_";
  protected final String TEXT_63 = ");" + NL + "  session_";
  protected final String TEXT_64 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_65 = ", null);" + NL + "  store_";
  protected final String TEXT_66 = " = new com.sun.mail.imap.IMAPStore(session_";
  protected final String TEXT_67 = ", url_";
  protected final String TEXT_68 = ");" + NL + "  store_";
  protected final String TEXT_69 = ".connect();" + NL + "  folder_";
  protected final String TEXT_70 = " = store_";
  protected final String TEXT_71 = ".getFolder(mbox_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = " " + NL + "" + NL + "try {" + NL + "  folder_";
  protected final String TEXT_74 = ".open(javax.mail.Folder.READ_WRITE);" + NL + "} catch (java.lang.Exception e){" + NL + "  folder_";
  protected final String TEXT_75 = ".open(javax.mail.Folder.READ_ONLY);" + NL + "}" + NL + "javax.mail.Message[] msgs_";
  protected final String TEXT_76 = " = folder_";
  protected final String TEXT_77 = ".getMessages();" + NL + "" + NL + "for (int counter_";
  protected final String TEXT_78 = " = 0; counter_";
  protected final String TEXT_79 = " < msgs_";
  protected final String TEXT_80 = ".length; counter_";
  protected final String TEXT_81 = "++) {";
  protected final String TEXT_82 = NL + "    if(nb_email_";
  protected final String TEXT_83 = " >= ";
  protected final String TEXT_84 = ") break; ";
  protected final String TEXT_85 = NL + "  javax.mail.Message message_";
  protected final String TEXT_86 = " = msgs_";
  protected final String TEXT_87 = "[counter_";
  protected final String TEXT_88 = "];" + NL + "  " + NL + "  try {" + NL + "    boolean isMatch_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = ";" + NL + "  ";
  protected final String TEXT_91 = NL + "        java.util.regex.Pattern pattern_";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_94 = ");" + NL + "        java.util.regex.Matcher matcher_";
  protected final String TEXT_95 = "_";
  protected final String TEXT_96 = " = pattern_";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = ".matcher(message_";
  protected final String TEXT_99 = ".getSubject()==null?\"\":message_";
  protected final String TEXT_100 = ".getSubject());" + NL + "        isMatch_";
  protected final String TEXT_101 = " = isMatch_";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = " matcher_";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = ".find();";
  protected final String TEXT_106 = NL + "        java.util.regex.Pattern pattern_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_109 = ");" + NL + "        java.util.regex.Matcher matcher_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = " = pattern_";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = ".matcher(message_";
  protected final String TEXT_114 = ".getFrom()[0]==null?\"\":message_";
  protected final String TEXT_115 = ".getFrom()[0].toString());" + NL + "        isMatch_";
  protected final String TEXT_116 = " = isMatch_";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = " matcher_";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ".find();";
  protected final String TEXT_121 = NL + "        java.util.regex.Pattern pattern_";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_124 = ");" + NL + "        java.util.regex.Matcher matcher_";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = " = null;" + NL + "\t\tjavax.mail.Address[] addr_";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = " = message_";
  protected final String TEXT_129 = ".getAllRecipients();" + NL + "\t\tboolean matcherFind_";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = " = false;" + NL + "\t\tfor(int matcher_";
  protected final String TEXT_132 = " = 0;matcher_";
  protected final String TEXT_133 = " < addr_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = ".length;matcher_";
  protected final String TEXT_136 = "++){" + NL + "\t\t\tmatcher_";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = " = pattern_";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = ".matcher(addr_";
  protected final String TEXT_141 = "_";
  protected final String TEXT_142 = "[matcher_";
  protected final String TEXT_143 = "]==null?\"\":addr_";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = "[matcher_";
  protected final String TEXT_146 = "].toString());" + NL + "\t\t\tmatcherFind_";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = " = matcher_";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = ".find()||matcherFind_";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = ";" + NL + "\t\t\tif(matcherFind_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = "){" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "        isMatch_";
  protected final String TEXT_155 = " = isMatch_";
  protected final String TEXT_156 = " ";
  protected final String TEXT_157 = " matcherFind_";
  protected final String TEXT_158 = "_";
  protected final String TEXT_159 = ";";
  protected final String TEXT_160 = NL + "        java.util.Date date_";
  protected final String TEXT_161 = "_";
  protected final String TEXT_162 = " = null;" + NL + "  " + NL + "        try {" + NL + "          date_";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_165 = ", \"dd-MM-yyyy HH:mm:ss\");" + NL + "        } catch (java.lang.Exception e){" + NL + "          date_";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_168 = ", \"dd-MM-yyyy\");" + NL + "        }" + NL + "  " + NL + "        if (date_";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = " != null) {" + NL + "          isMatch_";
  protected final String TEXT_171 = " = isMatch_";
  protected final String TEXT_172 = " ";
  protected final String TEXT_173 = " (message_";
  protected final String TEXT_174 = ".getSentDate()!=null && message_";
  protected final String TEXT_175 = ".getSentDate().";
  protected final String TEXT_176 = "before";
  protected final String TEXT_177 = "after";
  protected final String TEXT_178 = "(date_";
  protected final String TEXT_179 = "_";
  protected final String TEXT_180 = "));" + NL + "        }";
  protected final String TEXT_181 = NL + "      if (isMatch_";
  protected final String TEXT_182 = ") {";
  protected final String TEXT_183 = " " + NL + "      message_";
  protected final String TEXT_184 = ".setFlag(javax.mail.Flags.Flag.DELETED, true);";
  protected final String TEXT_185 = NL + "    String filename_";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ";" + NL + "    java.io.File file_";
  protected final String TEXT_188 = " = new java.io.File(";
  protected final String TEXT_189 = ", filename_";
  protected final String TEXT_190 = ");" + NL + "    java.io.OutputStream os_";
  protected final String TEXT_191 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_192 = ");" + NL + "    ";
  protected final String TEXT_193 = " " + NL + "    message_";
  protected final String TEXT_194 = ".writeTo(os_";
  protected final String TEXT_195 = ");" + NL + "    os_";
  protected final String TEXT_196 = ".close();" + NL + "    nb_email_";
  protected final String TEXT_197 = "++;" + NL + "    globalMap.put(\"";
  protected final String TEXT_198 = "_CURRENT_FILE\", filename_";
  protected final String TEXT_199 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_200 = "_CURRENT_FILEPATH\", file_";
  protected final String TEXT_201 = ".getAbsolutePath());";
  protected final String TEXT_202 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");

String port = ElementParameterParser.getValue(node, "__PORT__");
String outputDirectory = ElementParameterParser.getValue(node, "__OUTPUT_DIRECTORY__");
String filenamePattern = ElementParameterParser.getValue(node, "__FILENAME_PATTERN__");
String allEmails = ElementParameterParser.getValue(node, "__ALL_EMAILS__");
String maxEmails = ElementParameterParser.getValue(node, "__MAX_EMAILS__");
boolean bDeleteFromServer = "true".equals(ElementParameterParser.getValue(node, "__DELETE_FROM_SERVER__"));
String protocol = ElementParameterParser.getValue(node, "__PROTOCOL__");
List<Map<String, String>> filterList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_FILTER__");
String condition = ElementParameterParser.getValue(node, "__FILTER_RELATION__");
boolean useSSL = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_6);
    
String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
if (useSSL) {
  if ("pop3".equals(protocol)){
  
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
  } else {
  
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
  }
}

if ("pop3".equals(protocol)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(protocol);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
} else {
  if ("true".equals(ElementParameterParser.getValue(node, "__SPECIFY_MAIL_FOLDER__"))){
  
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAIL_FOLDER__"));
    stringBuffer.append(TEXT_56);
    
  }
  
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(protocol);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
}

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
    if ("false".equals(allEmails)) {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(maxEmails);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(("&&").equals(condition) ? "true" : "false");
    stringBuffer.append(TEXT_90);
    
    for (int i = 0;i < filterList.size(); i++) {
      String filterItem = filterList.get(i).get("FILTER_TIEM");
      String filterptn = filterList.get(i).get("PATTERN");
  
      if ("Subject".equals(filterItem)) {
      
    stringBuffer.append(TEXT_91);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    
      } else if ("From".equals(filterItem)) {
      
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
      } else if ("To".equals(filterItem)) {
      
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
      } else {
      
    stringBuffer.append(TEXT_160);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    if ("BeforeDate".equals(filterItem)){
    stringBuffer.append(TEXT_176);
    }else if("AfterDate".equals(filterItem)){
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
      }
    }
          
    if (filterList.size()>0){
    
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
    }
    
    if (bDeleteFromServer){
    
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(filenamePattern );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(outputDirectory );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
    //for bug TDI-21323

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(TEXT_202);
    return stringBuffer.toString();
  }
}
