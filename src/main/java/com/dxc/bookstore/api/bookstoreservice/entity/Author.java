package com.dxc.bookstore.api.bookstoreservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
