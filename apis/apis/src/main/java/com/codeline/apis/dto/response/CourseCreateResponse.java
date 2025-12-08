package com.codeline.apis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseCreateResponse {
    private Integer id;
    private String name;
    private String courseCode;
    private String message;

}
