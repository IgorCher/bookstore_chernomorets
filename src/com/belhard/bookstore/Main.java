package com.belhard.bookstore;

import com.belhard.bookstore.dao.BookDaoImpl;
import com.belhard.bookstore.dao.entity.Book;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String action;
        BookDaoImpl bookDao = new BookDaoImpl();

        do {
            System.out.println("all - list of all books");
            System.out.println("get - information about book");
            System.out.println("delete - delete book");
            System.out.println("exit - exit the program");

            action = scan.nextLine();

            switch (action) {
                case "all": {

                    List<Book> books = bookDao.findAll();
                    books.forEach(System.out::println);
                    System.out.println();
                    break;
                }
                case "get": {


                    System.out.println("Print id of the book");
                    long id = scan.nextLong();
                    Book book = bookDao.find(id);
                    System.out.println(book);
                    scan.nextLine();
                    break;

                }
                case "delete": {


                    System.out.println("Print id of the book you want to delete");
                    long id = scan.nextLong();
                    if (bookDao.delete(id)) {
                        System.out.printf("book id: %d deleted\n", id);
                    } else {
                        System.out.printf("book id: %d not found\n", id);
                    }
                    scan.nextLine();
                    break;
                }
                case "exit": {


                    continue;
                }
                default: {
                    System.out.println("No such command");
                }
            }
        } while (!action.equals("exit"));
    }
}
