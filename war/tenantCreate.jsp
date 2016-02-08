<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Surveys App</title>
<link rel="stylesheet" type="text/css" href="/stylesheets/styles.css"/>
</head>
<body>
	<span class="nav"><a href="adminPage.html">Back</a></span><p/>
	<span class="title">Create a New Tenant</span>
	<p/>
	
	<form method="get" action="thesurveysapp">
	<input type="hidden" name="action" value="tenantCreateDo"/>
	<table>
		<tr>
			<td>Company name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" name="description"></td>		
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Create"></td>
		</tr>
	</table>
	</form>
</body>
</html>