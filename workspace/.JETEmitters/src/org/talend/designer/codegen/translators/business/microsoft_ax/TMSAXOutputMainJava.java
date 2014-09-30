package org.talend.designer.codegen.translators.business.microsoft_ax;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedList;

public class TMSAXOutputMainJava
{
  protected static String nl;
  public static synchronized TMSAXOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSAXOutputMainJava result = new TMSAXOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;            ";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\trecord_";
  protected final String TEXT_5 = ".callMethod(\"ExecuteStmt\", new Object[] { ";
  protected final String TEXT_6 = "});" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tdynRec_";
  protected final String TEXT_8 = ".invoke(\"ExecuteStmt\", new Object[] { ";
  protected final String TEXT_9 = " });" + NL + "\t";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "\t\trecord_";
  protected final String TEXT_12 = ".callMethod(\"InitValue\");" + NL + "\t";
  protected final String TEXT_13 = NL + "    whetherReject_";
  protected final String TEXT_14 = " = false;";
  protected final String TEXT_15 = NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\trecord_";
  protected final String TEXT_17 = ".put(\"field\",new Object[]{";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = "});" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tdynRec_";
  protected final String TEXT_21 = ".invoke(\"set_Field\", new Object[] { \"";
  protected final String TEXT_22 = "\", ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " });" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "    try{" + NL + "    \t";
  protected final String TEXT_26 = NL + "        \trecord_";
  protected final String TEXT_27 = ".callMethod(\"Insert\");";
  protected final String TEXT_28 = NL + "        \tdynRec_";
  protected final String TEXT_29 = ".invoke(\"Insert\");";
  protected final String TEXT_30 = NL + "        insertedCount_";
  protected final String TEXT_31 = "++;" + NL + "        nb_line_";
  protected final String TEXT_32 = "++;" + NL + "    }catch(java.lang.Exception e){" + NL + "        whetherReject_";
  protected final String TEXT_33 = " = true;";
  protected final String TEXT_34 = NL + "            throw(e);";
  protected final String TEXT_35 = NL + "            ";
  protected final String TEXT_36 = " = new ";
  protected final String TEXT_37 = "Struct();";
  protected final String TEXT_38 = NL + "            ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ";";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_45 = NL + "            ";
  protected final String TEXT_46 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "            System.err.print(e.getMessage());";
  protected final String TEXT_49 = NL + "    }";
  protected final String TEXT_50 = NL + "        try{" + NL + "        \t";
  protected final String TEXT_51 = NL + "            \twhile(record_";
  protected final String TEXT_52 = ".get(\"Found\").getObjectAsBoolean()){";
  protected final String TEXT_53 = NL + "            \twhile(((Boolean)dynRec_";
  protected final String TEXT_54 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "            \t\tnetBC_";
  protected final String TEXT_55 = ".invoke(\"TTSBegin\");";
  protected final String TEXT_56 = NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\trecord_";
  protected final String TEXT_58 = ".put(\"field\",new Object[]{";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = "});" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tdynRec_";
  protected final String TEXT_62 = ".invoke(\"set_Field\", new Object[]{\"";
  protected final String TEXT_63 = "\", ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "});" + NL + "\t\t\t";
  protected final String TEXT_66 = "\t" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\trecord_";
  protected final String TEXT_68 = ".callMethod(\"Update\");" + NL + "                record_";
  protected final String TEXT_69 = ".callMethod(\"Next\");";
  protected final String TEXT_70 = NL + "            \tdynRec_";
  protected final String TEXT_71 = ".invoke(\"Update\");" + NL + "            \tnetBC_";
  protected final String TEXT_72 = ".invoke(\"TTSCommit\");" + NL + "            \tdynRec_";
  protected final String TEXT_73 = ".invoke(\"Next\");";
  protected final String TEXT_74 = NL + "                updatedCount_";
  protected final String TEXT_75 = "++;" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_76 = "++;" + NL + "        }catch(java.lang.Exception e){" + NL + "            whetherReject_";
  protected final String TEXT_77 = " = true;";
  protected final String TEXT_78 = NL + "                throw(e);";
  protected final String TEXT_79 = NL + "                    ";
  protected final String TEXT_80 = " = new ";
  protected final String TEXT_81 = "Struct();";
  protected final String TEXT_82 = NL + "                    ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "                    ";
  protected final String TEXT_88 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_89 = NL + "                    ";
  protected final String TEXT_90 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_93 = NL + "        }";
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\tif(record_";
  protected final String TEXT_96 = ".get(\"Found\").getObjectAsBoolean()){" + NL + "            try{" + NL + "\t\t\t\twhile(record_";
  protected final String TEXT_97 = ".get(\"Found\").getObjectAsBoolean()){" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\tif(((Boolean)dynRec_";
  protected final String TEXT_99 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "            try{" + NL + "\t\t\t\twhile(((Boolean)dynRec_";
  protected final String TEXT_100 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "\t\t\t\t\tnetBC_";
  protected final String TEXT_101 = ".invoke(\"TTSBegin\");";
  protected final String TEXT_102 = NL + "\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\trecord_";
  protected final String TEXT_104 = ".put(\"field\",new Object[]{";
  protected final String TEXT_105 = ",";
  protected final String TEXT_106 = "});" + NL + "\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\tdynRec_";
  protected final String TEXT_108 = ".invoke(\"set_Field\", new Object[]{\"";
  protected final String TEXT_109 = "\", ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = "});" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\trecord_";
  protected final String TEXT_114 = ".callMethod(\"Update\");" + NL + "\t\t                record_";
  protected final String TEXT_115 = ".callMethod(\"Next\");" + NL + "\t\t            ";
  protected final String TEXT_116 = NL + "\t\t            \tdynRec_";
  protected final String TEXT_117 = ".invoke(\"Update\");" + NL + "\t\t            \tnetBC_";
  protected final String TEXT_118 = ".invoke(\"TTSCommit\");" + NL + "\t\t            \tdynRec_";
  protected final String TEXT_119 = ".invoke(\"Next\");" + NL + "\t\t            ";
  protected final String TEXT_120 = NL + "                \tupdatedCount_";
  protected final String TEXT_121 = "++;" + NL + "            \t}" + NL + "            }catch(java.lang.Exception e){" + NL + "                whetherReject_";
  protected final String TEXT_122 = " = true;";
  protected final String TEXT_123 = NL + "                    throw(e);";
  protected final String TEXT_124 = NL + "                    ";
  protected final String TEXT_125 = " = new ";
  protected final String TEXT_126 = "Struct();";
  protected final String TEXT_127 = NL + "                            ";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "                        ";
  protected final String TEXT_133 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_134 = NL + "                        ";
  protected final String TEXT_135 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_138 = NL + "            }" + NL + "\t\t}else{ //insert" + NL + "            try{";
  protected final String TEXT_139 = NL + "\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\trecord_";
  protected final String TEXT_141 = ".put(\"field\",new Object[]{";
  protected final String TEXT_142 = ",";
  protected final String TEXT_143 = "});" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\tdynRec_";
  protected final String TEXT_145 = ".invoke(\"set_Field\", new Object[] { \"";
  protected final String TEXT_146 = "\", ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " });" + NL + "\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t        \trecord_";
  protected final String TEXT_150 = ".callMethod(\"Insert\");" + NL + "\t\t        ";
  protected final String TEXT_151 = NL + "\t\t        \tdynRec_";
  protected final String TEXT_152 = ".invoke(\"Insert\");" + NL + "\t\t        ";
  protected final String TEXT_153 = NL + "        \t\tinsertedCount_";
  protected final String TEXT_154 = "++;" + NL + "            }catch(java.lang.Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_155 = " = true;";
  protected final String TEXT_156 = NL + "                    throw(e);";
  protected final String TEXT_157 = NL + "                    ";
  protected final String TEXT_158 = " = new ";
  protected final String TEXT_159 = "Struct();";
  protected final String TEXT_160 = NL + "                    ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = ";";
  protected final String TEXT_165 = NL + "                    ";
  protected final String TEXT_166 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_167 = NL + "                    ";
  protected final String TEXT_168 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_169 = ";";
  protected final String TEXT_170 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_171 = NL + "            }" + NL + "\t\t}" + NL + "\t\tnb_line_";
  protected final String TEXT_172 = "++;";
  protected final String TEXT_173 = NL + "\t\tint updateFlag_";
  protected final String TEXT_174 = "=0;" + NL + "        try{" + NL + "       \t\t";
  protected final String TEXT_175 = NL + "            \twhile(record_";
  protected final String TEXT_176 = ".get(\"Found\").getObjectAsBoolean()){";
  protected final String TEXT_177 = NL + "            \twhile(((Boolean)dynRec_";
  protected final String TEXT_178 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "            \t\tnetBC_";
  protected final String TEXT_179 = ".invoke(\"TTSBegin\");";
  protected final String TEXT_180 = NL + "\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\trecord_";
  protected final String TEXT_182 = ".put(\"field\",new Object[]{";
  protected final String TEXT_183 = ",";
  protected final String TEXT_184 = "});" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\tdynRec_";
  protected final String TEXT_186 = ".invoke(\"set_Field\", new Object[]{\"";
  protected final String TEXT_187 = "\", ";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = "});" + NL + "\t\t\t\t";
  protected final String TEXT_190 = "\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\trecord_";
  protected final String TEXT_192 = ".callMethod(\"Update\");" + NL + "\t                record_";
  protected final String TEXT_193 = ".callMethod(\"Next\");" + NL + "\t            ";
  protected final String TEXT_194 = NL + "\t            \tdynRec_";
  protected final String TEXT_195 = ".invoke(\"Update\");" + NL + "\t            \tnetBC_";
  protected final String TEXT_196 = ".invoke(\"TTSCommit\");" + NL + "\t            \tdynRec_";
  protected final String TEXT_197 = ".invoke(\"Next\");" + NL + "\t            ";
  protected final String TEXT_198 = NL + "                updateFlag_";
  protected final String TEXT_199 = "++;" + NL + "                updatedCount_";
  protected final String TEXT_200 = "++;" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_201 = "++;" + NL + "        }catch(java.lang.Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_202 = " = true;";
  protected final String TEXT_203 = NL + "                throw(e);";
  protected final String TEXT_204 = NL + "                ";
  protected final String TEXT_205 = " = new ";
  protected final String TEXT_206 = "Struct();";
  protected final String TEXT_207 = NL + "                ";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "                ";
  protected final String TEXT_213 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_214 = NL + "                ";
  protected final String TEXT_215 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_216 = ";";
  protected final String TEXT_217 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_218 = NL + "        }" + NL + "        if(updateFlag_";
  protected final String TEXT_219 = " == 0) {" + NL + "            try{";
  protected final String TEXT_220 = NL + "\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\trecord_";
  protected final String TEXT_222 = ".put(\"field\",new Object[]{";
  protected final String TEXT_223 = ",";
  protected final String TEXT_224 = "});" + NL + "\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\tdynRec_";
  protected final String TEXT_226 = ".invoke(\"set_Field\", new Object[] { \"";
  protected final String TEXT_227 = "\", ";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = " });" + NL + "\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t        \trecord_";
  protected final String TEXT_231 = ".callMethod(\"Insert\");" + NL + "\t\t        ";
  protected final String TEXT_232 = NL + "\t\t        \tdynRec_";
  protected final String TEXT_233 = ".invoke(\"Insert\");" + NL + "\t\t        ";
  protected final String TEXT_234 = NL + "        \t\tinsertedCount_";
  protected final String TEXT_235 = "++;" + NL + "            }catch(java.lang.Exception e){" + NL + "                whetherReject_";
  protected final String TEXT_236 = " = true;";
  protected final String TEXT_237 = NL + "                    throw(e);";
  protected final String TEXT_238 = NL + "                    ";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " = ";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = ";";
  protected final String TEXT_243 = NL + "                    ";
  protected final String TEXT_244 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_245 = NL + "                    ";
  protected final String TEXT_246 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_247 = ";";
  protected final String TEXT_248 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_249 = NL + "            }" + NL + "        }" + NL + "        nb_line_";
  protected final String TEXT_250 = "++;";
  protected final String TEXT_251 = NL + "    try{" + NL + "    \t";
  protected final String TEXT_252 = NL + "\t    while(record_";
  protected final String TEXT_253 = ".get(\"Found\").getObjectAsBoolean()){" + NL + "\t\t\trecord_";
  protected final String TEXT_254 = ".callMethod(\"Delete\");" + NL + "            record_";
  protected final String TEXT_255 = ".callMethod(\"Next\");" + NL + "            updatedCount_";
  protected final String TEXT_256 = "++;" + NL + "        }";
  protected final String TEXT_257 = NL + "        while(((Boolean)dynRec_";
  protected final String TEXT_258 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "            netBC_";
  protected final String TEXT_259 = ".invoke(\"TTSBegin\");" + NL + "\t\t\tdynRec_";
  protected final String TEXT_260 = ".invoke(\"Delete\");" + NL + "            netBC_";
  protected final String TEXT_261 = ".invoke(\"TTSCommit\");" + NL + "            dynRec_";
  protected final String TEXT_262 = ".invoke(\"Next\");" + NL + "            updatedCount_";
  protected final String TEXT_263 = "++;" + NL + "        }\t";
  protected final String TEXT_264 = NL + "    }catch(java.lang.Exception e){" + NL + "        whetherReject_";
  protected final String TEXT_265 = " = true;";
  protected final String TEXT_266 = NL + "            throw(e);";
  protected final String TEXT_267 = NL + "            ";
  protected final String TEXT_268 = " = new ";
  protected final String TEXT_269 = "Struct();";
  protected final String TEXT_270 = NL + "            ";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = ";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = ";";
  protected final String TEXT_275 = NL + "            ";
  protected final String TEXT_276 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_277 = NL + "            ";
  protected final String TEXT_278 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_281 = NL + "    }" + NL + "    nb_line_";
  protected final String TEXT_282 = "++;";
  protected final String TEXT_283 = NL + "        if(!whetherReject_";
  protected final String TEXT_284 = ") {";
  protected final String TEXT_285 = NL + "        \t";
  protected final String TEXT_286 = " = new ";
  protected final String TEXT_287 = "Struct();";
  protected final String TEXT_288 = NL + "       \t\t";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = " = ";
  protected final String TEXT_291 = ".";
  protected final String TEXT_292 = ";";
  protected final String TEXT_293 = NL + "        }";
  protected final String TEXT_294 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String axTable = ElementParameterParser.getValue(node,"__TABLE__");
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

	String incomingConnName = null;
	List<IMetadataColumn> columnList = null;
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}
	
	String rejectConnName = null;
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
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
          }
    }

