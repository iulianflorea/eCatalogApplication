package com.org.ecatalog.mapper;

import com.org.ecatalog.dto.SchoolClassCreateDto;
import com.org.ecatalog.dto.SchoolClassDto;
import com.org.ecatalog.entity.SchoolClass;
import org.springframework.stereotype.Component;

@Component
public class SchoolClassMapper {

    // din SchoolClassCreateDto to SchoolClass (entity)
    public SchoolClass toEntity(SchoolClassCreateDto createDto) {
        SchoolClass entity = SchoolClass.builder()
                .classLevel(createDto.getClassLevel())
                .startYear(createDto.getStartYear())
                .name(createDto.getName())
                .build();
        return entity;
    }

    // din SchoolClass (entity) to SchoolClassDto
    public SchoolClassDto toDto(SchoolClass entity) {
        if (entity == null) {
            return null;
        }
        SchoolClassDto dto = SchoolClassDto.builder()
                .id(entity.getId())
                .classLevel(entity.getClassLevel())
                .startYear(entity.getStartYear())
                .name(entity.getName())
                .build();
        return dto;
    }
}
