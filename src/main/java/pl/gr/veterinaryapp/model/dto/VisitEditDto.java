package pl.gr.veterinaryapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.gr.veterinaryapp.common.VisitStatus;

@Data
@RequiredArgsConstructor
public class VisitEditDto {

    private final Long id;
    private final String description;
    private final VisitStatus visitStatus;
}
