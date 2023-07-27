package com.evoke.employee.exceptions;

public class DuplicateAccountException extends RuntimeException{

    public DuplicateAccountException(String message){
        super(message);
    }
}
