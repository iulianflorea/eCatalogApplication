package com.org.ecatalog.controller;

import com.org.ecatalog.dto.AppUserCreateDto;
import com.org.ecatalog.entity.AppUser;
import com.org.ecatalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUserCreateDto createDto){
        return appUserService.createUser(createDto);
    }
    @PostMapping("/login")

    public ResponseEntity<?> loginUser(@RequestBody AppUserCreateDto createDto){
    if (appUserService.checkCredentials(createDto)){
        return ResponseEntity.ok(createDto);
    }else{
        return  ResponseEntity.badRequest().body("Credentiale incorecte!");
    }

    }
}
