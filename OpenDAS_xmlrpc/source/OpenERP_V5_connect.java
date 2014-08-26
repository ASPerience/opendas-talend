package OpenDAS_xmlrpc;

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

import javax.swing.JComponent;

import redstone.xmlrpc.*; //http://xmlrpc.sourceforge.net/javadoc/redstone/xmlrpc/XmlRpcClient.html


public class OpenERP_V5_connect
{
	private String dbname = null;
	private String username = null;
	private Integer userid = null;
	private String pwd = null;
	private String host = null;
	private String port = null;
	private XmlRpcClient client_common = null;
	private XmlRpcClient client_object = null;
	
	private Object result = null;
	
	public OpenERP_V5_connect (String dbname, String username, String pwd, String host, String port) throws Exception
	{
		System.out.println("OpenERP_V5_connect "+dbname+" "+username+" "+pwd+" "+host+" "+port);
		this.dbname = new String(dbname);
		this.username = new String(username);
		this.pwd = new String(pwd);
		this.host = new String(host);
		this.port = new String(port);
		this.client_common = new XmlRpcClient( "http://"+host+":"+port+"/xmlrpc/common",false );
		this.client_object = new XmlRpcClient( "http://"+host+":"+port+"/xmlrpc/object",false );
		
		Object[] args = new Object[] { this.dbname, this.username, this.pwd };
		this.result = client_common.invoke( "login", args );
		
		if (this.result instanceof Integer) {
			System.out.println("Connexion OK");
			this.userid = (Integer)this.result;
		} else if (this.result instanceof Boolean) {
			System.out.println("Erreur de connexion "+this.result);
		} else {
			System.out.println("Retour non définit");
		}
	}

	public XmlRpcArray search (String model, Object[] filter) throws Exception
	{
		//Object[] filter = new Object[] { new Object[]{"name","=","dd"} }; // FILTRE CETTE FORME
		Object[] args = new Object[] { this.dbname, this.userid, this.pwd, model, "search", filter };
		this.result = client_object.invoke( "execute", args );
		System.out.println(result.toString());
		
		if (this.result instanceof XmlRpcArray) 
		{
			System.out.println("Reception d'un tableau d'id");
			XmlRpcArray tmp = (XmlRpcArray) this.result;
			for(int i=0 ; i<tmp.size() ; i++)
				System.out.println(tmp.getInteger(i));
			return tmp;
		}
		else
			System.out.println("Retour non définit");
		return null;
	}
	
	public XmlRpcArray read (String model, Object[] ids, Object[] filter) throws Exception
	{
		Object[] args = new Object[] { this.dbname, this.userid, this.pwd, model, "read", ids, filter };
		this.result = client_object.invoke( "execute", args );
		
		if (this.result instanceof XmlRpcArray) 
		{
			System.out.println("Reception d'un tableau de model");
			XmlRpcArray tmp = (XmlRpcArray) this.result;
			for(int i=0 ; i<tmp.size() ; i++)
				System.out.println(tmp.getStruct(i));
			return tmp;
		}
		else
			System.out.println("Retour non définit");
			return null;
	}
	
	public XmlRpcArray special_read (String method, String model, Object[] ids, Object[] filter) throws Exception
	{
		Object[] args = new Object[] { this.dbname, this.userid, this.pwd, model, method, ids, filter };
		this.result = client_object.invoke( "execute", args );
		
		if (this.result instanceof XmlRpcArray) 
		{
			System.out.println("Reception d'un tableau de model");
			XmlRpcArray tmp = (XmlRpcArray) this.result;
			for(int i=0 ; i<tmp.size() ; i++)
				System.out.println(tmp.getStruct(i));
			return tmp;
		}
		else
			System.out.println("Retour non définit");
			return null;
	}

	public Object exec (String model, String function, XmlRpcStruct context, Object[] filter) throws Exception
	{
		System.out.println("model:"+model+" function:"+function+" context:"+context);
		
		Object[] args = new Object[] { this.dbname, this.userid, this.pwd, model, function, context, filter };
		this.result = client_object.invoke( "execute", args );
//		System.out.println(this.result.toString());
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