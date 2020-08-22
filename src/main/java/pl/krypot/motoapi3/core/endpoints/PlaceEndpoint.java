package pl.krypot.motoapi3.core.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.PlacesConverter;
import pl.krypot.motoapi3.core.model.dto.PlaceDto;
import pl.krypot.motoapi3.core.model.inputs.AddPlaceInput;
import pl.krypot.motoapi3.core.services.PlacesService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/places")
@Api(value = "Places endpoint")
@RestController
public class PlaceEndpoint {


    private PlacesService placesService;
    private PlacesConverter placesConverter;

    @Autowired
    public PlaceEndpoint(final PlacesService placesService, final PlacesConverter placesConverter) {
        this.placesService = placesService;
        this.placesConverter = placesConverter;
    }

    @ApiOperation(value = "Returns all Places")
    @GetMapping("/getPlaces")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<PlaceDto>> getPlaces() {
        List<PlaceDto> placeDtos = placesConverter.convertPlaces(placesService.getPlaces());
        return new ResponseEntity<>(placeDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all Places with city name equals to")
    @GetMapping("/getPlacesWithCityNameEqualsTo")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<PlaceDto>> getPlacesWithCityNameEqualsTo(@RequestParam("name") @NotNull final String name) {
        List<PlaceDto> placeDtos = placesConverter.convertPlaces(placesService.getPlacesWithCityNameEqualsTo(name));
        return new ResponseEntity<>(placeDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Place")
    @GetMapping("/getPlace")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<PlaceDto> getPlace(@RequestParam("id") @NotNull final Long id) {
        PlaceDto placeDto;
        try {
            placeDto = placesConverter.convertPlace(placesService.getPlace(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(placeDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds Place")
    @PostMapping("/addPlace")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addPlace(@RequestBody @Valid final AddPlaceInput addPlaceInput) throws ItemNotFoundException, MessagingException{
        placesService.addPlace(addPlaceInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edits Place")
    @PostMapping("/editPlace")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editPlace(@RequestBody @Valid final PlaceDto placeDto) {
        try {
            placesService.editPlace(placeDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Place")
    @GetMapping("/getPlaceByName")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<PlaceDto> getPlace(@RequestParam("name") @NotNull final String name) {
        PlaceDto placeDto;
        try {
            placeDto = placesConverter.convertPlace(placesService.getPlaceByName(name));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(placeDto, HttpStatus.OK);
    }
}