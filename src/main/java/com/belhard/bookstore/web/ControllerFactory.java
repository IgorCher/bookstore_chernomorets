package com.belhard.bookstore.web;

import com.belhard.bookstore.data.connection.ConnectionManager;
import com.belhard.bookstore.data.connection.impl.ConnectionManagerImpl;
import com.belhard.bookstore.data.dao.BookDao;
import com.belhard.bookstore.data.dao.UserDao;
import com.belhard.bookstore.data.dao.impl.BookDaoImpl;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.platform.ConfigurationManager;
import com.belhard.bookstore.platform.impl.ConfigurationManagerImpl;
import com.belhard.bookstore.service.BookService;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.impl.BookServiceImpl;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import lombok.extern.log4j.Log4j2;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class ControllerFactory implements Closeable {
    public static final ControllerFactory INSTANCE = new ControllerFactory();
    private Map<String, Controller> controllers;
    private final List<Closeable> resources;

    public ControllerFactory() {
        resources = new ArrayList<>();
        controllers = new HashMap<>();
        ConfigurationManager configurationManager = new ConfigurationManagerImpl();
        String url = configurationManager.getProperty("db.url");
        String login = configurationManager.getProperty("db.login");
        String password = configurationManager.getProperty("db.password");
        String driver = configurationManager.getProperty("db.driver");

        ConnectionManager connectionManager = new ConnectionManagerImpl(url, login, password, driver);
        resources.add(connectionManager);
        UserDao userDao = new UserDaoImpl(connectionManager);
        UserService userService = new UserServiceImpl(userDao);

        BookDao bookDao = new BookDaoImpl(connectionManager);
        BookService bookService = new BookServiceImpl(bookDao);

        controllers.put("user", new UserController(userService));
        controllers.put("users", new UsersController(userService));
        controllers.put("book", new BookController(bookService));
        controllers.put("books",new BooksController(bookService));
        controllers.put("error", new ErrorController());
        controllers.put("create_user_form", new CreateUserFormController());
        controllers.put("create_user", new CreateUser(userService));
        controllers.put("create_book_form", new CreateBookFormController());
        controllers.put("create_book", new CreateBook(bookService));
    }

    public Controller getController(String command) {
        Controller controller = controllers.get(command);
        if (controller == null){
            controller = controllers.get("error");
        }
        return controller;
    }

    @Override
    public void close() {
        for (Closeable resource : resources) {
            try{
                resource.close();
            }catch (IOException e){
                log.error(e);
            }
        }
    }
}
