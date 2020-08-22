package pl.krypot.motoapi3.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@Entity(name = "news")
public class News {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @NotNull
    private String date;

    @NotNull
    private String article;
}
