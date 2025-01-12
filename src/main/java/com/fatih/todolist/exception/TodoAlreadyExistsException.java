package com.fatih.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException(String message) {
        super(message);
    }
}