class Column{
	IMetadataColumn column;
	String name;
	String dataType;
	String operator;
	String DBname;
	String value;
	boolean addCol;
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String value,boolean addCol, String dataType){
		this.column = null;
		this.name=colName;
		this.DBname = colName;
		this.value = value;
		this.addCol =addCol;
		this.dataType = dataType;
	}
	
	public Column(IMetadataColumn column, String rowName){
		this.column = column;
		this.name = column.getLabel();
		this.value =rowName+"."+name;
		this.addCol =false;
		this.DBname=column.getOriginalDbColumnName();
		this.dataType=JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	}

	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
}

class VariantTool{
	public String vStr(String value){
		return "new org.jinterop.dcom.core.JIVariant(new org.jinterop.dcom.core.JIString("+value+"))";
	}

	public String vCulomnVale(Column column,String rowName){
		if(("String").equals(column.dataType)){
			return vStr(column.value);
		}else if(("Int").equals(column.dataType) || ("Float").equals(column.dataType) || ("Double").equals(column.dataType)
			|| ("Short").equals(column.dataType) || ("Char").equals(column.dataType) || ("Object").equals(column.dataType)
			|| ("Date").equals(column.dataType) || ("Boolean").equals(column.dataType)){
			return "new org.jinterop.dcom.core.JIVariant("+column.value+")";
		}
		return "new org.jinterop.dcom.core.JIVariant.EMPTY";
	}
	
