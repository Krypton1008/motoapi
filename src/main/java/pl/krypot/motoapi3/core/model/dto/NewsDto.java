package pl.krypot.motoapi3.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krypot.motoapi3.core.model.entities.EventType;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private EventType eventType;

    @NotNull
    private String date;

    @NotNull
    private String article;
}
