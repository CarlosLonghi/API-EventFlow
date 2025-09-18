package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.exception.NotFoundEventIdentifierException;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase {

    private final EventGateway eventGateway;

    public FindEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findByIdentifier(identifier)
                .orElseThrow(() -> new NotFoundEventIdentifierException("Erro ao buscar Evento, não foi encontrado um Evento com o identificador informado"));
    }
}
