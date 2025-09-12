package br.com.carloslonghi.eventflow.api.infra.mapper;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.infra.persistence.EventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventEntityMapper {

    EventEntity toEntity(Event domain);

    Event toDomain(EventEntity entity);
}
