package pl.gr.veterinaryapp.model.dto;

import lombok.*;
import pl.gr.veterinaryapp.common.OperationType;
import pl.gr.veterinaryapp.common.VisitType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;

@Data
@Builder(builderClassName = "VisitRequestDtoBuilder")
@RequiredArgsConstructor
public class VisitRequestDto {

    private final Long vetId;
    private final Long petId;
    private final OffsetDateTime startDateTime;
    private final Duration duration;
    private final BigDecimal price;
    private final VisitType visitType;
    private final OperationType operationType;
}
