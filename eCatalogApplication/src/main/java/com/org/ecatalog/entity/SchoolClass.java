package com.org.ecatalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "school_class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_year")
    private Integer startYear;

    private String name;

    @Column(name = "class_level")
    @Enumerated(value = EnumType.STRING)
    private ClassLevel classLevel;



}
