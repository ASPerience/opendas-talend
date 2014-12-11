package org.talend.designer.codegen.translators.file.output_deprecated_;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputEBCDICMainJava
{
  protected static String nl;
  public static synchronized TFileOutputEBCDICMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputEBCDICMainJava result = new TFileOutputEBCDICMainJava();
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
  protected final String TEXT_29 = "\t" + NL + "\t\t\tjava.util.List record_";
  protected final String TEXT_30 = " = new java.util.ArrayList();";
  protected final String TEXT_31 = NL + "\t\t\t\trecord_";
  protected final String TEXT_32 = ".add(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ") ;";
  protected final String TEXT_35 = NL + "        \trwriter_";
  protected final String TEXT_36 = ".writeRecord(record_";
  protected final String TEXT_37 = ");\t" + NL + "        \tnb_line_";
  protected final String TEXT_38 = "++;" + NL + "\t\t";
  protected final String TEXT_39 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_40 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = " = new byte[";
  protected final String TEXT_44 = "];";
  protected final String TEXT_45 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_46 = " < ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ".length()) {" + NL + "                 \t\t   \t\tthrow new java.lang.Exception(\"Value length must be less than the length in schema.\");" + NL + "                \t\t\t}" + NL + "\t\t\t\t\t\t\twhile(";
  protected final String TEXT_49 = " > ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ".length()){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " + \" \";\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tbb_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ".getBytes(";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_61 = ".write(bb_";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t\t\tjava.math.BigDecimal ";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ";" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " = cobolConversion.EBCDICType3.writeType3Value(";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ",";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_76 = ".write(bb_";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t\t\tjava.math.BigDecimal ";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ";" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = " = cobolConversion.EBCDICType9.writeType9Value(";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = ",";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ");" + NL + "\t\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_93 = ".write(bb_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t\tjava.math.BigInteger ";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ".toBigInteger() ;" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = ".compareTo(new java.math.BigInteger(\"0\")) < 0 ){" + NL + "\t\t\t\t\t\t\t\tfor(int i=0;i< ";
  protected final String TEXT_103 = ";i++){" + NL + "\t\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = "[i] = (byte)0xFF;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tbyte[] bArr_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = ".toByteArray();" + NL + "\t\t\t\t\t\t\tfor(int j=0;j<bArr_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ".length;j++){" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = "[bb_";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ".length-(j+1)] = bArr_";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = "[bArr_";
  protected final String TEXT_118 = "_";
  protected final String TEXT_119 = ".length - (j+1)];" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_120 = ".write(bb_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\tbyte[] bArr_";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ";" + NL + "\t\t\t\t\t\t\tfor(int j=0;j<bArr_";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = ".length;j++){" + NL + "\t\t\t\t\t\t\t\tbb_";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = "[j] = bArr_";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = "[j];" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_134 = ".write(bb_";
  protected final String TEXT_135 = "_";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_138 = " should be X, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\tfOut_";
  protected final String TEXT_140 = ".flush();" + NL;
  protected final String TEXT_141 = NL + "       \t\t\t\tnb_line_";
  protected final String TEXT_142 = "++;\t";
  protected final String TEXT_143 = NL + "\t";

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
    String incomingName = (String)codeGenArgument.getIncomingName();
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
if(!customSetOriginalLength){//------11111
		List< ? extends IConnection> conns = node.getIncomingConnections();
    	List<IMetadataTable> preMetadatas = null;
		
		for (int i=0;i<conns.size();i++) {
			IConnection conn = conns.get(i);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    			
				if( conn.getName() == incomingName ) {				
					preMetadatas = conn.getSource().getMetadataList();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
			for (IMetadataColumn column: preMetadatas.get(0).getListColumns()) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    
			}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
				}
			}
		}
}else{//------1111
	List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//------2222
		List< ? extends IConnection> conns = node.getIncomingConnections();
       	for (IConnection conn : conns) {//------3333
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//------4444
    			if( conn.getName() == incomingName ) {	//------5555
	    			IMetadataTable metadata = metadatas.get(0);
	    			List<IMetadataColumn> columns = metadata.getListColumns();
	    			List<IMetadataColumn> extColumns = new java.util.ArrayList<IMetadataColumn>();
	    			for (IMetadataColumn tempColumn : columns) {
	    				extColumns.add(tempColumn);
	    			}
	    			List<IMetadataColumn> inColumns = conn.getMetadataTable().getListColumns();
	    			for (IMetadataColumn inColumn: inColumns) {//------6666
						IMetadataColumn column = null;
						for (int j = 0; j < extColumns.size(); j++) {// search the corresponding metadata column for the input column
							if(inColumn.getLabel().equals(extColumns.get(j).getLabel()) ) {
								column = extColumns.remove(j);
								break;
							}
						}
						// if not find, then the first one of the metadata columns is used to correspond the input column
						if (column==null && !extColumns.isEmpty()) { 
							column = extColumns.remove(0);
						}
						if (column != null ) { //------77777
							Integer orgainLength = column.getOriginalLength();
							Integer length = column.getLength();
							String orgainType = column.getType();
							Integer precision = column.getPrecision();
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    
								continue;
	 						}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_44);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(length );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(length);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								String isSignedStr = column.getAdditionalField().get("Signed");
								boolean isSigned = (isSignedStr!=null&&!("").equals(isSignedStr))?("true").equals(isSignedStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(orgainLength);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(isSigned );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
								}else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(length );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(isSigned );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
								}
							}else if(orgainType.equals("B")) {
								String isSignedStr = column.getAdditionalField().get("Signed");

    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(orgainLength);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
							}else {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_138);
    
							}

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
						} //-----77777
					}//------66666

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
				}//------5555
			}//------4444
		}//------3333
	}//------2222
}//------1111

    stringBuffer.append(TEXT_143);
    log4jFileUtil.debugWriteData(node);
    return stringBuffer.toString();
  }
}
