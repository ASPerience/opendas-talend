package org.talend.designer.codegen.translators.databases.as400;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TAS400OutputEndJava
{
  protected static String nl;
  public static synchronized TAS400OutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAS400OutputEndJava result = new TAS400OutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        if(pstmtUpdate_";
  protected final String TEXT_2 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_3 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_4 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_5 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_6 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_7 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_8 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_9 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_10 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_11 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_12 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_13 = "                " + NL + "\tif (pstmt_";
  protected final String TEXT_14 = " != null && batchSizeCounter_";
  protected final String TEXT_15 = " >0) { " + NL + "    try {";
  protected final String TEXT_16 = NL + "            pstmt_";
  protected final String TEXT_17 = ".executeBatch();";
  protected final String TEXT_18 = NL + "            int countSum_";
  protected final String TEXT_19 = " = 0;" + NL + "            for(int countEach_";
  protected final String TEXT_20 = ": pstmt_";
  protected final String TEXT_21 = ".executeBatch()) {" + NL + "                countSum_";
  protected final String TEXT_22 = " += (countEach_";
  protected final String TEXT_23 = " < 0 ? 0 : countEach_";
  protected final String TEXT_24 = ");" + NL + "            }";
  protected final String TEXT_25 = "                          " + NL + "                updatedCount_";
  protected final String TEXT_26 = " += countSum_";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "                deletedCount_";
  protected final String TEXT_29 = " += countSum_";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "    }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_32 = "){";
  protected final String TEXT_33 = NL + "            throw(e_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = "                          " + NL + "                int countSum_";
  protected final String TEXT_36 = " = 0;" + NL + "                for(int countEach_";
  protected final String TEXT_37 = ": e_";
  protected final String TEXT_38 = ".getUpdateCounts()) {" + NL + "                    countSum_";
  protected final String TEXT_39 = " += (countEach_";
  protected final String TEXT_40 = " < 0 ? 0 : countEach_";
  protected final String TEXT_41 = ");" + NL + "                }";
  protected final String TEXT_42 = "                          " + NL + "                updatedCount_";
  protected final String TEXT_43 = " += countSum_";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "                deletedCount_";
  protected final String TEXT_46 = " += countSum_";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "            System.out.println(e_";
  protected final String TEXT_49 = ".getMessage());";
  protected final String TEXT_50 = NL + "    }                                             ";
  protected final String TEXT_51 = NL + "            tmp_batchUpdateCount_";
  protected final String TEXT_52 = " = pstmt_";
  protected final String TEXT_53 = ".getUpdateCount();" + NL + "            insertedCount_";
  protected final String TEXT_54 = "+= (tmp_batchUpdateCount_";
  protected final String TEXT_55 = " >0 ? tmp_batchUpdateCount_";
  protected final String TEXT_56 = ":0);";
  protected final String TEXT_57 = " " + NL + "    }";
  protected final String TEXT_58 = "   " + NL + "                " + NL + "        if(pstmt_";
  protected final String TEXT_59 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_60 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_61 = NL + "    ";
  protected final String TEXT_62 = NL + "                if(commitCounter_";
  protected final String TEXT_63 = " > 0) {" + NL + "                    conn_";
  protected final String TEXT_64 = ".commit();" + NL + "                }";
  protected final String TEXT_65 = "  " + NL + "        conn_";
  protected final String TEXT_66 = " .close();" + NL + "        resourceMap.put(\"finish_";
  protected final String TEXT_67 = "\", true);";
  protected final String TEXT_68 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_69 = "=nb_line_deleted_";
  protected final String TEXT_70 = "+ deletedCount_";
  protected final String TEXT_71 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_72 = "=nb_line_update_";
  protected final String TEXT_73 = " + updatedCount_";
  protected final String TEXT_74 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_75 = "=nb_line_inserted_";
  protected final String TEXT_76 = " + insertedCount_";
  protected final String TEXT_77 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_78 = "=nb_line_rejected_";
  protected final String TEXT_79 = " + rejectedCount_";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = NL + "\tif (globalMap.get(\"";
  protected final String TEXT_82 = "_NB_LINE\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_83 = "_NB_LINE\",nb_line_";
  protected final String TEXT_84 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_85 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_86 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_87 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_88 = "_NB_LINE_UPDATED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_89 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_90 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_91 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_92 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_93 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_94 = "_NB_LINE_INSERTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_95 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_96 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_97 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_98 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_99 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_100 = "_NB_LINE_DELETED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_101 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_102 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_103 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_104 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_105 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_106 = "_NB_LINE_REJECTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_107 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_108 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_109 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_110 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_111 = ");" + NL + "    }";
  protected final String TEXT_112 = NL + "    globalMap.put(\"";
  protected final String TEXT_113 = "_NB_LINE\",nb_line_";
  protected final String TEXT_114 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_115 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_116 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_117 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_118 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_119 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_120 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_121 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_122 = ");" + NL + "    ";
  protected final String TEXT_123 = NL;
  protected final String TEXT_124 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
	String useCommitControl = ElementParameterParser.getValue(node,"__USE_COMMIT_CONTROL__");
    
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
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
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
    } else {
        
    
      if ((rejectConnName==null && useBatchSize) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
    	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
        if (("INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
        }else{
        
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
            if (("UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
            }else if (("DELETE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            }
        }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(("true").equals(dieOnError)) {
        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
        }else {
        
    
            if (("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) {
            
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
    
            }
            if (("UPDATE").equals(dataAction)) {
            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
            }else if (("DELETE").equals(dataAction)) {
            
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
            }
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
        }
        
    stringBuffer.append(TEXT_50);
    
    if (("INSERT").equals(dataAction)) {
    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
    }
    
    stringBuffer.append(TEXT_57);
    
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
    }   
    
    stringBuffer.append(TEXT_61);
    
    if(!("true").equals(useExistingConn)) {
        if(("true").equals(useCommitControl)) {
            if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
            }
        }
        
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
    }
    
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
	} else {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
