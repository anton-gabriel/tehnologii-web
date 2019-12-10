<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.GlobalInfo" %>
<%@ page import="game.Player" %>
<%@ page import="java.util.UUID" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1
    response.setHeader("Pragma", "no-cache");// HTTP 1.0
    response.setHeader("Expires", "0");// Proxies
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Home Page</title>
    <script type="text/java" src="g"></script>
</head>
<body>
<%
    //allow access only if session exists
    Player player = (Player) session.getAttribute("player");
    UUID gameId = (UUID) session.getAttribute("gameId");
    String username = "";
    if(gameId != null){
        response.sendRedirect("game.jsp");
    }
    else {

        if (player == null) {
            response.sendRedirect("login.jsp");
        }
        else
        {
            username = player.getUser().getUsername();
        }
    }
%>
<h3>Hi <%=username %>, Login successful. Your Session ID=<%=session.getId() %></h3>

<br>
<form action="logout" method="post">
    <input type="submit" value="Logout" >
</form>

<form action="createGame" method="post">
    <input type="submit" value="Create new game" >
</form>

<div id="listGame">
</div>

<script>
    setInterval(function refreshList() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("listGame").innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("GET", "gameList.jsp", true);
        xhttp.send();
    },1000);
</script>
</body>
</html>
