package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IProcess;

public class TFileOutputDelimitedEndJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedEndJava result = new TFileOutputDelimitedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Done.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_13 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tStringBuilder log4jParamters_";
  protected final String TEXT_15 = " = new StringBuilder();" + NL + "\t\t\t   \tlog4jParamters_";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" - Parameters:\");" + NL + "\t\t\t   \t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\tlog4jParamters_";
  protected final String TEXT_22 = ".append(\" | \");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t   \t\tlog.debug(log4jParamters_";
  protected final String TEXT_24 = ");" + NL + "\t   \t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_27 = ") + \".\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_28 = " - Content of the record \" + (nb_line_";
  protected final String TEXT_29 = ") + \": \" + log4jSb_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_31 = ".delete(0,log4jSb_";
  protected final String TEXT_32 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - Writing the record \" + nb_line_";
  protected final String TEXT_35 = " + \" to the file.\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_36 = " - Content of the record \" + nb_line_";
  protected final String TEXT_37 = " + \": \" + log4jSb_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_39 = ".delete(0,log4jSb_";
  protected final String TEXT_40 = ".length());";
  protected final String TEXT_41 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - Written records count: \" + nb_line_";
  protected final String TEXT_43 = " + \" .\");";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = NL + "\t   \t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\tif(out";
  protected final String TEXT_52 = "!=null) {" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_53 = ".flush();" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_54 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\tif(out";
  protected final String TEXT_56 = "!=null) {" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_57 = ".flush();" + NL + "\t\t\t\t\t\twriter_";
  protected final String TEXT_58 = ".flush();" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_59 = " = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_61 = "_NB_LINE\",nb_line_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_63 = "_FILE_NAME\",fileName_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_67 = "!=null) {" + NL + "\t\t\t\t    \tCsvWriter";
  protected final String TEXT_68 = ".close();" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\tif(out";
  protected final String TEXT_70 = "!=null) {" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_71 = ".flush();" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_72 = ".close();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_74 = "!=null) {" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_75 = ".close();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(out";
  protected final String TEXT_76 = "!=null) {" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_77 = ".flush();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(outWriter_";
  protected final String TEXT_78 = "!=null) {" + NL + "\t\t\t\t\t\t\toutWriter_";
  protected final String TEXT_79 = ".flush();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_81 = "!=null) {" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_82 = ".flush();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(bufferWriter_";
  protected final String TEXT_83 = "!=null) {" + NL + "\t\t\t\t\t\t\tbufferWriter_";
  protected final String TEXT_84 = ".flush();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(outWriter_";
  protected final String TEXT_85 = "!=null) {" + NL + "\t\t\t\t\t\t\toutWriter_";
  protected final String TEXT_86 = ".flush();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_87 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t    \tglobalMap.put(\"";
  protected final String TEXT_89 = "_NB_LINE\",nb_line_";
  protected final String TEXT_90 = ");" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\tif(isFileGenerated_";
  protected final String TEXT_97 = " && nb_line_";
  protected final String TEXT_98 = " == 0){" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\tfile_";
  protected final String TEXT_100 = ".delete();" + NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\tfile";
  protected final String TEXT_102 = ".delete();" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t}\t\t" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_105 = "\", true);" + NL + "\t";
  protected final String TEXT_106 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
		}
		
		public void logParameters(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			   	java.util.List<org.talend.core.model.process.EParameterFieldType> ignoreT = java.util.Arrays.asList(
			   		org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
			   		org.talend.core.model.process.EParameterFieldType.LABEL);
		   		for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
		   			if(ignoreT.contains(ep.getFieldType())){
		   				continue;
		   			}
		   			String name = ep.getName();
		   			String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
		   			if(value == null || "".equals(value.trim())) {
		   				value = "\"\"";
		   			} else if("\"\\n\"".equals(value) || "\"\\r\"".equals(value) || "\"\\r\\n\"".equals(value)) {
		   				value = value.replaceAll("\\\\","\\\\\\\\");
		   			} else if("\"\"\"".equals(value)){
		   				value = "\"" + "\\" +  "\"" + "\"";
		   			} else if("\"\"\\r\\n\"\"".equals(value)){
		   				value = "\"\\\\r\\\\n\"";
		   			} else if("\"\"\\r\"\"".equals(value)){
		   				value = "\"\\\\r\"";
		   			} else if("\"\"\\n\"\"".equals(value)){
		   				value = "\"\\\\n\"";
		   			}
		   			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		   		}
		   		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	   		}
		}

		//for all tFileinput* components
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
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
    		
			}
		}
		
		//for all tFileOutput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
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
    		
			}
		}
		
		//for all tFileOutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_44);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
    boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    
    String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__")); 
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
	
	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	
	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
	boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	
	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
	IProcess process = node.getProcess();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_45);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
	
    stringBuffer.append(TEXT_46);
     
	    if(codeGenArgument.getIsRunInMultiThread()){
		
    stringBuffer.append(TEXT_47);
    
		}
		if (codeGenArgument.subTreeContainsParallelIterate()) {
		
    stringBuffer.append(TEXT_48);
     
		}
		if (isParallelize) {
		
    stringBuffer.append(TEXT_49);
     
		}
		
    stringBuffer.append(TEXT_50);
    
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(!useStream){
				
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
				}else{
				
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
				}
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}else{//the following is the tFileOutputCSV component
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
    stringBuffer.append(TEXT_65);
    
				if(!useStream){
				
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
					if(isInRowMode){
					
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
					}
				}else{
					if(isInRowMode){
					
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
					}else{
					
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
					}
				}
				
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
			}
			
    stringBuffer.append(TEXT_91);
     
		if (isParallelize) {
		
    stringBuffer.append(TEXT_92);
    
		}
		if (codeGenArgument.subTreeContainsParallelIterate()) {
		
    stringBuffer.append(TEXT_93);
     
		}
		if(codeGenArgument.getIsRunInMultiThread()){
		
    stringBuffer.append(TEXT_94);
    
		}
		
    stringBuffer.append(TEXT_95);
    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    }else{
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
	}
}

    
log4jFileUtil.writeDataFinishInfo(node);
log4jFileUtil.componentFinishInfo(node);

    stringBuffer.append(TEXT_106);
    return stringBuffer.toString();
  }
}
