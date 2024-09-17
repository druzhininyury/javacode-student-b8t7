package ru.javacode.student.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDtoUpdate {

    @NotNull
    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    @PositiveOrZero
    private Integer salary;

    private Long departmentId;

}
