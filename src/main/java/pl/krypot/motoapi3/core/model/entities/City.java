package pl.krypot.motoapi3.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "city")
public class City {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @NotNull
    private Double lat;

    @NotNull
    private Double lon;
}
