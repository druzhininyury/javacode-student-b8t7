package ru.javacode.student.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDtoNew {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String position;

    @NotNull
    @PositiveOrZero
    private Integer salary;

    @NotNull
    private Long departmentId;

}
