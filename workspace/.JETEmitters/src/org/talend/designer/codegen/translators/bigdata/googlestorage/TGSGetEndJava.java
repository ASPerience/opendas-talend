package org.talend.designer.codegen.translators.bigdata.googlestorage;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TGSGetEndJava
{
  protected static String nl;
  public static synchronized TGSGetEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSGetEndJava result = new TGSGetEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t}" + NL + "\t\t   \t\t}";
  protected final String TEXT_3 = "\t\t   \t\t" + NL + " \t\t\t}";
  protected final String TEXT_4 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_5 = "){";
  protected final String TEXT_6 = NL + "\t\tthrow(e_";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\t\tif(e_";
  protected final String TEXT_9 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_10 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_11 = ";" + NL + "\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_12 = ":\");" + NL + "\t\t\tSystem.err.println(servError_";
  protected final String TEXT_13 = ".getMessage());" + NL + "\t\t\tif(servError_";
  protected final String TEXT_14 = ".getErrorCode()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_15 = ".getErrorCode());" + NL + "\t\t\t}" + NL + "\t\t\tif(servError_";
  protected final String TEXT_16 = ".getErrorMessage()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_17 = ".getErrorMessage());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t}else{" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_18 = ".getMessage());" + NL + "\t\t}";
  protected final String TEXT_19 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_20 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_21 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t}" + NL + "globalMap.put(\"";
  protected final String TEXT_23 = "_NB_LINE\", nb_line_";
  protected final String TEXT_24 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

	boolean getList = "true".equals(ElementParameterParser.getValue(node,"__GETLIST__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean useKeysList = "true".equals(ElementParameterParser.getValue(node,"__USE_KEYS_LIST__"));
	List<Map<String, String>> keys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEYS__");
	
	if((!getList && !useKeysList) || (useKeysList && keys.size()>0) || (getList && buckets.size()>0)){

    stringBuffer.append(TEXT_2);
    
		if(!useKeysList){

    stringBuffer.append(TEXT_3);
    
		}
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		} else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
