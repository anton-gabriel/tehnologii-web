<%@ page import="utils.GlobalInfo" %>
<%@ page import="java.util.UUID" %>
<%@ page import="game.GameRoom" %>
<%@ page import="game.Player" %>
<%@ page import="utils.enums.GameStatus" %>
<%@ page import="java.util.Objects" %>
<%@ page import="game.Card" %>
<%@ page import="utils.enums.PlayerStatus" %>
<%@ page import="utils.enums.CardSymbol" %>
<%@ page import="servlet.ExitGame" %>
<%@ page import="utils.constants.ApplicationConstants" %><%--
<%--
  Created by IntelliJ IDEA.
  User: crirex
  Date: 12/9/2019
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Content</title>
</head>
<body>
<%
    //allow access only if session exists
    Player player = (Player) session.getAttribute("player");
    Boolean sevenSymbol = (Boolean) session.getAttribute("seven");
    UUID gameId = (UUID) session.getAttribute("gameId");
    if (player == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (gameId == null) {
            response.sendRedirect("home.jsp");
        }
    }
    GameRoom game = GlobalInfo.getGame(gameId);
%>

Game=<%=gameId %>

<form action="exitGame" method="post">
    <input type="submit" value="Exit">
</form>

<%
    assert game != null;
    if (game.getStatus() == GameStatus.INACTIVE) {
%>

<table border='1'>
    <tr>
        <td>No</td>
        <td>Player</td>
    </tr>

    <%
        int playerId = ApplicationConstants.INITIAL_INDEX;
        for (Player gotPlayer : game.getPlayers()) {
            out.println("<tr><td>");
            out.println("" + playerId);
            out.println("</td><td>");
            out.println(gotPlayer.getUser().getUsername());
            out.println("</td></tr>");
            playerId += ApplicationConstants.ITERATION_VALUE;
        }
    %>
</table>
<br>
<%
    if (game.getPlayers().size() >= 2 && game.getGameOwner().equals(player)) {
        out.println("<form action=\"startGame\" method=\"post\"><input type=\"submit\" value=\"Start Game\" ></form>");
    } else {
        out.println("<form action=\"startGame\" method=\"post\"><input type=\"submit\" value=\"Start Game\" disabled></form>");
    }
%>

<%
} else if (game.getStatus() == GameStatus.ACTIVE) {
%>

<%
    Player currentPlayer = Objects.requireNonNull(GlobalInfo.getGame((UUID) session.getAttribute("gameId"))).getPlayers().getCurrentPlayer();
%>

Player <%=currentPlayer.getUser().getUsername() %>`s turn.
<br><br><br><br><br>

Curent card on top is <%=game.getCurrentCard().toString() %>

<br><br><br><br><br>

<%=game.getDeck().getCards().size() %> cards remaining.

<br><br><br><br><br>

The number of cards to draw
are <%= game.getStackedDrawCards().getNumberOfCards() != 0 ? game.getStackedDrawCards().getNumberOfCards() : 1 %>

<%
    if (sevenSymbol == null) {
        assert player != null;
        if (player.getStatus() != PlayerStatus.SPECTATING) {
            if (game.getPlayers().getCurrentPlayer().equals(player)) {
                out.println("<form action=\"drawCard\" method=\"post\"><input type=\"submit\" value=\"Draw\" ></form>");
            } else {
                out.println("<form action=\"drawCard\" method=\"post\"><input type=\"submit\" value=\"Draw\" disabled></form>");
            }
        }
%>


<br><br>
<%
        if (currentPlayer.equals(player)) {

            if (session.getAttribute("lobby") != null) {
                session.setAttribute("lobby", null);
                Cookie putCookie = new Cookie("timeout", "yes");
                putCookie.setMaxAge(ApplicationConstants.PLAYER_TURN_TIMEOUT);
                response.addCookie(putCookie);
            } else {
                boolean isCookieFound = false;
                for (Cookie currentCookie : request.getCookies()) {
                    if (currentCookie.getName().equals("timeout")) {
                        isCookieFound = true;
                    }
                }

                if (!isCookieFound) {
                    session.setAttribute("gameId", null);
                    game.getPlayers().remove(player);
                    ExitGame.verifyFinishedGame(game, player);
                }

            }

            int cardNumber = ApplicationConstants.INITIAL_INDEX;
            for (Card card : currentPlayer.getCards()) {
                out.print("<form action=\"useCard\" method=\"post\">");
                out.print("<input type=\"hidden\" value=\"" + cardNumber + "\" name=\"cardNumber\" >");
                out.print("<input type=\"submit\" value=\"" + card.toString() + "\" >");
                out.print("</form>");
                cardNumber += ApplicationConstants.ITERATION_VALUE;
            }
        }
    } else {
        for (CardSymbol symbol : CardSymbol.values()) {
            out.print("<form action=\"chooseSign\" method=\"post\">");
            out.print("<input type=\"hidden\" value=\"" + symbol + "\" name=\"signValue\" >");
            out.print("<input type=\"submit\" value=\"" + symbol.toString() + "\" >");
            out.print("</form>");
        }
    }
%>

<%
} else if (game.getStatus() == GameStatus.FINISHED) {
%>

Winner is: <%=game.getWinner().getUser().getUsername() %>

<%
    }
%>
</body>
</html>
