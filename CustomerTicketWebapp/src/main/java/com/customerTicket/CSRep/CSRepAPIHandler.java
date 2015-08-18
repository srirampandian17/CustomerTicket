package com.customerTicket.CSRep;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.customerTicket.JSONResponse.JsonResponse;
import com.customerTicket.db.DBObjectImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CSRepAPIHandler {
	public static ArrayList<HashMap> getCSRepDetails(){
		ArrayList<HashMap> csrRepList=new ArrayList<HashMap>();
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("CCSRRep");		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()){
			csrRepList.add((HashMap) cursor.next());
		}
		return csrRepList;
	}
	
	public static HashMap getCSRepDetails(int repId){
		
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("CCSRRep");		
		
		BasicDBObject fields = new BasicDBObject();
		fields.put("representative_id",repId);
		DBCursor cursor = collection.find(fields);
		return (HashMap)cursor.next();

	}
	
	public static boolean updateCSRepDetails(JSONObject customerObject,JSONObject repObject,String action){
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection collection = db.getCollection("CCSRRep");	
		BasicDBObject fields = new BasicDBObject();
		fields.put("representative_id",repObject.getInt("representative_id"));
		DBCursor cursor =collection.find(fields);
		HashMap repMap=(HashMap)cursor.next();
		ArrayList assignedCustomerList=(ArrayList)repMap.get("assigned_customers");//No I18n
		if(action.equalsIgnoreCase("save")){
			assignedCustomerList.add(customerObject.getInt("customer_id"));
		}else if(action.equalsIgnoreCase("delete")){
			assignedCustomerList.remove(customerObject.getInt("customer_id"));
		}
		repMap.put("customersCount",assignedCustomerList.size());
		repMap.put("assigned_customers",assignedCustomerList);
		BasicDBObject doc = new BasicDBObject("title", "MongoDB");
		for(Object key:repMap.keySet()){
			doc.append((String)key,repMap.get((String)key));
		}
		BasicDBObject searchQuery = new BasicDBObject().append("representative_id",repObject.getInt("representative_id"));

		collection.remove(searchQuery);
		collection.insert(doc);
		return true;
	}
}
