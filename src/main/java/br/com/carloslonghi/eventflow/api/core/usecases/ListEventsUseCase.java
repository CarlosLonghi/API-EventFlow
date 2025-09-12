package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;

import java.util.List;

public interface ListEventsUseCase {

    List<Event> execute();
}
