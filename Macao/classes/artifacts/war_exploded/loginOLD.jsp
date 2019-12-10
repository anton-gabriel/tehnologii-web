<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/4/2019
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<div align="center">
    <h1>Login Page</h1>
    <form action="login" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td>
                    <input type="text" name="username" />
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" />
                </td>
            </tr>

        </table>
        <input type="submit" value="Login" />
    </form>
</div>
</body>
</html>