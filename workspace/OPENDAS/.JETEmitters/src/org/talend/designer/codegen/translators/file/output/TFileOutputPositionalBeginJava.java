package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileOutputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalBeginJava result = new TFileOutputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\tString fileNewName_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\tjava.io.File createFile";
  protected final String TEXT_7 = " = new java.io.File(fileNewName_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "        //create directory only if not exists" + NL + "        java.io.File parentFile_";
  protected final String TEXT_10 = " = createFile";
  protected final String TEXT_11 = ".getParentFile();" + NL + "        if(parentFile_";
  protected final String TEXT_12 = " != null && !parentFile_";
  protected final String TEXT_13 = ".exists()) {" + NL + "            parentFile_";
  protected final String TEXT_14 = ".mkdirs();" + NL + "        }";
  protected final String TEXT_15 = NL + "        String fullName_";
  protected final String TEXT_16 = " = null;" + NL + "        String extension_";
  protected final String TEXT_17 = " = null;" + NL + "        String directory_";
  protected final String TEXT_18 = " = null;" + NL + "        if((fileNewName_";
  protected final String TEXT_19 = ".indexOf(\"/\") != -1)) {" + NL + "            if(fileNewName_";
  protected final String TEXT_20 = ".lastIndexOf(\".\") < fileNewName_";
  protected final String TEXT_21 = ".lastIndexOf(\"/\")) {" + NL + "                fullName_";
  protected final String TEXT_22 = " = fileNewName_";
  protected final String TEXT_23 = ";" + NL + "                extension_";
  protected final String TEXT_24 = " = \"\";" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_25 = " = fileNewName_";
  protected final String TEXT_26 = ".substring(0, fileNewName_";
  protected final String TEXT_27 = ".lastIndexOf(\".\"));" + NL + "                extension_";
  protected final String TEXT_28 = " = fileNewName_";
  protected final String TEXT_29 = ".substring(fileNewName_";
  protected final String TEXT_30 = ".lastIndexOf(\".\"));" + NL + "            }           " + NL + "            directory_";
  protected final String TEXT_31 = " = fileNewName_";
  protected final String TEXT_32 = ".substring(0, fileNewName_";
  protected final String TEXT_33 = ".lastIndexOf(\"/\"));            " + NL + "        } else {" + NL + "            if(fileNewName_";
  protected final String TEXT_34 = ".lastIndexOf(\".\") != -1) {" + NL + "                fullName_";
  protected final String TEXT_35 = " = fileNewName_";
  protected final String TEXT_36 = ".substring(0, fileNewName_";
  protected final String TEXT_37 = ".lastIndexOf(\".\"));" + NL + "                extension_";
  protected final String TEXT_38 = " = fileNewName_";
  protected final String TEXT_39 = ".substring(fileNewName_";
  protected final String TEXT_40 = ".lastIndexOf(\".\"));" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_41 = " = fileNewName_";
  protected final String TEXT_42 = ";" + NL + "                extension_";
  protected final String TEXT_43 = " = \"\";" + NL + "            }" + NL + "            directory_";
  protected final String TEXT_44 = " = \"\";" + NL + "        }" + NL + "\t\tString zipName_";
  protected final String TEXT_45 = " = fullName_";
  protected final String TEXT_46 = " + \".zip\";" + NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_47 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_48 = ")));" + NL + "\t    zipOut_";
  protected final String TEXT_49 = ".putNextEntry(new java.util.zip.ZipEntry(createFile";
  protected final String TEXT_50 = ".getName()));" + NL + "\t\tfinal ";
  protected final String TEXT_51 = " out";
  protected final String TEXT_52 = " = new ";
  protected final String TEXT_53 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = "));";
  protected final String TEXT_56 = NL + "\t\tfinal ";
  protected final String TEXT_57 = " out";
  protected final String TEXT_58 = " = new ";
  protected final String TEXT_59 = "(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = "),";
  protected final String TEXT_62 = "));";
  protected final String TEXT_63 = NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_64 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_65 = "));" + NL + "\t    zipOut_";
  protected final String TEXT_66 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputPositional\"));" + NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_67 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_68 = ",";
  protected final String TEXT_69 = ");" + NL + "\t\tfinal ";
  protected final String TEXT_70 = " out";
  protected final String TEXT_71 = " = new ";
  protected final String TEXT_72 = "(outWriter_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_75 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = ");" + NL + "\t\tfinal ";
  protected final String TEXT_78 = " out";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "(outWriter_";
  protected final String TEXT_81 = ");  ";
  protected final String TEXT_82 = NL + "\t\tif(createFile";
  protected final String TEXT_83 = ".length()==0){";
  protected final String TEXT_84 = NL + "    \t\t" + NL + "    \t\tString tempStringB";
  protected final String TEXT_85 = "=null;" + NL + "    \t\tint tempLengthB";
  protected final String TEXT_86 = "=0;";
  protected final String TEXT_87 = NL + "    \t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringB";
  protected final String TEXT_88 = "=\"";
  protected final String TEXT_89 = "\";" + NL + "    \t\t\t";
  protected final String TEXT_90 = NL + "    \t\t\ttempLengthB";
  protected final String TEXT_91 = "=tempStringB";
  protected final String TEXT_92 = ".getBytes(";
  protected final String TEXT_93 = ").length;" + NL + "    \t\t\t";
  protected final String TEXT_94 = NL + "    \t\t\ttempLengthB";
  protected final String TEXT_95 = "=tempStringB";
  protected final String TEXT_96 = ".length();" + NL + "    \t\t\t";
  protected final String TEXT_97 = NL + "    \t\t\t" + NL + "            \tif (tempLengthB";
  protected final String TEXT_98 = " > ";
  protected final String TEXT_99 = ") {";
  protected final String TEXT_100 = NL + "                        tempStringB";
  protected final String TEXT_101 = " = tempStringB";
  protected final String TEXT_102 = ".substring(tempLengthB";
  protected final String TEXT_103 = "-";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "                        int begin";
  protected final String TEXT_106 = "=(tempLengthB";
  protected final String TEXT_107 = "-";
  protected final String TEXT_108 = ")/2;" + NL + "                        tempStringB";
  protected final String TEXT_109 = " = tempStringB";
  protected final String TEXT_110 = ".substring(begin";
  protected final String TEXT_111 = ", begin";
  protected final String TEXT_112 = "+";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "                    tempStringB";
  protected final String TEXT_115 = " = tempStringB";
  protected final String TEXT_116 = ".substring(0, ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "                }else if(tempLengthB";
  protected final String TEXT_119 = "<";
  protected final String TEXT_120 = "){" + NL + "                    StringBuilder result";
  protected final String TEXT_121 = " = new StringBuilder();";
  protected final String TEXT_122 = NL + "                        result";
  protected final String TEXT_123 = ".append(tempStringB";
  protected final String TEXT_124 = ");" + NL + "                        for(int i";
  protected final String TEXT_125 = "=0; i";
  protected final String TEXT_126 = "< ";
  protected final String TEXT_127 = "-tempLengthB";
  protected final String TEXT_128 = "; i";
  protected final String TEXT_129 = "++){" + NL + "                            result";
  protected final String TEXT_130 = ".append(";
  protected final String TEXT_131 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_132 = " = result";
  protected final String TEXT_133 = ".toString();";
  protected final String TEXT_134 = NL + "                        for(int i";
  protected final String TEXT_135 = "=0; i";
  protected final String TEXT_136 = "< ";
  protected final String TEXT_137 = "-tempLengthB";
  protected final String TEXT_138 = "; i";
  protected final String TEXT_139 = "++){" + NL + "                            result";
  protected final String TEXT_140 = ".append(";
  protected final String TEXT_141 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_142 = ".append(tempStringB";
  protected final String TEXT_143 = ");" + NL + "                        tempStringB";
  protected final String TEXT_144 = " = result";
  protected final String TEXT_145 = ".toString();";
  protected final String TEXT_146 = NL + "                        int temp";
  protected final String TEXT_147 = "= (";
  protected final String TEXT_148 = "-tempLengthB";
  protected final String TEXT_149 = ")/2;" + NL + "                        for(int i";
  protected final String TEXT_150 = "=0;i";
  protected final String TEXT_151 = "<temp";
  protected final String TEXT_152 = ";i";
  protected final String TEXT_153 = "++){" + NL + "                            result";
  protected final String TEXT_154 = ".append(";
  protected final String TEXT_155 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_156 = ".append(tempStringB";
  protected final String TEXT_157 = ");" + NL + "                        for(int i";
  protected final String TEXT_158 = "=0;i";
  protected final String TEXT_159 = "<temp";
  protected final String TEXT_160 = ";i";
  protected final String TEXT_161 = "++){" + NL + "                            result";
  protected final String TEXT_162 = ".append(";
  protected final String TEXT_163 = ");" + NL + "                        }" + NL + "                        if((temp";
  protected final String TEXT_164 = "+temp";
  protected final String TEXT_165 = ")!=(";
  protected final String TEXT_166 = "-tempLengthB";
  protected final String TEXT_167 = ")){" + NL + "                            result";
  protected final String TEXT_168 = ".append(";
  protected final String TEXT_169 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_170 = " = result";
  protected final String TEXT_171 = ".toString();";
  protected final String TEXT_172 = "       " + NL + "                }" + NL + "                //get  and format output String end" + NL + "    \t\t\tout";
  protected final String TEXT_173 = ".write(tempStringB";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "    \t\tout";
  protected final String TEXT_176 = ".write(";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "    \t}";
  protected final String TEXT_179 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    	String cid = node.getUniqueName();
    	
    	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        if (encoding!=null) {
            if (("").equals(encoding)) {
                encoding = "undef";
            }
        }
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
        
        String filename = ElementParameterParser.getValue(
            node,
            "__FILENAME__"
        );
		
		boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
		
        boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));

        boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
        
		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
		String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
        
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        
        boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        String writerClass = null;
    	if(isInRowMode){
    		writerClass = "routines.system.BufferedOutput";
    	}else{
    		writerClass = "java.io.BufferedWriter";
    	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if(!useStream){// the part of file path

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
			if(compress && !isAppend){// compress the dest file

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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_55);
    
			}else{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_61);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_62);
    
			}
		}else{ //the part of the output stream
			if(compress && !isAppend){// compress the dest output stream

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
			}else{

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    
			}
		}
		
		if(isIncludeHeader){      	
			if(!useStream){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			}
			
    		List<IMetadataColumn> columns = metadata.getListColumns();
    		int sizeColumns = columns.size();

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
    		for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			Map<String, String> format=formats.get(i);

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_89);
    if(useByte){
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_93);
    }else{
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_99);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
                    } else if (("\'R\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_104);
    
                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_113);
    
                    } else {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_117);
    
                    }

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
                    } else {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    
                    } 

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    
    		}

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_177);
    
			if(!useStream){

    stringBuffer.append(TEXT_178);
    
			}
		}
    }
}

    stringBuffer.append(TEXT_179);
    return stringBuffer.toString();
  }
}
