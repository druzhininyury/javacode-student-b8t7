package ru.javacode.student.model.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.lastName + \" \" + target.firstName}")
    String getFullName();

    String getPosition();

    @Value("#{target.department.name}")
    String getDepartmentName();

}
