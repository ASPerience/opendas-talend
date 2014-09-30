package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSalesforceConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceConnectionBeginJava result = new TSalesforceConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_2 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_3 = ";" + NL + "\tString endpointURL_";
  protected final String TEXT_4 = " = null;" + NL + "\tString accessToken_";
  protected final String TEXT_5 = " = null;" + NL + "\toauthClient_";
  protected final String TEXT_6 = ".setBaseOAuthURL(";
  protected final String TEXT_7 = ");" + NL + "\toauthClient_";
  protected final String TEXT_8 = ".setClientID(";
  protected final String TEXT_9 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "\t";
  protected final String TEXT_16 = "\t" + NL + "\t" + NL + "\toauthClient_";
  protected final String TEXT_17 = ".setClientSecret(decryptedQauthClientPwd_";
  protected final String TEXT_18 = ");" + NL + "\tString refreshToken_";
  protected final String TEXT_19 = " = null;" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t// Attempt to load existing refresh token" + NL + "\t\tString tokenFile_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "\t\tif(tokenFile_";
  protected final String TEXT_23 = " != null){" + NL + "\t\t\tjava.util.Properties properties_";
  protected final String TEXT_24 = " = new java.util.Properties();" + NL + "\t\t\ttry{" + NL + "\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_25 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_27 = ".load(inputStream_";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\tinputStream_";
  protected final String TEXT_29 = ".close();" + NL + "\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_30 = "){" + NL + "\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_31 = "){" + NL + "\t\t\t}" + NL + "\t\t\tString storedRefreshToken_";
  protected final String TEXT_32 = " = (String) properties_";
  protected final String TEXT_33 = ".get(\"refreshtoken\");" + NL + "\t\t\t" + NL + "\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t// access token." + NL + "\t\t\tif(storedRefreshToken_";
  protected final String TEXT_34 = " != null){" + NL + "\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\ttoken_";
  protected final String TEXT_35 = " = oauthClient_";
  protected final String TEXT_36 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\tendpointURL_";
  protected final String TEXT_39 = " = oauthClient_";
  protected final String TEXT_40 = ".getBulkEndpoint(token_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tendpointURL_";
  protected final String TEXT_44 = " = oauthClient_";
  protected final String TEXT_45 = ".getSOAPEndpoint(token_";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\taccessToken_";
  protected final String TEXT_49 = " = token_";
  protected final String TEXT_50 = ".getAccess_token();" + NL + "\t\t\t\trefreshToken_";
  protected final String TEXT_51 = " = token_";
  protected final String TEXT_52 = ".getRefresh_token();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_53 = NL + "\tif(accessToken_";
  protected final String TEXT_54 = " == null || endpointURL_";
  protected final String TEXT_55 = " == null){" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\toauthClient_";
  protected final String TEXT_57 = ".setCallbackHost(";
  protected final String TEXT_58 = ");" + NL + "\t\toauthClient_";
  protected final String TEXT_59 = ".setCallbackPort(";
  protected final String TEXT_60 = ");" + NL + "\t\ttoken_";
  protected final String TEXT_61 = " = oauthClient_";
  protected final String TEXT_62 = ".getToken();" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\tendpointURL_";
  protected final String TEXT_64 = " = oauthClient_";
  protected final String TEXT_65 = ".getBulkEndpoint(token_";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ");" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\tendpointURL_";
  protected final String TEXT_69 = " = oauthClient_";
  protected final String TEXT_70 = ".getSOAPEndpoint(token_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ");" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\taccessToken_";
  protected final String TEXT_74 = " = token_";
  protected final String TEXT_75 = ".getAccess_token();" + NL + "\t\trefreshToken_";
  protected final String TEXT_76 = " = token_";
  protected final String TEXT_77 = ".getRefresh_token();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_78 = NL + "\t\tif(tokenFile_";
  protected final String TEXT_79 = " != null && refreshToken_";
  protected final String TEXT_80 = " != null){" + NL + "\t\t\t// Store the refresh token for future use." + NL + "\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_81 = " = new java.util.Properties();" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_82 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_83 = ");" + NL + "\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_84 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_85 = ");" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_86 = ".store(outputStream_";
  protected final String TEXT_87 = ", null);" + NL + "\t\t\tif(outputStream_";
  protected final String TEXT_88 = " != null){" + NL + "\t\t\t    outputStream_";
  protected final String TEXT_89 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_90 = NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_91 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\tsforceBulk_";
  protected final String TEXT_92 = ".setNeedCompression(";
  protected final String TEXT_93 = ");" + NL + "\tsforceBulk_";
  protected final String TEXT_94 = ".setNeedTraceMessage(";
  protected final String TEXT_95 = ");" + NL + "\t";
  protected final String TEXT_96 = NL + "\t\tsforceBulk_";
  protected final String TEXT_97 = ".login(accessToken_";
  protected final String TEXT_98 = ", endpointURL_";
  protected final String TEXT_99 = ");" + NL + "\t";
  protected final String TEXT_100 = NL + "    \t\tString decryptedPwd_";
  protected final String TEXT_101 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_102 = ");" + NL + "    \t\t";
  protected final String TEXT_103 = NL + "    \t\tString decryptedPwd_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";" + NL + "    \t\t";
  protected final String TEXT_106 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_107 = ".setProxy(true,";
  protected final String TEXT_108 = ",";
  protected final String TEXT_109 = ",";
  protected final String TEXT_110 = ",decryptedPwd_";
  protected final String TEXT_111 = ");" + NL + "\t\t";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_115 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = "; ";
  protected final String TEXT_120 = NL + "\t\tsforceBulk_";
  protected final String TEXT_121 = ".login(";
  protected final String TEXT_122 = ",";
  protected final String TEXT_123 = ",decryptedPassword_";
  protected final String TEXT_124 = ",";
  protected final String TEXT_125 = ");" + NL + "\t";
  protected final String TEXT_126 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_127 = "\", sforceBulk_";
  protected final String TEXT_128 = ".getConnection());";
  protected final String TEXT_129 = NL + "\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_130 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t";
  protected final String TEXT_131 = NL + "\t\tsfMgr_";
  protected final String TEXT_132 = ".setClientID(";
  protected final String TEXT_133 = ");" + NL + "\t\tglobalMap.put(\"callOptions_";
  protected final String TEXT_134 = "\", sfMgr_";
  protected final String TEXT_135 = ".getCallOptions());" + NL + "\t";
  protected final String TEXT_136 = NL + "\t\tboolean result_";
  protected final String TEXT_137 = " = sfMgr_";
  protected final String TEXT_138 = ".login(accessToken_";
  protected final String TEXT_139 = ", endpointURL_";
  protected final String TEXT_140 = ",";
  protected final String TEXT_141 = ",";
  protected final String TEXT_142 = ");" + NL + "\t\tif(!result_";
  protected final String TEXT_143 = "){" + NL + "\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_144 = NL + "    \t\tString decryptedPwd_";
  protected final String TEXT_145 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_146 = ");" + NL + "    \t\t";
  protected final String TEXT_147 = NL + "    \t\tString decryptedPwd_";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ";" + NL + "    \t\t";
  protected final String TEXT_150 = NL + "\t\t    java.util.Properties props_";
  protected final String TEXT_151 = " = System.getProperties();" + NL + "\t\t    props_";
  protected final String TEXT_152 = ".put(\"socksProxyHost\",";
  protected final String TEXT_153 = ");  " + NL + "\t\t    props_";
  protected final String TEXT_154 = ".put(\"socksProxyPort\",";
  protected final String TEXT_155 = ");" + NL + "\t\t    props_";
  protected final String TEXT_156 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_157 = ");" + NL + "\t\t    props_";
  protected final String TEXT_158 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_159 = "); " + NL + "\t\t";
  protected final String TEXT_160 = NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\t";
  protected final String TEXT_162 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_163 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = "; ";
  protected final String TEXT_168 = NL + "\t\tboolean result_";
  protected final String TEXT_169 = " = sfMgr_";
  protected final String TEXT_170 = ".login(";
  protected final String TEXT_171 = ",";
  protected final String TEXT_172 = ", decryptedPassword_";
  protected final String TEXT_173 = ",";
  protected final String TEXT_174 = ",";
  protected final String TEXT_175 = ");" + NL + "\t\tif(!result_";
  protected final String TEXT_176 = "){" + NL + "\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_177 = NL + "\tglobalMap.put(\"stub_";
  protected final String TEXT_178 = "\", sfMgr_";
  protected final String TEXT_179 = ".getStub());" + NL + "\tglobalMap.put(\"sessionHeader_";
  protected final String TEXT_180 = "\", sfMgr_";
  protected final String TEXT_181 = ".getSessionHeader());";
  protected final String TEXT_182 = "\t\t\t" + NL + "\t\t\t" + NL;
  protected final String TEXT_183 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
String username = ElementParameterParser.getValue(node, "__USER__");

String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
boolean httpTraceMessage = ("true").equals(ElementParameterParser.getValue(node,"__HTTP_TRACEMESSAGE__"));

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

boolean bulkConnection = ("true").equals(ElementParameterParser.getValue(node,"__BULK_CONNECTION__"));
String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");

String passwordFieldName = "";
String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
boolean useOAuth = "OAUTH".equals(loginType);
if(useOAuth){
	String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_9);
    
	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    
	} else {
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    
	}
	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
	if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
				if(bulkConnection){
				
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_42);
    
				}else{
				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_47);
    
				}
				
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	}
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
		if(bulkConnection){
		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_67);
    
		}else{
		
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_72);
    
		}
		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
	
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	}
}
if(bulkConnection){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(httpTraceMessage);
    stringBuffer.append(TEXT_95);
    
	if(useOAuth){
	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	}else{
		if(useProxy){
			passwordFieldName = "__PROXY_PASSWORD__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    		
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    
    		} else {
    		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    
    		}
		
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
		}
		
    stringBuffer.append(TEXT_112);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_113);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_116);
    } else {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_125);
    
	}
	
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
}else{

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
	
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	}
	if(useOAuth){
	
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
	}else{
		if(useProxy){
			passwordFieldName = "__PROXY_PASSWORD__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    		
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_146);
    
    		} else {
    		
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_149);
    
    		}
		
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
		}
		
    stringBuffer.append(TEXT_160);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_161);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_164);
    } else {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
	}
	
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
}

    stringBuffer.append(TEXT_182);
    stringBuffer.append(TEXT_183);
    return stringBuffer.toString();
  }
}
