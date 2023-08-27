package com.org.ecatalog.dto;

import com.org.ecatalog.entity.Subject;
import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TeacherCardDto {
    private Long id;
    private String firstName;

    private String lastName;

    private Subject subject;

    private  String profilePicture;
}
