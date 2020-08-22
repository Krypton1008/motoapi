package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.City;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<City,Long> {

    City findByName(String name);

    List<City> findAllByCountry_Name(String name);

    List<City> findAllByCountry_Id(Long id);
}
