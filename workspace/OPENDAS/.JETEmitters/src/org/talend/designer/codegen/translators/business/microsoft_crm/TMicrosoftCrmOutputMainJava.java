package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputMainJava result = new TMicrosoftCrmOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "StringBuffer OperXml_";
  protected final String TEXT_3 = " = new StringBuffer();" + NL;
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = NL + "    \tOperXml_";
  protected final String TEXT_6 = ".append(\"<Create xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_7 = NL + "    \tOperXml_";
  protected final String TEXT_8 = ".append(\"<Update xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_9 = NL + "        OperXml_";
  protected final String TEXT_10 = ".append(\"\\n\");" + NL + "    \tOperXml_";
  protected final String TEXT_11 = ".append(\"<entity xsi:type=\\\"web:\");" + NL + "    \tOperXml_";
  protected final String TEXT_12 = ".append(\"";
  protected final String TEXT_13 = "\");" + NL + "    \tOperXml_";
  protected final String TEXT_14 = ".append(\"\\\" xmlns:web=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "    \tOperXml_";
  protected final String TEXT_15 = ".append(\"\\n\");" + NL + "    \t\t";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " != null ) { //";
  protected final String TEXT_20 = "   " + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_21 = ".append(\"<\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_22 = ".append(\"";
  protected final String TEXT_23 = "\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_24 = ".append(\">\");" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_25 = ".append(\"<![CDATA[\");";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_27 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = "));";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_32 = ".append(String.valueOf(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = "));";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_36 = ".append(\"]]>\");" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_37 = ".append(\"</\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_38 = ".append(\"";
  protected final String TEXT_39 = "\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_40 = ".append(\">\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_41 = ".append(\"\\n\");";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_43 = ".append(\"<\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_44 = ".append(\"";
  protected final String TEXT_45 = "\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_46 = ".append(\"id>\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_47 = ".append(";
  protected final String TEXT_48 = ".Id);" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_49 = ".append(\"</\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_50 = ".append(\"";
  protected final String TEXT_51 = "\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_52 = ".append(\"id>\");" + NL + "\t\t\t\t\t\tOperXml_";
  protected final String TEXT_53 = ".append(\"\\n\");";
  protected final String TEXT_54 = NL + "\t    \t\t} //";
  protected final String TEXT_55 = "  \t\t\t\t\t\t\t\t" + NL;
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = NL + "OperXml_";
  protected final String TEXT_58 = ".append(\"</entity>\");" + NL + "OperXml_";
  protected final String TEXT_59 = ".append(\"\\n\");" + NL + "OperXml_";
  protected final String TEXT_60 = ".append(\"</Create>\");" + NL + "com.microsoft.schemas.crm._2007.webservices.CreateDocument createDoc_";
  protected final String TEXT_61 = " =  com.microsoft.schemas.crm._2007.webservices.CreateDocument.Factory.parse(OperXml_";
  protected final String TEXT_62 = ".toString());" + NL + "service_";
  protected final String TEXT_63 = ".create(createDoc_";
  protected final String TEXT_64 = ", catd_";
  protected final String TEXT_65 = ", null, null);";
  protected final String TEXT_66 = NL + "OperXml_";
  protected final String TEXT_67 = ".append(\"</entity>\");" + NL + "OperXml_";
  protected final String TEXT_68 = ".append(\"\\n\");" + NL + "OperXml_";
  protected final String TEXT_69 = ".append(\"</Update>\");" + NL + "com.microsoft.schemas.crm._2007.webservices.UpdateDocument updateDoc_";
  protected final String TEXT_70 = " = com.microsoft.schemas.crm._2007.webservices.UpdateDocument.Factory.parse(OperXml_";
  protected final String TEXT_71 = ".toString());" + NL + "service_";
  protected final String TEXT_72 = ".update(updateDoc_";
  protected final String TEXT_73 = ",catd_";
  protected final String TEXT_74 = ",null,null);\t\t\t";
  protected final String TEXT_75 = NL + "    \t\t\t";
  protected final String TEXT_76 = NL + "\tOperXml_";
  protected final String TEXT_77 = ".append(\"<Delete xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "\tOperXml_";
  protected final String TEXT_78 = ".append(\"\\n\");" + NL + "\tOperXml_";
  protected final String TEXT_79 = ".append(\"<entityName>\");" + NL + "\tOperXml_";
  protected final String TEXT_80 = ".append(\"";
  protected final String TEXT_81 = "\");" + NL + "\tOperXml_";
  protected final String TEXT_82 = ".append(\"</entityName>\");" + NL + "\tOperXml_";
  protected final String TEXT_83 = ".append(\"\\n\");" + NL + "\tOperXml_";
  protected final String TEXT_84 = ".append(\"<id>\");" + NL + "\tOperXml_";
  protected final String TEXT_85 = ".append(";
  protected final String TEXT_86 = ".Id);" + NL + "\tOperXml_";
  protected final String TEXT_87 = ".append(\"</id>\\n\");" + NL + "\tOperXml_";
  protected final String TEXT_88 = ".append(\"</Delete>\");" + NL + "\tcom.microsoft.schemas.crm._2007.webservices.DeleteDocument deleteDoc_";
  protected final String TEXT_89 = " = com.microsoft.schemas.crm._2007.webservices.DeleteDocument.Factory.parse(OperXml_";
  protected final String TEXT_90 = ".toString());" + NL + "\tservice_";
  protected final String TEXT_91 = ".delete(deleteDoc_";
  protected final String TEXT_92 = ",catd_";
  protected final String TEXT_93 = ",null,null);" + NL;
  protected final String TEXT_94 = " \t " + NL + "\t\tnb_line_";
  protected final String TEXT_95 = "++; " + NL + "\t\t" + NL + "\t\t///////////////////////    \t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_1);
    
    String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityname)){
		entityname = customEntityname.replaceAll("\"","");
	}
    String action = ElementParameterParser.getValue(node,"__ACTION__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
        String cid = node.getUniqueName();

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
 if ("insert".equals(action) || "update".equals(action)) {//************

    stringBuffer.append(TEXT_4);
    
    if("insert".equals(action))	{

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
    }else if("update".equals(action))	{

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    }

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(entityname.toLowerCase());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

        			
    			for (int i = 0; i < sizeColumns; i++) {//5  			

    				IMetadataColumn column = columns.get(i);
    				
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					
					String entityMethodTemp = column.getLabel();
					String entityMethod = "";

    stringBuffer.append(TEXT_16);
    
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    
    				}
    				if(!"Id".equals(column.getLabel())){ 

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
         
    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_30);
    				
						} else {//others

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    				
						}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
					}else{

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(entityname.toLowerCase());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(entityname.toLowerCase());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
					}	

    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_54);
    
					} 

    stringBuffer.append(TEXT_55);
    
				}//5	

    stringBuffer.append(TEXT_56);
    
 if ("insert".equals(action)) {//#######

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	} else if ("update".equals(action)) {//#######

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    
  }//#######

    stringBuffer.append(TEXT_75);
    
	} else if ("delete".equals(action)) {//*************	

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(entityname.toLowerCase());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(conn.getName() );
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
    
  }//************

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
    		}//4
    	}//3
    }//2
}//1


    return stringBuffer.toString();
  }
}
