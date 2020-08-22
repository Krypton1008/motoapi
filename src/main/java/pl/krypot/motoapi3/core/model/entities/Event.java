package pl.krypot.motoapi3.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @NotNull
    private String beginDate;

    @ManyToOne
    @JoinColumn(name = "place")
    private Place place;

    @NotNull
    private String description;


}