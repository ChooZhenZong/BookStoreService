package com.dxc.bookstore.api.bookstoreservice.exception;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String message) {
        super(message);
    }
}
