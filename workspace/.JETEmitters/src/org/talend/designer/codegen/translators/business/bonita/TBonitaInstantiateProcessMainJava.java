package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TBonitaInstantiateProcessMainJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessMainJava result = new TBonitaInstantiateProcessMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_3 = ".append(\"&variables=<map>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_5 = ".append(\"<entry><string>";
  protected final String TEXT_6 = "</string>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\t\t\t\tjava.io.StringWriter sw_";
  protected final String TEXT_11 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\t\t\t\t\t\tnew com.thoughtworks.xstream.XStream().marshal(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ", new com.thoughtworks.xstream.io.xml.CompactWriter(sw_";
  protected final String TEXT_14 = "));" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_15 = ".append(sw_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_18 = ".append(\"<string><![CDATA[\");" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_19 = ".append(java.net.URLEncoder.encode(java.net.URLEncoder.encode(String.valueOf(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = "), utf8Charset),utf8Charset));" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_22 = ".append(\"]]></string>\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_25 = ".append(\"<string></string>\");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_27 = ".append(\"</entry>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_29 = ".append(\"</map>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_31 = ".put(\"";
  protected final String TEXT_32 = "\", ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_35 = "    " + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tjava.io.DataOutputStream output_";
  protected final String TEXT_37 = " = new java.io.DataOutputStream(httpConn_";
  protected final String TEXT_38 = ".getOutputStream());" + NL + "\t\t\toutput_";
  protected final String TEXT_39 = ".writeBytes(parameters_";
  protected final String TEXT_40 = ".toString());" + NL + "\t\t\toutput_";
  protected final String TEXT_41 = ".flush();" + NL + "\t\t\tif (output_";
  protected final String TEXT_42 = " != null) {" + NL + "\t\t\t\toutput_";
  protected final String TEXT_43 = ".close();" + NL + "\t\t\t\toutput_";
  protected final String TEXT_44 = " = null;" + NL + "\t\t\t}" + NL + "\t\t    int responseCode_";
  protected final String TEXT_45 = " = httpConn_";
  protected final String TEXT_46 = ".getResponseCode();" + NL + "\t\t    " + NL + "\t\t    if(responseCode_";
  protected final String TEXT_47 = " != java.net.HttpURLConnection.HTTP_OK){" + NL + "\t\t    \tSystem.out.println(\"----------\\nRequest failled: \" + responseCode_";
  protected final String TEXT_48 = "+ \"----------\");" + NL + "\t\t      \tthrow new java.lang.Exception(\"Request the url:\" + url_";
  protected final String TEXT_49 = " + \" failed: \" + responseCode_";
  protected final String TEXT_50 = ");" + NL + "\t\t    } else {" + NL + "\t\t      \tjava.io.InputStream is_";
  protected final String TEXT_51 = " = httpConn_";
  protected final String TEXT_52 = ".getInputStream();" + NL + "\t\t      \tjavax.xml.xpath.XPath xPath_";
  protected final String TEXT_53 = " = javax.xml.xpath.XPathFactory.newInstance().newXPath();" + NL + "\t\t      \torg.xml.sax.InputSource inputSource_";
  protected final String TEXT_54 = " = new org.xml.sax.InputSource(is_";
  protected final String TEXT_55 = ");" + NL + "\t\t      \tprocessInstanceUUID_";
  protected final String TEXT_56 = " = (String) xPath_";
  protected final String TEXT_57 = ".evaluate(\"/ProcessInstanceUUID/value/text()\", inputSource_";
  protected final String TEXT_58 = ", javax.xml.xpath.XPathConstants.STRING);" + NL + "\t\t      \tif (is_";
  protected final String TEXT_59 = " != null) {" + NL + "\t\t      \t\tis_";
  protected final String TEXT_60 = ".close();" + NL + "\t\t      \t\tis_";
  protected final String TEXT_61 = " = null;" + NL + "\t\t      \t}" + NL + "\t\t    }" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\torg.ow2.bonita.facade.uuid.ProcessInstanceUUID instanceUUID_";
  protected final String TEXT_63 = " = runtimeAPI_";
  protected final String TEXT_64 = ".instantiateProcess(processID_";
  protected final String TEXT_65 = ", parameters_";
  protected final String TEXT_66 = ");" + NL + "\t\t\tprocessInstanceUUID_";
  protected final String TEXT_67 = " = instanceUUID_";
  protected final String TEXT_68 = ".getValue();" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t} catch (java.lang.Exception lee_";
  protected final String TEXT_70 = ") {" + NL + "\t\t";
  protected final String TEXT_71 = NL + "\t\t\tthrow lee_";
  protected final String TEXT_72 = ";\t" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\t\tSystem.err.println(lee_";
  protected final String TEXT_74 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t}" + NL + "\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = processInstanceUUID_";
  protected final String TEXT_79 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t " + NL + "\tSystem.out.println(\"**** Instance \"+ processInstanceUUID_";
  protected final String TEXT_81 = " + \" created ****\");" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_82 = "_ProcessInstanceUUID\", processInstanceUUID_";
  protected final String TEXT_83 = "); ";
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns != null && conns.size() > 0 && conns.get(0) != null) {
    	IConnection conn = conns.get(0);
    	if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
	    	INode previousNode = conn.getSource();
	    	if(previousNode != null) {
				List<IMetadataTable> metadatas = previousNode.getMetadataList();
				if ((metadatas!=null)&&(metadatas.size()>0)) {
					IMetadataTable metadata = metadatas.get(0);
					if (metadata!=null) {
						List<IMetadataColumn> columns = metadata.getListColumns();
						int sizeColumns = columns.size();
						for (int i = 0; i < sizeColumns; i++) {
							if ("HTTP_CLIENT".equals(clientMode)) {
								if (i==0) {
								
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
								}
								
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_6);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_9);
    }
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(columns.get(i).getTalendType());
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
									}else{
									
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
									}
									
    stringBuffer.append(TEXT_23);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
								if (i==sizeColumns-1) {
								
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
								}
							} else {
							
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_34);
    
							}
						}
					}
				}
	    	}
	    }
    }
	
    stringBuffer.append(TEXT_35);
    
		if ("HTTP_CLIENT".equals(clientMode)) {
		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
		} else { // Java Client
		
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		}
		
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
		} else {
		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    	
		}
		
    stringBuffer.append(TEXT_75);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns_out = node.getOutgoingConnections();
			for (IConnection conn : conns_out) {
				String connName = conn.getName();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int sizeColumns = columns.size();
					for (int i = 0; i < sizeColumns; i++) {
						if ("ProcessInstanceUUID".equals(columns.get(i).getLabel()) ) {
						
    stringBuffer.append(TEXT_76);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
							break;
						}
					}
				}
			}
		}
	}
	
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
