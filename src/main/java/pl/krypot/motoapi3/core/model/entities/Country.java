package pl.krypot.motoapi3.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "country")
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
}
