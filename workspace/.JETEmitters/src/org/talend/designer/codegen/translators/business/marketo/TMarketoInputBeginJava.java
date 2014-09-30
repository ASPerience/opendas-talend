package org.talend.designer.codegen.translators.business.marketo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMarketoInputBeginJava
{
  protected static String nl;
  public static synchronized TMarketoInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoInputBeginJava result = new TMarketoInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);  ";
  protected final String TEXT_4 = NL + "\t\t\tString[] includeTypes_";
  protected final String TEXT_5 = " = " + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_8 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_9 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "        \tString[] excludeTypes_";
  protected final String TEXT_12 = " = " + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_15 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_16 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_18 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "; ";
  protected final String TEXT_24 = NL + "\t\t\torg.talend.marketo.Client client_";
  protected final String TEXT_25 = " = new org.talend.marketo.Client(";
  protected final String TEXT_26 = ",decryptedPassword_";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = ");" + NL + "\t\t\tclient_";
  protected final String TEXT_29 = ".setTimeout(";
  protected final String TEXT_30 = ");" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\t\tcom.marketo.www.mktows.ResultGetLead leads_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t\tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_33 = " = null;" + NL + "\t\t\ttry{" + NL + "\t\t\t\tleads_";
  protected final String TEXT_34 = " = client_";
  protected final String TEXT_35 = ".getLead(\"";
  protected final String TEXT_36 = "\",";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_39 = ");  " + NL + "\t\t\t\t" + NL + "\t\t\t\trecords_";
  protected final String TEXT_40 = " = leads_";
  protected final String TEXT_41 = ".getLeadRecordList();" + NL + "\t\t\t}catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_42 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tif(!client_";
  protected final String TEXT_43 = ".isSystemError(axisFault_";
  protected final String TEXT_44 = ")){" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_45 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_46 = ");  " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_47 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_49 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_52 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_53 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_54 = NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_55 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t            throw(ex_";
  protected final String TEXT_57 = ");" + NL + "\t\t        ";
  protected final String TEXT_58 = NL + "\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_59 = ".getMessage());" + NL + "\t\t        ";
  protected final String TEXT_60 = NL + "\t\t\t}" + NL + "\t\t\tif(leads_";
  protected final String TEXT_61 = " != null && records_";
  protected final String TEXT_62 = "!=null){" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_63 = " = 0; i_";
  protected final String TEXT_64 = " < leads_";
  protected final String TEXT_65 = ".getCount(); i_";
  protected final String TEXT_66 = "++) {" + NL + "\t            \tjava.util.Map<String, String> result_";
  protected final String TEXT_67 = " = client_";
  protected final String TEXT_68 = ".readLead(records_";
  protected final String TEXT_69 = "[i_";
  protected final String TEXT_70 = "]);";
  protected final String TEXT_71 = NL + "\t\t\tjava.text.SimpleDateFormat updatedAt_";
  protected final String TEXT_72 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "        \tupdatedAt_";
  protected final String TEXT_73 = ".parse(";
  protected final String TEXT_74 = ");" + NL + "            java.util.Calendar updatedAtCal_";
  protected final String TEXT_75 = " = updatedAt_";
  protected final String TEXT_76 = ".getCalendar();" + NL + "            String streamPosition_";
  protected final String TEXT_77 = " = null;" + NL + "            String[] includeAttributes_";
  protected final String TEXT_78 = " = new String[]{" + NL + "\t\t\t";
  protected final String TEXT_79 = "\t" + NL + "    \t\t\t";
  protected final String TEXT_80 = ",\t\t" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t};" + NL + "            while(true){" + NL + "            \tcom.marketo.www.mktows.ResultGetMultipleLeads leads_";
  protected final String TEXT_82 = " = null;" + NL + "            \ttry{ " + NL + "            \t\tleads_";
  protected final String TEXT_83 = " = client_";
  protected final String TEXT_84 = ".getMultipleLeads(includeAttributes_";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ", updatedAtCal_";
  protected final String TEXT_87 = ", streamPosition_";
  protected final String TEXT_88 = ");" + NL + "            \t\tglobalMap.put(\"";
  protected final String TEXT_89 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_90 = ");" + NL + "            \t}catch(java.lang.Exception ex_";
  protected final String TEXT_91 = "){" + NL + "            \t\tif(ex_";
  protected final String TEXT_92 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_93 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_94 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_95 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_96 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_98 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_99 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_100 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_101 = NL + "\t\t\t\t}" + NL + "            \tif(leads_";
  protected final String TEXT_102 = " != null){" + NL + "\t            \tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_103 = " = leads_";
  protected final String TEXT_104 = ".getLeadRecordList();" + NL + "\t            \tfor (int i_";
  protected final String TEXT_105 = " = 0; i_";
  protected final String TEXT_106 = " < leads_";
  protected final String TEXT_107 = ".getReturnCount(); i_";
  protected final String TEXT_108 = "++) {" + NL + "\t            \t\tjava.util.Map<String, String> result_";
  protected final String TEXT_109 = " = client_";
  protected final String TEXT_110 = ".readLead(records_";
  protected final String TEXT_111 = "[i_";
  protected final String TEXT_112 = "]);";
  protected final String TEXT_113 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_114 = " = null;" + NL + "\t\t\twhile(true){" + NL + "\t\t\t\tcom.marketo.www.mktows.LeadActivityList activities_";
  protected final String TEXT_115 = " = null;" + NL + "\t\t\t\tcom.marketo.www.mktows.ActivityRecord[] activityRecords_";
  protected final String TEXT_116 = " = null;" + NL + "                try{" + NL + "\t                activities_";
  protected final String TEXT_117 = " = client_";
  protected final String TEXT_118 = ".getLeadActivity(\"";
  protected final String TEXT_119 = "\",";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = ", includeTypes_";
  protected final String TEXT_122 = ", excludeTypes_";
  protected final String TEXT_123 = ",streamPosition_";
  protected final String TEXT_124 = ");" + NL + "\t                globalMap.put(\"";
  protected final String TEXT_125 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_126 = ");\t" + NL + "\t                activityRecords_";
  protected final String TEXT_127 = " = activities_";
  protected final String TEXT_128 = ".getActivityRecordList();" + NL + "\t            }catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_129 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(!client_";
  protected final String TEXT_130 = ".isSystemError(axisFault_";
  protected final String TEXT_131 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_132 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_133 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_134 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_136 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t            throw(ex_";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t        ";
  protected final String TEXT_139 = NL + "\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_140 = ".getMessage());" + NL + "\t\t\t\t\t        break;" + NL + "\t\t\t\t        ";
  protected final String TEXT_141 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_142 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_145 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_146 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_147 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif(activities_";
  protected final String TEXT_148 = " != null && activityRecords_";
  protected final String TEXT_149 = " != null){" + NL + "\t                for (int i_";
  protected final String TEXT_150 = " = 0; i_";
  protected final String TEXT_151 = " < activities_";
  protected final String TEXT_152 = ".getReturnCount(); i_";
  protected final String TEXT_153 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_154 = " = client_";
  protected final String TEXT_155 = ".readActivity(activityRecords_";
  protected final String TEXT_156 = "[i_";
  protected final String TEXT_157 = "]);";
  protected final String TEXT_158 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_159 = " = new com.marketo.www.mktows.StreamPosition();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestcreatedat_";
  protected final String TEXT_161 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_162 = " != null){" + NL + "\t\t        \toldestcreatedat_";
  protected final String TEXT_163 = ".parse(";
  protected final String TEXT_164 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestcreatedat_";
  protected final String TEXT_165 = " = oldestcreatedat_";
  protected final String TEXT_166 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_167 = ".setOldestCreatedAt(calendar_oldestcreatedat_";
  protected final String TEXT_168 = ");" + NL + "\t            }";
  protected final String TEXT_169 = NL + "\t            java.text.SimpleDateFormat latestcreatedat_";
  protected final String TEXT_170 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_171 = " != null){" + NL + "\t\t        \tlatestcreatedat_";
  protected final String TEXT_172 = ".parse(";
  protected final String TEXT_173 = ");" + NL + "\t\t            java.util.Calendar calendar_latestcreatedat_";
  protected final String TEXT_174 = " = latestcreatedat_";
  protected final String TEXT_175 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_176 = ".setLatestCreatedAt(calendar_latestcreatedat_";
  protected final String TEXT_177 = ");" + NL + "\t\t        }";
  protected final String TEXT_178 = NL + "            " + NL + "            com.marketo.www.mktows.LastUpdateAtSelector leadSelector_";
  protected final String TEXT_179 = " = new com.marketo.www.mktows.LastUpdateAtSelector();" + NL + "            ";
  protected final String TEXT_180 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestupdatedat_";
  protected final String TEXT_181 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_182 = " != null){" + NL + "\t\t        \toldestupdatedat_";
  protected final String TEXT_183 = ".parse(";
  protected final String TEXT_184 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestupdatedat_";
  protected final String TEXT_185 = " = oldestupdatedat_";
  protected final String TEXT_186 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_187 = ".setOldestUpdatedAt(calendar_oldestupdatedat_";
  protected final String TEXT_188 = ");" + NL + "\t            }";
  protected final String TEXT_189 = NL + "\t            java.text.SimpleDateFormat latestupdatedat_";
  protected final String TEXT_190 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_191 = " != null){" + NL + "\t\t        \tlatestupdatedat_";
  protected final String TEXT_192 = ".parse(";
  protected final String TEXT_193 = ");" + NL + "\t\t            java.util.Calendar calendar_latestupdatedat_";
  protected final String TEXT_194 = " = latestupdatedat_";
  protected final String TEXT_195 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_196 = ".setLatestUpdatedAt(calendar_latestupdatedat_";
  protected final String TEXT_197 = ");" + NL + "\t\t        }";
  protected final String TEXT_198 = NL + "            " + NL + "            " + NL + "            while(true){" + NL + "                com.marketo.www.mktows.ResultGetLeadChanges changes_";
  protected final String TEXT_199 = " = null;" + NL + "                try{" + NL + "                \tchanges_";
  protected final String TEXT_200 = " = client_";
  protected final String TEXT_201 = ".getLeadChanges(";
  protected final String TEXT_202 = ", includeTypes_";
  protected final String TEXT_203 = ", excludeTypes_";
  protected final String TEXT_204 = ", streamPosition_";
  protected final String TEXT_205 = ", leadSelector_";
  protected final String TEXT_206 = ");" + NL + "                \tglobalMap.put(\"";
  protected final String TEXT_207 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_208 = ");" + NL + "                }catch(java.lang.Exception ex_";
  protected final String TEXT_209 = "){" + NL + "                \tif(ex_";
  protected final String TEXT_210 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_211 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_212 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_213 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_214 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_216 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_217 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_218 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_219 = NL + "\t\t\t\t}" + NL + "                if(changes_";
  protected final String TEXT_220 = " != null){" + NL + "\t                com.marketo.www.mktows.LeadChangeRecord[] changeRecords_";
  protected final String TEXT_221 = " = changes_";
  protected final String TEXT_222 = ".getLeadChangeRecordList();" + NL + "\t                for (int i_";
  protected final String TEXT_223 = " = 0; i_";
  protected final String TEXT_224 = " < changes_";
  protected final String TEXT_225 = ".getReturnCount(); i_";
  protected final String TEXT_226 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_227 = " = client_";
  protected final String TEXT_228 = ".readChange(changeRecords_";
  protected final String TEXT_229 = "[i_";
  protected final String TEXT_230 = "]);";
  protected final String TEXT_231 = NL + "\t\t\t\tif(result_";
  protected final String TEXT_232 = ".get(";
  protected final String TEXT_233 = ")!=null){" + NL + "    \t\t\t";
  protected final String TEXT_234 = "\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = result_";
  protected final String TEXT_237 = ".get(";
  protected final String TEXT_238 = ");" + NL + "    \t\t\t";
  protected final String TEXT_239 = NL + "    \t\t\t\t\t";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = " = ParserUtils.parseTo_Date(result_";
  protected final String TEXT_242 = ".get(";
  protected final String TEXT_243 = "), ";
  protected final String TEXT_244 = ");" + NL + "    \t\t\t";
  protected final String TEXT_245 = "\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " = ParserUtils.parseTo_";
  protected final String TEXT_248 = "(result_";
  protected final String TEXT_249 = ".get(";
  protected final String TEXT_250 = "));\t" + NL + "    \t\t\t";
  protected final String TEXT_251 = NL + "    \t\t\t}else{" + NL + "    \t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = ";
  protected final String TEXT_254 = ";" + NL + "    \t\t\t}";
  protected final String TEXT_255 = NL + NL + NL + NL + "        ";
  protected final String TEXT_256 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) { //1
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) { //2
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){ //3
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4

            String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

            String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
            String operation = ElementParameterParser.getValue(node, "__OPERATION__");
            String leadKeyType = ElementParameterParser.getValue(node, "__LEAD_KEYTYPE__");
            String leadKeyValue = ElementParameterParser.getValue(node, "__LEAD_KEYVALUE__");
            String mutipleLeadsLastUpdatedAt = ElementParameterParser.getValue(node, "__MUTIPLE_LEADS_LASTUPDATEDAT__");
            String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
            String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
            boolean setIncludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_INCLUDE_TYPES__"));
            boolean setExcludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_EXCLUDE_TYPES__"));
			List<Map<String, String>> includeTypesList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__INCLUDE_TYPES__");
			List<Map<String, String>> excludeTypesList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXCLUDE_TYPES__");
            boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
			List<String> includeTypes = null;
			if(setIncludeTypes){
				includeTypes = new ArrayList<String>();
    			for(Map<String,String> includeTypesMap:includeTypesList){
    				includeTypes.add(includeTypesMap.get("TYPES").toString());
    			} 
			}
			List<String> excludeTypes = null;
			if(setExcludeTypes){
				excludeTypes = new ArrayList<String>();
    			for(Map<String,String> excludeTypesMap:excludeTypesList){
    				excludeTypes.add(excludeTypesMap.get("TYPES").toString());
    			} 
			}
			if("getLeadChanges".equals(operation)||"getLeadActivity".equals(operation)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(includeTypes==null){
    stringBuffer.append(TEXT_6);
    }else{
    stringBuffer.append(TEXT_7);
    for(String includeType:includeTypes){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(includeType);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(excludeTypes==null){
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    for(String excludeType:excludeTypes){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(excludeType);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    }
    
			}
			List<Map<String, String>> mappingList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
			Map<String,String> fldMapping = new HashMap<String,String>();
			for(Map<String,String> inputMapping:mappingList){
				String mapStr = inputMapping.get("PARAMETER_NAME");
				if("\"\"".equals(mapStr)){
					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),"\""+inputMapping.get("SCHEMA_COLUMN")+"\"");
				}else{	
					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),inputMapping.get("PARAMETER_NAME"));
				}
			}

    
            String passwordFieldName = "__SECRET_KEY__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_30);
    
			if("getLead".equals(operation)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			        } else {
			        
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
			        }
			        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		        if (dieOnError) {
		        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
		        } else {
		        
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		        }
		        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    			
			}else if("getMutipleLeads".equals(operation)){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(mutipleLeadsLastUpdatedAt);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    for(String key:fldMapping.keySet()){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(fldMapping.get(key));
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
			        } else {
			        
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
			        }
			        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
			}else if("getLeadActivity".equals(operation)){

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
				        if (dieOnError) {
				        
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
				        } else {
				        
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
				        }
				        
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
			        } else {
			        
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
			        }
			        
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
			}else if("getLeadChanges".equals(operation)){
				String oldestcreatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTCREATEDAT__");
				String latestcreatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTCREATEDAT__");
				String oldestupdatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTUPDATEDAT__");
				String latestupdatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTUPDATEDAT__");

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(!"".equals(oldestcreatedat) && !"\"\"".equals(oldestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestcreatedat)){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    if(!"".equals(latestcreatedat) && !"\"\"".equals(latestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestcreatedat)){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    if(!"".equals(oldestupdatedat) && !"\"\"".equals(oldestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestupdatedat)){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    }
    if(!"".equals(latestupdatedat) && !"\"\"".equals(latestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestupdatedat)){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
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
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
			        } else {
			        
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
			        }
			        
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
			}
			

			for( int i = 0; i < columnList.size(); i++) {
			
				IMetadataColumn column = columnList.get(i);
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_233);
    	
    				if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_238);
    
    				} else if(javaType == JavaTypesManager.DATE) { // Date
    			
    stringBuffer.append(TEXT_239);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_243);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_244);
    
    				}  else  { // other
    			
    stringBuffer.append(TEXT_245);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_247);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_250);
    
    				}
    			
    stringBuffer.append(TEXT_251);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_254);
    
			}
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_255);
    stringBuffer.append(TEXT_256);
    return stringBuffer.toString();
  }
}
