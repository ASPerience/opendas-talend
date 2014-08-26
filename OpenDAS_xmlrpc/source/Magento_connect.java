package OpenDAS_xmlrpc;

import java.util.*;
import java.lang.*;
import java.util.Map.Entry;
import redstone.xmlrpc.*; //http://xmlrpc.sourceforge.net/javadoc/redstone/xmlrpc/XmlRpcClient.html


public class Magento_connect
{
	private String dbname = null;
	private String username = null;
	private String session = null;
	private String pwd = null;
	private String host = null;
	private String port = null;
	private XmlRpcClient client = null;
	
	private Object result = null;
	
	public Magento_connect (String username, String pwd, String host, String port) throws Exception
	{
		System.out.println("Magento_connect "+username+" "+pwd+" "+host+" "+port);
		this.username = new String(username);
		this.pwd = new String(pwd);
		this.host = new String(host);
		this.port = new String(port);
		this.client = new XmlRpcClient( "http://"+host+":"+port+"/index.php/api/xmlrpc",false );
		Object[] args = new Object[] {this.username, this.pwd};
		this.result = client.invoke( "login", args );
		
		
		if (this.result instanceof String) {
			System.out.println("Connexion OK");
			this.session = (String)this.result;
		} else if (this.result instanceof Boolean) {
			System.out.println("Erreur de connexion "+this.result);
		} else {
			System.out.println("Retour non définit");
		}
		
	}
	
	public XmlRpcArray search (String model, Object[] filter) throws Exception
	{
		return null;
	}
	
	public XmlRpcArray read (String model, Object[] ids, Object[] filter) throws Exception
	{
		return null;
	}
	
	public XmlRpcArray special_read (String method, String model, Object[] ids, Object[] filter) throws Exception
	{
		return null;
	}

	public Object exec (String model, String function, XmlRpcStruct context, Object[] filter) throws Exception
	{
		Object[] args = new Object[] {this.session, model+"."+function, new Object[]{context, filter}};
		this.result = this.client.invoke("call", args );
		System.out.println(this.result.toString());
		if (this.result instanceof XmlRpcArray) {
			System.out.println("Reception d'un tableau");
			return this.result;
		} else if (this.result instanceof XmlRpcStruct) {
			System.out.println("Reception d'un dictionnaire");
			return this.result;
		} else {
			System.out.println("Retour non définit :"+this.result.getClass().getName());
			return this.result;
		}
	}
	
	public HashMap convert (XmlRpcStruct struct) throws Exception
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		for (Entry<String, Object> entry : ((HashMap<String, Object>)struct).entrySet())
		{
			String key = entry.getKey();
			Object elem = entry.getValue();
			if (elem.getClass() == XmlRpcStruct.class)
			{
				result.put(key,this.convert((XmlRpcStruct)elem));
			}
			else if (elem.getClass() == XmlRpcArray.class)
			{
				result.put(key,this.convert((XmlRpcArray)elem));
			} else
			{
				result.put(key,elem);
			}
		}
		return result;
	}
	
	public LinkedList<Object> convert (XmlRpcArray struct) throws Exception
	{
		LinkedList<Object> result = new LinkedList<Object>();
		
		for (int i=0; i<struct.size(); ++i)
		{
			Object elem = struct.get(i);
			if (elem.getClass() == XmlRpcStruct.class)
			{
				result.add(this.convert((XmlRpcStruct)elem));
			}
			else if (elem.getClass() == XmlRpcArray.class)
			{
				result.add(this.convert((XmlRpcArray)elem));
			} else
			{
				result.add(elem);
			}
		}
		return result;
	}
	
	
}