package org.talend.designer.codegen.translators.data_quality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

public class TSchemaComplianceCheckBeginJava
{
  protected static String nl;
  public static synchronized TSchemaComplianceCheckBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSchemaComplianceCheckBeginJava result = new TSchemaComplianceCheckBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        try {" + NL + "          if (" + NL + "      \t";
  protected final String TEXT_2 = NL + "        \t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null  && (!\"\".equals(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ")) ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = NL + "            ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " != null";
  protected final String TEXT_11 = " " + NL + "            true";
  protected final String TEXT_12 = "        " + NL + "          ) {" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tif(!\"true\".equals(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ") || !\"false\".equals(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ")){" + NL + "\t\t\t\t\tthrow new Exception(\"Wrong Boolean type!\");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tif(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".toCharArray().length != 1){" + NL + "\t\t\t\t\tthrow new Exception(\"Wrong Character type!\");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t";
  protected final String TEXT_22 = " tester_";
  protected final String TEXT_23 = " = new ";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "        \t\t";
  protected final String TEXT_28 = " tester_";
  protected final String TEXT_29 = " = new ";
  protected final String TEXT_30 = "();" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "        \t\t";
  protected final String TEXT_32 = " tester_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ".valueOf(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "          }" + NL + "             " + NL + "        } catch(Exception e) {" + NL + "          ifPassedThrough = false;" + NL + "          errorCodeThrough += 2;" + NL + "          errorMessageThrough += \"|wrong type\";" + NL + "        }";
  protected final String TEXT_38 = NL + "        if (";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " != null){" + NL + "\t\t  handleBigdecimalPrecision((";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ").toPlainString(), ";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ");" + NL + "          ifPassedThrough = ifPassedThrough?ifPassed:false;" + NL + "          errorCodeThrough += errorCode;" + NL + "          errorMessageThrough += errorMessage;" + NL + "" + NL + "        }";
  protected final String TEXT_45 = NL + "        if (";
  protected final String TEXT_46 = NL + "          ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " != null  && (!\"\".equals(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ")) ";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = NL + "          ";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = " != null";
  protected final String TEXT_55 = " " + NL + "          true";
  protected final String TEXT_56 = "        " + NL + "        ) {";
  protected final String TEXT_57 = NL + "              if( ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ".length() > ";
  protected final String TEXT_60 = " )";
  protected final String TEXT_61 = NL + "                ";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ".substring(0, ";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "                tmpContentThrough = String.valueOf(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = "               " + NL + "                tmpContentThrough = ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".toString();";
  protected final String TEXT_73 = NL + "              " + NL + "              if (tmpContentThrough.length() > ";
  protected final String TEXT_74 = ")";
  protected final String TEXT_75 = NL + "                ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ".substring(0, ";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = "                   " + NL + "              if (";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ".length() > ";
  protected final String TEXT_84 = ") {" + NL + "                ifPassedThrough = false;" + NL + "                errorCodeThrough += 8;" + NL + "              errorMessageThrough += \"|exceed max length\";" + NL + "              }";
  protected final String TEXT_85 = NL + "                tmpContentThrough = String.valueOf(";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = ");              ";
  protected final String TEXT_88 = "               " + NL + "                tmpContentThrough = ";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ".toString();  ";
  protected final String TEXT_91 = NL + "              " + NL + "              if (tmpContentThrough.length() > ";
  protected final String TEXT_92 = ") {" + NL + "                ifPassedThrough = false;" + NL + "                errorCodeThrough += 8;" + NL + "                errorMessageThrough += \"|exceed max length\";" + NL + "              }";
  protected final String TEXT_93 = NL + "        }";
  protected final String TEXT_94 = "  " + NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 2;" + NL + "        errorMessageThrough += \"|Date format not defined\";";
  protected final String TEXT_95 = NL + "          try{                    " + NL + "            if (";
  protected final String TEXT_96 = NL + "              ";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " != null  && (!\"\".equals(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ")) ";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = NL + "              ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " != null";
  protected final String TEXT_105 = " " + NL + "              true";
  protected final String TEXT_106 = NL + "             ) {";
  protected final String TEXT_107 = "            " + NL + "                 if (!TalendDate.isDate((";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ").toString(), ";
  protected final String TEXT_110 = "))" + NL + "                   throw new IllegalArgumentException(\"Data format not matches\");";
  protected final String TEXT_111 = NL + "                 FastDateParser.getInstance(";
  protected final String TEXT_112 = ", false).parse(";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = ");            ";
  protected final String TEXT_115 = NL + "             }" + NL + "          } catch(Exception e){" + NL + "            ifPassedThrough = false;" + NL + "            errorCodeThrough += 2;" + NL + "            errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";" + NL + "          }";
  protected final String TEXT_116 = NL + "            ifPassedThrough = false;" + NL + "            errorCodeThrough += 2;" + NL + "            errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";";
  protected final String TEXT_117 = NL + "          ifPassedThrough = false;" + NL + "          errorCodeThrough += 2;" + NL + "          errorMessageThrough += \"|The TYPE of inputting data is error. (one of OBJECT, STRING, DATE)\";";
  protected final String TEXT_118 = NL + "\t\t        // validate nullable (empty as null)" + NL + "\t\t        if ((";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " == null) || (\"\".equals(";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = "))) {";
  protected final String TEXT_123 = NL + "\t\t        // validate nullable" + NL + "\t\t        if (";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " == null) {";
  protected final String TEXT_126 = NL + "\t\t        // validate nullable (empty as null)" + NL + "\t\t        if ((";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " == null) || (\"\".equals(";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = "))) {";
  protected final String TEXT_131 = NL + "\t\t        // validate nullable (empty as null)" + NL + "\t\t        if ((";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " == null) || (\"\".equals(";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = "))) {";
  protected final String TEXT_136 = NL + "\t\t        // validate nullable" + NL + "\t\t        if (";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " == null) {";
  protected final String TEXT_139 = NL + "\t\tifPassedThrough = false;" + NL + "\t\terrorCodeThrough += 4;" + NL + "\t\terrorMessageThrough += \"|empty or null\";                        " + NL + "        }";
  protected final String TEXT_140 = NL + "class RowSetValueUtil_";
  protected final String TEXT_141 = " {" + NL + "" + NL + "  boolean ifPassedThrough = true;" + NL + "  int errorCodeThrough = 0;" + NL + "  String errorMessageThrough = \"\";" + NL + "  int resultErrorCodeThrough = 0;" + NL + "  String resultErrorMessageThrough = \"\";" + NL + "  String tmpContentThrough = null;" + NL + "  " + NL + "\tboolean ifPassed = true;" + NL + "\tint errorCode = 0;" + NL + "\tString errorMessage = \"\";" + NL + "\tvoid handleBigdecimalPrecision(String data, int iPrecision, int maxLength){" + NL + "\t\t//number of digits before the decimal point(ignoring frontend zeroes)" + NL + "\t\tint len1 = 0;" + NL + "\t\tint len2 = 0;" + NL + "\t\tifPassed = true;" + NL + "\t\terrorCode = 0;" + NL + "\t\terrorMessage = \"\";" + NL + "\t\tif(data.startsWith(\"-\")){" + NL + "\t\t\tdata = data.substring(1);" + NL + "\t\t}" + NL + "\t\tdata = org.apache.commons.lang.StringUtils.stripStart(data, \"0\");" + NL + "\t\t  " + NL + "\t\tif(data.indexOf(\".\") >= 0){" + NL + "\t\t\tlen1 = data.indexOf(\".\");    " + NL + "\t\t    data = org.apache.commons.lang.StringUtils.stripEnd(data, \"0\");" + NL + "\t\t    len2 = data.length() - (len1 + 1);" + NL + "\t\t}else{" + NL + "\t\t    len1 = data.length();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (iPrecision < len2) {" + NL + "\t\t\tifPassed = false;" + NL + "\t\t\terrorCode += 8;" + NL + "\t\t\terrorMessage += \"|precision Non-matches\";" + NL + "\t\t} else if (maxLength < len1 + iPrecision) {" + NL + "\t\t\tifPassed = false;" + NL + "\t\t\terrorCode += 8;" + NL + "\t\t\terrorMessage += \"|invalid Length setting is unsuitable for Precision\";" + NL + "\t\t}" + NL + "\t}" + NL + "\tint handleErrorCode(int errorCode, int resultErrorCode){" + NL + "\t\tif (errorCode > 0) {" + NL + "\t\t\tif (resultErrorCode > 0) {" + NL + "\t\t\t\tresultErrorCode = 16;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tresultErrorCode = errorCode;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn resultErrorCode;" + NL + "\t}" + NL + "\tString handleErrorMessage(String errorMessage, String resultErrorMessage, String columnLabel){" + NL + "\t\tif (errorMessage.length() > 0) {" + NL + "\t\t\tif (resultErrorMessage.length() > 0) {" + NL + "\t\t\t\tresultErrorMessage += \";\"+ errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tresultErrorMessage = errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn resultErrorMessage;" + NL + "\t}" + NL + "\t  " + NL + "  void reset(){" + NL + "      ifPassedThrough = true;" + NL + "      errorCodeThrough = 0;" + NL + "      errorMessageThrough = \"\";" + NL + "      resultErrorCodeThrough = 0;" + NL + "      resultErrorMessageThrough = \"\";" + NL + "      tmpContentThrough = null;" + NL + "      " + NL + "      ifPassed = true;" + NL + "\t  errorCode = 0;" + NL + "\t  errorMessage = \"\";" + NL + "  }";
  protected final String TEXT_142 = NL + "\tvoid setRowValue_";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = "Struct ";
  protected final String TEXT_145 = ") {";
  protected final String TEXT_146 = NL + "    resultErrorCodeThrough = handleErrorCode(errorCodeThrough,resultErrorCodeThrough);" + NL + "    errorCodeThrough = 0;" + NL + "    resultErrorMessageThrough = handleErrorMessage(errorMessageThrough,resultErrorMessageThrough,\"";
  protected final String TEXT_147 = ":\");" + NL + "    errorMessageThrough = \"\";";
  protected final String TEXT_148 = NL + "\t}";
  protected final String TEXT_149 = NL + "\t}";
  protected final String TEXT_150 = NL + "}" + NL + "RowSetValueUtil_";
  protected final String TEXT_151 = " rsvUtil_";
  protected final String TEXT_152 = " = new RowSetValueUtil_";
  protected final String TEXT_153 = "();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    /*in shema:*/
    List<? extends IConnection> listInConns = node.getIncomingConnections();
    String sInConnName = null;
    IConnection inConn = null;
    List<IMetadataColumn> listInColumns = null;
    
    if (listInConns != null && listInConns.size() > 0) {
      IConnection inConnTemp = listInConns.get(0);
      sInConnName = inConnTemp.getName();
      if (inConnTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
      	inConn = inConnTemp;
        listInColumns = inConnTemp.getMetadataTable().getListColumns();
      }
	}
	String inConnName = null;
	
	class FindConnStartConn{
		IConnection findStartConn(IConnection conn){
			INode node = conn.getSource();
			if(node.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(node))){
				return conn;
			}
			List<? extends IConnection> listInConns = node.getIncomingConnections();
			IConnection inConnTemp = null;
			if (listInConns != null && listInConns.size() > 0) {
              inConnTemp = listInConns.get(0);
              if (inConnTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                return findStartConn(inConnTemp);
              }
        	}
        	return null;
		}
	}
	if(inConn != null){
		FindConnStartConn finder = new FindConnStartConn();
    	IConnection startConn = finder.findStartConn(inConn);
    	if(startConn!=null){
    		inConnName = startConn.getName();
    	}
	}
	
  /* get the schema of itself (maybe no output flow)*/
  List<IMetadataColumn> listColumsToTest = node.getMetadataList().get(0).getListColumns();

  String anotherChecked = ElementParameterParser.getValue(node, "__CHECK_ANOTHER__");
  String checkAll = ElementParameterParser.getValue(node, "__CHECK_ALL__");    
  final boolean bIsTrim = "true".equals( ElementParameterParser.getValue(node, "__SUB_STRING__") );    
  final boolean useFasteDateChecker = "true".equals( ElementParameterParser.getValue(node, "__FAST_DATE_CHECK__") );
  final boolean emptyIsNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTY_IS_NULL__"));
  final boolean allEmptyAreNull = "true".equals(ElementParameterParser.getValue(node, "__ALL_EMPTY_ARE_NULL__"));

  class SchemaChecker {
    public void  testDataType(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) {
      JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
      boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
      String colName = metadataColumn.getLabel();
      
      if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) {
      
    stringBuffer.append(TEXT_1);
    if (_bNullable){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_6);
    }else if (!isPrimitive){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_10);
    }else{
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
     if(typeSelected.equals("Boolean") ) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_17);
     }else if(typeSelected.equals("Character") ) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_20);
     }else if(typeSelected.equals("BigDecimal") ) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_26);
     } else if(typeSelected.equals("Object")){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_30);
     } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
      }
    }
    
    public void testPrecision(int _maxLength, int iPrecision, String _sInConnName, IMetadataColumn metadataColumn, String cid) {
      JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
      String colName = metadataColumn.getLabel();
      if (javaType == JavaTypesManager.BIGDECIMAL) {
        /* NULLable, in case input value is Null, do nothing... 
           Non-NULLable, 
             (1) in case input value is Non-null, go into...; 
             (2) in case input value is Null, do nothing and warning by NULL-CHECKER.
        */
        /*
          if precision value is not empty or Null, checking "Precision" at first, if passed then checking "Length"
        */
      
    stringBuffer.append(TEXT_38);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_44);
    
      }
    }
    
    public void testDataLength(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, int maxLength, String cid) {
      JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
      boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, metadataColumn.isNullable());
      boolean bIsStringType = (javaType == JavaTypesManager.STRING), bIsIntegerType = (javaType == JavaTypesManager.INTEGER);
      String colName = metadataColumn.getLabel();
      
      if (maxLength > 0 && ( bIsStringType || bIsIntegerType )){
      
    stringBuffer.append(TEXT_45);
    if (_bNullable){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_50);
    }else if (!isPrimitive){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_54);
    }else {
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
          if ( bIsTrim ){
            if (bIsStringType) {
            
    stringBuffer.append(TEXT_57);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_66);
    
            } else if ( bIsIntegerType ){
              String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
              if ("int".equals(generatedType)) {
              
    stringBuffer.append(TEXT_67);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_69);
    
              } else{
              
    stringBuffer.append(TEXT_70);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_72);
    
              }
              
    stringBuffer.append(TEXT_73);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_80);
    
            }
          } else{          
            if (bIsStringType) {
            
    stringBuffer.append(TEXT_81);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_84);
    
            } else if (bIsIntegerType) {
              String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
              if ("int".equals(generatedType)) {
              
    stringBuffer.append(TEXT_85);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_87);
    
              } else {
              
    stringBuffer.append(TEXT_88);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_90);
    
              }
              
    stringBuffer.append(TEXT_91);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_92);
    
            }
          }
          
    stringBuffer.append(TEXT_93);
     
      }
    }
  
    public void  testDate(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String pattern, String cid) {
      JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
      boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
      String colName = metadataColumn.getLabel();

      if ("".equals(pattern)){
      
    stringBuffer.append(TEXT_94);
    
      } else {
      
        if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) {
        
    stringBuffer.append(TEXT_95);
    if (_bNullable){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_100);
    }else if (!isPrimitive){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_104);
    }else {
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    if (!useFasteDateChecker) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_110);
    } else {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    
        // date type need check also (some inputting data not legal, beacause original data is not suite with pattern and has be converted)
        } else if (javaType == JavaTypesManager.DATE){
          if (!metadataColumn.getPattern().equals(pattern)){
          
    stringBuffer.append(TEXT_116);
    
          }
        } else{
        
    stringBuffer.append(TEXT_117);
    
        }
      }
    }

    public void testNull(String _sInConnName, IMetadataColumn metadataColumn, String cid, List<Map<String, String>> list){
	  List<String> listEmptyAsNull = new ArrayList<String>();
	  for(Map<String, String> map : list){
	  	if("true".equals(map.get("EMPTY_NULL"))){
	  		listEmptyAsNull.add(map.get("SCHEMA_COLUMN"));
	  	}
	  }
      boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(metadataColumn.getTalendType(), metadataColumn.isNullable());
      if (!isPrimitive){
      	if(emptyIsNull && !allEmptyAreNull){ //for the migration task
      		if(listEmptyAsNull.contains(metadataColumn.getLabel())){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_122);
    
			}else{

    stringBuffer.append(TEXT_123);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_125);
    
			}
		}else{
      		if(allEmptyAreNull){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_130);
    
			}else if(listEmptyAsNull.contains(metadataColumn.getLabel())){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_135);
    
			}else{

    stringBuffer.append(TEXT_136);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_138);
    
			}
		}

    stringBuffer.append(TEXT_139);
    
      }
    }
  }

  SchemaChecker checker = new SchemaChecker();    
  List<Map<String, String>> listCheckedColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CHECKCOLS__");
  boolean bNeedReferSchema = false;
  
  if ("true".equals(anotherChecked)){
    if (node.getMetadataFromConnector("OTHER") != null)
      listColumsToTest = node.getMetadataFromConnector("OTHER").getListColumns();
  } else if ("true".equals(checkAll)){
    ;
  } else{
    bNeedReferSchema = true;
  }

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
  for (IMetadataColumn inColumn : listInColumns) {
    int iInColIndex = listInColumns.indexOf(inColumn);
    
    if(iInColIndex % 100 == 0){

    stringBuffer.append(TEXT_142);
    stringBuffer.append((iInColIndex/100) );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(inConnName!=null?inConnName:sInConnName );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(sInConnName );
    stringBuffer.append(TEXT_145);
    
    }
    // when using another schema, it's size may less than listInColumns
    if (iInColIndex >= listColumsToTest.size()){
      break;
    }
    
    Object pre_iPrecision = null;
    String sInColumnName = inColumn.getLabel(), sTestColName = null, sTestColType = null, sTestColPattern = null;
    boolean bNullable = true, bMaxLenLimited = true;    
    /* use setting of tSchemaComplianceCheck schema (it is synchronize with inputting schema, but length value can be different) */    
    Object pre_maxLength = listColumsToTest.get(iInColIndex).getLength();
    int maxLength = (pre_maxLength == null) ? 0 : Integer.parseInt(pre_maxLength.toString());
      
    if (bNeedReferSchema) {
      Map<String, String> checkedColumn = listCheckedColumns.get(iInColIndex);
      sTestColName = checkedColumn.get("SCHEMA_COLUMN");
      sTestColType = checkedColumn.get("SELECTED_TYPE");
      sTestColPattern = checkedColumn.get("DATEPATTERN");
      bNullable = "true".equals(checkedColumn.get("NULLABLE"));
      bMaxLenLimited = "true".equals(checkedColumn.get("MAX_LENGTH"));
       
    } else{
      IMetadataColumn schemaColumn = listColumsToTest.get(iInColIndex);
      sTestColName = schemaColumn.getLabel();
      sTestColType = JavaTypesManager.getTypeToGenerate(schemaColumn.getTalendType(), true);
      sTestColPattern = schemaColumn.getPattern();
      bNullable = schemaColumn.isNullable();
      pre_iPrecision = schemaColumn.getPrecision();
    }

    // NULL checking
    if (!bNullable){
      List<Map<String, String>> list = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__EMPTY_NULL_TABLE__");
      checker.testNull(sInConnName, inColumn, cid, list);
    }
      
    // type checking
    if (sTestColType != null){
      if (sTestColType.indexOf("Date") >= 0){
        checker.testDate(bNullable, sInConnName, inColumn, sTestColPattern, cid); 
      } else{         
        checker.testDataType(bNullable, sInConnName, inColumn, sTestColType, cid);
      }
    }
    // length checking
    if (bMaxLenLimited){
      checker.testDataLength(bNullable, sInConnName, inColumn, maxLength, cid);
    }
    
    // precision checking
    if (pre_iPrecision != null){
      checker.testPrecision(maxLength, Integer.parseInt(pre_iPrecision.toString()), sInConnName, inColumn, cid);
    }
    
    stringBuffer.append(TEXT_146);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_147);
    
    if((iInColIndex + 1) % 100 == 0){

    stringBuffer.append(TEXT_148);
    
    }
  } // end for
  if(listInColumns.size() > 0 && listInColumns.size() % 100 > 0){

    stringBuffer.append(TEXT_149);
    
  }

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    return stringBuffer.toString();
  }
}
