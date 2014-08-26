package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMsgBoxMainJava
{
  protected static String nl;
  public static synchronized TMsgBoxMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMsgBoxMainJava result = new TMsgBoxMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint messageIcon";
  protected final String TEXT_3 = " = javax.swing.JOptionPane.";
  protected final String TEXT_4 = ";" + NL + "\tString title";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\tString message";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "\tString result";
  protected final String TEXT_9 = " = null;   \t" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\tjavax.swing.JOptionPane.showMessageDialog(null, message";
  protected final String TEXT_11 = ", title";
  protected final String TEXT_12 = ", messageIcon";
  protected final String TEXT_13 = ");" + NL + "\t\tresult";
  protected final String TEXT_14 = " = String.valueOf(1);";
  protected final String TEXT_15 = NL + "\t\t//javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_16 = ", title";
  protected final String TEXT_17 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_18 = ", null, new String[] { \"OK\", \"Cancel\" }, null);" + NL + "\t\t//result";
  protected final String TEXT_19 = " = 1;" + NL + "\t\t" + NL + "\t\tresult";
  protected final String TEXT_20 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_21 = ", title";
  protected final String TEXT_22 = ", javax.swing.JOptionPane.OK_CANCEL_OPTION, messageIcon";
  protected final String TEXT_23 = ", null, new String[] { \"OK\", \"Cancel\" }, null));";
  protected final String TEXT_24 = NL + "\t\tresult";
  protected final String TEXT_25 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_26 = ", title";
  protected final String TEXT_27 = ", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, messageIcon";
  protected final String TEXT_28 = ", null, new String[] { \"Abort\", \"Retry\", \"Ignore\" }, null));";
  protected final String TEXT_29 = NL + "\t\tresult";
  protected final String TEXT_30 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_31 = ", title";
  protected final String TEXT_32 = ", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, messageIcon";
  protected final String TEXT_33 = ", null, new String[] { \"Yes\", \"No\", \"Cancel\" }, null));";
  protected final String TEXT_34 = NL + "\t\tresult";
  protected final String TEXT_35 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_36 = ", title";
  protected final String TEXT_37 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_38 = ", null, new String[] { \"Yes\", \"No\" }, null));";
  protected final String TEXT_39 = NL + "\t\tresult";
  protected final String TEXT_40 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_41 = ", title";
  protected final String TEXT_42 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_43 = ", null, new String[] { \"Retry\", \"Cancel\" }, null));";
  protected final String TEXT_44 = NL + "\t\tresult";
  protected final String TEXT_45 = " = javax.swing.JOptionPane.showInputDialog(null, ";
  protected final String TEXT_46 = " , title";
  protected final String TEXT_47 = ", messageIcon";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_50 = "_RESULT\", result";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	int button = Integer.parseInt(ElementParameterParser.getValue(node, "__BUTTONS__"));	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ICON__") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TITLE__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	switch(button) {
		case 0:
		// 0) OK

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			break;
		case 1:
		// 1) OK and Cancel

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
    
			break;
		case 2:
		// 2) Abort Retry Ignore

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			break;
		case 3:
		// 3) Yes No and Cancel

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
			break;
		case 4:
		// 4) Yes and No

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
			break;
		case 5:
		// 5) Retry and Cancel

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
			break;
		case 6:
		// 6) Question

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(node, "__QUESTION_LABEL__") );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
			break;
		default:
			//do nothing
			break;
	}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
