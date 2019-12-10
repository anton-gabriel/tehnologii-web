package servlet;

import controller.Controller;
import controller.LoginController;
import model.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public final class MainServletOLD extends HttpServlet {
    private static final Map<Request, Controller> controllers = new HashMap<>();

    @Override
    public void init() throws ServletException {
        this.controllers.put(new Request("POST", "/login"), new LoginController());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private  void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = new Request(req.getMethod(), req.getRequestURI());
        controllers.getOrDefault(request, processView().apply("404"))
                .process(req, resp);
    }

    private Function<String, Controller> processView() {
        return x -> (req, resp) -> {
            try {
                req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", x)).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
    }
}