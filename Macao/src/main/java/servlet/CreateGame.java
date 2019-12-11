package servlet;

import game.GameRoom;
import game.Player;
import utils.GameLogger;
import utils.GlobalInfo;
import utils.enums.PlayerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;

/**
 * The type Create game.
 */
@WebServlet(name = "createGame",
        urlPatterns = {"/createGame"})
public class CreateGame extends HttpServlet {

    /**
     * Instantiates a new Create game.
     */
    public CreateGame() {
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
        } else if (session.getAttribute("gameId") != null) {
            resp.sendRedirect("game.jsp");
        } else {
            Player player = (Player) session.getAttribute("player");
            GameRoom game = new GameRoom(player);
            GlobalInfo.games.add(game);
            player.setStatus(PlayerStatus.ATTENDING);
            session.setAttribute("gameId", game.getId());
            session.setAttribute("lobby", "yes");
            resp.sendRedirect("game.jsp");
        }
    }


}
