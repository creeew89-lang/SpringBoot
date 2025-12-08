package com.codeline.apis.repository;

import com.codeline.apis.model.Course;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT * FROM course WHERE course_code = :code LIMIT 1", nativeQuery = true)
    Optional<Course> findByCourseCodeManual(@Param("code") String courseCode);
}