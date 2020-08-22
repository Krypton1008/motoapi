package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.Country;

import java.util.List;

@Repository
public interface CountriesRepository extends JpaRepository<Country,Long> {

    Country findByName(String name);
}
