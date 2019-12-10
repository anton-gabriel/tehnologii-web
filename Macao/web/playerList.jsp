<%@ page import="utils.GlobalInfo" %>
<%@ page import="java.util.UUID" %>
<%@ page import="game.GameRoom" %>
<%@ page import="game.Player" %><%--
  Created by IntelliJ IDEA.
  User: crirex
  Date: 12/9/2019
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player Table</title>
</head>
<body>

<table border='1'>
    <tr>
        <td>No</td>
        <td>Player</td>
    </tr>

    <%
        UUID gameId = (UUID) session.getAttribute("gameId");
        GameRoom game = GlobalInfo.getGame(gameId);
        if (game != null) {
            int playerId = 0;
            for (Player player : game.getPlayers()) {
                out.println("<tr><td>");
                out.println("" + playerId);
                out.println("</td><td>");
                out.println(player.getUser().getUsername());
                out.println("</td></tr>");
                playerId += 1;
            }
        }
    %>
</table>
</body>
</html>
