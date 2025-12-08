package com.codeline.apis.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseCreateRequest {
    @NotBlank(message = "Name is important")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Course code is important")
    @Size(max = 20)
    private String courseCode;
}
