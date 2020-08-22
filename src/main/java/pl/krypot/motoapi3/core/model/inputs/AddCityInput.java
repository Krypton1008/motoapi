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
public class AddCityInput {

    @NotNull
    private String name;

    @NotNull
    private AddCountryInput countryInput;

    @NotNull
    private Double lat;

    @NotNull
    private Double lon;

}
