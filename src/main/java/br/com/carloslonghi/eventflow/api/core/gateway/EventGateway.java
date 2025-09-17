package br.com.carloslonghi.eventflow.api.core.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;

public interface EventGateway {

    Event createEvent(Event event);

    PageResult<Event> listEvents(int pageNumber, int pageSize);

    boolean existsByIdentifier(String identifier);
}
