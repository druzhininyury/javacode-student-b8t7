package ru.javacode.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javacode.student.model.Department;
import ru.javacode.student.model.dto.DepartmentDtoNew;
import ru.javacode.student.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department addDepartment(DepartmentDtoNew departmentDtoNew) {
        Department department = new Department();
        department.setName(departmentDtoNew.getName());

        Department dbDepartment = departmentRepository.save(department);

        return dbDepartment;
    }

}
