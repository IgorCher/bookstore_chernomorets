package com.belhard.bookstore.web;

import com.belhard.bookstore.data.connection.ConnectionManager;
import com.belhard.bookstore.data.connection.impl.ConnectionManagerImpl;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.platform.ConfigurationManager;
import com.belhard.bookstore.platform.impl.ConfigurationManagerImpl;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import com.belhard.bookstore.data.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private final UserService userService;
    private static final ConfigurationManager configurationManager = new ConfigurationManagerImpl();
    private static final String URL = configurationManager.getProperty("db.url");
    private static final String LOGIN = configurationManager.getProperty("db.login");
    private static final String PASSWORD = configurationManager.getProperty("db.password");
    private static final String DRIVER = configurationManager.getProperty("db.driver");

    public UserController(){
        ConnectionManager connectionManager = new ConnectionManagerImpl(URL, LOGIN, PASSWORD, DRIVER);
        userService = new UserServiceImpl(new UserDaoImpl(connectionManager));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRaw = req.getParameter("id");
        if(idRaw == null){
            resp.getWriter().println("<html><h1>Bad request!!!</h1></html>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Long id = Long.valueOf(idRaw);
        UserDto user = userService.getById(id);

        String html = "<html><h1>User</h1><h2>ID</h2><p>"+user.getId()+
                "</p><h2>Email</h2><p>"+user.getEmail()+"</p></html>";
        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
