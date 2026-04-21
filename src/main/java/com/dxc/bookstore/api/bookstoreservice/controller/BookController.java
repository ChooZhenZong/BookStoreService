package com.dxc.bookstore.api.bookstoreservice.controller;

import com.dxc.bookstore.api.bookstoreservice.dto.BookRequest;
import com.dxc.bookstore.api.bookstoreservice.dto.BookResponse;
import com.dxc.bookstore.api.bookstoreservice.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookServiceImpl.addBook(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> searchBooks(@RequestParam(required = false) String author,
                                                          @RequestParam(required = false) String title) {

        return ResponseEntity.ok(bookServiceImpl.searchBook(author, title));
    }

//    @GetMapping
//    public ResponseEntity<BookResponse> searchBooksByISBN() {
//
//    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable String isbn, @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookServiceImpl.updateBook(isbn, bookRequest));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookServiceImpl.deleteBook(isbn);

        return ResponseEntity.noContent().build();
    }

}
