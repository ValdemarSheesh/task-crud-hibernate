package com.example.taskcrudhibernate.dto.simpleDto;

import jakarta.validation.constraints.NotBlank;

public class SimpleEmployeeDto {

    private Long id;
    @NotBlank
    private String name;

    public SimpleEmployeeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleEmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
