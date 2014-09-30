package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLMainJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLMainJava result = new TAdvancedFileOutputXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tvalueMap_";
  protected final String TEXT_4 = ".get(\"";
  protected final String TEXT_5 = "\")";
  protected final String TEXT_6 = NL + "\t(";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null?";
  protected final String TEXT_10 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_11 = "), ";
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
  protected final String TEXT_29 = ")";
  protected final String TEXT_30 = NL + "            ";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ".toString()";
  protected final String TEXT_33 = ":";
  protected final String TEXT_34 = "null";
  protected final String TEXT_35 = NL + "\t\t)";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_41 = "\");";
  protected final String TEXT_42 = NL + "\t\t";
  protected final String TEXT_43 = "_";
  protected final String TEXT_44 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = " = null;";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ".addElement(\"";
  protected final String TEXT_54 = "\");";
  protected final String TEXT_55 = NL + "\t\t";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ".addElement(\"";
  protected final String TEXT_60 = "\");";
  protected final String TEXT_61 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ";";
  protected final String TEXT_65 = NL + "\t\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_66 = " = null;";
  protected final String TEXT_67 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_68 = " =  tempElem;";
  protected final String TEXT_69 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_70 = "=root4Group_";
  protected final String TEXT_71 = ";";
  protected final String TEXT_72 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_73 = " = firstGroupPathElement_";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_76 = "=group";
  protected final String TEXT_77 = "__";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_80 = "=groupElementList_";
  protected final String TEXT_81 = ".get(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_84 = "=loop_";
  protected final String TEXT_85 = ";";
  protected final String TEXT_86 = NL + "\t\tnameToElement_";
  protected final String TEXT_87 = ".get(\"";
  protected final String TEXT_88 = "\")";
  protected final String TEXT_89 = NL + "\t\t((org.dom4j.Element)(nameToElement_";
  protected final String TEXT_90 = ".get(\"";
  protected final String TEXT_91 = "\")))";
  protected final String TEXT_92 = NL + "\t\tnameToElement_";
  protected final String TEXT_93 = ".put(\"";
  protected final String TEXT_94 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_95 = "\"));";
  protected final String TEXT_96 = NL + "\t\tnameToElement_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_99 = "\"));";
  protected final String TEXT_100 = NL + "\t\tnameToElement_";
  protected final String TEXT_101 = ".put(\"";
  protected final String TEXT_102 = "\",";
  protected final String TEXT_103 = ".addElement(\"";
  protected final String TEXT_104 = "\"));";
  protected final String TEXT_105 = NL + "\t\tnameToElement_";
  protected final String TEXT_106 = ".put(\"";
  protected final String TEXT_107 = "\",";
  protected final String TEXT_108 = ".addElement(\"";
  protected final String TEXT_109 = "\"));";
  protected final String TEXT_110 = NL + "\t\tnameToElement_";
  protected final String TEXT_111 = ".put(\"subTreeRootParent\",";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\tnameToElement_";
  protected final String TEXT_114 = ".put(\"subTreeRootParent\",null);";
  protected final String TEXT_115 = NL + "\t\tnameToElement_";
  protected final String TEXT_116 = ".put(\"subTreeRootParent\",tempElem);";
  protected final String TEXT_117 = NL + "\t\tnameToElement_";
  protected final String TEXT_118 = ".put(\"doc\",doc_";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "\t\tnameToElement_";
  protected final String TEXT_121 = ".put(\"subTreeRootParent\",root4Group_";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\tnameToElement_";
  protected final String TEXT_124 = ".put(\"subTreeRootParent\",firstGroupPathElement_";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\tnameToElement_";
  protected final String TEXT_127 = ".put(\"subTreeRootParent\",group";
  protected final String TEXT_128 = "__";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\tnameToElement_";
  protected final String TEXT_131 = ".put(\"subTreeRootParent\",groupElementList_";
  protected final String TEXT_132 = ".get(";
  protected final String TEXT_133 = "));";
  protected final String TEXT_134 = NL + "\t\tnameToElement_";
  protected final String TEXT_135 = ".put(\"subTreeRootParent\",loop_";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = NL + "\t\t\tclass TalendXMLGenerateTool_";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = " {";
  protected final String TEXT_141 = NL + "\t\t\t}";
  protected final String TEXT_142 = NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_143 = "() throws java.lang.Exception{";
  protected final String TEXT_144 = NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_145 = "() throws java.lang.Exception{";
  protected final String TEXT_146 = NL + "\t\t\tTalendXMLGenerateTool_";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = " talendXMLGenerateTool_";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = " = new TalendXMLGenerateTool_";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = "();";
  protected final String TEXT_153 = NL + "\t\t\t\t\ttalendXMLGenerateTool_";
  protected final String TEXT_154 = "_";
  protected final String TEXT_155 = ".generateDocument_";
  protected final String TEXT_156 = "();";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "\t\t\t";
  protected final String TEXT_159 = ".setName(\"";
  protected final String TEXT_160 = "\");";
  protected final String TEXT_161 = NL + "\t\t\tif (";
  protected final String TEXT_162 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_163 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_164 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_165 = ".remove(";
  protected final String TEXT_166 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\tif (";
  protected final String TEXT_168 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_169 = "\") == null) {" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_171 = NL + "        }";
  protected final String TEXT_172 = NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\tList currentList_";
  protected final String TEXT_174 = " =  ";
  protected final String TEXT_175 = ".elements(\"";
  protected final String TEXT_176 = "\");" + NL + "\t\tint app_size_";
  protected final String TEXT_177 = " = currentList_";
  protected final String TEXT_178 = ".size();" + NL + "\t\tif(app_size_";
  protected final String TEXT_179 = " > 0){" + NL + "\t\t\torders_";
  protected final String TEXT_180 = "[";
  protected final String TEXT_181 = "] =1+ ";
  protected final String TEXT_182 = ".elements().indexOf(currentList_";
  protected final String TEXT_183 = ".get(app_size_";
  protected final String TEXT_184 = "-1));" + NL + "\t\t}else{//when the group or loop element appear first time";
  protected final String TEXT_185 = NL + "\t\t\tList allList_";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ".elements();" + NL + "\t\t\t//append tail as default action" + NL + "\t\t\torders_";
  protected final String TEXT_188 = "[";
  protected final String TEXT_189 = "] = allList_";
  protected final String TEXT_190 = ".size();";
  protected final String TEXT_191 = NL + "\t\t\tList siblingList_";
  protected final String TEXT_192 = " = null;" + NL + "\t\t\tboolean findInsertPosition_";
  protected final String TEXT_193 = " = false;";
  protected final String TEXT_194 = NL + "\t\t\tif(!findInsertPosition_";
  protected final String TEXT_195 = " && allList_";
  protected final String TEXT_196 = ".size()!=0) {" + NL + "\t\t\t\tsiblingList_";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".elements(\"";
  protected final String TEXT_199 = "\");" + NL + "\t\t\t\tif(siblingList_";
  protected final String TEXT_200 = ".size() > 0) {" + NL + "\t\t\t\t\tfindInsertPosition_";
  protected final String TEXT_201 = " = true;" + NL + "\t\t\t\t\torders_";
  protected final String TEXT_202 = "[";
  protected final String TEXT_203 = "] = allList_";
  protected final String TEXT_204 = ".indexOf(siblingList_";
  protected final String TEXT_205 = ".get(0));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_206 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_207 = ".elements().add(orders_";
  protected final String TEXT_208 = "[";
  protected final String TEXT_209 = "],";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL + "        if(orders_";
  protected final String TEXT_212 = "[";
  protected final String TEXT_213 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_214 = "[";
  protected final String TEXT_215 = "] = ";
  protected final String TEXT_216 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_217 = " < orders_";
  protected final String TEXT_218 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_219 = "[";
  protected final String TEXT_220 = "] = 0;" + NL + "        }";
  protected final String TEXT_221 = ".elements().add(orders_";
  protected final String TEXT_222 = "[";
  protected final String TEXT_223 = "]++,";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\tif (";
  protected final String TEXT_226 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_227 = "\") == null) {";
  protected final String TEXT_228 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_229 = NL + "        }";
  protected final String TEXT_230 = NL + "\t\t";
  protected final String TEXT_231 = NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\tif(";
  protected final String TEXT_233 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_234 = " .parseAndAdd(";
  protected final String TEXT_235 = ",";
  protected final String TEXT_236 = ");" + NL + "\t\t}";
  protected final String TEXT_237 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_238 = " .parseAndAdd(";
  protected final String TEXT_239 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_240 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_241 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_242 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_243 = " .setText(";
  protected final String TEXT_244 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_245 = ").getDocument().getRootElement().asXML());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_246 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_247 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_248 = " .setText(";
  protected final String TEXT_249 = ",";
  protected final String TEXT_250 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_251 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_252 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_253 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_255 = ".parseAndAdd(";
  protected final String TEXT_256 = ",\"";
  protected final String TEXT_257 = "\");" + NL;
  protected final String TEXT_258 = " " + NL + "\t\t  if (";
  protected final String TEXT_259 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_260 = ".addAttribute(\"";
  protected final String TEXT_261 = "\", ";
  protected final String TEXT_262 = ");" + NL + "\t\t  } ";
  protected final String TEXT_263 = " else {" + NL + "\t\t    ";
  protected final String TEXT_264 = ".addAttribute(\"";
  protected final String TEXT_265 = "\", \"\");" + NL + "          }";
  protected final String TEXT_266 = NL + "\t\t    ";
  protected final String TEXT_267 = ".addAttribute(\"";
  protected final String TEXT_268 = "\", \"";
  protected final String TEXT_269 = "\");";
  protected final String TEXT_270 = NL + "\t\t    ";
  protected final String TEXT_271 = ".addAttribute(\"";
  protected final String TEXT_272 = "\", \"\");" + NL + "\t\t  ";
  protected final String TEXT_273 = NL + "\t\tif(";
  protected final String TEXT_274 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_275 = ".addNamespace(\"";
  protected final String TEXT_276 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_277 = "));";
  protected final String TEXT_278 = NL + "        \t";
  protected final String TEXT_279 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_280 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_281 = "))));";
  protected final String TEXT_282 = NL + "\t\t}";
  protected final String TEXT_283 = NL + "\t\t\t";
  protected final String TEXT_284 = ".addNamespace(\"";
  protected final String TEXT_285 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_286 = "\"));";
  protected final String TEXT_287 = NL + "        \t";
  protected final String TEXT_288 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_289 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_290 = "\"))));";
  protected final String TEXT_291 = "true";
  protected final String TEXT_292 = " && (";
  protected final String TEXT_293 = "(";
  protected final String TEXT_294 = "==null && ";
  protected final String TEXT_295 = " == null) || (true &&";
  protected final String TEXT_296 = "!=null" + NL + " && ";
  protected final String TEXT_297 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_298 = ".getText().equals(";
  protected final String TEXT_299 = ")";
  protected final String TEXT_300 = ")";
  protected final String TEXT_301 = NL + ")";
  protected final String TEXT_302 = " && (";
  protected final String TEXT_303 = "(";
  protected final String TEXT_304 = "==null && ";
  protected final String TEXT_305 = ".attribute(\"";
  protected final String TEXT_306 = "\") == null) || (true && ";
  protected final String TEXT_307 = ".attribute(\"";
  protected final String TEXT_308 = "\")!=null" + NL + "&& ";
  protected final String TEXT_309 = ".attribute(\"";
  protected final String TEXT_310 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_311 = ".attribute(\"";
  protected final String TEXT_312 = "\").getText().equals(";
  protected final String TEXT_313 = ")";
  protected final String TEXT_314 = ")";
  protected final String TEXT_315 = ")";
  protected final String TEXT_316 = NL;
  protected final String TEXT_317 = ".element(";
  protected final String TEXT_318 = ".getQName(\"";
  protected final String TEXT_319 = "\"))";
  protected final String TEXT_320 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_321 = "[";
  protected final String TEXT_322 = "] = buf_";
  protected final String TEXT_323 = ".toString();" + NL + "        buf_";
  protected final String TEXT_324 = " = new StringBuffer();";
  protected final String TEXT_325 = NL + "\t\tstartTabs_";
  protected final String TEXT_326 = "[";
  protected final String TEXT_327 = "] = buf_";
  protected final String TEXT_328 = ".toString();" + NL + "        buf_";
  protected final String TEXT_329 = " = new StringBuffer();";
  protected final String TEXT_330 = NL + "\t\tout_";
  protected final String TEXT_331 = ".write(buf_";
  protected final String TEXT_332 = ".toString());" + NL + "        buf_";
  protected final String TEXT_333 = " = new StringBuffer();";
  protected final String TEXT_334 = NL + "\t\tif( false";
  protected final String TEXT_335 = " || valueMap_";
  protected final String TEXT_336 = ".get(\"";
  protected final String TEXT_337 = "\") != null";
  protected final String TEXT_338 = " || true " + NL + "                    \t";
  protected final String TEXT_339 = NL + "\t\t){";
  protected final String TEXT_340 = NL + "\t\t}";
  protected final String TEXT_341 = NL + "\t\tbuf_";
  protected final String TEXT_342 = ".append(\"";
  protected final String TEXT_343 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_344 = ".append(\"";
  protected final String TEXT_345 = "<";
  protected final String TEXT_346 = "\");";
  protected final String TEXT_347 = NL + "\t\tbuf_";
  protected final String TEXT_348 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_349 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+ file_";
  protected final String TEXT_350 = ".substring(file_";
  protected final String TEXT_351 = ".lastIndexOf(\"/\")+1)+\".xsd\"+\"\\\"\");";
  protected final String TEXT_352 = NL + "\t\tif(";
  protected final String TEXT_353 = " == null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_354 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_355 = NL + "\t\tbuf_";
  protected final String TEXT_356 = ".append(\">\");";
  protected final String TEXT_357 = NL + "\t\tbuf_";
  protected final String TEXT_358 = ".append(\"";
  protected final String TEXT_359 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_360 = ".append(\"";
  protected final String TEXT_361 = "</";
  protected final String TEXT_362 = ">\");";
  protected final String TEXT_363 = NL + "\t\tbuf_";
  protected final String TEXT_364 = ".append(\"</";
  protected final String TEXT_365 = ">\");";
  protected final String TEXT_366 = NL + "\t\tif(";
  protected final String TEXT_367 = "!=null){" + NL + "\t\t\tif(routines.system.XMLHelper.getInstance().isValid(";
  protected final String TEXT_368 = ")){" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_369 = ".append(";
  protected final String TEXT_370 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_371 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_372 = "));" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_373 = NL + "\t\tif(";
  protected final String TEXT_374 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_375 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_376 = "));" + NL + "\t\t}";
  protected final String TEXT_377 = NL + "\t\tif(routines.system.XMLHelper.getInstance().isValid(\"";
  protected final String TEXT_378 = "\")){" + NL + "\t\t\tbuf_";
  protected final String TEXT_379 = ".append(\"";
  protected final String TEXT_380 = "\");" + NL + "\t\t} else {" + NL + "\t\t\tbuf_";
  protected final String TEXT_381 = ".append(TalendString.checkCDATAForXML(\"";
  protected final String TEXT_382 = "\"));" + NL + "\t\t}";
  protected final String TEXT_383 = NL + "\t\t  if (";
  protected final String TEXT_384 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_385 = ".append(\" ";
  protected final String TEXT_386 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_387 = ")+\"\\\"\");" + NL + "\t\t  } ";
  protected final String TEXT_388 = " else{" + NL + "\t\t    buf_";
  protected final String TEXT_389 = ".append(\" ";
  protected final String TEXT_390 = "=\\\"\\\"\");" + NL + "\t\t  }";
  protected final String TEXT_391 = NL + "\t\t    buf_";
  protected final String TEXT_392 = ".append(\" ";
  protected final String TEXT_393 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_394 = "\")+\"\\\"\");";
  protected final String TEXT_395 = NL + "\t\t    buf_";
  protected final String TEXT_396 = ".append(\" ";
  protected final String TEXT_397 = "=\\\"\\\"\");" + NL + "\t\t  ";
  protected final String TEXT_398 = NL + "\t\tif(";
  protected final String TEXT_399 = "!=null){";
  protected final String TEXT_400 = NL + "        \tbuf_";
  protected final String TEXT_401 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_402 = ")+\"\\\"\");";
  protected final String TEXT_403 = NL + "\t\t\tbuf_";
  protected final String TEXT_404 = ".append(\" xmlns:";
  protected final String TEXT_405 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_406 = ")+\"\\\"\");";
  protected final String TEXT_407 = NL + "\t\t}";
  protected final String TEXT_408 = NL + "        \tbuf_";
  protected final String TEXT_409 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_410 = "\")+\"\\\"\");";
  protected final String TEXT_411 = NL + "\t\t\tbuf_";
  protected final String TEXT_412 = ".append(\" xmlns:";
  protected final String TEXT_413 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_414 = "\")+\"\\\"\");";
  protected final String TEXT_415 = NL;
  protected final String TEXT_416 = NL + "\tnb_line_";
  protected final String TEXT_417 = "++;" + NL + "\tvalueMap_";
  protected final String TEXT_418 = ".clear();";
  protected final String TEXT_419 = NL + "\tadvancedXMLUtil_";
  protected final String TEXT_420 = ".putValue_";
  protected final String TEXT_421 = "(";
  protected final String TEXT_422 = ",valueMap_";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "\tvalueMap_";
  protected final String TEXT_425 = ".put(\"";
  protected final String TEXT_426 = "\", ";
  protected final String TEXT_427 = ");";
  protected final String TEXT_428 = NL + "\t";
  protected final String TEXT_429 = NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_430 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_431 = "=false;" + NL + "\t\tif(orders_";
  protected final String TEXT_432 = ".length>0){" + NL + "\t\t\torders_";
  protected final String TEXT_433 = "[0] = 0;" + NL + "\t\t}";
  protected final String TEXT_434 = NL + "\t\troot4Group_";
  protected final String TEXT_435 = " =  ";
  protected final String TEXT_436 = ";" + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_437 = NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_438 = NL + "\t}";
  protected final String TEXT_439 = NL + "\t\tif(firstGroupPathElement_";
  protected final String TEXT_440 = " == null){" + NL + "\t\t\tfirstGroupPathElement_";
  protected final String TEXT_441 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_442 = ".selectSingleNode(\"";
  protected final String TEXT_443 = "\");" + NL + "\t\t\tif(firstGroupPathElement_";
  protected final String TEXT_444 = " == null){" + NL + "\t\t\t\tfirstGroupPathElement_";
  protected final String TEXT_445 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_446 = ".selectSingleNode(\"";
  protected final String TEXT_447 = "\");" + NL + "\t\t\t\tif(firstGroupPathElement_";
  protected final String TEXT_448 = " == null) {" + NL + "\t\t\t\t\tSystem.err.println(\"WARN : the root tag is not same when appending\");" + NL + "\t\t\t\t} else { " + NL + "\t\t\t\t\tString subRootPath = firstGroupPathElement_";
  protected final String TEXT_449 = ".getPath().replace(\"*[name()='\",\"\").replace(\"']\", \"\");" + NL + "\t\t\t\t\tif(!\"";
  protected final String TEXT_450 = "\".equals(subRootPath)) {" + NL + "\t\t\t\t\t\tSystem.err.println(\"WARN : the root tag is not same on namespace prefix when appending\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tfirstGroupPathElement_";
  protected final String TEXT_451 = " = firstGroupPathElement_";
  protected final String TEXT_452 = ".getParent();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_453 = NL + "\t\t" + NL + "\t\tboolean bl_";
  protected final String TEXT_454 = "= false;//true:find the insert node;false:not";
  protected final String TEXT_455 = NL + "\t\tif(bl_";
  protected final String TEXT_456 = "==false){" + NL + "\t\t\tjava.util.List<org.dom4j.Element> listNodes= ";
  protected final String TEXT_457 = ".elements();" + NL + "\t\t\tif(listNodes!=null && listNodes.size()>0){" + NL + "\t\t\t\tint j=0;" + NL + "\t\t\t\tfor(j=0;j<listNodes.size();j++){" + NL + "\t\t\t\t\torg.dom4j.Element tempElem =listNodes.get(j);" + NL + "\t\t\t\t\tif((\"";
  protected final String TEXT_458 = "\").equals(tempElem.getPath()!=null ? tempElem.getPath().replace(\"*[name()='\",\"\").replace(\"']\", \"\") : \"\")){";
  protected final String TEXT_459 = NL + "\t\t\t\t\t\tif(advancedXMLUtil_";
  protected final String TEXT_460 = ".generateCodeDom4j_FindInsertNode";
  protected final String TEXT_461 = "(tempElem,valueMap_";
  protected final String TEXT_462 = ")){";
  protected final String TEXT_463 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_464 = "){";
  protected final String TEXT_465 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(j>=listNodes.size()){" + NL + "\t\t\t\t\tbl_";
  protected final String TEXT_467 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tbl_";
  protected final String TEXT_468 = "=true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(bl_";
  protected final String TEXT_469 = "==true){";
  protected final String TEXT_470 = NL + "\t\t\t\t\t\torg.dom4j.Element group";
  protected final String TEXT_471 = "__";
  protected final String TEXT_472 = " = advancedXMLUtil_";
  protected final String TEXT_473 = ".generateCodeDom4j_UnFindInsertNode";
  protected final String TEXT_474 = "(nestXMLTool_";
  protected final String TEXT_475 = ",valueMap_";
  protected final String TEXT_476 = ",";
  protected final String TEXT_477 = ",orders_";
  protected final String TEXT_478 = ",bl_";
  protected final String TEXT_479 = ");";
  protected final String TEXT_480 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_481 = NL + "\t\t}";
  protected final String TEXT_482 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_483 = " = false;";
  protected final String TEXT_484 = NL + "\tif(isNewElememt_";
  protected final String TEXT_485 = " || groupbyList_";
  protected final String TEXT_486 = ".size()<=";
  protected final String TEXT_487 = " || groupbyList_";
  protected final String TEXT_488 = ".get(";
  protected final String TEXT_489 = ")==null";
  protected final String TEXT_490 = NL + "\t|| advancedXMLUtil_";
  protected final String TEXT_491 = ".getValue_";
  protected final String TEXT_492 = "_";
  protected final String TEXT_493 = "(groupbyList_";
  protected final String TEXT_494 = ",valueMap_";
  protected final String TEXT_495 = ")";
  protected final String TEXT_496 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_497 = ".get(";
  protected final String TEXT_498 = ").get(";
  protected final String TEXT_499 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_500 = ".get(";
  protected final String TEXT_501 = ").get(";
  protected final String TEXT_502 = ").equals(";
  protected final String TEXT_503 = ") " + NL + "\t\t: ";
  protected final String TEXT_504 = "!=null )";
  protected final String TEXT_505 = NL + "\t){";
  protected final String TEXT_506 = NL + "\t\t\t\torg.dom4j.Element group";
  protected final String TEXT_507 = "__";
  protected final String TEXT_508 = "=advancedXMLUtil_";
  protected final String TEXT_509 = ".generateCodeDom4j_group";
  protected final String TEXT_510 = "(nestXMLTool_";
  protected final String TEXT_511 = ",valueMap_";
  protected final String TEXT_512 = ",";
  protected final String TEXT_513 = ",orders_";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "\t\t\t\t";
  protected final String TEXT_516 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_517 = ".size()<=";
  protected final String TEXT_518 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_519 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_520 = ".get(";
  protected final String TEXT_521 = ").clear();" + NL + "        }";
  protected final String TEXT_522 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_523 = ".setValue_";
  protected final String TEXT_524 = "_";
  protected final String TEXT_525 = "(groupbyList_";
  protected final String TEXT_526 = ",valueMap_";
  protected final String TEXT_527 = ");";
  protected final String TEXT_528 = NL + "\t\tgroupbyList_";
  protected final String TEXT_529 = ".get(";
  protected final String TEXT_530 = ").add(";
  protected final String TEXT_531 = ");";
  protected final String TEXT_532 = NL + "        isNewElememt_";
  protected final String TEXT_533 = "=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_534 = ".size()<=";
  protected final String TEXT_535 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_536 = ".add(";
  protected final String TEXT_537 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_538 = ".set(";
  protected final String TEXT_539 = ",";
  protected final String TEXT_540 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_541 = NL + "\t}" + NL;
  protected final String TEXT_542 = NL + "\t// build loop xml tree";
  protected final String TEXT_543 = NL + "\t\t\torg.dom4j.Element loop_";
  protected final String TEXT_544 = "=advancedXMLUtil_";
  protected final String TEXT_545 = ".generateCodeDom4j_Loop(nestXMLTool_";
  protected final String TEXT_546 = ",valueMap_";
  protected final String TEXT_547 = ",";
  protected final String TEXT_548 = ",orders_";
  protected final String TEXT_549 = ", bl_";
  protected final String TEXT_550 = ");";
  protected final String TEXT_551 = NL + "\t\t\t\t";
  protected final String TEXT_552 = NL + "    currentRowCount_";
  protected final String TEXT_553 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_554 = " == ";
  protected final String TEXT_555 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_556 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_557 = " = file_";
  protected final String TEXT_558 = " + currentFileCount_";
  protected final String TEXT_559 = " + suffix_";
  protected final String TEXT_560 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_561 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_562 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_563 = ".clear();" + NL + "" + NL + "    \tjava.io.FileOutputStream stream_";
  protected final String TEXT_564 = " = new java.io.FileOutputStream(fileName_";
  protected final String TEXT_565 = ");" + NL + "        org.dom4j.io.XMLWriter output_";
  protected final String TEXT_566 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_567 = ", format_";
  protected final String TEXT_568 = ");";
  protected final String TEXT_569 = NL + "\t\tdoc_";
  protected final String TEXT_570 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", file_";
  protected final String TEXT_571 = ".substring(file_";
  protected final String TEXT_572 = ".lastIndexOf(\"/\")+1)+\".xsd\");" + NL + "        doc_";
  protected final String TEXT_573 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_574 = "        " + NL + "        nestXMLTool_";
  protected final String TEXT_575 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_576 = ".getRootElement());";
  protected final String TEXT_577 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_578 = ".removeEmptyElement(doc_";
  protected final String TEXT_579 = ".getRootElement());";
  protected final String TEXT_580 = NL + "        output_";
  protected final String TEXT_581 = ".write(doc_";
  protected final String TEXT_582 = ");" + NL + "        output_";
  protected final String TEXT_583 = ".close();" + NL + "        doc_";
  protected final String TEXT_584 = "  = org.dom4j.DocumentHelper.createDocument();";
  protected final String TEXT_585 = NL + "\t\t\tdoc_";
  protected final String TEXT_586 = ".addDocType(";
  protected final String TEXT_587 = ", null, ";
  protected final String TEXT_588 = ");";
  protected final String TEXT_589 = NL + "\t\t\tdoc_";
  protected final String TEXT_590 = ".addProcessingInstruction(\"xml-stylesheet\", inMap_";
  protected final String TEXT_591 = ");";
  protected final String TEXT_592 = NL + "    \tgroupElementList_";
  protected final String TEXT_593 = ".clear();" + NL + "    }";
  protected final String TEXT_594 = NL + "\tStringBuffer buf_";
  protected final String TEXT_595 = " = new StringBuffer();" + NL + "\t//init value is 0 not -1, because it will output the root tab when all the row value is null." + NL + "\tint unNullMaxIndex_";
  protected final String TEXT_596 = " = 0;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_597 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_598 = "=false;";
  protected final String TEXT_599 = NL + "\t\t\tbuf_";
  protected final String TEXT_600 = "=advancedXMLUtil_";
  protected final String TEXT_601 = ".generateCodeNull_rootEmptySpace";
  protected final String TEXT_602 = "(buf_";
  protected final String TEXT_603 = ",out_";
  protected final String TEXT_604 = ",startTabs_";
  protected final String TEXT_605 = ",endTabs_";
  protected final String TEXT_606 = ",valueMap_";
  protected final String TEXT_607 = ");";
  protected final String TEXT_608 = NL + "\t\tif( false";
  protected final String TEXT_609 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_610 = ".generateCodeNull_conditMain";
  protected final String TEXT_611 = "_";
  protected final String TEXT_612 = "(valueMap_";
  protected final String TEXT_613 = ")";
  protected final String TEXT_614 = " || valueMap_";
  protected final String TEXT_615 = ".get(\"";
  protected final String TEXT_616 = "\") != null";
  protected final String TEXT_617 = NL + "\t\t){" + NL + "\t\t\tunNullMaxIndex_";
  protected final String TEXT_618 = " = ";
  protected final String TEXT_619 = ";" + NL + "\t\t}";
  protected final String TEXT_620 = NL + "\t\tendTabs_";
  protected final String TEXT_621 = "[";
  protected final String TEXT_622 = "] = buf_";
  protected final String TEXT_623 = ".toString();" + NL + "\t\tbuf_";
  protected final String TEXT_624 = " = new StringBuffer();";
  protected final String TEXT_625 = NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_626 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_627 = " = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_628 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_629 = " = new String[";
  protected final String TEXT_630 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_631 = " = new String[";
  protected final String TEXT_632 = "];";
  protected final String TEXT_633 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_634 = " or not" + NL + "\tif(isNewElememt_";
  protected final String TEXT_635 = " || groupbyList_";
  protected final String TEXT_636 = ".size()<=";
  protected final String TEXT_637 = " || groupbyList_";
  protected final String TEXT_638 = ".get(";
  protected final String TEXT_639 = ")==null";
  protected final String TEXT_640 = NL + "\t|| advancedXMLUtil_";
  protected final String TEXT_641 = ".getValue_";
  protected final String TEXT_642 = "_";
  protected final String TEXT_643 = "(groupbyList_";
  protected final String TEXT_644 = ",valueMap_";
  protected final String TEXT_645 = ")";
  protected final String TEXT_646 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_647 = ".get(";
  protected final String TEXT_648 = ").get(";
  protected final String TEXT_649 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_650 = ".get(";
  protected final String TEXT_651 = ").get(";
  protected final String TEXT_652 = ").equals(";
  protected final String TEXT_653 = ") " + NL + "\t\t: ";
  protected final String TEXT_654 = "!=null )";
  protected final String TEXT_655 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(isNewElememt_";
  protected final String TEXT_656 = " == false && groupbyList_";
  protected final String TEXT_657 = ".size()>";
  protected final String TEXT_658 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_659 = " = ";
  protected final String TEXT_660 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_661 = ".size()<=";
  protected final String TEXT_662 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_663 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_664 = ".get(";
  protected final String TEXT_665 = ").clear();" + NL + "        }";
  protected final String TEXT_666 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_667 = ".setValue_";
  protected final String TEXT_668 = "_";
  protected final String TEXT_669 = "(groupbyList_";
  protected final String TEXT_670 = ",valueMap_";
  protected final String TEXT_671 = ");";
  protected final String TEXT_672 = NL + "\t\tgroupbyList_";
  protected final String TEXT_673 = ".get(";
  protected final String TEXT_674 = ").add(";
  protected final String TEXT_675 = ");";
  protected final String TEXT_676 = NL + "        isNewElememt_";
  protected final String TEXT_677 = "=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_678 = NL + "\t\tbuf_";
  protected final String TEXT_679 = "=advancedXMLUtil_";
  protected final String TEXT_680 = ".generateCodeNull_emptySpace";
  protected final String TEXT_681 = "(buf_";
  protected final String TEXT_682 = ",valueMap_";
  protected final String TEXT_683 = ",groupBuffer_";
  protected final String TEXT_684 = ");";
  protected final String TEXT_685 = NL + "\tif( false";
  protected final String TEXT_686 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_687 = ".generateCodeNull_conditGroup";
  protected final String TEXT_688 = "_";
  protected final String TEXT_689 = "(valueMap_";
  protected final String TEXT_690 = ")";
  protected final String TEXT_691 = " || valueMap_";
  protected final String TEXT_692 = ".get(\"";
  protected final String TEXT_693 = "\") != null";
  protected final String TEXT_694 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_695 = " = ";
  protected final String TEXT_696 = ";" + NL + "\t}";
  protected final String TEXT_697 = NL + "\t// buffer the end tabs to groupEnd buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_698 = "[";
  protected final String TEXT_699 = "] = buf_";
  protected final String TEXT_700 = ".toString();" + NL + "    buf_";
  protected final String TEXT_701 = " = new StringBuffer();";
  protected final String TEXT_702 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_703 = " >= 0) {" + NL + "        //out_";
  protected final String TEXT_704 = ".newLine();//Track code";
  protected final String TEXT_705 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_706 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_707 = " = 0; i_";
  protected final String TEXT_708 = " < startTabs_";
  protected final String TEXT_709 = ".length; i_";
  protected final String TEXT_710 = "++) {" + NL + "                if (i_";
  protected final String TEXT_711 = " <= preUnNullMaxIndex_";
  protected final String TEXT_712 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_713 = "[i_";
  protected final String TEXT_714 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_715 = ".write(startTabs_";
  protected final String TEXT_716 = "[i_";
  protected final String TEXT_717 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_718 = "[i_";
  protected final String TEXT_719 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_720 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_721 = " = 0; i_";
  protected final String TEXT_722 = " < startTabs_";
  protected final String TEXT_723 = ".length; i_";
  protected final String TEXT_724 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_725 = "[i_";
  protected final String TEXT_726 = "] != null) {" + NL + "                out_";
  protected final String TEXT_727 = ".write(startTabs_";
  protected final String TEXT_728 = "[i_";
  protected final String TEXT_729 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_730 = "[i_";
  protected final String TEXT_731 = "] = null;" + NL + "        }";
  protected final String TEXT_732 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_733 = " >= preNewTabIndex_";
  protected final String TEXT_734 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_735 = " >= ";
  protected final String TEXT_736 = " + newTabIndex_";
  protected final String TEXT_737 = ") {" + NL + "            for (int i_";
  protected final String TEXT_738 = " = preUnNullMaxIndex_";
  protected final String TEXT_739 = "; i_";
  protected final String TEXT_740 = " >= ";
  protected final String TEXT_741 = " + newTabIndex_";
  protected final String TEXT_742 = "; i_";
  protected final String TEXT_743 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_744 = "[i_";
  protected final String TEXT_745 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_746 = ".write(endTabs_";
  protected final String TEXT_747 = "[i_";
  protected final String TEXT_748 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_749 = "[i_";
  protected final String TEXT_750 = "] = null;";
  protected final String TEXT_751 = "out_";
  protected final String TEXT_752 = ".newLine(); ";
  protected final String TEXT_753 = NL + "                out_";
  protected final String TEXT_754 = ".write(endTabStrs_";
  protected final String TEXT_755 = NL + "                        .get(i_";
  protected final String TEXT_756 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_757 = NL + "            for (int i_";
  protected final String TEXT_758 = " = preNewTabIndex_";
  protected final String TEXT_759 = " - 1; i_";
  protected final String TEXT_760 = " >= ";
  protected final String TEXT_761 = " + newTabIndex_";
  protected final String TEXT_762 = "; i_";
  protected final String TEXT_763 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_764 = "[i_";
  protected final String TEXT_765 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_766 = ".write(endTabs_";
  protected final String TEXT_767 = "[i_";
  protected final String TEXT_768 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_769 = "[i_";
  protected final String TEXT_770 = "] = null;" + NL + "            \t";
  protected final String TEXT_771 = "out_";
  protected final String TEXT_772 = ".newLine(); ";
  protected final String TEXT_773 = NL + "                out_";
  protected final String TEXT_774 = ".write(endTabStrs_";
  protected final String TEXT_775 = NL + "                        .get(i_";
  protected final String TEXT_776 = "));" + NL + "            }";
  protected final String TEXT_777 = NL + "        }";
  protected final String TEXT_778 = NL + "        preNewTabIndex_";
  protected final String TEXT_779 = " = newTabIndex_";
  protected final String TEXT_780 = " + ";
  protected final String TEXT_781 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_782 = " = 0; i_";
  protected final String TEXT_783 = " < groupBuffer_";
  protected final String TEXT_784 = ".length; i_";
  protected final String TEXT_785 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_786 = " >= preNewTabIndex_";
  protected final String TEXT_787 = " - ";
  protected final String TEXT_788 = ") {" + NL + "            startTabs_";
  protected final String TEXT_789 = "[i_";
  protected final String TEXT_790 = " + ";
  protected final String TEXT_791 = "] = groupBuffer_";
  protected final String TEXT_792 = "[i_";
  protected final String TEXT_793 = "];" + NL + "            endTabs_";
  protected final String TEXT_794 = "[i_";
  protected final String TEXT_795 = " + ";
  protected final String TEXT_796 = "] = groupEndBuffer_";
  protected final String TEXT_797 = "[i_";
  protected final String TEXT_798 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_799 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_800 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_801 = "=unNullMaxIndex_";
  protected final String TEXT_802 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_803 = ">";
  protected final String TEXT_804 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_805 = "=";
  protected final String TEXT_806 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_807 = NL + "\t// build loop xml tree";
  protected final String TEXT_808 = NL + "\t\tif( false";
  protected final String TEXT_809 = NL + "\t\t\t\t\t|| advancedXMLUtil_";
  protected final String TEXT_810 = ".generateCodeNull_conditLoop_";
  protected final String TEXT_811 = "(valueMap_";
  protected final String TEXT_812 = ")";
  protected final String TEXT_813 = " || valueMap_";
  protected final String TEXT_814 = ".get(\"";
  protected final String TEXT_815 = "\") != null";
  protected final String TEXT_816 = " || true " + NL + "    \t";
  protected final String TEXT_817 = NL + "\t\t){";
  protected final String TEXT_818 = NL + "\t\tadvancedXMLUtil_";
  protected final String TEXT_819 = ".generateCodeNull_loopEmptySpace(buf_";
  protected final String TEXT_820 = ",out_";
  protected final String TEXT_821 = ",endTabs_";
  protected final String TEXT_822 = ",valueMap_";
  protected final String TEXT_823 = ");";
  protected final String TEXT_824 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_825 = " = 0; i_";
  protected final String TEXT_826 = " < startTabs_";
  protected final String TEXT_827 = ".length; i_";
  protected final String TEXT_828 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_829 = "[i_";
  protected final String TEXT_830 = "] != null && startTabs_";
  protected final String TEXT_831 = "[i_";
  protected final String TEXT_832 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_833 = ".write(startTabs_";
  protected final String TEXT_834 = "[i_";
  protected final String TEXT_835 = "]);" + NL + "                startTabs_";
  protected final String TEXT_836 = "[i_";
  protected final String TEXT_837 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_838 = ".write(buf_";
  protected final String TEXT_839 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_840 = " = ";
  protected final String TEXT_841 = ";";
  protected final String TEXT_842 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_843 = " = ";
  protected final String TEXT_844 = ";" + NL + "\t\t}";
  protected final String TEXT_845 = NL + "    currentRowCount_";
  protected final String TEXT_846 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_847 = " == ";
  protected final String TEXT_848 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_849 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_850 = " = file_";
  protected final String TEXT_851 = " + currentFileCount_";
  protected final String TEXT_852 = " + suffix_";
  protected final String TEXT_853 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_854 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_855 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_856 = ".clear();" + NL + " ";
  protected final String TEXT_857 = "   \t" + NL + "\tif (preUnNullMaxIndex_";
  protected final String TEXT_858 = " >= 0) {" + NL + "        // output all buffer" + NL + "        for (int j_";
  protected final String TEXT_859 = " = 0; j_";
  protected final String TEXT_860 = " <= preUnNullMaxIndex_";
  protected final String TEXT_861 = "; j_";
  protected final String TEXT_862 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_863 = "[j_";
  protected final String TEXT_864 = "] != null)" + NL + "                out_";
  protected final String TEXT_865 = ".write(startTabs_";
  protected final String TEXT_866 = "[j_";
  protected final String TEXT_867 = "]);" + NL + "        }" + NL + "" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_868 = " < preNewTabIndex_";
  protected final String TEXT_869 = " ) {" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_870 = " = preNewTabIndex_";
  protected final String TEXT_871 = " - 1; i_";
  protected final String TEXT_872 = " >= 0; i_";
  protected final String TEXT_873 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_874 = "[i_";
  protected final String TEXT_875 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_876 = ".write(endTabs_";
  protected final String TEXT_877 = "[i_";
  protected final String TEXT_878 = "]);" + NL + "            \t}";
  protected final String TEXT_879 = "out_";
  protected final String TEXT_880 = ".newLine(); ";
  protected final String TEXT_881 = NL + "                out_";
  protected final String TEXT_882 = ".write(endTabStrs_";
  protected final String TEXT_883 = ".get(i_";
  protected final String TEXT_884 = "));" + NL + "            }" + NL + "        } else {" + NL + "            for (int i_";
  protected final String TEXT_885 = " = preUnNullMaxIndex_";
  protected final String TEXT_886 = "; i_";
  protected final String TEXT_887 = " >= 0; i_";
  protected final String TEXT_888 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_889 = "[i_";
  protected final String TEXT_890 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_891 = ".write(endTabs_";
  protected final String TEXT_892 = "[i_";
  protected final String TEXT_893 = "]);" + NL + "            \t}";
  protected final String TEXT_894 = "out_";
  protected final String TEXT_895 = ".newLine(); ";
  protected final String TEXT_896 = NL + "                out_";
  protected final String TEXT_897 = ".write(endTabStrs_";
  protected final String TEXT_898 = ".get(i_";
  protected final String TEXT_899 = "));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_900 = NL + "\tfor (int i_";
  protected final String TEXT_901 = " = endTabStrs_";
  protected final String TEXT_902 = ".size() - 1; i_";
  protected final String TEXT_903 = " >= 0; i_";
  protected final String TEXT_904 = "--) {" + NL + "    \tif(endTabs_";
  protected final String TEXT_905 = "[i_";
  protected final String TEXT_906 = "]!=null){" + NL + "    \t\tout_";
  protected final String TEXT_907 = ".write(endTabs_";
  protected final String TEXT_908 = "[i_";
  protected final String TEXT_909 = "]);" + NL + "    \t}";
  protected final String TEXT_910 = "out_";
  protected final String TEXT_911 = ".newLine(); ";
  protected final String TEXT_912 = NL + "        out_";
  protected final String TEXT_913 = ".write(endTabStrs_";
  protected final String TEXT_914 = ".get(i_";
  protected final String TEXT_915 = "));" + NL + "    }";
  protected final String TEXT_916 = NL + "\t    preUnNullMaxIndex_";
  protected final String TEXT_917 = " = -1;" + NL + "        preNewTabIndex_";
  protected final String TEXT_918 = " = -1;" + NL + "    \tstartTabs_";
  protected final String TEXT_919 = " = new String[endTabStrs_";
  protected final String TEXT_920 = ".size()];" + NL + "    \tendTabs_";
  protected final String TEXT_921 = " = new String[endTabStrs_";
  protected final String TEXT_922 = ".size()];" + NL + "    \t" + NL + "\t\tout_";
  protected final String TEXT_923 = ".close();" + NL + "\t\tout_";
  protected final String TEXT_924 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_925 = " + currentFileCount_";
  protected final String TEXT_926 = " + suffix_";
  protected final String TEXT_927 = "), ";
  protected final String TEXT_928 = "));" + NL + "        out_";
  protected final String TEXT_929 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_930 = "+\"\\\"?>\");" + NL + "        out_";
  protected final String TEXT_931 = ".newLine();" + NL + "        ";
  protected final String TEXT_932 = NL + "    \t\tout_";
  protected final String TEXT_933 = ".write(\"<!DOCTYPE \"+";
  protected final String TEXT_934 = "+\" SYSTEM \\\"\" + ";
  protected final String TEXT_935 = " + \"\\\">\");" + NL + "    \t\tout_";
  protected final String TEXT_936 = ".newLine();";
  protected final String TEXT_937 = NL + "\t\t\tout_";
  protected final String TEXT_938 = ".write(\"<?xml-stylesheet type=\\\"\"+";
  protected final String TEXT_939 = "+\"\\\" href=\\\"\"+";
  protected final String TEXT_940 = "+\"\\\">\");" + NL + "\t\t\tout_";
  protected final String TEXT_941 = ".newLine();";
  protected final String TEXT_942 = NL + "\t}";
  protected final String TEXT_943 = NL;

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
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();

    stringBuffer.append(TEXT_2);
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_5);
    
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

    stringBuffer.append(TEXT_6);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_9);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
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
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_29);
    
        }else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_32);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_33);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_34);
    
			}
		}

    stringBuffer.append(TEXT_35);
    
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

    stringBuffer.append(TEXT_36);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    
	}
	
	void getXMLElement(String currEleName) {
		getXMLNode(currEleName);
	}

	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_41);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_45);
    
	}

	void putCurrentElementByNull(String currEleName) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_54);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_60);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
	}
	
	void putDocument() {
		//do nothing
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_82);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
	}
}

class MappingTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_88);
    
	}
	
	void getXMLElement(String currEleName) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_91);
    
	}
	
	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_95);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_99);
    
	}
	
	void putCurrentElementByNull(String currEleName) {
		//do nothing
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_102);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_104);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_107);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_109);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_112);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
	}
	
	void putDocument() {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_133);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
	}
}

    stringBuffer.append(TEXT_137);
    
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

    stringBuffer.append(TEXT_138);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
		}
	}
	
	public void generateLeftBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_141);
    
		}
	}
	
	public void generateMethod() {
		if(isOptimizeCodeForXMLNode) {
			if(index == -1) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_143);
    
			} else if((index+1)%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_144);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_145);
    
			}
			index++;
		}
	}
	
	public void generateMethodCall() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    
			int count = index + 1;
			for(int i = 0; i < count; i++) {
				if(i%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i/xmlNodeOptNum);
    stringBuffer.append(TEXT_156);
    
				}
			}
		}
	}
	
}

    stringBuffer.append(TEXT_157);
    
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

    stringBuffer.append(TEXT_158);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_160);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateMainCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(isAppend && !outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_161);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_162);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_163);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_164);
    touchXMLNode.getXMLNode(parentName);
    stringBuffer.append(TEXT_165);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_166);
    
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

    stringBuffer.append(TEXT_167);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_169);
    touchXMLNode.putCurrentElementByNameWithoutNamespacePrefix(currEleName,node,index);
    stringBuffer.append(TEXT_170);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    stringBuffer.append(TEXT_171);
    
			}else{

    stringBuffer.append(TEXT_172);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    
			}
			if(isAppend){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_181);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    
				List<XMLNode> nextSiblings = node.getNextSiblings();

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
				if(nextSiblings.size() > 0) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
				}
				
				for(XMLNode sibling : nextSiblings) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(sibling.name);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    
				}

    stringBuffer.append(TEXT_206);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_209);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_210);
    
			}else{

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_220);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_223);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_224);
    
			}
		}else{
			touchXMLNode.putCurrentElementByNull(currEleName);
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_225);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_227);
    touchXMLNode.putCurrentElementByParentWithoutNamespacePrefix(currEleName,parentName,node,index);
    stringBuffer.append(TEXT_228);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    stringBuffer.append(TEXT_229);
    
			}else{

    stringBuffer.append(TEXT_230);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_231);
    touchXMLNode.putSubTreeRootParentByCurrentElement(currEleName);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_232);
    tool.getValue(node); 
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_235);
    tool.getValue(node);
    stringBuffer.append(TEXT_236);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_239);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_240);
    
				}
			}else{
				if("id_Document".equals(node.relatedColumn.getTalendType())) {

    stringBuffer.append(TEXT_241);
    tool.getValue(node); 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_244);
    tool.getValue(node);
    stringBuffer.append(TEXT_245);
    
				} else {

    stringBuffer.append(TEXT_246);
    tool.getValue(node); 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_249);
    tool.getValue(node);
    stringBuffer.append(TEXT_250);
    
				}
				if(outputAsXSD){

    stringBuffer.append(TEXT_251);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_252);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_253);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_257);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_258);
    tool.getValue(node);
    stringBuffer.append(TEXT_259);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_261);
    tool.getValue(node);
    stringBuffer.append(TEXT_262);
     if (bAddEmptyAttr) { 
    stringBuffer.append(TEXT_263);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_265);
    }
		} else { 
		  if (node.defaultValue != null && !("").equals(node.defaultValue) ){
          
    stringBuffer.append(TEXT_266);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_269);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_270);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_272);
    
		  }
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_273);
    tool.getValue(node);
    stringBuffer.append(TEXT_274);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_276);
    tool.getValue(node);
    stringBuffer.append(TEXT_277);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_278);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_279);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_280);
    tool.getValue(node);
    stringBuffer.append(TEXT_281);
    
			}

    stringBuffer.append(TEXT_282);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_283);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_286);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_287);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_288);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_290);
    
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

    stringBuffer.append(TEXT_291);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_292);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_293);
    tool.getValue(node); 
    stringBuffer.append(TEXT_294);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_295);
    			}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_296);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_297);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_298);
    tool.getValue(node); 
    stringBuffer.append(TEXT_299);
    if(!needEmptyNode){
    stringBuffer.append(TEXT_300);
    }
    stringBuffer.append(TEXT_301);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_302);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_303);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_304);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_306);
    					}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_308);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_309);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_310);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_311);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_312);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_313);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_314);
    }

    stringBuffer.append(TEXT_315);
    
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

    stringBuffer.append(TEXT_316);
    stringBuffer.append(parentName );
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){

    stringBuffer.append(TEXT_317);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_319);
    
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

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
						}else{

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty 
						&& (child.relatedColumn != null || child.childrenColumnList.size()>0
							 || child.hasDefaultValue == true ) ){

    stringBuffer.append(TEXT_334);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_337);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_338);
    }
    stringBuffer.append(TEXT_339);
    
						if(isCompact==false)
							generateCode(child,emptySpace+"  ");
						else
							generateCode(child,emptySpace);

    stringBuffer.append(TEXT_340);
    
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

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_346);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_352);
    tool.getValue(node); 
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
		}

    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_362);
    
		}else{

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_365);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_366);
    tool.getValue(node);
    stringBuffer.append(TEXT_367);
    tool.getValue(node);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    tool.getValue(node);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    tool.getValue(node);
    stringBuffer.append(TEXT_372);
    
			}else{

    stringBuffer.append(TEXT_373);
    tool.getValue(node);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    tool.getValue(node);
    stringBuffer.append(TEXT_376);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_382);
    
		}
	}
	private void addAttribute(XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_383);
    tool.getValue(node); 
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_386);
    tool.getValue(node);
    stringBuffer.append(TEXT_387);
     if (bAddEmptyAttr){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_390);
    }
		} else {
		  if (node.defaultValue != null && !("").equals(node.defaultValue)){
          
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_394);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_397);
    
		  }
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_398);
    tool.getValue(node);
    stringBuffer.append(TEXT_399);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    tool.getValue(node);
    stringBuffer.append(TEXT_402);
    
			}else{

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_405);
    tool.getValue(node);
    stringBuffer.append(TEXT_406);
    
			}

    stringBuffer.append(TEXT_407);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_410);
    
			}else{

    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_414);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

    stringBuffer.append(TEXT_415);
    
