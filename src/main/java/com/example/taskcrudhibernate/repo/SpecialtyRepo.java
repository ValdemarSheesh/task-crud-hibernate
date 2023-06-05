package com.example.taskcrudhibernate.repo;

import com.example.taskcrudhibernate.model.Specialty;

import java.util.List;

public interface SpecialtyRepo {

    void save(Specialty specialty);

    List<Specialty> findAll();

    Specialty findById(Long id);

    boolean deleteById(Long id);
}
