package pl.krypot.motoapi3.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krypot.motoapi3.core.model.entities.EventType;
import pl.krypot.motoapi3.core.model.entities.Place;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private EventType eventType;

    @NotNull
    private String beginDate;

    @NotNull
    private Place place;

    @NotNull
    private String description;
}
