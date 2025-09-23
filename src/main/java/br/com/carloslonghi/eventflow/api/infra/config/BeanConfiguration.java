package br.com.carloslonghi.eventflow.api.infra.config;

import br.com.carloslonghi.eventflow.api.core.gateway.EventGateway;
import br.com.carloslonghi.eventflow.api.core.util.EventIdentifierGenerator;
import br.com.carloslonghi.eventflow.api.core.usecases.*;
import br.com.carloslonghi.eventflow.api.infra.util.EventIdentifierGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public EventIdentifierGenerator eventIdentifierGenerator() {
        return new EventIdentifierGeneratorImpl();
    }

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway, EventIdentifierGenerator eventIdentifierGenerator) {
        return new CreateEventUseCaseImpl(eventGateway, eventIdentifierGenerator);
    }

    @Bean
    public ListEventsUseCase listEventsUseCase(EventGateway eventGateway) {
        return new ListEventsUseCaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdentifierUseCase findEventByIdentifierUseCase(EventGateway eventGateway) {
        return new FindEventByIdentifierUseCaseImpl(eventGateway);
    }
}
