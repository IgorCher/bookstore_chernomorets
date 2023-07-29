package com.belhard.bookstore.dao.entity;

import lombok.Data;

@Data
public class Book {

    private long id;
    private String title;
    private String author;
    private String year;
    private double price;
    private int pages;
    private String isbn;

    private Cover cover;

    public enum Cover{
        HARD,
        SOFT,
        OTHER
    }
}
