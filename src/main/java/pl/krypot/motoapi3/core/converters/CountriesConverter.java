package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.CountryDto;
import pl.krypot.motoapi3.core.model.entities.Country;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountriesConverter {

    public CountryDto convertCountry(final Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }

    public List<CountryDto> convertCountries(final List<Country> eventTypes) {
        return eventTypes.stream().map(this::convertCountry).collect(Collectors.toList());
    }
}
