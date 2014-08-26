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
import java.util.HashMap;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

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
  protected final String TEXT_1 = "\t\tvalueMap_";
  protected final String TEXT_2 = ".get(\"";
  protected final String TEXT_3 = "\")";
  protected final String TEXT_4 = NL + "\t(";
  protected final String TEXT_5 = NL + "\t\t";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " != null?";
  protected final String TEXT_8 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_9 = "), ";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ")\t\t\t\t\t";
  protected final String TEXT_12 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = "), ";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ")\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "            String.valueOf(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = NL + "\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_27 = ")";
  protected final String TEXT_28 = NL + "            ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ".toString()";
  protected final String TEXT_31 = ":";
  protected final String TEXT_32 = "null";
  protected final String TEXT_33 = NL + "\t\t)";
  protected final String TEXT_34 = NL + "\t\t\t";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = ".setName(\"";
  protected final String TEXT_37 = "\");";
  protected final String TEXT_38 = NL + "\t\t\tif (";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_43 = "_";
  protected final String TEXT_44 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_45 = NL + "                ";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = ".remove(";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ";" + NL + "\t\tif (";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_55 = "\") == null) {";
  protected final String TEXT_56 = NL + "            ";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_59 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_62 = "\");" + NL + "        }";
  protected final String TEXT_63 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_66 = "\");";
  protected final String TEXT_67 = NL + "\t\tint app_size_";
  protected final String TEXT_68 = "=";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = ".elements(\"";
  protected final String TEXT_71 = "\").size();" + NL + "\t\tif(app_size_";
  protected final String TEXT_72 = " > 0){" + NL + "\t\t\torders_";
  protected final String TEXT_73 = "[";
  protected final String TEXT_74 = "] =1+ ";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = ".elements().indexOf(";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ".elements(\"";
  protected final String TEXT_79 = "\").get(app_size_";
  protected final String TEXT_80 = "-1));" + NL + "\t\t}else{";
  protected final String TEXT_81 = NL + "\t\t\torders_";
  protected final String TEXT_82 = "[";
  protected final String TEXT_83 = "] = ";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = ".elements().size();";
  protected final String TEXT_86 = NL + "\t\t\torders_";
  protected final String TEXT_87 = "[";
  protected final String TEXT_88 = "] = ";
  protected final String TEXT_89 = ";" + NL + "\t\t\tif(orders_";
  protected final String TEXT_90 = "[";
  protected final String TEXT_91 = "] == 0 && ";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = ".elements().size() != 0) {" + NL + "\t\t\t\torders_";
  protected final String TEXT_94 = "[";
  protected final String TEXT_95 = "] = ";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ".elements().size();" + NL + "\t\t\t}";
  protected final String TEXT_98 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ".elements().add(orders_";
  protected final String TEXT_101 = "[";
  protected final String TEXT_102 = "],";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "        if(orders_";
  protected final String TEXT_106 = "[";
  protected final String TEXT_107 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_108 = "[";
  protected final String TEXT_109 = "] = ";
  protected final String TEXT_110 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_111 = " < orders_";
  protected final String TEXT_112 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_113 = "[";
  protected final String TEXT_114 = "] = 0;" + NL + "        }";
  protected final String TEXT_115 = NL + "        ";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = ".elements().add(orders_";
  protected final String TEXT_118 = "[";
  protected final String TEXT_119 = "]++,";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ";" + NL + "\t\tif (";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_127 = "\") == null) {";
  protected final String TEXT_128 = NL + "            ";
  protected final String TEXT_129 = "_";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = ".addElement(\"";
  protected final String TEXT_133 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = ".addElement(\"";
  protected final String TEXT_138 = "\");" + NL + "        }";
  protected final String TEXT_139 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = ".addElement(\"";
  protected final String TEXT_144 = "\");";
  protected final String TEXT_145 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = ";";
  protected final String TEXT_149 = NL + "\t\tif(";
  protected final String TEXT_150 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_151 = " .parseAndAdd(";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = ",";
  protected final String TEXT_154 = ");" + NL + "\t\t}";
  protected final String TEXT_155 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_156 = " .parseAndAdd(";
  protected final String TEXT_157 = "_";
  protected final String TEXT_158 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_161 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_162 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_163 = " .setText(";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_166 = ").getDocument().getRootElement().asXML());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_167 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_168 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_169 = " .setText(";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ",";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_173 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_176 = "_";
  protected final String TEXT_177 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_178 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_179 = ".parseAndAdd(";
  protected final String TEXT_180 = "_";
  protected final String TEXT_181 = ",\"";
  protected final String TEXT_182 = "\");" + NL;
  protected final String TEXT_183 = " " + NL + "\t\t  if (";
  protected final String TEXT_184 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_185 = "_";
  protected final String TEXT_186 = ".addAttribute(\"";
  protected final String TEXT_187 = "\", ";
  protected final String TEXT_188 = ");" + NL + "\t\t  } ";
  protected final String TEXT_189 = " else {" + NL + "\t\t    ";
  protected final String TEXT_190 = "_";
  protected final String TEXT_191 = ".addAttribute(\"";
  protected final String TEXT_192 = "\", \"\");" + NL + "          }";
  protected final String TEXT_193 = NL + "\t\t    ";
  protected final String TEXT_194 = "_";
  protected final String TEXT_195 = ".addAttribute(\"";
  protected final String TEXT_196 = "\", \"";
  protected final String TEXT_197 = "\");";
  protected final String TEXT_198 = NL + "\t\t    ";
  protected final String TEXT_199 = "_";
  protected final String TEXT_200 = ".addAttribute(\"";
  protected final String TEXT_201 = "\", \"\");" + NL + "\t\t  ";
  protected final String TEXT_202 = NL + "\t\tif(";
  protected final String TEXT_203 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ".addNamespace(\"";
  protected final String TEXT_206 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_207 = "));";
  protected final String TEXT_208 = NL + "        \t";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_213 = "))));";
  protected final String TEXT_214 = NL + "\t\t}";
  protected final String TEXT_215 = NL + "\t\t\t";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ".addNamespace(\"";
  protected final String TEXT_218 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_219 = "\"));";
  protected final String TEXT_220 = NL + "        \t";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_223 = "_";
  protected final String TEXT_224 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_225 = "\"))));";
  protected final String TEXT_226 = "true";
  protected final String TEXT_227 = " && (";
  protected final String TEXT_228 = "(";
  protected final String TEXT_229 = "==null && ";
  protected final String TEXT_230 = " == null) || (true &&";
  protected final String TEXT_231 = "!=null" + NL + " && ";
  protected final String TEXT_232 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_233 = ".getText().equals(";
  protected final String TEXT_234 = ")";
  protected final String TEXT_235 = ")";
  protected final String TEXT_236 = NL + ")";
  protected final String TEXT_237 = " && (";
  protected final String TEXT_238 = "(";
  protected final String TEXT_239 = "==null && ";
  protected final String TEXT_240 = ".attribute(\"";
  protected final String TEXT_241 = "\") == null) || (true && ";
  protected final String TEXT_242 = ".attribute(\"";
  protected final String TEXT_243 = "\")!=null" + NL + "&& ";
  protected final String TEXT_244 = ".attribute(\"";
  protected final String TEXT_245 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_246 = ".attribute(\"";
  protected final String TEXT_247 = "\").getText().equals(";
  protected final String TEXT_248 = ")";
  protected final String TEXT_249 = ")";
  protected final String TEXT_250 = ")";
  protected final String TEXT_251 = NL;
  protected final String TEXT_252 = ".element(\"";
  protected final String TEXT_253 = "\")";
  protected final String TEXT_254 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_255 = "[";
  protected final String TEXT_256 = "] = buf_";
  protected final String TEXT_257 = ".toString();" + NL + "        buf_";
  protected final String TEXT_258 = " = new StringBuffer();";
  protected final String TEXT_259 = NL + "\t\tstartTabs_";
  protected final String TEXT_260 = "[";
  protected final String TEXT_261 = "] = buf_";
  protected final String TEXT_262 = ".toString();" + NL + "        buf_";
  protected final String TEXT_263 = " = new StringBuffer();";
  protected final String TEXT_264 = NL + "\t\tout_";
  protected final String TEXT_265 = ".write(buf_";
  protected final String TEXT_266 = ".toString());" + NL + "        buf_";
  protected final String TEXT_267 = " = new StringBuffer();";
  protected final String TEXT_268 = NL + "\t\tif( false";
  protected final String TEXT_269 = " || valueMap_";
  protected final String TEXT_270 = ".get(\"";
  protected final String TEXT_271 = "\") != null";
  protected final String TEXT_272 = " || true " + NL + "                    \t";
  protected final String TEXT_273 = NL + "\t\t){";
  protected final String TEXT_274 = NL + "\t\t}";
  protected final String TEXT_275 = NL + "\t\tbuf_";
  protected final String TEXT_276 = ".append(\"";
  protected final String TEXT_277 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_278 = ".append(\"";
  protected final String TEXT_279 = "<";
  protected final String TEXT_280 = "\");";
  protected final String TEXT_281 = NL + "\t\tbuf_";
  protected final String TEXT_282 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_283 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+ file_";
  protected final String TEXT_284 = ".substring(file_";
  protected final String TEXT_285 = ".lastIndexOf(\"/\")+1)+\".xsd\"+\"\\\"\");";
  protected final String TEXT_286 = NL + "\t\tif(";
  protected final String TEXT_287 = " == null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_288 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_289 = NL + "\t\tbuf_";
  protected final String TEXT_290 = ".append(\">\");";
  protected final String TEXT_291 = NL + "\t\tbuf_";
  protected final String TEXT_292 = ".append(\"";
  protected final String TEXT_293 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_294 = ".append(\"";
  protected final String TEXT_295 = "</";
  protected final String TEXT_296 = ">\");";
  protected final String TEXT_297 = NL + "\t\tbuf_";
  protected final String TEXT_298 = ".append(\"</";
  protected final String TEXT_299 = ">\");";
  protected final String TEXT_300 = NL + "\t\tif(";
  protected final String TEXT_301 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_302 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_303 = "));" + NL + "\t\t}";
  protected final String TEXT_304 = NL + "\t\tif(";
  protected final String TEXT_305 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_306 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_307 = "));" + NL + "\t\t}";
  protected final String TEXT_308 = NL + "\t\tbuf_";
  protected final String TEXT_309 = ".append(TalendString.checkCDATAForXML(\"";
  protected final String TEXT_310 = "\"));";
  protected final String TEXT_311 = NL + "\t\t  if (";
  protected final String TEXT_312 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_313 = ".append(\" ";
  protected final String TEXT_314 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_315 = ")+\"\\\"\");" + NL + "\t\t  } ";
  protected final String TEXT_316 = " else{" + NL + "\t\t    buf_";
  protected final String TEXT_317 = ".append(\" ";
  protected final String TEXT_318 = "=\\\"\\\"\");" + NL + "\t\t  }";
  protected final String TEXT_319 = NL + "\t\t    buf_";
  protected final String TEXT_320 = ".append(\" ";
  protected final String TEXT_321 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_322 = "\")+\"\\\"\");";
  protected final String TEXT_323 = NL + "\t\t    buf_";
  protected final String TEXT_324 = ".append(\" ";
  protected final String TEXT_325 = "=\\\"\\\"\");" + NL + "\t\t  ";
  protected final String TEXT_326 = NL + "\t\tif(";
  protected final String TEXT_327 = "!=null){";
  protected final String TEXT_328 = NL + "        \tbuf_";
  protected final String TEXT_329 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_330 = ")+\"\\\"\");";
  protected final String TEXT_331 = NL + "\t\t\tbuf_";
  protected final String TEXT_332 = ".append(\" xmlns:";
  protected final String TEXT_333 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_334 = ")+\"\\\"\");";
  protected final String TEXT_335 = NL + "\t\t}";
  protected final String TEXT_336 = NL + "        \tbuf_";
  protected final String TEXT_337 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_338 = "\")+\"\\\"\");";
  protected final String TEXT_339 = NL + "\t\t\tbuf_";
  protected final String TEXT_340 = ".append(\" xmlns:";
  protected final String TEXT_341 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_342 = "\")+\"\\\"\");";
  protected final String TEXT_343 = NL + "\tnb_line_";
  protected final String TEXT_344 = "++;" + NL + "\tvalueMap_";
  protected final String TEXT_345 = ".clear();";
  protected final String TEXT_346 = NL + "\tvalueMap_";
  protected final String TEXT_347 = ".put(\"";
  protected final String TEXT_348 = "\", ";
  protected final String TEXT_349 = ");";
  protected final String TEXT_350 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_351 = " = null;" + NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_352 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_353 = "=false;" + NL + "\t\tif(orders_";
  protected final String TEXT_354 = ".length>0){" + NL + "\t\t\torders_";
  protected final String TEXT_355 = "[0] = 0;" + NL + "\t\t}";
  protected final String TEXT_356 = NL + "\t\troot4Group_";
  protected final String TEXT_357 = " = subTreeRootParent_";
  protected final String TEXT_358 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_359 = "=root4Group_";
  protected final String TEXT_360 = ";" + NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_361 = NL + "\t}";
  protected final String TEXT_362 = NL + "\t\t" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_363 = "=(org.dom4j.Element)doc_";
  protected final String TEXT_364 = ".selectSingleNode(\"";
  protected final String TEXT_365 = "\");" + NL + "\t\t" + NL + "\t\tif(subTreeRootParent_";
  protected final String TEXT_366 = "==null){" + NL + "\t\t\tsubTreeRootParent_";
  protected final String TEXT_367 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_368 = ".selectSingleNode(\"";
  protected final String TEXT_369 = "\");" + NL + "\t\t}else{" + NL + "\t\t\tsubTreeRootParent_";
  protected final String TEXT_370 = " =subTreeRootParent_";
  protected final String TEXT_371 = ".getParent();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tboolean bl_";
  protected final String TEXT_372 = "= false;//true:find the insert node;false:not";
  protected final String TEXT_373 = NL + "\t\tif(bl_";
  protected final String TEXT_374 = "==false){" + NL + "\t\t\tjava.util.List<org.dom4j.Element> listNodes= subTreeRootParent_";
  protected final String TEXT_375 = ".elements();" + NL + "\t\t\tif(listNodes!=null && listNodes.size()>0){" + NL + "\t\t\t\tint j=0;" + NL + "\t\t\t\tfor(j=0;j<listNodes.size();j++){" + NL + "\t\t\t\t\torg.dom4j.Element tempElem =listNodes.get(j);" + NL + "\t\t\t\t\tif((\"";
  protected final String TEXT_376 = "\").equals(tempElem.getPath())){" + NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_377 = "){" + NL + "\t\t\t\t\t\t\tsubTreeRootParent_";
  protected final String TEXT_378 = " =  tempElem;" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(j>=listNodes.size()){" + NL + "\t\t\t\t\tbl_";
  protected final String TEXT_379 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\tbl_";
  protected final String TEXT_380 = "=true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(bl_";
  protected final String TEXT_381 = "==true){";
  protected final String TEXT_382 = NL + "\t\t}";
  protected final String TEXT_383 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_384 = " = false;";
  protected final String TEXT_385 = NL + "\tif(isNewElememt_";
  protected final String TEXT_386 = " || groupbyList_";
  protected final String TEXT_387 = ".size()<=";
  protected final String TEXT_388 = " || groupbyList_";
  protected final String TEXT_389 = ".get(";
  protected final String TEXT_390 = ")==null";
  protected final String TEXT_391 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_392 = ".get(";
  protected final String TEXT_393 = ").get(";
  protected final String TEXT_394 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_395 = ".get(";
  protected final String TEXT_396 = ").get(";
  protected final String TEXT_397 = ").equals(";
  protected final String TEXT_398 = ") " + NL + "\t\t: ";
  protected final String TEXT_399 = "!=null )";
  protected final String TEXT_400 = NL + "\t){";
  protected final String TEXT_401 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_402 = ".size()<=";
  protected final String TEXT_403 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_404 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_405 = ".get(";
  protected final String TEXT_406 = ").clear();" + NL + "        }";
  protected final String TEXT_407 = NL + "\t\tgroupbyList_";
  protected final String TEXT_408 = ".get(";
  protected final String TEXT_409 = ").add(";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "        isNewElememt_";
  protected final String TEXT_412 = "=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_413 = ".size()<=";
  protected final String TEXT_414 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_415 = ".add(group";
  protected final String TEXT_416 = "__";
  protected final String TEXT_417 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_418 = ".set(";
  protected final String TEXT_419 = ",group";
  protected final String TEXT_420 = "__";
  protected final String TEXT_421 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_422 = "=groupElementList_";
  protected final String TEXT_423 = ".get(";
  protected final String TEXT_424 = ");" + NL + "\t}" + NL;
  protected final String TEXT_425 = NL + "\t// build loop xml tree";
  protected final String TEXT_426 = NL + "    currentRowCount_";
  protected final String TEXT_427 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_428 = " == ";
  protected final String TEXT_429 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_430 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_431 = " = file_";
  protected final String TEXT_432 = " + currentFileCount_";
  protected final String TEXT_433 = " + suffix_";
  protected final String TEXT_434 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_435 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_436 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_437 = ".clear();" + NL + "" + NL + "    \tjava.io.FileOutputStream stream_";
  protected final String TEXT_438 = " = new java.io.FileOutputStream(fileName_";
  protected final String TEXT_439 = ");" + NL + "        org.dom4j.io.XMLWriter output_";
  protected final String TEXT_440 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_441 = ", format_";
  protected final String TEXT_442 = ");";
  protected final String TEXT_443 = NL + "\t\tdoc_";
  protected final String TEXT_444 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", file_";
  protected final String TEXT_445 = ".substring(file_";
  protected final String TEXT_446 = ".lastIndexOf(\"/\")+1)+\".xsd\");" + NL + "        doc_";
  protected final String TEXT_447 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_448 = "        " + NL + "        nestXMLTool_";
  protected final String TEXT_449 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_450 = ".getRootElement());";
  protected final String TEXT_451 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_452 = ".removeEmptyElement(doc_";
  protected final String TEXT_453 = ".getRootElement());";
  protected final String TEXT_454 = NL + "        output_";
  protected final String TEXT_455 = ".write(doc_";
  protected final String TEXT_456 = ");" + NL + "        output_";
  protected final String TEXT_457 = ".close();" + NL + "        doc_";
  protected final String TEXT_458 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "    \tgroupElementList_";
  protected final String TEXT_459 = ".clear();" + NL + "    }";
  protected final String TEXT_460 = NL + "\tStringBuffer buf_";
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
  protected final String TEXT_478 = NL + "\tboolean isNewElememt_";
  protected final String TEXT_479 = " = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_480 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_481 = " = new String[";
  protected final String TEXT_482 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_483 = " = new String[";
  protected final String TEXT_484 = "];";
  protected final String TEXT_485 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_486 = " or not" + NL + "\tif(isNewElememt_";
  protected final String TEXT_487 = " || groupbyList_";
  protected final String TEXT_488 = ".size()<=";
  protected final String TEXT_489 = " || groupbyList_";
  protected final String TEXT_490 = ".get(";
  protected final String TEXT_491 = ")==null";
  protected final String TEXT_492 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_493 = ".get(";
  protected final String TEXT_494 = ").get(";
  protected final String TEXT_495 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_496 = ".get(";
  protected final String TEXT_497 = ").get(";
  protected final String TEXT_498 = ").equals(";
  protected final String TEXT_499 = ") " + NL + "\t\t: ";
  protected final String TEXT_500 = "!=null )";
  protected final String TEXT_501 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(isNewElememt_";
  protected final String TEXT_502 = " == false && groupbyList_";
  protected final String TEXT_503 = ".size()>";
  protected final String TEXT_504 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_505 = " = ";
  protected final String TEXT_506 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_507 = ".size()<=";
  protected final String TEXT_508 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_509 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_510 = ".get(";
  protected final String TEXT_511 = ").clear();" + NL + "        }";
  protected final String TEXT_512 = NL + "\t\tgroupbyList_";
  protected final String TEXT_513 = ".get(";
  protected final String TEXT_514 = ").add(";
  protected final String TEXT_515 = ");";
  protected final String TEXT_516 = NL + "        isNewElememt_";
  protected final String TEXT_517 = "=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_518 = NL + "\tif( false";
  protected final String TEXT_519 = " || valueMap_";
  protected final String TEXT_520 = ".get(\"";
  protected final String TEXT_521 = "\") != null";
  protected final String TEXT_522 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_523 = " = ";
  protected final String TEXT_524 = ";" + NL + "\t}";
  protected final String TEXT_525 = NL + "\t// buffer the end tabs to groupEnd buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_526 = "[";
  protected final String TEXT_527 = "] = buf_";
  protected final String TEXT_528 = ".toString();" + NL + "    buf_";
  protected final String TEXT_529 = " = new StringBuffer();";
  protected final String TEXT_530 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_531 = " >= 0) {" + NL + "        //out_";
  protected final String TEXT_532 = ".newLine();//Track code";
  protected final String TEXT_533 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_534 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_535 = " = 0; i_";
  protected final String TEXT_536 = " < startTabs_";
  protected final String TEXT_537 = ".length; i_";
  protected final String TEXT_538 = "++) {" + NL + "                if (i_";
  protected final String TEXT_539 = " <= preUnNullMaxIndex_";
  protected final String TEXT_540 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_541 = "[i_";
  protected final String TEXT_542 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_543 = ".write(startTabs_";
  protected final String TEXT_544 = "[i_";
  protected final String TEXT_545 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_546 = "[i_";
  protected final String TEXT_547 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_548 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_549 = " = 0; i_";
  protected final String TEXT_550 = " < startTabs_";
  protected final String TEXT_551 = ".length; i_";
  protected final String TEXT_552 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_553 = "[i_";
  protected final String TEXT_554 = "] != null) {" + NL + "                out_";
  protected final String TEXT_555 = ".write(startTabs_";
  protected final String TEXT_556 = "[i_";
  protected final String TEXT_557 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_558 = "[i_";
  protected final String TEXT_559 = "] = null;" + NL + "        }";
  protected final String TEXT_560 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_561 = " >= preNewTabIndex_";
  protected final String TEXT_562 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_563 = " >= ";
  protected final String TEXT_564 = " + newTabIndex_";
  protected final String TEXT_565 = ") {" + NL + "            for (int i_";
  protected final String TEXT_566 = " = preUnNullMaxIndex_";
  protected final String TEXT_567 = "; i_";
  protected final String TEXT_568 = " >= ";
  protected final String TEXT_569 = " + newTabIndex_";
  protected final String TEXT_570 = "; i_";
  protected final String TEXT_571 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_572 = "[i_";
  protected final String TEXT_573 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_574 = ".write(endTabs_";
  protected final String TEXT_575 = "[i_";
  protected final String TEXT_576 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_577 = "[i_";
  protected final String TEXT_578 = "] = null;";
  protected final String TEXT_579 = "out_";
  protected final String TEXT_580 = ".newLine(); ";
  protected final String TEXT_581 = NL + "                out_";
  protected final String TEXT_582 = ".write(endTabStrs_";
  protected final String TEXT_583 = NL + "                        .get(i_";
  protected final String TEXT_584 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_585 = NL + "            for (int i_";
  protected final String TEXT_586 = " = preNewTabIndex_";
  protected final String TEXT_587 = " - 1; i_";
  protected final String TEXT_588 = " >= ";
  protected final String TEXT_589 = " + newTabIndex_";
  protected final String TEXT_590 = "; i_";
  protected final String TEXT_591 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_592 = "[i_";
  protected final String TEXT_593 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_594 = ".write(endTabs_";
  protected final String TEXT_595 = "[i_";
  protected final String TEXT_596 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_597 = "[i_";
  protected final String TEXT_598 = "] = null;" + NL + "            \t";
  protected final String TEXT_599 = "out_";
  protected final String TEXT_600 = ".newLine(); ";
  protected final String TEXT_601 = NL + "                out_";
  protected final String TEXT_602 = ".write(endTabStrs_";
  protected final String TEXT_603 = NL + "                        .get(i_";
  protected final String TEXT_604 = "));" + NL + "            }";
  protected final String TEXT_605 = NL + "        }";
  protected final String TEXT_606 = NL + "        preNewTabIndex_";
  protected final String TEXT_607 = " = newTabIndex_";
  protected final String TEXT_608 = " + ";
  protected final String TEXT_609 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_610 = " = 0; i_";
  protected final String TEXT_611 = " < groupBuffer_";
  protected final String TEXT_612 = ".length; i_";
  protected final String TEXT_613 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_614 = " >= preNewTabIndex_";
  protected final String TEXT_615 = " - ";
  protected final String TEXT_616 = ") {" + NL + "            startTabs_";
  protected final String TEXT_617 = "[i_";
  protected final String TEXT_618 = " + ";
  protected final String TEXT_619 = "] = groupBuffer_";
  protected final String TEXT_620 = "[i_";
  protected final String TEXT_621 = "];" + NL + "            endTabs_";
  protected final String TEXT_622 = "[i_";
  protected final String TEXT_623 = " + ";
  protected final String TEXT_624 = "] = groupEndBuffer_";
  protected final String TEXT_625 = "[i_";
  protected final String TEXT_626 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_627 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_628 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_629 = "=unNullMaxIndex_";
  protected final String TEXT_630 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_631 = ">";
  protected final String TEXT_632 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_633 = "=";
  protected final String TEXT_634 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_635 = NL + "\t// build loop xml tree";
  protected final String TEXT_636 = NL + "\t\tif( false";
  protected final String TEXT_637 = " || valueMap_";
  protected final String TEXT_638 = ".get(\"";
  protected final String TEXT_639 = "\") != null";
  protected final String TEXT_640 = " || true " + NL + "    \t";
  protected final String TEXT_641 = NL + "\t\t){";
  protected final String TEXT_642 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_643 = " = 0; i_";
  protected final String TEXT_644 = " < startTabs_";
  protected final String TEXT_645 = ".length; i_";
  protected final String TEXT_646 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_647 = "[i_";
  protected final String TEXT_648 = "] != null && startTabs_";
  protected final String TEXT_649 = "[i_";
  protected final String TEXT_650 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_651 = ".write(startTabs_";
  protected final String TEXT_652 = "[i_";
  protected final String TEXT_653 = "]);" + NL + "                startTabs_";
  protected final String TEXT_654 = "[i_";
  protected final String TEXT_655 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_656 = ".write(buf_";
  protected final String TEXT_657 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_658 = " = ";
  protected final String TEXT_659 = ";";
  protected final String TEXT_660 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_661 = " = ";
  protected final String TEXT_662 = ";" + NL + "\t\t}";
  protected final String TEXT_663 = NL + "    currentRowCount_";
  protected final String TEXT_664 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_665 = " == ";
  protected final String TEXT_666 = "){" + NL + "    \tneedRoot_";
  protected final String TEXT_667 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_668 = " = file_";
  protected final String TEXT_669 = " + currentFileCount_";
  protected final String TEXT_670 = " + suffix_";
  protected final String TEXT_671 = ";" + NL + "        currentRowCount_";
  protected final String TEXT_672 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_673 = "++;" + NL + "    \tgroupbyList_";
  protected final String TEXT_674 = ".clear();" + NL + " ";
  protected final String TEXT_675 = "   \t" + NL + "\tif (preUnNullMaxIndex_";
  protected final String TEXT_676 = " >= 0) {" + NL + "        // output all buffer" + NL + "        for (int j_";
  protected final String TEXT_677 = " = 0; j_";
  protected final String TEXT_678 = " <= preUnNullMaxIndex_";
  protected final String TEXT_679 = "; j_";
  protected final String TEXT_680 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_681 = "[j_";
  protected final String TEXT_682 = "] != null)" + NL + "                out_";
  protected final String TEXT_683 = ".write(startTabs_";
  protected final String TEXT_684 = "[j_";
  protected final String TEXT_685 = "]);" + NL + "        }" + NL + "" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_686 = " < preNewTabIndex_";
  protected final String TEXT_687 = " ) {" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_688 = " = preNewTabIndex_";
  protected final String TEXT_689 = " - 1; i_";
  protected final String TEXT_690 = " >= 0; i_";
  protected final String TEXT_691 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_692 = "[i_";
  protected final String TEXT_693 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_694 = ".write(endTabs_";
  protected final String TEXT_695 = "[i_";
  protected final String TEXT_696 = "]);" + NL + "            \t}";
  protected final String TEXT_697 = "out_";
  protected final String TEXT_698 = ".newLine(); ";
  protected final String TEXT_699 = NL + "                out_";
  protected final String TEXT_700 = ".write(endTabStrs_";
  protected final String TEXT_701 = ".get(i_";
  protected final String TEXT_702 = "));" + NL + "            }" + NL + "        } else {" + NL + "            for (int i_";
  protected final String TEXT_703 = " = preUnNullMaxIndex_";
  protected final String TEXT_704 = "; i_";
  protected final String TEXT_705 = " >= 0; i_";
  protected final String TEXT_706 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_707 = "[i_";
  protected final String TEXT_708 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_709 = ".write(endTabs_";
  protected final String TEXT_710 = "[i_";
  protected final String TEXT_711 = "]);" + NL + "            \t}";
  protected final String TEXT_712 = "out_";
  protected final String TEXT_713 = ".newLine(); ";
  protected final String TEXT_714 = NL + "                out_";
  protected final String TEXT_715 = ".write(endTabStrs_";
  protected final String TEXT_716 = ".get(i_";
  protected final String TEXT_717 = "));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_718 = NL + "\tfor (int i_";
  protected final String TEXT_719 = " = endTabStrs_";
  protected final String TEXT_720 = ".size() - 1; i_";
  protected final String TEXT_721 = " >= 0; i_";
  protected final String TEXT_722 = "--) {" + NL + "    \tif(endTabs_";
  protected final String TEXT_723 = "[i_";
  protected final String TEXT_724 = "]!=null){" + NL + "    \t\tout_";
  protected final String TEXT_725 = ".write(endTabs_";
  protected final String TEXT_726 = "[i_";
  protected final String TEXT_727 = "]);" + NL + "    \t}";
  protected final String TEXT_728 = "out_";
  protected final String TEXT_729 = ".newLine(); ";
  protected final String TEXT_730 = NL + "        out_";
  protected final String TEXT_731 = ".write(endTabStrs_";
  protected final String TEXT_732 = ".get(i_";
  protected final String TEXT_733 = "));" + NL + "    }";
  protected final String TEXT_734 = NL + "\t    preUnNullMaxIndex_";
  protected final String TEXT_735 = " = -1;" + NL + "        preNewTabIndex_";
  protected final String TEXT_736 = " = -1;" + NL + "    \tstartTabs_";
  protected final String TEXT_737 = " = new String[endTabStrs_";
  protected final String TEXT_738 = ".size()];" + NL + "    \tendTabs_";
  protected final String TEXT_739 = " = new String[endTabStrs_";
  protected final String TEXT_740 = ".size()];" + NL + "    \t" + NL + "\t\tout_";
  protected final String TEXT_741 = ".close();" + NL + "\t\tout_";
  protected final String TEXT_742 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_743 = " + currentFileCount_";
  protected final String TEXT_744 = " + suffix_";
  protected final String TEXT_745 = "), ";
  protected final String TEXT_746 = "));" + NL + "        out_";
  protected final String TEXT_747 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_748 = "+\"\\\"?>\");" + NL + "        out_";
  protected final String TEXT_749 = ".newLine();" + NL + "\t}";
  protected final String TEXT_750 = NL;

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
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_3);
    
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

    stringBuffer.append(TEXT_4);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_7);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_11);
    
    		} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_16);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_23);
    
            }else{

    stringBuffer.append(TEXT_24);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_27);
    
        }else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_31);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_32);
    
			}
		}

    stringBuffer.append(TEXT_33);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	boolean isAppend = false;
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

    stringBuffer.append(TEXT_34);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_37);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(isAppend && !outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_62);
    
			}else{

    stringBuffer.append(TEXT_63);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_66);
    
			}
			if(isAppend){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
				if(currPos==0){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
				}else{

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
				}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
			}else{

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
			}
		}else{
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_122);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_138);
    
			}else{

    stringBuffer.append(TEXT_139);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_144);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_149);
    tool.getValue(node); 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    tool.getValue(node);
    stringBuffer.append(TEXT_154);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
				}
			}else{
				if("id_Document".equals(node.relatedColumn.getTalendType())) {

    stringBuffer.append(TEXT_161);
    tool.getValue(node); 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    tool.getValue(node);
    stringBuffer.append(TEXT_166);
    
				} else {

    stringBuffer.append(TEXT_167);
    tool.getValue(node); 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    tool.getValue(node);
    stringBuffer.append(TEXT_172);
    
				}
				if(outputAsXSD){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_182);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_183);
    tool.getValue(node);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_187);
    tool.getValue(node);
    stringBuffer.append(TEXT_188);
     if (bAddEmptyAttr) { 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_192);
    }
		} else { 
		  if (node.defaultValue != null && !("").equals(node.defaultValue) ){
          
    stringBuffer.append(TEXT_193);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_197);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_198);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_201);
    
		  }
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_202);
    tool.getValue(node);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_206);
    tool.getValue(node);
    stringBuffer.append(TEXT_207);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_208);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    tool.getValue(node);
    stringBuffer.append(TEXT_213);
    
			}

    stringBuffer.append(TEXT_214);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_215);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_219);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_220);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_225);
    
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

    stringBuffer.append(TEXT_226);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_227);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_228);
    tool.getValue(node); 
    stringBuffer.append(TEXT_229);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_230);
    			}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_231);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_232);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_233);
    tool.getValue(node); 
    stringBuffer.append(TEXT_234);
    if(!needEmptyNode){
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_237);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_238);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_239);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_241);
    					}
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_243);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_245);
    generateCmnExpr(arrNames, parentName); 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_247);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_248);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_249);
    }

    stringBuffer.append(TEXT_250);
    
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

    stringBuffer.append(TEXT_251);
    stringBuffer.append(parentName );
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){

    stringBuffer.append(TEXT_252);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_253);
    
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

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
						}else{

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty 
						&& (child.relatedColumn != null || child.childrenColumnList.size()>0
							 || child.hasDefaultValue == true ) ){

    stringBuffer.append(TEXT_268);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_271);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_272);
    }
    stringBuffer.append(TEXT_273);
    
						if(isCompact==false)
							generateCode(child,emptySpace+"  ");
						else
							generateCode(child,emptySpace);

    stringBuffer.append(TEXT_274);
    
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

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_280);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_286);
    tool.getValue(node); 
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
		}

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_296);
    
		}else{

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_299);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_300);
    tool.getValue(node);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    tool.getValue(node);
    stringBuffer.append(TEXT_303);
    
			}else{

    stringBuffer.append(TEXT_304);
    tool.getValue(node);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    tool.getValue(node);
    stringBuffer.append(TEXT_307);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_310);
    
		}
	}
	private void addAttribute(XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_311);
    tool.getValue(node); 
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_314);
    tool.getValue(node);
    stringBuffer.append(TEXT_315);
     if (bAddEmptyAttr){
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_318);
    }
		} else {
		  if (node.defaultValue != null && !("").equals(node.defaultValue)){
          
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_322);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_325);
    
		  }
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_326);
    tool.getValue(node);
    stringBuffer.append(TEXT_327);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    tool.getValue(node);
    stringBuffer.append(TEXT_330);
    
			}else{

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_333);
    tool.getValue(node);
    stringBuffer.append(TEXT_334);
    
			}

    stringBuffer.append(TEXT_335);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_338);
    
			}else{

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_342);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
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
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = conn.getName();
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

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
				for(IMetadataColumn column :metadata.getListColumns()){

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_348);
     tool.getValue(column); 
    stringBuffer.append(TEXT_349);
    
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
    generateToolByDom4j.tool = tool;
    
    //start generate code

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
     
	generateToolByDom4j.generateCode(root,"root","doc");
	if(isMerge==false || useStream){ // add a prerequisite useStream to ignore the append mode

    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
	}else{

    stringBuffer.append(TEXT_361);
    
	}
	
