package com.belhard.bookstore.service;

import com.belhard.bookstore.dao.BookDao;
import com.belhard.bookstore.dao.BookDaoImpl;
import com.belhard.bookstore.dao.entity.Book;
import com.belhard.bookstore.service.dto.BookDto;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();


    @Override
    public List<BookDto> getAll() {
        return bookDao.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public BookDto getById(long id) {
        Book book = bookDao.find(id);
        if (book == null) {
            throw new RuntimeException("Book with id:" + id + "not found");
        }
        return toDto(book);
    }


    @Override
    public BookDto create(BookDto bookDto) {
        if (bookDto.getIsbn() == null) {
            throw new RuntimeException();
        }
        Book entity = toEntity(bookDto);
        Book created = bookDao.create(entity);
        return toDto(created);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        if (bookDto.getIsbn() == null) {
            throw new RuntimeException();
        }
        Book entity = toEntity(bookDto);
        Book updated = bookDao.update(entity);
        return toDto(updated);
    }

    @Override
    public void delete(long id) {
        if (!bookDao.delete(id)) {
            throw new RuntimeException("Not found book with id: " + id);
        }
    }

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setName(book.getName());
        bookDto.setYear(book.getYear());
        bookDto.setPages(book.getPages());
        bookDto.setIsbn(book.getIsbn());
        return bookDto;
    }

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        book.setYear(bookDto.getYear());
        book.setPages(bookDto.getPages());
        book.setIsbn(bookDto.getIsbn());
        return book;
    }
}
