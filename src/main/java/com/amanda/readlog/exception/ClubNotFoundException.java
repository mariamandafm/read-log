package com.amanda.readlog.exception;

public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException() {
    }

    public ClubNotFoundException(String message) {
        super(message);
    }
}
