package br.com.carloslonghi.eventflow.api.core.gateway;

import br.com.carloslonghi.eventflow.api.core.domain.Event;

public interface EventGateway {

    Event createEvent(Event event);
}
