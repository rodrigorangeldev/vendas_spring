package com.rodrigorangeldev.spring_vendas.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
