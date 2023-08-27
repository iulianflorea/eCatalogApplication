package com.org.ecatalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(unique = true)
    private String cnp;
    @Enumerated(value = EnumType.STRING)
    private Subject subject;

    private Integer salary;
    @Column(name = "profile_picture")
    private  String profilePicture;
}
