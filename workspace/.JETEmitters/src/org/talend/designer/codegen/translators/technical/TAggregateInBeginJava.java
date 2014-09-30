package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TAggregateInBeginJava
{
  protected static String nl;
  public static synchronized TAggregateInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateInBeginJava result = new TAggregateInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tStringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_5 = ".append(\" and \");";
  protected final String TEXT_6 = NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_7 = ".append(\"'";
  protected final String TEXT_8 = "'\");";
  protected final String TEXT_9 = NL + NL + NL + "java.util.Collection<AggOperationStruct_";
  protected final String TEXT_10 = "> values_";
  protected final String TEXT_11 = " = hash_";
  protected final String TEXT_12 = ".values();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE\", values_";
  protected final String TEXT_14 = ".size());" + NL;
  protected final String TEXT_15 = NL + "\tlog.debug(\"";
  protected final String TEXT_16 = " - Grouping by the columns \" + log4jSb_";
  protected final String TEXT_17 = " + \".\");" + NL + "\tlog.info(\"";
  protected final String TEXT_18 = " - Retrieving the aggregation results.\");" + NL + "\tlog4jSb_";
  protected final String TEXT_19 = ".delete(0,log4jSb_";
  protected final String TEXT_20 = ".length());";
  protected final String TEXT_21 = NL + "for(AggOperationStruct_";
  protected final String TEXT_22 = " aggregated_row_";
  protected final String TEXT_23 = " : values_";
  protected final String TEXT_24 = ") { // G_AggR_600" + NL + NL;
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String origin = ElementParameterParser.getValue(node, "__ORIGIN__");
String cid = origin;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	List<IMetadataTable> mestadataTableListOut = node.getMetadataList();

	if (mestadataTableListOut!=null && mestadataTableListOut.size()>0) { // T_InMain_AggR_600
		IMetadataTable metadataTableOutput = mestadataTableListOut.get(0);
		if (metadataTableOutput!=null) { // T_InMain_AggR_601
			List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
			for(int g = 0; g < groupbys.size(); g++){ // T_InMain_AggR_605
				Map<String, String> groupby = groupbys.get(g);
				String inputColumn = groupby.get("INPUT_COLUMN");
				String outputGroupColumn = groupby.get("OUTPUT_COLUMN");
				if(g!=0) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_8);
    
				
			}
		}
	}
}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
