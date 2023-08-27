package com.org.ecatalog.dto;

import com.org.ecatalog.entity.Subject;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TeacherDto {

    private Long id;
    private String firstName;

    private String lastName;

    private String cnp;

    private Subject subject;

    private Integer salary;

    private  String profilePicture;
}
