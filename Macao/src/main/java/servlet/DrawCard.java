package servlet;

import game.Card;
import game.CardAction;
import game.GameRoom;

import game.Player;
import utils.GlobalInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "drawCard",
        urlPatterns = {"/drawCard"})
public class DrawCard extends HttpServlet {

    public DrawCard() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
        }
        else {
            if (session.getAttribute("gameId") == null)
            {
                resp.sendRedirect("home.jsp");
            }
            else {
                UUID gameId = (UUID)session.getAttribute("gameId");
                GameRoom game = GlobalInfo.getGame(gameId);
                if (game != null)
                {
                    game.getStackedDrawCards().draw(game);
                    game.getPlayers().getNextPlayer();
                    resp.sendRedirect("game.jsp");
                }
                else
                {
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }
}