package com.org.ecatalog.repository;

import com.org.ecatalog.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    @Override
    List<SchoolClass> findAll();

    @Override
    SchoolClass save(SchoolClass entity);
}