	public String whereStatement(Column column, String connectionType){
		if("DCOM".equals(connectionType)){
			return column.name + " " + column.operator + " \\\"\"+" + column.value + "+\"\\\"";
		}else{
			StringBuffer whereStatement = new StringBuffer();
			whereStatement.append(column.name);
			whereStatement.append(" ");
			whereStatement.append(column.operator);
			whereStatement.append(" ");
			if(("Int").equals(column.dataType) || ("Float").equals(column.dataType) || ("Double").equals(column.dataType)
				|| ("Short").equals(column.dataType) || ("Long").equals(column.dataType) || ("BigDecimal").equals(column.dataType)){
				whereStatement.append("\"+");
				whereStatement.append(column.value);
				whereStatement.append("+\"");
			}else{
				whereStatement.append("\\\"\"+");
				whereStatement.append(column.value);
				whereStatement.append("+\"\\\"");
			}	
			return whereStatement.toString();
		}
	}
}
VariantTool vTool = new VariantTool();

List<Column> stmtStructure =  new LinkedList<Column>();
for(IMetadataColumn column:columnList){
    Column myColumn = new Column(column,incomingConnName);
    myColumn.operator = "==";
	stmtStructure.add(myColumn);
}

for(IMetadataColumn column:columnList){
	if(addCols != null && addCols.size()>0){
		for(Map<String, String> addCol:addCols){
			if(addCol.get("REFCOL").equals(column.getLabel())){
				int stmtIndex = 0;
				for(Column stmtStr:stmtStructure){					
					if(stmtStr.name.equals(addCol.get("REFCOL"))){
						break;
					}
					stmtIndex++;
				}
				
				if(("AFTER").equals(addCol.get("POS"))){
					Column insertAfter = new Column(addCol.get("NAME").replaceAll("\"",""),addCol.get("SQL"),true,addCol.get("DATATYPE"));
					insertAfter.dataType = addCol.get("DATATYPE");
					insertAfter.operator = addCol.get("OPERATOR");
					stmtStructure.add(stmtIndex+1,insertAfter);
				}else if(("BEFORE").equals(addCol.get("POS"))){
					Column insertBefore = new Column(addCol.get("NAME").replaceAll("\"",""),addCol.get("SQL"),true,addCol.get("DATATYPE"));
					insertBefore.dataType = addCol.get("DATATYPE");
					insertBefore.operator = addCol.get("OPERATOR");
					stmtStructure.add(stmtIndex,insertBefore);
				}else if(("REPLACE").equals(addCol.get("POS"))){
					Column replacementCol = new Column(addCol.get("NAME").replaceAll("\"",""),addCol.get("SQL"),true,addCol.get("DATATYPE"));
					replacementCol.dataType = addCol.get("DATATYPE");
					replacementCol.operator = addCol.get("OPERATOR");
					Column replacedCol = (Column) stmtStructure.get(stmtIndex);
					replacedCol.replace(replacementCol);
				}
			}
		}
	}
}

