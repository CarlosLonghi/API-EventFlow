package br.com.carloslonghi.eventflow.api.infra.presentation;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;
import br.com.carloslonghi.eventflow.api.core.usecases.CreateEventUseCase;
import br.com.carloslonghi.eventflow.api.core.usecases.ListEventsUseCase;
import br.com.carloslonghi.eventflow.api.infra.dtos.EventDto;
import br.com.carloslonghi.eventflow.api.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final ListEventsUseCase listEventsUseCase;

    private final EventDtoMapper eventDtoMapper;

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event event = eventDtoMapper.toDomain(eventDto);
        Event eventCreated = createEventUseCase.execute(event);

        return eventDtoMapper.toDto(eventCreated);
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
}
