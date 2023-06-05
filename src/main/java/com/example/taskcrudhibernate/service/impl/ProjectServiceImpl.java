package com.example.taskcrudhibernate.service.impl;

import com.example.taskcrudhibernate.dto.ProjectDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleProjectDto;
import com.example.taskcrudhibernate.exceptions.NotFoundException;
import com.example.taskcrudhibernate.model.Employee;
import com.example.taskcrudhibernate.model.Project;
import com.example.taskcrudhibernate.repo.EmployeeRepo;
import com.example.taskcrudhibernate.repo.ProjectRepo;
import com.example.taskcrudhibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepo projectRepo;
    private EmployeeRepo employeeRepo;

    @Autowired
    public void setProjectRepo(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Transactional
    public void saveProject(SimpleProjectDto projectDto) {
        projectRepo.save(mapSimpleProjectDtoToProject(projectDto));
    }

    @Override
    @Transactional
    public List<ProjectDto> findAllProjects() {
        return projectRepo.findAll().stream().map(this::mapProjectToProjectDto).toList();
    }

    @Override
    @Transactional
    public ProjectDto findProjectById(Long id) {
        Project project = projectRepo.findById(id);
        if (project == null) throw new NotFoundException("Project with id " + id + " is not exist");
        return mapProjectToProjectDto(project);
    }

    @Override
    @Transactional
    public void assignProjectToEmployee(Long projectId, Long employeeId) {
        Project project = projectRepo.findById(projectId);
        Employee employee = employeeRepo.findById(employeeId);
        ;
        if (project == null) throw new NotFoundException("Project with id " + projectId + " is not exist");
        ;
        if (employee == null) throw new NotFoundException("Employee with id " + employeeId + " is not exist");
        project.getEmployees().add(employee);
    }

    @Override
    @Transactional
    public void updateProject(Long id, SimpleProjectDto projectDto) {
        Project project = projectRepo.findById(id);
        if (project == null) throw new NotFoundException("Project with id " + id + " is not exist");
        project.setNameProject(projectDto.getName());
    }

    @Override
    @Transactional
    public boolean deleteProjectById(Long id) {
        return projectRepo.deleteById(id);
    }

    private ProjectDto mapProjectToProjectDto(Project project) {
        return ProjectDto.ProjectDtoBuilder
                .aProjectDto()
                .withId(project.getId())
                .withNameProject(project.getNameProject())
                .withEmployeeDtoList(project.getEmployees()
                        .stream()
                        .map(i -> new SimpleEmployeeDto(i.getId(), i.getName()))
                        .toList())
                .build();
    }

    private Project mapSimpleProjectDtoToProject(SimpleProjectDto projectDto) {
        Project project = new Project();
        project.setNameProject(projectDto.getName());
        return project;
    }
}
