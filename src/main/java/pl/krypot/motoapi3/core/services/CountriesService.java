package pl.krypot.motoapi3.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.CountryDto;
import pl.krypot.motoapi3.core.model.entities.Country;
import pl.krypot.motoapi3.core.model.inputs.AddCountryInput;
import pl.krypot.motoapi3.core.repositories.CountriesRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.util.List;

@Service
public class CountriesService {
    private CountriesRepository countriesRepository;
    private CitiesService citiesService;

    @Autowired
    public CountriesService(final CountriesRepository countriesRepository, @Lazy CitiesService citiesService) {
        this.countriesRepository = countriesRepository;
        this.citiesService = citiesService;
    }

    public List <Country> getCountries() {return countriesRepository.findAll();}

    public Country getCountry(final Long id) throws ItemNotFoundException {
        return countriesRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public Country getCountryByName(final String name) {
        return countriesRepository.findByName(name);
    }

    public Country addCountry(final AddCountryInput addCountryInput) {
        Country country = new Country();
        country.setName(addCountryInput.getName());

        return countriesRepository.save(country);
    }

    public Country editCountry(final CountryDto countryDto) throws ItemNotFoundException {
        if (!countriesRepository.existsById(countryDto.getId())) {
            throw new ItemNotFoundException("Country with id = " + countryDto.getId() + " does not exist");
        }

        Country dish = new Country();
        dish.setId(countryDto.getId());
        dish.setName(countryDto.getName());

        return countriesRepository.save(dish);
    }
}
