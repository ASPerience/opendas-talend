package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPaloOutputBeginJava
{
  protected static String nl;
  public static synchronized TPaloOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloOutputBeginJava result = new TPaloOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "int nb_commit_count_";
  protected final String TEXT_3 = " = 0;" + NL + "String server_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "String port_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "String username_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "        String password_";
  protected final String TEXT_18 = " = decryptedPassword_";
  protected final String TEXT_19 = ";" + NL + "String database_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "String cube_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "int nb_columns_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "-1;" + NL + "String strArrTalendQuery[] = new String[nb_columns_";
  protected final String TEXT_26 = "];" + NL + "" + NL + "org.talend.palo.paloIX plIX_";
  protected final String TEXT_27 = " = new org.talend.palo.paloIX();" + NL + "org.talend.palo.paloIXConnection plConn_";
  protected final String TEXT_28 = " = plIX_";
  protected final String TEXT_29 = ".initAndConnect(username_";
  protected final String TEXT_30 = ",password_";
  protected final String TEXT_31 = ",server_";
  protected final String TEXT_32 = ",port_";
  protected final String TEXT_33 = ");" + NL + "\t\t" + NL + "\t\t" + NL + "\t\torg.talend.palo.paloIXDatabase plDb_";
  protected final String TEXT_34 = " = plConn_";
  protected final String TEXT_35 = ".getDatabase(database_";
  protected final String TEXT_36 = ");" + NL + "\t\torg.talend.palo.paloIXDimensions plDims_";
  protected final String TEXT_37 = " = plDb_";
  protected final String TEXT_38 = ".getCubeDimensions(cube_";
  protected final String TEXT_39 = ");" + NL + NL;
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {

	List<IMetadataColumn> columns = metadata.getListColumns();
    	int sizeColumns = columns.size();

	String cid = node.getUniqueName();
   	String server = ElementParameterParser.getValue(node,"__SERVER__");
    	String port = ElementParameterParser.getValue(node, "__SERVERPORT__");
    	String username = ElementParameterParser.getValue(node, "__USERNAME__");

    	String database = ElementParameterParser.getValue(node, "__DATABASE__");
    	String cube = ElementParameterParser.getValue(node, "__CUBE__");
	String measureColumn = ElementParameterParser.getValue(node, "__MEASURE_COLUMN__");
	boolean isCreateElement = ("true").equals(ElementParameterParser.getValue(node,"__CREATEELEM__"));
	boolean isSaveCube = ("true").equals(ElementParameterParser.getValue(node,"__SAVECUBE__"));
	String commitsize = ElementParameterParser.getValue(node, "__COMMITSIZE__");

    	if(("").equals(commitsize)){
		commitsize="1000";
    	}


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( server);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( username);
    stringBuffer.append(TEXT_9);
    
		String passwordFieldName = "__USERPASSWORD__";
		
    stringBuffer.append(TEXT_10);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( database);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cube);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( sizeColumns);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
	
	}
}

    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
