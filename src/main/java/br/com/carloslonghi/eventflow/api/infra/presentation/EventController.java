package br.com.carloslonghi.eventflow.api.infra.presentation;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;
import br.com.carloslonghi.eventflow.api.core.usecases.CreateEventUseCase;
import br.com.carloslonghi.eventflow.api.core.usecases.FindEventByIdentifierUseCase;
import br.com.carloslonghi.eventflow.api.core.usecases.ListEventsUseCase;
import br.com.carloslonghi.eventflow.api.infra.mapper.EventDtoMapper;
import br.com.carloslonghi.eventflow.api.infra.presentation.dtos.EventDto;
import br.com.carloslonghi.eventflow.api.infra.presentation.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final ListEventsUseCase listEventsUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;

    private final EventDtoMapper eventDtoMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<EventDto>> createEvent(@RequestBody EventDto eventDto) {
        Event event = eventDtoMapper.toDomain(eventDto);
        Event eventCreated = createEventUseCase.execute(event);

        ApiResponse<EventDto> response = new ApiResponse<>(
                "Evento criado com sucesso",
                eventDtoMapper.toDto(eventCreated),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public Page<EventDto> listEvents(Pageable pageable) {
        PageResult<Event> result = listEventsUseCase.execute(pageable.getPageNumber(), pageable.getPageSize());

        return new PageImpl<>(
                result.content().stream().map(eventDtoMapper::toDto).toList(),
                PageRequest.of(result.pageNumber(), result.pageSize()),
                result.totalElements()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<EventDto>> findEventByIdentifier(@RequestParam String identifier) {
        Event event = findEventByIdentifierUseCase.execute(identifier);

        ApiResponse<EventDto> response = new ApiResponse<>(
                "Evento encontrado",
                eventDtoMapper.toDto(event),
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }
}
