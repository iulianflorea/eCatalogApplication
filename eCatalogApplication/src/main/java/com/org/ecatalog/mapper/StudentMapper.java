package com.org.ecatalog.mapper;

import com.org.ecatalog.dto.SchoolClassDto;
import com.org.ecatalog.dto.StudentCardDto;
import com.org.ecatalog.dto.StudentCreateDto;
import com.org.ecatalog.dto.StudentDto;
import com.org.ecatalog.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class StudentMapper {

    private final SchoolClassMapper schoolClassMapper;

    public Student toEntity(StudentCreateDto createDto) {
        return Student.builder()
                .firstName(createDto.getFirstName())
                .lastName(createDto.getLastName())
                .cnp(createDto.getCnp())
                .schoolClassId(createDto.getSchoolClassId())
                .profilePicture(createDto.getProfilePicture())
                .build();
    }

    // (StudentDto <- SchoolClassDto)    <=  school class mapper  <=   (Student <- SchoolClass)
    public StudentDto toDto(Student entity) {

        SchoolClassDto schoolClassDto = schoolClassMapper.toDto(entity.getSchoolClass());

        return StudentDto.builder()
                .id(entity.getId())
                .cnp(entity.getCnp())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .schoolClassDto(schoolClassDto)
                .build();
    }

    public List<StudentDto> toDtoList(List<Student> studentsList) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student s : studentsList) {
            StudentDto studentDto = toDto(s);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

    public List<StudentCardDto> toStudentCardDtoList(List<Student> students) {
        List<StudentCardDto> studentCardDtos = new ArrayList<>();
        for (Student s : students) {
            StudentCardDto studentCardDto = StudentCardDto.builder()
                    .firstName(s.getFirstName())
                    .lastName(s.getLastName())
                    .profilePicture(s.getProfilePicture())
                    .cnp(s.getCnp())
                    .id(s.getId())
                    .schoolClassDto(schoolClassMapper.toDto(s.getSchoolClass()))
                    .build();
            studentCardDtos.add(studentCardDto);

        }
        return studentCardDtos;
    }
}