package br.com.carloslonghi.eventflow.api.core.exception;

public class DuplicateEventIdentifierException extends RuntimeException {

    public DuplicateEventIdentifierException(String message) {
        super(message);
    }
}
