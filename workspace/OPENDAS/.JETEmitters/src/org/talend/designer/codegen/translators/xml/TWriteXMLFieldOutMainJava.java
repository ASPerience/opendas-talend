package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

/**
 * add by xzhang
 */
public class TWriteXMLFieldOutMainJava {

  protected static String nl;
  public static synchronized TWriteXMLFieldOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutMainJava result = new TWriteXMLFieldOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tvalueMap_";
  protected final String TEXT_3 = ".get(\"";
  protected final String TEXT_4 = "\")";
  protected final String TEXT_5 = NL + "\t(";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null?";
  protected final String TEXT_9 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ".doubleValue()), ";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ")\t\t\t\t\t";
  protected final String TEXT_14 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = "), ";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = ")\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "            String.valueOf(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ")";
  protected final String TEXT_22 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = NL + "\t\t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ".doubleValue())";
  protected final String TEXT_31 = NL + "            ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ".toString()";
  protected final String TEXT_34 = ":";
  protected final String TEXT_35 = "null";
  protected final String TEXT_36 = NL + "\t\t)";
  protected final String TEXT_37 = NL + "\t\t\t";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = ".setName(\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\t\t\tif (";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_48 = NL + "                ";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ".remove(";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = ";" + NL + "\t\tif (";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_58 = "\") == null) {";
  protected final String TEXT_59 = NL + "            ";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_62 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_65 = "\");" + NL + "        }";
  protected final String TEXT_66 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_69 = "\");";
  protected final String TEXT_70 = NL + "        if(orders_";
  protected final String TEXT_71 = "[";
  protected final String TEXT_72 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_73 = "[";
  protected final String TEXT_74 = "] = ";
  protected final String TEXT_75 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_76 = " < orders_";
  protected final String TEXT_77 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_78 = "[";
  protected final String TEXT_79 = "] = 0;" + NL + "        }";
  protected final String TEXT_80 = NL + "        ";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ".elements().add(orders_";
  protected final String TEXT_83 = "[";
  protected final String TEXT_84 = "]++,";
  protected final String TEXT_85 = "_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = ";" + NL + "\t\tif (";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_92 = "\") == null) {";
  protected final String TEXT_93 = NL + "            ";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ".addElement(\"";
  protected final String TEXT_98 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = ".addElement(\"";
  protected final String TEXT_103 = "\");" + NL + "        }";
  protected final String TEXT_104 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = ".addElement(\"";
  protected final String TEXT_109 = "\");";
  protected final String TEXT_110 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = ";";
  protected final String TEXT_114 = NL + "\t\tif(";
  protected final String TEXT_115 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_116 = " .parseAndAdd(";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ",";
  protected final String TEXT_119 = ");" + NL + "\t\t}";
  protected final String TEXT_120 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_121 = " .parseAndAdd(";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_126 = NL + "\t\tif(";
  protected final String TEXT_127 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_128 = " .setText(";
  protected final String TEXT_129 = "_";
  protected final String TEXT_130 = ",";
  protected final String TEXT_131 = ");" + NL + "\t\t}";
  protected final String TEXT_132 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_135 = "_";
  protected final String TEXT_136 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_137 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_138 = ".parseAndAdd(";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = ",\"";
  protected final String TEXT_141 = "\");";
  protected final String TEXT_142 = NL + "\t\tif(";
  protected final String TEXT_143 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = ".addAttribute(\"";
  protected final String TEXT_146 = "\",";
  protected final String TEXT_147 = ");" + NL + "\t\t}";
  protected final String TEXT_148 = NL + "\t\t";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = ".addAttribute(\"";
  protected final String TEXT_151 = "\", \"";
  protected final String TEXT_152 = "\");";
  protected final String TEXT_153 = NL + "\t\tif(";
  protected final String TEXT_154 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_155 = "_";
  protected final String TEXT_156 = ".addNamespace(\"";
  protected final String TEXT_157 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_158 = "));";
  protected final String TEXT_159 = NL + "        \t";
  protected final String TEXT_160 = "_";
  protected final String TEXT_161 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_164 = "))));";
  protected final String TEXT_165 = NL + "\t\t}";
  protected final String TEXT_166 = NL + "\t\t\t";
  protected final String TEXT_167 = "_";
  protected final String TEXT_168 = ".addNamespace(\"";
  protected final String TEXT_169 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_170 = "\"));";
  protected final String TEXT_171 = NL + "        \t";
  protected final String TEXT_172 = "_";
  protected final String TEXT_173 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_176 = "\"))));";
  protected final String TEXT_177 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_178 = "[";
  protected final String TEXT_179 = "] = buf_";
  protected final String TEXT_180 = ".toString();" + NL + "        buf_";
  protected final String TEXT_181 = " = new StringBuffer();";
  protected final String TEXT_182 = NL + "\t\tstartTabs_";
  protected final String TEXT_183 = "[";
  protected final String TEXT_184 = "] = buf_";
  protected final String TEXT_185 = ".toString();" + NL + "        buf_";
  protected final String TEXT_186 = " = new StringBuffer();";
  protected final String TEXT_187 = NL + "\t\tout_";
  protected final String TEXT_188 = ".write(buf_";
  protected final String TEXT_189 = ".toString());" + NL + "        buf_";
  protected final String TEXT_190 = " = new StringBuffer();";
  protected final String TEXT_191 = NL + "\t\tif( false";
  protected final String TEXT_192 = " || valueMap_";
  protected final String TEXT_193 = ".get(\"";
  protected final String TEXT_194 = "\") != null";
  protected final String TEXT_195 = " || true " + NL + "                    \t";
  protected final String TEXT_196 = NL + "\t\t){";
  protected final String TEXT_197 = NL + "\t\t}";
  protected final String TEXT_198 = NL + "\t\tbuf_";
  protected final String TEXT_199 = ".append(\"\\n\");" + NL + "\t\tbuf_";
  protected final String TEXT_200 = ".append(\"";
  protected final String TEXT_201 = "<";
  protected final String TEXT_202 = "\");";
  protected final String TEXT_203 = NL + "\t\tbuf_";
  protected final String TEXT_204 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_205 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+";
  protected final String TEXT_206 = "+\"\\\"\");";
  protected final String TEXT_207 = NL + "\t\tif(";
  protected final String TEXT_208 = "==null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_209 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_210 = NL + "\t\tbuf_";
  protected final String TEXT_211 = ".append(\">\");";
  protected final String TEXT_212 = NL + "\t\tbuf_";
  protected final String TEXT_213 = ".append(\"\\n\");" + NL + "\t\tbuf_";
  protected final String TEXT_214 = ".append(\"";
  protected final String TEXT_215 = "</";
  protected final String TEXT_216 = ">\");";
  protected final String TEXT_217 = NL + "\t\tbuf_";
  protected final String TEXT_218 = ".append(\"</";
  protected final String TEXT_219 = ">\");";
  protected final String TEXT_220 = NL + "\t\tif(";
  protected final String TEXT_221 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_222 = ".append(";
  protected final String TEXT_223 = ");" + NL + "\t\t}";
  protected final String TEXT_224 = NL + "\t\tif(";
  protected final String TEXT_225 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_226 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_227 = "));" + NL + "\t\t}";
  protected final String TEXT_228 = NL + "\t\tbuf_";
  protected final String TEXT_229 = ".append(\"";
  protected final String TEXT_230 = "\");";
  protected final String TEXT_231 = NL + "\t\tif(";
  protected final String TEXT_232 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_233 = ".append(\" ";
  protected final String TEXT_234 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_235 = ")+\"\\\"\");" + NL + "\t\t}";
  protected final String TEXT_236 = NL + "\t\tbuf_";
  protected final String TEXT_237 = ".append(\" ";
  protected final String TEXT_238 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_239 = "\")+\"\\\"\");";
  protected final String TEXT_240 = NL + "\t\tif(";
  protected final String TEXT_241 = "!=null){";
  protected final String TEXT_242 = NL + "        \tbuf_";
  protected final String TEXT_243 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_244 = ")+\"\\\"\");";
  protected final String TEXT_245 = NL + "\t\t\tbuf_";
  protected final String TEXT_246 = ".append(\" xmlns:";
  protected final String TEXT_247 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_248 = ")+\"\\\"\");";
  protected final String TEXT_249 = NL + "\t\t}";
  protected final String TEXT_250 = NL + "        \tbuf_";
  protected final String TEXT_251 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_252 = "\")+\"\\\"\");";
  protected final String TEXT_253 = NL + "\t\t\tbuf_";
  protected final String TEXT_254 = ".append(\" xmlns:";
  protected final String TEXT_255 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_256 = "\")+\"\\\"\");";
  protected final String TEXT_257 = NL + "\tnb_line_";
  protected final String TEXT_258 = "++;" + NL + "\tvalueMap_";
  protected final String TEXT_259 = ".clear();";
  protected final String TEXT_260 = NL + "\tvalueMap_";
  protected final String TEXT_261 = ".put(\"";
  protected final String TEXT_262 = "\",";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "\tflowValues_";
  protected final String TEXT_265 = " = new java.util.HashMap<String,String>();" + NL + "\tflowValues_";
  protected final String TEXT_266 = ".putAll(valueMap_";
  protected final String TEXT_267 = ");" + NL + "\tflows_";
  protected final String TEXT_268 = ".add(flowValues_";
  protected final String TEXT_269 = ");";
  protected final String TEXT_270 = NL + "\t\tString strTemp_";
  protected final String TEXT_271 = " = \"\";";
  protected final String TEXT_272 = "\t\tstrTemp_";
  protected final String TEXT_273 = " = strTemp_";
  protected final String TEXT_274 = " + valueMap_";
  protected final String TEXT_275 = ".get(\"";
  protected final String TEXT_276 = "\")" + NL + "\t\t\t\t\t\t\t+ valueMap_";
  protected final String TEXT_277 = ".get(\"";
  protected final String TEXT_278 = "\").length();";
  protected final String TEXT_279 = NL + "\tif(strCompCache_";
  protected final String TEXT_280 = "==null){" + NL + "\t\tstrCompCache_";
  protected final String TEXT_281 = "=strTemp_";
  protected final String TEXT_282 = ";" + NL + "\t}else{";
  protected final String TEXT_283 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(strCompCache_";
  protected final String TEXT_284 = ".equals(strTemp_";
  protected final String TEXT_285 = ")==false){\t";
  protected final String TEXT_286 = NL + "\t\t\tdoc_";
  protected final String TEXT_287 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", ";
  protected final String TEXT_288 = ");" + NL + "\t\t    doc_";
  protected final String TEXT_289 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_290 = "  " + NL + "    \t\tnestXMLTool_";
  protected final String TEXT_291 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_292 = ".getRootElement());";
  protected final String TEXT_293 = NL + "    \t\tnestXMLTool_";
  protected final String TEXT_294 = ".removeEmptyElement(doc_";
  protected final String TEXT_295 = ".getRootElement());";
  protected final String TEXT_296 = "\t\t\t" + NL + "\t\t\tjava.io.StringWriter strWriter_";
  protected final String TEXT_297 = " = new java.io.StringWriter();\t" + NL + "\t\t\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_298 = " = new org.dom4j.io.XMLWriter(strWriter_";
  protected final String TEXT_299 = ", format_";
  protected final String TEXT_300 = ");" + NL + "\t\t\toutput_";
  protected final String TEXT_301 = ".write(doc_";
  protected final String TEXT_302 = ");" + NL + "\t\t    output_";
  protected final String TEXT_303 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\tString removeHeader_";
  protected final String TEXT_305 = " = strWriter_";
  protected final String TEXT_306 = ".toString();" + NL + "\t\t\tif(removeHeader_";
  protected final String TEXT_307 = ".indexOf(\"<?xml\") >=0 ){" + NL + "\t\t\t\tremoveHeader_";
  protected final String TEXT_308 = " = removeHeader_";
  protected final String TEXT_309 = ".substring(removeHeader_";
  protected final String TEXT_310 = ".indexOf(\"?>\")+3);" + NL + "\t\t\t}" + NL + "\t\t\tlistGroupby_";
  protected final String TEXT_311 = ".add(removeHeader_";
  protected final String TEXT_312 = ");";
  protected final String TEXT_313 = NL + "\t\t    listGroupby_";
  protected final String TEXT_314 = ".add(strWriter_";
  protected final String TEXT_315 = ".toString());";
  protected final String TEXT_316 = NL + "\t\t    doc_";
  protected final String TEXT_317 = ".clearContent();" + NL + "\t\t\tneedRoot_";
  protected final String TEXT_318 = " = true;" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_319 = "=0;i_";
  protected final String TEXT_320 = "<orders_";
  protected final String TEXT_321 = ".length;i_";
  protected final String TEXT_322 = "++){" + NL + "\t\t\t\torders_";
  protected final String TEXT_323 = "[i_";
  protected final String TEXT_324 = "] = 0;" + NL + "\t\t\t}" + NL + "\t\t\tstrCompCache_";
  protected final String TEXT_325 = "=strTemp_";
  protected final String TEXT_326 = ";";
  protected final String TEXT_327 = NL + "\t\t}";
  protected final String TEXT_328 = NL + "\t}" + NL;
  protected final String TEXT_329 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_330 = " = null;" + NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_331 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_332 = "=false;";
  protected final String TEXT_333 = NL + "\t\troot4Group_";
  protected final String TEXT_334 = " = subTreeRootParent_";
  protected final String TEXT_335 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_336 = "=root4Group_";
  protected final String TEXT_337 = ";" + NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_338 = NL + "\tboolean isNewElememt = false;";
  protected final String TEXT_339 = NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_340 = ".size()<=";
  protected final String TEXT_341 = " || groupbyList_";
  protected final String TEXT_342 = ".get(";
  protected final String TEXT_343 = ")==null";
  protected final String TEXT_344 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_345 = ".get(";
  protected final String TEXT_346 = ").get(";
  protected final String TEXT_347 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_348 = ".get(";
  protected final String TEXT_349 = ").get(";
  protected final String TEXT_350 = ").equals(";
  protected final String TEXT_351 = ") " + NL + "\t\t: ";
  protected final String TEXT_352 = "!=null )";
  protected final String TEXT_353 = NL + "\t){";
  protected final String TEXT_354 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_355 = ".size()<=";
  protected final String TEXT_356 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_357 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_358 = ".get(";
  protected final String TEXT_359 = ").clear();" + NL + "        }";
  protected final String TEXT_360 = NL + "\t\tgroupbyList_";
  protected final String TEXT_361 = ".get(";
  protected final String TEXT_362 = ").add(";
  protected final String TEXT_363 = ");";
  protected final String TEXT_364 = NL + "        isNewElememt=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_365 = ".size()<=";
  protected final String TEXT_366 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_367 = ".add(group";
  protected final String TEXT_368 = "__";
  protected final String TEXT_369 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_370 = ".set(";
  protected final String TEXT_371 = ",group";
  protected final String TEXT_372 = "__";
  protected final String TEXT_373 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_374 = "=groupElementList_";
  protected final String TEXT_375 = ".get(";
  protected final String TEXT_376 = ");" + NL + "\t}";
  protected final String TEXT_377 = NL + "\t// build loop xml tree";
  protected final String TEXT_378 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(strCompCache_";
  protected final String TEXT_379 = ".equals(strTemp_";
  protected final String TEXT_380 = ")==false){";
  protected final String TEXT_381 = NL + NL + "\t\t // write the endtag to the StringWriter:strWriter_tWriteXMLField_1_Out" + NL + "\t\t // close the bufferWriter" + NL + "\t\t // add the data in strWriter_tWriteXMLField_1_Out to listGroupby\t\t\t\t\t\t\t " + NL + "" + NL + "\t\tif (preUnNullMaxIndex_";
  protected final String TEXT_382 = " >= 0) {" + NL + "\t        // output all buffer" + NL + "\t        for (int j_";
  protected final String TEXT_383 = " = 0; j_";
  protected final String TEXT_384 = " <= preUnNullMaxIndex_";
  protected final String TEXT_385 = "; j_";
  protected final String TEXT_386 = "++) {" + NL + "\t            if (startTabs_";
  protected final String TEXT_387 = "[j_";
  protected final String TEXT_388 = "] != null)" + NL + "\t                out_";
  protected final String TEXT_389 = ".write(startTabs_";
  protected final String TEXT_390 = "[j_";
  protected final String TEXT_391 = "]);" + NL + "\t        }" + NL + "\t" + NL + "\t        if (preUnNullMaxIndex_";
  protected final String TEXT_392 = " < preNewTabIndex_";
  protected final String TEXT_393 = " ) {" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_394 = " = preNewTabIndex_";
  protected final String TEXT_395 = " - 1; i_";
  protected final String TEXT_396 = " >= 0; i_";
  protected final String TEXT_397 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_398 = "[i_";
  protected final String TEXT_399 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_400 = ".write(endTabs_";
  protected final String TEXT_401 = "[i_";
  protected final String TEXT_402 = "]);" + NL + "                \t}                \t" + NL + "\t                out_";
  protected final String TEXT_403 = ".newLine();" + NL + "\t                out_";
  protected final String TEXT_404 = ".write(endTabStrs_";
  protected final String TEXT_405 = ".get(i_";
  protected final String TEXT_406 = "));" + NL + "\t            }" + NL + "\t        } else {" + NL + "\t            for (int i_";
  protected final String TEXT_407 = " = preUnNullMaxIndex_";
  protected final String TEXT_408 = "; i_";
  protected final String TEXT_409 = " >= 0; i_";
  protected final String TEXT_410 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_411 = "[i_";
  protected final String TEXT_412 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_413 = ".write(endTabs_";
  protected final String TEXT_414 = "[i_";
  protected final String TEXT_415 = "]);" + NL + "                \t}" + NL + "                \tout_";
  protected final String TEXT_416 = ".newLine();" + NL + "\t                out_";
  protected final String TEXT_417 = ".write(endTabStrs_";
  protected final String TEXT_418 = ".get(i_";
  protected final String TEXT_419 = "));" + NL + "\t            }" + NL + "\t        }" + NL + "\t    }";
  protected final String TEXT_420 = NL + "\t\tfor (int i_";
  protected final String TEXT_421 = " = endTabStrs_";
  protected final String TEXT_422 = ".size() - 1; i_";
  protected final String TEXT_423 = " >= 0; i_";
  protected final String TEXT_424 = "--) {" + NL + "        \tif(endTabs_";
  protected final String TEXT_425 = "[i_";
  protected final String TEXT_426 = "]!=null){" + NL + "        \t\tout_";
  protected final String TEXT_427 = ".write(endTabs_";
  protected final String TEXT_428 = "[i_";
  protected final String TEXT_429 = "]);" + NL + "        \t}" + NL + "\t        out_";
  protected final String TEXT_430 = ".newLine();" + NL + "\t        out_";
  protected final String TEXT_431 = ".write(endTabStrs_";
  protected final String TEXT_432 = ".get(i_";
  protected final String TEXT_433 = "));" + NL + "\t    }";
  protected final String TEXT_434 = NL + "\t\tfor (int i_";
  protected final String TEXT_435 = " = 0; i_";
  protected final String TEXT_436 = " < endTabs_";
  protected final String TEXT_437 = ".length; i_";
  protected final String TEXT_438 = "++) {" + NL + "\t\t\tstartTabs_";
  protected final String TEXT_439 = "[i_";
  protected final String TEXT_440 = "] = null;" + NL + "\t\t\tendTabs_";
  protected final String TEXT_441 = "[i_";
  protected final String TEXT_442 = "] = null;" + NL + "\t\t}" + NL + "//\t\tendTabStrs_";
  protected final String TEXT_443 = ".clear();" + NL + "\t\tout_";
  protected final String TEXT_444 = ".newLine();" + NL + "\t\tout_";
  protected final String TEXT_445 = ".close();" + NL + "\t\tlistGroupby_";
  protected final String TEXT_446 = ".add(strWriter_";
  protected final String TEXT_447 = ".toString());" + NL + "" + NL + "\t\t//create a new StringWriter and BufferWriter" + NL + "\t\t//write the head title to the StringWriter\t\t" + NL + "\t\tstrWriter_";
  protected final String TEXT_448 = " = new java.io.StringWriter();" + NL + "\t\tout_";
  protected final String TEXT_449 = " = new java.io.BufferedWriter(strWriter_";
  protected final String TEXT_450 = ");";
  protected final String TEXT_451 = NL + "\t\tout_";
  protected final String TEXT_452 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_453 = "+\"\\\"?>\");" + NL + "\t\tout_";
  protected final String TEXT_454 = ".newLine();";
  protected final String TEXT_455 = NL + NL + "\t\tneedRoot_";
  protected final String TEXT_456 = " = true;" + NL + "\t\tstrCompCache_";
  protected final String TEXT_457 = "=strTemp_";
  protected final String TEXT_458 = ";" + NL + "\t\t";
  protected final String TEXT_459 = NL + "\t\t}";
  protected final String TEXT_460 = "\t" + NL + "\t}\t" + NL + "\t" + NL + "\tStringBuffer buf_";
  protected final String TEXT_461 = " = new StringBuffer();" + NL + "\t//init value is 0 not -1, because it will output the root tab when all the row value is null." + NL + "\tint unNullMaxIndex_";
  protected final String TEXT_462 = " = 0;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_463 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_464 = "=false;";
  protected final String TEXT_465 = NL + "\t\tif( false";
  protected final String TEXT_466 = " || valueMap_";
  protected final String TEXT_467 = ".get(\"";
  protected final String TEXT_468 = "\") != null";
  protected final String TEXT_469 = NL + "\t\t){" + NL + "\t\t\tunNullMaxIndex_";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = ";" + NL + "\t\t}";
  protected final String TEXT_472 = NL + "\t\tendTabs_";
  protected final String TEXT_473 = "[";
  protected final String TEXT_474 = "] = buf_";
  protected final String TEXT_475 = ".toString();" + NL + "\t\tbuf_";
  protected final String TEXT_476 = " = new StringBuffer();";
  protected final String TEXT_477 = NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_478 = NL + "\tboolean isNewElememt = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_479 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_480 = " = new String[";
  protected final String TEXT_481 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_482 = " = new String[";
  protected final String TEXT_483 = "];";
  protected final String TEXT_484 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_485 = " or not" + NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_486 = ".size()<=";
  protected final String TEXT_487 = " || groupbyList_";
  protected final String TEXT_488 = ".get(";
  protected final String TEXT_489 = ")==null";
  protected final String TEXT_490 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_491 = ".get(";
  protected final String TEXT_492 = ").get(";
  protected final String TEXT_493 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_494 = ".get(";
  protected final String TEXT_495 = ").get(";
  protected final String TEXT_496 = ").equals(";
  protected final String TEXT_497 = ") " + NL + "\t\t: ";
  protected final String TEXT_498 = "!=null )";
  protected final String TEXT_499 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(isNewElememt == false && groupbyList_";
  protected final String TEXT_500 = ".size()>";
  protected final String TEXT_501 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_502 = " = ";
  protected final String TEXT_503 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_504 = ".size()<=";
  protected final String TEXT_505 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_506 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_507 = ".get(";
  protected final String TEXT_508 = ").clear();" + NL + "        }";
  protected final String TEXT_509 = NL + "\t\tgroupbyList_";
  protected final String TEXT_510 = ".get(";
  protected final String TEXT_511 = ").add(";
  protected final String TEXT_512 = ");";
  protected final String TEXT_513 = NL + "        isNewElememt=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_514 = NL + "\tif( false";
  protected final String TEXT_515 = " || valueMap_";
  protected final String TEXT_516 = ".get(\"";
  protected final String TEXT_517 = "\") != null";
  protected final String TEXT_518 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_519 = " = ";
  protected final String TEXT_520 = ";" + NL + "\t}";
  protected final String TEXT_521 = NL + "\t// buffer the end tabs to group buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_522 = "[";
  protected final String TEXT_523 = "] = buf_";
  protected final String TEXT_524 = ".toString();" + NL + "    buf_";
  protected final String TEXT_525 = " = new StringBuffer();";
  protected final String TEXT_526 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_527 = " >= 0) {" + NL + "        //out_";
  protected final String TEXT_528 = ".newLine();//Track code";
  protected final String TEXT_529 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_530 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_531 = " = 0; i_";
  protected final String TEXT_532 = " < startTabs_";
  protected final String TEXT_533 = ".length; i_";
  protected final String TEXT_534 = "++) {" + NL + "                if (i_";
  protected final String TEXT_535 = " <= preUnNullMaxIndex_";
  protected final String TEXT_536 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_537 = "[i_";
  protected final String TEXT_538 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_539 = ".write(startTabs_";
  protected final String TEXT_540 = "[i_";
  protected final String TEXT_541 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_542 = "[i_";
  protected final String TEXT_543 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_544 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_545 = " = 0; i_";
  protected final String TEXT_546 = " < startTabs_";
  protected final String TEXT_547 = ".length; i_";
  protected final String TEXT_548 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_549 = "[i_";
  protected final String TEXT_550 = "] != null) {" + NL + "                out_";
  protected final String TEXT_551 = ".write(startTabs_";
  protected final String TEXT_552 = "[i_";
  protected final String TEXT_553 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_554 = "[i_";
  protected final String TEXT_555 = "] = null;" + NL + "        }";
  protected final String TEXT_556 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_557 = " >= preNewTabIndex_";
  protected final String TEXT_558 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_559 = " >= ";
  protected final String TEXT_560 = " + newTabIndex_";
  protected final String TEXT_561 = ") {" + NL + "            for (int i_";
  protected final String TEXT_562 = " = preUnNullMaxIndex_";
  protected final String TEXT_563 = "; i_";
  protected final String TEXT_564 = " >= ";
  protected final String TEXT_565 = " + newTabIndex_";
  protected final String TEXT_566 = "; i_";
  protected final String TEXT_567 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_568 = "[i_";
  protected final String TEXT_569 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_570 = ".write(endTabs_";
  protected final String TEXT_571 = "[i_";
  protected final String TEXT_572 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_573 = "[i_";
  protected final String TEXT_574 = "] = null;" + NL + "                out_";
  protected final String TEXT_575 = ".newLine();" + NL + "                out_";
  protected final String TEXT_576 = ".write(endTabStrs_";
  protected final String TEXT_577 = NL + "                        .get(i_";
  protected final String TEXT_578 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_579 = NL + "            for (int i_";
  protected final String TEXT_580 = " = preNewTabIndex_";
  protected final String TEXT_581 = " - 1; i_";
  protected final String TEXT_582 = " >= ";
  protected final String TEXT_583 = " + newTabIndex_";
  protected final String TEXT_584 = "; i_";
  protected final String TEXT_585 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_586 = "[i_";
  protected final String TEXT_587 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_588 = ".write(endTabs_";
  protected final String TEXT_589 = "[i_";
  protected final String TEXT_590 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_591 = "[i_";
  protected final String TEXT_592 = "] = null;" + NL + "                out_";
  protected final String TEXT_593 = ".newLine();" + NL + "                out_";
  protected final String TEXT_594 = ".write(endTabStrs_";
  protected final String TEXT_595 = NL + "                        .get(i_";
  protected final String TEXT_596 = "));" + NL + "            }";
  protected final String TEXT_597 = NL + "        }";
  protected final String TEXT_598 = NL + "        preNewTabIndex_";
  protected final String TEXT_599 = " = newTabIndex_";
  protected final String TEXT_600 = " + ";
  protected final String TEXT_601 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_602 = " = 0; i_";
  protected final String TEXT_603 = " < groupBuffer_";
  protected final String TEXT_604 = ".length; i_";
  protected final String TEXT_605 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_606 = " >= preNewTabIndex_";
  protected final String TEXT_607 = " - ";
  protected final String TEXT_608 = ") {" + NL + "            startTabs_";
  protected final String TEXT_609 = "[i_";
  protected final String TEXT_610 = " + ";
  protected final String TEXT_611 = "] = groupBuffer_";
  protected final String TEXT_612 = "[i_";
  protected final String TEXT_613 = "];" + NL + "            endTabs_";
  protected final String TEXT_614 = "[i_";
  protected final String TEXT_615 = " + ";
  protected final String TEXT_616 = "] = groupEndBuffer_";
  protected final String TEXT_617 = "[i_";
  protected final String TEXT_618 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_619 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_620 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_621 = "=unNullMaxIndex_";
  protected final String TEXT_622 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_623 = ">";
  protected final String TEXT_624 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_625 = "=";
  protected final String TEXT_626 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_627 = NL + "\t// build loop xml tree";
  protected final String TEXT_628 = NL + "\t\tif( false";
  protected final String TEXT_629 = " || valueMap_";
  protected final String TEXT_630 = ".get(\"";
  protected final String TEXT_631 = "\") != null";
  protected final String TEXT_632 = " || true " + NL + "    \t";
  protected final String TEXT_633 = NL + "\t\t){";
  protected final String TEXT_634 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_635 = " = 0; i_";
  protected final String TEXT_636 = " < startTabs_";
  protected final String TEXT_637 = ".length; i_";
  protected final String TEXT_638 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_639 = "[i_";
  protected final String TEXT_640 = "] != null && startTabs_";
  protected final String TEXT_641 = "[i_";
  protected final String TEXT_642 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_643 = ".write(startTabs_";
  protected final String TEXT_644 = "[i_";
  protected final String TEXT_645 = "]);" + NL + "                startTabs_";
  protected final String TEXT_646 = "[i_";
  protected final String TEXT_647 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_648 = ".write(buf_";
  protected final String TEXT_649 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_650 = " = ";
  protected final String TEXT_651 = ";";
  protected final String TEXT_652 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_653 = " = ";
  protected final String TEXT_654 = ";" + NL + "\t\t}";
  protected final String TEXT_655 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
    }

    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }

    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_4);
    
	}

	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_5);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_13);
    
    		} else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_18);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_25);
    
            }else{

    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
        }else{

    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_34);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_35);
    
			}
		}

    stringBuffer.append(TEXT_36);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_40);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_65);
    
			}else{

    stringBuffer.append(TEXT_66);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_69);
    
			}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
		}else{
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_103);
    
			}else{

    stringBuffer.append(TEXT_104);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_109);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_114);
    tool.getValue(node);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    tool.getValue(node);
    stringBuffer.append(TEXT_119);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
				}
			}else{

    stringBuffer.append(TEXT_126);
    tool.getValue(node);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    tool.getValue(node);
    stringBuffer.append(TEXT_131);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_141);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_142);
    tool.getValue(node);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_146);
    tool.getValue(node);
    stringBuffer.append(TEXT_147);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_152);
    
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_153);
    tool.getValue(node);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_157);
    tool.getValue(node);
    stringBuffer.append(TEXT_158);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    tool.getValue(node);
    stringBuffer.append(TEXT_164);
    
			}

    stringBuffer.append(TEXT_165);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_166);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_170);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_171);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_176);
    
			}
		}
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	String fileNameXSD = "";
	XMLTool tool = null;
	
	public void generateCode(XMLNode node, String emptySpace){	
		if(("ELEMENT").equals(node.type)){
			startElement(node,emptySpace);
			setText(node);
			XMLNode mainChild = null;
			for(XMLNode child:node.elements){
				if(child.isMainNode()){ //loop dosen't have a main child node
					mainChild = child;
					break;
				}
			}
			for(XMLNode child:node.elements){
				if(mainChild!=null && mainChild.order<=child.order){ //loop dosen't have a main child node
					if(1==(node.special & 1)){ // group

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
						}else{

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty && (child.relatedColumn != null || child.childrenColumnList.size()>0 || child.hasDefaultValue == true)){

    stringBuffer.append(TEXT_191);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_194);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    
						generateCode(child,emptySpace+"  ");

    stringBuffer.append(TEXT_197);
    
            		}else{
            			generateCode(child,emptySpace+"  ");
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_202);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_206);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_207);
    tool.getValue(node);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
		}

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_216);
    
		}else{

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_219);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_220);
    tool.getValue(node);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    tool.getValue(node);
    stringBuffer.append(TEXT_223);
    
			}else{

    stringBuffer.append(TEXT_224);
    tool.getValue(node);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    tool.getValue(node);
    stringBuffer.append(TEXT_227);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_230);
    
		}
	}
	private void addAttribute(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_231);
    tool.getValue(node);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_234);
    tool.getValue(node);
    stringBuffer.append(TEXT_235);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_239);
    
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_240);
    tool.getValue(node);
    stringBuffer.append(TEXT_241);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    tool.getValue(node);
    stringBuffer.append(TEXT_244);
    
			}else{

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_247);
    tool.getValue(node);
    stringBuffer.append(TEXT_248);
    
			}

    stringBuffer.append(TEXT_249);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_252);
    
			}else{

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_256);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

