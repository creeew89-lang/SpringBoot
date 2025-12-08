package com.codeline.apis.dto.response;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MarkCreateResponse {
    private Integer id;
    private String studentCode;
    private String courseCode;
    private Integer score;
    private String message;
}