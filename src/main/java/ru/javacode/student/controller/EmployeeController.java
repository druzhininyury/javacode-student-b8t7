package ru.javacode.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javacode.student.model.Employee;
import ru.javacode.student.model.dto.EmployeeDtoNew;
import ru.javacode.student.model.projection.EmployeeProjection;
import ru.javacode.student.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@Validated
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeProjection getEmployee(@PathVariable long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid EmployeeDtoNew employeeDtoNew) {
        return employeeService.addEmployee(employeeDtoNew);
    }

}
