package com.codeline.apis.dto.request;
import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MarkCreateRequest {
    @NotBlank @Size(max = 20) private String studentCode;
    @NotBlank @Size(max = 20) private String courseCode;
    @NotNull @Min(0) @Max(100) private Integer score;
}