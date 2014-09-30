package org.talend.designer.codegen.translators.databases.exist;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TEXistXQueryBeginJava
{
  protected static String nl;
  public static synchronized TEXistXQueryBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXistXQueryBeginJava result = new TEXistXQueryBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\torg.xmldb.api.base.Collection col_";
  protected final String TEXT_3 = " = (org.xmldb.api.base.Collection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "\t\tClass cl_";
  protected final String TEXT_6 = " = Class.forName(";
  protected final String TEXT_7 = ");" + NL + "\t    org.xmldb.api.base.Database database_";
  protected final String TEXT_8 = " = (org.xmldb.api.base.Database) cl_";
  protected final String TEXT_9 = ".newInstance();" + NL + "\t    database_";
  protected final String TEXT_10 = ".setProperty(\"create-database\", \"true\");" + NL + "\t    org.xmldb.api.DatabaseManager.registerDatabase(database_";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "\t    org.xmldb.api.base.Collection col_";
  protected final String TEXT_20 = " = org.xmldb.api.DatabaseManager.getCollection(";
  protected final String TEXT_21 = " + ";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ",decryptedPassword_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "    java.io.BufferedReader f_";
  protected final String TEXT_26 = " = new java.io.BufferedReader(new java.io.FileReader(";
  protected final String TEXT_27 = "));" + NL + "    String line_";
  protected final String TEXT_28 = ";" + NL + "    StringBuffer xml_";
  protected final String TEXT_29 = " = new StringBuffer();" + NL + "    while ((line_";
  protected final String TEXT_30 = " = f_";
  protected final String TEXT_31 = ".readLine()) != null)" + NL + "        xml_";
  protected final String TEXT_32 = ".append(line_";
  protected final String TEXT_33 = ");" + NL + "    f_";
  protected final String TEXT_34 = ".close();" + NL + "    String query_";
  protected final String TEXT_35 = " = xml_";
  protected final String TEXT_36 = ".toString();" + NL + "    org.exist.xmldb.XQueryService service_";
  protected final String TEXT_37 = " = (org.exist.xmldb.XQueryService) col_";
  protected final String TEXT_38 = ".getService(\"XQueryService\", \"1.0\");" + NL + "    service_";
  protected final String TEXT_39 = ".setProperty(javax.xml.transform.OutputKeys.INDENT, \"yes\");" + NL + "    service_";
  protected final String TEXT_40 = ".setProperty(javax.xml.transform.OutputKeys.ENCODING, \"UTF-8\");" + NL + "    org.xmldb.api.base.CompiledExpression compiled_";
  protected final String TEXT_41 = " = service_";
  protected final String TEXT_42 = ".compile(query_";
  protected final String TEXT_43 = ");" + NL + "    org.xmldb.api.base.ResourceSet result_";
  protected final String TEXT_44 = " = service_";
  protected final String TEXT_45 = ".execute(compiled_";
  protected final String TEXT_46 = ");" + NL + "    java.util.Properties outputProperties_";
  protected final String TEXT_47 = " = new java.util.Properties();" + NL + "    outputProperties_";
  protected final String TEXT_48 = ".setProperty(javax.xml.transform.OutputKeys.INDENT, \"yes\");" + NL + "    org.exist.util.serializer.SAXSerializer serializer_";
  protected final String TEXT_49 = " = (org.exist.util.serializer.SAXSerializer) org.exist.util.serializer.SerializerPool.getInstance().borrowObject(org.exist.util.serializer.SAXSerializer.class);" + NL + "    org.exist.util.serializer.SAXSerializer consoleSerializer_";
  protected final String TEXT_50 = " = (org.exist.util.serializer.SAXSerializer) org.exist.util.serializer.SerializerPool.getInstance().borrowObject(org.exist.util.serializer.SAXSerializer.class);" + NL + "    java.io.OutputStreamWriter writer_";
  protected final String TEXT_51 = " = new java.io.OutputStreamWriter(new java.io.FileOutputStream(new java.io.File(";
  protected final String TEXT_52 = ")));" + NL + "    java.io.OutputStreamWriter consoleWriter_";
  protected final String TEXT_53 = " = new java.io.OutputStreamWriter(System.out);" + NL + "    serializer_";
  protected final String TEXT_54 = ".setOutput(writer_";
  protected final String TEXT_55 = ", outputProperties_";
  protected final String TEXT_56 = ");" + NL + "    consoleSerializer_";
  protected final String TEXT_57 = ".setOutput(consoleWriter_";
  protected final String TEXT_58 = ", outputProperties_";
  protected final String TEXT_59 = ");" + NL + "    for (int i_";
  protected final String TEXT_60 = " = 0; i_";
  protected final String TEXT_61 = " < (int) result_";
  protected final String TEXT_62 = ".getSize(); i_";
  protected final String TEXT_63 = "++) {" + NL + "        org.xmldb.api.modules.XMLResource resource_";
  protected final String TEXT_64 = " = (org.xmldb.api.modules.XMLResource) result_";
  protected final String TEXT_65 = ".getResource((long) i_";
  protected final String TEXT_66 = ");" + NL + "        resource_";
  protected final String TEXT_67 = ".getContentAsSAX(serializer_";
  protected final String TEXT_68 = ");" + NL + "        resource_";
  protected final String TEXT_69 = ".getContentAsSAX(consoleSerializer_";
  protected final String TEXT_70 = ");" + NL + "    }" + NL + "    org.exist.util.serializer.SerializerPool.getInstance().returnObject(serializer_";
  protected final String TEXT_71 = ");" + NL + "    org.exist.util.serializer.SerializerPool.getInstance().returnObject(consoleSerializer_";
  protected final String TEXT_72 = ");" + NL + "    writer_";
  protected final String TEXT_73 = ".flush();" + NL + "    consoleWriter_";
  protected final String TEXT_74 = ".flush();";
  protected final String TEXT_75 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String uri = ElementParameterParser.getValue(node, "__URI__");
	String driver = ElementParameterParser.getValue(node, "__DRIVER__");
	String collection = ElementParameterParser.getValue(node, "__COLLECTION__");
	String user = ElementParameterParser.getValue(node, "__USERNAME__");
	String localOutput = ElementParameterParser.getValue(node, "__LOCALOUTPUT__");
	String xqueryFile = ElementParameterParser.getValue(node, "__XQUERY__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)){
		String col= "col_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(col);
    stringBuffer.append(TEXT_4);
    
	}else{

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driver);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(xqueryFile);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(localOutput);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    return stringBuffer.toString();
  }
}
