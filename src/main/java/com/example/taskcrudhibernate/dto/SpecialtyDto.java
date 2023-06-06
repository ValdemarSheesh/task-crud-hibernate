package com.example.taskcrudhibernate.dto;

import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SpecialtyDto {
    private Long id;
    private String nameSpecialty;
    private List<SimpleEmployeeDto> employees;

    public SpecialtyDto(Long id, String nameSpecialty, List<SimpleEmployeeDto> employees) {
        this.id = id;
        this.nameSpecialty = nameSpecialty;
        this.employees = employees;
    }

    public SpecialtyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSpecialty() {
        return nameSpecialty;
    }

    @JsonProperty("specialty")
    public void setNameSpecialty(String nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
    }

    public List<SimpleEmployeeDto> getEmployees() {
        return employees;
    }

    @JsonProperty("employees")
    public void setEmployees(List<SimpleEmployeeDto> employees) {
        this.employees = employees;
    }

    public static final class SpecialtyDtoBuilder {
        private Long id;
        private String nameSpecialty;
        private List<SimpleEmployeeDto> employees;

        private SpecialtyDtoBuilder() {
        }

        public static SpecialtyDtoBuilder aSpecialtyDto() {
            return new SpecialtyDtoBuilder();
        }

        public SpecialtyDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SpecialtyDtoBuilder withNameSpecialty(String nameSpecialty) {
            this.nameSpecialty = nameSpecialty;
            return this;
        }

        public SpecialtyDtoBuilder withEmployees(List<SimpleEmployeeDto> employees) {
            this.employees = employees;
            return this;
        }

        public SpecialtyDto build() {
            SpecialtyDto specialtyDto = new SpecialtyDto();
            specialtyDto.setId(id);
            specialtyDto.setNameSpecialty(nameSpecialty);
            specialtyDto.setEmployees(employees);
            return specialtyDto;
        }
    }
}

