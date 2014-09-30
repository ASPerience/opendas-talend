package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.ArrayList;
import java.util.LinkedList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLBeginJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLBeginJava result = new TAdvancedFileOutputXMLBeginJava();
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
  protected final String TEXT_10 = "), ";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ")\t\t\t\t\t";
  protected final String TEXT_13 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "), ";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ")\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "            String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = NL + "            ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".toString()";
  protected final String TEXT_32 = ":";
  protected final String TEXT_33 = "null";
  protected final String TEXT_34 = NL + "\t\t)";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = " = null;";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ".addElement(\"";
  protected final String TEXT_53 = "\");";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ".addElement(\"";
  protected final String TEXT_59 = "\");";
  protected final String TEXT_60 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = ";";
  protected final String TEXT_64 = NL + "\t\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_65 = " = null;";
  protected final String TEXT_66 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_67 = " =  tempElem;";
  protected final String TEXT_68 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_69 = "=root4Group_";
  protected final String TEXT_70 = ";";
  protected final String TEXT_71 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_72 = " = firstGroupPathElement_";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_75 = "=group";
  protected final String TEXT_76 = "__";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_79 = "=groupElementList_";
  protected final String TEXT_80 = ".get(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_83 = "=loop_";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL + "\t\tnameToElement_";
  protected final String TEXT_86 = ".get(\"";
  protected final String TEXT_87 = "\")";
  protected final String TEXT_88 = NL + "\t\t((org.dom4j.Element)(nameToElement_";
  protected final String TEXT_89 = ".get(\"";
  protected final String TEXT_90 = "\")))";
  protected final String TEXT_91 = NL + "\t\tnameToElement_";
  protected final String TEXT_92 = ".put(\"";
  protected final String TEXT_93 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_94 = "\"));";
  protected final String TEXT_95 = NL + "\t\tnameToElement_";
  protected final String TEXT_96 = ".put(\"";
  protected final String TEXT_97 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_98 = "\"));";
  protected final String TEXT_99 = NL + "\t\tnameToElement_";
  protected final String TEXT_100 = ".put(\"";
  protected final String TEXT_101 = "\",";
  protected final String TEXT_102 = ".addElement(\"";
  protected final String TEXT_103 = "\"));";
  protected final String TEXT_104 = NL + "\t\tnameToElement_";
  protected final String TEXT_105 = ".put(\"";
  protected final String TEXT_106 = "\",";
  protected final String TEXT_107 = ".addElement(\"";
  protected final String TEXT_108 = "\"));";
  protected final String TEXT_109 = NL + "\t\tnameToElement_";
  protected final String TEXT_110 = ".put(\"subTreeRootParent\",";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\tnameToElement_";
  protected final String TEXT_113 = ".put(\"subTreeRootParent\",null);";
  protected final String TEXT_114 = NL + "\t\tnameToElement_";
  protected final String TEXT_115 = ".put(\"subTreeRootParent\",tempElem);";
  protected final String TEXT_116 = NL + "\t\tnameToElement_";
  protected final String TEXT_117 = ".put(\"doc\",doc_";
  protected final String TEXT_118 = ");";
  protected final String TEXT_119 = NL + "\t\tnameToElement_";
  protected final String TEXT_120 = ".put(\"subTreeRootParent\",root4Group_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\tnameToElement_";
  protected final String TEXT_123 = ".put(\"subTreeRootParent\",firstGroupPathElement_";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "\t\tnameToElement_";
  protected final String TEXT_126 = ".put(\"subTreeRootParent\",group";
  protected final String TEXT_127 = "__";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\tnameToElement_";
  protected final String TEXT_130 = ".put(\"subTreeRootParent\",groupElementList_";
  protected final String TEXT_131 = ".get(";
  protected final String TEXT_132 = "));";
  protected final String TEXT_133 = NL + "\t\tnameToElement_";
  protected final String TEXT_134 = ".put(\"subTreeRootParent\",loop_";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL;
  protected final String TEXT_137 = NL + "\t\t\tclass TalendXMLGenerateTool_";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = " {";
  protected final String TEXT_140 = NL + "\t\t\t}";
  protected final String TEXT_141 = NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_142 = "() throws java.lang.Exception{";
  protected final String TEXT_143 = NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_144 = "() throws java.lang.Exception{";
  protected final String TEXT_145 = NL + "\t\t\tTalendXMLGenerateTool_";
  protected final String TEXT_146 = "_";
  protected final String TEXT_147 = " talendXMLGenerateTool_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = " = new TalendXMLGenerateTool_";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = "();";
  protected final String TEXT_152 = NL + "\t\t\t\t\ttalendXMLGenerateTool_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ".generateDocument_";
  protected final String TEXT_155 = "();";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + "\t\t\t";
  protected final String TEXT_158 = ".setName(\"";
  protected final String TEXT_159 = "\");";
  protected final String TEXT_160 = NL + "\t\t\tif (";
  protected final String TEXT_161 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_162 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_163 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_164 = ".remove(";
  protected final String TEXT_165 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_166 = NL + "\t\tif (";
  protected final String TEXT_167 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_168 = "\") == null) {" + NL + "\t\t\t";
  protected final String TEXT_169 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_170 = NL + "        }";
  protected final String TEXT_171 = NL + "\t\t";
  protected final String TEXT_172 = NL + "\t\tList currentList_";
  protected final String TEXT_173 = " =  ";
  protected final String TEXT_174 = ".elements(\"";
  protected final String TEXT_175 = "\");" + NL + "\t\tint app_size_";
  protected final String TEXT_176 = " = currentList_";
  protected final String TEXT_177 = ".size();" + NL + "\t\tif(app_size_";
  protected final String TEXT_178 = " > 0){" + NL + "\t\t\torders_";
  protected final String TEXT_179 = "[";
  protected final String TEXT_180 = "] =1+ ";
  protected final String TEXT_181 = ".elements().indexOf(currentList_";
  protected final String TEXT_182 = ".get(app_size_";
  protected final String TEXT_183 = "-1));" + NL + "\t\t}else{//when the group or loop element appear first time";
  protected final String TEXT_184 = NL + "\t\t\tList allList_";
  protected final String TEXT_185 = " = ";
  protected final String TEXT_186 = ".elements();" + NL + "\t\t\t//append tail as default action" + NL + "\t\t\torders_";
  protected final String TEXT_187 = "[";
  protected final String TEXT_188 = "] = allList_";
  protected final String TEXT_189 = ".size();";
  protected final String TEXT_190 = NL + "\t\t\tList siblingList_";
  protected final String TEXT_191 = " = null;" + NL + "\t\t\tboolean findInsertPosition_";
  protected final String TEXT_192 = " = false;";
  protected final String TEXT_193 = NL + "\t\t\tif(!findInsertPosition_";
  protected final String TEXT_194 = " && allList_";
  protected final String TEXT_195 = ".size()!=0) {" + NL + "\t\t\t\tsiblingList_";
  protected final String TEXT_196 = " = ";
  protected final String TEXT_197 = ".elements(\"";
  protected final String TEXT_198 = "\");" + NL + "\t\t\t\tif(siblingList_";
  protected final String TEXT_199 = ".size() > 0) {" + NL + "\t\t\t\t\tfindInsertPosition_";
  protected final String TEXT_200 = " = true;" + NL + "\t\t\t\t\torders_";
  protected final String TEXT_201 = "[";
  protected final String TEXT_202 = "] = allList_";
  protected final String TEXT_203 = ".indexOf(siblingList_";
  protected final String TEXT_204 = ".get(0));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_205 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_206 = ".elements().add(orders_";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "],";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "        if(orders_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_213 = "[";
  protected final String TEXT_214 = "] = ";
  protected final String TEXT_215 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_216 = " < orders_";
  protected final String TEXT_217 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_218 = "[";
  protected final String TEXT_219 = "] = 0;" + NL + "        }";
  protected final String TEXT_220 = ".elements().add(orders_";
  protected final String TEXT_221 = "[";
  protected final String TEXT_222 = "]++,";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "\t\tif (";
  protected final String TEXT_225 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_226 = "\") == null) {";
  protected final String TEXT_227 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_228 = NL + "        }";
  protected final String TEXT_229 = NL + "\t\t";
  protected final String TEXT_230 = NL + "\t\t";
  protected final String TEXT_231 = NL + "\t\tif(";
  protected final String TEXT_232 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_233 = " .parseAndAdd(";
  protected final String TEXT_234 = ",";
  protected final String TEXT_235 = ");" + NL + "\t\t}";
  protected final String TEXT_236 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_237 = " .parseAndAdd(";
  protected final String TEXT_238 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_239 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_240 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_241 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_242 = " .setText(";
  protected final String TEXT_243 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_244 = ").getDocument().getRootElement().asXML());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_245 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_246 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_247 = " .setText(";
  protected final String TEXT_248 = ",";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_250 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_251 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_252 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_253 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_254 = ".parseAndAdd(";
  protected final String TEXT_255 = ",\"";
  protected final String TEXT_256 = "\");" + NL;
  protected final String TEXT_257 = " " + NL + "\t\t  if (";
  protected final String TEXT_258 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_259 = ".addAttribute(\"";
  protected final String TEXT_260 = "\", ";
  protected final String TEXT_261 = ");" + NL + "\t\t  } ";
  protected final String TEXT_262 = " else {" + NL + "\t\t    ";
  protected final String TEXT_263 = ".addAttribute(\"";
  protected final String TEXT_264 = "\", \"\");" + NL + "          }";
  protected final String TEXT_265 = NL + "\t\t    ";
  protected final String TEXT_266 = ".addAttribute(\"";
  protected final String TEXT_267 = "\", \"";
  protected final String TEXT_268 = "\");";
  protected final String TEXT_269 = NL + "\t\t    ";
  protected final String TEXT_270 = ".addAttribute(\"";
  protected final String TEXT_271 = "\", \"\");" + NL + "\t\t  ";
  protected final String TEXT_272 = NL + "\t\tif(";
  protected final String TEXT_273 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_274 = ".addNamespace(\"";
  protected final String TEXT_275 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_276 = "));";
  protected final String TEXT_277 = NL + "        \t";
  protected final String TEXT_278 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_279 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_280 = "))));";
  protected final String TEXT_281 = NL + "\t\t}";
  protected final String TEXT_282 = NL + "\t\t\t";
  protected final String TEXT_283 = ".addNamespace(\"";
  protected final String TEXT_284 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_285 = "\"));";
  protected final String TEXT_286 = NL + "        \t";
  protected final String TEXT_287 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_288 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_289 = "\"))));";
  protected final String TEXT_290 = "true";
  protected final String TEXT_291 = " && (";
  protected final String TEXT_292 = "(";
  protected final String TEXT_293 = "==null && ";
  protected final String TEXT_294 = " == null) || (true &&";
  protected final String TEXT_295 = "!=null" + NL + " && ";
  protected final String TEXT_296 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_297 = ".getText().equals(";
  protected final String TEXT_298 = ")";
  protected final String TEXT_299 = ")";
  protected final String TEXT_300 = NL + ")";
  protected final String TEXT_301 = " && (";
  protected final String TEXT_302 = "(";
  protected final String TEXT_303 = "==null && ";
  protected final String TEXT_304 = ".attribute(\"";
  protected final String TEXT_305 = "\") == null) || (true && ";
  protected final String TEXT_306 = ".attribute(\"";
  protected final String TEXT_307 = "\")!=null" + NL + "&& ";
  protected final String TEXT_308 = ".attribute(\"";
  protected final String TEXT_309 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_310 = ".attribute(\"";
  protected final String TEXT_311 = "\").getText().equals(";
  protected final String TEXT_312 = ")";
  protected final String TEXT_313 = ")";
  protected final String TEXT_314 = ")";
  protected final String TEXT_315 = NL;
  protected final String TEXT_316 = ".element(";
  protected final String TEXT_317 = ".getQName(\"";
  protected final String TEXT_318 = "\"))";
  protected final String TEXT_319 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_320 = "[";
  protected final String TEXT_321 = "] = buf_";
  protected final String TEXT_322 = ".toString();" + NL + "        buf_";
  protected final String TEXT_323 = " = new StringBuffer();";
  protected final String TEXT_324 = NL + "\t\tstartTabs_";
  protected final String TEXT_325 = "[";
  protected final String TEXT_326 = "] = buf_";
  protected final String TEXT_327 = ".toString();" + NL + "        buf_";
  protected final String TEXT_328 = " = new StringBuffer();";
  protected final String TEXT_329 = NL + "\t\tout_";
  protected final String TEXT_330 = ".write(buf_";
  protected final String TEXT_331 = ".toString());" + NL + "        buf_";
  protected final String TEXT_332 = " = new StringBuffer();";
  protected final String TEXT_333 = NL + "\t\tif( false";
  protected final String TEXT_334 = " || valueMap_";
  protected final String TEXT_335 = ".get(\"";
  protected final String TEXT_336 = "\") != null";
  protected final String TEXT_337 = " || true " + NL + "                    \t";
  protected final String TEXT_338 = NL + "\t\t){";
  protected final String TEXT_339 = NL + "\t\t}";
  protected final String TEXT_340 = NL + "\t\tbuf_";
  protected final String TEXT_341 = ".append(\"";
  protected final String TEXT_342 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_343 = ".append(\"";
  protected final String TEXT_344 = "<";
  protected final String TEXT_345 = "\");";
  protected final String TEXT_346 = NL + "\t\tbuf_";
  protected final String TEXT_347 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_348 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+ file_";
  protected final String TEXT_349 = ".substring(file_";
  protected final String TEXT_350 = ".lastIndexOf(\"/\")+1)+\".xsd\"+\"\\\"\");";
  protected final String TEXT_351 = NL + "\t\tif(";
  protected final String TEXT_352 = " == null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_353 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_354 = NL + "\t\tbuf_";
  protected final String TEXT_355 = ".append(\">\");";
  protected final String TEXT_356 = NL + "\t\tbuf_";
  protected final String TEXT_357 = ".append(\"";
  protected final String TEXT_358 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_359 = ".append(\"";
  protected final String TEXT_360 = "</";
  protected final String TEXT_361 = ">\");";
  protected final String TEXT_362 = NL + "\t\tbuf_";
  protected final String TEXT_363 = ".append(\"</";
  protected final String TEXT_364 = ">\");";
  protected final String TEXT_365 = NL + "\t\tif(";
  protected final String TEXT_366 = "!=null){" + NL + "\t\t\tif(routines.system.XMLHelper.getInstance().isValid(";
  protected final String TEXT_367 = ")){" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_368 = ".append(";
  protected final String TEXT_369 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_370 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_371 = "));" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_372 = NL + "\t\tif(";
  protected final String TEXT_373 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_374 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_375 = "));" + NL + "\t\t}";
  protected final String TEXT_376 = NL + "\t\tif(routines.system.XMLHelper.getInstance().isValid(\"";
  protected final String TEXT_377 = "\")){" + NL + "\t\t\tbuf_";
  protected final String TEXT_378 = ".append(\"";
  protected final String TEXT_379 = "\");" + NL + "\t\t} else {" + NL + "\t\t\tbuf_";
  protected final String TEXT_380 = ".append(TalendString.checkCDATAForXML(\"";
  protected final String TEXT_381 = "\"));" + NL + "\t\t}";
  protected final String TEXT_382 = NL + "\t\t  if (";
  protected final String TEXT_383 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_384 = ".append(\" ";
  protected final String TEXT_385 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_386 = ")+\"\\\"\");" + NL + "\t\t  } ";
  protected final String TEXT_387 = " else{" + NL + "\t\t    buf_";
  protected final String TEXT_388 = ".append(\" ";
  protected final String TEXT_389 = "=\\\"\\\"\");" + NL + "\t\t  }";
  protected final String TEXT_390 = NL + "\t\t    buf_";
  protected final String TEXT_391 = ".append(\" ";
  protected final String TEXT_392 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_393 = "\")+\"\\\"\");";
  protected final String TEXT_394 = NL + "\t\t    buf_";
  protected final String TEXT_395 = ".append(\" ";
  protected final String TEXT_396 = "=\\\"\\\"\");" + NL + "\t\t  ";
  protected final String TEXT_397 = NL + "\t\tif(";
  protected final String TEXT_398 = "!=null){";
  protected final String TEXT_399 = NL + "        \tbuf_";
  protected final String TEXT_400 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_401 = ")+\"\\\"\");";
  protected final String TEXT_402 = NL + "\t\t\tbuf_";
  protected final String TEXT_403 = ".append(\" xmlns:";
  protected final String TEXT_404 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_405 = ")+\"\\\"\");";
  protected final String TEXT_406 = NL + "\t\t}";
  protected final String TEXT_407 = NL + "        \tbuf_";
  protected final String TEXT_408 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_409 = "\")+\"\\\"\");";
  protected final String TEXT_410 = NL + "\t\t\tbuf_";
  protected final String TEXT_411 = ".append(\" xmlns:";
  protected final String TEXT_412 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_413 = "\")+\"\\\"\");";
  protected final String TEXT_414 = NL;
  protected final String TEXT_415 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_416 = " = 0;" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_417 = NL + "\t\t\t\tboolean needRoot_";
  protected final String TEXT_418 = "  = false;" + NL + "\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t\tboolean\tneedRoot_";
  protected final String TEXT_420 = " = true;" + NL + "\t\t\t";
  protected final String TEXT_421 = NL + "\t\t\tString fileName_";
  protected final String TEXT_422 = " = ";
  protected final String TEXT_423 = ";" + NL + "\t\t\tBoolean alreadyExistsFile_";
  protected final String TEXT_424 = " = new java.io.File(fileName_";
  protected final String TEXT_425 = ").exists();" + NL + "\t\t\tfileName_";
  protected final String TEXT_426 = " = new java.io.File(fileName_";
  protected final String TEXT_427 = ").getAbsolutePath().replace(\"\\\\\", \"/\");" + NL + "\t\t\t" + NL + "\t\t\tString fileNameWithoutSuffix_";
  protected final String TEXT_428 = " = \"\";" + NL + "\t\t\t" + NL + "\t\t\tif (fileName_";
  protected final String TEXT_429 = ".indexOf(\"/\") < 0) {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"not a correct file name.\");\t\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString tail_";
  protected final String TEXT_430 = " = fileName_";
  protected final String TEXT_431 = ".substring(fileName_";
  protected final String TEXT_432 = ".lastIndexOf(\"/\"));" + NL + "\t\t\t\tfileNameWithoutSuffix_";
  protected final String TEXT_433 = " = tail_";
  protected final String TEXT_434 = ".lastIndexOf(\".\") > 0 ? fileName_";
  protected final String TEXT_435 = ".substring(0, fileName_";
  protected final String TEXT_436 = ".lastIndexOf(\".\")) : fileName_";
  protected final String TEXT_437 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfinal String file_";
  protected final String TEXT_438 = " = fileNameWithoutSuffix_";
  protected final String TEXT_439 = ";" + NL + "\t\t\t" + NL + "\t\t\tjava.io.File createFile";
  protected final String TEXT_440 = " = new java.io.File(fileName_";
  protected final String TEXT_441 = "); " + NL + "" + NL + "\t\t\t";
  protected final String TEXT_442 = NL + "\t\t\t\tif (!createFile";
  protected final String TEXT_443 = ".exists()) { " + NL + "\t\t\t\t\t(new java.io.File(fileName_";
  protected final String TEXT_444 = ".substring(0,fileName_";
  protected final String TEXT_445 = ".lastIndexOf(\"/\")))).mkdirs(); " + NL + "\t\t\t\t\tneedRoot_";
  protected final String TEXT_446 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_447 = NL + "\t\t\t\tif (!createFile";
  protected final String TEXT_448 = ".exists() || (createFile";
  protected final String TEXT_449 = ".isFile() && createFile";
  protected final String TEXT_450 = ".length() < 1)) {" + NL + "\t\t\t\t\tneedRoot_";
  protected final String TEXT_451 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_452 = NL + "\t\t\t\tint currentRowCount_";
  protected final String TEXT_453 = " = 0;" + NL + "\t\t\t\tint currentFileCount_";
  protected final String TEXT_454 = " = 0;" + NL + "\t\t\t\tString suffix_";
  protected final String TEXT_455 = " = \"\";" + NL + "" + NL + "\t\t\t\tif (fileName_";
  protected final String TEXT_456 = ".substring(fileName_";
  protected final String TEXT_457 = ".lastIndexOf(\"/\")).lastIndexOf(\".\") > 0) {" + NL + "\t\t\t\t\tsuffix_";
  protected final String TEXT_458 = " = fileName_";
  protected final String TEXT_459 = ".substring(fileName_";
  protected final String TEXT_460 = ".lastIndexOf(\".\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfileName_";
  protected final String TEXT_461 = " = file_";
  protected final String TEXT_462 = "+\"0\" + suffix_";
  protected final String TEXT_463 = ";" + NL + "\t\t\t";
  protected final String TEXT_464 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_465 = " = 0;" + NL + "\t\t\tboolean\tneedRoot_";
  protected final String TEXT_466 = " = true;" + NL + "\t\t";
  protected final String TEXT_467 = NL + "\t\tjava.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_468 = " = new java.util.ArrayList<java.util.List<String>>();" + NL + "\t\tfinal java.util.Map<String,String> valueMap_";
  protected final String TEXT_469 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "\t\t";
  protected final String TEXT_470 = NL + NL + "\t\t\tclass NestXMLTool_";
  protected final String TEXT_471 = " {" + NL + "\t\t\t\tpublic void parseAndAdd(org.dom4j.Element nestRoot, String value) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\torg.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText(\"<root>\"+ value + \"</root>\");" + NL + "\t\t\t\t\t\tnestRoot.setContent(doc4Str.getRootElement().content());" + NL + "\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t//    \t\te.printStackTrace();" + NL + "\t\t\t\t\t\tnestRoot.setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void setText(org.dom4j.Element element, String value) {" + NL + "\t\t\t\t\tif (value.startsWith(\"<![CDATA[\") && value.endsWith(\"]]>\")) {" + NL + "\t\t\t\t\t\tString text = value.substring(9, value.length()-3);" + NL + "\t\t\t\t\t\telement.addCDATA(text);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\telement.setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void replaceDefaultNameSpace(org.dom4j.Element nestRoot){" + NL + "\t\t\t\t\tif (nestRoot != null) {" + NL + "\t\t\t\t\t\tboolean isDefaultNameSpaceAtRoot = \"\".equals(nestRoot.getQName().getNamespace().getPrefix());" + NL + "\t\t\t\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {" + NL + "\t\t\t\t\t\t\tif ((\"\").equals(tmp.getQName().getNamespace().getURI()) && (\"\").equals(tmp.getQName().getNamespace().getPrefix()) && isDefaultNameSpaceAtRoot) {" + NL + "\t\t\t\t\t\t\t\ttmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treplaceDefaultNameSpace(tmp);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void removeEmptyElement(org.dom4j.Element root) {" + NL + "\t\t\t\t\tif (root != null) {" + NL + "\t\t\t\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {" + NL + "\t\t\t\t\t\t\tremoveEmptyElement(tmp);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (root.content().size() == 0 " + NL + "\t\t\t\t\t\t\t&& root.attributes().size() == 0 " + NL + "\t\t\t\t\t\t\t\t&& root.declaredNamespaces().size() == 0) {" + NL + "\t\t\t\t\t\t\tif (root.getParent() != null) {" + NL + "\t\t\t\t\t\t\t\troot.getParent().remove(root);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * remove the whiteSpace Node between the elements when appending the source file under dom4j" + NL + "\t\t\t\t * @param root" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic void removeWhiteSpaceTextNode(org.dom4j.Element root) {" + NL + "\t\t\t\t\tif(root != null) {" + NL + "\t\t\t\t\t\tList<org.dom4j.Node> textNodes = new java.util.ArrayList<org.dom4j.Node>();" + NL + "\t\t\t\t\t\tfor (int i=0; i< root.nodeCount(); i++) {" + NL + "\t\t\t\t\t\t\tif (root.node(i).getNodeType()==org.dom4j.Node.ELEMENT_NODE) {" + NL + "\t\t\t\t\t\t\t\tremoveWhiteSpaceTextNode((org.dom4j.Element)root.node(i));" + NL + "\t\t\t\t\t\t\t} else if(root.node(i).getNodeType()==org.dom4j.Node.TEXT_NODE) {" + NL + "\t\t\t\t\t\t\t\ttextNodes.add(root.node(i));" + NL + "\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(root.nodeCount() > 1) { // when root.nodeCount==1, that means the text node is the content of the element" + NL + "\t\t\t\t\t\t\tfor (org.dom4j.Node textNode: textNodes) {" + NL + "\t\t\t\t\t\t\t\tif(textNode.getText()==null || \"\".equals(textNode.getText().trim())) {" + NL + "\t\t\t\t\t\t\t\t\troot.remove(textNode);" + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfinal NestXMLTool_";
  protected final String TEXT_472 = " nestXMLTool_";
  protected final String TEXT_473 = " = new NestXMLTool_";
  protected final String TEXT_474 = "();" + NL + "\t\t\t// sort group root element for judgement of group" + NL + "\t\t\tjava.util.List<org.dom4j.Element> groupElementList_";
  protected final String TEXT_475 = " = new java.util.ArrayList<org.dom4j.Element>();" + NL + "\t\t\torg.dom4j.Element root4Group_";
  protected final String TEXT_476 = " = null;" + NL + "\t\t\torg.dom4j.Document doc_";
  protected final String TEXT_477 = "=null;" + NL + "\t\t\t" + NL + "\t\t\tfinal java.util.Map<String,org.dom4j.Branch> nameToElement_";
  protected final String TEXT_478 = " = new java.util.HashMap<String,org.dom4j.Branch>();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_479 = NL + "\t\t\t\tif (needRoot_";
  protected final String TEXT_480 = " == false) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\torg.dom4j.io.SAXReader saxReader_";
  protected final String TEXT_481 = "= new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_482 = " = saxReader_";
  protected final String TEXT_483 = ".read(createFile";
  protected final String TEXT_484 = ");" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_485 = ".removeWhiteSpaceTextNode(doc_";
  protected final String TEXT_486 = ".getRootElement());" + NL + "\t\t\t\t\t} catch (java.lang.Exception ex) {" + NL + "\t\t\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\t\t\tthrow new java.lang.Exception(\"can not find the file:\" + fileName_";
  protected final String TEXT_487 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdoc_";
  protected final String TEXT_488 = "=org.dom4j.DocumentHelper.createDocument();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\t\torg.dom4j.Element firstGroupPathElement_";
  protected final String TEXT_490 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_491 = NL + "\t\t\t";
  protected final String TEXT_492 = NL + "\t\t\t\tdoc_";
  protected final String TEXT_493 = "=org.dom4j.DocumentHelper.createDocument();" + NL + "\t\t\t";
  protected final String TEXT_494 = NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_495 = ".addDocType(";
  protected final String TEXT_496 = ", null, ";
  protected final String TEXT_497 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_498 = NL + "\t\t\t\t\t\tjava.util.Map<String, String> inMap_";
  protected final String TEXT_499 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\tinMap_";
  protected final String TEXT_500 = ".put(\"type\",";
  protected final String TEXT_501 = ");" + NL + "\t\t\t\t\t\tinMap_";
  protected final String TEXT_502 = ".put(\"href\",";
  protected final String TEXT_503 = ");" + NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_504 = ".addProcessingInstruction(\"xml-stylesheet\", inMap_";
  protected final String TEXT_505 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_506 = NL + "\t\t\t\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_507 = " = org.dom4j.io.OutputFormat.createCompactFormat();" + NL + "\t\t\t";
  protected final String TEXT_508 = NL + "\t\t\t\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_509 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "\t\t\t";
  protected final String TEXT_510 = NL + "\t\t\tformat_";
  protected final String TEXT_511 = ".setTrimText(";
  protected final String TEXT_512 = ");" + NL + "\t\t\tformat_";
  protected final String TEXT_513 = ".setEncoding(";
  protected final String TEXT_514 = ");" + NL + "\t\t\t";
  protected final String TEXT_515 = NL + "\t\t\tfinal int[] orders_";
  protected final String TEXT_516 = " = new int[";
  protected final String TEXT_517 = "];" + NL + "\t\t";
  protected final String TEXT_518 = NL + "\t\t\tjava.util.List<String> endTabStrs_";
  protected final String TEXT_519 = " = new java.util.ArrayList<String>();" + NL + "\t\t\tjava.util.List<String> startTabStrs_";
  protected final String TEXT_520 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_521 = NL + "\t\t\t\t\tendTabStrs_";
  protected final String TEXT_522 = ".add(\"";
  protected final String TEXT_523 = "</";
  protected final String TEXT_524 = ">\");" + NL + "\t\t\t\t\tstartTabStrs_";
  protected final String TEXT_525 = ".add(\"";
  protected final String TEXT_526 = "<";
  protected final String TEXT_527 = ">\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_528 = NL + "\t\t\tint preUnNullMaxIndex_";
  protected final String TEXT_529 = " = -1;" + NL + "\t\t\tint preNewTabIndex_";
  protected final String TEXT_530 = " = -1;" + NL + "\t\t\tString[] startTabs_";
  protected final String TEXT_531 = " = new String[endTabStrs_";
  protected final String TEXT_532 = ".size()];" + NL + "\t\t\tString[] endTabs_";
  protected final String TEXT_533 = " = new String[endTabStrs_";
  protected final String TEXT_534 = ".size()];" + NL + "\t\t\t";
  protected final String TEXT_535 = NL + "\t\t\t//String[] mainEndTabs_";
  protected final String TEXT_536 = " = new String[";
  protected final String TEXT_537 = "];" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_538 = NL + "\t\t\t\tjava.io.BufferedWriter out_";
  protected final String TEXT_539 = " = new java.io.BufferedWriter(" + NL + "\t\t\t\tnew java.io.OutputStreamWriter(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_540 = "), ";
  protected final String TEXT_541 = "));" + NL + "\t\t\t";
  protected final String TEXT_542 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_543 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_544 = ", ";
  protected final String TEXT_545 = ");" + NL + "\t\t\t\tjava.io.BufferedWriter out_";
  protected final String TEXT_546 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_547 = ");" + NL + "\t\t\t";
  protected final String TEXT_548 = NL + "\t\t\tout_";
  protected final String TEXT_549 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_550 = "+\"\\\"?>\");" + NL + "\t\t\tout_";
  protected final String TEXT_551 = ".newLine();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_552 = NL + "\t\t\t\t\tout_";
  protected final String TEXT_553 = ".write(\"<!DOCTYPE \"+";
  protected final String TEXT_554 = "+\" SYSTEM \\\"\" + ";
  protected final String TEXT_555 = " + \"\\\">\");" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_556 = ".newLine();" + NL + "\t\t\t\t";
  protected final String TEXT_557 = NL + "\t\t\t\t\tout_";
  protected final String TEXT_558 = ".write(\"<?xml-stylesheet type=\\\"\"+";
  protected final String TEXT_559 = "+\"\\\" href=\\\"\"+";
  protected final String TEXT_560 = "+\"\\\">\");" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_561 = ".newLine();" + NL + "\t\t\t\t";
  protected final String TEXT_562 = NL + "\t\t\tclass AdvancedXMLUtil_";
  protected final String TEXT_563 = "{";
  protected final String TEXT_564 = NL + "\t\t\t\tpublic void putValue_";
  protected final String TEXT_565 = "(";
  protected final String TEXT_566 = "Struct ";
  protected final String TEXT_567 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_568 = "){";
  protected final String TEXT_569 = NL + "\t\t\t\t\tvalueMap_";
  protected final String TEXT_570 = ".put(\"";
  protected final String TEXT_571 = "\", ";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "\t\t\t\t}";
  protected final String TEXT_574 = NL + "\t\t\t\t}";
  protected final String TEXT_575 = NL + "\t\tpublic boolean getValue_";
  protected final String TEXT_576 = "_";
  protected final String TEXT_577 = "(java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_578 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_579 = "){" + NL + "\t\t\treturn false";
  protected final String TEXT_580 = NL + "\t\t\t|| ( groupbyList_";
  protected final String TEXT_581 = ".get(";
  protected final String TEXT_582 = ").get(";
  protected final String TEXT_583 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_584 = ".get(";
  protected final String TEXT_585 = ").get(";
  protected final String TEXT_586 = ").equals(";
  protected final String TEXT_587 = ") " + NL + "\t\t: ";
  protected final String TEXT_588 = "!=null )";
  protected final String TEXT_589 = NL + "\t\t;" + NL + "\t\t}";
  protected final String TEXT_590 = NL + "\t   ;" + NL + "\t   }";
  protected final String TEXT_591 = NL + "\t\t\t\tpublic void setValue_";
  protected final String TEXT_592 = "_";
  protected final String TEXT_593 = "(java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_594 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_595 = "){";
  protected final String TEXT_596 = NL + "\t\t\t\t\tgroupbyList_";
  protected final String TEXT_597 = ".get(";
  protected final String TEXT_598 = ").add(";
  protected final String TEXT_599 = ");";
  protected final String TEXT_600 = NL + "\t\t\t\t}";
  protected final String TEXT_601 = NL + "\t   \t\t\t}";
  protected final String TEXT_602 = NL + "\t\t\t\tpublic boolean generateCodeDom4j_FindInsertNode";
  protected final String TEXT_603 = "(org.dom4j.Element tempElem,java.util.Map<String,String> valueMap_";
  protected final String TEXT_604 = "){" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_605 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_UnFindInsertNode";
  protected final String TEXT_606 = "(final NestXMLTool_";
  protected final String TEXT_607 = " nestXMLTool_";
  protected final String TEXT_608 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_609 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_610 = ",final int[] orders_";
  protected final String TEXT_611 = ",final boolean bl_";
  protected final String TEXT_612 = ") throws java.lang.Exception {";
  protected final String TEXT_613 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_614 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_615 = NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_group";
  protected final String TEXT_616 = "(final NestXMLTool_";
  protected final String TEXT_617 = " nestXMLTool_";
  protected final String TEXT_618 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_619 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_620 = ",final int[] orders_";
  protected final String TEXT_621 = ") throws java.lang.Exception {";
  protected final String TEXT_622 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_623 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_624 = NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_Loop(final NestXMLTool_";
  protected final String TEXT_625 = " nestXMLTool_";
  protected final String TEXT_626 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_627 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_628 = ",final int[] orders_";
  protected final String TEXT_629 = ",final boolean bl_";
  protected final String TEXT_630 = ") throws java.lang.Exception {";
  protected final String TEXT_631 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_632 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_633 = NL + "\t\t\t\t\t\t\tpublic StringBuffer generateCodeNull_rootEmptySpace";
  protected final String TEXT_634 = "(StringBuffer buf_";
  protected final String TEXT_635 = ",java.io.BufferedWriter out_";
  protected final String TEXT_636 = ",String[] startTabs_";
  protected final String TEXT_637 = ",String[] endTabs_";
  protected final String TEXT_638 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_639 = ")throws IOException{\t\t";
  protected final String TEXT_640 = NL + "\t\t\t\t\t\t\t\treturn buf_";
  protected final String TEXT_641 = ";" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_642 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditMain";
  protected final String TEXT_643 = "_";
  protected final String TEXT_644 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_645 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_646 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_647 = ".get(\"";
  protected final String TEXT_648 = "\") != null";
  protected final String TEXT_649 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_650 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_651 = NL + "\t\t\t\t\t\t\tpublic StringBuffer generateCodeNull_emptySpace";
  protected final String TEXT_652 = "(StringBuffer buf_";
  protected final String TEXT_653 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_654 = ",String[] groupBuffer_";
  protected final String TEXT_655 = "){";
  protected final String TEXT_656 = NL + "\t\t\t\t\t\t\t\treturn buf_";
  protected final String TEXT_657 = ";" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_658 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditGroup";
  protected final String TEXT_659 = "_";
  protected final String TEXT_660 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_661 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_662 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_663 = ".get(\"";
  protected final String TEXT_664 = "\") != null";
  protected final String TEXT_665 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_666 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_667 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditLoop_";
  protected final String TEXT_668 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_669 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_670 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_671 = ".get(\"";
  protected final String TEXT_672 = "\") != null";
  protected final String TEXT_673 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_674 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_675 = NL + "\t\t\t\t\t\t\tpublic void generateCodeNull_loopEmptySpace(StringBuffer buf_";
  protected final String TEXT_676 = ",java.io.BufferedWriter out_";
  protected final String TEXT_677 = ",String[] endTabs_";
  protected final String TEXT_678 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_679 = "){\t";
  protected final String TEXT_680 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_681 = NL + NL + "\t\t\t}" + NL + "\t\t\tAdvancedXMLUtil_";
  protected final String TEXT_682 = " advancedXMLUtil_";
  protected final String TEXT_683 = "=new AdvancedXMLUtil_";
  protected final String TEXT_684 = "();";
  protected final String TEXT_685 = NL;

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
        
        public List<XMLNode> getNextSiblings(){
            List<XMLNode> result = new ArrayList<XMLNode>();
            if(parent!=null && parent.elements!=null){
                for(XMLNode tmpNode: parent.elements){
                    if(order < tmpNode.order){
                        result.add(tmpNode);
                    }
                }
            }
            return result;
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
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");
List< ? extends IConnection> conns = node.getIncomingConnections();


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
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_12);
    
    		} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_17);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_24);
    
            }else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_28);
    
        }else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_32);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_33);
    
			}
		}

    stringBuffer.append(TEXT_34);
    
	}
}

