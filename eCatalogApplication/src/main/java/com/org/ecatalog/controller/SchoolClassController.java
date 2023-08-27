package com.org.ecatalog.controller;

import com.org.ecatalog.dto.SchoolClassCreateDto;
import com.org.ecatalog.dto.SchoolClassDto;
import com.org.ecatalog.exceptions.SchoolClassInvalidException;
import com.org.ecatalog.service.SchoolClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/school-class")
@AllArgsConstructor
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @GetMapping
    public ResponseEntity<List<SchoolClassDto>> getAll() {
        List<SchoolClassDto> classes = schoolClassService.findAll();
        return ResponseEntity.ok(classes);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SchoolClassCreateDto schoolClassCreateDto) {
        try {
            SchoolClassDto schoolClassDto = schoolClassService.create(schoolClassCreateDto);
            return ResponseEntity.ok(schoolClassDto);
        } catch (SchoolClassInvalidException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        schoolClassService.delete(id);
    }


}
