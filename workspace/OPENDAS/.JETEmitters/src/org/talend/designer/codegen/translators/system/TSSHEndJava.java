package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import java.util.List;

public class TSSHEndJava
{
  protected static String nl;
  public static synchronized TSSHEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHEndJava result = new TSSHEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t/* Close the connection */" + NL + "\tconn_";
  protected final String TEXT_4 = ".close();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_5 = "_EXIT_CODE\",sess_";
  protected final String TEXT_6 = ".getExitStatus());";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String standardOutput = ElementParameterParser.getValue(node, "__STANDARDOUTPUT__");
	String errorOuput = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
    if(("NORMAL_OUTPUT").equals(standardOutput) || ("NORMAL_OUTPUT").equals(errorOuput)){
    	List<IMetadataTable> metadatas = node.getMetadataList();
        if ((metadatas!=null)&&(metadatas.size()>0)) {
        	IMetadataTable metadata = metadatas.get(0);
        	if (metadata!=null) {
        		List<IMetadataColumn> columns=metadata.getListColumns();
        		List<? extends IConnection> conns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
        		if (conns!=null && conns.size()>0) {

    stringBuffer.append(TEXT_2);
    
         		}
			}
		}
	}  

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
