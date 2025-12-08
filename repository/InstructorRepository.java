package com.codeline.apis.repository;
import com.codeline.apis.model.Instructor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    @Query(value = "SELECT * FROM instructor WHERE instructor_code = :code LIMIT 1", nativeQuery = true)
    Optional<Instructor> findByInstructorCodeManual(@Param("code") String instructorCode);
}