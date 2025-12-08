package com.codeline.apis.controllers;
import com.codeline.apis.dto.request.MarkCreateRequest;
import com.codeline.apis.dto.response.MarkCreateResponse;
import com.codeline.apis.service.MarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService service;

    @PostMapping
    public ResponseEntity<MarkCreateResponse> create(@Valid @RequestBody MarkCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}