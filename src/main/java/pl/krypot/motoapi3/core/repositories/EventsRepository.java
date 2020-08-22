package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.Event;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event,Long> {

    Event findByName(String name);

    List<Event> findAllByEventType_Name(String name);
    List<Event> findAllByEventType_Id(Long id);
}
