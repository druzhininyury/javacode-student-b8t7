package ru.javacode.student.service;

import ru.javacode.student.model.Employee;
import ru.javacode.student.model.dto.EmployeeDtoNew;
import ru.javacode.student.model.dto.EmployeeDtoUpdate;
import ru.javacode.student.model.projection.EmployeeProjection;

public interface EmployeeService {

    EmployeeProjection getEmployee(long employeeId);

    Employee addEmployee(EmployeeDtoNew employeeDtoNew);

    Employee updateEmployee(EmployeeDtoUpdate employeeDtoUpdate);
}
