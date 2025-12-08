package com.codeline.apis.dto.response;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InstructorCreateResponse {
    private Integer id;
    private String name;
    private String instructorCode;
    private String email;
    private String message;
}