package br.com.carloslonghi.eventflow.api.infra.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;
import br.com.carloslonghi.eventflow.api.infra.mapper.EventEntityMapper;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventEntity;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventGatewayImpl implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntity(event);

        EventEntity eventSaved = eventRepository.save(eventEntity);

        return eventEntityMapper.toDomain(eventSaved);
    }

    @Override
    public PageResult<Event> listEvents(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        Page<EventEntity> result = eventRepository.findAll(pageable);

        return new PageResult<>(
                result.stream().map(eventEntityMapper::toDomain).toList(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages()
        );
    }

    @Override
    public boolean existsByIdentifier(String identifier) {
        return eventRepository.existsByIdentifier(identifier);
    }

    @Override
    public Optional<Event> findByIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier);
    }
}
