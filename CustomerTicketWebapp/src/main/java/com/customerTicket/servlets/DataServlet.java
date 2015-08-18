package com.customerTicket.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.customerTicket.CSRep.CSRepAPIHandler;
import com.customerTicket.Customer.CustomerIssues;
import com.customerTicket.JSONResponse.JsonResponse;
import com.customerTicket.Ticket.TicketAPIHandler;
import com.customerTicket.db.DBObjectImpl;

public class DataServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if((request.getRequestURI()).contains("getLogTicketDetails")){
			HashMap dataMap=new HashMap();
			JSONObject jsonObject=new JSONObject(request.getParameter("DATA_OBJECT"));
			dataMap.put("CUSTOMER_DETAILS",CustomerIssues.getCustomerDetails(jsonObject.getInt("customer_id")));
			dataMap.put("REPRESENTATIVE_LIST",CSRepAPIHandler.getCSRepDetails());
			System.out.println("  the data from data Map is  "+dataMap);
			JsonResponse.getInstance().sendResponse(response,dataMap);
		}else if((request.getRequestURI()).contains("editLogTicketDetails")){
			HashMap dataMap=new HashMap();
			JSONObject jsonObject=new JSONObject(request.getParameter("DATA_OBJECT"));
			int customerId=jsonObject.getInt("customer_id");//No I18n
			dataMap=TicketAPIHandler.getLogginTicketDetails(customerId);
			System.out.println("  the ticket map  "+dataMap);
			dataMap.put("CUSTOMER_DETAILS",CustomerIssues.getCustomerDetails(customerId));
			dataMap.put("REPRESENTATIVE_LIST",CSRepAPIHandler.getCSRepDetails());

			dataMap.put("SELECTED_REP",CSRepAPIHandler.getCSRepDetails((Integer)dataMap.get("representative_id")));

			System.out.println("  the data from data Map is  "+dataMap);
			JsonResponse.getInstance().sendResponse(response,dataMap);
		}else if((request.getRequestURI()).contains("createTicket")){
			HashMap dataMap=new HashMap();
			JSONObject jsonObject=new JSONObject(request.getParameter("DATA_OBJECT"));
			CSRepAPIHandler.updateCSRepDetails(jsonObject.getJSONObject("customerData"),jsonObject.getJSONObject("repData"), jsonObject.getString("action"));
			CustomerIssues.updateCustomerDetails(jsonObject.getJSONObject("customerData"),jsonObject.getString("ticket_status"));
			dataMap.put("MESSAGE", TicketAPIHandler.logTicket(jsonObject.getJSONObject("customerData"),jsonObject.getJSONObject("repData"),jsonObject.getString("ticket_status"),jsonObject.getString("action")));
			JsonResponse.getInstance().sendResponse(response,dataMap);
		}else if ((request.getRequestURI()).contains("getTicketsList")){
			HashMap dataMap=new HashMap();
			dataMap.put("TICKET_LIST",TicketAPIHandler.getTicketList());
			System.out.println("  the data from data Map is  "+dataMap);
			JsonResponse.getInstance().sendResponse(response,dataMap);
		}else{
			if((request.getRequestURI()).contains("deleteCustomer")){
				CustomerIssues.deleteCustomer(new JSONObject(request.getParameter("DATA_OBJECT")));
			}
			HashMap dataMap= CustomerIssues.getOpenIssues();
			dataMap.put("message",DBObjectImpl.getMessage());
			JsonResponse.getInstance().sendResponse(response,dataMap);
		}
	}
	
	

}
