package com.codeline.apis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentCreateResponse {
    private Integer id;
    private String name;
    private String deptCode;
    private String message;
}
