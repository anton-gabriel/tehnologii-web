package servlet;

import game.GameRoom;
import game.Player;
import utils.GameLogger;
import utils.GlobalInfo;
import utils.enums.GameStatus;
import utils.enums.PlayerStatus;

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
 * The type Join game.
 */
@WebServlet(name = "joinGame",
        urlPatterns = {"/joinGame"})
public class JoinGame extends HttpServlet {

    /**
     * Instantiates a new Join game.
     */
    public JoinGame() {
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
                String.format("%s servlet, %s method call", JoinGame.class.getName(), methodName));

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
        } else if (session.getAttribute("gameId") != null) {
            resp.sendRedirect("game.jsp");
        } else {
            UUID gameId = UUID.fromString(req.getParameter("gameId"));
            Player player = (Player) session.getAttribute("player");

            GameRoom game = GlobalInfo.getGame(gameId);

            if (game.getStatus() == GameStatus.INACTIVE) {

                if (!game.getSpectators().contains(player)) {
                    game.addPlayer(player);
                }
                player.setStatus(PlayerStatus.ATTENDING);
                session.setAttribute("gameId", gameId);
                session.setAttribute("lobby", "yes");
                resp.sendRedirect("game.jsp");
            } else if (game.getStatus() == GameStatus.ACTIVE) {
                game.getSpectators().add(player);
                player.setStatus(PlayerStatus.SPECTATING);
                session.setAttribute("gameId", gameId);
                resp.sendRedirect("game.jsp");
            } else {
                resp.sendRedirect("game.jsp");
            }

        }
    }
}
