package org.talend.designer.codegen.translators.processing.fields_deprecated_;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TExtractEBCDICFieldsBeginJava
{
  protected static String nl;
  public static synchronized TExtractEBCDICFieldsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractEBCDICFieldsBeginJava result = new TExtractEBCDICFieldsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\tint nb_line_";
  protected final String TEXT_30 = "=0;" + NL + "\tjava.nio.ByteBuffer bbRecord_";
  protected final String TEXT_31 = " = null;" + NL + "\t";
  protected final String TEXT_32 = NL + "\tclass ExtractEBCDICFieldUtil_";
  protected final String TEXT_33 = "{";
  protected final String TEXT_34 = NL + "\t\t\tpublic void putValue_Oirginal_";
  protected final String TEXT_35 = "(final ";
  protected final String TEXT_36 = "Struct ";
  protected final String TEXT_37 = ",final ";
  protected final String TEXT_38 = "Struct ";
  protected final String TEXT_39 = "){";
  protected final String TEXT_40 = NL + "\t\t\t\t\t";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t\t\t\t\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = NL + "\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\t}";
  protected final String TEXT_52 = NL + "\t\t\tpublic void putValue_unOirginal_";
  protected final String TEXT_53 = "(final ";
  protected final String TEXT_54 = "Struct ";
  protected final String TEXT_55 = ",java.nio.ByteBuffer bbRecord_";
  protected final String TEXT_56 = ")throws java.lang.Exception{";
  protected final String TEXT_57 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_58 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_59 = NL + "\t\t\tbyte[] bb_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = " = new byte[";
  protected final String TEXT_62 = "];" + NL + "\t\t\tbbRecord_";
  protected final String TEXT_63 = ".get(bb_";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = new String(bb_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_78 = NL + "\t\t\t\t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_83 = NL + "\t\t\t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = ",";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t\t\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_93 = "_";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\t\t\t";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = "),0);";
  protected final String TEXT_103 = NL + "\t\t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = bb_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_109 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_110 = NL + "\t\t\t}";
  protected final String TEXT_111 = NL + "\t\t\t}";
  protected final String TEXT_112 = NL + "\t\t\tpublic void putValue_reject_";
  protected final String TEXT_113 = "(final ";
  protected final String TEXT_114 = "Struct ";
  protected final String TEXT_115 = ",final ";
  protected final String TEXT_116 = "Struct ";
  protected final String TEXT_117 = "){";
  protected final String TEXT_118 = NL + "    \t\t\t";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = ";";
  protected final String TEXT_123 = NL + "\t\t\t}";
  protected final String TEXT_124 = NL + "\t\t\t}";
  protected final String TEXT_125 = NL + "\t}" + NL + "\tExtractEBCDICFieldUtil_";
  protected final String TEXT_126 = " extractEBCDICFieldUtil_";
  protected final String TEXT_127 = "=new ExtractEBCDICFieldUtil_";
  protected final String TEXT_128 = "();";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid = node.getUniqueName();

String field = ElementParameterParser.getValue(node, "__FIELD__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
String encoding  = ElementParameterParser.getValue(node, "__ENCODING__");
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		inConn = conn;
    		break;
    	}
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}


    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
if(outConn!=null && inConn!=null){
	IMetadataTable outputMetadataTable = outConn.getMetadataTable();
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	if(outputMetadataTable.getListColumns().size()> schemaOptNum){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		int oirginalColumnsSize=0;
		for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
			if(outputCol.getLabel().equals(field)){
				continue;
			}
			boolean isOirginalColumn = false;
			for(IMetadataColumn inputCol : inputMetadataTable.getListColumns()){	
				JavaType stringType =  JavaTypesManager.getJavaTypeFromId(inputCol.getTalendType());
				if( outputCol.getLabel().equals( inputCol.getLabel()) ){
					if(oirginalColumnsSize%schemaOptNum==0){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(oirginalColumnsSize/schemaOptNum);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn) );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_39);
    
					}
					isOirginalColumn = true;
					if(stringType == JavaTypesManager.STRING){
						boolean trimStr = false;
						if(trimSelects!=null){
							for(Map<String, String> mapTrim : trimSelects){
								if(outputCol.getLabel().equals(mapTrim.get("SCHEMA_COLUMN")) && "true".equals(mapTrim.get("TRIM"))){
									trimStr = true;
									break;
								}
							}
						}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && (trimStr)))?".trim()":"" );
    stringBuffer.append(TEXT_44);
    
					}else{

    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_49);
    
					}
					if((oirginalColumnsSize+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_50);
    
					}
					oirginalColumnsSize++;
					break;
				}
			}
			if(!isOirginalColumn){
				if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
					&& (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
				}else{
					newColumnList.add(outputCol);
				}
			}
		}
			if(oirginalColumnsSize>0&&(oirginalColumnsSize%schemaOptNum)>0){

    stringBuffer.append(TEXT_51);
    
			}
		for(int valueN = 0 ; valueN < newColumnList.size();valueN++){//----- for begin
				IMetadataColumn column = newColumnList.get(valueN);
				Integer orgainLength = column.getOriginalLength();
				String orgainType = column.getType();
				Integer precision = column.getPrecision();
				if(precision==null) precision = 0;
				if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
				}
				if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    
				continue;
				}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    
				if(orgainType.equals("X")){
						boolean trimStr = false;
						if(trimSelects!=null){
							for(Map<String, String> mapTrim : trimSelects){
								if(column.getLabel().equals(mapTrim.get("SCHEMA_COLUMN")) && "true".equals(mapTrim.get("TRIM"))){
									trimStr = true;
									break;
								}
							}
						}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_71);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && (trimStr)))?".trim()":"" );
    stringBuffer.append(TEXT_72);
    
				}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    
				}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    
				}else if(orgainType.equals("3") || orgainType.equals("9")) {
					String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
					boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
					if(orgainType.equals("3")){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_89);
    
					}else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    
					}
				}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    
				}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    
				}else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    
				}
				if((valueN+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_110);
    
				}
		}//----- for end
				if(newColumnList.size()>0&&(newColumnList.size()%schemaOptNum)>0){

    stringBuffer.append(TEXT_111);
    
				}
		if(!dieOnError){
			if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
				int outputColumnSize=outConn.getMetadataTable().getListColumns().size();
	            for(int rejectColNo=0;rejectColNo<outputColumnSize;rejectColNo++) {
	            	IMetadataColumn column=outConn.getMetadataTable().getListColumns().get(rejectColNo);
					if(rejectColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(rejectColNo/schemaOptNum);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_117);
    
					}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_122);
    
					if((rejectColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_123);
    
					}
				}
				if(outputColumnSize>0&&(outputColumnSize%schemaOptNum)>0){

    stringBuffer.append(TEXT_124);
    
				}
			}
		}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
	}
}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
