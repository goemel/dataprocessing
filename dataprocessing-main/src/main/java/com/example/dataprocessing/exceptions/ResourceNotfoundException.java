package com.example.dataprocessing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotfoundException extends Exception
{
    public ResourceNotfoundException(String message) {
        super(message);
    }
}
