package com.belhard.bookstore.controller;

import com.belhard.bookstore.connection.ConnectionManager;
import com.belhard.bookstore.connection.impl.ConnectionManagerImpl;
import com.belhard.bookstore.dao.BookDaoImpl;
import com.belhard.bookstore.platform.ConfigurationManager;
import com.belhard.bookstore.platform.impl.ConfigurationManagerImpl;
import com.belhard.bookstore.service.BookService;
import com.belhard.bookstore.service.BookServiceImpl;
import com.belhard.bookstore.service.dto.BookDto;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private static final ConfigurationManager configurationManager = new ConfigurationManagerImpl();
    private static final String URL = configurationManager.getProperty("db.url");
    private static final String LOGIN = configurationManager.getProperty("db.login");
    private static final String PASSWORD = configurationManager.getProperty("db.password");
    private final ConnectionManager connectionManager = new ConnectionManagerImpl(URL, LOGIN, PASSWORD);
    private final BookService bookService = new BookServiceImpl(new BookDaoImpl(connectionManager));

    public void process(String input) {
        label:
        do {
            switch (input) {
                case "all":
                    List<BookDto> dtos = bookService.getAll();
                    dtos.forEach(System.out::println);
                    break label;
                case "get": {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Print id of the book");
                    long id = scan.nextLong();
                    BookDto bookDto = bookService.getById(id);
                    System.out.println(bookDto);
                    scan.nextLine();
                    break label;
                }
                case "delete": {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Print id of the book you want to delete");
                    long id = scan.nextLong();
                    bookService.delete(id);
                    break label;
                }
                case "exit":
                    break label;
                default:
                    System.out.println("No such command");
                    break;
            }
        } while (true);
    }
}
