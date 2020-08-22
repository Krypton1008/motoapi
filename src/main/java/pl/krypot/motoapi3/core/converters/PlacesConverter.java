package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.PlaceDto;
import pl.krypot.motoapi3.core.model.entities.Place;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlacesConverter {
    public PlaceDto convertPlace(final Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setCity(place.getCity());
        placeDto.setLat(place.getLat());
        placeDto.setLon(place.getLon());
        return placeDto;
    }

    public List<PlaceDto> convertPlaces(final List<Place> places) {
        return places.stream().map(this::convertPlace).collect(Collectors.toList());
    }
}
