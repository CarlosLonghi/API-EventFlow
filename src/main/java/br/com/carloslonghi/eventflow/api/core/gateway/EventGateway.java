package br.com.carloslonghi.eventflow.api.core.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;

import java.util.List;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> listEvents();
}
