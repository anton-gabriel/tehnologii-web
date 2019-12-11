package servlet;

import game.Card;
import game.CardAction;
import game.GameRoom;
import game.Player;
import utils.GameLogger;
import utils.GlobalInfo;
import utils.enums.CardSymbol;
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
 * The type Choose sign.
 */
@WebServlet(name = "chooseSign",
        urlPatterns = {"/chooseSign"})
public class ChooseSign extends HttpServlet {

    /**
     * Instantiates a new Choose sign.
     */
    public ChooseSign() {
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
                CardSymbol cardSymbol = CardSymbol.valueOf(req.getParameter("signValue"));
                if (game != null) {
                    Player player = game.getPlayers().getCurrentPlayer();
                    req.getSession(false).setAttribute("seven", null);
                    Card card = player.getCards().get(player.getCards().size() - 1);
                    player.setDesiredCardSymbol(cardSymbol);

                    if (CardAction.getAction(card, game).apply(card, game)) {
                        if (player.getCards().isEmpty()) {
                            game.setWinner(player);
                            game.setStatus(GameStatus.FINISHED);
                            player.setNumberOfWins(player.getNumberOfWins() + 1);
                        } else {
                            session.setAttribute("lobby", "yes");
                            game.getPlayers().getNextPlayer();
                        }
                    }
                    resp.sendRedirect("game.jsp");
                } else {
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }
}