package com.codeline.apis.dto.request;
import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InstructorCreateRequest {
    @NotBlank @Size(max = 100) private String name;
    @NotBlank @Size(max = 20)  private String instructorCode;
    @NotBlank @Email            private String email;
}