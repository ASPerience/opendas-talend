package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IExternalNode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Iterate_subprocess_headerJava
{
  protected static String nl;
  public static synchronized Iterate_subprocess_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Iterate_subprocess_headerJava result = new Iterate_subprocess_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tNB_ITERATE_";
  protected final String TEXT_2 = "++;";
  protected final String TEXT_3 = "\t\t\t" + NL + "\tclass ";
  protected final String TEXT_4 = "Thread extends TalendThread {//implements routines.system.TalendThreadPool.PropertySettable" + NL + "\t" + NL + "\t\tclass ThreadedMap extends java.util.HashMap<String, Object> {" + NL + "\t\t\t" + NL + "\t\t\tprivate static final long serialVersionUID = 0L;" + NL + "" + NL + "\t\t\tpublic ThreadedMap(java.util.Map<String, Object> globalMap) {" + NL + "\t\t\t\tsuper(globalMap);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t@Override" + NL + "\t\t\tpublic Object put(String key, Object value) {" + NL + "\t\t\t\tsynchronized (";
  protected final String TEXT_5 = ".this.obj) {" + NL + "\t\t\t\t\tsuper.put(key, value);" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_6 = ".this.globalMap.put(key, value);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}\t" + NL + "" + NL + "\t\tprivate java.util.Map<String, Object> globalMap = null;" + NL + "\t\tboolean isRunning = false;" + NL + "\t\tString iterateId = \"\";";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = "\t\t  " + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = NL + "\t" + NL + "\t\tpublic ";
  protected final String TEXT_11 = "Thread(java.util.Map<String, Object> globalMap";
  protected final String TEXT_12 = ", int threadID) {" + NL + "\t\t\tsuper();" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "        \t\tif(";
  protected final String TEXT_14 = " != null){" + NL + "            \t\t";
  protected final String TEXT_15 = "this.";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ";" + NL + "    \t            \t";
  protected final String TEXT_20 = NL + "        \t\t}" + NL + "        \t\t";
  protected final String TEXT_21 = NL + "\t\t\tsynchronized (";
  protected final String TEXT_22 = ".this.obj) {" + NL + "\t\t\t\tthis.globalMap = java.util.Collections.synchronizedMap(new ThreadedMap(globalMap));" + NL + "\t\t\t}" + NL + "\t\t\titerateId = \".\" + threadID;" + NL + "\t\t}" + NL + "" + NL + "\t\t" + NL + "\t\tpublic void run() {\t\t" + NL + "" + NL + "\t\t\tjava.util.Map threadRunResultMap = new java.util.HashMap();" + NL + "\t\t\tthreadRunResultMap.put(\"errorCode\", null);" + NL + "\t\t\tthreadRunResultMap.put(\"status\", \"\");" + NL + "\t\t\tthreadLocal.set(threadRunResultMap);" + NL + "\t\t\t" + NL + "\t\t\tthis.isRunning = true;" + NL + "\t\t\tString currentComponent = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_23 = NL + "if(execStat){" + NL + "\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_24 = "\",0,\"exec\"+iterateId);" + NL + "}\t\t\t\t";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "if(execStat){\t\t\t\t" + NL + "           \t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_27 = "\", 3, \"exec\" + NB_ITERATE_";
  protected final String TEXT_28 = ");" + NL + "}           \t\t\t";
  protected final String TEXT_29 = "        \t\t" + NL + "if(execStat){" + NL + "\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_30 = "\", 1, \"exec\" + NB_ITERATE_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t//Thread.sleep(1000);" + NL + "}\t\t\t\t";
  protected final String TEXT_32 = NL;

    // add the list of the connection names to avoid to declare two times the same name.
    public String createPrivateClassInstance(INode node, String parentLastRoot, boolean force) {
    	return createPrivateClassInstance(node, parentLastRoot, force, new HashSet<String>());
    }

    public String createPrivateClassInstance(INode n, String parentLastRoot, boolean force, Set<String> names) {
        String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force)||(n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
	                    toReturn += conn.getName() + "Struct " + conn.getName() + " = new " + conn.getName()
	                            + "Struct();\n";
	                    names.add(conn.getName());
	                    parentLastRoot = conn.getName();
                    }
	            } else {
                    // copy
                    if (!names.contains(conn.getName())) {
	                    toReturn += parentLastRoot + "Struct " + conn.getName() + " = " + parentLastRoot + ";\n";
	                    names.add(conn.getName());
                    }
                }
                if(!conn.getTarget().getComponent().useMerge()) {
                   toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)||conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
            	toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
    
    public String createPriveClassMethodDeclaration(INode n, String parentLastRoot, boolean force, Set<String> names) {
    	String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force)||(n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
	                    toReturn += conn.getName() + "Struct " + conn.getName() + ",";
	                    names.add(conn.getName());
	                    parentLastRoot = conn.getName();
                    }
	            } else {
                    // copy
                    if (!names.contains(conn.getName())) {
	                    toReturn += parentLastRoot + "Struct " + conn.getName() + ",";
	                    names.add(conn.getName());
                    }
                }
                if(!conn.getTarget().getComponent().useMerge()) {
                   toReturn += createPriveClassMethodDeclaration(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)||conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
            	toReturn += createPriveClassMethodDeclaration(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
    
    public String createPrivateClassMethodInstance(INode n, String parentLastRoot, boolean force, Set<String> names) {
        String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force) || (n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
                        toReturn += conn.getName() + ",";
                        names.add(conn.getName());
                        parentLastRoot = conn.getName();
                    }
                } else {
                    // copy
                    if (!names.contains(conn.getName())) {
                        toReturn += conn.getName() + ",";
                        names.add(conn.getName());
                    }
                }
                if (!conn.getTarget().getComponent().useMerge()) {
                    toReturn += createPrivateClassMethodInstance(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)
                    || conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
                toReturn += createPrivateClassMethodInstance(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
IProcess process = node.getProcess();
 
NodesSubTree subTree = (NodesSubTree) codeGenArgument.getSubTree();
ECodePart codePart = codeGenArgument.getCodePart();
//boolean trace = codeGenArgument.isTrace();
boolean stat = codeGenArgument.isStatistics();

Set<IConnection> connSet =  new HashSet<IConnection>();
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));

Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
iterateConnSet.addAll(node.getIncomingConnections(EConnectionType.ITERATE));

String iterateNodeName = node.getUniqueName();

List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();
boolean parallelIterate = false;
for (IConnection iterateConn : iterateConnSet) { //1
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_2);
    	
	
	parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	if (parallelIterate) {//2
		if (codePart.equals(ECodePart.BEGIN)) {//3
			String rowList=","; 
			for (IConnection conn : allSubProcessConnection) {
				rowList += conn.getUniqueName()+"Struct "+conn.getUniqueName()+",";
			}
			rowList = rowList.substring(0, rowList.length()-1);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_6);
    
			if(!subTree.isMergeSubTree()) {
				List< ? extends IConnection> rootConns = subTree.getRootNode().getOutgoingConnections();
				if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(createPrivateClassInstance(subTree.getRootNode(), rootConns.get(0).getName(), false));
    
				}
  			} else {  
    			List<INode> sortedMergeBranchStarts = subTree.getSortedMergeBranchStarts();    
    			for (INode startNode : sortedMergeBranchStarts) {
    				List< ? extends IConnection> rootConns = startNode.getOutgoingConnections();
    				if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(createPrivateClassInstance(startNode, rootConns.get(0).getName(), false));
    
					}
				}
    
				List< ? extends IConnection> rootConns = subTree.getMergeNode().getOutgoingConnections();
				if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(createPrivateClassInstance(subTree.getMergeNode(), rootConns.get(0).getName(), false));
    
				}
			}
			
			String schemaInstanceDeclaration = createPriveClassMethodDeclaration(subTree.getRootNode(), subTree.getRootNode().getOutgoingConnections().get(0).getName(), false, new java.util.HashSet<String>());
			if (schemaInstanceDeclaration.length()>0) {
				schemaInstanceDeclaration = "," + schemaInstanceDeclaration.substring(0,schemaInstanceDeclaration.length()-1); 
			}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(schemaInstanceDeclaration );
    stringBuffer.append(TEXT_12);
    
			for (IConnection connection : allSubProcessConnection) {
        		IMetadataTable table = connection.getMetadataTable();
        		
    stringBuffer.append(TEXT_13);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_14);
    
    				List<IMetadataColumn> listColumns = table.getListColumns();
                	for (IMetadataColumn column : listColumns) {
    					
    stringBuffer.append(TEXT_15);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_19);
    
            		}
            		
    stringBuffer.append(TEXT_20);
    
			} 
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_22);
    
	        	if(stat){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_24);
    
				}
			}//3	
			continue;
		}else {//2
	      		if(stat){

    stringBuffer.append(TEXT_25);
    				
				Set<? extends IConnection> allInLineJobConns = NodeUtil.getAllInLineJobConnections(iterateConn.getTarget());
				for (IConnection inLineConn : allInLineJobConns) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(inLineConn.getUniqueName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_28);
            		
				}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_31);
    
		  		}
		}//2
	}//1

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}