package servlet;

import game.GameRoom;
import utils.GameLogger;
import utils.GlobalInfo;
import utils.enums.GameStatus;

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
 * The type Start game.
 */
@WebServlet(name = "startGame",
        urlPatterns = {"/startGame"})
public class StartGame extends HttpServlet {

    /**
     * Instantiates a new Start game.
     */
    public StartGame() {
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
                String.format("%s servlet, %s method call", StartGame.class.getName(), methodName));

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
        } else {
            if (session.getAttribute("gameId") == null) {
                resp.sendRedirect("home.jsp");
            } else {
                UUID gameId = (UUID) session.getAttribute("gameId");
                GameStatus status = GameStatus.ACTIVE;
                GameRoom game = GlobalInfo.getGame(gameId);
                if (game != null) {
                    if (game.startGame()) {
                        game.setStatus(status);
                        session.setAttribute("gameStatus", status);
                    }
                    resp.sendRedirect("game.jsp");
                } else {
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }
}
