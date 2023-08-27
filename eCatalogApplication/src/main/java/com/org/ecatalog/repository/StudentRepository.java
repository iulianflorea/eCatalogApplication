package com.org.ecatalog.repository;

import com.org.ecatalog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   List<Student> getStudentBySchoolClassId(Long schoolClassId);

}
