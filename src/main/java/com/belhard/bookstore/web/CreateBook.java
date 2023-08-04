package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.BookDto;
import com.belhard.bookstore.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBook implements Controller {
    public final BookService bookService;

    @Override
    public String process(HttpServletRequest req) {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String year = req.getParameter("year");
        String price = req.getParameter("price");
        String pages = req.getParameter("pages");
        String isbn = req.getParameter("isbn");
        String cover = req.getParameter("cover");
        BookDto bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setAuthor(author);
        bookDto.setYear(year);
        bookDto.setPrice(Double.parseDouble(price));
        bookDto.setPages(Integer.parseInt(pages));
        bookDto.setIsbn(isbn);
        bookDto.setCoverDto(BookDto.CoverDto.valueOf(cover));
        BookDto created = bookService.create(bookDto);
        req.setAttribute("book", created);
        return "jsp/book.jsp";
    }
}
