package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.exception.DuplicateEventIdentifierException;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        boolean existsByIdentifier = eventGateway.existsByIdentifier(event.identifier());
        if (existsByIdentifier) {
            throw new DuplicateEventIdentifierException("Erro ao criar evento. O identificador do evento (identifier): '" + event.identifier() + "' já está em uso por outro Evento");
        }

        return eventGateway.createEvent(event);
    }
}
