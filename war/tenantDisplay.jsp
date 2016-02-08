<%@ page import="java.util.List" %>
<%@ page import="tailspin.entities.*" %>

<% 
	Tenant tenant = (Tenant) request.getAttribute("tenant");
	List <Survey> surveys = (List<Survey>) request.getAttribute("surveys");
%>

<html>
<head>
	<title>Surveys App</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/styles.css"/>
</head>
<body>
	<span class="nav"><a href="/adminPage.html">Search</a></span><p/>
	<span class="title">Account Display</span>
	<p/>
	
	<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
		<tr bgcolor="#407BA8">
			<td style="color: #ffffff; font-weight: bold;">Name</td>
			<td bgcolor="#ffffff"><%= tenant.getTenantName() %> 
		</tr>
		<tr bgcolor="#407BA8">
			<td style="color: #ffffff; font-weight: bold;">Description</td>
			<td bgcolor="#ffffff"><%= tenant.getTenantDesc() %>
		</tr>
		<tr bgcolor="#407BA8">
			<td style="color: #ffffff; font-weight: bold;">Address</td>
			<td bgcolor="#ffffff"><%= tenant.getTenantAddress() %>
		</tr>
	</table>
	
	<br>
		<%if(surveys!= null && surveys.size() > 0){%>
			<p/><span class="heading">Surveys for <%=tenant.getID() %></span>
			<br>
			<p/>
			<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
				<tr bgcolor="#407BA8">
					<td style="color: #ffffff; font-weight: bold;">No.</td>
					<td style="color: #ffffff; font-weight: bold;">Name</td>
				</tr>
				<%for (int i=0; i<surveys.size(); i++){ %>
					<%Survey s = (Survey) surveys.get(i); %>
					<tr style="background:#ffffff" onMouseOver="this.style.background='#eeeeee';" onMouseOut="this.style.background='#ffffff';">
						<td><%=i+1 %></td>
						<td><%=s.getName() %></td>
					</tr>
				<%} %>
			</table>
		<%} else{%>
			<p/><span class="heading">No surveys found for <%=tenant.getTenantName() %></span>
			<%} %>
</body>
</html>