IMetadataTable metadata = null;
IConnection inConn = null;
for (IConnection conn : node.getIncomingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.FLOW)) {
		inConn = conn;
		break;
	}
}
if (inConn != null) {
	metadata = inConn.getMetadataTable();
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
            	List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                
                IMetadataTable inputMetadataTable= conn.getMetadataTable();
                List<IMetadataColumn> inputColumns= inputMetadataTable.getListColumns();
                
                List<Map<String,String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
				
				String removeHeader = ElementParameterParser.getValue(node, "__REMOVE_HEADER__"); // add for feature7788
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
                String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");                
                
	            String rowNumber = ElementParameterParser.getValue(node, "__ROW_NUMBER__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        		
        		boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
        		                
                java.util.Map<String,IMetadataColumn> inputKeysColumns = new java.util.HashMap<String,IMetadataColumn>();
                if(inputColumns!=null){
                	for(IMetadataColumn column :inputColumns){
                		for(int i=0;i<groupbys.size();i++){
                			String columnName=groupbys.get(i).get("INPUT_COLUMN");
                			if(column.getLabel().equals(columnName)){
                				inputKeysColumns.put(columnName,column);
                				break;
                			}
                		}
                	}
                }
        		
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = conn.getName();
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);
            	XMLNode loop = (XMLNode)treeObjs[2];
                
                if(!("true").equals(allowEmpty)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
				for(IMetadataColumn column :inputColumns){

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_262);
    tool.getValue(column);
    stringBuffer.append(TEXT_263);
    
				}

    if(storeFlow){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    
	if(inputKeysColumns.size() !=0){
		for (IMetadataColumn column : inputColumns) {
			if(inputKeysColumns.containsKey(column.getLabel())) {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_278);
    			}
		}
	}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
if(("Dom4j").equals(mode)){
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    		}
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
		}

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
		}

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
		if(("true").equals(removeHeader)){

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    
		}else{

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    
		}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_327);
    
		}

    stringBuffer.append(TEXT_328);
    
	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
    if(("true").equals(outputAsXSD)){
    	generateToolByDom4j.outputAsXSD = true;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByDom4j.allowEmpty = true;
    }
    generateToolByDom4j.cid = cid;
    generateToolByDom4j.tool = tool;
    
    //start generate code

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    
	generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_338);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_343);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_350);
    tool.getValue(attr);
    stringBuffer.append(TEXT_351);
    tool.getValue(attr);
    stringBuffer.append(TEXT_352);
    
			}
		}

    stringBuffer.append(TEXT_353);
    
		generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_359);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_362);
    tool.getValue(attr);
    stringBuffer.append(TEXT_363);
    
		}

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_376);
    
	}

    stringBuffer.append(TEXT_377);
    
	generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
