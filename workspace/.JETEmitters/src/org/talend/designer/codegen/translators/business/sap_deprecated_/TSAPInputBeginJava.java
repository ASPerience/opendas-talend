package org.talend.designer.codegen.translators.business.sap_deprecated_;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSAPInputBeginJava
{
  protected static String nl;
  public static synchronized TSAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPInputBeginJava result = new TSAPInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t//" + NL + "\t\t\t\t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_5 = ".getString(";
  protected final String TEXT_6 = "),";
  protected final String TEXT_7 = ");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".getValue(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = ParserUtils.parseTo_";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ".getString(";
  protected final String TEXT_18 = "));" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + NL + "\t";
  protected final String TEXT_21 = NL + NL + "\t";
  protected final String TEXT_22 = NL + NL + "\t";
  protected final String TEXT_23 = NL + "    " + NL + "\t";
  protected final String TEXT_24 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "; ";
  protected final String TEXT_30 = NL + "\t" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t";
  protected final String TEXT_33 = "\t    " + NL + "\t\t\tclient_";
  protected final String TEXT_34 = " = (com.sap.mw.jco.JCO.Client)globalMap.get(\"conn_";
  protected final String TEXT_35 = "\");\t" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tjava.util.Properties properties_";
  protected final String TEXT_38 = " = new java.util.Properties();" + NL + "\t\ttry{" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_40 = ".put(\"jco.client.type\", \"3\");" + NL + "        \t\tif (";
  protected final String TEXT_41 = " != null) properties_";
  protected final String TEXT_42 = ".put(\"jco.client.client\", ";
  protected final String TEXT_43 = ");" + NL + "        \t\tif (";
  protected final String TEXT_44 = " != null) properties_";
  protected final String TEXT_45 = ".put(\"jco.client.user\", ";
  protected final String TEXT_46 = ");" + NL + "        \t\tif (decryptedPassword_";
  protected final String TEXT_47 = " != null) properties_";
  protected final String TEXT_48 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_49 = ");" + NL + "        \t\tif (";
  protected final String TEXT_50 = " != null) properties_";
  protected final String TEXT_51 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_52 = ");" + NL + "        \t\tif (";
  protected final String TEXT_53 = " != null) properties_";
  protected final String TEXT_54 = ".put(\"jco.client.ashost\", ";
  protected final String TEXT_55 = ");" + NL + "        \t\tif (";
  protected final String TEXT_56 = " != null) properties_";
  protected final String TEXT_57 = ".put(\"jco.client.sysnr\", ";
  protected final String TEXT_58 = ");\t" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t//Create a client connection to Message Server " + NL + "\t\t\t\tproperties_";
  protected final String TEXT_60 = ".put(\"jco.client.type\", \"3\");" + NL + "                if (";
  protected final String TEXT_61 = " != null) properties_";
  protected final String TEXT_62 = ".put(\"jco.client.client\", ";
  protected final String TEXT_63 = ");" + NL + "        \t\tif (";
  protected final String TEXT_64 = " != null) properties_";
  protected final String TEXT_65 = ".put(\"jco.client.user\", ";
  protected final String TEXT_66 = ");" + NL + "        \t\tif (decryptedPassword_";
  protected final String TEXT_67 = " != null) properties_";
  protected final String TEXT_68 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_69 = ");" + NL + "        \t\tif (";
  protected final String TEXT_70 = " != null) properties_";
  protected final String TEXT_71 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_72 = ");" + NL + "        \t\tif (";
  protected final String TEXT_73 = " != null) properties_";
  protected final String TEXT_74 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_75 = ");" + NL + "        \t\tif (";
  protected final String TEXT_76 = " != null) properties_";
  protected final String TEXT_77 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_78 = ");" + NL + "        \t\tif (";
  protected final String TEXT_79 = " != null) properties_";
  protected final String TEXT_80 = ".put(\"jco.client.group\", ";
  protected final String TEXT_81 = ");" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t";
  protected final String TEXT_83 = NL + "        \t\tproperties_";
  protected final String TEXT_84 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "        \t\tproperties_";
  protected final String TEXT_85 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_86 = ");" + NL + "        \t\tproperties_";
  protected final String TEXT_87 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_88 = "));" + NL + "        \t\t";
  protected final String TEXT_89 = NL + "            \t\tif(";
  protected final String TEXT_90 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_91 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_92 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_93 = NL + "        \t\t";
  protected final String TEXT_94 = NL + "            \t\tif(";
  protected final String TEXT_95 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_96 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_97 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_98 = NL + "        \t";
  protected final String TEXT_99 = NL + "        \t";
  protected final String TEXT_100 = "\t" + NL + "        \t\tproperties_";
  protected final String TEXT_101 = ".put(";
  protected final String TEXT_102 = " ,";
  protected final String TEXT_103 = ");" + NL + "        \t\t";
  protected final String TEXT_104 = NL + "        \tclient_";
  protected final String TEXT_105 = " = com.sap.mw.jco.JCO.createClient(properties_";
  protected final String TEXT_106 = ");" + NL + "\t\t\t// Open the connection" + NL + "\t\t\tclient_";
  protected final String TEXT_107 = ".connect();" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\t\tclient_";
  protected final String TEXT_109 = ".setSapGui(2);" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = "      " + NL + "\t    com.sap.mw.jco.IRepository repository_";
  protected final String TEXT_112 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_113 = ");" + NL + "\t" + NL + "\t    com.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_114 = " = repository_";
  protected final String TEXT_115 = ".getFunctionTemplate(";
  protected final String TEXT_116 = ");" + NL + "\t    " + NL + "\t\tif(functionTemplate_";
  protected final String TEXT_117 = " == null){" + NL + "\t\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_118 = ");" + NL + "\t\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_119 = " + \".\");" + NL + "\t\t}        " + NL + "\t" + NL + "\t    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_120 = " = functionTemplate_";
  protected final String TEXT_121 = ".getFunction();" + NL + "\t" + NL + "\t    com.sap.mw.jco.JCO.ParameterList importParameterList_";
  protected final String TEXT_122 = " = function_";
  protected final String TEXT_123 = ".getImportParameterList();" + NL + "\t    com.sap.mw.jco.JCO.ParameterList exportParameterList_";
  protected final String TEXT_124 = " = function_";
  protected final String TEXT_125 = ".getExportParameterList();" + NL + "\t    com.sap.mw.jco.JCO.ParameterList tableParameterList_";
  protected final String TEXT_126 = " = function_";
  protected final String TEXT_127 = ".getTableParameterList();" + NL + "\t    " + NL + "\t    com.sap.mw.jco.JCO.Structure input_structure_";
  protected final String TEXT_128 = "=null;" + NL + "\t    com.sap.mw.jco.JCO.Table input_table_";
  protected final String TEXT_129 = "=null; " + NL + "\t    com.sap.mw.jco.JCO.Table  table_input_";
  protected final String TEXT_130 = "=null; " + NL + "\t";
  protected final String TEXT_131 = NL + "\t\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_132 = " = null;" + NL + "\t\t";
  protected final String TEXT_133 = "\t" + NL + "\t\t\tdest_";
  protected final String TEXT_134 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"conn_";
  protected final String TEXT_135 = "\");";
  protected final String TEXT_136 = NL + "\t\t\t\t\tif(dest_";
  protected final String TEXT_137 = " == null){" + NL + "\t\t\t\t\t\tdest_";
  protected final String TEXT_138 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_139 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_140 = NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t";
  protected final String TEXT_142 = NL + "\t\ttry{";
  protected final String TEXT_143 = NL + "\t\t\t\t\tdest_";
  protected final String TEXT_144 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t            if (null == dest_";
  protected final String TEXT_147 = ") {";
  protected final String TEXT_148 = NL + "\t\t\t\t\torg.talend.sap.TSAPDestinationData destinationData_";
  protected final String TEXT_149 = " = null;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tjava.util.Properties properties_";
  protected final String TEXT_150 = " = new java.util.Properties();" + NL + "        \t\t\t";
  protected final String TEXT_151 = NL + "                \t\tproperties_";
  protected final String TEXT_152 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "                \t\tproperties_";
  protected final String TEXT_153 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_154 = ");" + NL + "                \t\tproperties_";
  protected final String TEXT_155 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_156 = "));" + NL + "                \t\t";
  protected final String TEXT_157 = NL + "                    \t\tif(";
  protected final String TEXT_158 = " != null){" + NL + "                    \t\t\tproperties_";
  protected final String TEXT_159 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_160 = ");" + NL + "                    \t\t}" + NL + "                \t\t";
  protected final String TEXT_161 = NL + "                \t\t";
  protected final String TEXT_162 = NL + "                    \t\tif(";
  protected final String TEXT_163 = " != null){" + NL + "                    \t\t\tproperties_";
  protected final String TEXT_164 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_165 = ");" + NL + "                    \t\t}" + NL + "                \t\t";
  protected final String TEXT_166 = NL + "                \t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t";
  protected final String TEXT_168 = "\t" + NL + "                \t\tproperties_";
  protected final String TEXT_169 = ".put(";
  protected final String TEXT_170 = " ,";
  protected final String TEXT_171 = ");" + NL + "                \t\t";
  protected final String TEXT_172 = NL + "        \t\t\t";
  protected final String TEXT_173 = NL + "        \t\t\t\tdestinationData_";
  protected final String TEXT_174 = " = new org.talend.sap.TSAPApplicationServerDestData.Builder(";
  protected final String TEXT_175 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_177 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_178 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ")" + NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_183 = ")" + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "        \t\t\t";
  protected final String TEXT_184 = "\t\t\t" + NL + "        \t\t\t\tdestinationData_";
  protected final String TEXT_185 = " = new org.talend.sap.TSAPMessageServerDestData.Builder(";
  protected final String TEXT_186 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_188 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = "," + NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = "," + NL + "        \t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = ")" + NL + "        \t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_195 = ")" + NL + "            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "        \t\t\t";
  protected final String TEXT_196 = NL + "        \t\t    ";
  protected final String TEXT_197 = NL + "        \t\t\t\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "        \t\t\t";
  protected final String TEXT_198 = NL + "        \t\t\tdest_";
  protected final String TEXT_199 = " = org.talend.sap.TSAPDestinationFactory.getInstance().getDestination(destinationData_";
  protected final String TEXT_200 = ");" + NL + "        \t\t\t// Begins the stateful call sequence for calls to the specified destination." + NL + "\t\t    \t\tcom.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + "\t\t\t\t}";
  protected final String TEXT_203 = NL + "\t\t";
  protected final String TEXT_204 = " " + NL + "\t\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_205 = " = dest_";
  protected final String TEXT_206 = ".getRepository();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_207 = " = repository_";
  protected final String TEXT_208 = ".getFunctionTemplate(";
  protected final String TEXT_209 = ");" + NL + "\t\tif(functionTemplate_";
  protected final String TEXT_210 = " == null){" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_211 = ");" + NL + "\t\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_212 = " + \".\");" + NL + "\t\t}  " + NL + "\t\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_213 = " = functionTemplate_";
  protected final String TEXT_214 = ".getFunction();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoParameterList importParameterList_";
  protected final String TEXT_215 = " = function_";
  protected final String TEXT_216 = ".getImportParameterList();" + NL + "\t    com.sap.conn.jco.JCoParameterList exportParameterList_";
  protected final String TEXT_217 = " = function_";
  protected final String TEXT_218 = ".getExportParameterList();" + NL + "\t    com.sap.conn.jco.JCoParameterList tableParameterList_";
  protected final String TEXT_219 = " = function_";
  protected final String TEXT_220 = ".getTableParameterList();" + NL + "\t    " + NL + "\t    com.sap.conn.jco.JCoStructure input_structure_";
  protected final String TEXT_221 = "=null;" + NL + "\t    com.sap.conn.jco.JCoTable input_table_";
  protected final String TEXT_222 = "=null; " + NL + "\t    com.sap.conn.jco.JCoTable table_input_";
  protected final String TEXT_223 = "=null; " + NL + "\t";
  protected final String TEXT_224 = NL + "\t" + NL + "    Object isListObject_";
  protected final String TEXT_225 = "=null;" + NL + "        " + NL + "\t";
  protected final String TEXT_226 = NL + "\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\timportParameterList_";
  protected final String TEXT_228 = ".setValue(";
  protected final String TEXT_229 = ",";
  protected final String TEXT_230 = "); // \"input_single\"" + NL + "\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\timportParameterList_";
  protected final String TEXT_232 = ".setValue(";
  protected final String TEXT_233 = ",";
  protected final String TEXT_234 = "); // \"input_single\"" + NL + "\t\t\t";
  protected final String TEXT_235 = "\t\t" + NL + "\t\t";
  protected final String TEXT_236 = NL + "\t\t\tinput_structure_";
  protected final String TEXT_237 = " = importParameterList_";
  protected final String TEXT_238 = ".getStructure(";
  protected final String TEXT_239 = ");\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\tinput_structure_";
  protected final String TEXT_242 = ".setValue(";
  protected final String TEXT_243 = ",";
  protected final String TEXT_244 = ");\t// \"input_structure\"" + NL + "\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\tinput_structure_";
  protected final String TEXT_246 = ".setValue(";
  protected final String TEXT_247 = ",";
  protected final String TEXT_248 = ");\t// \"input_structure\"" + NL + "\t\t\t\t";
  protected final String TEXT_249 = "\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\tjava.util.List list_";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = "_";
  protected final String TEXT_253 = " = new java.util.ArrayList();\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_255 = "_";
  protected final String TEXT_256 = "_";
  protected final String TEXT_257 = ".add(";
  protected final String TEXT_258 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\tisListObject_";
  protected final String TEXT_260 = " = ";
  protected final String TEXT_261 = ";" + NL + "\t\t\t\t\tif(isListObject_";
  protected final String TEXT_262 = " instanceof java.util.List){" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_263 = "_";
  protected final String TEXT_264 = "_";
  protected final String TEXT_265 = ".addAll((java.util.List)isListObject_";
  protected final String TEXT_266 = ");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_267 = "_";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = ".add(";
  protected final String TEXT_270 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\tint rowSize_";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_274 = NL + "\t\t\t\t\trowSize_";
  protected final String TEXT_275 = "_";
  protected final String TEXT_276 = " = list_";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = "_";
  protected final String TEXT_279 = ".size();\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\tif(rowSize_";
  protected final String TEXT_281 = "_";
  protected final String TEXT_282 = "!=list_";
  protected final String TEXT_283 = "_";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = ".size()){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The row count of column: ";
  protected final String TEXT_286 = " in table: ";
  protected final String TEXT_287 = " not equals others, please make sure the row count of every columns equal.\");" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\tinput_table_";
  protected final String TEXT_289 = " = importParameterList_";
  protected final String TEXT_290 = ".getTable(";
  protected final String TEXT_291 = ");" + NL + "\t\t\tinput_table_";
  protected final String TEXT_292 = ".appendRows(rowSize_";
  protected final String TEXT_293 = "_";
  protected final String TEXT_294 = ");" + NL + "\t\t\tinput_table_";
  protected final String TEXT_295 = ".firstRow();" + NL + "\t\t\tfor(int rowNum_";
  protected final String TEXT_296 = "=0; rowNum_";
  protected final String TEXT_297 = " < rowSize_";
  protected final String TEXT_298 = "_";
  protected final String TEXT_299 = "; rowNum_";
  protected final String TEXT_300 = "++){\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_301 = NL + "\t\t\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t\t\t\tinput_table_";
  protected final String TEXT_303 = ".setValue(list_";
  protected final String TEXT_304 = "_";
  protected final String TEXT_305 = "_";
  protected final String TEXT_306 = ".get(rowNum_";
  protected final String TEXT_307 = "),";
  protected final String TEXT_308 = ");// \"table_input\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\t\tinput_table_";
  protected final String TEXT_310 = ".setValue(";
  protected final String TEXT_311 = ",list_";
  protected final String TEXT_312 = "_";
  protected final String TEXT_313 = "_";
  protected final String TEXT_314 = ".get(rowNum_";
  protected final String TEXT_315 = "));// \"table_input\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\t\tinput_table_";
  protected final String TEXT_318 = ".nextRow();" + NL + "\t\t\t}\t" + NL + "\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\tjava.util.List list_";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = "_";
  protected final String TEXT_322 = " = new java.util.ArrayList();\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_324 = "_";
  protected final String TEXT_325 = "_";
  protected final String TEXT_326 = ".add(";
  protected final String TEXT_327 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\tisListObject_";
  protected final String TEXT_329 = " = ";
  protected final String TEXT_330 = ";" + NL + "\t\t\t\t\tif(isListObject_";
  protected final String TEXT_331 = " instanceof java.util.List){" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_332 = "_";
  protected final String TEXT_333 = "_";
  protected final String TEXT_334 = ".addAll((java.util.List)isListObject_";
  protected final String TEXT_335 = ");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_336 = "_";
  protected final String TEXT_337 = "_";
  protected final String TEXT_338 = ".add(";
  protected final String TEXT_339 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_340 = NL + "\t\t\tint rowSize_";
  protected final String TEXT_341 = "_";
  protected final String TEXT_342 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t\trowSize_";
  protected final String TEXT_344 = "_";
  protected final String TEXT_345 = " = list_";
  protected final String TEXT_346 = "_";
  protected final String TEXT_347 = "_";
  protected final String TEXT_348 = ".size();\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\t\tif(rowSize_";
  protected final String TEXT_350 = "_";
  protected final String TEXT_351 = "!=list_";
  protected final String TEXT_352 = "_";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = ".size()){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The row count of column: ";
  protected final String TEXT_355 = " in table: ";
  protected final String TEXT_356 = " not equals others, please make sure the row count of every columns equal.\");" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\ttable_input_";
  protected final String TEXT_358 = " = tableParameterList_";
  protected final String TEXT_359 = ".getTable(";
  protected final String TEXT_360 = ");" + NL + "\t\t\ttable_input_";
  protected final String TEXT_361 = ".appendRows(rowSize_";
  protected final String TEXT_362 = "_";
  protected final String TEXT_363 = ");" + NL + "\t\t\ttable_input_";
  protected final String TEXT_364 = ".firstRow();" + NL + "\t\t\tfor(int rowNum_";
  protected final String TEXT_365 = "=0;rowNum_";
  protected final String TEXT_366 = "<rowSize_";
  protected final String TEXT_367 = "_";
  protected final String TEXT_368 = ";rowNum_";
  protected final String TEXT_369 = "++){\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t";
  protected final String TEXT_371 = NL + "\t\t\t\t\t\ttable_input_";
  protected final String TEXT_372 = ".setValue(list_";
  protected final String TEXT_373 = "_";
  protected final String TEXT_374 = "_";
  protected final String TEXT_375 = ".get(rowNum_";
  protected final String TEXT_376 = "),";
  protected final String TEXT_377 = ");// \"input_table\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_378 = NL + "\t\t\t\t\t\ttable_input_";
  protected final String TEXT_379 = ".setValue(";
  protected final String TEXT_380 = ",list_";
  protected final String TEXT_381 = "_";
  protected final String TEXT_382 = "_";
  protected final String TEXT_383 = ".get(rowNum_";
  protected final String TEXT_384 = "));// \"input_table\"" + NL + "\t\t\t\t\t";
  protected final String TEXT_385 = NL + "\t\t\t\t";
  protected final String TEXT_386 = NL + "\t\t\t\ttable_input_";
  protected final String TEXT_387 = ".nextRow();" + NL + "\t\t\t}\t" + NL + "\t\t";
  protected final String TEXT_388 = "        " + NL + "\t";
  protected final String TEXT_389 = NL + "\t\ttry{" + NL + "    \t\tclient_";
  protected final String TEXT_390 = ".execute(function_";
  protected final String TEXT_391 = ");" + NL + "\t    }catch (java.lang.Exception e_";
  protected final String TEXT_392 = ") {" + NL + "\t\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_393 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_394 = ".getMessage());" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_395 = NL + "\t\ttry{" + NL + "\t\t\tfunction_";
  protected final String TEXT_396 = ".execute(dest_";
  protected final String TEXT_397 = ");" + NL + "\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_398 = ") {" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_399 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_400 = ".getMessage());" + NL + "\t\t}";
  protected final String TEXT_401 = NL + "\t";
  protected final String TEXT_402 = NL + "\t\tboolean go_";
  protected final String TEXT_403 = " = true;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_404 = NL + "\t\t\t";
  protected final String TEXT_405 = NL + "\t\t\t\tcom.sap.mw.jco.JCO.Table table_";
  protected final String TEXT_406 = "_";
  protected final String TEXT_407 = " = exportParameterList_";
  protected final String TEXT_408 = ".getTable(";
  protected final String TEXT_409 = ");" + NL + "\t\t\t";
  protected final String TEXT_410 = NL + "\t\t\t\tcom.sap.conn.jco.JCoTable table_";
  protected final String TEXT_411 = "_";
  protected final String TEXT_412 = " = exportParameterList_";
  protected final String TEXT_413 = ".getTable(";
  protected final String TEXT_414 = ");" + NL + "\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\tgo_";
  protected final String TEXT_416 = " = !table_";
  protected final String TEXT_417 = "_";
  protected final String TEXT_418 = ".isEmpty();" + NL + "\t\t";
  protected final String TEXT_419 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_420 = NL + "\t\t\t";
  protected final String TEXT_421 = NL + "\t\t\t\tcom.sap.mw.jco.JCO.Table table_";
  protected final String TEXT_422 = "_";
  protected final String TEXT_423 = " = tableParameterList_";
  protected final String TEXT_424 = ".getTable(";
  protected final String TEXT_425 = ");" + NL + "\t\t\t";
  protected final String TEXT_426 = NL + "\t\t\t\tcom.sap.conn.jco.JCoTable table_";
  protected final String TEXT_427 = "_";
  protected final String TEXT_428 = " = tableParameterList_";
  protected final String TEXT_429 = ".getTable(";
  protected final String TEXT_430 = ");" + NL + "\t\t\t";
  protected final String TEXT_431 = NL + "\t\t\tgo_";
  protected final String TEXT_432 = " = !table_";
  protected final String TEXT_433 = "_";
  protected final String TEXT_434 = ".isEmpty();" + NL + "\t\t";
  protected final String TEXT_435 = "\t\t" + NL + "\t";
  protected final String TEXT_436 = NL + NL + "\twhile(" + NL + "\t";
  protected final String TEXT_437 = NL + "\t\t";
  protected final String TEXT_438 = "go_";
  protected final String TEXT_439 = NL + "\t\t";
  protected final String TEXT_440 = "){" + NL + "\t\t\t";
  protected final String TEXT_441 = NL + "\t\t\t\t";
  protected final String TEXT_442 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_443 = NL + NL + "\t\t\t";
  protected final String TEXT_444 = NL + NL + "\t\t\t\t";
  protected final String TEXT_445 = NL + "\t\t\t    \tif (true) {" + NL + "\t\t\t    \t\tthrow new java.lang.Exception(\"The connection for schema ";
  protected final String TEXT_446 = " is with problem, they must be the same name.\");" + NL + "    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_447 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t    \tif (true) {" + NL + "\t\t\t    \t\tthrow new java.lang.Exception(\"Please make sure to configure the \\\"Outputs->Mapping->Schema XpathQuerys\\\" for schema ";
  protected final String TEXT_449 = "\");    " + NL + "\t\t\t    \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_450 = NL + "\t\t\t\tif(go_";
  protected final String TEXT_451 = "){" + NL + "\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_452 = NL + "\t\t\t\t\t\tgo_";
  protected final String TEXT_453 = " = false;\t" + NL + "\t\t\t    \t\t";
  protected final String TEXT_454 = " = new ";
  protected final String TEXT_455 = "Struct();" + NL + "\t\t\t            ";
  protected final String TEXT_456 = NL + "\t\t\t            \t// \"output_single\"--";
  protected final String TEXT_457 = NL + "\t\t\t            \t";
  protected final String TEXT_458 = NL + "\t\t\t            \t";
  protected final String TEXT_459 = "           \t" + NL + "\t\t\t        ";
  protected final String TEXT_460 = NL + "\t\t\t        \tgo_";
  protected final String TEXT_461 = " = false;" + NL + "\t\t\t        \t";
  protected final String TEXT_462 = NL + "\t\t\t\t\t\t\tcom.sap.mw.jco.JCO.Structure output_structure_";
  protected final String TEXT_463 = "_";
  protected final String TEXT_464 = " = exportParameterList_";
  protected final String TEXT_465 = ".getStructure(";
  protected final String TEXT_466 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_467 = NL + "\t\t\t\t\t\t\tcom.sap.conn.jco.JCoStructure output_structure_";
  protected final String TEXT_468 = "_";
  protected final String TEXT_469 = " = exportParameterList_";
  protected final String TEXT_470 = ".getStructure(";
  protected final String TEXT_471 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_472 = NL + "\t\t\t    \t\t";
  protected final String TEXT_473 = " = new ";
  protected final String TEXT_474 = "Struct();" + NL + "\t\t\t            ";
  protected final String TEXT_475 = NL + "\t\t\t\t            // \"output_structure\"--";
  protected final String TEXT_476 = NL + "\t\t\t\t            ";
  protected final String TEXT_477 = NL + "\t\t\t            \t";
  protected final String TEXT_478 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_479 = NL + "\t\t\t    \t\tif(table_";
  protected final String TEXT_480 = "_";
  protected final String TEXT_481 = ".isLastRow()){ //check the flag first" + NL + "\t\t\t    \t\t\tgo_";
  protected final String TEXT_482 = " = false;" + NL + "\t\t\t    \t\t}        \t" + NL + "\t    \t\t\t\t";
  protected final String TEXT_483 = " = new ";
  protected final String TEXT_484 = "Struct();" + NL + "\t            \t\t";
  protected final String TEXT_485 = "\t" + NL + "\t\t\t\t            // \"table_output\" or \"output_table\"--";
  protected final String TEXT_486 = NL + "\t\t\t\t            ";
  protected final String TEXT_487 = NL + "\t            \t\t\t";
  protected final String TEXT_488 = " \t" + NL + "\t\t\t            if(go_";
  protected final String TEXT_489 = "){" + NL + "\t            \t\t\ttable_";
  protected final String TEXT_490 = "_";
  protected final String TEXT_491 = ".nextRow();" + NL + "\t            \t\t}     " + NL + "\t\t            ";
  protected final String TEXT_492 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_493 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class AssignUtil{
    	public void gen(IConnection justConn,IMetadataColumn justColumn,String value,String paramName){
    		
    		String typeToGenerate = JavaTypesManager.getTypeToGenerate(justColumn.getTalendType(), justColumn.isNullable());
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(justColumn.getTalendType());
			String patternValue = justColumn.getPattern() == null || justColumn.getPattern().trim().length() == 0 ? null : justColumn.getPattern();
			
			if(javaType == JavaTypesManager.DATE) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_7);
    
			} else if(javaType == JavaTypesManager.OBJECT) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_12);
    
			} else{
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(justColumn.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_18);
    
			}
    	}
    }
	
    stringBuffer.append(TEXT_19);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    stringBuffer.append(TEXT_20);
    	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ( metadatas != null && metadatas.size() > 0 ) {
		metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn == null || firstColumnList == null)
	{
		return "";
	}
	
    stringBuffer.append(TEXT_21);
             
	List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
	
	List<Map<String, String>> tempSchemaBufferBaseOnLink = new ArrayList<Map<String, String>>();
	//filter some values for schemas, because it should be base on Connection, because some Connection maybe deactivate.
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
	            for(Map<String, String> schemaMap : schemas) {
	            	String schemaName = schemaMap.get("SCHEMA");
	    			if(schemaName.equals(conn.getName())){
						tempSchemaBufferBaseOnLink.add(schemaMap);
	    			}
	    		}	
			}
		}
	}
	schemas =  tempSchemaBufferBaseOnLink;
	
    stringBuffer.append(TEXT_22);
    
	boolean startIterate = false;
	String firstDataConnName = firstDataConn.getName();
	
	String client = ElementParameterParser.getValue(node, "__CLIENT__");
	String userid = ElementParameterParser.getValue(node, "__USERID__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
	String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
	String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
	
	String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
	String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
	String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
	
	String functionName = ElementParameterParser.getValue(node, "__SAP_FUNCTION__");
	
	String iterate_out_type = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TYPE__");
	String iterate_out_tablename = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TABLENAME__");
	String [] iterate_out_multi = iterate_out_tablename.split(",");
	for(int k = 0; k < iterate_out_multi.length; k++){
		if(iterate_out_multi[k] != null){
			iterate_out_multi[k] = iterate_out_multi[k].trim();
		}
	}
	List<String> iterate_out_multi_list = Arrays.asList(iterate_out_multi);
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
	String version = "sapjco.jar";
    if(useExistingConn){
	    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
	    for(INode targetNode : nodes){
	    	if (targetNode.getUniqueName().equals(connection)) {
		      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
		    }
	    }
	}else{
		version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}
	
    String passwordFieldName = "__PASSWORD__";
    
    boolean activeSNC = ("true").equals(ElementParameterParser.getValue(node,"__SNC_ACTIVE__"));
    String partnerSNCName = ElementParameterParser.getValue(node,"__SNC_PARTNER_NAME__");
    String mySNCName = ElementParameterParser.getValue(node,"__SNC_MY_NAME__");
    String sncLevel = ElementParameterParser.getValue(node,"__SNC_LEVEL__");
    String sncLibPath = ElementParameterParser.getValue(node,"__SNC_LIB_PATH__");
    boolean hasSNCLibPath = sncLibPath != null && !"".equals(sncLibPath);
    boolean hasMySNCName = mySNCName != null && !"".equals(mySNCName);
    
    List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");    
	
    stringBuffer.append(TEXT_23);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(useExistingConn){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    }else{
    stringBuffer.append(TEXT_36);
    //big try
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    
        	if(activeSNC){
        	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_88);
    if(hasMySNCName){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
        	}
        	
    stringBuffer.append(TEXT_99);
    
            if(sapProps!=null) {
        		for(Map<String, String> item : sapProps){
        		
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_103);
     
        		}
            }
        	
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    if(useFtpHttp){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    if(useExistingConn){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_135);
    	
			INode connectionNode = null; 
			for (INode processNode : node.getProcess().getGeneratingNodes()) { 
				if(connection.equals(processNode.getUniqueName())) { 
					connectionNode = processNode; 
					break; 
				} 
			} 
			boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
			if(specify_alias){
				String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
				if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_139);
    
				}
			}

    stringBuffer.append(TEXT_140);
    }else{
    stringBuffer.append(TEXT_141);
    //big try
    stringBuffer.append(TEXT_142);
    
			boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	 		if(specify_alias){
				String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
				if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_145);
    
				}

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
			}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
                	if(activeSNC){
                	
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_156);
    if(hasMySNCName){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_162);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    
                	}
                	
    stringBuffer.append(TEXT_167);
    
                    if(sapProps!=null) {
                		for(Map<String, String> item : sapProps){
                		
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_171);
     
                		}
                    }
                	
    stringBuffer.append(TEXT_172);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_180);
    if(useFtpHttp){
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    }else{
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_192);
    if(useFtpHttp){
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    if(useFtpHttp){
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
			if(specify_alias){

    stringBuffer.append(TEXT_202);
    
			}

    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
	Map<String,String> input_single_map = new HashMap<String,String>();
	Map<String,Map<String,String>> input_structure_map = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> input_table_map = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> table_input_map = new HashMap<String,Map<String,String>>();
	Map<String,String> table_map = null;

	List<Map<String, String>> sapMapping_input = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");            
    
	for(Map<String, String> configRow : sapMapping_input){
	
		String parameterType = configRow.get("SAP_PARAMETER_TYPE");
		if("table_input".equals(parameterType)) { 
			if(table_input_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				table_input_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = table_input_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else if("input_table".equals(parameterType)){
			if(input_table_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				input_table_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = input_table_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else if("input_structure".equals(parameterType)){
			if(input_structure_map.get(configRow.get("SAP_TABLE_NAME"))==null){
				table_map = new HashMap<String,String>();
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
				input_structure_map.put(configRow.get("SAP_TABLE_NAME"),table_map);
			}else{
				table_map = input_structure_map.get(configRow.get("SAP_TABLE_NAME"));
				table_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));
			}
		}else{
			input_single_map.put(configRow.get("SAP_PARAMETER_NAME"),configRow.get("SAP_PARAMETER_VALUE"));	
		}
		
		if(false){
		System.out.println(configRow.get("SCHEMA_COLUMN") + " " + configRow.get("SAP_PARAMETER_TYPE") + " " + configRow.get("SAP_TABLE_NAME") + " " + configRow.get("SAP_PARAMETER_NAME") + " " + configRow.get("SAP_PARAMETER_VALUE")+ " " + configRow.get("SAP_TABLE_ROWNUMBER"));
		}
	}
	//assign input value	
	if(!input_single_map.isEmpty()){
		for(Object pName:input_single_map.keySet()){
		
    stringBuffer.append(TEXT_226);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(input_single_map.get(pName));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(pName.toString());
    stringBuffer.append(TEXT_230);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(pName.toString());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(input_single_map.get(pName));
    stringBuffer.append(TEXT_234);
    }
    stringBuffer.append(TEXT_235);
    
		}
	}
	if(!input_structure_map.isEmpty()){
		for(Object tableName:input_structure_map.keySet()){
		
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(tableName.toString());
    stringBuffer.append(TEXT_239);
    
			table_map = (HashMap<String,String>)input_structure_map.get(tableName);
			for(Object ColName: table_map.keySet()){
			
    stringBuffer.append(TEXT_240);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(table_map.get(ColName));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(ColName.toString());
    stringBuffer.append(TEXT_244);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(ColName.toString());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(table_map.get(ColName));
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    
			}
		}
	}
	if(!input_table_map.isEmpty()){
		String tName = "";
		String cName = "";
		for(Object tableName:input_table_map.keySet()){
			tName = TalendTextUtils.removeQuotes(tableName.toString());
			table_map = (HashMap<String,String>)input_table_map.get(tableName);
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				String multiValues = table_map.get(colName);
				
    stringBuffer.append(TEXT_250);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
				if(multiValues != null && multiValues.indexOf(",") != -1){
					String[] values = multiValues.split(",");
					for(int k = 0; k < values.length; k++){
					
    stringBuffer.append(TEXT_254);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(values[k]);
    stringBuffer.append(TEXT_258);
    
					}
				}else{
				
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_270);
    						
				}
			}
			
    stringBuffer.append(TEXT_271);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
     
			boolean isFirstRow = true;
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				if(isFirstRow){ 
				
    stringBuffer.append(TEXT_274);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
					isFirstRow = false;
				}else{
				
    stringBuffer.append(TEXT_280);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_287);
    
				}
			}
			
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_300);
    
				for(Object colName: table_map.keySet()){
					cName = TalendTextUtils.removeQuotes(colName.toString());
					
    stringBuffer.append(TEXT_301);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_308);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    
				}
				
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    
		}
	}
	if(!table_input_map.isEmpty()){
		String tName = "";
		String cName = "";
		for(Object tableName:table_input_map.keySet()){
			tName = TalendTextUtils.removeQuotes(tableName.toString());
			table_map = (HashMap<String,String>)table_input_map.get(tableName);
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				String multiValues = table_map.get(colName);
				
    stringBuffer.append(TEXT_319);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    
				if(multiValues != null && multiValues.indexOf(",") != -1){
    				String[] values = multiValues.split(",");
    				for(int k = 0; k < values.length; k++){
					
    stringBuffer.append(TEXT_323);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(values[k]);
    stringBuffer.append(TEXT_327);
    
					}
				}else{
				
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(table_map.get(colName));
    stringBuffer.append(TEXT_339);
    						
				}
			}
			
    stringBuffer.append(TEXT_340);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
			boolean isFirstRow = true;
			for(Object colName: table_map.keySet()){
				cName = TalendTextUtils.removeQuotes(colName.toString());
				if(isFirstRow){
				
    stringBuffer.append(TEXT_343);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
					isFirstRow = false;
				}else{
				
    stringBuffer.append(TEXT_349);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_356);
    
				}
			}
			
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_369);
    
				for(Object colName: table_map.keySet()){
					cName = TalendTextUtils.removeQuotes(colName.toString());
					
    stringBuffer.append(TEXT_370);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_377);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(colName.toString());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cName);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(tName);
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    
				}
				
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    
		}
	}	
	
    stringBuffer.append(TEXT_388);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    
	for(Map<String, String> schemaMap : schemas) {
		String schemaName = schemaMap.get("SCHEMA");
		String paramType = schemaMap.get("SAP_ITERATE_OUT_TYPE");	
		String tableName = schemaMap.get("SAP_TABLE_NAME");	
		
    stringBuffer.append(TEXT_402);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_403);
    if(paramType.equals("output_table")){
    stringBuffer.append(TEXT_404);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_405);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_409);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_410);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_414);
    }
    stringBuffer.append(TEXT_415);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    }
    stringBuffer.append(TEXT_419);
    if(paramType.equals("table_output")){
    stringBuffer.append(TEXT_420);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_421);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_425);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_430);
    }
    stringBuffer.append(TEXT_431);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    }
    stringBuffer.append(TEXT_435);
    	
	}
	
    stringBuffer.append(TEXT_436);
    boolean firstWhilePart = true;
	for(Map<String, String> schemaMap : schemas) {
		String schemaName = schemaMap.get("SCHEMA");
		
    stringBuffer.append(TEXT_437);
    stringBuffer.append(!firstWhilePart?"||":"" );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_439);
    	
		firstWhilePart = false;
	}
    stringBuffer.append(TEXT_440);
    
			for(Map<String, String> schemaMap : schemas) {
				String schemaName = schemaMap.get("SCHEMA");
			
    stringBuffer.append(TEXT_441);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_442);
    	
			}
			
    stringBuffer.append(TEXT_443);
    
			for(Map<String, String> schemaMap : schemas) {
				String schemaName = schemaMap.get("SCHEMA");
				String paramType = schemaMap.get("SAP_ITERATE_OUT_TYPE");
				String tableName = schemaMap.get("SAP_TABLE_NAME");	
				String mapping = schemaMap.get("MAPPING");	
				String[] paramNames = null;
				if(mapping != null){
					paramNames = mapping.split(",");
				}	
				IConnection justConn = null; //------->get the right output connection--->to get the columns info
				if(conns != null && conns.size() > 0){
					for(IConnection conn : conns){
						if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(schemaName.equals(conn.getName())){
								justConn = conn;
								break;
							}
						}
					}
				}
				
    stringBuffer.append(TEXT_444);
    
				//do check1, make sure the field "component setting viewer->View->Connection format" is "row"
				if(justConn == null){
				
    stringBuffer.append(TEXT_445);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_446);
    
					return stringBuffer.toString();
				}

				IMetadataTable justMetadata = justConn.getMetadataTable();
				List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
				
    stringBuffer.append(TEXT_447);
    
				//do check2, make sure the field "Schema XpathQuerys" are not empty 
				if(paramNames == null || paramNames.length != justColumnList.size()){
				
    stringBuffer.append(TEXT_448);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_449);
    
					return stringBuffer.toString();
				}
				
    stringBuffer.append(TEXT_450);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_451);
    if(paramType.equals("output_single")){
    stringBuffer.append(TEXT_452);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_455);
    
		                int i = 0;
		                for(IMetadataColumn justColumn : justColumnList){    
			            
    stringBuffer.append(TEXT_456);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_457);
    new AssignUtil().gen(justConn,justColumn,"exportParameterList_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_458);
    	
			            	i++;
			            }
			            
    stringBuffer.append(TEXT_459);
    }else if(paramType.equals("output_structure")){
    stringBuffer.append(TEXT_460);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_461);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_462);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_466);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_467);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_471);
    }
    stringBuffer.append(TEXT_472);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_474);
    
			            int i = 0;
			            for(IMetadataColumn justColumn : justColumnList){    
			            
    stringBuffer.append(TEXT_475);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_476);
    new AssignUtil().gen(justConn,justColumnList.get(i),"output_structure_"+justConn.getName()+"_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_477);
    	
			            	i++;
			            }
			            
    stringBuffer.append(TEXT_478);
    }else if(paramType.equals("output_table") || paramType.equals("table_output")){
    stringBuffer.append(TEXT_479);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_484);
    
		                int i = 0;
		                for(IMetadataColumn justColumn : justColumnList){  
	            		
    stringBuffer.append(TEXT_485);
    stringBuffer.append(justColumnList.get(i).getLabel() );
    stringBuffer.append(TEXT_486);
    new AssignUtil().gen(justConn,justColumnList.get(i),"table_"+schemaName+"_"+cid,paramNames[i]);
    stringBuffer.append(TEXT_487);
    	
	        				i++;
	            		}
	            		
    stringBuffer.append(TEXT_488);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    
		            }
		            
    stringBuffer.append(TEXT_492);
    	
			}
			
    stringBuffer.append(TEXT_493);
    return stringBuffer.toString();
  }
}
