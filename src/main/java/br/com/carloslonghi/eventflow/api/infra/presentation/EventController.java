package br.com.carloslonghi.eventflow.api.infra.presentation;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.usecases.CreateEventUseCase;
import br.com.carloslonghi.eventflow.api.infra.dtos.EventDto;
import br.com.carloslonghi.eventflow.api.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final EventDtoMapper eventDtoMapper;

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event event = eventDtoMapper.toDomain(eventDto);
        Event eventCreated = createEventUseCase.execute(event);

        return eventDtoMapper.toDto(eventCreated);
    }

    @GetMapping
    public String getAllEvents() {
        return "Lista de eventos";
    }
}
