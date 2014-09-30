package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloDimensionBeginJava
{
  protected static String nl;
  public static synchronized TPaloDimensionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDimensionBeginJava result = new TPaloDimensionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "org.talend.jpalo.palo p_";
  protected final String TEXT_3 = " = null;" + NL + "org.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_4 = " = null;" + NL;
  protected final String TEXT_5 = NL + "\t// Use Existing" + NL + "\tp_";
  protected final String TEXT_6 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_7 = "\");" + NL + "\tpConn_";
  protected final String TEXT_8 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "\t// Initialize jpalo" + NL + "\tp_";
  protected final String TEXT_11 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_12 = ");" + NL + "\t// Open the connection" + NL + "\t";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; ";
  protected final String TEXT_20 = NL + "\tpConn_";
  protected final String TEXT_21 = " = p_";
  protected final String TEXT_22 = ".connect(";
  protected final String TEXT_23 = ", decryptedPassword_";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + NL + "org.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_28 = " = pConn_";
  protected final String TEXT_29 = ".getDatabases();" + NL + "org.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_30 = "= pDBs_";
  protected final String TEXT_31 = ".getDatabase(";
  protected final String TEXT_32 = "); " + NL + "if(pDB_";
  protected final String TEXT_33 = " == null){" + NL + "" + NL + "\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_34 = " + \"' not found. exiting...\");" + NL + "\t" + NL + "}" + NL + "" + NL + "org.talend.jpalo.palodimensions pDIMs_";
  protected final String TEXT_35 = " = pDB_";
  protected final String TEXT_36 = ".getDimensions(org.talend.jpalo.palodimensions.DIMENSION_";
  protected final String TEXT_37 = ");" + NL + "" + NL + "org.talend.jpalo.palodimension pDIM_";
  protected final String TEXT_38 = " = null;" + NL;
  protected final String TEXT_39 = NL + "\tpDIM_";
  protected final String TEXT_40 = " = pDIMs_";
  protected final String TEXT_41 = ".getDimension(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\tpDIM_";
  protected final String TEXT_44 = " = pDIMs_";
  protected final String TEXT_45 = ".createDimension(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tpDIM_";
  protected final String TEXT_48 = " = pDIMs_";
  protected final String TEXT_49 = ".getDimension(";
  protected final String TEXT_50 = ");" + NL + "\tif(null==pDIM_";
  protected final String TEXT_51 = ") pDIM_";
  protected final String TEXT_52 = " = pDIMs_";
  protected final String TEXT_53 = ".createDimension(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\tpDIM_";
  protected final String TEXT_56 = " = pDIMs_";
  protected final String TEXT_57 = ".getDimension(";
  protected final String TEXT_58 = ");" + NL + "\tif(null!=pDIM_";
  protected final String TEXT_59 = "){" + NL + "\t\torg.talend.jpalo.palocubes CUBES_";
  protected final String TEXT_60 = " = new org.talend.jpalo.palocubes(pConn_";
  protected final String TEXT_61 = ", pDB_";
  protected final String TEXT_62 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\torg.talend.jpalo.palodimensions.DIMENSION_NORMAL);" + NL + "\t\t" + NL + "\t\torg.talend.jpalo.palocubes pCUBEs_";
  protected final String TEXT_63 = " = pDIM_";
  protected final String TEXT_64 = ".getCubes();" + NL + "\t\tjava.util.ArrayList<String> strCubeNames_";
  protected final String TEXT_65 = " = new java.util.ArrayList<String>();" + NL + "\t\t" + NL + "\t\t//Get all the Cubes belong to the specifice Dimension" + NL + "\t\tfor(org.talend.jpalo.palocube pCUBE_";
  protected final String TEXT_66 = " : pCUBEs_";
  protected final String TEXT_67 = ".getCubes()) " + NL + "\t\t    strCubeNames_";
  protected final String TEXT_68 = ".add(pCUBE_";
  protected final String TEXT_69 = ".getName());" + NL + "\t\t" + NL + "\t\t//Loop through Cubes, delete one by one" + NL + "\t\tfor(String strCubeName_";
  protected final String TEXT_70 = " : strCubeNames_";
  protected final String TEXT_71 = ") " + NL + "\t\t    CUBES_";
  protected final String TEXT_72 = ".deleteCube(strCubeName_";
  protected final String TEXT_73 = ");" + NL + "\t\t" + NL + "\t\tpDIMs_";
  protected final String TEXT_74 = ".deleteDimension(";
  protected final String TEXT_75 = ");" + NL + "\t\tpDIM_";
  protected final String TEXT_76 = " = pDIMs_";
  protected final String TEXT_77 = ".getDimension(";
  protected final String TEXT_78 = ");" + NL + "\t}" + NL + "\telse {" + NL + "\t\t throw new RuntimeException (\"Dimension '\" + ";
  protected final String TEXT_79 = " + \"' not found in database '\" + ";
  protected final String TEXT_80 = " + \"'. exiting...\" );" + NL + "\t}";
  protected final String TEXT_81 = NL + "\tpDIM_";
  protected final String TEXT_82 = " = pDIMs_";
  protected final String TEXT_83 = ".getDimension(";
  protected final String TEXT_84 = ");" + NL + "\tif(null!=pDIM_";
  protected final String TEXT_85 = "){" + NL + "\t    org.talend.jpalo.palocubes CUBES_";
  protected final String TEXT_86 = " = new org.talend.jpalo.palocubes(pConn_";
  protected final String TEXT_87 = ", pDB_";
  protected final String TEXT_88 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\torg.talend.jpalo.palodimensions.DIMENSION_NORMAL);" + NL + "\t\t" + NL + "\t\torg.talend.jpalo.palocubes pCUBEs_";
  protected final String TEXT_89 = " = pDIM_";
  protected final String TEXT_90 = ".getCubes();" + NL + "\t\tjava.util.ArrayList<String> strCubeNames_";
  protected final String TEXT_91 = " = new java.util.ArrayList<String>();" + NL + "\t\tfor(org.talend.jpalo.palocube pCUBE_";
  protected final String TEXT_92 = " : pCUBEs_";
  protected final String TEXT_93 = ".getCubes()) strCubeNames_";
  protected final String TEXT_94 = ".add(pCUBE_";
  protected final String TEXT_95 = ".getName());" + NL + "\t\tfor(String strCubeName_";
  protected final String TEXT_96 = " : strCubeNames_";
  protected final String TEXT_97 = ") " + NL + "\t\tCUBES_";
  protected final String TEXT_98 = " .deleteCube(strCubeName_";
  protected final String TEXT_99 = ");" + NL + "\t\t" + NL + "\t\tpDIMs_";
  protected final String TEXT_100 = ".deleteDimension(";
  protected final String TEXT_101 = ");" + NL + "\t\t" + NL + "\t" + NL + "\t}" + NL;
  protected final String TEXT_102 = NL + " \t\tpDIM_";
  protected final String TEXT_103 = " = pDIMs_";
  protected final String TEXT_104 = ".createDimension(";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\torg.talend.jpalo.paloelements pELMstd_";
  protected final String TEXT_107 = " = pDIM_";
  protected final String TEXT_108 = ".getElements();" + NL + "\tjava.util.ArrayList<String> strElementNames_";
  protected final String TEXT_109 = " = new java.util.ArrayList<String>();" + NL + "\tfor(org.talend.jpalo.paloelement pELM_";
  protected final String TEXT_110 = " : pELMstd_";
  protected final String TEXT_111 = ".getElements()) " + NL + "\tstrElementNames_";
  protected final String TEXT_112 = ".add(pELM_";
  protected final String TEXT_113 = ".getName());" + NL + "\tfor(String strElmName_";
  protected final String TEXT_114 = " : strElementNames_";
  protected final String TEXT_115 = ") \t" + NL + "\tpELMstd_";
  protected final String TEXT_116 = ".deleteElement(strElmName_";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + NL + "if(null != pDIM_";
  protected final String TEXT_119 = "){" + NL + "\torg.talend.jpalo.paloelements pELMs_";
  protected final String TEXT_120 = " = pDIM_";
  protected final String TEXT_121 = ".getElements();" + NL + "\torg.talend.jpalo.talendHelpers.tPaloDimensions thPDims_";
  protected final String TEXT_122 = " = new org.talend.jpalo.talendHelpers.tPaloDimensions();" + NL + "" + NL + "\tint iCommitCounter_";
  protected final String TEXT_123 = " = 0;" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));


    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");


    String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");

    String sDimensionName = ElementParameterParser.getValue(node,"__DIMENSION__");
    String sDimensionAction = ElementParameterParser.getValue(node,"__DIMENSION_ACTION__");
    String sCommitSize = ElementParameterParser.getValue(node,"__COMMIT_SIZE__");
    
    String sDimensionType="NORMAL";
    if(sDimensionAction.equals("NONE")) 
       sDimensionType = ElementParameterParser.getValue(node,"__DIMENSION_TYPE__");
    
    boolean bCreateElements = "true".equals(ElementParameterParser.getValue(node,"__CREATE_ELEMENTS_BASED_ON_INPUT__"));
    boolean bDeleteElements = "true".equals(ElementParameterParser.getValue(node,"__DELETE_ALL_ELEMENTS_BEFORE__"));

    boolean bCreateConsolidations = "true".equals(ElementParameterParser.getValue(node,"__CREATE_CONSOLIDATIONS_BASED_ON_INPUT__"));


    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    

if(useExistingConnection){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String p = "p_" + connection;
	String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_9);
    
}else{

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_12);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sServerport);
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
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sDimensionType);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
if(("NONE").equals(sDimensionAction)){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_42);
    
}else if(("CREATE").equals(sDimensionAction)){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_46);
    
}else if(("CREATE_IF_NOT_EXISTS").equals(sDimensionAction)){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_54);
    
}else if (("DELETE").equals(sDimensionAction)){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_80);
    
}else if(("DELETE_IF_EXISTS_AND_CREATE").equals(sDimensionAction)){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_101);
    
	if(("DELETE_IF_EXISTS_AND_CREATE").equals(sDimensionAction)){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(sDimensionName);
    stringBuffer.append(TEXT_105);
    
	}
}
if(bDeleteElements){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
}if(bCreateElements ){


    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
}

    return stringBuffer.toString();
  }
}
