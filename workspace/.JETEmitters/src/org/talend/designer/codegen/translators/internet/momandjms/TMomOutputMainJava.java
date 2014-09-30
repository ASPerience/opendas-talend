package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMomOutputMainJava
{
  protected static String nl;
  public static synchronized TMomOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputMainJava result = new TMomOutputMainJava();
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
  protected final String TEXT_8 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_9 = " = String.valueOf(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t\tjavax.jms.TextMessage message_";
  protected final String TEXT_13 = " = session_";
  protected final String TEXT_14 = ".createTextMessage( msgBody_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t\t message_";
  protected final String TEXT_17 = ".setString(msgID_";
  protected final String TEXT_18 = ",msgBody_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t    byte[] msgBody_";
  protected final String TEXT_21 = " = String.valueOf(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ").getBytes();";
  protected final String TEXT_24 = NL + "\t                        byte[] msgBody_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\tjavax.jms.BytesMessage message_";
  protected final String TEXT_29 = " = session_";
  protected final String TEXT_30 = ".createBytesMessage();" + NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_31 = ".writeBytes(msgBody_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_34 = ".setBytes(msgID_";
  protected final String TEXT_35 = ",msgBody_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\tjavax.jms.MapMessage message_";
  protected final String TEXT_38 = " = session_";
  protected final String TEXT_39 = ".createMapMessage();";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_41 = ".set";
  protected final String TEXT_42 = "(\"";
  protected final String TEXT_43 = "\",";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ");\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_47 = ".setString(\"";
  protected final String TEXT_48 = "\",String.valueOf(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = "));\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t\tjavax.jms.Destination desJMS_";
  protected final String TEXT_52 = "=";
  protected final String TEXT_53 = ";";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_55 = ".set";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_59 = ".set";
  protected final String TEXT_60 = "Property(";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_64 = ".send(";
  protected final String TEXT_65 = "desJMS_";
  protected final String TEXT_66 = " ,";
  protected final String TEXT_67 = "message_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t\t\t\tcom.ibm.mq.MQMessage message_";
  protected final String TEXT_70 = " = new com.ibm.mq.MQMessage();";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_72 = ".format = ";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = "\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ";" + NL + "\t\t\t\t\t\tif (msgID_";
  protected final String TEXT_79 = " != null & !(\"\").equals(msgID_";
  protected final String TEXT_80 = ")) {" + NL + "\t\t\t\t\t\t\tString padding = new String();" + NL + "\t\t\t\t\t       \tint padlen = 24;" + NL + "\t\t\t\t\t " + NL + "\t\t\t\t\t       \tint len = Math.abs(padlen) - msgID_";
  protected final String TEXT_81 = ".toString().length();" + NL + "\t\t\t\t\t       \tif (len > 0) {" + NL + "\t\t\t\t\t        \tfor (int i = 0 ; i < len ; i++) {" + NL + "\t\t\t\t\t           \t\tpadding = padding + \" \";" + NL + "\t\t\t\t\t         \t}" + NL + "\t\t\t\t\t        \tmsgID_";
  protected final String TEXT_82 = " = msgID_";
  protected final String TEXT_83 = " + padding;" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_84 = ".messageId = msgID_";
  protected final String TEXT_85 = ".getBytes(\"ISO-8859-15\");";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_91 = " = new org.talend.mq.headers.rfh2.MQRFH2();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_93 = ".set";
  protected final String TEXT_94 = "(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.McdArea mcd_";
  protected final String TEXT_97 = " = new org.talend.mq.headers.rfh2.McdArea();";
  protected final String TEXT_98 = " " + NL + "\t\t\t\t\t\t\tmcd_";
  protected final String TEXT_99 = ".set";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_103 = ".addArea(mcd_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.JmsArea jms_";
  protected final String TEXT_106 = " = new org.talend.mq.headers.rfh2.JmsArea();";
  protected final String TEXT_107 = " " + NL + "\t\t\t\t\t\t\tjms_";
  protected final String TEXT_108 = ".set";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_112 = ".addArea(jms_";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.UsrArea usr_";
  protected final String TEXT_115 = " = new org.talend.mq.headers.rfh2.UsrArea();" + NL + "\t\t\t\t\t\t\tjava.util.Map<String, Object> map_usr_";
  protected final String TEXT_116 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_117 = " " + NL + "\t\t\t\t\t\t\tmap_usr_";
  protected final String TEXT_118 = ".put(";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\torg.talend.mq.util.TalendMQUtil.setDefinedPropertiesToUser(usr_";
  protected final String TEXT_122 = ",map_usr_";
  protected final String TEXT_123 = ");" + NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_124 = ".addArea(usr_";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_127 = ".toMessage(message_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_130 = " = String.valueOf(";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_133 = ".writeString(msgBody_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t    String msgBody_";
  protected final String TEXT_136 = " = String.valueOf(";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t\t\t    message_";
  protected final String TEXT_139 = ".write(msgBody_";
  protected final String TEXT_140 = ".getBytes());";
  protected final String TEXT_141 = NL + "                            message_";
  protected final String TEXT_142 = ".write(";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\tjava.util.Map msgBody_";
  protected final String TEXT_146 = " = new java.util.HashMap();";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\tmsgBody_";
  protected final String TEXT_148 = ".put(\"";
  protected final String TEXT_149 = "\",";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "\t\t\t\t    \tmessage_";
  protected final String TEXT_153 = ".writeObject(msgBody_";
  protected final String TEXT_154 = ");" + NL + "\t\t\t\t  ";
  protected final String TEXT_155 = NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_156 = ".put(message_";
  protected final String TEXT_157 = ", opM_";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "\t" + NL + "\tnb_line_";
  protected final String TEXT_160 = "++;" + NL + "" + NL + "\t\t";
  protected final String TEXT_161 = NL;

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
	
	boolean isSetJMSDestination = false;
    boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	boolean setJmsHeader =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_HEADER__"));
	List<Map<String,String>> jmsHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_HEADERS__");
	
	boolean setJmsProp =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_PROPERTIES__"));
	List<Map<String,String>> jmsProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_PROPERTIES__");

	boolean setMQMDField =  ("true").equals(ElementParameterParser.getValue(node, "__SET_MQMD_FIELDS__"));
	List<Map<String,String>> mqmdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQMD_FIELDS__");

	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));
	boolean useFixedMqRFH2 = "true".equals(ElementParameterParser.getValue(node, "__USE_FIX_MQRFH2__"));
	List<Map<String,String>> mqrfh2FixedFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_FIXED_FIELD__");

	boolean useMqRFH2_mcd = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_MCD__"));
	List<Map<String,String>> mqrfh2mcdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_MCD_FIELD__");

	boolean useMqRFH2_jms = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_JMS__"));
	List<Map<String,String>> mqrfh2jmsFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_JMS_FIELD__");

	boolean useMqRFH2_usr = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_USR__"));
	List<Map<String,String>> mqrfh2usrFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_USR_FIELD__");

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			
				if (isUseSharedConnection || ("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
				
					/*-------------------1.is use message id.this functions just use map message type-------------------------------------*/
					if(("true").equals(useMsgId)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(metadata.getColumn("messageid").getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
					}
					
					/*--------------------------2.judge message body type----------------------------------------------------------------*/
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(metadata.getColumn("message").getLabel());
    stringBuffer.append(TEXT_11);
    
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
						} else {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
						}
					} else if ("Bytes".equals(msgBobyType)) {
						IMetadataColumn column = conn.getMetadataTable().getColumn("message");
						if(!"id_byte[]".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    
						}else{

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    
						}
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
						} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
						}
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
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
					            if(!"Document".equals(typeToGenerate)){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    
								}else{

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    
								}
						}
					} 
					/*---------------------------------------------3.set message headers------------------------------------------------------*/
					
					if (setJmsHeader) {
						java.util.List<String> jsmHeaderClient=java.util.Arrays.asList(new String[]{"JMSCorrelationID","JMSReplyTo","JMSType","JMSTimestamp","JMSDestination","JMSMessageID","JMSRedelivered"});
						for(Map<String,String> header:jmsHeaders) {
							String jsmHeaderParam=header.get("JMS_HEADER_NAME");
							if("JMSDestination".equals(jsmHeaderParam)){
								isSetJMSDestination = true;

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_53);
    
								continue;
							}
							if(jsmHeaderClient.contains(jsmHeaderParam)){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(jsmHeaderParam);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_57);
    				
							}
						}
					}
					
					/*---------------------------------------------4.set message headers------------------------------------------------------*/
					
					if (setJmsProp) {
						for(Map<String,String> prop:jmsProps) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(prop.get("JMS_PROPERTIES_TYPE"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(prop.get("JMS_PROPERTIES_NAME"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(prop.get("JMS_PROPERTIES_VALUE"));
    stringBuffer.append(TEXT_62);
    				
						}
					}
					
					/*---------------------------------------------5.send message to server------------------------------------------------------*/

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    if(isSetJMSDestination){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
				} else {//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
     
					if(useMQFormat) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(wsMQFormat);
    stringBuffer.append(TEXT_73);
    
					}

    stringBuffer.append(TEXT_74);
    
					if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(metadata.getColumn("messageid").getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
					}
										
					/*---------------------------------------------set MQMD Fields------------------------------------------------------*/
					
					if (setMQMDField) {
						for(Map<String,String> field:mqmdFields) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(field.get("MQMD_FIELD_VALUE"));
    stringBuffer.append(TEXT_89);
    				
						}
					}
					// include the header: MQRFH2
					if (useMqHeader) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
						if (useFixedMqRFH2 ) {
							for(Map<String,String> field : mqrfh2FixedFields) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_95);
    
							}
						}
						if(useMqRFH2_mcd ) { // mcd folder

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
							for(Map<String,String> field : mqrfh2mcdFields) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_101);
    
							}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
						}
						if(useMqRFH2_jms ) { //jms folder

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
							for(Map<String,String> field : mqrfh2jmsFields) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_110);
    
							}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
						}
						if(useMqRFH2_usr ) { //usr folder

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
							for(Map<String,String> field : mqrfh2usrFields) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_120);
    
							}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
						}

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
					}
					
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(metadata.getColumn("message").getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
					} else if ("Bytes".equals(msgBobyType)) {
					    IMetadataColumn column = conn.getMetadataTable().getColumn("message");
                        if(!"id_byte[]".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
                        }else{

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_144);
    
                        }
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
						for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_151);
    
						}

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
					}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
				}
			}
		}
	}  

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(TEXT_161);
    return stringBuffer.toString();
  }
}
