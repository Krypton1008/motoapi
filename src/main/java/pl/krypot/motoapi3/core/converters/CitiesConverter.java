package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.CityDto;
import pl.krypot.motoapi3.core.model.entities.City;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CitiesConverter {
    public CityDto convertCity(final City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountry(city.getCountry());
        cityDto.setLat(city.getLat());
        cityDto.setLon(city.getLon());
        return cityDto;
    }

    public List<CityDto> convertCities(final List<City> cities) {
        return cities.stream().map(this::convertCity).collect(Collectors.toList());
    }
}