abstract class TouchXMLNode {
	protected String cid = null;
	
	abstract void getXMLNode(String currEleName);
	
	abstract void getXMLElement(String currEleName);
	
	abstract void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index);
	
	abstract void putCurrentElementByName(String currEleName,XMLNode node);
	
	abstract void putCurrentElementByNull(String currEleName);
	
	abstract void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index);
	
	abstract void putCurrentElementByParent(String currEleName,String parentName,XMLNode node);
	
	abstract void putSubTreeRootParentByCurrentElement(String currEleName);
	
	abstract void putSubTreeRootParentByNull();
	
	abstract void putSubTreeRootParentByTempElem();
	
	abstract void putDocument();
	
	abstract void putSubTreeRootParentByRootGroup();
	
	abstract void putSubTreeRootParentByFirstGroup();
	
	abstract void putSubTreeRootParentByGroup(int i);
	
	abstract void putSubTreeRootParentByGroupList(int i);
	
	abstract void putSubTreeRootParentByLoop();
}

//get mean reference
//put mean declare,assign action
class ReferenceTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    
	}
	
	void getXMLElement(String currEleName) {
		getXMLNode(currEleName);
	}

	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_40);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_44);
    
	}

	void putCurrentElementByNull(String currEleName) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_53);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_59);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
	}
	
	void putDocument() {
		//do nothing
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_81);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
	}
}

class MappingTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_87);
    
	}
	
	void getXMLElement(String currEleName) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_90);
    
	}
	
	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_94);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_98);
    
	}
	
	void putCurrentElementByNull(String currEleName) {
		//do nothing
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_101);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_103);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_106);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_108);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_111);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	}
	
	void putDocument() {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	}
}

    stringBuffer.append(TEXT_136);
    
//65535 limit
class BigMethodHelper {
	protected String cid = null;
	protected boolean isOptimizeCodeForXMLNode = false;
	protected int xmlNodeOptNum = 100;
	protected int index = -1;
	
	protected String generateId = "";
	
	public BigMethodHelper() {
		initIsOptimizeCodeForXMLNode();
	}
	
	public void setGenerateId(String generateId) {
		this.generateId = generateId; 
	}
	
	public void resetIndex() {
		index = -1;
	}
	
	public TouchXMLNode getTouchXMLNode() {
		if(isOptimizeCodeForXMLNode) {
			return new MappingTouchXMLNode();
		}
		return new ReferenceTouchXMLNode();
	}
	
	public void initIsOptimizeCodeForXMLNode(){
		String xmlNodeOptNumStr = ElementParameterParser.getValue(node, "__XMLNODE_OPT_NUM__");
		if(xmlNodeOptNumStr!=null && !"".equals(xmlNodeOptNumStr) && !"\"\"".equals(xmlNodeOptNumStr)){
			xmlNodeOptNum  = Integer.parseInt(xmlNodeOptNumStr);
		}
		
        List<Map<String, String>> rootTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
        
        int elementNumber = getElementNumber(rootTable) + getElementNumber(groupTable) + getElementNumber(loopTable);
        if(elementNumber > xmlNodeOptNum) {
			isOptimizeCodeForXMLNode = true;
        }
	}
	
