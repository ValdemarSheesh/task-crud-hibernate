package com.example.taskcrudhibernate.service.impl;

import com.example.taskcrudhibernate.dto.SpecialtyDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleEmployeeDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleSpecialtyDto;
import com.example.taskcrudhibernate.exceptions.NotFoundException;
import com.example.taskcrudhibernate.model.Specialty;
import com.example.taskcrudhibernate.repo.SpecialtyRepo;
import com.example.taskcrudhibernate.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private SpecialtyRepo specialtyRepo;

    @Autowired
    public void setSpecialtyRepo(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    @Transactional
    public void saveSpecialty(SimpleSpecialtyDto specialtyDto) {
        specialtyRepo.save(mapSimpleSpecialtyDtoToSpecialty(specialtyDto));
    }

    @Override
    @Transactional
    public List<SpecialtyDto> findAllSpecialties() {
        return specialtyRepo.findAll().stream().map(this::mapSpecialtyToSpecialtyDto).toList();
    }

    @Override
    @Transactional
    public SpecialtyDto findSpecialtyById(Long id) {
        Specialty specialty = specialtyRepo.findById(id);
        if (specialty == null) throw new NotFoundException("Specialty with id " + id + " is not exist");
        return mapSpecialtyToSpecialtyDto(specialty);
    }

    @Override
    @Transactional
    public void updateSpecialty(Long id, SimpleSpecialtyDto specialtyDto) {
        Specialty specialty = specialtyRepo.findById(id);
        if (specialty == null) throw new NotFoundException("Specialty with id " + id + " is not exist");
        specialty.setNameSpecialty(specialtyDto.getName());
    }

    @Override
    @Transactional
    public boolean deleteSpecialtyById(Long id) {
        return specialtyRepo.deleteById(id);
    }

    private SpecialtyDto mapSpecialtyToSpecialtyDto(Specialty specialty) {
        return SpecialtyDto.SpecialtyDtoBuilder
                .aSpecialtyDto()
                .withId(specialty.getId())
                .withNameSpecialty(specialty.getNameSpecialty())
                .withEmployees(specialty.getEmployees()
                        .stream()
                        .map(i -> new SimpleEmployeeDto(i.getId(), i.getName()))
                        .toList())
                .build();
    }

    private Specialty mapSimpleSpecialtyDtoToSpecialty(SimpleSpecialtyDto specialtyDto) {
        Specialty specialty = new Specialty();
        specialty.setNameSpecialty(specialtyDto.getName());
        return specialty;
    }
}
