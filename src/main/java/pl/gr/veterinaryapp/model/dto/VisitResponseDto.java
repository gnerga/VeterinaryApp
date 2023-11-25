package pl.gr.veterinaryapp.model.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import pl.gr.veterinaryapp.common.OperationType;
import pl.gr.veterinaryapp.common.VisitStatus;
import pl.gr.veterinaryapp.common.VisitType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(builderClassName = "VisitResponseDtoBuilder")
@RequiredArgsConstructor
public class VisitResponseDto extends RepresentationModel<VisitResponseDto> {

    private final Long id;
    private final Long vetId;
    private final Long petId;
    private final Long treatmentRoomId;
    private final OffsetDateTime startDateTime;
    private final Duration duration;
    private final BigDecimal price;
    private final VisitType visitType;
    private final String visitDescription;
    private final VisitStatus visitStatus;
    private final OperationType operationType;
}
