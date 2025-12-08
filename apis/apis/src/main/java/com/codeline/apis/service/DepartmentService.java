package com.codeline.apis.service;

import com.codeline.apis.dto.request.DepartmentCreateRequest;
import com.codeline.apis.dto.response.DepartmentCreateResponse;
import com.codeline.apis.exception.DuplicateResourceException;
import com.codeline.apis.model.Department;
import com.codeline.apis.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repo;

    @Transactional
    public DepartmentCreateResponse create(DepartmentCreateRequest req) {
        if (repo.findByDeptCodeManual(req.getDeptCode()).isPresent()) {
            throw new DuplicateResourceException("Department code already exists");
        }
        Department saved = repo.save(
                Department.builder()
                        .name(req.getName())
                        .deptCode(req.getDeptCode())
                        .isActive(true)
                        .build());
        return DepartmentCreateResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .deptCode(saved.getDeptCode())
                .message("Department created")
                .build();
    }
}