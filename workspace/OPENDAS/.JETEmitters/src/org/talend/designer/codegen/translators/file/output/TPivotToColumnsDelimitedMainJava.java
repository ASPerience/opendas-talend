package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedMainJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedMainJava result = new TPivotToColumnsDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "                   " + NL + "    //pivot key  " + NL + "    pivot_Keys_Split";
  protected final String TEXT_3 = " = pivot_Keys";
  protected final String TEXT_4 = ".split(";
  protected final String TEXT_5 = ");" + NL + "    " + NL + "    pivot_Exists";
  protected final String TEXT_6 = " = false;" + NL + "    " + NL + "    int pivotNum";
  protected final String TEXT_7 = " = 0;" + NL + "    " + NL + "    for(int i = 0;i<pivot_Keys_Split";
  protected final String TEXT_8 = ".length;i++){" + NL + "        " + NL + "        if(pivot_Keys_Split";
  protected final String TEXT_9 = "[i].equals(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ")){" + NL + "            " + NL + "            pivot_Exists";
  protected final String TEXT_12 = " = true;" + NL + "            " + NL + "            pivotNum";
  protected final String TEXT_13 = " = i + 1;" + NL + "            " + NL + "            break;" + NL + "            " + NL + "        }" + NL + "        " + NL + "    }" + NL + "    " + NL + "    if(!pivot_Exists";
  protected final String TEXT_14 = "){" + NL + "        " + NL + "        pivot_Key";
  protected final String TEXT_15 = ".delete(0, pivot_Key";
  protected final String TEXT_16 = ".length());" + NL + "        " + NL + "        pivot_Keys";
  protected final String TEXT_17 = " = pivot_Keys";
  protected final String TEXT_18 = " + pivot_Key";
  protected final String TEXT_19 = ".append(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ").toString() + ";
  protected final String TEXT_22 = ";" + NL + "        " + NL + "        pivot_Keys_Split";
  protected final String TEXT_23 = " = pivot_Keys";
  protected final String TEXT_24 = ".split(";
  protected final String TEXT_25 = ");" + NL + "        " + NL + "        pivotNum";
  protected final String TEXT_26 = " = pivot_Keys_Split";
  protected final String TEXT_27 = ".length;" + NL + "        " + NL + "    }" + NL + "" + NL + "    " + NL + "    //group key" + NL + "" + NL + "    group_Keys_Split";
  protected final String TEXT_28 = " = group_Keys";
  protected final String TEXT_29 = ".split(";
  protected final String TEXT_30 = ");" + NL + "    " + NL + "    group_Exists";
  protected final String TEXT_31 = " = false;" + NL + "    " + NL + "    gKvalue";
  protected final String TEXT_32 = " = \"\";" + NL + "    " + NL + "    group_Key";
  protected final String TEXT_33 = ".delete(0,group_Key";
  protected final String TEXT_34 = ".length());" + NL + "        ";
  protected final String TEXT_35 = NL + NL + "        gKvalue";
  protected final String TEXT_36 = " = gKvalue";
  protected final String TEXT_37 = " + group_Key";
  protected final String TEXT_38 = ".append(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ").toString()";
  protected final String TEXT_41 = "+";
  protected final String TEXT_42 = "; " + NL + "        " + NL + "        group_Key";
  protected final String TEXT_43 = ".delete(0,group_Key";
  protected final String TEXT_44 = ".length());";
  protected final String TEXT_45 = NL + "    " + NL + "    for(int i = 0;i<group_Keys_Split";
  protected final String TEXT_46 = ".length;i++){" + NL + "    " + NL + "        if(group_Keys_Split";
  protected final String TEXT_47 = "[i].equals(gKvalue";
  protected final String TEXT_48 = ")){" + NL + "            " + NL + "            group_Exists";
  protected final String TEXT_49 = " = true;" + NL + "            " + NL + "            break;" + NL + "            " + NL + "        }" + NL + "        " + NL + "    }" + NL + "" + NL + "    if(!group_Exists";
  protected final String TEXT_50 = "){" + NL + "        " + NL + "        group_Key";
  protected final String TEXT_51 = ".delete(0, group_Key";
  protected final String TEXT_52 = ".length());" + NL + "        " + NL + "        group_Keys";
  protected final String TEXT_53 = " = group_Keys";
  protected final String TEXT_54 = " + gKvalue";
  protected final String TEXT_55 = " + ";
  protected final String TEXT_56 = ";" + NL + "        " + NL + "        group_Keys_Split";
  protected final String TEXT_57 = " = group_Keys";
  protected final String TEXT_58 = ".split(";
  protected final String TEXT_59 = ");" + NL + "    " + NL + "        aggValues";
  protected final String TEXT_60 = ".delete(0, aggValues";
  protected final String TEXT_61 = ".length());" + NL + "        " + NL + "        for(int i = 0; i<pivotNum";
  protected final String TEXT_62 = "-1; i++)" + NL + "            " + NL + "            aggValues";
  protected final String TEXT_63 = ".append(";
  protected final String TEXT_64 = ");" + NL + "        ";
  protected final String TEXT_65 = NL + NL + "        aggregation";
  protected final String TEXT_66 = ".put(gKvalue";
  protected final String TEXT_67 = ",aggValues";
  protected final String TEXT_68 = ".append(1).append(";
  protected final String TEXT_69 = ").toString());" + NL;
  protected final String TEXT_70 = NL + "        " + NL + "        aggregation";
  protected final String TEXT_71 = ".put(gKvalue";
  protected final String TEXT_72 = ",aggValues";
  protected final String TEXT_73 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = "),";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = ")).append(";
  protected final String TEXT_78 = ").toString());" + NL + "  ";
  protected final String TEXT_79 = NL + "\t\t" + NL + "        aggregation";
  protected final String TEXT_80 = ".put(gKvalue";
  protected final String TEXT_81 = ",aggValues";
  protected final String TEXT_82 = ".append(";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = ").append(";
  protected final String TEXT_85 = ").toString());" + NL;
  protected final String TEXT_86 = NL + "    }else{" + NL + "" + NL + "        String aggStr";
  protected final String TEXT_87 = " = (String)aggregation";
  protected final String TEXT_88 = ".get(gKvalue";
  protected final String TEXT_89 = ");" + NL + "        " + NL + "        String[] aggStrSpli";
  protected final String TEXT_90 = " = aggStr";
  protected final String TEXT_91 = ".split(";
  protected final String TEXT_92 = ");" + NL + "        " + NL + "        if(aggStrSpli";
  protected final String TEXT_93 = ".length < pivotNum";
  protected final String TEXT_94 = "){" + NL + "            " + NL + "" + NL + "    \t\tfor(int i = 0 ; i<pivotNum";
  protected final String TEXT_95 = " - aggStrSpli";
  protected final String TEXT_96 = ".length-1; i++){" + NL + "                    " + NL + "                aggStr";
  protected final String TEXT_97 = " = aggStr";
  protected final String TEXT_98 = " + ";
  protected final String TEXT_99 = ";" + NL + "            " + NL + "            }    " + NL + "               " + NL + "            aggValues";
  protected final String TEXT_100 = ".delete(0,aggValues";
  protected final String TEXT_101 = ".length());" + NL + "            ";
  protected final String TEXT_102 = NL + NL + "            aggStr";
  protected final String TEXT_103 = " = aggStr";
  protected final String TEXT_104 = " + aggValues";
  protected final String TEXT_105 = ".append(1).toString() + ";
  protected final String TEXT_106 = ";" + NL;
  protected final String TEXT_107 = NL + "            " + NL + "            aggStr";
  protected final String TEXT_108 = " = aggStr";
  protected final String TEXT_109 = " + aggValues";
  protected final String TEXT_110 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = "),";
  protected final String TEXT_113 = ",";
  protected final String TEXT_114 = ")).toString() + ";
  protected final String TEXT_115 = ";" + NL;
  protected final String TEXT_116 = NL + "\t" + NL + "            aggStr";
  protected final String TEXT_117 = " = aggStr";
  protected final String TEXT_118 = " + aggValues";
  protected final String TEXT_119 = ".append(";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ").toString() + ";
  protected final String TEXT_122 = ";" + NL + "\t";
  protected final String TEXT_123 = NL + "  " + NL + "            aggregation";
  protected final String TEXT_124 = ".remove(gKvalue";
  protected final String TEXT_125 = ");" + NL + "            " + NL + "            aggregation";
  protected final String TEXT_126 = ".put(gKvalue";
  protected final String TEXT_127 = ",aggStr";
  protected final String TEXT_128 = ");" + NL + "" + NL + "        }else{" + NL + "            " + NL + "            //step1: get the index of the pivot" + NL + "            int pivotIndex";
  protected final String TEXT_129 = " = 0 ;" + NL + "            " + NL + "            for(int i = 0; i<pivot_Keys_Split";
  protected final String TEXT_130 = ".length; i++){" + NL + "                " + NL + "                if(pivot_Keys_Split";
  protected final String TEXT_131 = "[i].equals(";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = ")){" + NL + "                    " + NL + "                    pivotIndex";
  protected final String TEXT_134 = " = i;" + NL + "                    " + NL + "                    break;" + NL + "                    " + NL + "                }" + NL + "                " + NL + "            }" + NL + "            " + NL + "            //step2: process the splitted data according to function" + NL + "            " + NL + "            String[] aggStrSplit";
  protected final String TEXT_135 = " = aggStr";
  protected final String TEXT_136 = ".split(";
  protected final String TEXT_137 = ");" + NL + "            " + NL + "            aggValues";
  protected final String TEXT_138 = ".delete(0,aggValues";
  protected final String TEXT_139 = ".length());" + NL + "        ";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + "                ";
  protected final String TEXT_142 = " sum";
  protected final String TEXT_143 = " ;" + NL + "" + NL + "                if ((\"\").equals(aggStrSplit";
  protected final String TEXT_144 = "[pivotIndex";
  protected final String TEXT_145 = "])){" + NL + "                " + NL + "                \t";
  protected final String TEXT_146 = NL + "                \t\tsum";
  protected final String TEXT_147 = " = new java.math.BigDecimal(";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = ".toPlainString());" + NL + "                \t";
  protected final String TEXT_150 = NL + "                \t\taggStrSplit";
  protected final String TEXT_151 = "[pivotIndex";
  protected final String TEXT_152 = "] = FormatterUtils.format_Number(sum";
  protected final String TEXT_153 = ".toPlainString(),";
  protected final String TEXT_154 = ",";
  protected final String TEXT_155 = ");" + NL + "                \t";
  protected final String TEXT_156 = NL + "                \t\taggStrSplit";
  protected final String TEXT_157 = "[pivotIndex";
  protected final String TEXT_158 = "] = sum";
  protected final String TEXT_159 = ".toPlainString();" + NL + "                \t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ".parse";
  protected final String TEXT_163 = "(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " + \"\");" + NL + "\t                    " + NL + "\t                      aggStrSplit";
  protected final String TEXT_166 = "[pivotIndex";
  protected final String TEXT_167 = "] = FormatterUtils.format_Number(String.valueOf(sum";
  protected final String TEXT_168 = "),";
  protected final String TEXT_169 = ",";
  protected final String TEXT_170 = ");" + NL + "                      " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = ".parse";
  protected final String TEXT_174 = "(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = " + \"\");" + NL + "\t                    " + NL + "\t                      aggStrSplit";
  protected final String TEXT_177 = "[pivotIndex";
  protected final String TEXT_178 = "] = String.valueOf(sum";
  protected final String TEXT_179 = ");" + NL + "                      " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ".parse";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = " + \"\");" + NL + "                    " + NL + "                      aggStrSplit";
  protected final String TEXT_186 = "[pivotIndex";
  protected final String TEXT_187 = "] = String.valueOf(sum";
  protected final String TEXT_188 = ");                      " + NL + "                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_189 = NL + "                    " + NL + "                }else{" + NL + "               \t\t";
  protected final String TEXT_190 = NL + "               \t\t\t" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal sourceBD_";
  protected final String TEXT_191 = " = new java.math.BigDecimal(FormatterUtils.unformat_Number(aggStrSplit";
  protected final String TEXT_192 = "[pivotIndex";
  protected final String TEXT_193 = "],";
  protected final String TEXT_194 = ",";
  protected final String TEXT_195 = "));" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal targetBD_";
  protected final String TEXT_196 = " = new java.math.BigDecimal(aggValues";
  protected final String TEXT_197 = ".append(";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ").toString());" + NL + "\t\t\t\t\t  \t\taggStrSplit";
  protected final String TEXT_200 = "[pivotIndex";
  protected final String TEXT_201 = "] = FormatterUtils.format_Number(sourceBD_";
  protected final String TEXT_202 = ".add(targetBD_";
  protected final String TEXT_203 = ").toString(),";
  protected final String TEXT_204 = ",";
  protected final String TEXT_205 = ");" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + NL + "\t\t\t\t\t  \t\taggStrSplit";
  protected final String TEXT_207 = "[pivotIndex";
  protected final String TEXT_208 = "] = (new java.math.BigDecimal(aggStrSplit";
  protected final String TEXT_209 = "[pivotIndex";
  protected final String TEXT_210 = "])).add(new java.math.BigDecimal(aggValues";
  protected final String TEXT_211 = ".append(";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = ").toString())).toString();" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_215 = " = (";
  protected final String TEXT_216 = ")(";
  protected final String TEXT_217 = ".parse";
  protected final String TEXT_218 = "(aggStrSplit";
  protected final String TEXT_219 = "[pivotIndex";
  protected final String TEXT_220 = "]) + ";
  protected final String TEXT_221 = ".parse";
  protected final String TEXT_222 = "(aggValues";
  protected final String TEXT_223 = ".append(";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ").toString()));" + NL + "                \t" + NL + "                \t  aggStrSplit";
  protected final String TEXT_226 = "[pivotIndex";
  protected final String TEXT_227 = "] = String.valueOf(sum";
  protected final String TEXT_228 = ");" + NL + "                \t  " + NL + "\t\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\t" + NL + "\t\t\t\t}" + NL + "            ";
  protected final String TEXT_230 = NL + "                int count";
  protected final String TEXT_231 = " = 1;" + NL + "                " + NL + "                if (!(\"\").equals(aggStrSplit";
  protected final String TEXT_232 = "[pivotIndex";
  protected final String TEXT_233 = "]))" + NL + "            " + NL + "                    count";
  protected final String TEXT_234 = " = Integer.parseInt(aggStrSplit";
  protected final String TEXT_235 = "[pivotIndex";
  protected final String TEXT_236 = "]) + 1;" + NL + "                    " + NL + "                aggStrSplit";
  protected final String TEXT_237 = "[pivotIndex";
  protected final String TEXT_238 = "] = String.valueOf(count";
  protected final String TEXT_239 = ");" + NL + "            ";
  protected final String TEXT_240 = NL + "               \t\t" + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_241 = " = FormatterUtils.unformat_Number(aggValues";
  protected final String TEXT_242 = ".append(";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = ").toString(),";
  protected final String TEXT_245 = ",";
  protected final String TEXT_246 = ");" + NL + "            \t\tString unformatedTargetStr_";
  protected final String TEXT_247 = " = FormatterUtils.unformat_Number(aggStrSplit";
  protected final String TEXT_248 = "[pivotIndex";
  protected final String TEXT_249 = "],";
  protected final String TEXT_250 = ",";
  protected final String TEXT_251 = ");" + NL + "\t                if(Float.parseFloat(unformatedSourceStr_";
  protected final String TEXT_252 = ")>Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_253 = "))" + NL + "\t                    aggStrSplit";
  protected final String TEXT_254 = "[pivotIndex";
  protected final String TEXT_255 = "] = FormatterUtils.format_Number(aggValues";
  protected final String TEXT_256 = ".toString(),";
  protected final String TEXT_257 = ",";
  protected final String TEXT_258 = ");" + NL + "\t                    " + NL + "\t            ";
  protected final String TEXT_259 = NL + "\t            " + NL + "\t                if(Float.parseFloat(aggValues";
  protected final String TEXT_260 = ".append(";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = ").toString())>Float.parseFloat(aggStrSplit";
  protected final String TEXT_263 = "[pivotIndex";
  protected final String TEXT_264 = "]))" + NL + "\t                    aggStrSplit";
  protected final String TEXT_265 = "[pivotIndex";
  protected final String TEXT_266 = "] = aggValues";
  protected final String TEXT_267 = ".toString();" + NL + "            ";
  protected final String TEXT_268 = NL + "                " + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_269 = " = FormatterUtils.unformat_Number(aggValues";
  protected final String TEXT_270 = ".append(";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = ").toString(),";
  protected final String TEXT_273 = ",";
  protected final String TEXT_274 = ");" + NL + "            \t\tString unformatedTargetStr_";
  protected final String TEXT_275 = " = FormatterUtils.unformat_Number(aggStrSplit";
  protected final String TEXT_276 = "[pivotIndex";
  protected final String TEXT_277 = "],";
  protected final String TEXT_278 = ",";
  protected final String TEXT_279 = ");" + NL + "\t                if(Float.parseFloat(unformatedSourceStr_";
  protected final String TEXT_280 = ")<Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_281 = "))" + NL + "\t                    aggStrSplit";
  protected final String TEXT_282 = "[pivotIndex";
  protected final String TEXT_283 = "] = FormatterUtils.format_Number(aggValues";
  protected final String TEXT_284 = ".toString(),";
  protected final String TEXT_285 = ",";
  protected final String TEXT_286 = ");" + NL + "                    ";
  protected final String TEXT_287 = NL + "                " + NL + "\t                if(Float.parseFloat(aggValues";
  protected final String TEXT_288 = ".append(";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = ").toString())<Float.parseFloat(aggStrSplit";
  protected final String TEXT_291 = "[pivotIndex";
  protected final String TEXT_292 = "]))" + NL + "\t                    aggStrSplit";
  protected final String TEXT_293 = "[pivotIndex";
  protected final String TEXT_294 = "] = aggValues";
  protected final String TEXT_295 = ".toString();" + NL + "            ";
  protected final String TEXT_296 = NL + "            \t" + NL + "                if ((\"\").equals(aggStrSplit";
  protected final String TEXT_297 = "[pivotIndex";
  protected final String TEXT_298 = "]))" + NL + "                ";
  protected final String TEXT_299 = NL + NL + "                    aggStrSplit";
  protected final String TEXT_300 = "[pivotIndex";
  protected final String TEXT_301 = "] = aggValues";
  protected final String TEXT_302 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = "),";
  protected final String TEXT_305 = ",";
  protected final String TEXT_306 = ")).toString();" + NL + "                    ";
  protected final String TEXT_307 = NL + "                " + NL + "                    aggStrSplit";
  protected final String TEXT_308 = "[pivotIndex";
  protected final String TEXT_309 = "] = aggValues";
  protected final String TEXT_310 = ".append(String.valueOf(";
  protected final String TEXT_311 = ".";
  protected final String TEXT_312 = ")).toString();" + NL + "            ";
  protected final String TEXT_313 = NL + "    " + NL + "                    aggStrSplit";
  protected final String TEXT_314 = "[pivotIndex";
  protected final String TEXT_315 = "] = aggValues";
  protected final String TEXT_316 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = "),";
  protected final String TEXT_319 = ",";
  protected final String TEXT_320 = ")).toString();" + NL + "                ";
  protected final String TEXT_321 = NL + "                    aggStrSplit";
  protected final String TEXT_322 = "[pivotIndex";
  protected final String TEXT_323 = "] = aggValues";
  protected final String TEXT_324 = ".append(String.valueOf(";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = ")).toString();" + NL + "            \t" + NL + "            \t";
  protected final String TEXT_327 = " " + NL + "            " + NL + "            //step3: write new data back to string" + NL + "            " + NL + "            aggValues";
  protected final String TEXT_328 = ".delete(0, aggValues";
  protected final String TEXT_329 = ".length());" + NL + "            " + NL + "            for(int i = 0; i<aggStrSplit";
  protected final String TEXT_330 = ".length; i++){" + NL + "                " + NL + "                aggValues";
  protected final String TEXT_331 = ".append(aggStrSplit";
  protected final String TEXT_332 = "[i]);" + NL + "                aggValues";
  protected final String TEXT_333 = ".append(";
  protected final String TEXT_334 = ");" + NL + "                " + NL + "            }" + NL + "            " + NL + "            aggregation";
  protected final String TEXT_335 = ".remove(gKvalue";
  protected final String TEXT_336 = ");" + NL + "          " + NL + "            aggregation";
  protected final String TEXT_337 = ".put(gKvalue";
  protected final String TEXT_338 = ",aggValues";
  protected final String TEXT_339 = ".toString());            " + NL + "            " + NL + "        }" + NL + "        " + NL + "        } " + NL + "" + NL + "    nb_line_";
  protected final String TEXT_340 = "++;" + NL + "   ";
  protected final String TEXT_341 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
