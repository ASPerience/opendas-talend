package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloDimensionListBeginJava
{
  protected static String nl;
  public static synchronized TPaloDimensionListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDimensionListBeginJava result = new TPaloDimensionListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint NB_DIMENSIONS";
  protected final String TEXT_3 = " = 0;  " + NL + "\torg.talend.jpalo.palo p_";
  protected final String TEXT_4 = " = null;" + NL + "\torg.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_5 = " = null;" + NL;
  protected final String TEXT_6 = NL + "\t// Use Existing" + NL + "\tp_";
  protected final String TEXT_7 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "\tpConn_";
  protected final String TEXT_9 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_10 = "\");";
  protected final String TEXT_11 = NL + "\t// Initialize jpalo" + NL + "\tp_";
  protected final String TEXT_12 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_13 = ");" + NL + "\t// Open the connection" + NL + "\t";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "; ";
  protected final String TEXT_21 = NL + "\tpConn_";
  protected final String TEXT_22 = " = p_";
  protected final String TEXT_23 = ".connect(";
  protected final String TEXT_24 = ", decryptedPassword_";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + NL;
  protected final String TEXT_29 = NL + NL + "org.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_30 = " = pConn_";
  protected final String TEXT_31 = ".getDatabases();" + NL + "org.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_32 = " = pDBs_";
  protected final String TEXT_33 = ".getDatabase(";
  protected final String TEXT_34 = ");" + NL + "if(pDB_";
  protected final String TEXT_35 = " == null){" + NL + "\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_36 = " + \"' not found. exiting...\");" + NL + "}" + NL + "" + NL + "org.talend.jpalo.palocube pCUB_";
  protected final String TEXT_37 = " = null;" + NL + "org.talend.jpalo.palodimension pDIM_";
  protected final String TEXT_38 = " = null;" + NL;
  protected final String TEXT_39 = NL + "\t\t//pCUB_";
  protected final String TEXT_40 = " = pDB_";
  protected final String TEXT_41 = ".getCubes(org.talend.jpalo.palocubes.CUBE_NORMAL).getCube();";
  protected final String TEXT_42 = NL + NL;
  protected final String TEXT_43 = NL + "\tfor(int i_";
  protected final String TEXT_44 = "=0;i_";
  protected final String TEXT_45 = "<4;i_";
  protected final String TEXT_46 = "++){" + NL + "\t\torg.talend.jpalo.palodimensions pDIMs_";
  protected final String TEXT_47 = "=null;";
  protected final String TEXT_48 = NL + "\t\torg.talend.jpalo.palocube pCB_";
  protected final String TEXT_49 = " = pDB_";
  protected final String TEXT_50 = ".getCubes(i_";
  protected final String TEXT_51 = ").getCube(";
  protected final String TEXT_52 = ");" + NL + "\t\t" + NL + "\t\tif(null!=pCB_";
  protected final String TEXT_53 = ")\t{" + NL + "\t\t    pDIMs_";
  protected final String TEXT_54 = " = pCB_";
  protected final String TEXT_55 = ".getDimensions();" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\tpDIMs_";
  protected final String TEXT_57 = " = pDB_";
  protected final String TEXT_58 = ".getDimensions(i_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = "\t\t" + NL + "" + NL + "\t\tif(null!=pDIMs_";
  protected final String TEXT_61 = "){" + NL + "\t\tfor(int j_";
  protected final String TEXT_62 = "=0;j_";
  protected final String TEXT_63 = "< pDIMs_";
  protected final String TEXT_64 = ".getNumberOfDimensions();j_";
  protected final String TEXT_65 = "++){" + NL + "\t\t\tpDIM_";
  protected final String TEXT_66 = "=pDIMs_";
  protected final String TEXT_67 = ".getDimension(j_";
  protected final String TEXT_68 = ");" + NL + "\t\t\tNB_DIMENSIONS";
  protected final String TEXT_69 = "++;";
  protected final String TEXT_70 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_71 = ".dimension_id=pDIM_";
  protected final String TEXT_72 = ".getDimensionId();" + NL + "\t\t\t";
  protected final String TEXT_73 = ".dimension_name=pDIM_";
  protected final String TEXT_74 = ".getName();" + NL + "\t\t\t";
  protected final String TEXT_75 = ".dimension_attribut_cube=pDIM_";
  protected final String TEXT_76 = ".getAttributCube();" + NL + "\t\t\t";
  protected final String TEXT_77 = ".dimension_rights_cube=pDIM_";
  protected final String TEXT_78 = ".getRightsCube();" + NL + "\t\t\t";
  protected final String TEXT_79 = ".dimension_elements=pDIM_";
  protected final String TEXT_80 = ".getNumberOfElements();" + NL + "\t\t\t";
  protected final String TEXT_81 = ".dimension_max_level=pDIM_";
  protected final String TEXT_82 = ".getMaximumLevel();" + NL + "\t\t\t";
  protected final String TEXT_83 = ".dimension_max_indent=pDIM_";
  protected final String TEXT_84 = ".getMaximumIndent();" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_85 = ".dimension_type=pDIM_";
  protected final String TEXT_86 = ".getDimensionType();";
  protected final String TEXT_87 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_88 = "_DIMENSIONNAME\", pDIM_";
  protected final String TEXT_89 = ".getName());" + NL + "\t\t";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean useRetriveFromCube = "true".equals(ElementParameterParser.getValue(node,"__RETRIEVE_DIMENSIONS_FROM_CUBE__"));

    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");


    String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    String sCubeName = ElementParameterParser.getValue(node,"__CUBE__");
    

    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
if(useExistingConnection){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String p = "p_" + connection;
	String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_10);
    
}else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_13);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_14);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    
	String outputConnName = null;
	boolean bIterate=false;
	boolean bData=false;
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null) {
		if (conns.size()>0) {
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					outputConnName = connTemp.getName();
					bData=true;
					//break;
				}
			}
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if(connTemp.getLineStyle().toString().equals("ITERATE")) {
					bIterate=true;
					//break;
				}
			}
	
		}
	}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
	if(useRetriveFromCube){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	}

    stringBuffer.append(TEXT_42);
    
if (outputConnName != null || bIterate){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
	if(useRetriveFromCube){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
	}else{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
	}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		if(bData){

    stringBuffer.append(TEXT_70);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
		}
		if(bIterate){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
		}
}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
