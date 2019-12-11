package servlet;

import game.GameRoom;
import game.Player;
import utils.GlobalInfo;
import utils.enums.GameStatus;
import utils.enums.PlayerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "exitGame",
        urlPatterns = {"/exitGame"})
public class ExitGame extends HttpServlet {

    public ExitGame() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
