package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.Event;
import pl.krypot.motoapi3.core.model.entities.Place;

import java.util.List;

@Repository
public interface PlacesRepository extends JpaRepository<Place,Long> {

    Place findByName(String name);

    List <Place> findAllByCity_Name(String name);
    List <Place> findAllByCity_Id(Long id);
}
