package ru.javacode.student.service;

import org.springframework.stereotype.Service;
import ru.javacode.student.model.Department;
import ru.javacode.student.model.dto.DepartmentDtoNew;

public interface DepartmentService {

    Department addDepartment(DepartmentDtoNew departmentDtoNew);


}
