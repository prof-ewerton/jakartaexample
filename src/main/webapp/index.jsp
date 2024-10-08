<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>OK!!!</h1>
	<h1>OK!!!</h1>
	<h1>OK!!!</h1>
	<%
	double num = Math.random(); // [0.0, 1.0)
	if (num > 0.95) {
	%>
	<h2>You'll have a luck day!</h2>
	<p>
		(<%=num%>)
	</p>
	<% } else { %>
	<h2>Well, life goes on ...</h2>
	<p>(<%=num%>)</p>
	<% } %>
	<a href="<%=request.getRequestURI()%>"><h3>Try Again</h3></a>
</body>
</html>