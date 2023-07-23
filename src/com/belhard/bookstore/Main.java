package com.belhard.bookstore;

import com.belhard.bookstore.controller.BookController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("all - list of all books");
        System.out.println("get - information about book");
        System.out.println("delete - delete book");
        System.out.println("exit - exit the program");

        String action = scan.next();
        BookController bookController = new BookController();
        bookController.process(action);
    }
}
