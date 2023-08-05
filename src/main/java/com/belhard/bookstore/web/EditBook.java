package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.BookDto;
import com.belhard.bookstore.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class EditBook implements Controller {
    public final BookService bookService;

    @Override
    public String process(HttpServletRequest req) {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String year = req.getParameter("year");
        String price = req.getParameter("price");
        String pages = req.getParameter("pages");
        String isbn = req.getParameter("isbn");
        String cover = req.getParameter("cover");
        BookDto bookDto = new BookDto();
        bookDto.setId(Long.parseLong(id));
        bookDto.setTitle(title);
        bookDto.setAuthor(author);
        bookDto.setYear(year);
        bookDto.setPrice(Double.parseDouble(price));
        bookDto.setPages(Integer.parseInt(pages));
        bookDto.setIsbn(isbn);
        bookDto.setCoverDto(BookDto.CoverDto.valueOf(cover));
        log.debug("Prepare to update book");
        BookDto updated = bookService.update(bookDto);
        log.debug("Book updated");
        req.setAttribute("book", updated);
        return "jsp/book.jsp";
    }
}
