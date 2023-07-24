package com.belhard.bookstore;

import com.belhard.bookstore.controller.UserController;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("all - list of all users");
        System.out.println("get - information about user");
        System.out.println("delete - delete user");
        System.out.println("exit - exit the program");

        String action = scan.next();
        UserController userController = new UserController();
        userController.process(action);
    }
}
