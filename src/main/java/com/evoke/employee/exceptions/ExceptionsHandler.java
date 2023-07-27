package com.evoke.employee.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionsHandler {

  @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
      return new ResponseEntity<Object>(
              e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({DuplicateAccountException.class})
    public ResponseEntity<Object> handleDuplicateAccountException(DuplicateAccountException e, HttpServletRequest request){
      return new ResponseEntity<Object>(
              e.getMessage(),new HttpHeaders(),HttpStatus.CONFLICT);
    }

}
