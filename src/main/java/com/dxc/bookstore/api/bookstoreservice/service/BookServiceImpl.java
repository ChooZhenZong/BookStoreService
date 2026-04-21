package com.dxc.bookstore.api.bookstoreservice.service;

import com.dxc.bookstore.api.bookstoreservice.dto.BookRequest;
import com.dxc.bookstore.api.bookstoreservice.dto.BookResponse;
import com.dxc.bookstore.api.bookstoreservice.entity.Author;
import com.dxc.bookstore.api.bookstoreservice.entity.Book;
import com.dxc.bookstore.api.bookstoreservice.exception.BookAlreadyExistException;
import com.dxc.bookstore.api.bookstoreservice.exception.BookNotFoundException;
import com.dxc.bookstore.api.bookstoreservice.mapper.BookMapper;
import com.dxc.bookstore.api.bookstoreservice.respository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dxc.bookstore.api.bookstoreservice.constant.ErrorConstants.*;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        if (bookRepository.existsById(bookRequest.getIsbn())) {
            throw new BookAlreadyExistException(String.format(BOOK_ALREADY_EXIST, bookRequest.getIsbn()));
        }

        Book book = BookMapper.toEntity(bookRequest);
        Book savedBook = bookRepository.save(book);

        return BookMapper.toResponse(savedBook);
    }

    @Override
    public List<BookResponse> searchBook(String author, String title) {
        List<Book> books;

        if (title != null && author != null) {
            books = bookRepository.findByTitle(title)
                    .stream()
                    .filter(b -> b.getAuthors()
                            .stream()
                            .anyMatch(a -> a.getName().equals(author)))
                    .toList();

        } else if (title != null) {
            books = bookRepository.findByTitle(title);
        } else if (author != null) {
            books = bookRepository.findByAuthors_Name(author);
        } else {
            books = bookRepository.findAll();
        }

        return books.stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    @Override
    public BookResponse searchBookByISBN(String isbn) {
        return null;
    }

    @Override
    public BookResponse updateBook(String isbn, BookRequest bookRequest) {
        Book existingBook = bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException(String.format(BOOK_NOT_FOUND, isbn)));

        existingBook.setTitle(bookRequest.getTitle());
        existingBook.setYear(bookRequest.getYear());
        existingBook.setPrice(bookRequest.getPrice());
        existingBook.setGenre(bookRequest.getGenre());

        existingBook.getAuthors().clear();

        if (bookRequest.getAuthors() != null) {
            bookRequest.getAuthors().forEach(a -> {
                Author author = new Author();
                author.setName(a.getName());
                author.setBirthday(a.getBirthday());

                existingBook.addAuthor(author);
            });
        }

        Book saved = bookRepository.save(existingBook);

        return BookMapper.toResponse(saved);
    }

    @Override
    public void deleteBook(String isbn) {
        Book existingBook = bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException(String.format(BOOK_NOT_FOUND, isbn)));

        bookRepository.delete(existingBook);
    }


}
