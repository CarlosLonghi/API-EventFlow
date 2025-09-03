package br.com.carloslonghi.eventflow.api.core.entities;

import br.com.carloslonghi.eventflow.api.core.enums.EventType;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String name,
        String description,
        String identifier,
        LocalDateTime startAt,
        LocalDateTime endAt,
        String location, // criar outra entidade "location" com informações do local
        Integer maximumCapacity,
        String organizer,
        EventType type
) {
}
