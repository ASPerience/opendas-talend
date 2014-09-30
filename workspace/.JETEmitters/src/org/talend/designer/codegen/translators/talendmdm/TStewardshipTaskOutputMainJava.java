package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TStewardshipTaskOutputMainJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputMainJava result = new TStewardshipTaskOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if(!taskFlag_";
  protected final String TEXT_2 = ".equals(";
  protected final String TEXT_3 = ")){";
  protected final String TEXT_4 = NL + "\tif(targetRecordExisted_";
  protected final String TEXT_5 = "){" + NL + "\t\trecord_";
  protected final String TEXT_6 = " = task_";
  protected final String TEXT_7 = ".addTargetRecord();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "    \t\t\trecord_";
  protected final String TEXT_9 = ".addSrcColumn(recordColumn_";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = ",recordColumn_";
  protected final String TEXT_12 = "_Value_";
  protected final String TEXT_13 = ",recordColumn_";
  protected final String TEXT_14 = "_Type_";
  protected final String TEXT_15 = ",recordColumn_";
  protected final String TEXT_16 = "_Key_";
  protected final String TEXT_17 = ");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\ttargetRecordExisted_";
  protected final String TEXT_19 = " = false;" + NL + "\t}" + NL + "\tif(tasks_";
  protected final String TEXT_20 = ".getTaskCount()>=";
  protected final String TEXT_21 = "){" + NL + "\t\tString content = tasks_";
  protected final String TEXT_22 = ".getTasksAndClear();" + NL + "\t\t//System.out.println(content);" + NL + "\t\tboolean loadResult_";
  protected final String TEXT_23 = " = taskLoadClient_";
  protected final String TEXT_24 = ".doLoad(content);" + NL + "\t\tif(!loadResult_";
  protected final String TEXT_25 = "){" + NL + "\t\t\tSystem.err.println(\"An error occured while uploading tasks.\");" + NL + "\t\t}" + NL + "\t}" + NL + "\tnb_line_";
  protected final String TEXT_26 = " ++;" + NL + "\ttask_";
  protected final String TEXT_27 = " = tasks_";
  protected final String TEXT_28 = ".addTask();" + NL + "\ttask_";
  protected final String TEXT_29 = ".setBasicInfo(";
  protected final String TEXT_30 = ",\"";
  protected final String TEXT_31 = "\",";
  protected final String TEXT_32 = ",";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ",";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\ttaskFlag_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";\t" + NL + "}";
  protected final String TEXT_39 = NL + "\t" + NL + "if(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = "){" + NL + "\ttargetRecordExisted_";
  protected final String TEXT_42 = " = true;";
  protected final String TEXT_43 = NL + "    \t\trecordColumn_";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = " = \"";
  protected final String TEXT_46 = "\";" + NL + "    \t\trecordColumn_";
  protected final String TEXT_47 = "_Value_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ";" + NL + "    \t\trecordColumn_";
  protected final String TEXT_50 = "_Type_";
  protected final String TEXT_51 = " = \"";
  protected final String TEXT_52 = "\";" + NL + "    \t\trecordColumn_";
  protected final String TEXT_53 = "_Key_";
  protected final String TEXT_54 = " = \"";
  protected final String TEXT_55 = "\";";
  protected final String TEXT_56 = NL + "}else{" + NL + "\trecord_";
  protected final String TEXT_57 = " = task_";
  protected final String TEXT_58 = ".addSourceRecord();";
  protected final String TEXT_59 = "\t" + NL + "\trecord_";
  protected final String TEXT_60 = ".setBasicInfo(";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\trecord_";
  protected final String TEXT_65 = ".setBasicInfo(";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = "\t";
  protected final String TEXT_68 = NL + "    if(";
  protected final String TEXT_69 = "!=null && !\"\".equals(";
  protected final String TEXT_70 = ")){" + NL + "    \trecord_";
  protected final String TEXT_71 = ".addExtraInfo(";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ",\"";
  protected final String TEXT_74 = "\");" + NL + "    }";
  protected final String TEXT_75 = NL + "    \t\trecord_";
  protected final String TEXT_76 = ".addSrcColumn(\"";
  protected final String TEXT_77 = "\",";
  protected final String TEXT_78 = ",\"";
  protected final String TEXT_79 = "\",\"";
  protected final String TEXT_80 = "\");";
  protected final String TEXT_81 = NL + "}";
  protected final String TEXT_82 = NL + NL;
  protected final String TEXT_83 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
	String loopingColumn = ElementParameterParser.getValue(node, "__LOOPING_COLUMN__");
	String maxTaskCount = ElementParameterParser.getValue(node, "__NB_TASKS_PER_COMMIT__");
	String taskName = ElementParameterParser.getValue(node, "__TASKNAME__");
	String type = ElementParameterParser.getValue(node, "__TASKTYPE__");
	String createdBy = ElementParameterParser.getValue(node, "__CREATED_BY__");
	String owner = ElementParameterParser.getValue(node, "__OWNER__");
	String starRanking = ElementParameterParser.getValue(node, "__STAR_RANKING__");
	String tags = ElementParameterParser.getValue(node, "__TAGS__");
	
	String recordType = ElementParameterParser.getValue(node, "__RECORD_TYPE__");
	
	String source = ElementParameterParser.getValue(node, "__SOURCE__");
	String score = ElementParameterParser.getValue(node, "__SCORE__");
	String weights = ElementParameterParser.getValue(node, "__WEIGHTS__");
	
	List<Map<String, String>> extraInfos = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTRA_INFO__");
	List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");
	
	final String RESOLUTION_TYPE = "1";

class DataUtil{
	Map<String,String> colTypeMap = new java.util.HashMap<String,String>();
	Map<String,JavaType> colTalendTypeMap = new java.util.HashMap<String,JavaType>();
    Map<String,Boolean> colKeyMap = new java.util.HashMap<String,Boolean>();
    Map<String,String> colPatternMap = new java.util.HashMap<String,String>();
	public DataUtil(IMetadataTable metadata){
		List<IMetadataColumn> columns = metadata.getListColumns();
        int sizeColumns = columns.size();
        for (int i = 0; i < sizeColumns; i++) {
        	IMetadataColumn column = columns.get(i);
        	JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        	String typeName;
        	if(javaType == JavaTypesManager.DATE){
        		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        		colPatternMap.put(column.getLabel(),patternValue);
        		typeName = "date";
        	}else if(javaType == JavaTypesManager.BIGDECIMAL){
        		typeName = "decimal";
        	}else{
        		typeName = JavaTypesManager.getShortNameFromJavaType(javaType).toLowerCase();
        	}
        	//JavaTypesManager.getShortNameFromJavaType(javaType)
        	colTypeMap.put(column.getLabel(),typeName);
        	colKeyMap.put(column.getLabel(),column.isKey());
        	colTalendTypeMap.put(column.getLabel(),javaType);
        }
	}
    public String getValueExpression(String connName,String columnName){
    	if(colTalendTypeMap.get(columnName) == JavaTypesManager.DATE){
    		return "("+connName+"."+columnName+"!=null)?FormatterUtils.format_Date("+connName+"."+columnName+","+colPatternMap.get(columnName)+"):null";
    	}else{
    		return "("+connName+"."+columnName+"!=null)?String.valueOf("+connName+"."+columnName+"):null";
    	}
	}
	public String getColType(String columnName){
		return colTypeMap.get(columnName);
	}
	public String isKey(String columnName){
		return colKeyMap.get(columnName)?"1":"0";
	}
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			DataUtil dataUtil = new DataUtil(metadata);

    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),loopingColumn));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		if(recordColumns.size()>0){
			for(Map<String, String> recordColumn:recordColumns){
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(maxTaskCount);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
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
    stringBuffer.append(taskName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(createdBy);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(starRanking);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tags);
    stringBuffer.append(TEXT_35);
    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),loopingColumn));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(recordType);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	if(recordColumns.size()>0){
		for(Map<String, String> recordColumn:recordColumns){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dataUtil.getColType(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataUtil.isKey(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_55);
    
		}
	}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),source));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),score));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),weights));
    stringBuffer.append(TEXT_63);
    }else{
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),source));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    
	if(extraInfos.size()>0){
		for(Map<String, String> extraInfo:extraInfos){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(extraInfo.get("INFO"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(extraInfo.get("SCOPE"));
    stringBuffer.append(TEXT_74);
    
		}
	}
	if(recordColumns.size()>0){
		for(Map<String, String> recordColumn:recordColumns){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dataUtil.getColType(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dataUtil.isKey(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_80);
    
		}
	}

    stringBuffer.append(TEXT_81);
    
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
