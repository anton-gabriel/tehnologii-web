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
 * The type Exit game.
 */
@WebServlet(name = "exitGame",
        urlPatterns = {"/exitGame"})
public class ExitGame extends HttpServlet {

    /**
     * Instantiates a new Exit game.
     */
    public ExitGame() {
        super();
    }

    /**
     * Verify finished game.
     *
     * @param game   the game
     * @param player the player
     */
    static public void verifyFinishedGame(GameRoom game, Player player) {
        if (game.getPlayers().size() == 1 && game.getStatus() != GameStatus.FINISHED) {
            game.setWinner(game.getPlayers().get(0));
            game.setStatus(GameStatus.FINISHED);
            game.getWinner().setNumberOfWins(player.getNumberOfWins() + 1);
        }
        if (game.getPlayers().size() <= 0 && game.getSpectators().size() <= 0) {
            GlobalInfo.games.remove(game);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        GameLogger.getInstance().log(Level.INFO,
                String.format("%s servlet, %s method call", ExitGame.class.getName(), methodName));

        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        UUID gameId = (UUID) session.getAttribute("gameId");
        Player player = (Player) session.getAttribute("player");
        GameRoom game = GlobalInfo.getGame(gameId);
        if (game != null) {
            if (player.getStatus() == PlayerStatus.SPECTATING) {
                game.getSpectators().remove(player);
            } else {
                game.getPlayers().remove(player);
            }
            verifyFinishedGame(game, player);
        }
        session.setAttribute("gameId", null);
        session.setAttribute("gameStatus", null);
        resp.sendRedirect("home.jsp");
    }


}
