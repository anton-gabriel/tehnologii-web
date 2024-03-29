package servlet;

import game.*;
import utils.GameLogger;
import utils.GlobalInfo;
import utils.enums.CardNumber;
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
 * The type Use card.
 */
@WebServlet(name = "useCard",
        urlPatterns = {"/useCard"})
public class UseCard extends HttpServlet {

    /**
     * Instantiates a new Use card.
     */
    public UseCard() {
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
                int cardLocation = Integer.parseInt(req.getParameter("cardNumber"));
                if (game != null) {
                    Player player = game.getPlayers().getCurrentPlayer();
                    Card card = player.getCards().get(cardLocation);
                    if (card instanceof StandardCard && ((StandardCard) card).getCardNumber() == CardNumber.SEVEN) {
                        player.getCards().remove(cardLocation);
                        player.getCards().add(card);
                        req.getSession(false).setAttribute("seven", true);
                    } else if (CardAction.getAction(card, game).apply(card, game)) {
                        if (player.getCards().isEmpty()) {
                            game.setWinner(player);
                            game.setStatus(GameStatus.FINISHED);
                            player.setNumberOfWins(player.getNumberOfWins() + 1);
                        } else {
                            game.getPlayers().getNextPlayer();
                            session.setAttribute("lobby", "yes");
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
