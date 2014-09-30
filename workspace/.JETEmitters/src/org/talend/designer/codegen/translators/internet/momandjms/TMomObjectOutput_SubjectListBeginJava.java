package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMomObjectOutput_SubjectListBeginJava
{
  protected static String nl;
  public static synchronized TMomObjectOutput_SubjectListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomObjectOutput_SubjectListBeginJava result = new TMomObjectOutput_SubjectListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();";
  protected final String TEXT_4 = NL + "\t\t\tprops_";
  protected final String TEXT_5 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_6 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_7 = "+\":\"+";
  protected final String TEXT_8 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_9 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_10 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_11 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_12 = NL + "\t\t\t\t= (javax.jms.ConnectionFactory)context_";
  protected final String TEXT_13 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\tString url_";
  protected final String TEXT_15 = " = \"tcp://\"+";
  protected final String TEXT_16 = "+\":\"+";
  protected final String TEXT_17 = ";" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_18 = ");" + NL + "\t\t\tSystem.out.println(\"Producing \" + (";
  protected final String TEXT_19 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_20 = ");" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_21 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory" + NL + "\t\t\t\t\t(org.apache.activemq.ActiveMQConnection.DEFAULT_USER, org.apache.activemq.ActiveMQConnection.DEFAULT_PASSWORD, url_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = "\t" + NL + "\t\t\t\t" + NL + "\t\tjavax.jms.Connection connection_";
  protected final String TEXT_24 = " = factory_";
  protected final String TEXT_25 = ".createConnection();" + NL + "\t\tconnection_";
  protected final String TEXT_26 = ".start();" + NL + "\t" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_27 = " = connection_";
  protected final String TEXT_28 = ".createSession(";
  protected final String TEXT_29 = ", javax.jms.Session.";
  protected final String TEXT_30 = ");" + NL + "\t\t" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "\t\t\tdes_";
  protected final String TEXT_33 = " = session_";
  protected final String TEXT_34 = ".createQueue(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t    \tdes_";
  protected final String TEXT_37 = " = session_";
  protected final String TEXT_38 = ".createTopic(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_41 = " = session_";
  protected final String TEXT_42 = ".createProducer(des_";
  protected final String TEXT_43 = ");" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t\tproducer_";
  protected final String TEXT_45 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);";
  protected final String TEXT_46 = NL + "\t\t\tproducer_";
  protected final String TEXT_47 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);";
  protected final String TEXT_48 = NL + "\t\t" + NL;
  protected final String TEXT_49 = NL + "\t    props_";
  protected final String TEXT_50 = ".put(\"hostname\", ";
  protected final String TEXT_51 = ");" + NL + "\t    props_";
  protected final String TEXT_52 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_53 = "));" + NL + "\t    props_";
  protected final String TEXT_54 = ".put(\"channel\", ";
  protected final String TEXT_55 = ");" + NL + "\t    props_";
  protected final String TEXT_56 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t    props_";
  protected final String TEXT_57 = ".put(\"transport\", \"MQSeries\");" + NL + "\t" + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_58 = " = new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_59 = ", props_";
  protected final String TEXT_60 = ");" + NL + "\t    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_61 = " = qMgr_";
  protected final String TEXT_62 = ".accessQueue(";
  protected final String TEXT_63 = ", 16);" + NL + "\t    com.ibm.mq.MQPutMessageOptions opM_";
  protected final String TEXT_64 = " = new com.ibm.mq.MQPutMessageOptions();";
  protected final String TEXT_65 = NL + "\t" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_66 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String station=ElementParameterParser.getValue(node, "__STATION__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	String from = ElementParameterParser.getValue(node, "__FROM__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);
		}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {// server judgement
	
	/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType)){ 

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		}else if(("ActiveMQ").equals(serverType)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(!("Queue").equals(msgType));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		if (("Queue").equals(msgType)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_35);
    
		} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_39);
    
		}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
		if ("N_PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
		} else if ("PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
		}

    stringBuffer.append(TEXT_48);
    
	}else{ //server judgement   /***WebSphere MQ*****/
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    return stringBuffer.toString();
  }
}
