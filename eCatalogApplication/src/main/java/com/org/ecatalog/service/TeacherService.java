package com.org.ecatalog.service;

import com.org.ecatalog.dto.TeacherCardDto;
import com.org.ecatalog.dto.TeacherCreateDto;
import com.org.ecatalog.dto.TeacherDto;
import com.org.ecatalog.entity.Teacher;
import com.org.ecatalog.mapper.TeacherMapper;
import com.org.ecatalog.repository.TeacherRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Slf4j
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final EntityManager entityManager;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper, EntityManager entityManager) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.entityManager = entityManager;
    }

    public TeacherDto create(TeacherCreateDto createDto) {
        Teacher toBeSaved = teacherMapper.toEntity(createDto);
        Teacher saved = teacherRepository.save(toBeSaved);
        return teacherMapper.toDto(saved);
    }

    public List<TeacherCardDto> getTeachersCards() {
        return teacherMapper.toTeacherCardDtoList(teacherRepository.findAll());
    }

    public TeacherDto getTeacherByCnp(String cnp){
        Teacher teacher = teacherRepository.findByCnp(cnp);
        return teacherMapper.toDto(teacher);
    }

    public void deleteTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacherRepository.delete(teacher.get());
            log.info("Teacher {} was deleted", teacher);
        } else {
            log.info("Teacher with cnp: {} was not found", id);
        }
    }
}
