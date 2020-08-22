package pl.krypot.motoapi3.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.EventDto;
import pl.krypot.motoapi3.core.model.entities.Event;
import pl.krypot.motoapi3.core.model.inputs.AddEventInput;
import pl.krypot.motoapi3.core.repositories.EventsRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.util.List;

@Service
public class EventsService {
    private EventsRepository eventsRepository;
    private EventTypesService eventTypesService;
    private PlacesService placesService;

    @Autowired
    public EventsService(final EventsRepository eventsRepository, @Lazy final EventTypesService eventTypesService) {
        this.eventsRepository = eventsRepository;
        this.eventTypesService = eventTypesService;
    }

    public List<Event> getEvents() {
        return eventsRepository.findAll();
    }

    public List<Event> getEventsWithTypeNameEqualsTo(String name) {
        return eventsRepository.findAllByEventType_Name(name);
    }

    public List<Event> getEventsWithTypeIdEqualsTo(Long id) {
        return eventsRepository.findAllByEventType_Id(id);
    }

    public Event getEvent(final Long id) throws ItemNotFoundException {
        return eventsRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public Event addEvent(final AddEventInput addEventInput) throws ItemNotFoundException {
        Event event = new Event();
        event.setEventType(eventTypesService.getEventTypeByName(addEventInput.getEventTypeInput().getName()));
        event.setName(addEventInput.getName());
        event.setBeginDate(addEventInput.getBeginDate());
        event.setPlace(placesService.getPlaceByName(addEventInput.getPlaceInput().getName()));
        event.setDescription(addEventInput.getDescription());

        return eventsRepository.save(event);
    }

    public void deleteEvent(final Long id) throws ItemNotFoundException {

        if (!eventsRepository.existsById(id)) {
            throw new ItemNotFoundException("Address with id = " + id + " does not exist");
        }
        eventsRepository.deleteById(id);

    }

    public Event editEvent(final EventDto eventDto) throws ItemNotFoundException {
        if (!eventsRepository.existsById(eventDto.getId())) {
            throw new ItemNotFoundException("Dish with id = " + eventDto.getId() + " does not exist");
        }

        Event event = new Event();
        event.setId(eventDto.getId());
        event.setEventType(eventDto.getEventType());
        event.setName(eventDto.getName());
        event.setBeginDate(eventDto.getBeginDate());
        event.setPlace(eventDto.getPlace());
        event.setDescription(eventDto.getDescription());

       return eventsRepository.save(event);
    }

    public Event getEventByName(final String name) throws ItemNotFoundException {
        return eventsRepository.findByName(name);
    }

}
