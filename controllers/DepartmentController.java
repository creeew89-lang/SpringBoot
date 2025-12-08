package com.codeline.apis.controllers;

import com.codeline.apis.dto.request.DepartmentCreateRequest;
import com.codeline.apis.dto.response.DepartmentCreateResponse;
import com.codeline.apis.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<DepartmentCreateResponse> create(@Valid @RequestBody DepartmentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}