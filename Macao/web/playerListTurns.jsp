<%@ page import="utils.GlobalInfo" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: crirex
  Date: 12/9/2019
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player List Turns</title>
</head>
<body>

Player <%=out.println(Objects.requireNonNull(GlobalInfo.getGame((UUID) session.getAttribute("gameId"))).getPlayers().getCurrentPlayer().getUser().getUsername()) %>`s turn.
</body>
</html>
