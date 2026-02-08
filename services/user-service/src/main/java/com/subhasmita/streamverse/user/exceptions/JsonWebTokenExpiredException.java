package com.subhasmita.streamverse.user.exceptions;

public class JsonWebTokenExpiredException extends RuntimeException{
    public JsonWebTokenExpiredException(String message) {
        super(message);
    }
}
