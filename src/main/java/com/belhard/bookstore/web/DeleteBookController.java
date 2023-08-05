package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.BookDto;
import com.belhard.bookstore.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeleteBookController implements Controller {
    public final BookService bookService;

    @Override
    public String process(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        bookService.delete(id);
        List<BookDto> books = bookService.getAll();
        req.setAttribute("books", books);
        return "jsp/books.jsp";
    }
}