List<Map<String, String>> groupbys = 
    ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                
            String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

            String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");

            String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
                
            String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            
            String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");

            //String fieldSeparator = delim1.substring(1,delim1.length()-1);
            
            List<? extends IConnection> incomingConnections = node.getIncomingConnections();
            
                if (incomingConnections != null && !incomingConnections.isEmpty()) {
                    
                    IMetadataTable inMetadata = incomingConnections.get(0).getMetadataTable();
                    
                    String inConnName = incomingConnections.get(0).getName();
                    
                    List<IMetadataColumn> columnList = metadata.getListColumns();
                    
                    JavaType javaType = null;
                    
                    String columnType = null;
                    
                    String columnTypeValue = null;
                    
                    String columnTypeFunName = null;
             		
             		for(IMetadataColumn column:columnList){
             			
             			if(column.getLabel().equals(aggColumn)){
             			
             				javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
             			
							columnType = column.getTalendType().substring(3);
							
							columnTypeValue = JavaTypesManager.getShortNameFromJavaType(JavaTypesManager.getJavaTypeFromId(column.getTalendType()));
							
							columnTypeFunName = columnTypeValue.substring(0,1).toUpperCase()+columnTypeValue.substring(1);

							break;
						}
             		}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    for (int i=0; i<groupbys.size(); i++) {
       
      Map<String, String> groupby = groupbys.get(i);
    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_40);
    if(i!=groupbys.size()-1){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(fieldSeparator);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    

     }
    
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_64);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_69);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_78);
    }else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_85);
    
	}
  }
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
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_106);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_115);
    }else{
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_122);
    	}
  }
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
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
      
            if( ("sum").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_140);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
                	if(("BigDecimal").equals(columnType)) {
                	
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_149);
    
                		if(advancedSeparator){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_155);
    
                		} else {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
                		}
					} else if(("Double").equals(columnType)||("Float").equals(columnType)){
						if(advancedSeparator){
						
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_170);
    }else{
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    }
					  }else{
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    if(("BigDecimal").equals(columnType) || ("Double").equals(columnType)||("Float").equals(columnType)){
               			if(advancedSeparator){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_205);
    }else{
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_213);
    }
					}else{
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    
            }else if( ("count").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
            }else if( ("max").equals(aggFunction) ){
               	if(advancedSeparator){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_258);
    }else{
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
            	}
            }else if( ("min").equals(aggFunction) ){
               	if(advancedSeparator){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_286);
    }else{
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
            	}
            }else if( ("first").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    if(advancedSeparator){
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_306);
    }else{
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_312);
    
            	}
            }else if( ("last").equals(aggFunction) ){
            	if(advancedSeparator){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_320);
    }else{
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_326);
    }
            }
            
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
        }
    }
}

    stringBuffer.append(TEXT_341);
    return stringBuffer.toString();
  }
}
