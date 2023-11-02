package com.org.ecatalog.service;

import com.org.ecatalog.dto.StudentCardDto;
import com.org.ecatalog.dto.StudentCreateDto;
import com.org.ecatalog.dto.StudentDto;
import com.org.ecatalog.entity.SchoolClass;
import com.org.ecatalog.entity.Student;
import com.org.ecatalog.mapper.StudentMapper;
import com.org.ecatalog.repository.SchoolClassRepository;
import com.org.ecatalog.repository.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public StudentDto create(StudentCreateDto createDto) {
        Student toBeSaved = studentMapper.toEntity(createDto);
        Student saved = studentRepository.save(toBeSaved);
        return studentMapper.toDto(saved);

    }

    public void nuFaceNimic() {

    }

    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDtoList(students);
    }

    public List<StudentDto> getAllStudentsFromAClass(Long schoolClassId) {
        List<Student> studentsList = studentRepository.getStudentBySchoolClassId(schoolClassId);
        return studentMapper.toDtoList(studentsList);

    }

    public List<StudentCardDto> getStudentCards() {
        return studentMapper.toStudentCardDtoList(studentRepository.findAll());
    }


    public StudentDto update(Long id, StudentCreateDto studentCreateDto) {
        Student studentToBeSaved = studentRepository.findById(id).orElseThrow();
        studentToBeSaved.setSchoolClassId(studentCreateDto.getSchoolClassId());
        studentToBeSaved.setLastName(studentCreateDto.getLastName());
        studentToBeSaved.setFirstName(studentCreateDto.getFirstName());
        Student studentSaved = studentRepository.save(studentToBeSaved);
        return studentMapper.toDto(studentSaved);
    }

    public void deleteById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.get().setSchoolClass(null);
            studentRepository.delete(student.get());
        }
    }
}
