package pl.krypot.motoapi3.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventTypeDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;
}
