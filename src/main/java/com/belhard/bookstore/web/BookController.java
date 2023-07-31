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
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@RequiredArgsConstructor
@Log4j2
public class BookController implements Controller{
    private final BookService bookService;

    @Override
    public String process(HttpServletRequest req) {
        String idRaw = req.getParameter("id");
        Long id = Long.valueOf(idRaw);
        BookDto bookDto = bookService.getById(id);
        req.setAttribute("book",bookDto);
        return "jsp/book.jsp";
    }
}
