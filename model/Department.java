package com.codeline.apis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 20)
    private String deptCode;
    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;
    @Builder.Default
    private LocalDateTime createdDAte = LocalDateTime.now();
    private LocalDateTime updatedDate;
}
