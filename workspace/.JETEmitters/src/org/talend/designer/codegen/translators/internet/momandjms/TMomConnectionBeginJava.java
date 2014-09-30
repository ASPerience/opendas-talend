package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMomConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomConnectionBeginJava result = new TMomConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t/*---------------------------------------1.initial jms connection factry---------------------------------*/ " + NL + "" + NL + "\t\t\tString url_";
  protected final String TEXT_3 = " =\"\";";
  protected final String TEXT_4 = NL + "\t\t\turl_";
  protected final String TEXT_5 = " = \"failover:(\";" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_7 = " = url_";
  protected final String TEXT_8 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_10 = " = url_";
  protected final String TEXT_11 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_12 = " = url_";
  protected final String TEXT_13 = " +";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_15 = " = url_";
  protected final String TEXT_16 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_17 = " = url_";
  protected final String TEXT_18 = " +";
  protected final String TEXT_19 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\turl_";
  protected final String TEXT_21 = " = url_";
  protected final String TEXT_22 = " +\")?randomize=false\";" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_24 = " = url_";
  protected final String TEXT_25 = " +\"&\"+";
  protected final String TEXT_26 = "+\"=\"+";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\turl_";
  protected final String TEXT_29 = " = \"tcp://\"+";
  protected final String TEXT_30 = "+\":\"+";
  protected final String TEXT_31 = ";" + NL + "\t\t\t";
  protected final String TEXT_32 = "\t\t\t" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_33 = ");" + NL + "" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_34 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_38 = " = factory_";
  protected final String TEXT_39 = ".createConnection();";
  protected final String TEXT_40 = NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "; ";
  protected final String TEXT_48 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_49 = " = factory_";
  protected final String TEXT_50 = ".createConnection(";
  protected final String TEXT_51 = ",decryptedPassword_";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + NL + "        connection_";
  protected final String TEXT_54 = ".start();" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_55 = "\", connection_";
  protected final String TEXT_56 = ");" + NL + "" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_57 = " = connection_";
  protected final String TEXT_58 = ".createSession(";
  protected final String TEXT_59 = ", javax.jms.Session.";
  protected final String TEXT_60 = ");" + NL + "        globalMap.put(\"session_";
  protected final String TEXT_61 = "\", session_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");

	String dbuser= ElementParameterParser.getValue(node, "__USER__");

	String strHost = null;
	String strPort = null;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(failover){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");

					if(i>0) {
					
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
					}
					
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_19);
    
					i++;
				}
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
				for(Map<String, String> optrion : additionalOpts) {
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_27);
    
				}
			}else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 

    stringBuffer.append(TEXT_36);
    		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    		} else { 
    stringBuffer.append(TEXT_40);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_41);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    		} 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
