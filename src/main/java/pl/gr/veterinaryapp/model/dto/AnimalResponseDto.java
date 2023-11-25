package pl.gr.veterinaryapp.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class AnimalResponseDto extends RepresentationModel<AnimalResponseDto> {
    private final Long id;
    private final String species;
}
