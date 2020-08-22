package pl.krypot.motoapi3.core.model.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewsInput {

    @NotNull
    private String title;

    @NotNull
    private AddEventTypeInput eventTypeInput;

    @NotNull
    private String date;

    @NotNull
    private String article;
}
