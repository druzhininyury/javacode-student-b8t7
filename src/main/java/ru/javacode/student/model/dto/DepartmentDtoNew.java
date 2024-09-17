package ru.javacode.student.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDtoNew {

    @NotNull
    private String name;

}
