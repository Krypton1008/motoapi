package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.EventTypeDto;
import pl.krypot.motoapi3.core.model.entities.EventType;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventTypesConverter {
    public EventTypeDto convertEventType(final EventType eventType) {
        EventTypeDto eventTypeDto = new EventTypeDto();
        eventTypeDto.setId(eventType.getId());
        eventTypeDto.setName(eventType.getName());
        return eventTypeDto;
    }
    public List<EventTypeDto> convertEventTypes(final List<EventType> eventTypes) {
          return eventTypes.stream().map(this::convertEventType).collect(Collectors.toList());
    }
}
