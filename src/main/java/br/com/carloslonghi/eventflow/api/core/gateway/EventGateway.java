package br.com.carloslonghi.eventflow.api.core.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;

import java.util.Optional;

public interface EventGateway {

    Event createEvent(Event event, String identifier);

    PageResult<Event> listEvents(int pageNumber, int pageSize);

    boolean existsByIdentifier(String identifier);

    Optional<Event> findByIdentifier(String identifier);
}
