package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TLDAPOutputMainJava
{
  protected static String nl;
  public static synchronized TLDAPOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPOutputMainJava result = new TLDAPOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = " = null;            ";
  protected final String TEXT_4 = NL + "\t\t\t\t\tjavax.naming.directory.Attributes entry_";
  protected final String TEXT_5 = " = new javax.naming.directory.BasicAttributes(true);" + NL + "\t\t\t\t\twhetherReject_";
  protected final String TEXT_6 = " = false;" + NL + "\t\t\t\t\tString dn_";
  protected final String TEXT_7 = " = String.valueOf(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ").trim();";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " != null){";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t\tentry_";
  protected final String TEXT_14 = ".put(\"";
  protected final String TEXT_15 = "\",";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t\t\tString incomingColumn_";
  protected final String TEXT_19 = " = new SimpleDateFormat(";
  protected final String TEXT_20 = ").format(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t\t\t    \tif(incomingColumn_";
  protected final String TEXT_23 = ".trim().indexOf(";
  protected final String TEXT_24 = ")>0){" + NL + "\t\t\t\t\t\t\t    \t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_25 = " = new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_26 = "\");" + NL + "\t\t\t\t\t\t\t    \t\tfor(String value_";
  protected final String TEXT_27 = " : incomingColumn_";
  protected final String TEXT_28 = ".trim().split(";
  protected final String TEXT_29 = ")){" + NL + "\t\t\t\t\t\t\t    \t\t\tattr_";
  protected final String TEXT_30 = ".add(value_";
  protected final String TEXT_31 = ");    \t\t" + NL + "\t\t\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t\t\t    \t\tentry_";
  protected final String TEXT_32 = ".put(attr_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\t\t\t    \t}else{" + NL + "\t\t\t\t\t\t\t    \t\tentry_";
  protected final String TEXT_34 = ".put(\"";
  protected final String TEXT_35 = "\",incomingColumn_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t\t\t    \t}";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t\t\t\tString incomingColumn_";
  protected final String TEXT_38 = " = String.valueOf(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\t\t\t    \tif(incomingColumn_";
  protected final String TEXT_41 = ".trim().indexOf(";
  protected final String TEXT_42 = ")>0){" + NL + "\t\t\t\t\t\t\t    \t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_43 = " = new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_44 = "\");" + NL + "\t\t\t\t\t\t\t    \t\tfor(String value_";
  protected final String TEXT_45 = " : incomingColumn_";
  protected final String TEXT_46 = ".trim().split(";
  protected final String TEXT_47 = ")){" + NL + "\t\t\t\t\t\t\t    \t\t\tattr_";
  protected final String TEXT_48 = ".add(value_";
  protected final String TEXT_49 = ");    \t\t" + NL + "\t\t\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t\t\t    \t\tentry_";
  protected final String TEXT_50 = ".put(attr_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t\t\t\t    \t}else{" + NL + "\t\t\t\t\t\t\t    \t\tentry_";
  protected final String TEXT_52 = ".put(\"";
  protected final String TEXT_53 = "\",incomingColumn_";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t\t\t\t    \t}";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t    }";
  protected final String TEXT_56 = NL + "\ttry{";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\tctx_";
  protected final String TEXT_58 = ".modifyAttributes(dn_";
  protected final String TEXT_59 = ", javax.naming.directory.DirContext.ADD_ATTRIBUTE, entry_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = " " + NL + "\t\t\t\t\t\tctx_";
  protected final String TEXT_62 = ".createSubcontext(dn_";
  protected final String TEXT_63 = ", entry_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\tList<javax.naming.directory.ModificationItem> mfItem_";
  protected final String TEXT_66 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\tList<javax.naming.directory.Attribute> forUpate";
  protected final String TEXT_67 = " = new java.util.ArrayList();";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\t    \tfor(String value_";
  protected final String TEXT_69 = " : ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ".trim().split(";
  protected final String TEXT_72 = ")){" + NL + "\t\t\t\t\t\t\t    \t\t\tforUpate";
  protected final String TEXT_73 = ".add(new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_74 = "\", value_";
  protected final String TEXT_75 = "));" + NL + "\t\t\t\t\t\t\t\t    \t}";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t    \t\t\tforUpate";
  protected final String TEXT_77 = ".add(new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_78 = "\", ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = "));";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t  \t\tforUpate";
  protected final String TEXT_82 = ".add(new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_83 = "\"));";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\t  \t\tfor (javax.naming.directory.Attribute attrForUpate_";
  protected final String TEXT_85 = " : forUpate";
  protected final String TEXT_86 = ") {" + NL + "\t\t\t\t\t\t\t  \t\t\tmfItem_";
  protected final String TEXT_87 = ".add(new javax.naming.directory.ModificationItem(javax.naming.directory.DirContext.ADD_ATTRIBUTE, attrForUpate_";
  protected final String TEXT_88 = "));" + NL + "\t\t\t\t\t\t\t  \t\t}";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\t    \tfor (javax.naming.directory.Attribute attrForUpate_";
  protected final String TEXT_90 = " : forUpate";
  protected final String TEXT_91 = ") {" + NL + "\t\t\t\t\t\t\t  \t\t\tmfItem_";
  protected final String TEXT_92 = ".add(new javax.naming.directory.ModificationItem(javax.naming.directory.DirContext.REPLACE_ATTRIBUTE, attrForUpate_";
  protected final String TEXT_93 = "));" + NL + "\t\t\t\t\t\t\t  \t\t}";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\t\t\t\tfor (javax.naming.directory.Attribute attrForUpate_";
  protected final String TEXT_95 = " : forUpate";
  protected final String TEXT_96 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\tmfItem_";
  protected final String TEXT_97 = ".add(new javax.naming.directory.ModificationItem(javax.naming.directory.DirContext.REMOVE_ATTRIBUTE, attrForUpate_";
  protected final String TEXT_98 = "));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\t  \t  for (javax.naming.directory.Attribute attrDelete_";
  protected final String TEXT_100 = " : forUpate";
  protected final String TEXT_101 = ") {" + NL + "\t\t\t\t\t\t\t  \t\t\tmfItem_";
  protected final String TEXT_102 = ".add(new javax.naming.directory.ModificationItem(javax.naming.directory.DirContext.REMOVE_ATTRIBUTE, attrDelete_";
  protected final String TEXT_103 = "));" + NL + "\t\t\t\t\t\t\t  \t\t}";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\t\t\tforUpate";
  protected final String TEXT_105 = ".clear();";
  protected final String TEXT_106 = NL + "  \t\t\t\t\t\t\tctx_";
  protected final String TEXT_107 = ".modifyAttributes(dn_";
  protected final String TEXT_108 = ",mfItem_";
  protected final String TEXT_109 = ".toArray(new javax.naming.directory.ModificationItem[0]));";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\tctx_";
  protected final String TEXT_111 = ".modifyAttributes(dn_";
  protected final String TEXT_112 = ", javax.naming.directory.DirContext.REPLACE_ATTRIBUTE, entry_";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\tctx_";
  protected final String TEXT_115 = ".destroySubcontext(dn_";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\tboolean found = false;" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tctx_";
  protected final String TEXT_118 = ".getAttributes(dn_";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t\t\t\tfound = true;" + NL + "\t\t\t\t\t\t}catch(javax.naming.NameNotFoundException nfEx_";
  protected final String TEXT_120 = ")" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\tctx_";
  protected final String TEXT_121 = ".createSubcontext(dn_";
  protected final String TEXT_122 = ", entry_";
  protected final String TEXT_123 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(found)" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\tctx_";
  protected final String TEXT_124 = ".modifyAttributes(dn_";
  protected final String TEXT_125 = ", javax.naming.directory.DirContext.REPLACE_ATTRIBUTE, entry_";
  protected final String TEXT_126 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_127 = NL + "\t}catch(Exception e){" + NL + "        whetherReject_";
  protected final String TEXT_128 = " = true;";
  protected final String TEXT_129 = NL + "        throw(e);";
  protected final String TEXT_130 = NL + "        ";
  protected final String TEXT_131 = " = new ";
  protected final String TEXT_132 = "Struct();";
  protected final String TEXT_133 = NL + "        ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = ";";
  protected final String TEXT_138 = NL + "                ";
  protected final String TEXT_139 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_140 = ";";
  protected final String TEXT_141 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_142 = NL + "    }";
  protected final String TEXT_143 = NL + "        if(!whetherReject_";
  protected final String TEXT_144 = ") {";
  protected final String TEXT_145 = NL + "\t\t\t";
  protected final String TEXT_146 = " = new ";
  protected final String TEXT_147 = "Struct();";
  protected final String TEXT_148 = NL + "            ";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = ";";
  protected final String TEXT_153 = NL + "        }";
  protected final String TEXT_154 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String insertMode =ElementParameterParser.getValue(node, "__INSERT_MODE__");
	String separatorText=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String dnColumnName = ElementParameterParser.getValue(node, "__DN_COLUMN_NAME__");
	boolean useAttributeOptions = "true".equals(ElementParameterParser.getValue(node, "__USE_ATTRIBUTE_OPTIONS__"));
	List<Map<String, String>> attributeOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ATTRIBUTE_OPTIONS__");
	String separator = separatorText;
	if(("\"|\"").equals(separatorText)){
		separator="\"\\\\|\"";
	}
	
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();	    
	}
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
          }
    }
    
	String cid = node.getUniqueName();
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columnList = metadata.getListColumns();
		
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for(IConnection conn:conns){
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
     			String firstConnName = conn.getName();
    			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {	

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dnColumnName);
    stringBuffer.append(TEXT_9);
    
					for(IMetadataColumn column:columnList){
						String columnType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						if (dnColumnName.equals(column.getLabel().trim())) {
							continue;
						}
						if(!("DELETE").equals(insertMode) && !("UPDATA").equals(insertMode)){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    
								if("byte[]".equals(columnType)){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_17);
    
								}else if("java.util.Date".equals(columnType)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(separatorText);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(separator);
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
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
								}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(separatorText);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
								}

    stringBuffer.append(TEXT_55);
    
						}
					}

    stringBuffer.append(TEXT_56);
    
					if(("ADD").equals(insertMode)){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
					} else if(("INSERT").equals(insertMode)){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
					}else if(("UPDATA").equals(insertMode)){
						if(useAttributeOptions && attributeOptions.size() > 0){
						//7631: tLDAPOutput: Add a attributes options parameter 

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
						  	for (int i=0; i<attributeOptions.size(); i++) {
						  		Map<String, String> row  = attributeOptions.get(i);
						  		String option = row.get("ATTRIBUTE_OPTION").trim();
						  		String name = row.get("ATTRIBUTE_NAME").trim();
						  		String columnType = "";
						  		for(IMetadataColumn column : columnList){
						  			if(column.getLabel().equals(name)){
										columnType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						  			}
								}
					  			if (!"REMOVE_ATTRIBUTE".equals(option)) {
					  				if("String".equals(columnType)){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
									}else{

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    
									}
  								} else {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_83);
    
  								}
  								if ("ADD".equals(option)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
  								} else if ("REPLACE".equals(option)) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
  								} else if ("REMOVE_VALUE".equals(option)){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
  								} else {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
  								}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
  							}

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
  	//7631
						}else{

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
						}
					}else if(("DELETE").equals(insertMode)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
					}else if(("INSERT_UPDATA").equals(insertMode)){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
					}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
        if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_129);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_132);
    
                for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_137);
    
                }

    stringBuffer.append(TEXT_138);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_140);
    
            } else {

    stringBuffer.append(TEXT_141);
    
            }
        }

    stringBuffer.append(TEXT_142);
    
    	if(outgoingConns != null && outgoingConns.size() > 0) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
            for(IConnection outgoingConn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_147);
    
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
     
                        }
                    }
                }
            }

    stringBuffer.append(TEXT_153);
    
    }
				}
			}
		}
	}

    stringBuffer.append(TEXT_154);
    return stringBuffer.toString();
  }
}
