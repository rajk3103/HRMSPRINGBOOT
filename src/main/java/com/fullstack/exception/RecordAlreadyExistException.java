package com.fullstack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class RecordAlreadyExistException {

    public RecordAlreadyExistException(String message) {

        super(message);
    }
}
