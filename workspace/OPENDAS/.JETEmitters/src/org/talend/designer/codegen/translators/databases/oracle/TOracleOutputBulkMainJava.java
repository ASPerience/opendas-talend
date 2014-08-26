package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TOracleOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TOracleOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputBulkMainJava result = new TOracleOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_4 = NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_5 = "\t\t" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_6 = ".write(OUT_FIELDS_ENCLOSURE_LEFT_";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_8 = NL + "    \t\t\t\t\t\tout";
  protected final String TEXT_9 = ".write(" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\"<startlob>\" +" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = "    \t\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tFormatterUtils.format_Date_Locale(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ", \"";
  protected final String TEXT_16 = "\")";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_18 = " " + NL + "                                      FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_19 = "), ";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ")                                  ";
  protected final String TEXT_22 = " " + NL + "                                      FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = "), ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ")                                           ";
  protected final String TEXT_27 = " " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\t new String(((byte[])(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ")))";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ")";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t+\"<endlob>\"";
  protected final String TEXT_37 = "   " + NL + "\t\t\t\t\t\t);";
  protected final String TEXT_38 = "\t\t" + NL + "\t\t\t\t\t\tout";
  protected final String TEXT_39 = ".write(OUT_FIELDS_ENCLOSURE_RIGHT_";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_43 = ".write(OUT_DELIM_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_46 = NL + "    \t\t\tout";
  protected final String TEXT_47 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_48 = ");" + NL + "    \t\t\t";
  protected final String TEXT_49 = NL + "    \t\t\tout";
  protected final String TEXT_50 = ".write(OUT_DELIM_ROWSEP_WITH_LOB_";
  protected final String TEXT_51 = ");" + NL + "    \t\t\t";
  protected final String TEXT_52 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_53 = "++;";
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

boolean hasLobflag=false;

if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	
    	String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    	boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
    	String locale = ElementParameterParser.getValue(node, "__DATE_LOCALE__");
    	boolean useFieldsEnclosure = ("true").equals(ElementParameterParser.getValue(node,"__USE_FIELDS_ENCLOSURE__"));
    	
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String dbType = columns.get(i).getType();
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
					
    				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_3);
    
    				} 
    				
    stringBuffer.append(TEXT_4);
    
					if (useFieldsEnclosure && !( "BLOB".equals (dbType) || "CLOB".equals(dbType))) {
					
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
					}
					
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
     if ("BLOB".equals (dbType) || "CLOB".equals(dbType)) {
						hasLobflag=true;
					
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    					if(("DEFAULT").equals(locale)){
							locale = java.util.Locale.getDefault().toString();
						}else if(("CUSTOM").equals(locale)){
							locale = ElementParameterParser.getValue(node, "__CUSTOM_DATE_LOCALE__");
							locale = locale.substring(1,locale.length()-1);
						}else{
							locale = locale;
						}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(locale);
    stringBuffer.append(TEXT_16);
    
					}  else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {  										
							
    stringBuffer.append(TEXT_17);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_21);
     } else { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY ) {					

    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_32);
    					
					} else  {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    				
					}

     
					if ("BLOB".equals (dbType) || "CLOB".equals(dbType)) {
    stringBuffer.append(TEXT_36);
    
					}

    stringBuffer.append(TEXT_37);
    	
					if (useFieldsEnclosure && !( "BLOB".equals (dbType) || "CLOB".equals(dbType))) {
					
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_41);
    
    				} 
					if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
    				}
    			}
    			
    stringBuffer.append(TEXT_45);
     if (!hasLobflag) {
    			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
    			}else { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
    		}
    	}
    }
}

    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
