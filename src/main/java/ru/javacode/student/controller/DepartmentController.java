package ru.javacode.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javacode.student.model.Department;
import ru.javacode.student.model.dto.DepartmentDtoNew;
import ru.javacode.student.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@Validated
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department addDepartment(@RequestBody @Valid DepartmentDtoNew departmentDtoNew) {
        return departmentService.addDepartment(departmentDtoNew);
    }
}