else if(("Null").equals(mode)){
//	String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
	//init the generate tool.
	GenerateToolByNull generateToolByNull = new GenerateToolByNull();
    if(("true").equals(outputAsXSD)){
    	generateToolByNull.outputAsXSD = true;
    	generateToolByNull.fileNameXSD = fileNameXSD;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByNull.allowEmpty = true;
    }
    generateToolByNull.cid = cid;
    generateToolByNull.tool = tool;

	if(inputKeysColumns.size() !=0){
	
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    	}
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
			}
		}

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    
	if(!("true").equals(removeHeader)){

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    
	}

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    	if(inputKeysColumns.size() !=0){
    stringBuffer.append(TEXT_459);
    	}
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
	String rootEmptySpace = "";
	for(int i=0;i<mainList.size();i++){
		generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		rootEmptySpace+="  ";
		
		if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
			if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){

    stringBuffer.append(TEXT_465);
    
                	for(IMetadataColumn column : mainList.get(i).childrenColumnList){
                		
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_468);
    
                	}

    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_471);
    
			}
		}

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    

	}

    stringBuffer.append(TEXT_477);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_483);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_484);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_489);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_496);
    tool.getValue(attr);
    stringBuffer.append(TEXT_497);
    tool.getValue(attr);
    stringBuffer.append(TEXT_498);
    
			}
		}

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_508);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_511);
    tool.getValue(attr);
    stringBuffer.append(TEXT_512);
    
		}

    stringBuffer.append(TEXT_513);
    
		String emptySpace = "";
		for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
			emptySpace +="  ";
		}
		generateToolByNull.generateCode(groupList.get(i),emptySpace);
		
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_514);
    
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
            		
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_517);
    
            	}

    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_520);
    
			}
		}

    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    
		}else{

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    
		}

    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_597);
    
		}

    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_626);
    
	}

    stringBuffer.append(TEXT_627);
    
	String emptySpace = "";
	for(int len =loop.path.split("/").length-1;len>1;len--){
		emptySpace +="  ";
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_628);
    
    	for(IMetadataColumn column : loop.childrenColumnList){
    		
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_631);
    
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_632);
    }
    stringBuffer.append(TEXT_633);
    
	}
	generateToolByNull.generateCode(loop,emptySpace);
	generateToolByNull.endElement(loop,emptySpace);

    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_651);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_654);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_655);
    return stringBuffer.toString();
  }
}
