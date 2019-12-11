<%@ page import="utils.GlobalInfo" %>
<%@ page import="game.GameRoom" %>
<%@ page import="utils.constants.GameConstants" %><%--
  Created by IntelliJ IDEA.
  User: crirex
  Date: 12/8/2019
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Game Table</title>
</head>
<body>
<table border='1'>
    <tr>
        <td>Game ID</td>
        <td>Number of Players</td>
        <td>Number of Spectators</td>
        <td>Status</td>
        <td>Join</td>
    </tr>

    <%
        for (GameRoom game : GlobalInfo.games) {
            out.println("<tr><td>");
            out.println("" + game.getId());
            out.println("</td><td>");
            out.println(game.getPlayers().size() + "/" + GameConstants.MAXIMUM_PLAYERS);
            out.println("</td><td>");
            out.println(game.getSpectators().size());
            out.println("</td><td>");
            out.println(game.getStatus().toString());
            out.println("</td><td>");
            out.println("<form action=\"joinGame\" method=\"post\">");
            out.println("<input type=\"hidden\" value=\"" + game.getId() + "\" name=\"gameId\" >");
            out.println("<input type=\"submit\" value=\"Join\" >");
            out.println("</form>");
            out.println("</td></tr>");
        }
    %>
</table>
</body>
</html>
