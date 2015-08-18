CustomerTicket.LogTicketController = Ember.ObjectController.extend({
	queryParams: ['customer_id','action','customer_name','representative_id'],
	customer_name:null,
	customer_id:null,	
	representative_id:null,
	action:"save",
	ticketStatus:"assigned",
	actions:{
		createTicket:function(){
			CustomerTicket.LogTicketClass.saveTicketDetails(this.get("customerData"),this.get("selectedCustomer"),this.get("action"),this);
			
		}
	}
});
var LogTicketModel = Ember.Object.create();
CustomerTicket.LogTicketClass = Ember.Object.extend();
CustomerTicket.LogTicketClass.reopenClass({
	getTicketDetails:function(customer_id,action,representative_id){
		
	    var jsonData={};
	    jsonData["customer_id"]=customer_id;
	    
		var issuesList={};
		var Ajaxurl="/CustomerTicketWebapp/getLogTicketDetails";
		if(action=="edit"){
			 jsonData["representative_id"]=representative_id;
			Ajaxurl="/CustomerTicketWebapp/editLogTicketDetails";
		}
		$.ajax({
		    type: "POST",
		    url: Ajaxurl,
		    async: false,
		    data: {"DATA_OBJECT":JSON.stringify(jsonData)},
   			success: function(dataJson) {
   				issuesList["customerData"]=dataJson.CUSTOMER_DETAILS;	
   				issuesList["repDataList"]=dataJson.REPRESENTATIVE_LIST;
   				issuesList["ticket_status"]=dataJson["CUSTOMER_DETAILS"].ticket_status;
   				if(action=="save"){
   					var list=dataJson.REPRESENTATIVE_LIST;
   					issuesList["selectedCustomer"]=list.get(0);
   				}else{
   					issuesList["selectedCustomer"]=dataJson.SELECTED_REP;
   					
   				}
   				for(var i=0;i<issuesList["repDataList"].length;i++){
   					 if((issuesList["repDataList"])[i].representative_id==issuesList["selectedCustomer"].representative_id){
   						issuesList["selectedCustomer"]=(issuesList["repDataList"])[i];
   						break;
   					 }
   					
   				}
   				
    		}
		});
		console.log("the dataList  is    "+issuesList);
		return issuesList;
	},saveTicketDetails:function(customerDetails,repMap,action,self){
	    var jsonData={};
	    jsonData["customerData"]=customerDetails;
	    jsonData["repData"]=repMap;
	    jsonData["action"]=action;
	    jsonData["ticket_status"]=document.getElementById("ticket_status").value;
	    if(jsonData["ticket_status"]=="new"){
	    	alert("  plz change the status");
	    }else{
		var Ajaxurl="/CustomerTicketWebapp/createTicket";
		
		$.ajax({	
		    type: "POST",
		    url: Ajaxurl,
		    async: false,
		    data: {"DATA_OBJECT":JSON.stringify(jsonData)},
   			success: function(dataJson) {
   				alert(dataJson.MESSAGE);
   				self.transitionTo("TicketList");
    		}
		});
	    }
		return issuesList;
	}
});
CustomerTicket.LogTicketRoute = Ember.Route.extend({
	model: function(params) {
		if(params.action!=null&&params.action=="edit"){
			this.set("action","edit");
			return CustomerTicket.LogTicketClass.getTicketDetails(params.customer_id,"edit",params.representative_id);
		}
		return CustomerTicket.LogTicketClass.getTicketDetails(params.customer_id,"save",undefined);
	},
	renderTemplate: function(){
		
		this.render('LogTicket',{//No I18N
			into: 'application',//No I18N
			outlet: 'contentBar'//No I18N
		});
	}
});