CustomerTicket.CustomerIssuesController = Ember.ObjectController.extend({
	actions:{
		deleteCustomer:function(customer_id){
			this.set("model",CustomerTicket.CustomerIssuesClass.deleteCustomer(customer_id));
		},
		logTicket:function(customer_id){
			this.transitionToRoute('LogTicket', {queryParams: {customer_id:customer_id,action:"save"}});//No I18n
		}
	}
});
var customerIssuesModel = Ember.Object.create();
CustomerTicket.CustomerIssuesClass = Ember.Object.extend();
CustomerTicket.CustomerIssuesClass.reopenClass({
	getOpenIssues:function(){
	var issuesList={};
		var Ajaxurl="/CustomerTicketWebapp/getCustomerIsues";
		$.ajax({
		    type: "POST",
		    url: Ajaxurl,
		    async: false,		    
   			success: function(dataJson) {
   				issuesList["issuesList"]=dataJson.ISSUES_LIST;	
    		}
		});
		console.log("the dataList  is    "+issuesList);
		return issuesList;
	},deleteCustomer:function(customer_id){
		var customerData={};
		var issuesList={};
		customerData["customer_id"]=customer_id;
		var Ajaxurl="/CustomerTicketWebapp/deleteCustomer";
		$.ajax({
		    type: "POST",
		    url: Ajaxurl,
		    async: false,	
			data: {"DATA_OBJECT":JSON.stringify(customerData)},
   			success: function(dataJson) {
   				
   				issuesList["issuesList"]=dataJson.ISSUES_LIST;	
    		}
		});
		return issuesList;
	}	
});
CustomerTicket.CustomerIssuesRoute = Ember.Route.extend({
	
	renderTemplate: function(){
		this.render('CustomerIssues',{//No I18N
			into: 'application',//No I18N
			outlet: 'contentBar'//No I18N
		});
	},setupController: function(controller,model){
		controller.set("model",CustomerTicket.CustomerIssuesClass.getOpenIssues());//No I18N
	}
});