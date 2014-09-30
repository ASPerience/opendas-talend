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

public class TMomObjectOutputMainJava
{
  protected static String nl;
  public static synchronized TMomObjectOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomObjectOutputMainJava result = new TMomObjectOutputMainJava();
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
  protected final String TEXT_8 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tSystem.out.println(\"attachement :\"+  ";
  protected final String TEXT_9 = ".attachement);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t//on reconstitue le message d'origine" + NL + "\t\t\t\t\torg.opendas.modele.ServerRequest previousRequest = new org.opendas.modele.ServerRequest();" + NL + "\t\t\t\t\tpreviousRequest.setTitle(";
  protected final String TEXT_10 = ".title);" + NL + "\t\t\t\t\tpreviousRequest.setSendUrl(";
  protected final String TEXT_11 = ".sendUrl);" + NL + "\t\t\t\t\tpreviousRequest.setFromUrl(";
  protected final String TEXT_12 = ".fromUrl);" + NL + "\t\t\t\t\tpreviousRequest.setSendedDate(";
  protected final String TEXT_13 = ".sendedDate);" + NL + "\t\t\t\t\tpreviousRequest.setAttachement((java.io.Serializable) ";
  protected final String TEXT_14 = ".attachement);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t//on crée le message de réponse" + NL + "\t\t\t\t\torg.opendas.modele.ServerRequest response = new org.opendas.modele.ServerRequest(previousRequest);" + NL + "\t\t\t\t\tresponse.setTitle(";
  protected final String TEXT_15 = ".title_out);" + NL + "\t\t\t\t\tresponse.setSendedDate(";
  protected final String TEXT_16 = ".sendedDate_out);" + NL + "\t\t\t\t\tresponse.setAttachement((java.io.Serializable) ";
  protected final String TEXT_17 = ".attachement_out);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tjavax.jms.ObjectMessage message_";
  protected final String TEXT_18 = " = session_";
  protected final String TEXT_19 = ".createObjectMessage();//On crée l'ObjectMessage" + NL + "\t\t\t\t\tmessage_";
  protected final String TEXT_20 = ".setObject(response);" + NL + "\t\t\t\t\tmessage_";
  protected final String TEXT_21 = ".setStringProperty(\"Sujet\", ";
  protected final String TEXT_22 = ".station);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tSystem.out.println(\"----------------------------\");" + NL + "\t\t\t\t\tSystem.out.println(response);" + NL + "\t\t\t\t\tSystem.out.println(\"----------------------------\");" + NL;
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_24 = " = String.valueOf(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\tjavax.jms.TextMessage message_";
  protected final String TEXT_28 = " = session_";
  protected final String TEXT_29 = ".createTextMessage( msgBody_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t message_";
  protected final String TEXT_32 = ".setString(msgID_";
  protected final String TEXT_33 = ",msgBody_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_36 = " = String.valueOf(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\tjavax.jms.BytesMessage message_";
  protected final String TEXT_40 = " = session_";
  protected final String TEXT_41 = ".createBytesMessage();" + NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_42 = ".writeBytes(msgBody_";
  protected final String TEXT_43 = ".getBytes());";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_45 = ".setBytes(msgID_";
  protected final String TEXT_46 = ",msgBody_";
  protected final String TEXT_47 = ".getBytes());";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\tjavax.jms.MapMessage message_";
  protected final String TEXT_49 = " = session_";
  protected final String TEXT_50 = ".createMapMessage();";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_52 = ".set";
  protected final String TEXT_53 = "(\"";
  protected final String TEXT_54 = "\",";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\tdes_";
  protected final String TEXT_58 = " = session_";
  protected final String TEXT_59 = ".createQueue(response.getSendUrl());" + NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_60 = " = session_";
  protected final String TEXT_61 = ".createProducer(des_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_63 = ".send(message_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\t\t\tcom.ibm.mq.MQMessage message_";
  protected final String TEXT_66 = " = new com.ibm.mq.MQMessage();";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_68 = ".format = ";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = "\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ";" + NL + "\t\t\t\t\t\tif (msgID_";
  protected final String TEXT_75 = " != null & !(\"\").equals(msgID_";
  protected final String TEXT_76 = ")) {" + NL + "\t\t\t\t\t\t\tString padding = new String();" + NL + "\t\t\t\t\t       \tint padlen = 24;" + NL + "\t\t\t\t\t " + NL + "\t\t\t\t\t       \tint len = Math.abs(padlen) - msgID_";
  protected final String TEXT_77 = ".toString().length();" + NL + "\t\t\t\t\t       \tif (len > 0) {" + NL + "\t\t\t\t\t        \tfor (int i = 0 ; i < len ; i++) {" + NL + "\t\t\t\t\t           \t\tpadding = padding + \" \";" + NL + "\t\t\t\t\t         \t}" + NL + "\t\t\t\t\t        \tmsgID_";
  protected final String TEXT_78 = " = msgID_";
  protected final String TEXT_79 = " + padding;" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_80 = ".messageId = msgID_";
  protected final String TEXT_81 = ".getBytes(\"ISO-8859-15\");";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_83 = " = String.valueOf(";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_86 = ".writeString(msgBody_";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_89 = " = String.valueOf(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_92 = ".write(msgBody_";
  protected final String TEXT_93 = ".getBytes());";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\tjava.util.Map msgBody_";
  protected final String TEXT_95 = " = new java.util.HashMap();";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t\tmsgBody_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\",";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\t\t\t    \tmessage_";
  protected final String TEXT_102 = ".writeObject(msgBody_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t  ";
  protected final String TEXT_104 = NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_105 = ".put(message_";
  protected final String TEXT_106 = ", opM_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	boolean useMQFormat = ("true").equals(ElementParameterParser.getValue(node, "__USE_FORMAT__"));
	String wsMQFormat = ElementParameterParser.getValue(node, "__WS_MQ_FORMAT__");
	
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			
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
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_22);
    


					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_26);
    
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
						} else {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
						}
					} else if ("Bytes".equals(msgBobyType)) {
						IMetadataColumn column = (IMetadataColumn)columns.get(0);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_38);
    
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
						} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
						}
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
						for(IMetadataColumn column : columns) {
							 String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							  if(("byte[]").equals(typeToGenerate)) {
					                typeToGenerate = "Bytes";
					            }else if(("Character").equals(typeToGenerate)) {
					            	 typeToGenerate = "Char";
					            }else if(("Integer").equals(typeToGenerate)) {
					            	 typeToGenerate = "Int";
					            } else if(("Java.util.Date").equals(typeToGenerate)||"BigDecimal".equals(typeToGenerate)
					            			||"List".equals(typeToGenerate)) {
					            	 typeToGenerate = "Object";
					            }else {
					                typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					            }

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    
						}

					} 
					
					/*---------------------------------------------3.send message to server------------------------------------------------------*/

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
				} else {//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
     
					if(useMQFormat) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(wsMQFormat);
    stringBuffer.append(TEXT_69);
    
					}

    stringBuffer.append(TEXT_70);
    
					if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((IMetadataColumn)columns.get(1)).getLabel() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
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
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
					} else if ("Bytes".equals(msgBobyType)) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
						for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
						}

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
					}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
				}
			}
		}
	}  

    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
