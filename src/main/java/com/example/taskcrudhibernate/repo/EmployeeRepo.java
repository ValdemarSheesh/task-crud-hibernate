package com.example.taskcrudhibernate.repo;

import com.example.taskcrudhibernate.model.Employee;

import java.util.List;

public interface EmployeeRepo {

    void save(Employee employee);

    List<Employee> findAll();

    Employee findById(Long id);

    boolean deleteById(Long id);
}
