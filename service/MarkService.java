package com.codeline.apis.service;
import com.codeline.apis.dto.request.MarkCreateRequest;
import com.codeline.apis.dto.response.MarkCreateResponse;
import com.codeline.apis.exception.DuplicateResourceException;
import com.codeline.apis.model.Mark;
import com.codeline.apis.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository repo;

    @Transactional
    public MarkCreateResponse create(MarkCreateRequest req) {
        if (repo.findByStudentAndCourseManual(req.getStudentCode(), req.getCourseCode()).isPresent()) {
            throw new DuplicateResourceException("Mark already exists for this student & course");
        }
        Mark saved = repo.save(
                Mark.builder()
                        .studentCode(req.getStudentCode())
                        .courseCode(req.getCourseCode())
                        .score(req.getScore())
                        .build());
        return MarkCreateResponse.builder()
                .id(saved.getId())
                .studentCode(saved.getStudentCode())
                .courseCode(saved.getCourseCode())
                .score(saved.getScore())
                .message("Mark created")
                .build();
    }
}