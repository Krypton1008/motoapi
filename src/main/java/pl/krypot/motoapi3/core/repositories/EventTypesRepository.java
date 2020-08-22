package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.EventType;

@Repository
public interface EventTypesRepository extends JpaRepository<EventType, Long> {

    EventType findByName(String name);
}

