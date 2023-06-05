package com.example.taskcrudhibernate.service;

import com.example.taskcrudhibernate.dto.EmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(SimpleEmployeeDto employeeDto);

    List<EmployeeDto> findAllEmployees();

    EmployeeDto findEmployeeById(Long id);

    void assignEmployeeToSpecialty(Long employeeId, Long specialtyId);

    void updateEmployee(Long id, SimpleEmployeeDto employeeDto);

    boolean deleteEmployeeById(Long id);
}
