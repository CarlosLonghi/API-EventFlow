package br.com.carloslonghi.eventflow.api.core.gateway;

import br.com.carloslonghi.eventflow.api.core.entities.Event;

public interface EventGateway {

    Event createEvent(Event event);
}
