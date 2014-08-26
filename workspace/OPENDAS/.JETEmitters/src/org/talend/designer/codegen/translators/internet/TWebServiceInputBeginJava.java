package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;
import java.util.List;
import org.talend.core.model.utils.TalendTextUtils;

public class TWebServiceInputBeginJava
{
  protected static String nl;
  public static synchronized TWebServiceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceInputBeginJava result = new TWebServiceInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/////////////////////////////////// " + NL + "        System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "        Object[] params_";
  protected final String TEXT_3 = " = new Object[] {";
  protected final String TEXT_4 = NL + "        ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = ",      ";
  protected final String TEXT_8 = NL + "        ";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = "      " + NL + "        };";
  protected final String TEXT_11 = "   " + NL + "        System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "" + NL + "\t\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_12 = ");" + NL + "\t\tSystem.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = "        \t   " + NL + "        org.talend.DynamicInvoker.setAuth(true, ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = "); \t\t";
  protected final String TEXT_17 = NL + "\t\torg.talend.DynamicInvoker.setWINAuth(true, ";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = "); \t  \t\t";
  protected final String TEXT_20 = "  " + NL + "\t\torg.talend.DynamicInvoker.setHttpProxy(true, ";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = "); ";
  protected final String TEXT_25 = " " + NL + "\t\torg.talend.DynamicInvoker.setTimeOut(";
  protected final String TEXT_26 = ");" + NL + "\t\t" + NL + " \t\torg.talend.DynamicInvoker.main(params_";
  protected final String TEXT_27 = ");" + NL + " \t\tjava.util.Map result = org.talend.DynamicInvoker.getResult();" + NL + "        " + NL + "        Object[] results_";
  protected final String TEXT_28 = " = null;" + NL + "\t    int nb_line_";
  protected final String TEXT_29 = " = 0;" + NL + "\t" + NL + "        for (Object key : result.keySet()) {" + NL + "        " + NL + "           results_";
  protected final String TEXT_30 = " = new Object[";
  protected final String TEXT_31 = "];" + NL + "            " + NL + "           Object value = result.get(key);" + NL + "           if (value instanceof Object[]){" + NL + "                Object[] objArr_";
  protected final String TEXT_32 = " = (Object[])value;" + NL + "                int len_";
  protected final String TEXT_33 = " = Math.min(objArr_";
  protected final String TEXT_34 = ".length, results_";
  protected final String TEXT_35 = ".length);" + NL + "                int k_";
  protected final String TEXT_36 = " = 0;" + NL + "                for (int i_";
  protected final String TEXT_37 = " = 0; i_";
  protected final String TEXT_38 = " < len_";
  protected final String TEXT_39 = "; i_";
  protected final String TEXT_40 = "++ ) {" + NL + "                    results_";
  protected final String TEXT_41 = "[k_";
  protected final String TEXT_42 = "] = objArr_";
  protected final String TEXT_43 = "[k_";
  protected final String TEXT_44 = "];" + NL + "                }" + NL + "                " + NL + "          } else if (value instanceof java.util.List) {" + NL + "                java.util.List list_";
  protected final String TEXT_45 = " = (java.util.List)value;" + NL + "                int len_";
  protected final String TEXT_46 = " = Math.min(list_";
  protected final String TEXT_47 = ".size(), results_";
  protected final String TEXT_48 = ".length);" + NL + "                int k_";
  protected final String TEXT_49 = " = 0;" + NL + "                for (java.util.Iterator iter_";
  protected final String TEXT_50 = " = list_";
  protected final String TEXT_51 = ".iterator(); iter_";
  protected final String TEXT_52 = ".hasNext() && k_";
  protected final String TEXT_53 = " < len_";
  protected final String TEXT_54 = "; k_";
  protected final String TEXT_55 = "++) {" + NL + "                    results_";
  protected final String TEXT_56 = "[k_";
  protected final String TEXT_57 = "] = iter_";
  protected final String TEXT_58 = ".next();" + NL + "                }" + NL + "                                " + NL + "            } else if (value instanceof java.util.Map) {                " + NL + "\t\t\t\tjava.util.Map map_";
  protected final String TEXT_59 = " = (java.util.Map)value;" + NL + "                java.util.Collection values_";
  protected final String TEXT_60 = " = map_";
  protected final String TEXT_61 = ".values();" + NL + "                int len_";
  protected final String TEXT_62 = " = Math.min(values_";
  protected final String TEXT_63 = ".size(), results_";
  protected final String TEXT_64 = ".length);" + NL + "                int k_";
  protected final String TEXT_65 = " = 0;" + NL + "                for (java.util.Iterator iter_";
  protected final String TEXT_66 = " = values_";
  protected final String TEXT_67 = ".iterator(); iter_";
  protected final String TEXT_68 = ".hasNext() && k_";
  protected final String TEXT_69 = " < len_";
  protected final String TEXT_70 = "; k_";
  protected final String TEXT_71 = "++) {" + NL + "                    results_";
  protected final String TEXT_72 = "[k_";
  protected final String TEXT_73 = "] = iter_";
  protected final String TEXT_74 = ".next();" + NL + "                }" + NL + "" + NL + "            } else if (value instanceof org.w3c.dom.Element) {" + NL + "                results_";
  protected final String TEXT_75 = "[0] = org.apache.axis.utils.XMLUtils.ElementToString((org.w3c.dom.Element)value);" + NL + "                " + NL + "            }else if (value instanceof org.apache.axis.types.Schema){" + NL + "                org.apache.axis.types.Schema schema_";
  protected final String TEXT_76 = " = (org.apache.axis.types.Schema) value;" + NL + "                org.apache.axis.message.MessageElement[] _any_";
  protected final String TEXT_77 = " = schema_";
  protected final String TEXT_78 = ".get_any();" + NL + "                for (int s_";
  protected final String TEXT_79 = " = 0; s_";
  protected final String TEXT_80 = " < _any_";
  protected final String TEXT_81 = ".length; s_";
  protected final String TEXT_82 = "++) {" + NL + "                    results_";
  protected final String TEXT_83 = "[s_";
  protected final String TEXT_84 = "] = _any_";
  protected final String TEXT_85 = "[s_";
  protected final String TEXT_86 = "].toString();" + NL + "                }\t" + NL + "                " + NL + "            } else {" + NL + "\t\t\t    results_";
  protected final String TEXT_87 = "[0] = value;" + NL + "            }" + NL + "            ";
  protected final String TEXT_88 = NL + "        Object[] results_";
  protected final String TEXT_89 = " = null;" + NL + "\t    int nb_line_";
  protected final String TEXT_90 = " = 0;" + NL + "\t    " + NL + "        org.talend.TalendJob talendJob_";
  protected final String TEXT_91 = " = new org.talend.TalendJobProxy(";
  protected final String TEXT_92 = ");" + NL + "        String[][] runJob_";
  protected final String TEXT_93 = " = talendJob_";
  protected final String TEXT_94 = ".runJob(new String[]{";
  protected final String TEXT_95 = NL + "        ";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = " " + NL + "        });" + NL + "        for (String[] item_";
  protected final String TEXT_98 = " : runJob_";
  protected final String TEXT_99 = ") {" + NL + "\t\t\tresults_";
  protected final String TEXT_100 = " = item_";
  protected final String TEXT_101 = ";";
  protected final String TEXT_102 = "            " + NL + "\t" + NL + "           nb_line_";
  protected final String TEXT_103 = "++;" + NL + "\t       " + NL + "// for output";
  protected final String TEXT_104 = NL + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_106 = " < results_";
  protected final String TEXT_107 = ".length && results_";
  protected final String TEXT_108 = "[";
  protected final String TEXT_109 = "]!=null){\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = results_";
  protected final String TEXT_113 = "[";
  protected final String TEXT_114 = "];\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = results_";
  protected final String TEXT_118 = "[";
  protected final String TEXT_119 = "].toString();";
  protected final String TEXT_120 = "\t\t\t\t\t" + NL + "\t\t\t\t\tif(results_";
  protected final String TEXT_121 = "[";
  protected final String TEXT_122 = "] instanceof java.util.GregorianCalendar) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = ((java.util.GregorianCalendar)results_";
  protected final String TEXT_125 = "[";
  protected final String TEXT_126 = "]).getTime();" + NL + "                   \t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_129 = "[";
  protected final String TEXT_130 = "].toString(), ";
  protected final String TEXT_131 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_132 = NL + "\t\t\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = results_";
  protected final String TEXT_135 = "[";
  protected final String TEXT_136 = "].toString().getBytes();" + NL + "\t";
  protected final String TEXT_137 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = ParserUtils.parseTo_";
  protected final String TEXT_140 = "(results_";
  protected final String TEXT_141 = "[";
  protected final String TEXT_142 = "].toString());";
  protected final String TEXT_143 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "      \t\t\t";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_152 = NL + "///////////////////////////////////       ";
  protected final String TEXT_153 = NL + " ";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = NL + "\tint nb_line_";
  protected final String TEXT_156 = " = 0;" + NL + "\t";
  protected final String TEXT_157 = NL + "    ";
  protected final String TEXT_158 = NL + "    " + NL + "    nb_line_";
  protected final String TEXT_159 = "++;";
  protected final String TEXT_160 = NL;
  protected final String TEXT_161 = " ";
  protected final String TEXT_162 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
// component id
String cid = node.getUniqueName();

if(("false").equals(ElementParameterParser.getValue(node,"__ADVANCED_USE__"))) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
     
        List<IMetadataColumn> listColumns = metadata.getListColumns(); 
        
        List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
        
        boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
        String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
        String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");
        
        boolean winAuth = ("true").equals(ElementParameterParser.getValue(node,"__WIN_AUTH__"));
        String domain = ElementParameterParser.getValue(node,"__DOMAIN__");
        
        boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__UES_PROXY__"));
        String proxuHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
        String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
        String proxuUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
        String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
        
        boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
        String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
        String trustStorePassword = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");
        
        
        String timeoutStr = ElementParameterParser.getValue(node,"__TIMEOUT__");
		String timeout = (timeoutStr!=null&&!("").equals(timeoutStr))?timeoutStr:"20";
		
        String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");
        String method = ElementParameterParser.getValue(node,"__METHOD__");
        if(method != null && !("\"runJob\"").equals(method.trim())) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(method );
    stringBuffer.append(TEXT_7);
    
        for (int i = 0; i < params.size(); i++) {
            Map<String, String> line = params.get(i);

    stringBuffer.append(TEXT_8);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_9);
    
        }

    stringBuffer.append(TEXT_10);
     
		if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(trustStorePassword );
    stringBuffer.append(TEXT_13);
     
		}
		if (needAuth&&!winAuth) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_16);
    
  		}
  		if (needAuth&&winAuth){
  			String domain_username = "\""+TalendTextUtils.removeQuotes(domain)+"\\\\"+TalendTextUtils.removeQuotes(username)+"\"";

    stringBuffer.append(TEXT_17);
    stringBuffer.append(domain_username );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_19);
    
  		}
		if (useProxy) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(proxuHost );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(proxuUser );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_24);
    
  		}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(timeout );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(listColumns.size()==0? 1 : listColumns.size());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    } else { 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
        for (int i = 0; i < params.size(); i++) {
            Map<String, String> line = params.get(i);

    stringBuffer.append(TEXT_95);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_96);
    
        }

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_104);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_109);
    
					if(javaType == JavaTypesManager.OBJECT){//Object

    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_114);
    
					}else if(javaType == JavaTypesManager.STRING) { //String 

    stringBuffer.append(TEXT_115);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_119);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_131);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_132);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_136);
    
					} else  { //other

    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_142);
    
					}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_146);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_151);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1

    stringBuffer.append(TEXT_152);
    
  }
}  
 
    stringBuffer.append(TEXT_153);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the use the wsdl2java
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_154);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String code = ElementParameterParser.getValue(node, "__CODE__");
        
        // we give a default value to prevComponentName so that no error
        // occur when the user tries to generated Java code while no input
        // component was linked to our tJavaRow.        
        String outputRowName = new String("output_row");
        
        List< ? extends IConnection> outConns = node.getOutgoingConnections();
        if (outConns != null && !outConns.isEmpty()) {
            IConnection outConn = outConns.get(0);
            outputRowName = outConn.getName();
        }

        // In case the user would make some tricky Java things, he can use
        // the arrays as a whole.

        code = code.replaceAll(
            "output_row",
            outputRowName
        );


    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
    }
}

    stringBuffer.append(TEXT_160);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  }

    stringBuffer.append(TEXT_161);
    stringBuffer.append(TEXT_162);
    return stringBuffer.toString();
  }
}
