package com.codeline.apis.controllers;

import com.codeline.apis.dto.request.CourseCreateRequest;
import com.codeline.apis.dto.response.CourseCreateResponse;
import com.codeline.apis.model.Course;
import com.codeline.apis.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;
    @PostMapping
    public ResponseEntity<CourseCreateResponse>create(@Valid @RequestBody CourseCreateRequest request){
        return
                ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}

