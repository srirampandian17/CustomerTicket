package com.customerTicket.db;


import java.util.ArrayList;
import java.util.HashMap;

import com.customerTicket.JSONResponse.JsonResponse;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

public class DBObjectImpl {
	private static  com.mongodb.DB db=null;
	volatile private static DBObjectImpl instance = null;
    private static String exceptionmessage=null;
	public static DBObjectImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(DBObjectImpl.class)
			{
				if(instance == null)
				{
					instance = new DBObjectImpl();
					instance.initializeIssues();
				}
			}
		}
		return instance;
	}
	private DBObjectImpl(){

	}

	public  DB getDBObject() {
		try{
			if(db==null){
				String textUri = "mongodb://redmart:redmart@ds035643.mongolab.com:35643/customernew";
				MongoClientURI uri = new MongoClientURI(textUri);
				MongoClient mongoClient = new MongoClient(uri);
				db = mongoClient.getDB( "customernew" );
				db.authenticate("redmart", "redmart".toCharArray());
				System.out.println("Connect to database sucredmartValidatorcessfully");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			exceptionmessage=ex.getMessage();
		}
		return db;
	}
	 public static String getMessage(){
		 return exceptionmessage;
	 }
	//Used to create issues first
	private static void initializeIssues() {
		// To connect to mongodb server
		try{
			DB  db=instance.getDBObject();
			System.out.println(" the object   "+db);
			DBCollection coll = db.getCollection("ticket");	
			coll.remove( new BasicDBObject());
			coll = db.getCollection("customer");	
			coll.remove( new BasicDBObject());
			System.out.println("Collection mycol selected successfully");
			for(HashMap dataMap:getCustomerIssueData()){
				BasicDBObject doc = new BasicDBObject("title", "MongoDB");
				for(Object key:dataMap.keySet()){
					doc.append((String)key,dataMap.get((String)key));
				}
				coll.insert(doc);

			}
			coll = db.getCollection("CCSRRep");	
			coll.remove( new BasicDBObject());
			for(HashMap dataMap:getCustomerRepresntativesData()){
				BasicDBObject doc = new BasicDBObject("title", "MongoDB");
				for(Object key:dataMap.keySet()){
					doc.append((String)key,dataMap.get((String)key));
				}
				coll.insert(doc);

			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Document inserted successfully");
	}

	private static ArrayList<HashMap> getCustomerIssueData(){
		ArrayList<HashMap> customerIssuesList=new ArrayList<HashMap>();
		try{
			HashMap customerIssueMap=new HashMap();
			customerIssueMap.put("customer_id",1);
			customerIssueMap.put("description", "there has been delay in item");
			customerIssueMap.put("name", "saranya");
			customerIssueMap.put("location", "singapore west");
			customerIssueMap.put("date", "14/2/2015");
			customerIssueMap.put("ticket_status", "new");
			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("customer_id",2);
			customerIssueMap.put("description", "there has been delay in item");
			customerIssueMap.put("name", "arvind");
			customerIssueMap.put("location", "tirupur");
			customerIssueMap.put("date", "14/2/2015");
			customerIssueMap.put("ticket_status", "new");
			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("customer_id",3);
			customerIssueMap.put("description", "there has been delay in item");
			customerIssueMap.put("name", "saihari");
			customerIssueMap.put("location", "vizag");
			customerIssueMap.put("date", "14/2/2015");
			customerIssueMap.put("ticket_status", "new");
			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("customer_id",4);
			customerIssueMap.put("description", "return the material");
			customerIssueMap.put("name", "testCustomer");
			customerIssueMap.put("date", "8/7/2015");
			customerIssueMap.put("location", "vizag");
			customerIssueMap.put("ticket_status", "new");
			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("customer_id",5);
			customerIssueMap.put("description", "done satisfy eith the responce");
			customerIssueMap.put("name", "testCust123");
			customerIssueMap.put("location", "pune");
			customerIssueMap.put("date", "11/2/2015");
			customerIssueMap.put("ticket_status", "closed");
			customerIssueMap.put("statusClosed",true);
			customerIssuesList.add(customerIssueMap);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return customerIssuesList;
	}

	private static ArrayList<HashMap> getCustomerRepresntativesData(){
		ArrayList<HashMap> customerIssuesList=new ArrayList<HashMap>();
		try{
			HashMap customerIssueMap=new HashMap();
			customerIssueMap.put("representative_id",1);
			customerIssueMap.put("DOJ", "14/11/2010");
			customerIssueMap.put("name", "Jayadev");
			customerIssueMap.put("seat_location", "11WH14");
			customerIssueMap.put("assigned_customers",new ArrayList());
			customerIssueMap.put("customersCount",0);

			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("representative_id",2);
			customerIssueMap.put("DOJ", "17/4/2010");
			customerIssueMap.put("name", "Unadkad");
			customerIssueMap.put("seat_location", "11WH15");
			customerIssueMap.put("assigned_customers",new ArrayList());
			customerIssueMap.put("customersCount",0);
			customerIssuesList.add(customerIssueMap);

			customerIssueMap=new HashMap();
			customerIssueMap.put("representative_id",3);
			customerIssueMap.put("DOJ", "8/10/2012");
			customerIssueMap.put("name", "Sharma");
			customerIssueMap.put("seat_location", "11WH16");
			customerIssueMap.put("assigned_customers",new ArrayList());
			customerIssueMap.put("customersCount",0);
			customerIssuesList.add(customerIssueMap);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return customerIssuesList;
	}
}