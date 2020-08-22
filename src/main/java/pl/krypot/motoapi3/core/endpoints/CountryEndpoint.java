package pl.krypot.motoapi3.core.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.CountriesConverter;
import pl.krypot.motoapi3.core.model.dto.CountryDto;
import pl.krypot.motoapi3.core.model.inputs.AddCountryInput;
import pl.krypot.motoapi3.core.services.CountriesService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;


import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/countries")
@Api(value = "countries endpoint")
@RestController
public class CountryEndpoint {

    private CountriesService countriesService;
    private CountriesConverter countriesConverter;

    @Autowired
    public CountryEndpoint(final CountriesService countriesService, final CountriesConverter countriesConverter) {
        this.countriesService = countriesService;
        this.countriesConverter = countriesConverter;
    }

    @ApiOperation(value = "Returns all countries")
    @GetMapping("/getCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<CountryDto> countryDtos = countriesConverter.convertCountries(countriesService.getCountries());
        return new ResponseEntity<>(countryDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Country")
    @GetMapping("/getCountry")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<CountryDto> getCountry(@RequestParam("id") @NotNull final Long id) {
        CountryDto countryDto;
        try {
            countryDto = countriesConverter.convertCountry(countriesService.getCountry(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds Country")
    @PostMapping("/addCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addCountry(@RequestBody @Valid final AddCountryInput addCountryInput) throws ItemNotFoundException, MessagingException{
        countriesService.addCountry(addCountryInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edits Country")
    @PostMapping("/editCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editDishType(@RequestBody @Valid final CountryDto countryDto) {
        try {
            countriesService.editCountry(countryDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
