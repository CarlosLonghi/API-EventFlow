package br.com.carloslonghi.eventflow.api.infra.config;

import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.usecases.CreateEventUseCase;
import br.com.carloslonghi.eventflow.api.core.usecases.CreateEventUseCaseImpl;
import br.com.carloslonghi.eventflow.api.core.usecases.ListEventsUseCase;
import br.com.carloslonghi.eventflow.api.core.usecases.ListEventsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway) {
        return new CreateEventUseCaseImpl(eventGateway);
    }

    @Bean
    public ListEventsUseCase listEventsUseCase(EventGateway eventGateway) {
        return new ListEventsUseCaseImpl(eventGateway);
    }
}
