package com.belhard.bookstore.controller;

import com.belhard.bookstore.service.BookService;
import com.belhard.bookstore.service.BookServiceImpl;
import com.belhard.bookstore.service.dto.BookDto;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private final BookService bookService = new BookServiceImpl();

    public void process(String input) {
        label:
        do{
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
