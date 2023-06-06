package com.example.taskcrudhibernate.service.impl;

import com.example.taskcrudhibernate.dto.EmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleProjectDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleSpecialtyDto;
import com.example.taskcrudhibernate.exceptions.NotFoundException;
import com.example.taskcrudhibernate.model.Employee;
import com.example.taskcrudhibernate.model.Specialty;
import com.example.taskcrudhibernate.repo.EmployeeRepo;
import com.example.taskcrudhibernate.repo.SpecialtyRepo;
import com.example.taskcrudhibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    private SpecialtyRepo specialtyRepo;

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Autowired
    public void setSpecialtyRepo(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    @Transactional
    public void saveEmployee(SimpleEmployeeDto employeeDto) {
        employeeRepo.save(mapSimpleEmployeeDtoToEmployee(employeeDto));
    }

    @Override
    @Transactional
    public List<EmployeeDto> findAllEmployees() {
        return employeeRepo.findAll().stream().map(this::mapEmployeeToEmployeeDto).toList();
    }

    @Override
    @Transactional
    public EmployeeDto findEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id);
        if (employee == null) throw new NotFoundException("Employee with id " + id + " is not exist");
        return mapEmployeeToEmployeeDto(employee);
    }

    @Override
    @Transactional
    public void assignEmployeeToSpecialty(Long employeeId, Long specialtyId) {
        Specialty specialty = specialtyRepo.findById(specialtyId);
        Employee employee = employeeRepo.findById(employeeId);
        if (specialty == null) throw new NotFoundException("Specialty with id " + specialtyId + " is not exist");
        if (employee == null) throw new NotFoundException("Employee with id " + employeeId + " is not exist");
        employee.setSpecialty(specialty);
    }

    @Override
    @Transactional
    public void updateEmployee(Long id, SimpleEmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(id);
        if (employee == null) throw new NotFoundException("Employee with id " + id + " is not exist");
        employee.setName(employeeDto.getName());
    }

    @Override
    @Transactional
    public boolean deleteEmployeeById(Long id) {
        return employeeRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteSpecialtyInEmployee(Long id) {
        Employee employee = employeeRepo.findById(id);
        if (employee == null) throw new NotFoundException("Employee with id " + id + " is not exist");
        employee.setSpecialty(null);
    }

    private EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.EmployeeDtoBuilder
                .anEmployeeDto()
                .withId(employee.getId())
                .withName(employee.getName())
                .withProjectDtoList(employee.getProjects()
                        .stream()
                        .map(i -> new SimpleProjectDto(i.getId(), i.getNameProject()))
                        .toList())
                .build();

        Specialty specialty = employee.getSpecialty();
        if (specialty != null)
            employeeDto.setSpecialtyDto(new SimpleSpecialtyDto(specialty.getId(), specialty.getNameSpecialty()));

        return employeeDto;
    }

    private Employee mapSimpleEmployeeDtoToEmployee(SimpleEmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        return employee;
    }
}
