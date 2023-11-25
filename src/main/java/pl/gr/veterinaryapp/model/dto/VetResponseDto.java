package pl.gr.veterinaryapp.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;


import java.time.OffsetTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class VetResponseDto extends RepresentationModel<VetResponseDto> {
    private final Long id;
    private final String name;
    private final String surname;
    private final String photoUrl;
    private final OffsetTime workStartTime;
    private final OffsetTime workEndTime;
}
