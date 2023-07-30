package com.belhard.bookstore.web;

import com.belhard.bookstore.data.connection.ConnectionManager;
import com.belhard.bookstore.data.connection.impl.ConnectionManagerImpl;
import com.belhard.bookstore.data.dao.impl.BookDaoImpl;
import com.belhard.bookstore.data.dto.BookDto;
import com.belhard.bookstore.platform.ConfigurationManager;
import com.belhard.bookstore.platform.impl.ConfigurationManagerImpl;
import com.belhard.bookstore.service.BookService;
import com.belhard.bookstore.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet("/book")
@Log4j2
public class BookController extends HttpServlet {
    private final BookService bookService;
    private static final ConfigurationManager configurationManager = new ConfigurationManagerImpl();
    private static final String URL = configurationManager.getProperty("db.url");
    private static final String LOGIN = configurationManager.getProperty("db.login");
    private static final String PASSWORD = configurationManager.getProperty("db.password");
    private static final String DRIVER = configurationManager.getProperty("db.driver");

    public BookController(){
        ConnectionManager connectionManager = new ConnectionManagerImpl(URL, LOGIN, PASSWORD, DRIVER);
        bookService = new BookServiceImpl(new BookDaoImpl(connectionManager));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idRaw = req.getParameter("id");
        if(idRaw == null){
            resp.getWriter().println("<html><h1>Bad request!!!</h1><p>Need to set parameters</p></html>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            Long id = Long.valueOf(idRaw);
            BookDto bookDto = bookService.getById(id);

            String html = "<html><h1>Book</h1><h2>ID: " + bookDto.getId() + "</h2>" +
                    "<h2>Title: " + bookDto.getTitle() + "</h2>" +
                    "<h3>Author: " + bookDto.getAuthor() + "</h3><p>Price: " + bookDto.getPrice() + "</p></html>";
            resp.getWriter().println(html);
        }catch (RuntimeException e) {
            log.error("Bad request with parameter: id = " + idRaw);
            resp.getWriter().println("<html><h1>Bad request!!!</h1></html>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
