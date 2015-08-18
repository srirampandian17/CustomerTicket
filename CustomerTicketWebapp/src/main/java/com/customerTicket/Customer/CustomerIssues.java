package com.customerTicket.Customer;

import java.util.ArrayList;
import java.util.HashMap;






import org.json.JSONObject;

import com.customerTicket.db.DBObjectImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.util.Hash;

public class CustomerIssues {
		
	public static HashMap getOpenIssues(){
		HashMap dataMap=new HashMap();
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("customer");
		ArrayList<HashMap<String,Object>> issuesList=new ArrayList<HashMap<String,Object>>();
 		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()){
			HashMap issuesMap=(HashMap) cursor.next();
			if(((String)issuesMap.get("ticket_status")).equalsIgnoreCase("closed")){
				issuesMap.put("statusClosed", true);
			}
			issuesList.add(issuesMap);
		}
		try{
			cursor.close();
		}catch(Exception ex){
			
		}
		dataMap.put("ISSUES_LIST",issuesList);
		return dataMap;
	}
	
	public static String deleteCustomer(JSONObject customerObject){
		try{
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("customer");
		BasicDBObject fields = new BasicDBObject();
		fields.put("customer_id",customerObject.getInt("customer_id"));
		collection.remove(fields);
		}catch(Exception ex){
			ex.printStackTrace();
			return ex.getMessage();
		}
		return "Successfully Deleted the CUstomer";
	}
	
	public static boolean updateCustomerDetails(JSONObject jsonObject,String ticket_status){
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("customer");	
		BasicDBObject fields = new BasicDBObject();
		fields.put("customer_id",jsonObject.getInt("customer_id"));
		DBCursor cursor =collection.find(fields);
		HashMap customerMap=(HashMap)cursor.next();
		BasicDBObject newDocument = new BasicDBObject();
		customerMap.put("ticket_status",ticket_status);
		BasicDBObject searchQuery = new BasicDBObject().append("customer_id",jsonObject.getInt("customer_id"));
		collection.remove(searchQuery);
		BasicDBObject doc = new BasicDBObject("title", "MongoDB");
		for(Object key:customerMap.keySet()){
			doc.append((String)key,customerMap.get((String)key));
		}
		collection.insert(doc);
		try{
			cursor.close();
		}catch(Exception ex){
			
		}
		return true;
	}
	
	public static HashMap getCustomerDetails(int customerId){
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("customer");	
		BasicDBObject fields = new BasicDBObject();
				fields.put("customer_id",customerId);
		DBCursor cursor =collection.find(fields);
		HashMap dataMap=(HashMap)cursor.next();
		try{
			cursor.close();
		}catch(Exception ex){
			
		}
		return dataMap;
	}
}
