package pl.krypot.motoapi3.core.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.CitiesConverter;
import pl.krypot.motoapi3.core.model.dto.CityDto;
import pl.krypot.motoapi3.core.model.inputs.AddCityInput;
import pl.krypot.motoapi3.core.services.CitiesService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/cities")
@Api(value = "Cities endpoint")
@RestController
public class CityEndpoint {

    private CitiesService citiesService;
    private CitiesConverter citiesConverter;

    @Autowired
    public CityEndpoint(final CitiesService citiesService, final CitiesConverter citiesConverter) {
        this.citiesService = citiesService;
        this.citiesConverter = citiesConverter;
    }

    @ApiOperation(value = "Returns all cities")
    @GetMapping("/getCities")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<CityDto>> getCities() {
        List<CityDto> cityDtos = citiesConverter.convertCities(citiesService.getCities());
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all cities with country name equals to")
    @GetMapping("/getCitiesWithCountryNameEqualsTo")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<CityDto>> getCitiesWithCountryNameEqualsTo(@RequestParam("name") @NotNull final String name) {
        List<CityDto> cityDtos = citiesConverter.convertCities(citiesService.getCitiesWithCountryNameEqualsTo(name));
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns City")
    @GetMapping("/getCity")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<CityDto> getCity(@RequestParam("id") @NotNull final Long id) {
        CityDto cityDto;
        try {
            cityDto = citiesConverter.convertCity(citiesService.getCity(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns City by name")
    @GetMapping("/getCityByName")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<CityDto> getCity(@RequestParam("name") @NotNull final String name) {
        CityDto cityDto;
        try {
            cityDto = citiesConverter.convertCity(citiesService.getCityByName(name));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds City")
    @PostMapping("/addCity")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addCity(@RequestBody @Valid final AddCityInput addCityInput) throws ItemNotFoundException, MessagingException{
        citiesService.addCity(addCityInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edits City")
    @PostMapping("/editCity")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editCity(@RequestBody @Valid final CityDto cityDto) {
        try {
            citiesService.editCity(cityDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
