package com.example.taskcrudhibernate.dto;

import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProjectDto {
    private Long id;
    private String nameProject;
    private List<SimpleEmployeeDto> employeeDtoList;

    public ProjectDto(Long id, String nameProject, List<SimpleEmployeeDto> employeeDtoList) {
        this.id = id;
        this.nameProject = nameProject;
        this.employeeDtoList = employeeDtoList;
    }

    public ProjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProject() {
        return nameProject;
    }

    @JsonProperty("project")
    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public List<SimpleEmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    @JsonProperty("employees")
    public void setEmployeeDtoList(List<SimpleEmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

    public static final class ProjectDtoBuilder {
        private Long id;
        private String nameProject;
        private List<SimpleEmployeeDto> employeeDtoList;

        private ProjectDtoBuilder() {
        }

        public static ProjectDtoBuilder aProjectDto() {
            return new ProjectDtoBuilder();
        }

        public ProjectDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ProjectDtoBuilder withNameProject(String nameProject) {
            this.nameProject = nameProject;
            return this;
        }

        public ProjectDtoBuilder withEmployeeDtoList(List<SimpleEmployeeDto> employeeDtoList) {
            this.employeeDtoList = employeeDtoList;
            return this;
        }

        public ProjectDto build() {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(id);
            projectDto.setNameProject(nameProject);
            projectDto.setEmployeeDtoList(employeeDtoList);
            return projectDto;
        }
    }
}
