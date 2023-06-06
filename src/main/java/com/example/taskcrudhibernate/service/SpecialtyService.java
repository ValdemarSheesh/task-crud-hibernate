package com.example.taskcrudhibernate.service;


import com.example.taskcrudhibernate.dto.SpecialtyDto;
import com.example.taskcrudhibernate.dto.simpleDto.SimpleSpecialtyDto;

import java.util.List;

public interface SpecialtyService {

    void saveSpecialty(SimpleSpecialtyDto specialtyDto);

    List<SpecialtyDto> findAllSpecialties();

    SpecialtyDto findSpecialtyById(Long id);

    void updateSpecialty(Long id, SimpleSpecialtyDto specialtyDto);

    boolean deleteSpecialtyById(Long id);
}