List<Column> insertValueList = new LinkedList<Column>();
List<Column> updateValueList = new LinkedList<Column>();
StringBuilder whereStmt = new StringBuilder();
for(Column column : stmtStructure) {
    if(column.isReplaced()) {
        List<Column> replacedColumns = column.getReplacement();          
        for(Column replacedColumn : replacedColumns) {
			insertValueList.add(replacedColumn);
            if(column.column.isKey()) {
            	if(whereStmt.length()>0){
            		whereStmt.append(" && ");
            		//whereStmt.append("%1." + replacedColumn.name + " " + replacedColumn.operator + " \\\"\"+" + replacedColumn.value + "+\"\\\"" );
            		whereStmt.append("%1." + vTool.whereStatement(replacedColumn, connectionType));
            	}else{
            		//whereStmt.append(" %1." + replacedColumn.name + " " + replacedColumn.operator + " \\\"\"+" + replacedColumn.value+ "+\"\\\"");
            		whereStmt.append(" %1." + vTool.whereStatement(replacedColumn, connectionType));
            	}
            } else {
                updateValueList.add(replacedColumn);
            }
        }
    } else {
        if(column.addCol) {
            insertValueList.add(column);
			updateValueList.add(column);
        } else {
            insertValueList.add(column);
            if(column.column.isKey()) {
            	if(whereStmt.length()>0){
            		whereStmt.append(" && ");
            		//whereStmt.append("%1." + column.name + " " + column.operator + " \\\"\"+" + column.value+"+\"\\\"");
            		whereStmt.append("%1." + vTool.whereStatement(column, connectionType));
            	}else{
            		//whereStmt.append(" %1." + column.name + " " + column.operator + " \\\"\"+" + column.value+"+\"\\\"");
            		whereStmt.append(" %1." + vTool.whereStatement(column, connectionType));
            	}
            } else {
                updateValueList.add(column);
            }
        }
    }
}

