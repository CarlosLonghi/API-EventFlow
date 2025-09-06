package br.com.carloslonghi.eventflow.api.infra.mapper;

import br.com.carloslonghi.eventflow.api.core.entities.Event;
import br.com.carloslonghi.eventflow.api.infra.dtos.EventDto;
import org.mapstruct.Mapper;

@Mapper
public interface EventDtoMapper {

    EventDto toDto(Event entity);

    Event toEntity(EventDto dto);
}
