package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloDatabaseBeginJava
{
  protected static String nl;
  public static synchronized TPaloDatabaseBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDatabaseBeginJava result = new TPaloDatabaseBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "org.talend.jpalo.palo p_";
  protected final String TEXT_3 = " = null;" + NL + "org.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_4 = " = null;" + NL;
  protected final String TEXT_5 = NL + "\t// Use Existing" + NL + "\tp_";
  protected final String TEXT_6 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_7 = "\");" + NL + "\tpConn_";
  protected final String TEXT_8 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "\t// Initialize jpalo" + NL + "\tp_";
  protected final String TEXT_11 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_12 = ");" + NL + "\t// Open the connection" + NL + "\t";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; ";
  protected final String TEXT_20 = NL + "\tpConn_";
  protected final String TEXT_21 = " = p_";
  protected final String TEXT_22 = ".connect(";
  protected final String TEXT_23 = ", decryptedPassword_";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "\torg.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_29 = " = pConn_";
  protected final String TEXT_30 = ".getDatabases();" + NL + "\tpDBs_";
  protected final String TEXT_31 = ".createDatabase(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\torg.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_34 = " = pConn_";
  protected final String TEXT_35 = ".getDatabases();" + NL + "\tif(null==pDBs_";
  protected final String TEXT_36 = ".getDatabase(";
  protected final String TEXT_37 = ")) pDBs_";
  protected final String TEXT_38 = ".createDatabase(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\torg.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_41 = " = pConn_";
  protected final String TEXT_42 = ".getDatabases();" + NL + "\tif(null!=pDBs_";
  protected final String TEXT_43 = ".getDatabase(";
  protected final String TEXT_44 = ")) pDBs_";
  protected final String TEXT_45 = ".deleteDatabase(";
  protected final String TEXT_46 = ");" + NL + "\tpDBs_";
  protected final String TEXT_47 = ".createDatabase(";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\torg.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_50 = " = pConn_";
  protected final String TEXT_51 = ".getDatabases();" + NL + "\torg.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_52 = " = pDBs_";
  protected final String TEXT_53 = ".getDatabase(";
  protected final String TEXT_54 = ");" + NL + "\tif(null != pDB_";
  protected final String TEXT_55 = ")" + NL + "\t    pDBs_";
  protected final String TEXT_56 = ".deleteDatabase(";
  protected final String TEXT_57 = ");\t" + NL + "\telse" + NL + "\t\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_58 = " + \"' not found. exiting...\");";
  protected final String TEXT_59 = NL + "\t\tif(pConn_";
  protected final String TEXT_60 = " != null){" + NL + "\t\t\tpConn_";
  protected final String TEXT_61 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_62 = NL + "globalMap.put(\"";
  protected final String TEXT_63 = "_DATABASENAME\",";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));


    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");


    String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    String sDatabaseAction = ElementParameterParser.getValue(node,"__DATABASE_ACTION__");
    

    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
if(useExistingConnection){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String p = "p_" + connection;
	String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_9);
    
}else{

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_12);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    
if(("CREATE").equals(sDatabaseAction)){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_32);
    
}else if(("CREATE_IF_NOT_EXISTS").equals(sDatabaseAction)){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_39);
    
}else if(("DELETE_IF_EXISTS_AND_CREATE").equals(sDatabaseAction)){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_48);
    
}else if(("DELETE").equals(sDatabaseAction)){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_58);
    	
}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
	}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
