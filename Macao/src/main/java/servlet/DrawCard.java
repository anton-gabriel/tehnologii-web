package servlet;

import game.GameRoom;
import utils.GameLogger;
import utils.GlobalInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

/**
 * The type Draw card.
 */
@WebServlet(name = "drawCard",
        urlPatterns = {"/drawCard"})
public class DrawCard extends HttpServlet {

    /**
     * Instantiates a new Draw card.
     */
    public DrawCard() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        GameLogger.getInstance().log(Level.INFO,
                String.format("%s servlet, %s method call", ChooseSign.class.getName(), methodName));

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
        } else {
            if (session.getAttribute("gameId") == null) {
                resp.sendRedirect("home.jsp");
            } else {
                UUID gameId = (UUID) session.getAttribute("gameId");
                GameRoom game = GlobalInfo.getGame(gameId);
                if (game != null) {
                    game.getStackedDrawCards().draw(game);
                    game.getPlayers().getNextPlayer();
                    session.setAttribute("lobby", "yes");
                    resp.sendRedirect("game.jsp");
                } else {
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }
}