package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Map;

public class TTeradataFastExportMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastExportMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastExportMainJava result = new TTeradataFastExportMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String tableFullName_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = " + \".\" + ";
  protected final String TEXT_4 = ";" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_5 = " = new java.io.FileWriter(";
  protected final String TEXT_6 = "+";
  protected final String TEXT_7 = "+\".script\");" + NL;
  protected final String TEXT_8 = NL + NL + "StringBuilder script_";
  protected final String TEXT_9 = " = new StringBuilder();" + NL + "fw_";
  protected final String TEXT_10 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_11 = "+\".\"+";
  protected final String TEXT_12 = "+\"_lt;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_13 = ".write(\".LOGON \"+";
  protected final String TEXT_14 = "+\",\"+";
  protected final String TEXT_15 = "+\";\\r\\n\");" + NL;
  protected final String TEXT_16 = NL + "fw_";
  protected final String TEXT_17 = ".write(\".BEGIN EXPORT SESSIONS 8;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_18 = ".write(\"SELECT \\r\\n\");";
  protected final String TEXT_19 = NL + "\t\tfw_";
  protected final String TEXT_20 = ".write(\"cast( ";
  protected final String TEXT_21 = " as CHAR(";
  protected final String TEXT_22 = ")),\\r\\n\");" + NL + "\t";
  protected final String TEXT_23 = NL + "\t\tfw_";
  protected final String TEXT_24 = ".write(\"cast( ";
  protected final String TEXT_25 = " as CHAR(";
  protected final String TEXT_26 = "))\\r\\n\");" + NL + "\t";
  protected final String TEXT_27 = NL + "fw_";
  protected final String TEXT_28 = ".write(\"FROM \"+ ";
  protected final String TEXT_29 = " + \".\" + ";
  protected final String TEXT_30 = "+\";\\r\\n\");" + NL;
  protected final String TEXT_31 = NL + "fw_";
  protected final String TEXT_32 = ".write(\".EXPORT OUTFILE \\\"\"+";
  protected final String TEXT_33 = "+\".data\\\" FORMAT TEXT mode record;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_34 = ".write(\".END EXPORT;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_35 = ".write(\".LOGOFF;\\r\\n\");" + NL;
  protected final String TEXT_36 = NL + "fw_";
  protected final String TEXT_37 = ".close();" + NL;
  protected final String TEXT_38 = NL + "String sb_";
  protected final String TEXT_39 = "= new String(\"";
  protected final String TEXT_40 = "fexp < \\\"\"+";
  protected final String TEXT_41 = "+";
  protected final String TEXT_42 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_43 = "+\"\\\" 2>&1\");" + NL + "final Process process_";
  protected final String TEXT_44 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_45 = "); " + NL + "Thread normal_";
  protected final String TEXT_46 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_47 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {" + NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_48 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_49 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_50 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_51 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_52 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_53 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_54 = ".interrupt();";
  protected final String TEXT_55 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String exportedFile= ElementParameterParser.getValue(node, "__EXPORTED_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(exportedFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	exportedFile = exportedFile.replaceAll("/", "\\\\\\\\");
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_7);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_15);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
if(columnList!=null){
	int counter = 1;
	for(IMetadataColumn column:columnList){	
		if( columnList.size() != counter){	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_22);
    
		} else {
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_26);
     } 
		counter++;
	}
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_30);
    //Export file----------------------------------------------------------
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(exportedFile);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    //run fexp command----------------------------------------------------
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append((("Windows").equals(execution))?"cmd /c ":"");
    stringBuffer.append(TEXT_40);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    return stringBuffer.toString();
  }
}
