package com.org.ecatalog.controller;

import com.org.ecatalog.dto.StudentCardDto;
import com.org.ecatalog.dto.StudentCreateDto;
import com.org.ecatalog.dto.StudentDto;

import com.org.ecatalog.entity.Student;
import com.org.ecatalog.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentCreateDto studentCreateDto) {
        return ResponseEntity.ok(studentService.create(studentCreateDto));
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();

    }

    // http://localhost:8080/students/school-class/3409738a-cb43-46a1-86a0-9ceace64ab2b
    @GetMapping("/school-class/{id}")
    public List<StudentDto> getAllStudentsFromAClass(@PathVariable(name = "id") Long schoolClassId) {
        return studentService.getAllStudentsFromAClass(schoolClassId);
    }

    @GetMapping(path = "/students-cards")
    public List<StudentCardDto> getStudentsCards() {
        return studentService.getStudentCards();
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable(name = "id") Long studentId,
                             @RequestBody StudentCreateDto studentCreateDto) {
        return studentService.update(studentId, studentCreateDto);
    }

    @DeleteMapping("{id}")
    public void deleteByCnp(@PathVariable Long id) {
        studentService.deleteById(id);
    }

}
