package com.codeline.apis.controllers;
import com.codeline.apis.dto.request.InstructorCreateRequest;
import com.codeline.apis.dto.response.InstructorCreateResponse;
import com.codeline.apis.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService service;

    @PostMapping
    public ResponseEntity<InstructorCreateResponse> create(@Valid @RequestBody InstructorCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}