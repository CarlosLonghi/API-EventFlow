package br.com.carloslonghi.eventflow.api.core.usecases;

import br.com.carloslonghi.eventflow.api.core.domain.Event;

public interface SearchEventUseCase {

    Event execute(String name);
}
