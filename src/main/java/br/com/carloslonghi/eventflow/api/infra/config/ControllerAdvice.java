package br.com.carloslonghi.eventflow.api.infra.config;

import br.com.carloslonghi.eventflow.api.core.exception.DuplicateEventIdentifierException;
import br.com.carloslonghi.eventflow.api.core.exception.NotFoundEventIdentifierException;
import br.com.carloslonghi.eventflow.api.infra.presentation.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(DuplicateEventIdentifierException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateEventIdentifierException(DuplicateEventIdentifierException exception) {
        ApiResponse<String> response = new ApiResponse<>(
                exception.getMessage(),
                null,
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(NotFoundEventIdentifierException.class)
    public ResponseEntity<ApiResponse<String>> handleEventIdentifierNotFoundException(NotFoundEventIdentifierException exception) {
        ApiResponse<String> response = new ApiResponse<>(
                exception.getMessage(),
                null,
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
