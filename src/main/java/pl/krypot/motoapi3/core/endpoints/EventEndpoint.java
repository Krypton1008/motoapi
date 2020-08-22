package pl.krypot.motoapi3.core.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.EventsConverter;
import pl.krypot.motoapi3.core.model.dto.EventDto;
import pl.krypot.motoapi3.core.model.inputs.AddEventInput;
import pl.krypot.motoapi3.core.services.EventsService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/events")
@Api(value = "Events endpoint")
@RestController
public class EventEndpoint {

    private EventsService eventsService;
    private EventsConverter eventsConverter;

    @Autowired
    public EventEndpoint(final EventsService eventsService, final EventsConverter eventsConverter) {
        this.eventsService = eventsService;
        this.eventsConverter = eventsConverter;
    }

    @ApiOperation(value = "Returns all events")
    @GetMapping("/getEvents")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<EventDto>> getEvents() {
        List<EventDto> eventDtos = eventsConverter.convertEvents(eventsService.getEvents());
        return new ResponseEntity<>(eventDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all dishes with type name equals to")
    @GetMapping("/getDishesWithTypeNameEqualsTo")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<EventDto>> getDishesWithTypeNameEqualsTo(@RequestParam("name") @NotNull final String name) {
        List<EventDto> eventDtos = eventsConverter.convertEvents(eventsService.getEventsWithTypeNameEqualsTo(name));
        return new ResponseEntity<>(eventDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns dishName")
    @GetMapping("/getDish")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<EventDto> getDish(@RequestParam("id") @NotNull final Long id) {
        EventDto eventDto;
        try {
            eventDto = eventsConverter.convertEvent(eventsService.getEvent(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds Event")
    @PostMapping("/addEvent")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addDish(@RequestBody @Valid final AddEventInput addEventInput) throws ItemNotFoundException, MessagingException{
        eventsService.addEvent(addEventInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Removes Event")
    @DeleteMapping("/deleteEvent")
    public ResponseEntity<Void> deleteDish(@RequestParam("id") @NotNull final Long id) {
        try {
            eventsService.deleteEvent(id);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Edits Event")
    @PostMapping("/editEvent")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editDish(@RequestBody @Valid final EventDto eventDto) {
        try {
            eventsService.editEvent(eventDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Event")
    @GetMapping("/getEventByName")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<EventDto> getEvent(@RequestParam("name") @NotNull final String name) {
        EventDto eventDto;
        try {
            eventDto = eventsConverter.convertEvent(eventsService.getEventByName(name));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }
}