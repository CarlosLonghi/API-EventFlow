package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.core.shared.PageResult;

public interface ListEventsUseCase {

    PageResult<Event> execute(int pageNumber, int pageSize);
}
