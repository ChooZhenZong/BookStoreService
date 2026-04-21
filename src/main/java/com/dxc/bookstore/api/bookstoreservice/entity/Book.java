package com.dxc.bookstore.api.bookstoreservice.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

// for demo purposes, i decided to not use lombok
@Entity
public class Book {

    @Id
    private String isbn;

    private String title;

    @Column(name = "published_year")
    private int year;
    private double price;
    private String genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Author> authors;

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> author) {
        this.authors = author;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Double.compare(price, book.price) == 0 && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, authors, year, price, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", athors=" + authors +
                ", year=" + year +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new java.util.ArrayList<>();
        }
        this.authors.add(author);
        author.setBook(this);
    }
}