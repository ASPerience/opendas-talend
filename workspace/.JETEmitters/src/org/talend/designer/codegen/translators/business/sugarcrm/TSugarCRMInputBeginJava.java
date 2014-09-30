package org.talend.designer.codegen.translators.business.sugarcrm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSugarCRMInputBeginJava
{
  protected static String nl;
  public static synchronized TSugarCRMInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSugarCRMInputBeginJava result = new TSugarCRMInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "////////////////////////////        " + NL + "        " + NL + "         \tclass Util_";
  protected final String TEXT_3 = NL + "            {" + NL + "                    public String getFieldbyOrder(int index, String[] filedArr, org.talend.sugarws.Name_value[] nameValue) {" + NL + "           \t\t\t\t" + NL + "" + NL + "           \t\t\t\tString fieldName = filedArr[index].trim();" + NL + "           \t\t\t\tfor (int j = 0; j < nameValue.length; j++) {" + NL + "                    \t\tif(fieldName.equals(nameValue[j].getName()))" + NL + "                    \t\t{" + NL + "                    \t\t\treturn \tnameValue[j].getValue();" + NL + "                    \t\t}" + NL + "                          }" + NL + "                        return \"\";                       " + NL + "                    }                   " + NL + "            }        " + NL + "        " + NL + "        " + NL + "        int nb_line_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = NL + "        String modulename_";
  protected final String TEXT_6 = " =  ";
  protected final String TEXT_7 = "+\"_\"+";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "        String modulename_";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\";";
  protected final String TEXT_12 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = "; ";
  protected final String TEXT_18 = NL + "        " + NL + "        org.talend.SugarManagement.SugarManagement sugarManagement_";
  protected final String TEXT_19 = " = new org.talend.SugarManagement.SugarManagementImpl(";
  protected final String TEXT_20 = ", decryptedPassword_";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ", \"sugarcrm\",\"5.2.0\");" + NL + "        sugarManagement_";
  protected final String TEXT_23 = ".login();" + NL + "        " + NL + "        String[] filedArr_";
  protected final String TEXT_24 = " = new String[]{";
  protected final String TEXT_25 = NL + "\t\t\"";
  protected final String TEXT_26 = "\",";
  protected final String TEXT_27 = "      " + NL + "        };" + NL + "        " + NL + "        String condition_";
  protected final String TEXT_28 = " = \"\";" + NL + "        " + NL + "        Util_";
  protected final String TEXT_29 = " util_";
  protected final String TEXT_30 = " = new Util_";
  protected final String TEXT_31 = "();" + NL + "        " + NL + "" + NL + "       ";
  protected final String TEXT_32 = "   condition_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = "; ";
  protected final String TEXT_35 = " " + NL + "         " + NL + "        org.talend.sugarws.Get_entry_list_result getEntryListResult_";
  protected final String TEXT_36 = " = sugarManagement_";
  protected final String TEXT_37 = ".getRecordswithQuery(modulename_";
  protected final String TEXT_38 = ", condition_";
  protected final String TEXT_39 = ", filedArr_";
  protected final String TEXT_40 = ", 0, 100); " + NL + "" + NL + "\t\tif(getEntryListResult_";
  protected final String TEXT_41 = ".getResult_count() < 0 ){" + NL + "\t\t\tSystem.err.println(\"Error Code:\"+getEntryListResult_";
  protected final String TEXT_42 = ".getError().getNumber());" + NL + "\t\t\tSystem.err.println(getEntryListResult_";
  protected final String TEXT_43 = ".getError().getName());" + NL + "\t\t\tSystem.err.println(getEntryListResult_";
  protected final String TEXT_44 = ".getError().getDescription());" + NL + "\t\t}" + NL + "        // read the record from remote, one time 100 records." + NL + "        while (getEntryListResult_";
  protected final String TEXT_45 = ".getResult_count() > 0) {" + NL + "            org.talend.sugarws.Entry_value[] entry_value_";
  protected final String TEXT_46 = " = getEntryListResult_";
  protected final String TEXT_47 = ".getEntry_list();" + NL + "            // get every record" + NL + "            for (int i_";
  protected final String TEXT_48 = " = 0; i_";
  protected final String TEXT_49 = " < entry_value_";
  protected final String TEXT_50 = ".length; i_";
  protected final String TEXT_51 = "++) {" + NL + "                org.talend.sugarws.Name_value[] nameValue_";
  protected final String TEXT_52 = " = entry_value_";
  protected final String TEXT_53 = "[i_";
  protected final String TEXT_54 = "].getName_value_list(); " + NL + "        \t\tnb_line_";
  protected final String TEXT_55 = "++;" + NL + "                " + NL + "//////////       " + NL;
  protected final String TEXT_56 = NL + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\tString crmReturnValue_";
  protected final String TEXT_58 = ";";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t" + NL + "\t\t\tcrmReturnValue_";
  protected final String TEXT_60 = " = util_";
  protected final String TEXT_61 = ".getFieldbyOrder(";
  protected final String TEXT_62 = ", filedArr_";
  protected final String TEXT_63 = ", nameValue_";
  protected final String TEXT_64 = ");" + NL + "\t\t\tif(!\"\".equals(crmReturnValue_";
  protected final String TEXT_65 = ")){\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = crmReturnValue_";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = NL + "\t\t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = ParserUtils.parseTo_Date(crmReturnValue_";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = crmReturnValue_";
  protected final String TEXT_78 = ".getBytes();" + NL + "\t";
  protected final String TEXT_79 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = ParserUtils.parseTo_";
  protected final String TEXT_82 = "(crmReturnValue_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "      \t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_93 = " " + NL + "////////////////////////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");
	String packageName = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_PACKAGE__");
	String customModuleName = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	
	String username = ElementParameterParser.getValue(node, "__USER__");

	
	String condition = ElementParameterParser.getValue(node, "__CONDITION__");

    stringBuffer.append(TEXT_1);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {    
   

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    if("CustomModule".equals(modulename)){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(customModuleName);
    stringBuffer.append(TEXT_8);
    }else{
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_11);
    }
    
        String passwordFieldName = "__PASS__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
	//get the select fields from schema
    List<IMetadataColumn> columnsFields=metadata.getListColumns();

    for (int i=0;i < columnsFields.size();i++) {//4
		IMetadataColumn column=columnsFields.get(i);

    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
	}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
     if (condition!=null && condition.trim().length()>0) { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(condition );
    stringBuffer.append(TEXT_34);
     } 
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_56);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_74);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
					} else  { //other

    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
					}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_87);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_93);
    
  }
}

    return stringBuffer.toString();
  }
}
