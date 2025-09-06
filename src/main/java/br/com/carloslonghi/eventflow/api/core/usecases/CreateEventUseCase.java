package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.entities.Event;

public interface CreateEventUseCase {

    Event execute(Event event);
}
