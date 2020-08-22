package pl.krypot.motoapi3.core.endpoints;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.EventTypesConverter;
import pl.krypot.motoapi3.core.model.dto.EventTypeDto;
import pl.krypot.motoapi3.core.model.inputs.AddEventTypeInput;
import pl.krypot.motoapi3.core.services.EventTypesService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/eventType")
@Api(value = "Event Type endpoint")
@RestController
public class EventTypeEndpoint {

    private EventTypesService eventTypesService;
    private EventTypesConverter eventTypesConverter;

    @Autowired
    public EventTypeEndpoint(final EventTypesService eventTypesService, final EventTypesConverter eventTypesConverter) {
        this.eventTypesService = eventTypesService;
        this.eventTypesConverter = eventTypesConverter;
    }

    @ApiOperation(value = "Returns all Event types")
    @GetMapping("/getEventTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<EventTypeDto>> getEventTypes() {
        List<EventTypeDto> eventTypeDtos = eventTypesConverter.convertEventTypes(eventTypesService.getEventTypes());
        return new ResponseEntity<>(eventTypeDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Event type")
    @GetMapping("/getEventType")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<EventTypeDto> getDishType(@RequestParam("id") @NotNull final Long id) {
        EventTypeDto eventTypeDto;
        try {
            eventTypeDto = eventTypesConverter.convertEventType(eventTypesService.getEventType(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventTypeDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds Event type")
    @PostMapping("/addEventType")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addEventType(@RequestBody @Valid final AddEventTypeInput addEventTypeInput) throws ItemNotFoundException, MessagingException{
        eventTypesService.addEventType(addEventTypeInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Removes Event type")
    @DeleteMapping("/deleteEventType")
    public ResponseEntity<Void> deleteEventType(@RequestParam("id") @NotNull final Long id) {
        try {
            eventTypesService.deleteEventType(id);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Edits Event type")
    @PostMapping("/editEventType")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editEventType(@RequestBody @Valid final EventTypeDto eventTypeDto) {
        try {
            eventTypesService.editEventType(eventTypeDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
