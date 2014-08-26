package org.talend.designer.codegen.translators.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TESBProviderRequestEndJava
{
  protected static String nl;
  public static synchronized TESBProviderRequestEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBProviderRequestEndJava result = new TESBProviderRequestEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t} catch (ESBJobInterruptedException e) {" + NL + "\t\t\t// job interrupted from outside" + NL + "\t\t\tbreak;" + NL + "\t\t} catch (Throwable e) {" + NL + "\t\t\t((ESBProviderCallback) globalMap.get(\"esbHandler\")).sendResponse(e);" + NL + "\t\t} finally {" + NL + "\t\t\t// Exit from this loop is made by the configuring \"Keep listening\"" + NL + "\t\t\t// parameter to false. Then we will have a break before." + NL + "\t\t\tif (\"false\".equals(\"";
  protected final String TEXT_2 = "\")) {" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tnb_line_";
  protected final String TEXT_3 = "++;" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\", nb_line_";
  protected final String TEXT_5 = ");" + NL + "\t} // This is the end of the ESB Service Provider loop" + NL + "} finally {" + NL + "\t// for \"keep listening\" == false web service need a time to serve response" + NL + "\tThread.currentThread();" + NL + "\tThread.sleep(500);" + NL + "\t// unsubscribe" + NL + "\tif (null != handlerThread_";
  protected final String TEXT_6 = ") {" + NL + "\t\t// stop endpoint in case it was opened by job" + NL + "\t\thandlerThread_";
  protected final String TEXT_7 = ".stopEndpoint();" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	boolean isOneWay = (node.getProcess().getNodesOfType("tESBProviderFault").isEmpty()
		&& node.getProcess().getNodesOfType("tESBProviderResponse").isEmpty());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ElementParameterParser.getValue(node, "__KEEPLISTENING__"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
