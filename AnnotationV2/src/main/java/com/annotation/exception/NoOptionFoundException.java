package com.annotation.exception;

public class NoOptionFoundException extends RuntimeException{

    public NoOptionFoundException(){
        super("");
    }

    public NoOptionFoundException(String message){
        super(message);
    }
}
