package pl.krypot.motoapi3.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "event_type")
public class EventType {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

}