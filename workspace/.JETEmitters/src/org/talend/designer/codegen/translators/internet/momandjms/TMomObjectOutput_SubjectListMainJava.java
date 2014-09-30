package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TMomObjectOutput_SubjectListMainJava
{
  protected static String nl;
  public static synchronized TMomObjectOutput_SubjectListMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomObjectOutput_SubjectListMainJava result = new TMomObjectOutput_SubjectListMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";" + NL + "\t\t\t\t\t\tjavax.jms.MapMessage message_";
  protected final String TEXT_6 = " = session_";
  protected final String TEXT_7 = ".createMapMessage();";
  protected final String TEXT_8 = NL + "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t//On envoie le message qui demandera la liste des sujets à suivre dans la file" + NL + "\t\t\t\t\torg.opendas.modele.ServerRequest serverRequest = new org.opendas.modele.ServerRequest();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tserverRequest.setTitle(\"getSubjectList\");" + NL + "\t\t\t\t\tserverRequest.setSendUrl(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t\tserverRequest.setFromUrl(";
  protected final String TEXT_10 = ");" + NL + "" + NL + "\t\t\t\t\tjavax.jms.ObjectMessage message_";
  protected final String TEXT_11 = " = session_";
  protected final String TEXT_12 = ".createObjectMessage();//On crée l'ObjectMessage" + NL + "" + NL + "\t\t\t\t\tmessage_";
  protected final String TEXT_13 = ".setObject(serverRequest);" + NL + "" + NL + "\t\t\t\t\t//propriétés" + NL + "\t\t\t\t\tmessage_";
  protected final String TEXT_14 = ".setStringProperty(\"Sujet\", \"getSubjectList\");" + NL + "\t\t\t\t\tmessage_";
  protected final String TEXT_15 = ".setStringProperty(\"Station\", ";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tSystem.out.println(\"";
  protected final String TEXT_18 = " Envoi de la demande de liste de sujets\");//DEBUG" + NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_19 = ".send(message_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\t\t\tcom.ibm.mq.MQMessage message_";
  protected final String TEXT_22 = " = new com.ibm.mq.MQMessage();";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_24 = ".format = ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = "\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";" + NL + "\t\t\t\t\t\tif (msgID_";
  protected final String TEXT_31 = " != null & !(\"\").equals(msgID_";
  protected final String TEXT_32 = ")) {" + NL + "\t\t\t\t\t\t\tString padding = new String();" + NL + "\t\t\t\t\t       \tint padlen = 24;" + NL + "\t\t\t\t\t " + NL + "\t\t\t\t\t       \tint len = Math.abs(padlen) - msgID_";
  protected final String TEXT_33 = ".toString().length();" + NL + "\t\t\t\t\t       \tif (len > 0) {" + NL + "\t\t\t\t\t        \tfor (int i = 0 ; i < len ; i++) {" + NL + "\t\t\t\t\t           \t\tpadding = padding + \" \";" + NL + "\t\t\t\t\t         \t}" + NL + "\t\t\t\t\t        \tmsgID_";
  protected final String TEXT_34 = " = msgID_";
  protected final String TEXT_35 = " + padding;" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_36 = ".messageId = msgID_";
  protected final String TEXT_37 = ".getBytes(\"ISO-8859-15\");";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_39 = " = String.valueOf(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_42 = ".writeString(msgBody_";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_45 = " = String.valueOf(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_48 = ".write(msgBody_";
  protected final String TEXT_49 = ".getBytes());";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tjava.util.Map msgBody_";
  protected final String TEXT_51 = " = new java.util.HashMap();";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\tmsgBody_";
  protected final String TEXT_53 = ".put(\"";
  protected final String TEXT_54 = "\",";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\t\t\t    \tmessage_";
  protected final String TEXT_58 = ".writeObject(msgBody_";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t  ";
  protected final String TEXT_60 = NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_61 = ".put(message_";
  protected final String TEXT_62 = ", opM_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String station=ElementParameterParser.getValue(node, "__STATION__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	boolean useMQFormat = ("true").equals(ElementParameterParser.getValue(node, "__USE_FORMAT__"));
	String wsMQFormat = ElementParameterParser.getValue(node, "__WS_MQ_FORMAT__");
	String from = ElementParameterParser.getValue(node, "__FROM__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	List<IMetadataTable> metadatas = node.getMetadataList();

	if ((metadatas!=null)&&(metadatas.size()>0)) {

		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();

			IConnection conn = conns.get(0);

				if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
				
					/*-------------------1.is use message id.this functions just use map message type-------------------------------------*/
					if(("true").equals(useMsgId)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(((IMetadataColumn)columns.get(1)).getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
					}
					
					/*--------------------------2.judge message body type----------------------------------------------------------------*/

    stringBuffer.append(TEXT_8);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(from);
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
    stringBuffer.append(station);
    stringBuffer.append(TEXT_16);
    

					
					/*---------------------------------------------3.send message to server------------------------------------------------------*/

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
				} else {//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
     
					if(useMQFormat) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(wsMQFormat);
    stringBuffer.append(TEXT_25);
    
					}

    stringBuffer.append(TEXT_26);
    
					if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((IMetadataColumn)columns.get(1)).getLabel() );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
					}
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
					} else if ("Bytes".equals(msgBobyType)) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
						for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    
						}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
					}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
				}
		}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
