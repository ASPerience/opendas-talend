package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;

public class TSalesforceBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceBulkExecBeginJava result = new TSalesforceBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_3 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_4 = ";" + NL + "\t\tString endpointURL_";
  protected final String TEXT_5 = " = null;" + NL + "\t\tString accessToken_";
  protected final String TEXT_6 = " = null;" + NL + "\t\toauthClient_";
  protected final String TEXT_7 = ".setBaseOAuthURL(";
  protected final String TEXT_8 = ");" + NL + "\t\toauthClient_";
  protected final String TEXT_9 = ".setClientID(";
  protected final String TEXT_10 = ");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\t\t";
  protected final String TEXT_17 = "\t\t" + NL + "\t    " + NL + "\t\toauthClient_";
  protected final String TEXT_18 = ".setClientSecret(decryptedQauthClientPwd_";
  protected final String TEXT_19 = ");" + NL + "\t\tString refreshToken_";
  protected final String TEXT_20 = " = null;" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\tString tokenFile_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "\t\t\tif(tokenFile_";
  protected final String TEXT_24 = " != null){" + NL + "\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_25 = " = new java.util.Properties();" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_26 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_28 = ".load(inputStream_";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t\tinputStream_";
  protected final String TEXT_30 = ".close();" + NL + "\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_31 = "){" + NL + "\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_32 = "){" + NL + "\t\t\t\t}" + NL + "\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_33 = " = (String) properties_";
  protected final String TEXT_34 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t" + NL + "\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t// access token." + NL + "\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_35 = " != null){" + NL + "\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\ttoken_";
  protected final String TEXT_36 = " = oauthClient_";
  protected final String TEXT_37 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t\tendpointURL_";
  protected final String TEXT_39 = " = oauthClient_";
  protected final String TEXT_40 = ".getBulkEndpoint(token_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t\taccessToken_";
  protected final String TEXT_43 = " = token_";
  protected final String TEXT_44 = ".getAccess_token();" + NL + "\t\t\t\t\trefreshToken_";
  protected final String TEXT_45 = " = token_";
  protected final String TEXT_46 = ".getRefresh_token();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\tif(accessToken_";
  protected final String TEXT_48 = " == null || endpointURL_";
  protected final String TEXT_49 = " == null){" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\toauthClient_";
  protected final String TEXT_51 = ".setCallbackHost(";
  protected final String TEXT_52 = ");" + NL + "\t\t\toauthClient_";
  protected final String TEXT_53 = ".setCallbackPort(";
  protected final String TEXT_54 = ");" + NL + "\t\t\ttoken_";
  protected final String TEXT_55 = " = oauthClient_";
  protected final String TEXT_56 = ".getToken();" + NL + "\t\t\tendpointURL_";
  protected final String TEXT_57 = " = oauthClient_";
  protected final String TEXT_58 = ".getBulkEndpoint(token_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ");" + NL + "\t\t\taccessToken_";
  protected final String TEXT_61 = " = token_";
  protected final String TEXT_62 = ".getAccess_token();" + NL + "\t\t\trefreshToken_";
  protected final String TEXT_63 = " = token_";
  protected final String TEXT_64 = ".getRefresh_token();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t\tif(tokenFile_";
  protected final String TEXT_66 = " != null && refreshToken_";
  protected final String TEXT_67 = " != null){" + NL + "\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_68 = " = new java.util.Properties();" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_69 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_71 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_73 = ".store(outputStream_";
  protected final String TEXT_74 = ", null);" + NL + "\t\t\t\tif(outputStream_";
  protected final String TEXT_75 = " != null){" + NL + "\t\t\t\t    outputStream_";
  protected final String TEXT_76 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\tint nb_line_";
  protected final String TEXT_78 = " = 0;" + NL + "    int nb_success_";
  protected final String TEXT_79 = " = 0;" + NL + "    int nb_reject_";
  protected final String TEXT_80 = " = 0;" + NL + "\t" + NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_81 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\tsforceBulk_";
  protected final String TEXT_82 = ".setConcurrencyMode(\"";
  protected final String TEXT_83 = "\");" + NL + "\tsforceBulk_";
  protected final String TEXT_84 = ".setAwaitTime(";
  protected final String TEXT_85 = ");" + NL + "\t";
  protected final String TEXT_86 = NL + "\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_87 = "\")==null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_88 = "\");" + NL + "\t\t}" + NL + "\t\tsforceBulk_";
  protected final String TEXT_89 = ".login((com.sforce.async.BulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_90 = "\"));" + NL + "\t";
  protected final String TEXT_91 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_92 = ".login(accessToken_";
  protected final String TEXT_93 = ", endpointURL_";
  protected final String TEXT_94 = ");" + NL + "\t\t";
  protected final String TEXT_95 = NL + "        \t\tString decryptedPwd_";
  protected final String TEXT_96 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_97 = ");" + NL + "        \t\t";
  protected final String TEXT_98 = NL + "        \t\tString decryptedPwd_";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = ";" + NL + "        \t\t";
  protected final String TEXT_101 = NL + "\t\t\t\tsforceBulk_";
  protected final String TEXT_102 = ".setProxy(true,";
  protected final String TEXT_103 = ",";
  protected final String TEXT_104 = ",";
  protected final String TEXT_105 = ",decryptedPwd_";
  protected final String TEXT_106 = ");" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t";
  protected final String TEXT_109 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_110 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = "; ";
  protected final String TEXT_115 = NL + "\t\t\tsforceBulk_";
  protected final String TEXT_116 = ".login(";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = ",decryptedPassword_";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ");" + NL + "\t\t";
  protected final String TEXT_121 = NL + NL + NL + "\tsforceBulk_";
  protected final String TEXT_122 = ".executeBulk(";
  protected final String TEXT_123 = ",\"";
  protected final String TEXT_124 = "\",";
  protected final String TEXT_125 = ",\"";
  protected final String TEXT_126 = "\",";
  protected final String TEXT_127 = ",";
  protected final String TEXT_128 = ",";
  protected final String TEXT_129 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_130 = NL + "\t\t\tint j_";
  protected final String TEXT_131 = "=0;" + NL + "\t\t\tint batchCount_";
  protected final String TEXT_132 = " = sforceBulk_";
  protected final String TEXT_133 = ".getBatchCount();" + NL + "\t\t\tfor(int i = 0; i < batchCount_";
  protected final String TEXT_134 = "; i++){" + NL + "\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_135 = " = sforceBulk_";
  protected final String TEXT_136 = ".getBatchLog(i);" + NL + "\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_137 = " : resultListMessage_";
  protected final String TEXT_138 = "){" + NL + "\t\t\t\t\tj_";
  protected final String TEXT_139 = "++;" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_141 = " = null;\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = "\t" + NL + "\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_143 = ".get(\"Success\"))){" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\tnb_success_";
  protected final String TEXT_145 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_146 = " = new ";
  protected final String TEXT_147 = "Struct();" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_148 = ".salesforce_created = resultMessage_";
  protected final String TEXT_149 = ".get(\"Created\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_150 = ".salesforce_id = resultMessage_";
  protected final String TEXT_151 = ".get(\"Id\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_152 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_153 = ".get(\"";
  protected final String TEXT_154 = "\")))){" + NL + "\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_155 = ".put(\"";
  protected final String TEXT_156 = "\",null);" + NL + "\t\t\t\t        \t}" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_157 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = resultMessage_";
  protected final String TEXT_160 = ".get(\"";
  protected final String TEXT_161 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_165 = ".get(\"";
  protected final String TEXT_166 = "\"), ";
  protected final String TEXT_167 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_168 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = ParserUtils.parseTo_";
  protected final String TEXT_171 = "(resultMessage_";
  protected final String TEXT_172 = ".get(\"";
  protected final String TEXT_173 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = " = ParserUtils.parseTo_";
  protected final String TEXT_177 = "(resultMessage_";
  protected final String TEXT_178 = ".get(\"";
  protected final String TEXT_179 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t           \t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\tnb_reject_";
  protected final String TEXT_183 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_184 = " = new ";
  protected final String TEXT_185 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_186 = ".error = resultMessage_";
  protected final String TEXT_187 = ".get(\"Error\");" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_188 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_189 = ".get(\"";
  protected final String TEXT_190 = "\")))){" + NL + "\t\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_191 = ".put(\"";
  protected final String TEXT_192 = "\",null);" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_193 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = resultMessage_";
  protected final String TEXT_196 = ".get(\"";
  protected final String TEXT_197 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_201 = ".get(\"";
  protected final String TEXT_202 = "\"), ";
  protected final String TEXT_203 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_204 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = ParserUtils.parseTo_";
  protected final String TEXT_207 = "(resultMessage_";
  protected final String TEXT_208 = ".get(\"";
  protected final String TEXT_209 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_210 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = " = ParserUtils.parseTo_";
  protected final String TEXT_213 = "(resultMessage_";
  protected final String TEXT_214 = ".get(\"";
  protected final String TEXT_215 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\tSystem.err.print(\"Row \"+j_";
  protected final String TEXT_218 = "+\":\"+resultMessage_";
  protected final String TEXT_219 = ".get(\"Error\"));" + NL + "\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_221 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String apiVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
	String username = ElementParameterParser.getValue(node, "__USER__");

	
	String sObject = ElementParameterParser.getValue(node, "__MODULENAME__");
	String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	if ("CustomModule".equals(sObject)) {
		//modulename = customModulename; 
		sObject = customModulename;
	}else{
		sObject = "\""+sObject+"\"";
	}
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String externalId = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
	//String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
	String contentType = "csv";
	String bulkFileName = ElementParameterParser.getValue(node, "__BULKFILENAME__").trim();
	
	String maxBytes = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_BYTES__");
	String maxRows = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_ROWS__");
	
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	
	String concurrencyMode = ElementParameterParser.getValue(node,"__CONCURRENCY_MODE__");
	String awaitTime = ElementParameterParser.getValue(node,"__AWAIT_TIME__");
	
	String passwordFieldName = "";
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	if(!useExistingConn && useOAuth){
		String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_10);
    
		passwordFieldName = "__OAUTH_CLIENT_SECRET__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    
		} else {
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    
		}
		
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
		if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
		
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tokenFile);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		}
		
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
			String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
		
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		}
	}
	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(concurrencyMode);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(awaitTime);
    stringBuffer.append(TEXT_85);
    
	if(useExistingConn){
	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_90);
    
	}else{
		if(useOAuth){
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		}else{
			if(useProxy){
				passwordFieldName = "__PROXY_PASSWORD__";
				if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        		
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_97);
    
        		} else {
        		
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_100);
    
        		}
			
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
			}
			
    stringBuffer.append(TEXT_107);
    
			passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_108);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_111);
    } else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_120);
    
		}
	}
	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(externalId);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(bulkFileName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(maxBytes);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_129);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
		
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
     
			List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
			if(outgoingConns!=null){
				for (int i=0;i<outgoingConns.size();i++) {
			    IConnection outgoingConn = outgoingConns.get(i);
			    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_140);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_141);
    
			    	}
			    }
			}
    	
			List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
			List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
			
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
				if (connsSuccess != null && connsSuccess.size() == 1) {
					IConnection connSuccess = connsSuccess.get(0);
					if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_156);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_157);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_161);
    
					        }else if(javaType == JavaTypesManager.DATE){
					        
    stringBuffer.append(TEXT_162);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_167);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    
					        }else { 
							
    stringBuffer.append(TEXT_174);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_179);
    
							}
							
    stringBuffer.append(TEXT_180);
    					 
						}
					}
				}
				
    stringBuffer.append(TEXT_181);
    
				if (connsReject != null && connsReject.size() == 1) {
					IConnection connReject = connsReject.get(0);
					if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_193);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    
					        }else if(javaType == JavaTypesManager.DATE && pattern != null){
					        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_203);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_204);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    
					        }else { 
							
    stringBuffer.append(TEXT_210);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_215);
    
							}
							
    stringBuffer.append(TEXT_216);
    					 
						}
					}
				}else{
				
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
				}
		}//2
	}//1
	
    stringBuffer.append(TEXT_220);
    stringBuffer.append(TEXT_221);
    return stringBuffer.toString();
  }
}