	private int getElementNumber(List<Map<String, String>> nodeTable) {
		if(nodeTable == null) {
			return 0;
		}
		
		int result = 0;
		for(Map<String,String> node : nodeTable) {
			if(node == null) {
				continue;
			}
			
			if("attri".equals(node.get("ATTRIBUTE")) || "ns".equals(node.get("ATTRIBUTE"))) {
				continue;
			}
			
			result++;
		}
		
		return result;
	}
	
	public void generateClassNameWithRBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
		}
	}
	
	public void generateLeftBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_140);
    
		}
	}
	
	public void generateMethod() {
		if(isOptimizeCodeForXMLNode) {
			if(index == -1) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_142);
    
			} else if((index+1)%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_143);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_144);
    
			}
			index++;
		}
	}
	
	public void generateMethodCall() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
			int count = index + 1;
			for(int i = 0; i < count; i++) {
				if(i%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i/xmlNodeOptNum);
    stringBuffer.append(TEXT_155);
    
				}
			}
		}
	}
	
}

    stringBuffer.append(TEXT_156);
    
// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	boolean isAppend = false;
	
	//opt for big xml config tree
	BigMethodHelper bigMethodHelper = null;
	TouchXMLNode touchXMLNode = null;
	
	public GenerateToolByDom4j() {
		bigMethodHelper = new BigMethodHelper();
		touchXMLNode = bigMethodHelper.getTouchXMLNode();
	}
	
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(!("ELEMENT").equals(node.type)){
			return;
		}
		
		bigMethodHelper.setGenerateId(currEleName);
		//start the class
		bigMethodHelper.generateClassNameWithRBlock();
		
		bigMethodHelper.resetIndex();
		
		generateMainCode(node,currEleName,parentName);
		
		//end the last method
		bigMethodHelper.generateLeftBlock();
		
		//end the class
		bigMethodHelper.generateLeftBlock();
		
		bigMethodHelper.generateMethodCall();
	}
	
	public void generateMainCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			bigMethodHelper.generateMethod();
			
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_157);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_159);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateMainCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(isAppend && !outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_160);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_161);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_162);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_163);
    touchXMLNode.getXMLNode(parentName);
    stringBuffer.append(TEXT_164);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_165);
    
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			touchXMLNode.putCurrentElementByNull(currEleName);
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_166);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_168);
    touchXMLNode.putCurrentElementByNameWithoutNamespacePrefix(currEleName,node,index);
    stringBuffer.append(TEXT_169);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    stringBuffer.append(TEXT_170);
    
			}else{

    stringBuffer.append(TEXT_171);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    
			}
			if(isAppend){

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_180);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
				List<XMLNode> nextSiblings = node.getNextSiblings();

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
				if(nextSiblings.size() > 0) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
				}
				
				for(XMLNode sibling : nextSiblings) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(sibling.name);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    
				}

    stringBuffer.append(TEXT_205);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_208);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_209);
    
			}else{

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_219);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_222);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_223);
    
			}
		}else{
			touchXMLNode.putCurrentElementByNull(currEleName);
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_224);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_226);
    touchXMLNode.putCurrentElementByParentWithoutNamespacePrefix(currEleName,parentName,node,index);
    stringBuffer.append(TEXT_227);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    stringBuffer.append(TEXT_228);
    
			}else{

    stringBuffer.append(TEXT_229);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_230);
    touchXMLNode.putSubTreeRootParentByCurrentElement(currEleName);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_231);
    tool.getValue(node); 
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_234);
    tool.getValue(node);
    stringBuffer.append(TEXT_235);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_238);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_239);
    
				}
			}else{
				if("id_Document".equals(node.relatedColumn.getTalendType())) {

    stringBuffer.append(TEXT_240);
    tool.getValue(node); 
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_243);
    tool.getValue(node);
    stringBuffer.append(TEXT_244);
    
				} else {

    stringBuffer.append(TEXT_245);
    tool.getValue(node); 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_248);
    tool.getValue(node);
    stringBuffer.append(TEXT_249);
    
				}
				if(outputAsXSD){

    stringBuffer.append(TEXT_250);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_251);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_252);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_256);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_257);
    tool.getValue(node);
    stringBuffer.append(TEXT_258);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_260);
    tool.getValue(node);
    stringBuffer.append(TEXT_261);
     if (bAddEmptyAttr) { 
    stringBuffer.append(TEXT_262);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_264);
    }
		} else { 
		  if (node.defaultValue != null && !("").equals(node.defaultValue) ){
          
    stringBuffer.append(TEXT_265);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_268);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_269);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_271);
    
		  }
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_272);
    tool.getValue(node);
    stringBuffer.append(TEXT_273);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_275);
    tool.getValue(node);
    stringBuffer.append(TEXT_276);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_277);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_278);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_279);
    tool.getValue(node);
    stringBuffer.append(TEXT_280);
    
			}

    stringBuffer.append(TEXT_281);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_282);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_285);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_286);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_287);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_289);
    
			}
		}
	}
}

