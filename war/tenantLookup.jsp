<%@ page import="java.util.List"%>
<%@ page import="tailspin.entities.*"%>

<%
	List <Tenant> tenants = (List<Tenant>) request.getAttribute("tenants");
%>

<html>
<head>
	<title>App Engine Surveys App with Bigtables</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/styles.css"/>
</head>
<body>
	<span class="title">Google App Engine Surveys App with Bigtable</span>
	<p/>
	<p>Before creating a new Survey, ensure that the tenant does not already exist.
	You can also <a href="thesurveysapp?action=tenantCreate"/>create a new tenant</a>.</p>
	<p/>
	<form method="post" action="thesurveysapp">
		<input type="hidden" name="action" value="tenantLookup"/>
		<span class="heading">Search by Tenant Name:</span>
		<p/>
		<input type="text" name="tenantName" value="
			<%if(request.getParameter("accountName")!=null){
				out.println(request.getParameter("accountName"));
				}
			%>"
			style="width:300px;"
		/>
		&nbsp
		<input type="submit" value="Search"/>
		&nbsp
	</form>
	</p>
	<%
	if(tenants.size()>0){%>
		<span class="heading"><%=tenants.size() %> tenants matching your search criteria:</span>
		<p/>
		<table border="0" cellspacing="1" cellpadding="5" bgcolor=""CCCCCC" width="50%">
			<tr bgcolor="#407BA8">
				<td style="color: #ffffff; font-weight: bold;">Name</td>
				<td style="color: #ffffff; font-weight: bold;">Description</td>
				<td style="color: #ffffff; font-weight: bold;">Address</td>
			</tr>
			<tr>
				<%
				for(int i=0; i<tenants.size(); i++){%>
					<% Tenant t = (Tenant) tenants.get(i); %>
					<tr style="background:#ffffff" onMouseOver="this.style.background='#eeeeee';" onMouseOut="this.style.background='#ffffff';">
						<td><a href="thesurveysapp?action=tenantDisplay&tenantId=<%=t.getID()%>"><%= t.getTenantName() %></a></td>
						<td><%=t.getTenantDesc()%></td>
						<td><%=t.getTenantAddress()%></td>
					</tr>
				<%}%>			
		</table>
	<%} else{%>
		<span class="heading">No matching tenants found. </span>
	<%}%>
	<p/>
</body>
</html>