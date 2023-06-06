package com.example.taskcrudhibernate.dto;

import com.example.taskcrudhibernate.dto.simpleDto.SimpleProjectDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleSpecialtyDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeDto {
    private Long id;
    private String name;
    private SimpleSpecialtyDto specialtyDto;
    private List<SimpleProjectDto> projectDtoList;

    public EmployeeDto(Long id, String name, SimpleSpecialtyDto specialtyDto, List<SimpleProjectDto> projectDtoList) {
        this.id = id;
        this.name = name;
        this.specialtyDto = specialtyDto;
        this.projectDtoList = projectDtoList;
    }

    public EmployeeDto() {
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

    public SimpleSpecialtyDto getSpecialtyDto() {
        return specialtyDto;
    }

    @JsonProperty("specialty")
    public void setSpecialtyDto(SimpleSpecialtyDto specialtyDto) {
        this.specialtyDto = specialtyDto;
    }

    public List<SimpleProjectDto> getProjectDtoList() {
        return projectDtoList;
    }

    @JsonProperty("projects")
    public void setProjectDtoList(List<SimpleProjectDto> projectDtoList) {
        this.projectDtoList = projectDtoList;
    }

    public static final class EmployeeDtoBuilder {
        private Long id;
        private String name;
        private SimpleSpecialtyDto specialtyDto;
        private List<SimpleProjectDto> projectDtoList;

        private EmployeeDtoBuilder() {
        }

        public static EmployeeDtoBuilder anEmployeeDto() {
            return new EmployeeDtoBuilder();
        }

        public EmployeeDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeDtoBuilder withSpecialtyDto(SimpleSpecialtyDto specialtyDto) {
            this.specialtyDto = specialtyDto;
            return this;
        }

        public EmployeeDtoBuilder withProjectDtoList(List<SimpleProjectDto> projectDtoList) {
            this.projectDtoList = projectDtoList;
            return this;
        }

        public EmployeeDto build() {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(id);
            employeeDto.setName(name);
            employeeDto.setSpecialtyDto(specialtyDto);
            employeeDto.setProjectDtoList(projectDtoList);
            return employeeDto;
        }
    }
}
