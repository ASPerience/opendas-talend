package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPFileExistsBeginJava
{
  protected static String nl;
  public static synchronized TSCPFileExistsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPFileExistsBeginJava result = new TSCPFileExistsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.info(\"";
  protected final String TEXT_4 = " - Start to work.\");" + NL + "\t";
  protected final String TEXT_5 = NL + NL + NL + "    /* Create a connection instance */" + NL + "\t";
  protected final String TEXT_6 = NL + "\t" + NL + "\t\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_7 = " = (ch.ethz.ssh2.Connection)globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\tif(conn_";
  protected final String TEXT_10 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Uses an existing connection. Connection hostname: \" + conn_";
  protected final String TEXT_12 = ".getHostname() + \". Connection port: \" + conn_";
  protected final String TEXT_13 = ".getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + "\t    String hostname_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "\t    String username_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "        ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_21 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "        ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_24 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "              /* Now connect */" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Connection attempt to '\" + hostname_";
  protected final String TEXT_30 = " + \"' as '\" + ";
  protected final String TEXT_31 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_32 = NL + "        conn_";
  protected final String TEXT_33 = ".connect();" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_35 = " - Connection to '\" + hostname_";
  protected final String TEXT_36 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_39 = " - Authentication using a public key\");" + NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_40 = " - Private key: '\" + ";
  protected final String TEXT_41 = " + \"'.\" );" + NL + "\t\t";
  protected final String TEXT_42 = NL + "        java.io.File keyfile_";
  protected final String TEXT_43 = " = new java.io.File(";
  protected final String TEXT_44 = "); ";
  protected final String TEXT_45 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_46 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "; ";
  protected final String TEXT_51 = NL + "\t        " + NL + "            boolean isAuthenticated_";
  protected final String TEXT_52 = " = conn_";
  protected final String TEXT_53 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_54 = ", keyfile_";
  protected final String TEXT_55 = ", decryptedPassword_";
  protected final String TEXT_56 = ");" + NL + "              if (isAuthenticated_";
  protected final String TEXT_57 = " == false){" + NL + "\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_59 = " - Authentication failed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + "                      throw new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t  }" + NL + "\t\t\t  ";
  protected final String TEXT_61 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_62 = " - Authentication succeeded.\");" + NL + "\t\t\t  ";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_65 = " - Authentication using a password\");" + NL + "\t\t";
  protected final String TEXT_66 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_67 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = "; ";
  protected final String TEXT_72 = NL + "\t\t\t" + NL + "\t        boolean isAuthenticated_";
  protected final String TEXT_73 = " = conn_";
  protected final String TEXT_74 = ".authenticateWithPassword(username_";
  protected final String TEXT_75 = ", decryptedPassword_";
  protected final String TEXT_76 = ");" + NL + "\t        if (isAuthenticated_";
  protected final String TEXT_77 = " == false){" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_79 = " - Authentication failed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t            throw new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_82 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_85 = " - Authentication using an interactive action\");" + NL + "\t\t";
  protected final String TEXT_86 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_87 = " = conn_";
  protected final String TEXT_88 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_89 = ", " + NL + "            new ch.ethz.ssh2.InteractiveCallback() {" + NL + "        " + NL + "        \t\tpublic String[] replyToChallenge(String name," + NL + "        \t\t\t\tString instruction, int numPrompts," + NL + "        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "        \t\t\t\tthrows java.lang.Exception {" + NL + "        \t\t\t// TODO Auto-generated method stub" + NL + "        \t\t\tString[] reply = new String[numPrompts];";
  protected final String TEXT_90 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_91 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = "; ";
  protected final String TEXT_96 = NL + "        \t\t\t\t" + NL + "        \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "        \t\t\t\t\treply[i] = decryptedPassword_";
  protected final String TEXT_97 = ";" + NL + "        \t\t\t}" + NL + "        " + NL + "        \t\t\treturn reply;" + NL + "        \t\t}" + NL + "        \t}\t" + NL + "        );" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_98 = " == false){" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_100 = " - Authentication failed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_103 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_104 = "\t\t";
  protected final String TEXT_105 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
        String cid = node.getUniqueName();

        String host = ElementParameterParser.getValue(
            node,
            "__HOST__"
        );

        String port = ElementParameterParser.getValue(
            node,
            "__PORT__"
        );

        String user = ElementParameterParser.getValue(
            node,
            "__USERNAME__"
        );

        String authMethod = ElementParameterParser.getValue(
            node,
            "__AUTH_METHOD__"
        );

        String privatekey = ElementParameterParser.getValue(
            node,
            "__PRIVATEKEY__"
        );

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	
	if(("true").equals(useExistingConn)){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		String conn= "conn_" + connection;
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_19);
    
        if(("").equals(port)){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
        } else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_26);
    
        }

    stringBuffer.append(TEXT_27);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
            
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_37);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_44);
    
            String passwordFieldName = "__PASSPHRASE__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    
        }
        if (("PASSWORD").equals(authMethod)) {

    stringBuffer.append(TEXT_63);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    
            String passwordFieldName = "__PASSWORD__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    
        }
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_83);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_92);
    } else {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    
        }
	}// if(existconn)

    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}