// ------------------- *** Common code start *** ------------------- //
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
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
                
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                boolean bAddEmptyAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_EMPTY_ATTRIBUTE__"));
                boolean bAddUnmappedAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_UNMAPPED_ATTRIBUTE__"));
                
                String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
                
                String split = ElementParameterParser.getValue(node, "__SPLIT__");
                String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
				
        		boolean isMerge= ("true").equals(ElementParameterParser.getValue(node, "__MERGE__"));        		
        		boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));
        		
        		//*****************add for the feature:8873 to support output steam *****************
        		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
				String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
				//*******************add for feature:8873 end ****************
				
				boolean needFileValid = ("true").equals(ElementParameterParser.getValue(node, "__FILE_VALID__"));
				
				boolean needDTDValid = ("true").equals(ElementParameterParser.getValue(node, "__DTD_VALID__"));
				String dtdRootName = ElementParameterParser.getValue(node, "__DTD_NAME__");
        		String dtdFileName = ElementParameterParser.getValue(node, "__DTD_SYSTEMID__");
        		
        		boolean needXSLValid = ("true").equals(ElementParameterParser.getValue(node, "__XSL_VALID__"));
        		String xslType = ElementParameterParser.getValue(node, "__XSL_TYPE__");
				String xslHref = ElementParameterParser.getValue(node, "__XSL_HREF__");
				
				int schemaOptNum=100;
				boolean isOptimizeCode=false;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				} 
				if(metadata.getListColumns().size()> schemaOptNum){
					isOptimizeCode=true;
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

    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    
				int colNum=0;
				for(IMetadataColumn column :metadata.getListColumns()){
					if(isOptimizeCode){
						if(colNum%schemaOptNum==0){

    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(colNum/schemaOptNum);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    
						}
					}else{

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_426);
     tool.getValue(column); 
    stringBuffer.append(TEXT_427);
    
					}
					colNum++;
				}
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
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
    
    //start generate code

    stringBuffer.append(TEXT_428);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByNull();
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
     
	generateToolByDom4j.touchXMLNode.putDocument();
	generateToolByDom4j.generateCode(root,"root","doc");
	if(!isMerge || useStream){ // add a prerequisite useStream to ignore the append mode

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    generateToolByDom4j.touchXMLNode.getXMLElement("subTreeRootParent");
    stringBuffer.append(TEXT_436);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByRootGroup();
    stringBuffer.append(TEXT_437);
    
	}else{

    stringBuffer.append(TEXT_438);
    
	}
	
