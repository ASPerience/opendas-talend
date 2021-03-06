package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileUnarchiveBeginJava
{
  protected static String nl;
  public static synchronized TFileUnarchiveBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileUnarchiveBeginJava result = new TFileUnarchiveBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "      " + NL + "\t\tcom.talend.compress.zip.Util util_";
  protected final String TEXT_2 = " = new com.talend.compress.zip.Util(";
  protected final String TEXT_3 = ");" + NL + "        " + NL + "        String zipFileURL_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "        String tmpFileURL_";
  protected final String TEXT_6 = " = zipFileURL_";
  protected final String TEXT_7 = ".toLowerCase();" + NL + "        String outputPath_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = "        " + NL + "        java.io.File file_";
  protected final String TEXT_11 = " = new java.io.File(zipFileURL_";
  protected final String TEXT_12 = ");        " + NL + "        String name_";
  protected final String TEXT_13 = " = file_";
  protected final String TEXT_14 = ".getName();        " + NL + "\t\tint i_";
  protected final String TEXT_15 = " = 0;" + NL + "\t\tif (tmpFileURL_";
  protected final String TEXT_16 = ".endsWith(\".tar.gz\"))  {" + NL + "\t\t\ti_";
  protected final String TEXT_17 = " = name_";
  protected final String TEXT_18 = ".length()-7;" + NL + "   \t\t} else {           " + NL + "            i_";
  protected final String TEXT_19 = " = name_";
  protected final String TEXT_20 = ".lastIndexOf('.');        " + NL + "            i_";
  protected final String TEXT_21 = " = i_";
  protected final String TEXT_22 = "!=-1? i_";
  protected final String TEXT_23 = " : name_";
  protected final String TEXT_24 = ".length();        " + NL + "        }    " + NL + "        String root_";
  protected final String TEXT_25 = " = name_";
  protected final String TEXT_26 = ".substring(0, i_";
  protected final String TEXT_27 = ");   " + NL + "        new java.io.File(outputPath_";
  protected final String TEXT_28 = ", root_";
  protected final String TEXT_29 = ").mkdir();" + NL + "        outputPath_";
  protected final String TEXT_30 = " = outputPath_";
  protected final String TEXT_31 = " +\"/\" + root_";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + NL + "\tif (tmpFileURL_";
  protected final String TEXT_34 = ".endsWith(\".tar.gz\") || tmpFileURL_";
  protected final String TEXT_35 = ".endsWith(\".tgz\")){   " + NL + "\t\tif(";
  protected final String TEXT_36 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_37 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_38 = " + \" is corrupted, process terminated...\" );" + NL + "\t\t}" + NL + "\t\torg.apache.tools.tar.TarInputStream zip_";
  protected final String TEXT_39 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_40 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_41 = " = new java.io.FileInputStream(zipFileURL_";
  protected final String TEXT_42 = ");" + NL + "\t\t\tinputStream_";
  protected final String TEXT_43 = " = new java.util.zip.GZIPInputStream(inputStream_";
  protected final String TEXT_44 = ");" + NL + "           \tzip_";
  protected final String TEXT_45 = " = new org.apache.tools.tar.TarInputStream(inputStream_";
  protected final String TEXT_46 = ");" + NL + "           \t" + NL + "            org.apache.tools.tar.TarEntry entry_";
  protected final String TEXT_47 = " = null;" + NL + "            java.io.InputStream is_";
  protected final String TEXT_48 = " = null;" + NL + "            while ((entry_";
  protected final String TEXT_49 = " = zip_";
  protected final String TEXT_50 = ".getNextEntry()) != null) {" + NL + "                boolean isDirectory_";
  protected final String TEXT_51 = " = entry_";
  protected final String TEXT_52 = ".isDirectory();" + NL + "    \t\t\tif (!isDirectory_";
  protected final String TEXT_53 = ") {" + NL + "                    is_";
  protected final String TEXT_54 = " = zip_";
  protected final String TEXT_55 = ";" + NL + "    \t\t\t}" + NL + "                String filename_";
  protected final String TEXT_56 = " =  entry_";
  protected final String TEXT_57 = ".getName();" + NL + "                util_";
  protected final String TEXT_58 = ".output(outputPath_";
  protected final String TEXT_59 = ", filename_";
  protected final String TEXT_60 = ", isDirectory_";
  protected final String TEXT_61 = ", is_";
  protected final String TEXT_62 = ");\t\t\t" + NL + "    ";
  protected final String TEXT_63 = "  " + NL + "                java.io.File f = new java.io.File(outputPath_";
  protected final String TEXT_64 = "+\"/\"+ filename_";
  protected final String TEXT_65 = ");  " + NL + "                f.setLastModified(entry_";
  protected final String TEXT_66 = ".getModTime().getTime());  ";
  protected final String TEXT_67 = "  " + NL + "                java.io.File unzippedFile = new java.io.File(outputPath_";
  protected final String TEXT_68 = " + util_";
  protected final String TEXT_69 = ".getEntryName(filename_";
  protected final String TEXT_70 = "));  " + NL + "                unzippedFile.setLastModified(entry_";
  protected final String TEXT_71 = ".getModTime().getTime());  ";
  protected final String TEXT_72 = " " + NL + "            }" + NL + "        } finally {" + NL + "        \tif(zip_";
  protected final String TEXT_73 = " != null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_74 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_75 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_76 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} else if (tmpFileURL_";
  protected final String TEXT_77 = ".endsWith(\".tar\")){ " + NL + "\t\tif(";
  protected final String TEXT_78 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_79 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_80 = " + \" is corrupted, process terminated...\" );" + NL + "" + NL + "\t\t}" + NL + "\t\torg.apache.tools.tar.TarInputStream zip_";
  protected final String TEXT_81 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_82 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_83 = " = new java.io.FileInputStream(zipFileURL_";
  protected final String TEXT_84 = ");" + NL + "           \tzip_";
  protected final String TEXT_85 = " = new org.apache.tools.tar.TarInputStream(inputStream_";
  protected final String TEXT_86 = ");" + NL + "           \t" + NL + "            org.apache.tools.tar.TarEntry entry_";
  protected final String TEXT_87 = " = null;" + NL + "            java.io.InputStream is_";
  protected final String TEXT_88 = " = null;" + NL + "            while ((entry_";
  protected final String TEXT_89 = " = zip_";
  protected final String TEXT_90 = ".getNextEntry()) != null) {" + NL + "                boolean isDirectory_";
  protected final String TEXT_91 = " = entry_";
  protected final String TEXT_92 = ".isDirectory(); " + NL + "                if (!isDirectory_";
  protected final String TEXT_93 = ") {" + NL + "                    is_";
  protected final String TEXT_94 = " = zip_";
  protected final String TEXT_95 = ";" + NL + "    \t\t\t}" + NL + "                String filename_";
  protected final String TEXT_96 = " =  entry_";
  protected final String TEXT_97 = ".getName();" + NL + "                util_";
  protected final String TEXT_98 = ".output(outputPath_";
  protected final String TEXT_99 = ", filename_";
  protected final String TEXT_100 = ", isDirectory_";
  protected final String TEXT_101 = ", is_";
  protected final String TEXT_102 = ");            " + NL + "             ";
  protected final String TEXT_103 = "  " + NL + "                       java.io.File f = new java.io.File(outputPath_";
  protected final String TEXT_104 = "+\"/\"+ filename_";
  protected final String TEXT_105 = ");  " + NL + "                       f.setLastModified(entry_";
  protected final String TEXT_106 = ".getModTime().getTime());  ";
  protected final String TEXT_107 = "  " + NL + "                       java.io.File unzippedFile = new java.io.File(outputPath_";
  protected final String TEXT_108 = " + util_";
  protected final String TEXT_109 = ".getEntryName(filename_";
  protected final String TEXT_110 = "));  " + NL + "                       unzippedFile.setLastModified(entry_";
  protected final String TEXT_111 = ".getModTime().getTime());  ";
  protected final String TEXT_112 = " " + NL + "    " + NL + "            }" + NL + "        } finally {" + NL + "        \tif(zip_";
  protected final String TEXT_113 = "!=null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_114 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_115 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_116 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "  \t}else if (tmpFileURL_";
  protected final String TEXT_117 = ".endsWith(\".gz\")){ " + NL + "  \t\tif(";
  protected final String TEXT_118 = " && !org.talend.archive.IntegrityUtil.isGZIPValid(zipFileURL_";
  protected final String TEXT_119 = ")){" + NL + "\t\t\tthrow new RuntimeException (\"The file \" + zipFileURL_";
  protected final String TEXT_120 = " + \" is corrupted, process terminated...\" );" + NL + "" + NL + "\t\t}" + NL + "\t\tjava.util.zip.GZIPInputStream zip_";
  protected final String TEXT_121 = " = null;" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_122 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_123 = " = new java.io.FileInputStream(new java.io.File(zipFileURL_";
  protected final String TEXT_124 = "));" + NL + "           \tzip_";
  protected final String TEXT_125 = " = new java.util.zip.GZIPInputStream(inputStream_";
  protected final String TEXT_126 = ");" + NL + "           \t" + NL + "            java.io.InputStream is_";
  protected final String TEXT_127 = " = zip_";
  protected final String TEXT_128 = ";" + NL + "            String fullName_";
  protected final String TEXT_129 = " = new java.io.File(zipFileURL_";
  protected final String TEXT_130 = ").getName();  " + NL + "    \t\tString filename_";
  protected final String TEXT_131 = " =  fullName_";
  protected final String TEXT_132 = ".substring(0, fullName_";
  protected final String TEXT_133 = ".length()-3);  " + NL + "    \t\tutil_";
  protected final String TEXT_134 = ".output(outputPath_";
  protected final String TEXT_135 = ", filename_";
  protected final String TEXT_136 = ",is_";
  protected final String TEXT_137 = ");" + NL + "\t\t} finally {" + NL + "\t\t\tif(zip_";
  protected final String TEXT_138 = " != null) {" + NL + "\t\t\t\tzip_";
  protected final String TEXT_139 = ".close();" + NL + "\t\t\t} else if(inputStream_";
  protected final String TEXT_140 = " != null) {" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_141 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}else {" + NL + "\t\t//the others all use the ZIP to decompression" + NL + "\t\tcom.talend.compress.zip.Unzip unzip_";
  protected final String TEXT_142 = " = new com.talend.compress.zip.Unzip(zipFileURL_";
  protected final String TEXT_143 = ", outputPath_";
  protected final String TEXT_144 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_145 = ".setNeedPassword(";
  protected final String TEXT_146 = ");" + NL + "\t\t";
  protected final String TEXT_147 = NL + "\t\t";
  protected final String TEXT_148 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_149 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_150 = ");";
  protected final String TEXT_151 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = "; ";
  protected final String TEXT_154 = NL + "\t\tunzip_";
  protected final String TEXT_155 = ".setPassword(decryptedPassword_";
  protected final String TEXT_156 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_157 = ".setCheckArchive(";
  protected final String TEXT_158 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_159 = ".setVerbose(";
  protected final String TEXT_160 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_161 = ".setExtractPath(";
  protected final String TEXT_162 = ");" + NL + "\t\tunzip_";
  protected final String TEXT_163 = ".setUtil(util_";
  protected final String TEXT_164 = ");" + NL + "\t\t" + NL + "\t\tunzip_";
  protected final String TEXT_165 = ".doUnzip();" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\tfor (com.talend.compress.zip.UnzippedFile uf";
  protected final String TEXT_166 = " : util_";
  protected final String TEXT_167 = ".unzippedFiles) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_168 = "_CURRENT_FILE\", uf";
  protected final String TEXT_169 = ".fileName);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_170 = "_CURRENT_FILEPATH\", uf";
  protected final String TEXT_171 = ".filePath);" + NL + "\t";
  protected final String TEXT_172 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	

	String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
	String zipFile = ElementParameterParser.getValue(node, "__ZIPFILE__");
	boolean rootName = ("true").equals(ElementParameterParser.getValue(node, "__ROOTNAME__"));
	boolean extractPath = ("true").equals(ElementParameterParser.getValue(node, "__EXTRACTPATH__"));
	
	boolean isArchiveValid = ("true").equals(ElementParameterParser.getValue(node, "__INTEGRITY__"));
	boolean isPasswordNeeded = ("true").equals(ElementParameterParser.getValue(node, "__CHECKPASSWORD__"));
	boolean needPrintout = ("true").equals(ElementParameterParser.getValue(node, "__PRINTOUT__"));
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(extractPath);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_9);
    
	if (rootName==true) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
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
    
  }

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
     if (extractPath == true) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    } else {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
     }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
     if (extractPath == true) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    } else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
     }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(isPasswordNeeded);
    stringBuffer.append(TEXT_146);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_147);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_150);
    } else {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(isArchiveValid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(needPrintout);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(extractPath);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
    return stringBuffer.toString();
  }
}
