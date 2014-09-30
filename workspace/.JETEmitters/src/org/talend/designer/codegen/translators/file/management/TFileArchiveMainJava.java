package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileArchiveMainJava
{
  protected static String nl;
  public static synchronized TFileArchiveMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileArchiveMainJava result = new TFileArchiveMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "    String sourceDir_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";      " + NL + "    String zipFile_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "    " + NL + "    com.talend.compress.zip.Zip zip_";
  protected final String TEXT_6 = " = new com.talend.compress.zip.Zip(sourceDir_";
  protected final String TEXT_7 = ", zipFile_";
  protected final String TEXT_8 = ");" + NL + "    zip_";
  protected final String TEXT_9 = ".setOverwriteExistTargetZip(";
  protected final String TEXT_10 = ");" + NL + "\tzip_";
  protected final String TEXT_11 = ".setMakeTargetDir(";
  protected final String TEXT_12 = ");" + NL + "\tint level_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\tzip_";
  protected final String TEXT_15 = ".setCompressLevel(level_";
  protected final String TEXT_16 = ");" + NL + "\tzip_";
  protected final String TEXT_17 = ".setAllFiles(";
  protected final String TEXT_18 = ");" + NL + "    zip_";
  protected final String TEXT_19 = ".setContainSubDir(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = "  " + NL + "    \t//build filename pattern filter" + NL + "\t    String[] patterns_";
  protected final String TEXT_22 = " = new String[";
  protected final String TEXT_23 = "];" + NL + "    \t";
  protected final String TEXT_24 = NL + "\t        patterns_";
  protected final String TEXT_25 = "[";
  protected final String TEXT_26 = "] = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "  \t\tStringBuilder sbf_";
  protected final String TEXT_29 = " = new StringBuilder(); " + NL + "        sbf_";
  protected final String TEXT_30 = ".append(\"(\");" + NL + "        for (int i_";
  protected final String TEXT_31 = " = 0 ; i_";
  protected final String TEXT_32 = " < patterns_";
  protected final String TEXT_33 = ".length ; i_";
  protected final String TEXT_34 = "++) {" + NL + "            sbf_";
  protected final String TEXT_35 = ".append(patterns_";
  protected final String TEXT_36 = "[i_";
  protected final String TEXT_37 = "].replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "            if(i_";
  protected final String TEXT_38 = " != patterns_";
  protected final String TEXT_39 = ".length-1) sbf_";
  protected final String TEXT_40 = ".append(\"|\");" + NL + "        }        " + NL + "        sbf_";
  protected final String TEXT_41 = ".append(\")\");" + NL + "        final String maskStr_";
  protected final String TEXT_42 = " = new String(sbf_";
  protected final String TEXT_43 = ".toString());" + NL + "        " + NL + "        //apply the filter" + NL + "       \tzip_";
  protected final String TEXT_44 = ".setNamePatternFilter(maskStr_";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = "     " + NL + "   \t" + NL + "   \t  zip_";
  protected final String TEXT_47 = ".setEncoding(";
  protected final String TEXT_48 = ");" + NL + "   \t  zip_";
  protected final String TEXT_49 = ".setZip64Mode(\"";
  protected final String TEXT_50 = "\");" + NL + "   \t  zip_";
  protected final String TEXT_51 = ".setEncrypted(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t  ";
  protected final String TEXT_54 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_55 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = "; ";
  protected final String TEXT_60 = NL + "\t  zip_";
  protected final String TEXT_61 = ".setPassword(decryptedPassword_";
  protected final String TEXT_62 = ");" + NL + "   \t  " + NL + "   \t  zip_";
  protected final String TEXT_63 = ".doZip();" + NL + "   \t  " + NL + "      globalMap.put(\"";
  protected final String TEXT_64 = "_ARCHIVE_FILEPATH\",zipFile_";
  protected final String TEXT_65 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_66 = "_ARCHIVE_FILENAME\",(";
  protected final String TEXT_67 = ").contains(\"\\\\\")?" + NL + "    (";
  protected final String TEXT_68 = ").substring(((";
  protected final String TEXT_69 = ").lastIndexOf(\"\\\\\")+2)): (";
  protected final String TEXT_70 = ").substring(((";
  protected final String TEXT_71 = ").lastIndexOf(\"/\"))+1));";
  protected final String TEXT_72 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	

	String directory = ElementParameterParser.getValue(node, "__SOURCE__");
	String zipFile = ElementParameterParser.getValue(node, "__TARGET__");
	String level = ElementParameterParser.getValue(node, "__LEVEL__");
	boolean mkDir = ("true").equals(ElementParameterParser.getValue(node, "__MKDIR__"));
	boolean isAllFile = ("true").equals(ElementParameterParser.getValue(node, "__ALL_FILES__"));
	boolean subDir = ("true").equals(ElementParameterParser.getValue(node, "__SUB_DIRECTROY__"));
	boolean overwrite = ("true").equals(ElementParameterParser.getValue(node, "__OVERWRITE__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean isEncrypted = ("true").equals(ElementParameterParser.getValue(node, "__ENCRYPT_FILES__"));
	
	List<Map<String, String>> masks = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MASK__");	
	
	String zip64Mode = ElementParameterParser.getValue(node, "__ZIP64_MODE__");
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(mkDir);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(level );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(isAllFile);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(subDir);
    stringBuffer.append(TEXT_20);
     
	if (!isAllFile) {
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(masks.size());
    stringBuffer.append(TEXT_23);
    
	    for(int i=0 ; i < masks.size() ; i++) {
	        Map<String, String> line = masks.get(i);
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(line.get("FILEMASK"));
    stringBuffer.append(TEXT_27);
    
	    }
	    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
     
   }
   
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(zip64Mode);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isEncrypted);
    stringBuffer.append(TEXT_52);
    
	  String passwordFieldName = "__PASSWORD__";
	  
    stringBuffer.append(TEXT_53);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
