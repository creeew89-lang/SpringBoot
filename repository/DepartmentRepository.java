package com.codeline.apis.repository;
import com.codeline.apis.model.Department;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "SELECT * FROM department WHERE dept_code = :code LIMIT 1", nativeQuery = true)
    Optional<Department> findByDeptCodeManual(@Param("code") String deptCode);
}