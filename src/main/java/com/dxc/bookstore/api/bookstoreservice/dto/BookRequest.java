package com.dxc.bookstore.api.bookstoreservice.dto;

import java.util.List;

public class BookRequest {
    private String isbn;
    private String title;
    private int year;
    private double price;
    private String genre;

    private List<AuthorRequest> authors;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<AuthorRequest> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorRequest> authors) {
        this.authors = authors;
    }

}