if(groupTable.size()>0){					//init the generate tool.
	if(!useStream && isMerge){//merge into the file and add a prerequisite:useStream to ignore the append mode
		generateToolByDom4j.isAppend= true;
	    String firstGroupPath = groupList.get(0).path;

    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(firstGroupPath );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(firstGroupPath.substring(0,firstGroupPath.lastIndexOf("/")) );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(firstGroupPath.substring(0,firstGroupPath.lastIndexOf("/")) );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByFirstGroup();
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    
		for( int i=0; i<groupList.size();i++){
			XMLNode groupNode= groupList.get(i);
			GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
			generateExprCmpByDom4j.tool = tool;
			generateExprCmpByDom4j.groupNode = groupNode;
			generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    generateToolByDom4j.touchXMLNode.getXMLElement("subTreeRootParent");
    stringBuffer.append(TEXT_457);
    stringBuffer.append(groupNode.path);
    stringBuffer.append(TEXT_458);
    
					if(isOptimizeCode){

    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    
					}else{

    stringBuffer.append(TEXT_463);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_464);
    
					}

    stringBuffer.append(TEXT_465);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByTempElem();
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    
					if(isOptimizeCode){

    stringBuffer.append(TEXT_470);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    generateToolByDom4j.touchXMLNode.getXMLElement("subTreeRootParent");
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    
						if(("ELEMENT").equals(groupList.get(i).type) && (0!=(groupList.get(i).special & 2))){

    stringBuffer.append(TEXT_480);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByGroup(i);
    
						}
					}else{
						generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");
					}

    stringBuffer.append(TEXT_481);
    
 		}//for
 	}else{//last group code

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
     
		for(int i=0;i<groupList.size();i++){
			XMLNode groupRootNode = groupList.get(i);
			int nodeNum=0;

    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
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
					if(isOptimizeCode){
						if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    
						}
						nodeNum++;
					}else{

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_502);
    tool.getValue(attr);
    stringBuffer.append(TEXT_503);
    tool.getValue(attr);
    stringBuffer.append(TEXT_504);
     
					}
				}
			}

    stringBuffer.append(TEXT_505);
     
			if(isOptimizeCode){

    stringBuffer.append(TEXT_506);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    generateToolByDom4j.touchXMLNode.getXMLElement("subTreeRootParent");
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
				if(("ELEMENT").equals(groupRootNode.type) && (0!=(groupRootNode.special & 2))){

    stringBuffer.append(TEXT_515);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByGroup(i);
    
				}
			}else{
				generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");
			}

    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_521);
     
			for(int j=0;j<groupbyNodeList.get(i).size();j++){
				XMLNode attr = groupbyNodeList.get(i).get(j);
				if(isOptimizeCode){
					if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    
					}
				}else{

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_530);
    tool.getValue(attr);
    stringBuffer.append(TEXT_531);
     
				}
			}

    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_539);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_540);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByGroupList(i);
    stringBuffer.append(TEXT_541);
    
		}//for
 	}//if merge=true 	
}


    stringBuffer.append(TEXT_542);
    
	if(loopTable!=null && loopTable.size()>0){
		if(isOptimizeCode){

    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    generateToolByDom4j.touchXMLNode.getXMLElement("subTreeRootParent");
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    if(!useStream && isMerge && groupTable.size()>0){
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_550);
    
				if(("ELEMENT").equals(loop.type) && (0!=(loop.special & 2))){

    stringBuffer.append(TEXT_551);
    generateToolByDom4j.touchXMLNode.putSubTreeRootParentByLoop();
    
				}
		}else{
		 	generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
		}
	}
	//file split
	if(!useStream && ("true").equals(split)){ //add a prerequisite:useStream to ignore the append mode

    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    
		}

    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    
		if(!("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    
		}

    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    
		if (!isMerge && needFileValid) {
			if(needDTDValid) {

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_588);
    
			} else if(needXSLValid) {

    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    			
			}
		}

    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
