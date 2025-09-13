package br.com.carloslonghi.eventflow.api.infra.mapper;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import br.com.carloslonghi.eventflow.api.infra.presentation.dtos.EventDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventDtoMapper {

    EventDto toDto(Event domain);

    Event toDomain(EventDto dto);
}
