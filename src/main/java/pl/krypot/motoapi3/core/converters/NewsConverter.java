package pl.krypot.motoapi3.core.converters;

import org.springframework.stereotype.Component;
import pl.krypot.motoapi3.core.model.dto.NewsDto;
import pl.krypot.motoapi3.core.model.entities.News;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsConverter {
    public NewsDto convertOneNews(final News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setEventType(news.getEventType());
        newsDto.setDate(news.getDate());
        newsDto.setArticle(news.getArticle());
        return newsDto;
    }

    public List<NewsDto> convertNews(final List<News> newsList) {
        return newsList.stream().map(this::convertOneNews).collect(Collectors.toList());
    }
}
