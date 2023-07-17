package com.belhard.bookstore.service;

import com.belhard.bookstore.service.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getById(long id);

    BookDto create(BookDto book);

    BookDto update(BookDto book);

    void delete(long id);
}
