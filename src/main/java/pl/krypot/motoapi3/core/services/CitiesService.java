package pl.krypot.motoapi3.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.CityDto;
import pl.krypot.motoapi3.core.model.entities.City;
import pl.krypot.motoapi3.core.model.inputs.AddCityInput;
import pl.krypot.motoapi3.core.repositories.CitiesRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.util.List;

@Service
public class CitiesService {
    private CitiesRepository citiesRepository;
    private CountriesService countriesService;

    @Autowired
    public CitiesService(final CitiesRepository citiesRepository, @Lazy final CountriesService countriesService) {
        this.citiesRepository = citiesRepository;
        this.countriesService = countriesService;
    }

    public List<City> getCities() {return citiesRepository.findAll();}

    public List<City> getCitiesWithCountryNameEqualsTo(String name) {
        return citiesRepository.findAllByCountry_Name(name);
    }

    public List<City> getCitiesWithCountryIdEqualsTo(Long id) {
        return citiesRepository.findAllByCountry_Id(id);
    }

    public City getCity(final Long id) throws ItemNotFoundException {
        return citiesRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public City getCityByName(final String name) throws ItemNotFoundException {
        return citiesRepository.findByName(name);
    }

    public City addCity(final AddCityInput addCityInput) {
        City city = new City();
        city.setName(addCityInput.getName());
        city.setCountry(countriesService.getCountryByName(addCityInput.getCountryInput().getName()));
        city.setLat(addCityInput.getLat());
        city.setLon(addCityInput.getLon());

        return citiesRepository.save(city);
    }

    public City editCity(final CityDto cityDto) throws ItemNotFoundException {
        if (!citiesRepository.existsById(cityDto.getId())) {
            throw new ItemNotFoundException("City with id = " + cityDto.getId() + " does not exist");
        }

        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(cityDto.getCountry());
        city.setLat(cityDto.getLat());
        city.setLon(cityDto.getLon());

        return citiesRepository.save(city);
    }

}
