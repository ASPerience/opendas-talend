package org.talend.designer.codegen.translators.databases.oledb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TOleDbOutputEndJava
{
  protected static String nl;
  public static synchronized TOleDbOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOleDbOutputEndJava result = new TOleDbOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    conn_";
  protected final String TEXT_3 = ".invoke(\"Close\");" + NL + "" + NL + "\tnb_line_deleted_";
  protected final String TEXT_4 = "=nb_line_deleted_";
  protected final String TEXT_5 = "+ deletedCount_";
  protected final String TEXT_6 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_7 = "=nb_line_update_";
  protected final String TEXT_8 = " + updatedCount_";
  protected final String TEXT_9 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_10 = "=nb_line_inserted_";
  protected final String TEXT_11 = " + insertedCount_";
  protected final String TEXT_12 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_13 = "=nb_line_rejected_";
  protected final String TEXT_14 = " + rejectedCount_";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "\tif (globalMap.get(\"";
  protected final String TEXT_17 = "_NB_LINE\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_18 = "_NB_LINE\",nb_line_";
  protected final String TEXT_19 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_20 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_21 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_22 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_23 = "_NB_LINE_UPDATED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_24 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_25 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_26 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_27 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_28 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_29 = "_NB_LINE_INSERTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_30 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_31 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_32 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_33 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_34 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_35 = "_NB_LINE_DELETED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_37 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_38 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_39 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_40 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_41 = "_NB_LINE_REJECTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_42 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_43 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_44 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_45 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_46 = ");" + NL + "    }";
  protected final String TEXT_47 = NL + "    globalMap.put(\"";
  protected final String TEXT_48 = "_NB_LINE\",nb_line_";
  protected final String TEXT_49 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_51 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_52 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_53 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_54 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_55 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_56 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_57 = ");" + NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
    	
    	
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
	} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
	}

    return stringBuffer.toString();
  }
}
