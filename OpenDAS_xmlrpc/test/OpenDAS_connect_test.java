import OpenDAS_xmlrpc.*;
import java.util.*;
import java.lang.*;
import redstone.xmlrpc.*;

public class OpenDAS_connect_test
{	
	public static void main (String[] args) throws Exception
	{
//		Magento_connect tt = new ASPerpgi_xmlrpc.Magento_connect("opendas","opendas","127.0.0.1","80");
		
//		tt.search("opendas.shipping.order", new Object[] { new Object[]{"name","=","dd"} });
//		tt.search("opendas.shipping.order", new Object[] {  });
//		tt.read("opendas.shipping.order", new Object[] { 1,2 }, new Object[] { "name" });
//		
		XmlRpcStruct status = new XmlRpcStruct();
		status.put("nin", new Object[] {"complete", "canceled","closed"});
		XmlRpcStruct context = new XmlRpcStruct();
		context.put("status", status);
    
		
//		tt.exec("opendas.shipping.order", "sign_out", new Object[] { 1 }, context);
//		tt.exec("sales_order", "list",  context);
//		tt.exec("opendas_shipping_order", "list_can_ship", context2);
		
		OpenERP_V5_connect c1 = new Opendas_xmlrpc.OpenERP_V5_connect("opendas","admin@buroform","opendas","127.0.0.1","8070");
		XmlRpcStruct res = (XmlRpcStruct)c1.exec("stock.picking", "talend_get_picking", context, new Object[]{});
		c1.convert((XmlRpcStruct)((XmlRpcArray)res.get("object")).get(0));
//		for (int i = 0 ; i < . )
//		{
//			
//		}

//		Magento_connect c2 = new ASPerpgi_xmlrpc.Magento_connect("opendas","opendas","172.26.44.52","80");
//		c2.exec("opendas_shipping_order", "list_can_ship", context, new Object[]{new Object[]{"dd","dd","dd"}});
//		

	}
}


//redstone.xmlrpc.XmlRpcStruct context = new redstone.xmlrpc.XmlRpcStructXmlRpcStruct();





//import ASPerpgi_xmlrpc.*;
//import java.util.*;
//import java.lang.*;
//import redstone.xmlrpc.*;
//
//public class ASPerpgi_connect_test
//{	
//	public static void main (String[] args) throws Exception
//	{
//		ASPerpgi_connect tt = new ASPerpgi_connect("1","admin@opendas","opendas","127.0.0.1","8069");
//		tt.search("hr.employee", new Object[] { new Object[]{"name","=","dd"} });
//		tt.search("hr.employee", new Object[] {  });
//		tt.read("hr.employee", new Object[] { 1,2 }, new Object[] { "name" });
//		
//		XmlRpcStruct context = new XmlRpcStruct();
//			context.put("objectType", "workcenter");
//			context.put("objectId", 1);
//			context.put("otherid", "001");
//    
//		tt.exec("hr.employee", "sign_out", new Object[] { 1 }, context);
//
//	}
//}
//
//
//redstone.xmlrpc.XmlRpcStruct context = new redstone.xmlrpc.XmlRpcStructXmlRpcStruct();
