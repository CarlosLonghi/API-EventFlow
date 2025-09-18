package br.com.carloslonghi.eventflow.api.core.exception;

public class NotFoundEventIdentifierException extends RuntimeException {

    public NotFoundEventIdentifierException(String message) {
        super(message);
    }
}
