package com.belhard.bookstore.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet("/controller")
@Log4j2
public class FrontController extends HttpServlet {

    @Override
    public void init() {
        log.warn("Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("DoGet called");
        String command = req.getParameter("command");
        Controller controller = ControllerFactory.INSTANCE.getController(command);
        String page;
        try {
            page = controller.process(req);
        } catch (Exception e) {
            log.error(e);
            Controller error = ControllerFactory.INSTANCE.getController("error");
            page = error.process(req);
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    public void destroy() {
        log.warn("Servlet destroyed");
    }
}
