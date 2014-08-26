package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;
import java.util.List;

public class TRESTBeginJava
{
  protected static String nl;
  public static synchronized TRESTBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTBeginJava result = new TRESTBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\tcom.sun.jersey.api.client.Client restClient_";
  protected final String TEXT_3 = " = com.sun.jersey.api.client.Client.create();" + NL + "\t\tcom.sun.jersey.api.client.WebResource restResource_";
  protected final String TEXT_4 = ";" + NL + "\t\tif(";
  protected final String TEXT_5 = "!=null && !";
  protected final String TEXT_6 = ".equals(\"\")){" + NL + "\t\t\trestResource_";
  protected final String TEXT_7 = " = restClient_";
  protected final String TEXT_8 = ".resource(";
  protected final String TEXT_9 = ");" + NL + "\t\t}else{" + NL + "\t\t\tthrow new IllegalArgumentException(\"url can't be empty!\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tcom.sun.jersey.api.client.ClientResponse errorResponse_";
  protected final String TEXT_10 = " = null;" + NL + "\t\tString restResponse_";
  protected final String TEXT_11 = " = \"\";" + NL + "\ttry{" + NL + "\t\trestResponse_";
  protected final String TEXT_12 = " = restResource_";
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = NL + "        .header(";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = "  ";
  protected final String TEXT_18 = NL + "\t\t.get(String.class);";
  protected final String TEXT_19 = NL + "\t\t.post(String.class,";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t.put(String.class,";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t.delete(String.class);";
  protected final String TEXT_24 = NL + "\t}catch (com.sun.jersey.api.client.UniformInterfaceException ue) {" + NL + "        errorResponse_";
  protected final String TEXT_25 = " = ue.getResponse();" + NL + "    }" + NL + "\t\t// for output";
  protected final String TEXT_26 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_27 = " = new ";
  protected final String TEXT_28 = "Struct();" + NL + "\t\t\t\tif(errorResponse_";
  protected final String TEXT_29 = "!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = ".ERROR_CODE = errorResponse_";
  protected final String TEXT_31 = ".getStatus();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = ".Body = restResponse_";
  protected final String TEXT_33 = ";" + NL + "\t\t\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String url = ElementParameterParser.getValue(node,"__URL__");
String method = ElementParameterParser.getValue(node,"__METHOD__");
List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
        
String body = ElementParameterParser.getValue(node,"__BODY__");
body = body.replaceAll("[\r\n]", " ");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        for (int i = 0; i < headers.size(); i++) {
            Map<String, String> line = headers.get(i);

    stringBuffer.append(TEXT_14);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_16);
    
        }

    stringBuffer.append(TEXT_17);
    
		if("GET".equals(method)){

    stringBuffer.append(TEXT_18);
    
		}else if("POST".equals(method)){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_20);
    		
		}else if("PUT".equals(method)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_22);
    
		}else if("DELETE".equals(method)){

    stringBuffer.append(TEXT_23);
    
		}	

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null) {//1
		if (conns.size()>0) {//2
			IConnection conn = conns.get(0); //the first connection
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    			
			}//3
		}//2
	}//1

    return stringBuffer.toString();
  }
}
