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

public class TMomObjectInputBeginJava
{
  protected static String nl;
  public static synchronized TMomObjectInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomObjectInputBeginJava result = new TMomObjectInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();" + NL + "\t\tprops_";
  protected final String TEXT_4 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\tprops_";
  protected final String TEXT_5 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_6 = "+\":\"+";
  protected final String TEXT_7 = ");" + NL + "\t\tprops_";
  protected final String TEXT_8 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\tprops_";
  protected final String TEXT_9 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\tprops_";
  protected final String TEXT_10 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "" + NL + "\t\tjavax.naming.Context context_";
  protected final String TEXT_11 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_12 = ");" + NL + "\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_13 = "=(javax.jms.ConnectionFactory)context_";
  protected final String TEXT_14 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\tString url_";
  protected final String TEXT_16 = " = \"tcp://\"+";
  protected final String TEXT_17 = "+\":\"+";
  protected final String TEXT_18 = ";" + NL + "\t\tlong timeout_";
  protected final String TEXT_19 = " =";
  protected final String TEXT_20 = ";" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\torg.apache.activemq.broker.BrokerService broker_";
  protected final String TEXT_22 = " = new org.apache.activemq.broker.BrokerService();" + NL + "\t\t\tbroker_";
  protected final String TEXT_23 = ".setUseJmx(true);" + NL + "\t\t\tbroker_";
  protected final String TEXT_24 = ".addConnector(url_";
  protected final String TEXT_25 = ");" + NL + "\t\t\tbroker_";
  protected final String TEXT_26 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_28 = ");" + NL + "\t\tSystem.out.println(\"Consuming \" + (";
  protected final String TEXT_29 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_30 = ");" + NL + "" + NL + "\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_31 = " = " + NL + "\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory" + NL + "\t\t\t(org.apache.activemq.ActiveMQConnection.DEFAULT_USER, org.apache.activemq.ActiveMQConnection.DEFAULT_PASSWORD, url_";
  protected final String TEXT_32 = ");" + NL + "\t\t";
  protected final String TEXT_33 = "\t\t" + NL + "" + NL + "\tjavax.jms.Connection connection_";
  protected final String TEXT_34 = " = factory_";
  protected final String TEXT_35 = ".createConnection();" + NL + "\tconnection_";
  protected final String TEXT_36 = ".start();" + NL + "\tjavax.jms.Session session_";
  protected final String TEXT_37 = " = connection_";
  protected final String TEXT_38 = ".createSession(";
  protected final String TEXT_39 = ", javax.jms.Session.";
  protected final String TEXT_40 = ");" + NL + "\tjavax.jms.Destination des_";
  protected final String TEXT_41 = " = null;" + NL + "\t";
  protected final String TEXT_42 = NL + "\t\tdes_";
  protected final String TEXT_43 = " = session_";
  protected final String TEXT_44 = ".createQueue(";
  protected final String TEXT_45 = ");" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\tdes_";
  protected final String TEXT_47 = " = session_";
  protected final String TEXT_48 = ".createTopic(";
  protected final String TEXT_49 = ");" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_51 = " = session_";
  protected final String TEXT_52 = ".createProducer(null);" + NL + "\treplyProducer_";
  protected final String TEXT_53 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "" + NL + "\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_54 = " = session_";
  protected final String TEXT_55 = ".createConsumer(des_";
  protected final String TEXT_56 = ", \"Sujet = '\"+";
  protected final String TEXT_57 = "+\"'\");" + NL + "\tSystem.out.println(\"";
  protected final String TEXT_58 = " Attente de la liste de sujet Sujet = '";
  protected final String TEXT_59 = "'\");" + NL + "\t";
  protected final String TEXT_60 = "\t\t\t\t\t" + NL + "\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\tjavax.jms.Message message_";
  protected final String TEXT_61 = ";" + NL + "" + NL + "\t\twhile((message_";
  protected final String TEXT_62 = "=consumer_";
  protected final String TEXT_63 = ".receive())!=null){" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\tSystem.out.println(\"";
  protected final String TEXT_66 = " Attente de la liste de sujets\");" + NL + "" + NL + "\t\t//Réception de la liste de sujets à écouter\t\t" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\tjava.util.List subjectList = null;" + NL + "\t\t\t\t//Boucle qui écoute jusqu'à ce qu'on ait retiré la liste du message." + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_67 = " = consumer_";
  protected final String TEXT_68 = ".receive()) != null) {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\tjavax.jms.ObjectMessage objMsg_";
  protected final String TEXT_69 = " = (javax.jms.ObjectMessage) message_";
  protected final String TEXT_70 = ";\t\t\t" + NL + "\t\t\t\t\tObject object = objMsg_";
  protected final String TEXT_71 = ".getObject();" + NL + "\t\t\t\t\tif (object instanceof org.opendas.modele.ServerRequest) {" + NL + "\t\t\t\t\t\torg.opendas.modele.ServerRequest serverRequest = (org.opendas.modele.ServerRequest) object;" + NL + "\t\t\t\t\t\tsubjectList = (java.util.List) serverRequest.getAttachement();" + NL + "\t\t\t\t\t\tSystem.out.println(\"";
  protected final String TEXT_72 = " Liste reçue\");" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t}" + NL + "" + NL + "" + NL + "" + NL + "\t\t\t\t//Création de la requête de sélection de sujets en fonction de la liste reçue." + NL + "\t\t\t\tStringBuilder strBuild = new StringBuilder();" + NL + "" + NL + "\t\t\t\tjava.util.Iterator it = subjectList.iterator();" + NL + "  \t\t\t\twhile(it.hasNext()){" + NL + "  \t\t\t\t\tstrBuild.append(\"Sujet = '\");" + NL + "     \t\t\t\tstrBuild.append(it.next() + \"'\");" + NL + "     \t\t\t\tif (it.hasNext())" + NL + "     \t\t\t\t\tstrBuild.append(\" OR \");" + NL + "\t\t\t\t}" + NL + "" + NL + "\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t//Création d'un autre MessageConsumer avec le bon MessageSelector " + NL + "\t\t\t\tSystem.out.println(\"";
  protected final String TEXT_73 = " Liste de sujets non utilisée\");//DEBUG" + NL + "\t\t\t\tconsumer_";
  protected final String TEXT_74 = " = session_";
  protected final String TEXT_75 = ".createConsumer(des_";
  protected final String TEXT_76 = ", strBuild.toString());" + NL + "\t\t\t\tSystem.out.println(\"\\n";
  protected final String TEXT_77 = " message selector : \" + consumer_";
  protected final String TEXT_78 = ".getMessageSelector());" + NL + "" + NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_79 = " = consumer_";
  protected final String TEXT_80 = ".receive()) != null) {" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\tint maxMsg_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "\t\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_84 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_85 = " = 0; i_";
  protected final String TEXT_86 = " < maxMsg_";
  protected final String TEXT_87 = " ;) {" + NL + "\t\t\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_88 = " = consumer_";
  protected final String TEXT_89 = ".receive();" + NL + "\t\t\t\t\t\tif (message_";
  protected final String TEXT_90 = " != null) {" + NL + "\t\t\t\t\t\t\ti_";
  protected final String TEXT_91 = "++;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\tSystem.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_93 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_94 = ";" + NL + "\t\t\t\t\t\t\twhile ((message_";
  protected final String TEXT_95 = " = consumer_";
  protected final String TEXT_96 = ".receive(";
  protected final String TEXT_97 = "*1000)) != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\tif (message_";
  protected final String TEXT_100 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\t\t\t\t\tjavax.jms.MapMessage objMsg_";
  protected final String TEXT_101 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\t\t\t\t\tString msg_";
  protected final String TEXT_103 = " = objMsg_";
  protected final String TEXT_104 = ".getString(";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tif(msg_";
  protected final String TEXT_106 = " !=null){" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tjavax.jms.ObjectMessage objMsg_";
  protected final String TEXT_108 = " = (javax.jms.ObjectMessage) message_";
  protected final String TEXT_109 = ";\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tString msg_";
  protected final String TEXT_110 = " = \"\";" + NL + "\t\t\t\t\t\t\t\t\tObject object = objMsg_";
  protected final String TEXT_111 = ".getObject();" + NL + "\t\t\t\t\t\t\t\t\tSystem.out.println(\"\\n";
  protected final String TEXT_112 = " Station : \" + objMsg_";
  protected final String TEXT_113 = ".getStringProperty(\"Station\"));//DEBUG" + NL + "\t\t\t\t\t\t\t\t\tString station = objMsg_";
  protected final String TEXT_114 = ".getStringProperty(\"Station\");" + NL + "\t\t\t\t\t\t\t\t\t//initialisation des champs récupérés dans le message" + NL + "\t\t\t\t\t\t\t\t\tString title = null;" + NL + "\t\t\t\t\t\t\t\t\tString sendUrl = null;" + NL + "\t\t\t\t\t\t\t\t\tString fromUrl = null;" + NL + "\t\t\t\t\t\t\t\t\tDate sendedDate = null;" + NL + "\t\t\t\t\t\t\t\t\tObject attachement = null;" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tif (object instanceof org.opendas.modele.ServerRequest) {" + NL + "\t\t\t\t\t\t\t\t\t\torg.opendas.modele.ServerRequest serverRequest = (org.opendas.modele.ServerRequest) object;" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t//champs qui serviront à créer l'object previousRequest que l'on enverra avec la réponse" + NL + "\t\t\t\t\t\t\t\t\t\t\t\ttitle = serverRequest.getTitle();//on récupère le champ \"title\"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsendUrl = serverRequest.getSendUrl();//on récupère le champ \"sendUrl\"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tfromUrl = serverRequest.getFromUrl();//on récupère le champ \"fromUrl\"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsendedDate = serverRequest.getSendedDate();//on récupère le champ \"sendedDate\"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t//champ contenant les paramètres de la requête XMLRPC à effectuer" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tattachement = serverRequest.getAttachement();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tSystem.out.println(\"";
  protected final String TEXT_115 = " title : \" + title);//DEBUG" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\t\t\t\t//renseigner les champs des connexions de sortie (champs pour previousRequest)" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".title = title;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_118 = ".sendUrl = sendUrl;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_119 = ".fromUrl = fromUrl;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".sendedDate = sendedDate;" + NL + "\t\t\t\t\t\t\t\t\t\t\t//champ attachement fournissant les paramètres pour la requête XMLRPC" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_121 = ".attachement = attachement;" + NL + "\t\t\t\t\t\t\t\t\t\t\t//nom de l'expéditeur du message (la propriété \"Sujet\" de la réponse prendra cette valeur)" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ".station = station;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = "\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = ".messageid=";
  protected final String TEXT_125 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = "\t    " + NL + "\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\tjava.util.Hashtable properties";
  protected final String TEXT_129 = "=new java.util.Hashtable();" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_130 = ".put(\"hostname\", ";
  protected final String TEXT_131 = ");" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_132 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_133 = "));" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_134 = ".put(\"channel\", ";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_136 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_137 = ".put(\"transport\",\"MQSeries\");" + NL + "" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueueManager qMgr";
  protected final String TEXT_138 = "=null;" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueue remoteQ";
  protected final String TEXT_139 = "=null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\tString msgId_";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = ";" + NL + "\t\t\t\t\t\tif (msgId_";
  protected final String TEXT_143 = " != null & !(\"\").equals(msgId_";
  protected final String TEXT_144 = ")) {" + NL + "\t\t\t\t\t\t\tString padding_";
  protected final String TEXT_145 = " = new String();" + NL + "\t\t\t\t\t\t\tint padlen_";
  protected final String TEXT_146 = " = 24;" + NL + "" + NL + "\t\t\t\t\t\t\tint len_";
  protected final String TEXT_147 = " = Math.abs(padlen_";
  protected final String TEXT_148 = ") - msgId_";
  protected final String TEXT_149 = ".toString().length();" + NL + "\t\t\t\t\t\t\tif (len_";
  protected final String TEXT_150 = " > 0) {" + NL + "\t\t\t\t\t\t\t\tfor (int i = 0 ; i < len_";
  protected final String TEXT_151 = " ; i++) {" + NL + "\t\t\t\t\t\t\t\t\tpadding_";
  protected final String TEXT_152 = " = padding_";
  protected final String TEXT_153 = " + \" \";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tmsgId_";
  protected final String TEXT_154 = " = msgId_";
  protected final String TEXT_155 = " + padding_";
  protected final String TEXT_156 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\ttry{" + NL + "" + NL + "\t\t\t\t\t\tint openOptions";
  protected final String TEXT_158 = "=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE;" + NL + "" + NL + "\t\t\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo";
  protected final String TEXT_159 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_160 = ".options=gmo";
  protected final String TEXT_161 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_162 = ".options=gmo";
  protected final String TEXT_163 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_164 = "MQGMO_NO_WAIT";
  protected final String TEXT_165 = "MQGMO_WAIT";
  protected final String TEXT_166 = ";" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_167 = ".options=gmo";
  protected final String TEXT_168 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_169 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\t\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\t\t\t\tboolean flag";
  protected final String TEXT_170 = "=true;" + NL + "" + NL + "\t\t\t\t\t\tqMgr";
  protected final String TEXT_171 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_172 = ",properties";
  protected final String TEXT_173 = ");" + NL + "\t\t\t\t\t\tremoteQ";
  protected final String TEXT_174 = "=qMgr";
  protected final String TEXT_175 = ".accessQueue(";
  protected final String TEXT_176 = ",openOptions";
  protected final String TEXT_177 = ");" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_179 = ".getCurrentDepth()).equals(0))" + NL + "\t\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t\tflag";
  protected final String TEXT_180 = "= false;" + NL + "\t\t\t\t\t\t\t} \t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_181 = "\t" + NL + "\t\t\t\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\t\t\t    System.out.println(\"Waiting...\");\t" + NL + "\t\t\t\t\t\twhile(flag";
  protected final String TEXT_182 = "){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_184 = ".getCurrentDepth()).equals(1))" + NL + "\t\t\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t\t\tflag";
  protected final String TEXT_185 = "= false;" + NL + "\t\t\t\t\t\t\t\t} \t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t\tcom.ibm.mq.MQMessage inMessage";
  protected final String TEXT_187 = "=new com.ibm.mq.MQMessage();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t\tinMessage";
  protected final String TEXT_189 = ".messageId = msgId_";
  protected final String TEXT_190 = ".getBytes(\"ISO-8859-15\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = "\t\t" + NL + "\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\tremoteQ";
  protected final String TEXT_192 = ".get(inMessage";
  protected final String TEXT_193 = ",gmo";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t\t\t\t\t}catch (com.ibm.mq.MQException me_";
  protected final String TEXT_195 = ") {   " + NL + "\t\t\t\t\t\t\t\t\tif (me_";
  protected final String TEXT_196 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t\t\t\t\t\t\t\tbreak;   " + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tthrow me_";
  protected final String TEXT_197 = ";" + NL + "\t\t\t\t\t\t\t\t\t}   " + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\tremoteQ";
  protected final String TEXT_199 = ".get(inMessage";
  protected final String TEXT_200 = ",gmo";
  protected final String TEXT_201 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t\t\tString msg_";
  protected final String TEXT_204 = "=inMessage";
  protected final String TEXT_205 = ".readStringOfCharLength(inMessage";
  protected final String TEXT_206 = ".getMessageLength());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_208 = " = new byte[inMessage";
  protected final String TEXT_209 = ".getMessageLength()];" + NL + "\t\t\t\t\t\t\t\tinMessage";
  protected final String TEXT_210 = ".readFully(bytesMsgBody_";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t\t\t\t\tString msg_";
  protected final String TEXT_212 = " = new String(bytesMsgBody_";
  protected final String TEXT_213 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\t\tjava.util.Map msg_";
  protected final String TEXT_215 = " = (java.util.Map)inMessage";
  protected final String TEXT_216 = ".readObject();\t\t\t  " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\t\t\t\tqMgr";
  protected final String TEXT_218 = ".commit();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t";
  protected final String TEXT_220 = ".from=";
  protected final String TEXT_221 = ";\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_222 = ".message=msg_";
  protected final String TEXT_223 = ";\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = " = (";
  protected final String TEXT_227 = ")msg_";
  protected final String TEXT_228 = ".get(\"";
  protected final String TEXT_229 = "\");" + NL;
  protected final String TEXT_230 = NL + "\t\t\t\t";
  protected final String TEXT_231 = ".messageid=new String(inMessage";
  protected final String TEXT_232 = ".messageId,\"ISO-8859-15\");\t";
  protected final String TEXT_233 = NL + NL + NL;
  protected final String TEXT_234 = NL;

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
String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
String msgId=ElementParameterParser.getValue(node, "__MSG_ID__");
String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
String from=ElementParameterParser.getValue(node, "__FROM__");
boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");

boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");

IMetadataTable metadata=null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	metadata = metadatas.get(0);
	columns = metadata.getListColumns();
}
if (("JBoss").equals(serverType)||("ActiveMQ").equals(serverType)) {

	/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
	if(("JBoss").equals(serverType) ){ // server judgement
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    		
	}else if(("ActiveMQ").equals(serverType)){
		boolean startServer = ("true").equals(ElementParameterParser.getValue(node, "__STARTSERVER__"));
		String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
		String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");

		if(("").equals(maxiumMessages)|| maxiumMessages == null){
			maxiumMessages = "0";
		}
		if(("").equals(receiveTimeOut)|| receiveTimeOut == null){
			receiveTimeOut = "0L";
		}
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(receiveTimeOut );
    stringBuffer.append(TEXT_20);
    
		if(startServer){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
		}
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append("Topic".equals(msgType));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	}

	/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_45);
    
	} else {
		
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_49);
    
	}
	
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(station );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(station );
    stringBuffer.append(TEXT_59);
    		
	/*---------------------------------------3.receive message form server ---------------------------------*/ 	
	if(("JBoss").equals(serverType) ){ 
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    		
		}else if(("ActiveMQ").equals(serverType)){
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
				}else if (useMax) {
					
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
						}else {
							
    stringBuffer.append(TEXT_92);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_97);
    
							}
						}
						
    stringBuffer.append(TEXT_98);
    				msgBobyType = "Text";

						/*-----------------------------------------------------------4.judge message body type---------------------------------------*/
						if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
							
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
								}else{
									
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
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
    

								}


								//Envoi des champs à toutes les connexions sortantes
								List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
								List<IMetadataColumn> columnList = metadata.getListColumns();
								for(IConnection conn:conns){
									if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
										String firstConnName = conn.getName();

										if ("Text".equals(msgBobyType) || "Bytes".equals(msgBobyType)) {
											
    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_122);
    
										}
										if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
											
    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_125);
    
								}
							}
						}	

						if (useMax) {
							
    stringBuffer.append(TEXT_126);
    
					}
					/*---------------------------------------------------------end 4----------------------------------------------------------------*/	
					
    stringBuffer.append(TEXT_127);
    
				} else { //server judgement   /***WebSphere MQ*****/
					String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
					String qm=ElementParameterParser.getValue(node, "__QM__");
					String queue = ElementParameterParser.getValue(node, "__QUEUE__");
					
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
					if(("true").equals(useMsgId)){
						
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
					}
					
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_164);
    }else{
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
						if(("false").equals(kListen)) {
							
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
						}	
						
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
							if(("false").equals(kListen)){
								
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
							}
							
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
							if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
								
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
							}
							if(("false").equals(kListen) && ("true").equals(useMsgId) && !"Map".equals(msgBobyType) ){
								
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
							} else {
								
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
							}
							
    stringBuffer.append(TEXT_202);
    		
							if ("Text".equals(msgBobyType)) {
								
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
							} else if ("Bytes".equals(msgBobyType)) {
								
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
							} else if ("Map".equals(msgBobyType)) {
								
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
							}
							if("true".equals(ElementParameterParser.getValue(node, "__COMMIT__")) && ("WebSphere").equals(serverType)){
								
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
							}
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<IMetadataColumn> columnList = metadata.getListColumns();
	for(IConnection conn:conns){
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
 			String firstConnName = conn.getName();
		 		if ("Text".equals(msgBobyType) || "Bytes".equals(msgBobyType)) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
				} else {
					for(IMetadataColumn column : columns) {
						String columType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());


    stringBuffer.append(TEXT_224);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(columType);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_229);
    
					}
				}
			if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){

    stringBuffer.append(TEXT_230);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
			}
		}
	}
						}
						
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    return stringBuffer.toString();
  }
}
