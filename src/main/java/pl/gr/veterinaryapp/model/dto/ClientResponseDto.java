package pl.gr.veterinaryapp.model.dto;

import lombok.Data;

@Data
public class ClientResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
}
