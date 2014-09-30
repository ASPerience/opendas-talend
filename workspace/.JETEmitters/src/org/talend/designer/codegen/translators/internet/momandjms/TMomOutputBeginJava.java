package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomOutputBeginJava
{
  protected static String nl;
  public static synchronized TMomOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputBeginJava result = new TMomOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();" + NL + "\tint nb_line_";
  protected final String TEXT_4 = " = 0;" + NL + "" + NL + "\t";
  protected final String TEXT_5 = NL + "        javax.jms.Connection connection_";
  protected final String TEXT_6 = " = null;" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_7 = " = null;" + NL + "        try {" + NL + "\t        connection_";
  protected final String TEXT_8 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_9 = "\");" + NL + "            connection_";
  protected final String TEXT_10 = ".start();" + NL + "\t\t\tsession_";
  protected final String TEXT_11 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_12 = "\");" + NL + "\t\t} catch (NullPointerException npe) {" + NL + "\t\t    throw new RuntimeException(\"";
  protected final String TEXT_13 = " still not initialized. Try to redesign job.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_14 = " = (javax.jms.MessageProducer)globalMap.get(\"producer_";
  protected final String TEXT_15 = "\");" + NL + "\t\t" + NL + "\t\tif(producer_";
  protected final String TEXT_16 = " == null) {" + NL + "\t\t" + NL + "\t\t\tjavax.jms.Destination des_";
  protected final String TEXT_17 = ";" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tdes_";
  protected final String TEXT_19 = " = session_";
  protected final String TEXT_20 = ".createQueue(";
  protected final String TEXT_21 = ");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t    \t\tdes_";
  protected final String TEXT_23 = " = session_";
  protected final String TEXT_24 = ".createTopic(";
  protected final String TEXT_25 = ");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + " " + NL + "\t\t \tproducer_";
  protected final String TEXT_27 = " = session_";
  protected final String TEXT_28 = ".createProducer(des_";
  protected final String TEXT_29 = ");" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tproducer_";
  protected final String TEXT_31 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\tproducer_";
  protected final String TEXT_33 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_35 = NL + "        \tresourceMap.put(\"session_";
  protected final String TEXT_36 = "\", session_";
  protected final String TEXT_37 = ");" + NL + "        \tresourceMap.put(\"producer_";
  protected final String TEXT_38 = "\", producer_";
  protected final String TEXT_39 = ");" + NL + "\t\t\tresourceMap.put(\"connection_";
  protected final String TEXT_40 = "\", connection_";
  protected final String TEXT_41 = ");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\t    " + NL + "\t";
  protected final String TEXT_43 = NL + "\t\t\tprops_";
  protected final String TEXT_44 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_45 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_46 = "+\":\"+";
  protected final String TEXT_47 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_48 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_49 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_50 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_51 = NL + "\t\t\t\t= (javax.jms.ConnectionFactory)context_";
  protected final String TEXT_52 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_53 = "\t" + NL + "\t\t\tString url_";
  protected final String TEXT_54 = " =\"\";" + NL + "" + NL + "      \t\t";
  protected final String TEXT_55 = NL + "\t\t\t\turl_";
  protected final String TEXT_56 = " = \"failover:(\";" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_58 = " = url_";
  protected final String TEXT_59 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_61 = " = url_";
  protected final String TEXT_62 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_63 = " = url_";
  protected final String TEXT_64 = " +";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_66 = " = url_";
  protected final String TEXT_67 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_68 = " = url_";
  protected final String TEXT_69 = " +";
  protected final String TEXT_70 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\turl_";
  protected final String TEXT_72 = " = url_";
  protected final String TEXT_73 = " +\")?randomize=false\";" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_75 = " = url_";
  protected final String TEXT_76 = " +\"&\"+";
  protected final String TEXT_77 = "+\"=\"+";
  protected final String TEXT_78 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\turl_";
  protected final String TEXT_80 = " = \"tcp://\"+";
  protected final String TEXT_81 = "+\":\"+";
  protected final String TEXT_82 = ";" + NL + "\t\t\t";
  protected final String TEXT_83 = "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_84 = ");" + NL + "\t\t\tSystem.out.println(\"Producing \" + (";
  protected final String TEXT_85 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_86 = ");" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_87 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_88 = ");" + NL + "\t\t";
  protected final String TEXT_89 = "\t" + NL + "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_91 = " = factory_";
  protected final String TEXT_92 = ".createConnection();" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t";
  protected final String TEXT_95 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_96 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = "; ";
  protected final String TEXT_101 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_102 = " = factory_";
  protected final String TEXT_103 = ".createConnection(";
  protected final String TEXT_104 = ",decryptedPassword_";
  protected final String TEXT_105 = ");" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t\t" + NL + "\t\tconnection_";
  protected final String TEXT_107 = ".start();" + NL + "\t" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_108 = " = connection_";
  protected final String TEXT_109 = ".createSession(";
  protected final String TEXT_110 = ", javax.jms.Session.";
  protected final String TEXT_111 = ");" + NL + "\t\t" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_112 = ";" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t\tdes_";
  protected final String TEXT_114 = " = session_";
  protected final String TEXT_115 = ".createQueue(";
  protected final String TEXT_116 = ");" + NL + "\t\t";
  protected final String TEXT_117 = NL + "\t    \tdes_";
  protected final String TEXT_118 = " = session_";
  protected final String TEXT_119 = ".createTopic(";
  protected final String TEXT_120 = ");" + NL + "\t\t";
  protected final String TEXT_121 = NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_122 = " = session_";
  protected final String TEXT_123 = ".createProducer(des_";
  protected final String TEXT_124 = ");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t\t\tproducer_";
  protected final String TEXT_126 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t";
  protected final String TEXT_127 = NL + "\t\t\tproducer_";
  protected final String TEXT_128 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);" + NL + "\t\t";
  protected final String TEXT_129 = NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t\tresourceMap.put(\"session_";
  protected final String TEXT_131 = "\", session_";
  protected final String TEXT_132 = ");" + NL + "\t\t\tresourceMap.put(\"producer_";
  protected final String TEXT_133 = "\", producer_";
  protected final String TEXT_134 = ");" + NL + "\t\t\tresourceMap.put(\"connection_";
  protected final String TEXT_135 = "\", connection_";
  protected final String TEXT_136 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_137 = NL + "\t";
  protected final String TEXT_138 = NL + "\t    props_";
  protected final String TEXT_139 = ".put(\"hostname\", ";
  protected final String TEXT_140 = ");" + NL + "\t    props_";
  protected final String TEXT_141 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_142 = "));" + NL + "\t    props_";
  protected final String TEXT_143 = ".put(\"channel\", ";
  protected final String TEXT_144 = ");" + NL + "\t    props_";
  protected final String TEXT_145 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t    props_";
  protected final String TEXT_146 = ".put(\"transport\", \"MQSeries\");" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_147 = NL + "\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_148 = "\";" + NL + "\t\t";
  protected final String TEXT_149 = NL + "\t\t\tprops_";
  protected final String TEXT_150 = ".put(\"userID\",";
  protected final String TEXT_151 = ");" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t";
  protected final String TEXT_153 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_154 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_157 = " = ";
  protected final String TEXT_158 = "; ";
  protected final String TEXT_159 = NL + "\t\t\t" + NL + "\t\t\tprops_";
  protected final String TEXT_160 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_161 = ");" + NL + "\t\t";
  protected final String TEXT_162 = NL + "\t" + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_163 = " = new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_164 = ", props_";
  protected final String TEXT_165 = ");" + NL + "\t    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_166 = " = qMgr_";
  protected final String TEXT_167 = ".accessQueue(";
  protected final String TEXT_168 = ", 16);" + NL + "\t    com.ibm.mq.MQPutMessageOptions opM_";
  protected final String TEXT_169 = " = new com.ibm.mq.MQPutMessageOptions();" + NL + "\t\t";
  protected final String TEXT_170 = "\t" + NL + "\t\t\topM_";
  protected final String TEXT_171 = ".options=opM_";
  protected final String TEXT_172 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\t\tif(producer_";
  protected final String TEXT_174 = "!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_176 = ".setTimeToLive(";
  protected final String TEXT_177 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_179 = ".setPriority(";
  protected final String TEXT_180 = ");\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_182 = ".setDisableMessageTimestamp(false);" + NL + "\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_184 = ".setDeliveryMode(";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t}" + NL + "\t\t\tglobalMap.put(\"producer_";
  protected final String TEXT_187 = "\",producer_";
  protected final String TEXT_188 = ");" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_189 = "\",session_";
  protected final String TEXT_190 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_191 = "\",connection_";
  protected final String TEXT_192 = ");" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t";
  protected final String TEXT_194 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");

	String dbuser= ElementParameterParser.getValue(node, "__USER__");

		
	String strHost = null;
	String strPort = null;
	
	boolean setJmsHeader =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_HEADER__"));
	List<Map<String,String>> jmsHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_HEADERS__");

	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
	}

	boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
		|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());

	if (isUseSharedConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
                           	failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    	
	if (isUseSharedConnection) { 
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_21);
    
			} else {
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_25);
    
			}
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			if ("N_PERSISTENT".equals(deliverMode)) {
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			} else if ("PERSISTENT".equals(deliverMode)) {
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
			}
			
    stringBuffer.append(TEXT_34);
    
		if(!isCommitRollback && transacted){
		
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
		}
		
    stringBuffer.append(TEXT_42);
    	
	} else if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {// server judgement
	
	/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType)){ 
		
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}else if(("ActiveMQ").equals(serverType)) {
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    if(failover){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");
	
					if(i>0) {
					
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
					}
					
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_70);
    
					i++;
				}
				
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
				for(Map<String, String> optrion : additionalOpts) {
				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_78);
    
				}
			}else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(!("Queue").equals(msgType));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
		
    stringBuffer.append(TEXT_89);
    
		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
		} else { 
		
    stringBuffer.append(TEXT_93);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_94);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_97);
    } else {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		} 
		
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_116);
    
		} else {
		
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_120);
    
		}
		
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
		if ("N_PERSISTENT".equals(deliverMode)) {
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
		} else if ("PERSISTENT".equals(deliverMode)) {
		
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
		}
		
    stringBuffer.append(TEXT_129);
    if(!isCommitRollback && transacted){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
		}
		
    stringBuffer.append(TEXT_137);
    
	}else{ //server judgement   /***WebSphere MQ*****/
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
		String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
		
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		if(needSSLCipher){
		
    stringBuffer.append(TEXT_147);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_148);
    
		}
		if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_151);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_152);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_155);
    } else {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
		}
		
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    	    
	    if (transacted) {
		
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	    }
	}
	if(isUseSharedConnection ||("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)){
		if(setJmsHeader && jmsHeaders !=null && jmsHeaders.size()>0){
		
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    
				for(Map<String,String> header:jmsHeaders) {
					java.util.List<String> senderHeaderParams = java.util.Arrays.asList(new String[]{"JMSExpiration","JMSPriority","JMSTimestamp","JMSDeliveryMode"});
					String senderHeaderParam = header.get("JMS_HEADER_NAME");
					if(!senderHeaderParams.contains(senderHeaderParam)){
						continue;
					}
					if("JMSExpiration".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_177);
    
					}
					if("JMSPriority".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_180);
    
					}
					if("JMSTimestamp".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    
					}
					if("JMSDeliveryMode".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_185);
    
					}
				}
				
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
		}
	}
	
    stringBuffer.append(TEXT_193);
    stringBuffer.append(TEXT_194);
    return stringBuffer.toString();
  }
}
