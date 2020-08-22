package pl.krypot.motoapi3.core.model.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krypot.motoapi3.core.model.entities.Place;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventInput {

    @NotNull
    private AddEventTypeInput eventTypeInput;

    @NotNull
    private String name;

    @NotNull
    private String beginDate;

    @NotNull
    private AddPlaceInput placeInput;

    @NotNull
    private String description;
}