//select recode
if(!("INSERT").equals(dataAction)){
	String executeStmt = "\"select forupdate %1 where"+whereStmt.toString()+"\"";

    stringBuffer.append(TEXT_3);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(vTool.vStr(executeStmt));
    stringBuffer.append(TEXT_6);
    }else{
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(executeStmt);
    stringBuffer.append(TEXT_9);
    }
    
}else{

    stringBuffer.append(TEXT_10);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    }
    
}



if(incomingConnName != null && columnList != null){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
    if(("INSERT").equals(dataAction)){
		for(Column column : insertValueList){

    stringBuffer.append(TEXT_15);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_19);
    }else{
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_24);
    }
    
		}

    stringBuffer.append(TEXT_25);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
        if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_34);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_37);
    
                for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    
                }

    stringBuffer.append(TEXT_43);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_47);
    
            } else {

    stringBuffer.append(TEXT_48);
    
            }
        } 

    stringBuffer.append(TEXT_49);
    
	}else if(("UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_50);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    
		for(Column column : updateValueList){

    stringBuffer.append(TEXT_56);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_60);
    }else{
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_65);
    }
    
		}

    stringBuffer.append(TEXT_66);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }else{
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
            if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_78);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_81);
    
                    for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    
                    }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_91);
    
                } else {

    stringBuffer.append(TEXT_92);
    
                }
            } 

    stringBuffer.append(TEXT_93);
    
	}else if (("INSERT_OR_UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_94);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }else{
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    
		for(Column column : updateValueList){

    stringBuffer.append(TEXT_102);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_106);
    }else{
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_111);
    }
    
		}

    stringBuffer.append(TEXT_112);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    }else{
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
                if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_123);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_126);
    
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    
                        }

    stringBuffer.append(TEXT_132);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_136);
    
                    } else {

    stringBuffer.append(TEXT_137);
    
                    }
                }

    stringBuffer.append(TEXT_138);
    
			for(Column column : insertValueList){

    stringBuffer.append(TEXT_139);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_143);
    }else{
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_148);
    }
    
			}

    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    }else{
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
                if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_156);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_159);
    
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_160);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_164);
    
                        }

    stringBuffer.append(TEXT_165);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_169);
    
                    } else {

    stringBuffer.append(TEXT_170);
    
                    }
                }

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	}else if (("UPDATE_OR_INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }else{
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    }
    
		for(Column column : updateValueList){

    stringBuffer.append(TEXT_180);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_184);
    }else{
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_189);
    }
    
		}

    stringBuffer.append(TEXT_190);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }else{
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
            if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_203);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_206);
    
                    for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    
                    }

    stringBuffer.append(TEXT_212);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_216);
    
                } else {

    stringBuffer.append(TEXT_217);
    
                }
            }

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
			for(Column column : insertValueList){

    stringBuffer.append(TEXT_220);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(vTool.vStr("\""+column.name+"\""));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(vTool.vCulomnVale(column,incomingConnName));
    stringBuffer.append(TEXT_224);
    }else{
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.name);
    stringBuffer.append(TEXT_229);
    }
    
			}

    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    }else{
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
                if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_237);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_242);
    
                        }

    stringBuffer.append(TEXT_243);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_247);
    
                    } else {

    stringBuffer.append(TEXT_248);
    
                    }
                }

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
	}else if (("DELETE").equals(dataAction)){

    stringBuffer.append(TEXT_251);
    if("DCOM".equals(connectionType)){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    }else{
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
        if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_266);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_269);
    
                for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_274);
    
            	}

    stringBuffer.append(TEXT_275);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_279);
    
            } else {

    stringBuffer.append(TEXT_280);
    
            }
        }

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
	}
	
    if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
            for(IConnection outgoingConn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_286);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_287);
    
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_288);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_292);
    
                        }
                    }
                }
            }

    stringBuffer.append(TEXT_293);
    
    }
}

    stringBuffer.append(TEXT_294);
    return stringBuffer.toString();
  }
}
