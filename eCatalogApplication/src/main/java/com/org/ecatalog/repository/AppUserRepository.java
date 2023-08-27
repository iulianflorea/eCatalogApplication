package com.org.ecatalog.repository;

import com.org.ecatalog.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
