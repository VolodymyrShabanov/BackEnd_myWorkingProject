package myworkingproject.controllers;


import myworkingproject.service.exeption.AlreadyExistException;
import myworkingproject.service.exeption.CalculateException;
import myworkingproject.service.exeption.IllegalArgumentException;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> handlerAlreadyExistException(AlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CalculateException.class)
    public ResponseEntity<String> handlerCalculateException(CalculateException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
