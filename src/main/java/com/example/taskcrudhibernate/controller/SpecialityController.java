package com.example.taskcrudhibernate.controller;

import com.example.taskcrudhibernate.dto.SpecialtyDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleSpecialtyDto;
import com.example.taskcrudhibernate.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("specialty")
public class SpecialityController {

    private SpecialtyService specialtyService;

    @Autowired
    public void setSpecialtyService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @PostMapping
    public ResponseEntity<?> saveSpeciality(@RequestBody SimpleSpecialtyDto specialtyDto) {
        specialtyService.saveSpecialty(specialtyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Specialty is created");
    }

    @GetMapping
    public ResponseEntity<?> getAllSpecialities() {
        List<SpecialtyDto> specialtyDtoList = specialtyService.findAllSpecialties();
        if (specialtyDtoList.isEmpty())
            return ResponseEntity.ok("Specialties is not exist");
        else
            return ResponseEntity.ok(specialtyDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecialty(@PathVariable(value = "id") Long id) {
        SpecialtyDto specialty = specialtyService.findSpecialtyById(id);
        return ResponseEntity.ok(specialty);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSpecialty(@PathVariable(value = "id") Long id,
                                             @RequestBody SimpleSpecialtyDto specialtyDto) {
        specialtyService.updateSpecialty(id, specialtyDto);
        return ResponseEntity.ok("Specialty is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(specialtyService.deleteSpecialtyById(id));
    }
}
