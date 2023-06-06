package com.example.taskcrudhibernate.controller;

import com.example.taskcrudhibernate.dto.ProjectDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleProjectDto;
import com.example.taskcrudhibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<?> saveProject(@Validated @RequestBody SimpleProjectDto projectDto) {
        projectService.saveProject(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project is created");
    }

    @GetMapping
    public ResponseEntity<?> getProjects() {
        List<ProjectDto> projects = projectService.findAllProjects();
        if (projects.isEmpty())
            return ResponseEntity.ok("Projects is not exist");
        else
            return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findProjectById(id));
    }

    @PatchMapping("/employee/{projectId}")
    public ResponseEntity<?> assignProjectToEmployee(@PathVariable Long projectId,
                                                     @RequestParam(value = "employee_id") Long employeeId) {
        projectService.assignProjectToEmployee(projectId, employeeId);
        return ResponseEntity.ok("Project assign to employee");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id,
                                           @Validated @RequestBody SimpleProjectDto projectDto) {
        projectService.updateProject(id, projectDto);
        return ResponseEntity.ok("Project is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.deleteProjectById(id));
    }
}
