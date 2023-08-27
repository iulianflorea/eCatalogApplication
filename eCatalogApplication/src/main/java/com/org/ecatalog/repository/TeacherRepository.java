package com.org.ecatalog.repository;

import com.org.ecatalog.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByCnp(String cnp);

}
