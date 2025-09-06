package br.com.carloslonghi.eventflow.api.infra.mapper;

import br.com.carloslonghi.eventflow.api.core.entities.Event;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EventEntityMapper {

    EventEntity toEntity(Event event);

    Event toDomain(EventEntity eventEntity);
}
