package com.example.taskcrudhibernate.repo;

import com.example.taskcrudhibernate.model.Project;

import java.util.List;

public interface ProjectRepo {

    void save(Project project);

    List<Project> findAll();

    Project findById(Long id);

    boolean deleteById(Long id);
}
