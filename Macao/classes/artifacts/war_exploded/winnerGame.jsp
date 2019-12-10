<%@ page import="game.Player" %>
<%@ page import="java.util.UUID" %>
<%@ page import="utils.enums.GameStatus" %><%--
  Created by IntelliJ IDEA.
  User: crirex
  Date: 12/9/2019
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Winner</title>
</head>
<body>
<%
    //allow access only if session exists
    Player player = (Player) session.getAttribute("player");
    UUID gameId = (UUID) session.getAttribute("gameId");
    GameStatus gameStatus = (GameStatus) session.getAttribute("gameStatus");
    if(player == null){
        response.sendRedirect("login.jsp");
    }
    else {
        if (gameId == null) {
            response.sendRedirect("home.jsp");
        } else {
            if (gameStatus != null) {
                if (gameStatus == GameStatus.INACTIVE) {
                    response.sendRedirect("game.jsp");
                } else if (gameStatus == GameStatus.ACTIVE) {
                    response.sendRedirect("gameActive.jsp");
                }
            }
        }
    }
%>
</body>
</html>
