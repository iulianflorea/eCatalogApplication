package com.org.ecatalog.service;

import com.org.ecatalog.dto.SchoolClassCreateDto;
import com.org.ecatalog.dto.SchoolClassDto;
import com.org.ecatalog.entity.SchoolClass;
import com.org.ecatalog.exceptions.SchoolClassInvalidException;
import com.org.ecatalog.mapper.SchoolClassMapper;
import com.org.ecatalog.repository.SchoolClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;


    public List<SchoolClassDto> findAll() {
        return schoolClassRepository.findAll().stream().map(schoolClass -> {
            SchoolClassDto dto = schoolClassMapper.toDto(schoolClass);
            return dto;
        }).collect(Collectors.toList());
    }

    public SchoolClassDto create(SchoolClassCreateDto schoolClassCreateDto) throws SchoolClassInvalidException {

        List<String> errors = validateSchoolClass(schoolClassCreateDto);
        if(errors.isEmpty() == false) {
            throw new SchoolClassInvalidException(errors);
        }

        SchoolClass entity = schoolClassMapper.toEntity(schoolClassCreateDto);
        SchoolClass schoolClassWithId = schoolClassRepository.save(entity);
        return schoolClassMapper.toDto(schoolClassWithId);
    }

    private List<String> validateSchoolClass(SchoolClassCreateDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto.getStartYear() > LocalDate.now().getYear()) {
            errors.add("Year " + dto.getStartYear() + " is invalid. The starting year should not be in the future.");
        }
        return errors;
    }

    public void delete(Long id) {
        Optional<SchoolClass> schoolClass = schoolClassRepository.findById(id);
        if (schoolClass.isPresent()) {
            schoolClass.get().setClassLevel(null);
            schoolClassRepository.delete(schoolClass.get());
        }
    }
}
