package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "String fileName_";
  protected final String TEXT_3 = " = \"\";";
  protected final String TEXT_4 = NL + "fileName_";
  protected final String TEXT_5 = " = (new java.io.File(";
  protected final String TEXT_6 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "String fullName_";
  protected final String TEXT_7 = " = null;" + NL + "String extension_";
  protected final String TEXT_8 = " = null;" + NL + "String directory_";
  protected final String TEXT_9 = " = null;" + NL + "if((fileName_";
  protected final String TEXT_10 = ".indexOf(\"/\") != -1)) {" + NL + "    if(fileName_";
  protected final String TEXT_11 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_12 = ".lastIndexOf(\"/\")) {" + NL + "        fullName_";
  protected final String TEXT_13 = " = fileName_";
  protected final String TEXT_14 = ";" + NL + "        extension_";
  protected final String TEXT_15 = " = \"\";" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_16 = " = fileName_";
  protected final String TEXT_17 = ".substring(0, fileName_";
  protected final String TEXT_18 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_19 = " = fileName_";
  protected final String TEXT_20 = ".substring(fileName_";
  protected final String TEXT_21 = ".lastIndexOf(\".\"));" + NL + "    }           " + NL + "    directory_";
  protected final String TEXT_22 = " = fileName_";
  protected final String TEXT_23 = ".substring(0, fileName_";
  protected final String TEXT_24 = ".lastIndexOf(\"/\"));            " + NL + "} else {" + NL + "    if(fileName_";
  protected final String TEXT_25 = ".lastIndexOf(\".\") != -1) {" + NL + "        fullName_";
  protected final String TEXT_26 = " = fileName_";
  protected final String TEXT_27 = ".substring(0, fileName_";
  protected final String TEXT_28 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_29 = " = fileName_";
  protected final String TEXT_30 = ".substring(fileName_";
  protected final String TEXT_31 = ".lastIndexOf(\".\"));" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_32 = " = fileName_";
  protected final String TEXT_33 = ";" + NL + "        extension_";
  protected final String TEXT_34 = " = \"\";" + NL + "    }" + NL + "    directory_";
  protected final String TEXT_35 = " = \"\";" + NL + "}" + NL + "boolean isFileGenerated_";
  protected final String TEXT_36 = " = true;" + NL + "java.io.File file";
  protected final String TEXT_37 = " = new java.io.File(fileName_";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "if(file";
  protected final String TEXT_40 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_41 = " = false;" + NL + "}";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_44 = "= true;";
  protected final String TEXT_45 = NL + "    \t\tint nb_line_";
  protected final String TEXT_46 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_49 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_50 = " = 0;\t\t" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ";" + NL;
  protected final String TEXT_55 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_56 = " != null && directory_";
  protected final String TEXT_57 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_58 = " = new java.io.File(directory_";
  protected final String TEXT_59 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_60 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_61 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_62 = NL + "    ";
  protected final String TEXT_63 = NL + "\t\t\t\tfile";
  protected final String TEXT_64 = " = new java.io.File(fileName_";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_66 = " = fullName_";
  protected final String TEXT_67 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_68 = " = new java.io.File(zipName_";
  protected final String TEXT_69 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_70 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_71 = ")));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_72 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_73 = ".getName()));" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_74 = " = new ";
  protected final String TEXT_75 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = "));";
  protected final String TEXT_78 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "(new java.io.OutputStreamWriter(" + NL + "            \t\tnew java.io.FileOutputStream(fileName_";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = "),";
  protected final String TEXT_83 = "));";
  protected final String TEXT_84 = NL + "                java.io.Writer out";
  protected final String TEXT_85 = " = new ";
  protected final String TEXT_86 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_87 = " + splitedFileNo_";
  protected final String TEXT_88 = " + extension_";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = "),";
  protected final String TEXT_91 = "));" + NL + "                file";
  protected final String TEXT_92 = " = new java.io.File(fullName_";
  protected final String TEXT_93 = " + splitedFileNo_";
  protected final String TEXT_94 = " + extension_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_99 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_100 = NL + "    \t\t    if(file_";
  protected final String TEXT_101 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t    ";
  protected final String TEXT_102 = NL + "    \t\t    if(file";
  protected final String TEXT_103 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t        ";
  protected final String TEXT_104 = NL + "\t    \t\t            out";
  protected final String TEXT_105 = ".write(\"";
  protected final String TEXT_106 = "\");" + NL + "\t    \t\t            ";
  protected final String TEXT_107 = NL + "\t    \t\t                out";
  protected final String TEXT_108 = ".write(OUT_DELIM_";
  protected final String TEXT_109 = ");" + NL + "\t    \t\t                ";
  protected final String TEXT_110 = NL + "    \t\t        out";
  protected final String TEXT_111 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_112 = ");" + NL + "    \t\t        out";
  protected final String TEXT_113 = ".flush();" + NL + "    \t\t    }" + NL + "\t\t        ";
  protected final String TEXT_114 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_115 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_116 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_117 = NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_118 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_119 = "));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_120 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_121 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_122 = ",";
  protected final String TEXT_123 = ");" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_124 = " = new ";
  protected final String TEXT_125 = "(writer_";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_128 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_129 = ",";
  protected final String TEXT_130 = ");" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_131 = " = new ";
  protected final String TEXT_132 = "(writer_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "    \t\t            out";
  protected final String TEXT_135 = ".write(\"";
  protected final String TEXT_136 = "\");" + NL + "    \t\t            ";
  protected final String TEXT_137 = NL + "    \t\t                out";
  protected final String TEXT_138 = ".write(OUT_DELIM_";
  protected final String TEXT_139 = ");" + NL + "    \t\t                ";
  protected final String TEXT_140 = NL + "    \t\t        out";
  protected final String TEXT_141 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = NL;
  protected final String TEXT_145 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_146 = "= true;" + NL + "            String[] headColu";
  protected final String TEXT_147 = " = null;";
  protected final String TEXT_148 = NL + "            String[] headColu";
  protected final String TEXT_149 = "=new String[";
  protected final String TEXT_150 = "];";
  protected final String TEXT_151 = "   \t    \t\t" + NL + "            class CSVBasicSet_";
  protected final String TEXT_152 = "{          \t" + NL + "            \tprivate char field_Delim;            \t" + NL + "            \tprivate char row_Delim;            \t" + NL + "            \tprivate char escape;            \t" + NL + "            \tprivate char textEnclosure;" + NL + "            \t          \t" + NL + "            \tpublic void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_153 = "[] = null;" + NL + "                    " + NL + "            \t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "            \t\tif (fieldSep.length() > 0 ){" + NL + "            \t\t\tfield_Delim_";
  protected final String TEXT_154 = " = fieldSep.toCharArray();" + NL + "            \t\t}else { " + NL + "            \t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.field_Delim = field_Delim_";
  protected final String TEXT_155 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getFieldDelim(){" + NL + "            \t\tif(this.field_Delim==0){" + NL + "            \t\t\tsetFieldSeparator(";
  protected final String TEXT_156 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.field_Delim;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic void setRowSeparator(String rowSep){" + NL + "            \t\tchar row_Delim";
  protected final String TEXT_157 = "[] = null;" + NL + "                 " + NL + "            \t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'.  " + NL + "            \t\tif (rowSep.length() > 0 ){ " + NL + "            \t\t\trow_Delim";
  protected final String TEXT_158 = " = rowSep.toCharArray();" + NL + "            \t\t}else {" + NL + "            \t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.row_Delim = row_Delim";
  protected final String TEXT_159 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getRowDelim(){" + NL + "            \t\tif(this.row_Delim==0){" + NL + "            \t\t\tsetRowSeparator(";
  protected final String TEXT_160 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.row_Delim;" + NL + "            \t}" + NL + "            \t       \t        " + NL + "        \t    public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "        \t        if(strEscape.length() <= 0 ){ " + NL + "        \t            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        \t        }" + NL + "        \t        " + NL + "                \tif (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "                \tif((\"'\").equals(strTextEnclosure)){" + NL + "            \t\t\tstrTextEnclosure = \"\\\\'\";" + NL + "            \t\t} " + NL + "        \t\t\tchar textEnclosure_";
  protected final String TEXT_161 = "[] = null;" + NL + "        \t        " + NL + "        \t        if(strTextEnclosure.length() > 0 ){ " + NL + "              \t\t\ttextEnclosure_";
  protected final String TEXT_162 = " = strTextEnclosure.toCharArray(); " + NL + "        \t\t\t}else { " + NL + "        \t            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        \t        }" + NL + "" + NL + "        \t\t\tif((\"\\\\\\\\\").equals(strEscape)){" + NL + "        \t\t\t\tthis.escape = com.csvreader.CsvWriter.ESCAPE_MODE_BACKSLASH;" + NL + "        \t\t\t}else if(strEscape.equals(strTextEnclosure)){" + NL + "        \t\t\t\tthis.escape = com.csvreader.CsvWriter.ESCAPE_MODE_DOUBLED;" + NL + "        \t\t\t}" + NL + "        \t\t\t" + NL + "        \t\t\tthis.textEnclosure = textEnclosure_";
  protected final String TEXT_163 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getEscapeChar(){" + NL + "            \t\treturn (char)this.escape;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getTextEnclosure(){" + NL + "            \t\treturn this.textEnclosure;" + NL + "            \t}" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_164 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_167 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_168 = " = 0;" + NL + "            " + NL + "            " + NL + "            CSVBasicSet_";
  protected final String TEXT_169 = " csvSettings_";
  protected final String TEXT_170 = " = new CSVBasicSet_";
  protected final String TEXT_171 = "();" + NL + "            csvSettings_";
  protected final String TEXT_172 = ".setFieldSeparator(";
  protected final String TEXT_173 = ");" + NL + "            csvSettings_";
  protected final String TEXT_174 = ".setRowSeparator(";
  protected final String TEXT_175 = ");" + NL + "\t\t\tcsvSettings_";
  protected final String TEXT_176 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_177 = ",";
  protected final String TEXT_178 = ");";
  protected final String TEXT_179 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_180 = " != null && directory_";
  protected final String TEXT_181 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_182 = " = new java.io.File(directory_";
  protected final String TEXT_183 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_184 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_185 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_186 = NL + "\t\t\t\tfile";
  protected final String TEXT_187 = " = new java.io.File(fileName_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_189 = " = fullName_";
  protected final String TEXT_190 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_191 = " = new java.io.File(zipName_";
  protected final String TEXT_192 = ");\t\t\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_193 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_194 = ")));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_195 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_196 = ".getName()));" + NL + "                java.io.Writer out";
  protected final String TEXT_197 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_198 = ", ";
  protected final String TEXT_199 = "));" + NL + "\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_200 = " = new java.io.StringWriter();" + NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_201 = " = new com.csvreader.CsvWriter(strWriter";
  protected final String TEXT_202 = ", csvSettings_";
  protected final String TEXT_203 = ".getFieldDelim()); ";
  protected final String TEXT_204 = "\t\t" + NL + "                java.io.Writer out";
  protected final String TEXT_205 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_206 = ", ";
  protected final String TEXT_207 = "), ";
  protected final String TEXT_208 = "));" + NL + "\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_209 = " = new java.io.StringWriter();" + NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_210 = " = new com.csvreader.CsvWriter(strWriter";
  protected final String TEXT_211 = ", csvSettings_";
  protected final String TEXT_212 = ".getFieldDelim());  ";
  protected final String TEXT_213 = NL + "\t\t\t\tfile";
  protected final String TEXT_214 = " = new java.io.File(fileName_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_216 = " = fullName_";
  protected final String TEXT_217 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_218 = " = new java.io.File(zipName_";
  protected final String TEXT_219 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_220 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_221 = ")));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_222 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_223 = ".getName()));" + NL + "\t\t\t\tcom.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_224 = " = new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    zipOut_";
  protected final String TEXT_225 = ", ";
  protected final String TEXT_226 = ")), csvSettings_";
  protected final String TEXT_227 = ".getFieldDelim()); " + NL + "\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\tcom.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_229 = " = new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_230 = ", ";
  protected final String TEXT_231 = "), ";
  protected final String TEXT_232 = ")), csvSettings_";
  protected final String TEXT_233 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_234 = NL + "                java.io.Writer out";
  protected final String TEXT_235 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_236 = " + splitedFileNo_";
  protected final String TEXT_237 = " + extension_";
  protected final String TEXT_238 = ", ";
  protected final String TEXT_239 = "),";
  protected final String TEXT_240 = "));" + NL + "                java.io.StringWriter strWriter";
  protected final String TEXT_241 = " = new java.io.StringWriter();    " + NL + "                  " + NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_242 = " = new com.csvreader.CsvWriter(strWriter";
  protected final String TEXT_243 = ", csvSettings_";
  protected final String TEXT_244 = ".getFieldDelim());";
  protected final String TEXT_245 = NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_246 = " = new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_247 = " + splitedFileNo_";
  protected final String TEXT_248 = " + extension_";
  protected final String TEXT_249 = ", ";
  protected final String TEXT_250 = "),";
  protected final String TEXT_251 = ")), csvSettings_";
  protected final String TEXT_252 = ".getFieldDelim());";
  protected final String TEXT_253 = NL + "                file";
  protected final String TEXT_254 = " = new java.io.File(fullName_";
  protected final String TEXT_255 = " + splitedFileNo_";
  protected final String TEXT_256 = " + extension_";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "        \t    if(csvSettings_";
  protected final String TEXT_259 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_260 = ".getRowDelim()!='\\n')" + NL + "        \t    \tCsvWriter";
  protected final String TEXT_261 = ".setRecordDelimiter(csvSettings_";
  protected final String TEXT_262 = ".getRowDelim());" + NL + "\t    \t\t";
  protected final String TEXT_263 = "\t\t   " + NL + "\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t        ";
  protected final String TEXT_266 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_267 = NL + "\t        \tif(file_";
  protected final String TEXT_268 = ".length()==0)" + NL + "\t        \t{" + NL + "\t        ";
  protected final String TEXT_269 = NL + "    \t        if(file";
  protected final String TEXT_270 = ".length()==0)  " + NL + "    \t        {" + NL + "    \t            ";
  protected final String TEXT_271 = "\t      \t" + NL + "        \t\t\t\theadColu";
  protected final String TEXT_272 = "[";
  protected final String TEXT_273 = "]=\"";
  protected final String TEXT_274 = "\";" + NL + "        \t\t\t\t";
  protected final String TEXT_275 = "\t " + NL + "    \t            CsvWriter";
  protected final String TEXT_276 = ".writeRecord(headColu";
  protected final String TEXT_277 = ");" + NL + "    \t            CsvWriter";
  protected final String TEXT_278 = ".flush();" + NL + "    \t            \t";
  protected final String TEXT_279 = NL + "    \t            out";
  protected final String TEXT_280 = ".write(strWriter";
  protected final String TEXT_281 = ".getBuffer().toString());" + NL + "    \t            out";
  protected final String TEXT_282 = ".flush();" + NL + "                \tstrWriter";
  protected final String TEXT_283 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_284 = ".getBuffer().length()); \t" + NL + "                \t\t";
  protected final String TEXT_285 = NL + "                }" + NL + "\t        ";
  protected final String TEXT_286 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_287 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_288 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_289 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_290 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_291 = "));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_292 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_293 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_294 = ", ";
  protected final String TEXT_295 = ");" + NL + "                java.io.Writer out";
  protected final String TEXT_296 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_297 = ");" + NL + "\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_298 = " = new java.io.StringWriter();" + NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_299 = " = new com.csvreader.CsvWriter(strWriter";
  protected final String TEXT_300 = ", csvSettings_";
  protected final String TEXT_301 = ".getFieldDelim());  ";
  protected final String TEXT_302 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_303 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = ");" + NL + "                java.io.Writer out";
  protected final String TEXT_306 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_307 = ");" + NL + "\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_308 = " = new java.io.StringWriter();" + NL + "                com.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_309 = " = new com.csvreader.CsvWriter(strWriter";
  protected final String TEXT_310 = ", csvSettings_";
  protected final String TEXT_311 = ".getFieldDelim());  ";
  protected final String TEXT_312 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_313 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_314 = "));" + NL + "    \t\t    zipOut_";
  protected final String TEXT_315 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_316 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_317 = ", ";
  protected final String TEXT_318 = ");" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_319 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_320 = ");" + NL + "\t\t\t\tcom.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_321 = " = new com.csvreader.CsvWriter(bufferWriter_";
  protected final String TEXT_322 = ", csvSettings_";
  protected final String TEXT_323 = ".getFieldDelim());";
  protected final String TEXT_324 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_325 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_326 = ", ";
  protected final String TEXT_327 = ");" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_328 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_329 = ");" + NL + "\t\t\t\tcom.csvreader.CsvWriter CsvWriter";
  protected final String TEXT_330 = " = new com.csvreader.CsvWriter(bufferWriter_";
  protected final String TEXT_331 = ", csvSettings_";
  protected final String TEXT_332 = ".getFieldDelim());  ";
  protected final String TEXT_333 = NL + "        \t    if(csvSettings_";
  protected final String TEXT_334 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_335 = ".getRowDelim()!='\\n')" + NL + "        \t    \tCsvWriter";
  protected final String TEXT_336 = ".setRecordDelimiter(csvSettings_";
  protected final String TEXT_337 = ".getRowDelim());   \t    \t" + NL + "    \t    ";
  protected final String TEXT_338 = NL + "       \t\t\t\theadColu";
  protected final String TEXT_339 = "[";
  protected final String TEXT_340 = "]=\"";
  protected final String TEXT_341 = "\";" + NL + "       \t\t\t\t";
  protected final String TEXT_342 = NL + "        \t\tCsvWriter";
  protected final String TEXT_343 = ".writeRecord(headColu";
  protected final String TEXT_344 = ");\t" + NL + "        \t\t\t";
  protected final String TEXT_345 = NL + "        \t\tout";
  protected final String TEXT_346 = ".write(strWriter";
  protected final String TEXT_347 = ".getBuffer().toString());" + NL + "                strWriter";
  protected final String TEXT_348 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_349 = ".getBuffer().length());" + NL + "        \t\t\t";
  protected final String TEXT_350 = NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_351 = ".setEscapeMode(csvSettings_";
  protected final String TEXT_352 = ".getEscapeChar());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_353 = ".setTextQualifier(csvSettings_";
  protected final String TEXT_354 = ".getTextEnclosure());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_355 = ".setForceQualifier(true);";
  protected final String TEXT_356 = NL + NL;
  protected final String TEXT_357 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	
if(!useStream){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if(isAppend){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	}
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_42);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            String fullName = null;
            String extensionName = null;
            String directoryName = null;    
            
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );
            
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
    		String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
    		boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    	}
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_54);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
			
    			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
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
    
    			}

    stringBuffer.append(TEXT_62);
     	
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(!split){
    				if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_77);
    
    				}else{

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_83);
     
					}
    			} else {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
    			}
    			
    			if(isIncludeHeader && !hasDynamic){
    		    
    stringBuffer.append(TEXT_96);
    
					if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_97);
    
					}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_98);
     
		        	}
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_99);
     
					}
					if(!split && compress && !isAppend){
		        
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
    		    	}else{
    		    	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
    		        }		
	    		        List<IMetadataColumn> columns = metadata.getListColumns();
	    		        int sizeColumns = columns.size();
	    		        for (int i = 0; i < sizeColumns; i++) {
	    		            IMetadataColumn column = columns.get(i);
	    		            
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    
	    		            if(i != sizeColumns - 1) {
	    		                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
	    		            }
	    		        }
    		        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
     
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_114);
    
		        	}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_115);
    
		        	}
		        	if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_116);
    
					}
		        
    
    			}

    		}else{
    		//***********************the following is the part of output Stream**************************************
    		
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(compress){// compress the dest output stream
 
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
    			}else{

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
				}
    			if(isIncludeHeader && !hasDynamic){
    		        List<IMetadataColumn> columns = metadata.getListColumns();
    		        int sizeColumns = columns.size();
    		        for (int i = 0; i < sizeColumns; i++) {
    		            IMetadataColumn column = columns.get(i);
    		            
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    
    		            if(i != sizeColumns - 1) {
    		                
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
    		            }
    		        }
    		        
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
    		    }
    		}// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_143);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_144);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                       
        	List<IMetadataColumn> columns = metadata.getListColumns();
	    	int sizeColumns = columns.size(); 
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    		String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    		
        	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        	
 			if(escapeChar1.equals("\"\"\"")){
 				escapeChar1 = "\"\\\"\"";
 			}
        	
        	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
 			if(textEnclosure1.equals("\"\"\"")){
 				textEnclosure1 = "\"\\\"\"";
 			}
 			
        	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
        	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
            	}else{
            
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_150);
    
            	}
    	    
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_178);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
            	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
            	}
    	
	            if(!split){
	            	if(isInRowMode){
    					if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    
    					}else{

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    
                		}
                	}else{
                		if(compress && !isAppend){// compress the dest file
				
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    
						}else{
				
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    
						}
                	}
	            }else{
	            	if(isInRowMode){
                
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
                	}else{
                
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    
                	}
                
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
	            }
	    		
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
    	        
    stringBuffer.append(TEXT_263);
    
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_264);
    
				}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_265);
     
	        	}
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_266);
     
				}
				if(!split && compress && !isAppend){
	        
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
	        	}else{
	        
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
    	        }			
	         			for(int i = 0 ; i < sizeColumns ; i++)
	        			{
	        				IMetadataColumn column = columns.get(i);
        				
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    
         				}
    	            
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    if(isInRowMode){
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
    }
    stringBuffer.append(TEXT_285);
     
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_286);
    
	        	}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_287);
    
	        	}
	        	if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_288);
    
				}
	        
    		  
	    	    }
	    	}else{
    		//***********************the following is the part of output Stream**************************************
	            if(isInRowMode){
	            	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    
	            	}else{

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    
					}
                }else{
                	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    
                	}else{

    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    
					}
                }

    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
     		
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
	    	        for(int i = 0; i < sizeColumns; i++)
	        		{
	        			IMetadataColumn column = columns.get(i);
        			
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_341);
    
	        		}
    	        
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    if(isInRowMode){
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    }
	    	    }
	    	}//*****************************csv mode under output stream end********************************************************
	    	
	    	if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    
			}
	    }
    }
    
    stringBuffer.append(TEXT_356);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_357);
    return stringBuffer.toString();
  }
}
