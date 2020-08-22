package pl.krypot.motoapi3.core.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.EventDto;
import pl.krypot.motoapi3.core.model.dto.PlaceDto;
import pl.krypot.motoapi3.core.model.entities.Event;
import pl.krypot.motoapi3.core.model.entities.Place;
import pl.krypot.motoapi3.core.model.inputs.AddPlaceInput;
import pl.krypot.motoapi3.core.repositories.PlacesRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.util.List;

@Service
public class PlacesService {

    private PlacesRepository placesRepository;
    private CitiesService citiesService;

    @Autowired
    public PlacesService(final PlacesRepository placesRepository, @Lazy final CitiesService citiesService) {
        this.placesRepository = placesRepository;
        this.citiesService = citiesService;
    }

    public List<Place> getPlaces() {return placesRepository.findAll();}

    public List<Place> getPlacesWithCityIdEqualsTo(final Long id) {return placesRepository.findAllByCity_Id(id);}

    public List<Place> getPlacesWithCityNameEqualsTo(final String name) {return placesRepository.findAllByCity_Name(name);}

    public Place getPlace(final Long id) throws ItemNotFoundException {
        return placesRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }
    public Place getPlaceByName(final String name) throws ItemNotFoundException {
        return placesRepository.findByName(name);}

    public Place addPlace(final AddPlaceInput addPlaceInput) throws ItemNotFoundException {
        Place place = new Place();
        place.setName(addPlaceInput.getName());
        place.setCity(citiesService.getCityByName(addPlaceInput.getAddCityInput().getName()));
        place.setLat(addPlaceInput.getLat());
        place.setLon(addPlaceInput.getLon());

        return placesRepository.save(place);
    }

    public Place editPlace(final PlaceDto placeDto) throws ItemNotFoundException {
        if (!placesRepository.existsById(placeDto.getId())) {
            throw new ItemNotFoundException("Dish with id = " + placeDto.getId() + " does not exist");
        }

        Place place = new Place();
        place.setId(placeDto.getId());
        place.setName(placeDto.getName());
        place.setCity(placeDto.getCity());
        place.setLat(placeDto.getLat());
        place.setLon(placeDto.getLon());

        return placesRepository.save(place);
    }
}
