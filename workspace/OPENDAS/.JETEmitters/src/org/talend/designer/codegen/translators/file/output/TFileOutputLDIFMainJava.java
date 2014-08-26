package org.talend.designer.codegen.translators.file.output;

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

public class TFileOutputLDIFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFMainJava result = new TFileOutputLDIFMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t//////////////////////////";
  protected final String TEXT_2 = " " + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\t\tboolean needSeparator_";
  protected final String TEXT_4 = " = false;" + NL + "\t\tboolean canOutput_";
  protected final String TEXT_5 = " = false;\t\t\t\t   \t\t";
  protected final String TEXT_6 = NL + "\t\tString value_";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = " = \"\";";
  protected final String TEXT_9 = "   \t\t\t\t" + NL + "\t    if(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " != null && !(\"\").equals(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ")) {";
  protected final String TEXT_14 = NL + "    \tvalue_";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = " =  \t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\tFormatterUtils.format_Date(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "\t\tString.valueOf(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\tString.valueOf(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = "\t\t" + NL + "\t\tutil_";
  protected final String TEXT_30 = ".breakString(sb_";
  protected final String TEXT_31 = ", dn_";
  protected final String TEXT_32 = " + value_";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = ", wrap_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = "\t\t" + NL + "        util_";
  protected final String TEXT_37 = ".breakString(sb_";
  protected final String TEXT_38 = ", changetype_";
  protected final String TEXT_39 = " + \"";
  protected final String TEXT_40 = "\", wrap_";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "\tcanOutput_";
  protected final String TEXT_44 = " = true;        ";
  protected final String TEXT_45 = " " + NL;
  protected final String TEXT_46 = NL + "\t    }";
  protected final String TEXT_47 = "   ";
  protected final String TEXT_48 = "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t    }";
  protected final String TEXT_50 = " \t\t" + NL + "\t";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + "\tif(needSeparator_";
  protected final String TEXT_53 = "){" + NL + "\t\tsb_";
  protected final String TEXT_54 = ".append(\"-\\n\");" + NL + "\t}  " + NL + "\tutil_";
  protected final String TEXT_55 = ".breakString(sb_";
  protected final String TEXT_56 = ", \"";
  protected final String TEXT_57 = ": \" + \"";
  protected final String TEXT_58 = "\", wrap_";
  protected final String TEXT_59 = ");" + NL + "\t";
  protected final String TEXT_60 = "\t\t" + NL + "\t\tString[] values_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = " = value_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ".split(";
  protected final String TEXT_65 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_66 = " : values_";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = "){" + NL + "\t\t\tutil_";
  protected final String TEXT_69 = ".breakString(sb_";
  protected final String TEXT_70 = ", \"";
  protected final String TEXT_71 = ": \" + item_";
  protected final String TEXT_72 = ", wrap_";
  protected final String TEXT_73 = ");" + NL + "\t\t}\t\t\t\t" + NL + "\t";
  protected final String TEXT_74 = NL + "\t\tutil_";
  protected final String TEXT_75 = ".breakString(sb_";
  protected final String TEXT_76 = ", \"";
  protected final String TEXT_77 = ": \" + value_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = ", wrap_";
  protected final String TEXT_80 = "); " + NL + "\t";
  protected final String TEXT_81 = NL + "\tneedSeparator_";
  protected final String TEXT_82 = " = true;" + NL + "\tcanOutput_";
  protected final String TEXT_83 = " = true;   \t";
  protected final String TEXT_84 = NL + "sb_";
  protected final String TEXT_85 = ".append(\"-\\n\");";
  protected final String TEXT_86 = NL + "\t";
  protected final String TEXT_87 = NL + "\t\tString[] values_";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = " = value_";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = ".split(";
  protected final String TEXT_92 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_93 = " : values_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = "){" + NL + "\t\t\tutil_";
  protected final String TEXT_96 = ".breakString(sb_";
  protected final String TEXT_97 = ", \"";
  protected final String TEXT_98 = ": \" + item_";
  protected final String TEXT_99 = ", wrap_";
  protected final String TEXT_100 = ");" + NL + "\t\t}\t\t\t\t" + NL + "\t";
  protected final String TEXT_101 = NL + "\t\tutil_";
  protected final String TEXT_102 = ".breakString(sb_";
  protected final String TEXT_103 = ", \"";
  protected final String TEXT_104 = ": \" + value_";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = ", wrap_";
  protected final String TEXT_107 = ");" + NL + "\t";
  protected final String TEXT_108 = NL + "\tcanOutput_";
  protected final String TEXT_109 = " = true;";
  protected final String TEXT_110 = NL + "\t\tutil_";
  protected final String TEXT_111 = ".breakString(sb_";
  protected final String TEXT_112 = ", \"";
  protected final String TEXT_113 = ": \" + value_";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ", wrap_";
  protected final String TEXT_116 = ");" + NL + "\t\tcanOutput_";
  protected final String TEXT_117 = " = true;";
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = NL + "\t    }";
  protected final String TEXT_120 = "   \t\t\t\t";
  protected final String TEXT_121 = "\t\t\t\t\t\t" + NL + "\t\tsb_";
  protected final String TEXT_122 = ".append('\\n');\t\t" + NL + "\t\t" + NL + "\tif(canOutput_";
  protected final String TEXT_123 = "){\t\t" + NL + "\t\tpw_";
  protected final String TEXT_124 = ".write(sb_";
  protected final String TEXT_125 = ".toString());" + NL + "\t\t";
  protected final String TEXT_126 = NL + "            if(nb_line_";
  protected final String TEXT_127 = "%";
  protected final String TEXT_128 = " == 0) {\t\t" + NL + "    \t\tpw_";
  protected final String TEXT_129 = ".flush();" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_130 = " \t\t" + NL + "\t\t" + NL + "    \tnb_line_";
  protected final String TEXT_131 = "++;" + NL + "    }\t";
  protected final String TEXT_132 = "    \t" + NL + "    \t//////////////////////////";
  protected final String TEXT_133 = NL;

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
        String changetype = ElementParameterParser.getValue(node, "__CHANGETYPE__");
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));		
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        
        List<Map<String, String>> multiValueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MULTIVALUECOLUMNS__");
        List<Map<String, String>> modifyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIFYCONFIG__");

    stringBuffer.append(TEXT_1);
    
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    		

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    		
    			boolean generateOneAlready = false; //only for Modify append the char '-'
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			boolean firstLoop = true;
    			for (int i = 0; i < sizeColumns; i++) {    				
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());					

    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    					
					if(!isPrimitive) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    
} 

    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_20);
    				
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_25);
    
					} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    				
}					

     
	if(i==0) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    if(!"none".equals(changetype)){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(changetype );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    if("delete".equals(changetype)){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_46);
    					
	} 

    stringBuffer.append(TEXT_47);
    
	continue;
 } 

    stringBuffer.append(TEXT_48);
     if ("delete".equals(changetype)) {
	if(firstLoop){
	
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_49);
    					
	} 

    stringBuffer.append(TEXT_50);
    	
	}
	firstLoop = false; 
	break; 
} 
     if ("modify".equals(changetype)) {
		String operation = null;
		boolean isMultiValue = false;   
		String separator = null;
		for(Map<String, String> line:modifyColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");				
				if(column.getLabel().equals(columnName)){
					operation = line.get("OPERATION");					
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");										
					break;
				}
		}	

    stringBuffer.append(TEXT_51);
    if(!"none".equals(operation)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(operation );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    if(isMultiValue){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    }else{
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    }
  if(i==sizeColumns - 1){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    }
}// here end the if modify

     if ("add".equals(changetype) || "none".equals(changetype)) {   
		boolean isMultiValue = false;
		String separator = null;
		for(Map<String, String> line:multiValueColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");				
				if(column.getLabel().equals(columnName)){
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");										
					break;
				}
		}

    stringBuffer.append(TEXT_86);
    if(isMultiValue){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    }else{
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
}// here end the if add

     if ("modrdn".equals(changetype)) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
}// here end the if modrdn

    stringBuffer.append(TEXT_118);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_119);
    					
	} 

    stringBuffer.append(TEXT_120);
     
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
			}
		
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_132);
    
  }
}  

    stringBuffer.append(TEXT_133);
    return stringBuffer.toString();
  }
}
