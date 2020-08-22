package pl.krypot.motoapi3.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.EventTypeDto;
import pl.krypot.motoapi3.core.model.entities.Event;
import pl.krypot.motoapi3.core.model.entities.EventType;
import pl.krypot.motoapi3.core.model.inputs.AddEventTypeInput;
import pl.krypot.motoapi3.core.repositories.EventTypesRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.util.List;

@Service
public class EventTypesService {
    private EventTypesRepository eventTypesRepository;
    private EventsService eventsService;

    @Autowired
    public EventTypesService(final EventTypesRepository eventTypesRepository, final EventsService eventsService) {
        this.eventTypesRepository = eventTypesRepository;
        this.eventsService = eventsService;
    }

    public List<EventType> getEventTypes() {
        return eventTypesRepository.findAll();
    }

    public EventType getEventType(final Long id) throws ItemNotFoundException {
        return eventTypesRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }
    public EventType getEventTypeByName(final String name) {
        return eventTypesRepository.findByName(name);
    }

    public EventType addEventType(final AddEventTypeInput addEventTypeInput) {
        EventType eventType = new EventType();
        eventType.setName(addEventTypeInput.getName());

        return eventTypesRepository.save(eventType);
    }

    public void deleteEventType(final Long id) throws ItemNotFoundException {
        if (!eventTypesRepository.existsById(id)) {
            throw new ItemNotFoundException("EventType with id = " + id + " does not exist");
        }
        List<Event> events = eventsService.getEventsWithTypeIdEqualsTo(id);
        for(int i = 0; i < events.size(); i++){
            eventsService.deleteEvent(events.get(i).getId());
        }
        eventTypesRepository.deleteById(id);
    }

    public EventType editEventType(final EventTypeDto eventTypeDto) throws ItemNotFoundException {
        if (!eventTypesRepository.existsById(eventTypeDto.getId())) {
            throw new ItemNotFoundException("EventType with id = " + eventTypeDto.getId() + " does not exist");
        }

        EventType eventType = new EventType();
        eventType.setId(eventTypeDto.getId());
        eventType.setName(eventTypeDto.getName());

        return eventTypesRepository.save(eventType);
    }
}
