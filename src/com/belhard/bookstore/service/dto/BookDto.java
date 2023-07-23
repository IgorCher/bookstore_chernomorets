package com.belhard.bookstore.service.dto;

import com.belhard.bookstore.dao.entity.Book;

import java.util.Objects;

public class BookDto {

    private long id;
    private String title;
    private String author;
    private String year;
    private double price;
    private int pages;
    private String isbn;
    private CoverDto coverDto;

    public enum CoverDto {
        HARD,
        SOFT,
        OTHER
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CoverDto getCoverDto() {
        return coverDto;
    }

    public void setCoverDto(CoverDto coverDto) {
        this.coverDto = coverDto;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto book = (BookDto) o;
        return pages == book.pages && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn, id, title, year, pages);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                ", coverDto=" + coverDto +
                '}';
    }
}
