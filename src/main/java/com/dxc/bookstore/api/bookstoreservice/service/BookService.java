package com.dxc.bookstore.api.bookstoreservice.service;

import com.dxc.bookstore.api.bookstoreservice.dto.BookRequest;
import com.dxc.bookstore.api.bookstoreservice.dto.BookResponse;

import java.util.List;

public interface BookService {

    public BookResponse addBook(BookRequest bookRequest);
    public List<BookResponse> searchBook(String title, String author);
    public BookResponse searchBookByISBN(String isbn);
    public BookResponse updateBook(String isbn, BookRequest bookRequest);
    public void deleteBook(String isbn);

}
