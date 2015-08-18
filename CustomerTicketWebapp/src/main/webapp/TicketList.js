CustomerTicket.TicketListController = Ember.ObjectController.extend({
	queryParams: ['customer_id'],
	customer_id:null,	
	action:"save",
	actions:{
		editTicket:function(customer_name,representative_id){
			this.transitionTo('LogTicket', {queryParams: {customer_id:parseInt(customer_name),action:"edit",representative_id:representative_id}});//No I18n
		}
	}
});
var TicketListModel = Ember.Object.create();
CustomerTicket.TicketListClass = Ember.Object.extend();
CustomerTicket.TicketListClass.reopenClass({
	getTicketsList:function(customer_id){
		var ticketsList={};
		var Ajaxurl="/CustomerTicketWebapp/getTicketsList";
		$.ajax({
		    type: "POST",
		    url: Ajaxurl,
		    async: false,
   			success: function(dataJson) {
   				ticketsList["ticketsList"]=dataJson.TICKET_LIST;
    		}
		});
		console.log("the dataList  is    "+ticketsList);
		return ticketsList;
	}
});
CustomerTicket.TicketListRoute = Ember.Route.extend({
	model: function(params) {
		return CustomerTicket.TicketListClass.getTicketsList();
	},
	renderTemplate: function(){
		this.render('TicketList',{//No I18N
			into: 'application',//No I18N
			outlet: 'contentBar'//No I18N
		});
	}
});