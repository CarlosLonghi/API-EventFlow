package br.com.carloslonghi.eventflow.api.infra.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.infra.mapper.EventEntityMapper;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventEntity;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntity(event);

        EventEntity eventSaved = eventRepository.save(eventEntity);

        return eventEntityMapper.toDomain(eventSaved);
    }
}
