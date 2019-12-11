<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/4/2019
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1
    response.setHeader("Pragma", "no-cache");// HTTP 1.0
    response.setHeader("Expires", "0");// Proxies
%>
<html>
<head>
    <title>Page</title>
</head>
<body>
<%
    response.sendRedirect("home.jsp");
%>
</body>
</html>
