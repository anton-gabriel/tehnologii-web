package servlet;

import game.GameRoom;
import game.Player;
import utils.GlobalInfo;
import utils.enums.PlayerStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "createGame",
        urlPatterns = {"/createGame"})
public class CreateGame extends HttpServlet {

    public CreateGame() {
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