package com.customerTicket.JSONResponse;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonResponse {
	volatile private static JsonResponse instance = null;
	
	public static JsonResponse getInstance()
	{
		if(instance == null)
		{
			synchronized(JsonResponse.class)
			{
				if(instance == null)
				{
					instance = new JsonResponse();
				}
			}
		}
		return instance;
	}
	
	private JsonResponse()
	{
	
	}
	
	public void sendResponse(HttpServletResponse response,Map<Object,Object> map) {
		try{
			response.setContentType("text/plain; charset=UTF-8"); //No I18N
			
			StringBuilder sb = new StringBuilder();	
			response.setContentType("application/json"); //No I18N
			PrintWriter out = response.getWriter();
            sb.append(mapToJSONString(map));//No I18N			
			out.println(sb.toString());
			out.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String mapToJSONString(Map<Object,Object> map) throws Exception
	{
    	JSONObject jsonObj = mapToJSONObject(map);
    	return jsonObj.toString();
	}
    
    public JSONObject mapToJSONObject(Map<Object,Object> map) throws Exception
    {
    	JSONObject jsonObj = new JSONObject();
    	int size = map.size();
    	for(Object key : map.keySet())
    	{
    		Object value = map.get(key);
    		if(value instanceof Map)
    		{
    			value = mapToJSONObject((Map<Object,Object>)value);
    		}
    		else if(value instanceof List)
    		{
    			value = listToJSONArray((List)value);
    		}
    		try
    		{
    			jsonObj.put(String.valueOf(key),value);
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	return jsonObj;
    }
    
    public JSONArray listToJSONArray(List list) throws Exception
    {
    	JSONArray jsonArr = new JSONArray();
    	int size = list.size();
    	for(int i = 0;i < size;i++)
    	{
    		Object value = list.get(i);
    		if(value instanceof List)
    		{
    			value = listToJSONArray((List)value);
    		}
    		else if(value instanceof Map)
    		{
    			value = mapToJSONObject((Map<Object,Object>)value);
    		}
    		jsonArr.put(value);
    	}
    	return jsonArr;
    }
    
    public String listToJSON(List list) throws Exception
	{
    	JSONArray jsonArr = listToJSONArray(list);
    	return jsonArr.toString();
	}
}
