package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Camel_footerJava
{
  protected static String nl;
  public static synchronized Camel_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_footerJava result = new Camel_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}" + NL + "\t\t\t});" + NL + "" + NL + "\t\t\tgetCamelContexts().get(0).start();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected void doStop() throws Exception {" + NL + "\t\t\tsuper.doStop();" + NL + "\t\t\tgetCamelContexts().get(0).stop();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected org.apache.camel.ProducerTemplate findOrCreateCamelTemplate() {" + NL + "\t\t\treturn getCamelContexts().get(0).createProducerTemplate();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected java.util.Map<String, org.apache.camel.CamelContext> getCamelContextMap() {" + NL + "\t\t\tjava.util.Map<String, org.apache.camel.CamelContext> answer = new java.util.HashMap<String, org.apache.camel.CamelContext>();" + NL + "\t\t\tanswer.put(\"camel-1\", new org.apache.camel.impl.DefaultCamelContext());" + NL + "\t\t\treturn answer;" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected org.apache.camel.view.ModelFileGenerator createModelFileGenerator()" + NL + "\t\t\t\tthrows javax.xml.bind.JAXBException {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tCamelImpl camelImplementation = new CamelImpl();" + NL + "\tcamelImplementation.enableHangupSupport();" + NL + "\tcamelImplementation.run();" + NL + "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
