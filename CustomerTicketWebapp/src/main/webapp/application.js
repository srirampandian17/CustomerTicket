window.CustomerTicket = Ember.Application.create({
  LOG_MODULE_RESOLVER: true,
  LOG_ACTIVE_GENERATION: true,
  LOG_VIEW_LOOKUPS: true,
  LOG_TRANSITIONS: true,
  LOG_TRANSITIONS_INTERNAL: true,
});

CustomerTicket.Router.map(function() {
	  this.route('CustomerIssues', { path: '/CustomerIssues' });
	  this.route('LogTicket', { path: '/LogTicket'});
	  this.route('TicketList', { path: '/TicketList'});
});

CustomerTicket.IndexRoute = Ember.Route.extend({
//	 this.transitionTo('customerIssues');
	redirect: function() {
		   this.transitionTo('CustomerIssues'); 
		  }
});