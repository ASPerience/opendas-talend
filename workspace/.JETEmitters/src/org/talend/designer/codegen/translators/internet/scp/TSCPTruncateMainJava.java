package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPTruncateMainJava
{
  protected static String nl;
  public static synchronized TSCPTruncateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPTruncateMainJava result = new TSCPTruncateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry{" + NL + "        if(destFile_";
  protected final String TEXT_3 = "!=null && destFile_";
  protected final String TEXT_4 = ".length()!=0){" + NL + "   \t\t\tjava.io.OutputStream out_";
  protected final String TEXT_5 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tout_";
  protected final String TEXT_6 = " = scp_";
  protected final String TEXT_7 = ".put(destFile_";
  protected final String TEXT_8 = ", 0, ";
  protected final String TEXT_9 = ", \"0644\");" + NL + "\t\t\t\tout_";
  protected final String TEXT_10 = ".write(new byte[]{});" + NL + "\t\t\t} finally {" + NL + "            \tif(out_";
  protected final String TEXT_11 = " != null){" + NL + "        \t\t\tout_";
  protected final String TEXT_12 = ".close();" + NL + "            \t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "            nb_file_";
  protected final String TEXT_13 = " ++;" + NL + "            globalMap.put(\"";
  protected final String TEXT_14 = "_STATUS\", \"File truncate OK.\");" + NL + "        }" + NL + "    }catch(java.lang.Exception e_";
  protected final String TEXT_15 = "){" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_16 = "_STATUS\", \"File truncate fail.\");" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        String cid = node.getUniqueName();      

        String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
