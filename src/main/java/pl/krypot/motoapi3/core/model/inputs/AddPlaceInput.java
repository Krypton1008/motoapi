package pl.krypot.motoapi3.core.model.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPlaceInput {

    @NotNull
    private String name;

    @NotNull
    private AddCityInput addCityInput;

    @NotNull
    private Double lat;

    @NotNull
    private Double lon;
}
