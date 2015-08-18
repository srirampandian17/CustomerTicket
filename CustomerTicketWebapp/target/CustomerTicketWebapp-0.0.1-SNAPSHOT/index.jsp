<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table, td, th {
    border: 1px solid green;
}

th {
    background-color: green;
    color: white;
}
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
divLeft {
    width: 320px;
    padding: 10px;
    border: 5px solid gray;
    margin: 0;
}
.divBox-1 { width:100%; border-top:1px solid #c6cacc; padding:17px 0;}
.divBox-1 h2.head { margin-bottom:20px}
.admin .reportConfig li.label {width:45%;}
.admin .reportConfig li.field {width:38%}
.admin .crediantials li.label {width:45%}
.admin .crediantials li.field {width:50%}

/*----------------- alerts config css -------------------*/
.alertConfigWrap {
    .daySpan {
        color: #333333;
        font-size: 13px;
    }
    .Authentic {
        margin: 0 0 30px 30px;
        width: 350px;
    }
    .Authentic strong span { 
        margin-left: 0;
    }
}
.alert-btn-box {
    border-top: 1px solid #e3e7e8;
    margin-top: 20px;
    padding-top: 20px;
    text-align: center;
}
.serverAuthentic {
    width: 550px !important;
}
.alertServerWrap { 
    width: 125px !important;
    padding-top: 3px;
}
.modeDropdown .domainName > li {
    overflow: hidden;
    padding: 0;
    width: 100%;
}
.modeDropdown > * {
    vertical-align: middle;
}
.modeDropdown .domainName {
    width: 108px;
}
.alertServerWrap {
    margin-bottom: 12px !important;
}
.modeHint {
    width: 100%;
    float: left;
    font-size: 11px;
    padding-left: 30px;
    color: #9B9FBB;
}

.noteBlockArchive {
    font-size: 11px;
    float: left;
    padding-left: 10px;
    margin-top: 20px;
    width: 100%;
    box-sizing: border-box;
}
.noteBlockArchive a {
    margin-right: 10px;
    color: #6bb020;
    text-decoration: underline;
    float: right;
}
.noteBlockArchive a:hover {
    text-decoration: none;
}

.f-left { float:left}
.reportConfigTable {margin-top:10px; min-width:1110px}

/*Save & cancel Button*/
.btnBlocks {width:20%; height:28px; margin:0 auto; position:relative}
.btnBlocks li { float:left; margin:0; width:50%}
.save {background:#7ebb49; margin-right:10px; color:#ffffff; /*transition: all 0.4s ease 0s;*/} .save:hover { background:@saveHover}
.cancel {background:#d5d8db; color:@darkGrey; /*transition: all 0.4s ease 0s;*/} .cancel:hover {background:#c9cdd0}
.stop {background: #cc3333; color:@white; } .stop:hover {background:#ba2b2b}
</style>
	<head>
		<title>Customer Ticket </title><%--No I18N--%>
		<link href="styles/styles.css"  type="text/css"/>
		<meta http-equiv="Content-Type" rel="stylesheet" content="text/html; charset=UTF-8" />

		<script src="Ember/jquery-1.11.2.js"></script>
		<script src="Ember/jquery-ui-1.10.0.custom.js"></script>
		
		<link  href="Ember/jquery-ui-1.7.1.custom.css" rel="stylesheet"/>

		<script src="Ember/handlebars-v1.3.0.js"></script>
		<script src="Ember/ember-template-compiler.js"></script>
		<script src="Ember/ember.js"></script>
		<%@include file="application.hbs"%>
		<script src="application.js"></script>
		<%@include file="logTicket.hbs"%>
		<script src="logTicket.js"></script>
		<%@include file="CustomerIssues.hbs"%>
		<script src="CustomerIssues.js"></script>
		<%@include file="TicketList.hbs"%>
		<script src="TicketList.js"></script>
	</head>
	<body>
    </body>
</html>
	