if(groupTable.size()>0){					//init the generate tool.
	if(!useStream && isMerge==true){//merge into the file and add a prerequisite:useStream to ignore the append mode
		generateToolByDom4j.isAppend= true;
	    String firstGroupPath = groupList.get(0).path;

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(firstGroupPath );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(firstGroupPath.substring(0,firstGroupPath.lastIndexOf("/")) );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    
		for( int i=0; i<groupList.size();i++){
			XMLNode groupNode= groupList.get(i);
			GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
			generateExprCmpByDom4j.tool = tool;
			generateExprCmpByDom4j.groupNode = groupNode;
			generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(groupNode.path);
    stringBuffer.append(TEXT_376);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
     
			generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_382);
    
 		}//for
 	}else{//last group code

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
     
		for(int i=0;i<groupList.size();i++){
			XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_390);
     
			for(int j=0;j<groupbyNodeList.get(i).size();j++){
				XMLNode attr = groupbyNodeList.get(i).get(j);
				if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_397);
    tool.getValue(attr);
    stringBuffer.append(TEXT_398);
    tool.getValue(attr);
    stringBuffer.append(TEXT_399);
     
				}
			}

    stringBuffer.append(TEXT_400);
     
			generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_406);
     
			for(int j=0;j<groupbyNodeList.get(i).size();j++){
				XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_409);
    tool.getValue(attr);
    stringBuffer.append(TEXT_410);
     
			}

    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_424);
    
		}//for
 	}//if merge=true 	
}


    stringBuffer.append(TEXT_425);
    
	if(loopTable!=null && loopTable.size()>0){
		generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
	}
	//file split
	if(!useStream && ("true").equals(split)){ //add a prerequisite:useStream to ignore the append mode

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    
		}

    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    
		if(!("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    
		}

    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
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
	for(int i=0;i < mainList.size();i++){
		generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		if(isCompact==false){//generate pretty file
			rootEmptySpace+="  ";
		}
		
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_484);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_485);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_491);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_498);
    tool.getValue(attr);
    stringBuffer.append(TEXT_499);
    tool.getValue(attr);
    stringBuffer.append(TEXT_500);
    
			}
		}

    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_511);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_514);
    tool.getValue(attr);
    stringBuffer.append(TEXT_515);
    
		}

    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    
		String emptySpace = "";
		
		if(isCompact==false){//generate pretty file
			for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
				emptySpace +="  ";
			}
		}
		
		generateToolByNull.generateCode(groupList.get(i),emptySpace);
		
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_518);
    
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
            		
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_521);
    
            	}

    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_524);
    
			}
		}

    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    
		}else{

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    if(isCompact==false){
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    }
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    
		}

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    if(isCompact==false){
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    }
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_605);
    
		}

    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
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
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_634);
    
	}

    stringBuffer.append(TEXT_635);
    
	String emptySpace = "";
	if(isCompact==false){//generate pretty file
		for(int len =loop.path.split("/").length-1;len>1;len--){
			emptySpace +="  ";
		}
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_636);
    
    	for(IMetadataColumn column : loop.childrenColumnList){
    		
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_639);
    
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_640);
    }
    stringBuffer.append(TEXT_641);
    
	}
	generateToolByNull.generateCode(loop,emptySpace);
	generateToolByNull.endElement(loop,emptySpace);

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_659);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_662);
    
	}
	
	//file split 
	if(!useStream && ("true").equals(split)){ // add a new prerequisite:useStream to ignore the split condition

    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    if(isCompact==false){
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    }
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    if(isCompact==false){
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    }
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    if(isCompact==false){
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    }
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    
			}
		}

    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_745);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_750);
    return stringBuffer.toString();
  }
}
