package pl.gr.veterinaryapp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class PetResponseDto extends RepresentationModel<PetResponseDto> {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private Long animalId;
    private Long clientId;
}