else if(("Null").equals(mode)){

	//init the generate tool.
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

    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    
	String rootEmptySpace = "";
	for(int i=0;i < mainList.size();i++){
		if(isOptimizeCode){

    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(i);
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
    
		}else{
			generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		}
		if(isCompact==false){//generate pretty file
			rootEmptySpace+="  ";
		}
		
		if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
			if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){

    stringBuffer.append(TEXT_608);
    
					int columnNum=0;
                	for(IMetadataColumn column : mainList.get(i).childrenColumnList){
                		if(isOptimizeCode){
                			if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    
                			}
                			columnNum++;
                		}else{
                		
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_616);
    
                		}
                	}

    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_619);
    
			}
		}

    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
	}

    stringBuffer.append(TEXT_625);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_632);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);
		int nodeNum=0;

    stringBuffer.append(TEXT_633);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_639);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){
				if(isOptimizeCode){
					if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    
					}
					nodeNum++;
				}else{

    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_652);
    tool.getValue(attr);
    stringBuffer.append(TEXT_653);
    tool.getValue(attr);
    stringBuffer.append(TEXT_654);
    
				}
			}
		}

    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_665);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
				if(isOptimizeCode){
					if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    
					}
				}else{

    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_674);
    tool.getValue(attr);
    stringBuffer.append(TEXT_675);
    
				}
		}

    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    
		String emptySpace = "";
		
		if(isCompact==false){//generate pretty file
			for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
				emptySpace +="  ";
			}
		}
		if(isOptimizeCode){

    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    
		}else{
			generateToolByNull.generateCode(groupList.get(i),emptySpace);
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_685);
    
				int columnNum=0;
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
					if(isOptimizeCode){
            			if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    
            			}
                		columnNum++;
        			}else{
                		
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_693);
    
        			}
            	}

    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_696);
    
			}
		}

    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    
		}else{

    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    if(isCompact==false){
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    }
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    
		}

    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    if(isCompact==false){
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    }
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_777);
    
		}

    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_806);
    
	}

    stringBuffer.append(TEXT_807);
    
	String emptySpace = "";
	if(isCompact==false){//generate pretty file
		for(int len =loop.path.split("/").length-1;len>1;len--){
			emptySpace +="  ";
		}
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_808);
    
		int columnNum=0;
    	for(IMetadataColumn column : loop.childrenColumnList){
			if(isOptimizeCode){
            	if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    
            	}
                columnNum++;
        	}else{
                	
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_815);
    
        	}
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_816);
    }
    stringBuffer.append(TEXT_817);
    
	}
	if(isOptimizeCode){

    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    
	}else{
		generateToolByNull.generateCode(loop,emptySpace);
		generateToolByNull.endElement(loop,emptySpace);
	}

    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_841);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_844);
    
	}
	
	//file split 
	if(!useStream && ("true").equals(split)){ // add a new prerequisite:useStream to ignore the split condition

    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_847);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_856);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_874);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    if(isCompact==false){
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    }
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_892);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_893);
    if(isCompact==false){
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_895);
    }
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_899);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    if(isCompact==false){
    stringBuffer.append(TEXT_910);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_911);
    }
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    
			}
		}

    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_927);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_931);
    
		if (needFileValid) {
			if (needDTDValid) {

    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_934);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_936);
    
			} else if (needXSLValid) {

    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_938);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_939);
    stringBuffer.append(xslHref);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_941);
    			
			}
		}

    stringBuffer.append(TEXT_942);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_943);
    return stringBuffer.toString();
  }
}
