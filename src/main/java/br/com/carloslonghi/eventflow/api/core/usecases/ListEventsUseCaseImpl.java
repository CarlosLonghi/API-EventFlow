package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;

public class ListEventsUseCaseImpl implements ListEventsUseCase {

    private final EventGateway eventGateway;

    public ListEventsUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public PageResult<Event> execute(int pageNumber, int pageSize) {
        return eventGateway.listEvents(pageNumber, pageSize);
    }
}
