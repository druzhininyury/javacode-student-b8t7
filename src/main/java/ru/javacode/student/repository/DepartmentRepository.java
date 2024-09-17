package ru.javacode.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javacode.student.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {



}
