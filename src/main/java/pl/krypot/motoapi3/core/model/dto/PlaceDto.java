package pl.krypot.motoapi3.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krypot.motoapi3.core.model.entities.City;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private City city;

    @NotNull
    private Double lat;

    @NotNull
    private Double lon;
}
