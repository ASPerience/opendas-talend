package org.talend.designer.codegen.translators.bigdata.googlestorage;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TGSListEndJava
{
  protected static String nl;
  public static synchronized TGSListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSListEndJava result = new TGSListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t   \t\t}" + NL + "\t\t    }";
  protected final String TEXT_3 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_4 = "){";
  protected final String TEXT_5 = NL + "\t\tthrow(e_";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\tif(e_";
  protected final String TEXT_8 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_9 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_10 = ";" + NL + "\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_11 = ":\");" + NL + "\t\t\tSystem.err.println(servError_";
  protected final String TEXT_12 = ".getMessage());" + NL + "\t\t\tif(servError_";
  protected final String TEXT_13 = ".getErrorCode()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_14 = ".getErrorCode());" + NL + "\t\t\t}" + NL + "\t\t\tif(servError_";
  protected final String TEXT_15 = ".getErrorMessage()!=null){" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_16 = ".getErrorMessage());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t}else{" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_17 = ".getMessage());" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_19 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_20 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_22 = "_NB_LINE\", nb_line_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean listInBucketList = "true".equals(ElementParameterParser.getValue(node,"__LIST_IN_BUCKET_LIST__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	if(!listInBucketList || buckets.size()>0){

    stringBuffer.append(TEXT_2);
    
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		} else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