//----------** add by wliu dom4j to genenrate get function for node **-------//
class GenerateExprCmpByDom4j{
//	String cid = null;
	XMLTool tool = null;
	XMLNode groupNode = null;
	boolean needEmptyNode = true;
	public void generateCode(XMLNode node, String parentName){
		String tmpPath = node.path.replaceFirst(groupNode.path,"");
		String[] arrNames = tmpPath.split("/");
		if(node==groupNode){

    stringBuffer.append(TEXT_290);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_291);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_292);
    tool.getValue(node); 
    stringBuffer.append(TEXT_293);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_294);
    			}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_295);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_296);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_297);
    tool.getValue(node); 
    stringBuffer.append(TEXT_298);
    if(!needEmptyNode){
    stringBuffer.append(TEXT_299);
    }
    stringBuffer.append(TEXT_300);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_301);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_302);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_303);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_305);
    					}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_306);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_307);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_308);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_309);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_310);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_311);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_312);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_313);
    }

    stringBuffer.append(TEXT_314);
    
				}
			}
		}
		
		if(node.elements!=null){
			for(XMLNode child:node.elements){
				if(!child.isMainNode()){
					generateCode(child,parentName);
				}
			}
		}		
	}
	
	private void generateCmnExpr(String[] arrNames, String parentName){

    stringBuffer.append(TEXT_315);
    stringBuffer.append(parentName );
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){

    stringBuffer.append(TEXT_316);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_318);
    
		}
	}
}

// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	
	boolean isCompact = false;
	
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

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
						}else{

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty 
						&& (child.relatedColumn != null || child.childrenColumnList.size()>0
							 || child.hasDefaultValue == true ) ){

    stringBuffer.append(TEXT_333);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_336);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_337);
    }
    stringBuffer.append(TEXT_338);
    
						if(isCompact==false)
							generateCode(child,emptySpace+"  ");
						else
							generateCode(child,emptySpace);

    stringBuffer.append(TEXT_339);
    
            		}else{
            			if(isCompact==false)
            				generateCode(child,emptySpace+"  ");
            			else
            				generateCode(child,emptySpace);
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_345);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_351);
    tool.getValue(node); 
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
		}

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_361);
    
		}else{

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_364);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_365);
    tool.getValue(node);
    stringBuffer.append(TEXT_366);
    tool.getValue(node);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    tool.getValue(node);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    tool.getValue(node);
    stringBuffer.append(TEXT_371);
    
			}else{

    stringBuffer.append(TEXT_372);
    tool.getValue(node);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    tool.getValue(node);
    stringBuffer.append(TEXT_375);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_376);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_381);
    
		}
	}
	private void addAttribute(XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_382);
    tool.getValue(node); 
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_385);
    tool.getValue(node);
    stringBuffer.append(TEXT_386);
     if (bAddEmptyAttr){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_389);
    }
		} else {
		  if (node.defaultValue != null && !("").equals(node.defaultValue)){
          
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_393);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_396);
    
		  }
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_397);
    tool.getValue(node);
    stringBuffer.append(TEXT_398);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    tool.getValue(node);
    stringBuffer.append(TEXT_401);
    
			}else{

    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_404);
    tool.getValue(node);
    stringBuffer.append(TEXT_405);
    
			}

    stringBuffer.append(TEXT_406);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_409);
    
			}else{

    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_413);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

    stringBuffer.append(TEXT_414);
    
