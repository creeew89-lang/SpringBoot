package com.codeline.apis.service;

import com.codeline.apis.dto.request.CourseCreateRequest;
import com.codeline.apis.dto.response.CourseCreateResponse;
import com.codeline.apis.exception.DuplicateResourceException;
import com.codeline.apis.model.Course;
import com.codeline.apis.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repo;
    @Transactional
    public CourseCreateResponse create(CourseCreateRequest req){
        if (repo.findByCourseCodeManual(req.getCourseCode()).isPresent()) {
            throw new DuplicateResourceException("Course code already exists");
        }
        Course saved = repo.save(
                Course.builder()
                        .name(req.getName())
                        .courseCode(req.getCourseCode())
                        .isActive(true)
                        .build());
return CourseCreateResponse.builder()
        .id(saved.getId())
        .name(saved.getName())
        .courseCode(saved.getCourseCode())
        .message("Course created")
        .build();
        }
    }
