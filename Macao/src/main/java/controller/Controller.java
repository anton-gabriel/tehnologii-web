package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The interface Controller.
 */
public interface Controller {
    /**
     * Process the request.
     *
     * @param req  the request
     * @param resp the response
     */
    void process(HttpServletRequest req, HttpServletResponse resp);
}
