package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TSSHBeginJava
{
  protected static String nl;
  public static synchronized TSSHBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHBeginJava result = new TSSHBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");";
  protected final String TEXT_4 = NL + "\t\t\tfinal java.util.Vector<String> output_";
  protected final String TEXT_5 = " = new java.util.Vector<String>();";
  protected final String TEXT_6 = NL + "    String hostname_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "    String username_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "" + NL + "\tglobalMap.remove(\"";
  protected final String TEXT_11 = "_STDOUT\");" + NL + "\tglobalMap.remove(\"";
  protected final String TEXT_12 = "_STDERR\");" + NL + "" + NL + "\t/* Create a connection instance */" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection attempt to '\" +hostname_";
  protected final String TEXT_15 = " + \"' on the port '";
  protected final String TEXT_16 = "' as '\" + username_";
  protected final String TEXT_17 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_19 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_22 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_23 = ",Integer.parseInt(";
  protected final String TEXT_24 = " + \"\"));";
  protected final String TEXT_25 = NL + "\t\t/* Create a session */" + NL + "\t\tch.ethz.ssh2.Session sess_";
  protected final String TEXT_26 = " = null;" + NL + "              /* Now connect */";
  protected final String TEXT_27 = NL + "\t\t\t  conn_";
  protected final String TEXT_28 = ".connect(null,0,";
  protected final String TEXT_29 = "*1000);";
  protected final String TEXT_30 = NL + "\t\t\t  conn_";
  protected final String TEXT_31 = ".connect();";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Authentication using a public key.\");" + NL + "\t\t";
  protected final String TEXT_35 = NL + "        java.io.File keyfile_";
  protected final String TEXT_36 = " = new java.io.File(";
  protected final String TEXT_37 = "); ";
  protected final String TEXT_38 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + "        " + NL + "\t\t    boolean isAuthenticated_";
  protected final String TEXT_45 = " = conn_";
  protected final String TEXT_46 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_47 = ", keyfile_";
  protected final String TEXT_48 = ", decryptedPassword_";
  protected final String TEXT_49 = ");" + NL + "\t\t\t  if (isAuthenticated_";
  protected final String TEXT_50 = " == false){" + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_52 = " - Authentication failed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t      throw new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t  }";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Authentication using a password.\");" + NL + "\t\t";
  protected final String TEXT_57 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_58 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "; ";
  protected final String TEXT_63 = NL + "\t\t" + NL + "        boolean isAuthenticated_";
  protected final String TEXT_64 = " = conn_";
  protected final String TEXT_65 = ".authenticateWithPassword(username_";
  protected final String TEXT_66 = ", decryptedPassword_";
  protected final String TEXT_67 = ");" + NL + "\t\t\tif (isAuthenticated_";
  protected final String TEXT_68 = " == false){" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_70 = " - Authentication failed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\tthrow new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t}";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Authentication using an interactive action.\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_76 = " = conn_";
  protected final String TEXT_77 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_78 = ", " + NL + "            new ch.ethz.ssh2.InteractiveCallback() {" + NL + "        " + NL + "        \t\tpublic String[] replyToChallenge(String name," + NL + "        \t\t\t\tString instruction, int numPrompts," + NL + "        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "        \t\t\t\tthrows java.lang.Exception {" + NL + "        \t\t\t// TODO Auto-generated method stub" + NL + "        \t\t\tString[] reply = new String[numPrompts];";
  protected final String TEXT_79 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = "; ";
  protected final String TEXT_85 = NL + "        \t\t\t" + NL + "        \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "        \t\t\t\treply[i] = decryptedPassword_";
  protected final String TEXT_86 = ";" + NL + "        \t\t\t}" + NL + "        " + NL + "        \t\t\treturn reply;" + NL + "        \t\t}" + NL + "        \t}\t" + NL + "        );" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_87 = " == false){" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_89 = " - Authentication failed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "        \t}";
  protected final String TEXT_91 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_92 = " - Connection to '\" +hostname_";
  protected final String TEXT_93 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\tStringBuilder stringStdout_";
  protected final String TEXT_95 = " =new StringBuilder();" + NL + "        StringBuilder stringStderr_";
  protected final String TEXT_96 = " =new StringBuilder();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean stats = codeGenArgument.isStatistics();

List<IMetadataTable> metadatas = node.getMetadataList();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")); 
String cid = node.getUniqueName();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {

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
            "__USER__"
        );

        String authMethod = ElementParameterParser.getValue(
            node,
            "__AUTH_METHOD__"
        );

        String privatekey = ElementParameterParser.getValue(
            node,
            "__PRIVATEKEY__"
        );
        
        String useTimeout = ElementParameterParser.getValue(
            node,
            "__USE_TIMEOUT__"
        );

        String timeout = ElementParameterParser.getValue(
            node,
            "__TIMEOUT__"
        );
        
        String standardOutput  = ElementParameterParser.getValue(node, "__STANDARDOUTPUT__");
		String errorOuput  = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
		if (isLog4jEnabled) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		}
		if (("NORMAL_OUTPUT").equals(standardOutput)||("NORMAL_OUTPUT").equals(errorOuput)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    
        if(("").equals(port)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
        } else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_24);
    
        }

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
        if(("true").equals(useTimeout)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_29);
    
        } else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
        }
        
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_37);
    
        String passwordFieldName = "__PASSPHRASE__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    
        }
        if (("PASSWORD").equals(authMethod)) {

    stringBuffer.append(TEXT_54);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    
        String passwordFieldName = "__PASSWORD__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    
        }
        
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_72);
    if(isLog4jEnabled){
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
    
                    String passwordFieldName = "__PASSWORD__";
                    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    } else {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    
        }

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    
    }
}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    return stringBuffer.toString();
  }
}
