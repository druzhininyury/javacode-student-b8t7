package ru.javacode.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javacode.student.model.Employee;
import ru.javacode.student.model.projection.EmployeeProjection;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<EmployeeProjection> findEmployeeProjectionById(long employeeId);

}
