package com.fiap.checkpoint2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    @Query(value = "SELECT AVG(e.salary) FROM Employee e WHERE e.department_id = :departmentId", nativeQuery = true)
    Double findAverageSalaryByDepartment(@Param("departmentId") Long departmentId);
}

