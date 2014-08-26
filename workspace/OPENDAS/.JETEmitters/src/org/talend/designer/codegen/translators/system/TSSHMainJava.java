package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;
import java.lang.StringBuilder;

public class TSSHMainJava
{
  protected static String nl;
  public static synchronized TSSHMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHMainJava result = new TSSHMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t/* Create a session */" + NL + "\t\tch.ethz.ssh2.Session sess_";
  protected final String TEXT_3 = " = conn_";
  protected final String TEXT_4 = ".openSession();";
  protected final String TEXT_5 = NL + "\t\t\tsess_";
  protected final String TEXT_6 = ".requestDumbPTY();" + NL + "\t        sess_";
  protected final String TEXT_7 = ".startShell();";
  protected final String TEXT_8 = NL + "\t\t\t\t\tsess_";
  protected final String TEXT_9 = ".getStdin().write((";
  protected final String TEXT_10 = "+\"\\n\").getBytes());";
  protected final String TEXT_11 = NL + "\t\t\tsess_";
  protected final String TEXT_12 = ".getStdin().write(\"exit\\n\".getBytes());";
  protected final String TEXT_13 = NL + "        \t\tStringBuilder command_";
  protected final String TEXT_14 = " = new StringBuilder();";
  protected final String TEXT_15 = NL + "\t                if(command_";
  protected final String TEXT_16 = ".length() > 0){" + NL + "\t                \tcommand_";
  protected final String TEXT_17 = ".append(";
  protected final String TEXT_18 = ");" + NL + "\t                }" + NL + "\t                ";
  protected final String TEXT_19 = NL + "\t       \t\t    command_";
  protected final String TEXT_20 = ".append(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\tsess_";
  protected final String TEXT_23 = ".execCommand((command_";
  protected final String TEXT_24 = ").toString());" + NL;
  protected final String TEXT_25 = NL + NL + "\t\tjava.io.InputStream stdout_";
  protected final String TEXT_26 = " = sess_";
  protected final String TEXT_27 = ".getStdout();" + NL + "\t\tjava.io.BufferedReader brout_";
  protected final String TEXT_28 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stdout_";
  protected final String TEXT_29 = "));" + NL + "        String line_";
  protected final String TEXT_30 = " = \"\";" + NL + "        StringBuilder stringStdout_";
  protected final String TEXT_31 = " =new StringBuilder();" + NL + "" + NL + "        if((line_";
  protected final String TEXT_32 = " = brout_";
  protected final String TEXT_33 = ".readLine()) != null){" + NL + "            stringStdout_";
  protected final String TEXT_34 = ".append(line_";
  protected final String TEXT_35 = ");" + NL + "        }" + NL + "\t\twhile((line_";
  protected final String TEXT_36 = " = brout_";
  protected final String TEXT_37 = ".readLine()) != null){" + NL + "\t\t\tstringStdout_";
  protected final String TEXT_38 = ".append(\"\\n\"+line_";
  protected final String TEXT_39 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t    brout_";
  protected final String TEXT_40 = ".close();" + NL + "\t\tstdout_";
  protected final String TEXT_41 = ".close();" + NL + "\t\t" + NL + "\t\tjava.io.InputStream stderr_";
  protected final String TEXT_42 = " = sess_";
  protected final String TEXT_43 = ".getStderr();" + NL + "        java.io.BufferedReader breer_";
  protected final String TEXT_44 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_45 = "));" + NL + "        String line1_";
  protected final String TEXT_46 = " = \"\";" + NL + "        StringBuilder stringStderr_";
  protected final String TEXT_47 = " =new StringBuilder();" + NL + "" + NL + "        if((line1_";
  protected final String TEXT_48 = " = breer_";
  protected final String TEXT_49 = ".readLine()) != null){" + NL + "        \tstringStderr_";
  protected final String TEXT_50 = ".append(line1_";
  protected final String TEXT_51 = ");" + NL + "        }" + NL + "\t\twhile((line1_";
  protected final String TEXT_52 = " = breer_";
  protected final String TEXT_53 = ".readLine()) != null) {" + NL + "\t\t\tstringStderr_";
  protected final String TEXT_54 = ".append(\"\\n\"+line1_";
  protected final String TEXT_55 = ");" + NL + "\t\t}" + NL + "" + NL + "\t\tbreer_";
  protected final String TEXT_56 = ".close();" + NL + "\t\tstderr_";
  protected final String TEXT_57 = ".close();" + NL + "\t\t" + NL + "\t\tsess_";
  protected final String TEXT_58 = ".waitForCondition(ch.ethz.ssh2.ChannelCondition.EXIT_STATUS, 10000);" + NL + "\t\t" + NL + "\t\t /* Close this session */" + NL + "\t\t" + NL + "\t\tsess_";
  protected final String TEXT_59 = ".close();" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tSystem.out.println(stringStdout_";
  protected final String TEXT_61 = ".toString());";
  protected final String TEXT_62 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_63 = "_STDOUT\", stringStdout_";
  protected final String TEXT_64 = ".toString());";
  protected final String TEXT_65 = NL + "\t\t\tSystem.out.println(stringStdout_";
  protected final String TEXT_66 = ".toString());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_67 = "_STDOUT\", stringStdout_";
  protected final String TEXT_68 = ".toString());";
  protected final String TEXT_69 = NL + "\t\t\toutput_";
  protected final String TEXT_70 = ".add(stringStdout_";
  protected final String TEXT_71 = ".toString());";
  protected final String TEXT_72 = NL + "\t\t\tSystem.out.println(stringStderr_";
  protected final String TEXT_73 = ".toString());";
  protected final String TEXT_74 = NL + "\t\t\t" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_75 = "_STDERR\", stringStderr_";
  protected final String TEXT_76 = ".toString());";
  protected final String TEXT_77 = NL + "\t\t\tSystem.out.println(stringStderr_";
  protected final String TEXT_78 = ".toString());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_79 = "_STDERR\", stringStderr_";
  protected final String TEXT_80 = ".toString());";
  protected final String TEXT_81 = NL + "\t\t\toutput_";
  protected final String TEXT_82 = ".add(stringStderr_";
  protected final String TEXT_83 = ".toString());";
  protected final String TEXT_84 = NL + "\t\t\t\tfor(String tmp_";
  protected final String TEXT_85 = ":output_";
  protected final String TEXT_86 = "){";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = tmp_";
  protected final String TEXT_90 = ";\t\t\t\t";
  protected final String TEXT_91 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean stats = codeGenArgument.isStatistics();
String standardOutput = ElementParameterParser.getValue(node, "__STANDARDOUTPUT__");
String errorOutput = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
boolean pty = "true".equals(ElementParameterParser.getValue(node, "__PTY__"));
List<IMetadataTable> metadatas = node.getMetadataList();
String cid = node.getUniqueName();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        List<IMetadataColumn> columns = metadata.getListColumns();
        List<? extends IConnection> conns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
       	String commandSeparator = ElementParameterParser.getValue(node,"__COMMANDSEPARATOR__");
        List<Map<String, String>> commands =(List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__COMMANDS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
        if (pty) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
        	if(commands.size() > 0){
        		for(java.util.Map<String, String> map : commands){
        			String cmd = map.get("COMMAND");

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cmd);
    stringBuffer.append(TEXT_10);
    
				}
			}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}else{
        	if(commands.size() > 0){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
      
				for(java.util.Map<String, String> map : commands){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(commandSeparator);
    stringBuffer.append(TEXT_18);
    String cmd = map.get("COMMAND");
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cmd );
    stringBuffer.append(TEXT_21);
     
				}
        	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
		}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		//-----begin to handle output
		if(("TO_CONSOLE").equals(standardOutput)){

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
		}else if(("TO_GLOBAL_VARIABLE").equals(standardOutput)){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		}else if(("TO_CONSOLE_AND_GLOBAL_VARIABLE").equals(standardOutput)){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		}else if(("NORMAL_OUTPUT").equals(standardOutput)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		}
		if(("TO_CONSOLE").equals(errorOutput)){

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    			
		}else if(("TO_GLOBAL_VARIABLE").equals(errorOutput)){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    		
		}else if(("TO_CONSOLE_AND_GLOBAL_VARIABLE").equals(errorOutput)){

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    		
		}else if(("NORMAL_OUTPUT").equals(errorOutput)){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    		
		}
		if(("NORMAL_OUTPUT").equals(errorOutput) || ("NORMAL_OUTPUT").equals(standardOutput)){
			if (conns!=null && conns.size()>0) {
				IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
					for(IMetadataColumn column:columns) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
					}
			}
		}
		//-----end handle output
    }
}

    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
