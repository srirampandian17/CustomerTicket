package com.customerTicket.Ticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

import com.customerTicket.db.DBObjectImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class TicketAPIHandler {
	public static HashMap getLogginTicketDetails(int customer_id){
		
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection coll = db.getCollection("ticket");	
		BasicDBObject fields = new BasicDBObject();
		fields.put("customer_id",(Integer)customer_id);
		DBCursor cursor =coll.find(fields);
		
		return (HashMap)cursor.next();
	}
	
	public static String logTicket(JSONObject customerObject,JSONObject repObject,String ticket_status,String action){
		String message="SuccesFully Logged Ticket";
		try{
			DB  db=DBObjectImpl.getInstance().getDBObject();
			DBCollection coll = db.getCollection("ticket");	
			if(!action.equals("save")){
				BasicDBObject fields = new BasicDBObject();
				fields.put("customer_id",customerObject.getInt("customer_id"));
				coll.remove(fields);
				
			}
			BasicDBObject doc = new BasicDBObject("title", "MongoDB");
			doc.append("customer_id",customerObject.getInt("customer_id"));	
			doc.append("customer_name",customerObject.getString("name"));	
			doc.append("representative_id",repObject.getInt("representative_id"));	
			doc.append("representative_name",repObject.getString("name"));	
			doc.append("ticket_status",ticket_status);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			doc.append("assigned_Date",reportDate);			
			coll.insert(doc);
		}catch(Exception ex){
			ex.printStackTrace();
			message=ex.getMessage();
		}
		return message;
	}
	public static boolean updateTicket(JSONObject customerObject,JSONObject repObject,JSONObject jsonObject){
		try{
			DB  db=DBObjectImpl.getInstance().getDBObject();
			DBCollection coll = db.getCollection("ticket");	
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("customer_id",customerObject.getInt("customer_id"));
			newDocument.append("customer_name",customerObject.getInt("name"));
			newDocument.append("representative_id",customerObject.getInt("representative_id"));	
			newDocument.append("representative_name",repObject.getInt("name"));
			newDocument.append("ticket_status",jsonObject.getString("ticket_status"));
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			newDocument.append("assigned_Date",reportDate);	
			BasicDBObject searchQuery = new BasicDBObject().append("id",jsonObject.getInt(("ticket_id")));

			coll.update(searchQuery, newDocument);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return true;
	}
	
	public static boolean deleteTicket(int ticket_id){
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection coll = db.getCollection("ticket");	
		coll.remove(new BasicDBObject().append("ticket_id",ticket_id));
		return true;
	}
	
	public static ArrayList<HashMap> getTicketList(){
		ArrayList<HashMap> dataList=new ArrayList<HashMap>();
		DB  db=DBObjectImpl.getInstance().getDBObject();
		DBCollection coll = db.getCollection("ticket");	
		DBCursor cursor=coll.find();
		while(cursor.hasNext()){
			HashMap ticketMap=(HashMap)cursor.next();
			if(((String)ticketMap.get("ticket_status")).equalsIgnoreCase("closed")){
				ticketMap.put("status_closed",true);
			}
			dataList.add(ticketMap);
		}
		return dataList;
	}
	
}
