package com.example.taskcrudhibernate.service;

import com.example.taskcrudhibernate.dto.ProjectDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleProjectDto;

import java.util.List;

public interface ProjectService {

    void saveProject(SimpleProjectDto projectDto);

    List<ProjectDto> findAllProjects();

    ProjectDto findProjectById(Long id);

    void assignProjectToEmployee(Long projectId, Long employeeId);

    void updateProject(Long id, SimpleProjectDto projectDto);

    boolean deleteProjectById(Long id);

    void deleteEmployeeFromProject(Long projectId, Long employeeId);
}
