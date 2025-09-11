package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.createEvent(event);
    }
}
