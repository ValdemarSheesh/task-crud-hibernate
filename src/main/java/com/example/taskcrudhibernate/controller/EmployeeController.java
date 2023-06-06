package com.example.taskcrudhibernate.controller;

import com.example.taskcrudhibernate.dto.EmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.example.taskcrudhibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody SimpleEmployeeDto employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee is created");
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.findAllEmployees();
        if (employeeDtoList.isEmpty())
            return ResponseEntity.ok("Specialties is not exist");
        else
            return ResponseEntity.ok(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        EmployeeDto employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PatchMapping("/specialty/{employeeId}")
    public ResponseEntity<?> assignEmployeeToSpecialty(@PathVariable Long employeeId,
                                                       @RequestParam(value = "specialty_id") Long specialtyId) {
        employeeService.assignEmployeeToSpecialty(employeeId, specialtyId);
        return ResponseEntity.ok("Employee assign to specialty");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,
                                            @Validated @RequestBody SimpleEmployeeDto employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok("Employee is updated");
    }

    @DeleteMapping("/specialty/{id}")
    public ResponseEntity<?> deleteSpecialtyInEmployee(@PathVariable Long id) {
        employeeService.deleteSpecialtyInEmployee(id);
        return ResponseEntity.ok("Specialty deleted for employee");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }
}









