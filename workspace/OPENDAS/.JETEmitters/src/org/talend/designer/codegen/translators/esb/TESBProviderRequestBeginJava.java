package org.talend.designer.codegen.translators.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TESBProviderRequestBeginJava
{
  protected static String nl;
  public static synchronized TESBProviderRequestBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBProviderRequestBeginJava result = new TESBProviderRequestBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//*** ESB context initialization" + NL + "\tfinal String endpointUrl = ";
  protected final String TEXT_2 = ";" + NL + "//*** ESB context initialization finish" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "/**" + NL + " * queued message exchange" + NL + " */" + NL + "class QueuedExchangeContextImpl<T> {" + NL + "" + NL + "\t/**" + NL + "\t * Exchange timeout in seconds" + NL + "\t */" + NL + "\tprivate static final long EXCHANGE_TIMEOUT = 50;" + NL + "" + NL + "\tprivate final java.util.concurrent.Exchanger<Exception> exceptionExchange =" + NL + "\t\tnew java.util.concurrent.Exchanger<Exception>();" + NL + "\tprivate final java.util.concurrent.CountDownLatch latch =" + NL + "\t\tnew java.util.concurrent.CountDownLatch(1);" + NL + "" + NL + "\tprivate final T input;" + NL + "" + NL + "\tprivate T output = null;" + NL + "\tprivate T faultDetails = null;" + NL + "\tprivate Throwable fault = null;" + NL + "\tprivate String faultMessage = null;" + NL + "" + NL + "\tpublic QueuedExchangeContextImpl(T inMsg) {" + NL + "\t\tthis.input = inMsg;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Don't forget to call this method when you are done" + NL + "\t * with processing of the {@link QueuedExchangeContext}" + NL + "\t */" + NL + "\tpublic void release() throws Exception {" + NL + "\t\tlatch.countDown();" + NL + "\t\tException exception;" + NL + "\t\ttry {" + NL + "\t\t\texception = exceptionExchange.exchange(null, EXCHANGE_TIMEOUT," + NL + "\t\t\t\t\tjava.util.concurrent.TimeUnit.SECONDS);" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\tthrow new Exception(e);" + NL + "\t\t} catch (java.util.concurrent.TimeoutException e) {" + NL + "\t\t\tthrow new Exception(e);" + NL + "\t\t}" + NL + "\t\tif (exception != null) {" + NL + "\t\t\tthrow exception;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This operation have to be called on the Web Service" + NL + "\t * thread to send response if required" + NL + "\t *" + NL + "\t * @throws InterruptedException" + NL + "\t */" + NL + "\tpublic void completeQueuedProcessing() throws InterruptedException {" + NL + "\t\texceptionExchange.exchange(null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @throws InterruptedException" + NL + "\t */" + NL + "\tvoid waitForRelease(long timeout, java.util.concurrent.TimeUnit unit)" + NL + "\t\t\tthrows InterruptedException {" + NL + "\t\tlatch.await(timeout, unit);" + NL + "\t}" + NL + "" + NL + "\tpublic T getInputMessage() {" + NL + "\t\treturn input;" + NL + "\t}" + NL + "" + NL + "\tpublic void serveOutputMessage(T response) {" + NL + "\t\toutput = response;" + NL + "\t}" + NL + "" + NL + "\tpublic void serveBusinessFault(String faultMessage, T faultDetails) {" + NL + "\t\tthis.faultMessage =" + NL + "\t\t\t(null == faultMessage || 0 == faultMessage.trim().length())" + NL + "\t\t\t\t? \"Talend job business fault\" : faultMessage;" + NL + "\t\tthis.faultDetails = faultDetails;" + NL + "\t}" + NL + "" + NL + "\tpublic void serveFault(String faultMessage, Throwable fault) {" + NL + "\t\tthis.faultMessage =" + NL + "\t\t\t(null == faultMessage || 0 == faultMessage.trim().length())" + NL + "\t\t\t\t? \"Talend job error\" : faultMessage;" + NL + "\t\tthis.fault = fault;" + NL + "\t}" + NL + "" + NL + "\tpublic boolean isFault() {" + NL + "\t\treturn (faultMessage != null);" + NL + "\t}" + NL + "" + NL + "\tpublic boolean isBusinessFault() {" + NL + "\t\treturn isFault() && null == fault;" + NL + "\t}" + NL + "" + NL + "\tpublic T getResponse() {" + NL + "\t\treturn output;" + NL + "\t}" + NL + "" + NL + "\tpublic String getFaultMessage() {" + NL + "\t\treturn faultMessage;" + NL + "\t}" + NL + "" + NL + "\tpublic T getBusinessFaultDetails() {" + NL + "\t\treturn faultDetails;" + NL + "\t}" + NL + "" + NL + "\tpublic Throwable getFault() {" + NL + "\t\treturn fault;" + NL + "\t}" + NL + "" + NL + "}" + NL + "" + NL + "/**" + NL + " * message exchange controller" + NL + " */" + NL + "class QueuedMessageHandlerImpl<T> implements ESBProviderCallback {" + NL + "\tprivate final int MAX_QUEUE_SIZE = 1000;" + NL + "" + NL + "\tprivate final int WAIT_TIMEOUT_SECONDS = 120;" + NL + "" + NL + "\tprivate final java.util.concurrent.BlockingQueue<QueuedExchangeContextImpl<?>> queue =" + NL + "\t\tnew java.util.concurrent.LinkedBlockingQueue<QueuedExchangeContextImpl<?>>(MAX_QUEUE_SIZE);" + NL + "" + NL + "\t/**" + NL + "\t * This method add a newly created" + NL + "\t * {@link QueuedExchangeContextImpl} into the internal" + NL + "\t * blocking queue where consumer thread is waiting for it." + NL + "\t * Then it waits until the {@link QueuedExchangeContextImpl}" + NL + "\t * will be completed for request-response operations" + NL + "\t */" + NL + "\tpublic QueuedExchangeContextImpl<T> invoke(T request) {" + NL + "\t\tQueuedExchangeContextImpl<T> context =" + NL + "\t\t\tnew QueuedExchangeContextImpl<T>(request);" + NL + "\t\tboolean inserted = queue.offer(context);" + NL + "\t\tif (!inserted) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tcontext.release();" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t\t// context.serveFault(\"job pool overflow exceed\", null);" + NL + "\t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\"Can't queue request, queue size of \"" + NL + "\t\t\t\t\t\t\t+ MAX_QUEUE_SIZE + \" is exceeded\");" + NL + "\t\t} else {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tcontext.waitForRelease(WAIT_TIMEOUT_SECONDS," + NL + "\t\t\t\t\t\tjava.util.concurrent.TimeUnit.SECONDS);" + NL + "\t\t\t} catch (InterruptedException ie) {" + NL + "\t\t\t\t// context.serveFault(\"job execution timeout\", ie);" + NL + "\t\t\t\tthrow new RuntimeException(" + NL + "\t\t\t\t\t\t\"job execution timeout: \" + ie.getMessage());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn context;" + NL + "\t}" + NL + "" + NL + "\tQueuedExchangeContextImpl<T> currentExchangeContext;" + NL + "" + NL + "\tpublic Object getRequest() throws ESBJobInterruptedException {" + NL + "\t\tcurrentExchangeContext = null;" + NL + "\t\ttry {" + NL + "\t\t\tcurrentExchangeContext = (QueuedExchangeContextImpl<T>) queue.take();" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\t// e.printStackTrace();" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "\t\t}" + NL + "\t\treturn currentExchangeContext.getInputMessage();" + NL + "\t}" + NL + "" + NL + "\tpublic void sendResponse(Object output) {" + NL + "\t\tif (null == currentExchangeContext) {" + NL + "\t\t\tthrow new RuntimeException(\"sendResponse() invoked before getRequest()\");" + NL + "\t\t}" + NL + "" + NL + "\t\t// business fault" + NL + "\t\tif (output instanceof ProviderFault) {" + NL + "\t\t\tProviderFault providerFault = (ProviderFault) output;" + NL + "\t\t\tcurrentExchangeContext.serveBusinessFault(" + NL + "\t\t\t\t\tproviderFault.getMessage(), (T) providerFault.getDetail());" + NL + "\t\t}" + NL + "" + NL + "\t\t// job error" + NL + "\t\tif (output instanceof Exception) {" + NL + "\t\t\tcurrentExchangeContext.serveFault(" + NL + "\t\t\t\t\t\"Talend job execution error\", (Throwable) output);" + NL + "\t\t}" + NL + "" + NL + "\t\t// payload" + NL + "\t\tcurrentExchangeContext.serveOutputMessage((T) output);" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tcurrentExchangeContext.release();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t// e.printStackTrace();" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "/**" + NL + " * web service provider implementation" + NL + " */";
  protected final String TEXT_5 = NL + "@javax.jws.WebService(" + NL + "\t\tname = \"";
  protected final String TEXT_6 = "\"," + NL + "\t\ttargetNamespace = \"";
  protected final String TEXT_7 = "\"" + NL + "\t)" + NL + "@javax.jws.soap.SOAPBinding(" + NL + "\t\tparameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.BARE" + NL + "\t)" + NL + "@javax.xml.ws.ServiceMode(" + NL + "\t\tvalue = javax.xml.ws.Service.Mode.PAYLOAD" + NL + "\t)" + NL + "@javax.xml.ws.WebServiceProvider()" + NL + "class ESBProvider_";
  protected final String TEXT_8 = " implements" + NL + "\t\tjavax.xml.ws.Provider<javax.xml.transform.Source> {" + NL + "" + NL + "\tprivate javax.xml.transform.TransformerFactory factory =" + NL + "\t\tjavax.xml.transform.TransformerFactory.newInstance();" + NL + "\tprivate QueuedMessageHandlerImpl<org.dom4j.Document> messageHandler;" + NL + "" + NL + "\tprivate final String TNS = ESBProvider_";
  protected final String TEXT_9 = ".class.getAnnotation(" + NL + "\t\t\tjavax.jws.WebService.class).targetNamespace();" + NL + "" + NL + "\tpublic ESBProvider_";
  protected final String TEXT_10 = "(" + NL + "\t\t\tQueuedMessageHandlerImpl<org.dom4j.Document> messageHandler) {" + NL + "\t\tthis.messageHandler = messageHandler;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "\t@javax.jws.WebMethod(" + NL + "\t\t\toperationName = \"";
  protected final String TEXT_12 = "\"," + NL + "\t\t\taction = \"";
  protected final String TEXT_13 = "/";
  protected final String TEXT_14 = "\"" + NL + "\t\t)";
  protected final String TEXT_15 = NL + "\t@javax.jws.Oneway()";
  protected final String TEXT_16 = NL + "\t@javax.jws.WebResult(" + NL + "\t\t\tname = \"";
  protected final String TEXT_17 = "Output\"," + NL + "\t\t\ttargetNamespace = \"";
  protected final String TEXT_18 = "\"," + NL + "\t\t\tpartName = \"response\"" + NL + "\t\t)";
  protected final String TEXT_19 = NL + "\tpublic javax.xml.transform.Source invoke(" + NL + "\t\t\t@javax.jws.WebParam(" + NL + "\t\t\t\t\tname = \"";
  protected final String TEXT_20 = "Input\"," + NL + "\t\t\t\t\ttargetNamespace = \"";
  protected final String TEXT_21 = "\"," + NL + "\t\t\t\t\tpartName = \"request\"" + NL + "\t\t\t\t) javax.xml.transform.Source request) {" + NL + "" + NL + "\t\t// System.out.println(System.currentTimeMillis() + \" -> handleMessage\");" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\torg.dom4j.io.DocumentResult docResult = new org.dom4j.io.DocumentResult();" + NL + "\t\t\tfactory.newTransformer().transform(request, docResult);" + NL + "\t\t\torg.dom4j.Document requestDoc = docResult.getDocument();" + NL + "\t\t\t// System.out.println(\"request: \" + requestDoc.asXML());" + NL + "" + NL + "\t\t\tQueuedExchangeContextImpl<org.dom4j.Document> messageExchange =" + NL + "\t\t\t\tmessageHandler.invoke(requestDoc);" + NL + "" + NL + "\t\t\ttry {";
  protected final String TEXT_22 = NL + "\t\t\t\treturn null;";
  protected final String TEXT_23 = NL + "\t\t\t\tif (messageExchange.isFault()) {" + NL + "\t\t\t\t\tString faultString = messageExchange.getFaultMessage();" + NL + "\t\t\t\t\t// System.out.println(\"fault: \" + faultString);" + NL + "" + NL + "\t\t\t\t\tif (messageExchange.isBusinessFault()) {" + NL + "\t\t\t\t\t\torg.dom4j.Document faultDoc = messageExchange.getBusinessFaultDetails();" + NL + "\t\t\t\t\t\tjavax.xml.soap.SOAPFactory soapFactory =" + NL + "\t\t\t\t\t\t\tjavax.xml.soap.SOAPFactory.newInstance();" + NL + "\t\t\t\t\t\tjavax.xml.soap.SOAPFault soapFault =" + NL + "\t\t\t\t\t\t\tsoapFactory.createFault(faultString," + NL + "\t\t\t\t\t\t\t\t\tnew javax.xml.namespace.QName(TNS, \"businessFault\"));" + NL + "\t\t\t\t\t\tif (null != faultDoc) {" + NL + "\t\t\t\t\t\t\t// System.out.println(\"business fault details: \" + faultDoc.asXML());" + NL + "\t\t\t\t\t\t\torg.dom4j.io.DOMWriter writer = new org.dom4j.io.DOMWriter();" + NL + "\t\t\t\t\t\t\torg.w3c.dom.Document faultDetailDom = writer.write(faultDoc);" + NL + "\t\t\t\t\t\t\tsoapFault.addDetail().appendChild(" + NL + "\t\t\t\t\t\t\t\t\tsoapFault.getOwnerDocument().importNode(" + NL + "\t\t\t\t\t\t\t\t\t\t\tfaultDetailDom.getDocumentElement(), true));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tthrow new javax.xml.ws.soap.SOAPFaultException(soapFault);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tThrowable error = messageExchange.getFault();" + NL + "\t\t\t\t\t\t// System.out.println(\"job error: \" + error.getMessage());" + NL + "\t\t\t\t\t\tif (error instanceof RuntimeException) {" + NL + "\t\t\t\t\t\t\tthrow (RuntimeException) error;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(faultString, error);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\torg.dom4j.Document responseDoc = messageExchange.getResponse();" + NL + "\t\t\t\t\tif (null == responseDoc) {" + NL + "\t\t\t\t\t\t// System.out.println(\"response: empty\");" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"no response provided by Talend job\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t// System.out.println(\"response: \" + responseDoc.asXML());" + NL + "" + NL + "\t\t\t\t\treturn new org.dom4j.io.DocumentSource(responseDoc);" + NL + "\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t} finally {" + NL + "\t\t\t\tmessageExchange.completeQueuedProcessing();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t} catch (RuntimeException ex) {" + NL + "\t\t\tthrow ex;" + NL + "\t\t} catch (Throwable ex) {" + NL + "\t\t\tex.printStackTrace();" + NL + "\t\t\tthrow new RuntimeException(ex);" + NL + "\t\t} finally {" + NL + "\t\t\t// System.out.println(System.currentTimeMillis() + \" <- handleMessage\");" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "class HandlerThread_";
  protected final String TEXT_25 = " extends Thread {" + NL + "" + NL + "\tprivate final String TNS = ESBProvider_";
  protected final String TEXT_26 = ".class.getAnnotation(" + NL + "\t\t\tjavax.jws.WebService.class).targetNamespace();" + NL + "" + NL + "\tprivate final String serviceName;" + NL + "" + NL + "\tprivate javax.xml.ws.Endpoint endpoint;" + NL + "\tQueuedMessageHandlerImpl<org.dom4j.Document> handler;" + NL + "" + NL + "\tpublic HandlerThread_";
  protected final String TEXT_27 = "(" + NL + "\t\t\tQueuedMessageHandlerImpl<org.dom4j.Document> handler," + NL + "\t\t\tString serviceName) {" + NL + "\t\tthis.handler = handler;" + NL + "\t\tthis.serviceName = serviceName;" + NL + "\t}" + NL + "" + NL + "\tpublic void run() {" + NL + "\t\tESBProvider_";
  protected final String TEXT_28 = " esbProvider = new ESBProvider_";
  protected final String TEXT_29 = "(handler);" + NL + "" + NL + "\t\tendpoint = javax.xml.ws.Endpoint.create(esbProvider);" + NL + "\t\t@SuppressWarnings(\"serial\")" + NL + "\t\tjava.util.Map<String, Object> map = new java.util.HashMap<String, Object>() {{" + NL + "\t\t\tput(javax.xml.ws.Endpoint.WSDL_SERVICE," + NL + "\t\t\t\t\tnew javax.xml.namespace.QName(TNS, serviceName));" + NL + "\t\t\tput(javax.xml.ws.Endpoint.WSDL_PORT," + NL + "\t\t\t\t\tnew javax.xml.namespace.QName(TNS, serviceName + \"SoapBinding\"));" + NL + "\t\t}};" + NL + "\t\tendpoint.setProperties(map);" + NL + "\t\tendpoint.publish(endpointUrl);" + NL + "" + NL + "\t\tSystem.out.println(\"web service [endpoint: \" + endpointUrl + \"] published\");" + NL + "\t}" + NL + "" + NL + "\tpublic void stopEndpoint() {" + NL + "\t\tif (null != endpoint) {" + NL + "\t\t\tendpoint.stop();" + NL + "\t\t\tSystem.out.println(\"web service [endpoint: \" + endpointUrl + \"] unpublished\");" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "//*** external processor(s) initialization" + NL + "\tESBProviderCallback providerCallback;" + NL + "\tHandlerThread_";
  protected final String TEXT_30 = " handlerThread_";
  protected final String TEXT_31 = " = null; " + NL + "\tif (null == callback) {" + NL + "\t\tfinal QueuedMessageHandlerImpl<org.dom4j.Document> handler =" + NL + "\t\t\tnew QueuedMessageHandlerImpl<org.dom4j.Document>(); " + NL + "\t\thandlerThread_";
  protected final String TEXT_32 = " =" + NL + "\t\t\tnew HandlerThread_";
  protected final String TEXT_33 = "(handler, \"";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "\");" + NL + "\t\thandlerThread_";
  protected final String TEXT_36 = ".start();" + NL + "\t\tproviderCallback = handler;" + NL + "\t} else {" + NL + "\t\tproviderCallback = callback;" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"esbHandler\", providerCallback);" + NL + "//*** external processor(s) initialization finish" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_37 = " = 0;" + NL + "" + NL + "try {" + NL + "\t// This is a beginning of the ESB provider request component cycle" + NL + "\twhile(true) {" + NL + "\t\ttry {" + NL;
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String projectName = codeGenArgument.getCurrentProjectName();
	String processName = node.getProcess().getName();

	boolean isOneWay = (node.getProcess().getNodesOfType("tESBProviderFault").isEmpty()
		&& node.getProcess().getNodesOfType("tESBProviderResponse").isEmpty());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    
	String methodName = ElementParameterParser.getValue(node,"__METHOD__");
	methodName = methodName.split("\\(")[0];
	String serviceNS = ElementParameterParser.getValue(node,"__SERVICE_NS__");
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SERVICE_NAME__"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
     
	 
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_14);
     if (isOneWay) { 
    stringBuffer.append(TEXT_15);
     } else { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_18);
     } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_21);
     if (isOneWay) { 
    stringBuffer.append(TEXT_22);
     } else { 
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
