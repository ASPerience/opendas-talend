package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TWaitForFileBeginJava
{
  protected static String nl;
  public static synchronized TWaitForFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileBeginJava result = new TWaitForFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        class Util_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "            private boolean flagt = false;" + NL + "" + NL + "            private java.util.regex.Pattern fileNamePatternt = null;" + NL + "" + NL + "            java.util.List<java.io.File> getFiles() {" + NL + "                String directoryt = ";
  protected final String TEXT_3 = ";" + NL + "                String filemaskt = ";
  protected final String TEXT_4 = "+\"$\";" + NL + "" + NL + "                if (filemaskt.indexOf(\"^\") == -1) {" + NL + "                    filemaskt = \"^\" + filemaskt;" + NL + "                }" + NL + "                if (!(filemaskt.lastIndexOf(\".*$\") == -1) && filemaskt.lastIndexOf(\"*.*$\") == -1) {" + NL + "                    filemaskt = filemaskt.substring(0, filemaskt.length() - 3) + \"$\";" + NL + "                    flagt = true;" + NL + "                } else {" + NL + "                    filemaskt = java.util.regex.Pattern.compile(\"[*]\").matcher(filemaskt).replaceAll(\".*\");" + NL + "                }" + NL + "" + NL + "                boolean case_sensitivet = ";
  protected final String TEXT_5 = ";" + NL + "                fileNamePatternt = java.util.regex.Pattern.compile(filemaskt);" + NL + "                if (!case_sensitivet) {" + NL + "                    fileNamePatternt = java.util.regex.Pattern.compile(filemaskt, java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "                }" + NL + "                java.io.File filet = new java.io.File(directoryt);" + NL + "                final java.util.List<java.io.File> list = new java.util.ArrayList<java.io.File>();" + NL + "                filet.listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "                    public boolean accept(java.io.File dir, String name) {" + NL + "                        java.io.File file = new java.io.File(dir, name);" + NL + "                        if (file.isFile()) {" + NL + "                            String fileNamet = name;" + NL + "                            if (flagt == true) {" + NL + "                                if (!(fileNamet.indexOf(\".\") == -1)) {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet.substring(0, fileNamet.indexOf(\".\"))).find()) {" + NL + "                                        list.add(file);" + NL + "" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                        list.add(file);" + NL + "                                    }" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                    list.add(file);" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                            return true;" + NL + "                        } ";
  protected final String TEXT_6 = "                          " + NL + "                            else {" + NL + "" + NL + "                                file.listFiles(this);" + NL + "                            }" + NL + "                      ";
  protected final String TEXT_7 = "                        " + NL + "                        return false;" + NL + "                    }" + NL + "" + NL + "                });" + NL + "" + NL + "                return list;" + NL + "            }";
  protected final String TEXT_8 = NL + "                public String getFileChecksum(java.io.File file) {" + NL + "                \tString strMD5 = \"\";" + NL + "                \tjava.security.MessageDigest complete = null;" + NL + "                \tjava.io.InputStream fis = null;" + NL + "                \ttry{" + NL + "                        fis =  new java.io.FileInputStream(file);" + NL + "                        byte[] buffer = new byte[1024];" + NL + "                        complete = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "                        int numRead;" + NL + "                        while((numRead = fis.read(buffer))!= -1){" + NL + "                          \tif (numRead > 0) {" + NL + "                            \tcomplete.update(buffer, 0, numRead);" + NL + "                            }" + NL + "                        }" + NL + "                    } catch(java.lang.Exception ex) {" + NL + "    " + NL + "                    } finally {" + NL + "                    \tif(fis != null) {" + NL + "                    \t\ttry {" + NL + "                    \t\t\tfis.close();" + NL + "                    \t\t} catch(Exception ex) {" + NL + "                    \t\t}" + NL + "                    \t}" + NL + "                    }" + NL + "                   \t" + NL + "                   \tif(complete != null){" + NL + "            \t\t\tbyte[] b = complete.digest();" + NL + "             \t\t\tfor (int i = 0; i < b.length; i++) {" + NL + "              \t\t\t\tstrMD5 += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );" + NL + "              \t\t\t}" + NL + "          \t\t\t}" + NL + "            \t\treturn strMD5;" + NL + "                }";
  protected final String TEXT_9 = NL + "        }" + NL + "            " + NL + "        Util_";
  protected final String TEXT_10 = " util_";
  protected final String TEXT_11 = " = new Util_";
  protected final String TEXT_12 = "();" + NL + "        java.util.List<java.io.File> originalFiles_";
  protected final String TEXT_13 = " = util_";
  protected final String TEXT_14 = ".getFiles();            ";
  protected final String TEXT_15 = NL + "            java.util.Map<String, java.io.File> originalMap_";
  protected final String TEXT_16 = " = new java.util.HashMap<String, java.io.File>();" + NL + "            for(java.io.File file_";
  protected final String TEXT_17 = ":originalFiles_";
  protected final String TEXT_18 = "){" + NL + "            \toriginalMap_";
  protected final String TEXT_19 = ".put(util_";
  protected final String TEXT_20 = ".getFileChecksum(file_";
  protected final String TEXT_21 = "), file_";
  protected final String TEXT_22 = ");" + NL + "            }";
  protected final String TEXT_23 = NL + "      " + NL + "        int count_";
  protected final String TEXT_24 = " = 0;" + NL + "        while (true) {";
  protected final String TEXT_25 = "                " + NL + "                if (count_";
  protected final String TEXT_26 = " == ";
  protected final String TEXT_27 = " ) {" + NL + "                    break;" + NL + "                }";
  protected final String TEXT_28 = "                " + NL + "            boolean found_";
  protected final String TEXT_29 = " = false;";
  protected final String TEXT_30 = "              " + NL + "    \t\t\tif( count_";
  protected final String TEXT_31 = " < originalFiles_";
  protected final String TEXT_32 = ".size()) {" + NL + "                    java.io.File file_";
  protected final String TEXT_33 = " = originalFiles_";
  protected final String TEXT_34 = ".get(count_";
  protected final String TEXT_35 = ");" + NL + "                    globalMap.put(\"";
  protected final String TEXT_36 = "_FILENAME\", file_";
  protected final String TEXT_37 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_38 = "_PRESENT_FILE\", file_";
  protected final String TEXT_39 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_40 = " = true;" + NL + "    \t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_41 = NL + "            java.util.List<java.io.File> fetchFilesOneTime_";
  protected final String TEXT_42 = " = util_";
  protected final String TEXT_43 = ".getFiles();";
  protected final String TEXT_44 = NL + "                for(java.io.File file_";
  protected final String TEXT_45 = " : fetchFilesOneTime_";
  protected final String TEXT_46 = ") {" + NL + "                    if(!originalFiles_";
  protected final String TEXT_47 = ".contains(file_";
  protected final String TEXT_48 = ")) {" + NL + "           \t";
  protected final String TEXT_49 = NL + "                    \twhile(true){" + NL + "                        \tjava.io.FileInputStream fis_";
  protected final String TEXT_50 = " = null;" + NL + "                        \ttry{" + NL + "                            \tfis_";
  protected final String TEXT_51 = " = new java.io.FileInputStream(file_";
  protected final String TEXT_52 = ".getAbsolutePath());" + NL + "                        \t}catch(java.io.FileNotFoundException e){" + NL + "                            \tThread.sleep(3000);" + NL + "                            \tcontinue;" + NL + "                        \t}" + NL + "                        \tif(fis_";
  protected final String TEXT_53 = " != null){" + NL + "\t                    \t\ttry {" + NL + "\t                    \t\t\tfis_";
  protected final String TEXT_54 = ".close();" + NL + "\t                    \t\t} catch(Exception ex) {" + NL + "\t                    \t\t}" + NL + "                        \t}" + NL + "                        \tbreak;" + NL + "                    \t}";
  protected final String TEXT_55 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_56 = "_FILENAME\", file_";
  protected final String TEXT_57 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_58 = "_CREATED_FILE\", file_";
  protected final String TEXT_59 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_60 = " = true;      " + NL + "                        originalFiles_";
  protected final String TEXT_61 = ".add(file_";
  protected final String TEXT_62 = ");              " + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "               // originalFiles_";
  protected final String TEXT_63 = " = util_";
  protected final String TEXT_64 = ".getFiles();";
  protected final String TEXT_65 = NL + "                for(java.io.File file_";
  protected final String TEXT_66 = " : originalFiles_";
  protected final String TEXT_67 = ") {" + NL + "                    if(!fetchFilesOneTime_";
  protected final String TEXT_68 = ".contains(file_";
  protected final String TEXT_69 = ")) {" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_70 = "_FILENAME\", file_";
  protected final String TEXT_71 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_72 = "_DELETED_FILE\", file_";
  protected final String TEXT_73 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_74 = " = true;  " + NL + "                        originalFiles_";
  protected final String TEXT_75 = ".remove(file_";
  protected final String TEXT_76 = ");                  " + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "               // originalFiles_";
  protected final String TEXT_77 = " = util_";
  protected final String TEXT_78 = ".getFiles();";
  protected final String TEXT_79 = NL + "                for(java.io.File file_";
  protected final String TEXT_80 = " : fetchFilesOneTime_";
  protected final String TEXT_81 = ") {";
  protected final String TEXT_82 = "    " + NL + "                    if(null == originalMap_";
  protected final String TEXT_83 = ".get(util_";
  protected final String TEXT_84 = ".getFileChecksum(file_";
  protected final String TEXT_85 = "))) {" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_86 = "_FILENAME\", file_";
  protected final String TEXT_87 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_88 = "_UPDATED_FILE\", file_";
  protected final String TEXT_89 = ".getAbsolutePath());" + NL + "                       \tfound_";
  protected final String TEXT_90 = " = true;" + NL + "                        originalMap_";
  protected final String TEXT_91 = ".put(util_";
  protected final String TEXT_92 = ".getFileChecksum(file_";
  protected final String TEXT_93 = "), file_";
  protected final String TEXT_94 = ");" + NL + "                        /*originalFiles_";
  protected final String TEXT_95 = " = util_";
  protected final String TEXT_96 = ".getFiles();" + NL + "                        originalMap_";
  protected final String TEXT_97 = ".clear();" + NL + "                        for(java.io.File newFile_";
  protected final String TEXT_98 = " : originalFiles_";
  protected final String TEXT_99 = ") {" + NL + "                            originalMap_";
  protected final String TEXT_100 = ".put(util_";
  protected final String TEXT_101 = ".getFileChecksum(newFile_";
  protected final String TEXT_102 = "), newFile_";
  protected final String TEXT_103 = ");" + NL + "                        } */    " + NL + "                        break;                        " + NL + "                    }" + NL + "            \t";
  protected final String TEXT_104 = NL + "            \t\tif(null == originalMap_";
  protected final String TEXT_105 = ".get(util_";
  protected final String TEXT_106 = ".getFileChecksum(file_";
  protected final String TEXT_107 = "))) {" + NL + "            \t\t\toriginalMap_";
  protected final String TEXT_108 = ".put(util_";
  protected final String TEXT_109 = ".getFileChecksum(file_";
  protected final String TEXT_110 = "), file_";
  protected final String TEXT_111 = ");" + NL + "            \t\t\tglobalMap.put(\"";
  protected final String TEXT_112 = "_NOT_UPDATED_FILE\", null);" + NL + "            \t\t\tfound_";
  protected final String TEXT_113 = " = false;" + NL + "                   \t}else{                   " + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_114 = "_FILENAME\", file_";
  protected final String TEXT_115 = ".getName());" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_116 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_117 = ".getAbsolutePath());" + NL + "                    \tfound_";
  protected final String TEXT_118 = " = true;" + NL + "                    \tbreak;" + NL + "                    }";
  protected final String TEXT_119 = NL + "                }    " + NL + "                ";
  protected final String TEXT_120 = NL + "                for(java.io.File file_";
  protected final String TEXT_121 = " : originalFiles_";
  protected final String TEXT_122 = ") {" + NL + "                    if(!fetchFilesOneTime_";
  protected final String TEXT_123 = ".contains(file_";
  protected final String TEXT_124 = ")) {" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_125 = "_FILENAME\", file_";
  protected final String TEXT_126 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_127 = "_DELETED_FILE\", file_";
  protected final String TEXT_128 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_129 = " = true;" + NL + "                        if(fetchFilesOneTime_";
  protected final String TEXT_130 = ".size() != originalFiles_";
  protected final String TEXT_131 = ".size()) {" + NL + "                        originalFiles_";
  protected final String TEXT_132 = ".remove(file_";
  protected final String TEXT_133 = ");" + NL + "                            /*originalFiles_";
  protected final String TEXT_134 = " = util_";
  protected final String TEXT_135 = ".getFiles();" + NL + "                            originalMap_";
  protected final String TEXT_136 = ".clear();" + NL + "                            for(java.io.File newFile_";
  protected final String TEXT_137 = " : originalFiles_";
  protected final String TEXT_138 = ") {" + NL + "                                originalMap_";
  protected final String TEXT_139 = ".put(util_";
  protected final String TEXT_140 = ".getFileChecksum(newFile_";
  protected final String TEXT_141 = "), newFile_";
  protected final String TEXT_142 = ");" + NL + "                            }*/" + NL + "                        }" + NL + "                        //fetchFilesOneTime_";
  protected final String TEXT_143 = " = util_";
  protected final String TEXT_144 = ".getFiles();                        " + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "                for(java.io.File file_";
  protected final String TEXT_145 = " : fetchFilesOneTime_";
  protected final String TEXT_146 = ") {" + NL + "                    if(!originalFiles_";
  protected final String TEXT_147 = ".contains(file_";
  protected final String TEXT_148 = ")) {" + NL + "           \t";
  protected final String TEXT_149 = NL + "                    \twhile(true){" + NL + "                        \tjava.io.FileInputStream fis_";
  protected final String TEXT_150 = " = null;" + NL + "                        \ttry{" + NL + "                            \tfis_";
  protected final String TEXT_151 = " = new java.io.FileInputStream(file_";
  protected final String TEXT_152 = ".getAbsolutePath());" + NL + "                        \t}catch(java.io.FileNotFoundException e){" + NL + "                            \tThread.sleep(3000);" + NL + "                            \tcontinue;" + NL + "                        \t}" + NL + "                        \tif(fis_";
  protected final String TEXT_153 = " != null){" + NL + "\t                    \t\ttry {" + NL + "\t                    \t\t\tfis_";
  protected final String TEXT_154 = ".close();" + NL + "\t                    \t\t} catch(Exception ex) {" + NL + "\t                    \t\t}" + NL + "                        \t}" + NL + "                        \tbreak;" + NL + "                    \t}";
  protected final String TEXT_155 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_156 = "_FILENAME\", file_";
  protected final String TEXT_157 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_158 = "_CREATED_FILE\", file_";
  protected final String TEXT_159 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_160 = " = true;" + NL + "                        originalFiles_";
  protected final String TEXT_161 = ".add(file_";
  protected final String TEXT_162 = ");" + NL + "                        /*originalFiles_";
  protected final String TEXT_163 = " = util_";
  protected final String TEXT_164 = ".getFiles();" + NL + "                        originalMap_";
  protected final String TEXT_165 = ".clear();" + NL + "                        for(java.io.File newFile_";
  protected final String TEXT_166 = " : originalFiles_";
  protected final String TEXT_167 = ") {" + NL + "                            originalMap_";
  protected final String TEXT_168 = ".put(util_";
  protected final String TEXT_169 = ".getFileChecksum(newFile_";
  protected final String TEXT_170 = "), newFile_";
  protected final String TEXT_171 = ");" + NL + "                        }" + NL + "                        fetchFilesOneTime_";
  protected final String TEXT_172 = " = util_";
  protected final String TEXT_173 = ".getFiles();       */             " + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "                for(java.io.File file_";
  protected final String TEXT_174 = " : fetchFilesOneTime_";
  protected final String TEXT_175 = ") {" + NL + "                    if(null == originalMap_";
  protected final String TEXT_176 = ".get(util_";
  protected final String TEXT_177 = ".getFileChecksum(file_";
  protected final String TEXT_178 = "))) {" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_179 = "_FILENAME\", file_";
  protected final String TEXT_180 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_181 = "_UPDATED_FILE\", file_";
  protected final String TEXT_182 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_183 = " = true;" + NL + "                        originalMap_";
  protected final String TEXT_184 = ".put(util_";
  protected final String TEXT_185 = ".getFileChecksum(file_";
  protected final String TEXT_186 = "), file_";
  protected final String TEXT_187 = ");//occur repeat value" + NL + "                       /* originalFiles_";
  protected final String TEXT_188 = " = util_";
  protected final String TEXT_189 = ".getFiles();" + NL + "                        originalMap_";
  protected final String TEXT_190 = ".clear();" + NL + "                        for(java.io.File newFile_";
  protected final String TEXT_191 = " : originalFiles_";
  protected final String TEXT_192 = ") {" + NL + "                            originalMap_";
  protected final String TEXT_193 = ".put(util_";
  protected final String TEXT_194 = ".getFileChecksum(newFile_";
  protected final String TEXT_195 = "), newFile_";
  protected final String TEXT_196 = ");" + NL + "                        }   */                 " + NL + "                        break;" + NL + "                    }" + NL + "                }               ";
  protected final String TEXT_197 = NL;
  protected final String TEXT_198 = "   " + NL + "                }";
  protected final String TEXT_199 = NL + "            count_";
  protected final String TEXT_200 = "++;" + NL + "            " + NL + "            globalMap.put(\"";
  protected final String TEXT_201 = "_CURRENT_ITERATION\", count_";
  protected final String TEXT_202 = ");" + NL + "            " + NL + "            if (!found_";
  protected final String TEXT_203 = ") {" + NL + "            \tThread.currentThread().sleep(";
  protected final String TEXT_204 = " * 1000);" + NL + "                continue;" + NL + "            }            " + NL;
  protected final String TEXT_205 = "\t" + NL + "\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = ((";
  protected final String TEXT_208 = ")globalMap.get(\"";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = "\"));";
  protected final String TEXT_211 = "            ";
  protected final String TEXT_212 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_SUBDIR__"));
    boolean present = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_PRESENT__"));
    String triggerAction = ElementParameterParser.getValue(node, "__ACTION_ON__");
    boolean waitRelease = ("true").equals(ElementParameterParser.getValue(node, "__WAIT_RELEASE__"));
    boolean nonUpdate = "true".equals(ElementParameterParser.getValue(node, "__NON_UPDATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__") );
    stringBuffer.append(TEXT_5);
    
                        if(incldSubdir==true)  {
                            
    stringBuffer.append(TEXT_6);
    
                        }   
                        
    stringBuffer.append(TEXT_7);
    
            if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_8);
    
            }
            
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
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
        }
        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
            if(!("").equals(ElementParameterParser.getValue(node,"__MAX_ITERATIONS__"))){
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__") );
    stringBuffer.append(TEXT_27);
    
            } 
            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
            if(present){
                
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
    
    			}
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
            if(("filecreated").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    	
           		if(waitRelease){
           	
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
    
            	}
            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
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
    
            } else if(("filedeleted").equals(triggerAction)) {
                
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
    
            } else if(("fileupdated").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    if(!nonUpdate){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }else{
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_119);
    
            } else if(("fileall").equals(triggerAction)) {
                
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
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
    	
           		if(waitRelease){
           	
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
    
            	}
            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
            }
            
    stringBuffer.append(TEXT_197);
    
            if(present) {
                
    stringBuffer.append(TEXT_198);
    
            }
            
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_204);
    	
	//*************************************************************//	
	//The following part will extract data from globalMap to schema in order to support the MAIN link simply.
	//step 1:
	
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
	if ( metadatas != null && metadatas.size() > 0 ) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn != null && firstColumnList != null)
	{
    	//step 2:
    
        String firstDataConnName = firstDataConn.getName();
        for (IMetadataColumn column: firstColumnList) {
        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstDataConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    
	    }
 	}

    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    return stringBuffer.toString();
  }
}
