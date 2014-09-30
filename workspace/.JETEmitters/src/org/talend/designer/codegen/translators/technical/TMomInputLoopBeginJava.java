package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomInputLoopBeginJava
{
  protected static String nl;
  public static synchronized TMomInputLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopBeginJava result = new TMomInputLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "javax.jms.Connection connection_";
  protected final String TEXT_4 = " = null;" + NL + "try {" + NL;
  protected final String TEXT_5 = NL + "\t    connection_";
  protected final String TEXT_6 = " = null;" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_7 = " = null;" + NL + "            try {" + NL + "\t        connection_";
  protected final String TEXT_8 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_9 = "\");" + NL + "                connection_";
  protected final String TEXT_10 = ".start();" + NL + "\t\tsession_";
  protected final String TEXT_11 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_12 = "\");" + NL + "\t    } catch (NullPointerException npe) {" + NL + "\t    throw new RuntimeException(\"";
  protected final String TEXT_13 = " still not initialized. Try to redesign job.\");" + NL + "\t    }" + NL + "\t    javax.jms.Destination des_";
  protected final String TEXT_14 = " = null;" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\tdes_";
  protected final String TEXT_16 = " = session_";
  protected final String TEXT_17 = ".createQueue(";
  protected final String TEXT_18 = ");" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t    \tdes_";
  protected final String TEXT_20 = " = session_";
  protected final String TEXT_21 = ".createTopic(";
  protected final String TEXT_22 = ");" + NL + "\t\t";
  protected final String TEXT_23 = NL + NL + "\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_24 = " = session_";
  protected final String TEXT_25 = ".createProducer(null);" + NL + "\t\treplyProducer_";
  protected final String TEXT_26 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_27 = " = session_";
  protected final String TEXT_28 = ".createConsumer(des_";
  protected final String TEXT_29 = ");" + NL + "" + NL + "\t\tglobalMap.put(\"session_";
  protected final String TEXT_30 = "\",session_";
  protected final String TEXT_31 = ");" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_32 = "\",connection_";
  protected final String TEXT_33 = ");" + NL + "\t\t" + NL + "\t\t// Receive message" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_35 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_36 = " = consumer_";
  protected final String TEXT_37 = ".receive()) != null) {" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_38 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_39 = NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_43 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_44 = " = 0; i_";
  protected final String TEXT_45 = " < maxMsg_";
  protected final String TEXT_46 = " ;) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_47 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\t        javax.jms.Message message_";
  protected final String TEXT_49 = " = consumer_";
  protected final String TEXT_50 = ".receive();" + NL + "\t\t\t        if (message_";
  protected final String TEXT_51 = " != null) {" + NL + "\t\t            \ti_";
  protected final String TEXT_52 = "++;" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_54 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_55 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_56 = " = consumer_";
  protected final String TEXT_57 = ".receive(";
  protected final String TEXT_58 = "*1000)) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_59 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t    " + NL + "\t\t/*-----------------------------------------------------------4.judge message body type---------------------------------------*/" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\tif (message_";
  protected final String TEXT_63 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_64 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_66 = " = txtMsg_";
  protected final String TEXT_67 = ".getString(";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\tif(msg_";
  protected final String TEXT_69 = " !=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_71 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_72 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_73 = " = txtMsg_";
  protected final String TEXT_74 = ".getText();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_76 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_77 = ";" + NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_78 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_79 = ".getBodyLength()];" + NL + "\t\t\t\tbytesMsg_";
  protected final String TEXT_80 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_83 = " = new String(bytesMsgBody_";
  protected final String TEXT_84 = ");" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_86 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_87 = ";" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\tjava.util.Hashtable props_";
  protected final String TEXT_90 = "=new java.util.Hashtable();" + NL + "\t\t\tprops_";
  protected final String TEXT_91 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_92 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_93 = "+\":\"+";
  protected final String TEXT_94 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_95 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\tprops_";
  protected final String TEXT_96 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\tprops_";
  protected final String TEXT_97 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_98 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_99 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_100 = "=(javax.jms.ConnectionFactory)context_";
  protected final String TEXT_101 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t\tString url_";
  protected final String TEXT_103 = " =\"\";";
  protected final String TEXT_104 = NL + "\t\t\turl_";
  protected final String TEXT_105 = " = \"failover:(\";" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_107 = " = url_";
  protected final String TEXT_108 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_110 = " = url_";
  protected final String TEXT_111 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_112 = " = url_";
  protected final String TEXT_113 = " +";
  protected final String TEXT_114 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_115 = " = url_";
  protected final String TEXT_116 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_117 = " = url_";
  protected final String TEXT_118 = " +";
  protected final String TEXT_119 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\turl_";
  protected final String TEXT_121 = " = url_";
  protected final String TEXT_122 = " +\")?randomize=false\";" + NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_124 = " = url_";
  protected final String TEXT_125 = " +\"&\"+";
  protected final String TEXT_126 = "+\"=\"+";
  protected final String TEXT_127 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\turl_";
  protected final String TEXT_129 = " = \"tcp://\"+";
  protected final String TEXT_130 = "+\":\"+";
  protected final String TEXT_131 = ";" + NL + "\t\t\t";
  protected final String TEXT_132 = "\t\t\t" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\torg.apache.activemq.broker.BrokerService broker_";
  protected final String TEXT_134 = " = new org.apache.activemq.broker.BrokerService();" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_135 = ".setUseJmx(true);" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_136 = ".addConnector(url_";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_138 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_140 = ");" + NL + "\t\t\tSystem.out.println(\"Consuming \" + (";
  protected final String TEXT_141 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_142 = ");" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_143 = " = new org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_144 = ");" + NL + "\t\t";
  protected final String TEXT_145 = "\t\t" + NL + "\t\t";
  protected final String TEXT_146 = NL + "\t\t\tconnection_";
  protected final String TEXT_147 = " = factory_";
  protected final String TEXT_148 = ".createConnection();" + NL + "\t\t";
  protected final String TEXT_149 = NL + "\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t";
  protected final String TEXT_151 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_152 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = "; ";
  protected final String TEXT_157 = NL + "\t\t\tconnection_";
  protected final String TEXT_158 = " = factory_";
  protected final String TEXT_159 = ".createConnection(";
  protected final String TEXT_160 = ",decryptedPassword_";
  protected final String TEXT_161 = ");" + NL + "\t\t";
  protected final String TEXT_162 = NL + "\t\tconnection_";
  protected final String TEXT_163 = ".start();" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_164 = " = connection_";
  protected final String TEXT_165 = ".createSession(";
  protected final String TEXT_166 = ", javax.jms.Session.";
  protected final String TEXT_167 = ");" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_168 = " = null;" + NL + "" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_169 = NL + "\t\t\tdes_";
  protected final String TEXT_170 = " = session_";
  protected final String TEXT_171 = ".createQueue(";
  protected final String TEXT_172 = ");" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t    \tdes_";
  protected final String TEXT_174 = " = session_";
  protected final String TEXT_175 = ".createTopic(";
  protected final String TEXT_176 = ");" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_178 = " = session_";
  protected final String TEXT_179 = ".createProducer(null);" + NL + "\t\treplyProducer_";
  protected final String TEXT_180 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_181 = " = session_";
  protected final String TEXT_182 = ".createConsumer(des_";
  protected final String TEXT_183 = ");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_184 = NL + "\t\tglobalMap.put(\"session_";
  protected final String TEXT_185 = "\",session_";
  protected final String TEXT_186 = ");" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_187 = "\",connection_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + NL + "\t\t";
  protected final String TEXT_190 = "\t\t\t\t\t" + NL + "\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\tjavax.jms.Message message_";
  protected final String TEXT_191 = ";" + NL + "\t\t" + NL + "\t\t\twhile((message_";
  protected final String TEXT_192 = "=consumer_";
  protected final String TEXT_193 = ".receive())!=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_196 = " = consumer_";
  protected final String TEXT_197 = ".receive()) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_198 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_199 = NL + "\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_203 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_204 = " = 0; i_";
  protected final String TEXT_205 = " < maxMsg_";
  protected final String TEXT_206 = " ;) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_207 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_208 = NL + "\t\t\t        javax.jms.Message message_";
  protected final String TEXT_209 = " = consumer_";
  protected final String TEXT_210 = ".receive();" + NL + "\t\t\t        if (message_";
  protected final String TEXT_211 = " != null) {" + NL + "\t\t            \ti_";
  protected final String TEXT_212 = "++;" + NL + "\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_214 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_215 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_216 = " = consumer_";
  protected final String TEXT_217 = ".receive(";
  protected final String TEXT_218 = "*1000)) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_219 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\tif (message_";
  protected final String TEXT_222 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_223 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_224 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_225 = " = txtMsg_";
  protected final String TEXT_226 = ".getString(";
  protected final String TEXT_227 = ");" + NL + "\t\t\t\tif(msg_";
  protected final String TEXT_228 = " !=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_230 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_231 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_232 = " = txtMsg_";
  protected final String TEXT_233 = ".getText();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_235 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_236 = ";" + NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_237 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_238 = ".getBodyLength()];" + NL + "\t\t\t\tbytesMsg_";
  protected final String TEXT_239 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_240 = ");" + NL + "\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_242 = " = new String(bytesMsgBody_";
  protected final String TEXT_243 = ");" + NL + "\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_245 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_246 = ";" + NL + "\t\t\t";
  protected final String TEXT_247 = NL + "\t" + NL + "\t";
  protected final String TEXT_248 = NL + "\t\tjava.util.Hashtable properties";
  protected final String TEXT_249 = "=new java.util.Hashtable();" + NL + "\t\tproperties";
  protected final String TEXT_250 = ".put(\"hostname\", ";
  protected final String TEXT_251 = ");" + NL + "\t\tproperties";
  protected final String TEXT_252 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_253 = "));" + NL + "\t\tproperties";
  protected final String TEXT_254 = ".put(\"channel\", ";
  protected final String TEXT_255 = ");" + NL + "\t\tproperties";
  protected final String TEXT_256 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\tproperties";
  protected final String TEXT_257 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t";
  protected final String TEXT_258 = NL + "\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_259 = "\";" + NL + "\t\t";
  protected final String TEXT_260 = NL + "\t\t\tproperties";
  protected final String TEXT_261 = ".put(\"userID\",";
  protected final String TEXT_262 = ");" + NL + "\t\t\t";
  protected final String TEXT_263 = NL + "\t\t\t";
  protected final String TEXT_264 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_265 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_266 = ");";
  protected final String TEXT_267 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_268 = " = ";
  protected final String TEXT_269 = "; ";
  protected final String TEXT_270 = NL + "\t\t\t" + NL + "\t\t\tproperties";
  protected final String TEXT_271 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_272 = ");" + NL + "\t\t";
  protected final String TEXT_273 = NL + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr";
  protected final String TEXT_274 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ";
  protected final String TEXT_275 = "=null;" + NL + "\t\t";
  protected final String TEXT_276 = NL + "\t\t\tString msgId_";
  protected final String TEXT_277 = " = ";
  protected final String TEXT_278 = ";" + NL + "\t    \tif (msgId_";
  protected final String TEXT_279 = " != null & !(\"\").equals(msgId_";
  protected final String TEXT_280 = ")) {" + NL + "\t\t\t\tString padding_";
  protected final String TEXT_281 = " = new String();" + NL + "\t\t       \tint padlen_";
  protected final String TEXT_282 = " = 24;" + NL + "\t\t " + NL + "\t\t       \tint len_";
  protected final String TEXT_283 = " = Math.abs(padlen_";
  protected final String TEXT_284 = ") - msgId_";
  protected final String TEXT_285 = ".toString().length();" + NL + "\t\t       \tif (len_";
  protected final String TEXT_286 = " > 0) {" + NL + "\t\t        \tfor (int i = 0 ; i < len_";
  protected final String TEXT_287 = " ; i++) {" + NL + "\t\t           \t\tpadding_";
  protected final String TEXT_288 = " = padding_";
  protected final String TEXT_289 = " + \" \";" + NL + "\t\t         \t}" + NL + "\t\t        \tmsgId_";
  protected final String TEXT_290 = " = msgId_";
  protected final String TEXT_291 = " + padding_";
  protected final String TEXT_292 = ";" + NL + "\t\t        }" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_293 = NL + "\t\ttry{" + NL + "\t" + NL + "\t\t\tint openOptions";
  protected final String TEXT_294 = "=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE";
  protected final String TEXT_295 = " | com.ibm.mq.MQC.MQOO_BROWSE";
  protected final String TEXT_296 = ";" + NL + "\t\t" + NL + "\t\t\tcom.ibm.mq.MQGetMessageOptions gmo";
  protected final String TEXT_297 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\tgmo";
  protected final String TEXT_299 = ".options=gmo";
  protected final String TEXT_300 = ".options+com.ibm.mq.MQC.MQGMO_BROWSE_FIRST;" + NL + "\t\t\t\tint browseCursor_";
  protected final String TEXT_301 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t\tgmo";
  protected final String TEXT_303 = ".options=gmo";
  protected final String TEXT_304 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\tgmo";
  protected final String TEXT_306 = ".options=gmo";
  protected final String TEXT_307 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_308 = "MQGMO_NO_WAIT";
  protected final String TEXT_309 = "MQGMO_WAIT";
  protected final String TEXT_310 = ";" + NL + "\t\t\tgmo";
  protected final String TEXT_311 = ".options=gmo";
  protected final String TEXT_312 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\tgmo";
  protected final String TEXT_313 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\tboolean flag";
  protected final String TEXT_314 = "=true;" + NL + "\t\t" + NL + "\t\t\tqMgr";
  protected final String TEXT_315 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_316 = ",properties";
  protected final String TEXT_317 = ");" + NL + "\t\t\tremoteQ";
  protected final String TEXT_318 = "=qMgr";
  protected final String TEXT_319 = ".accessQueue(";
  protected final String TEXT_320 = ",openOptions";
  protected final String TEXT_321 = ");" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_323 = ".getCurrentDepth()).equals(0))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_324 = "= false;" + NL + "\t\t\t\t} \t" + NL + "\t\t\t";
  protected final String TEXT_325 = "\t" + NL + "\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\twhile(flag";
  protected final String TEXT_326 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_328 = ".getCurrentDepth()).equals(1))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tflag";
  protected final String TEXT_329 = "= false;" + NL + "\t\t\t\t\t} \t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_330 = NL + "\t\t\t\t";
  protected final String TEXT_331 = NL + "\t\t\t\t\tif(browseCursor_";
  protected final String TEXT_332 = " > 0){" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_333 = ".options=com.ibm.mq.MQC.MQGMO_BROWSE_NEXT; " + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_334 = ".options=gmo";
  protected final String TEXT_335 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_336 = "MQGMO_NO_WAIT";
  protected final String TEXT_337 = "MQGMO_WAIT";
  protected final String TEXT_338 = ";" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_339 = ".options=gmo";
  protected final String TEXT_340 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tbrowseCursor_";
  protected final String TEXT_341 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_342 = NL + "\t\t\t\tcom.ibm.mq.MQMessage inMessage";
  protected final String TEXT_343 = "=new com.ibm.mq.MQMessage();" + NL + "\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t\tinMessage";
  protected final String TEXT_345 = ".messageId = msgId_";
  protected final String TEXT_346 = ".getBytes(\"ISO-8859-15\");" + NL + "\t\t\t\t";
  protected final String TEXT_347 = "\t\t" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tremoteQ";
  protected final String TEXT_348 = ".get(inMessage";
  protected final String TEXT_349 = ",gmo";
  protected final String TEXT_350 = ");" + NL + "\t\t\t\t\t}catch (com.ibm.mq.MQException me_";
  protected final String TEXT_351 = ") {   " + NL + "\t\t\t            if (me_";
  protected final String TEXT_352 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t            \tbreak;   " + NL + "\t\t\t            }else{" + NL + "\t\t\t            \tthrow me_";
  protected final String TEXT_353 = ";" + NL + "\t\t\t            }   " + NL + "\t     \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_354 = NL + "\t\t\t\t\tremoteQ";
  protected final String TEXT_355 = ".get(inMessage";
  protected final String TEXT_356 = ",gmo";
  protected final String TEXT_357 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_358 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_359 = "\t\t\t\t" + NL + "\t\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_360 = " = new org.talend.mq.headers.rfh2.MQRFH2(inMessage";
  protected final String TEXT_361 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_362 = NL + NL + "\t\t\t\t";
  protected final String TEXT_363 = NL + "\t\t    \t\tString msg_";
  protected final String TEXT_364 = "=inMessage";
  protected final String TEXT_365 = ".readStringOfByteLength(inMessage";
  protected final String TEXT_366 = ".getDataLength());" + NL + "\t\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_368 = " = new byte[inMessage";
  protected final String TEXT_369 = ".getDataLength()];" + NL + "\t\t\t\t\tinMessage";
  protected final String TEXT_370 = ".readFully(bytesMsgBody_";
  protected final String TEXT_371 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_373 = " = new String(bytesMsgBody_";
  protected final String TEXT_374 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\t\t\tjava.util.Map msg_";
  protected final String TEXT_376 = " = (java.util.Map)inMessage";
  protected final String TEXT_377 = ".readObject();\t\t\t  " + NL + "\t\t\t\t";
  protected final String TEXT_378 = NL + "\t\t\t\t\tqMgr";
  protected final String TEXT_379 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_380 = NL + NL + NL + "\t\t";
  protected final String TEXT_381 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
        boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
        String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	String msgId=ElementParameterParser.getValue(node, "__MSG_ID__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String from=ElementParameterParser.getValue(node, "__FROM__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");

	String strHost = null;
	String strPort = null;
	
	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));

        boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
    	
        if (isUseConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType = ElementParameterParser.getValue(pNode, "__SERVER__");
                           	failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}

	IMetadataTable metadata=null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		columns = metadata.getListColumns();
	} 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
     if (isUseConnection) { 
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
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_18);
    
		} else {
		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_22);
    
		}
		
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
     boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_38);
    
		}
		
    stringBuffer.append(TEXT_39);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_47);
    
		}
		
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
			}else {
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_58);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_59);
    
		}
		
    stringBuffer.append(TEXT_60);
    
			} 
    stringBuffer.append(TEXT_61);
    
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
		}else{
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
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
    
			    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
			    }
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
			}
	}
		
    stringBuffer.append(TEXT_88);
          } else if (("JBoss").equals(serverType)||("ActiveMQ").equals(serverType)) {
	
		/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType) ){ // server judgement
		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    		
		}else if(("ActiveMQ").equals(serverType)){
			boolean startServer = ("true").equals(ElementParameterParser.getValue(node, "__STARTSERVER__"));
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    if(failover){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");

					if(i>0) {
					
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
					}
					
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_119);
    
					i++;
				}
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
				for(Map<String, String> optrion : additionalOpts) {
				
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_127);
    
				}
			}else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    
			if(startServer){
			
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    
			}
			
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append("Topic".equals(msgType));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
		
    stringBuffer.append(TEXT_145);
    	
		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
		} else {
		
    stringBuffer.append(TEXT_149);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_150);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_153);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
		}
		
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_172);
    
		} else {
		
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_176);
    
		}
		
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    	//put session to global map
		if( ("ActiveMQ").equals(serverType)) {
		
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
		}
		
    stringBuffer.append(TEXT_189);
    		
		/*---------------------------------------3.recevice message form server ---------------------------------*/ 	
		if(("JBoss").equals(serverType) ){ 
		
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    		
		}else if(("ActiveMQ").equals(serverType)){
			boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_198);
    
		}
		
    stringBuffer.append(TEXT_199);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_207);
    
		}
		
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    
			}else {
			
    stringBuffer.append(TEXT_213);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_218);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_219);
    
		}
		
    stringBuffer.append(TEXT_220);
    
			}
		}
		/*-----------------------------------------------------------4.judge message body type---------------------------------------*/
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    
		}else{
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
			    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
			    }
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
			}
		}
		
    stringBuffer.append(TEXT_247);
    
	} else { //server judgement   /***WebSphere MQ*****/
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
		String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
		isCommit = isCommit && !isBrowse;
		isBrowse = isBrowse && !isRollback && !isCommit;
		
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
		if(needSSLCipher){
		
    stringBuffer.append(TEXT_258);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_259);
    
		}
		if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_262);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_263);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_266);
    } else {
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
		}
		
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
		if(("true").equals(useMsgId)){
		
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
		}
		
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    if(isBrowse){
    stringBuffer.append(TEXT_295);
    }
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    if(isBrowse){
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    }else{
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_308);
    }else{
    stringBuffer.append(TEXT_309);
    }
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
			if(("false").equals(kListen)) {
			
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
			}	
			
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
				if(("false").equals(kListen)){
				
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
				}
				
    stringBuffer.append(TEXT_330);
    
				if(isBrowse){
				
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_336);
    }else{
    stringBuffer.append(TEXT_337);
    }
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
				}
				
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
				if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
				
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    
				}
				if(("false").equals(kListen) && ("true").equals(useMsgId) && !"Map".equals(msgBobyType) ){
				
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
				} else {
				
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
				}
				
    stringBuffer.append(TEXT_358);
    
				if (useMqHeader) {
				
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    }
    stringBuffer.append(TEXT_362);
    		
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
			    	if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    
			    	}
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    
				}
				if(isCommit){
				
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    
				}
				
	}
	
    stringBuffer.append(TEXT_380);
    stringBuffer.append(TEXT_381);
    return stringBuffer.toString();
  }
}
