package com.org.ecatalog.dto;

import com.org.ecatalog.entity.SchoolClass;
import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentCardDto {
    private Long id;

    private String cnp;

    private String firstName;

    private String lastName;

    private SchoolClassDto schoolClassDto;

    private  String profilePicture;
}
