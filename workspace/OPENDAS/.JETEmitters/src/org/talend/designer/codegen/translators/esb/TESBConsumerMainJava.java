package org.talend.designer.codegen.translators.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "\torg.dom4j.Document responseDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {" + NL + "\t\tDocument requestTalendDoc = ";
  protected final String TEXT_5 = ".payload;" + NL + "" + NL + "\t\tif (consumer_";
  protected final String TEXT_6 = " == null) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tresponseDoc_";
  protected final String TEXT_7 = " = serviceInvokerHelper_";
  protected final String TEXT_8 = ".invoke(" + NL + "\t\t\t\t\t\tserviceName_";
  protected final String TEXT_9 = ", portName_";
  protected final String TEXT_10 = ", \"";
  protected final String TEXT_11 = "\"," + NL + "\t\t\t\t\t\trequestTalendDoc.getDocument());" + NL + "\t\t\t} catch (javax.xml.ws.soap.SOAPFaultException e) {";
  protected final String TEXT_12 = NL + "\t\t\t\tString faultString = e.getFault().getFaultString();" + NL + "\t\t\t\tDocument faultTalendDoc = null;" + NL + "\t\t\t\tif (null != e.getFault().getDetail()" + NL + "\t\t\t\t\t&& null != e.getFault().getDetail().getFirstChild()) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tjavax.xml.transform.Source faultSource =" + NL + "\t\t\t\t\t\t\tnew javax.xml.transform.dom.DOMSource(" + NL + "\t\t\t\t\t\t\t\t\te.getFault().getDetail().getFirstChild());" + NL + "" + NL + "\t\t\t\t\t\torg.dom4j.io.DocumentResult result = new org.dom4j.io.DocumentResult();" + NL + "\t\t\t\t\t\tjavax.xml.transform.TransformerFactory.newInstance()" + NL + "\t\t\t\t\t\t\t.newTransformer().transform(faultSource, result);" + NL + "\t\t\t\t\t\torg.dom4j.Document faultDoc = result.getDocument();" + NL + "" + NL + "\t\t\t\t\t\tfaultTalendDoc = new Document();" + NL + "\t\t\t\t\t\tfaultTalendDoc.setDocument(faultDoc);" + NL + "\t\t\t\t\t} catch (Exception e1) {" + NL + "\t\t\t\t\t\te1.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (";
  protected final String TEXT_13 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = " = new ";
  protected final String TEXT_15 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_16 = ".faultString = faultString;" + NL + "\t\t\t\t";
  protected final String TEXT_17 = ".faultDetail = faultTalendDoc;";
  protected final String TEXT_18 = NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tresponseDoc_";
  protected final String TEXT_19 = " = (org.dom4j.Document) consumer_";
  protected final String TEXT_20 = ".invoke(requestTalendDoc.getDocument());" + NL + "\t\t\t} catch(Exception e){";
  protected final String TEXT_21 = NL + "\t\t\t\tString faultMessage = e.getMessage();" + NL + "\t\t\t\tif (";
  protected final String TEXT_22 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = " = new ";
  protected final String TEXT_24 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_25 = ".faultString = faultMessage;" + NL + "\t\t\t\t";
  protected final String TEXT_26 = ".faultDetail = null;";
  protected final String TEXT_27 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} catch(Exception e){";
  protected final String TEXT_28 = NL + "\t\t\tthrow(e);";
  protected final String TEXT_29 = NL + "\t\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_30 = NL + "\t}" + NL;
  protected final String TEXT_31 = NL + "\tif (null != responseDoc_";
  protected final String TEXT_32 = ") {" + NL + "\t\tif (";
  protected final String TEXT_33 = " == null) {" + NL + "\t\t\t";
  protected final String TEXT_34 = " = new ";
  protected final String TEXT_35 = "Struct();" + NL + "\t\t}" + NL + "" + NL + "\t\tDocument responseTalendDoc_";
  protected final String TEXT_36 = " = new Document();" + NL + "\t\tresponseTalendDoc_";
  protected final String TEXT_37 = ".setDocument(responseDoc_";
  protected final String TEXT_38 = ");" + NL + "\t\t";
  protected final String TEXT_39 = ".payload = responseTalendDoc_";
  protected final String TEXT_40 = ";" + NL + "\t}";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String methodTemp = ElementParameterParser.getValue(node,"__METHOD__");
String method = methodTemp.indexOf("(")!=-1?methodTemp.substring(0,methodTemp.indexOf("(")):methodTemp;

IConnection inputConn = null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inputConn = conn;
			break;
		}
	}
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns != null && conns.size() > 0) {
	for (int i = 0; i < conns.size(); i++) {
		IConnection conn = conns.get(i);
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
		}
	}
}

List<? extends IConnection> connsResponse = node.getOutgoingConnections("RESPONSE");
List<? extends IConnection> connsFault = node.getOutgoingConnections("FAULT");
IConnection connResponse = null;
IConnection connFault = null;
if (connsResponse.size() == 1) {
	connResponse = connsResponse.get(0);
}
if (connsFault.size() == 1) {
	connFault = connsFault.get(0);
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_11);
    				if (null != connFault) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_17);
    				} 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    				if (null != connFault) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connFault.getName());
    stringBuffer.append(TEXT_26);
    				} 
    stringBuffer.append(TEXT_27);
    		if (("true").equals(dieOnError)) { 
    stringBuffer.append(TEXT_28);
    		} else { 
    stringBuffer.append(TEXT_29);
    		} 
    stringBuffer.append(TEXT_30);
    	if (null != connResponse) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connResponse.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connResponse.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connResponse.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connResponse.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    	} 
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
