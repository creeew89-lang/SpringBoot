package com.codeline.apis.repository;
import com.codeline.apis.model.Mark;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "SELECT * FROM mark WHERE student_code = :st AND course_code = :co LIMIT 1", nativeQuery = true)
    Optional<Mark> findByStudentAndCourseManual(@Param("st") String studentCode, @Param("co") String courseCode);
}