<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.GlobalInfo" %>
<%@ page import="game.Player" %>
<%@ page import="java.util.UUID" %>
<%@ page import="utils.enums.GameStatus" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1
    response.setHeader("Pragma", "no-cache");// HTTP 1.0
    response.setHeader("Expires", "0");// Proxies
%>

<html>
<head>
    <title>Game</title>
</head>
<body>
<%
    //allow access only if session exists
    Player player = (Player) session.getAttribute("player");
    UUID gameId = (UUID) session.getAttribute("gameId");
    if(player == null){
        response.sendRedirect("login.jsp");
    }
    else {
        if (gameId == null) {
            response.sendRedirect("home.jsp");
        }
    }
%>
<br>
<div id="gameContent">
</div>

<script>
    setInterval(function refreshPlayerList() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("gameContent").innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("GET", "gameContent.jsp", true);
        xhttp.send();
    }, 1000);
</script>

</body>
</html>
