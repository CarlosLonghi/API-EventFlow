package br.com.carloslonghi.eventflow.api.infra.presentation.response;

import java.time.Instant;

public record ApiResponse<T>(
        String message,
        T data,
        Instant timestamp
) {
}
