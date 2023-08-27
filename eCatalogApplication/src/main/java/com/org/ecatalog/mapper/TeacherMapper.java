package com.org.ecatalog.mapper;

import com.org.ecatalog.dto.*;
import com.org.ecatalog.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherMapper {
    public Teacher toEntity(TeacherCreateDto createDto) {
        return Teacher.builder()
                .firstName(createDto.getFirstName())
                .lastName(createDto.getLastName())
                .cnp(createDto.getCnp())
                .salary(createDto.getSalary())
                .subject(createDto.getSubject())
                .profilePicture(createDto.getProfilePicture())
                .build();
    }
    public TeacherDto toDto(Teacher entity) {

        return TeacherDto.builder()
                .id(entity.getId())
                .cnp(entity.getCnp())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .salary(entity.getSalary())
                .subject(entity.getSubject())
                .profilePicture(entity.getProfilePicture())
                .build();
    }
    public List<TeacherCardDto> toTeacherCardDtoList(List<Teacher> teachers){
        List<TeacherCardDto> teacherCardDtos=new ArrayList<>();
        for (Teacher t:teachers) {
            TeacherCardDto teacherCardDto= TeacherCardDto.builder()
                    .firstName(t.getFirstName())
                    .lastName(t.getLastName())
                    .subject(t.getSubject())
                    .profilePicture(t.getProfilePicture())
                    .id(t.getId())
                    .profilePicture(t.getProfilePicture())
                    .build();
            teacherCardDtos.add(teacherCardDto);
        }
    return teacherCardDtos;
    }
}
