package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TTeradataOutputEndJava
{
  protected static String nl;
  public static synchronized TTeradataOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataOutputEndJava result = new TTeradataOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_3 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_4 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_5 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_6 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_7 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_8 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_9 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_10 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_11 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_12 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_13 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = NL + "                try {" + NL + "        \t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tif ( batchSizeCounter_";
  protected final String TEXT_17 = " > 0 ) { // do not commit empty batch, this is a jdbc error" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tif ( commitCounter_";
  protected final String TEXT_19 = " > 0 ) { // do not commit empty batch, this is a jdbc error" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\tif (pstmt_";
  protected final String TEXT_21 = " !=null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_22 = "\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Executing the ";
  protected final String TEXT_25 = " batch.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = NL + "            \t    \tint countSum_";
  protected final String TEXT_27 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_28 = ": pstmt_";
  protected final String TEXT_29 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_30 = " += (countEach_";
  protected final String TEXT_31 = " < 0 ? 0 : countEach_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - The ";
  protected final String TEXT_35 = " batch execution has succeeded.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "            \t    \t";
  protected final String TEXT_37 = NL + "            \t    \t\tinsertedCount_";
  protected final String TEXT_38 = " += countSum_";
  protected final String TEXT_39 = ";" + NL + "            \t    \t";
  protected final String TEXT_40 = NL + "            \t    \t\tupdatedCount_";
  protected final String TEXT_41 = " += countSum_";
  protected final String TEXT_42 = ";" + NL + "            \t    \t";
  protected final String TEXT_43 = NL + "            \t    \t    deletedCount_";
  protected final String TEXT_44 = " += countSum_";
  protected final String TEXT_45 = ";" + NL + "            \t    \t";
  protected final String TEXT_46 = NL + "            \t    \t" + NL + "\t\t\t\t\t\t}" + NL + "                //}catch (java.sql.BatchUpdateException e){" + NL + "\t\t\t\t}catch (java.sql.SQLException e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tjava.sql.SQLException e2 = e;" + NL + "\t\t\t\t\twhile (e2 != null) {" + NL + "\t\t\t\t\t\tSystem.out.println(e.getMessage());" + NL + "\t\t\t\t\t\te2 = e2.getNextException();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tjava.sql.SQLException e3 = e;" + NL + "                \tboolean isFailure = false;" + NL + "                \tint errorCode = 0;" + NL + "\t\t\tString sqlState = \"\";" + NL + "\t\t\tString message = \"\";" + NL + "\t\t\twhile(e != null){" + NL + "\t\t\t\tif(e.getErrorCode() == -2801){" + NL + "\t\t\t\t\tSystem.out.println(\"[Message]: \" + e.getMessage());" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\tSystem.out.println();" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse if(e.getErrorCode() == 1339){" + NL + "\t\t\t\t\tisFailure = true;" + NL + "\t\t\t\t} else{" + NL + "\t\t\t\t\tSystem.out.println(\"[Message]: \" + e.getMessage());" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\te = e.getNextException();" + NL + "\t\t\t}" + NL + "\t\t\tif(isFailure && e != null){" + NL + "\t\t\t\tSystem.out.println(\"[Message]: \" + e.getMessage());" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "                \t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_51 = " - \" + e3.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tthrow(e3);" + NL + "                \t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_55 = " - \" + e3.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tSystem.err.println(e3.getMessage());" + NL + "                \t";
  protected final String TEXT_57 = "                \t" + NL + "            \t}                                  ";
  protected final String TEXT_58 = NL + "        " + NL + "        if(pstmt_";
  protected final String TEXT_59 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_60 = ".close();" + NL + "            pstmt_";
  protected final String TEXT_61 = " = null;" + NL + "        }        ";
  protected final String TEXT_62 = NL + "\t\t\tif (commitCounter_";
  protected final String TEXT_63 = " > 0)" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_65 = " - Starting to commit \" + commitCounter_";
  protected final String TEXT_66 = " + \" records.\");" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t            conn_";
  protected final String TEXT_68 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_70 = " - Commit has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "\t        ";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t    conn_";
  protected final String TEXT_76 = " .close();" + NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_77 = "\", true);" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_79 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t    ";
  protected final String TEXT_81 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_82 = "=nb_line_deleted_";
  protected final String TEXT_83 = "+ deletedCount_";
  protected final String TEXT_84 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_85 = "=nb_line_update_";
  protected final String TEXT_86 = " + updatedCount_";
  protected final String TEXT_87 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_88 = "=nb_line_inserted_";
  protected final String TEXT_89 = " + insertedCount_";
  protected final String TEXT_90 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_91 = "=nb_line_rejected_";
  protected final String TEXT_92 = " + rejectedCount_";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = NL + "\tif (globalMap.get(\"";
  protected final String TEXT_95 = "_NB_LINE\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_96 = "_NB_LINE\",nb_line_";
  protected final String TEXT_97 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_98 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_99 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_100 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_101 = "_NB_LINE_UPDATED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_102 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_103 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_104 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_105 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_106 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_107 = "_NB_LINE_INSERTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_108 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_109 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_110 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_111 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_112 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_113 = "_NB_LINE_DELETED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_114 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_115 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_116 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_117 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_118 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_119 = "_NB_LINE_REJECTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_120 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_121 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_122 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_123 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_124 = ");" + NL + "    }";
  protected final String TEXT_125 = NL + "    globalMap.put(\"";
  protected final String TEXT_126 = "_NB_LINE\",nb_line_";
  protected final String TEXT_127 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_128 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_129 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_130 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_131 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_132 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_133 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_134 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_135 = ");" + NL + "    ";
  protected final String TEXT_136 = NL + "\t" + NL + "\t";
  protected final String TEXT_137 = NL + "\t\tlog.info(\"";
  protected final String TEXT_138 = " - Has inserted \" + nb_line_inserted_";
  protected final String TEXT_139 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_140 = NL + "\t  \tlog.info(\"";
  protected final String TEXT_141 = " - Has updated \" + nb_line_update_";
  protected final String TEXT_142 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_143 = NL + "\t  \tlog.info(\"";
  protected final String TEXT_144 = " - Has deleted \" + nb_line_deleted_";
  protected final String TEXT_145 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_146 = NL + "\t  \tlog.info(\"";
  protected final String TEXT_147 = " - Has inserted \" + nb_line_inserted_";
  protected final String TEXT_148 = " + \" records.\");" + NL + "\t  \tlog.info(\"";
  protected final String TEXT_149 = " - Has updated \" + nb_line_update_";
  protected final String TEXT_150 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_151 = NL + "\t  \tlog.info(\"";
  protected final String TEXT_152 = " - Has updated \" + nb_line_update_";
  protected final String TEXT_153 = " + \" records.\");" + NL + "\t  \tlog.info(\"";
  protected final String TEXT_154 = " - Has inserted \" + nb_line_inserted_";
  protected final String TEXT_155 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_156 = NL + "\t\tlog.info(\"";
  protected final String TEXT_157 = " - Has rejected \" + nb_line_rejected_";
  protected final String TEXT_158 = " + \"records.\");" + NL + "\t";
  protected final String TEXT_159 = NL + "\t\tlog.info(\"";
  protected final String TEXT_160 = " - Done.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    
	boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
	
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    
    
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
    } else { // dataAction equals "INSERT" or "UPDATE" or "DELETE" 
        
    stringBuffer.append(TEXT_14);
    if (  (rejectConnName==null) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
        
    stringBuffer.append(TEXT_15);
    	
					if("true".equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
					
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
					} else if (!useExistingConn &&!("").equals(commitEvery) && !("0").equals(commitEvery)) {
					
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
					} else {
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
					} 
					
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
            	    	}else if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
            	    	}
    stringBuffer.append(TEXT_46);
     if (isEnableDebug) { 
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_48);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    
                	}else {
                	
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
                	}
    stringBuffer.append(TEXT_57);
    
        }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
    }
    
    
	if(!useExistingConn){
	    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    
	    }
	    
    stringBuffer.append(TEXT_72);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    
	}
    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
	} else {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	}

    stringBuffer.append(TEXT_136);
    
	if(isLog4jEnabled){
		if (("INSERT").equals(dataAction)) { 
	
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
		} else if (("UPDATE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
		} else if (("DELETE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
		} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
		} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
	
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
		}
	    if (rejectConnName!=null) {
	
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		}
	
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
	}
	
    return stringBuffer.toString();
  }
}
