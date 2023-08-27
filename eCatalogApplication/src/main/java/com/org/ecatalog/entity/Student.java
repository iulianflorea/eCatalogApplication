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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cnp;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "school_class_id")
    private Long schoolClassId;

    @Column(name = "profile_picture")
    private  String profilePicture;

    @ManyToOne(targetEntity = SchoolClass.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_class_id", insertable = false, updatable = false)
    private SchoolClass schoolClass;


}
