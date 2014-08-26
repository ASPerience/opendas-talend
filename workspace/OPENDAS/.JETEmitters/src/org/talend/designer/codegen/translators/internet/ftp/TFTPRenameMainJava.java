package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPRenameMainJava
{
  protected static String nl;
  public static synchronized TFTPRenameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPRenameMainJava result = new TFTPRenameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "try{";
  protected final String TEXT_2 = "\t" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file renamed.\");" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet();   " + NL + "    \tfor (String key";
  protected final String TEXT_6 = " : keySet";
  protected final String TEXT_7 = ")" + NL + "   \t\t{    " + NL + "   \t\t\ttry{" + NL + "   \t\t\tc_";
  protected final String TEXT_8 = ".rename(";
  protected final String TEXT_9 = "+\"/\"+key";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = "+\"/\"+map";
  protected final String TEXT_12 = ".get(key";
  protected final String TEXT_13 = "));" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_14 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "   \t\t\t}catch(com.jcraft.jsch.SftpException se){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_15 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "   \t\t\tthrow se;" + NL + "   \t\t\t}" + NL + "   \t\t\tnb_file_";
  protected final String TEXT_16 = "++;" + NL + "   \t\t}" + NL + "\t" + NL + NL;
  protected final String TEXT_17 = "//normal ftp" + NL + "\t \t" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_18 = " = map";
  protected final String TEXT_19 = ".keySet(); " + NL + "    \ttry{  " + NL + "    \tfor (String key";
  protected final String TEXT_20 = " : keySet";
  protected final String TEXT_21 = ")" + NL + "   \t\t{" + NL + "     \t\t";
  protected final String TEXT_22 = NL + "     \t\t  " + NL + "     \t\t\tString fromFile_";
  protected final String TEXT_23 = " = key";
  protected final String TEXT_24 = ";" + NL + "     \t\t\tString toFile_";
  protected final String TEXT_25 = " = map";
  protected final String TEXT_26 = ".get(key";
  protected final String TEXT_27 = ");" + NL + "     \t\t\t" + NL + "     \t\t    if (!fromFile_";
  protected final String TEXT_28 = ".equals(toFile_";
  protected final String TEXT_29 = ")){" + NL + "     \t\t      if(ftp_";
  protected final String TEXT_30 = ".exists(fromFile_";
  protected final String TEXT_31 = ")){" + NL + "     \t\t    \tif(ftp_";
  protected final String TEXT_32 = ".exists(toFile_";
  protected final String TEXT_33 = " + \".tmp\")){" + NL + "     \t\t    \t\tftp_";
  protected final String TEXT_34 = ".delete(toFile_";
  protected final String TEXT_35 = " + \".tmp\");" + NL + "     \t\t    \t}" + NL + "     \t\t    \tif(ftp_";
  protected final String TEXT_36 = ".exists(toFile_";
  protected final String TEXT_37 = ")){" + NL + "\t\t     \t\t\tftp_";
  protected final String TEXT_38 = ".rename(toFile_";
  protected final String TEXT_39 = ", toFile_";
  protected final String TEXT_40 = " + \".tmp\");" + NL + "     \t\t    \t}" + NL + "\t     \t\t\tftp_";
  protected final String TEXT_41 = ".rename(fromFile_";
  protected final String TEXT_42 = ", toFile_";
  protected final String TEXT_43 = ");" + NL + "\t     \t\t\tif(ftp_";
  protected final String TEXT_44 = ".exists(toFile_";
  protected final String TEXT_45 = " + \".tmp\")){" + NL + "\t\t     \t\t\tftp_";
  protected final String TEXT_46 = ".delete(toFile_";
  protected final String TEXT_47 = " + \".tmp\");" + NL + "\t     \t\t\t}" + NL + "\t     \t\t\tglobalMap.put(\"";
  protected final String TEXT_48 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t     \t\t\tnb_file_";
  protected final String TEXT_49 = "++;" + NL + "     \t\t\t  }" + NL + "     \t       }" + NL + "     \t\t";
  protected final String TEXT_50 = NL + "     \t\t";
  protected final String TEXT_51 = NL + "     \t\t\tif(!(ftp_";
  protected final String TEXT_52 = ".exists(map";
  protected final String TEXT_53 = ".get(key";
  protected final String TEXT_54 = "))))" + NL + "     \t\t\t{" + NL + "     \t\t\tftp_";
  protected final String TEXT_55 = ".rename(key";
  protected final String TEXT_56 = ", map";
  protected final String TEXT_57 = ".get(key";
  protected final String TEXT_58 = "));" + NL + "     \t\t\tglobalMap.put(\"";
  protected final String TEXT_59 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "     \t\t\tnb_file_";
  protected final String TEXT_60 = "++;" + NL + "     \t\t\t}" + NL + "     \t\t";
  protected final String TEXT_61 = NL + "     \t\t";
  protected final String TEXT_62 = NL + "     \t\t\tif((ftp_";
  protected final String TEXT_63 = ".exists(map";
  protected final String TEXT_64 = ".get(key";
  protected final String TEXT_65 = ")))){" + NL + "\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftpnewNamefile";
  protected final String TEXT_66 = "=ftp_";
  protected final String TEXT_67 = ".fileDetails(map";
  protected final String TEXT_68 = ".get(key";
  protected final String TEXT_69 = "));" + NL + "\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftporigNamefile";
  protected final String TEXT_70 = "=ftp_";
  protected final String TEXT_71 = ".fileDetails(key";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\tlong newNameSize";
  protected final String TEXT_73 = "=ftpnewNamefile";
  protected final String TEXT_74 = ".size();" + NL + "\t\t\t\t\tlong origNameSize";
  protected final String TEXT_75 = "=ftporigNamefile";
  protected final String TEXT_76 = ".size();" + NL + "\t\t\t\t\tif(!(newNameSize";
  protected final String TEXT_77 = "==origNameSize";
  protected final String TEXT_78 = "))" + NL + "\t\t\t\t\t{" + NL + "\t\t     \t\t\tString fromFile_";
  protected final String TEXT_79 = " = key";
  protected final String TEXT_80 = ";" + NL + "\t\t     \t\t\tString toFile_";
  protected final String TEXT_81 = " = map";
  protected final String TEXT_82 = ".get(key";
  protected final String TEXT_83 = ");" + NL + "\t\t\t\t\t\tif(ftp_";
  protected final String TEXT_84 = ".exists(fromFile_";
  protected final String TEXT_85 = ")){" + NL + "\t\t     \t\t    \tif(ftp_";
  protected final String TEXT_86 = ".exists(toFile_";
  protected final String TEXT_87 = " + \".tmp\")){" + NL + "\t\t     \t\t    \t\tftp_";
  protected final String TEXT_88 = ".delete(toFile_";
  protected final String TEXT_89 = " + \".tmp\");" + NL + "\t\t     \t\t    \t}" + NL + "\t\t     \t\t    \tif(ftp_";
  protected final String TEXT_90 = ".exists(toFile_";
  protected final String TEXT_91 = ")){" + NL + "\t\t\t\t     \t\t\tftp_";
  protected final String TEXT_92 = ".rename(toFile_";
  protected final String TEXT_93 = ", toFile_";
  protected final String TEXT_94 = " + \".tmp\");" + NL + "\t\t     \t\t    \t}" + NL + "\t\t\t     \t\t\tftp_";
  protected final String TEXT_95 = ".rename(fromFile_";
  protected final String TEXT_96 = ", toFile_";
  protected final String TEXT_97 = ");" + NL + "\t\t\t     \t\t\tif(ftp_";
  protected final String TEXT_98 = ".exists(toFile_";
  protected final String TEXT_99 = " + \".tmp\")){" + NL + "\t\t\t\t     \t\t\tftp_";
  protected final String TEXT_100 = ".delete(toFile_";
  protected final String TEXT_101 = " + \".tmp\");" + NL + "\t\t\t     \t\t\t}" + NL + "\t\t\t     \t\t\tglobalMap.put(\"";
  protected final String TEXT_102 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t\t     \t\t\tnb_file_";
  protected final String TEXT_103 = "++;" + NL + "\t\t     \t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tftp_";
  protected final String TEXT_104 = ".rename(key";
  protected final String TEXT_105 = ", map";
  protected final String TEXT_106 = ".get(key";
  protected final String TEXT_107 = "));" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_108 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t\t\t\tnb_file_";
  protected final String TEXT_109 = "++;" + NL + "\t\t\t\t}" + NL + "     \t\t";
  protected final String TEXT_110 = NL + "   \t\t}" + NL + "   \t\t}catch(com.enterprisedt.net.ftp.FTPException e){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_111 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "            throw e;" + NL + "   \t\t}" + NL + "\t" + NL;
  protected final String TEXT_112 = NL + " \t}catch(Exception e){";
  protected final String TEXT_113 = NL + "            throw(e);";
  protected final String TEXT_114 = NL + "\t\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_115 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String overwrite=ElementParameterParser.getValue(node, "__OVERWRITE__");
	String cid = node.getUniqueName();
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean sftp = false;
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
	}

    stringBuffer.append(TEXT_1);
    
	if(sftp){//sftp support

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    if(("always").equals(overwrite)){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    if(("never").equals(overwrite)){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    if(("size_differ").equals(overwrite)){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    
        if(("true").equals(dieOnError)){

    stringBuffer.append(TEXT_113);
    
		}else{

    stringBuffer.append(TEXT_114);
    
		}

    stringBuffer.append(TEXT_115);
    return stringBuffer.toString();
  }
}
