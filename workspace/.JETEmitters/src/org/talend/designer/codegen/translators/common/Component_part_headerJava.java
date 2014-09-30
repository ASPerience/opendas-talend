package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Component_part_headerJava
{
  protected static String nl;
  public static synchronized Component_part_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_headerJava result = new Component_part_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t/**" + NL + "\t * [";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = " ] start" + NL + "\t */" + NL + "" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\t\tTalendThreadPool mtp_";
  protected final String TEXT_5 = " = new TalendThreadPool(";
  protected final String TEXT_6 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tfinal Object[] lockWrite = new Object[0];" + NL + "\t\t\t\t\tint threadIdCounter =0;" + NL + "\t\t\t\t";
  protected final String TEXT_8 = "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_9 = "\t\t\t" + NL + "\t\t\tint NB_ITERATE_";
  protected final String TEXT_10 = " = 0; //for statistics" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tglobalMap.put(\"ENABLE_TRACES_CONNECTION_";
  protected final String TEXT_14 = "\",Boolean.FALSE);" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\tok_Hash.put(\"";
  protected final String TEXT_16 = "\", false);" + NL + "\t\tstart_Hash.put(\"";
  protected final String TEXT_17 = "\", System.currentTimeMillis());" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = ".addMessage(\"begin\",\"";
  protected final String TEXT_20 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_21 = "Process(globalMap);" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "    \t\t\t\t";
  protected final String TEXT_23 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_24 = ".addLineToRow(\"";
  protected final String TEXT_25 = "_count\");" + NL + "    \t\t\t\t\t";
  protected final String TEXT_26 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_27 = ".addLineToRow(\"";
  protected final String TEXT_28 = "_count\");" + NL + "    \t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = NL + "\t\tcurrentVirtualComponent = \"";
  protected final String TEXT_31 = "\";" + NL + "\t";
  protected final String TEXT_32 = NL + "\tcurrentComponent=\"";
  protected final String TEXT_33 = "\";" + NL + "" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\t\tif (execStat) {" + NL + "\t\t\t\tif(resourceMap.get(\"inIterateVComp\") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap_";
  protected final String TEXT_36 = " = (java.util.concurrent.ConcurrentHashMap) globalMap.get(\"concurrentHashMap\");" + NL + "\t\t\t\t\t\tconcurrentHashMap_";
  protected final String TEXT_37 = ".putIfAbsent(\"";
  protected final String TEXT_38 = "\" + iterateLoop,new java.util.concurrent.atomic.AtomicInteger(0));" + NL + "\t\t\t\t\t\tjava.util.concurrent.atomic.AtomicInteger stats_";
  protected final String TEXT_39 = " = (java.util.concurrent.atomic.AtomicInteger) concurrentHashMap_";
  protected final String TEXT_40 = ".get(\"";
  protected final String TEXT_41 = "\" + iterateLoop);" + NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_42 = "\" + iterateId, stats_";
  protected final String TEXT_43 = ".incrementAndGet()<=1?0:1, 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_45 = "\" + iterateId, 0, 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t}" + NL + "\t\t\t} " + NL + "" + NL + "\t\t";
  protected final String TEXT_47 = NL + NL + "\t\t\t//";
  protected final String TEXT_48 = NL + "\t\t\t//";
  protected final String TEXT_49 = NL + NL + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_51 = "\"+iterateId,1, 1);" + NL + "\t\t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_53 = "\"+iterateId,1, 1);" + NL + "\t\t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_54 = NL + NL + "\t\t";
  protected final String TEXT_55 = NL + NL + "\t";
  protected final String TEXT_56 = NL + "\t\tint tos_count_";
  protected final String TEXT_57 = " = 0;" + NL + "\t";
  protected final String TEXT_58 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\tjava.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap_";
  protected final String TEXT_61 = " = (java.util.concurrent.ConcurrentHashMap) globalMap.get(\"concurrentHashMap\");" + NL + "\t\t\t\t\t\t\tconcurrentHashMap_";
  protected final String TEXT_62 = ".putIfAbsent(\"";
  protected final String TEXT_63 = "\" + iterateLoop,new java.util.concurrent.atomic.AtomicInteger(0));" + NL + "\t\t\t\t\t\t\tjava.util.concurrent.atomic.AtomicInteger stats_";
  protected final String TEXT_64 = " = (java.util.concurrent.atomic.AtomicInteger) concurrentHashMap_";
  protected final String TEXT_65 = ".get(\"";
  protected final String TEXT_66 = "\" + iterateLoop);" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_67 = "\" + iterateId, stats_";
  protected final String TEXT_68 = ".incrementAndGet()<=1?0:1, 0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_70 = "\" + iterateId, 0, 0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean containsTPartitioner = node.getProcess().getNodesOfType("tPartitioner").size() > 0 ? true : false;
	String startNodeCid=node.getDesignSubjobStartNode().getUniqueName();
	ECodePart codePart = codeGenArgument.getCodePart();
	boolean trace = codeGenArgument.isTrace();
	boolean stat = codeGenArgument.isStatistics();
	Set<IConnection> connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));
	String incomingName = codeGenArgument.getIncomingName();
	
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	iterateConnSet.addAll(node.getOutgoingConnections(EConnectionType.ITERATE));
	
	List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codePart );
    stringBuffer.append(TEXT_3);
    
    //This part in order to feedback with the iterate_subprocess_header.javajet and iterate_subprocess_footer.javajet
    
	if (codePart.equals(ECodePart.BEGIN)) {
		boolean parallelIterate = false;
		boolean hasParallelIterate = false;
		for (IConnection iterateConn : iterateConnSet) { 
			parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	        if (parallelIterate) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(iterateConn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(iterateConn,"__NUMBER_PARALLEL__") );
    stringBuffer.append(TEXT_6);
    
				if(!hasParallelIterate){
					hasParallelIterate = true;
					
    stringBuffer.append(TEXT_7);
    
				}
				
    stringBuffer.append(TEXT_8);
    
			}
			
			String iterateNodeName = iterateConn.getTarget().getUniqueName();
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_10);
    			
			continue;
		}
	}	
	
    stringBuffer.append(TEXT_11);
    
	if (codePart.equals(ECodePart.BEGIN)) {
	
    stringBuffer.append(TEXT_12);
    
		if(trace){ 
		
    stringBuffer.append(TEXT_13);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_14);
    
		}
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_17);
    
		String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
		if ((node.getProcess().getNodesOfType("tStatCatcher").size() > 0) && (statCatcher.equals("true"))) {
			for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_21);
    
			}
		}
	}
	if(codePart.equals(ECodePart.MAIN)) {
		List<INode> meterCatchers = (List<INode>)node.getProcess().getNodesOfType("tFlowMeterCatcher");	
	    if ((node.getProcess().getNodesOfType("tFlowMeter").size() > 0)){
        	for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MAIN)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(temp_conn.isUseByMetter()){ 	    	
				
    stringBuffer.append(TEXT_22);
    
		            if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_25);
    
		        		}
		        	}
				}
			}
			
			for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MERGE)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(name_conn == incomingName && temp_conn.isUseByMetter()){ 	    	
            		if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_26);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_28);
    
		        		}
		        	}
				}
			}			
	    }
	}
	
    stringBuffer.append(TEXT_29);
    
	if(node.isVirtualGenerateNode()){
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(NodeUtil.getVirtualUniqueName(node));
    stringBuffer.append(TEXT_31);
    
	}
	
    stringBuffer.append(TEXT_32);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_33);
    
	connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));

	if ((codePart.equals(ECodePart.BEGIN))&&(stat)&&connSet.size()>0) {
		for(IConnection con:connSet){
		
    stringBuffer.append(TEXT_34);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_43);
    }else{
    stringBuffer.append(TEXT_44);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
		}
	}
	
	if((codePart.equals(ECodePart.MAIN))&&(stat)&&connSet.size()>0){
		for(IConnection con:connSet){
		
    stringBuffer.append(TEXT_47);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append((String)codeGenArgument.getIncomingName());
    stringBuffer.append(TEXT_49);
    if (!node.getComponent().useMerge()) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_51);
    
			} else if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
		}
	}
	
    stringBuffer.append(TEXT_55);
    
	if(codePart.equals(ECodePart.BEGIN)){ 
	
    stringBuffer.append(TEXT_56);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_57);
    
	}
	if(stat){
		boolean iterateInVFComp = (node.getVirtualLinkTo() != null && node.getVirtualLinkTo() == EConnectionType.ITERATE);
		if(iterateInVFComp){
			if(codePart.equals(ECodePart.BEGIN)){
				List<String> needToStartConnNames = new ArrayList<String>();
				INode nextNode = node.getOutgoingConnections(EConnectionType.ITERATE).get(0).getTarget();
				NodeUtil.fillConnectionsForStat(needToStartConnNames, nextNode);
				
    stringBuffer.append(TEXT_58);
    
					for(String connName : needToStartConnNames){
					
    stringBuffer.append(TEXT_59);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_68);
    }else{
    stringBuffer.append(TEXT_69);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    	
					}
					
    stringBuffer.append(TEXT_72);
    
			}else if(codePart.equals(ECodePart.MAIN)){ 
			
    stringBuffer.append(TEXT_73);
    
			}else if(codePart.equals(ECodePart.END)){
			
    stringBuffer.append(TEXT_74);
    
			} 
		}else{
			IConnection preIterate = (node.getIncomingConnections(EConnectionType.ITERATE) != null && node.getIncomingConnections(EConnectionType.ITERATE).size() == 1) ? node.getIncomingConnections(EConnectionType.ITERATE).get(0) : null;
			if(preIterate != null){
				boolean iterateInVSComp = (preIterate.getSource().getVirtualLinkTo() != null && preIterate.getSource().getVirtualLinkTo() == EConnectionType.ITERATE);
				if(iterateInVSComp){
					if(codePart.equals(ECodePart.BEGIN)){ 
					
    stringBuffer.append(TEXT_75);
    
					}else if(codePart.equals(ECodePart.END)){
					
    stringBuffer.append(TEXT_76);
    
					}
				}
			}	
		}
	}
	
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
