package pl.krypot.motoapi3.core.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krypot.motoapi3.core.converters.NewsConverter;
import pl.krypot.motoapi3.core.model.dto.NewsDto;
import pl.krypot.motoapi3.core.model.inputs.AddNewsInput;
import pl.krypot.motoapi3.core.services.NewsService;
import pl.krypot.motoapi3.exceptions.ItemNotFoundException;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestMapping("/news")
@Api(value = "news endpoint")
@RestController
public class NewsEndpoint {

    private NewsService newsService;
    private NewsConverter newsConverter;

    @Autowired
    public NewsEndpoint(final NewsService newsService, final NewsConverter newsConverter) {
        this.newsService = newsService;
        this.newsConverter = newsConverter;
    }

    @ApiOperation(value = "Returns all news")
    @GetMapping("/getAllNews")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<NewsDto>> getAllNews() {
        List<NewsDto> newsDtos = newsConverter.convertNews(newsService.getAllNews());
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns one news")
    @GetMapping("/getNews")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<NewsDto> getNews(@RequestParam("id") @NotNull final Long id) {
        NewsDto newsDto;
        try {
            newsDto = newsConverter.convertOneNews(newsService.getNews(id));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns news by title")
    @GetMapping("/getNewsByTitle")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<NewsDto> getNews(@RequestParam("title") @NotNull final String title) {
        NewsDto newsDto;
        try {
            newsDto = newsConverter.convertOneNews(newsService.getNewsByTitle(title));
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds news")
    @PostMapping("/addNews")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> addNews(@RequestBody @Valid final AddNewsInput addNewsInput) throws ItemNotFoundException, MessagingException{
        newsService.addNews(addNewsInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Removes news")
    @DeleteMapping("/deleteNews")
    public ResponseEntity<Void> deleteNews(@RequestParam("id") @NotNull final Long id) {
        try {
            newsService.deleteNews(id);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Edits news")
    @PostMapping("/editNews")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> editNews(@RequestBody @Valid final NewsDto newsDto) {
        try {
            newsService.editNews(newsDto);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
