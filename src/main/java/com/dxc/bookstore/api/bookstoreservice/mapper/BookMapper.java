package com.dxc.bookstore.api.bookstoreservice.mapper;

import com.dxc.bookstore.api.bookstoreservice.dto.*;
import com.dxc.bookstore.api.bookstoreservice.entity.*;

import java.util.List;

public class BookMapper {

    public static Book toEntity(BookRequest request) {
        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setYear(request.getYear());
        book.setPrice(request.getPrice());
        book.setGenre(request.getGenre());

        if (request.getAuthors() != null) {
            request.getAuthors().forEach(a -> {
                Author author = new Author();
                author.setName(a.getName());
                author.setBirthday(a.getBirthday());

                book.addAuthor(author);
            });
        }

        return book;
    }

    public static BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setYear(book.getYear());
        response.setPrice(book.getPrice());
        response.setGenre(book.getGenre());

        response.setAuthors(toAuthorResponseList(book.getAuthors()));

        return response;
    }

    private static List<AuthorResponse> toAuthorResponseList(List<Author> authors) {
        if (authors == null) return List.of();

        return authors.stream().map(a -> {
            AuthorResponse ar = new AuthorResponse();
            ar.setName(a.getName());
            ar.setBirthday(a.getBirthday());
            return ar;
        }).toList();
    }
}