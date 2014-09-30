package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSAPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPConnectionBeginJava result = new TSAPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    ";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_11 = " = null;" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\tclient_";
  protected final String TEXT_13 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_14 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_15 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_16 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_17 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_18 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_19 = " );      // system number" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t//Create a client connection to Message Server " + NL + "\t\tclient_";
  protected final String TEXT_21 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_22 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_23 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t decryptedPassword_";
  protected final String TEXT_24 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_25 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_26 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_27 = ",    // system ID,defined in sapmsg.ini" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_28 = " );  // group name    " + NL + "\t";
  protected final String TEXT_29 = NL + "\t// Open the connection" + NL + "\tclient_";
  protected final String TEXT_30 = ".connect();" + NL + "\t";
  protected final String TEXT_31 = NL + "\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\tclient_";
  protected final String TEXT_32 = ".setSapGui(2);" + NL + "\t";
  protected final String TEXT_33 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_34 = "\", client_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_37 = " = null; ";
  protected final String TEXT_38 = " " + NL + "                                dest_";
  protected final String TEXT_39 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_40 = "); ";
  protected final String TEXT_41 = " " + NL + "                        if (dest_";
  protected final String TEXT_42 = " == null) { " + NL + " ";
  protected final String TEXT_43 = " " + NL + "                        org.talend.sap.TalendDestinationData destinationData_";
  protected final String TEXT_44 = " = null; ";
  protected final String TEXT_45 = " " + NL + "                                destinationData_";
  protected final String TEXT_46 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_49 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_56 = "); ";
  protected final String TEXT_57 = "                       " + NL + "                                destinationData_";
  protected final String TEXT_58 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_61 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = NL + "                                                                                                                                                                        ";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = NL + "                                                                                                                                                        ";
  protected final String TEXT_70 = " ); ";
  protected final String TEXT_71 = " " + NL + "                    org.talend.sap.TalendDestinationDataProvider destinationDataProvider_";
  protected final String TEXT_72 = " = org.talend.sap.TalendDestinationDataProvider.getInstance(); " + NL + "                    destinationDataProvider_";
  protected final String TEXT_73 = ".addDestination(\"SAP_SERVER_";
  protected final String TEXT_74 = "\", destinationData_";
  protected final String TEXT_75 = "); ";
  protected final String TEXT_76 = " " + NL + "                    destinationDataProvider_";
  protected final String TEXT_77 = ".getDestinationProperties(\"SAP_SERVER_";
  protected final String TEXT_78 = "\").setProperty(com.sap.conn.jco.ext.DestinationDataProvider.JCO_USE_SAPGUI, \"2\"); " + NL + "                        com.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\"); ";
  protected final String TEXT_79 = " " + NL + "                    try { " + NL + "                        com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(destinationDataProvider_";
  protected final String TEXT_80 = "); " + NL + "                        } catch (java.lang.IllegalStateException ex) { " + NL + "                                //ignore if the provider already registered. " + NL + "                    } " + NL + "                    dest_";
  protected final String TEXT_81 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(\"SAP_SERVER_";
  protected final String TEXT_82 = "\");";
  protected final String TEXT_83 = " " + NL + "                        } ";
  protected final String TEXT_84 = " " + NL + "    // Begins the stateful call sequence for calls to the specified destination." + NL + "    com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_85 = ");" + NL + "\tdest_";
  protected final String TEXT_86 = ".ping();" + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_87 = "\", dest_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String client = ElementParameterParser.getValue(node, "__CLIENT__");
    String userid = ElementParameterParser.getValue(node, "__USERID__");
    String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
    String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
    String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
    
    String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
    String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
    String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
    boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
    
    String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_19);
    }else{
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    if(useFtpHttp){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    }else{
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
     
                boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__")); 
                if(specify_alias){ 
                        String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__"); 
                        if(null != alias && !("".equals(alias))){ 

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_40);
     
                        } 

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
     
                } 

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_56);
    }else{
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    if(useFtpHttp){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
     
                if(specify_alias){ 

    stringBuffer.append(TEXT_83);
     
                } 

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    return stringBuffer.toString();
  }
}
