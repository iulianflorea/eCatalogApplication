package com.org.ecatalog.service;

import com.org.ecatalog.dto.AppUserCreateDto;
import com.org.ecatalog.entity.AppUser;
import com.org.ecatalog.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AppUserService {

    private final PasswordEncoder appPasswordEncoder;

    private final AppUserRepository appUserRepository;

    public AppUser createUser(AppUserCreateDto appUserCreateDto) {
        AppUser user = new AppUser();
        user.setEmail(appUserCreateDto.getEmail());
        String encodedPass = appPasswordEncoder.encode(appUserCreateDto.getPass());
        user.setPass(encodedPass);
        return appUserRepository.save(user);

    }

    public Boolean checkCredentials(AppUserCreateDto createDto) {
        AppUser user = appUserRepository.findByEmail(createDto.getEmail());
        if(user == null) {
            return false;
        }
        return appPasswordEncoder.matches(createDto.getPass(), user.getPassword());
    }

}
