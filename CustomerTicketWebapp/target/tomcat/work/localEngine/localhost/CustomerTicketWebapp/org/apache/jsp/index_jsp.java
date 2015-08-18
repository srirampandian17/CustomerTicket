package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/application.hbs");
    _jspx_dependants.add("/logTicket.hbs");
    _jspx_dependants.add("/CustomerIssues.hbs");
    _jspx_dependants.add("/TicketList.hbs");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<!-- CSS goes in the document HEAD or added to your external stylesheet -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table, td, th {\r\n");
      out.write("    border: 1px solid green;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("    background-color: green;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("table.gridtable {\r\n");
      out.write("\tfont-family: verdana,arial,sans-serif;\r\n");
      out.write("\tfont-size:11px;\r\n");
      out.write("\tcolor:#333333;\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("table.gridtable th {\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tbackground-color: #dedede;\r\n");
      out.write("}\r\n");
      out.write("table.gridtable td {\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tbackground-color: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("divLeft {\r\n");
      out.write("    width: 320px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    border: 5px solid gray;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("}\r\n");
      out.write(".divBox-1 { width:100%; border-top:1px solid #c6cacc; padding:17px 0;}\r\n");
      out.write(".divBox-1 h2.head { margin-bottom:20px}\r\n");
      out.write(".admin .reportConfig li.label {width:45%;}\r\n");
      out.write(".admin .reportConfig li.field {width:38%}\r\n");
      out.write(".admin .crediantials li.label {width:45%}\r\n");
      out.write(".admin .crediantials li.field {width:50%}\r\n");
      out.write("\r\n");
      out.write("/*----------------- alerts config css -------------------*/\r\n");
      out.write(".alertConfigWrap {\r\n");
      out.write("    .daySpan {\r\n");
      out.write("        color: #333333;\r\n");
      out.write("        font-size: 13px;\r\n");
      out.write("    }\r\n");
      out.write("    .Authentic {\r\n");
      out.write("        margin: 0 0 30px 30px;\r\n");
      out.write("        width: 350px;\r\n");
      out.write("    }\r\n");
      out.write("    .Authentic strong span { \r\n");
      out.write("        margin-left: 0;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write(".alert-btn-box {\r\n");
      out.write("    border-top: 1px solid #e3e7e8;\r\n");
      out.write("    margin-top: 20px;\r\n");
      out.write("    padding-top: 20px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".serverAuthentic {\r\n");
      out.write("    width: 550px !important;\r\n");
      out.write("}\r\n");
      out.write(".alertServerWrap { \r\n");
      out.write("    width: 125px !important;\r\n");
      out.write("    padding-top: 3px;\r\n");
      out.write("}\r\n");
      out.write(".modeDropdown .domainName > li {\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("}\r\n");
      out.write(".modeDropdown > * {\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write(".modeDropdown .domainName {\r\n");
      out.write("    width: 108px;\r\n");
      out.write("}\r\n");
      out.write(".alertServerWrap {\r\n");
      out.write("    margin-bottom: 12px !important;\r\n");
      out.write("}\r\n");
      out.write(".modeHint {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    float: left;\r\n");
      out.write("    font-size: 11px;\r\n");
      out.write("    padding-left: 30px;\r\n");
      out.write("    color: #9B9FBB;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noteBlockArchive {\r\n");
      out.write("    font-size: 11px;\r\n");
      out.write("    float: left;\r\n");
      out.write("    padding-left: 10px;\r\n");
      out.write("    margin-top: 20px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write(".noteBlockArchive a {\r\n");
      out.write("    margin-right: 10px;\r\n");
      out.write("    color: #6bb020;\r\n");
      out.write("    text-decoration: underline;\r\n");
      out.write("    float: right;\r\n");
      out.write("}\r\n");
      out.write(".noteBlockArchive a:hover {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".f-left { float:left}\r\n");
      out.write(".reportConfigTable {margin-top:10px; min-width:1110px}\r\n");
      out.write("\r\n");
      out.write("/*Save & cancel Button*/\r\n");
      out.write(".btnBlocks {width:20%; height:28px; margin:0 auto; position:relative}\r\n");
      out.write(".btnBlocks li { float:left; margin:0; width:50%}\r\n");
      out.write(".save {background:#7ebb49; margin-right:10px; color:#ffffff; /*transition: all 0.4s ease 0s;*/} .save:hover { background:@saveHover}\r\n");
      out.write(".cancel {background:#d5d8db; color:@darkGrey; /*transition: all 0.4s ease 0s;*/} .cancel:hover {background:#c9cdd0}\r\n");
      out.write(".stop {background: #cc3333; color:@white; } .stop:hover {background:#ba2b2b}\r\n");
      out.write("</style>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Customer Ticket </title>");
      out.write("\r\n");
      out.write("\t\t<link href=\"styles/styles.css\"  type=\"text/css\"/>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" rel=\"stylesheet\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<script src=\"Ember/jquery-1.11.2.js\"></script>\r\n");
      out.write("\t\t<script src=\"Ember/jquery-ui-1.10.0.custom.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link  href=\"Ember/jquery-ui-1.7.1.custom.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("\t\t<script src=\"Ember/handlebars-v1.3.0.js\"></script>\r\n");
      out.write("\t\t<script src=\"Ember/ember-template-compiler.js\"></script>\r\n");
      out.write("\t\t<script src=\"Ember/ember.js\"></script>\r\n");
      out.write("\t\t");
      out.write("<script type=\"text/x-handlebars\" data-template-name=\"application\">\r\n");
      out.write("<table ><tr>\r\n");
      out.write("    <td width=\"40%\">\r\n");
      out.write("    \t\r\n");
      out.write("\t\t<div style=\"color:#0000FF\" class=\"divBox-1 admin\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>{{#link-to 'TicketList'}}TicketList{{/link-to}}</li>\r\n");
      out.write("\t\t\t\t<li>{{#link-to 'CustomerIssues'}}Customer Issues{{/link-to}}</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t{{outlet 'contentBar'}}\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t\t<script src=\"application.js\"></script>\r\n");
      out.write("\t\t");
      out.write("<script type=\"text/x-handlebars\" data-template-name=\"LogTicket\">\r\n");
      out.write("\t<h1> Log a Ticket </h1>\r\n");
      out.write("\t<div class=\"divBox-1 admin\">\r\n");
      out.write("\t\t<table class=\"reportConfigTable\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<div class=\"alertConfigWrap\">\r\n");
      out.write("\t\t\t<td width=\"50%\">\t\t\t\t\r\n");
      out.write("                 <div class=\"Authentic f-left\">\r\n");
      out.write("                       <strong>CustomerName</strong>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 </td><td>\r\n");
      out.write("  \t\t            <div class=\"f-left\">\r\n");
      out.write("        \t\t         <label>{{customerData.name}}</label>\r\n");
      out.write("                \t</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                     </div>\r\n");
      out.write("            </tr>        \r\n");
      out.write("            <tr>\r\n");
      out.write("            <div class=\"alertConfigWrap\">\r\n");
      out.write("\t\t\t<td width=\"50%\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                        <div class=\"Authentic f-left\">\r\n");
      out.write("                            <strong>Date of Assignment</strong>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </td><td>\r\n");
      out.write("                        <div class=\"f-left\">\r\n");
      out.write("                            <label>{{customerData.date}}</label>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                   \r\n");
      out.write("             </td>\r\n");
      out.write("              </div>\r\n");
      out.write("            </tr>      \r\n");
      out.write("            <tr>\r\n");
      out.write("            <div class=\"alertConfigWrap\">\r\n");
      out.write("\t\t\t<td width=\"50%\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                        <div class=\"Authentic f-left\">\r\n");
      out.write("                            <strong>Ticket Status</strong>\r\n");
      out.write("                        </div>\r\n");
      out.write("              </td><td>\r\n");
      out.write("                        <div class=\"f-left\">\r\n");
      out.write("                            {{input type=\"text\" id=\"ticket_status\" value=ticket_status class=\"wth-42\"}}\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                    \r\n");
      out.write("\t\t\t\t </td>\r\n");
      out.write("\t\t\t\t </div>\r\n");
      out.write("            </tr>   \r\n");
      out.write("            <tr>\r\n");
      out.write("            <div class=\"alertConfigWrap\">\r\n");
      out.write("\t\t\t\t<td width=\"50%\">\r\n");
      out.write("\t\t\t\t<div class=\"Authentic f-left\">\r\n");
      out.write("                            <strong>Rep Name</strong>\r\n");
      out.write("                        </div>\r\n");
      out.write("\t\t\t </td><td>\r\n");
      out.write("\t\t\t\t {{view \"select\" content=repDataList optionValuePath=\"content.representative_id\" optionLabelPath=\"content.name\" selection=selectedCustomer}}\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t\t </tr>\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("\t\t\t \t<td width=\"50%\">\r\n");
      out.write("\t\t\t         <div class=\"Authentic f-left\">\r\n");
      out.write("                          <strong>assigned Issues to {{selectedCustomer.name}}  </strong>\r\n");
      out.write("                     </div>\r\n");
      out.write("                 </td><td>   \r\n");
      out.write("                        <div class=\"f-left\">\r\n");
      out.write("                            <label> {{selectedCustomer.customersCount}}</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("\t\t\t </td>\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t </tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table class=\"reportConfigTable\">\r\n");
      out.write("                <td >\r\n");
      out.write("                    <div class=\"btnBlocks alert-btn-box clear\" style=\"width:auto\">\r\n");
      out.write("                        <input type=\"button\" {{action createTicket }} class=\"save\" value=\"Save\"/>\r\n");
      out.write("                        <input type=\"button\" class=\"cancel\" value=\"Cancel\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </td>\r\n");
      out.write("              \r\n");
      out.write("            </table>   \r\n");
      out.write("\t</div>\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t\t<script src=\"logTicket.js\"></script>\r\n");
      out.write("\t\t");
      out.write("<script type=\"text/x-handlebars\" data-template-name=\"CustomerIssues\">\r\n");
      out.write("<h1> Customer Issues </h1>\r\n");
      out.write("<table style=\"width:100%\" class=\"reportConfigTable\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t  <th  >ID</th>\r\n");
      out.write("\t\t  <th  >DESCRIPTION</th>\r\n");
      out.write(" \t\t  <th   >NAME</th>\r\n");
      out.write("  \t\t  <th   >LOCATION</th>\r\n");
      out.write("  \t\t  <th   >STATUS</th>\r\n");
      out.write("  \t\t  <th   >ACTION</th>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("</tr>\r\n");
      out.write("\t{{#each customer in issuesList}}\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td >{{customer.customer_id}}</td>\r\n");
      out.write("  \t\t\t<td >{{customer.description}}</td>\r\n");
      out.write("  \t\t\t<td>{{customer.name}}</td>\r\n");
      out.write("  \t\t\t<td>{{customer.location}}</td>\r\n");
      out.write("  \t\t\t<td>{{customer.ticket_status}}</td>\r\n");
      out.write("  \t\t\t{{#if customer.statusClosed}}\r\n");
      out.write("  \t\t\t\t<td >\r\n");
      out.write("  \t\t\t\t\t<ul><li>\r\n");
      out.write("  \t\t\t\t\t\t<button>\r\n");
      out.write("\t  \t\t\t\t\t<label {{action \"deleteCustomer\" customer.customer_id}}>DELETE</label>\r\n");
      out.write("  \t\t\t\t\t\t</button>\r\n");
      out.write("  \t\t\t\t\t</li></ul>\r\n");
      out.write("  \t\t\t\t</td>\r\n");
      out.write("  \t\t\t{{else}}\r\n");
      out.write("  \t\t\t\t<td >\r\n");
      out.write("  \t\t\t\t\t<ul><li>\r\n");
      out.write("  \t\t\t\t\t<button>\r\n");
      out.write("\t  \t\t\t\t\t<label {{action \"logTicket\" customer.customer_id}}>LOG Ticket</label>\r\n");
      out.write("  \t\t\t\t\t\t</button>\r\n");
      out.write("  \t\t\t\t\t</li></ul>\r\n");
      out.write("  \t\t\t\t</td>\r\n");
      out.write("  \t\t\t{{/if}}\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t{{/each}}\r\n");
      out.write("</table>\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t\t<script src=\"CustomerIssues.js\"></script>\r\n");
      out.write("\t\t");
      out.write("<script type=\"text/x-handlebars\" data-template-name=\"TicketList\">\r\n");
      out.write("<h1> status of all tickets so far </h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<table class=\"reportConfigTable\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>\r\n");
      out.write("\t\t\t\tSTATUS\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tCUSTOMER_NAME\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tREP NAME\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\tACTION\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t</tr>\t\r\n");
      out.write("\t\t{{#each ticket in ticketsList}}\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("                        <div >\r\n");
      out.write("                          <label>{{ticket.ticket_status}}</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("              </td><td>\r\n");
      out.write("                        <div >\r\n");
      out.write("                            <label>{{ticket.customer_name}}</label>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("              </td>\r\n");
      out.write("              <td>\r\n");
      out.write("                        <div >\r\n");
      out.write("                            <label>{{ticket.representative_name}}</label>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("              </td>\r\n");
      out.write("              <td >\r\n");
      out.write("              \t\t{{#if ticket.status_closed}}\r\n");
      out.write("  \t\t\t\t\t<ul><li>\r\n");
      out.write("  \t\t\t\t\t     <button>\r\n");
      out.write("\t  \t\t\t\t\t\t<label >CLOSED</label>\r\n");
      out.write("  \t\t\t\t\t\t</button>\r\n");
      out.write("  \t\t\t\t\t</li></ul>\r\n");
      out.write("  \t\t\t\t\t{{else}}\r\n");
      out.write("  \t\t\t\t\t\t<ul><li>\r\n");
      out.write("  \t\t\t\t\t     <button>\r\n");
      out.write("\t  \t\t\t\t\t\t<label {{action \"editTicket\" ticket.customer_id ticket.representative_id}}>EDIT</label>\r\n");
      out.write("  \t\t\t\t\t\t</button>\r\n");
      out.write("  \t\t\t\t\t</li></ul>\r\n");
      out.write("  \t\t\t\t\t{{/if}}\r\n");
      out.write("  \t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t{{/each}}\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t\t<script src=\"TicketList.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\t");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
