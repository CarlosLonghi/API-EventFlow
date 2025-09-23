package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.util.EventIdentifierGenerator;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;
    private final EventIdentifierGenerator eventIdentifierGenerator;

    public CreateEventUseCaseImpl(EventGateway eventGateway, EventIdentifierGenerator eventIdentifierGenerator) {
        this.eventGateway = eventGateway;
        this.eventIdentifierGenerator = eventIdentifierGenerator;
    }

    @Override
    public Event execute(Event event) {
        String identifier;
        do {
            identifier = eventIdentifierGenerator.generate();
        } while (eventGateway.existsByIdentifier(identifier));

        return eventGateway.createEvent(event, identifier);
    }
}
