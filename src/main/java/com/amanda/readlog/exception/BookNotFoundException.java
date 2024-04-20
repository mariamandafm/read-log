package com.amanda.readlog.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
