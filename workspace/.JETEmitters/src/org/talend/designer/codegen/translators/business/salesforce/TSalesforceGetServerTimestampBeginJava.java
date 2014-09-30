package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TSalesforceGetServerTimestampBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceGetServerTimestampBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetServerTimestampBeginJava result = new TSalesforceGetServerTimestampBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL;
  protected final String TEXT_4 = NL + "\t\t\t\t\torg.talend.salesforce.oauth.OAuthClient oauthClient_";
  protected final String TEXT_5 = " = new org.talend.salesforce.oauth.OAuthClient();" + NL + "\t\t\t\t\torg.talend.salesforce.oauth.Token token_";
  protected final String TEXT_6 = ";" + NL + "\t\t\t\t\tString endpointURL_";
  protected final String TEXT_7 = " = null;" + NL + "\t\t\t\t\tString accessToken_";
  protected final String TEXT_8 = " = null;" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_9 = ".setBaseOAuthURL(";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_11 = ".setClientID(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tString decryptedQauthClientPwd_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\toauthClient_";
  protected final String TEXT_20 = ".setClientSecret(decryptedQauthClientPwd_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\tString refreshToken_";
  protected final String TEXT_22 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t// Attempt to load existing refresh token" + NL + "\t\t\t\t\t\tString tokenFile_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ";" + NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_26 = " != null){" + NL + "\t\t\t\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_27 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_28 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t\t\t\t\tproperties_";
  protected final String TEXT_30 = ".load(inputStream_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\t\t\t\tinputStream_";
  protected final String TEXT_32 = ".close();" + NL + "\t\t\t\t\t\t\t}catch(java.io.FileNotFoundException e_";
  protected final String TEXT_33 = "){" + NL + "\t\t\t\t\t\t\t}catch(java.io.IOException ee_";
  protected final String TEXT_34 = "){" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tString storedRefreshToken_";
  protected final String TEXT_35 = " = (String) properties_";
  protected final String TEXT_36 = ".get(\"refreshtoken\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t\t\t\t\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t\t\t\t\t\t// access token." + NL + "\t\t\t\t\t\t\tif(storedRefreshToken_";
  protected final String TEXT_37 = " != null){" + NL + "\t\t\t\t\t\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\t\t\t\t\t\ttoken_";
  protected final String TEXT_38 = " = oauthClient_";
  protected final String TEXT_39 = ".refreshToken(storedRefreshToken_";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_41 = " = oauthClient_";
  protected final String TEXT_42 = ".getSOAPEndpoint(token_";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t\t\t\t\taccessToken_";
  protected final String TEXT_45 = " = token_";
  protected final String TEXT_46 = ".getAccess_token();" + NL + "\t\t\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_47 = " = token_";
  protected final String TEXT_48 = ".getRefresh_token();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tif(accessToken_";
  protected final String TEXT_50 = " == null || endpointURL_";
  protected final String TEXT_51 = " == null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_53 = ".setCallbackHost(";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t\t\toauthClient_";
  protected final String TEXT_55 = ".setCallbackPort(";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\ttoken_";
  protected final String TEXT_57 = " = oauthClient_";
  protected final String TEXT_58 = ".getToken();" + NL + "\t\t\t\t\t\tendpointURL_";
  protected final String TEXT_59 = " = oauthClient_";
  protected final String TEXT_60 = ".getSOAPEndpoint(token_";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t\t\taccessToken_";
  protected final String TEXT_63 = " = token_";
  protected final String TEXT_64 = ".getAccess_token();" + NL + "\t\t\t\t\t\trefreshToken_";
  protected final String TEXT_65 = " = token_";
  protected final String TEXT_66 = ".getRefresh_token();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\tif(tokenFile_";
  protected final String TEXT_68 = " != null && refreshToken_";
  protected final String TEXT_69 = " != null){" + NL + "\t\t\t\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_70 = " = new java.util.Properties();" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_71 = ".setProperty(\"refreshtoken\", refreshToken_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_73 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_74 = ");" + NL + "\t\t\t\t\t\t\tstoreProperties_";
  protected final String TEXT_75 = ".store(outputStream_";
  protected final String TEXT_76 = ", null);" + NL + "\t\t\t\t\t\t\tif(outputStream_";
  protected final String TEXT_77 = " != null){" + NL + "\t\t\t\t\t\t\t    outputStream_";
  protected final String TEXT_78 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_80 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tif(globalMap.get(\"stub_";
  protected final String TEXT_82 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_83 = "\")==null){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_84 = "\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(globalMap.get(\"callOptions_";
  protected final String TEXT_85 = "\")!=null ){" + NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_86 = ".setCallOptions((com.salesforce.soap.partner.CallOptions)globalMap.get(\"callOptions_";
  protected final String TEXT_87 = "\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsfMgr_";
  protected final String TEXT_88 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_89 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_90 = "\"));" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tsfMgr_";
  protected final String TEXT_93 = ".setClientID(";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_96 = " = sfMgr_";
  protected final String TEXT_97 = ".login(accessToken_";
  protected final String TEXT_98 = ", endpointURL_";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_102 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed!\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "                \t\tString decryptedPwd_";
  protected final String TEXT_104 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_105 = ");" + NL + "                \t\t";
  protected final String TEXT_106 = NL + "                \t\tString decryptedPwd_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";" + NL + "                \t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_110 = " = System.getProperties();" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_111 = ".put(\"socksProxyHost\",";
  protected final String TEXT_112 = ");  " + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_113 = ".put(\"socksProxyPort\",";
  protected final String TEXT_114 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_115 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_117 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_118 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t";
  protected final String TEXT_120 = NL + "        \t\t\t";
  protected final String TEXT_121 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_122 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = "; ";
  protected final String TEXT_127 = NL + "\t\t\t\t\tboolean result_";
  protected final String TEXT_128 = " = sfMgr_";
  protected final String TEXT_129 = ".login(";
  protected final String TEXT_130 = ",";
  protected final String TEXT_131 = ", decryptedPassword_";
  protected final String TEXT_132 = ",";
  protected final String TEXT_133 = ",";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t\tif(!result_";
  protected final String TEXT_135 = "){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t";
  protected final String TEXT_138 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));

String cid = node.getUniqueName();
String passwordFieldName = "";

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		if (outgoingConns != null && outgoingConns.size() > 0){
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			String username = ElementParameterParser.getValue(node, "__USER__");

			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
			
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);
			if(!useExistingConn){
				if(useOAuth){
					String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
					String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
					
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_12);
    
					passwordFieldName = "__OAUTH_CLIENT_SECRET__";
					if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    
					} else {
					
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    
					}
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
					String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tokenFile);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}
					
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
						String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
						String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
						
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
					if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
					
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
					}
				}
			}		
			
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    if(useExistingConn){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_90);
    }else{
    stringBuffer.append(TEXT_91);
    if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_94);
    
				}
				if(useOAuth){
				
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
				}else{
					if(useProxy){
						passwordFieldName = "__PROXY_PASSWORD__";
        				if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    
                		} else {
                		
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_108);
    
                		}
					
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
					}
					
    stringBuffer.append(TEXT_119);
    
        			passwordFieldName = "__PASS__";
        			
    stringBuffer.append(TEXT_120);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_123);
    } else {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
				}
				
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    
		}
	}
}

    stringBuffer.append(TEXT_138);
    return stringBuffer.toString();
  }
}
