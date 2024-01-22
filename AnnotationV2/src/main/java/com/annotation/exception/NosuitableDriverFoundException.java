package com.annotation.exception;

public class NosuitableDriverFoundException extends RuntimeException{

   public NosuitableDriverFoundException(){
        super("");
    }

    public NosuitableDriverFoundException(String message){
       super(message);
    }
}
