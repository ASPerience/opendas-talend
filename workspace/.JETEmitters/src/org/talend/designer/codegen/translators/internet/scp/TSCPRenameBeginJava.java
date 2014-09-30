package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPRenameBeginJava
{
  protected static String nl;
  public static synchronized TSCPRenameBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPRenameBeginJava result = new TSCPRenameBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "    /* Create a connection instance */" + NL + "\t";
  protected final String TEXT_3 = NL + "\t" + NL + "\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_4 = " = (ch.ethz.ssh2.Connection)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t";
  protected final String TEXT_6 = NL + NL + "    String hostname_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "    String username_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "              ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_12 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "              ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_15 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "              /* Now connect */" + NL + "        conn_";
  protected final String TEXT_19 = ".connect();";
  protected final String TEXT_20 = NL + "        java.io.File keyfile_";
  protected final String TEXT_21 = " = new java.io.File(";
  protected final String TEXT_22 = "); ";
  protected final String TEXT_23 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = "; ";
  protected final String TEXT_29 = NL + "        \t" + NL + "            boolean isAuthenticated_";
  protected final String TEXT_30 = " = conn_";
  protected final String TEXT_31 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_32 = ", keyfile_";
  protected final String TEXT_33 = ", decryptedPassword_";
  protected final String TEXT_34 = ");" + NL + "              if (isAuthenticated_";
  protected final String TEXT_35 = " == false)" + NL + "                      throw new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_36 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_37 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = "; ";
  protected final String TEXT_42 = NL + "\t\t\t" + NL + "        \tboolean isAuthenticated_";
  protected final String TEXT_43 = " = conn_";
  protected final String TEXT_44 = ".authenticateWithPassword(username_";
  protected final String TEXT_45 = ", decryptedPassword_";
  protected final String TEXT_46 = ");" + NL + "        if (isAuthenticated_";
  protected final String TEXT_47 = " == false)" + NL + "            throw new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_48 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_49 = " = conn_";
  protected final String TEXT_50 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_51 = ", " + NL + "            new ch.ethz.ssh2.InteractiveCallback() {" + NL + "        " + NL + "        \t\tpublic String[] replyToChallenge(String name," + NL + "        \t\t\t\tString instruction, int numPrompts," + NL + "        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "        \t\t\t\tthrows java.lang.Exception {" + NL + "        \t\t\t// TODO Auto-generated method stub" + NL + "        \t\t\tString[] reply = new String[numPrompts];";
  protected final String TEXT_52 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_53 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = "; ";
  protected final String TEXT_58 = NL + "\t        \t\t\t" + NL + "        \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "\t        \t\t\t\treply[i] = decryptedPassword_";
  protected final String TEXT_59 = ";" + NL + "        \t\t\t}" + NL + "        " + NL + "        \t\t\treturn reply;" + NL + "        \t\t}" + NL + "        \t}" + NL + "        );" + NL + "        if (isAuthenticated_";
  protected final String TEXT_60 = " == false)" + NL + "            throw new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_61 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
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
    
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	
	if(("true").equals(useExistingConn)){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		String conn= "conn_" + connection;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_10);
    
        if(("").equals(port)){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        } else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_17);
    
        }

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
            
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_22);
    
            String passwordFieldName = "__PASSPHRASE__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    } else {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
        }
        if (("PASSWORD").equals(authMethod)) {

    
            String passwordFieldName = "__PASSWORD__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_38);
    } else {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
        }
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    } else {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
        }
        
	}//if(useExistingConn)

    stringBuffer.append(TEXT_61);
    return stringBuffer.toString();
  }
}
