package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMomMessageIdListBeginJava
{
  protected static String nl;
  public static synchronized TMomMessageIdListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomMessageIdListBeginJava result = new TMomMessageIdListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t\tclass HelloInput implements javax.jms.MessageListener {" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_5 = "Connection connection";
  protected final String TEXT_6 = ";" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_7 = "Session session";
  protected final String TEXT_8 = ";" + NL + "\t\t\tjavax.jms.";
  protected final String TEXT_9 = " topic";
  protected final String TEXT_10 = ";" + NL + "\t\t\tjava.util.Queue<String> msgQueue";
  protected final String TEXT_11 = "=null;\t" + NL + "\t\t\tpublic HelloInput(String factoryJNDI, String topicJNDI) throws javax.jms.JMSException, javax.naming.NamingException{" + NL + "\t\t\t\tmsgQueue";
  protected final String TEXT_12 = "=new java.util.LinkedList<String>();" + NL + "\t\t\t\tjava.util.Hashtable props";
  protected final String TEXT_13 = "=new java.util.Hashtable();" + NL + "\t\t\t\tprops";
  protected final String TEXT_14 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_15 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_16 = "+\":\"+";
  protected final String TEXT_17 = ");" + NL + "\t\t\t\tprops";
  protected final String TEXT_18 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_19 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\t\tprops";
  protected final String TEXT_20 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t\tjavax.naming.Context context";
  protected final String TEXT_21 = "=new javax.naming.InitialContext(props";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\tjavax.jms.";
  protected final String TEXT_23 = "ConnectionFactory factory";
  protected final String TEXT_24 = "=(javax.jms.";
  protected final String TEXT_25 = "ConnectionFactory)context";
  protected final String TEXT_26 = ".lookup(factoryJNDI);\t" + NL + "\t\t\t\tconnection";
  protected final String TEXT_27 = "=factory";
  protected final String TEXT_28 = ".create";
  protected final String TEXT_29 = "Connection();" + NL + "\t\t\t\tsession";
  protected final String TEXT_30 = "=connection";
  protected final String TEXT_31 = ".create";
  protected final String TEXT_32 = "Session(false, javax.jms.Session.AUTO_ACKNOWLEDGE);" + NL + "\t\t\t\ttopic";
  protected final String TEXT_33 = "=(javax.jms.";
  protected final String TEXT_34 = ")context";
  protected final String TEXT_35 = ".lookup(topicJNDI);" + NL;
  protected final String TEXT_36 = NL + "\t\t\t\t\tjavax.jms.";
  protected final String TEXT_37 = "Receiver receiver";
  protected final String TEXT_38 = "=session";
  protected final String TEXT_39 = ".createReceiver(topic";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\treceiver";
  protected final String TEXT_41 = ".setMessageListener(this);";
  protected final String TEXT_42 = NL + "\t\t\t\t\tjavax.jms.";
  protected final String TEXT_43 = "Subscriber subscriber";
  protected final String TEXT_44 = "=session";
  protected final String TEXT_45 = ".createSubscriber(topic";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\t\tsubscriber";
  protected final String TEXT_47 = ".setMessageListener(this);";
  protected final String TEXT_48 = "\t" + NL + "\t\t\t\tconnection";
  protected final String TEXT_49 = ".start();" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tpublic void onMessage(javax.jms.Message m){" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tString msg";
  protected final String TEXT_50 = "=((javax.jms.TextMessage)m).getText();" + NL + "\t\t\t\t\tmsgQueue";
  protected final String TEXT_51 = ".add(msg";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\t} catch (javax.jms.JMSException e) {" + NL + "\t\t\t\t\tSystem.err.println(\"Could not get text message:\" + e);" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic void close() throws javax.jms.JMSException{" + NL + "\t\t\t\tsession";
  protected final String TEXT_53 = ".close();" + NL + "\t\t\t\tconnection";
  protected final String TEXT_54 = ".close();" + NL + "\t\t\t}\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tHelloInput input";
  protected final String TEXT_55 = "=null;" + NL + "\t\ttry {" + NL + "\t\t//begin part" + NL + "\t\t\tinput";
  protected final String TEXT_56 = "=new HelloInput(\"";
  protected final String TEXT_57 = "TopicConnectionFactory";
  protected final String TEXT_58 = "ConnectionFactory";
  protected final String TEXT_59 = "\",";
  protected final String TEXT_60 = ");\t\t\t" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\tSystem.err.println(\"An exception occurred while testing HelloSubscriber:\" + e);" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t" + NL + "\t\tBoolean flag";
  protected final String TEXT_61 = "=true;" + NL + "\t\twhile(flag";
  protected final String TEXT_62 = "){" + NL + "\t\t\twhile(!(input";
  protected final String TEXT_63 = ".msgQueue";
  protected final String TEXT_64 = ".size()==0)){" + NL + "\t\t\t\tString msg";
  protected final String TEXT_65 = "=(String)input";
  protected final String TEXT_66 = ".msgQueue";
  protected final String TEXT_67 = ".poll();" + NL + "\t";
  protected final String TEXT_68 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = ".from=";
  protected final String TEXT_70 = ";\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = ".message=msg";
  protected final String TEXT_72 = ";\t" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\tjava.util.List<String> idList_";
  protected final String TEXT_74 = " = new java.util.ArrayList<String>();" + NL + "\t" + NL + "\t\tjava.util.Hashtable properties_";
  protected final String TEXT_75 = "=new java.util.Hashtable();" + NL + "\t\tproperties_";
  protected final String TEXT_76 = ".put(\"hostname\", ";
  protected final String TEXT_77 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_78 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_79 = "));" + NL + "\t\tproperties_";
  protected final String TEXT_80 = ".put(\"channel\", ";
  protected final String TEXT_81 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_82 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\tproperties_";
  protected final String TEXT_83 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t" + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_84 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_85 = "=null;" + NL + "\t\ttry{" + NL + "\t\t\tint openOptions_";
  protected final String TEXT_86 = "=com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INPUT_AS_Q_DEF;" + NL + "\t" + NL + "\t    \tcom.ibm.mq.MQGetMessageOptions gmo_";
  protected final String TEXT_87 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t    \tgmo_";
  protected final String TEXT_88 = ".options=gmo_";
  protected final String TEXT_89 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t    \tgmo_";
  protected final String TEXT_90 = ".options=gmo_";
  protected final String TEXT_91 = ".options+com.ibm.mq.MQC.MQGMO_NO_WAIT;" + NL + "\t    \tgmo_";
  protected final String TEXT_92 = ".options=gmo_";
  protected final String TEXT_93 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t    \tgmo_";
  protected final String TEXT_94 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t    \tcom.ibm.mq.MQException.log = null;" + NL + "\t    \tboolean flag_";
  protected final String TEXT_95 = "=true;" + NL + "\t    " + NL + "\t    \tqMgr_";
  protected final String TEXT_96 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_97 = ",properties_";
  protected final String TEXT_98 = ");" + NL + "\t    \twhile(flag_";
  protected final String TEXT_99 = "){" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_100 = "=qMgr_";
  protected final String TEXT_101 = ".accessQueue(";
  protected final String TEXT_102 = ",openOptions_";
  protected final String TEXT_103 = ");" + NL + "\t    \t\tcom.ibm.mq.MQMessage inMessage_";
  protected final String TEXT_104 = "=new com.ibm.mq.MQMessage();" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_105 = ".get(inMessage_";
  protected final String TEXT_106 = ",gmo_";
  protected final String TEXT_107 = ");" + NL + "\t    \t\tidList_";
  protected final String TEXT_108 = ".add(new String(inMessage_";
  protected final String TEXT_109 = ".messageId,\"ISO-8859-15\"));" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_110 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}catch(com.ibm.mq.MQException me_";
  protected final String TEXT_111 = "){" + NL + "\t\t\tif (me_";
  protected final String TEXT_112 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t        \tremoteQ_";
  protected final String TEXT_113 = ".close();" + NL + "\t        \tqMgr_";
  protected final String TEXT_114 = ".backout();" + NL + "\t            qMgr_";
  protected final String TEXT_115 = ".disconnect();" + NL + "\t        }else{" + NL + "\t        \tthrow me_";
  protected final String TEXT_116 = ";" + NL + "\t        }" + NL + "\t\t}" + NL + "\t" + NL + "\t\tfor(String tmpId_";
  protected final String TEXT_117 = " : idList_";
  protected final String TEXT_118 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_119 = " ++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_120 = "_CURRENT_MESSAGE_ID\", tmpId_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	
	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(("JBoss").equals(serverType)){ // server judgement
		String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
		String from=ElementParameterParser.getValue(node, "__FROM__");


    stringBuffer.append(TEXT_4);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    	
				if(("Queue").equals(msgType)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
				}else{

    stringBuffer.append(TEXT_42);
    stringBuffer.append(msgType);
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

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
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
    if(("Topic").equals(msgType)){
    stringBuffer.append(TEXT_57);
    }else{
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
				List<IMetadataColumn> columnList = metadata.getListColumns();
				for(IConnection conn:conns){
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
				 		String firstConnName = conn.getName();

    stringBuffer.append(TEXT_68);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
					}
				}
	}  //server judgement   /***WebSphere MQ*****/
	else{
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		String idMask = ElementParameterParser.getValue(node, "__IDMASK__");

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
	}

    stringBuffer.append(TEXT_122);
    return stringBuffer.toString();
  }
}
