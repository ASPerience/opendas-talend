package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TFileInputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileInputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputLDIFBeginJava result = new TFileInputLDIFBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////////////////" + NL + "        netscape.ldap.util.LDIF ldif_";
  protected final String TEXT_2 = " = new netscape.ldap.util.LDIF(";
  protected final String TEXT_3 = ");" + NL + "" + NL + "        String[] filters_";
  protected final String TEXT_4 = " = new String[] {         ";
  protected final String TEXT_5 = " " + NL + "\t\t\"";
  protected final String TEXT_6 = "\",";
  protected final String TEXT_7 = "        " + NL + "        };" + NL + "        String[] results_";
  protected final String TEXT_8 = " = null;" + NL + "        int nb_line_";
  protected final String TEXT_9 = " = 0;" + NL + "        " + NL + "        ///////////////////////////////////" + NL + "" + NL + "        for (netscape.ldap.util.LDIFRecord record_";
  protected final String TEXT_10 = " = ldif_";
  protected final String TEXT_11 = ".nextRecord(); record_";
  protected final String TEXT_12 = " != null; record_";
  protected final String TEXT_13 = " = ldif_";
  protected final String TEXT_14 = ".nextRecord()) {" + NL + "" + NL + "            results_";
  protected final String TEXT_15 = " = new String[";
  protected final String TEXT_16 = "];" + NL + "            " + NL + "            netscape.ldap.util.LDIFContent content_";
  protected final String TEXT_17 = " = record_";
  protected final String TEXT_18 = ".getContent();" + NL + "\t\t\tnetscape.ldap.LDAPAttribute[] attributes_";
  protected final String TEXT_19 = " = null;" + NL + "\t\t\t" + NL + "            switch (content_";
  protected final String TEXT_20 = ".getType()) {" + NL + "            " + NL + "            case netscape.ldap.util.LDIFContent.ATTRIBUTE_CONTENT:" + NL + "            " + NL + "                netscape.ldap.util.LDIFAttributeContent attrContent_";
  protected final String TEXT_21 = " = (netscape.ldap.util.LDIFAttributeContent) content_";
  protected final String TEXT_22 = ";" + NL + "                attributes_";
  protected final String TEXT_23 = " = attrContent_";
  protected final String TEXT_24 = ".getAttributes();" + NL + "                " + NL + "                for (int i_";
  protected final String TEXT_25 = " = 0; i_";
  protected final String TEXT_26 = " < filters_";
  protected final String TEXT_27 = ".length; i_";
  protected final String TEXT_28 = "++) {" + NL + "                " + NL + "                    for (int j_";
  protected final String TEXT_29 = " = 0; j_";
  protected final String TEXT_30 = " < attributes_";
  protected final String TEXT_31 = ".length; j_";
  protected final String TEXT_32 = "++) {" + NL + "                    " + NL + "                        netscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_33 = " = attributes_";
  protected final String TEXT_34 = "[j_";
  protected final String TEXT_35 = "];" + NL + "                        " + NL + "\t\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_36 = "[i_";
  protected final String TEXT_37 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_38 = "[i_";
  protected final String TEXT_39 = "] = record_";
  protected final String TEXT_40 = ".getDN();" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t" + NL + "                            if (filters_";
  protected final String TEXT_41 = "[i_";
  protected final String TEXT_42 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_43 = ".getName())) {" + NL + "                            " + NL + "                                java.util.Enumeration values_";
  protected final String TEXT_44 = " = attribute_";
  protected final String TEXT_45 = ".getStringValues();" + NL + "                                " + NL + "                                while (values_";
  protected final String TEXT_46 = ".hasMoreElements()) {" + NL + "                                    String value_";
  protected final String TEXT_47 = " = (String) values_";
  protected final String TEXT_48 = ".nextElement();" + NL + "                                    results_";
  protected final String TEXT_49 = "[i_";
  protected final String TEXT_50 = "] = results_";
  protected final String TEXT_51 = "[i_";
  protected final String TEXT_52 = "] == null ? value_";
  protected final String TEXT_53 = " : results_";
  protected final String TEXT_54 = "[i_";
  protected final String TEXT_55 = "] + ";
  protected final String TEXT_56 = " + value_";
  protected final String TEXT_57 = ";" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }" + NL + "                " + NL + "                break;" + NL + "" + NL + "            case netscape.ldap.util.LDIFContent.ADD_CONTENT:" + NL + "            " + NL + "                netscape.ldap.util.LDIFAddContent addContent_";
  protected final String TEXT_58 = " = (netscape.ldap.util.LDIFAddContent) content_";
  protected final String TEXT_59 = ";" + NL + "                attributes_";
  protected final String TEXT_60 = " = addContent_";
  protected final String TEXT_61 = ".getAttributes();" + NL + "                " + NL + "                for (int i_";
  protected final String TEXT_62 = " = 0; i_";
  protected final String TEXT_63 = " < filters_";
  protected final String TEXT_64 = ".length; i_";
  protected final String TEXT_65 = "++) {" + NL + "                " + NL + "                    for (int j_";
  protected final String TEXT_66 = " = 0; j_";
  protected final String TEXT_67 = " < attributes_";
  protected final String TEXT_68 = ".length; j_";
  protected final String TEXT_69 = "++) {" + NL + "                    " + NL + "                        netscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_70 = " = attributes_";
  protected final String TEXT_71 = "[j_";
  protected final String TEXT_72 = "];" + NL + "                        " + NL + "\t\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_73 = "[i_";
  protected final String TEXT_74 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_75 = "[i_";
  protected final String TEXT_76 = "] = record_";
  protected final String TEXT_77 = ".getDN();" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_78 = "[i_";
  protected final String TEXT_79 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_80 = "[i_";
  protected final String TEXT_81 = "] = \"add\";" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t" + NL + "                            if (filters_";
  protected final String TEXT_82 = "[i_";
  protected final String TEXT_83 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_84 = ".getName())) {" + NL + "                            " + NL + "                                java.util.Enumeration values_";
  protected final String TEXT_85 = " = attribute_";
  protected final String TEXT_86 = ".getStringValues();" + NL + "                                " + NL + "                                while (values_";
  protected final String TEXT_87 = ".hasMoreElements()) {" + NL + "                                    String value_";
  protected final String TEXT_88 = " = (String) values_";
  protected final String TEXT_89 = ".nextElement();" + NL + "                                    results_";
  protected final String TEXT_90 = "[i_";
  protected final String TEXT_91 = "] = results_";
  protected final String TEXT_92 = "[i_";
  protected final String TEXT_93 = "] == null ? value_";
  protected final String TEXT_94 = " : results_";
  protected final String TEXT_95 = "[i_";
  protected final String TEXT_96 = "] + ";
  protected final String TEXT_97 = " + value_";
  protected final String TEXT_98 = ";" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }                " + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.MODIFICATION_CONTENT:" + NL + "" + NL + "\t\t\t\t\tnetscape.ldap.util.LDIFModifyContent modifyContent_";
  protected final String TEXT_99 = " = (netscape.ldap.util.LDIFModifyContent) content_";
  protected final String TEXT_100 = ";" + NL + "\t\t\t\t\tnetscape.ldap.LDAPModification[] modifications_";
  protected final String TEXT_101 = " = modifyContent_";
  protected final String TEXT_102 = ".getModifications();" + NL + "" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_103 = " = 0; i_";
  protected final String TEXT_104 = " < filters_";
  protected final String TEXT_105 = ".length; i_";
  protected final String TEXT_106 = "++) {" + NL + "" + NL + "\t\t\t\t\t\tfor (netscape.ldap.LDAPModification modification_";
  protected final String TEXT_107 = " : modifications_";
  protected final String TEXT_108 = ") {" + NL + "\t\t\t\t\t\t\tnetscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_109 = " = modification_";
  protected final String TEXT_110 = ".getAttribute();" + NL + "" + NL + "\t\t\t\t\t\t\tif (\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_111 = "[i_";
  protected final String TEXT_112 = "])) {" + NL + "\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_113 = "[i_";
  protected final String TEXT_114 = "] = record_";
  protected final String TEXT_115 = ".getDN();" + NL + "" + NL + "\t\t\t\t\t\t\t} else if (\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_116 = "[i_";
  protected final String TEXT_117 = "])) {" + NL + "\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_118 = "[i_";
  protected final String TEXT_119 = "] = \"modify\";" + NL + "" + NL + "\t\t\t\t\t\t\t} else {" + NL + "" + NL + "\t\t\t\t\t\t\t\tif (filters_";
  protected final String TEXT_120 = "[i_";
  protected final String TEXT_121 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_122 = ".getName())) {" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tint op_";
  protected final String TEXT_124 = " = modification_";
  protected final String TEXT_125 = ".getOp();" + NL + "\t\t\t\t\t\t\t\t\tswitch(op_";
  protected final String TEXT_126 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.ADD: " + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_127 = "[i_";
  protected final String TEXT_128 = "] = \"add\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.DELETE: " + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_129 = "[i_";
  protected final String TEXT_130 = "] = \"delete\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.REPLACE:" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_131 = "[i_";
  protected final String TEXT_132 = "] = \"replace\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tdefault:" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_133 = "[i_";
  protected final String TEXT_134 = "] = \"\";" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = "\t\t\t\t\t\t\t\t\t" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tjava.util.Enumeration values_";
  protected final String TEXT_136 = " = attribute_";
  protected final String TEXT_137 = ".getStringValues();" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tboolean firstLoop_";
  protected final String TEXT_138 = " = true;" + NL + "\t\t\t\t\t\t\t\t\twhile (values_";
  protected final String TEXT_139 = ".hasMoreElements()) {" + NL + "\t\t\t\t\t\t\t\t\t\tString value_";
  protected final String TEXT_140 = " = (String) values_";
  protected final String TEXT_141 = ".nextElement();\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(firstLoop_";
  protected final String TEXT_142 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_143 = "[i_";
  protected final String TEXT_144 = "] = results_";
  protected final String TEXT_145 = "[i_";
  protected final String TEXT_146 = "] == null ? value_";
  protected final String TEXT_147 = " : results_";
  protected final String TEXT_148 = "[i_";
  protected final String TEXT_149 = "] + \":\" + value_";
  protected final String TEXT_150 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_151 = "[i_";
  protected final String TEXT_152 = "] = results_";
  protected final String TEXT_153 = "[i_";
  protected final String TEXT_154 = "] + ";
  protected final String TEXT_155 = " + value_";
  protected final String TEXT_156 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\tfirstLoop_";
  protected final String TEXT_157 = " = false;\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}                " + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.DELETE_CONTENT:" + NL + "                //netscape.ldap.util.LDIFDeleteContent deleteContent_";
  protected final String TEXT_158 = " = (netscape.ldap.util.LDIFDeleteContent) content_";
  protected final String TEXT_159 = ";" + NL + "                for (int i_";
  protected final String TEXT_160 = " = 0; i_";
  protected final String TEXT_161 = " < filters_";
  protected final String TEXT_162 = ".length; i_";
  protected final String TEXT_163 = "++) {" + NL + "\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_164 = "[i_";
  protected final String TEXT_165 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_166 = "[i_";
  protected final String TEXT_167 = "] = record_";
  protected final String TEXT_168 = ".getDN();\t\t\t\t\t\t" + NL + "\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_169 = "[i_";
  protected final String TEXT_170 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_171 = "[i_";
  protected final String TEXT_172 = "] = \"delete\";" + NL + "\t\t\t\t\t}                " + NL + "                }                " + NL + "                break;" + NL + "                " + NL + "\t\t\tcase netscape.ldap.util.LDIFContent.MODDN_CONTENT:" + NL + "\t\t\t\tnetscape.ldap.util.LDIFModDNContent moddnContent_";
  protected final String TEXT_173 = " = (netscape.ldap.util.LDIFModDNContent) content_";
  protected final String TEXT_174 = ";" + NL + "                for (int i_";
  protected final String TEXT_175 = " = 0; i_";
  protected final String TEXT_176 = " < filters_";
  protected final String TEXT_177 = ".length; i_";
  protected final String TEXT_178 = "++) {" + NL + "\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_179 = "[i_";
  protected final String TEXT_180 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_181 = "[i_";
  protected final String TEXT_182 = "] = record_";
  protected final String TEXT_183 = ".getDN();\t\t\t\t\t\t" + NL + "\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_184 = "[i_";
  protected final String TEXT_185 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_186 = "[i_";
  protected final String TEXT_187 = "] = \"modrdn\";" + NL + "\t\t\t\t\t}else if(\"newrdn\".equalsIgnoreCase(filters_";
  protected final String TEXT_188 = "[i_";
  protected final String TEXT_189 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_190 = "[i_";
  protected final String TEXT_191 = "] = moddnContent_";
  protected final String TEXT_192 = ".getRDN();" + NL + "\t\t\t\t\t}else if(\"deleteoldrdn\".equalsIgnoreCase(filters_";
  protected final String TEXT_193 = "[i_";
  protected final String TEXT_194 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_195 = "[i_";
  protected final String TEXT_196 = "] = Boolean.toString(moddnContent_";
  protected final String TEXT_197 = ".getDeleteOldRDN());" + NL + "\t\t\t\t\t}else if(\"newsuperior\".equalsIgnoreCase(filters_";
  protected final String TEXT_198 = "[i_";
  protected final String TEXT_199 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_200 = "[i_";
  protected final String TEXT_201 = "] = moddnContent_";
  protected final String TEXT_202 = ".getNewParent();" + NL + "\t\t\t\t\t}\t\t\t\t\t                " + NL + "                }" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tdefault:                " + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_203 = "++;" + NL + "            " + NL + "            " + NL + "// for output";
  protected final String TEXT_204 = NL + "    \t\t";
  protected final String TEXT_205 = " = null;\t\t\t";
  protected final String TEXT_206 = NL + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_207 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_208 = " = new ";
  protected final String TEXT_209 = "Struct();" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_211 = " < results_";
  protected final String TEXT_212 = ".length && results_";
  protected final String TEXT_213 = "[";
  protected final String TEXT_214 = "]!=null ){\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = " = results_";
  protected final String TEXT_218 = "[";
  protected final String TEXT_219 = "];";
  protected final String TEXT_220 = NL + "\t\t\t\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_223 = "[";
  protected final String TEXT_224 = "], ";
  protected final String TEXT_225 = ");";
  protected final String TEXT_226 = NL + "\t\t\t\t\t";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = " = results_";
  protected final String TEXT_229 = "[";
  protected final String TEXT_230 = "].getBytes(";
  protected final String TEXT_231 = ");" + NL + "\t";
  protected final String TEXT_232 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = " = ParserUtils.parseTo_";
  protected final String TEXT_235 = "(results_";
  protected final String TEXT_236 = "[";
  protected final String TEXT_237 = "]);";
  protected final String TEXT_238 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " = ";
  protected final String TEXT_241 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t";
  protected final String TEXT_243 = " ";
  protected final String TEXT_244 = " = null; ";
  protected final String TEXT_245 = "\t\t\t" + NL + "\t\t\t" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_246 = " = true;";
  protected final String TEXT_247 = NL + "            throw(e);";
  protected final String TEXT_248 = NL + "                    ";
  protected final String TEXT_249 = " = new ";
  protected final String TEXT_250 = "Struct();";
  protected final String TEXT_251 = NL + "                    ";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = ";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = ";";
  protected final String TEXT_256 = NL + "                ";
  protected final String TEXT_257 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_258 = ";";
  protected final String TEXT_259 = NL + "                ";
  protected final String TEXT_260 = " = null;";
  protected final String TEXT_261 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_262 = NL + "                ";
  protected final String TEXT_263 = " = null;";
  protected final String TEXT_264 = NL + "            \t";
  protected final String TEXT_265 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_266 = ";";
  protected final String TEXT_267 = NL + "    }" + NL + "\t\t\t";
  protected final String TEXT_268 = NL + "\t\t";
  protected final String TEXT_269 = "if(!whetherReject_";
  protected final String TEXT_270 = ") { ";
  protected final String TEXT_271 = "      " + NL + "             if(";
  protected final String TEXT_272 = " == null){ " + NL + "            \t ";
  protected final String TEXT_273 = " = new ";
  protected final String TEXT_274 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_275 = NL + "\t    \t ";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = " = ";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = ";    \t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t";
  protected final String TEXT_281 = " } ";
  protected final String TEXT_282 = "\t";
  protected final String TEXT_283 = NL + "///////////////////////////////////        ";
  protected final String TEXT_284 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__"); 
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;               
        List<IMetadataColumn> listColumns = metadata.getListColumns();
        
        String addprefixStr = ElementParameterParser.getValue(node, "__ADDPREFIX__");
        boolean addprefix = (addprefixStr!=null&&!("").equals(addprefixStr))?("true").equals(addprefixStr):false;
        String valueSeparator = ElementParameterParser.getValue(node, "__VALUE_SEPARATOR__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
        for (IMetadataColumn column: listColumns) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    
        }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(listColumns.size() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
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
    stringBuffer.append(valueSeparator);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    if(addprefix){
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    
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

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_205);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();		
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_214);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_215);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_219);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_220);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_224);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_225);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_226);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_231);
    
					} else  { //other

    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_237);
    
					}

    stringBuffer.append(TEXT_238);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_241);
    			
			} //4
    stringBuffer.append(TEXT_242);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_247);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_248);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_250);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_255);
    
                }
                
    stringBuffer.append(TEXT_256);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_260);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_263);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_266);
    }
        } 
        
    stringBuffer.append(TEXT_267);
    
		}//3
		
		
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_268);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_274);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_275);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_279);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_280);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_281);
     } 
    stringBuffer.append(TEXT_282);
    
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_283);
    
  }
}  
 
    stringBuffer.append(TEXT_284);
    return stringBuffer.toString();
  }
}
