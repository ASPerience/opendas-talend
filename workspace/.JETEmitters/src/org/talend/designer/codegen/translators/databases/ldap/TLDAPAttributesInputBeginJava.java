package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TLDAPAttributesInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPAttributesInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPAttributesInputBeginJava result = new TLDAPAttributesInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString baseDN_";
  protected final String TEXT_3 = " = \"\";";
  protected final String TEXT_4 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_5 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_6 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "\tenv_";
  protected final String TEXT_7 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "\tenv_";
  protected final String TEXT_8 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_9 = "\");" + NL + "\tenv_";
  protected final String TEXT_10 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_11 = "\");" + NL + "\tenv_";
  protected final String TEXT_12 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_13 = "+\":\"+";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tenv_";
  protected final String TEXT_16 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "; ";
  protected final String TEXT_24 = NL + "\tenv_";
  protected final String TEXT_25 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tenv_";
  protected final String TEXT_28 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_29 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_30 = NL + "\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_31 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t\t\t    ";
  protected final String TEXT_34 = NL + "\t\t\t\t    ";
  protected final String TEXT_35 = " " + NL + "\t\t\t\t    \tfinal String decryptedPwd_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t    ";
  protected final String TEXT_38 = NL + "\t\t\t\t    \tfinal String decryptedPwd_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; " + NL + "\t\t\t\t    ";
  protected final String TEXT_41 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_44 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_45 = ", null);";
  protected final String TEXT_46 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_47 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "\tjavax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_48 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_49 = ".extendedOperation(tldsReq_";
  protected final String TEXT_50 = ");" + NL + "\tjavax.net.ssl.SSLSession session_";
  protected final String TEXT_51 = " = tls_";
  protected final String TEXT_52 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";
  protected final String TEXT_53 = NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_54 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_55 = "\");" + NL + "\tbaseDN_";
  protected final String TEXT_56 = " = (String)globalMap.get(\"";
  protected final String TEXT_57 = "\");";
  protected final String TEXT_58 = NL + NL + "\tint ";
  protected final String TEXT_59 = "_NB_LINE = 0;" + NL + "\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_60 = " = new javax.naming.directory.SearchControls();" + NL + "\tsearchCtls_";
  protected final String TEXT_61 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);" + NL + "\tsearchCtls_";
  protected final String TEXT_62 = ".setTimeLimit(";
  protected final String TEXT_63 = "*1000);" + NL + "\tsearchCtls_";
  protected final String TEXT_64 = ".setCountLimit(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t//get basce dn" + NL + "\t\t\t\t\t\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_67 = " = ctx_";
  protected final String TEXT_68 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "\t\t\t\t\t\tjavax.naming.directory.Attribute aNaming_";
  protected final String TEXT_69 = " = attrsNaming_";
  protected final String TEXT_70 = ".get(\"namingContexts\");" + NL + "\t\t\t\t\t\tif(aNaming_";
  protected final String TEXT_71 = " == null)" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\taNaming_";
  protected final String TEXT_72 = " =attrsNaming_";
  protected final String TEXT_73 = ".get(\"namingcontexts\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t// String searchBase_";
  protected final String TEXT_74 = " = (aNaming_";
  protected final String TEXT_75 = "==null)|())?\"\":aNaming_";
  protected final String TEXT_76 = ".get().toString();\t\t " + NL + "\t\t\t\t\t\tString searchBase_";
  protected final String TEXT_77 = " = ((aNaming_";
  protected final String TEXT_78 = " == null) || ((aNaming_";
  protected final String TEXT_79 = " != null)" + NL + "\t\t\t\t\t\t\t\t\t\t&& (aNaming_";
  protected final String TEXT_80 = ".get().toString() != null)" + NL + "\t\t\t\t\t\t\t\t\t\t&& (aNaming_";
  protected final String TEXT_81 = ".get().toString().length() > 0) && (Character" + NL + "\t\t\t\t\t\t\t\t\t\t.isIdentifierIgnorable(aNaming_";
  protected final String TEXT_82 = ".get().toString().charAt(0))))) ? \"\"" + NL + "\t\t\t\t\t\t\t\t\t\t: aNaming_";
  protected final String TEXT_83 = ".get().toString();";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tString searchBase_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "\t\t\t\t\tString searchBase_";
  protected final String TEXT_88 = " = \"\";";
  protected final String TEXT_89 = NL + "\t\tbaseDN_";
  protected final String TEXT_90 = " = searchBase_";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "\t// Set the page size and initialize the cookie that we pass back in subsequent pages" + NL + "\tint pageSize_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "\tbyte[] cookie_";
  protected final String TEXT_95 = " = null;" + NL + "\t// Request the paged results control" + NL + "\tjavax.naming.ldap.Control[] ctls_";
  protected final String TEXT_96 = " = new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_97 = ", true) };" + NL + "\tctx_";
  protected final String TEXT_98 = ".setRequestControls(ctls_";
  protected final String TEXT_99 = ");" + NL + "\t" + NL + "do {";
  protected final String TEXT_100 = NL + NL + "\tjavax.naming.NamingEnumeration answer_";
  protected final String TEXT_101 = " = ctx_";
  protected final String TEXT_102 = ".search(searchBase_";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ", searchCtls_";
  protected final String TEXT_105 = ");" + NL + "\t" + NL + "\tjavax.naming.directory.DirContext rootSchema_";
  protected final String TEXT_106 = " = ctx_";
  protected final String TEXT_107 = ".getSchema(\"\");" + NL + "\tjava.util.Set<String> objectClasses_";
  protected final String TEXT_108 = " = new java.util.HashSet<String>();" + NL + "\tjava.util.Set<String> objectAttributes_";
  protected final String TEXT_109 = " = new java.util.HashSet<String>();" + NL + "\tjava.util.Set<String> mandatoryAttributes_";
  protected final String TEXT_110 = " = new java.util.HashSet<String>();" + NL + "\tjava.util.Set<String> optionalAttributes_";
  protected final String TEXT_111 = " = new java.util.HashSet<String>();" + NL + "\t" + NL + "\twhile (answer_";
  protected final String TEXT_112 = " .hasMoreElements()) {//a" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t\t";
  protected final String TEXT_114 = " = null;\t\t\t";
  protected final String TEXT_115 = NL + "\t\t";
  protected final String TEXT_116 = "_NB_LINE++;" + NL + "\t\tjavax.naming.directory.Attributes attrs_";
  protected final String TEXT_117 = " = null;";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = " = new ";
  protected final String TEXT_120 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_121 = NL + "\t\t\tjavax.naming.directory.SearchResult sr_";
  protected final String TEXT_122 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_123 = ".next();" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_124 = "_RESULT_NAME\",sr_";
  protected final String TEXT_125 = ".getName());" + NL + "\t\t\tattrs_";
  protected final String TEXT_126 = " = sr_";
  protected final String TEXT_127 = ".getAttributes();" + NL + "\t\t\t" + NL + "\t\t\tobjectClasses_";
  protected final String TEXT_128 = ".clear();" + NL + "\t\t\tobjectAttributes_";
  protected final String TEXT_129 = ".clear();" + NL + "\t\t\tmandatoryAttributes_";
  protected final String TEXT_130 = ".clear();" + NL + "\t\t\toptionalAttributes_";
  protected final String TEXT_131 = ".clear();" + NL + "" + NL + "\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_132 = " = attrs_";
  protected final String TEXT_133 = ".getIDs(); e_";
  protected final String TEXT_134 = ".hasMore();){" + NL + "\t\t\t\tobjectAttributes_";
  protected final String TEXT_135 = ".add((String)e_";
  protected final String TEXT_136 = ".next());\t" + NL + "   \t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_137 = " = attrs_";
  protected final String TEXT_138 = ".get(\"objectClass\").getAll(); e_";
  protected final String TEXT_139 = ".hasMore();){" + NL + "\t\t\t\tobjectClasses_";
  protected final String TEXT_140 = ".add((String)e_";
  protected final String TEXT_141 = ".next());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfor(String objectClass_";
  protected final String TEXT_142 = " : objectClasses_";
  protected final String TEXT_143 = ") {" + NL + "\t\t\t\tjavax.naming.directory.DirContext schema_";
  protected final String TEXT_144 = " = (javax.naming.directory.DirContext) rootSchema_";
  protected final String TEXT_145 = ".lookup(";
  protected final String TEXT_146 = " + objectClass_";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\tjavax.naming.directory.Attributes attributes_";
  protected final String TEXT_148 = " = schema_";
  protected final String TEXT_149 = ".getAttributes(\"\");" + NL + "" + NL + "\t\t\t\tif(attributes_";
  protected final String TEXT_150 = " != null) {" + NL + "\t\t\t\t\tif (attributes_";
  protected final String TEXT_151 = ".get(\"must\") != null) {" + NL + "\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_152 = " = attributes_";
  protected final String TEXT_153 = ".get(\"must\").getAll(); e_";
  protected final String TEXT_154 = ".hasMore();){" + NL + "\t\t\t\t\t\t\tmandatoryAttributes_";
  protected final String TEXT_155 = ".add((String)e_";
  protected final String TEXT_156 = ".next());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif (attributes_";
  protected final String TEXT_157 = ".get(\"may\") != null) {" + NL + "\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_158 = " = attributes_";
  protected final String TEXT_159 = ".get(\"may\").getAll(); e_";
  protected final String TEXT_160 = ".hasMore();){" + NL + "\t\t\t\t\t\t\toptionalAttributes_";
  protected final String TEXT_161 = ".add((String)e_";
  protected final String TEXT_162 = ".next());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tschema_";
  protected final String TEXT_163 = ".close();" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t \t\t// for output" + NL + "\t \t\tStringBuilder attrStr_";
  protected final String TEXT_164 = " = null;";
  protected final String TEXT_165 = "\t\t  " + NL + "\t\tif (attrs_";
  protected final String TEXT_166 = " != null) {//b";
  protected final String TEXT_167 = NL + "\t\t\tattrStr_";
  protected final String TEXT_168 = " = new StringBuilder();" + NL + "\t\t\tfor (String objectAttribute_";
  protected final String TEXT_169 = " : objectAttributes_";
  protected final String TEXT_170 = "){" + NL + "\t\t\t\tif(attrStr_";
  protected final String TEXT_171 = ".length()>0){" + NL + "\t\t\t\t\tattrStr_";
  protected final String TEXT_172 = ".append(";
  protected final String TEXT_173 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tattrStr_";
  protected final String TEXT_174 = ".append(objectAttribute_";
  protected final String TEXT_175 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = attrStr_";
  protected final String TEXT_178 = ".toString();";
  protected final String TEXT_179 = NL + "\t\t\tattrStr_";
  protected final String TEXT_180 = " = new StringBuilder();" + NL + "\t\t\tfor (String mandatoryAttribute_";
  protected final String TEXT_181 = " : mandatoryAttributes_";
  protected final String TEXT_182 = "){" + NL + "\t\t\t\tif(attrStr_";
  protected final String TEXT_183 = ".length()>0){" + NL + "\t\t\t\t\tattrStr_";
  protected final String TEXT_184 = ".append(";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tattrStr_";
  protected final String TEXT_186 = ".append(mandatoryAttribute_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " = attrStr_";
  protected final String TEXT_190 = ".toString();";
  protected final String TEXT_191 = NL + "\t\t\tattrStr_";
  protected final String TEXT_192 = " = new StringBuilder();" + NL + "\t\t\tfor (String optionalAttribute_";
  protected final String TEXT_193 = " : optionalAttributes_";
  protected final String TEXT_194 = "){" + NL + "\t\t\t\tif(attrStr_";
  protected final String TEXT_195 = ".length()>0){" + NL + "\t\t\t\t\tattrStr_";
  protected final String TEXT_196 = ".append(";
  protected final String TEXT_197 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tattrStr_";
  protected final String TEXT_198 = ".append(optionalAttribute_";
  protected final String TEXT_199 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = attrStr_";
  protected final String TEXT_202 = ".toString();";
  protected final String TEXT_203 = NL + "\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = " = attrs_";
  protected final String TEXT_206 = ".get(\"";
  protected final String TEXT_207 = "\");" + NL + "\t\t\tif(attr_";
  protected final String TEXT_208 = "_";
  protected final String TEXT_209 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\tattrStr_";
  protected final String TEXT_210 = " = new StringBuilder();" + NL + "\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_211 = " = attr_";
  protected final String TEXT_212 = "_";
  protected final String TEXT_213 = ".getAll(); e_";
  protected final String TEXT_214 = ".hasMore();){" + NL + "\t\t\t\t\tif(attrStr_";
  protected final String TEXT_215 = ".length()>0){" + NL + "\t\t\t\t\t\tattrStr_";
  protected final String TEXT_216 = ".append(";
  protected final String TEXT_217 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tattrStr_";
  protected final String TEXT_218 = ".append(e_";
  protected final String TEXT_219 = ".next().toString());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = attrStr_";
  protected final String TEXT_222 = ".toString();" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " = null;" + NL + "\t\t\t}\t\t\t";
  protected final String TEXT_225 = NL + "\t\t}//b" + NL + "\t} catch (java.lang.Exception e) {" + NL;
  protected final String TEXT_226 = NL + "\t\tthrow(e);";
  protected final String TEXT_227 = "\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_228 = " = new ";
  protected final String TEXT_229 = "Struct();";
  protected final String TEXT_230 = NL + "\t\t";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = ";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = ";";
  protected final String TEXT_235 = NL + "\t\t\t\t";
  protected final String TEXT_236 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_237 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_238 = " = null;";
  protected final String TEXT_239 = NL + "\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_240 = " = null;";
  protected final String TEXT_241 = NL + "\t\t\t\t";
  protected final String TEXT_242 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = NL + "\t}";
  protected final String TEXT_245 = NL + "///////////////////////////////////\t\t";
  protected final String TEXT_246 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);			
			if(metadata!=null) {

	List<IMetadataColumn> columnList = metadata.getListColumns();
	String cid = node.getUniqueName();
	String limit =ElementParameterParser.getValue(node, "__LIMIT__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	
	boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));	
	String pageSize = ElementParameterParser.getValue(node, "__PAGESIZE__");
	String classDefRoot = ElementParameterParser.getValue(node, "__CLASSDEF_ROOT__");
	String filter=ElementParameterParser.getValue(node, "__FILTER__");
	String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
	String timeout =ElementParameterParser.getValue(node, "__TIMEOUT__");
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");

	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String exConn= "conn_" + connection;
	String exConnBaseDN = "connBaseDN_" + connection;
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(("false").equals(useExistingConn)){
	String authen =ElementParameterParser.getValue(node, "__AUTHENTIFICATION__");
	String user =ElementParameterParser.getValue(node, "__USER__");

	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_14);
    
	if(("true").equals(authen)){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_17);
    
    String passwordFieldName = "__PASS__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
	}
	if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_30);
    
			} else {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_32);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_33);
    
				    String passwordFieldName = "__STORECAPWD__";
				    
    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
	if(("TLS").equals(protocol)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
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
}else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_57);
    
}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_65);
    
				if(("false").equals(useExistingConn)){
					if(baseDN == null || baseDN.length()<=2){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
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
    
					}else{

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_86);
    
					}
				}else{

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
				}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    if(paging){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(pageSize );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

	String rejectConnName = "";
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
		IConnection rejectConn = rejectConns.get(0);
		rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
		rejectColumnList = metadataTable.getListColumns();	  
	}
	
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					if(i==0){
						firstConnName = connTemp.getName();
					}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_114);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	if(firstConnName.length()>0){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_120);
    
	}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(classDefRoot );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
			if (conns!=null) {//1
				if (conns.size()>0) {//2
					IConnection conn = conns.get(0); //the first connection
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
						firstConnName = conn.getName();		 
						
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
					for(IMetadataColumn column:columnList){//5
						if ("objectAttributes".equals(column.getLabel())) {
							// Availible attributes for this object

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
						} else if ("mandatoryAttributes".equals(column.getLabel())) {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
						} else if ("optionalAttributes".equals(column.getLabel())) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
						} else {

    stringBuffer.append(TEXT_203);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_224);
    					
						}
					}//5

    stringBuffer.append(TEXT_225);
    
		if (dieOnError) {

    stringBuffer.append(TEXT_226);
    
		} else {
			if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_229);
    
				for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_234);
    
				}

    stringBuffer.append(TEXT_235);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_238);
    
			} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_239);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_240);
    
			} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_241);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_243);
    
			}
		}

    stringBuffer.append(TEXT_244);
    
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_245);
    
	}
}

    stringBuffer.append(TEXT_246);
    return stringBuffer.toString();
  }
}
