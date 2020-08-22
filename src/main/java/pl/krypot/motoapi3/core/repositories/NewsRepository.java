package pl.krypot.motoapi3.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krypot.motoapi3.core.model.entities.News;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
    List<News> findAllByDate(String date);

    News findByTitle(String title);
}
