package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.EventDto;
import pl.krypot.motoapi3.core.model.entities.Event;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventsConverter {
    public EventDto convertEvent(final Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setEventType(event.getEventType());
        eventDto.setBeginDate(event.getBeginDate());
        eventDto.setPlace(event.getPlace());
        eventDto.setDescription(event.getDescription());
        return eventDto;
    }

    public List<EventDto> convertEvents(final List<Event> dishes) {
        return dishes.stream().map(this::convertEvent).collect(Collectors.toList());
    }
}
