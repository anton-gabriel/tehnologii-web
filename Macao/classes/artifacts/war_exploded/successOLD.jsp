<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/4/2019
  Time: 10:30 PM
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
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <table style="with: 50%">
        <tr><td>
            <% String username = (String)request.getSession().getAttribute("user"); %>
            <a>Welcome   <% out.println(username); %> User!!!! You have logged in.</a></td></tr>
        <tr></tr><tr><td></td><td></td><td><a href="login.jsp"><b>Logout</b></a></td></tr>
    </table>
</div>
</body>
</html>