package com.belhard.bookstore.data.dao;

import com.belhard.bookstore.data.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    List<Book> findByAuthor(String author);

    Book find(long id);

    Book findByIsbn(String isbn);

    Book create(Book book);

    Book update(Book book);

    boolean delete(long id);

    long countAll();

}