if (conns == null || conns.isEmpty()) {
	return "";			
} else {
	IConnection conn = conns.get(0);

	if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
		return "";
	}
}
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
		String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
		String dtdRootName = ElementParameterParser.getValue(node, "__DTD_NAME__");
		String dtdFileName = ElementParameterParser.getValue(node, "__DTD_SYSTEMID__");
		String xslType = ElementParameterParser.getValue(node, "__XSL_TYPE__");
		String xslHref = ElementParameterParser.getValue(node, "__XSL_HREF__");
		boolean split = "true".equals(ElementParameterParser.getValue(node, "__SPLIT__"));
		boolean trim = "true".equals(ElementParameterParser.getValue(node, "__TRIM__"));
		boolean isMerge= ("true").equals(ElementParameterParser.getValue(node, "__MERGE__"));
		boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));
		boolean needFileValid = ("true").equals(ElementParameterParser.getValue(node, "__FILE_VALID__"));
		boolean needDTDValid = ("true").equals(ElementParameterParser.getValue(node, "__DTD_VALID__"));
		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
		boolean needXSLValid = ("true").equals(ElementParameterParser.getValue(node, "__XSL_VALID__"));
		List<Map<String, String>> rootTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
		List<Map<String, String>> groupTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
		List<Map<String, String>> loopTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");

		if (!useStream) {
		
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    if (isMerge) {
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    } else {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    }
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    if (("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))) {
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    }

			if (isMerge) {
			
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    
			}

			if (split) {
			
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    
			}
		} else {
		
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    
		}//***************************the part of the output stream end************************************************
		
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    
		// *** generation mode init ***
		if (("Dom4j").equals(mode)) {
		
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    if (!useStream && isMerge) {//append mode and the code of file path
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    if(groupTable.size()>0){
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    }
    stringBuffer.append(TEXT_491);
    } else {	
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    
			}

			if (!isMerge) {
				if (needFileValid) {
					if (needDTDValid) {
					
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_497);
    } else if (needXSLValid) {
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(xslHref );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    
					}
				}
			}

			if (isCompact==true) {//generate compact file
			
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    } else {	
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
			}
			
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_514);
    
			int groupSize = 0;

			if (groupTable != null && groupTable.size() > 0) {
				for (java.util.Map<String, String> tmpMap : groupTable) {
					if (tmpMap.get("ATTRIBUTE").equals("main")) {
						groupSize++;
					}
				}
			}
			
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(groupSize + 1);
    stringBuffer.append(TEXT_517);
    
		} else if (("Null").equals(mode)) {
		
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
			if (loopTable.size() > 0) {
				String emptyspace = "";
				String endPath = loopTable.get(0).get("PATH");
				String[] endTabs = endPath.split("/");

				for (int len = 1; len < endTabs.length-1; len++) {
				
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_527);
    
					if (isCompact == false) {//generate pretty file
						emptyspace += "  ";
					}
				}
			}
			
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
			int rootSize = 0;

			if (rootTable != null && rootTable.size() > 0) {
				for (java.util.Map<String, String> tmpMap : rootTable) {
					if (tmpMap.get("ATTRIBUTE").equals("main")) {
						rootSize++;
					}
				}
			}
			
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(rootSize);
    stringBuffer.append(TEXT_537);
    if (!useStream) {// the part of file path---the old code
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_541);
    } else {// the part of output stream
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    }
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    
			if (needFileValid) {
				if (needDTDValid) {
				
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    } else if (needXSLValid) {
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(xslHref);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    
				}
			}
		}
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
        		boolean bAddEmptyAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_EMPTY_ATTRIBUTE__"));
                boolean bAddUnmappedAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_UNMAPPED_ATTRIBUTE__"));
        		int schemaOptNum=100;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				} 
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = NodeUtil.getPrivateConnClassName(conn);
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
				
				if(treeObjs == null || treeObjs.length == 0){
					return "";
				}
				
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
          		if(metadata.getListColumns().size()> schemaOptNum){

    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    
					int colNum = 0;
					for(IMetadataColumn column :metadata.getListColumns()){
						if(colNum%schemaOptNum==0){

    stringBuffer.append(TEXT_564);
    stringBuffer.append(colNum/schemaOptNum);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
						}

    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_571);
     tool.getValue(column); 
    stringBuffer.append(TEXT_572);
    
						if((colNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_573);
    
						}
					colNum++;
					}
						if(colNum>0&&(colNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_574);
    
						}
						if((groupTable.size()>0 && "Dom4j".equals(mode)&&(useStream || !isMerge))||("Null".equals(mode))){
							for(int groupNum=0;groupNum<groupList.size();groupNum++){
								XMLNode groupRootNode = groupList.get(groupNum);
								int nodeNum=0;
								for(int j=0;j<groupbyNodeList.get(groupNum).size();j++){
									XMLNode attr = groupbyNodeList.get(groupNum).get(j);
									if(attr.relatedColumn!=null){
										if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_575);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    
										}

    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_586);
    tool.getValue(attr);
    stringBuffer.append(TEXT_587);
    tool.getValue(attr);
    stringBuffer.append(TEXT_588);
    
										if((nodeNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_589);
    
										}
										nodeNum++;
									}
											
								}
								if(nodeNum>0&&(nodeNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_590);
    
								}
							for(int j=0;j<groupbyNodeList.get(groupNum).size();j++){
									XMLNode attr = groupbyNodeList.get(groupNum).get(j);
									if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_591);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    
									}

    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_598);
    tool.getValue(attr);
    stringBuffer.append(TEXT_599);
    
										if((j+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_600);
    
										}
							}
								if(groupbyNodeList.get(groupNum).size()>0&&(groupbyNodeList.get(groupNum).size()%schemaOptNum)>0){

    stringBuffer.append(TEXT_601);
    
								}
							}
						}
						if(("Dom4j").equals(mode)){
							//init the generate tool.
							GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
							if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
								generateToolByDom4j.outputAsXSD = true;
							}
							if(("true").equals(allowEmpty)){
								generateToolByDom4j.allowEmpty = true;
							}
							generateToolByDom4j.bAddEmptyAttr = bAddEmptyAttr;
							generateToolByDom4j.bAddUnmappedAttr = bAddUnmappedAttr;
							generateToolByDom4j.cid = cid;
							generateToolByDom4j.touchXMLNode.cid = cid;
							generateToolByDom4j.bigMethodHelper.cid = cid;
							generateToolByDom4j.tool = tool;
							if( groupTable.size()>0){
								if((!useStream && isMerge)){
									generateToolByDom4j.isAppend= true;
									for( int i=0; i<groupList.size();i++){
										XMLNode groupNode= groupList.get(i);
										GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
										generateExprCmpByDom4j.tool = tool;
										generateExprCmpByDom4j.groupNode = groupNode;
										generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);
								

    stringBuffer.append(TEXT_602);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_605);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
     
					generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_613);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_614);
    
								
									}
								}else{
									for(int i=0;i<groupList.size();i++){
										XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_615);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    
				generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_622);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_623);
    
									}
								}
							}
							if(loopTable!=null && loopTable.size()>0){

    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    if(!useStream && isMerge && groupTable.size()>0){
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_630);
    
					generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");

    stringBuffer.append(TEXT_631);
    generateToolByDom4j.touchXMLNode.getXMLElement("loop");
    stringBuffer.append(TEXT_632);
    
							}
						}
						if("Null".equals(mode)){
							GenerateToolByNull generateToolByNull = new GenerateToolByNull();
						    if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
						    	generateToolByNull.outputAsXSD = true;
						    }
						    if(("true").equals(allowEmpty)){
						    	generateToolByNull.allowEmpty = true;
						    }
						    generateToolByNull.bAddEmptyAttr = bAddEmptyAttr;
						    generateToolByNull.bAddUnmappedAttr = bAddUnmappedAttr;
						    generateToolByNull.cid = cid;
						    generateToolByNull.tool = tool;
						    generateToolByNull.isCompact = isCompact;
						    String rootEmptySpace = "";
						    for(int i=0;i < mainList.size();i++){

    stringBuffer.append(TEXT_633);
    stringBuffer.append(i);
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
    
								generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);

    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    
								if(isCompact==false){//generate pretty file
									rootEmptySpace+="  ";
								}
								if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
									if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){
										int columnNum=0;
										for(IMetadataColumn column : mainList.get(i).childrenColumnList){
											if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_642);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    
											}

    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_648);
    
											if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_649);
    
											}
											columnNum++;
										}
											if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_650);
    
											}
									}
								}
							}
							for(int i=0;i<groupList.size();i++){
								String emptySpace = "";
								if(isCompact==false){//generate pretty file
									for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
										emptySpace +="  ";
									}
								}

    stringBuffer.append(TEXT_651);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    
								generateToolByNull.generateCode(groupList.get(i),emptySpace);

    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    
								if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
									if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){
										int columnNum=0;
										for(IMetadataColumn column : groupList.get(i).childrenColumnList){
											if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_658);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    
											}

    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_664);
    
											if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_665);
    
											}
											columnNum++;
										}
											if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_666);
    
											}
									
									}
								}
							}
							if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
								int columnNum=0;
									for(IMetadataColumn column : loop.childrenColumnList){
										if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_667);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    
										}

    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_672);
    
										if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_673);
    
										}
										columnNum++;
									}
										if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_674);
    
										}
									
									
							}
							String emptySpace = "";
							if(isCompact==false){//generate pretty file
								for(int len =loop.path.split("/").length-1;len>1;len--){
									emptySpace +="  ";
								}
							}

    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
							 generateToolByNull.generateCode(loop,emptySpace);
							 generateToolByNull.endElement(loop,emptySpace);

    stringBuffer.append(TEXT_680);
    
						}

    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_685);
    return stringBuffer.toString();
  }
}
