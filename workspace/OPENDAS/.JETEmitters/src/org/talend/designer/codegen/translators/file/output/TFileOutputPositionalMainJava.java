package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputPositionalMainJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalMainJava result = new TFileOutputPositionalMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t\t\tString tempStringM";
  protected final String TEXT_2 = "= null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tint tempLengthM";
  protected final String TEXT_3 = "= 0;" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tStringBuilder sb_";
  protected final String TEXT_5 = " = new StringBuilder();";
  protected final String TEXT_6 = NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringM";
  protected final String TEXT_7 = "=";
  protected final String TEXT_8 = NL + "\t\t\t\t\tString.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "\t\t\t\t\t(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == null) ? " + NL + "\t\t\t\t\t\"\": ";
  protected final String TEXT_14 = "FormatterUtils.format_Date(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")).toString()";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_24 = "), ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "), ";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_33 = "String.valueOf(";
  protected final String TEXT_34 = ")\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = "String.valueOf(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = " ;" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "    \t\t\ttempLengthM";
  protected final String TEXT_40 = "=tempStringM";
  protected final String TEXT_41 = ".getBytes(";
  protected final String TEXT_42 = ").length;" + NL + "    \t\t\t";
  protected final String TEXT_43 = NL + "    \t\t\ttempLengthM";
  protected final String TEXT_44 = "=tempStringM";
  protected final String TEXT_45 = ".length();" + NL + "    \t\t\t";
  protected final String TEXT_46 = NL + "    \t\t\t" + NL + "            \tif (tempLengthM";
  protected final String TEXT_47 = " >=";
  protected final String TEXT_48 = ") {";
  protected final String TEXT_49 = NL + "                        sb_";
  protected final String TEXT_50 = ".append(tempStringM";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                        sb_";
  protected final String TEXT_53 = ".append(tempStringM";
  protected final String TEXT_54 = ".substring(tempLengthM";
  protected final String TEXT_55 = "-";
  protected final String TEXT_56 = "));";
  protected final String TEXT_57 = NL + "                        int begin";
  protected final String TEXT_58 = "=(tempLengthM";
  protected final String TEXT_59 = "-";
  protected final String TEXT_60 = ")/2;" + NL + "                        sb_";
  protected final String TEXT_61 = ".append(tempStringM";
  protected final String TEXT_62 = ".substring(begin";
  protected final String TEXT_63 = ", begin";
  protected final String TEXT_64 = "+";
  protected final String TEXT_65 = "));";
  protected final String TEXT_66 = NL + "                        sb_";
  protected final String TEXT_67 = ".append(tempStringM";
  protected final String TEXT_68 = ".substring(0, ";
  protected final String TEXT_69 = "));";
  protected final String TEXT_70 = NL + "                }else if(tempLengthM";
  protected final String TEXT_71 = "<";
  protected final String TEXT_72 = "){" + NL + "                   ";
  protected final String TEXT_73 = NL + "                        sb_";
  protected final String TEXT_74 = ".append(tempStringM";
  protected final String TEXT_75 = ");" + NL + "                        for(int i_";
  protected final String TEXT_76 = "=0; i_";
  protected final String TEXT_77 = "< ";
  protected final String TEXT_78 = "-tempLengthM";
  protected final String TEXT_79 = "; i_";
  protected final String TEXT_80 = "++){" + NL + "                            sb_";
  protected final String TEXT_81 = ".append(";
  protected final String TEXT_82 = ");" + NL + "                        }" + NL + "                        ";
  protected final String TEXT_83 = NL + "                        for(int i_";
  protected final String TEXT_84 = "=0; i_";
  protected final String TEXT_85 = "< ";
  protected final String TEXT_86 = "-tempLengthM";
  protected final String TEXT_87 = "; i_";
  protected final String TEXT_88 = "++){" + NL + "                            sb_";
  protected final String TEXT_89 = ".append(";
  protected final String TEXT_90 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_91 = ".append(tempStringM";
  protected final String TEXT_92 = ");" + NL + "                        ";
  protected final String TEXT_93 = NL + "                        int temp";
  protected final String TEXT_94 = "= (";
  protected final String TEXT_95 = "-tempLengthM";
  protected final String TEXT_96 = ")/2;" + NL + "                        for(int i_";
  protected final String TEXT_97 = "=0;i_";
  protected final String TEXT_98 = "<temp";
  protected final String TEXT_99 = ";i_";
  protected final String TEXT_100 = "++){" + NL + "                            sb_";
  protected final String TEXT_101 = ".append(";
  protected final String TEXT_102 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_103 = ".append(tempStringM";
  protected final String TEXT_104 = ");" + NL + "                        for(int i=temp";
  protected final String TEXT_105 = "+tempLengthM";
  protected final String TEXT_106 = ";i<";
  protected final String TEXT_107 = ";i++){" + NL + "                            sb_";
  protected final String TEXT_108 = ".append(";
  protected final String TEXT_109 = ");" + NL + "                        }" + NL + "" + NL + "                        ";
  protected final String TEXT_110 = "       " + NL + "                }" + NL + "                //get  and format output String end\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\tsb_";
  protected final String TEXT_112 = ".append(";
  protected final String TEXT_113 = ");" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\tout";
  protected final String TEXT_118 = ".write(sb_";
  protected final String TEXT_119 = ".toString());" + NL + "    \t\t";
  protected final String TEXT_120 = NL + "        \t\tif(nb_line_";
  protected final String TEXT_121 = "%";
  protected final String TEXT_122 = " == 0) {" + NL + "        \t\tout";
  protected final String TEXT_123 = ".flush();" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_124 = NL + "    \t\t";
  protected final String TEXT_125 = NL + "    \t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_128 = " \t\t\t\t\t\t" + NL + "\t\t\tnb_line_";
  protected final String TEXT_129 = "++;";
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        String cid = node.getUniqueName();
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );

        String encoding = ElementParameterParser.getValue(
            node,
            "__ENCODING__"
        );

        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );            
            
        boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
        
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__")); 
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        

		String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			List<IMetadataColumn> columns = metadata.getListColumns();
			int sizeColumns = columns.size();
			for (int i = 0; i < sizeColumns; i++) {
				IMetadataColumn column = columns.get(i);
				Map<String,String> format=formats.get(i);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    				
				if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable()) ) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    					
				} else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    
					if(javaType == JavaTypesManager.DATE && patternValue!=null){
					
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_17);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY){
					
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
					}else if(javaType == JavaTypesManager.STRING){
					
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_22);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_26);
     } else { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_31);
     } 
    stringBuffer.append(TEXT_32);
    
					}else if (javaType == JavaTypesManager.BIGDECIMAL) {
					
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_34);
     }else{
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    
					}
				}
    stringBuffer.append(TEXT_38);
    if(useByte){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_42);
    }else{
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_48);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
                    } else if (("\'R\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_56);
    
                    } else if (("\'M\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_65);
    
                    } else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_69);
    
                    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_72);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {
                    
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_82);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
                    } else {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_109);
    
                    } 
    stringBuffer.append(TEXT_110);
    
			}
			
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_113);
     
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_114);
    
				}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_115);
     
				}
				if (isParallelize) {
			
    stringBuffer.append(TEXT_116);
     
				}
			
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
    			}
    		
    stringBuffer.append(TEXT_124);
    
    			if ( isParallelize) {
			
    stringBuffer.append(TEXT_125);
    
    		    }
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_126);
     
				}
				if(codeGenArgument.getIsRunInMultiThread()){
    		
    stringBuffer.append(TEXT_127);
    
    			}
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
		}
	}
    }
}

    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
