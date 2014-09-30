package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TLDAPInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPInputBeginJava result = new TLDAPInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString baseDN_";
  protected final String TEXT_3 = " = \"\";" + NL + "\tint ";
  protected final String TEXT_4 = "_NB_LINE = 0;";
  protected final String TEXT_5 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_6 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_7 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "    env_";
  protected final String TEXT_8 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "\tenv_";
  protected final String TEXT_9 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_10 = "\");" + NL + "\tenv_";
  protected final String TEXT_11 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "\tenv_";
  protected final String TEXT_14 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_15 = "+\":\"+";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tenv_";
  protected final String TEXT_18 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_19 = "+\":\"+";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "    env_";
  protected final String TEXT_22 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_23 = ");" + NL + "\t";
  protected final String TEXT_24 = NL + "\t";
  protected final String TEXT_25 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "; ";
  protected final String TEXT_31 = NL + "    env_";
  protected final String TEXT_32 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\tenv_";
  protected final String TEXT_35 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_36 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_37 = NL + "\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_38 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_41 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "; ";
  protected final String TEXT_46 = "\t\t\t\t" + NL + "\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "   " + NL + "   \tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_49 = " = null;" + NL + "\ttry{" + NL + "\tctx_";
  protected final String TEXT_50 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_51 = ", null);";
  protected final String TEXT_52 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_53 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "    javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_54 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_55 = ".extendedOperation(tldsReq_";
  protected final String TEXT_56 = ");" + NL + "    javax.net.ssl.SSLSession session_";
  protected final String TEXT_57 = " = tls_";
  protected final String TEXT_58 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";
  protected final String TEXT_59 = NL + "\ttry{" + NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_60 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_61 = "\");" + NL + "\tbaseDN_";
  protected final String TEXT_62 = " = (String)globalMap.get(\"";
  protected final String TEXT_63 = "\");";
  protected final String TEXT_64 = NL + "\t" + NL + "\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_65 = " = new javax.naming.directory.SearchControls();" + NL + "    searchCtls_";
  protected final String TEXT_66 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);";
  protected final String TEXT_67 = NL + "        routines.system.Dynamic dcg_";
  protected final String TEXT_68 = " =  new routines.system.Dynamic();";
  protected final String TEXT_69 = NL + "    searchCtls_";
  protected final String TEXT_70 = ".setReturningAttributes(new String[]{";
  protected final String TEXT_71 = NL + "\t\t\"";
  protected final String TEXT_72 = "\",";
  protected final String TEXT_73 = "    " + NL + "    });";
  protected final String TEXT_74 = NL + "    searchCtls_";
  protected final String TEXT_75 = ".setTimeLimit(";
  protected final String TEXT_76 = "*1000);" + NL + "    searchCtls_";
  protected final String TEXT_77 = ".setCountLimit(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t//get basce dn" + NL + "\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_80 = " = ctx_";
  protected final String TEXT_81 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "    javax.naming.directory.Attribute aNaming_";
  protected final String TEXT_82 = " = attrsNaming_";
  protected final String TEXT_83 = ".get(\"namingContexts\");" + NL + "    if(aNaming_";
  protected final String TEXT_84 = " == null)" + NL + "    {" + NL + "        aNaming_";
  protected final String TEXT_85 = " =attrsNaming_";
  protected final String TEXT_86 = ".get(\"namingcontexts\");" + NL + "    }" + NL + "\t\tbaseDN_";
  protected final String TEXT_87 = " = ((aNaming_";
  protected final String TEXT_88 = " == null) || ((aNaming_";
  protected final String TEXT_89 = " != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_90 = ".get().toString() != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_91 = ".get().toString().length() > 0) && (Character" + NL + "                    .isIdentifierIgnorable(aNaming_";
  protected final String TEXT_92 = ".get().toString().charAt(0))))) ? \"\"" + NL + "                    : aNaming_";
  protected final String TEXT_93 = ".get().toString();";
  protected final String TEXT_94 = NL + "\t\tbaseDN_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ";";
  protected final String TEXT_97 = NL + "\t\tString binaryColumns_";
  protected final String TEXT_98 = " = \"";
  protected final String TEXT_99 = "\";";
  protected final String TEXT_100 = NL + "\t\tString[] columnsInSchema_";
  protected final String TEXT_101 = " = \"";
  protected final String TEXT_102 = "\".split(\",\");" + NL + "\t\tjava.util.Arrays.sort(columnsInSchema_";
  protected final String TEXT_103 = ");" + NL + "    \tjavax.naming.directory.Attributes attrsDyn_";
  protected final String TEXT_104 = " = null;" + NL + "    \tjavax.naming.NamingEnumeration answerDyn_";
  protected final String TEXT_105 = " = ctx_";
  protected final String TEXT_106 = ".search(";
  protected final String TEXT_107 = "baseDN_";
  protected final String TEXT_108 = "\"\"";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = ", searchCtls_";
  protected final String TEXT_111 = ");" + NL + "    \twhile (answerDyn_";
  protected final String TEXT_112 = " .hasMoreElements()) {" + NL + "    \t\tjavax.naming.directory.SearchResult srDyn_";
  protected final String TEXT_113 = "  = (javax.naming.directory.SearchResult) answerDyn_";
  protected final String TEXT_114 = ".next();" + NL + "            attrsDyn_";
  protected final String TEXT_115 = " = srDyn_";
  protected final String TEXT_116 = ".getAttributes();" + NL + "            javax.naming.NamingEnumeration ne_";
  protected final String TEXT_117 = " =attrsDyn_";
  protected final String TEXT_118 = ".getAll();" + NL + "\t\t\twhile(ne_";
  protected final String TEXT_119 = ".hasMoreElements()){" + NL + "\t\t\t\tString element_";
  protected final String TEXT_120 = " = ne_";
  protected final String TEXT_121 = ".nextElement().toString();" + NL + "\t\t\t\tint splitorIndex_";
  protected final String TEXT_122 = " = element_";
  protected final String TEXT_123 = ".indexOf(\":\");" + NL + "\t\t\t\tif(splitorIndex_";
  protected final String TEXT_124 = ">0){" + NL + "\t\t\t\t\tString columnName_";
  protected final String TEXT_125 = " = element_";
  protected final String TEXT_126 = ".substring(0,splitorIndex_";
  protected final String TEXT_127 = ");" + NL + "\t\t\t\t\tif(java.util.Arrays.binarySearch(columnsInSchema_";
  protected final String TEXT_128 = ",columnName_";
  protected final String TEXT_129 = ") < 0 || \"";
  protected final String TEXT_130 = "\".equals(columnName_";
  protected final String TEXT_131 = ")){" + NL + "\t\t\t\t\t\tDynamicMetadata dm_";
  protected final String TEXT_132 = " = new DynamicMetadata();" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_133 = ".setName(columnName_";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_135 = ".setDbName(columnName_";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_137 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t\tif(!dcg_";
  protected final String TEXT_138 = ".metadatas.contains(dm_";
  protected final String TEXT_139 = ")){" + NL + "\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_140 = ".metadatas.add(dm_";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\t\tif(binaryColumns_";
  protected final String TEXT_143 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_144 = "+=\" \";" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_146 = "+=\" \";";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_148 = "+=columnName_";
  protected final String TEXT_149 = ";";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "    \t}";
  protected final String TEXT_151 = NL + "    // Set the page size and initialize the cookie that we pass back in subsequent pages" + NL + "    int pageSize_";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = ";" + NL + "    byte[] cookie_";
  protected final String TEXT_154 = " = null;" + NL + "    // Request the paged results control" + NL + "    javax.naming.ldap.Control[] ctls_";
  protected final String TEXT_155 = " = new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_156 = ", true) };" + NL + "    ctx_";
  protected final String TEXT_157 = ".setRequestControls(ctls_";
  protected final String TEXT_158 = ");" + NL + "    " + NL + "do {";
  protected final String TEXT_159 = NL + "\t\tif(binaryColumns_";
  protected final String TEXT_160 = ".length()>0){" + NL + "\t\t\tjava.util.Hashtable orignal_env_";
  protected final String TEXT_161 = "= ctx_";
  protected final String TEXT_162 = ".getEnvironment();" + NL + "\t\t\torignal_env_";
  protected final String TEXT_163 = ".put(\"java.naming.ldap.attributes.binary\",binaryColumns_";
  protected final String TEXT_164 = ");" + NL + "\t\t\tctx_";
  protected final String TEXT_165 = " = new javax.naming.ldap.InitialLdapContext(orignal_env_";
  protected final String TEXT_166 = ", null);" + NL + "\t\t}";
  protected final String TEXT_167 = NL + NL + "    javax.naming.NamingEnumeration answer_";
  protected final String TEXT_168 = " = ctx_";
  protected final String TEXT_169 = ".search(";
  protected final String TEXT_170 = "baseDN_";
  protected final String TEXT_171 = "\"\"";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ", searchCtls_";
  protected final String TEXT_174 = ");" + NL + "    while (answer_";
  protected final String TEXT_175 = " .hasMoreElements()) {//a";
  protected final String TEXT_176 = NL + "    \t\t";
  protected final String TEXT_177 = " = null;\t\t\t";
  protected final String TEXT_178 = NL + "    \t";
  protected final String TEXT_179 = "_NB_LINE++;" + NL + "    \tjavax.naming.directory.Attributes attrs_";
  protected final String TEXT_180 = " = null;";
  protected final String TEXT_181 = NL + "\t\t";
  protected final String TEXT_182 = " = new ";
  protected final String TEXT_183 = "Struct(); " + NL + "\ttry{";
  protected final String TEXT_184 = NL + NL + "            javax.naming.directory.SearchResult sr_";
  protected final String TEXT_185 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_186 = ".next();" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_187 = "_RESULT_NAME\",sr_";
  protected final String TEXT_188 = ".getName());" + NL + "            attrs_";
  protected final String TEXT_189 = " = sr_";
  protected final String TEXT_190 = ".getAttributes();" + NL + "     \t\t// for output";
  protected final String TEXT_191 = "          " + NL + "        if (attrs_";
  protected final String TEXT_192 = " != null) {//b";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\tif(attrs_";
  protected final String TEXT_194 = ".get(\"";
  protected final String TEXT_195 = "\") !=null){" + NL + "                            \t";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = (byte[])attrs_";
  protected final String TEXT_198 = ".get(\"";
  protected final String TEXT_199 = "\").get();" + NL + "    \t\t\t\t\t\t} else {" + NL + "                           \t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = null;" + NL + "    \t\t\t\t\t\t}";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = " = (\"\".equals(sr_";
  protected final String TEXT_205 = ".getName())?sr_";
  protected final String TEXT_206 = ".getName():(sr_";
  protected final String TEXT_207 = ".getName()+ \",\")) + baseDN_";
  protected final String TEXT_208 = ";";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_210 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\tfor(DynamicMetadata dm_";
  protected final String TEXT_211 = " :dcg_";
  protected final String TEXT_212 = ".metadatas){" + NL + "\t\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_213 = "_";
  protected final String TEXT_214 = " = attrs_";
  protected final String TEXT_215 = ".get(dm_";
  protected final String TEXT_216 = ".getDbName());" + NL + "\t\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_217 = "_";
  protected final String TEXT_218 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\tStringBuilder attrStr_";
  protected final String TEXT_219 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_220 = " = attr_";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = ".getAll(); e_";
  protected final String TEXT_223 = ".hasMore();){" + NL + "\t\t\t\t\t\t    \t\t\t\tif(attrStr_";
  protected final String TEXT_224 = ".length()>0){" + NL + "\t\t\t\t\t\t    \t\t\t\t\tattrStr_";
  protected final String TEXT_225 = ".append(";
  protected final String TEXT_226 = ");" + NL + "\t\t\t\t\t\t    \t\t\t\t}" + NL + "\t\t\t\t\t\t    \t\t\t\tattrStr_";
  protected final String TEXT_227 = ".append(e_";
  protected final String TEXT_228 = ".next().toString());" + NL + "\t\t\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_229 = ".addColumnValue(attrStr_";
  protected final String TEXT_230 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_231 = ".addColumnValue(null);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = dcg_";
  protected final String TEXT_234 = ";";
  protected final String TEXT_235 = NL + "\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = " = attrs_";
  protected final String TEXT_238 = ".get(\"";
  protected final String TEXT_239 = "\");" + NL + "\t\t\tif(attr_";
  protected final String TEXT_240 = "_";
  protected final String TEXT_241 = " != null){";
  protected final String TEXT_242 = "\t\t\t" + NL + "\t\t\t\t\tList list_";
  protected final String TEXT_243 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_244 = " = attr_";
  protected final String TEXT_245 = "_";
  protected final String TEXT_246 = ".getAll(); e_";
  protected final String TEXT_247 = ".hasMore();){" + NL + "    \t\t\t\t \tlist_";
  protected final String TEXT_248 = ".add(e_";
  protected final String TEXT_249 = ".next());" + NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = " = list_";
  protected final String TEXT_252 = ";";
  protected final String TEXT_253 = NL + "    \t\t\tStringBuilder attrStr_";
  protected final String TEXT_254 = " = new StringBuilder();" + NL + "    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_255 = " = attr_";
  protected final String TEXT_256 = "_";
  protected final String TEXT_257 = ".getAll(); e_";
  protected final String TEXT_258 = ".hasMore();){" + NL + "    \t\t\t\tif(attrStr_";
  protected final String TEXT_259 = ".length()>0){" + NL + "    \t\t\t\t\tattrStr_";
  protected final String TEXT_260 = ".append(";
  protected final String TEXT_261 = ");" + NL + "    \t\t\t\t}" + NL + "    \t\t\t\tattrStr_";
  protected final String TEXT_262 = ".append(e_";
  protected final String TEXT_263 = ".next().toString());" + NL + "    \t\t\t}" + NL + "    \t\t\t";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " = attrStr_";
  protected final String TEXT_266 = ".toString();";
  protected final String TEXT_267 = "\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_268 = ".";
  protected final String TEXT_269 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_270 = NL + "\t\t}//b" + NL + "\t} catch (java.lang.Exception e) {" + NL;
  protected final String TEXT_271 = NL + "        throw(e);";
  protected final String TEXT_272 = "                    ";
  protected final String TEXT_273 = NL + "        ";
  protected final String TEXT_274 = " = new ";
  protected final String TEXT_275 = "Struct();";
  protected final String TEXT_276 = NL + "        ";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = ";";
  protected final String TEXT_281 = NL + "                ";
  protected final String TEXT_282 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_283 = ";";
  protected final String TEXT_284 = NL + "                ";
  protected final String TEXT_285 = " = null;";
  protected final String TEXT_286 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_287 = NL + "                ";
  protected final String TEXT_288 = " = null;";
  protected final String TEXT_289 = NL + "            \t";
  protected final String TEXT_290 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_291 = ";";
  protected final String TEXT_292 = NL + "    }";
  protected final String TEXT_293 = NL + "///////////////////////////////////        ";
  protected final String TEXT_294 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
	boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
	List<IMetadataTable> metadatas = node.getMetadataList();
	    if ((metadatas!=null)&&(metadatas.size()>0)) {
	        IMetadataTable metadata = metadatas.get(0);	        
	        if(metadata!=null) {

	List<IMetadataColumn> columnList = metadata.getListColumns();
	String cid = node.getUniqueName();
	String filter=ElementParameterParser.getValue(node, "__FILTER__");
	String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	
	boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));	
	String pageSize =ElementParameterParser.getValue(node, "__PAGESIZE__");
	String limit =ElementParameterParser.getValue(node, "__LIMIT__");
	String timeout =ElementParameterParser.getValue(node, "__TIMEOUT__");
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
	
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String exConn= "conn_" + connection;
	String exConnBaseDN = "connBaseDN_" + connection;
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");
	String authen =ElementParameterParser.getValue(node, "__AUTHENTIFICATION__");
	String user =ElementParameterParser.getValue(node, "__USER__");


    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_12);
    	
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_16);
    
	}else{

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_20);
    
	}
    if(("true").equals(authen)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_23);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_24);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    }
    if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_37);
    
			} else {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_39);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    
                    String passwordFieldName = "__STORECAPWD__";
                    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
				}
			}
		}
    }

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
	if(("TLS").equals(protocol)){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
	}
}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_63);
    
}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
	boolean isDynamic = metadata.isDynamicSchema();
    if(isDynamic){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
	}else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
					for(IMetadataColumn column:columnList){		

    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_72);
    
                	}

    stringBuffer.append(TEXT_73);
    
	}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_78);
    
				if(("false").equals(useExistingConn)){
					if(baseDN == null || baseDN.length()<=2){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
					}else{

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_96);
    
					}
				}

    
	String binaryColumns = "";
	boolean hasDynamicBinary=false;
	if(useFieldOptions){
		for(int i = 0;i<fieldOptions.size();i++){// search in the configuration table
			Map<String, String> line = fieldOptions.get(i);
			String columnName = line.get("SCHEMA_COLUMN");
			Boolean isBinary = "true".equals(line.get("BINARY"));
			if(isBinary){
				IMetadataColumn column = columnList.get(i);
				if(!column.getTalendType().equals("id_Dynamic")){
					if(binaryColumns.length()>0){
						binaryColumns+=" ";
					}
					binaryColumns+=column.getOriginalDbColumnName();
				}else{
					hasDynamicBinary = true;
				}
			}
		}
	}
	boolean hasBinaryColumn = binaryColumns.length()>0 || hasDynamicBinary;
	if(hasBinaryColumn){

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(binaryColumns);
    stringBuffer.append(TEXT_99);
    
	}
    if(isDynamic){
    	String columnsStr = "";
		for(IMetadataColumn column:columnList){
			columnsStr += column.getOriginalDbColumnName() + ",";
		}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnsStr);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
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
    stringBuffer.append(metadata.getDynamicColumn().getOriginalDbColumnName());
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
    
							if(hasDynamicBinary){
								if(binaryColumns.length()==0){

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
								}else{

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
								}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
							}

    stringBuffer.append(TEXT_150);
    
	}

    if(paging){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(pageSize );
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
    }
    
	if(hasBinaryColumn){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
	}

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
	List< ? extends IConnection> conns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	if(conns.size() == 0){
		conns = node.getOutgoingConnections(EConnectionType.FLOW_MERGE);
	}
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
        		if(i==0){
        			firstConnName = connTemp.getName();
        		}
        		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_177);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
	if(firstConnName.length()>0){

    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_183);
    
	}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
            if (conns!=null) {//1
                if (conns.size()>0) {//2
                    IConnection conn = conns.get(0); //the first connection
                    firstConnName = conn.getName();         
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
                        
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
					for(IMetadataColumn column:columnList){//5		
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    
						}else{
							if("dn".equals(column.getLabel().toLowerCase())){

    stringBuffer.append(TEXT_202);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
							}else{

    
							if("id_Dynamic".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
							}else{

    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
								if(javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    				
								} else {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
								}

    stringBuffer.append(TEXT_267);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_269);
    
								}
							}
						}
                	}//5

    stringBuffer.append(TEXT_270);
    
        if (dieOnError) {

    stringBuffer.append(TEXT_271);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_275);
    
                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_276);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_280);
    
                }

    stringBuffer.append(TEXT_281);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_285);
    
            } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_288);
    
            } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_291);
    
			}
        }

    stringBuffer.append(TEXT_292);
    
        }//3
    }//2
    
}//1


    stringBuffer.append(TEXT_293);
    
  }
}  
 
    stringBuffer.append(TEXT_294);
    return stringBuffer.toString();
  }
}
