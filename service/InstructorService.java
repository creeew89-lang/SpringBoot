package com.codeline.apis.service;
import com.codeline.apis.dto.request.InstructorCreateRequest;
import com.codeline.apis.dto.response.InstructorCreateResponse;
import com.codeline.apis.exception.DuplicateResourceException;
import com.codeline.apis.model.Instructor;
import com.codeline.apis.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository repo;

    @Transactional
    public InstructorCreateResponse create(InstructorCreateRequest req) {
        if (repo.findByInstructorCodeManual(req.getInstructorCode()).isPresent()) {
            throw new DuplicateResourceException("Instructor code already exists");
        }
        Instructor saved = repo.save(
                Instructor.builder()
                        .name(req.getName())
                        .instructorCode(req.getInstructorCode())
                        .email(req.getEmail())
                        .isActive(true)
                        .build());
        return InstructorCreateResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .instructorCode(saved.getInstructorCode())
                .email(saved.getEmail())
                .message("Instructor created")
                .build();
    }
}