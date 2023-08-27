package com.org.ecatalog.controller;

import com.org.ecatalog.dto.TeacherCardDto;
import com.org.ecatalog.dto.TeacherCreateDto;
import com.org.ecatalog.dto.TeacherDto;
import com.org.ecatalog.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public TeacherDto create(@RequestBody TeacherCreateDto teacherCreateDto) {
        return teacherService.create(teacherCreateDto);
    }

    @GetMapping(path = "/teachers_cards")
    public List<TeacherCardDto> getTeachersCards() {
        return teacherService.getTeachersCards();
    }

    @GetMapping("/get-by-id")
    public TeacherDto getTeacherByCnp(@RequestBody String cnp){
        return teacherService.getTeacherByCnp(cnp);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherByCnp(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}
