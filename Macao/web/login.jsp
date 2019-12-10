<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1
    response.setHeader("Pragma", "no-cache");// HTTP 1.0
    response.setHeader("Expires", "0");// Proxies
%>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>

<%
    //allow access only if session exists
    if(session.getAttribute("player") != null){
        response.sendRedirect("home.jsp");
    }
%>

<div align="center">
    <h1>Login Page</h1>
    <form action="login" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td>
                    <input type="text" name="user"/>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="pwd" />
                </td>
            </tr>

        </table>
        <input type="submit" value="Login" />
    </form>
</div>
</body>
</html>