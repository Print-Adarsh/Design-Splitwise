package org.example.splitwiseaug25.exception;

public class GroupDoesNotExistException extends RuntimeException{
    public GroupDoesNotExistException(){

    }
    public GroupDoesNotExistException(String message){
        super(message);
    }
    public GroupDoesNotExistException(String message, Throwable cause){
        super(message, cause);
    }
}
