package pl.krypot.motoapi3.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.model.dto.NewsDto;
import pl.krypot.motoapi3.core.model.entities.News;
import pl.krypot.motoapi3.core.model.inputs.AddNewsInput;
import pl.krypot.motoapi3.core.repositories.NewsRepository;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class NewsService {
    private NewsRepository newsRepository;
    private EventTypesService eventTypesService;

    @Autowired
    public NewsService(final NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {return  newsRepository.findAll();}

    public List<News> getNewsByDate(String date) {
        return newsRepository.findAllByDate(date);
    }

    public News getNews(final Long id) throws ItemNotFoundException {
        return newsRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public News getNewsByTitle(final String title) throws ItemNotFoundException {
        return newsRepository.findByTitle(title);
    }

    public News addNews(final AddNewsInput addNewsInput) {
        News news = new News();
        news.setTitle(addNewsInput.getTitle());
        news.setEventType(eventTypesService.getEventTypeByName(addNewsInput.getEventTypeInput().getName()));
        news.setDate(addNewsInput.getDate());
        news.setArticle(addNewsInput.getArticle());

        return newsRepository.save(news);
    }

    public void deleteNews(final Long id) throws ItemNotFoundException {

        if (!newsRepository.existsById(id)) {
            throw new ItemNotFoundException("News with id = " + id + " does not exist");
        }
        newsRepository.deleteById(id);

    }

    public News editNews(final NewsDto newsDto) throws ItemNotFoundException {
        if (!newsRepository.existsById(newsDto.getId())) {
            throw new ItemNotFoundException("News with id = " + newsDto.getId() + " does not exist");
        }

        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setDate(newsDto.getDate());
        news.setArticle(newsDto.getArticle());

        return newsRepository.save(news);
    }
}
