package ru.javacode.student.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javacode.student.model.Department;
import ru.javacode.student.model.Employee;
import ru.javacode.student.model.dto.EmployeeDtoNew;
import ru.javacode.student.model.dto.EmployeeDtoUpdate;
import ru.javacode.student.model.projection.EmployeeProjection;
import ru.javacode.student.repository.DepartmentRepository;
import ru.javacode.student.repository.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeProjection getEmployee(long employeeId) {
        Optional<EmployeeProjection> employeeProjectionOptional = employeeRepository.findEmployeeProjectionById(employeeId);
        if (employeeProjectionOptional.isEmpty()) {
            throw new EntityNotFoundException("Employee hasn't been found.");
        }
        EmployeeProjection employeeProjection = employeeProjectionOptional.get();

        return employeeProjection;
    }

    @Override
    @Transactional
    public Employee addEmployee(EmployeeDtoNew employeeDtoNew) {
        Optional<Department> departmentOptional = departmentRepository.findById(employeeDtoNew.getDepartmentId());
        if (departmentOptional.isEmpty()) {
            throw new EntityNotFoundException("Department hasn't been found.");
        }
        Department dbDepartment = departmentOptional.get();

        Employee employee = new Employee();
        employee.setFirstName(employeeDtoNew.getFirstName());
        employee.setLastName(employeeDtoNew.getLastName());
        employee.setPosition(employeeDtoNew.getPosition());
        employee.setSalary(employeeDtoNew.getSalary());
        employee.setDepartment(dbDepartment);

        Employee dbEmployee = employeeRepository.save(employee);

        return dbEmployee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(EmployeeDtoUpdate employeeDtoUpdate) {
        Optional<Department> departmentOptional;
        if (employeeDtoUpdate.getDepartmentId() != null) {
            departmentOptional= departmentRepository.findById(employeeDtoUpdate.getDepartmentId());
            if (departmentOptional.isEmpty()) {
                throw new EntityNotFoundException("Department hasn't been found.");
            }
        } else {
            departmentOptional = Optional.empty();
        }

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDtoUpdate.getId());
        if (employeeOptional.isEmpty()) {
            throw  new EntityNotFoundException("Employee hasn't been found.");
        }

        Employee dbEmployee = employeeOptional.get();

        if (employeeDtoUpdate.getFirstName() != null) {
            dbEmployee.setFirstName(employeeDtoUpdate.getFirstName());
        }
        if (employeeDtoUpdate.getLastName() != null) {
            dbEmployee.setLastName(employeeDtoUpdate.getLastName());
        }
        if (employeeDtoUpdate.getPosition() != null) {
            dbEmployee.setPosition(employeeDtoUpdate.getPosition());
        }
        if (employeeDtoUpdate.getSalary() != null) {
            dbEmployee.setSalary(employeeDtoUpdate.getSalary());
        }
        if (departmentOptional.isPresent()) {
            dbEmployee.setDepartment(departmentOptional.get());
        }

        dbEmployee = employeeRepository.save(dbEmployee);

        return dbEmployee;
    }
}
